package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzari;
import com.google.android.gms.internal.ads.zzva;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzv extends zzari {
    private Activity zzaap;
    private boolean zzdqo = false;
    private AdOverlayInfoParcel zzdrw;
    private boolean zzdrx = false;

    public zzv(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzdrw = adOverlayInfoParcel;
        this.zzaap = activity;
    }

    private final synchronized void zzvp() {
        if (!this.zzdrx) {
            zzp zzp = this.zzdrw.zzdrm;
            if (zzp != null) {
                zzp.zza(zzl.OTHER);
            }
            this.zzdrx = true;
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void onBackPressed() {
    }

    public final void onCreate(Bundle bundle) {
        zzp zzp;
        boolean z = false;
        if (bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
            z = true;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdrw;
        if (adOverlayInfoParcel == null) {
            this.zzaap.finish();
        } else if (z) {
            this.zzaap.finish();
        } else {
            if (bundle == null) {
                zzva zzva = adOverlayInfoParcel.zzcgp;
                if (zzva != null) {
                    zzva.onAdClicked();
                }
                if (!(this.zzaap.getIntent() == null || !this.zzaap.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) || (zzp = this.zzdrw.zzdrm) == null)) {
                    zzp.zzux();
                }
            }
            zzp.zzko();
            Activity activity = this.zzaap;
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzdrw;
            if (!zza.zza((Context) activity, adOverlayInfoParcel2.zzdrl, adOverlayInfoParcel2.zzdrq)) {
                this.zzaap.finish();
            }
        }
    }

    public final void onDestroy() {
        if (this.zzaap.isFinishing()) {
            zzvp();
        }
    }

    public final void onPause() {
        zzp zzp = this.zzdrw.zzdrm;
        if (zzp != null) {
            zzp.onPause();
        }
        if (this.zzaap.isFinishing()) {
            zzvp();
        }
    }

    public final void onRestart() {
    }

    public final void onResume() {
        if (this.zzdqo) {
            this.zzaap.finish();
            return;
        }
        this.zzdqo = true;
        zzp zzp = this.zzdrw.zzdrm;
        if (zzp != null) {
            zzp.onResume();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzdqo);
    }

    public final void onStart() {
    }

    public final void onStop() {
        if (this.zzaap.isFinishing()) {
            zzvp();
        }
    }

    public final void onUserLeaveHint() {
        zzp zzp = this.zzdrw.zzdrm;
        if (zzp != null) {
            zzp.onUserLeaveHint();
        }
    }

    public final void zzad(IObjectWrapper iObjectWrapper) {
    }

    public final void zzdp() {
    }

    public final boolean zzve() {
        return false;
    }
}
