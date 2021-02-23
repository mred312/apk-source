package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Util;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* renamed from: com.bumptech.glide.load.engine.prefill.a */
/* compiled from: BitmapPreFillRunner */
final class C1263a implements Runnable {

    /* renamed from: i */
    private static final C1264a f5978i = new C1264a();

    /* renamed from: j */
    static final long f5979j = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: a */
    private final BitmapPool f5980a;

    /* renamed from: b */
    private final MemoryCache f5981b;

    /* renamed from: c */
    private final C1266b f5982c;

    /* renamed from: d */
    private final C1264a f5983d;

    /* renamed from: e */
    private final Set<PreFillType> f5984e;

    /* renamed from: f */
    private final Handler f5985f;

    /* renamed from: g */
    private long f5986g;

    /* renamed from: h */
    private boolean f5987h;

    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.prefill.a$a */
    /* compiled from: BitmapPreFillRunner */
    static class C1264a {
        C1264a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public long mo9710a() {
            return SystemClock.currentThreadTimeMillis();
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.prefill.a$b */
    /* compiled from: BitmapPreFillRunner */
    private static final class C1265b implements Key {
        C1265b() {
        }

        public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
            throw new UnsupportedOperationException();
        }
    }

    public C1263a(BitmapPool bitmapPool, MemoryCache memoryCache, C1266b bVar) {
        this(bitmapPool, memoryCache, bVar, f5978i, new Handler(Looper.getMainLooper()));
    }

    /* renamed from: c */
    private long m4438c() {
        return this.f5981b.getMaxSize() - this.f5981b.getCurrentSize();
    }

    /* renamed from: d */
    private long m4439d() {
        long j = this.f5986g;
        this.f5986g = Math.min(4 * j, f5979j);
        return j;
    }

    /* renamed from: e */
    private boolean m4440e(long j) {
        return this.f5983d.mo9710a() - j >= 32;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public boolean mo9707a() {
        Bitmap bitmap;
        long a = this.f5983d.mo9710a();
        while (!this.f5982c.mo9711a() && !m4440e(a)) {
            PreFillType b = this.f5982c.mo9712b();
            if (!this.f5984e.contains(b)) {
                this.f5984e.add(b);
                bitmap = this.f5980a.getDirty(b.mo9699d(), b.mo9697b(), b.mo9696a());
            } else {
                bitmap = Bitmap.createBitmap(b.mo9699d(), b.mo9697b(), b.mo9696a());
            }
            int bitmapByteSize = Util.getBitmapByteSize(bitmap);
            if (m4438c() >= ((long) bitmapByteSize)) {
                this.f5981b.put(new C1265b(), BitmapResource.obtain(bitmap, this.f5980a));
            } else {
                this.f5980a.put(bitmap);
            }
            if (Log.isLoggable("PreFillRunner", 3)) {
                Log.d("PreFillRunner", "allocated [" + b.mo9699d() + "x" + b.mo9697b() + "] " + b.mo9696a() + " size: " + bitmapByteSize);
            }
        }
        return !this.f5987h && !this.f5982c.mo9711a();
    }

    /* renamed from: b */
    public void mo9708b() {
        this.f5987h = true;
    }

    public void run() {
        if (mo9707a()) {
            this.f5985f.postDelayed(this, m4439d());
        }
    }

    @VisibleForTesting
    C1263a(BitmapPool bitmapPool, MemoryCache memoryCache, C1266b bVar, C1264a aVar, Handler handler) {
        this.f5984e = new HashSet();
        this.f5986g = 40;
        this.f5980a = bitmapPool;
        this.f5981b = memoryCache;
        this.f5982c = bVar;
        this.f5983d = aVar;
        this.f5985f = handler;
    }
}
