package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzctn implements zzcto<zzcbt> {

    /* renamed from: a */
    private final zzcat f14836a;

    /* renamed from: b */
    private final zzdzc f14837b;

    /* renamed from: c */
    private final zzceo f14838c;

    /* renamed from: d */
    private final zzdod<zzcgh> f14839d;

    public zzctn(zzcat zzcat, zzdzc zzdzc, zzceo zzceo, zzdod<zzcgh> zzdod) {
        this.f14836a = zzcat;
        this.f14837b = zzdzc;
        this.f14838c = zzceo;
        this.f14839d = zzdod;
    }

    /* renamed from: e */
    private final zzdyz<zzcbt> m8265e(zzdnj zzdnj, zzdmu zzdmu, JSONObject jSONObject) {
        zzdyz<zzcgh> zzaux = this.f14839d.zzaux();
        zzdyz<zzcce> zza = this.f14838c.zza(zzdnj, zzdmu, jSONObject);
        return zzdyr.zzb((zzdyz<? extends V>[]) new zzdyz[]{zzaux, zza}).zza(new C2183mp(this, zza, zzaux, zzdnj, zzdmu, jSONObject), this.f14837b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzcbt mo16997a(zzdyz zzdyz, zzdyz zzdyz2, zzdnj zzdnj, zzdmu zzdmu, JSONObject jSONObject) {
        zzcce zzcce = (zzcce) zzdyz.get();
        zzcgh zzcgh = (zzcgh) zzdyz2.get();
        zzccg zza = this.f14836a.zza(new zzbos(zzdnj, zzdmu, (String) null), new zzccq(zzcce), new zzcbh(jSONObject, zzcgh));
        zza.zzafy().zzaov();
        zza.zzafz().zzb(zzcgh);
        zza.zzaga().zzl(zzcce.zzanh());
        return zza.zzafx();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ zzdyz mo16998b(zzcgh zzcgh, JSONObject jSONObject) {
        this.f14839d.zzd(zzdyr.zzag(zzcgh));
        if (jSONObject.optBoolean(FirebaseAnalytics.Param.SUCCESS)) {
            return zzdyr.zzag(jSONObject.getJSONObject("json").getJSONArray("ads"));
        }
        throw new zzama("process json failed");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ zzdyz mo16999c(zzdmu zzdmu, zzcgh zzcgh) {
        JSONObject zza = zzbk.zza("isNonagon", (Object) Boolean.TRUE);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("response", zzdmu.zzhgx.zzgao);
        jSONObject.put("sdk_params", zza);
        return zzdyr.zzb(zzcgh.zzc("google.afma.nativeAds.preProcessJson", jSONObject), new C2146lp(this, zzcgh), (Executor) this.f14837b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ zzdyz mo17000d(zzdnj zzdnj, zzdmu zzdmu, JSONArray jSONArray) {
        if (jSONArray.length() == 0) {
            return zzdyr.immediateFailedFuture(new zzcme(zzdok.NO_FILL));
        }
        if (zzdnj.zzhij.zzfvl.zzgwz <= 1) {
            return zzdyr.zzb(m8265e(zzdnj, zzdmu, jSONArray.getJSONObject(0)), C2109kp.f9773a, (Executor) this.f14837b);
        }
        int length = jSONArray.length();
        this.f14839d.ensureSize(Math.min(length, zzdnj.zzhij.zzfvl.zzgwz));
        ArrayList arrayList = new ArrayList(zzdnj.zzhij.zzfvl.zzgwz);
        for (int i = 0; i < zzdnj.zzhij.zzfvl.zzgwz; i++) {
            if (i < length) {
                arrayList.add(m8265e(zzdnj, zzdmu, jSONArray.getJSONObject(i)));
            } else {
                arrayList.add(zzdyr.immediateFailedFuture(new zzcme(zzdok.NO_FILL)));
            }
        }
        return zzdyr.zzag(arrayList);
    }

    public final boolean zza(zzdnj zzdnj, zzdmu zzdmu) {
        zzdnb zzdnb = zzdmu.zzhgx;
        return (zzdnb == null || zzdnb.zzgao == null) ? false : true;
    }

    public final zzdyz<List<zzdyz<zzcbt>>> zzb(zzdnj zzdnj, zzdmu zzdmu) {
        return zzdyr.zzb(zzdyr.zzb(this.f14839d.zzaux(), new C2072jp(this, zzdmu), (Executor) this.f14837b), new C2035ip(this, zzdnj, zzdmu), (Executor) this.f14837b);
    }
}
