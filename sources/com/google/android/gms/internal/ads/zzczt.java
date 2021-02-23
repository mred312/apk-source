package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzczt implements zzepf<zzdyz<zzczx>> {

    /* renamed from: a */
    private final zzeps<zzdro> f15103a;

    /* renamed from: b */
    private final zzeps<zzczs> f15104b;

    /* renamed from: c */
    private final zzeps<zzbqz> f15105c;

    public zzczt(zzeps<zzdro> zzeps, zzeps<zzczs> zzeps2, zzeps<zzbqz> zzeps3) {
        this.f15103a = zzeps;
        this.f15104b = zzeps2;
        this.f15105c = zzeps3;
    }

    public final /* synthetic */ Object get() {
        return (zzdyz) zzepl.zza(this.f15103a.get().zza(zzdrl.GENERATE_SIGNALS, this.f15105c.get().zzakr()).zza(this.f15104b.get()).zza((long) ((Integer) zzwq.zzqe().zzd(zzabf.zzcvj)).intValue(), TimeUnit.SECONDS).zzaww(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
