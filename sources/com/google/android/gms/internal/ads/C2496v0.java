package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.v0 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2496v0 implements zzaih {

    /* renamed from: a */
    private final /* synthetic */ zzazq f11457a;

    C2496v0(zzaif zzaif, zzazq zzazq) {
        this.f11457a = zzazq;
    }

    public final void onFailure(@Nullable String str) {
        this.f11457a.setException(new zzama(str));
    }

    public final void zzc(JSONObject jSONObject) {
        this.f11457a.set(jSONObject);
    }
}
