package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.Resource;

/* renamed from: com.bumptech.glide.load.resource.drawable.a */
/* compiled from: NonOwnedDrawableResource */
final class C1320a extends DrawableResource<Drawable> {
    private C1320a(Drawable drawable) {
        super(drawable);
    }

    @Nullable
    /* renamed from: a */
    static Resource<Drawable> m4580a(@Nullable Drawable drawable) {
        if (drawable != null) {
            return new C1320a(drawable);
        }
        return null;
    }

    @NonNull
    public Class<Drawable> getResourceClass() {
        return this.drawable.getClass();
    }

    public int getSize() {
        return Math.max(1, this.drawable.getIntrinsicWidth() * this.drawable.getIntrinsicHeight() * 4);
    }

    public void recycle() {
    }
}
