package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzqr {

    /* renamed from: a */
    private final String f16911a;

    /* renamed from: b */
    private final JSONObject f16912b;

    /* renamed from: c */
    private final String f16913c;

    /* renamed from: d */
    private final String f16914d;

    /* renamed from: e */
    private final boolean f16915e;

    public zzqr(String str, zzazh zzazh, String str2, JSONObject jSONObject, boolean z, boolean z2) {
        this.f16914d = zzazh.zzbrf;
        this.f16912b = jSONObject;
        this.f16913c = str;
        this.f16911a = str2;
        this.f16915e = z2;
    }

    public final String getUniqueId() {
        return this.f16913c;
    }

    public final boolean isNative() {
        return this.f16915e;
    }

    public final String zzlu() {
        return this.f16911a;
    }

    public final String zzlv() {
        return this.f16914d;
    }

    public final JSONObject zzlw() {
        return this.f16912b;
    }
}
