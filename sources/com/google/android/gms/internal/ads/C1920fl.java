package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;

/* renamed from: com.google.android.gms.internal.ads.fl */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C1920fl implements Runnable {

    /* renamed from: a */
    private final zzazq f8481a;

    C1920fl(zzclp zzclp, zzazq zzazq) {
        this.f8481a = zzazq;
    }

    public final void run() {
        zzazq zzazq = this.f8481a;
        String zzxf = zzp.zzku().zzwz().zzxv().zzxf();
        if (!TextUtils.isEmpty(zzxf)) {
            zzazq.set(zzxf);
        } else {
            zzazq.setException(new Exception());
        }
    }
}
