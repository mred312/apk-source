package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: com.google.android.gms.tasks.n */
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
final class C3196n<TResult> implements C3201t<TResult> {

    /* renamed from: a */
    private final Executor f18794a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Object f18795b = new Object();
    /* access modifiers changed from: private */
    @GuardedBy("mLock")

    /* renamed from: c */
    public OnSuccessListener<? super TResult> f18796c;

    public C3196n(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        this.f18794a = executor;
        this.f18796c = onSuccessListener;
    }

    /* renamed from: a */
    public final void mo20679a(@NonNull Task<TResult> task) {
        if (task.isSuccessful()) {
            synchronized (this.f18795b) {
                if (this.f18796c != null) {
                    this.f18794a.execute(new C3197o(this, task));
                }
            }
        }
    }

    public final void zza() {
        synchronized (this.f18795b) {
            this.f18796c = null;
        }
    }
}
