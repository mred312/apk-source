package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdbv implements zzdfi<zzdfj<Bundle>> {
    @Nullable

    /* renamed from: a */
    private final zzdjv f15198a;

    zzdbv(@Nullable zzdjv zzdjv) {
        this.f15198a = zzdjv;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo17078a(Bundle bundle) {
        bundle.putString("key_schema", this.f15198a.zzauc());
    }

    public final zzdyz<zzdfj<Bundle>> zzasm() {
        zzdjv zzdjv = this.f15198a;
        return zzdyr.zzag((zzdjv == null || zzdjv.zzauc() == null || this.f15198a.zzauc().isEmpty()) ? null : new C1854dt(this));
    }
}
