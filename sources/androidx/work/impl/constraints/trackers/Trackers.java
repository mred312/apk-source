package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class Trackers {

    /* renamed from: e */
    private static Trackers f5268e;

    /* renamed from: a */
    private BatteryChargingTracker f5269a;

    /* renamed from: b */
    private BatteryNotLowTracker f5270b;

    /* renamed from: c */
    private NetworkStateTracker f5271c;

    /* renamed from: d */
    private StorageNotLowTracker f5272d;

    private Trackers(@NonNull Context context, @NonNull TaskExecutor taskExecutor) {
        Context applicationContext = context.getApplicationContext();
        this.f5269a = new BatteryChargingTracker(applicationContext, taskExecutor);
        this.f5270b = new BatteryNotLowTracker(applicationContext, taskExecutor);
        this.f5271c = new NetworkStateTracker(applicationContext, taskExecutor);
        this.f5272d = new StorageNotLowTracker(applicationContext, taskExecutor);
    }

    @NonNull
    public static synchronized Trackers getInstance(Context context, TaskExecutor taskExecutor) {
        Trackers trackers;
        synchronized (Trackers.class) {
            if (f5268e == null) {
                f5268e = new Trackers(context, taskExecutor);
            }
            trackers = f5268e;
        }
        return trackers;
    }

    @VisibleForTesting
    public static synchronized void setInstance(@NonNull Trackers trackers) {
        synchronized (Trackers.class) {
            f5268e = trackers;
        }
    }

    @NonNull
    public BatteryChargingTracker getBatteryChargingTracker() {
        return this.f5269a;
    }

    @NonNull
    public BatteryNotLowTracker getBatteryNotLowTracker() {
        return this.f5270b;
    }

    @NonNull
    public NetworkStateTracker getNetworkStateTracker() {
        return this.f5271c;
    }

    @NonNull
    public StorageNotLowTracker getStorageNotLowTracker() {
        return this.f5272d;
    }
}
