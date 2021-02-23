package com.google.android.gms.internal.ads;

import android.net.Uri;

/* renamed from: com.google.android.gms.internal.ads.m9 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2167m9 implements zzbeu {

    /* renamed from: a */
    private final zzbdv f9921a;

    C2167m9(zzbdv zzbdv) {
        this.f9921a = zzbdv;
    }

    public final void zzh(Uri uri) {
        zzbfg zzacs = this.f9921a.zzacs();
        if (zzacs == null) {
            zzaza.zzey("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
        } else {
            zzacs.zzh(uri);
        }
    }
}
