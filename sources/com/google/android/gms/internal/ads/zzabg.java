package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzabg {
    /* renamed from: a */
    private static void m7425a(List<String> list, zzacn<String> zzacn) {
        String str = zzacn.get();
        if (!TextUtils.isEmpty(str)) {
            list.add(str);
        }
    }

    /* renamed from: b */
    static List<String> m7426b() {
        ArrayList arrayList = new ArrayList();
        m7425a(arrayList, zzacn.zzi("gad:dynamite_module:experiment_id", ""));
        m7425a(arrayList, zzacz.zzdch);
        m7425a(arrayList, zzacz.zzdci);
        m7425a(arrayList, zzacz.zzdcj);
        m7425a(arrayList, zzacz.zzdck);
        m7425a(arrayList, zzacz.zzdcl);
        m7425a(arrayList, zzacz.zzdcr);
        m7425a(arrayList, zzacz.zzdcm);
        m7425a(arrayList, zzacz.zzdcn);
        m7425a(arrayList, zzacz.zzdco);
        m7425a(arrayList, zzacz.zzdcp);
        m7425a(arrayList, zzacz.zzdcq);
        return arrayList;
    }

    /* renamed from: c */
    static List<String> m7427c() {
        ArrayList arrayList = new ArrayList();
        m7425a(arrayList, zzadi.zzddm);
        return arrayList;
    }
}
