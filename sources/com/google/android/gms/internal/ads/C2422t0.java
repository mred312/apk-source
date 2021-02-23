package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.DialogInterface;

/* renamed from: com.google.android.gms.internal.ads.t0 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2422t0 implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private final zzahz f11119a;

    /* renamed from: b */
    private final String f11120b;

    /* renamed from: c */
    private final Context f11121c;

    C2422t0(zzahz zzahz, String str, Context context) {
        this.f11119a = zzahz;
        this.f11120b = str;
        this.f11121c = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f11119a.mo15348d(this.f11120b, this.f11121c, dialogInterface, i);
    }
}
