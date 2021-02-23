package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: com.google.android.gms.tasks.m */
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
final class C3195m<TResult> implements C3201t<TResult> {

    /* renamed from: a */
    private final Executor f18791a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Object f18792b = new Object();
    /* access modifiers changed from: private */
    @GuardedBy("mLock")

    /* renamed from: c */
    public OnFailureListener f18793c;

    public C3195m(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.f18791a = executor;
        this.f18793c = onFailureListener;
    }

    /* renamed from: a */
    public final void mo20679a(@NonNull Task<TResult> task) {
        if (!task.isSuccessful() && !task.isCanceled()) {
            synchronized (this.f18792b) {
                if (this.f18793c != null) {
                    this.f18791a.execute(new C3194l(this, task));
                }
            }
        }
    }

    public final void zza() {
        synchronized (this.f18792b) {
            this.f18793c = null;
        }
    }
}
