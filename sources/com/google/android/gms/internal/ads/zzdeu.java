package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdeu implements zzdfj<Bundle> {

    /* renamed from: a */
    private final boolean f15511a;

    /* renamed from: b */
    private final boolean f15512b;

    /* renamed from: c */
    private final String f15513c;

    /* renamed from: d */
    private final boolean f15514d;

    /* renamed from: e */
    private final int f15515e;

    /* renamed from: f */
    private final int f15516f;

    /* renamed from: g */
    private final int f15517g;

    public zzdeu(boolean z, boolean z2, String str, boolean z3, int i, int i2, int i3) {
        this.f15511a = z;
        this.f15512b = z2;
        this.f15513c = str;
        this.f15514d = z3;
        this.f15515e = i;
        this.f15516f = i2;
        this.f15517g = i3;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("js", this.f15513c);
        bundle.putBoolean("is_nonagon", true);
        bundle.putString("extra_caps", (String) zzwq.zzqe().zzd(zzabf.zzcrt));
        bundle.putInt("target_api", this.f15515e);
        bundle.putInt("dv", this.f15516f);
        bundle.putInt("lv", this.f15517g);
        Bundle zza = zzdnx.zza(bundle, "sdk_env");
        zza.putBoolean("mf", zzadb.zzdct.get().booleanValue());
        zza.putBoolean("instant_app", this.f15511a);
        zza.putBoolean("lite", this.f15512b);
        zza.putBoolean("is_privileged_process", this.f15514d);
        bundle.putBundle("sdk_env", zza);
        Bundle zza2 = zzdnx.zza(zza, "build_meta");
        zza2.putString("cl", "334274230");
        zza2.putString("rapid_rc", "dev");
        zza2.putString("rapid_rollup", "HEAD");
        zza.putBundle("build_meta", zza2);
    }
}
