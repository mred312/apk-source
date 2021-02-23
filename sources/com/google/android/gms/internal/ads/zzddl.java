package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzddl implements zzepf<zzddj> {

    /* renamed from: a */
    private final zzeps<zzdzc> f15452a;

    /* renamed from: b */
    private final zzeps<zzdms> f15453b;

    private zzddl(zzeps<zzdzc> zzeps, zzeps<zzdms> zzeps2) {
        this.f15452a = zzeps;
        this.f15453b = zzeps2;
    }

    public static zzddl zzbd(zzeps<zzdzc> zzeps, zzeps<zzdms> zzeps2) {
        return new zzddl(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzddj(this.f15452a.get(), this.f15453b.get());
    }
}
