package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.measurement.internal.z3 */
/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
final class C3166z3 implements Callable<List<C3134v7>> {

    /* renamed from: a */
    private final /* synthetic */ zzn f18473a;

    /* renamed from: b */
    private final /* synthetic */ String f18474b;

    /* renamed from: c */
    private final /* synthetic */ String f18475c;

    /* renamed from: d */
    private final /* synthetic */ zzfw f18476d;

    C3166z3(zzfw zzfw, zzn zzn, String str, String str2) {
        this.f18476d = zzfw;
        this.f18473a = zzn;
        this.f18474b = str;
        this.f18475c = str2;
    }

    public final /* synthetic */ Object call() {
        this.f18476d.f18635a.mo20510T();
        return this.f18476d.f18635a.zze().mo19869r(this.f18473a.zza, this.f18474b, this.f18475c);
    }
}
