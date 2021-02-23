package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzat {

    /* renamed from: e */
    private static final Comparator<byte[]> f12798e = new C2237o4();

    /* renamed from: a */
    private final List<byte[]> f12799a = new ArrayList();

    /* renamed from: b */
    private final List<byte[]> f12800b = new ArrayList(64);

    /* renamed from: c */
    private int f12801c = 0;

    /* renamed from: d */
    private final int f12802d = 4096;

    public zzat(int i) {
    }

    /* renamed from: a */
    private final synchronized void m7547a() {
        while (this.f12801c > this.f12802d) {
            byte[] remove = this.f12799a.remove(0);
            this.f12800b.remove(remove);
            this.f12801c -= remove.length;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(byte[] r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 == 0) goto L_0x002e
            int r0 = r3.length     // Catch:{ all -> 0x002b }
            int r1 = r2.f12802d     // Catch:{ all -> 0x002b }
            if (r0 <= r1) goto L_0x0009
            goto L_0x002e
        L_0x0009:
            java.util.List<byte[]> r0 = r2.f12799a     // Catch:{ all -> 0x002b }
            r0.add(r3)     // Catch:{ all -> 0x002b }
            java.util.List<byte[]> r0 = r2.f12800b     // Catch:{ all -> 0x002b }
            java.util.Comparator<byte[]> r1 = f12798e     // Catch:{ all -> 0x002b }
            int r0 = java.util.Collections.binarySearch(r0, r3, r1)     // Catch:{ all -> 0x002b }
            if (r0 >= 0) goto L_0x001b
            int r0 = -r0
            int r0 = r0 + -1
        L_0x001b:
            java.util.List<byte[]> r1 = r2.f12800b     // Catch:{ all -> 0x002b }
            r1.add(r0, r3)     // Catch:{ all -> 0x002b }
            int r0 = r2.f12801c     // Catch:{ all -> 0x002b }
            int r3 = r3.length     // Catch:{ all -> 0x002b }
            int r0 = r0 + r3
            r2.f12801c = r0     // Catch:{ all -> 0x002b }
            r2.m7547a()     // Catch:{ all -> 0x002b }
            monitor-exit(r2)
            return
        L_0x002b:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        L_0x002e:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzat.zza(byte[]):void");
    }

    public final synchronized byte[] zzf(int i) {
        for (int i2 = 0; i2 < this.f12800b.size(); i2++) {
            byte[] bArr = this.f12800b.get(i2);
            if (bArr.length >= i) {
                this.f12801c -= bArr.length;
                this.f12800b.remove(i2);
                this.f12799a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }
}
