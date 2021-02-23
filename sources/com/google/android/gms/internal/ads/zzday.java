package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzday implements zzdfi<zzdfj<Bundle>> {

    /* renamed from: a */
    private final Executor f15156a;

    /* renamed from: b */
    private final zzayg f15157b;

    zzday(Executor executor, zzayg zzayg) {
        this.f15156a = executor;
        this.f15157b = zzayg;
    }

    public final zzdyz<zzdfj<Bundle>> zzasm() {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcrd)).booleanValue()) {
            return zzdyr.zzag(null);
        }
        return zzdyr.zzb(this.f15157b.zzxa(), C2561ws.f11733a, this.f15156a);
    }
}
