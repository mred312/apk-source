package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.mp */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2183mp implements Callable {

    /* renamed from: a */
    private final zzctn f10001a;

    /* renamed from: b */
    private final zzdyz f10002b;

    /* renamed from: c */
    private final zzdyz f10003c;

    /* renamed from: d */
    private final zzdnj f10004d;

    /* renamed from: e */
    private final zzdmu f10005e;

    /* renamed from: f */
    private final JSONObject f10006f;

    C2183mp(zzctn zzctn, zzdyz zzdyz, zzdyz zzdyz2, zzdnj zzdnj, zzdmu zzdmu, JSONObject jSONObject) {
        this.f10001a = zzctn;
        this.f10002b = zzdyz;
        this.f10003c = zzdyz2;
        this.f10004d = zzdnj;
        this.f10005e = zzdmu;
        this.f10006f = jSONObject;
    }

    public final Object call() {
        return this.f10001a.mo16997a(this.f10002b, this.f10003c, this.f10004d, this.f10005e, this.f10006f);
    }
}
