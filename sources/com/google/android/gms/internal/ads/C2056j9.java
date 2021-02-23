package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.j9 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2056j9 implements zzahv<zzbdv> {

    /* renamed from: a */
    private final /* synthetic */ C1982h9 f9383a;

    C2056j9(C1982h9 h9Var) {
        this.f9383a = h9Var;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbdv zzbdv = (zzbdv) obj;
        if (map != null) {
            String str = (String) map.get("height");
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.f9383a) {
                        if (this.f9383a.f8859I != parseInt) {
                            int unused = this.f9383a.f8859I = parseInt;
                            this.f9383a.requestLayout();
                        }
                    }
                } catch (Exception e) {
                    zzaza.zzd("Exception occurred while getting webview content height", e);
                }
            }
        }
    }
}
