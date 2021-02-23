package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class r30 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Context f10762a;

    r30(zzdx zzdx, Context context) {
        this.f10762a = context;
    }

    public final void run() {
        try {
            zzdx.f16039g.zzb(this.f10762a);
        } catch (Exception e) {
            zzdx.f16041i.zza(2019, -1, e);
        }
    }
}
