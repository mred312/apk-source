package com.bumptech.glide.util;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.transition.Transition;
import java.util.Arrays;

public class ViewPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T>, SizeReadyCallback {

    /* renamed from: a */
    private int[] f6515a;

    /* renamed from: b */
    private C1359a f6516b;

    /* renamed from: com.bumptech.glide.util.ViewPreloadSizeProvider$a */
    static final class C1359a extends CustomViewTarget<View, Object> {
        C1359a(@NonNull View view) {
            super(view);
        }

        public void onLoadFailed(@Nullable Drawable drawable) {
        }

        /* access modifiers changed from: protected */
        public void onResourceCleared(@Nullable Drawable drawable) {
        }

        public void onResourceReady(@NonNull Object obj, @Nullable Transition<? super Object> transition) {
        }
    }

    public ViewPreloadSizeProvider() {
    }

    @Nullable
    public int[] getPreloadSize(@NonNull T t, int i, int i2) {
        int[] iArr = this.f6515a;
        if (iArr == null) {
            return null;
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    public void onSizeReady(int i, int i2) {
        this.f6515a = new int[]{i, i2};
        this.f6516b = null;
    }

    public void setView(@NonNull View view) {
        if (this.f6515a == null && this.f6516b == null) {
            C1359a aVar = new C1359a(view);
            this.f6516b = aVar;
            aVar.getSize(this);
        }
    }

    public ViewPreloadSizeProvider(@NonNull View view) {
        C1359a aVar = new C1359a(view);
        this.f6516b = aVar;
        aVar.getSize(this);
    }
}
