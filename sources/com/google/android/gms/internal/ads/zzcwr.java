package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcwr implements zzg {
    @GuardedBy("this")

    /* renamed from: a */
    private zzg f15000a;

    public final synchronized void zza(zzg zzg) {
        this.f15000a = zzg;
    }

    public final synchronized void zzh(View view) {
        zzg zzg = this.f15000a;
        if (zzg != null) {
            zzg.zzh(view);
        }
    }

    public final synchronized void zzkb() {
        zzg zzg = this.f15000a;
        if (zzg != null) {
            zzg.zzkb();
        }
    }

    public final synchronized void zzkc() {
        zzg zzg = this.f15000a;
        if (zzg != null) {
            zzg.zzkc();
        }
    }
}
