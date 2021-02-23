package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbkv implements zzrl {

    /* renamed from: a */
    private final ScheduledExecutorService f13443a;

    /* renamed from: b */
    private final Clock f13444b;
    @GuardedBy("this")
    @Nullable

    /* renamed from: c */
    private ScheduledFuture<?> f13445c;
    @GuardedBy("this")

    /* renamed from: d */
    private long f13446d = -1;
    @GuardedBy("this")

    /* renamed from: e */
    private long f13447e = -1;
    @GuardedBy("this")

    /* renamed from: f */
    private Runnable f13448f = null;
    @GuardedBy("this")

    /* renamed from: g */
    private boolean f13449g = false;

    public zzbkv(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        this.f13443a = scheduledExecutorService;
        this.f13444b = clock;
        zzp.zzkt().zza(this);
    }

    @VisibleForTesting
    /* renamed from: a */
    private final synchronized void m7821a() {
        if (!this.f13449g) {
            ScheduledFuture<?> scheduledFuture = this.f13445c;
            if (scheduledFuture == null || scheduledFuture.isDone()) {
                this.f13447e = -1;
            } else {
                this.f13445c.cancel(true);
                this.f13447e = this.f13446d - this.f13444b.elapsedRealtime();
            }
            this.f13449g = true;
        }
    }

    @VisibleForTesting
    /* renamed from: b */
    private final synchronized void m7822b() {
        ScheduledFuture<?> scheduledFuture;
        if (this.f13449g) {
            if (this.f13447e > 0 && (scheduledFuture = this.f13445c) != null && scheduledFuture.isCancelled()) {
                this.f13445c = this.f13443a.schedule(this.f13448f, this.f13447e, TimeUnit.MILLISECONDS);
            }
            this.f13449g = false;
        }
    }

    public final synchronized void zza(int i, Runnable runnable) {
        this.f13448f = runnable;
        long j = (long) i;
        this.f13446d = this.f13444b.elapsedRealtime() + j;
        this.f13445c = this.f13443a.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    public final void zzp(boolean z) {
        if (z) {
            m7822b();
        } else {
            m7821a();
        }
    }
}
