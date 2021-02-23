package com.google.firebase.installations;

import androidx.annotation.NonNull;
import com.google.firebase.FirebaseException;

public class FirebaseInstallationsException extends FirebaseException {
    @NonNull

    /* renamed from: a */
    private final Status f19590a;

    public enum Status {
        BAD_CONFIG,
        UNAVAILABLE
    }

    public FirebaseInstallationsException(@NonNull Status status) {
        this.f19590a = status;
    }

    @NonNull
    public Status getStatus() {
        return this.f19590a;
    }

    public FirebaseInstallationsException(@NonNull String str, @NonNull Status status) {
        super(str);
        this.f19590a = status;
    }

    public FirebaseInstallationsException(@NonNull String str, @NonNull Status status, @NonNull Throwable th) {
        super(str, th);
        this.f19590a = status;
    }
}
