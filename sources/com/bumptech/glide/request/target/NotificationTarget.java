package com.bumptech.glide.request.target;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;

public class NotificationTarget extends CustomTarget<Bitmap> {

    /* renamed from: d */
    private final RemoteViews f6436d;

    /* renamed from: e */
    private final Context f6437e;

    /* renamed from: f */
    private final int f6438f;

    /* renamed from: g */
    private final String f6439g;

    /* renamed from: h */
    private final Notification f6440h;

    /* renamed from: i */
    private final int f6441i;

    public NotificationTarget(Context context, int i, RemoteViews remoteViews, Notification notification, int i2) {
        this(context, i, remoteViews, notification, i2, (String) null);
    }

    /* renamed from: a */
    private void m4731a(@Nullable Bitmap bitmap) {
        this.f6436d.setImageViewBitmap(this.f6441i, bitmap);
        m4732b();
    }

    /* renamed from: b */
    private void m4732b() {
        ((NotificationManager) Preconditions.checkNotNull((NotificationManager) this.f6437e.getSystemService("notification"))).notify(this.f6439g, this.f6438f, this.f6440h);
    }

    public void onLoadCleared(@Nullable Drawable drawable) {
        m4731a((Bitmap) null);
    }

    public NotificationTarget(Context context, int i, RemoteViews remoteViews, Notification notification, int i2, String str) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i, remoteViews, notification, i2, str);
    }

    public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
        m4731a(bitmap);
    }

    public NotificationTarget(Context context, int i, int i2, int i3, RemoteViews remoteViews, Notification notification, int i4, String str) {
        super(i, i2);
        this.f6437e = (Context) Preconditions.checkNotNull(context, "Context must not be null!");
        this.f6440h = (Notification) Preconditions.checkNotNull(notification, "Notification object can not be null!");
        this.f6436d = (RemoteViews) Preconditions.checkNotNull(remoteViews, "RemoteViews object can not be null!");
        this.f6441i = i3;
        this.f6438f = i4;
        this.f6439g = str;
    }
}
