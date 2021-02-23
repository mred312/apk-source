package com.google.android.gms.internal.ads;

import android.view.MotionEvent;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class a60 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ int f7789a;

    /* renamed from: b */
    private final /* synthetic */ int f7790b;

    /* renamed from: c */
    private final /* synthetic */ int f7791c;

    a60(zzdx zzdx, int i, int i2, int i3) {
        this.f7789a = i;
        this.f7790b = i2;
        this.f7791c = i3;
    }

    public final void run() {
        try {
            zzdx.f16039g.zza(MotionEvent.obtain(0, (long) this.f7789a, 0, (float) this.f7790b, (float) this.f7791c, 0));
        } catch (Exception e) {
            zzdx.f16041i.zza(2022, -1, e);
        }
    }
}
