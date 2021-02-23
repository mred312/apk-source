package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbov implements zzp {

    /* renamed from: a */
    private final zzbsu f13596a;

    /* renamed from: b */
    private AtomicBoolean f13597b = new AtomicBoolean(false);

    public zzbov(zzbsu zzbsu) {
        this.f13596a = zzbsu;
    }

    public final boolean isClosed() {
        return this.f13597b.get();
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public final void onUserLeaveHint() {
    }

    public final void zza(zzl zzl) {
        this.f13597b.set(true);
        this.f13596a.onAdClosed();
    }

    public final void zzux() {
        this.f13596a.onAdOpened();
    }
}
