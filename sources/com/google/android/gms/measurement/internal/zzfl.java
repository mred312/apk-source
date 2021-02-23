package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.MainThread;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.internal.measurement.zzg;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzfl implements ServiceConnection {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f18580a;

    /* renamed from: b */
    final /* synthetic */ zzfi f18581b;

    zzfl(zzfi zzfi, String str) {
        this.f18581b = zzfi;
        this.f18580a = str;
    }

    @MainThread
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.f18581b.f18575a.zzq().zzh().zza("Install Referrer connection returned with null binder");
            return;
        }
        try {
            zzd zza = zzg.zza(iBinder);
            if (zza == null) {
                this.f18581b.f18575a.zzq().zzh().zza("Install Referrer Service implementation was not found");
                return;
            }
            this.f18581b.f18575a.zzq().zzw().zza("Install Referrer Service connected");
            this.f18581b.f18575a.zzp().zza((Runnable) new C3058n3(this, zza, this));
        } catch (Exception e) {
            this.f18581b.f18575a.zzq().zzh().zza("Exception occurred while calling Install Referrer API", e);
        }
    }

    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f18581b.f18575a.zzq().zzw().zza("Install Referrer Service disconnected");
    }
}
