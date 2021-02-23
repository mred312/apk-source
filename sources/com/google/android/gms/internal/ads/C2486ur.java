package com.google.android.gms.internal.ads;

import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ads.ur */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2486ur implements Callable {

    /* renamed from: a */
    private final zzcyx f11440a;

    /* renamed from: b */
    private final List f11441b;

    /* renamed from: c */
    private final IObjectWrapper f11442c;

    C2486ur(zzcyx zzcyx, List list, IObjectWrapper iObjectWrapper) {
        this.f11440a = zzcyx;
        this.f11441b = list;
        this.f11442c = iObjectWrapper;
    }

    public final Object call() {
        return this.f11440a.mo17061f(this.f11441b, this.f11442c);
    }
}
