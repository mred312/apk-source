package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ViewPropertyAnimatorCompatSet {

    /* renamed from: a */
    final ArrayList<ViewPropertyAnimatorCompat> f789a = new ArrayList<>();

    /* renamed from: b */
    private long f790b = -1;

    /* renamed from: c */
    private Interpolator f791c;

    /* renamed from: d */
    ViewPropertyAnimatorListener f792d;

    /* renamed from: e */
    private boolean f793e;

    /* renamed from: f */
    private final ViewPropertyAnimatorListenerAdapter f794f = new C0211a();

    /* renamed from: androidx.appcompat.view.ViewPropertyAnimatorCompatSet$a */
    class C0211a extends ViewPropertyAnimatorListenerAdapter {

        /* renamed from: a */
        private boolean f795a = false;

        /* renamed from: b */
        private int f796b = 0;

        C0211a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo1459a() {
            this.f796b = 0;
            this.f795a = false;
            ViewPropertyAnimatorCompatSet.this.mo1451a();
        }

        public void onAnimationEnd(View view) {
            int i = this.f796b + 1;
            this.f796b = i;
            if (i == ViewPropertyAnimatorCompatSet.this.f789a.size()) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = ViewPropertyAnimatorCompatSet.this.f792d;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationEnd((View) null);
                }
                mo1459a();
            }
        }

        public void onAnimationStart(View view) {
            if (!this.f795a) {
                this.f795a = true;
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = ViewPropertyAnimatorCompatSet.this.f792d;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationStart((View) null);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1451a() {
        this.f793e = false;
    }

    public void cancel() {
        if (this.f793e) {
            Iterator<ViewPropertyAnimatorCompat> it = this.f789a.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            this.f793e = false;
        }
    }

    public ViewPropertyAnimatorCompatSet play(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (!this.f793e) {
            this.f789a.add(viewPropertyAnimatorCompat);
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet playSequentially(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        this.f789a.add(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompat2.setStartDelay(viewPropertyAnimatorCompat.getDuration());
        this.f789a.add(viewPropertyAnimatorCompat2);
        return this;
    }

    public ViewPropertyAnimatorCompatSet setDuration(long j) {
        if (!this.f793e) {
            this.f790b = j;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet setInterpolator(Interpolator interpolator) {
        if (!this.f793e) {
            this.f791c = interpolator;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (!this.f793e) {
            this.f792d = viewPropertyAnimatorListener;
        }
        return this;
    }

    public void start() {
        if (!this.f793e) {
            Iterator<ViewPropertyAnimatorCompat> it = this.f789a.iterator();
            while (it.hasNext()) {
                ViewPropertyAnimatorCompat next = it.next();
                long j = this.f790b;
                if (j >= 0) {
                    next.setDuration(j);
                }
                Interpolator interpolator = this.f791c;
                if (interpolator != null) {
                    next.setInterpolator(interpolator);
                }
                if (this.f792d != null) {
                    next.setListener(this.f794f);
                }
                next.start();
            }
            this.f793e = true;
        }
    }
}
