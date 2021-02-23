package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.DialogInterface;

/* renamed from: com.google.android.gms.internal.ads.s0 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2381s0 implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    private final zzahz f10836a;

    /* renamed from: b */
    private final String f10837b;

    /* renamed from: c */
    private final Context f10838c;

    C2381s0(zzahz zzahz, String str, Context context) {
        this.f10836a = zzahz;
        this.f10837b = str;
        this.f10838c = context;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.f10836a.mo15347c(this.f10837b, this.f10838c, dialogInterface);
    }
}
