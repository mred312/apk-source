package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.doubleclick.CustomRenderedAd;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzabx implements CustomRenderedAd {

    /* renamed from: a */
    private final zzabw f12377a;

    public zzabx(zzabw zzabw) {
        this.f12377a = zzabw;
    }

    public final String getBaseUrl() {
        try {
            return this.f12377a.zzrz();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final String getContent() {
        try {
            return this.f12377a.getContent();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final void onAdRendered(View view) {
        try {
            this.f12377a.zzn(view != null ? ObjectWrapper.wrap(view) : null);
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void recordClick() {
        try {
            this.f12377a.recordClick();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void recordImpression() {
        try {
            this.f12377a.recordImpression();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }
}
