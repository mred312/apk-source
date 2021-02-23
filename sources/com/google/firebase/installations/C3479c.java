package com.google.firebase.installations;

/* renamed from: com.google.firebase.installations.c */
/* compiled from: FirebaseInstallations */
final /* synthetic */ class C3479c implements Runnable {

    /* renamed from: a */
    private final FirebaseInstallations f19602a;

    private C3479c(FirebaseInstallations firebaseInstallations) {
        this.f19602a = firebaseInstallations;
    }

    /* renamed from: a */
    public static Runnable m11794a(FirebaseInstallations firebaseInstallations) {
        return new C3479c(firebaseInstallations);
    }

    public void run() {
        this.f19602a.m11772g(false);
    }
}
