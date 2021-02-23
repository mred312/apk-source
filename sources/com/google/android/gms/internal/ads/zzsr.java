package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzsr extends AppOpenAd {

    /* renamed from: a */
    private final zzsg f16978a;

    public zzsr(zzsg zzsg) {
        this.f16978a = zzsg;
    }

    public final ResponseInfo getResponseInfo() {
        zzyn zzyn;
        try {
            zzyn = this.f16978a.zzkh();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            zzyn = null;
        }
        return ResponseInfo.zza(zzyn);
    }

    public final void show(Activity activity, FullScreenContentCallback fullScreenContentCallback) {
        try {
            this.f16978a.zza(ObjectWrapper.wrap(activity), new zzsh(fullScreenContentCallback));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(zzsm zzsm) {
        try {
            this.f16978a.zza(zzsm);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    /* access modifiers changed from: protected */
    public final zzxg zzdx() {
        try {
            return this.f16978a.zzdx();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }
}
