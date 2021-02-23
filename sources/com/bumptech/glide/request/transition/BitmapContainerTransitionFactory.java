package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.Transition;

public abstract class BitmapContainerTransitionFactory<R> implements TransitionFactory<R> {

    /* renamed from: a */
    private final TransitionFactory<Drawable> f6459a;

    /* renamed from: com.bumptech.glide.request.transition.BitmapContainerTransitionFactory$a */
    private final class C1350a implements Transition<R> {

        /* renamed from: a */
        private final Transition<Drawable> f6460a;

        C1350a(Transition<Drawable> transition) {
            this.f6460a = transition;
        }

        public boolean transition(R r, Transition.ViewAdapter viewAdapter) {
            return this.f6460a.transition(new BitmapDrawable(viewAdapter.getView().getResources(), BitmapContainerTransitionFactory.this.getBitmap(r)), viewAdapter);
        }
    }

    public BitmapContainerTransitionFactory(TransitionFactory<Drawable> transitionFactory) {
        this.f6459a = transitionFactory;
    }

    public Transition<R> build(DataSource dataSource, boolean z) {
        return new C1350a(this.f6459a.build(dataSource, z));
    }

    /* access modifiers changed from: protected */
    public abstract Bitmap getBitmap(R r);
}
