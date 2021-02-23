package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzfg {
    @VisibleForTesting

    /* renamed from: a */
    private final String f18565a;

    /* renamed from: b */
    private final String f18566b;

    /* renamed from: c */
    private final String f18567c;

    /* renamed from: d */
    private final long f18568d;

    /* renamed from: e */
    private final /* synthetic */ C3049m3 f18569e;

    private zzfg(C3049m3 m3Var, String str, long j) {
        this.f18569e = m3Var;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkArgument(j > 0);
        this.f18565a = String.valueOf(str).concat(":start");
        this.f18566b = String.valueOf(str).concat(":count");
        this.f18567c = String.valueOf(str).concat(":value");
        this.f18568d = j;
    }

    @WorkerThread
    /* renamed from: a */
    private final void m10782a() {
        this.f18569e.zzc();
        long currentTimeMillis = this.f18569e.zzl().currentTimeMillis();
        SharedPreferences.Editor edit = this.f18569e.mo20043h().edit();
        edit.remove(this.f18566b);
        edit.remove(this.f18567c);
        edit.putLong(this.f18565a, currentTimeMillis);
        edit.apply();
    }

    @WorkerThread
    /* renamed from: b */
    private final long m10783b() {
        return this.f18569e.mo20043h().getLong(this.f18565a, 0);
    }

    @WorkerThread
    public final void zza(String str, long j) {
        this.f18569e.zzc();
        if (m10783b() == 0) {
            m10782a();
        }
        if (str == null) {
            str = "";
        }
        long j2 = this.f18569e.mo20043h().getLong(this.f18566b, 0);
        if (j2 <= 0) {
            SharedPreferences.Editor edit = this.f18569e.mo20043h().edit();
            edit.putString(this.f18567c, str);
            edit.putLong(this.f18566b, 1);
            edit.apply();
            return;
        }
        long j3 = j2 + 1;
        boolean z = (this.f18569e.zzo().mo20564V().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / j3;
        SharedPreferences.Editor edit2 = this.f18569e.mo20043h().edit();
        if (z) {
            edit2.putString(this.f18567c, str);
        }
        edit2.putLong(this.f18566b, j3);
        edit2.apply();
    }

    @WorkerThread
    public final Pair<String, Long> zza() {
        long j;
        this.f18569e.zzc();
        this.f18569e.zzc();
        long b = m10783b();
        if (b == 0) {
            m10782a();
            j = 0;
        } else {
            j = Math.abs(b - this.f18569e.zzl().currentTimeMillis());
        }
        long j2 = this.f18568d;
        if (j < j2) {
            return null;
        }
        if (j > (j2 << 1)) {
            m10782a();
            return null;
        }
        String string = this.f18569e.mo20043h().getString(this.f18567c, (String) null);
        long j3 = this.f18569e.mo20043h().getLong(this.f18566b, 0);
        m10782a();
        if (string == null || j3 <= 0) {
            return C3049m3.f18223C;
        }
        return new Pair<>(string, Long.valueOf(j3));
    }
}
