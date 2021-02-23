package com.google.android.datatransport.runtime;

import com.google.android.datatransport.TransportScheduleCallback;

/* renamed from: com.google.android.datatransport.runtime.h */
/* compiled from: TransportImpl */
final /* synthetic */ class C1602h implements TransportScheduleCallback {

    /* renamed from: a */
    private static final C1602h f7248a = new C1602h();

    private C1602h() {
    }

    /* renamed from: a */
    public static TransportScheduleCallback m5065a() {
        return f7248a;
    }

    public void onSchedule(Exception exc) {
        C1603i.m5066a(exc);
    }
}
