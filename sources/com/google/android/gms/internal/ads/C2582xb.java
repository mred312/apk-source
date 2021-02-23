package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.xb */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2582xb implements Runnable {

    /* renamed from: a */
    private final zzbkr f11880a;

    /* renamed from: b */
    private final JSONObject f11881b;

    C2582xb(zzbkr zzbkr, JSONObject jSONObject) {
        this.f11880a = zzbkr;
        this.f11881b = jSONObject;
    }

    public final void run() {
        this.f11880a.mo16334b(this.f11881b);
    }
}
