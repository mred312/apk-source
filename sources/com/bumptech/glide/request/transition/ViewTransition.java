package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.bumptech.glide.request.transition.Transition;

public class ViewTransition<R> implements Transition<R> {

    /* renamed from: a */
    private final C1353a f6478a;

    /* renamed from: com.bumptech.glide.request.transition.ViewTransition$a */
    interface C1353a {
        /* renamed from: a */
        Animation mo10225a(Context context);
    }

    ViewTransition(C1353a aVar) {
        this.f6478a = aVar;
    }

    public boolean transition(R r, Transition.ViewAdapter viewAdapter) {
        View view = viewAdapter.getView();
        if (view == null) {
            return false;
        }
        view.clearAnimation();
        view.startAnimation(this.f6478a.mo10225a(view.getContext()));
        return false;
    }
}
