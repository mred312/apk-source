package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.measurement.internal.y3 */
/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
final class C3157y3 implements Callable<List<C3134v7>> {

    /* renamed from: a */
    private final /* synthetic */ String f18459a;

    /* renamed from: b */
    private final /* synthetic */ String f18460b;

    /* renamed from: c */
    private final /* synthetic */ String f18461c;

    /* renamed from: d */
    private final /* synthetic */ zzfw f18462d;

    C3157y3(zzfw zzfw, String str, String str2, String str3) {
        this.f18462d = zzfw;
        this.f18459a = str;
        this.f18460b = str2;
        this.f18461c = str3;
    }

    public final /* synthetic */ Object call() {
        this.f18462d.f18635a.mo20510T();
        return this.f18462d.f18635a.zze().mo19869r(this.f18459a, this.f18460b, this.f18461c);
    }
}
