package com.google.firebase.installations.local;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.PersistedInstallationEntry;

/* renamed from: com.google.firebase.installations.local.a */
/* compiled from: AutoValue_PersistedInstallationEntry */
final class C3491a extends PersistedInstallationEntry {

    /* renamed from: a */
    private final String f19620a;

    /* renamed from: b */
    private final PersistedInstallation.RegistrationStatus f19621b;

    /* renamed from: c */
    private final String f19622c;

    /* renamed from: d */
    private final String f19623d;

    /* renamed from: e */
    private final long f19624e;

    /* renamed from: f */
    private final long f19625f;

    /* renamed from: g */
    private final String f19626g;

    /* renamed from: com.google.firebase.installations.local.a$b */
    /* compiled from: AutoValue_PersistedInstallationEntry */
    static final class C3493b extends PersistedInstallationEntry.Builder {

        /* renamed from: a */
        private String f19627a;

        /* renamed from: b */
        private PersistedInstallation.RegistrationStatus f19628b;

        /* renamed from: c */
        private String f19629c;

        /* renamed from: d */
        private String f19630d;

        /* renamed from: e */
        private Long f19631e;

        /* renamed from: f */
        private Long f19632f;

        /* renamed from: g */
        private String f19633g;

        public PersistedInstallationEntry build() {
            String str = "";
            if (this.f19628b == null) {
                str = str + " registrationStatus";
            }
            if (this.f19631e == null) {
                str = str + " expiresInSecs";
            }
            if (this.f19632f == null) {
                str = str + " tokenCreationEpochInSecs";
            }
            if (str.isEmpty()) {
                return new C3491a(this.f19627a, this.f19628b, this.f19629c, this.f19630d, this.f19631e.longValue(), this.f19632f.longValue(), this.f19633g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public PersistedInstallationEntry.Builder setAuthToken(@Nullable String str) {
            this.f19629c = str;
            return this;
        }

        public PersistedInstallationEntry.Builder setExpiresInSecs(long j) {
            this.f19631e = Long.valueOf(j);
            return this;
        }

        public PersistedInstallationEntry.Builder setFirebaseInstallationId(String str) {
            this.f19627a = str;
            return this;
        }

        public PersistedInstallationEntry.Builder setFisError(@Nullable String str) {
            this.f19633g = str;
            return this;
        }

        public PersistedInstallationEntry.Builder setRefreshToken(@Nullable String str) {
            this.f19630d = str;
            return this;
        }

        public PersistedInstallationEntry.Builder setRegistrationStatus(PersistedInstallation.RegistrationStatus registrationStatus) {
            if (registrationStatus != null) {
                this.f19628b = registrationStatus;
                return this;
            }
            throw new NullPointerException("Null registrationStatus");
        }

        public PersistedInstallationEntry.Builder setTokenCreationEpochInSecs(long j) {
            this.f19632f = Long.valueOf(j);
            return this;
        }

        C3493b() {
        }

        private C3493b(PersistedInstallationEntry persistedInstallationEntry) {
            this.f19627a = persistedInstallationEntry.getFirebaseInstallationId();
            this.f19628b = persistedInstallationEntry.getRegistrationStatus();
            this.f19629c = persistedInstallationEntry.getAuthToken();
            this.f19630d = persistedInstallationEntry.getRefreshToken();
            this.f19631e = Long.valueOf(persistedInstallationEntry.getExpiresInSecs());
            this.f19632f = Long.valueOf(persistedInstallationEntry.getTokenCreationEpochInSecs());
            this.f19633g = persistedInstallationEntry.getFisError();
        }
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersistedInstallationEntry)) {
            return false;
        }
        PersistedInstallationEntry persistedInstallationEntry = (PersistedInstallationEntry) obj;
        String str3 = this.f19620a;
        if (str3 != null ? str3.equals(persistedInstallationEntry.getFirebaseInstallationId()) : persistedInstallationEntry.getFirebaseInstallationId() == null) {
            if (this.f19621b.equals(persistedInstallationEntry.getRegistrationStatus()) && ((str = this.f19622c) != null ? str.equals(persistedInstallationEntry.getAuthToken()) : persistedInstallationEntry.getAuthToken() == null) && ((str2 = this.f19623d) != null ? str2.equals(persistedInstallationEntry.getRefreshToken()) : persistedInstallationEntry.getRefreshToken() == null) && this.f19624e == persistedInstallationEntry.getExpiresInSecs() && this.f19625f == persistedInstallationEntry.getTokenCreationEpochInSecs()) {
                String str4 = this.f19626g;
                if (str4 == null) {
                    if (persistedInstallationEntry.getFisError() == null) {
                        return true;
                    }
                } else if (str4.equals(persistedInstallationEntry.getFisError())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Nullable
    public String getAuthToken() {
        return this.f19622c;
    }

    public long getExpiresInSecs() {
        return this.f19624e;
    }

    @Nullable
    public String getFirebaseInstallationId() {
        return this.f19620a;
    }

    @Nullable
    public String getFisError() {
        return this.f19626g;
    }

    @Nullable
    public String getRefreshToken() {
        return this.f19623d;
    }

    @NonNull
    public PersistedInstallation.RegistrationStatus getRegistrationStatus() {
        return this.f19621b;
    }

    public long getTokenCreationEpochInSecs() {
        return this.f19625f;
    }

    public int hashCode() {
        String str = this.f19620a;
        int i = 0;
        int hashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f19621b.hashCode()) * 1000003;
        String str2 = this.f19622c;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f19623d;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        long j = this.f19624e;
        long j2 = this.f19625f;
        int i2 = (((((hashCode2 ^ hashCode3) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        String str4 = this.f19626g;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return i2 ^ i;
    }

    public PersistedInstallationEntry.Builder toBuilder() {
        return new C3493b(this);
    }

    public String toString() {
        return "PersistedInstallationEntry{firebaseInstallationId=" + this.f19620a + ", registrationStatus=" + this.f19621b + ", authToken=" + this.f19622c + ", refreshToken=" + this.f19623d + ", expiresInSecs=" + this.f19624e + ", tokenCreationEpochInSecs=" + this.f19625f + ", fisError=" + this.f19626g + "}";
    }

    private C3491a(@Nullable String str, PersistedInstallation.RegistrationStatus registrationStatus, @Nullable String str2, @Nullable String str3, long j, long j2, @Nullable String str4) {
        this.f19620a = str;
        this.f19621b = registrationStatus;
        this.f19622c = str2;
        this.f19623d = str3;
        this.f19624e = j;
        this.f19625f = j2;
        this.f19626g = str4;
    }
}
