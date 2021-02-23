package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzfh {

    /* renamed from: a */
    private final String f18570a;

    /* renamed from: b */
    private final long f18571b;

    /* renamed from: c */
    private boolean f18572c;

    /* renamed from: d */
    private long f18573d;

    /* renamed from: e */
    private final /* synthetic */ C3049m3 f18574e;

    public zzfh(C3049m3 m3Var, String str, long j) {
        this.f18574e = m3Var;
        Preconditions.checkNotEmpty(str);
        this.f18570a = str;
        this.f18571b = j;
    }

    @WorkerThread
    public final long zza() {
        if (!this.f18572c) {
            this.f18572c = true;
            this.f18573d = this.f18574e.mo20043h().getLong(this.f18570a, this.f18571b);
        }
        return this.f18573d;
    }

    @WorkerThread
    public final void zza(long j) {
        SharedPreferences.Editor edit = this.f18574e.mo20043h().edit();
        edit.putLong(this.f18570a, j);
        edit.apply();
        this.f18573d = j;
    }
}
