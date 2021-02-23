package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.ads.bd */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1764bd implements zzbsp, zzbtj {

    /* renamed from: a */
    private final Context f7907a;

    /* renamed from: b */
    private final zzdmu f7908b;

    /* renamed from: c */
    private final zzarq f7909c;

    public C1764bd(Context context, zzdmu zzdmu, zzarq zzarq) {
        this.f7907a = context;
        this.f7908b = zzdmu;
        this.f7909c = zzarq;
    }

    public final void onAdLoaded() {
        zzaro zzaro = this.f7908b.zzhhl;
        if (zzaro != null && zzaro.zzdry) {
            ArrayList arrayList = new ArrayList();
            if (!this.f7908b.zzhhl.zzdrz.isEmpty()) {
                arrayList.add(this.f7908b.zzhhl.zzdrz);
            }
            this.f7909c.zza(this.f7907a, arrayList);
        }
    }

    public final void zzcc(@Nullable Context context) {
    }

    public final void zzcd(@Nullable Context context) {
    }

    public final void zzce(@Nullable Context context) {
        this.f7909c.detach();
    }
}
