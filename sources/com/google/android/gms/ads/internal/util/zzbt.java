package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;

@TargetApi(17)
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbt {
    private static zzbt zzefj;
    String zzefk;

    private zzbt() {
    }

    public static zzbt zzyy() {
        if (zzefj == null) {
            zzefj = new zzbt();
        }
        return zzefj;
    }
}
