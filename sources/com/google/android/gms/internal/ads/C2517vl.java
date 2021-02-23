package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;

/* renamed from: com.google.android.gms.internal.ads.vl */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2517vl implements zzdyo<zzdnj> {

    /* renamed from: a */
    private final /* synthetic */ zzcne f11629a;

    C2517vl(zzcne zzcne) {
        this.f11629a = zzcne;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzdnj zzdnj = (zzdnj) obj;
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwu)).booleanValue()) {
            this.f11629a.f14628f.zzea(zzdnj.zzhik.zzerj.responseCode);
            this.f11629a.f14628f.zzeq(zzdnj.zzhik.zzerj.zzgot);
        }
    }

    public final void zzb(Throwable th) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwu)).booleanValue()) {
            Matcher matcher = zzcne.f14623g.matcher(th.getMessage());
            if (matcher.matches()) {
                this.f11629a.f14628f.zzea(Integer.parseInt(matcher.group(1)));
            }
        }
    }
}
