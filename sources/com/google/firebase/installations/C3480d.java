package com.google.firebase.installations;

/* renamed from: com.google.firebase.installations.d */
/* compiled from: FirebaseInstallations */
final /* synthetic */ class C3480d implements Runnable {

    /* renamed from: a */
    private final FirebaseInstallations f19603a;

    /* renamed from: b */
    private final boolean f19604b;

    private C3480d(FirebaseInstallations firebaseInstallations, boolean z) {
        this.f19603a = firebaseInstallations;
        this.f19604b = z;
    }

    /* renamed from: a */
    public static Runnable m11795a(FirebaseInstallations firebaseInstallations, boolean z) {
        return new C3480d(firebaseInstallations, z);
    }

    public void run() {
        this.f19603a.m11772g(this.f19604b);
    }
}
