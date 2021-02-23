package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzddt implements zzdfj<Bundle> {

    /* renamed from: a */
    private final String f15465a;

    public zzddt(String str) {
        this.f15465a = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static boolean m8352a(Set<String> set) {
        return set.contains("rewarded") || set.contains("interstitial") || set.contains("native") || set.contains("banner");
    }

    public final /* synthetic */ void zzs(Object obj) {
        zzdnx.zza((Bundle) obj, "omid_v", this.f15465a);
    }
}
