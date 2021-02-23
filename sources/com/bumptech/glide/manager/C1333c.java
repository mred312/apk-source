package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.util.Preconditions;

/* renamed from: com.bumptech.glide.manager.c */
/* compiled from: DefaultConnectivityMonitor */
final class C1333c implements ConnectivityMonitor {

    /* renamed from: a */
    private final Context f6284a;

    /* renamed from: b */
    final ConnectivityMonitor.ConnectivityListener f6285b;

    /* renamed from: c */
    boolean f6286c;

    /* renamed from: d */
    private boolean f6287d;

    /* renamed from: e */
    private final BroadcastReceiver f6288e = new C1334a();

    /* renamed from: com.bumptech.glide.manager.c$a */
    /* compiled from: DefaultConnectivityMonitor */
    class C1334a extends BroadcastReceiver {
        C1334a() {
        }

        public void onReceive(@NonNull Context context, Intent intent) {
            C1333c cVar = C1333c.this;
            boolean z = cVar.f6286c;
            cVar.f6286c = cVar.mo10008a(context);
            if (z != C1333c.this.f6286c) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + C1333c.this.f6286c);
                }
                C1333c cVar2 = C1333c.this;
                cVar2.f6285b.onConnectivityChanged(cVar2.f6286c);
            }
        }
    }

    C1333c(@NonNull Context context, @NonNull ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.f6284a = context.getApplicationContext();
        this.f6285b = connectivityListener;
    }

    /* renamed from: b */
    private void m4656b() {
        if (!this.f6287d) {
            this.f6286c = mo10008a(this.f6284a);
            try {
                this.f6284a.registerReceiver(this.f6288e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.f6287d = true;
            } catch (SecurityException e) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to register", e);
                }
            }
        }
    }

    /* renamed from: c */
    private void m4657c() {
        if (this.f6287d) {
            this.f6284a.unregisterReceiver(this.f6288e);
            this.f6287d = false;
        }
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"MissingPermission"})
    /* renamed from: a */
    public boolean mo10008a(@NonNull Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) Preconditions.checkNotNull((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (RuntimeException e) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e);
            }
            return true;
        }
    }

    public void onDestroy() {
    }

    public void onStart() {
        m4656b();
    }

    public void onStop() {
        m4657c();
    }
}
