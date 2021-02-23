package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbju implements zzbjn {

    /* renamed from: a */
    private final Context f13361a;

    public zzbju(Context context) {
        this.f13361a = context;
    }

    public final void zzm(Map<String, String> map) {
        CookieManager zzbh;
        String str = map.get("cookie");
        if (!TextUtils.isEmpty(str) && (zzbh = zzp.zzks().zzbh(this.f13361a)) != null) {
            zzbh.setCookie((String) zzwq.zzqe().zzd(zzabf.zzcoi), str);
        }
    }
}
