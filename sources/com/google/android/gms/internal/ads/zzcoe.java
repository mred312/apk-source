package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcoe implements zzepf<C2032im> {

    /* renamed from: a */
    private final zzeps<Context> f14651a;

    /* renamed from: b */
    private final zzeps<zzawx> f14652b;

    private zzcoe(zzeps<Context> zzeps, zzeps<zzawx> zzeps2) {
        this.f14651a = zzeps;
        this.f14652b = zzeps2;
    }

    public static zzcoe zzat(zzeps<Context> zzeps, zzeps<zzawx> zzeps2) {
        return new zzcoe(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new C2032im(this.f14651a.get(), this.f14652b.get());
    }
}
