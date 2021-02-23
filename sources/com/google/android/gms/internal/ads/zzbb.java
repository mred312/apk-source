package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbb {

    /* renamed from: a */
    private final int f13024a;

    /* renamed from: b */
    private final List<zzu> f13025b;

    /* renamed from: c */
    private final int f13026c;

    /* renamed from: d */
    private final InputStream f13027d;

    public zzbb(int i, List<zzu> list) {
        this(i, list, -1, (InputStream) null);
    }

    public final InputStream getContent() {
        return this.f13027d;
    }

    public final int getContentLength() {
        return this.f13026c;
    }

    public final int getStatusCode() {
        return this.f13024a;
    }

    public final List<zzu> zzq() {
        return Collections.unmodifiableList(this.f13025b);
    }

    public zzbb(int i, List<zzu> list, int i2, InputStream inputStream) {
        this.f13024a = i;
        this.f13025b = list;
        this.f13026c = i2;
        this.f13027d = inputStream;
    }
}
