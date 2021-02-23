package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdgz implements zzdfi<zzdgw> {

    /* renamed from: a */
    private zzaxy f15610a;

    /* renamed from: b */
    private zzdzc f15611b;

    /* renamed from: c */
    private String f15612c;

    public zzdgz(zzaxy zzaxy, zzdzc zzdzc, String str) {
        this.f15610a = zzaxy;
        this.f15611b = zzdzc;
        this.f15612c = str;
    }

    public final zzdyz<zzdgw> zzasm() {
        new zzazq();
        zzdyz<String> zzag = zzdyr.zzag(null);
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcvx)).booleanValue()) {
            zzag = this.f15610a.zzec(this.f15612c);
        }
        zzdyz<String> zzed = this.f15610a.zzed(this.f15612c);
        return zzdyr.zzb((zzdyz<? extends V>[]) new zzdyz[]{zzag, zzed}).zza(new C1893ev(zzag, zzed), zzazj.zzegp);
    }
}
