package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class zzbx extends BroadcastReceiver {
    private final /* synthetic */ zzby zzefm;

    zzbx(zzby zzby) {
        this.zzefm = zzby;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zzefm.zzc(context, intent);
    }
}
