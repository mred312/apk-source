package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LruBitmapPool implements BitmapPool {

    /* renamed from: k */
    private static final Bitmap.Config f5719k = Bitmap.Config.ARGB_8888;

    /* renamed from: a */
    private final C1213e f5720a;

    /* renamed from: b */
    private final Set<Bitmap.Config> f5721b;

    /* renamed from: c */
    private final long f5722c;

    /* renamed from: d */
    private final C1201a f5723d;

    /* renamed from: e */
    private long f5724e;

    /* renamed from: f */
    private long f5725f;

    /* renamed from: g */
    private int f5726g;

    /* renamed from: h */
    private int f5727h;

    /* renamed from: i */
    private int f5728i;

    /* renamed from: j */
    private int f5729j;

    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool$a */
    private interface C1201a {
        /* renamed from: a */
        void mo9526a(Bitmap bitmap);

        /* renamed from: b */
        void mo9527b(Bitmap bitmap);
    }

    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool$b */
    private static final class C1202b implements C1201a {
        C1202b() {
        }

        /* renamed from: a */
        public void mo9526a(Bitmap bitmap) {
        }

        /* renamed from: b */
        public void mo9527b(Bitmap bitmap) {
        }
    }

    LruBitmapPool(long j, C1213e eVar, Set<Bitmap.Config> set) {
        this.f5722c = j;
        this.f5724e = j;
        this.f5720a = eVar;
        this.f5721b = set;
        this.f5723d = new C1202b();
    }

    @TargetApi(26)
    /* renamed from: a */
    private static void m4264a(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    @NonNull
    /* renamed from: b */
    private static Bitmap m4265b(int i, int i2, @Nullable Bitmap.Config config) {
        if (config == null) {
            config = f5719k;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    /* renamed from: c */
    private void m4266c() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            m4267d();
        }
    }

    /* renamed from: d */
    private void m4267d() {
        Log.v("LruBitmapPool", "Hits=" + this.f5726g + ", misses=" + this.f5727h + ", puts=" + this.f5728i + ", evictions=" + this.f5729j + ", currentSize=" + this.f5725f + ", maxSize=" + this.f5724e + "\nStrategy=" + this.f5720a);
    }

    /* renamed from: e */
    private void m4268e() {
        m4274k(this.f5724e);
    }

    @TargetApi(26)
    /* renamed from: f */
    private static Set<Bitmap.Config> m4269f() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            hashSet.add((Object) null);
        }
        if (i >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* renamed from: g */
    private static C1213e m4270g() {
        if (Build.VERSION.SDK_INT >= 19) {
            return new SizeConfigStrategy();
        }
        return new C1207b();
    }

    @Nullable
    /* renamed from: h */
    private synchronized Bitmap m4271h(int i, int i2, @Nullable Bitmap.Config config) {
        Bitmap bitmap;
        m4264a(config);
        bitmap = this.f5720a.get(i, i2, config != null ? config : f5719k);
        if (bitmap == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.f5720a.logBitmap(i, i2, config));
            }
            this.f5727h++;
        } else {
            this.f5726g++;
            this.f5725f -= (long) this.f5720a.getSize(bitmap);
            this.f5723d.mo9526a(bitmap);
            m4273j(bitmap);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.f5720a.logBitmap(i, i2, config));
        }
        m4266c();
        return bitmap;
    }

    @TargetApi(19)
    /* renamed from: i */
    private static void m4272i(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    /* renamed from: j */
    private static void m4273j(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        m4272i(bitmap);
    }

    /* renamed from: k */
    private synchronized void m4274k(long j) {
        while (this.f5725f > j) {
            Bitmap removeLast = this.f5720a.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    m4267d();
                }
                this.f5725f = 0;
                return;
            }
            this.f5723d.mo9526a(removeLast);
            this.f5725f -= (long) this.f5720a.getSize(removeLast);
            this.f5729j++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Evicting bitmap=" + this.f5720a.logBitmap(removeLast));
            }
            m4266c();
            removeLast.recycle();
        }
    }

    public void clearMemory() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        m4274k(0);
    }

    @NonNull
    public Bitmap get(int i, int i2, Bitmap.Config config) {
        Bitmap h = m4271h(i, i2, config);
        if (h == null) {
            return m4265b(i, i2, config);
        }
        h.eraseColor(0);
        return h;
    }

    @NonNull
    public Bitmap getDirty(int i, int i2, Bitmap.Config config) {
        Bitmap h = m4271h(i, i2, config);
        return h == null ? m4265b(i, i2, config) : h;
    }

    public long getMaxSize() {
        return this.f5724e;
    }

    public synchronized void put(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && ((long) this.f5720a.getSize(bitmap)) <= this.f5724e) {
                        if (this.f5721b.contains(bitmap.getConfig())) {
                            int size = this.f5720a.getSize(bitmap);
                            this.f5720a.put(bitmap);
                            this.f5723d.mo9527b(bitmap);
                            this.f5728i++;
                            this.f5725f += (long) size;
                            if (Log.isLoggable("LruBitmapPool", 2)) {
                                Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f5720a.logBitmap(bitmap));
                            }
                            m4266c();
                            m4268e();
                            return;
                        }
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f5720a.logBitmap(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f5721b.contains(bitmap.getConfig()));
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new NullPointerException("Bitmap must not be null");
        }
    }

    public synchronized void setSizeMultiplier(float f) {
        this.f5724e = (long) Math.round(((float) this.f5722c) * f);
        m4268e();
    }

    @SuppressLint({"InlinedApi"})
    public void trimMemory(int i) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i);
        }
        if (i >= 40 || (Build.VERSION.SDK_INT >= 23 && i >= 20)) {
            clearMemory();
        } else if (i >= 20 || i == 15) {
            m4274k(getMaxSize() / 2);
        }
    }

    public LruBitmapPool(long j) {
        this(j, m4270g(), m4269f());
    }

    public LruBitmapPool(long j, Set<Bitmap.Config> set) {
        this(j, m4270g(), set);
    }
}
