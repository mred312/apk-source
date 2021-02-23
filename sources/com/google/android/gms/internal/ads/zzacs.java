package com.google.android.gms.internal.ads;

import androidx.work.WorkRequest;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzacs {
    static {
        zzaco.zzg("gads:consent:gmscore:dsid:enabled", true);
        zzaco.zzg("gads:consent:gmscore:lat:enabled", true);
        new zzaco("gads:consent:gmscore:backend_url", "https://adservice.google.com/getconfig/pubvendors", C2495v.f11455d);
        new zzaco("gads:consent:gmscore:time_out", Long.valueOf(WorkRequest.MIN_BACKOFF_MILLIS), C2495v.f11453b);
        zzaco.zzg("gads:consent:gmscore:enabled", true);
    }

    public static final void zza(zzadr zzadr) {
    }
}
