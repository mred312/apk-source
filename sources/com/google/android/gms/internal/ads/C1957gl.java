package com.google.android.gms.internal.ads;

import java.util.List;

/* renamed from: com.google.android.gms.internal.ads.gl */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C1957gl implements Runnable {

    /* renamed from: a */
    private final zzclp f8793a;

    /* renamed from: b */
    private final zzdoe f8794b;

    /* renamed from: c */
    private final zzajb f8795c;

    /* renamed from: d */
    private final List f8796d;

    /* renamed from: e */
    private final String f8797e;

    C1957gl(zzclp zzclp, zzdoe zzdoe, zzajb zzajb, List list, String str) {
        this.f8793a = zzclp;
        this.f8794b = zzdoe;
        this.f8795c = zzajb;
        this.f8796d = list;
        this.f8797e = str;
    }

    public final void run() {
        this.f8793a.mo16911e(this.f8794b, this.f8795c, this.f8796d, this.f8797e);
    }
}
