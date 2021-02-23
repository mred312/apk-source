package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.du */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C1855du implements Callable {

    /* renamed from: a */
    private final List f8290a;

    C1855du(List list) {
        this.f8290a = list;
    }

    public final Object call() {
        List<zzdyz> list = this.f8290a;
        JSONArray jSONArray = new JSONArray();
        for (zzdyz zzdyz : list) {
            if (((JSONObject) zzdyz.get()) != null) {
                jSONArray.put(zzdyz.get());
            }
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return new zzdel(jSONArray.toString());
    }
}
