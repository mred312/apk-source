package com.google.android.gms.internal.ads;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;

/* renamed from: com.google.android.gms.internal.ads.ji */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2065ji implements zzdvm {

    /* renamed from: a */
    private final String f9514a;

    /* renamed from: b */
    private final double f9515b;

    /* renamed from: c */
    private final int f9516c;

    /* renamed from: d */
    private final int f9517d;

    C2065ji(String str, double d, int i, int i2) {
        this.f9514a = str;
        this.f9515b = d;
        this.f9516c = i;
        this.f9517d = i2;
    }

    public final Object apply(Object obj) {
        String str = this.f9514a;
        return new zzadv(new BitmapDrawable(Resources.getSystem(), (Bitmap) obj), Uri.parse(str), this.f9515b, this.f9516c, this.f9517d);
    }
}
