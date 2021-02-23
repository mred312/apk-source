package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class z30<V> extends j30<V> {
    /* access modifiers changed from: private */
    @NullableDecl

    /* renamed from: h */
    public zzdyz<V> f12254h;
    /* access modifiers changed from: private */
    @NullableDecl

    /* renamed from: i */
    public ScheduledFuture<?> f12255i;

    private z30(zzdyz<V> zzdyz) {
        this.f12254h = (zzdyz) zzdvv.checkNotNull(zzdyz);
    }

    /* renamed from: v */
    static <V> zzdyz<V> m7392v(zzdyz<V> zzdyz, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        z30 z30 = new z30(zzdyz);
        b40 b40 = new b40(z30);
        z30.f12255i = scheduledExecutorService.schedule(b40, j, timeUnit);
        zzdyz.addListener(b40, g30.INSTANCE);
        return z30;
    }

    /* access modifiers changed from: protected */
    public final void afterDone() {
        mo17379c(this.f12254h);
        ScheduledFuture<?> scheduledFuture = this.f12255i;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f12254h = null;
        this.f12255i = null;
    }

    /* access modifiers changed from: protected */
    public final String pendingToString() {
        zzdyz<V> zzdyz = this.f12254h;
        ScheduledFuture<?> scheduledFuture = this.f12255i;
        if (zzdyz == null) {
            return null;
        }
        String valueOf = String.valueOf(zzdyz);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14);
        sb.append("inputFuture=[");
        sb.append(valueOf);
        sb.append("]");
        String sb2 = sb.toString();
        if (scheduledFuture == null) {
            return sb2;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return sb2;
        }
        String valueOf2 = String.valueOf(sb2);
        StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 43);
        sb3.append(valueOf2);
        sb3.append(", remaining delay=[");
        sb3.append(delay);
        sb3.append(" ms]");
        return sb3.toString();
    }
}
