package com.google.android.datatransport.runtime;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.concurrent.Executor;

public final class ExecutionModule_ExecutorFactory implements Factory<Executor> {

    /* renamed from: a */
    private static final ExecutionModule_ExecutorFactory f7166a = new ExecutionModule_ExecutorFactory();

    public static ExecutionModule_ExecutorFactory create() {
        return f7166a;
    }

    public static Executor executor() {
        return (Executor) Preconditions.checkNotNull(C1598e.m5064a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public Executor get() {
        return executor();
    }
}
