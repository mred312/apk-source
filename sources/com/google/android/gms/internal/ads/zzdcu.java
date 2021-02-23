package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdcu implements zzdfj<Bundle> {

    /* renamed from: a */
    private final String f15431a;

    /* renamed from: b */
    private final boolean f15432b;

    public zzdcu(String str, boolean z) {
        this.f15431a = str;
        this.f15432b = z;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("gct", this.f15431a);
        if (this.f15432b) {
            bundle.putString("de", "1");
        }
    }
}
