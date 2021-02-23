package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.i */
/* compiled from: Uploader */
final /* synthetic */ class C1619i implements SynchronizationGuard.CriticalSection {

    /* renamed from: a */
    private final Uploader f7333a;

    /* renamed from: b */
    private final TransportContext f7334b;

    /* renamed from: c */
    private final int f7335c;

    private C1619i(Uploader uploader, TransportContext transportContext, int i) {
        this.f7333a = uploader;
        this.f7334b = transportContext;
        this.f7335c = i;
    }

    /* renamed from: a */
    public static SynchronizationGuard.CriticalSection m5117a(Uploader uploader, TransportContext transportContext, int i) {
        return new C1619i(uploader, transportContext, i);
    }

    public Object execute() {
        return this.f7333a.f7291d.schedule(this.f7334b, this.f7335c + 1);
    }
}
