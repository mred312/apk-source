package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbpl implements zzepf<zzayf> {

    /* renamed from: a */
    private final zzeps<Clock> f13621a;

    /* renamed from: b */
    private final zzeps<zzayq> f13622b;

    /* renamed from: c */
    private final zzeps<zzdnn> f13623c;

    private zzbpl(zzeps<Clock> zzeps, zzeps<zzayq> zzeps2, zzeps<zzdnn> zzeps3) {
        this.f13621a = zzeps;
        this.f13622b = zzeps2;
        this.f13623c = zzeps3;
    }

    public static zzbpl zzg(zzeps<Clock> zzeps, zzeps<zzayq> zzeps2, zzeps<zzdnn> zzeps3) {
        return new zzbpl(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return (zzayf) zzepl.zza(this.f13622b.get().zza(this.f13621a.get(), this.f13623c.get().zzhip), "Cannot return null from a non-@Nullable @Provides method");
    }
}
