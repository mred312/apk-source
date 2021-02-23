package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.common.j */
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
final class C1686j extends C1676i {

    /* renamed from: e */
    private final Callable<String> f7585e;

    private C1686j(Callable<String> callable) {
        super(false, (String) null, (Throwable) null);
        this.f7585e = callable;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final String mo12877f() {
        try {
            return this.f7585e.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
