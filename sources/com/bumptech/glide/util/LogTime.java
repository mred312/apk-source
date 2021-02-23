package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.SystemClock;

public final class LogTime {

    /* renamed from: a */
    private static final double f6503a;

    static {
        double d = 1.0d;
        if (Build.VERSION.SDK_INT >= 17) {
            d = 1.0d / Math.pow(10.0d, 6.0d);
        }
        f6503a = d;
    }

    private LogTime() {
    }

    public static double getElapsedMillis(long j) {
        double logTime = (double) (getLogTime() - j);
        double d = f6503a;
        Double.isNaN(logTime);
        return logTime * d;
    }

    @TargetApi(17)
    public static long getLogTime() {
        if (Build.VERSION.SDK_INT >= 17) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return SystemClock.uptimeMillis();
    }
}
