package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbqu implements zzbru, zzbsi, zzbvz, zzbxn {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzbsl f13688a;

    /* renamed from: b */
    private final zzdmu f13689b;

    /* renamed from: c */
    private final ScheduledExecutorService f13690c;

    /* renamed from: d */
    private final Executor f13691d;

    /* renamed from: e */
    private zzdzh<Boolean> f13692e = zzdzh.zzazp();

    /* renamed from: f */
    private ScheduledFuture<?> f13693f;

    public zzbqu(zzbsl zzbsl, zzdmu zzdmu, ScheduledExecutorService scheduledExecutorService, Executor executor) {
        this.f13688a = zzbsl;
        this.f13689b = zzdmu;
        this.f13690c = scheduledExecutorService;
        this.f13691d = executor;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo16410b() {
        synchronized (this) {
            if (!this.f13692e.isDone()) {
                this.f13692e.set(Boolean.TRUE);
            }
        }
    }

    public final void onAdClosed() {
    }

    public final void onAdLeftApplication() {
    }

    public final void onAdOpened() {
        int i = this.f13689b.zzhhj;
        if (i == 0 || i == 1) {
            this.f13688a.onAdImpression();
        }
    }

    public final void onRewardedVideoCompleted() {
    }

    public final void onRewardedVideoStarted() {
    }

    public final void zzakl() {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcqh)).booleanValue()) {
            zzdmu zzdmu = this.f13689b;
            if (zzdmu.zzhhj != 2) {
                return;
            }
            if (zzdmu.zzhgv == 0) {
                this.f13688a.onAdImpression();
                return;
            }
            zzdyr.zza(this.f13692e, new C1727ad(this), this.f13691d);
            this.f13693f = this.f13690c.schedule(new C2658zc(this), (long) this.f13689b.zzhgv, TimeUnit.MILLISECONDS);
        }
    }

    public final synchronized void zzakm() {
        if (!this.f13692e.isDone()) {
            ScheduledFuture<?> scheduledFuture = this.f13693f;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.f13692e.set(Boolean.TRUE);
        }
    }

    public final void zzakn() {
    }

    public final void zzako() {
    }

    public final void zzb(zzauf zzauf, String str, String str2) {
    }

    public final synchronized void zzj(zzve zzve) {
        if (!this.f13692e.isDone()) {
            ScheduledFuture<?> scheduledFuture = this.f13693f;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.f13692e.setException(new Exception());
        }
    }
}
