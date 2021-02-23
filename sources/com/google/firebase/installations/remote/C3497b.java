package com.google.firebase.installations.remote;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.installations.remote.TokenResult;

/* renamed from: com.google.firebase.installations.remote.b */
/* compiled from: AutoValue_TokenResult */
final class C3497b extends TokenResult {

    /* renamed from: a */
    private final String f19653a;

    /* renamed from: b */
    private final long f19654b;

    /* renamed from: c */
    private final TokenResult.ResponseCode f19655c;

    /* renamed from: com.google.firebase.installations.remote.b$b */
    /* compiled from: AutoValue_TokenResult */
    static final class C3499b extends TokenResult.Builder {

        /* renamed from: a */
        private String f19656a;

        /* renamed from: b */
        private Long f19657b;

        /* renamed from: c */
        private TokenResult.ResponseCode f19658c;

        public TokenResult build() {
            String str = "";
            if (this.f19657b == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (str.isEmpty()) {
                return new C3497b(this.f19656a, this.f19657b.longValue(), this.f19658c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public TokenResult.Builder setResponseCode(TokenResult.ResponseCode responseCode) {
            this.f19658c = responseCode;
            return this;
        }

        public TokenResult.Builder setToken(String str) {
            this.f19656a = str;
            return this;
        }

        public TokenResult.Builder setTokenExpirationTimestamp(long j) {
            this.f19657b = Long.valueOf(j);
            return this;
        }

        C3499b() {
        }

        private C3499b(TokenResult tokenResult) {
            this.f19656a = tokenResult.getToken();
            this.f19657b = Long.valueOf(tokenResult.getTokenExpirationTimestamp());
            this.f19658c = tokenResult.getResponseCode();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TokenResult)) {
            return false;
        }
        TokenResult tokenResult = (TokenResult) obj;
        String str = this.f19653a;
        if (str != null ? str.equals(tokenResult.getToken()) : tokenResult.getToken() == null) {
            if (this.f19654b == tokenResult.getTokenExpirationTimestamp()) {
                TokenResult.ResponseCode responseCode = this.f19655c;
                if (responseCode == null) {
                    if (tokenResult.getResponseCode() == null) {
                        return true;
                    }
                } else if (responseCode.equals(tokenResult.getResponseCode())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Nullable
    public TokenResult.ResponseCode getResponseCode() {
        return this.f19655c;
    }

    @Nullable
    public String getToken() {
        return this.f19653a;
    }

    @NonNull
    public long getTokenExpirationTimestamp() {
        return this.f19654b;
    }

    public int hashCode() {
        String str = this.f19653a;
        int i = 0;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.f19654b;
        int i2 = (((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        TokenResult.ResponseCode responseCode = this.f19655c;
        if (responseCode != null) {
            i = responseCode.hashCode();
        }
        return i2 ^ i;
    }

    public TokenResult.Builder toBuilder() {
        return new C3499b(this);
    }

    public String toString() {
        return "TokenResult{token=" + this.f19653a + ", tokenExpirationTimestamp=" + this.f19654b + ", responseCode=" + this.f19655c + "}";
    }

    private C3497b(@Nullable String str, long j, @Nullable TokenResult.ResponseCode responseCode) {
        this.f19653a = str;
        this.f19654b = j;
        this.f19655c = responseCode;
    }
}
