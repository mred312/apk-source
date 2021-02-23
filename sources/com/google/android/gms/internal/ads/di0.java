package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.PushbackInputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class di0 extends PushbackInputStream {

    /* renamed from: a */
    private final /* synthetic */ ci0 f8269a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    di0(ci0 ci0, InputStream inputStream, int i) {
        super(inputStream, 1);
        this.f8269a = ci0;
    }

    public final synchronized void close() {
        this.f8269a.f8015c.m9107a();
        super.close();
    }
}
