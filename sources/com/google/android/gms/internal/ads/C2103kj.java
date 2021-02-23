package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.overlay.zzu;

/* renamed from: com.google.android.gms.internal.ads.kj */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2103kj implements zzp, zzu, zzagy, zzaha, zzva {

    /* renamed from: a */
    private zzva f9759a;

    /* renamed from: b */
    private zzagy f9760b;

    /* renamed from: c */
    private zzp f9761c;

    /* renamed from: d */
    private zzaha f9762d;

    /* renamed from: e */
    private zzu f9763e;

    private C2103kj() {
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final synchronized void m6425b(zzva zzva, zzagy zzagy, zzp zzp, zzaha zzaha, zzu zzu) {
        this.f9759a = zzva;
        this.f9760b = zzagy;
        this.f9761c = zzp;
        this.f9762d = zzaha;
        this.f9763e = zzu;
    }

    public final synchronized void onAdClicked() {
        zzva zzva = this.f9759a;
        if (zzva != null) {
            zzva.onAdClicked();
        }
    }

    public final synchronized void onAppEvent(String str, @Nullable String str2) {
        zzaha zzaha = this.f9762d;
        if (zzaha != null) {
            zzaha.onAppEvent(str, str2);
        }
    }

    public final synchronized void onPause() {
        zzp zzp = this.f9761c;
        if (zzp != null) {
            zzp.onPause();
        }
    }

    public final synchronized void onResume() {
        zzp zzp = this.f9761c;
        if (zzp != null) {
            zzp.onResume();
        }
    }

    public final synchronized void onUserLeaveHint() {
        zzp zzp = this.f9761c;
        if (zzp != null) {
            zzp.onUserLeaveHint();
        }
    }

    public final synchronized void zza(zzl zzl) {
        zzp zzp = this.f9761c;
        if (zzp != null) {
            zzp.zza(zzl);
        }
    }

    public final synchronized void zzux() {
        zzp zzp = this.f9761c;
        if (zzp != null) {
            zzp.zzux();
        }
    }

    public final synchronized void zzvo() {
        zzu zzu = this.f9763e;
        if (zzu != null) {
            zzu.zzvo();
        }
    }

    /* synthetic */ C2103kj(C1992hj hjVar) {
        this();
    }

    public final synchronized void zza(String str, Bundle bundle) {
        zzagy zzagy = this.f9760b;
        if (zzagy != null) {
            zzagy.zza(str, bundle);
        }
    }
}
