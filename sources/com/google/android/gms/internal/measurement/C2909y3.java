package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.y3 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2909y3<T extends zzhr<T>> {

    /* renamed from: d */
    private static final C2909y3 f17525d = new C2909y3(true);

    /* renamed from: a */
    final C2841p5<T, Object> f17526a;

    /* renamed from: b */
    private boolean f17527b;

    /* renamed from: c */
    private boolean f17528c;

    private C2909y3() {
        this.f17526a = C2841p5.m9704b(16);
    }

    /* renamed from: a */
    public static int m9937a(zzhr<?> zzhr, Object obj) {
        zzli zzb = zzhr.zzb();
        int zza = zzhr.zza();
        if (!zzhr.zzd()) {
            return m9938b(zzb, zza, obj);
        }
        int i = 0;
        if (zzhr.zze()) {
            for (Object j : (List) obj) {
                i += m9945j(zzb, j);
            }
            return zzhg.zze(zza) + i + zzhg.zzl(i);
        }
        for (Object b : (List) obj) {
            i += m9938b(zzb, zza, b);
        }
        return i;
    }

    /* renamed from: b */
    static int m9938b(zzli zzli, int i, Object obj) {
        int zze = zzhg.zze(i);
        if (zzli == zzli.GROUP) {
            zzic.m10386e((zzjh) obj);
            zze <<= 1;
        }
        return zze + m9945j(zzli, obj);
    }

    /* renamed from: c */
    public static <T extends zzhr<T>> C2909y3<T> m9939c() {
        return f17525d;
    }

    /* renamed from: d */
    private final Object m9940d(T t) {
        Object obj = this.f17526a.get(t);
        if (!(obj instanceof zzim)) {
            return obj;
        }
        zzim zzim = (zzim) obj;
        return zzim.zza();
    }

    /* renamed from: e */
    private static Object m9941e(Object obj) {
        if (obj instanceof zzjq) {
            return ((zzjq) obj).zza();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* renamed from: f */
    static void m9942f(zzhg zzhg, zzli zzli, int i, Object obj) {
        if (zzli == zzli.GROUP) {
            zzjh zzjh = (zzjh) obj;
            zzic.m10386e(zzjh);
            zzhg.zza(i, 3);
            zzjh.zza(zzhg);
            zzhg.zza(i, 4);
            return;
        }
        zzhg.zza(i, zzli.zzb());
        switch (C2716a4.f17216b[zzli.ordinal()]) {
            case 1:
                zzhg.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzhg.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzhg.zza(((Long) obj).longValue());
                return;
            case 4:
                zzhg.zza(((Long) obj).longValue());
                return;
            case 5:
                zzhg.zza(((Integer) obj).intValue());
                return;
            case 6:
                zzhg.zzc(((Long) obj).longValue());
                return;
            case 7:
                zzhg.zzd(((Integer) obj).intValue());
                return;
            case 8:
                zzhg.zza(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzjh) obj).zza(zzhg);
                return;
            case 10:
                zzhg.zza((zzjh) obj);
                return;
            case 11:
                if (obj instanceof zzgr) {
                    zzhg.zza((zzgr) obj);
                    return;
                } else {
                    zzhg.zza((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzgr) {
                    zzhg.zza((zzgr) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzhg.mo19471e(bArr, 0, bArr.length);
                return;
            case 13:
                zzhg.zzb(((Integer) obj).intValue());
                return;
            case 14:
                zzhg.zzd(((Integer) obj).intValue());
                return;
            case 15:
                zzhg.zzc(((Long) obj).longValue());
                return;
            case 16:
                zzhg.zzc(((Integer) obj).intValue());
                return;
            case 17:
                zzhg.zzb(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzib) {
                    zzhg.zza(((zzib) obj).zza());
                    return;
                } else {
                    zzhg.zza(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzib) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzim) == false) goto L_0x0014;
     */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m9943h(com.google.android.gms.internal.measurement.zzli r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.measurement.zzic.m10383b(r3)
            int[] r0 = com.google.android.gms.internal.measurement.C2716a4.f17215a
            com.google.android.gms.internal.measurement.zzll r2 = r2.zza()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L_0x0040;
                case 2: goto L_0x003d;
                case 3: goto L_0x003a;
                case 4: goto L_0x0037;
                case 5: goto L_0x0034;
                case 6: goto L_0x0031;
                case 7: goto L_0x0028;
                case 8: goto L_0x001f;
                case 9: goto L_0x0016;
                default: goto L_0x0014;
            }
        L_0x0014:
            r0 = 0
            goto L_0x0042
        L_0x0016:
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzjh
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzim
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x001f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzib
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzgr
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0031:
            boolean r0 = r3 instanceof java.lang.String
            goto L_0x0042
        L_0x0034:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L_0x0042
        L_0x0037:
            boolean r0 = r3 instanceof java.lang.Double
            goto L_0x0042
        L_0x003a:
            boolean r0 = r3 instanceof java.lang.Float
            goto L_0x0042
        L_0x003d:
            boolean r0 = r3 instanceof java.lang.Long
            goto L_0x0042
        L_0x0040:
            boolean r0 = r3 instanceof java.lang.Integer
        L_0x0042:
            if (r0 == 0) goto L_0x0045
            return
        L_0x0045:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            goto L_0x004e
        L_0x004d:
            throw r2
        L_0x004e:
            goto L_0x004d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C2909y3.m9943h(com.google.android.gms.internal.measurement.zzli, java.lang.Object):void");
    }

    /* renamed from: i */
    private static <T extends zzhr<T>> boolean m9944i(Map.Entry<T, Object> entry) {
        zzhr zzhr = (zzhr) entry.getKey();
        if (zzhr.zzc() == zzll.MESSAGE) {
            if (zzhr.zzd()) {
                for (zzjh i_ : (List) entry.getValue()) {
                    if (!i_.mo19516i_()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzjh) {
                    if (!((zzjh) value).mo19516i_()) {
                        return false;
                    }
                } else if (value instanceof zzim) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    /* renamed from: j */
    private static int m9945j(zzli zzli, Object obj) {
        switch (C2716a4.f17216b[zzli.ordinal()]) {
            case 1:
                return zzhg.zzb(((Double) obj).doubleValue());
            case 2:
                return zzhg.zzb(((Float) obj).floatValue());
            case 3:
                return zzhg.zzd(((Long) obj).longValue());
            case 4:
                return zzhg.zze(((Long) obj).longValue());
            case 5:
                return zzhg.zzf(((Integer) obj).intValue());
            case 6:
                return zzhg.zzg(((Long) obj).longValue());
            case 7:
                return zzhg.zzi(((Integer) obj).intValue());
            case 8:
                return zzhg.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzhg.zzc((zzjh) obj);
            case 10:
                if (obj instanceof zzim) {
                    return zzhg.zza((zziq) (zzim) obj);
                }
                return zzhg.zzb((zzjh) obj);
            case 11:
                if (obj instanceof zzgr) {
                    return zzhg.zzb((zzgr) obj);
                }
                return zzhg.zzb((String) obj);
            case 12:
                if (obj instanceof zzgr) {
                    return zzhg.zzb((zzgr) obj);
                }
                return zzhg.zzb((byte[]) obj);
            case 13:
                return zzhg.zzg(((Integer) obj).intValue());
            case 14:
                return zzhg.zzj(((Integer) obj).intValue());
            case 15:
                return zzhg.zzh(((Long) obj).longValue());
            case 16:
                return zzhg.zzh(((Integer) obj).intValue());
            case 17:
                return zzhg.zzf(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzib) {
                    return zzhg.zzk(((zzib) obj).zza());
                }
                return zzhg.zzk(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* renamed from: l */
    private final void m9946l(T t, Object obj) {
        if (!t.zzd()) {
            m9943h(t.zzb(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                m9943h(t.zzb(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzim) {
            this.f17528c = true;
        }
        this.f17526a.put(t, obj);
    }

    /* renamed from: m */
    private final void m9947m(Map.Entry<T, Object> entry) {
        Object obj;
        zzhr zzhr = (zzhr) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzim) {
            zzim zzim = (zzim) value;
            value = zzim.zza();
        }
        if (zzhr.zzd()) {
            Object d = m9940d(zzhr);
            if (d == null) {
                d = new ArrayList();
            }
            for (Object e : (List) value) {
                ((List) d).add(m9941e(e));
            }
            this.f17526a.put(zzhr, d);
        } else if (zzhr.zzc() == zzll.MESSAGE) {
            Object d2 = m9940d(zzhr);
            if (d2 == null) {
                this.f17526a.put(zzhr, m9941e(value));
                return;
            }
            if (d2 instanceof zzjq) {
                obj = zzhr.zza((zzjq) d2, (zzjq) value);
            } else {
                obj = zzhr.zza(((zzjh) d2).zzbs(), (zzjh) value).zzz();
            }
            this.f17526a.put(zzhr, obj);
        } else {
            this.f17526a.put(zzhr, m9941e(value));
        }
    }

    /* renamed from: n */
    private static int m9948n(Map.Entry<T, Object> entry) {
        zzhr zzhr = (zzhr) entry.getKey();
        Object value = entry.getValue();
        if (zzhr.zzc() != zzll.MESSAGE || zzhr.zzd() || zzhr.zze()) {
            return m9937a(zzhr, value);
        }
        if (value instanceof zzim) {
            return zzhg.zzb(((zzhr) entry.getKey()).zza(), (zziq) (zzim) value);
        }
        return zzhg.zzb(((zzhr) entry.getKey()).zza(), (zzjh) value);
    }

    public final /* synthetic */ Object clone() {
        C2909y3 y3Var = new C2909y3();
        for (int i = 0; i < this.f17526a.mo18804j(); i++) {
            Map.Entry<T, Object> h = this.f17526a.mo18801h(i);
            y3Var.m9946l((zzhr) h.getKey(), h.getValue());
        }
        for (Map.Entry next : this.f17526a.mo18805m()) {
            y3Var.m9946l((zzhr) next.getKey(), next.getValue());
        }
        y3Var.f17528c = this.f17528c;
        return y3Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2909y3)) {
            return false;
        }
        return this.f17526a.equals(((C2909y3) obj).f17526a);
    }

    /* renamed from: g */
    public final void mo18984g(C2909y3<T> y3Var) {
        for (int i = 0; i < y3Var.f17526a.mo18804j(); i++) {
            m9947m(y3Var.f17526a.mo18801h(i));
        }
        for (Map.Entry<T, Object> m : y3Var.f17526a.mo18805m()) {
            m9947m(m);
        }
    }

    public final int hashCode() {
        return this.f17526a.hashCode();
    }

    /* renamed from: k */
    public final void mo18986k() {
        if (!this.f17527b) {
            this.f17526a.mo18786e();
            this.f17527b = true;
        }
    }

    /* renamed from: o */
    public final boolean mo18987o() {
        return this.f17527b;
    }

    /* renamed from: p */
    public final Iterator<Map.Entry<T, Object>> mo18988p() {
        if (this.f17528c) {
            return new C2784i4(this.f17526a.entrySet().iterator());
        }
        return this.f17526a.entrySet().iterator();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public final Iterator<Map.Entry<T, Object>> mo18989q() {
        if (this.f17528c) {
            return new C2784i4(this.f17526a.mo18806o().iterator());
        }
        return this.f17526a.mo18806o().iterator();
    }

    /* renamed from: r */
    public final boolean mo18990r() {
        for (int i = 0; i < this.f17526a.mo18804j(); i++) {
            if (!m9944i(this.f17526a.mo18801h(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> i2 : this.f17526a.mo18805m()) {
            if (!m9944i(i2)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: s */
    public final int mo18991s() {
        int i = 0;
        for (int i2 = 0; i2 < this.f17526a.mo18804j(); i2++) {
            i += m9948n(this.f17526a.mo18801h(i2));
        }
        for (Map.Entry<T, Object> n : this.f17526a.mo18805m()) {
            i += m9948n(n);
        }
        return i;
    }

    private C2909y3(boolean z) {
        this(C2841p5.m9704b(0));
        mo18986k();
    }

    private C2909y3(C2841p5<T, Object> p5Var) {
        this.f17526a = p5Var;
        mo18986k();
    }
}
