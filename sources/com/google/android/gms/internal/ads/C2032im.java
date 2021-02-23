package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* renamed from: com.google.android.gms.internal.ads.im */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2032im implements zzbui {

    /* renamed from: a */
    private final Context f9338a;

    /* renamed from: b */
    private final zzawx f9339b;

    C2032im(Context context, zzawx zzawx) {
        this.f9338a = context;
        this.f9339b = zzawx;
    }

    public final void zzb(zzdnj zzdnj) {
        if (!TextUtils.isEmpty(zzdnj.zzhik.zzerj.zzdvn)) {
            this.f9339b.zza(this.f9338a, zzdnj.zzhij.zzfvl.zzhio);
            this.f9339b.zzi(this.f9338a, zzdnj.zzhik.zzerj.zzdvn);
        }
    }

    public final void zzd(zzatl zzatl) {
    }
}
