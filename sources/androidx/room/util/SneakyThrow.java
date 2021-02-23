package androidx.room.util;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SneakyThrow {
    private SneakyThrow() {
    }

    /* renamed from: a */
    private static <E extends Throwable> void m3622a(@NonNull Throwable th) {
        throw th;
    }

    public static void reThrow(@NonNull Exception exc) {
        m3622a(exc);
        throw null;
    }
}
