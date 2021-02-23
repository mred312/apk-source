package com.google.android.gms.internal.ads;

import androidx.work.WorkRequest;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzadk {
    public static zzacn<Long> zzddr = zzacn.zzb("gads:rendering:timeout_ms", 60000);

    static {
        zzacn.zzb("gads:ad_loader:timeout_ms", 60000);
        zzacn.zzb("gads:resolve_future:default_timeout_ms", (long) WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
    }
}
