package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public class zzwp extends AdListener {

    /* renamed from: a */
    private final Object f17094a = new Object();

    /* renamed from: b */
    private AdListener f17095b;

    public void onAdClosed() {
        synchronized (this.f17094a) {
            AdListener adListener = this.f17095b;
            if (adListener != null) {
                adListener.onAdClosed();
            }
        }
    }

    public void onAdFailedToLoad(int i) {
        synchronized (this.f17094a) {
            AdListener adListener = this.f17095b;
            if (adListener != null) {
                adListener.onAdFailedToLoad(i);
            }
        }
    }

    public void onAdImpression() {
        synchronized (this.f17094a) {
            AdListener adListener = this.f17095b;
            if (adListener != null) {
                adListener.onAdImpression();
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.f17094a) {
            AdListener adListener = this.f17095b;
            if (adListener != null) {
                adListener.onAdLeftApplication();
            }
        }
    }

    public void onAdLoaded() {
        synchronized (this.f17094a) {
            AdListener adListener = this.f17095b;
            if (adListener != null) {
                adListener.onAdLoaded();
            }
        }
    }

    public void onAdOpened() {
        synchronized (this.f17094a) {
            AdListener adListener = this.f17095b;
            if (adListener != null) {
                adListener.onAdOpened();
            }
        }
    }

    public final void zza(AdListener adListener) {
        synchronized (this.f17094a) {
            this.f17095b = adListener;
        }
    }

    public void onAdFailedToLoad(LoadAdError loadAdError) {
        synchronized (this.f17094a) {
            AdListener adListener = this.f17095b;
            if (adListener != null) {
                adListener.onAdFailedToLoad(loadAdError);
            }
        }
    }
}
