package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: androidx.work.impl.background.systemalarm.b */
/* compiled from: ConstraintsCommandHandler */
class C1095b {

    /* renamed from: e */
    private static final String f5210e = Logger.tagWithPrefix("ConstraintsCmdHandler");

    /* renamed from: a */
    private final Context f5211a;

    /* renamed from: b */
    private final int f5212b;

    /* renamed from: c */
    private final SystemAlarmDispatcher f5213c;

    /* renamed from: d */
    private final WorkConstraintsTracker f5214d;

    C1095b(@NonNull Context context, int i, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        this.f5211a = context;
        this.f5212b = i;
        this.f5213c = systemAlarmDispatcher;
        this.f5214d = new WorkConstraintsTracker(context, systemAlarmDispatcher.mo8909d(), (WorkConstraintsCallback) null);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: a */
    public void mo8919a() {
        List<WorkSpec> scheduledWork = this.f5213c.mo8910e().getWorkDatabase().workSpecDao().getScheduledWork();
        ConstraintProxy.m3937a(this.f5211a, scheduledWork);
        this.f5214d.replace(scheduledWork);
        ArrayList<WorkSpec> arrayList = new ArrayList<>(scheduledWork.size());
        long currentTimeMillis = System.currentTimeMillis();
        for (WorkSpec next : scheduledWork) {
            String str = next.f5281id;
            if (currentTimeMillis >= next.calculateNextRunTime() && (!next.hasConstraints() || this.f5214d.areAllConstraintsMet(str))) {
                arrayList.add(next);
            }
        }
        for (WorkSpec workSpec : arrayList) {
            String str2 = workSpec.f5281id;
            Intent b = CommandHandler.m3923b(this.f5211a, str2);
            Logger.get().debug(f5210e, String.format("Creating a delay_met command for workSpec with id (%s)", new Object[]{str2}), new Throwable[0]);
            SystemAlarmDispatcher systemAlarmDispatcher = this.f5213c;
            systemAlarmDispatcher.mo8913i(new SystemAlarmDispatcher.C1091b(systemAlarmDispatcher, b, this.f5212b));
        }
        this.f5214d.reset();
    }
}
