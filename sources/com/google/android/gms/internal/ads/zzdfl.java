package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdfl<T> {

    /* renamed from: a */
    private final Set<zzdfi<? extends zzdfj<T>>> f15533a;

    /* renamed from: b */
    private final Executor f15534b;

    public zzdfl(Executor executor, Set<zzdfi<? extends zzdfj<T>>> set) {
        this.f15534b = executor;
        this.f15533a = set;
    }

    public final zzdyz<T> zzt(T t) {
        ArrayList arrayList = new ArrayList(this.f15533a.size());
        for (zzdfi next : this.f15533a) {
            zzdyz zzasm = next.zzasm();
            if (zzada.zzdcs.get().booleanValue()) {
                zzasm.addListener(new C2225nu(next, zzp.zzkx().elapsedRealtime()), zzazj.zzegu);
            }
            arrayList.add(zzasm);
        }
        return zzdyr.zzk(arrayList).zza(new C2263ou(arrayList, t), this.f15534b);
    }
}
