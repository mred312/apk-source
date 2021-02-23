package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.common.internal.e */
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
final class C1684e implements ServiceConnection, zzj {

    /* renamed from: a */
    private final Map<ServiceConnection, ServiceConnection> f7566a = new HashMap();

    /* renamed from: b */
    private int f7567b = 2;

    /* renamed from: c */
    private boolean f7568c;
    @Nullable

    /* renamed from: d */
    private IBinder f7569d;

    /* renamed from: e */
    private final GmsClientSupervisor.zza f7570e;

    /* renamed from: f */
    private ComponentName f7571f;

    /* renamed from: g */
    private final /* synthetic */ C1682c f7572g;

    public C1684e(C1682c cVar, GmsClientSupervisor.zza zza) {
        this.f7572g = cVar;
        this.f7570e = zza;
    }

    /* renamed from: a */
    public final void mo12993a(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f7566a.put(serviceConnection, serviceConnection2);
    }

    /* renamed from: b */
    public final void mo12994b(ServiceConnection serviceConnection, String str) {
        this.f7566a.remove(serviceConnection);
    }

    /* renamed from: c */
    public final void mo12995c(String str) {
        this.f7567b = 3;
        boolean zza = this.f7572g.f7562g.zza(this.f7572g.f7560e, str, this.f7570e.zza(this.f7572g.f7560e), this, this.f7570e.zzc());
        this.f7568c = zza;
        if (zza) {
            this.f7572g.f7561f.sendMessageDelayed(this.f7572g.f7561f.obtainMessage(1, this.f7570e), this.f7572g.f7564i);
            return;
        }
        this.f7567b = 2;
        try {
            this.f7572g.f7562g.unbindService(this.f7572g.f7560e, this);
        } catch (IllegalArgumentException unused) {
        }
    }

    /* renamed from: d */
    public final boolean mo12996d() {
        return this.f7568c;
    }

    /* renamed from: e */
    public final boolean mo12997e(ServiceConnection serviceConnection) {
        return this.f7566a.containsKey(serviceConnection);
    }

    /* renamed from: f */
    public final int mo12998f() {
        return this.f7567b;
    }

    /* renamed from: g */
    public final void mo12999g(String str) {
        this.f7572g.f7561f.removeMessages(1, this.f7570e);
        this.f7572g.f7562g.unbindService(this.f7572g.f7560e, this);
        this.f7568c = false;
        this.f7567b = 2;
    }

    /* renamed from: h */
    public final boolean mo13000h() {
        return this.f7566a.isEmpty();
    }

    @Nullable
    /* renamed from: i */
    public final IBinder mo13001i() {
        return this.f7569d;
    }

    /* renamed from: j */
    public final ComponentName mo13002j() {
        return this.f7571f;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f7572g.f7559d) {
            this.f7572g.f7561f.removeMessages(1, this.f7570e);
            this.f7569d = iBinder;
            this.f7571f = componentName;
            for (ServiceConnection onServiceConnected : this.f7566a.values()) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.f7567b = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f7572g.f7559d) {
            this.f7572g.f7561f.removeMessages(1, this.f7570e);
            this.f7569d = null;
            this.f7571f = componentName;
            for (ServiceConnection onServiceDisconnected : this.f7566a.values()) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.f7567b = 2;
        }
    }
}
