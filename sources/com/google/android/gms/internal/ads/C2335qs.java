package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.ads.qs */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2335qs implements zzdfj {

    /* renamed from: a */
    private final ArrayList f10737a;

    C2335qs(ArrayList arrayList) {
        this.f10737a = arrayList;
    }

    public final void zzs(Object obj) {
        ((Bundle) obj).putStringArrayList("ad_types", this.f10737a);
    }
}
