package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;

/* renamed from: com.google.android.datatransport.runtime.scheduling.a */
/* compiled from: DefaultScheduler */
final /* synthetic */ class C1607a implements Runnable {

    /* renamed from: a */
    private final DefaultScheduler f7270a;

    /* renamed from: b */
    private final TransportContext f7271b;

    /* renamed from: c */
    private final TransportScheduleCallback f7272c;

    /* renamed from: d */
    private final EventInternal f7273d;

    private C1607a(DefaultScheduler defaultScheduler, TransportContext transportContext, TransportScheduleCallback transportScheduleCallback, EventInternal eventInternal) {
        this.f7270a = defaultScheduler;
        this.f7271b = transportContext;
        this.f7272c = transportScheduleCallback;
        this.f7273d = eventInternal;
    }

    /* renamed from: a */
    public static Runnable m5082a(DefaultScheduler defaultScheduler, TransportContext transportContext, TransportScheduleCallback transportScheduleCallback, EventInternal eventInternal) {
        return new C1607a(defaultScheduler, transportContext, transportScheduleCallback, eventInternal);
    }

    public void run() {
        DefaultScheduler.m5079b(this.f7270a, this.f7271b, this.f7272c, this.f7273d);
    }
}
