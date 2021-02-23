package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.g */
/* compiled from: Uploader */
final /* synthetic */ class C1617g implements SynchronizationGuard.CriticalSection {

    /* renamed from: a */
    private final Uploader f7327a;

    /* renamed from: b */
    private final BackendResponse f7328b;

    /* renamed from: c */
    private final Iterable f7329c;

    /* renamed from: d */
    private final TransportContext f7330d;

    /* renamed from: e */
    private final int f7331e;

    private C1617g(Uploader uploader, BackendResponse backendResponse, Iterable iterable, TransportContext transportContext, int i) {
        this.f7327a = uploader;
        this.f7328b = backendResponse;
        this.f7329c = iterable;
        this.f7330d = transportContext;
        this.f7331e = i;
    }

    /* renamed from: a */
    public static SynchronizationGuard.CriticalSection m5115a(Uploader uploader, BackendResponse backendResponse, Iterable iterable, TransportContext transportContext, int i) {
        return new C1617g(uploader, backendResponse, iterable, transportContext, i);
    }

    public Object execute() {
        return Uploader.m5099c(this.f7327a, this.f7328b, this.f7329c, this.f7330d, this.f7331e);
    }
}
