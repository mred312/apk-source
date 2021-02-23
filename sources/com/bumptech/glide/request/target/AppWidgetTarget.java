package com.bumptech.glide.request.target;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;

public class AppWidgetTarget extends CustomTarget<Bitmap> {

    /* renamed from: d */
    private final int[] f6405d;

    /* renamed from: e */
    private final ComponentName f6406e;

    /* renamed from: f */
    private final RemoteViews f6407f;

    /* renamed from: g */
    private final Context f6408g;

    /* renamed from: h */
    private final int f6409h;

    public AppWidgetTarget(Context context, int i, int i2, int i3, RemoteViews remoteViews, int... iArr) {
        super(i, i2);
        if (iArr.length != 0) {
            this.f6408g = (Context) Preconditions.checkNotNull(context, "Context can not be null!");
            this.f6407f = (RemoteViews) Preconditions.checkNotNull(remoteViews, "RemoteViews object can not be null!");
            this.f6405d = (int[]) Preconditions.checkNotNull(iArr, "WidgetIds can not be null!");
            this.f6409h = i3;
            this.f6406e = null;
            return;
        }
        throw new IllegalArgumentException("WidgetIds must have length > 0");
    }

    /* renamed from: a */
    private void m4709a(@Nullable Bitmap bitmap) {
        this.f6407f.setImageViewBitmap(this.f6409h, bitmap);
        m4710b();
    }

    /* renamed from: b */
    private void m4710b() {
        AppWidgetManager instance = AppWidgetManager.getInstance(this.f6408g);
        ComponentName componentName = this.f6406e;
        if (componentName != null) {
            instance.updateAppWidget(componentName, this.f6407f);
        } else {
            instance.updateAppWidget(this.f6405d, this.f6407f);
        }
    }

    public void onLoadCleared(@Nullable Drawable drawable) {
        m4709a((Bitmap) null);
    }

    public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
        m4709a(bitmap);
    }

    public AppWidgetTarget(Context context, int i, RemoteViews remoteViews, int... iArr) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i, remoteViews, iArr);
    }

    public AppWidgetTarget(Context context, int i, int i2, int i3, RemoteViews remoteViews, ComponentName componentName) {
        super(i, i2);
        this.f6408g = (Context) Preconditions.checkNotNull(context, "Context can not be null!");
        this.f6407f = (RemoteViews) Preconditions.checkNotNull(remoteViews, "RemoteViews object can not be null!");
        this.f6406e = (ComponentName) Preconditions.checkNotNull(componentName, "ComponentName can not be null!");
        this.f6409h = i3;
        this.f6405d = null;
    }

    public AppWidgetTarget(Context context, int i, RemoteViews remoteViews, ComponentName componentName) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i, remoteViews, componentName);
    }
}
