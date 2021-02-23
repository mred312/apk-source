package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.measurement.internal.a4 */
/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
final class C2935a4 implements Callable<List<zzw>> {

    /* renamed from: a */
    private final /* synthetic */ String f17935a;

    /* renamed from: b */
    private final /* synthetic */ String f17936b;

    /* renamed from: c */
    private final /* synthetic */ String f17937c;

    /* renamed from: d */
    private final /* synthetic */ zzfw f17938d;

    C2935a4(zzfw zzfw, String str, String str2, String str3) {
        this.f17938d = zzfw;
        this.f17935a = str;
        this.f17936b = str2;
        this.f17937c = str3;
    }

    public final /* synthetic */ Object call() {
        this.f17938d.f18635a.mo20510T();
        return this.f17938d.f18635a.zze().mo19835Q(this.f17935a, this.f17936b, this.f17937c);
    }
}
