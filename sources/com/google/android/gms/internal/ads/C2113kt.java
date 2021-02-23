package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* renamed from: com.google.android.gms.internal.ads.kt */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2113kt implements zzdfj<Bundle> {

    /* renamed from: a */
    private final String f9775a;

    /* renamed from: b */
    private final String f9776b;

    /* renamed from: c */
    private final Bundle f9777c;

    private C2113kt(String str, String str2, Bundle bundle) {
        this.f9775a = str;
        this.f9776b = str2;
        this.f9777c = bundle;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("consent_string", this.f9775a);
        bundle.putString("fc_consent", this.f9776b);
        bundle.putBundle("iab_consent_info", this.f9777c);
    }
}
