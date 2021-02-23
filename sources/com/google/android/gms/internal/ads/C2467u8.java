package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.widget.EditText;

/* renamed from: com.google.android.gms.internal.ads.u8 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2467u8 implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ JsPromptResult f11255a;

    /* renamed from: b */
    private final /* synthetic */ EditText f11256b;

    C2467u8(JsPromptResult jsPromptResult, EditText editText) {
        this.f11255a = jsPromptResult;
        this.f11256b = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f11255a.confirm(this.f11256b.getText().toString());
    }
}
