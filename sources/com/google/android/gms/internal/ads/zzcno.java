package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.io.StringReader;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcno {

    /* renamed from: a */
    private final Context f14640a;

    /* renamed from: b */
    private final zzazh f14641b;

    /* renamed from: c */
    private final zzdnn f14642c;

    /* renamed from: d */
    private final Executor f14643d;

    public zzcno(Context context, zzazh zzazh, zzdnn zzdnn, Executor executor) {
        this.f14640a = context;
        this.f14641b = zzazh;
        this.f14642c = zzdnn;
        this.f14643d = executor;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzdyz mo16932a(JSONObject jSONObject) {
        return zzdyr.zzag(new zzdnj(new zzdne(this.f14642c), zzdnh.zza(new StringReader(jSONObject.toString()))));
    }

    public final zzdyz<zzdnj> zzaqz() {
        zzaml zzb = zzp.zzld().zzb(this.f14640a, this.f14641b);
        zzamh<JSONObject> zzamh = zzamg.zzdjy;
        zzamd<I, O> zza = zzb.zza("google.afma.response.normalize", zzamh, zzamh);
        return zzdyr.zzb(zzdyr.zzb(zzdyr.zzb(zzdyr.zzag(""), new C1736am(this, this.f14642c.zzhio.zzchn), this.f14643d), new C1810cm(zza), this.f14643d), new C1773bm(this), this.f14643d);
    }
}
