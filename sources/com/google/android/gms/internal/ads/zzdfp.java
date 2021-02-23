package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdfp implements zzdfj<Bundle> {

    /* renamed from: a */
    private final boolean f15537a;

    /* renamed from: b */
    private final boolean f15538b;

    /* renamed from: c */
    private final String f15539c;

    /* renamed from: d */
    private final boolean f15540d;

    /* renamed from: e */
    private final boolean f15541e;

    /* renamed from: f */
    private final boolean f15542f;

    /* renamed from: g */
    private final String f15543g;

    /* renamed from: h */
    private final ArrayList<String> f15544h;

    /* renamed from: i */
    private final String f15545i;

    /* renamed from: j */
    private final String f15546j;

    /* renamed from: k */
    private final String f15547k;

    /* renamed from: l */
    private final boolean f15548l;

    /* renamed from: m */
    private final String f15549m;

    /* renamed from: n */
    private final long f15550n;

    public zzdfp(boolean z, boolean z2, String str, boolean z3, boolean z4, boolean z5, String str2, ArrayList<String> arrayList, @Nullable String str3, @Nullable String str4, String str5, boolean z6, String str6, long j) {
        this.f15537a = z;
        this.f15538b = z2;
        this.f15539c = str;
        this.f15540d = z3;
        this.f15541e = z4;
        this.f15542f = z5;
        this.f15543g = str2;
        this.f15544h = arrayList;
        this.f15545i = str3;
        this.f15546j = str4;
        this.f15547k = str5;
        this.f15548l = z6;
        this.f15549m = str6;
        this.f15550n = j;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putBoolean("cog", this.f15537a);
        bundle.putBoolean("coh", this.f15538b);
        bundle.putString("gl", this.f15539c);
        bundle.putBoolean("simulator", this.f15540d);
        bundle.putBoolean("is_latchsky", this.f15541e);
        bundle.putBoolean("is_sidewinder", this.f15542f);
        bundle.putString("hl", this.f15543g);
        if (!this.f15544h.isEmpty()) {
            bundle.putStringArrayList("hl_list", this.f15544h);
        }
        bundle.putString("mv", this.f15545i);
        bundle.putString("submodel", this.f15549m);
        Bundle zza = zzdnx.zza(bundle, "device");
        bundle.putBundle("device", zza);
        zza.putString("build", this.f15547k);
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcrr)).booleanValue()) {
            zza.putLong("remaining_data_partition_space", this.f15550n);
        }
        Bundle zza2 = zzdnx.zza(zza, "browser");
        zza.putBundle("browser", zza2);
        zza2.putBoolean("is_browser_custom_tabs_capable", this.f15548l);
        if (!TextUtils.isEmpty(this.f15546j)) {
            Bundle zza3 = zzdnx.zza(zza, "play_store");
            zza.putBundle("play_store", zza3);
            zza3.putString("package_version", this.f15546j);
        }
    }
}
