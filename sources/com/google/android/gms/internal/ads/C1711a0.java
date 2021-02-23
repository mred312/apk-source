package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.PublisherAdView;

/* renamed from: com.google.android.gms.internal.ads.a0 */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class C1711a0 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ PublisherAdView f7771a;

    /* renamed from: b */
    private final /* synthetic */ zzxg f7772b;

    /* renamed from: c */
    private final /* synthetic */ zzagv f7773c;

    C1711a0(zzagv zzagv, PublisherAdView publisherAdView, zzxg zzxg) {
        this.f7773c = zzagv;
        this.f7771a = publisherAdView;
        this.f7772b = zzxg;
    }

    public final void run() {
        if (this.f7771a.zza(this.f7772b)) {
            this.f7773c.f12458a.onPublisherAdViewLoaded(this.f7771a);
        } else {
            zzaza.zzfa("Could not bind.");
        }
    }
}
