package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.e5 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
final class C2976e5 implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ AtomicReference f18035a;

    /* renamed from: b */
    private final /* synthetic */ String f18036b;

    /* renamed from: c */
    private final /* synthetic */ String f18037c;

    /* renamed from: d */
    private final /* synthetic */ String f18038d;

    /* renamed from: e */
    private final /* synthetic */ zzgy f18039e;

    C2976e5(zzgy zzgy, AtomicReference atomicReference, String str, String str2, String str3) {
        this.f18039e = zzgy;
        this.f18035a = atomicReference;
        this.f18036b = str;
        this.f18037c = str2;
        this.f18038d = str3;
    }

    public final void run() {
        this.f18039e.zzy.zzv().zza((AtomicReference<List<zzw>>) this.f18035a, this.f18036b, this.f18037c, this.f18038d);
    }
}
