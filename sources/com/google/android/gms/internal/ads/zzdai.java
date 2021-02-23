package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdai implements zzdfj<Bundle> {

    /* renamed from: a */
    private final zzvn f15124a;

    /* renamed from: b */
    private final String f15125b;

    /* renamed from: c */
    private final boolean f15126c;

    /* renamed from: d */
    private final String f15127d;

    /* renamed from: e */
    private final float f15128e;

    /* renamed from: f */
    private final int f15129f;

    /* renamed from: g */
    private final int f15130g;

    /* renamed from: h */
    private final String f15131h;

    /* renamed from: i */
    private final boolean f15132i;

    public zzdai(zzvn zzvn, String str, boolean z, String str2, float f, int i, int i2, String str3, boolean z2) {
        Preconditions.checkNotNull(zzvn, "the adSize must not be null");
        this.f15124a = zzvn;
        this.f15125b = str;
        this.f15126c = z;
        this.f15127d = str2;
        this.f15128e = f;
        this.f15129f = i;
        this.f15130g = i2;
        this.f15131h = str3;
        this.f15132i = z2;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzdnx.zza(bundle, "smart_w", "full", this.f15124a.width == -1);
        zzdnx.zza(bundle, "smart_h", "auto", this.f15124a.height == -2);
        Boolean bool = Boolean.TRUE;
        zzdnx.zza(bundle, "ene", bool, this.f15124a.zzchs);
        zzdnx.zza(bundle, "rafmt", "102", this.f15124a.zzchv);
        zzdnx.zza(bundle, "rafmt", "103", this.f15124a.zzchw);
        zzdnx.zza(bundle, "inline_adaptive_slot", bool, this.f15132i);
        zzdnx.zza(bundle, "format", this.f15125b);
        zzdnx.zza(bundle, "fluid", "height", this.f15126c);
        String str = this.f15127d;
        zzdnx.zza(bundle, "sz", str, !TextUtils.isEmpty(str));
        bundle.putFloat("u_sd", this.f15128e);
        bundle.putInt("sw", this.f15129f);
        bundle.putInt("sh", this.f15130g);
        String str2 = this.f15131h;
        zzdnx.zza(bundle, "sc", str2, true ^ TextUtils.isEmpty(str2));
        ArrayList arrayList = new ArrayList();
        zzvn[] zzvnArr = this.f15124a.zzchq;
        if (zzvnArr == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("height", this.f15124a.height);
            bundle2.putInt("width", this.f15124a.width);
            bundle2.putBoolean("is_fluid_height", this.f15124a.zzchr);
            arrayList.add(bundle2);
        } else {
            for (zzvn zzvn : zzvnArr) {
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean("is_fluid_height", zzvn.zzchr);
                bundle3.putInt("height", zzvn.height);
                bundle3.putInt("width", zzvn.width);
                arrayList.add(bundle3);
            }
        }
        bundle.putParcelableArrayList("valid_ad_sizes", arrayList);
    }
}
