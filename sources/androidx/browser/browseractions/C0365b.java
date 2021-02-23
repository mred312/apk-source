package androidx.browser.browseractions;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

/* renamed from: androidx.browser.browseractions.b */
/* compiled from: BrowserActionsFallbackMenuDialog */
class C0365b extends Dialog {

    /* renamed from: a */
    private final View f1788a;

    /* renamed from: androidx.browser.browseractions.b$a */
    /* compiled from: BrowserActionsFallbackMenuDialog */
    class C0366a extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ boolean f1789a;

        C0366a(boolean z) {
            this.f1789a = z;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f1789a) {
                C0365b.super.dismiss();
            }
        }
    }

    C0365b(Context context, View view) {
        super(context);
        this.f1788a = view;
    }

    /* renamed from: b */
    private void m1200b(boolean z) {
        float f = 0.0f;
        float f2 = z ? 0.0f : 1.0f;
        if (z) {
            f = 1.0f;
        }
        long j = z ? 250 : 150;
        this.f1788a.setScaleX(f2);
        this.f1788a.setScaleY(f2);
        this.f1788a.animate().scaleX(f).scaleY(f).setDuration(j).setInterpolator(new LinearOutSlowInInterpolator()).setListener(new C0366a(z)).start();
    }

    public void dismiss() {
        m1200b(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        dismiss();
        return true;
    }

    public void show() {
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        m1200b(true);
        super.show();
    }
}
