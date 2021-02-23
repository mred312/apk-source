package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.e */
/* compiled from: Uploader */
final /* synthetic */ class C1615e implements Runnable {

    /* renamed from: a */
    private final Uploader f7321a;

    /* renamed from: b */
    private final TransportContext f7322b;

    /* renamed from: c */
    private final int f7323c;

    /* renamed from: d */
    private final Runnable f7324d;

    private C1615e(Uploader uploader, TransportContext transportContext, int i, Runnable runnable) {
        this.f7321a = uploader;
        this.f7322b = transportContext;
        this.f7323c = i;
        this.f7324d = runnable;
    }

    /* renamed from: a */
    public static Runnable m5113a(Uploader uploader, TransportContext transportContext, int i, Runnable runnable) {
        return new C1615e(uploader, transportContext, i, runnable);
    }

    public void run() {
        Uploader.m5101e(this.f7321a, this.f7322b, this.f7323c, this.f7324d);
    }
}
