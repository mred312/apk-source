package com.google.android.datatransport.runtime;

import dagger.Module;
import dagger.Provides;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.inject.Singleton;

@Module
/* renamed from: com.google.android.datatransport.runtime.e */
/* compiled from: ExecutionModule */
abstract class C1598e {
    @Singleton
    @Provides
    /* renamed from: a */
    static Executor m5064a() {
        return new C1599f(Executors.newSingleThreadExecutor());
    }
}
