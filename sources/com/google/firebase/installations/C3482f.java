package com.google.firebase.installations;

/* renamed from: com.google.firebase.installations.f */
/* compiled from: FirebaseInstallations */
final /* synthetic */ class C3482f implements Runnable {

    /* renamed from: a */
    private final FirebaseInstallations f19606a;

    /* renamed from: b */
    private final boolean f19607b;

    private C3482f(FirebaseInstallations firebaseInstallations, boolean z) {
        this.f19606a = firebaseInstallations;
        this.f19607b = z;
    }

    /* renamed from: a */
    public static Runnable m11797a(FirebaseInstallations firebaseInstallations, boolean z) {
        return new C3482f(firebaseInstallations, z);
    }

    public void run() {
        this.f19606a.m11771f(this.f19607b);
    }
}
