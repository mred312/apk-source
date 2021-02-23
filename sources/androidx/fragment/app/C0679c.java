package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.annotation.AnimRes;
import androidx.annotation.NonNull;
import androidx.core.p003os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.C0610R;
import androidx.fragment.app.C0697j;

/* renamed from: androidx.fragment.app.c */
/* compiled from: FragmentAnim */
class C0679c {

    /* renamed from: androidx.fragment.app.c$a */
    /* compiled from: FragmentAnim */
    class C0680a implements CancellationSignal.OnCancelListener {

        /* renamed from: a */
        final /* synthetic */ Fragment f3296a;

        C0680a(Fragment fragment) {
            this.f3296a = fragment;
        }

        public void onCancel() {
            if (this.f3296a.mo5454f() != null) {
                View f = this.f3296a.mo5454f();
                this.f3296a.mo5443Z((View) null);
                f.clearAnimation();
            }
            this.f3296a.mo5445a0((Animator) null);
        }
    }

    /* renamed from: androidx.fragment.app.c$b */
    /* compiled from: FragmentAnim */
    class C0681b implements Animation.AnimationListener {

        /* renamed from: a */
        final /* synthetic */ ViewGroup f3297a;

        /* renamed from: b */
        final /* synthetic */ Fragment f3298b;

        /* renamed from: c */
        final /* synthetic */ C0697j.C0704g f3299c;

        /* renamed from: d */
        final /* synthetic */ CancellationSignal f3300d;

        /* renamed from: androidx.fragment.app.c$b$a */
        /* compiled from: FragmentAnim */
        class C0682a implements Runnable {
            C0682a() {
            }

            public void run() {
                if (C0681b.this.f3298b.mo5454f() != null) {
                    C0681b.this.f3298b.mo5443Z((View) null);
                    C0681b bVar = C0681b.this;
                    bVar.f3299c.mo5840a(bVar.f3298b, bVar.f3300d);
                }
            }
        }

        C0681b(ViewGroup viewGroup, Fragment fragment, C0697j.C0704g gVar, CancellationSignal cancellationSignal) {
            this.f3297a = viewGroup;
            this.f3298b = fragment;
            this.f3299c = gVar;
            this.f3300d = cancellationSignal;
        }

        public void onAnimationEnd(Animation animation) {
            this.f3297a.post(new C0682a());
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: androidx.fragment.app.c$c */
    /* compiled from: FragmentAnim */
    class C0683c extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ ViewGroup f3302a;

        /* renamed from: b */
        final /* synthetic */ View f3303b;

        /* renamed from: c */
        final /* synthetic */ Fragment f3304c;

        /* renamed from: d */
        final /* synthetic */ C0697j.C0704g f3305d;

        /* renamed from: e */
        final /* synthetic */ CancellationSignal f3306e;

        C0683c(ViewGroup viewGroup, View view, Fragment fragment, C0697j.C0704g gVar, CancellationSignal cancellationSignal) {
            this.f3302a = viewGroup;
            this.f3303b = view;
            this.f3304c = fragment;
            this.f3305d = gVar;
            this.f3306e = cancellationSignal;
        }

        public void onAnimationEnd(Animator animator) {
            this.f3302a.endViewTransition(this.f3303b);
            Animator g = this.f3304c.mo5456g();
            this.f3304c.mo5445a0((Animator) null);
            if (g != null && this.f3302a.indexOfChild(this.f3303b) < 0) {
                this.f3305d.mo5840a(this.f3304c, this.f3306e);
            }
        }
    }

    /* renamed from: androidx.fragment.app.c$f */
    /* compiled from: FragmentAnim */
    static class C0686f extends AnimationSet {
        C0686f(@NonNull Animation animation) {
            super(false);
            addAnimation(animation);
        }
    }

    /* renamed from: a */
    static void m2389a(@NonNull Fragment fragment, @NonNull C0684d dVar, @NonNull C0697j.C0704g gVar) {
        View view = fragment.f2989H;
        ViewGroup viewGroup = fragment.f2988G;
        viewGroup.startViewTransition(view);
        CancellationSignal cancellationSignal = new CancellationSignal();
        cancellationSignal.setOnCancelListener(new C0680a(fragment));
        gVar.mo5841b(fragment, cancellationSignal);
        if (dVar.f3307a != null) {
            C0685e eVar = new C0685e(dVar.f3307a, viewGroup, view);
            fragment.mo5443Z(fragment.f2989H);
            eVar.setAnimationListener(new C0681b(viewGroup, fragment, gVar, cancellationSignal));
            fragment.f2989H.startAnimation(eVar);
            return;
        }
        Animator animator = dVar.f3308b;
        fragment.mo5445a0(animator);
        animator.addListener(new C0683c(viewGroup, view, fragment, gVar, cancellationSignal));
        animator.setTarget(fragment.f2989H);
        animator.start();
    }

    /* renamed from: b */
    static C0684d m2390b(@NonNull Context context, @NonNull Fragment fragment, boolean z) {
        int c;
        int l = fragment.mo5506l();
        int k = fragment.mo5505k();
        boolean z2 = false;
        fragment.mo5449d0(0);
        ViewGroup viewGroup = fragment.f2988G;
        if (viewGroup != null) {
            int i = C0610R.C0612id.visible_removing_fragment_view_tag;
            if (viewGroup.getTag(i) != null) {
                fragment.f2988G.setTag(i, (Object) null);
            }
        }
        ViewGroup viewGroup2 = fragment.f2988G;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = fragment.onCreateAnimation(l, z, k);
        if (onCreateAnimation != null) {
            return new C0684d(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(l, z, k);
        if (onCreateAnimator != null) {
            return new C0684d(onCreateAnimator);
        }
        if (k != 0) {
            boolean equals = "anim".equals(context.getResources().getResourceTypeName(k));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(context, k);
                    if (loadAnimation != null) {
                        return new C0684d(loadAnimation);
                    }
                    z2 = true;
                } catch (Resources.NotFoundException e) {
                    throw e;
                } catch (RuntimeException unused) {
                }
            }
            if (!z2) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(context, k);
                    if (loadAnimator != null) {
                        return new C0684d(loadAnimator);
                    }
                } catch (RuntimeException e2) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, k);
                        if (loadAnimation2 != null) {
                            return new C0684d(loadAnimation2);
                        }
                    } else {
                        throw e2;
                    }
                }
            }
        }
        if (l != 0 && (c = m2391c(l, z)) >= 0) {
            return new C0684d(AnimationUtils.loadAnimation(context, c));
        }
        return null;
    }

    @AnimRes
    /* renamed from: c */
    private static int m2391c(int i, boolean z) {
        if (i == 4097) {
            return z ? C0610R.anim.fragment_open_enter : C0610R.anim.fragment_open_exit;
        }
        if (i == 4099) {
            return z ? C0610R.anim.fragment_fade_enter : C0610R.anim.fragment_fade_exit;
        }
        if (i != 8194) {
            return -1;
        }
        return z ? C0610R.anim.fragment_close_enter : C0610R.anim.fragment_close_exit;
    }

    /* renamed from: androidx.fragment.app.c$d */
    /* compiled from: FragmentAnim */
    static class C0684d {

        /* renamed from: a */
        public final Animation f3307a;

        /* renamed from: b */
        public final Animator f3308b;

        C0684d(Animation animation) {
            this.f3307a = animation;
            this.f3308b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        C0684d(Animator animator) {
            this.f3307a = null;
            this.f3308b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* renamed from: androidx.fragment.app.c$e */
    /* compiled from: FragmentAnim */
    static class C0685e extends AnimationSet implements Runnable {

        /* renamed from: a */
        private final ViewGroup f3309a;

        /* renamed from: b */
        private final View f3310b;

        /* renamed from: c */
        private boolean f3311c;

        /* renamed from: d */
        private boolean f3312d;

        /* renamed from: e */
        private boolean f3313e = true;

        C0685e(@NonNull Animation animation, @NonNull ViewGroup viewGroup, @NonNull View view) {
            super(false);
            this.f3309a = viewGroup;
            this.f3310b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        public boolean getTransformation(long j, @NonNull Transformation transformation) {
            this.f3313e = true;
            if (this.f3311c) {
                return !this.f3312d;
            }
            if (!super.getTransformation(j, transformation)) {
                this.f3311c = true;
                OneShotPreDrawListener.add(this.f3309a, this);
            }
            return true;
        }

        public void run() {
            if (this.f3311c || !this.f3313e) {
                this.f3309a.endViewTransition(this.f3310b);
                this.f3312d = true;
                return;
            }
            this.f3313e = false;
            this.f3309a.post(this);
        }

        public boolean getTransformation(long j, @NonNull Transformation transformation, float f) {
            this.f3313e = true;
            if (this.f3311c) {
                return !this.f3312d;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.f3311c = true;
                OneShotPreDrawListener.add(this.f3309a, this);
            }
            return true;
        }
    }
}
