package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.u3 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2879u3 implements C2882u6 {

    /* renamed from: a */
    private final zzhg f17482a;

    private C2879u3(zzhg zzhg) {
        zzic.m10385d(zzhg, "output");
        zzhg zzhg2 = zzhg;
        this.f17482a = zzhg2;
        zzhg2.f17666a = this;
    }

    /* renamed from: I */
    public static C2879u3 m9799I(zzhg zzhg) {
        C2879u3 u3Var = zzhg.f17666a;
        if (u3Var != null) {
            return u3Var;
        }
        return new C2879u3(zzhg);
    }

    /* renamed from: A */
    public final void mo18875A(int i, Object obj, C2793j5 j5Var) {
        this.f17482a.mo19469b(i, (zzjh) obj, j5Var);
    }

    /* renamed from: B */
    public final void mo18876B(int i, zzgr zzgr) {
        this.f17482a.zza(i, zzgr);
    }

    /* renamed from: C */
    public final void mo18877C(int i, int i2) {
        this.f17482a.zzd(i, i2);
    }

    /* renamed from: D */
    public final void mo18878D(int i, List<?> list, C2793j5 j5Var) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            mo18903u(i, list.get(i2), j5Var);
        }
    }

    /* renamed from: E */
    public final <K, V> void mo18879E(int i, C2864s4<K, V> s4Var, Map<K, V> map) {
        for (Map.Entry next : map.entrySet()) {
            this.f17482a.zza(i, 2);
            this.f17482a.zzb(zziz.m10397a(s4Var, next.getKey(), next.getValue()));
            zziz.m10398b(this.f17482a, s4Var, next.getKey(), next.getValue());
        }
    }

    /* renamed from: F */
    public final void mo18880F(int i, int i2) {
        this.f17482a.zze(i, i2);
    }

    /* renamed from: G */
    public final void mo18881G(int i, int i2) {
        this.f17482a.zzc(i, i2);
    }

    /* renamed from: H */
    public final void mo18882H(int i, long j) {
        this.f17482a.zzb(i, j);
    }

    /* renamed from: a */
    public final void mo18883a(int i, List<Boolean> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f17482a.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhg.zzb(list.get(i4).booleanValue());
            }
            this.f17482a.zzb(i3);
            while (i2 < list.size()) {
                this.f17482a.zza(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f17482a.zza(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    /* renamed from: b */
    public final void mo18884b(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f17482a.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhg.zzf(list.get(i4).intValue());
            }
            this.f17482a.zzb(i3);
            while (i2 < list.size()) {
                this.f17482a.zza(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f17482a.zzb(i, list.get(i2).intValue());
            i2++;
        }
    }

    /* renamed from: c */
    public final void mo18885c(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f17482a.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhg.zzk(list.get(i4).intValue());
            }
            this.f17482a.zzb(i3);
            while (i2 < list.size()) {
                this.f17482a.zza(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f17482a.zzb(i, list.get(i2).intValue());
            i2++;
        }
    }

    /* renamed from: d */
    public final void mo18886d(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f17482a.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhg.zzd(list.get(i4).longValue());
            }
            this.f17482a.zzb(i3);
            while (i2 < list.size()) {
                this.f17482a.zza(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f17482a.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    /* renamed from: e */
    public final void mo18887e(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f17482a.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhg.zzh(list.get(i4).longValue());
            }
            this.f17482a.zzb(i3);
            while (i2 < list.size()) {
                this.f17482a.zzc(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f17482a.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    /* renamed from: f */
    public final void mo18888f(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f17482a.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhg.zzi(list.get(i4).intValue());
            }
            this.f17482a.zzb(i3);
            while (i2 < list.size()) {
                this.f17482a.zzd(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f17482a.zze(i, list.get(i2).intValue());
            i2++;
        }
    }

    /* renamed from: g */
    public final void mo18889g(int i, String str) {
        this.f17482a.zza(i, str);
    }

    /* renamed from: h */
    public final void mo18890h(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f17482a.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhg.zzg(list.get(i4).intValue());
            }
            this.f17482a.zzb(i3);
            while (i2 < list.size()) {
                this.f17482a.zzb(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f17482a.zzc(i, list.get(i2).intValue());
            i2++;
        }
    }

    /* renamed from: i */
    public final void mo18891i(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f17482a.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhg.zzj(list.get(i4).intValue());
            }
            this.f17482a.zzb(i3);
            while (i2 < list.size()) {
                this.f17482a.zzd(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f17482a.zze(i, list.get(i2).intValue());
            i2++;
        }
    }

    /* renamed from: j */
    public final void mo18892j(int i, double d) {
        this.f17482a.zza(i, d);
    }

    /* renamed from: k */
    public final void mo18893k(int i, float f) {
        this.f17482a.zza(i, f);
    }

    /* renamed from: l */
    public final void mo18894l(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f17482a.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhg.zzg(list.get(i4).longValue());
            }
            this.f17482a.zzb(i3);
            while (i2 < list.size()) {
                this.f17482a.zzc(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f17482a.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    /* renamed from: m */
    public final void mo18895m(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f17482a.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhg.zzf(list.get(i4).longValue());
            }
            this.f17482a.zzb(i3);
            while (i2 < list.size()) {
                this.f17482a.zzb(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f17482a.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }

    /* renamed from: n */
    public final void mo18896n(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f17482a.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhg.zze(list.get(i4).longValue());
            }
            this.f17482a.zzb(i3);
            while (i2 < list.size()) {
                this.f17482a.zza(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f17482a.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    /* renamed from: o */
    public final void mo18897o(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f17482a.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhg.zzh(list.get(i4).intValue());
            }
            this.f17482a.zzb(i3);
            while (i2 < list.size()) {
                this.f17482a.zzc(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f17482a.zzd(i, list.get(i2).intValue());
            i2++;
        }
    }

    /* renamed from: p */
    public final void mo18898p(int i, List<Double> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f17482a.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhg.zzb(list.get(i4).doubleValue());
            }
            this.f17482a.zzb(i3);
            while (i2 < list.size()) {
                this.f17482a.zza(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f17482a.zza(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    /* renamed from: q */
    public final void mo18899q(int i, List<zzgr> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f17482a.zza(i, list.get(i2));
        }
    }

    /* renamed from: r */
    public final void mo18900r(int i, long j) {
        this.f17482a.zzc(i, j);
    }

    /* renamed from: s */
    public final void mo18901s(int i, List<Float> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f17482a.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhg.zzb(list.get(i4).floatValue());
            }
            this.f17482a.zzb(i3);
            while (i2 < list.size()) {
                this.f17482a.zza(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f17482a.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    /* renamed from: t */
    public final void mo18902t(int i, List<String> list) {
        int i2 = 0;
        if (list instanceof zzis) {
            zzis zzis = (zzis) list;
            while (i2 < list.size()) {
                Object zzb = zzis.zzb(i2);
                if (zzb instanceof String) {
                    this.f17482a.zza(i, (String) zzb);
                } else {
                    this.f17482a.zza(i, (zzgr) zzb);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f17482a.zza(i, list.get(i2));
            i2++;
        }
    }

    /* renamed from: u */
    public final void mo18903u(int i, Object obj, C2793j5 j5Var) {
        zzhg zzhg = this.f17482a;
        zzhg.zza(i, 3);
        j5Var.mo18546f((zzjh) obj, zzhg.f17666a);
        zzhg.zza(i, 4);
    }

    /* renamed from: v */
    public final void mo18904v(int i, boolean z) {
        this.f17482a.zza(i, z);
    }

    /* renamed from: w */
    public final void mo18905w(int i, long j) {
        this.f17482a.zzc(i, j);
    }

    /* renamed from: x */
    public final void mo18906x(int i, int i2) {
        this.f17482a.zzb(i, i2);
    }

    /* renamed from: y */
    public final void mo18907y(int i, long j) {
        this.f17482a.zza(i, j);
    }

    /* renamed from: z */
    public final void mo18908z(int i, List<?> list, C2793j5 j5Var) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            mo18875A(i, list.get(i2), j5Var);
        }
    }

    public final int zza() {
        return zzln.zza;
    }

    public final void zzb(int i) {
        this.f17482a.zza(i, 4);
    }

    public final void zzc(int i, int i2) {
        this.f17482a.zzb(i, i2);
    }

    public final void zza(int i, int i2) {
        this.f17482a.zze(i, i2);
    }

    public final void zza(int i, long j) {
        this.f17482a.zza(i, j);
    }

    public final void zza(int i) {
        this.f17482a.zza(i, 3);
    }

    public final void zza(int i, Object obj) {
        if (obj instanceof zzgr) {
            this.f17482a.zzb(i, (zzgr) obj);
        } else {
            this.f17482a.zza(i, (zzjh) obj);
        }
    }
}
