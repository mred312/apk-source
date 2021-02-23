package com.google.firebase.installations.remote;

import androidx.annotation.Nullable;
import com.google.firebase.installations.remote.InstallationResponse;

/* renamed from: com.google.firebase.installations.remote.a */
/* compiled from: AutoValue_InstallationResponse */
final class C3494a extends InstallationResponse {

    /* renamed from: a */
    private final String f19643a;

    /* renamed from: b */
    private final String f19644b;

    /* renamed from: c */
    private final String f19645c;

    /* renamed from: d */
    private final TokenResult f19646d;

    /* renamed from: e */
    private final InstallationResponse.ResponseCode f19647e;

    /* renamed from: com.google.firebase.installations.remote.a$b */
    /* compiled from: AutoValue_InstallationResponse */
    static final class C3496b extends InstallationResponse.Builder {

        /* renamed from: a */
        private String f19648a;

        /* renamed from: b */
        private String f19649b;

        /* renamed from: c */
        private String f19650c;

        /* renamed from: d */
        private TokenResult f19651d;

        /* renamed from: e */
        private InstallationResponse.ResponseCode f19652e;

        public InstallationResponse build() {
            return new C3494a(this.f19648a, this.f19649b, this.f19650c, this.f19651d, this.f19652e);
        }

        public InstallationResponse.Builder setAuthToken(TokenResult tokenResult) {
            this.f19651d = tokenResult;
            return this;
        }

        public InstallationResponse.Builder setFid(String str) {
            this.f19649b = str;
            return this;
        }

        public InstallationResponse.Builder setRefreshToken(String str) {
            this.f19650c = str;
            return this;
        }

        public InstallationResponse.Builder setResponseCode(InstallationResponse.ResponseCode responseCode) {
            this.f19652e = responseCode;
            return this;
        }

        public InstallationResponse.Builder setUri(String str) {
            this.f19648a = str;
            return this;
        }

        C3496b() {
        }

        private C3496b(InstallationResponse installationResponse) {
            this.f19648a = installationResponse.getUri();
            this.f19649b = installationResponse.getFid();
            this.f19650c = installationResponse.getRefreshToken();
            this.f19651d = installationResponse.getAuthToken();
            this.f19652e = installationResponse.getResponseCode();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationResponse)) {
            return false;
        }
        InstallationResponse installationResponse = (InstallationResponse) obj;
        String str = this.f19643a;
        if (str != null ? str.equals(installationResponse.getUri()) : installationResponse.getUri() == null) {
            String str2 = this.f19644b;
            if (str2 != null ? str2.equals(installationResponse.getFid()) : installationResponse.getFid() == null) {
                String str3 = this.f19645c;
                if (str3 != null ? str3.equals(installationResponse.getRefreshToken()) : installationResponse.getRefreshToken() == null) {
                    TokenResult tokenResult = this.f19646d;
                    if (tokenResult != null ? tokenResult.equals(installationResponse.getAuthToken()) : installationResponse.getAuthToken() == null) {
                        InstallationResponse.ResponseCode responseCode = this.f19647e;
                        if (responseCode == null) {
                            if (installationResponse.getResponseCode() == null) {
                                return true;
                            }
                        } else if (responseCode.equals(installationResponse.getResponseCode())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Nullable
    public TokenResult getAuthToken() {
        return this.f19646d;
    }

    @Nullable
    public String getFid() {
        return this.f19644b;
    }

    @Nullable
    public String getRefreshToken() {
        return this.f19645c;
    }

    @Nullable
    public InstallationResponse.ResponseCode getResponseCode() {
        return this.f19647e;
    }

    @Nullable
    public String getUri() {
        return this.f19643a;
    }

    public int hashCode() {
        String str = this.f19643a;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f19644b;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f19645c;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        TokenResult tokenResult = this.f19646d;
        int hashCode4 = (hashCode3 ^ (tokenResult == null ? 0 : tokenResult.hashCode())) * 1000003;
        InstallationResponse.ResponseCode responseCode = this.f19647e;
        if (responseCode != null) {
            i = responseCode.hashCode();
        }
        return hashCode4 ^ i;
    }

    public InstallationResponse.Builder toBuilder() {
        return new C3496b(this);
    }

    public String toString() {
        return "InstallationResponse{uri=" + this.f19643a + ", fid=" + this.f19644b + ", refreshToken=" + this.f19645c + ", authToken=" + this.f19646d + ", responseCode=" + this.f19647e + "}";
    }

    private C3494a(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable TokenResult tokenResult, @Nullable InstallationResponse.ResponseCode responseCode) {
        this.f19643a = str;
        this.f19644b = str2;
        this.f19645c = str3;
        this.f19646d = tokenResult;
        this.f19647e = responseCode;
    }
}
