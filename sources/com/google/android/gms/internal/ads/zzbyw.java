package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebView;
import com.bumptech.glide.load.Key;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbyw implements zzsu {

    /* renamed from: a */
    private zzdva f13858a;

    public final View getView() {
        return this.f13858a;
    }

    public final WebView getWebView() {
        if (this.f13858a == null) {
            return null;
        }
        return zzdva.getWebView();
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.f13858a != null) {
            zzdva.onPageStarted(webView, str, bitmap);
        }
    }

    public final void zza(Activity activity, WebView webView) {
        try {
            this.f13858a = new zzdva(activity, webView);
        } catch (RuntimeException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 46);
            sb.append(" Failed to initialize the internal ArWebView: ");
            sb.append(valueOf);
            zzaza.zzey(sb.toString());
        }
    }

    public final void zzc(String str, String str2) {
        if (this.f13858a == null) {
            zzaza.zzey("ArWebView is not initialized.");
        } else {
            zzdva.getWebView().loadDataWithBaseURL(str, str2, "text/html", Key.STRING_CHARSET_NAME, (String) null);
        }
    }
}
