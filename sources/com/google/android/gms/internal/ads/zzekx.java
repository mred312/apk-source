package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public class zzekx {

    /* renamed from: a */
    private volatile zzels f16274a;

    /* renamed from: b */
    private volatile zzeiu f16275b;

    static {
        zzeju.zzbhe();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.ads.zzels m8837a(com.google.android.gms.internal.ads.zzels r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.ads.zzels r0 = r1.f16274a
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzels r0 = r1.f16274a     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.f16274a = r2     // Catch:{ zzeks -> 0x0012 }
            com.google.android.gms.internal.ads.zzeiu r0 = com.google.android.gms.internal.ads.zzeiu.zziiy     // Catch:{ zzeks -> 0x0012 }
            r1.f16275b = r0     // Catch:{ zzeks -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.f16274a = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.ads.zzeiu r2 = com.google.android.gms.internal.ads.zzeiu.zziiy     // Catch:{ all -> 0x001a }
            r1.f16275b = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.ads.zzels r2 = r1.f16274a
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzekx.m8837a(com.google.android.gms.internal.ads.zzels):com.google.android.gms.internal.ads.zzels");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzekx)) {
            return false;
        }
        zzekx zzekx = (zzekx) obj;
        zzels zzels = this.f16274a;
        zzels zzels2 = zzekx.f16274a;
        if (zzels == null && zzels2 == null) {
            return zzbfg().equals(zzekx.zzbfg());
        }
        if (zzels != null && zzels2 != null) {
            return zzels.equals(zzels2);
        }
        if (zzels != null) {
            return zzels.equals(zzekx.m8837a(zzels.zzbhw()));
        }
        return m8837a(zzels2.zzbhw()).equals(zzels2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzeiu zzbfg() {
        if (this.f16275b != null) {
            return this.f16275b;
        }
        synchronized (this) {
            if (this.f16275b != null) {
                zzeiu zzeiu = this.f16275b;
                return zzeiu;
            }
            if (this.f16274a == null) {
                this.f16275b = zzeiu.zziiy;
            } else {
                this.f16275b = this.f16274a.zzbfg();
            }
            zzeiu zzeiu2 = this.f16275b;
            return zzeiu2;
        }
    }

    public final int zzbhz() {
        if (this.f16275b != null) {
            return this.f16275b.size();
        }
        if (this.f16274a != null) {
            return this.f16274a.zzbhz();
        }
        return 0;
    }

    public final zzels zzn(zzels zzels) {
        zzels zzels2 = this.f16274a;
        this.f16275b = null;
        this.f16274a = zzels;
        return zzels2;
    }
}
