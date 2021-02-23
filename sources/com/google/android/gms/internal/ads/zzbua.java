package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Clock;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbua extends zzbwk<zzbue> {

    /* renamed from: b */
    private final ScheduledExecutorService f13777b;

    /* renamed from: c */
    private final Clock f13778c;
    @GuardedBy("this")

    /* renamed from: d */
    private long f13779d = -1;
    @GuardedBy("this")

    /* renamed from: e */
    private long f13780e = -1;
    @GuardedBy("this")

    /* renamed from: f */
    private boolean f13781f = false;
    @GuardedBy("this")
    @Nullable

    /* renamed from: g */
    private ScheduledFuture<?> f13782g;

    public zzbua(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        super(Collections.emptySet());
        this.f13777b = scheduledExecutorService;
        this.f13778c = clock;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m7862c() {
        zza(C1950ge.f8743a);
    }

    /* renamed from: d */
    private final synchronized void m7863d(long j) {
        ScheduledFuture<?> scheduledFuture = this.f13782g;
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            this.f13782g.cancel(true);
        }
        this.f13779d = this.f13778c.elapsedRealtime() + j;
        this.f13782g = this.f13777b.schedule(new C1987he(this), j, TimeUnit.MILLISECONDS);
    }

    public final synchronized void onPause() {
        if (!this.f13781f) {
            ScheduledFuture<?> scheduledFuture = this.f13782g;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                this.f13780e = -1;
            } else {
                this.f13782g.cancel(true);
                this.f13780e = this.f13779d - this.f13778c.elapsedRealtime();
            }
            this.f13781f = true;
        }
    }

    public final synchronized void onResume() {
        if (this.f13781f) {
            if (this.f13780e > 0 && this.f13782g.isCancelled()) {
                m7863d(this.f13780e);
            }
            this.f13781f = false;
        }
    }

    public final synchronized void zzalb() {
        this.f13781f = false;
        m7863d(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzdx(int r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            if (r7 > 0) goto L_0x0005
            monitor-exit(r6)
            return
        L_0x0005:
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x003e }
            long r1 = (long) r7     // Catch:{ all -> 0x003e }
            long r0 = r0.toMillis(r1)     // Catch:{ all -> 0x003e }
            boolean r7 = r6.f13781f     // Catch:{ all -> 0x003e }
            if (r7 == 0) goto L_0x0022
            long r2 = r6.f13780e     // Catch:{ all -> 0x003e }
            r4 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 <= 0) goto L_0x001d
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r0 = r2
        L_0x001e:
            r6.f13780e = r0     // Catch:{ all -> 0x003e }
            monitor-exit(r6)
            return
        L_0x0022:
            com.google.android.gms.common.util.Clock r7 = r6.f13778c     // Catch:{ all -> 0x003e }
            long r2 = r7.elapsedRealtime()     // Catch:{ all -> 0x003e }
            long r4 = r6.f13779d     // Catch:{ all -> 0x003e }
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 > 0) goto L_0x0039
            com.google.android.gms.common.util.Clock r7 = r6.f13778c     // Catch:{ all -> 0x003e }
            long r2 = r7.elapsedRealtime()     // Catch:{ all -> 0x003e }
            long r4 = r4 - r2
            int r7 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r7 <= 0) goto L_0x003c
        L_0x0039:
            r6.m7863d(r0)     // Catch:{ all -> 0x003e }
        L_0x003c:
            monitor-exit(r6)
            return
        L_0x003e:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbua.zzdx(int):void");
    }
}
