package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.engine.j */
/* compiled from: EngineKey */
class C1254j implements Key {

    /* renamed from: a */
    private final Object f5923a;

    /* renamed from: b */
    private final int f5924b;

    /* renamed from: c */
    private final int f5925c;

    /* renamed from: d */
    private final Class<?> f5926d;

    /* renamed from: e */
    private final Class<?> f5927e;

    /* renamed from: f */
    private final Key f5928f;

    /* renamed from: g */
    private final Map<Class<?>, Transformation<?>> f5929g;

    /* renamed from: h */
    private final Options f5930h;

    /* renamed from: i */
    private int f5931i;

    C1254j(Object obj, Key key, int i, int i2, Map<Class<?>, Transformation<?>> map, Class<?> cls, Class<?> cls2, Options options) {
        this.f5923a = Preconditions.checkNotNull(obj);
        this.f5928f = (Key) Preconditions.checkNotNull(key, "Signature must not be null");
        this.f5924b = i;
        this.f5925c = i2;
        this.f5929g = (Map) Preconditions.checkNotNull(map);
        this.f5926d = (Class) Preconditions.checkNotNull(cls, "Resource class must not be null");
        this.f5927e = (Class) Preconditions.checkNotNull(cls2, "Transcode class must not be null");
        this.f5930h = (Options) Preconditions.checkNotNull(options);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1254j)) {
            return false;
        }
        C1254j jVar = (C1254j) obj;
        if (!this.f5923a.equals(jVar.f5923a) || !this.f5928f.equals(jVar.f5928f) || this.f5925c != jVar.f5925c || this.f5924b != jVar.f5924b || !this.f5929g.equals(jVar.f5929g) || !this.f5926d.equals(jVar.f5926d) || !this.f5927e.equals(jVar.f5927e) || !this.f5930h.equals(jVar.f5930h)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.f5931i == 0) {
            int hashCode = this.f5923a.hashCode();
            this.f5931i = hashCode;
            int hashCode2 = (hashCode * 31) + this.f5928f.hashCode();
            this.f5931i = hashCode2;
            int i = (hashCode2 * 31) + this.f5924b;
            this.f5931i = i;
            int i2 = (i * 31) + this.f5925c;
            this.f5931i = i2;
            int hashCode3 = (i2 * 31) + this.f5929g.hashCode();
            this.f5931i = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.f5926d.hashCode();
            this.f5931i = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f5927e.hashCode();
            this.f5931i = hashCode5;
            this.f5931i = (hashCode5 * 31) + this.f5930h.hashCode();
        }
        return this.f5931i;
    }

    public String toString() {
        return "EngineKey{model=" + this.f5923a + ", width=" + this.f5924b + ", height=" + this.f5925c + ", resourceClass=" + this.f5926d + ", transcodeClass=" + this.f5927e + ", signature=" + this.f5928f + ", hashCode=" + this.f5931i + ", transformations=" + this.f5929g + ", options=" + this.f5930h + '}';
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
