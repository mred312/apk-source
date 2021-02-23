package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdre {

    /* renamed from: a */
    private final Object f15888a;

    /* renamed from: b */
    private final /* synthetic */ zzdra f15889b;

    /* JADX WARN: Failed to parse method signature: (TE)V */
    private zzdre(zzdra zzdra, Object obj) {
        this.f15889b = zzdra;
        this.f15888a = obj;
    }

    /* renamed from: a */
    private final <O> zzdrg<O> m8474a(Callable<O> callable, zzdzc zzdzc) {
        return new zzdrg(this.f15889b, this.f15888a, (String) null, zzdra.f15881d, Collections.emptyList(), zzdzc.zze(callable), (C2494uz) null);
    }

    public final zzdrg<?> zza(zzdqy zzdqy, zzdzc zzdzc) {
        return m8474a(new C2606xz(zzdqy), zzdzc);
    }

    public final <O> zzdrg<O> zzc(Callable<O> callable) {
        return m8474a(callable, this.f15889b.f15882a);
    }

    public final <O> zzdrg<O> zze(zzdyz<O> zzdyz) {
        return new zzdrg(this.f15889b, this.f15888a, (String) null, zzdra.f15881d, Collections.emptyList(), zzdyz, (C2494uz) null);
    }
}
