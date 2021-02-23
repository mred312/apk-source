package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzdfj;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdbw<S extends zzdfj<?>> implements zzdfi<S> {

    /* renamed from: a */
    private final AtomicReference<C1891et<S>> f15199a = new AtomicReference<>();

    /* renamed from: b */
    private final Clock f15200b;

    /* renamed from: c */
    private final zzdfi<S> f15201c;

    /* renamed from: d */
    private final long f15202d;

    public zzdbw(zzdfi<S> zzdfi, long j, Clock clock) {
        this.f15200b = clock;
        this.f15201c = zzdfi;
        this.f15202d = j;
    }

    public final zzdyz<S> zzasm() {
        C1891et etVar = this.f15199a.get();
        if (etVar == null || etVar.mo13918a()) {
            etVar = new C1891et(this.f15201c.zzasm(), this.f15202d, this.f15200b);
            this.f15199a.set(etVar);
        }
        return etVar.f8399a;
    }
}
