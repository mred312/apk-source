package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzckv extends zzcky {

    /* renamed from: d */
    private final Context f14518d;

    /* renamed from: e */
    private final String f14519e;

    /* renamed from: f */
    private final String f14520f;

    public zzckv(Executor executor, zzaze zzaze, Context context, zzazh zzazh) {
        super(executor, zzaze);
        this.f14518d = context;
        this.f14519e = context.getPackageName();
        this.f14520f = zzazh.zzbrf;
        zzaqi();
    }

    public final Map<String, String> zzaqh() {
        return new HashMap(this.zzgki);
    }

    /* access modifiers changed from: protected */
    public final void zzaqi() {
        this.zzgki.put("s", "gmob_sdk");
        this.zzgki.put("v", "3");
        this.zzgki.put("os", Build.VERSION.RELEASE);
        this.zzgki.put("api_v", Build.VERSION.SDK);
        Map<String, String> map = this.zzgki;
        zzp.zzkq();
        map.put("device", zzm.zzyg());
        this.zzgki.put("app", this.f14519e);
        Map<String, String> map2 = this.zzgki;
        zzp.zzkq();
        map2.put("is_lite_sdk", zzm.zzaw(this.f14518d) ? "1" : "0");
        this.zzgki.put("e", TextUtils.join(",", zzabf.zzrm()));
        this.zzgki.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, this.f14520f);
    }
}
