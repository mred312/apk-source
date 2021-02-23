package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;

/* renamed from: com.google.android.gms.internal.ads.zl */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2667zl implements zzdyo<zzdnj> {

    /* renamed from: a */
    private final /* synthetic */ zzcnh f12310a;

    C2667zl(zzcnh zzcnh) {
        this.f12310a = zzcnh;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzdnj zzdnj = (zzdnj) obj;
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwu)).booleanValue()) {
            this.f12310a.f14634e.zzea(zzdnj.zzhik.zzerj.responseCode);
            this.f12310a.f14634e.zzeq(zzdnj.zzhik.zzerj.zzgot);
        }
    }

    public final void zzb(Throwable th) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwu)).booleanValue()) {
            Matcher matcher = zzcnh.f14629f.matcher(th.getMessage());
            if (matcher.matches()) {
                this.f12310a.f14634e.zzea(Integer.parseInt(matcher.group(1)));
            }
        }
    }
}
