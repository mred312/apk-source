package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzw extends Thread {

    /* renamed from: a */
    private final BlockingQueue<zzaa<?>> f17089a;

    /* renamed from: b */
    private final zzx f17090b;

    /* renamed from: c */
    private final zzk f17091c;

    /* renamed from: d */
    private final zzak f17092d;

    /* renamed from: e */
    private volatile boolean f17093e = false;

    public zzw(BlockingQueue<zzaa<?>> blockingQueue, zzx zzx, zzk zzk, zzak zzak) {
        this.f17089a = blockingQueue;
        this.f17090b = zzx;
        this.f17091c = zzk;
        this.f17092d = zzak;
    }

    /* renamed from: a */
    private final void m9262a() {
        zzaa take = this.f17089a.take();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        take.zzd(3);
        try {
            take.zzc("network-queue-take");
            take.isCanceled();
            TrafficStats.setThreadStatsTag(take.zzd());
            zzy zzc = this.f17090b.zzc(take);
            take.zzc("network-http-complete");
            if (!zzc.zzam || !take.zzl()) {
                zzaj zza = take.zza(zzc);
                take.zzc("network-parse-complete");
                if (take.zzh() && zza.zzbq != null) {
                    this.f17091c.zza(take.zze(), zza.zzbq);
                    take.zzc("network-cache-written");
                }
                take.zzk();
                this.f17092d.zzb(take, zza);
                take.zza((zzaj<?>) zza);
                take.zzd(4);
                return;
            }
            take.zzd("not-modified");
            take.zzm();
        } catch (zzao e) {
            e.mo15557a(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.f17092d.zza(take, e);
            take.zzm();
        } catch (Exception e2) {
            zzaq.zza(e2, "Unhandled exception %s", e2.toString());
            zzao zzao = new zzao((Throwable) e2);
            zzao.mo15557a(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.f17092d.zza(take, zzao);
            take.zzm();
        } finally {
            take.zzd(4);
        }
    }

    public final void quit() {
        this.f17093e = true;
        interrupt();
    }

    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                m9262a();
            } catch (InterruptedException unused) {
                if (this.f17093e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzaq.m7525e("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
