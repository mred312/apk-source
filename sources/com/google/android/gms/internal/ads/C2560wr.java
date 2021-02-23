package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ads.wr */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2560wr implements Callable {

    /* renamed from: a */
    private final zzcyx f11730a;

    /* renamed from: b */
    private final Uri f11731b;

    /* renamed from: c */
    private final IObjectWrapper f11732c;

    C2560wr(zzcyx zzcyx, Uri uri, IObjectWrapper iObjectWrapper) {
        this.f11730a = zzcyx;
        this.f11731b = uri;
        this.f11732c = iObjectWrapper;
    }

    public final Object call() {
        return this.f11730a.mo17063k(this.f11731b, this.f11732c);
    }
}
