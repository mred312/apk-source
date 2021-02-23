package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.ads.zzdte;
import com.google.android.gms.internal.ads.zzdti;

@ShowFirstParty
/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public final class zzdst {

    /* renamed from: a */
    private final Context f15933a;

    /* renamed from: b */
    private final Looper f15934b;

    public zzdst(@NonNull Context context, @NonNull Looper looper) {
        this.f15933a = context;
        this.f15934b = looper;
    }

    public final void zzgz(@NonNull String str) {
        new r00(this.f15933a, this.f15934b, (zzdti) ((zzekh) zzdti.zzaxl().zzhc(this.f15933a.getPackageName()).zzb(zzdti.zzb.BLOCKED_IMPRESSION).zza(zzdte.zzaxj().zzhb(str).zzb(zzdte.zza.BLOCKED_REASON_BACKGROUND)).zzbhv())).mo14706b();
    }
}
