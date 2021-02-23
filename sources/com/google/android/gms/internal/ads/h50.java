package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class h50 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Context f8832a;

    /* renamed from: b */
    private final /* synthetic */ View f8833b;

    /* renamed from: c */
    private final /* synthetic */ Activity f8834c;

    h50(zzdx zzdx, Context context, View view, Activity activity) {
        this.f8832a = context;
        this.f8833b = view;
        this.f8834c = activity;
    }

    public final void run() {
        try {
            zzdx.f16039g.zza(this.f8832a, this.f8833b, this.f8834c);
        } catch (Exception e) {
            zzdx.f16041i.zza(2020, -1, e);
        }
    }
}
