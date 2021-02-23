package com.google.android.gms.internal.ads;

import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzamx<I, O> implements zzdyb<I, O> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzamf<O> f12534a;

    /* renamed from: b */
    private final zzame<I> f12535b;

    /* renamed from: c */
    private final String f12536c;

    /* renamed from: d */
    private final zzdyz<zzalz> f12537d;

    zzamx(zzdyz<zzalz> zzdyz, String str, zzame<I> zzame, zzamf<O> zzamf) {
        this.f12537d = zzdyz;
        this.f12536c = str;
        this.f12535b = zzame;
        this.f12534a = zzamf;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ zzdyz mo15432b(Object obj, zzalz zzalz) {
        zzazq zzazq = new zzazq();
        zzp.zzkq();
        String zzyf = zzm.zzyf();
        zzahc.zzdgi.zza(zzyf, (zzaih) new C2535w2(this, zzazq));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(FacebookAdapter.KEY_ID, zzyf);
        jSONObject.put("args", this.f12535b.zzj(obj));
        zzalz.zza(this.f12536c, jSONObject);
        return zzazq;
    }

    public final zzdyz<O> zzf(I i) {
        return zzdyr.zzb(this.f12537d, new C2498v2(this, i), (Executor) zzazj.zzegu);
    }
}
