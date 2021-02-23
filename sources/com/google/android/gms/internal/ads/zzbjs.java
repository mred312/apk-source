package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzf;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbjs implements zzbjn {

    /* renamed from: a */
    private zzf f13359a;

    public zzbjs(zzf zzf) {
        this.f13359a = zzf;
    }

    public final void zzm(Map<String, String> map) {
        this.f13359a.zzap(Boolean.parseBoolean(map.get("content_vertical_opted_out")));
    }
}
