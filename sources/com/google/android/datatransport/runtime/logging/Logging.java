package com.google.android.datatransport.runtime.logging;

import android.util.Log;

public final class Logging {
    private Logging() {
    }

    /* renamed from: a */
    private static String m5070a(String str) {
        return "TransportRuntime." + str;
    }

    /* renamed from: d */
    public static void m5071d(String str, String str2) {
        Log.d(m5070a(str), str2);
    }

    /* renamed from: e */
    public static void m5075e(String str, String str2, Throwable th) {
        Log.e(m5070a(str), str2, th);
    }

    /* renamed from: i */
    public static void m5076i(String str, String str2) {
        Log.i(m5070a(str), str2);
    }

    /* renamed from: w */
    public static void m5077w(String str, String str2, Object obj) {
        Log.w(m5070a(str), String.format(str2, new Object[]{obj}));
    }

    /* renamed from: d */
    public static void m5072d(String str, String str2, Object obj) {
        Log.d(m5070a(str), String.format(str2, new Object[]{obj}));
    }

    /* renamed from: d */
    public static void m5073d(String str, String str2, Object obj, Object obj2) {
        Log.d(m5070a(str), String.format(str2, new Object[]{obj, obj2}));
    }

    /* renamed from: d */
    public static void m5074d(String str, String str2, Object... objArr) {
        Log.d(m5070a(str), String.format(str2, objArr));
    }
}
