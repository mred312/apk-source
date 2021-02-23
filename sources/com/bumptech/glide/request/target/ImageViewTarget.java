package com.bumptech.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.transition.Transition;

public abstract class ImageViewTarget<Z> extends ViewTarget<ImageView, Z> implements Transition.ViewAdapter {
    @Nullable

    /* renamed from: h */
    private Animatable f6435h;

    public ImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    /* renamed from: g */
    private void m4729g(@Nullable Z z) {
        if (z instanceof Animatable) {
            Animatable animatable = (Animatable) z;
            this.f6435h = animatable;
            animatable.start();
            return;
        }
        this.f6435h = null;
    }

    /* renamed from: h */
    private void m4730h(@Nullable Z z) {
        setResource(z);
        m4729g(z);
    }

    @Nullable
    public Drawable getCurrentDrawable() {
        return ((ImageView) this.view).getDrawable();
    }

    public void onLoadCleared(@Nullable Drawable drawable) {
        super.onLoadCleared(drawable);
        Animatable animatable = this.f6435h;
        if (animatable != null) {
            animatable.stop();
        }
        m4730h((Object) null);
        setDrawable(drawable);
    }

    public void onLoadFailed(@Nullable Drawable drawable) {
        super.onLoadFailed(drawable);
        m4730h((Object) null);
        setDrawable(drawable);
    }

    public void onLoadStarted(@Nullable Drawable drawable) {
        super.onLoadStarted(drawable);
        m4730h((Object) null);
        setDrawable(drawable);
    }

    public void onResourceReady(@NonNull Z z, @Nullable Transition<? super Z> transition) {
        if (transition == null || !transition.transition(z, this)) {
            m4730h(z);
        } else {
            m4729g(z);
        }
    }

    public void onStart() {
        Animatable animatable = this.f6435h;
        if (animatable != null) {
            animatable.start();
        }
    }

    public void onStop() {
        Animatable animatable = this.f6435h;
        if (animatable != null) {
            animatable.stop();
        }
    }

    public void setDrawable(Drawable drawable) {
        ((ImageView) this.view).setImageDrawable(drawable);
    }

    /* access modifiers changed from: protected */
    public abstract void setResource(@Nullable Z z);

    @Deprecated
    public ImageViewTarget(ImageView imageView, boolean z) {
        super(imageView, z);
    }
}
