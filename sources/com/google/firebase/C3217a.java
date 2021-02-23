package com.google.firebase;

import android.content.Context;
import com.google.firebase.inject.Provider;

/* renamed from: com.google.firebase.a */
/* compiled from: FirebaseApp */
final /* synthetic */ class C3217a implements Provider {

    /* renamed from: a */
    private final FirebaseApp f18852a;

    /* renamed from: b */
    private final Context f18853b;

    private C3217a(FirebaseApp firebaseApp, Context context) {
        this.f18852a = firebaseApp;
        this.f18853b = context;
    }

    /* renamed from: a */
    public static Provider m11127a(FirebaseApp firebaseApp, Context context) {
        return new C3217a(firebaseApp, context);
    }

    public Object get() {
        return FirebaseApp.m11111h(this.f18852a, this.f18853b);
    }
}
