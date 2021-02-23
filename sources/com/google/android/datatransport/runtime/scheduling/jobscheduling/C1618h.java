package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.h */
/* compiled from: Uploader */
final /* synthetic */ class C1618h implements SynchronizationGuard.CriticalSection {

    /* renamed from: a */
    private final EventStore f7332a;

    private C1618h(EventStore eventStore) {
        this.f7332a = eventStore;
    }

    /* renamed from: a */
    public static SynchronizationGuard.CriticalSection m5116a(EventStore eventStore) {
        return new C1618h(eventStore);
    }

    public Object execute() {
        return Integer.valueOf(this.f7332a.cleanUp());
    }
}
