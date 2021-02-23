package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.measurement.internal.b4 */
/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
final class C2945b4 implements Callable<List<zzw>> {

    /* renamed from: a */
    private final /* synthetic */ zzn f17959a;

    /* renamed from: b */
    private final /* synthetic */ String f17960b;

    /* renamed from: c */
    private final /* synthetic */ String f17961c;

    /* renamed from: d */
    private final /* synthetic */ zzfw f17962d;

    C2945b4(zzfw zzfw, zzn zzn, String str, String str2) {
        this.f17962d = zzfw;
        this.f17959a = zzn;
        this.f17960b = str;
        this.f17961c = str2;
    }

    public final /* synthetic */ Object call() {
        this.f17962d.f18635a.mo20510T();
        return this.f17962d.f18635a.zze().mo19835Q(this.f17959a.zza, this.f17960b, this.f17961c);
    }
}
