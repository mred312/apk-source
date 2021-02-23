package com.google.android.gms.internal.ads;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class md0 {

    /* renamed from: a */
    public final zzmy f9937a;

    /* renamed from: b */
    public final Object f9938b;

    /* renamed from: c */
    public final int f9939c;

    /* renamed from: d */
    public final zznn[] f9940d;

    /* renamed from: e */
    private final boolean[] f9941e;

    /* renamed from: f */
    public final long f9942f;

    /* renamed from: g */
    public int f9943g;

    /* renamed from: h */
    public long f9944h;

    /* renamed from: i */
    public boolean f9945i;

    /* renamed from: j */
    public boolean f9946j;

    /* renamed from: k */
    public boolean f9947k;

    /* renamed from: l */
    public md0 f9948l;

    /* renamed from: m */
    public zzoj f9949m;

    /* renamed from: n */
    private final zzhy[] f9950n;

    /* renamed from: o */
    private final zzhx[] f9951o;

    /* renamed from: p */
    private final zzoh f9952p;

    /* renamed from: q */
    private final zzht f9953q;

    /* renamed from: r */
    private final zzna f9954r;

    /* renamed from: s */
    private zzoj f9955s;

    public md0(zzhy[] zzhyArr, zzhx[] zzhxArr, long j, zzoh zzoh, zzht zzht, zzna zzna, Object obj, int i, int i2, boolean z, long j2) {
        this.f9950n = zzhyArr;
        this.f9951o = zzhxArr;
        this.f9942f = j;
        this.f9952p = zzoh;
        this.f9953q = zzht;
        this.f9954r = zzna;
        this.f9938b = zzpc.checkNotNull(obj);
        this.f9939c = i;
        this.f9943g = i2;
        this.f9945i = z;
        this.f9944h = j2;
        this.f9940d = new zznn[zzhyArr.length];
        this.f9941e = new boolean[zzhyArr.length];
        this.f9937a = zzna.zza(i2, zzht.zzfd());
    }

    /* renamed from: a */
    public final void mo14431a() {
        try {
            this.f9954r.zzb(this.f9937a);
        } catch (RuntimeException e) {
            Log.e("ExoPlayerImplInternal", "Period release failed.", e);
        }
    }

    /* renamed from: b */
    public final long mo14432b(long j, boolean z, boolean[] zArr) {
        zzoe zzoe = this.f9949m.zzbhv;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= zzoe.length) {
                break;
            }
            boolean[] zArr2 = this.f9941e;
            if (z || !this.f9949m.zza(this.f9955s, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        long zza = this.f9937a.zza(zzoe.zzim(), this.f9941e, this.f9940d, zArr, j);
        this.f9955s = this.f9949m;
        this.f9947k = false;
        int i2 = 0;
        while (true) {
            zznn[] zznnArr = this.f9940d;
            if (i2 < zznnArr.length) {
                if (zznnArr[i2] != null) {
                    zzpc.checkState(zzoe.zzbe(i2) != null);
                    this.f9947k = true;
                } else {
                    zzpc.checkState(zzoe.zzbe(i2) == null);
                }
                i2++;
            } else {
                this.f9953q.zza(this.f9950n, this.f9949m.zzbhu, zzoe);
                return zza;
            }
        }
    }

    /* renamed from: c */
    public final long mo14433c(long j, boolean z) {
        return mo14432b(j, false, new boolean[this.f9950n.length]);
    }

    /* renamed from: d */
    public final void mo14434d(int i, boolean z) {
        this.f9943g = i;
        this.f9945i = z;
    }

    /* renamed from: e */
    public final long mo14435e() {
        return this.f9942f - this.f9944h;
    }

    /* renamed from: f */
    public final boolean mo14436f() {
        if (this.f9946j) {
            return !this.f9947k || this.f9937a.zzhr() == Long.MIN_VALUE;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo14437g() {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzoh r0 = r6.f9952p
            com.google.android.gms.internal.ads.zzhx[] r1 = r6.f9951o
            com.google.android.gms.internal.ads.zzmy r2 = r6.f9937a
            com.google.android.gms.internal.ads.zznq r2 = r2.zzho()
            com.google.android.gms.internal.ads.zzoj r0 = r0.zza(r1, r2)
            com.google.android.gms.internal.ads.zzoj r1 = r6.f9955s
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0016
        L_0x0014:
            r1 = 0
            goto L_0x0028
        L_0x0016:
            r4 = 0
        L_0x0017:
            com.google.android.gms.internal.ads.zzoe r5 = r0.zzbhv
            int r5 = r5.length
            if (r4 >= r5) goto L_0x0027
            boolean r5 = r0.zza(r1, r4)
            if (r5 != 0) goto L_0x0024
            goto L_0x0014
        L_0x0024:
            int r4 = r4 + 1
            goto L_0x0017
        L_0x0027:
            r1 = 1
        L_0x0028:
            if (r1 == 0) goto L_0x002b
            return r3
        L_0x002b:
            r6.f9949m = r0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.md0.mo14437g():boolean");
    }
}
