package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.Transition;

public class NoTransition<R> implements Transition<R> {

    /* renamed from: a */
    static final NoTransition<?> f6469a = new NoTransition<>();

    /* renamed from: b */
    private static final TransitionFactory<?> f6470b = new NoAnimationFactory();

    public static class NoAnimationFactory<R> implements TransitionFactory<R> {
        public Transition<R> build(DataSource dataSource, boolean z) {
            return NoTransition.f6469a;
        }
    }

    public static <R> Transition<R> get() {
        return f6469a;
    }

    public static <R> TransitionFactory<R> getFactory() {
        return f6470b;
    }

    public boolean transition(Object obj, Transition.ViewAdapter viewAdapter) {
        return false;
    }
}
