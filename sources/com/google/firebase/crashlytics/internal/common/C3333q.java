package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.firebase.crashlytics.internal.common.q */
/* compiled from: SessionReportingCoordinator */
final /* synthetic */ class C3333q implements Continuation {

    /* renamed from: a */
    private final C3335s f19202a;

    private C3333q(C3335s sVar) {
        this.f19202a = sVar;
    }

    /* renamed from: a */
    public static Continuation m11465a(C3335s sVar) {
        return new C3333q(sVar);
    }

    public Object then(Task task) {
        return Boolean.valueOf(this.f19202a.m11471h(task));
    }
}
