package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.WallTime;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import javax.inject.Inject;

public class Uploader {

    /* renamed from: a */
    private final Context f7288a;

    /* renamed from: b */
    private final BackendRegistry f7289b;

    /* renamed from: c */
    private final EventStore f7290c;

    /* renamed from: d */
    private final WorkScheduler f7291d;

    /* renamed from: e */
    private final Executor f7292e;

    /* renamed from: f */
    private final SynchronizationGuard f7293f;

    /* renamed from: g */
    private final Clock f7294g;

    @Inject
    public Uploader(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, @WallTime Clock clock) {
        this.f7288a = context;
        this.f7289b = backendRegistry;
        this.f7290c = eventStore;
        this.f7291d = workScheduler;
        this.f7292e = executor;
        this.f7293f = synchronizationGuard;
        this.f7294g = clock;
    }

    /* renamed from: c */
    static /* synthetic */ Object m5099c(Uploader uploader, BackendResponse backendResponse, Iterable iterable, TransportContext transportContext, int i) {
        if (backendResponse.getStatus() == BackendResponse.Status.TRANSIENT_ERROR) {
            uploader.f7290c.recordFailure(iterable);
            uploader.f7291d.schedule(transportContext, i + 1);
            return null;
        }
        uploader.f7290c.recordSuccess(iterable);
        if (backendResponse.getStatus() == BackendResponse.Status.OK) {
            uploader.f7290c.recordNextCallTime(transportContext, uploader.f7294g.getTime() + backendResponse.getNextRequestWaitMillis());
        }
        if (!uploader.f7290c.hasPendingEventsFor(transportContext)) {
            return null;
        }
        uploader.f7291d.schedule(transportContext, 1);
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002f, code lost:
        r5.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0022, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r2.f7291d.schedule(r3, r4 + 1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0024 */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void m5101e(com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader r2, com.google.android.datatransport.runtime.TransportContext r3, int r4, java.lang.Runnable r5) {
        /*
            com.google.android.datatransport.runtime.synchronization.SynchronizationGuard r0 = r2.f7293f     // Catch:{ SynchronizationException -> 0x0024 }
            com.google.android.datatransport.runtime.scheduling.persistence.EventStore r1 = r2.f7290c     // Catch:{ SynchronizationException -> 0x0024 }
            r1.getClass()     // Catch:{ SynchronizationException -> 0x0024 }
            com.google.android.datatransport.runtime.synchronization.SynchronizationGuard$CriticalSection r1 = com.google.android.datatransport.runtime.scheduling.jobscheduling.C1618h.m5116a(r1)     // Catch:{ SynchronizationException -> 0x0024 }
            r0.runCriticalSection(r1)     // Catch:{ SynchronizationException -> 0x0024 }
            boolean r0 = r2.mo11482a()     // Catch:{ SynchronizationException -> 0x0024 }
            if (r0 != 0) goto L_0x001e
            com.google.android.datatransport.runtime.synchronization.SynchronizationGuard r0 = r2.f7293f     // Catch:{ SynchronizationException -> 0x0024 }
            com.google.android.datatransport.runtime.synchronization.SynchronizationGuard$CriticalSection r1 = com.google.android.datatransport.runtime.scheduling.jobscheduling.C1619i.m5117a(r2, r3, r4)     // Catch:{ SynchronizationException -> 0x0024 }
            r0.runCriticalSection(r1)     // Catch:{ SynchronizationException -> 0x0024 }
            goto L_0x002b
        L_0x001e:
            r2.mo11483f(r3, r4)     // Catch:{ SynchronizationException -> 0x0024 }
            goto L_0x002b
        L_0x0022:
            r2 = move-exception
            goto L_0x002f
        L_0x0024:
            com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler r2 = r2.f7291d     // Catch:{ all -> 0x0022 }
            int r4 = r4 + 1
            r2.schedule(r3, r4)     // Catch:{ all -> 0x0022 }
        L_0x002b:
            r5.run()
            return
        L_0x002f:
            r5.run()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader.m5101e(com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader, com.google.android.datatransport.runtime.TransportContext, int, java.lang.Runnable):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo11482a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f7288a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo11483f(TransportContext transportContext, int i) {
        BackendResponse backendResponse;
        TransportBackend transportBackend = this.f7289b.get(transportContext.getBackendName());
        Iterable<PersistedEvent> iterable = (Iterable) this.f7293f.runCriticalSection(C1616f.m5114a(this, transportContext));
        if (iterable.iterator().hasNext()) {
            if (transportBackend == null) {
                Logging.m5072d("Uploader", "Unknown backend for %s, deleting event batch for it...", (Object) transportContext);
                backendResponse = BackendResponse.fatalError();
            } else {
                ArrayList arrayList = new ArrayList();
                for (PersistedEvent event : iterable) {
                    arrayList.add(event.getEvent());
                }
                backendResponse = transportBackend.send(BackendRequest.builder().setEvents(arrayList).setExtras(transportContext.getExtras()).build());
            }
            this.f7293f.runCriticalSection(C1617g.m5115a(this, backendResponse, iterable, transportContext, i));
        }
    }

    public void upload(TransportContext transportContext, int i, Runnable runnable) {
        this.f7292e.execute(C1615e.m5113a(this, transportContext, i, runnable));
    }
}
