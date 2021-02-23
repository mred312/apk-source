package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzef;
import com.google.android.gms.internal.ads.zzeg;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class zzo implements Callable<zzef> {
    private final /* synthetic */ zzj zzbpl;

    zzo(zzj zzj) {
        this.zzbpl = zzj;
    }

    public final /* synthetic */ Object call() {
        return new zzef(zzeg.zzb(this.zzbpl.zzbpd.zzbrf, this.zzbpl.context, false));
    }
}
