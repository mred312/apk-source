package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzm extends Thread {

    /* renamed from: g */
    private static final boolean f16718g = zzaq.DEBUG;

    /* renamed from: a */
    private final BlockingQueue<zzaa<?>> f16719a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final BlockingQueue<zzaa<?>> f16720b;

    /* renamed from: c */
    private final zzk f16721c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final zzak f16722d;

    /* renamed from: e */
    private volatile boolean f16723e = false;

    /* renamed from: f */
    private final lg0 f16724f;

    public zzm(BlockingQueue<zzaa<?>> blockingQueue, BlockingQueue<zzaa<?>> blockingQueue2, zzk zzk, zzak zzak) {
        this.f16719a = blockingQueue;
        this.f16720b = blockingQueue2;
        this.f16721c = zzk;
        this.f16722d = zzak;
        this.f16724f = new lg0(this);
    }

    /* renamed from: a */
    private final void m9022a() {
        zzaa take = this.f16719a.take();
        take.zzc("cache-queue-take");
        take.zzd(1);
        try {
            take.isCanceled();
            zzn zzb = this.f16721c.zzb(take.zze());
            if (zzb == null) {
                take.zzc("cache-miss");
                if (!this.f16724f.m6458d(take)) {
                    this.f16720b.put(take);
                }
            } else if (zzb.zza()) {
                take.zzc("cache-hit-expired");
                take.zza(zzb);
                if (!this.f16724f.m6458d(take)) {
                    this.f16720b.put(take);
                }
                take.zzd(2);
            } else {
                take.zzc("cache-hit");
                zzaj zza = take.zza(new zzy(zzb.data, zzb.zzw));
                take.zzc("cache-hit-parsed");
                if (!zza.isSuccess()) {
                    take.zzc("cache-parsing-failed");
                    this.f16721c.zza(take.zze(), true);
                    take.zza((zzn) null);
                    if (!this.f16724f.m6458d(take)) {
                        this.f16720b.put(take);
                    }
                    take.zzd(2);
                    return;
                }
                if (!(zzb.zzv < System.currentTimeMillis())) {
                    this.f16722d.zzb(take, zza);
                } else {
                    take.zzc("cache-hit-refresh-needed");
                    take.zza(zzb);
                    zza.zzbs = true;
                    if (!this.f16724f.m6458d(take)) {
                        this.f16722d.zza(take, zza, new og0(this, take));
                    } else {
                        this.f16722d.zzb(take, zza);
                    }
                }
                take.zzd(2);
            }
        } finally {
            take.zzd(2);
        }
    }

    public final void quit() {
        this.f16723e = true;
        interrupt();
    }

    public final void run() {
        if (f16718g) {
            zzaq.m7526v("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f16721c.initialize();
        while (true) {
            try {
                m9022a();
            } catch (InterruptedException unused) {
                if (this.f16723e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzaq.m7525e("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
