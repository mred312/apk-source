package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class e90<T extends zzejz<T>> {

    /* renamed from: d */
    private static final e90 f8326d = new e90(true);

    /* renamed from: a */
    final bb0<T, Object> f8327a;

    /* renamed from: b */
    private boolean f8328b;

    /* renamed from: c */
    private boolean f8329c;

    private e90() {
        this.f8327a = bb0.m5846o(16);
    }

    /* renamed from: e */
    static int m6013e(zzenw zzenw, int i, Object obj) {
        int zzgu = zzejo.zzgu(i);
        if (zzenw == zzenw.GROUP) {
            zzekk.m8827e((zzels) obj);
            zzgu <<= 1;
        }
        return zzgu + m6020m(zzenw, obj);
    }

    /* renamed from: f */
    private final Object m6014f(T t) {
        Object obj = this.f8327a.get(t);
        if (!(obj instanceof zzekt)) {
            return obj;
        }
        zzekt zzekt = (zzekt) obj;
        return zzekt.zzbir();
    }

    /* renamed from: g */
    static void m6015g(zzejo zzejo, zzenw zzenw, int i, Object obj) {
        if (zzenw == zzenw.GROUP) {
            zzels zzels = (zzels) obj;
            zzekk.m8827e(zzels);
            zzejo.writeTag(i, 3);
            zzels.zzb(zzejo);
            zzejo.writeTag(i, 4);
            return;
        }
        zzejo.writeTag(i, zzenw.zzbkq());
        switch (g90.f8528b[zzenw.ordinal()]) {
            case 1:
                zzejo.zzc(((Double) obj).doubleValue());
                return;
            case 2:
                zzejo.zzf(((Float) obj).floatValue());
                return;
            case 3:
                zzejo.zzfh(((Long) obj).longValue());
                return;
            case 4:
                zzejo.zzfh(((Long) obj).longValue());
                return;
            case 5:
                zzejo.zzgq(((Integer) obj).intValue());
                return;
            case 6:
                zzejo.zzfj(((Long) obj).longValue());
                return;
            case 7:
                zzejo.zzgt(((Integer) obj).intValue());
                return;
            case 8:
                zzejo.zzbs(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzels) obj).zzb(zzejo);
                return;
            case 10:
                zzejo.zzg((zzels) obj);
                return;
            case 11:
                if (obj instanceof zzeiu) {
                    zzejo.zzai((zzeiu) obj);
                    return;
                } else {
                    zzejo.zzht((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzeiu) {
                    zzejo.zzai((zzeiu) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzejo.mo17613i(bArr, 0, bArr.length);
                return;
            case 13:
                zzejo.zzgr(((Integer) obj).intValue());
                return;
            case 14:
                zzejo.zzgt(((Integer) obj).intValue());
                return;
            case 15:
                zzejo.zzfj(((Long) obj).longValue());
                return;
            case 16:
                zzejo.zzgs(((Integer) obj).intValue());
                return;
            case 17:
                zzejo.zzfi(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzekj) {
                    zzejo.zzgq(((zzekj) obj).zzv());
                    return;
                } else {
                    zzejo.zzgq(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    /* renamed from: i */
    private final void m6016i(T t, Object obj) {
        if (!t.zzbhn()) {
            m6017j(t.zzbhl(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                m6017j(t.zzbhl(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzekt) {
            this.f8329c = true;
        }
        this.f8327a.put(t, obj);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if ((r3 instanceof com.google.android.gms.internal.ads.zzekj) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        if ((r3 instanceof com.google.android.gms.internal.ads.zzekt) == false) goto L_0x0014;
     */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m6017j(com.google.android.gms.internal.ads.zzenw r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.ads.zzekk.m8823a(r3)
            int[] r0 = com.google.android.gms.internal.ads.g90.f8527a
            com.google.android.gms.internal.ads.zzenz r2 = r2.zzbkp()
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
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzels
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzekt
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x001f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzekj
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzeiu
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.e90.m6017j(com.google.android.gms.internal.ads.zzenw, java.lang.Object):void");
    }

    /* renamed from: k */
    private static Object m6018k(Object obj) {
        if (obj instanceof zzelx) {
            return ((zzelx) obj).zzbfi();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* renamed from: l */
    public static int m6019l(zzejz<?> zzejz, Object obj) {
        zzenw zzbhl = zzejz.zzbhl();
        int zzv = zzejz.zzv();
        if (!zzejz.zzbhn()) {
            return m6013e(zzbhl, zzv, obj);
        }
        int i = 0;
        if (zzejz.zzbho()) {
            for (Object m : (List) obj) {
                i += m6020m(zzbhl, m);
            }
            return zzejo.zzgu(zzv) + i + zzejo.zzhc(i);
        }
        for (Object e : (List) obj) {
            i += m6013e(zzbhl, zzv, e);
        }
        return i;
    }

    /* renamed from: m */
    private static int m6020m(zzenw zzenw, Object obj) {
        switch (g90.f8528b[zzenw.ordinal()]) {
            case 1:
                return zzejo.zzd(((Double) obj).doubleValue());
            case 2:
                return zzejo.zzg(((Float) obj).floatValue());
            case 3:
                return zzejo.zzfk(((Long) obj).longValue());
            case 4:
                return zzejo.zzfl(((Long) obj).longValue());
            case 5:
                return zzejo.zzgv(((Integer) obj).intValue());
            case 6:
                return zzejo.zzfn(((Long) obj).longValue());
            case 7:
                return zzejo.zzgy(((Integer) obj).intValue());
            case 8:
                return zzejo.zzbt(((Boolean) obj).booleanValue());
            case 9:
                return zzejo.zzi((zzels) obj);
            case 10:
                if (obj instanceof zzekt) {
                    return zzejo.zza((zzekt) obj);
                }
                return zzejo.zzh((zzels) obj);
            case 11:
                if (obj instanceof zzeiu) {
                    return zzejo.zzaj((zzeiu) obj);
                }
                return zzejo.zzhu((String) obj);
            case 12:
                if (obj instanceof zzeiu) {
                    return zzejo.zzaj((zzeiu) obj);
                }
                return zzejo.zzw((byte[]) obj);
            case 13:
                return zzejo.zzgw(((Integer) obj).intValue());
            case 14:
                return zzejo.zzgz(((Integer) obj).intValue());
            case 15:
                return zzejo.zzfo(((Long) obj).longValue());
            case 16:
                return zzejo.zzgx(((Integer) obj).intValue());
            case 17:
                return zzejo.zzfm(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzekj) {
                    return zzejo.zzha(((zzekj) obj).zzv());
                }
                return zzejo.zzha(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* renamed from: n */
    private static <T extends zzejz<T>> boolean m6021n(Map.Entry<T, Object> entry) {
        zzejz zzejz = (zzejz) entry.getKey();
        if (zzejz.zzbhm() == zzenz.MESSAGE) {
            if (zzejz.zzbhn()) {
                for (zzels isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzels) {
                    if (!((zzels) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzekt) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    /* renamed from: p */
    public static <T extends zzejz<T>> e90<T> m6022p() {
        return f8326d;
    }

    /* renamed from: r */
    private final void m6023r(Map.Entry<T, Object> entry) {
        Object obj;
        zzejz zzejz = (zzejz) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzekt) {
            zzekt zzekt = (zzekt) value;
            value = zzekt.zzbir();
        }
        if (zzejz.zzbhn()) {
            Object f = m6014f(zzejz);
            if (f == null) {
                f = new ArrayList();
            }
            for (Object k : (List) value) {
                ((List) f).add(m6018k(k));
            }
            this.f8327a.put(zzejz, f);
        } else if (zzejz.zzbhm() == zzenz.MESSAGE) {
            Object f2 = m6014f(zzejz);
            if (f2 == null) {
                this.f8327a.put(zzejz, m6018k(value));
                return;
            }
            if (f2 instanceof zzelx) {
                obj = zzejz.zza((zzelx) f2, (zzelx) value);
            } else {
                obj = zzejz.zza(((zzels) f2).zzbid(), (zzels) value).zzbhv();
            }
            this.f8327a.put(zzejz, obj);
        } else {
            this.f8327a.put(zzejz, m6018k(value));
        }
    }

    /* renamed from: s */
    private static int m6024s(Map.Entry<T, Object> entry) {
        zzejz zzejz = (zzejz) entry.getKey();
        Object value = entry.getValue();
        if (zzejz.zzbhm() != zzenz.MESSAGE || zzejz.zzbhn() || zzejz.zzbho()) {
            return m6019l(zzejz, value);
        }
        if (value instanceof zzekt) {
            return zzejo.zzb(((zzejz) entry.getKey()).zzv(), (zzekx) (zzekt) value);
        }
        return zzejo.zzb(((zzejz) entry.getKey()).zzv(), (zzels) value);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Iterator<Map.Entry<T, Object>> mo13876a() {
        if (this.f8329c) {
            return new p90(this.f8327a.mo13666j().iterator());
        }
        return this.f8327a.mo13666j().iterator();
    }

    /* renamed from: b */
    public final boolean mo13877b() {
        return this.f8328b;
    }

    /* renamed from: c */
    public final boolean mo13878c() {
        for (int i = 0; i < this.f8327a.mo13663h(); i++) {
            if (!m6021n(this.f8327a.mo13667p(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> n : this.f8327a.mo13665i()) {
            if (!m6021n(n)) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object clone() {
        e90 e90 = new e90();
        for (int i = 0; i < this.f8327a.mo13663h(); i++) {
            Map.Entry<T, Object> p = this.f8327a.mo13667p(i);
            e90.m6016i((zzejz) p.getKey(), p.getValue());
        }
        for (Map.Entry next : this.f8327a.mo13665i()) {
            e90.m6016i((zzejz) next.getKey(), next.getValue());
        }
        e90.f8329c = this.f8329c;
        return e90;
    }

    /* renamed from: d */
    public final Iterator<Map.Entry<T, Object>> mo13880d() {
        if (this.f8329c) {
            return new p90(this.f8327a.entrySet().iterator());
        }
        return this.f8327a.entrySet().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e90)) {
            return false;
        }
        return this.f8327a.equals(((e90) obj).f8327a);
    }

    /* renamed from: h */
    public final void mo13882h(e90<T> e90) {
        for (int i = 0; i < e90.f8327a.mo13663h(); i++) {
            m6023r(e90.f8327a.mo13667p(i));
        }
        for (Map.Entry<T, Object> r : e90.f8327a.mo13665i()) {
            m6023r(r);
        }
    }

    public final int hashCode() {
        return this.f8327a.hashCode();
    }

    /* renamed from: o */
    public final void mo13884o() {
        if (!this.f8328b) {
            this.f8327a.mo13596g();
            this.f8328b = true;
        }
    }

    /* renamed from: q */
    public final int mo13885q() {
        int i = 0;
        for (int i2 = 0; i2 < this.f8327a.mo13663h(); i2++) {
            i += m6024s(this.f8327a.mo13667p(i2));
        }
        for (Map.Entry<T, Object> s : this.f8327a.mo13665i()) {
            i += m6024s(s);
        }
        return i;
    }

    private e90(boolean z) {
        this(bb0.m5846o(0));
        mo13884o();
    }

    private e90(bb0<T, Object> bb0) {
        this.f8327a = bb0;
        mo13884o();
    }
}
