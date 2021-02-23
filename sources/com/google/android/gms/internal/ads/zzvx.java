package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public class zzvx {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzvi f17080a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final zzvf f17081b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final zzzp f17082c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final zzagn f17083d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final zzaut f17084e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final zzarh f17085f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final zzagm f17086g;

    public zzvx(zzvi zzvi, zzvf zzvf, zzzp zzzp, zzagn zzagn, zzaut zzaut, zzavx zzavx, zzarh zzarh, zzagm zzagm) {
        this.f17080a = zzvi;
        this.f17081b = zzvf;
        this.f17082c = zzzp;
        this.f17083d = zzagn;
        this.f17084e = zzaut;
        this.f17085f = zzarh;
        this.f17086g = zzagm;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m9253b(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzwq.zzqa().zza(context, zzwq.zzqg().zzbrf, "gmob-apps", bundle, true);
    }

    public final zzxg zza(Context context, zzvn zzvn, String str, zzani zzani) {
        return (zzxg) new dj0(this, context, zzvn, str, zzani).mo14405b(context, false);
    }

    public final zzwz zzb(Context context, String str, zzani zzani) {
        return (zzwz) new ij0(this, context, str, zzani).mo14405b(context, false);
    }

    public final zzavh zzc(Context context, String str, zzani zzani) {
        return (zzavh) new xi0(this, context, str, zzani).mo14405b(context, false);
    }

    public final zzaen zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzaen) new kj0(this, frameLayout, frameLayout2, context).mo14405b(context, false);
    }

    @Nullable
    public final zzarj zzb(Activity activity) {
        aj0 aj0 = new aj0(this, activity);
        Intent intent = activity.getIntent();
        boolean z = false;
        if (!intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            zzaza.zzey("useClientJar flag not found in activity intent extras.");
        } else {
            z = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        return (zzarj) aj0.mo14405b(activity, z);
    }

    public final zzaeq zza(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        return (zzaeq) new jj0(this, view, hashMap, hashMap2).mo14405b(view.getContext(), false);
    }

    @Nullable
    public final zzaqw zzb(Context context, zzani zzani) {
        return (zzaqw) new bj0(this, context, zzani).mo14405b(context, false);
    }

    @Nullable
    public final zzaxq zza(Context context, zzani zzani) {
        return (zzaxq) new zi0(this, context, zzani).mo14405b(context, false);
    }
}
