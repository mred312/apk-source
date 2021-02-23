package com.google.firebase.installations;

import java.util.concurrent.Callable;

/* renamed from: com.google.firebase.installations.e */
/* compiled from: FirebaseInstallations */
final /* synthetic */ class C3481e implements Callable {

    /* renamed from: a */
    private final FirebaseInstallations f19605a;

    private C3481e(FirebaseInstallations firebaseInstallations) {
        this.f19605a = firebaseInstallations;
    }

    /* renamed from: a */
    public static Callable m11796a(FirebaseInstallations firebaseInstallations) {
        return new C3481e(firebaseInstallations);
    }

    public Object call() {
        return this.f19605a.m11770e();
    }
}
