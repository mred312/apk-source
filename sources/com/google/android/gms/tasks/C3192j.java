package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: com.google.android.gms.tasks.j */
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
final class C3192j<TResult> implements C3201t<TResult> {

    /* renamed from: a */
    private final Executor f18784a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Object f18785b = new Object();
    /* access modifiers changed from: private */
    @GuardedBy("mLock")

    /* renamed from: c */
    public OnCompleteListener<TResult> f18786c;

    public C3192j(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.f18784a = executor;
        this.f18786c = onCompleteListener;
    }

    /* renamed from: a */
    public final void mo20679a(@NonNull Task<TResult> task) {
        synchronized (this.f18785b) {
            if (this.f18786c != null) {
                this.f18784a.execute(new C3193k(this, task));
            }
        }
    }

    public final void zza() {
        synchronized (this.f18785b) {
            this.f18786c = null;
        }
    }
}
