package com.google.android.gms.measurement.internal;

import android.net.Uri;

/* renamed from: com.google.android.gms.measurement.internal.n5 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C3060n5 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ boolean f18265a;

    /* renamed from: b */
    private final /* synthetic */ Uri f18266b;

    /* renamed from: c */
    private final /* synthetic */ String f18267c;

    /* renamed from: d */
    private final /* synthetic */ String f18268d;

    /* renamed from: e */
    private final /* synthetic */ C3069o5 f18269e;

    C3060n5(C3069o5 o5Var, boolean z, Uri uri, String str, String str2) {
        this.f18269e = o5Var;
        this.f18265a = z;
        this.f18266b = uri;
        this.f18267c = str;
        this.f18268d = str2;
    }

    public final void run() {
        this.f18269e.m10626b(this.f18265a, this.f18266b, this.f18267c, this.f18268d);
    }
}
