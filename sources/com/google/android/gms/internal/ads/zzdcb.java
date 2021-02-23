package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdcb implements zzdfi<zzdby> {

    /* renamed from: a */
    private final zzdzc f15401a;

    /* renamed from: b */
    private final zzcis f15402b;

    /* renamed from: c */
    private final String f15403c;

    /* renamed from: d */
    private final zzdnn f15404d;

    public zzdcb(zzdzc zzdzc, zzcis zzcis, zzdnn zzdnn, String str) {
        this.f15401a = zzdzc;
        this.f15402b = zzcis;
        this.f15404d = zzdnn;
        this.f15403c = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzdby mo17079a() {
        JSONObject zzq;
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcss)).booleanValue() && (zzq = this.f15402b.zzq(this.f15404d.zzhip, this.f15403c)) != null) {
            return new zzdby(zzq.toString());
        }
        return null;
    }

    public final zzdyz<zzdby> zzasm() {
        return this.f15401a.zze(new C1928ft(this));
    }
}
