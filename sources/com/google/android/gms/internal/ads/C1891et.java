package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzdfj;

/* renamed from: com.google.android.gms.internal.ads.et */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1891et<S extends zzdfj<?>> {

    /* renamed from: a */
    public final zzdyz<S> f8399a;

    /* renamed from: b */
    private final long f8400b;

    /* renamed from: c */
    private final Clock f8401c;

    public C1891et(zzdyz<S> zzdyz, long j, Clock clock) {
        this.f8399a = zzdyz;
        this.f8401c = clock;
        this.f8400b = clock.elapsedRealtime() + j;
    }

    /* renamed from: a */
    public final boolean mo13918a() {
        return this.f8400b < this.f8401c.elapsedRealtime();
    }
}
