package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbkf implements zzepf<zzbkg> {

    /* renamed from: a */
    private final zzeps<Context> f13396a;

    /* renamed from: b */
    private final zzeps<zzqr> f13397b;

    private zzbkf(zzeps<Context> zzeps, zzeps<zzqr> zzeps2) {
        this.f13396a = zzeps;
        this.f13397b = zzeps2;
    }

    public static zzbkf zza(zzeps<Context> zzeps, zzeps<zzqr> zzeps2) {
        return new zzbkf(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzbkg(this.f13396a.get(), this.f13397b.get());
    }
}
