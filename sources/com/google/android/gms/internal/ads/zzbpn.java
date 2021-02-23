package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbpn implements zzepf<zzbpo> {

    /* renamed from: a */
    private final zzeps<Clock> f13624a;

    /* renamed from: b */
    private final zzeps<zzayf> f13625b;

    private zzbpn(zzeps<Clock> zzeps, zzeps<zzayf> zzeps2) {
        this.f13624a = zzeps;
        this.f13625b = zzeps2;
    }

    public static zzbpn zzd(zzeps<Clock> zzeps, zzeps<zzayf> zzeps2) {
        return new zzbpn(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzbpo(this.f13624a.get(), this.f13625b.get());
    }
}
