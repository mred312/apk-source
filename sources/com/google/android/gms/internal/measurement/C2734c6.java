package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.c6 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
abstract class C2734c6<T, B> {
    C2734c6() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract B mo18584a();

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract T mo18585b(B b);

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract void mo18586c(B b, int i, int i2);

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public abstract void mo18587d(B b, int i, long j);

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public abstract void mo18588e(B b, int i, zzgr zzgr);

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public abstract void mo18589f(B b, int i, T t);

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public abstract void mo18590g(T t, C2882u6 u6Var);

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public abstract void mo18591h(Object obj, T t);

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public abstract boolean mo18592i(C2809l5 l5Var);

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f A[LOOP:0: B:16:0x002f->B:19:0x003c, LOOP_START] */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo18593j(B r7, com.google.android.gms.internal.measurement.C2809l5 r8) {
        /*
            r6 = this;
            int r0 = r8.zzb()
            int r1 = r0 >>> 3
            r0 = r0 & 7
            r2 = 1
            if (r0 == 0) goto L_0x0061
            if (r0 == r2) goto L_0x0059
            r3 = 2
            if (r0 == r3) goto L_0x0051
            r3 = 4
            r4 = 3
            if (r0 == r4) goto L_0x0028
            if (r0 == r3) goto L_0x0026
            r3 = 5
            if (r0 != r3) goto L_0x0021
            int r8 = r8.zzj()
            r6.mo18586c(r7, r1, r8)
            return r2
        L_0x0021:
            com.google.android.gms.internal.measurement.zzik r7 = com.google.android.gms.internal.measurement.zzih.m10392f()
            throw r7
        L_0x0026:
            r7 = 0
            return r7
        L_0x0028:
            java.lang.Object r0 = r6.mo18584a()
            int r4 = r1 << 3
            r3 = r3 | r4
        L_0x002f:
            int r4 = r8.zza()
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x003e
            boolean r4 = r6.mo18593j(r0, r8)
            if (r4 != 0) goto L_0x002f
        L_0x003e:
            int r8 = r8.zzb()
            if (r3 != r8) goto L_0x004c
            java.lang.Object r8 = r6.mo18585b(r0)
            r6.mo18589f(r7, r1, r8)
            return r2
        L_0x004c:
            com.google.android.gms.internal.measurement.zzih r7 = com.google.android.gms.internal.measurement.zzih.m10391e()
            throw r7
        L_0x0051:
            com.google.android.gms.internal.measurement.zzgr r8 = r8.zzn()
            r6.mo18588e(r7, r1, r8)
            return r2
        L_0x0059:
            long r3 = r8.zzi()
            r6.mo18595l(r7, r1, r3)
            return r2
        L_0x0061:
            long r3 = r8.zzg()
            r6.mo18587d(r7, r1, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C2734c6.mo18593j(java.lang.Object, com.google.android.gms.internal.measurement.l5):boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public abstract T mo18594k(Object obj);

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public abstract void mo18595l(B b, int i, long j);

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public abstract void mo18596m(T t, C2882u6 u6Var);

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public abstract void mo18597n(Object obj, B b);

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public abstract B mo18598o(Object obj);

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public abstract T mo18599p(T t, T t2);

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public abstract void mo18600q(Object obj);

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public abstract int mo18601r(T t);

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public abstract int mo18602s(T t);
}
