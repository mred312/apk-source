package com.google.android.gms.measurement.internal;

import androidx.annotation.GuardedBy;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;

/* renamed from: com.google.android.gms.measurement.internal.p3 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3076p3 extends Thread {

    /* renamed from: a */
    private final Object f18290a;

    /* renamed from: b */
    private final BlockingQueue<C3085q3<?>> f18291b;
    @GuardedBy("threadLifeCycleLock")

    /* renamed from: c */
    private boolean f18292c = false;

    /* renamed from: d */
    private final /* synthetic */ zzfo f18293d;

    public C3076p3(zzfo zzfo, String str, BlockingQueue<C3085q3<?>> blockingQueue) {
        this.f18293d = zzfo;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.f18290a = new Object();
        this.f18291b = blockingQueue;
        setName(str);
    }

    /* renamed from: b */
    private final void m10628b(InterruptedException interruptedException) {
        this.f18293d.zzq().zzh().zza(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    /* renamed from: c */
    private final void m10629c() {
        synchronized (this.f18293d.f18590h) {
            if (!this.f18292c) {
                this.f18293d.f18591i.release();
                this.f18293d.f18590h.notifyAll();
                if (this == this.f18293d.f18584b) {
                    C3076p3 unused = this.f18293d.f18584b = null;
                } else if (this == this.f18293d.f18585c) {
                    C3076p3 unused2 = this.f18293d.f18585c = null;
                } else {
                    this.f18293d.zzq().zze().zza("Current scheduler thread is neither worker nor network");
                }
                this.f18292c = true;
            }
        }
    }

    /* renamed from: a */
    public final void mo20084a() {
        synchronized (this.f18290a) {
            this.f18290a.notifyAll();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0075, code lost:
        m10629c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0078, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r5 = this;
            r0 = 0
        L_0x0001:
            if (r0 != 0) goto L_0x0013
            com.google.android.gms.measurement.internal.zzfo r1 = r5.f18293d     // Catch:{ InterruptedException -> 0x000e }
            java.util.concurrent.Semaphore r1 = r1.f18591i     // Catch:{ InterruptedException -> 0x000e }
            r1.acquire()     // Catch:{ InterruptedException -> 0x000e }
            r0 = 1
            goto L_0x0001
        L_0x000e:
            r1 = move-exception
            r5.m10628b(r1)
            goto L_0x0001
        L_0x0013:
            int r0 = android.os.Process.myTid()     // Catch:{ all -> 0x0081 }
            int r0 = android.os.Process.getThreadPriority(r0)     // Catch:{ all -> 0x0081 }
        L_0x001b:
            java.util.concurrent.BlockingQueue<com.google.android.gms.measurement.internal.q3<?>> r1 = r5.f18291b     // Catch:{ all -> 0x0081 }
            java.lang.Object r1 = r1.poll()     // Catch:{ all -> 0x0081 }
            com.google.android.gms.measurement.internal.q3 r1 = (com.google.android.gms.measurement.internal.C3085q3) r1     // Catch:{ all -> 0x0081 }
            if (r1 == 0) goto L_0x0034
            boolean r2 = r1.f18315b     // Catch:{ all -> 0x0081 }
            if (r2 == 0) goto L_0x002b
            r2 = r0
            goto L_0x002d
        L_0x002b:
            r2 = 10
        L_0x002d:
            android.os.Process.setThreadPriority(r2)     // Catch:{ all -> 0x0081 }
            r1.run()     // Catch:{ all -> 0x0081 }
            goto L_0x001b
        L_0x0034:
            java.lang.Object r1 = r5.f18290a     // Catch:{ all -> 0x0081 }
            monitor-enter(r1)     // Catch:{ all -> 0x0081 }
            java.util.concurrent.BlockingQueue<com.google.android.gms.measurement.internal.q3<?>> r2 = r5.f18291b     // Catch:{ all -> 0x007e }
            java.lang.Object r2 = r2.peek()     // Catch:{ all -> 0x007e }
            if (r2 != 0) goto L_0x0053
            com.google.android.gms.measurement.internal.zzfo r2 = r5.f18293d     // Catch:{ all -> 0x007e }
            boolean r2 = r2.f18592j     // Catch:{ all -> 0x007e }
            if (r2 != 0) goto L_0x0053
            java.lang.Object r2 = r5.f18290a     // Catch:{ InterruptedException -> 0x004f }
            r3 = 30000(0x7530, double:1.4822E-319)
            r2.wait(r3)     // Catch:{ InterruptedException -> 0x004f }
            goto L_0x0053
        L_0x004f:
            r2 = move-exception
            r5.m10628b(r2)     // Catch:{ all -> 0x007e }
        L_0x0053:
            monitor-exit(r1)     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.zzfo r1 = r5.f18293d     // Catch:{ all -> 0x0081 }
            java.lang.Object r1 = r1.f18590h     // Catch:{ all -> 0x0081 }
            monitor-enter(r1)     // Catch:{ all -> 0x0081 }
            java.util.concurrent.BlockingQueue<com.google.android.gms.measurement.internal.q3<?>> r2 = r5.f18291b     // Catch:{ all -> 0x007b }
            java.lang.Object r2 = r2.peek()     // Catch:{ all -> 0x007b }
            if (r2 != 0) goto L_0x0079
            com.google.android.gms.measurement.internal.zzfo r0 = r5.f18293d     // Catch:{ all -> 0x007b }
            com.google.android.gms.measurement.internal.zzy r0 = r0.zzs()     // Catch:{ all -> 0x007b }
            com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzat.zzbq     // Catch:{ all -> 0x007b }
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzeg<java.lang.Boolean>) r2)     // Catch:{ all -> 0x007b }
            if (r0 == 0) goto L_0x0074
            r5.m10629c()     // Catch:{ all -> 0x007b }
        L_0x0074:
            monitor-exit(r1)     // Catch:{ all -> 0x007b }
            r5.m10629c()
            return
        L_0x0079:
            monitor-exit(r1)     // Catch:{ all -> 0x007b }
            goto L_0x001b
        L_0x007b:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x007b }
            throw r0     // Catch:{ all -> 0x0081 }
        L_0x007e:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x007e }
            throw r0     // Catch:{ all -> 0x0081 }
        L_0x0081:
            r0 = move-exception
            r5.m10629c()
            goto L_0x0087
        L_0x0086:
            throw r0
        L_0x0087:
            goto L_0x0086
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C3076p3.run():void");
    }
}
