package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzagv extends zzafw {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final OnPublisherAdViewLoadedListener f12458a;

    public zzagv(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener) {
        this.f12458a = onPublisherAdViewLoadedListener;
    }

    public final void zza(zzxg zzxg, IObjectWrapper iObjectWrapper) {
        if (zzxg != null && iObjectWrapper != null) {
            PublisherAdView publisherAdView = new PublisherAdView((Context) ObjectWrapper.unwrap(iObjectWrapper));
            AppEventListener appEventListener = null;
            try {
                if (zzxg.zzkj() instanceof zzvg) {
                    zzvg zzvg = (zzvg) zzxg.zzkj();
                    publisherAdView.setAdListener(zzvg != null ? zzvg.getAdListener() : null);
                }
            } catch (RemoteException e) {
                zzaza.zzc("", e);
            }
            try {
                if (zzxg.zzki() instanceof zzvt) {
                    zzvt zzvt = (zzvt) zzxg.zzki();
                    if (zzvt != null) {
                        appEventListener = zzvt.getAppEventListener();
                    }
                    publisherAdView.setAppEventListener(appEventListener);
                }
            } catch (RemoteException e2) {
                zzaza.zzc("", e2);
            }
            zzayr.zzzz.post(new C1711a0(this, publisherAdView, zzxg));
        }
    }
}
