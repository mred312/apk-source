package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
public class TaskCompletionSource<TResult> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C3204w<TResult> f18755a = new C3204w<>();

    public TaskCompletionSource() {
    }

    @NonNull
    public Task<TResult> getTask() {
        return this.f18755a;
    }

    public void setException(@NonNull Exception exc) {
        this.f18755a.mo20691a(exc);
    }

    public void setResult(@Nullable TResult tresult) {
        this.f18755a.mo20692b(tresult);
    }

    public boolean trySetException(@NonNull Exception exc) {
        return this.f18755a.mo20694e(exc);
    }

    public boolean trySetResult(@Nullable TResult tresult) {
        return this.f18755a.mo20695f(tresult);
    }

    public TaskCompletionSource(@NonNull CancellationToken cancellationToken) {
        cancellationToken.onCanceledRequested(new C3202u(this));
    }
}
