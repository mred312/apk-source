package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.w9 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2542w9 implements zzahv<zzbdv> {

    /* renamed from: a */
    private final /* synthetic */ C2468u9 f11683a;

    C2542w9(C2468u9 u9Var) {
        this.f11683a = u9Var;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbdv zzbdv = (zzbdv) obj;
        if (map != null) {
            String str = (String) map.get("height");
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.f11683a) {
                        if (this.f11683a.f11263G != parseInt) {
                            int unused = this.f11683a.f11263G = parseInt;
                            this.f11683a.requestLayout();
                        }
                    }
                } catch (Exception e) {
                    zzaza.zzd("Exception occurred while getting webview content height", e);
                }
            }
        }
    }
}
