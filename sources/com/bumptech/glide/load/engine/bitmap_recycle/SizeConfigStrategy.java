package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

@RequiresApi(19)
public class SizeConfigStrategy implements C1213e {

    /* renamed from: d */
    private static final Bitmap.Config[] f5730d;

    /* renamed from: e */
    private static final Bitmap.Config[] f5731e;

    /* renamed from: f */
    private static final Bitmap.Config[] f5732f = {Bitmap.Config.RGB_565};

    /* renamed from: g */
    private static final Bitmap.Config[] f5733g = {Bitmap.Config.ARGB_4444};

    /* renamed from: h */
    private static final Bitmap.Config[] f5734h = {Bitmap.Config.ALPHA_8};

    /* renamed from: a */
    private final C1205c f5735a = new C1205c();

    /* renamed from: b */
    private final C1211d<C1204b, Bitmap> f5736b = new C1211d<>();

    /* renamed from: c */
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f5737c = new HashMap();

    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy$a */
    static /* synthetic */ class C1203a {

        /* renamed from: a */
        static final /* synthetic */ int[] f5738a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                android.graphics.Bitmap$Config[] r0 = android.graphics.Bitmap.Config.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5738a = r0
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f5738a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5738a     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_4444     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f5738a     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ALPHA_8     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy.C1203a.<clinit>():void");
        }
    }

    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy$b */
    static final class C1204b implements C1214f {

        /* renamed from: a */
        private final C1205c f5739a;

        /* renamed from: b */
        int f5740b;

        /* renamed from: c */
        private Bitmap.Config f5741c;

        public C1204b(C1205c cVar) {
            this.f5739a = cVar;
        }

        /* renamed from: a */
        public void mo9518a() {
            this.f5739a.mo9549c(this);
        }

        /* renamed from: b */
        public void mo9535b(int i, Bitmap.Config config) {
            this.f5740b = i;
            this.f5741c = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1204b)) {
                return false;
            }
            C1204b bVar = (C1204b) obj;
            if (this.f5740b != bVar.f5740b || !Util.bothNullOrEqual(this.f5741c, bVar.f5741c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = this.f5740b * 31;
            Bitmap.Config config = this.f5741c;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return SizeConfigStrategy.m4281c(this.f5740b, this.f5741c);
        }
    }

    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy$c */
    static class C1205c extends C1210c<C1204b> {
        C1205c() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public C1204b mo9523a() {
            return new C1204b(this);
        }

        /* renamed from: e */
        public C1204b mo9540e(int i, Bitmap.Config config) {
            C1204b bVar = (C1204b) mo9548b();
            bVar.mo9535b(i, config);
            return bVar;
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f5730d = configArr;
        f5731e = configArr;
    }

    /* renamed from: a */
    private void m4279a(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> e = m4283e(bitmap.getConfig());
        Integer num2 = (Integer) e.get(num);
        if (num2 == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + logBitmap(bitmap) + ", this: " + this);
        } else if (num2.intValue() == 1) {
            e.remove(num);
        } else {
            e.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    /* renamed from: b */
    private C1204b m4280b(int i, Bitmap.Config config) {
        C1204b e = this.f5735a.mo9540e(i, config);
        Bitmap.Config[] d = m4282d(config);
        int length = d.length;
        int i2 = 0;
        while (i2 < length) {
            Bitmap.Config config2 = d[i2];
            Integer ceilingKey = m4283e(config2).ceilingKey(Integer.valueOf(i));
            if (ceilingKey == null || ceilingKey.intValue() > i * 8) {
                i2++;
            } else {
                if (ceilingKey.intValue() == i) {
                    if (config2 == null) {
                        if (config == null) {
                            return e;
                        }
                    } else if (config2.equals(config)) {
                        return e;
                    }
                }
                this.f5735a.mo9549c(e);
                return this.f5735a.mo9540e(ceilingKey.intValue(), config2);
            }
        }
        return e;
    }

    /* renamed from: c */
    static String m4281c(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    /* renamed from: d */
    private static Bitmap.Config[] m4282d(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return f5731e;
        }
        int i = C1203a.f5738a[config.ordinal()];
        if (i == 1) {
            return f5730d;
        }
        if (i == 2) {
            return f5732f;
        }
        if (i == 3) {
            return f5733g;
        }
        if (i == 4) {
            return f5734h;
        }
        return new Bitmap.Config[]{config};
    }

    /* renamed from: e */
    private NavigableMap<Integer, Integer> m4283e(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f5737c.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f5737c.put(config, treeMap);
        return treeMap;
    }

    @Nullable
    public Bitmap get(int i, int i2, Bitmap.Config config) {
        C1204b b = m4280b(Util.getBitmapByteSize(i, i2, config), config);
        Bitmap a = this.f5736b.mo9550a(b);
        if (a != null) {
            m4279a(Integer.valueOf(b.f5740b), a);
            a.reconfigure(i, i2, config);
        }
        return a;
    }

    public int getSize(Bitmap bitmap) {
        return Util.getBitmapByteSize(bitmap);
    }

    public String logBitmap(Bitmap bitmap) {
        return m4281c(Util.getBitmapByteSize(bitmap), bitmap.getConfig());
    }

    public void put(Bitmap bitmap) {
        C1204b e = this.f5735a.mo9540e(Util.getBitmapByteSize(bitmap), bitmap.getConfig());
        this.f5736b.mo9551d(e, bitmap);
        NavigableMap<Integer, Integer> e2 = m4283e(bitmap.getConfig());
        Integer num = (Integer) e2.get(Integer.valueOf(e.f5740b));
        Integer valueOf = Integer.valueOf(e.f5740b);
        int i = 1;
        if (num != null) {
            i = 1 + num.intValue();
        }
        e2.put(valueOf, Integer.valueOf(i));
    }

    @Nullable
    public Bitmap removeLast() {
        Bitmap f = this.f5736b.mo9552f();
        if (f != null) {
            m4279a(Integer.valueOf(Util.getBitmapByteSize(f)), f);
        }
        return f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f5736b);
        sb.append(", sortedSizes=(");
        for (Map.Entry next : this.f5737c.entrySet()) {
            sb.append(next.getKey());
            sb.append('[');
            sb.append(next.getValue());
            sb.append("], ");
        }
        if (!this.f5737c.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }

    public String logBitmap(int i, int i2, Bitmap.Config config) {
        return m4281c(Util.getBitmapByteSize(i, i2, config), config);
    }
}
