package com.google.android.gms.internal.ads;

import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class t10 {
    static {
        Logger.getLogger(t10.class.getName());
    }

    private t10() {
    }

    /* renamed from: a */
    static String m6980a(@NullableDecl String str) {
        if (m6981b(str)) {
            return null;
        }
        return str;
    }

    /* renamed from: b */
    static boolean m6981b(@NullableDecl String str) {
        return str == null || str.isEmpty();
    }

    /* renamed from: c */
    static String m6982c(@NullableDecl String str) {
        return str == null ? "" : str;
    }
}
