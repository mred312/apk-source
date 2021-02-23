package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbff;
import com.google.android.gms.internal.ads.zzbfh;

@TargetApi(17)
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbet<WebViewT extends zzbex & zzbff & zzbfh> {

    /* renamed from: a */
    private final zzbeu f13212a;

    /* renamed from: b */
    private final WebViewT f13213b;

    private zzbet(WebViewT webviewt, zzbeu zzbeu) {
        this.f13212a = zzbeu;
        this.f13213b = webviewt;
    }

    public static zzbet<zzbdv> zzc(zzbdv zzbdv) {
        return new zzbet<>(zzbdv, new C2167m9(zzbdv));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo16199a(String str) {
        this.f13212a.zzh(Uri.parse(str));
    }

    @JavascriptInterface
    public final String getClickSignals(String str) {
        if (TextUtils.isEmpty(str)) {
            zzd.zzee("Click string is empty, not proceeding.");
            return "";
        }
        zzef zzacv = ((zzbff) this.f13213b).zzacv();
        if (zzacv == null) {
            zzd.zzee("Signal utils is empty, ignoring.");
            return "";
        }
        zzdv zzca = zzacv.zzca();
        if (zzca == null) {
            zzd.zzee("Signals object is empty, ignoring.");
            return "";
        } else if (this.f13213b.getContext() != null) {
            return zzca.zza(this.f13213b.getContext(), str, ((zzbfh) this.f13213b).getView(), this.f13213b.zzaaj());
        } else {
            zzd.zzee("Context is null, ignoring.");
            return "";
        }
    }

    @JavascriptInterface
    public final void notify(String str) {
        if (TextUtils.isEmpty(str)) {
            zzaza.zzfa("URL is empty, ignoring message");
        } else {
            zzm.zzedd.post(new C2204n9(this, str));
        }
    }
}
