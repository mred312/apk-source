package com.medio.catchexception;

import com.google.firebase.crashlytics.FirebaseCrashlytics;

public class CatchException {
    public static void log(String str) {
        try {
            FirebaseCrashlytics.getInstance().log(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void logException(Throwable th) {
        try {
            FirebaseCrashlytics.getInstance().recordException(th);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
