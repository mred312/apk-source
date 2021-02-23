package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* renamed from: com.google.android.gms.measurement.internal.l7 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3044l7 {

    /* renamed from: a */
    private final Clock f18217a;

    /* renamed from: b */
    private long f18218b;

    public C3044l7(Clock clock) {
        Preconditions.checkNotNull(clock);
        this.f18217a = clock;
    }

    /* renamed from: a */
    public final void mo20033a() {
        this.f18218b = this.f18217a.elapsedRealtime();
    }

    /* renamed from: b */
    public final boolean mo20034b(long j) {
        if (this.f18218b != 0 && this.f18217a.elapsedRealtime() - this.f18218b < 3600000) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public final void mo20035c() {
        this.f18218b = 0;
    }
}
