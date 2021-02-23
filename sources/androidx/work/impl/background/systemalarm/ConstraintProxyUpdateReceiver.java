package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.Logger;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.ConstraintProxy;
import androidx.work.impl.utils.PackageManagerHelper;

public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {

    /* renamed from: a */
    static final String f5173a = Logger.tagWithPrefix("ConstrntProxyUpdtRecvr");

    /* renamed from: androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver$a */
    class C1089a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Intent f5174a;

        /* renamed from: b */
        final /* synthetic */ Context f5175b;

        /* renamed from: c */
        final /* synthetic */ BroadcastReceiver.PendingResult f5176c;

        C1089a(ConstraintProxyUpdateReceiver constraintProxyUpdateReceiver, Intent intent, Context context, BroadcastReceiver.PendingResult pendingResult) {
            this.f5174a = intent;
            this.f5175b = context;
            this.f5176c = pendingResult;
        }

        public void run() {
            try {
                boolean booleanExtra = this.f5174a.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra2 = this.f5174a.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                boolean booleanExtra3 = this.f5174a.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra4 = this.f5174a.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                Logger.get().debug(ConstraintProxyUpdateReceiver.f5173a, String.format("Updating proxies: BatteryNotLowProxy enabled (%s), BatteryChargingProxy enabled (%s), StorageNotLowProxy (%s), NetworkStateProxy enabled (%s)", new Object[]{Boolean.valueOf(booleanExtra), Boolean.valueOf(booleanExtra2), Boolean.valueOf(booleanExtra3), Boolean.valueOf(booleanExtra4)}), new Throwable[0]);
                PackageManagerHelper.setComponentEnabled(this.f5175b, ConstraintProxy.BatteryNotLowProxy.class, booleanExtra);
                PackageManagerHelper.setComponentEnabled(this.f5175b, ConstraintProxy.BatteryChargingProxy.class, booleanExtra2);
                PackageManagerHelper.setComponentEnabled(this.f5175b, ConstraintProxy.StorageNotLowProxy.class, booleanExtra3);
                PackageManagerHelper.setComponentEnabled(this.f5175b, ConstraintProxy.NetworkStateProxy.class, booleanExtra4);
            } finally {
                this.f5176c.finish();
            }
        }
    }

    public static Intent newConstraintProxyUpdateIntent(Context context, boolean z, boolean z2, boolean z3, boolean z4) {
        Intent intent = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
        intent.setComponent(new ComponentName(context, ConstraintProxyUpdateReceiver.class));
        intent.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", z).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z2).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z3).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z4);
        return intent;
    }

    public void onReceive(@NonNull Context context, @Nullable Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if (!"androidx.work.impl.background.systemalarm.UpdateProxies".equals(action)) {
            Logger.get().debug(f5173a, String.format("Ignoring unknown action %s", new Object[]{action}), new Throwable[0]);
        } else {
            WorkManagerImpl.getInstance(context).getWorkTaskExecutor().executeOnBackgroundThread(new C1089a(this, intent, context, goAsync()));
        }
    }
}
