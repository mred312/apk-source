package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;

/* renamed from: com.google.android.gms.internal.ads.ai */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C1732ai implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a */
    private final View f7822a;

    /* renamed from: b */
    private final zzbdv f7823b;

    /* renamed from: c */
    private final String f7824c;

    /* renamed from: d */
    private final WindowManager.LayoutParams f7825d;

    /* renamed from: e */
    private final int f7826e;

    /* renamed from: f */
    private final WindowManager f7827f;

    C1732ai(View view, zzbdv zzbdv, String str, WindowManager.LayoutParams layoutParams, int i, WindowManager windowManager) {
        this.f7822a = view;
        this.f7823b = zzbdv;
        this.f7824c = str;
        this.f7825d = layoutParams;
        this.f7826e = i;
        this.f7827f = windowManager;
    }

    public final void onScrollChanged() {
        View view = this.f7822a;
        zzbdv zzbdv = this.f7823b;
        String str = this.f7824c;
        WindowManager.LayoutParams layoutParams = this.f7825d;
        int i = this.f7826e;
        WindowManager windowManager = this.f7827f;
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect) && zzbdv.getView().getWindowToken() != null) {
            if ("1".equals(str) || "2".equals(str)) {
                layoutParams.y = rect.bottom - i;
            } else {
                layoutParams.y = rect.top - i;
            }
            windowManager.updateViewLayout(zzbdv.getView(), layoutParams);
        }
    }
}
