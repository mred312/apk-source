package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzfj {

    /* renamed from: a */
    private final String f18576a;

    /* renamed from: b */
    private boolean f18577b;

    /* renamed from: c */
    private String f18578c;

    /* renamed from: d */
    private final /* synthetic */ C3049m3 f18579d;

    public zzfj(C3049m3 m3Var, String str, String str2) {
        this.f18579d = m3Var;
        Preconditions.checkNotEmpty(str);
        this.f18576a = str;
    }

    @WorkerThread
    public final String zza() {
        if (!this.f18577b) {
            this.f18577b = true;
            this.f18578c = this.f18579d.mo20043h().getString(this.f18576a, (String) null);
        }
        return this.f18578c;
    }

    @WorkerThread
    public final void zza(String str) {
        SharedPreferences.Editor edit = this.f18579d.mo20043h().edit();
        edit.putString(this.f18576a, str);
        edit.apply();
        this.f18578c = str;
    }
}
