package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class BroadcastReceiverConstraintTracker<T> extends ConstraintTracker<T> {

    /* renamed from: f */
    private static final String f5252f = Logger.tagWithPrefix("BrdcstRcvrCnstrntTrckr");

    /* renamed from: e */
    private final BroadcastReceiver f5253e = new C1102a();

    /* renamed from: androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker$a */
    class C1102a extends BroadcastReceiver {
        C1102a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                BroadcastReceiverConstraintTracker.this.onBroadcastReceive(context, intent);
            }
        }
    }

    public BroadcastReceiverConstraintTracker(@NonNull Context context, @NonNull TaskExecutor taskExecutor) {
        super(context, taskExecutor);
    }

    public abstract IntentFilter getIntentFilter();

    public abstract void onBroadcastReceive(Context context, @NonNull Intent intent);

    public void startTracking() {
        Logger.get().debug(f5252f, String.format("%s: registering receiver", new Object[]{getClass().getSimpleName()}), new Throwable[0]);
        this.mAppContext.registerReceiver(this.f5253e, getIntentFilter());
    }

    public void stopTracking() {
        Logger.get().debug(f5252f, String.format("%s: unregistering receiver", new Object[]{getClass().getSimpleName()}), new Throwable[0]);
        this.mAppContext.unregisterReceiver(this.f5253e);
    }
}
