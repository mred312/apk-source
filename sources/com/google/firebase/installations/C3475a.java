package com.google.firebase.installations;

import androidx.annotation.NonNull;
import com.google.firebase.installations.InstallationTokenResult;

/* renamed from: com.google.firebase.installations.a */
/* compiled from: com.google.firebase:firebase-installations-interop@@16.0.0 */
final class C3475a extends InstallationTokenResult {

    /* renamed from: a */
    private final String f19594a;

    /* renamed from: b */
    private final long f19595b;

    /* renamed from: c */
    private final long f19596c;

    /* renamed from: com.google.firebase.installations.a$b */
    /* compiled from: com.google.firebase:firebase-installations-interop@@16.0.0 */
    static final class C3477b extends InstallationTokenResult.Builder {

        /* renamed from: a */
        private String f19597a;

        /* renamed from: b */
        private Long f19598b;

        /* renamed from: c */
        private Long f19599c;

        public InstallationTokenResult build() {
            String str = "";
            if (this.f19597a == null) {
                str = str + " token";
            }
            if (this.f19598b == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (this.f19599c == null) {
                str = str + " tokenCreationTimestamp";
            }
            if (str.isEmpty()) {
                return new C3475a(this.f19597a, this.f19598b.longValue(), this.f19599c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public InstallationTokenResult.Builder setToken(String str) {
            if (str != null) {
                this.f19597a = str;
                return this;
            }
            throw new NullPointerException("Null token");
        }

        public InstallationTokenResult.Builder setTokenCreationTimestamp(long j) {
            this.f19599c = Long.valueOf(j);
            return this;
        }

        public InstallationTokenResult.Builder setTokenExpirationTimestamp(long j) {
            this.f19598b = Long.valueOf(j);
            return this;
        }

        C3477b() {
        }

        private C3477b(InstallationTokenResult installationTokenResult) {
            this.f19597a = installationTokenResult.getToken();
            this.f19598b = Long.valueOf(installationTokenResult.getTokenExpirationTimestamp());
            this.f19599c = Long.valueOf(installationTokenResult.getTokenCreationTimestamp());
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationTokenResult)) {
            return false;
        }
        InstallationTokenResult installationTokenResult = (InstallationTokenResult) obj;
        if (this.f19594a.equals(installationTokenResult.getToken()) && this.f19595b == installationTokenResult.getTokenExpirationTimestamp() && this.f19596c == installationTokenResult.getTokenCreationTimestamp()) {
            return true;
        }
        return false;
    }

    @NonNull
    public String getToken() {
        return this.f19594a;
    }

    @NonNull
    public long getTokenCreationTimestamp() {
        return this.f19596c;
    }

    @NonNull
    public long getTokenExpirationTimestamp() {
        return this.f19595b;
    }

    public int hashCode() {
        long j = this.f19595b;
        long j2 = this.f19596c;
        return ((((this.f19594a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public InstallationTokenResult.Builder toBuilder() {
        return new C3477b(this);
    }

    public String toString() {
        return "InstallationTokenResult{token=" + this.f19594a + ", tokenExpirationTimestamp=" + this.f19595b + ", tokenCreationTimestamp=" + this.f19596c + "}";
    }

    private C3475a(String str, long j, long j2) {
        this.f19594a = str;
        this.f19595b = j;
        this.f19596c = j2;
    }
}
