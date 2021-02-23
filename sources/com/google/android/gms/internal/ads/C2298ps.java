package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.ads.ps */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2298ps implements zzdfi<zzdfj<Bundle>> {

    /* renamed from: a */
    private final Set<String> f10650a;

    C2298ps(Set<String> set) {
        this.f10650a = set;
    }

    public final zzdyz<zzdfj<Bundle>> zzasm() {
        ArrayList arrayList = new ArrayList();
        for (String add : this.f10650a) {
            arrayList.add(add);
        }
        return zzdyr.zzag(new C2335qs(arrayList));
    }
}
