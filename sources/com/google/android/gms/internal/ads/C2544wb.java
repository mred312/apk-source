package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.wb */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2544wb implements Runnable {

    /* renamed from: a */
    private final zzbdv f11694a;

    /* renamed from: b */
    private final JSONObject f11695b;

    C2544wb(zzbdv zzbdv, JSONObject jSONObject) {
        this.f11694a = zzbdv;
        this.f11695b = jSONObject;
    }

    public final void run() {
        this.f11694a.zza("AFMA_updateActiveView", this.f11695b);
    }
}
