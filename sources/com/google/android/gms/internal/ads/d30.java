package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class d30<V> extends b30<V, List<V>> {
    d30(zzdwl<? extends zzdyz<? extends V>> zzdwl, boolean z) {
        super(zzdwl, true);
        mo14998H();
    }

    /* renamed from: M */
    public final /* synthetic */ Object mo13628M(List list) {
        ArrayList zzes = zzdwu.zzes(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            c30 c30 = (c30) it.next();
            zzes.add(c30 != null ? c30.f7960a : null);
        }
        return Collections.unmodifiableList(zzes);
    }
}
