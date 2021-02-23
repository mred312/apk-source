package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzepe {
    /* renamed from: a */
    static <T> HashSet<T> m8916a(int i) {
        return new HashSet<>(m8917b(i));
    }

    /* renamed from: b */
    private static int m8917b(int i) {
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((((float) i) / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static <T> List<T> zzic(int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        return new ArrayList(i);
    }

    public static <K, V> LinkedHashMap<K, V> zzie(int i) {
        return new LinkedHashMap<>(m8917b(i));
    }
}
