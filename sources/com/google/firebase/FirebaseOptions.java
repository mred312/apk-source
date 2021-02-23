package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Strings;

public final class FirebaseOptions {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f18838a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final String f18839b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final String f18840c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final String f18841d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final String f18842e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final String f18843f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final String f18844g;

    public static final class Builder {

        /* renamed from: a */
        private String f18845a;

        /* renamed from: b */
        private String f18846b;

        /* renamed from: c */
        private String f18847c;

        /* renamed from: d */
        private String f18848d;

        /* renamed from: e */
        private String f18849e;

        /* renamed from: f */
        private String f18850f;

        /* renamed from: g */
        private String f18851g;

        public Builder() {
        }

        @NonNull
        public FirebaseOptions build() {
            return new FirebaseOptions(this.f18846b, this.f18845a, this.f18847c, this.f18848d, this.f18849e, this.f18850f, this.f18851g);
        }

        @NonNull
        public Builder setApiKey(@NonNull String str) {
            this.f18845a = Preconditions.checkNotEmpty(str, "ApiKey must be set.");
            return this;
        }

        @NonNull
        public Builder setApplicationId(@NonNull String str) {
            this.f18846b = Preconditions.checkNotEmpty(str, "ApplicationId must be set.");
            return this;
        }

        @NonNull
        public Builder setDatabaseUrl(@Nullable String str) {
            this.f18847c = str;
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder setGaTrackingId(@Nullable String str) {
            this.f18848d = str;
            return this;
        }

        @NonNull
        public Builder setGcmSenderId(@Nullable String str) {
            this.f18849e = str;
            return this;
        }

        @NonNull
        public Builder setProjectId(@Nullable String str) {
            this.f18851g = str;
            return this;
        }

        @NonNull
        public Builder setStorageBucket(@Nullable String str) {
            this.f18850f = str;
            return this;
        }

        public Builder(@NonNull FirebaseOptions firebaseOptions) {
            this.f18846b = firebaseOptions.f18839b;
            this.f18845a = firebaseOptions.f18838a;
            this.f18847c = firebaseOptions.f18840c;
            this.f18848d = firebaseOptions.f18841d;
            this.f18849e = firebaseOptions.f18842e;
            this.f18850f = firebaseOptions.f18843f;
            this.f18851g = firebaseOptions.f18844g;
        }
    }

    @Nullable
    public static FirebaseOptions fromResource(@NonNull Context context) {
        StringResourceValueReader stringResourceValueReader = new StringResourceValueReader(context);
        String string = stringResourceValueReader.getString("google_app_id");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new FirebaseOptions(string, stringResourceValueReader.getString("google_api_key"), stringResourceValueReader.getString("firebase_database_url"), stringResourceValueReader.getString("ga_trackingId"), stringResourceValueReader.getString("gcm_defaultSenderId"), stringResourceValueReader.getString("google_storage_bucket"), stringResourceValueReader.getString("project_id"));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseOptions)) {
            return false;
        }
        FirebaseOptions firebaseOptions = (FirebaseOptions) obj;
        if (!Objects.equal(this.f18839b, firebaseOptions.f18839b) || !Objects.equal(this.f18838a, firebaseOptions.f18838a) || !Objects.equal(this.f18840c, firebaseOptions.f18840c) || !Objects.equal(this.f18841d, firebaseOptions.f18841d) || !Objects.equal(this.f18842e, firebaseOptions.f18842e) || !Objects.equal(this.f18843f, firebaseOptions.f18843f) || !Objects.equal(this.f18844g, firebaseOptions.f18844g)) {
            return false;
        }
        return true;
    }

    @NonNull
    public String getApiKey() {
        return this.f18838a;
    }

    @NonNull
    public String getApplicationId() {
        return this.f18839b;
    }

    @Nullable
    public String getDatabaseUrl() {
        return this.f18840c;
    }

    @KeepForSdk
    @Nullable
    public String getGaTrackingId() {
        return this.f18841d;
    }

    @Nullable
    public String getGcmSenderId() {
        return this.f18842e;
    }

    @Nullable
    public String getProjectId() {
        return this.f18844g;
    }

    @Nullable
    public String getStorageBucket() {
        return this.f18843f;
    }

    public int hashCode() {
        return Objects.hashCode(this.f18839b, this.f18838a, this.f18840c, this.f18841d, this.f18842e, this.f18843f, this.f18844g);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("applicationId", this.f18839b).add("apiKey", this.f18838a).add("databaseUrl", this.f18840c).add("gcmSenderId", this.f18842e).add("storageBucket", this.f18843f).add("projectId", this.f18844g).toString();
    }

    private FirebaseOptions(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        Preconditions.checkState(!Strings.isEmptyOrWhitespace(str), "ApplicationId must be set.");
        this.f18839b = str;
        this.f18838a = str2;
        this.f18840c = str3;
        this.f18841d = str4;
        this.f18842e = str5;
        this.f18843f = str6;
        this.f18844g = str7;
    }
}
