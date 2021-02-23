package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class a90 implements hc0 {

    /* renamed from: a */
    private final zzejo f7798a;

    private a90(zzejo zzejo) {
        zzekk.m8825c(zzejo, "output");
        zzejo zzejo2 = zzejo;
        this.f7798a = zzejo2;
        zzejo2.f16205a = this;
    }

    /* renamed from: g */
    public static a90 m5763g(zzejo zzejo) {
        a90 a90 = zzejo.f16205a;
        if (a90 != null) {
            return a90;
        }
        return new a90(zzejo);
    }

    /* renamed from: A */
    public final void mo13543A(int i, long j) {
        this.f7798a.zzk(i, j);
    }

    /* renamed from: B */
    public final void mo13544B(int i, Object obj, wa0 wa0) {
        zzejo zzejo = this.f7798a;
        zzejo.writeTag(i, 3);
        wa0.mo14198k((zzels) obj, zzejo.f16205a);
        zzejo.writeTag(i, 4);
    }

    /* renamed from: C */
    public final <K, V> void mo13545C(int i, z90<K, V> z90, Map<K, V> map) {
        for (Map.Entry next : map.entrySet()) {
            this.f7798a.writeTag(i, 2);
            this.f7798a.zzgr(zzelk.m8839a(z90, next.getKey(), next.getValue()));
            zzelk.m8840b(this.f7798a, z90, next.getKey(), next.getValue());
        }
    }

    /* renamed from: D */
    public final void mo13546D(int i, long j) {
        this.f7798a.zzi(i, j);
    }

    /* renamed from: E */
    public final void mo13547E(int i, boolean z) {
        this.f7798a.zzh(i, z);
    }

    /* renamed from: F */
    public final void mo13548F(int i, Object obj, wa0 wa0) {
        this.f7798a.mo17611b(i, (zzels) obj, wa0);
    }

    /* renamed from: G */
    public final void mo13549G(int i, long j) {
        this.f7798a.zzi(i, j);
    }

    /* renamed from: H */
    public final void mo13550H(int i, long j) {
        this.f7798a.zzk(i, j);
    }

    /* renamed from: I */
    public final void mo13551I(int i, int i2) {
        this.f7798a.zzac(i, i2);
    }

    /* renamed from: J */
    public final void mo13552J(int i, int i2) {
        this.f7798a.zzae(i, i2);
    }

    /* renamed from: K */
    public final void mo13553K(int i) {
        this.f7798a.writeTag(i, 3);
    }

    /* renamed from: L */
    public final int mo13554L() {
        return zzeob.zziug;
    }

    /* renamed from: M */
    public final void mo13555M(int i, int i2) {
        this.f7798a.zzaf(i, i2);
    }

    /* renamed from: N */
    public final void mo13556N(int i) {
        this.f7798a.writeTag(i, 4);
    }

    /* renamed from: O */
    public final void mo13557O(int i, int i2) {
        this.f7798a.zzac(i, i2);
    }

    /* renamed from: P */
    public final void mo13558P(int i, zzeiu zzeiu) {
        this.f7798a.zza(i, zzeiu);
    }

    /* renamed from: Q */
    public final void mo13559Q(int i, int i2) {
        this.f7798a.zzaf(i, i2);
    }

    /* renamed from: R */
    public final void mo13560R(int i, int i2) {
        this.f7798a.zzad(i, i2);
    }

    /* renamed from: a */
    public final void mo13561a(int i, List<Boolean> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f7798a.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.zzbt(list.get(i4).booleanValue());
            }
            this.f7798a.zzgr(i3);
            while (i2 < list.size()) {
                this.f7798a.zzbs(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f7798a.zzh(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    /* renamed from: b */
    public final void mo13562b(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f7798a.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.zzgv(list.get(i4).intValue());
            }
            this.f7798a.zzgr(i3);
            while (i2 < list.size()) {
                this.f7798a.zzgq(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f7798a.zzac(i, list.get(i2).intValue());
            i2++;
        }
    }

    /* renamed from: c */
    public final void mo13563c(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f7798a.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.zzha(list.get(i4).intValue());
            }
            this.f7798a.zzgr(i3);
            while (i2 < list.size()) {
                this.f7798a.zzgq(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f7798a.zzac(i, list.get(i2).intValue());
            i2++;
        }
    }

    /* renamed from: d */
    public final void mo13564d(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f7798a.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.zzfk(list.get(i4).longValue());
            }
            this.f7798a.zzgr(i3);
            while (i2 < list.size()) {
                this.f7798a.zzfh(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f7798a.zzi(i, list.get(i2).longValue());
            i2++;
        }
    }

    /* renamed from: e */
    public final void mo13565e(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f7798a.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.zzfo(list.get(i4).longValue());
            }
            this.f7798a.zzgr(i3);
            while (i2 < list.size()) {
                this.f7798a.zzfj(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f7798a.zzk(i, list.get(i2).longValue());
            i2++;
        }
    }

    /* renamed from: f */
    public final void mo13566f(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f7798a.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.zzgy(list.get(i4).intValue());
            }
            this.f7798a.zzgr(i3);
            while (i2 < list.size()) {
                this.f7798a.zzgt(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f7798a.zzaf(i, list.get(i2).intValue());
            i2++;
        }
    }

    /* renamed from: h */
    public final void mo13567h(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f7798a.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.zzgw(list.get(i4).intValue());
            }
            this.f7798a.zzgr(i3);
            while (i2 < list.size()) {
                this.f7798a.zzgr(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f7798a.zzad(i, list.get(i2).intValue());
            i2++;
        }
    }

    /* renamed from: i */
    public final void mo13568i(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f7798a.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.zzgz(list.get(i4).intValue());
            }
            this.f7798a.zzgr(i3);
            while (i2 < list.size()) {
                this.f7798a.zzgt(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f7798a.zzaf(i, list.get(i2).intValue());
            i2++;
        }
    }

    /* renamed from: k */
    public final void mo13569k(int i, float f) {
        this.f7798a.zza(i, f);
    }

    /* renamed from: l */
    public final void mo13570l(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f7798a.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.zzfn(list.get(i4).longValue());
            }
            this.f7798a.zzgr(i3);
            while (i2 < list.size()) {
                this.f7798a.zzfj(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f7798a.zzk(i, list.get(i2).longValue());
            i2++;
        }
    }

    /* renamed from: m */
    public final void mo13571m(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f7798a.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.zzfm(list.get(i4).longValue());
            }
            this.f7798a.zzgr(i3);
            while (i2 < list.size()) {
                this.f7798a.zzfi(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f7798a.zzj(i, list.get(i2).longValue());
            i2++;
        }
    }

    /* renamed from: n */
    public final void mo13572n(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f7798a.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.zzfl(list.get(i4).longValue());
            }
            this.f7798a.zzgr(i3);
            while (i2 < list.size()) {
                this.f7798a.zzfh(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f7798a.zzi(i, list.get(i2).longValue());
            i2++;
        }
    }

    /* renamed from: o */
    public final void mo13573o(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f7798a.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.zzgx(list.get(i4).intValue());
            }
            this.f7798a.zzgr(i3);
            while (i2 < list.size()) {
                this.f7798a.zzgs(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f7798a.zzae(i, list.get(i2).intValue());
            i2++;
        }
    }

    /* renamed from: p */
    public final void mo13574p(int i, List<Double> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f7798a.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.zzd(list.get(i4).doubleValue());
            }
            this.f7798a.zzgr(i3);
            while (i2 < list.size()) {
                this.f7798a.zzc(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f7798a.zzb(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    /* renamed from: q */
    public final void mo13575q(int i, List<zzeiu> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f7798a.zza(i, list.get(i2));
        }
    }

    /* renamed from: s */
    public final void mo13576s(int i, List<Float> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f7798a.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.zzg(list.get(i4).floatValue());
            }
            this.f7798a.zzgr(i3);
            while (i2 < list.size()) {
                this.f7798a.zzf(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f7798a.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    /* renamed from: t */
    public final void mo13577t(int i, List<String> list) {
        int i2 = 0;
        if (list instanceof zzekz) {
            zzekz zzekz = (zzekz) list;
            while (i2 < list.size()) {
                Object zzhi = zzekz.zzhi(i2);
                if (zzhi instanceof String) {
                    this.f7798a.zzi(i, (String) zzhi);
                } else {
                    this.f7798a.zza(i, (zzeiu) zzhi);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f7798a.zzi(i, list.get(i2));
            i2++;
        }
    }

    /* renamed from: u */
    public final void mo13578u(int i, Object obj) {
        if (obj instanceof zzeiu) {
            this.f7798a.zzb(i, (zzeiu) obj);
        } else {
            this.f7798a.zza(i, (zzels) obj);
        }
    }

    /* renamed from: v */
    public final void mo13579v(int i, List<?> list, wa0 wa0) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            mo13548F(i, list.get(i2), wa0);
        }
    }

    /* renamed from: w */
    public final void mo13580w(int i, long j) {
        this.f7798a.zzj(i, j);
    }

    /* renamed from: x */
    public final void mo13581x(int i, double d) {
        this.f7798a.zzb(i, d);
    }

    /* renamed from: y */
    public final void mo13582y(int i, String str) {
        this.f7798a.zzi(i, str);
    }

    /* renamed from: z */
    public final void mo13583z(int i, List<?> list, wa0 wa0) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            mo13544B(i, list.get(i2), wa0);
        }
    }
}
