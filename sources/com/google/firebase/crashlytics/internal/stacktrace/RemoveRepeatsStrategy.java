package com.google.firebase.crashlytics.internal.stacktrace;

import java.util.HashMap;

public class RemoveRepeatsStrategy implements StackTraceTrimmingStrategy {

    /* renamed from: a */
    private final int f19536a;

    public RemoveRepeatsStrategy() {
        this(1);
    }

    /* renamed from: a */
    private static boolean m11730a(StackTraceElement[] stackTraceElementArr, int i, int i2) {
        int i3 = i2 - i;
        if (i2 + i3 > stackTraceElementArr.length) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!stackTraceElementArr[i + i4].equals(stackTraceElementArr[i2 + i4])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private static StackTraceElement[] m11731b(StackTraceElement[] stackTraceElementArr, int i) {
        int i2;
        HashMap hashMap = new HashMap();
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[stackTraceElementArr.length];
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (i3 < stackTraceElementArr.length) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i3];
            Integer num = (Integer) hashMap.get(stackTraceElement);
            if (num == null || !m11730a(stackTraceElementArr, num.intValue(), i3)) {
                stackTraceElementArr2[i4] = stackTraceElementArr[i3];
                i4++;
                i2 = i3;
                i5 = 1;
            } else {
                int intValue = i3 - num.intValue();
                if (i5 < i) {
                    System.arraycopy(stackTraceElementArr, i3, stackTraceElementArr2, i4, intValue);
                    i4 += intValue;
                    i5++;
                }
                i2 = (intValue - 1) + i3;
            }
            hashMap.put(stackTraceElement, Integer.valueOf(i3));
            i3 = i2 + 1;
        }
        StackTraceElement[] stackTraceElementArr3 = new StackTraceElement[i4];
        System.arraycopy(stackTraceElementArr2, 0, stackTraceElementArr3, 0, i4);
        return stackTraceElementArr3;
    }

    public StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] stackTraceElementArr) {
        StackTraceElement[] b = m11731b(stackTraceElementArr, this.f19536a);
        return b.length < stackTraceElementArr.length ? b : stackTraceElementArr;
    }

    public RemoveRepeatsStrategy(int i) {
        this.f19536a = i;
    }
}
