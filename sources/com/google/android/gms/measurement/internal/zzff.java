package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzff {

    /* renamed from: a */
    private final String f18560a;

    /* renamed from: b */
    private final boolean f18561b;

    /* renamed from: c */
    private boolean f18562c;

    /* renamed from: d */
    private boolean f18563d;

    /* renamed from: e */
    private final /* synthetic */ C3049m3 f18564e;

    public zzff(C3049m3 m3Var, String str, boolean z) {
        this.f18564e = m3Var;
        Preconditions.checkNotEmpty(str);
        this.f18560a = str;
        this.f18561b = z;
    }

    @WorkerThread
    public final boolean zza() {
        if (!this.f18562c) {
            this.f18562c = true;
            this.f18563d = this.f18564e.mo20043h().getBoolean(this.f18560a, this.f18561b);
        }
        return this.f18563d;
    }

    @WorkerThread
    public final void zza(boolean z) {
        SharedPreferences.Editor edit = this.f18564e.mo20043h().edit();
        edit.putBoolean(this.f18560a, z);
        edit.apply();
        this.f18563d = z;
    }
}
