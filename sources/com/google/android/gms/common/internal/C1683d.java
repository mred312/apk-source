package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.core.p003os.EnvironmentCompat;
import com.google.android.gms.common.internal.GmsClientSupervisor;

/* renamed from: com.google.android.gms.common.internal.d */
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
final class C1683d implements Handler.Callback {

    /* renamed from: a */
    private final /* synthetic */ C1682c f7565a;

    private C1683d(C1682c cVar) {
        this.f7565a = cVar;
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.f7565a.f7559d) {
                GmsClientSupervisor.zza zza = (GmsClientSupervisor.zza) message.obj;
                C1684e eVar = (C1684e) this.f7565a.f7559d.get(zza);
                if (eVar != null && eVar.mo13000h()) {
                    if (eVar.mo12996d()) {
                        eVar.mo12999g("GmsClientSupervisor");
                    }
                    this.f7565a.f7559d.remove(zza);
                }
            }
            return true;
        } else if (i != 1) {
            return false;
        } else {
            synchronized (this.f7565a.f7559d) {
                GmsClientSupervisor.zza zza2 = (GmsClientSupervisor.zza) message.obj;
                C1684e eVar2 = (C1684e) this.f7565a.f7559d.get(zza2);
                if (eVar2 != null && eVar2.mo12998f() == 3) {
                    String valueOf = String.valueOf(zza2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Timeout waiting for ServiceConnection callback ");
                    sb.append(valueOf);
                    Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                    ComponentName j = eVar2.mo13002j();
                    if (j == null) {
                        j = zza2.zzb();
                    }
                    if (j == null) {
                        j = new ComponentName((String) Preconditions.checkNotNull(zza2.zza()), EnvironmentCompat.MEDIA_UNKNOWN);
                    }
                    eVar2.onServiceDisconnected(j);
                }
            }
            return true;
        }
    }
}
