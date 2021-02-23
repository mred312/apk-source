package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.net.ConnectivityManagerCompat;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NetworkStateTracker extends ConstraintTracker<NetworkState> {

    /* renamed from: h */
    static final String f5261h = Logger.tagWithPrefix("NetworkStateTracker");

    /* renamed from: e */
    private final ConnectivityManager f5262e = ((ConnectivityManager) this.mAppContext.getSystemService("connectivity"));
    @RequiresApi(24)

    /* renamed from: f */
    private C1105b f5263f;

    /* renamed from: g */
    private C1104a f5264g;

    /* renamed from: androidx.work.impl.constraints.trackers.NetworkStateTracker$a */
    private class C1104a extends BroadcastReceiver {
        C1104a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                Logger.get().debug(NetworkStateTracker.f5261h, "Network broadcast received", new Throwable[0]);
                NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
                networkStateTracker.setState(networkStateTracker.mo8967a());
            }
        }
    }

    @RequiresApi(24)
    /* renamed from: androidx.work.impl.constraints.trackers.NetworkStateTracker$b */
    private class C1105b extends ConnectivityManager.NetworkCallback {
        C1105b() {
        }

        public void onCapabilitiesChanged(@NonNull Network network, @NonNull NetworkCapabilities networkCapabilities) {
            Logger.get().debug(NetworkStateTracker.f5261h, String.format("Network capabilities changed: %s", new Object[]{networkCapabilities}), new Throwable[0]);
            NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
            networkStateTracker.setState(networkStateTracker.mo8967a());
        }

        public void onLost(@NonNull Network network) {
            Logger.get().debug(NetworkStateTracker.f5261h, "Network connection lost", new Throwable[0]);
            NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
            networkStateTracker.setState(networkStateTracker.mo8967a());
        }
    }

    public NetworkStateTracker(@NonNull Context context, @NonNull TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        if (m3994c()) {
            this.f5263f = new C1105b();
        } else {
            this.f5264g = new C1104a();
        }
    }

    /* renamed from: b */
    private boolean m3993b() {
        NetworkCapabilities networkCapabilities;
        if (Build.VERSION.SDK_INT >= 23 && (networkCapabilities = this.f5262e.getNetworkCapabilities(this.f5262e.getActiveNetwork())) != null && networkCapabilities.hasCapability(16)) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    private static boolean m3994c() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public NetworkState mo8967a() {
        NetworkInfo activeNetworkInfo = this.f5262e.getActiveNetworkInfo();
        boolean z = true;
        boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        boolean b = m3993b();
        boolean isActiveNetworkMetered = ConnectivityManagerCompat.isActiveNetworkMetered(this.f5262e);
        if (activeNetworkInfo == null || activeNetworkInfo.isRoaming()) {
            z = false;
        }
        return new NetworkState(z2, b, isActiveNetworkMetered, z);
    }

    public void startTracking() {
        if (m3994c()) {
            Logger.get().debug(f5261h, "Registering network callback", new Throwable[0]);
            this.f5262e.registerDefaultNetworkCallback(this.f5263f);
            return;
        }
        Logger.get().debug(f5261h, "Registering broadcast receiver", new Throwable[0]);
        this.mAppContext.registerReceiver(this.f5264g, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void stopTracking() {
        if (m3994c()) {
            try {
                Logger.get().debug(f5261h, "Unregistering network callback", new Throwable[0]);
                this.f5262e.unregisterNetworkCallback(this.f5263f);
            } catch (IllegalArgumentException e) {
                Logger.get().error(f5261h, "Received exception while unregistering network callback", e);
            }
        } else {
            Logger.get().debug(f5261h, "Unregistering broadcast receiver", new Throwable[0]);
            this.mAppContext.unregisterReceiver(this.f5264g);
        }
    }

    public NetworkState getInitialState() {
        return mo8967a();
    }
}
