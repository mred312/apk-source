package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdeg implements zzdfi<zzdfj<Bundle>> {

    /* renamed from: a */
    private final Context f15483a;

    /* renamed from: b */
    private final String f15484b;

    zzdeg(Context context, @Nullable String str) {
        this.f15483a = context;
        this.f15484b = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo17087a(Bundle bundle) {
        bundle.putString("rewarded_sku_package", this.f15483a.getPackageName());
    }

    public final zzdyz<zzdfj<Bundle>> zzasm() {
        C1744au auVar;
        if (this.f15484b == null) {
            auVar = null;
        } else {
            auVar = new C1744au(this);
        }
        return zzdyr.zzag(auVar);
    }
}
