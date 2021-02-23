package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzadv extends zzaei {

    /* renamed from: a */
    private final Drawable f12403a;

    /* renamed from: b */
    private final Uri f12404b;

    /* renamed from: c */
    private final double f12405c;

    /* renamed from: d */
    private final int f12406d;

    /* renamed from: e */
    private final int f12407e;

    public zzadv(Drawable drawable, Uri uri, double d, int i, int i2) {
        this.f12403a = drawable;
        this.f12404b = uri;
        this.f12405c = d;
        this.f12406d = i;
        this.f12407e = i2;
    }

    public final int getHeight() {
        return this.f12407e;
    }

    public final double getScale() {
        return this.f12405c;
    }

    public final Uri getUri() {
        return this.f12404b;
    }

    public final int getWidth() {
        return this.f12406d;
    }

    public final IObjectWrapper zzsr() {
        return ObjectWrapper.wrap(this.f12403a);
    }
}
