package com.google.android.gms.ads.internal.util;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class zzq implements Runnable {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzm zzedj;

    zzq(zzm zzm, Context context) {
        this.zzedj = zzm;
        this.val$context = context;
    }

    public final void run() {
        synchronized (this.zzedj.zzede) {
            String unused = this.zzedj.zzbih = zzm.zzao(this.val$context);
            this.zzedj.zzede.notifyAll();
        }
    }
}
