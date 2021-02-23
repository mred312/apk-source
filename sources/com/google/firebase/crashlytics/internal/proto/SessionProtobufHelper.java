package com.google.firebase.crashlytics.internal.proto;

import android.app.ActivityManager;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.stacktrace.TrimmedThrowableData;
import java.util.List;
import java.util.Map;

public class SessionProtobufHelper {

    /* renamed from: a */
    private static final C3447a f19481a = C3447a.m11676c("0");

    /* renamed from: b */
    private static final C3447a f19482b = C3447a.m11676c("Unity");

    private SessionProtobufHelper() {
    }

    /* renamed from: a */
    private static int m11651a(C3447a aVar, C3447a aVar2) {
        int computeUInt64Size = CodedOutputStream.computeUInt64Size(1, 0) + 0 + CodedOutputStream.computeUInt64Size(2, 0) + CodedOutputStream.computeBytesSize(3, aVar);
        return aVar2 != null ? computeUInt64Size + CodedOutputStream.computeBytesSize(4, aVar2) : computeUInt64Size;
    }

    /* renamed from: b */
    private static int m11652b(String str, String str2) {
        int computeBytesSize = CodedOutputStream.computeBytesSize(1, C3447a.m11676c(str));
        if (str2 == null) {
            str2 = "";
        }
        return computeBytesSize + CodedOutputStream.computeBytesSize(2, C3447a.m11676c(str2));
    }

    /* renamed from: c */
    private static int m11653c(TrimmedThrowableData trimmedThrowableData, int i, int i2) {
        int i3 = 0;
        int computeBytesSize = CodedOutputStream.computeBytesSize(1, C3447a.m11676c(trimmedThrowableData.className)) + 0;
        String str = trimmedThrowableData.localizedMessage;
        if (str != null) {
            computeBytesSize += CodedOutputStream.computeBytesSize(3, C3447a.m11676c(str));
        }
        for (StackTraceElement i4 : trimmedThrowableData.stacktrace) {
            int i5 = m11659i(i4, true);
            computeBytesSize += CodedOutputStream.computeTagSize(4) + CodedOutputStream.computeRawVarint32Size(i5) + i5;
        }
        TrimmedThrowableData trimmedThrowableData2 = trimmedThrowableData.cause;
        if (trimmedThrowableData2 == null) {
            return computeBytesSize;
        }
        if (i < i2) {
            int c = m11653c(trimmedThrowableData2, i + 1, i2);
            return computeBytesSize + CodedOutputStream.computeTagSize(6) + CodedOutputStream.computeRawVarint32Size(c) + c;
        }
        while (trimmedThrowableData2 != null) {
            trimmedThrowableData2 = trimmedThrowableData2.cause;
            i3++;
        }
        return computeBytesSize + CodedOutputStream.computeUInt32Size(7, i3);
    }

    /* renamed from: d */
    private static int m11654d() {
        C3447a aVar = f19481a;
        return CodedOutputStream.computeBytesSize(1, aVar) + 0 + CodedOutputStream.computeBytesSize(2, aVar) + CodedOutputStream.computeUInt64Size(3, 0);
    }

    /* renamed from: e */
    private static int m11655e(TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, C3447a aVar, C3447a aVar2) {
        int n = m11664n(thread, stackTraceElementArr, 4, true);
        int computeTagSize = CodedOutputStream.computeTagSize(1) + CodedOutputStream.computeRawVarint32Size(n) + n + 0;
        int length = threadArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            int n2 = m11664n(threadArr[i2], list.get(i2), 0, false);
            computeTagSize += CodedOutputStream.computeTagSize(1) + CodedOutputStream.computeRawVarint32Size(n2) + n2;
        }
        int c = m11653c(trimmedThrowableData, 1, i);
        int d = m11654d();
        int a = m11651a(aVar, aVar2);
        return computeTagSize + CodedOutputStream.computeTagSize(2) + CodedOutputStream.computeRawVarint32Size(c) + c + CodedOutputStream.computeTagSize(3) + CodedOutputStream.computeRawVarint32Size(d) + d + CodedOutputStream.computeTagSize(3) + CodedOutputStream.computeRawVarint32Size(a) + a;
    }

    /* renamed from: f */
    private static int m11656f(TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, C3447a aVar, C3447a aVar2, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2) {
        int e = m11655e(trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, aVar, aVar2);
        boolean z = true;
        int computeTagSize = CodedOutputStream.computeTagSize(1) + CodedOutputStream.computeRawVarint32Size(e) + e + 0;
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                int b = m11652b((String) next.getKey(), (String) next.getValue());
                computeTagSize += CodedOutputStream.computeTagSize(2) + CodedOutputStream.computeRawVarint32Size(b) + b;
            }
        }
        if (runningAppProcessInfo != null) {
            if (runningAppProcessInfo.importance == 100) {
                z = false;
            }
            computeTagSize += CodedOutputStream.computeBoolSize(3, z);
        }
        return computeTagSize + CodedOutputStream.computeUInt32Size(4, i2);
    }

    /* renamed from: g */
    private static int m11657g(Float f, int i, boolean z, int i2, long j, long j2) {
        int i3 = 0;
        if (f != null) {
            i3 = 0 + CodedOutputStream.computeFloatSize(1, f.floatValue());
        }
        return i3 + CodedOutputStream.computeSInt32Size(2, i) + CodedOutputStream.computeBoolSize(3, z) + CodedOutputStream.computeUInt32Size(4, i2) + CodedOutputStream.computeUInt64Size(5, j) + CodedOutputStream.computeUInt64Size(6, j2);
    }

    /* renamed from: h */
    private static int m11658h(C3447a aVar) {
        return CodedOutputStream.computeBytesSize(1, aVar);
    }

    /* renamed from: i */
    private static int m11659i(StackTraceElement stackTraceElement, boolean z) {
        int i;
        int i2 = 0;
        if (stackTraceElement.isNativeMethod()) {
            i = CodedOutputStream.computeUInt64Size(1, (long) Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            i = CodedOutputStream.computeUInt64Size(1, 0);
        }
        int computeBytesSize = i + 0 + CodedOutputStream.computeBytesSize(2, C3447a.m11676c(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            computeBytesSize += CodedOutputStream.computeBytesSize(3, C3447a.m11676c(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            computeBytesSize += CodedOutputStream.computeUInt64Size(4, (long) stackTraceElement.getLineNumber());
        }
        if (z) {
            i2 = 2;
        }
        return computeBytesSize + CodedOutputStream.computeUInt32Size(5, i2);
    }

    /* renamed from: j */
    private static int m11660j(C3447a aVar, C3447a aVar2, C3447a aVar3, C3447a aVar4, int i, C3447a aVar5) {
        int computeBytesSize = CodedOutputStream.computeBytesSize(1, aVar) + 0 + CodedOutputStream.computeBytesSize(2, aVar2) + CodedOutputStream.computeBytesSize(3, aVar3) + CodedOutputStream.computeBytesSize(6, aVar4);
        if (aVar5 != null) {
            computeBytesSize = computeBytesSize + CodedOutputStream.computeBytesSize(8, f19482b) + CodedOutputStream.computeBytesSize(9, aVar5);
        }
        return computeBytesSize + CodedOutputStream.computeEnumSize(10, i);
    }

    /* renamed from: k */
    private static int m11661k(int i, C3447a aVar, int i2, long j, long j2, boolean z, int i3, C3447a aVar2, C3447a aVar3) {
        int i4;
        int i5;
        int i6 = 0;
        int computeEnumSize = CodedOutputStream.computeEnumSize(3, i) + 0;
        if (aVar == null) {
            i4 = 0;
        } else {
            i4 = CodedOutputStream.computeBytesSize(4, aVar);
        }
        int computeUInt32Size = computeEnumSize + i4 + CodedOutputStream.computeUInt32Size(5, i2) + CodedOutputStream.computeUInt64Size(6, j) + CodedOutputStream.computeUInt64Size(7, j2) + CodedOutputStream.computeBoolSize(10, z) + CodedOutputStream.computeUInt32Size(12, i3);
        if (aVar2 == null) {
            i5 = 0;
        } else {
            i5 = CodedOutputStream.computeBytesSize(13, aVar2);
        }
        int i7 = computeUInt32Size + i5;
        if (aVar3 != null) {
            i6 = CodedOutputStream.computeBytesSize(14, aVar3);
        }
        return i7 + i6;
    }

    /* renamed from: l */
    private static int m11662l(long j, String str, TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2, C3447a aVar, C3447a aVar2, Float f, int i3, boolean z, long j2, long j3, C3447a aVar3) {
        long j4 = j;
        int computeUInt64Size = CodedOutputStream.computeUInt64Size(1, j) + 0 + CodedOutputStream.computeBytesSize(2, C3447a.m11676c(str));
        int f2 = m11656f(trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, aVar, aVar2, map, runningAppProcessInfo, i2);
        int g = m11657g(f, i3, z, i2, j2, j3);
        int computeTagSize = computeUInt64Size + CodedOutputStream.computeTagSize(3) + CodedOutputStream.computeRawVarint32Size(f2) + f2 + CodedOutputStream.computeTagSize(5) + CodedOutputStream.computeRawVarint32Size(g) + g;
        if (aVar3 == null) {
            return computeTagSize;
        }
        int h = m11658h(aVar3);
        return computeTagSize + CodedOutputStream.computeTagSize(6) + CodedOutputStream.computeRawVarint32Size(h) + h;
    }

    /* renamed from: m */
    private static int m11663m(C3447a aVar, C3447a aVar2, boolean z) {
        return CodedOutputStream.computeEnumSize(1, 3) + 0 + CodedOutputStream.computeBytesSize(2, aVar) + CodedOutputStream.computeBytesSize(3, aVar2) + CodedOutputStream.computeBoolSize(4, z);
    }

    /* renamed from: n */
    private static int m11664n(Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) {
        int computeBytesSize = CodedOutputStream.computeBytesSize(1, C3447a.m11676c(thread.getName())) + CodedOutputStream.computeUInt32Size(2, i);
        for (StackTraceElement i2 : stackTraceElementArr) {
            int i3 = m11659i(i2, z);
            computeBytesSize += CodedOutputStream.computeTagSize(3) + CodedOutputStream.computeRawVarint32Size(i3) + i3;
        }
        return computeBytesSize;
    }

    /* renamed from: o */
    private static C3447a m11665o(String str) {
        if (str == null) {
            return null;
        }
        return C3447a.m11676c(str);
    }

    /* renamed from: p */
    private static void m11666p(CodedOutputStream codedOutputStream, int i, StackTraceElement stackTraceElement, boolean z) {
        codedOutputStream.writeTag(i, 2);
        codedOutputStream.writeRawVarint32(m11659i(stackTraceElement, z));
        int i2 = 0;
        if (stackTraceElement.isNativeMethod()) {
            codedOutputStream.writeUInt64(1, (long) Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            codedOutputStream.writeUInt64(1, 0);
        }
        codedOutputStream.writeBytes(2, C3447a.m11676c(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            codedOutputStream.writeBytes(3, C3447a.m11676c(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            codedOutputStream.writeUInt64(4, (long) stackTraceElement.getLineNumber());
        }
        if (z) {
            i2 = 4;
        }
        codedOutputStream.writeUInt32(5, i2);
    }

    /* renamed from: q */
    private static void m11667q(CodedOutputStream codedOutputStream, TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, C3447a aVar, C3447a aVar2, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2) {
        codedOutputStream.writeTag(3, 2);
        codedOutputStream.writeRawVarint32(m11656f(trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, aVar, aVar2, map, runningAppProcessInfo, i2));
        m11669s(codedOutputStream, trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, aVar, aVar2);
        if (map != null && !map.isEmpty()) {
            m11668r(codedOutputStream, map);
        }
        if (runningAppProcessInfo != null) {
            codedOutputStream.writeBool(3, runningAppProcessInfo.importance != 100);
        }
        codedOutputStream.writeUInt32(4, i2);
    }

    /* renamed from: r */
    private static void m11668r(CodedOutputStream codedOutputStream, Map<String, String> map) {
        for (Map.Entry next : map.entrySet()) {
            codedOutputStream.writeTag(2, 2);
            codedOutputStream.writeRawVarint32(m11652b((String) next.getKey(), (String) next.getValue()));
            codedOutputStream.writeBytes(1, C3447a.m11676c((String) next.getKey()));
            String str = (String) next.getValue();
            if (str == null) {
                str = "";
            }
            codedOutputStream.writeBytes(2, C3447a.m11676c(str));
        }
    }

    /* renamed from: s */
    private static void m11669s(CodedOutputStream codedOutputStream, TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, C3447a aVar, C3447a aVar2) {
        codedOutputStream.writeTag(1, 2);
        codedOutputStream.writeRawVarint32(m11655e(trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, aVar, aVar2));
        m11673w(codedOutputStream, thread, stackTraceElementArr, 4, true);
        int length = threadArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            m11673w(codedOutputStream, threadArr[i2], list.get(i2), 0, false);
        }
        m11670t(codedOutputStream, trimmedThrowableData, 1, i, 2);
        codedOutputStream.writeTag(3, 2);
        codedOutputStream.writeRawVarint32(m11654d());
        C3447a aVar3 = f19481a;
        codedOutputStream.writeBytes(1, aVar3);
        codedOutputStream.writeBytes(2, aVar3);
        codedOutputStream.writeUInt64(3, 0);
        codedOutputStream.writeTag(4, 2);
        codedOutputStream.writeRawVarint32(m11651a(aVar, aVar2));
        codedOutputStream.writeUInt64(1, 0);
        codedOutputStream.writeUInt64(2, 0);
        codedOutputStream.writeBytes(3, aVar);
        if (aVar2 != null) {
            codedOutputStream.writeBytes(4, aVar2);
        }
    }

    /* renamed from: t */
    private static void m11670t(CodedOutputStream codedOutputStream, TrimmedThrowableData trimmedThrowableData, int i, int i2, int i3) {
        codedOutputStream.writeTag(i3, 2);
        codedOutputStream.writeRawVarint32(m11653c(trimmedThrowableData, 1, i2));
        codedOutputStream.writeBytes(1, C3447a.m11676c(trimmedThrowableData.className));
        String str = trimmedThrowableData.localizedMessage;
        if (str != null) {
            codedOutputStream.writeBytes(3, C3447a.m11676c(str));
        }
        int i4 = 0;
        for (StackTraceElement p : trimmedThrowableData.stacktrace) {
            m11666p(codedOutputStream, 4, p, true);
        }
        TrimmedThrowableData trimmedThrowableData2 = trimmedThrowableData.cause;
        if (trimmedThrowableData2 == null) {
            return;
        }
        if (i < i2) {
            m11670t(codedOutputStream, trimmedThrowableData2, i + 1, i2, 6);
            return;
        }
        while (trimmedThrowableData2 != null) {
            trimmedThrowableData2 = trimmedThrowableData2.cause;
            i4++;
        }
        codedOutputStream.writeUInt32(7, i4);
    }

    /* renamed from: u */
    private static void m11671u(CodedOutputStream codedOutputStream, Float f, int i, boolean z, int i2, long j, long j2) {
        codedOutputStream.writeTag(5, 2);
        codedOutputStream.writeRawVarint32(m11657g(f, i, z, i2, j, j2));
        if (f != null) {
            codedOutputStream.writeFloat(1, f.floatValue());
        }
        codedOutputStream.writeSInt32(2, i);
        codedOutputStream.writeBool(3, z);
        codedOutputStream.writeUInt32(4, i2);
        codedOutputStream.writeUInt64(5, j);
        codedOutputStream.writeUInt64(6, j2);
    }

    /* renamed from: v */
    private static void m11672v(CodedOutputStream codedOutputStream, C3447a aVar) {
        if (aVar != null) {
            codedOutputStream.writeTag(6, 2);
            codedOutputStream.writeRawVarint32(m11658h(aVar));
            codedOutputStream.writeBytes(1, aVar);
        }
    }

    /* renamed from: w */
    private static void m11673w(CodedOutputStream codedOutputStream, Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) {
        codedOutputStream.writeTag(1, 2);
        codedOutputStream.writeRawVarint32(m11664n(thread, stackTraceElementArr, i, z));
        codedOutputStream.writeBytes(1, C3447a.m11676c(thread.getName()));
        codedOutputStream.writeUInt32(2, i);
        for (StackTraceElement p : stackTraceElementArr) {
            m11666p(codedOutputStream, 3, p, z);
        }
    }

    public static void writeBeginSession(CodedOutputStream codedOutputStream, String str, String str2, long j) {
        codedOutputStream.writeBytes(1, C3447a.m11676c(str2));
        codedOutputStream.writeBytes(2, C3447a.m11676c(str));
        codedOutputStream.writeUInt64(3, j);
    }

    public static void writeSessionApp(CodedOutputStream codedOutputStream, String str, String str2, String str3, String str4, int i, String str5) {
        C3447a c = C3447a.m11676c(str);
        C3447a c2 = C3447a.m11676c(str2);
        C3447a c3 = C3447a.m11676c(str3);
        C3447a c4 = C3447a.m11676c(str4);
        C3447a c5 = str5 != null ? C3447a.m11676c(str5) : null;
        codedOutputStream.writeTag(7, 2);
        codedOutputStream.writeRawVarint32(m11660j(c, c2, c3, c4, i, c5));
        codedOutputStream.writeBytes(1, c);
        codedOutputStream.writeBytes(2, c2);
        codedOutputStream.writeBytes(3, c3);
        codedOutputStream.writeBytes(6, c4);
        if (c5 != null) {
            codedOutputStream.writeBytes(8, f19482b);
            codedOutputStream.writeBytes(9, c5);
        }
        codedOutputStream.writeEnum(10, i);
    }

    public static void writeSessionAppClsId(CodedOutputStream codedOutputStream, String str) {
        C3447a c = C3447a.m11676c(str);
        codedOutputStream.writeTag(7, 2);
        int computeBytesSize = CodedOutputStream.computeBytesSize(2, c);
        codedOutputStream.writeRawVarint32(CodedOutputStream.computeTagSize(5) + CodedOutputStream.computeRawVarint32Size(computeBytesSize) + computeBytesSize);
        codedOutputStream.writeTag(5, 2);
        codedOutputStream.writeRawVarint32(computeBytesSize);
        codedOutputStream.writeBytes(2, c);
    }

    public static void writeSessionDevice(CodedOutputStream codedOutputStream, int i, String str, int i2, long j, long j2, boolean z, int i3, String str2, String str3) {
        CodedOutputStream codedOutputStream2 = codedOutputStream;
        C3447a o = m11665o(str);
        C3447a o2 = m11665o(str3);
        C3447a o3 = m11665o(str2);
        codedOutputStream.writeTag(9, 2);
        codedOutputStream.writeRawVarint32(m11661k(i, o, i2, j, j2, z, i3, o3, o2));
        codedOutputStream.writeEnum(3, i);
        codedOutputStream.writeBytes(4, o);
        codedOutputStream.writeUInt32(5, i2);
        codedOutputStream.writeUInt64(6, j);
        codedOutputStream.writeUInt64(7, j2);
        codedOutputStream.writeBool(10, z);
        codedOutputStream.writeUInt32(12, i3);
        if (o3 != null) {
            codedOutputStream.writeBytes(13, o3);
        }
        if (o2 != null) {
            codedOutputStream.writeBytes(14, o2);
        }
    }

    public static void writeSessionEvent(CodedOutputStream codedOutputStream, long j, String str, TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, Map<String, String> map, byte[] bArr, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2, String str2, String str3, Float f, int i3, boolean z, long j2, long j3) {
        C3447a aVar;
        CodedOutputStream codedOutputStream2 = codedOutputStream;
        String str4 = str3;
        C3447a c = C3447a.m11676c(str2);
        C3447a aVar2 = null;
        if (str4 == null) {
            aVar = null;
        } else {
            aVar = C3447a.m11676c(str4.replace("-", ""));
        }
        if (bArr != null) {
            aVar2 = C3447a.m11674a(bArr);
        } else {
            Logger.getLogger().mo20859d("No log data to include with this event.");
        }
        C3447a aVar3 = aVar2;
        codedOutputStream2.writeTag(10, 2);
        codedOutputStream2.writeRawVarint32(m11662l(j, str, trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, map, runningAppProcessInfo, i2, c, aVar, f, i3, z, j2, j3, aVar3));
        codedOutputStream2.writeUInt64(1, j);
        codedOutputStream2.writeBytes(2, C3447a.m11676c(str));
        m11667q(codedOutputStream, trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, c, aVar, map, runningAppProcessInfo, i2);
        m11671u(codedOutputStream, f, i3, z, i2, j2, j3);
        m11672v(codedOutputStream2, aVar3);
    }

    public static void writeSessionOS(CodedOutputStream codedOutputStream, String str, String str2, boolean z) {
        C3447a c = C3447a.m11676c(str);
        C3447a c2 = C3447a.m11676c(str2);
        codedOutputStream.writeTag(8, 2);
        codedOutputStream.writeRawVarint32(m11663m(c, c2, z));
        codedOutputStream.writeEnum(1, 3);
        codedOutputStream.writeBytes(2, c);
        codedOutputStream.writeBytes(3, c2);
        codedOutputStream.writeBool(4, z);
    }

    public static void writeSessionUser(CodedOutputStream codedOutputStream, String str, String str2, String str3) {
        if (str == null) {
            str = "";
        }
        C3447a c = C3447a.m11676c(str);
        C3447a o = m11665o(str2);
        C3447a o2 = m11665o(str3);
        int computeBytesSize = CodedOutputStream.computeBytesSize(1, c) + 0;
        if (str2 != null) {
            computeBytesSize += CodedOutputStream.computeBytesSize(2, o);
        }
        if (str3 != null) {
            computeBytesSize += CodedOutputStream.computeBytesSize(3, o2);
        }
        codedOutputStream.writeTag(6, 2);
        codedOutputStream.writeRawVarint32(computeBytesSize);
        codedOutputStream.writeBytes(1, c);
        if (str2 != null) {
            codedOutputStream.writeBytes(2, o);
        }
        if (str3 != null) {
            codedOutputStream.writeBytes(3, o2);
        }
    }
}
