package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdkp {
    /* renamed from: a */
    private static <AppOpenAdRequestComponent extends zzbre<AppOpenAd>, AppOpenAd extends zzboc> zzdkl<AppOpenAdRequestComponent, AppOpenAd> m8402a(Context context, zzdpa zzdpa, zzdpr zzdpr) {
        if (((Integer) zzwq.zzqe().zzd(zzabf.zzcxp)).intValue() <= 0) {
            return new zzdkd();
        }
        zzdpu zza = zzdpr.zza(zzdpj.AppOpen, context, zzdpa, new C2417sw(new zzdjk()));
        zzdkc zzdkc = new zzdkc(new zzdkd());
        zzdpd zzdpd = zza.zzhez;
        zzdzc zzdzc = zzazj.zzegp;
        return new zzdjp(zzdkc, new zzdju(zzdpd, zzdzc), zza.zzhmg, zzdzc);
    }

    public static zzdkl<zzblg, zzbll> zza(Context context, zzdpa zzdpa, zzdpr zzdpr) {
        return m8402a(context, zzdpa, zzdpr);
    }

    public static zzdkl<zzblp, zzblv> zzb(Context context, zzdpa zzdpa, zzdpr zzdpr) {
        return m8402a(context, zzdpa, zzdpr);
    }
}
