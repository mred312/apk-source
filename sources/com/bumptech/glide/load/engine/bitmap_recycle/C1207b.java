package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Util;

/* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.b */
/* compiled from: AttributeStrategy */
class C1207b implements C1213e {

    /* renamed from: a */
    private final C1209b f5742a = new C1209b();

    /* renamed from: b */
    private final C1211d<C1208a, Bitmap> f5743b = new C1211d<>();

    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.b$a */
    /* compiled from: AttributeStrategy */
    static class C1208a implements C1214f {

        /* renamed from: a */
        private final C1209b f5744a;

        /* renamed from: b */
        private int f5745b;

        /* renamed from: c */
        private int f5746c;

        /* renamed from: d */
        private Bitmap.Config f5747d;

        public C1208a(C1209b bVar) {
            this.f5744a = bVar;
        }

        /* renamed from: a */
        public void mo9518a() {
            this.f5744a.mo9549c(this);
        }

        /* renamed from: b */
        public void mo9542b(int i, int i2, Bitmap.Config config) {
            this.f5745b = i;
            this.f5746c = i2;
            this.f5747d = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1208a)) {
                return false;
            }
            C1208a aVar = (C1208a) obj;
            if (this.f5745b == aVar.f5745b && this.f5746c == aVar.f5746c && this.f5747d == aVar.f5747d) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = ((this.f5745b * 31) + this.f5746c) * 31;
            Bitmap.Config config = this.f5747d;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return C1207b.m4289a(this.f5745b, this.f5746c, this.f5747d);
        }
    }

    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.b$b */
    /* compiled from: AttributeStrategy */
    static class C1209b extends C1210c<C1208a> {
        C1209b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public C1208a mo9523a() {
            return new C1208a(this);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public C1208a mo9547e(int i, int i2, Bitmap.Config config) {
            C1208a aVar = (C1208a) mo9548b();
            aVar.mo9542b(i, i2, config);
            return aVar;
        }
    }

    C1207b() {
    }

    /* renamed from: a */
    static String m4289a(int i, int i2, Bitmap.Config config) {
        return "[" + i + "x" + i2 + "], " + config;
    }

    /* renamed from: b */
    private static String m4290b(Bitmap bitmap) {
        return m4289a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    public Bitmap get(int i, int i2, Bitmap.Config config) {
        return this.f5743b.mo9550a(this.f5742a.mo9547e(i, i2, config));
    }

    public int getSize(Bitmap bitmap) {
        return Util.getBitmapByteSize(bitmap);
    }

    public String logBitmap(Bitmap bitmap) {
        return m4290b(bitmap);
    }

    public void put(Bitmap bitmap) {
        this.f5743b.mo9551d(this.f5742a.mo9547e(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    public Bitmap removeLast() {
        return this.f5743b.mo9552f();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f5743b;
    }

    public String logBitmap(int i, int i2, Bitmap.Config config) {
        return m4289a(i, i2, config);
    }
}
