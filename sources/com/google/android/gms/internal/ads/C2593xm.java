package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.xm */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2593xm implements Callable {

    /* renamed from: a */
    private final zzdyz f11948a;

    /* renamed from: b */
    private final zzdyz f11949b;

    /* renamed from: c */
    private final zzdyz f11950c;

    C2593xm(zzdyz zzdyz, zzdyz zzdyz2, zzdyz zzdyz3) {
        this.f11948a = zzdyz;
        this.f11949b = zzdyz2;
        this.f11950c = zzdyz3;
    }

    public final Object call() {
        return new zzcpi((zzcpl) this.f11948a.get(), (JSONObject) this.f11949b.get(), (zzatr) this.f11950c.get());
    }
}
