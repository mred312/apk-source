package com.google.android.gms.internal.ads;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class v30<V> extends zzdyp<V> implements zzdyz<V>, ScheduledFuture<V> {

    /* renamed from: b */
    private final ScheduledFuture<?> f11467b;

    public v30(zzdyz<V> zzdyz, ScheduledFuture<?> scheduledFuture) {
        super(zzdyz);
        this.f11467b = scheduledFuture;
    }

    public final boolean cancel(boolean z) {
        boolean cancel = super.cancel(z);
        if (cancel) {
            this.f11467b.cancel(z);
        }
        return cancel;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return this.f11467b.compareTo((Delayed) obj);
    }

    public final long getDelay(TimeUnit timeUnit) {
        return this.f11467b.getDelay(timeUnit);
    }
}
