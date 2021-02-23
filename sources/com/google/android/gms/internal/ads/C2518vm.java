package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.vm */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2518vm implements Callable {

    /* renamed from: a */
    private final zzdyz f11630a;

    /* renamed from: b */
    private final zzdyz f11631b;

    C2518vm(zzdyz zzdyz, zzdyz zzdyz2) {
        this.f11630a = zzdyz;
        this.f11631b = zzdyz2;
    }

    public final Object call() {
        return new zzcpm((JSONObject) this.f11630a.get(), (zzatr) this.f11631b.get());
    }
}
