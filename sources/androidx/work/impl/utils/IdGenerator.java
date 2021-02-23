package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class IdGenerator {
    public static final int INITIAL_ID = 0;

    /* renamed from: a */
    private final Context f5322a;

    /* renamed from: b */
    private SharedPreferences f5323b;

    /* renamed from: c */
    private boolean f5324c;

    public IdGenerator(Context context) {
        this.f5322a = context;
    }

    /* renamed from: a */
    private void m4025a() {
        if (!this.f5324c) {
            this.f5323b = this.f5322a.getSharedPreferences("androidx.work.util.id", 0);
            this.f5324c = true;
        }
    }

    /* renamed from: b */
    private int m4026b(String str) {
        int i = 0;
        int i2 = this.f5323b.getInt(str, 0);
        if (i2 != Integer.MAX_VALUE) {
            i = i2 + 1;
        }
        m4027c(str, i);
        return i2;
    }

    /* renamed from: c */
    private void m4027c(String str, int i) {
        this.f5323b.edit().putInt(str, i).apply();
    }

    public int nextAlarmManagerId() {
        int b;
        synchronized (IdGenerator.class) {
            m4025a();
            b = m4026b("next_alarm_manager_id");
        }
        return b;
    }

    public int nextJobSchedulerIdWithRange(int i, int i2) {
        synchronized (IdGenerator.class) {
            m4025a();
            int b = m4026b("next_job_scheduler_id");
            if (b >= i) {
                if (b <= i2) {
                    i = b;
                }
            }
            m4027c("next_job_scheduler_id", i + 1);
        }
        return i;
    }
}
