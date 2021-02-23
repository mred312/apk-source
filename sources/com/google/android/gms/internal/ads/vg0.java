package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class vg0 implements Handler.Callback, Choreographer.FrameCallback {

    /* renamed from: f */
    private static final vg0 f11612f = new vg0();

    /* renamed from: a */
    public volatile long f11613a;

    /* renamed from: b */
    private final Handler f11614b;

    /* renamed from: c */
    private final HandlerThread f11615c;

    /* renamed from: d */
    private Choreographer f11616d;

    /* renamed from: e */
    private int f11617e;

    private vg0() {
        HandlerThread handlerThread = new HandlerThread("ChoreographerOwner:Handler");
        this.f11615c = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper(), this);
        this.f11614b = handler;
        handler.sendEmptyMessage(0);
    }

    /* renamed from: b */
    public static vg0 m7096b() {
        return f11612f;
    }

    /* renamed from: a */
    public final void mo14938a() {
        this.f11614b.sendEmptyMessage(2);
    }

    /* renamed from: c */
    public final void mo14939c() {
        this.f11614b.sendEmptyMessage(1);
    }

    public final void doFrame(long j) {
        this.f11613a = j;
        this.f11616d.postFrameCallbackDelayed(this, 500);
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            this.f11616d = Choreographer.getInstance();
            return true;
        } else if (i == 1) {
            int i2 = this.f11617e + 1;
            this.f11617e = i2;
            if (i2 == 1) {
                this.f11616d.postFrameCallback(this);
            }
            return true;
        } else if (i != 2) {
            return false;
        } else {
            int i3 = this.f11617e - 1;
            this.f11617e = i3;
            if (i3 == 0) {
                this.f11616d.removeFrameCallback(this);
                this.f11613a = 0;
            }
            return true;
        }
    }
}
