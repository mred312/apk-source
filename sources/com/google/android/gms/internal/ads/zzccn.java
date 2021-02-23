package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzccn {

    /* renamed from: a */
    zzafk f14082a;

    /* renamed from: b */
    zzafj f14083b;

    /* renamed from: c */
    zzafy f14084c;

    /* renamed from: d */
    zzafx f14085d;

    /* renamed from: e */
    zzajt f14086e;

    /* renamed from: f */
    final SimpleArrayMap<String, zzafq> f14087f = new SimpleArrayMap<>();

    /* renamed from: g */
    final SimpleArrayMap<String, zzafp> f14088g = new SimpleArrayMap<>();

    public final zzccn zza(zzafx zzafx) {
        this.f14085d = zzafx;
        return this;
    }

    public final zzccl zzany() {
        return new zzccl(this);
    }

    public final zzccn zzb(zzafk zzafk) {
        this.f14082a = zzafk;
        return this;
    }

    public final zzccn zzb(zzafj zzafj) {
        this.f14083b = zzafj;
        return this;
    }

    public final zzccn zzb(zzafy zzafy) {
        this.f14084c = zzafy;
        return this;
    }

    public final zzccn zzb(zzajt zzajt) {
        this.f14086e = zzajt;
        return this;
    }

    public final zzccn zzb(String str, zzafq zzafq, zzafp zzafp) {
        this.f14087f.put(str, zzafq);
        this.f14088g.put(str, zzafp);
        return this;
    }
}
