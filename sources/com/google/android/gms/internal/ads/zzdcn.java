package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdcn implements zzdfi<C2113kt> {

    /* renamed from: a */
    private final Context f15425a;

    /* renamed from: b */
    private final zzdzc f15426b;

    zzdcn(Context context, zzdzc zzdzc) {
        this.f15425a = context;
        this.f15426b = zzdzc;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ C2113kt mo17080a() {
        zzp.zzkq();
        String zzax = zzm.zzax(this.f15425a);
        String str = "";
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwp)).booleanValue()) {
            str = this.f15425a.getSharedPreferences("mobileads_consent", 0).getString("fc_consent", str);
        }
        zzp.zzkq();
        return new C2113kt(zzax, str, zzm.zzay(this.f15425a));
    }

    public final zzdyz<C2113kt> zzasm() {
        return this.f15426b.zze(new C2076jt(this));
    }
}
