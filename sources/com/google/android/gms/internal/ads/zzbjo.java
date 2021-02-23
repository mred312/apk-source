package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbjo implements zzdyb<zzdnj, zzdnj> {

    /* renamed from: a */
    private Map<String, zzbjn> f13355a;

    public zzbjo(Map<String, zzbjn> map) {
        this.f13355a = map;
    }

    public final /* synthetic */ zzdyz zzf(Object obj) {
        zzdnj zzdnj = (zzdnj) obj;
        for (zzdng next : zzdnj.zzhik.zzhii) {
            if (this.f13355a.containsKey(next.name)) {
                this.f13355a.get(next.name).zzm(next.zzhig);
            }
        }
        return zzdyr.zzag(zzdnj);
    }
}
