package androidx.core.content;

import android.content.LocusId;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

public final class LocusIdCompat {

    /* renamed from: a */
    private final String f2260a;

    /* renamed from: b */
    private final LocusId f2261b;

    @RequiresApi(29)
    /* renamed from: androidx.core.content.LocusIdCompat$a */
    private static class C0441a {
        @NonNull
        /* renamed from: a */
        static LocusId m1481a(@NonNull String str) {
            return new LocusId(str);
        }

        @NonNull
        /* renamed from: b */
        static String m1482b(@NonNull LocusId locusId) {
            return locusId.getId();
        }
    }

    public LocusIdCompat(@NonNull String str) {
        this.f2260a = (String) Preconditions.checkStringNotEmpty(str, "id cannot be empty");
        if (Build.VERSION.SDK_INT >= 29) {
            this.f2261b = C0441a.m1481a(str);
        } else {
            this.f2261b = null;
        }
    }

    @NonNull
    /* renamed from: a */
    private String m1480a() {
        int length = this.f2260a.length();
        return length + "_chars";
    }

    @RequiresApi(29)
    @NonNull
    public static LocusIdCompat toLocusIdCompat(@NonNull LocusId locusId) {
        Preconditions.checkNotNull(locusId, "locusId cannot be null");
        return new LocusIdCompat((String) Preconditions.checkStringNotEmpty(C0441a.m1482b(locusId), "id cannot be empty"));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || LocusIdCompat.class != obj.getClass()) {
            return false;
        }
        LocusIdCompat locusIdCompat = (LocusIdCompat) obj;
        String str = this.f2260a;
        if (str != null) {
            return str.equals(locusIdCompat.f2260a);
        }
        if (locusIdCompat.f2260a == null) {
            return true;
        }
        return false;
    }

    @NonNull
    public String getId() {
        return this.f2260a;
    }

    public int hashCode() {
        String str = this.f2260a;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    @RequiresApi(29)
    @NonNull
    public LocusId toLocusId() {
        return this.f2261b;
    }

    @NonNull
    public String toString() {
        return "LocusIdCompat[" + m1480a() + "]";
    }
}
