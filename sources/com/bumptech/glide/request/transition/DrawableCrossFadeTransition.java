package com.bumptech.glide.request.transition;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.bumptech.glide.request.transition.Transition;

public class DrawableCrossFadeTransition implements Transition<Drawable> {

    /* renamed from: a */
    private final int f6467a;

    /* renamed from: b */
    private final boolean f6468b;

    public DrawableCrossFadeTransition(int i, boolean z) {
        this.f6467a = i;
        this.f6468b = z;
    }

    public boolean transition(Drawable drawable, Transition.ViewAdapter viewAdapter) {
        Drawable currentDrawable = viewAdapter.getCurrentDrawable();
        if (currentDrawable == null) {
            currentDrawable = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{currentDrawable, drawable});
        transitionDrawable.setCrossFadeEnabled(this.f6468b);
        transitionDrawable.startTransition(this.f6467a);
        viewAdapter.setDrawable(transitionDrawable);
        return true;
    }
}
