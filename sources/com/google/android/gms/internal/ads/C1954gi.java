package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.gi */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C1954gi implements Callable {

    /* renamed from: a */
    private final zzdyz f8776a;

    /* renamed from: b */
    private final zzdyz f8777b;

    /* renamed from: c */
    private final zzdyz f8778c;

    /* renamed from: d */
    private final zzdyz f8779d;

    /* renamed from: e */
    private final zzdyz f8780e;

    /* renamed from: f */
    private final JSONObject f8781f;

    /* renamed from: g */
    private final zzdyz f8782g;

    /* renamed from: h */
    private final zzdyz f8783h;

    /* renamed from: i */
    private final zzdyz f8784i;

    C1954gi(zzceo zzceo, zzdyz zzdyz, zzdyz zzdyz2, zzdyz zzdyz3, zzdyz zzdyz4, zzdyz zzdyz5, JSONObject jSONObject, zzdyz zzdyz6, zzdyz zzdyz7, zzdyz zzdyz8) {
        this.f8776a = zzdyz;
        this.f8777b = zzdyz2;
        this.f8778c = zzdyz3;
        this.f8779d = zzdyz4;
        this.f8780e = zzdyz5;
        this.f8781f = jSONObject;
        this.f8782g = zzdyz6;
        this.f8783h = zzdyz7;
        this.f8784i = zzdyz8;
    }

    public final Object call() {
        zzdyz zzdyz = this.f8776a;
        zzdyz zzdyz2 = this.f8777b;
        zzdyz zzdyz3 = this.f8778c;
        zzdyz zzdyz4 = this.f8779d;
        zzdyz zzdyz5 = this.f8780e;
        JSONObject jSONObject = this.f8781f;
        zzdyz zzdyz6 = this.f8782g;
        zzdyz zzdyz7 = this.f8783h;
        zzdyz zzdyz8 = this.f8784i;
        zzcce zzcce = (zzcce) zzdyz.get();
        zzcce.setImages((List) zzdyz2.get());
        zzcce.zza((zzaej) zzdyz3.get());
        zzcce.zzb((zzaej) zzdyz4.get());
        zzcce.zza((zzaeb) zzdyz5.get());
        zzcce.zzh(zzces.zzj(jSONObject));
        zzcce.zza(zzces.zzk(jSONObject));
        zzbdv zzbdv = (zzbdv) zzdyz6.get();
        if (zzbdv != null) {
            zzcce.zzi(zzbdv);
            zzcce.zzac(zzbdv.getView());
            zzcce.zzb((zzys) zzbdv.zzaah());
        }
        zzbdv zzbdv2 = (zzbdv) zzdyz7.get();
        if (zzbdv2 != null) {
            zzcce.zzj(zzbdv2);
        }
        for (zzcfd zzcfd : (List) zzdyz8.get()) {
            int i = zzcfd.type;
            if (i == 1) {
                zzcce.zzn(zzcfd.zzck, zzcfd.zzdpv);
            } else if (i == 2) {
                zzcce.zza(zzcfd.zzck, zzcfd.zzggw);
            }
        }
        return zzcce;
    }
}
