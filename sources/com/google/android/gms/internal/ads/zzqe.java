package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;

@TargetApi(16)
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzqe {

    /* renamed from: a */
    private final vg0 f16882a;

    /* renamed from: b */
    private final boolean f16883b;

    /* renamed from: c */
    private final long f16884c;

    /* renamed from: d */
    private final long f16885d;

    /* renamed from: e */
    private long f16886e;

    /* renamed from: f */
    private long f16887f;

    /* renamed from: g */
    private long f16888g;

    /* renamed from: h */
    private boolean f16889h;

    /* renamed from: i */
    private long f16890i;

    /* renamed from: j */
    private long f16891j;

    /* renamed from: k */
    private long f16892k;

    public zzqe() {
        this(-1.0d);
    }

    /* renamed from: a */
    private final boolean m9066a(long j, long j2) {
        return Math.abs((j2 - this.f16890i) - (j - this.f16891j)) > 20000000;
    }

    public final void disable() {
        if (this.f16883b) {
            this.f16882a.mo14938a();
        }
    }

    public final void enable() {
        this.f16889h = false;
        if (this.f16883b) {
            this.f16882a.mo14939c();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0086 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzf(long r12, long r14) {
        /*
            r11 = this;
            r0 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r12
            boolean r2 = r11.f16889h
            if (r2 == 0) goto L_0x0042
            long r2 = r11.f16886e
            int r4 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0019
            long r2 = r11.f16892k
            r4 = 1
            long r2 = r2 + r4
            r11.f16892k = r2
            long r2 = r11.f16888g
            r11.f16887f = r2
        L_0x0019:
            long r2 = r11.f16892k
            r4 = 6
            r6 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 < 0) goto L_0x003a
            long r4 = r11.f16891j
            long r4 = r0 - r4
            long r4 = r4 / r2
            long r2 = r11.f16887f
            long r2 = r2 + r4
            boolean r4 = r11.m9066a(r2, r14)
            if (r4 == 0) goto L_0x0033
            r11.f16889h = r6
            goto L_0x0042
        L_0x0033:
            long r4 = r11.f16890i
            long r4 = r4 + r2
            long r6 = r11.f16891j
            long r4 = r4 - r6
            goto L_0x0044
        L_0x003a:
            boolean r2 = r11.m9066a(r0, r14)
            if (r2 == 0) goto L_0x0042
            r11.f16889h = r6
        L_0x0042:
            r4 = r14
            r2 = r0
        L_0x0044:
            boolean r6 = r11.f16889h
            r7 = 0
            if (r6 != 0) goto L_0x0053
            r11.f16891j = r0
            r11.f16890i = r14
            r11.f16892k = r7
            r14 = 1
            r11.f16889h = r14
        L_0x0053:
            r11.f16886e = r12
            r11.f16888g = r2
            com.google.android.gms.internal.ads.vg0 r12 = r11.f16882a
            if (r12 == 0) goto L_0x0086
            long r12 = r12.f11613a
            int r14 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r14 != 0) goto L_0x0062
            goto L_0x0086
        L_0x0062:
            com.google.android.gms.internal.ads.vg0 r12 = r11.f16882a
            long r12 = r12.f11613a
            long r14 = r11.f16884c
            long r0 = r4 - r12
            long r0 = r0 / r14
            long r0 = r0 * r14
            long r12 = r12 + r0
            int r0 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r0 > 0) goto L_0x0075
            long r14 = r12 - r14
            goto L_0x0079
        L_0x0075:
            long r14 = r14 + r12
            r9 = r12
            r12 = r14
            r14 = r9
        L_0x0079:
            long r0 = r12 - r4
            long r4 = r4 - r14
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x0081
            goto L_0x0082
        L_0x0081:
            r12 = r14
        L_0x0082:
            long r14 = r11.f16885d
            long r12 = r12 - r14
            return r12
        L_0x0086:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqe.zzf(long, long):long");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzqe(android.content.Context r3) {
        /*
            r2 = this;
            java.lang.String r0 = "window"
            java.lang.Object r3 = r3.getSystemService(r0)
            android.view.WindowManager r3 = (android.view.WindowManager) r3
            android.view.Display r0 = r3.getDefaultDisplay()
            if (r0 == 0) goto L_0x0018
            android.view.Display r3 = r3.getDefaultDisplay()
            float r3 = r3.getRefreshRate()
            double r0 = (double) r3
            goto L_0x001a
        L_0x0018:
            r0 = -4616189618054758400(0xbff0000000000000, double:-1.0)
        L_0x001a:
            r2.<init>((double) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqe.<init>(android.content.Context):void");
    }

    private zzqe(double d) {
        boolean z = d != -1.0d;
        this.f16883b = z;
        if (z) {
            this.f16882a = vg0.m7096b();
            long j = (long) (1.0E9d / d);
            this.f16884c = j;
            this.f16885d = (j * 80) / 100;
            return;
        }
        this.f16882a = null;
        this.f16884c = -1;
        this.f16885d = -1;
    }
}
