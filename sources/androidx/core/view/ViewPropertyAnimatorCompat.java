package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class ViewPropertyAnimatorCompat {

    /* renamed from: a */
    private WeakReference<View> f2674a;

    /* renamed from: b */
    Runnable f2675b = null;

    /* renamed from: c */
    Runnable f2676c = null;

    /* renamed from: d */
    int f2677d = -1;

    /* renamed from: androidx.core.view.ViewPropertyAnimatorCompat$a */
    class C0545a extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ ViewPropertyAnimatorListener f2678a;

        /* renamed from: b */
        final /* synthetic */ View f2679b;

        C0545a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorListener viewPropertyAnimatorListener, View view) {
            this.f2678a = viewPropertyAnimatorListener;
            this.f2679b = view;
        }

        public void onAnimationCancel(Animator animator) {
            this.f2678a.onAnimationCancel(this.f2679b);
        }

        public void onAnimationEnd(Animator animator) {
            this.f2678a.onAnimationEnd(this.f2679b);
        }

        public void onAnimationStart(Animator animator) {
            this.f2678a.onAnimationStart(this.f2679b);
        }
    }

    /* renamed from: androidx.core.view.ViewPropertyAnimatorCompat$b */
    class C0546b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ ViewPropertyAnimatorUpdateListener f2680a;

        /* renamed from: b */
        final /* synthetic */ View f2681b;

        C0546b(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener, View view) {
            this.f2680a = viewPropertyAnimatorUpdateListener;
            this.f2681b = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f2680a.onAnimationUpdate(this.f2681b);
        }
    }

    /* renamed from: androidx.core.view.ViewPropertyAnimatorCompat$c */
    static class C0547c implements ViewPropertyAnimatorListener {

        /* renamed from: a */
        ViewPropertyAnimatorCompat f2682a;

        /* renamed from: b */
        boolean f2683b;

        C0547c(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
            this.f2682a = viewPropertyAnimatorCompat;
        }

        public void onAnimationCancel(View view) {
            Object tag = view.getTag(2113929216);
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationCancel(view);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: androidx.core.view.ViewPropertyAnimatorListener} */
        /* JADX WARNING: Multi-variable type inference failed */
        @android.annotation.SuppressLint({"WrongConstant"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onAnimationEnd(android.view.View r4) {
            /*
                r3 = this;
                androidx.core.view.ViewPropertyAnimatorCompat r0 = r3.f2682a
                int r0 = r0.f2677d
                r1 = -1
                r2 = 0
                if (r0 <= r1) goto L_0x000f
                r4.setLayerType(r0, r2)
                androidx.core.view.ViewPropertyAnimatorCompat r0 = r3.f2682a
                r0.f2677d = r1
            L_0x000f:
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 16
                if (r0 >= r1) goto L_0x0019
                boolean r0 = r3.f2683b
                if (r0 != 0) goto L_0x0039
            L_0x0019:
                androidx.core.view.ViewPropertyAnimatorCompat r0 = r3.f2682a
                java.lang.Runnable r1 = r0.f2676c
                if (r1 == 0) goto L_0x0024
                r0.f2676c = r2
                r1.run()
            L_0x0024:
                r0 = 2113929216(0x7e000000, float:4.2535296E37)
                java.lang.Object r0 = r4.getTag(r0)
                boolean r1 = r0 instanceof androidx.core.view.ViewPropertyAnimatorListener
                if (r1 == 0) goto L_0x0031
                r2 = r0
                androidx.core.view.ViewPropertyAnimatorListener r2 = (androidx.core.view.ViewPropertyAnimatorListener) r2
            L_0x0031:
                if (r2 == 0) goto L_0x0036
                r2.onAnimationEnd(r4)
            L_0x0036:
                r4 = 1
                r3.f2683b = r4
            L_0x0039:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.ViewPropertyAnimatorCompat.C0547c.onAnimationEnd(android.view.View):void");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.core.view.ViewPropertyAnimatorListener} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onAnimationStart(android.view.View r4) {
            /*
                r3 = this;
                r0 = 0
                r3.f2683b = r0
                androidx.core.view.ViewPropertyAnimatorCompat r0 = r3.f2682a
                int r0 = r0.f2677d
                r1 = 0
                r2 = -1
                if (r0 <= r2) goto L_0x000f
                r0 = 2
                r4.setLayerType(r0, r1)
            L_0x000f:
                androidx.core.view.ViewPropertyAnimatorCompat r0 = r3.f2682a
                java.lang.Runnable r2 = r0.f2675b
                if (r2 == 0) goto L_0x001a
                r0.f2675b = r1
                r2.run()
            L_0x001a:
                r0 = 2113929216(0x7e000000, float:4.2535296E37)
                java.lang.Object r0 = r4.getTag(r0)
                boolean r2 = r0 instanceof androidx.core.view.ViewPropertyAnimatorListener
                if (r2 == 0) goto L_0x0027
                r1 = r0
                androidx.core.view.ViewPropertyAnimatorListener r1 = (androidx.core.view.ViewPropertyAnimatorListener) r1
            L_0x0027:
                if (r1 == 0) goto L_0x002c
                r1.onAnimationStart(r4)
            L_0x002c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.ViewPropertyAnimatorCompat.C0547c.onAnimationStart(android.view.View):void");
        }
    }

    ViewPropertyAnimatorCompat(View view) {
        this.f2674a = new WeakReference<>(view);
    }

    /* renamed from: a */
    private void m1807a(View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view.animate().setListener(new C0545a(this, viewPropertyAnimatorListener, view));
        } else {
            view.animate().setListener((Animator.AnimatorListener) null);
        }
    }

    public ViewPropertyAnimatorCompat alpha(float f) {
        View view = (View) this.f2674a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat alphaBy(float f) {
        View view = (View) this.f2674a.get();
        if (view != null) {
            view.animate().alphaBy(f);
        }
        return this;
    }

    public void cancel() {
        View view = (View) this.f2674a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long getDuration() {
        View view = (View) this.f2674a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0;
    }

    public Interpolator getInterpolator() {
        View view = (View) this.f2674a.get();
        if (view == null || Build.VERSION.SDK_INT < 18) {
            return null;
        }
        return (Interpolator) view.animate().getInterpolator();
    }

    public long getStartDelay() {
        View view = (View) this.f2674a.get();
        if (view != null) {
            return view.animate().getStartDelay();
        }
        return 0;
    }

    public ViewPropertyAnimatorCompat rotation(float f) {
        View view = (View) this.f2674a.get();
        if (view != null) {
            view.animate().rotation(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationBy(float f) {
        View view = (View) this.f2674a.get();
        if (view != null) {
            view.animate().rotationBy(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationX(float f) {
        View view = (View) this.f2674a.get();
        if (view != null) {
            view.animate().rotationX(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationXBy(float f) {
        View view = (View) this.f2674a.get();
        if (view != null) {
            view.animate().rotationXBy(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationY(float f) {
        View view = (View) this.f2674a.get();
        if (view != null) {
            view.animate().rotationY(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationYBy(float f) {
        View view = (View) this.f2674a.get();
        if (view != null) {
            view.animate().rotationYBy(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleX(float f) {
        View view = (View) this.f2674a.get();
        if (view != null) {
            view.animate().scaleX(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleXBy(float f) {
        View view = (View) this.f2674a.get();
        if (view != null) {
            view.animate().scaleXBy(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleY(float f) {
        View view = (View) this.f2674a.get();
        if (view != null) {
            view.animate().scaleY(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleYBy(float f) {
        View view = (View) this.f2674a.get();
        if (view != null) {
            view.animate().scaleYBy(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setDuration(long j) {
        View view = (View) this.f2674a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setInterpolator(Interpolator interpolator) {
        View view = (View) this.f2674a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = (View) this.f2674a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                m1807a(view, viewPropertyAnimatorListener);
            } else {
                view.setTag(2113929216, viewPropertyAnimatorListener);
                m1807a(view, new C0547c(this));
            }
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setStartDelay(long j) {
        View view = (View) this.f2674a.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setUpdateListener(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        View view = (View) this.f2674a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            C0546b bVar = null;
            if (viewPropertyAnimatorUpdateListener != null) {
                bVar = new C0546b(this, viewPropertyAnimatorUpdateListener, view);
            }
            view.animate().setUpdateListener(bVar);
        }
        return this;
    }

    public void start() {
        View view = (View) this.f2674a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public ViewPropertyAnimatorCompat translationX(float f) {
        View view = (View) this.f2674a.get();
        if (view != null) {
            view.animate().translationX(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationXBy(float f) {
        View view = (View) this.f2674a.get();
        if (view != null) {
            view.animate().translationXBy(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationY(float f) {
        View view = (View) this.f2674a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationYBy(float f) {
        View view = (View) this.f2674a.get();
        if (view != null) {
            view.animate().translationYBy(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationZ(float f) {
        View view = (View) this.f2674a.get();
        if (view != null && Build.VERSION.SDK_INT >= 21) {
            view.animate().translationZ(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationZBy(float f) {
        View view = (View) this.f2674a.get();
        if (view != null && Build.VERSION.SDK_INT >= 21) {
            view.animate().translationZBy(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withEndAction(Runnable runnable) {
        View view = (View) this.f2674a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                view.animate().withEndAction(runnable);
            } else {
                m1807a(view, new C0547c(this));
                this.f2676c = runnable;
            }
        }
        return this;
    }

    @SuppressLint({"WrongConstant"})
    public ViewPropertyAnimatorCompat withLayer() {
        View view = (View) this.f2674a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                view.animate().withLayer();
            } else {
                this.f2677d = view.getLayerType();
                m1807a(view, new C0547c(this));
            }
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withStartAction(Runnable runnable) {
        View view = (View) this.f2674a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                view.animate().withStartAction(runnable);
            } else {
                m1807a(view, new C0547c(this));
                this.f2675b = runnable;
            }
        }
        return this;
    }

    /* renamed from: x */
    public ViewPropertyAnimatorCompat mo4679x(float f) {
        View view = (View) this.f2674a.get();
        if (view != null) {
            view.animate().x(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat xBy(float f) {
        View view = (View) this.f2674a.get();
        if (view != null) {
            view.animate().xBy(f);
        }
        return this;
    }

    /* renamed from: y */
    public ViewPropertyAnimatorCompat mo4681y(float f) {
        View view = (View) this.f2674a.get();
        if (view != null) {
            view.animate().y(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat yBy(float f) {
        View view = (View) this.f2674a.get();
        if (view != null) {
            view.animate().yBy(f);
        }
        return this;
    }

    /* renamed from: z */
    public ViewPropertyAnimatorCompat mo4683z(float f) {
        View view = (View) this.f2674a.get();
        if (view != null && Build.VERSION.SDK_INT >= 21) {
            view.animate().z(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat zBy(float f) {
        View view = (View) this.f2674a.get();
        if (view != null && Build.VERSION.SDK_INT >= 21) {
            view.animate().zBy(f);
        }
        return this;
    }
}
