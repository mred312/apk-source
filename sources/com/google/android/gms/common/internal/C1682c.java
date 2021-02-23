package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import androidx.work.PeriodicWorkRequest;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.common.zzi;
import java.util.HashMap;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: com.google.android.gms.common.internal.c */
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
final class C1682c extends GmsClientSupervisor {
    /* access modifiers changed from: private */
    @GuardedBy("connectionStatus")

    /* renamed from: d */
    public final HashMap<GmsClientSupervisor.zza, C1684e> f7559d = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Context f7560e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Handler f7561f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final ConnectionTracker f7562g;

    /* renamed from: h */
    private final long f7563h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final long f7564i;

    C1682c(Context context) {
        this.f7560e = context.getApplicationContext();
        this.f7561f = new zzi(context.getMainLooper(), new C1683d(this));
        this.f7562g = ConnectionTracker.getInstance();
        this.f7563h = 5000;
        this.f7564i = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
    }

    /* access modifiers changed from: protected */
    public final boolean zza(GmsClientSupervisor.zza zza, ServiceConnection serviceConnection, String str) {
        boolean d;
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f7559d) {
            C1684e eVar = this.f7559d.get(zza);
            if (eVar == null) {
                eVar = new C1684e(this, zza);
                eVar.mo12993a(serviceConnection, serviceConnection, str);
                eVar.mo12995c(str);
                this.f7559d.put(zza, eVar);
            } else {
                this.f7561f.removeMessages(0, zza);
                if (!eVar.mo12997e(serviceConnection)) {
                    eVar.mo12993a(serviceConnection, serviceConnection, str);
                    int f = eVar.mo12998f();
                    if (f == 1) {
                        serviceConnection.onServiceConnected(eVar.mo13002j(), eVar.mo13001i());
                    } else if (f == 2) {
                        eVar.mo12995c(str);
                    }
                } else {
                    String valueOf = String.valueOf(zza);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            }
            d = eVar.mo12996d();
        }
        return d;
    }

    /* access modifiers changed from: protected */
    public final void zzb(GmsClientSupervisor.zza zza, ServiceConnection serviceConnection, String str) {
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f7559d) {
            C1684e eVar = this.f7559d.get(zza);
            if (eVar == null) {
                String valueOf = String.valueOf(zza);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            } else if (eVar.mo12997e(serviceConnection)) {
                eVar.mo12994b(serviceConnection, str);
                if (eVar.mo13000h()) {
                    this.f7561f.sendMessageDelayed(this.f7561f.obtainMessage(0, zza), this.f7563h);
                }
            } else {
                String valueOf2 = String.valueOf(zza);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }
}
