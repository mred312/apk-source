package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class lg0 implements C2380s {

    /* renamed from: a */
    private final Map<String, List<zzaa<?>>> f9864a = new HashMap();

    /* renamed from: b */
    private final zzm f9865b;

    lg0(zzm zzm) {
        this.f9865b = zzm;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0051, code lost:
        return false;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean m6458d(com.google.android.gms.internal.ads.zzaa<?> r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = r6.zze()     // Catch:{ all -> 0x0052 }
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzaa<?>>> r1 = r5.f9864a     // Catch:{ all -> 0x0052 }
            boolean r1 = r1.containsKey(r0)     // Catch:{ all -> 0x0052 }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x003a
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzaa<?>>> r1 = r5.f9864a     // Catch:{ all -> 0x0052 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0052 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x0052 }
            if (r1 != 0) goto L_0x001e
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0052 }
            r1.<init>()     // Catch:{ all -> 0x0052 }
        L_0x001e:
            java.lang.String r4 = "waiting-for-response"
            r6.zzc(r4)     // Catch:{ all -> 0x0052 }
            r1.add(r6)     // Catch:{ all -> 0x0052 }
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzaa<?>>> r6 = r5.f9864a     // Catch:{ all -> 0x0052 }
            r6.put(r0, r1)     // Catch:{ all -> 0x0052 }
            boolean r6 = com.google.android.gms.internal.ads.zzaq.DEBUG     // Catch:{ all -> 0x0052 }
            if (r6 == 0) goto L_0x0038
            java.lang.String r6 = "Request for cacheKey=%s is in flight, putting on hold."
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x0052 }
            r1[r3] = r0     // Catch:{ all -> 0x0052 }
            com.google.android.gms.internal.ads.zzaq.m7524d(r6, r1)     // Catch:{ all -> 0x0052 }
        L_0x0038:
            monitor-exit(r5)
            return r2
        L_0x003a:
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzaa<?>>> r1 = r5.f9864a     // Catch:{ all -> 0x0052 }
            r4 = 0
            r1.put(r0, r4)     // Catch:{ all -> 0x0052 }
            r6.zza((com.google.android.gms.internal.ads.C2380s) r5)     // Catch:{ all -> 0x0052 }
            boolean r6 = com.google.android.gms.internal.ads.zzaq.DEBUG     // Catch:{ all -> 0x0052 }
            if (r6 == 0) goto L_0x0050
            java.lang.String r6 = "new request, sending to network %s"
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x0052 }
            r1[r3] = r0     // Catch:{ all -> 0x0052 }
            com.google.android.gms.internal.ads.zzaq.m7524d(r6, r1)     // Catch:{ all -> 0x0052 }
        L_0x0050:
            monitor-exit(r5)
            return r3
        L_0x0052:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.lg0.m6458d(com.google.android.gms.internal.ads.zzaa):boolean");
    }

    /* renamed from: a */
    public final void mo14403a(zzaa<?> zzaa, zzaj<?> zzaj) {
        List<zzaa> remove;
        zzn zzn = zzaj.zzbq;
        if (zzn == null || zzn.zza()) {
            mo14404b(zzaa);
            return;
        }
        String zze = zzaa.zze();
        synchronized (this) {
            remove = this.f9864a.remove(zze);
        }
        if (remove != null) {
            if (zzaq.DEBUG) {
                zzaq.m7526v("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), zze);
            }
            for (zzaa zzb : remove) {
                this.f9865b.f16722d.zzb(zzb, zzaj);
            }
        }
    }

    /* renamed from: b */
    public final synchronized void mo14404b(zzaa<?> zzaa) {
        String zze = zzaa.zze();
        List remove = this.f9864a.remove(zze);
        if (remove != null && !remove.isEmpty()) {
            if (zzaq.DEBUG) {
                zzaq.m7526v("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), zze);
            }
            zzaa zzaa2 = (zzaa) remove.remove(0);
            this.f9864a.put(zze, remove);
            zzaa2.zza((C2380s) this);
            try {
                this.f9865b.f16720b.put(zzaa2);
            } catch (InterruptedException e) {
                zzaq.m7525e("Couldn't add request to queue. %s", e.toString());
                Thread.currentThread().interrupt();
                this.f9865b.quit();
            }
        }
    }
}
