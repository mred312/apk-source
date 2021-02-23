package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.room.migration.Migration;
import androidx.sqlite.p005db.SupportSQLiteDatabase;
import androidx.work.impl.utils.Preferences;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkDatabaseMigrations {
    public static Migration MIGRATION_1_2 = new C1081a(1, 2);
    public static Migration MIGRATION_3_4 = new C1082b(3, 4);
    public static Migration MIGRATION_4_5 = new C1083c(4, 5);
    public static final int VERSION_1 = 1;
    public static final int VERSION_2 = 2;
    public static final int VERSION_3 = 3;
    public static final int VERSION_4 = 4;
    public static final int VERSION_5 = 5;
    public static final int VERSION_6 = 6;

    public static class WorkMigration extends Migration {

        /* renamed from: a */
        final Context f5109a;

        public WorkMigration(@NonNull Context context, int i, int i2) {
            super(i, i2);
            this.f5109a = context;
        }

        public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            new Preferences(this.f5109a).setNeedsReschedule(true);
        }
    }

    /* renamed from: androidx.work.impl.WorkDatabaseMigrations$a */
    static class C1081a extends Migration {
        C1081a(int i, int i2) {
            super(i, i2);
        }

        public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            supportSQLiteDatabase.execSQL("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS alarmInfo");
            supportSQLiteDatabase.execSQL("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
        }
    }

    /* renamed from: androidx.work.impl.WorkDatabaseMigrations$b */
    static class C1082b extends Migration {
        C1082b(int i, int i2) {
            super(i, i2);
        }

        public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            if (Build.VERSION.SDK_INT >= 23) {
                supportSQLiteDatabase.execSQL("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
            }
        }
    }

    /* renamed from: androidx.work.impl.WorkDatabaseMigrations$c */
    static class C1083c extends Migration {
        C1083c(int i, int i2) {
            super(i, i2);
        }

        public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
            supportSQLiteDatabase.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
        }
    }

    private WorkDatabaseMigrations() {
    }
}
