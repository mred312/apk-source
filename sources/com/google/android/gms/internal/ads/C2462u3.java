package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;

/* renamed from: com.google.android.gms.internal.ads.u3 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2462u3 implements zzp {

    /* renamed from: a */
    private final /* synthetic */ zzaqe f11244a;

    C2462u3(zzaqe zzaqe) {
        this.f11244a = zzaqe;
    }

    public final void onPause() {
        zzaza.zzeb("AdMobCustomTabsAdapter overlay is paused.");
    }

    public final void onResume() {
        zzaza.zzeb("AdMobCustomTabsAdapter overlay is resumed.");
    }

    public final void onUserLeaveHint() {
    }

    public final void zza(zzl zzl) {
        zzaza.zzeb("AdMobCustomTabsAdapter overlay is closed.");
        this.f11244a.f12605b.onAdClosed(this.f11244a);
    }

    public final void zzux() {
        zzaza.zzeb("Opening AdMobCustomTabsAdapter overlay.");
        this.f11244a.f12605b.onAdOpened(this.f11244a);
    }
}
