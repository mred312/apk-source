package com.google.firebase.remoteconfig.internal;

import java.util.concurrent.Callable;

/* renamed from: com.google.firebase.remoteconfig.internal.c */
/* compiled from: ConfigCacheClient */
final /* synthetic */ class C3589c implements Callable {

    /* renamed from: a */
    private final ConfigStorageClient f20289a;

    private C3589c(ConfigStorageClient configStorageClient) {
        this.f20289a = configStorageClient;
    }

    /* renamed from: a */
    public static Callable m12183a(ConfigStorageClient configStorageClient) {
        return new C3589c(configStorageClient);
    }

    public Object call() {
        return this.f20289a.read();
    }
}
