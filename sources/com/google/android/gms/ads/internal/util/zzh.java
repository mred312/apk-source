package com.google.android.gms.ads.internal.util;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class zzh implements Runnable {
    private final Context zzckm;
    private final String zzdgt;
    private final zzi zzecf;

    zzh(zzi zzi, Context context, String str) {
        this.zzecf = zzi;
        this.zzckm = context;
        this.zzdgt = str;
    }

    public final void run() {
        this.zzecf.zzo(this.zzckm, this.zzdgt);
    }
}
