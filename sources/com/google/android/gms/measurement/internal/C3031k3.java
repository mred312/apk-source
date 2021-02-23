package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

/* renamed from: com.google.android.gms.measurement.internal.k3 */
/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
class C3031k3 extends BroadcastReceiver {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzki f18192a;

    /* renamed from: b */
    private boolean f18193b;

    /* renamed from: c */
    private boolean f18194c;

    static {
        Class<C3031k3> cls = C3031k3.class;
    }

    C3031k3(zzki zzki) {
        Preconditions.checkNotNull(zzki);
        this.f18192a = zzki;
    }

    @WorkerThread
    /* renamed from: b */
    public final void mo20012b() {
        this.f18192a.mo20508R();
        this.f18192a.zzp().zzc();
        if (!this.f18193b) {
            this.f18192a.zzm().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f18194c = this.f18192a.zzd().zze();
            this.f18192a.zzq().zzw().zza("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f18194c));
            this.f18193b = true;
        }
    }

    @WorkerThread
    /* renamed from: c */
    public final void mo20013c() {
        this.f18192a.mo20508R();
        this.f18192a.zzp().zzc();
        this.f18192a.zzp().zzc();
        if (this.f18193b) {
            this.f18192a.zzq().zzw().zza("Unregistering connectivity change receiver");
            this.f18193b = false;
            this.f18194c = false;
            try {
                this.f18192a.zzm().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.f18192a.zzq().zze().zza("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    @MainThread
    public void onReceive(Context context, Intent intent) {
        this.f18192a.mo20508R();
        String action = intent.getAction();
        this.f18192a.zzq().zzw().zza("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean zze = this.f18192a.zzd().zze();
            if (this.f18194c != zze) {
                this.f18194c = zze;
                this.f18192a.zzp().zza((Runnable) new C3022j3(this, zze));
                return;
            }
            return;
        }
        this.f18192a.zzq().zzh().zza("NetworkBroadcastReceiver received unknown action", action);
    }
}
