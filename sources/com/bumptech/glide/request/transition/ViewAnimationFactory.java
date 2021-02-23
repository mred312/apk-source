package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.ViewTransition;

public class ViewAnimationFactory<R> implements TransitionFactory<R> {

    /* renamed from: a */
    private final ViewTransition.C1353a f6471a;

    /* renamed from: b */
    private Transition<R> f6472b;

    /* renamed from: com.bumptech.glide.request.transition.ViewAnimationFactory$a */
    private static class C1351a implements ViewTransition.C1353a {

        /* renamed from: a */
        private final Animation f6473a;

        C1351a(Animation animation) {
            this.f6473a = animation;
        }

        /* renamed from: a */
        public Animation mo10225a(Context context) {
            return this.f6473a;
        }
    }

    /* renamed from: com.bumptech.glide.request.transition.ViewAnimationFactory$b */
    private static class C1352b implements ViewTransition.C1353a {

        /* renamed from: a */
        private final int f6474a;

        C1352b(int i) {
            this.f6474a = i;
        }

        /* renamed from: a */
        public Animation mo10225a(Context context) {
            return AnimationUtils.loadAnimation(context, this.f6474a);
        }
    }

    public ViewAnimationFactory(Animation animation) {
        this((ViewTransition.C1353a) new C1351a(animation));
    }

    public Transition<R> build(DataSource dataSource, boolean z) {
        if (dataSource == DataSource.MEMORY_CACHE || !z) {
            return NoTransition.get();
        }
        if (this.f6472b == null) {
            this.f6472b = new ViewTransition(this.f6471a);
        }
        return this.f6472b;
    }

    public ViewAnimationFactory(int i) {
        this((ViewTransition.C1353a) new C1352b(i));
    }

    ViewAnimationFactory(ViewTransition.C1353a aVar) {
        this.f6471a = aVar;
    }
}
