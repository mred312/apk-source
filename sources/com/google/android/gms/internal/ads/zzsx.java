package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzsx {

    /* renamed from: a */
    private final Runnable f16986a = new wh0(this);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Object f16987b = new Object();
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    @Nullable

    /* renamed from: c */
    public zztc f16988c;
    @GuardedBy("lock")
    @Nullable

    /* renamed from: d */
    private Context f16989d;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    @Nullable

    /* renamed from: e */
    public zztg f16990e;

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m9097a() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f16987b
            monitor-enter(r0)
            android.content.Context r1 = r3.f16989d     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x0021
            com.google.android.gms.internal.ads.zztc r1 = r3.f16988c     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x000c
            goto L_0x0021
        L_0x000c:
            com.google.android.gms.internal.ads.xh0 r1 = new com.google.android.gms.internal.ads.xh0     // Catch:{ all -> 0x0023 }
            r1.<init>(r3)     // Catch:{ all -> 0x0023 }
            com.google.android.gms.internal.ads.zh0 r2 = new com.google.android.gms.internal.ads.zh0     // Catch:{ all -> 0x0023 }
            r2.<init>(r3)     // Catch:{ all -> 0x0023 }
            com.google.android.gms.internal.ads.zztc r1 = r3.m9099c(r1, r2)     // Catch:{ all -> 0x0023 }
            r3.f16988c = r1     // Catch:{ all -> 0x0023 }
            r1.checkAvailabilityAndConnect()     // Catch:{ all -> 0x0023 }
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            return
        L_0x0021:
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            return
        L_0x0023:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsx.m9097a():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m9098b() {
        synchronized (this.f16987b) {
            zztc zztc = this.f16988c;
            if (zztc != null) {
                if (zztc.isConnected() || this.f16988c.isConnecting()) {
                    this.f16988c.disconnect();
                }
                this.f16988c = null;
                this.f16990e = null;
                Binder.flushPendingCommands();
            }
        }
    }

    @VisibleForTesting
    /* renamed from: c */
    private final synchronized zztc m9099c(BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zztc(this.f16989d, zzp.zzle().zzyw(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initialize(android.content.Context r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.Object r0 = r2.f16987b
            monitor-enter(r0)
            android.content.Context r1 = r2.f16989d     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x000c:
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x0048 }
            r2.f16989d = r3     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzabf.zzctb     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x0048 }
            java.lang.Object r3 = r1.zzd(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0028
            r2.m9097a()     // Catch:{ all -> 0x0048 }
            goto L_0x0046
        L_0x0028:
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzabf.zzcta     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x0048 }
            java.lang.Object r3 = r1.zzd(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0046
            com.google.android.gms.internal.ads.yh0 r3 = new com.google.android.gms.internal.ads.yh0     // Catch:{ all -> 0x0048 }
            r3.<init>(r2)     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzrg r1 = com.google.android.gms.ads.internal.zzp.zzkt()     // Catch:{ all -> 0x0048 }
            r1.zza(r3)     // Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x0048:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsx.initialize(android.content.Context):void");
    }

    public final zzta zza(zztf zztf) {
        synchronized (this.f16987b) {
            if (this.f16990e == null) {
                zzta zzta = new zzta();
                return zzta;
            }
            try {
                if (this.f16988c.zznd()) {
                    zzta zzc = this.f16990e.zzc(zztf);
                    return zzc;
                }
                zzta zza = this.f16990e.zza(zztf);
                return zza;
            } catch (RemoteException e) {
                zzaza.zzc("Unable to call into cache service.", e);
                return new zzta();
            }
        }
    }

    public final long zzb(zztf zztf) {
        synchronized (this.f16987b) {
            if (this.f16990e == null) {
                return -2;
            }
            if (this.f16988c.zznd()) {
                try {
                    long zzb = this.f16990e.zzb(zztf);
                    return zzb;
                } catch (RemoteException e) {
                    zzaza.zzc("Unable to call into cache service.", e);
                    return -2;
                }
            }
        }
    }

    public final void zzmu() {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzctc)).booleanValue()) {
            synchronized (this.f16987b) {
                m9097a();
                zzduw zzduw = zzm.zzedd;
                zzduw.removeCallbacks(this.f16986a);
                zzduw.postDelayed(this.f16986a, ((Long) zzwq.zzqe().zzd(zzabf.zzctd)).longValue());
            }
        }
    }
}
