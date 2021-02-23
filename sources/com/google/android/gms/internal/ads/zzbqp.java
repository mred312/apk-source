package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbqp implements zzepf<zzbxy<zzbui>> {

    /* renamed from: a */
    private final zzeps<zzbqo> f13684a;

    private zzbqp(zzbqq zzbqq, zzeps<zzbqo> zzeps) {
        this.f13684a = zzeps;
    }

    public static zzbqp zza(zzbqq zzbqq, zzeps<zzbqo> zzeps) {
        return new zzbqp(zzbqq, zzeps);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.f13684a.get(), zzazj.zzegu), "Cannot return null from a non-@Nullable @Provides method");
    }
}
