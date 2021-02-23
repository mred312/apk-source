package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* renamed from: com.google.android.gms.internal.ads.q8 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2315q8 implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ JsResult f10692a;

    C2315q8(JsResult jsResult) {
        this.f10692a = jsResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f10692a.cancel();
    }
}
