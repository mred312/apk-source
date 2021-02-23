package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.d5 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2966d5 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ AtomicReference f18014a;

    /* renamed from: b */
    private final /* synthetic */ String f18015b;

    /* renamed from: c */
    private final /* synthetic */ String f18016c;

    /* renamed from: d */
    private final /* synthetic */ String f18017d;

    /* renamed from: e */
    private final /* synthetic */ boolean f18018e;

    /* renamed from: f */
    private final /* synthetic */ zzgy f18019f;

    C2966d5(zzgy zzgy, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.f18019f = zzgy;
        this.f18014a = atomicReference;
        this.f18015b = str;
        this.f18016c = str2;
        this.f18017d = str3;
        this.f18018e = z;
    }

    public final void run() {
        this.f18019f.zzy.zzv().zza(this.f18014a, this.f18015b, this.f18016c, this.f18017d, this.f18018e);
    }
}
