package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbjr implements zzbjn {

    /* renamed from: a */
    private final zzdms f13358a;

    public zzbjr(zzdms zzdms) {
        this.f13358a = zzdms;
    }

    public final void zzm(Map<String, String> map) {
        String str = map.get("render_in_browser");
        if (!TextUtils.isEmpty(str)) {
            try {
                this.f13358a.zzbm(Boolean.parseBoolean(str));
            } catch (Exception unused) {
                throw new IllegalStateException("Invalid render_in_browser state");
            }
        }
    }
}
