package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;

public final class OneShotPreDrawListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a */
    private final View f2641a;

    /* renamed from: b */
    private ViewTreeObserver f2642b;

    /* renamed from: c */
    private final Runnable f2643c;

    private OneShotPreDrawListener(View view, Runnable runnable) {
        this.f2641a = view;
        this.f2642b = view.getViewTreeObserver();
        this.f2643c = runnable;
    }

    @NonNull
    public static OneShotPreDrawListener add(@NonNull View view, @NonNull Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        } else if (runnable != null) {
            OneShotPreDrawListener oneShotPreDrawListener = new OneShotPreDrawListener(view, runnable);
            view.getViewTreeObserver().addOnPreDrawListener(oneShotPreDrawListener);
            view.addOnAttachStateChangeListener(oneShotPreDrawListener);
            return oneShotPreDrawListener;
        } else {
            throw new NullPointerException("runnable == null");
        }
    }

    public boolean onPreDraw() {
        removeListener();
        this.f2643c.run();
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        this.f2642b = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        removeListener();
    }

    public void removeListener() {
        if (this.f2642b.isAlive()) {
            this.f2642b.removeOnPreDrawListener(this);
        } else {
            this.f2641a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f2641a.removeOnAttachStateChangeListener(this);
    }
}
