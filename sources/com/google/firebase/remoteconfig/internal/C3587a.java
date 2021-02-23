package com.google.firebase.remoteconfig.internal;

import java.util.concurrent.Callable;

/* renamed from: com.google.firebase.remoteconfig.internal.a */
/* compiled from: ConfigCacheClient */
final /* synthetic */ class C3587a implements Callable {

    /* renamed from: a */
    private final ConfigCacheClient f20284a;

    /* renamed from: b */
    private final ConfigContainer f20285b;

    private C3587a(ConfigCacheClient configCacheClient, ConfigContainer configContainer) {
        this.f20284a = configCacheClient;
        this.f20285b = configContainer;
    }

    /* renamed from: a */
    public static Callable m12181a(ConfigCacheClient configCacheClient, ConfigContainer configContainer) {
        return new C3587a(configCacheClient, configContainer);
    }

    public Object call() {
        return this.f20284a.f20225b.write(this.f20285b);
    }
}
