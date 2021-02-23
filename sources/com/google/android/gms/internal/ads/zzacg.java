package com.google.android.gms.internal.ads;

import android.view.MotionEvent;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzacg {

    /* renamed from: a */
    private MotionEvent f12383a = MotionEvent.obtain(0, 0, 1, 0.0f, 0.0f, 0);

    /* renamed from: b */
    private MotionEvent f12384b = MotionEvent.obtain(0, 0, 0, 0.0f, 0.0f, 0);

    public final void zza(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && motionEvent.getEventTime() > this.f12383a.getEventTime()) {
            this.f12383a = MotionEvent.obtain(motionEvent);
        } else if (motionEvent.getAction() == 0 && motionEvent.getEventTime() > this.f12384b.getEventTime()) {
            this.f12384b = MotionEvent.obtain(motionEvent);
        }
    }

    public final MotionEvent zzsg() {
        return this.f12383a;
    }

    public final MotionEvent zzsh() {
        return this.f12384b;
    }
}
