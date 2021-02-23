package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbnb implements zzepf<zzcqz<zzbme>> {

    /* renamed from: a */
    private final zzeps<Boolean> f13526a;

    /* renamed from: b */
    private final zzeps<zzcug> f13527b;

    /* renamed from: c */
    private final zzeps<zzcvy<zzbme, zzdoe, zzcst>> f13528c;

    public zzbnb(zzeps<Boolean> zzeps, zzeps<zzcug> zzeps2, zzeps<zzcvy<zzbme, zzdoe, zzcst>> zzeps3) {
        this.f13526a = zzeps;
        this.f13527b = zzeps2;
        this.f13528c = zzeps3;
    }

    public final /* synthetic */ Object get() {
        boolean booleanValue = this.f13526a.get().booleanValue();
        Object obj = (zzcug) this.f13527b.get();
        Object obj2 = (zzcvy) this.f13528c.get();
        if (!booleanValue) {
            obj = obj2;
        }
        return (zzcqz) zzepl.zza(obj, "Cannot return null from a non-@Nullable @Provides method");
    }
}
