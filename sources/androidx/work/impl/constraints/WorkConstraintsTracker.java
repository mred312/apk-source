package androidx.work.impl.constraints;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.Logger;
import androidx.work.impl.constraints.controllers.BatteryChargingController;
import androidx.work.impl.constraints.controllers.BatteryNotLowController;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.NetworkConnectedController;
import androidx.work.impl.constraints.controllers.NetworkMeteredController;
import androidx.work.impl.constraints.controllers.NetworkNotRoamingController;
import androidx.work.impl.constraints.controllers.NetworkUnmeteredController;
import androidx.work.impl.constraints.controllers.StorageNotLowController;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.List;

public class WorkConstraintsTracker implements ConstraintController.OnConstraintUpdatedCallback {

    /* renamed from: d */
    private static final String f5240d = Logger.tagWithPrefix("WorkConstraintsTracker");
    @Nullable

    /* renamed from: a */
    private final WorkConstraintsCallback f5241a;

    /* renamed from: b */
    private final ConstraintController<?>[] f5242b;

    /* renamed from: c */
    private final Object f5243c = new Object();

    public WorkConstraintsTracker(@NonNull Context context, @NonNull TaskExecutor taskExecutor, @Nullable WorkConstraintsCallback workConstraintsCallback) {
        Context applicationContext = context.getApplicationContext();
        this.f5241a = workConstraintsCallback;
        this.f5242b = new ConstraintController[]{new BatteryChargingController(applicationContext, taskExecutor), new BatteryNotLowController(applicationContext, taskExecutor), new StorageNotLowController(applicationContext, taskExecutor), new NetworkConnectedController(applicationContext, taskExecutor), new NetworkUnmeteredController(applicationContext, taskExecutor), new NetworkNotRoamingController(applicationContext, taskExecutor), new NetworkMeteredController(applicationContext, taskExecutor)};
    }

    public boolean areAllConstraintsMet(@NonNull String str) {
        synchronized (this.f5243c) {
            for (ConstraintController<?> constraintController : this.f5242b) {
                if (constraintController.isWorkSpecConstrained(str)) {
                    Logger.get().debug(f5240d, String.format("Work %s constrained by %s", new Object[]{str, constraintController.getClass().getSimpleName()}), new Throwable[0]);
                    return false;
                }
            }
            return true;
        }
    }

    public void onConstraintMet(@NonNull List<String> list) {
        synchronized (this.f5243c) {
            ArrayList arrayList = new ArrayList();
            for (String next : list) {
                if (areAllConstraintsMet(next)) {
                    Logger.get().debug(f5240d, String.format("Constraints met for %s", new Object[]{next}), new Throwable[0]);
                    arrayList.add(next);
                }
            }
            WorkConstraintsCallback workConstraintsCallback = this.f5241a;
            if (workConstraintsCallback != null) {
                workConstraintsCallback.onAllConstraintsMet(arrayList);
            }
        }
    }

    public void onConstraintNotMet(@NonNull List<String> list) {
        synchronized (this.f5243c) {
            WorkConstraintsCallback workConstraintsCallback = this.f5241a;
            if (workConstraintsCallback != null) {
                workConstraintsCallback.onAllConstraintsNotMet(list);
            }
        }
    }

    public void replace(@NonNull List<WorkSpec> list) {
        synchronized (this.f5243c) {
            for (ConstraintController<?> callback : this.f5242b) {
                callback.setCallback((ConstraintController.OnConstraintUpdatedCallback) null);
            }
            for (ConstraintController<?> replace : this.f5242b) {
                replace.replace(list);
            }
            for (ConstraintController<?> callback2 : this.f5242b) {
                callback2.setCallback(this);
            }
        }
    }

    public void reset() {
        synchronized (this.f5243c) {
            for (ConstraintController<?> reset : this.f5242b) {
                reset.reset();
            }
        }
    }
}
