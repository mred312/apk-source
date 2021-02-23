package com.google.android.datatransport;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class Encoding {

    /* renamed from: a */
    private final String f7074a;

    private Encoding(@NonNull String str) {
        if (str != null) {
            this.f7074a = str;
            return;
        }
        throw new NullPointerException("name is null");
    }

    /* renamed from: of */
    public static Encoding m5015of(@NonNull String str) {
        return new Encoding(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Encoding)) {
            return false;
        }
        return this.f7074a.equals(((Encoding) obj).f7074a);
    }

    public String getName() {
        return this.f7074a;
    }

    public int hashCode() {
        return this.f7074a.hashCode() ^ 1000003;
    }

    @NonNull
    public String toString() {
        return "Encoding{name=\"" + this.f7074a + "\"}";
    }
}
