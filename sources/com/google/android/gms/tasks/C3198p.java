package com.google.android.gms.tasks;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.tasks.p */
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
final class C3198p implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Task f18799a;

    /* renamed from: b */
    private final /* synthetic */ C3199q f18800b;

    C3198p(C3199q qVar, Task task) {
        this.f18800b = qVar;
        this.f18799a = task;
    }

    public final void run() {
        try {
            Task then = this.f18800b.f18802b.then(this.f18799a.getResult());
            if (then == null) {
                this.f18800b.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = TaskExecutors.f18756a;
            then.addOnSuccessListener(executor, this.f18800b);
            then.addOnFailureListener(executor, (OnFailureListener) this.f18800b);
            then.addOnCanceledListener(executor, (OnCanceledListener) this.f18800b);
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                this.f18800b.onFailure((Exception) e.getCause());
            } else {
                this.f18800b.onFailure(e);
            }
        } catch (CancellationException unused) {
            this.f18800b.onCanceled();
        } catch (Exception e2) {
            this.f18800b.onFailure(e2);
        }
    }
}
