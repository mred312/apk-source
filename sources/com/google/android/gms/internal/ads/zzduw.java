package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.CallSuper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public class zzduw extends Handler {
    private static zzduv zzhsn;

    public zzduw() {
    }

    public final void dispatchMessage(Message message) {
        zzb(message);
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void zzb(Message message) {
        super.dispatchMessage(message);
    }

    public zzduw(Looper looper) {
        super(looper);
    }
}
