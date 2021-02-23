package com.google.android.gms.internal.ads;

import android.view.MotionEvent;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class n60 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ MotionEvent f10040a;

    n60(zzdx zzdx, MotionEvent motionEvent) {
        this.f10040a = motionEvent;
    }

    public final void run() {
        try {
            zzdx.f16039g.zza(this.f10040a);
        } catch (Exception e) {
            zzdx.f16041i.zza(2022, -1, e);
        }
    }
}
