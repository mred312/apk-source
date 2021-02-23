package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;

/* renamed from: com.google.android.gms.internal.ads.q9 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2316q9 implements zzp {

    /* renamed from: a */
    private zzbdv f10695a;
    @Nullable

    /* renamed from: b */
    private zzp f10696b;

    public C2316q9(zzbdv zzbdv, @Nullable zzp zzp) {
        this.f10695a = zzbdv;
        this.f10696b = zzp;
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public final void onUserLeaveHint() {
        zzp zzp = this.f10696b;
        if (zzp != null) {
            zzp.onUserLeaveHint();
        }
    }

    public final void zza(zzl zzl) {
        zzp zzp = this.f10696b;
        if (zzp != null) {
            zzp.zza(zzl);
        }
        this.f10695a.zzacl();
    }

    public final void zzux() {
        zzp zzp = this.f10696b;
        if (zzp != null) {
            zzp.zzux();
        }
        this.f10695a.zzvj();
    }
}
