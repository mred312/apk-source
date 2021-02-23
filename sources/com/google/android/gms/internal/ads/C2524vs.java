package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.ads.vs */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2524vs implements zzdfj {

    /* renamed from: a */
    private final ArrayList f11640a;

    C2524vs(ArrayList arrayList) {
        this.f11640a = arrayList;
    }

    public final void zzs(Object obj) {
        ((Bundle) obj).putStringArrayList("android_permissions", this.f11640a);
    }
}
