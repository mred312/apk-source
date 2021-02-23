package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzboc;
import java.util.LinkedList;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdpv<AdT extends zzboc> {

    /* renamed from: a */
    private final zzdpa f15868a;
    /* access modifiers changed from: private */
    @GuardedBy("this")

    /* renamed from: b */
    public zzdqb f15869b;
    /* access modifiers changed from: private */
    @GuardedBy("this")

    /* renamed from: c */
    public zzdzh<zzdpn<AdT>> f15870c;
    @GuardedBy("this")

    /* renamed from: d */
    private zzdyz<zzdpn<AdT>> f15871d;
    /* access modifiers changed from: private */
    @GuardedBy("this")

    /* renamed from: e */
    public int f15872e = C2156lz.f9896a;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final zzdpd f15873f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final zzdqc<AdT> f15874g;

    /* renamed from: h */
    private final LinkedList<zzdqb> f15875h;

    /* renamed from: i */
    private final zzdyo<zzdpn<AdT>> f15876i = new C2082jz(this);

    public zzdpv(zzdpd zzdpd, zzdpa zzdpa, zzdqc<AdT> zzdqc) {
        this.f15873f = zzdpd;
        this.f15868a = zzdpa;
        this.f15874g = zzdqc;
        this.f15875h = new LinkedList<>();
        zzdpa.zza(new C1971gz(this));
    }

    /* renamed from: d */
    private final boolean m8461d() {
        zzdyz<zzdpn<AdT>> zzdyz = this.f15871d;
        return zzdyz == null || zzdyz.isDone();
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public final void m8465j(zzdqb zzdqb) {
        while (m8461d()) {
            if (zzdqb != null || !this.f15875h.isEmpty()) {
                if (zzdqb == null) {
                    zzdqb = this.f15875h.remove();
                }
                if (zzdqb.zzaua() == null || !this.f15873f.zzb(zzdqb.zzaua())) {
                    zzdqb = null;
                } else {
                    this.f15869b = zzdqb.zzaub();
                    this.f15870c = zzdzh.zzazp();
                    zzdyz<zzdpn<AdT>> zza = this.f15874g.zza(this.f15869b);
                    this.f15871d = zza;
                    zzdyr.zza(zza, this.f15876i, zzdqb.getExecutor());
                    return;
                }
            } else {
                return;
            }
        }
        if (zzdqb != null) {
            this.f15875h.add(zzdqb);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final /* synthetic */ void mo17221e() {
        synchronized (this) {
            m8465j(this.f15869b);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final /* synthetic */ zzdyz mo17222h(zzdpn zzdpn) {
        zzdyz zzag;
        synchronized (this) {
            zzag = zzdyr.zzag(new zzdpz(zzdpn, this.f15869b));
        }
        return zzag;
    }

    public final void zzb(zzdqb zzdqb) {
        this.f15875h.add(zzdqb);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0043, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.internal.ads.zzdyz<com.google.android.gms.internal.ads.zzdpz<AdT>> zzc(com.google.android.gms.internal.ads.zzdqb r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.m8461d()     // Catch:{ all -> 0x0044 }
            r1 = 0
            if (r0 == 0) goto L_0x000a
            monitor-exit(r3)
            return r1
        L_0x000a:
            int r0 = com.google.android.gms.internal.ads.C2156lz.f9898c     // Catch:{ all -> 0x0044 }
            r3.f15872e = r0     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzdqb r0 = r3.f15869b     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzdpq r0 = r0.zzaua()     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0042
            com.google.android.gms.internal.ads.zzdpq r0 = r4.zzaua()     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0042
            com.google.android.gms.internal.ads.zzdqb r0 = r3.f15869b     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzdpq r0 = r0.zzaua()     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzdpq r2 = r4.zzaua()     // Catch:{ all -> 0x0044 }
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x002d
            goto L_0x0042
        L_0x002d:
            int r0 = com.google.android.gms.internal.ads.C2156lz.f9897b     // Catch:{ all -> 0x0044 }
            r3.f15872e = r0     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzdzh<com.google.android.gms.internal.ads.zzdpn<AdT>> r0 = r3.f15870c     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.hz r1 = new com.google.android.gms.internal.ads.hz     // Catch:{ all -> 0x0044 }
            r1.<init>(r3)     // Catch:{ all -> 0x0044 }
            java.util.concurrent.Executor r4 = r4.getExecutor()     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzdyz r4 = com.google.android.gms.internal.ads.zzdyr.zzb(r0, r1, (java.util.concurrent.Executor) r4)     // Catch:{ all -> 0x0044 }
            monitor-exit(r3)
            return r4
        L_0x0042:
            monitor-exit(r3)
            return r1
        L_0x0044:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdpv.zzc(com.google.android.gms.internal.ads.zzdqb):com.google.android.gms.internal.ads.zzdyz");
    }
}
