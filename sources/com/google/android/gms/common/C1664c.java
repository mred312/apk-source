package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.common.c */
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
final /* synthetic */ class C1664c implements Callable {

    /* renamed from: a */
    private final boolean f7497a;

    /* renamed from: b */
    private final String f7498b;

    /* renamed from: c */
    private final C1663b f7499c;

    C1664c(boolean z, String str, C1663b bVar) {
        this.f7497a = z;
        this.f7498b = str;
        this.f7499c = bVar;
    }

    public final Object call() {
        return C1660a.m5248b(this.f7497a, this.f7498b, this.f7499c);
    }
}
