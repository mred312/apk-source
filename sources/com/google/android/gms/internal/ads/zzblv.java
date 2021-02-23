package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzblv extends zzboc {
    @Nullable

    /* renamed from: f */
    private final zzbdv f13472f;

    /* renamed from: g */
    private final int f13473g;

    /* renamed from: h */
    private final zzble f13474h;

    /* renamed from: i */
    private final zzcaf f13475i;

    /* renamed from: j */
    private boolean f13476j = false;

    zzblv(zzbob zzbob, @Nullable zzbdv zzbdv, int i, zzble zzble, zzcaf zzcaf) {
        super(zzbob);
        this.f13472f = zzbdv;
        this.f13473g = i;
        this.f13474h = zzble;
        this.f13475i = zzcaf;
    }

    public final void destroy() {
        super.destroy();
        zzbdv zzbdv = this.f13472f;
        if (zzbdv != null) {
            zzbdv.destroy();
        }
    }

    public final void zza(zzsc zzsc) {
        zzbdv zzbdv = this.f13472f;
        if (zzbdv != null) {
            zzbdv.zza(zzsc);
        }
    }

    public final int zzaip() {
        return this.f13473g;
    }

    public final void zzb(long j, int i) {
        this.f13474h.zzb(j, i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x006d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x006e A[SYNTHETIC, Splitter:B:16:0x006e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(android.app.Activity r6, com.google.android.gms.internal.ads.zzsq r7) {
        /*
            r5 = this;
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcnz
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x005b
            com.google.android.gms.ads.internal.zzp.zzkq()
            boolean r0 = com.google.android.gms.ads.internal.util.zzm.zzas(r6)
            if (r0 == 0) goto L_0x005b
            java.lang.String r0 = "Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies"
            com.google.android.gms.internal.ads.zzaza.zzfa(r0)
            com.google.android.gms.internal.ads.zzdok r0 = com.google.android.gms.internal.ads.zzdok.APP_NOT_FOREGROUND
            r3 = 0
            com.google.android.gms.internal.ads.zzve r0 = com.google.android.gms.internal.ads.zzdoi.zza(r0, r3, r3)
            r7.zzb(r0)
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcoa
            com.google.android.gms.internal.ads.zzabb r3 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r0 = r3.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x006a
            com.google.android.gms.internal.ads.zzdst r0 = new com.google.android.gms.internal.ads.zzdst
            android.content.Context r3 = r6.getApplicationContext()
            com.google.android.gms.ads.internal.util.zzbo r4 = com.google.android.gms.ads.internal.zzp.zzle()
            android.os.Looper r4 = r4.zzyw()
            r0.<init>(r3, r4)
            com.google.android.gms.internal.ads.zzdnj r3 = r5.zzfpr
            com.google.android.gms.internal.ads.zzdnh r3 = r3.zzhik
            com.google.android.gms.internal.ads.zzdmz r3 = r3.zzerj
            java.lang.String r3 = r3.zzbvf
            r0.zzgz(r3)
            goto L_0x006a
        L_0x005b:
            boolean r0 = r5.f13476j
            if (r0 == 0) goto L_0x0064
            java.lang.String r0 = "App open interstitial ad is already visible."
            com.google.android.gms.internal.ads.zzaza.zzfa(r0)
        L_0x0064:
            boolean r0 = r5.f13476j
            if (r0 != 0) goto L_0x006a
            r0 = 1
            goto L_0x006b
        L_0x006a:
            r0 = 0
        L_0x006b:
            if (r0 != 0) goto L_0x006e
            return
        L_0x006e:
            com.google.android.gms.internal.ads.zzcaf r0 = r5.f13475i     // Catch:{ zzcai -> 0x0076 }
            r0.zza(r2, r6)     // Catch:{ zzcai -> 0x0076 }
            r5.f13476j = r1
            return
        L_0x0076:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzve r6 = com.google.android.gms.internal.ads.zzdoi.zzh(r6)
            r7.zzb(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzblv.zza(android.app.Activity, com.google.android.gms.internal.ads.zzsq):void");
    }
}
