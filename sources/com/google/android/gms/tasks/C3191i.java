package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: com.google.android.gms.tasks.i */
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
final class C3191i<TResult> implements C3201t<TResult> {

    /* renamed from: a */
    private final Executor f18781a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Object f18782b = new Object();
    /* access modifiers changed from: private */
    @GuardedBy("mLock")

    /* renamed from: c */
    public OnCanceledListener f18783c;

    public C3191i(@NonNull Executor executor, @NonNull OnCanceledListener onCanceledListener) {
        this.f18781a = executor;
        this.f18783c = onCanceledListener;
    }

    /* renamed from: a */
    public final void mo20679a(@NonNull Task<TResult> task) {
        if (task.isCanceled()) {
            synchronized (this.f18782b) {
                if (this.f18783c != null) {
                    this.f18781a.execute(new C3190h(this));
                }
            }
        }
    }

    public final void zza() {
        synchronized (this.f18782b) {
            this.f18783c = null;
        }
    }
}
