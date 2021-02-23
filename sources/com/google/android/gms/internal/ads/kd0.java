package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class kd0 extends Handler {

    /* renamed from: a */
    private final /* synthetic */ ld0 f9749a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    kd0(ld0 ld0, Looper looper) {
        super(looper);
        this.f9749a = ld0;
    }

    public final void handleMessage(Message message) {
        this.f9749a.mo14387a(message);
    }
}
