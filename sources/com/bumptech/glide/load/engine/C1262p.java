package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.engine.p */
/* compiled from: ResourceCacheKey */
final class C1262p implements Key {

    /* renamed from: i */
    private static final LruCache<Class<?>, byte[]> f5956i = new LruCache<>(50);

    /* renamed from: a */
    private final ArrayPool f5957a;

    /* renamed from: b */
    private final Key f5958b;

    /* renamed from: c */
    private final Key f5959c;

    /* renamed from: d */
    private final int f5960d;

    /* renamed from: e */
    private final int f5961e;

    /* renamed from: f */
    private final Class<?> f5962f;

    /* renamed from: g */
    private final Options f5963g;

    /* renamed from: h */
    private final Transformation<?> f5964h;

    C1262p(ArrayPool arrayPool, Key key, Key key2, int i, int i2, Transformation<?> transformation, Class<?> cls, Options options) {
        this.f5957a = arrayPool;
        this.f5958b = key;
        this.f5959c = key2;
        this.f5960d = i;
        this.f5961e = i2;
        this.f5964h = transformation;
        this.f5962f = cls;
        this.f5963g = options;
    }

    /* renamed from: a */
    private byte[] m4429a() {
        LruCache<Class<?>, byte[]> lruCache = f5956i;
        byte[] bArr = lruCache.get(this.f5962f);
        if (bArr != null) {
            return bArr;
        }
        byte[] bytes = this.f5962f.getName().getBytes(Key.CHARSET);
        lruCache.put(this.f5962f, bytes);
        return bytes;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1262p)) {
            return false;
        }
        C1262p pVar = (C1262p) obj;
        if (this.f5961e != pVar.f5961e || this.f5960d != pVar.f5960d || !Util.bothNullOrEqual(this.f5964h, pVar.f5964h) || !this.f5962f.equals(pVar.f5962f) || !this.f5958b.equals(pVar.f5958b) || !this.f5959c.equals(pVar.f5959c) || !this.f5963g.equals(pVar.f5963g)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (((((this.f5958b.hashCode() * 31) + this.f5959c.hashCode()) * 31) + this.f5960d) * 31) + this.f5961e;
        Transformation<?> transformation = this.f5964h;
        if (transformation != null) {
            hashCode = (hashCode * 31) + transformation.hashCode();
        }
        return (((hashCode * 31) + this.f5962f.hashCode()) * 31) + this.f5963g.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f5958b + ", signature=" + this.f5959c + ", width=" + this.f5960d + ", height=" + this.f5961e + ", decodedResourceClass=" + this.f5962f + ", transformation='" + this.f5964h + '\'' + ", options=" + this.f5963g + '}';
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f5957a.getExact(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f5960d).putInt(this.f5961e).array();
        this.f5959c.updateDiskCacheKey(messageDigest);
        this.f5958b.updateDiskCacheKey(messageDigest);
        messageDigest.update(bArr);
        Transformation<?> transformation = this.f5964h;
        if (transformation != null) {
            transformation.updateDiskCacheKey(messageDigest);
        }
        this.f5963g.updateDiskCacheKey(messageDigest);
        messageDigest.update(m4429a());
        this.f5957a.put(bArr);
    }
}
