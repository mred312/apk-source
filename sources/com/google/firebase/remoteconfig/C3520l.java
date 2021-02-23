package com.google.firebase.remoteconfig;

import java.util.concurrent.Callable;

/* renamed from: com.google.firebase.remoteconfig.l */
/* compiled from: RemoteConfigComponent */
final /* synthetic */ class C3520l implements Callable {

    /* renamed from: a */
    private final RemoteConfigComponent f19717a;

    private C3520l(RemoteConfigComponent remoteConfigComponent) {
        this.f19717a = remoteConfigComponent;
    }

    /* renamed from: a */
    public static Callable m11888a(RemoteConfigComponent remoteConfigComponent) {
        return new C3520l(remoteConfigComponent);
    }

    public Object call() {
        return this.f19717a.mo21731c();
    }
}
