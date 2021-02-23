package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.firebase.remoteconfig.internal.b */
/* compiled from: ConfigCacheClient */
final /* synthetic */ class C3588b implements SuccessContinuation {

    /* renamed from: a */
    private final ConfigCacheClient f20286a;

    /* renamed from: b */
    private final boolean f20287b;

    /* renamed from: c */
    private final ConfigContainer f20288c;

    private C3588b(ConfigCacheClient configCacheClient, boolean z, ConfigContainer configContainer) {
        this.f20286a = configCacheClient;
        this.f20287b = z;
        this.f20288c = configContainer;
    }

    /* renamed from: a */
    public static SuccessContinuation m12182a(ConfigCacheClient configCacheClient, boolean z, ConfigContainer configContainer) {
        return new C3588b(configCacheClient, z, configContainer);
    }

    public Task then(Object obj) {
        return ConfigCacheClient.m12098d(this.f20286a, this.f20287b, this.f20288c, (Void) obj);
    }
}
