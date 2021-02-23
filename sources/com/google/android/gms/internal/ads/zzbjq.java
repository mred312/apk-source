package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzf;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbjq implements zzbjn {

    /* renamed from: a */
    private zzf f13357a;

    public zzbjq(zzf zzf) {
        this.f13357a = zzf;
    }

    public final void zzm(Map<String, String> map) {
        this.f13357a.zzao(Boolean.parseBoolean(map.get("content_url_opted_out")));
    }
}
