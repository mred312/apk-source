package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.google.firebase.crashlytics.internal.common.t */
/* compiled from: Utils */
final /* synthetic */ class C3336t implements Continuation {

    /* renamed from: a */
    private final CountDownLatch f19209a;

    private C3336t(CountDownLatch countDownLatch) {
        this.f19209a = countDownLatch;
    }

    /* renamed from: a */
    public static Continuation m11481a(CountDownLatch countDownLatch) {
        return new C3336t(countDownLatch);
    }

    public Object then(Task task) {
        return this.f19209a.countDown();
    }
}
