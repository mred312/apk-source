package com.google.android.datatransport.runtime.util;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.google.android.datatransport.Priority;
import java.util.EnumMap;

public final class PriorityMapping {

    /* renamed from: a */
    private static SparseArray<Priority> f7410a = new SparseArray<>();

    /* renamed from: b */
    private static EnumMap<Priority, Integer> f7411b;

    static {
        EnumMap<Priority, Integer> enumMap = new EnumMap<>(Priority.class);
        f7411b = enumMap;
        enumMap.put(Priority.DEFAULT, 0);
        f7411b.put(Priority.VERY_LOW, 1);
        f7411b.put(Priority.HIGHEST, 2);
        for (Priority next : f7411b.keySet()) {
            f7410a.append(f7411b.get(next).intValue(), next);
        }
    }

    public static int toInt(@NonNull Priority priority) {
        Integer num = f7411b.get(priority);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + priority);
    }

    @NonNull
    public static Priority valueOf(int i) {
        Priority priority = f7410a.get(i);
        if (priority != null) {
            return priority;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i);
    }
}
