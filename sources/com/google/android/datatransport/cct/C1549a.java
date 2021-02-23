package com.google.android.datatransport.cct;

import com.google.android.datatransport.cct.C1574c;
import com.google.android.datatransport.runtime.retries.Function;

/* renamed from: com.google.android.datatransport.cct.a */
final /* synthetic */ class C1549a implements Function {

    /* renamed from: a */
    private final C1574c f7085a;

    private C1549a(C1574c cVar) {
        this.f7085a = cVar;
    }

    /* renamed from: a */
    public static Function m5016a(C1574c cVar) {
        return new C1549a(cVar);
    }

    public Object apply(Object obj) {
        return this.f7085a.m5027b((C1574c.C1575a) obj);
    }
}
