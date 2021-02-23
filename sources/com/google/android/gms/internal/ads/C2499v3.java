package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.Intent;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;

/* renamed from: com.google.android.gms.internal.ads.v3 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2499v3 implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ zzaqj f11466a;

    C2499v3(zzaqj zzaqj) {
        this.f11466a = zzaqj;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent a = this.f11466a.mo15624a();
        zzp.zzkq();
        zzm.zza(this.f11466a.f12608d, a);
    }
}
