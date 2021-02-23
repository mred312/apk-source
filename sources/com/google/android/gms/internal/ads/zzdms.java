package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdms {

    /* renamed from: a */
    private final Clock f15780a;

    /* renamed from: b */
    private final Object f15781b = new Object();
    @GuardedBy("lock")

    /* renamed from: c */
    private volatile int f15782c = C2229ny.f10233a;

    /* renamed from: d */
    private volatile long f15783d = 0;

    public zzdms(Clock clock) {
        this.f15780a = clock;
    }

    /* renamed from: a */
    private final void m8422a() {
        long currentTimeMillis = this.f15780a.currentTimeMillis();
        synchronized (this.f15781b) {
            if (this.f15782c == C2229ny.f10235c) {
                if (this.f15783d + ((Long) zzwq.zzqe().zzd(zzabf.zzcwh)).longValue() <= currentTimeMillis) {
                    this.f15782c = C2229ny.f10233a;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m8423b(int r5, int r6) {
        /*
            r4 = this;
            r4.m8422a()
            com.google.android.gms.common.util.Clock r0 = r4.f15780a
            long r0 = r0.currentTimeMillis()
            java.lang.Object r2 = r4.f15781b
            monitor-enter(r2)
            int r3 = r4.f15782c     // Catch:{ all -> 0x001e }
            if (r3 == r5) goto L_0x0012
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            return
        L_0x0012:
            r4.f15782c = r6     // Catch:{ all -> 0x001e }
            int r5 = r4.f15782c     // Catch:{ all -> 0x001e }
            int r6 = com.google.android.gms.internal.ads.C2229ny.f10235c     // Catch:{ all -> 0x001e }
            if (r5 != r6) goto L_0x001c
            r4.f15783d = r0     // Catch:{ all -> 0x001e }
        L_0x001c:
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            return
        L_0x001e:
            r5 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdms.m8423b(int, int):void");
    }

    public final boolean zzaui() {
        boolean z;
        synchronized (this.f15781b) {
            m8422a();
            z = this.f15782c == C2229ny.f10234b;
        }
        return z;
    }

    public final boolean zzauj() {
        boolean z;
        synchronized (this.f15781b) {
            m8422a();
            z = this.f15782c == C2229ny.f10235c;
        }
        return z;
    }

    public final void zzbm(boolean z) {
        if (z) {
            m8423b(C2229ny.f10233a, C2229ny.f10234b);
        } else {
            m8423b(C2229ny.f10234b, C2229ny.f10233a);
        }
    }

    public final void zzwv() {
        m8423b(C2229ny.f10234b, C2229ny.f10235c);
    }
}
