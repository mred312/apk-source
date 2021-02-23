package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
public class zziq {

    /* renamed from: a */
    private volatile zzjh f17737a;

    /* renamed from: b */
    private volatile zzgr f17738b;

    static {
        zzhm.zza();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.measurement.zzjh m10396a(com.google.android.gms.internal.measurement.zzjh r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.measurement.zzjh r0 = r1.f17737a
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.measurement.zzjh r0 = r1.f17737a     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.f17737a = r2     // Catch:{ zzih -> 0x0012 }
            com.google.android.gms.internal.measurement.zzgr r0 = com.google.android.gms.internal.measurement.zzgr.zza     // Catch:{ zzih -> 0x0012 }
            r1.f17738b = r0     // Catch:{ zzih -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.f17737a = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.measurement.zzgr r2 = com.google.android.gms.internal.measurement.zzgr.zza     // Catch:{ all -> 0x001a }
            r1.f17738b = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.measurement.zzjh r2 = r1.f17737a
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zziq.m10396a(com.google.android.gms.internal.measurement.zzjh):com.google.android.gms.internal.measurement.zzjh");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zziq)) {
            return false;
        }
        zziq zziq = (zziq) obj;
        zzjh zzjh = this.f17737a;
        zzjh zzjh2 = zziq.f17737a;
        if (zzjh == null && zzjh2 == null) {
            return zzc().equals(zziq.zzc());
        }
        if (zzjh != null && zzjh2 != null) {
            return zzjh.equals(zzjh2);
        }
        if (zzjh != null) {
            return zzjh.equals(zziq.m10396a(zzjh.zzaa()));
        }
        return m10396a(zzjh2.zzaa()).equals(zzjh2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzjh zza(zzjh zzjh) {
        zzjh zzjh2 = this.f17737a;
        this.f17738b = null;
        this.f17737a = zzjh;
        return zzjh2;
    }

    public final int zzb() {
        if (this.f17738b != null) {
            return this.f17738b.zza();
        }
        if (this.f17737a != null) {
            return this.f17737a.zzbo();
        }
        return 0;
    }

    public final zzgr zzc() {
        if (this.f17738b != null) {
            return this.f17738b;
        }
        synchronized (this) {
            if (this.f17738b != null) {
                zzgr zzgr = this.f17738b;
                return zzgr;
            }
            if (this.f17737a == null) {
                this.f17738b = zzgr.zza;
            } else {
                this.f17738b = this.f17737a.zzbj();
            }
            zzgr zzgr2 = this.f17738b;
            return zzgr2;
        }
    }
}
