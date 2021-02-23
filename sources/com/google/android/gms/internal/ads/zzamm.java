package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzamm<I, O> implements zzamd<I, O> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzamf<O> f12528a;

    /* renamed from: b */
    private final zzame<I> f12529b;

    /* renamed from: c */
    private final zzalb f12530c;

    /* renamed from: d */
    private final String f12531d;

    zzamm(zzalb zzalb, String str, zzame<I> zzame, zzamf<O> zzamf) {
        this.f12530c = zzalb;
        this.f12531d = str;
        this.f12529b = zzame;
        this.f12528a = zzamf;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m7497b(zzalo zzalo, zzalz zzalz, I i, zzazq<O> zzazq) {
        try {
            zzp.zzkq();
            String zzyf = zzm.zzyf();
            zzahc.zzdgi.zza(zzyf, (zzaih) new C2309q2(this, zzalo, zzazq));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(FacebookAdapter.KEY_ID, zzyf);
            jSONObject.put("args", this.f12529b.zzj(i));
            zzalz.zza(this.f12531d, jSONObject);
        } catch (Exception e) {
            zzazq.setException(e);
            zzaza.zzc("Unable to invokeJavascript", e);
            zzalo.release();
        } catch (Throwable th) {
            zzalo.release();
            throw th;
        }
    }

    public final zzdyz<O> zzf(@Nullable I i) {
        return zzi(i);
    }

    public final zzdyz<O> zzi(I i) {
        zzazq zzazq = new zzazq();
        zzalo zzb = this.f12530c.zzb((zzef) null);
        zzb.zza(new C2272p2(this, zzb, i, zzazq), new C2234o2(this, zzazq, zzb));
        return zzazq;
    }
}
