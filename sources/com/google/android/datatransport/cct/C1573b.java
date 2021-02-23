package com.google.android.datatransport.cct;

import com.google.android.datatransport.cct.C1574c;
import com.google.android.datatransport.runtime.retries.RetryStrategy;

/* renamed from: com.google.android.datatransport.cct.b */
final /* synthetic */ class C1573b implements RetryStrategy {

    /* renamed from: a */
    private static final C1573b f7151a = new C1573b();

    private C1573b() {
    }

    /* renamed from: a */
    public static RetryStrategy m5025a() {
        return f7151a;
    }

    public Object shouldRetry(Object obj, Object obj2) {
        return C1574c.m5026a((C1574c.C1575a) obj, (C1574c.C1576b) obj2);
    }
}
