package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcrc<DelegateT, AdapterT> implements zzcqz<AdapterT> {
    @VisibleForTesting

    /* renamed from: a */
    private final zzcqz<DelegateT> f14731a;

    /* renamed from: b */
    private final zzdvm<DelegateT, AdapterT> f14732b;

    public zzcrc(zzcqz<DelegateT> zzcqz, zzdvm<DelegateT, AdapterT> zzdvm) {
        this.f14731a = zzcqz;
        this.f14732b = zzdvm;
    }

    public final boolean zza(zzdnj zzdnj, zzdmu zzdmu) {
        return this.f14731a.zza(zzdnj, zzdmu);
    }

    public final zzdyz<AdapterT> zzb(zzdnj zzdnj, zzdmu zzdmu) {
        return zzdyr.zzb(this.f14731a.zzb(zzdnj, zzdmu), this.f14732b, (Executor) zzazj.zzegp);
    }
}
