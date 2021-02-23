package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbrn implements zzepf<zzdnn> {

    /* renamed from: a */
    private final zzbrg f13740a;

    private zzbrn(zzbrg zzbrg) {
        this.f13740a = zzbrg;
    }

    public static zzbrn zzn(zzbrg zzbrg) {
        return new zzbrn(zzbrg);
    }

    public static zzdnn zzo(zzbrg zzbrg) {
        return (zzdnn) zzepl.zza(zzbrg.mo16419b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzo(this.f13740a);
    }
}
