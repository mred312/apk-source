package androidx.work.impl.constraints.controllers;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

public class BatteryChargingController extends ConstraintController<Boolean> {
    public BatteryChargingController(Context context, TaskExecutor taskExecutor) {
        super(Trackers.getInstance(context, taskExecutor).getBatteryChargingTracker());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo8944a(@NonNull WorkSpec workSpec) {
        return workSpec.constraints.requiresCharging();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo8945b(@NonNull Boolean bool) {
        return !bool.booleanValue();
    }
}
