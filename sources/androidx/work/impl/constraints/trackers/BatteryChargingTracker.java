package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class BatteryChargingTracker extends BroadcastReceiverConstraintTracker<Boolean> {

    /* renamed from: g */
    private static final String f5250g = Logger.tagWithPrefix("BatteryChrgTracker");

    public BatteryChargingTracker(@NonNull Context context, @NonNull TaskExecutor taskExecutor) {
        super(context, taskExecutor);
    }

    /* renamed from: a */
    private boolean m3992a(Intent intent) {
        if (Build.VERSION.SDK_INT >= 23) {
            int intExtra = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
            if (intExtra == 2 || intExtra == 5) {
                return true;
            }
        } else if (intent.getIntExtra("plugged", 0) != 0) {
            return true;
        }
        return false;
    }

    public IntentFilter getIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        if (Build.VERSION.SDK_INT >= 23) {
            intentFilter.addAction("android.os.action.CHARGING");
            intentFilter.addAction("android.os.action.DISCHARGING");
        } else {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        return intentFilter;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004b, code lost:
        if (r9.equals("android.os.action.DISCHARGING") == false) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBroadcastReceive(android.content.Context r8, @androidx.annotation.NonNull android.content.Intent r9) {
        /*
            r7 = this;
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            java.lang.String r9 = r9.getAction()
            if (r9 != 0) goto L_0x000b
            return
        L_0x000b:
            androidx.work.Logger r1 = androidx.work.Logger.get()
            java.lang.String r2 = f5250g
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]
            r5 = 0
            r4[r5] = r9
            java.lang.String r6 = "Received %s"
            java.lang.String r4 = java.lang.String.format(r6, r4)
            java.lang.Throwable[] r6 = new java.lang.Throwable[r5]
            r1.debug(r2, r4, r6)
            r9.hashCode()
            r1 = -1
            int r2 = r9.hashCode()
            switch(r2) {
                case -1886648615: goto L_0x004e;
                case -54942926: goto L_0x0045;
                case 948344062: goto L_0x003a;
                case 1019184907: goto L_0x002f;
                default: goto L_0x002d;
            }
        L_0x002d:
            r3 = -1
            goto L_0x0058
        L_0x002f:
            java.lang.String r2 = "android.intent.action.ACTION_POWER_CONNECTED"
            boolean r9 = r9.equals(r2)
            if (r9 != 0) goto L_0x0038
            goto L_0x002d
        L_0x0038:
            r3 = 3
            goto L_0x0058
        L_0x003a:
            java.lang.String r2 = "android.os.action.CHARGING"
            boolean r9 = r9.equals(r2)
            if (r9 != 0) goto L_0x0043
            goto L_0x002d
        L_0x0043:
            r3 = 2
            goto L_0x0058
        L_0x0045:
            java.lang.String r2 = "android.os.action.DISCHARGING"
            boolean r9 = r9.equals(r2)
            if (r9 != 0) goto L_0x0058
            goto L_0x002d
        L_0x004e:
            java.lang.String r2 = "android.intent.action.ACTION_POWER_DISCONNECTED"
            boolean r9 = r9.equals(r2)
            if (r9 != 0) goto L_0x0057
            goto L_0x002d
        L_0x0057:
            r3 = 0
        L_0x0058:
            switch(r3) {
                case 0: goto L_0x0068;
                case 1: goto L_0x0064;
                case 2: goto L_0x0060;
                case 3: goto L_0x005c;
                default: goto L_0x005b;
            }
        L_0x005b:
            goto L_0x006b
        L_0x005c:
            r7.setState(r0)
            goto L_0x006b
        L_0x0060:
            r7.setState(r0)
            goto L_0x006b
        L_0x0064:
            r7.setState(r8)
            goto L_0x006b
        L_0x0068:
            r7.setState(r8)
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.constraints.trackers.BatteryChargingTracker.onBroadcastReceive(android.content.Context, android.content.Intent):void");
    }

    public Boolean getInitialState() {
        Intent registerReceiver = this.mAppContext.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return Boolean.valueOf(m3992a(registerReceiver));
        }
        Logger.get().error(f5250g, "getInitialState - null intent received", new Throwable[0]);
        return null;
    }
}
