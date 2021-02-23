package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.appopen.AppOpenAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzsv {

    /* renamed from: a */
    private zzxg f16979a;

    /* renamed from: b */
    private final Context f16980b;

    /* renamed from: c */
    private final String f16981c;

    /* renamed from: d */
    private final zzza f16982d;
    @AppOpenAd.AppOpenAdOrientation

    /* renamed from: e */
    private final int f16983e;

    /* renamed from: f */
    private final AppOpenAd.AppOpenAdLoadCallback f16984f;

    /* renamed from: g */
    private final zzanj f16985g = new zzanj();

    public zzsv(Context context, String str, zzza zzza, @AppOpenAd.AppOpenAdOrientation int i, AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.f16980b = context;
        this.f16981c = str;
        this.f16982d = zzza;
        this.f16983e = i;
        this.f16984f = appOpenAdLoadCallback;
        zzvl zzvl = zzvl.zzcho;
    }

    public final void zzmt() {
        try {
            this.f16979a = zzwq.zzqb().zza(this.f16980b, zzvn.zzpq(), this.f16981c, this.f16985g);
            this.f16979a.zza(new zzvw(this.f16983e));
            this.f16979a.zza((zzsl) new zzsf(this.f16984f));
            this.f16979a.zza(zzvl.zza(this.f16980b, this.f16982d));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }
}
