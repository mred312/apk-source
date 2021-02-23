package com.google.android.datatransport.runtime;

import android.content.Context;
import androidx.annotation.RestrictTo;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.C1605k;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.Monotonic;
import com.google.android.datatransport.runtime.time.WallTime;
import java.util.Collections;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TransportRuntime implements C1604j {

    /* renamed from: e */
    private static volatile C1605k f7167e;

    /* renamed from: a */
    private final Clock f7168a;

    /* renamed from: b */
    private final Clock f7169b;

    /* renamed from: c */
    private final Scheduler f7170c;

    /* renamed from: d */
    private final Uploader f7171d;

    @Inject
    TransportRuntime(@WallTime Clock clock, @Monotonic Clock clock2, Scheduler scheduler, Uploader uploader, WorkInitializer workInitializer) {
        this.f7168a = clock;
        this.f7169b = clock2;
        this.f7170c = scheduler;
        this.f7171d = uploader;
        workInitializer.ensureContextsScheduled();
    }

    /* renamed from: a */
    private EventInternal m5042a(SendRequest sendRequest) {
        return EventInternal.builder().setEventMillis(this.f7168a.getTime()).setUptimeMillis(this.f7169b.getTime()).setTransportName(sendRequest.mo11397g()).setEncodedPayload(new EncodedPayload(sendRequest.mo11392b(), sendRequest.mo11394d())).setCode(sendRequest.mo11393c().getCode()).build();
    }

    /* renamed from: b */
    private static Set<Encoding> m5043b(Destination destination) {
        if (destination instanceof EncodedDestination) {
            return Collections.unmodifiableSet(((EncodedDestination) destination).getSupportedEncodings());
        }
        return Collections.singleton(Encoding.m5015of("proto"));
    }

    public static TransportRuntime getInstance() {
        C1605k kVar = f7167e;
        if (kVar != null) {
            return kVar.mo11451b();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static void initialize(Context context) {
        if (f7167e == null) {
            synchronized (TransportRuntime.class) {
                if (f7167e == null) {
                    C1605k.C1606a c = C1595d.m5058c();
                    c.mo11452a(context);
                    f7167e = c.build();
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Uploader getUploader() {
        return this.f7171d;
    }

    @Deprecated
    public TransportFactory newFactory(String str) {
        return new C1601g(m5043b((Destination) null), TransportContext.builder().setBackendName(str).build(), this);
    }

    public void send(SendRequest sendRequest, TransportScheduleCallback transportScheduleCallback) {
        this.f7170c.schedule(sendRequest.mo11396f().withPriority(sendRequest.mo11393c().getPriority()), m5042a(sendRequest), transportScheduleCallback);
    }

    public TransportFactory newFactory(Destination destination) {
        return new C1601g(m5043b(destination), TransportContext.builder().setBackendName(destination.getName()).setExtras(destination.getExtras()).build(), this);
    }
}
