package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.PlatformVersion;

@TargetApi(19)
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcif {
    @Nullable

    /* renamed from: a */
    private Context f14431a;
    @Nullable

    /* renamed from: b */
    private PopupWindow f14432b;

    /* renamed from: a */
    private static PopupWindow m8163a(Context context, View view) {
        Window window = context instanceof Activity ? ((Activity) context).getWindow() : null;
        if (window == null || window.getDecorView() == null || ((Activity) context).isDestroyed()) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.addView(view, -1, -1);
        PopupWindow popupWindow = new PopupWindow(frameLayout, 1, 1, false);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setClippingEnabled(false);
        zzaza.zzeb("Displaying the 1x1 popup off the screen.");
        try {
            popupWindow.showAtLocation(window.getDecorView(), 0, -1, -1);
            return popupWindow;
        } catch (Exception unused) {
            return null;
        }
    }

    public final void zzapd() {
        Context context = this.f14431a;
        if (context != null && this.f14432b != null) {
            if (!(context instanceof Activity) || !((Activity) context).isDestroyed()) {
                if (this.f14432b.isShowing()) {
                    this.f14432b.dismiss();
                }
                this.f14431a = null;
                this.f14432b = null;
                return;
            }
            this.f14431a = null;
            this.f14432b = null;
        }
    }

    public final void zzc(Context context, View view) {
        if (PlatformVersion.isAtLeastKitKat() && !PlatformVersion.isAtLeastLollipop()) {
            PopupWindow a = m8163a(context, view);
            this.f14432b = a;
            if (a == null) {
                context = null;
            }
            this.f14431a = context;
        }
    }
}
