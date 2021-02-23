package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.w2 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2535w2 implements zzaih {

    /* renamed from: a */
    private final zzazq<O> f11655a;

    /* renamed from: b */
    private final /* synthetic */ zzamx f11656b;

    public C2535w2(zzamx zzamx, zzazq<O> zzazq) {
        this.f11656b = zzamx;
        this.f11655a = zzazq;
    }

    public final void onFailure(@Nullable String str) {
        if (str == null) {
            try {
                this.f11655a.setException(new zzama());
            } catch (IllegalStateException unused) {
            }
        } else {
            this.f11655a.setException(new zzama(str));
        }
    }

    public final void zzc(JSONObject jSONObject) {
        try {
            this.f11655a.set(this.f11656b.f12534a.zzd(jSONObject));
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.f11655a.setException(e);
        }
    }
}
