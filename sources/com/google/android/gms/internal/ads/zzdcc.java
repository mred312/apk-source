package com.google.android.gms.internal.ads;

import androidx.work.WorkRequest;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdcc implements zzepf<zzdbw<zzdbr>> {

    /* renamed from: a */
    private final zzeps<zzdbq> f15405a;

    /* renamed from: b */
    private final zzeps<Clock> f15406b;

    public zzdcc(zzeps<zzdbq> zzeps, zzeps<Clock> zzeps2) {
        this.f15405a = zzeps;
        this.f15406b = zzeps2;
    }

    public final /* synthetic */ Object get() {
        return (zzdbw) zzepl.zza(new zzdbw(this.f15405a.get(), WorkRequest.MIN_BACKOFF_MILLIS, this.f15406b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
