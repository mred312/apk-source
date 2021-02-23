package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdom implements zzepf<Clock> {
    public zzdom(zzdoj zzdoj) {
    }

    public final /* synthetic */ Object get() {
        return (Clock) zzepl.zza(DefaultClock.getInstance(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
