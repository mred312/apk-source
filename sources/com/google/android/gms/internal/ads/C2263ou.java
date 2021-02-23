package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ads.ou */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2263ou implements Callable {

    /* renamed from: a */
    private final List f10403a;

    /* renamed from: b */
    private final Object f10404b;

    C2263ou(List list, Object obj) {
        this.f10403a = list;
        this.f10404b = obj;
    }

    public final Object call() {
        List<zzdyz> list = this.f10403a;
        Object obj = this.f10404b;
        for (zzdyz zzdyz : list) {
            zzdfj zzdfj = (zzdfj) zzdyz.get();
            if (zzdfj != null) {
                zzdfj.zzs(obj);
            }
        }
        return obj;
    }
}
