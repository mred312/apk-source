package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.google.firebase.heartbeatinfo.b */
/* compiled from: HeartBeatInfoStorage */
class C3469b {

    /* renamed from: b */
    private static C3469b f19572b;

    /* renamed from: a */
    private final SharedPreferences f19573a;

    private C3469b(Context context) {
        this.f19573a = context.getSharedPreferences("FirebaseAppHeartBeat", 0);
    }

    /* renamed from: a */
    static synchronized C3469b m11763a(Context context) {
        C3469b bVar;
        synchronized (C3469b.class) {
            if (f19572b == null) {
                f19572b = new C3469b(context);
            }
            bVar = f19572b;
        }
        return bVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized boolean mo21573b(long j) {
        return mo21574c("fire-global", j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public synchronized boolean mo21574c(String str, long j) {
        if (!this.f19573a.contains(str)) {
            this.f19573a.edit().putLong(str, j).apply();
            return true;
        } else if (j - this.f19573a.getLong(str, -1) < 86400000) {
            return false;
        } else {
            this.f19573a.edit().putLong(str, j).apply();
            return true;
        }
    }
}
