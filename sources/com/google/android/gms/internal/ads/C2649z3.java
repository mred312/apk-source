package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* renamed from: com.google.android.gms.internal.ads.z3 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2649z3 implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ zzaqp f12253a;

    C2649z3(zzaqp zzaqp) {
        this.f12253a = zzaqp;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f12253a.zzdt("User canceled the download.");
    }
}
