package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class ph0 implements Runnable {

    /* renamed from: a */
    private ValueCallback<String> f10629a = new sh0(this);

    /* renamed from: b */
    final /* synthetic */ zzre f10630b;

    /* renamed from: c */
    final /* synthetic */ WebView f10631c;

    /* renamed from: d */
    final /* synthetic */ boolean f10632d;

    /* renamed from: e */
    final /* synthetic */ zzrk f10633e;

    ph0(zzrk zzrk, zzre zzre, WebView webView, boolean z) {
        this.f10633e = zzrk;
        this.f10630b = zzre;
        this.f10631c = webView;
        this.f10632d = z;
    }

    public final void run() {
        if (this.f10631c.getSettings().getJavaScriptEnabled()) {
            try {
                this.f10631c.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.f10629a);
            } catch (Throwable unused) {
                this.f10629a.onReceiveValue("");
            }
        }
    }
}
