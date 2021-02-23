package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;

/* renamed from: com.google.android.gms.internal.ads.z8 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2654z8 implements zzp {

    /* renamed from: a */
    private zzbdv f12260a;
    @Nullable

    /* renamed from: b */
    private zzp f12261b;

    public C2654z8(zzbdv zzbdv, @Nullable zzp zzp) {
        this.f12260a = zzbdv;
        this.f12261b = zzp;
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public final void onUserLeaveHint() {
        zzp zzp = this.f12261b;
        if (zzp != null) {
            zzp.onUserLeaveHint();
        }
    }

    public final void zza(zzl zzl) {
        zzp zzp = this.f12261b;
        if (zzp != null) {
            zzp.zza(zzl);
        }
        this.f12260a.zzacl();
    }

    public final void zzux() {
        zzp zzp = this.f12261b;
        if (zzp != null) {
            zzp.zzux();
        }
        this.f12260a.zzvj();
    }
}
