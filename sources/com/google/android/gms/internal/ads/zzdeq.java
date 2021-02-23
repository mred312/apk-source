package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdeq implements zzdfj<Bundle> {

    /* renamed from: a */
    private final String f15496a;

    /* renamed from: b */
    private final String f15497b;

    /* renamed from: c */
    private final String f15498c;

    /* renamed from: d */
    private final String f15499d;

    /* renamed from: e */
    private final Long f15500e;

    public zzdeq(String str, String str2, String str3, String str4, Long l) {
        this.f15496a = str;
        this.f15497b = str2;
        this.f15498c = str3;
        this.f15499d = str4;
        this.f15500e = l;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzdnx.zza(bundle, "gmp_app_id", this.f15496a);
        zzdnx.zza(bundle, "fbs_aiid", this.f15497b);
        zzdnx.zza(bundle, "fbs_aeid", this.f15498c);
        zzdnx.zza(bundle, "apm_id_origin", this.f15499d);
        Long l = this.f15500e;
        if (l != null) {
            bundle.putLong("sai_timeout", l.longValue());
        }
    }
}
