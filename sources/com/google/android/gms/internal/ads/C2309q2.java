package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.q2 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2309q2 implements zzaih {

    /* renamed from: a */
    private final zzalo f10671a;

    /* renamed from: b */
    private final zzazq<O> f10672b;

    /* renamed from: c */
    private final /* synthetic */ zzamm f10673c;

    public C2309q2(zzamm zzamm, zzalo zzalo, zzazq<O> zzazq) {
        this.f10673c = zzamm;
        this.f10671a = zzalo;
        this.f10672b = zzazq;
    }

    public final void onFailure(@Nullable String str) {
        if (str == null) {
            try {
                this.f10672b.setException(new zzama());
            } catch (IllegalStateException unused) {
                this.f10671a.release();
                return;
            } catch (Throwable th) {
                this.f10671a.release();
                throw th;
            }
        } else {
            this.f10672b.setException(new zzama(str));
        }
        this.f10671a.release();
    }

    public final void zzc(JSONObject jSONObject) {
        try {
            this.f10672b.set(this.f10673c.f12528a.zzd(jSONObject));
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.f10672b.setException(e);
        } finally {
            this.f10671a.release();
        }
    }
}
