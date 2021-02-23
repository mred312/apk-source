package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.oh */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2250oh implements zzadx {

    /* renamed from: a */
    private final /* synthetic */ zzcdy f10370a;

    /* renamed from: b */
    private final /* synthetic */ ViewGroup f10371b;

    /* renamed from: c */
    private final /* synthetic */ zzcda f10372c;

    C2250oh(zzcda zzcda, zzcdy zzcdy, ViewGroup viewGroup) {
        this.f10372c = zzcda;
        this.f10370a = zzcdy;
        this.f10371b = viewGroup;
    }

    public final void zzc(MotionEvent motionEvent) {
        this.f10370a.onTouch((View) null, motionEvent);
    }

    public final void zzss() {
        if (zzcda.m7924c(this.f10370a, zzccy.zzgeb)) {
            this.f10370a.onClick(this.f10371b);
        }
    }

    public final JSONObject zzst() {
        return this.f10370a.zzst();
    }
}
