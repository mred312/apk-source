package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

/* renamed from: com.google.android.gms.internal.ads.r8 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2352r8 implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ JsPromptResult f10770a;

    C2352r8(JsPromptResult jsPromptResult) {
        this.f10770a = jsPromptResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f10770a.cancel();
    }
}
