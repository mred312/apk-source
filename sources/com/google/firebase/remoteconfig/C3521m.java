package com.google.firebase.remoteconfig;

import com.google.firebase.remoteconfig.internal.LegacyConfigsHandler;
import java.util.concurrent.Callable;

/* renamed from: com.google.firebase.remoteconfig.m */
/* compiled from: RemoteConfigComponent */
final /* synthetic */ class C3521m implements Callable {

    /* renamed from: a */
    private final LegacyConfigsHandler f19718a;

    private C3521m(LegacyConfigsHandler legacyConfigsHandler) {
        this.f19718a = legacyConfigsHandler;
    }

    /* renamed from: a */
    public static Callable m11889a(LegacyConfigsHandler legacyConfigsHandler) {
        return new C3521m(legacyConfigsHandler);
    }

    public Object call() {
        return Boolean.valueOf(this.f19718a.saveLegacyConfigsIfNecessary());
    }
}
