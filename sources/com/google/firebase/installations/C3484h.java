package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.local.PersistedInstallationEntry;

/* renamed from: com.google.firebase.installations.h */
/* compiled from: GetAuthTokenListener */
class C3484h implements C3489j {

    /* renamed from: a */
    private final C3490k f19609a;

    /* renamed from: b */
    private final TaskCompletionSource<InstallationTokenResult> f19610b;

    public C3484h(C3490k kVar, TaskCompletionSource<InstallationTokenResult> taskCompletionSource) {
        this.f19609a = kVar;
        this.f19610b = taskCompletionSource;
    }

    /* renamed from: a */
    public boolean mo21600a(PersistedInstallationEntry persistedInstallationEntry, Exception exc) {
        if (!persistedInstallationEntry.isErrored() && !persistedInstallationEntry.isNotGenerated() && !persistedInstallationEntry.isUnregistered()) {
            return false;
        }
        this.f19610b.trySetException(exc);
        return true;
    }

    /* renamed from: b */
    public boolean mo21601b(PersistedInstallationEntry persistedInstallationEntry) {
        if (!persistedInstallationEntry.isRegistered() || this.f19609a.mo21603b(persistedInstallationEntry)) {
            return false;
        }
        this.f19610b.setResult(InstallationTokenResult.builder().setToken(persistedInstallationEntry.getAuthToken()).setTokenExpirationTimestamp(persistedInstallationEntry.getExpiresInSecs()).setTokenCreationTimestamp(persistedInstallationEntry.getTokenCreationEpochInSecs()).build());
        return true;
    }
}
