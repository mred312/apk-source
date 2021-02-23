package com.bumptech.glide.request.transition;

import android.view.View;
import com.bumptech.glide.request.transition.Transition;

public class ViewPropertyTransition<R> implements Transition<R> {

    /* renamed from: a */
    private final Animator f6477a;

    public interface Animator {
        void animate(View view);
    }

    public ViewPropertyTransition(Animator animator) {
        this.f6477a = animator;
    }

    public boolean transition(R r, Transition.ViewAdapter viewAdapter) {
        if (viewAdapter.getView() == null) {
            return false;
        }
        this.f6477a.animate(viewAdapter.getView());
        return false;
    }
}
