package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbtr extends zzbwk<zzp> implements zzp {
    public zzbtr(Set<zzbxy<zzp>> set) {
        super(set);
    }

    public final synchronized void onPause() {
        zza(C1728ae.f7806a);
    }

    public final synchronized void onResume() {
        zza(C1839de.f8250a);
    }

    public final synchronized void onUserLeaveHint() {
        zza(C1765be.f7911a);
    }

    public final synchronized void zza(zzl zzl) {
        zza(new C2659zd(zzl));
    }

    public final synchronized void zzux() {
        zza(C1802ce.f7990a);
    }
}
