package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.tasks.g */
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
final class C3189g implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Task f18778a;

    /* renamed from: b */
    private final /* synthetic */ C3187e f18779b;

    C3189g(C3187e eVar, Task task) {
        this.f18779b = eVar;
        this.f18778a = task;
    }

    public final void run() {
        try {
            Task task = (Task) this.f18779b.f18774b.then(this.f18778a);
            if (task == null) {
                this.f18779b.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = TaskExecutors.f18756a;
            task.addOnSuccessListener(executor, this.f18779b);
            task.addOnFailureListener(executor, (OnFailureListener) this.f18779b);
            task.addOnCanceledListener(executor, (OnCanceledListener) this.f18779b);
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                this.f18779b.f18775c.mo20691a((Exception) e.getCause());
            } else {
                this.f18779b.f18775c.mo20691a(e);
            }
        } catch (Exception e2) {
            this.f18779b.f18775c.mo20691a(e2);
        }
    }
}
