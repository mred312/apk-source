package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbso extends zzbwk<zzbsp> {
    public zzbso(Set<zzbxy<zzbsp>> set) {
        super(set);
    }

    public final void zza(zzbyo zzbyo, Executor executor) {
        zza(zzbxy.zzb(new C2246od(this, zzbyo), executor));
    }

    public final void zzcc(Context context) {
        zza(new C2208nd(context));
    }

    public final void zzcd(Context context) {
        zza(new C2171md(context));
    }

    public final void zzce(Context context) {
        zza(new C2283pd(context));
    }
}
