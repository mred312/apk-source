package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.google.android.gms.internal.ads.u0 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2459u0 extends TimerTask {

    /* renamed from: a */
    private final /* synthetic */ AlertDialog f11235a;

    /* renamed from: b */
    private final /* synthetic */ Timer f11236b;

    C2459u0(zzahz zzahz, AlertDialog alertDialog, Timer timer) {
        this.f11235a = alertDialog;
        this.f11236b = timer;
    }

    public final void run() {
        this.f11235a.dismiss();
        this.f11236b.cancel();
    }
}
