package com.google.android.gms.measurement.internal;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzmv;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.measurement.internal.b8 */
/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
final class C2949b8 {

    /* renamed from: a */
    private String f17969a;

    /* renamed from: b */
    private boolean f17970b;

    /* renamed from: c */
    private zzcd.zzi f17971c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public BitSet f17972d;

    /* renamed from: e */
    private BitSet f17973e;

    /* renamed from: f */
    private Map<Integer, Long> f17974f;

    /* renamed from: g */
    private Map<Integer, List<Long>> f17975g;

    /* renamed from: h */
    private final /* synthetic */ C2939a8 f17976h;

    private C2949b8(C2939a8 a8Var, String str) {
        this.f17976h = a8Var;
        this.f17969a = str;
        this.f17970b = true;
        this.f17972d = new BitSet();
        this.f17973e = new BitSet();
        this.f17974f = new ArrayMap();
        this.f17975g = new ArrayMap();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: a */
    public final zzcd.zza mo19829a(int i) {
        ArrayList arrayList;
        List list;
        zzcd.zza.C3998zza zzh = zzcd.zza.zzh();
        zzh.zza(i);
        zzh.zza(this.f17970b);
        zzcd.zzi zzi = this.f17971c;
        if (zzi != null) {
            zzh.zza(zzi);
        }
        zzcd.zzi.zza zza = zzcd.zzi.zzi().zzb((Iterable<? extends Long>) zzks.m10961l(this.f17972d)).zza((Iterable<? extends Long>) zzks.m10961l(this.f17973e));
        if (this.f17974f == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(this.f17974f.size());
            for (Integer intValue : this.f17974f.keySet()) {
                int intValue2 = intValue.intValue();
                arrayList.add((zzcd.zzb) ((zzhz) zzcd.zzb.zze().zza(intValue2).zza(this.f17974f.get(Integer.valueOf(intValue2)).longValue()).zzz()));
            }
        }
        zza.zzc(arrayList);
        if (this.f17975g == null) {
            list = Collections.emptyList();
        } else {
            ArrayList arrayList2 = new ArrayList(this.f17975g.size());
            for (Integer next : this.f17975g.keySet()) {
                zzcd.zzj.zza zza2 = zzcd.zzj.zze().zza(next.intValue());
                List list2 = this.f17975g.get(next);
                if (list2 != null) {
                    Collections.sort(list2);
                    zza2.zza((Iterable<? extends Long>) list2);
                }
                arrayList2.add((zzcd.zzj) ((zzhz) zza2.zzz()));
            }
            list = arrayList2;
        }
        zza.zzd(list);
        zzh.zza(zza);
        return (zzcd.zza) ((zzhz) zzh.zzz());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo19830c(@NonNull C2999g8 g8Var) {
        int a = g8Var.mo19891a();
        Boolean bool = g8Var.f18089c;
        if (bool != null) {
            this.f17973e.set(a, bool.booleanValue());
        }
        Boolean bool2 = g8Var.f18090d;
        if (bool2 != null) {
            this.f17972d.set(a, bool2.booleanValue());
        }
        if (g8Var.f18091e != null) {
            Long l = this.f17974f.get(Integer.valueOf(a));
            long longValue = g8Var.f18091e.longValue() / 1000;
            if (l == null || longValue > l.longValue()) {
                this.f17974f.put(Integer.valueOf(a), Long.valueOf(longValue));
            }
        }
        if (g8Var.f18092f != null) {
            List list = this.f17975g.get(Integer.valueOf(a));
            if (list == null) {
                list = new ArrayList();
                this.f17975g.put(Integer.valueOf(a), list);
            }
            if (g8Var.mo19892i()) {
                list.clear();
            }
            if (zzmv.zzb() && this.f17976h.zzs().zzd(this.f17969a, zzat.zzbb) && g8Var.mo19893j()) {
                list.clear();
            }
            if (!zzmv.zzb() || !this.f17976h.zzs().zzd(this.f17969a, zzat.zzbb)) {
                list.add(Long.valueOf(g8Var.f18092f.longValue() / 1000));
                return;
            }
            long longValue2 = g8Var.f18092f.longValue() / 1000;
            if (!list.contains(Long.valueOf(longValue2))) {
                list.add(Long.valueOf(longValue2));
            }
        }
    }

    private C2949b8(C2939a8 a8Var, String str, zzcd.zzi zzi, BitSet bitSet, BitSet bitSet2, Map<Integer, Long> map, Map<Integer, Long> map2) {
        this.f17976h = a8Var;
        this.f17969a = str;
        this.f17972d = bitSet;
        this.f17973e = bitSet2;
        this.f17974f = map;
        this.f17975g = new ArrayMap();
        if (map2 != null) {
            for (Integer next : map2.keySet()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(map2.get(next));
                this.f17975g.put(next, arrayList);
            }
        }
        this.f17970b = false;
        this.f17971c = zzi;
    }

    /* synthetic */ C2949b8(C2939a8 a8Var, String str, zzcd.zzi zzi, BitSet bitSet, BitSet bitSet2, Map map, Map map2, C2959c8 c8Var) {
        this(a8Var, str, zzi, bitSet, bitSet2, map, map2);
    }

    /* synthetic */ C2949b8(C2939a8 a8Var, String str, C2959c8 c8Var) {
        this(a8Var, str);
    }
}
