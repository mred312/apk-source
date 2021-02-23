package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

/* renamed from: com.google.android.gms.internal.ads.s8 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2389s8 implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    private final /* synthetic */ JsPromptResult f10857a;

    C2389s8(JsPromptResult jsPromptResult) {
        this.f10857a = jsPromptResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.f10857a.cancel();
    }
}
