package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.sh */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2402sh implements zzahv {

    /* renamed from: a */
    private final zzcdi f11087a;

    C2402sh(zzcdi zzcdi) {
        this.f11087a = zzcdi;
    }

    public final void zza(Object obj, Map map) {
        zzbdv zzbdv = (zzbdv) obj;
        zzbdv.zzacs().zza((zzbfj) new C2550wh(this.f11087a, map));
        String str = (String) map.get("overlayHtml");
        String str2 = (String) map.get("baseUrl");
        if (TextUtils.isEmpty(str2)) {
            zzbdv.loadData(str, "text/html", Key.STRING_CHARSET_NAME);
        } else {
            zzbdv.loadDataWithBaseURL(str2, str, "text/html", Key.STRING_CHARSET_NAME, (String) null);
        }
    }
}
