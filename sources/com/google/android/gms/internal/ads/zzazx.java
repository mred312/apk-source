package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzazx<T> {

    /* renamed from: a */
    private final zzazq<T> f12980a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final AtomicInteger f12981b = new AtomicInteger(0);

    public zzazx() {
        zzazq<T> zzazq = new zzazq<>();
        this.f12980a = zzazq;
        zzdyr.zza(zzazq, new C1942g6(this), zzazj.zzegu);
    }

    @Deprecated
    public final int getStatus() {
        return this.f12981b.get();
    }

    @Deprecated
    public final void reject() {
        this.f12980a.setException(new Exception());
    }

    @Deprecated
    public final void zza(zzazu<T> zzazu, zzazs zzazs) {
        zzdyr.zza(this.f12980a, new C1979h6(this, zzazu, zzazs), zzazj.zzegu);
    }

    @Deprecated
    public final void zzm(T t) {
        this.f12980a.set(t);
    }
}
