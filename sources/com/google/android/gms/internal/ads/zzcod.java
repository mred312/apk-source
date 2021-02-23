package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcod implements zzcoi {

    /* renamed from: a */
    private final Map<String, zzeps<zzcoi>> f14648a;

    /* renamed from: b */
    private final zzdzc f14649b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final zzbuh f14650c;

    public zzcod(Map<String, zzeps<zzcoi>> map, zzdzc zzdzc, zzbuh zzbuh) {
        this.f14648a = map;
        this.f14649b = zzdzc;
        this.f14650c = zzbuh;
    }

    public final zzdyz<zzdnj> zzh(zzatl zzatl) {
        this.f14650c.zzd(zzatl);
        zzdyz<zzdnj> immediateFailedFuture = zzdyr.immediateFailedFuture(new zzcme(zzdok.NO_FILL));
        for (String trim : ((String) zzwq.zzqe().zzd(zzabf.zzcyv)).split(",")) {
            zzeps zzeps = this.f14648a.get(trim.trim());
            if (zzeps != null) {
                immediateFailedFuture = zzdyr.zzb(immediateFailedFuture, zzcme.class, new C2143lm(zzeps, zzatl), this.f14649b);
            }
        }
        zzdyr.zza(immediateFailedFuture, new C2106km(this), zzazj.zzegu);
        return immediateFailedFuture;
    }
}
