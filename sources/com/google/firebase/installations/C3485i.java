package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.local.PersistedInstallationEntry;

/* renamed from: com.google.firebase.installations.i */
/* compiled from: GetIdListener */
class C3485i implements C3489j {

    /* renamed from: a */
    final TaskCompletionSource<String> f19611a;

    public C3485i(TaskCompletionSource<String> taskCompletionSource) {
        this.f19611a = taskCompletionSource;
    }

    /* renamed from: a */
    public boolean mo21600a(PersistedInstallationEntry persistedInstallationEntry, Exception exc) {
        return false;
    }

    /* renamed from: b */
    public boolean mo21601b(PersistedInstallationEntry persistedInstallationEntry) {
        if (!persistedInstallationEntry.isUnregistered() && !persistedInstallationEntry.isRegistered() && !persistedInstallationEntry.isErrored()) {
            return false;
        }
        this.f19611a.trySetResult(persistedInstallationEntry.getFirebaseInstallationId());
        return true;
    }
}
