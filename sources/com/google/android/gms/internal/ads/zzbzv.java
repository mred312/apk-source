package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbzv implements zzp {

    /* renamed from: a */
    private final zzbtr f13890a;

    /* renamed from: b */
    private final zzbxu f13891b;

    public zzbzv(zzbtr zzbtr, zzbxu zzbxu) {
        this.f13890a = zzbtr;
        this.f13891b = zzbxu;
    }

    public final void onPause() {
        this.f13890a.onPause();
    }

    public final void onResume() {
        this.f13890a.onResume();
    }

    public final void onUserLeaveHint() {
        this.f13890a.onUserLeaveHint();
    }

    public final void zza(zzl zzl) {
        this.f13890a.zza(zzl);
        this.f13891b.onHide();
    }

    public final void zzux() {
        this.f13890a.zzux();
        this.f13891b.zzalv();
    }
}
