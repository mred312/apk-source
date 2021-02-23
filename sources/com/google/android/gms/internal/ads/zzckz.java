package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzckz {
    @GuardedBy("this")

    /* renamed from: a */
    private List<Map<String, String>> f14527a = new ArrayList();
    @GuardedBy("this")

    /* renamed from: b */
    private boolean f14528b = false;
    @GuardedBy("this")

    /* renamed from: c */
    private boolean f14529c = false;

    /* renamed from: d */
    private String f14530d;

    /* renamed from: e */
    private zzckv f14531e;

    public zzckz(String str, zzckv zzckv) {
        this.f14530d = str;
        this.f14531e = zzckv;
    }

    /* renamed from: a */
    private final Map<String, String> m8184a() {
        Map<String, String> zzaqh = this.f14531e.zzaqh();
        zzaqh.put("tms", Long.toString(zzp.zzkx().elapsedRealtime(), 10));
        zzaqh.put("tid", this.f14530d);
        return zzaqh;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzaqj() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcqp     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x002e }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x002e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x002e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x002e }
            if (r0 != 0) goto L_0x0015
            monitor-exit(r3)
            return
        L_0x0015:
            boolean r0 = r3.f14528b     // Catch:{ all -> 0x002e }
            if (r0 != 0) goto L_0x002c
            java.util.Map r0 = r3.m8184a()     // Catch:{ all -> 0x002e }
            java.lang.String r1 = "action"
            java.lang.String r2 = "init_started"
            r0.put(r1, r2)     // Catch:{ all -> 0x002e }
            java.util.List<java.util.Map<java.lang.String, java.lang.String>> r1 = r3.f14527a     // Catch:{ all -> 0x002e }
            r1.add(r0)     // Catch:{ all -> 0x002e }
            r0 = 1
            r3.f14528b = r0     // Catch:{ all -> 0x002e }
        L_0x002c:
            monitor-exit(r3)
            return
        L_0x002e:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzckz.zzaqj():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0045, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzaqk() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcqp     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x0046 }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x0046 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0046 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0046 }
            if (r0 != 0) goto L_0x0015
            monitor-exit(r3)
            return
        L_0x0015:
            boolean r0 = r3.f14529c     // Catch:{ all -> 0x0046 }
            if (r0 != 0) goto L_0x0044
            java.util.Map r0 = r3.m8184a()     // Catch:{ all -> 0x0046 }
            java.lang.String r1 = "action"
            java.lang.String r2 = "init_finished"
            r0.put(r1, r2)     // Catch:{ all -> 0x0046 }
            java.util.List<java.util.Map<java.lang.String, java.lang.String>> r1 = r3.f14527a     // Catch:{ all -> 0x0046 }
            r1.add(r0)     // Catch:{ all -> 0x0046 }
            java.util.List<java.util.Map<java.lang.String, java.lang.String>> r0 = r3.f14527a     // Catch:{ all -> 0x0046 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0046 }
        L_0x002f:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0046 }
            if (r1 == 0) goto L_0x0041
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0046 }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzckv r2 = r3.f14531e     // Catch:{ all -> 0x0046 }
            r2.zzo(r1)     // Catch:{ all -> 0x0046 }
            goto L_0x002f
        L_0x0041:
            r0 = 1
            r3.f14529c = r0     // Catch:{ all -> 0x0046 }
        L_0x0044:
            monitor-exit(r3)
            return
        L_0x0046:
            r0 = move-exception
            monitor-exit(r3)
            goto L_0x004a
        L_0x0049:
            throw r0
        L_0x004a:
            goto L_0x0049
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzckz.zzaqk():void");
    }

    public final synchronized void zzgf(String str) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcqp)).booleanValue()) {
            Map<String, String> a = m8184a();
            a.put("action", "adapter_init_started");
            a.put("ancn", str);
            this.f14527a.add(a);
        }
    }

    public final synchronized void zzgg(String str) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcqp)).booleanValue()) {
            Map<String, String> a = m8184a();
            a.put("action", "adapter_init_finished");
            a.put("ancn", str);
            this.f14527a.add(a);
        }
    }

    public final synchronized void zzs(String str, String str2) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcqp)).booleanValue()) {
            Map<String, String> a = m8184a();
            a.put("action", "adapter_init_finished");
            a.put("ancn", str);
            a.put("rqe", str2);
            this.f14527a.add(a);
        }
    }
}
