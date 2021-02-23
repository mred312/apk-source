package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.ViewPropertyTransition;

public class ViewPropertyAnimationFactory<R> implements TransitionFactory<R> {

    /* renamed from: a */
    private final ViewPropertyTransition.Animator f6475a;

    /* renamed from: b */
    private ViewPropertyTransition<R> f6476b;

    public ViewPropertyAnimationFactory(ViewPropertyTransition.Animator animator) {
        this.f6475a = animator;
    }

    public Transition<R> build(DataSource dataSource, boolean z) {
        if (dataSource == DataSource.MEMORY_CACHE || !z) {
            return NoTransition.get();
        }
        if (this.f6476b == null) {
            this.f6476b = new ViewPropertyTransition<>(this.f6475a);
        }
        return this.f6476b;
    }
}
