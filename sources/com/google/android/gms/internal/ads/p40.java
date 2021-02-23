package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class p40 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Context f10429a;

    /* renamed from: b */
    private final /* synthetic */ String f10430b;

    /* renamed from: c */
    private final /* synthetic */ View f10431c;

    /* renamed from: d */
    private final /* synthetic */ Activity f10432d;

    p40(zzdx zzdx, Context context, String str, View view, Activity activity) {
        this.f10429a = context;
        this.f10430b = str;
        this.f10431c = view;
        this.f10432d = activity;
    }

    public final void run() {
        try {
            zzdx.f16039g.zza(this.f10429a, this.f10430b, this.f10431c, this.f10432d);
        } catch (Exception e) {
            zzdx.f16041i.zza(2021, -1, e);
        }
    }
}
