package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.BackendResponse;

/* renamed from: com.google.android.datatransport.runtime.backends.b */
/* compiled from: AutoValue_BackendResponse */
final class C1587b extends BackendResponse {

    /* renamed from: a */
    private final BackendResponse.Status f7210a;

    /* renamed from: b */
    private final long f7211b;

    C1587b(BackendResponse.Status status, long j) {
        if (status != null) {
            this.f7210a = status;
            this.f7211b = j;
            return;
        }
        throw new NullPointerException("Null status");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendResponse)) {
            return false;
        }
        BackendResponse backendResponse = (BackendResponse) obj;
        if (!this.f7210a.equals(backendResponse.getStatus()) || this.f7211b != backendResponse.getNextRequestWaitMillis()) {
            return false;
        }
        return true;
    }

    public long getNextRequestWaitMillis() {
        return this.f7211b;
    }

    public BackendResponse.Status getStatus() {
        return this.f7210a;
    }

    public int hashCode() {
        long j = this.f7211b;
        return ((this.f7210a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.f7210a + ", nextRequestWaitMillis=" + this.f7211b + "}";
    }
}
