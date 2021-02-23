package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzabj {

    /* renamed from: a */
    private String f12358a;

    /* renamed from: b */
    private Map<String, String> f12359b;

    /* renamed from: c */
    private Context f12360c = null;

    /* renamed from: d */
    private String f12361d = null;

    public zzabj(Context context, String str) {
        String str2;
        this.f12360c = context;
        this.f12361d = str;
        this.f12358a = zzacu.zzdbq.get();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f12359b = linkedHashMap;
        linkedHashMap.put("s", "gmob_sdk");
        this.f12359b.put("v", "3");
        this.f12359b.put("os", Build.VERSION.RELEASE);
        this.f12359b.put("api_v", Build.VERSION.SDK);
        Map<String, String> map = this.f12359b;
        zzp.zzkq();
        map.put("device", zzm.zzyg());
        Map<String, String> map2 = this.f12359b;
        if (context.getApplicationContext() != null) {
            str2 = context.getApplicationContext().getPackageName();
        } else {
            str2 = context.getPackageName();
        }
        map2.put("app", str2);
        Map<String, String> map3 = this.f12359b;
        zzp.zzkq();
        map3.put("is_lite_sdk", zzm.zzaw(context) ? "1" : "0");
        Future<zzatq> zzr = zzp.zzlb().zzr(this.f12360c);
        try {
            this.f12359b.put("network_coarse", Integer.toString(zzr.get().zzdwr));
            this.f12359b.put("network_fine", Integer.toString(zzr.get().zzdws));
        } catch (Exception e) {
            zzp.zzku().zza(e, "CsiConfiguration.CsiConfiguration");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Context mo15171a() {
        return this.f12360c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final String mo15172b() {
        return this.f12361d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final String mo15173c() {
        return this.f12358a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final Map<String, String> mo15174d() {
        return this.f12359b;
    }
}
