package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.C1605k;
import com.google.android.datatransport.runtime.backends.CreationContextFactory_Factory;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry_Factory;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler_Factory;
import com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule_ConfigFactory;
import com.google.android.datatransport.runtime.scheduling.SchedulingModule_WorkSchedulerFactory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader_Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer_Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_DbNameFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_SchemaVersionFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_StoreConfigFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore_Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager_Factory;
import com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory;
import com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* renamed from: com.google.android.datatransport.runtime.d */
/* compiled from: DaggerTransportRuntimeComponent */
final class C1595d extends C1605k {

    /* renamed from: a */
    private Provider<Executor> f7230a;

    /* renamed from: b */
    private Provider<Context> f7231b;

    /* renamed from: c */
    private Provider f7232c;

    /* renamed from: d */
    private Provider f7233d;

    /* renamed from: e */
    private Provider f7234e;

    /* renamed from: f */
    private Provider<SQLiteEventStore> f7235f;

    /* renamed from: g */
    private Provider<SchedulerConfig> f7236g;

    /* renamed from: h */
    private Provider<WorkScheduler> f7237h;

    /* renamed from: i */
    private Provider<DefaultScheduler> f7238i;

    /* renamed from: j */
    private Provider<Uploader> f7239j;

    /* renamed from: k */
    private Provider<WorkInitializer> f7240k;

    /* renamed from: l */
    private Provider<TransportRuntime> f7241l;

    /* renamed from: com.google.android.datatransport.runtime.d$b */
    /* compiled from: DaggerTransportRuntimeComponent */
    private static final class C1597b implements C1605k.C1606a {

        /* renamed from: a */
        private Context f7242a;

        private C1597b() {
        }

        /* renamed from: a */
        public /* bridge */ /* synthetic */ C1605k.C1606a mo11452a(Context context) {
            mo11453b(context);
            return this;
        }

        /* renamed from: b */
        public C1597b mo11453b(Context context) {
            this.f7242a = (Context) Preconditions.checkNotNull(context);
            return this;
        }

        public C1605k build() {
            Preconditions.checkBuilderRequirement(this.f7242a, Context.class);
            return new C1595d(this.f7242a);
        }
    }

    /* renamed from: c */
    public static C1605k.C1606a m5058c() {
        return new C1597b();
    }

    /* renamed from: d */
    private void m5059d(Context context) {
        this.f7230a = DoubleCheck.provider(ExecutionModule_ExecutorFactory.create());
        Factory create = InstanceFactory.create(context);
        this.f7231b = create;
        CreationContextFactory_Factory create2 = CreationContextFactory_Factory.create(create, TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create());
        this.f7232c = create2;
        this.f7233d = DoubleCheck.provider(MetadataBackendRegistry_Factory.create(this.f7231b, create2));
        this.f7234e = SchemaManager_Factory.create(this.f7231b, EventStoreModule_DbNameFactory.create(), EventStoreModule_SchemaVersionFactory.create());
        this.f7235f = DoubleCheck.provider(SQLiteEventStore_Factory.create(TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create(), EventStoreModule_StoreConfigFactory.create(), this.f7234e));
        SchedulingConfigModule_ConfigFactory create3 = SchedulingConfigModule_ConfigFactory.create(TimeModule_EventClockFactory.create());
        this.f7236g = create3;
        SchedulingModule_WorkSchedulerFactory create4 = SchedulingModule_WorkSchedulerFactory.create(this.f7231b, this.f7235f, create3, TimeModule_UptimeClockFactory.create());
        this.f7237h = create4;
        Provider<Executor> provider = this.f7230a;
        Provider provider2 = this.f7233d;
        Provider<SQLiteEventStore> provider3 = this.f7235f;
        this.f7238i = DefaultScheduler_Factory.create(provider, provider2, create4, provider3, provider3);
        Provider<Context> provider4 = this.f7231b;
        Provider provider5 = this.f7233d;
        Provider<SQLiteEventStore> provider6 = this.f7235f;
        this.f7239j = Uploader_Factory.create(provider4, provider5, provider6, this.f7237h, this.f7230a, provider6, TimeModule_EventClockFactory.create());
        Provider<Executor> provider7 = this.f7230a;
        Provider<SQLiteEventStore> provider8 = this.f7235f;
        this.f7240k = WorkInitializer_Factory.create(provider7, provider8, this.f7237h, provider8);
        this.f7241l = DoubleCheck.provider(TransportRuntime_Factory.create(TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create(), this.f7238i, this.f7239j, this.f7240k));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public EventStore mo11450a() {
        return this.f7235f.get();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public TransportRuntime mo11451b() {
        return this.f7241l.get();
    }

    private C1595d(Context context) {
        m5059d(context);
    }
}
