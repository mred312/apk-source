package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.BackendRegistryModule;
import com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule;
import com.google.android.datatransport.runtime.scheduling.SchedulingModule;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule;
import com.google.android.datatransport.runtime.time.TimeModule;
import dagger.BindsInstance;
import dagger.Component;
import java.io.Closeable;
import javax.inject.Singleton;

@Singleton
@Component(modules = {BackendRegistryModule.class, EventStoreModule.class, C1598e.class, SchedulingModule.class, SchedulingConfigModule.class, TimeModule.class})
/* renamed from: com.google.android.datatransport.runtime.k */
/* compiled from: TransportRuntimeComponent */
abstract class C1605k implements Closeable {

    @Component.Builder
    /* renamed from: com.google.android.datatransport.runtime.k$a */
    /* compiled from: TransportRuntimeComponent */
    interface C1606a {
        @BindsInstance
        /* renamed from: a */
        C1606a mo11452a(Context context);

        C1605k build();
    }

    C1605k() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract EventStore mo11450a();

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract TransportRuntime mo11451b();

    public void close() {
        mo11450a().close();
    }
}
