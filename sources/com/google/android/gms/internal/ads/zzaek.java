package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzaek extends NativeAd.Image {

    /* renamed from: a */
    private final zzaej f12423a;

    /* renamed from: b */
    private final Drawable f12424b;

    /* renamed from: c */
    private final Uri f12425c;

    /* renamed from: d */
    private final double f12426d;

    /* renamed from: e */
    private final int f12427e;

    /* renamed from: f */
    private final int f12428f;

    public zzaek(zzaej zzaej) {
        Drawable drawable;
        int i;
        this.f12423a = zzaej;
        Uri uri = null;
        try {
            IObjectWrapper zzsr = zzaej.zzsr();
            if (zzsr != null) {
                drawable = (Drawable) ObjectWrapper.unwrap(zzsr);
                this.f12424b = drawable;
                uri = this.f12423a.getUri();
                this.f12425c = uri;
                double d = 1.0d;
                d = this.f12423a.getScale();
                this.f12426d = d;
                int i2 = -1;
                i = this.f12423a.getWidth();
                this.f12427e = i;
                i2 = this.f12423a.getHeight();
                this.f12428f = i2;
            }
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
        drawable = null;
        this.f12424b = drawable;
        try {
            uri = this.f12423a.getUri();
        } catch (RemoteException e2) {
            zzaza.zzc("", e2);
        }
        this.f12425c = uri;
        double d2 = 1.0d;
        try {
            d2 = this.f12423a.getScale();
        } catch (RemoteException e3) {
            zzaza.zzc("", e3);
        }
        this.f12426d = d2;
        int i22 = -1;
        try {
            i = this.f12423a.getWidth();
        } catch (RemoteException e4) {
            zzaza.zzc("", e4);
            i = -1;
        }
        this.f12427e = i;
        try {
            i22 = this.f12423a.getHeight();
        } catch (RemoteException e5) {
            zzaza.zzc("", e5);
        }
        this.f12428f = i22;
    }

    public final Drawable getDrawable() {
        return this.f12424b;
    }

    public final int getHeight() {
        return this.f12428f;
    }

    public final double getScale() {
        return this.f12426d;
    }

    public final Uri getUri() {
        return this.f12425c;
    }

    public final int getWidth() {
        return this.f12427e;
    }
}
