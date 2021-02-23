package com.google.firebase.crashlytics.internal.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;

/* renamed from: com.google.firebase.crashlytics.internal.common.c */
/* compiled from: BatteryState */
class C3278c {

    /* renamed from: a */
    private final Float f19074a;

    /* renamed from: b */
    private final boolean f19075b;

    private C3278c(Float f, boolean z) {
        this.f19075b = z;
        this.f19074a = f;
    }

    /* renamed from: a */
    public static C3278c m11288a(Context context) {
        boolean z;
        Float f = null;
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            z = m11290e(registerReceiver);
            f = m11289d(registerReceiver);
        } else {
            z = false;
        }
        return new C3278c(f, z);
    }

    /* renamed from: d */
    private static Float m11289d(Intent intent) {
        int intExtra = intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
        int intExtra2 = intent.getIntExtra("scale", -1);
        if (intExtra == -1 || intExtra2 == -1) {
            return null;
        }
        return Float.valueOf(((float) intExtra) / ((float) intExtra2));
    }

    /* renamed from: e */
    private static boolean m11290e(Intent intent) {
        int intExtra = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
        if (intExtra == -1) {
            return false;
        }
        return intExtra == 2 || intExtra == 5;
    }

    /* renamed from: b */
    public Float mo20948b() {
        return this.f19074a;
    }

    /* renamed from: c */
    public int mo20949c() {
        Float f;
        if (!this.f19075b || (f = this.f19074a) == null) {
            return 1;
        }
        return ((double) f.floatValue()) < 0.99d ? 2 : 3;
    }
}
