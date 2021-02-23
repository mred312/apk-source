package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcyb implements zzbub {

    /* renamed from: a */
    private final AtomicReference<zzym> f15047a = new AtomicReference<>();

    public final void zzb(zzvp zzvp) {
        zzdkb.zza(this.f15047a, new C2074jr(zzvp));
    }

    public final void zzc(zzym zzym) {
        this.f15047a.set(zzym);
    }
}
