package com.google.android.gms.measurement.internal;

import java.util.Map;

/* renamed from: com.google.android.gms.measurement.internal.t5 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final /* synthetic */ class C3114t5 implements Runnable {

    /* renamed from: a */
    private final C3087q5 f18370a;

    /* renamed from: b */
    private final int f18371b;

    /* renamed from: c */
    private final Exception f18372c;

    /* renamed from: d */
    private final byte[] f18373d;

    /* renamed from: e */
    private final Map f18374e;

    C3114t5(C3087q5 q5Var, int i, Exception exc, byte[] bArr, Map map) {
        this.f18370a = q5Var;
        this.f18371b = i;
        this.f18372c = exc;
        this.f18373d = bArr;
        this.f18374e = map;
    }

    public final void run() {
        this.f18370a.mo20093a(this.f18371b, this.f18372c, this.f18373d, this.f18374e);
    }
}
