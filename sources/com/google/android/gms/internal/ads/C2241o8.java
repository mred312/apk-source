package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* renamed from: com.google.android.gms.internal.ads.o8 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2241o8 implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    private final /* synthetic */ JsResult f10262a;

    C2241o8(JsResult jsResult) {
        this.f10262a = jsResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.f10262a.cancel();
    }
}
