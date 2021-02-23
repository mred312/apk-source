package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.common.zzn;
import com.google.android.gms.internal.common.zzo;
import java.util.concurrent.ConcurrentHashMap;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public class ConnectionTracker {

    /* renamed from: b */
    private static final Object f7591b = new Object();

    /* renamed from: c */
    private static volatile ConnectionTracker f7592c;

    /* renamed from: d */
    private static zzo<Boolean> f7593d = zzn.zza(C1689a.f7613a);
    @VisibleForTesting

    /* renamed from: a */
    private ConcurrentHashMap<ServiceConnection, ServiceConnection> f7594a = new ConcurrentHashMap<>();

    private ConnectionTracker() {
    }

    @SuppressLint({"UntrackedBindService"})
    /* renamed from: a */
    private static void m5331a(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException e) {
            Log.w("ConnectionTracker", "Exception thrown while unbinding", e);
        }
    }

    /* renamed from: b */
    static final /* synthetic */ boolean m5332b() {
        return false;
    }

    @SuppressLint({"UntrackedBindService"})
    /* renamed from: c */
    private final boolean m5333c(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i, boolean z) {
        boolean z2;
        ComponentName component = intent.getComponent();
        if (component == null) {
            z2 = false;
        } else {
            z2 = ClientLibraryUtils.zza(context, component.getPackageName());
        }
        if (z2) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        } else if (!m5334d(serviceConnection)) {
            return context.bindService(intent, serviceConnection, i);
        } else {
            ServiceConnection putIfAbsent = this.f7594a.putIfAbsent(serviceConnection, serviceConnection);
            if (!(putIfAbsent == null || serviceConnection == putIfAbsent)) {
                Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", new Object[]{serviceConnection, str, intent.getAction()}));
            }
            try {
                boolean bindService = context.bindService(intent, serviceConnection, i);
                return !bindService ? bindService : bindService;
            } finally {
                this.f7594a.remove(serviceConnection, serviceConnection);
            }
        }
    }

    /* renamed from: d */
    private static boolean m5334d(ServiceConnection serviceConnection) {
        return f7593d.zza().booleanValue() && !(serviceConnection instanceof zzj);
    }

    @KeepForSdk
    public static ConnectionTracker getInstance() {
        if (f7592c == null) {
            synchronized (f7591b) {
                if (f7592c == null) {
                    f7592c = new ConnectionTracker();
                }
            }
        }
        return f7592c;
    }

    @KeepForSdk
    public boolean bindService(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return zza(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    @SuppressLint({"UntrackedBindService"})
    @KeepForSdk
    public void unbindService(Context context, ServiceConnection serviceConnection) {
        if (!m5334d(serviceConnection) || !this.f7594a.containsKey(serviceConnection)) {
            m5331a(context, serviceConnection);
            return;
        }
        try {
            m5331a(context, this.f7594a.get(serviceConnection));
        } finally {
            this.f7594a.remove(serviceConnection);
        }
    }

    @SuppressLint({"UntrackedBindService"})
    @KeepForSdk
    public void unbindServiceSafe(Context context, ServiceConnection serviceConnection) {
        try {
            unbindService(context, serviceConnection);
        } catch (IllegalArgumentException e) {
            Log.w("ConnectionTracker", "Exception thrown while unbinding", e);
        }
    }

    public final boolean zza(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        return m5333c(context, str, intent, serviceConnection, i, true);
    }
}
