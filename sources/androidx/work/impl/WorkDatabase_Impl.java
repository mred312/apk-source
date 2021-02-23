package androidx.work.impl;

import android.os.Build;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.p005db.SupportSQLiteDatabase;
import androidx.sqlite.p005db.SupportSQLiteOpenHelper;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.DependencyDao_Impl;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.SystemIdInfoDao_Impl;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkNameDao_Impl;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.model.WorkTagDao_Impl;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class WorkDatabase_Impl extends WorkDatabase {

    /* renamed from: j */
    private volatile WorkSpecDao f5110j;

    /* renamed from: k */
    private volatile DependencyDao f5111k;

    /* renamed from: l */
    private volatile WorkTagDao f5112l;

    /* renamed from: m */
    private volatile SystemIdInfoDao f5113m;

    /* renamed from: n */
    private volatile WorkNameDao f5114n;

    /* renamed from: androidx.work.impl.WorkDatabase_Impl$a */
    class C1084a extends RoomOpenHelper.Delegate {
        C1084a(int i) {
            super(i);
        }

        public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            supportSQLiteDatabase.execSQL("CREATE  INDEX `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
            supportSQLiteDatabase.execSQL("CREATE  INDEX `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `required_network_type` INTEGER, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB, PRIMARY KEY(`id`))");
            supportSQLiteDatabase.execSQL("CREATE  INDEX `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            supportSQLiteDatabase.execSQL("CREATE  INDEX `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            supportSQLiteDatabase.execSQL("CREATE  INDEX `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
            supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c84d23ade98552f1cec71088c1f0794c')");
        }

        public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Dependency`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkSpec`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkTag`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `SystemIdInfo`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkName`");
        }

        /* access modifiers changed from: protected */
        public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (WorkDatabase_Impl.this.mCallbacks != null) {
                int size = WorkDatabase_Impl.this.mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) WorkDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                }
            }
        }

        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            SupportSQLiteDatabase unused = WorkDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
            supportSQLiteDatabase.execSQL("PRAGMA foreign_keys = ON");
            WorkDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
            if (WorkDatabase_Impl.this.mCallbacks != null) {
                int size = WorkDatabase_Impl.this.mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) WorkDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                }
            }
        }

        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
        }

        /* access modifiers changed from: protected */
        public void validateMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
            SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
            HashMap hashMap = new HashMap(2);
            hashMap.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 1));
            hashMap.put("prerequisite_id", new TableInfo.Column("prerequisite_id", "TEXT", true, 2));
            HashSet hashSet = new HashSet(2);
            List asList = Arrays.asList(new String[]{"work_spec_id"});
            List asList2 = Arrays.asList(new String[]{FacebookAdapter.KEY_ID});
            String str = FacebookAdapter.KEY_ID;
            hashSet.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", asList, asList2));
            hashSet.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"prerequisite_id"}), Arrays.asList(new String[]{str})));
            HashSet hashSet2 = new HashSet(2);
            hashSet2.add(new TableInfo.Index("index_Dependency_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"})));
            hashSet2.add(new TableInfo.Index("index_Dependency_prerequisite_id", false, Arrays.asList(new String[]{"prerequisite_id"})));
            TableInfo tableInfo = new TableInfo("Dependency", hashMap, hashSet, hashSet2);
            TableInfo read = TableInfo.read(supportSQLiteDatabase2, "Dependency");
            if (tableInfo.equals(read)) {
                HashMap hashMap2 = new HashMap(23);
                hashMap2.put(str, new TableInfo.Column(str, "TEXT", true, 1));
                hashMap2.put(RemoteConfigConstants.ResponseFieldKey.STATE, new TableInfo.Column(RemoteConfigConstants.ResponseFieldKey.STATE, "INTEGER", true, 0));
                hashMap2.put("worker_class_name", new TableInfo.Column("worker_class_name", "TEXT", true, 0));
                hashMap2.put("input_merger_class_name", new TableInfo.Column("input_merger_class_name", "TEXT", false, 0));
                hashMap2.put("input", new TableInfo.Column("input", "BLOB", true, 0));
                hashMap2.put("output", new TableInfo.Column("output", "BLOB", true, 0));
                hashMap2.put("initial_delay", new TableInfo.Column("initial_delay", "INTEGER", true, 0));
                hashMap2.put("interval_duration", new TableInfo.Column("interval_duration", "INTEGER", true, 0));
                hashMap2.put("flex_duration", new TableInfo.Column("flex_duration", "INTEGER", true, 0));
                hashMap2.put("run_attempt_count", new TableInfo.Column("run_attempt_count", "INTEGER", true, 0));
                hashMap2.put("backoff_policy", new TableInfo.Column("backoff_policy", "INTEGER", true, 0));
                hashMap2.put("backoff_delay_duration", new TableInfo.Column("backoff_delay_duration", "INTEGER", true, 0));
                hashMap2.put("period_start_time", new TableInfo.Column("period_start_time", "INTEGER", true, 0));
                hashMap2.put("minimum_retention_duration", new TableInfo.Column("minimum_retention_duration", "INTEGER", true, 0));
                hashMap2.put("schedule_requested_at", new TableInfo.Column("schedule_requested_at", "INTEGER", true, 0));
                hashMap2.put("required_network_type", new TableInfo.Column("required_network_type", "INTEGER", false, 0));
                hashMap2.put("requires_charging", new TableInfo.Column("requires_charging", "INTEGER", true, 0));
                hashMap2.put("requires_device_idle", new TableInfo.Column("requires_device_idle", "INTEGER", true, 0));
                hashMap2.put("requires_battery_not_low", new TableInfo.Column("requires_battery_not_low", "INTEGER", true, 0));
                hashMap2.put("requires_storage_not_low", new TableInfo.Column("requires_storage_not_low", "INTEGER", true, 0));
                hashMap2.put("trigger_content_update_delay", new TableInfo.Column("trigger_content_update_delay", "INTEGER", true, 0));
                hashMap2.put("trigger_max_content_delay", new TableInfo.Column("trigger_max_content_delay", "INTEGER", true, 0));
                hashMap2.put("content_uri_triggers", new TableInfo.Column("content_uri_triggers", "BLOB", false, 0));
                HashSet hashSet3 = new HashSet(0);
                HashSet hashSet4 = new HashSet(1);
                hashSet4.add(new TableInfo.Index("index_WorkSpec_schedule_requested_at", false, Arrays.asList(new String[]{"schedule_requested_at"})));
                TableInfo tableInfo2 = new TableInfo("WorkSpec", hashMap2, hashSet3, hashSet4);
                TableInfo read2 = TableInfo.read(supportSQLiteDatabase2, "WorkSpec");
                if (tableInfo2.equals(read2)) {
                    HashMap hashMap3 = new HashMap(2);
                    hashMap3.put("tag", new TableInfo.Column("tag", "TEXT", true, 1));
                    hashMap3.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 2));
                    HashSet hashSet5 = new HashSet(1);
                    hashSet5.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{str})));
                    HashSet hashSet6 = new HashSet(1);
                    hashSet6.add(new TableInfo.Index("index_WorkTag_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"})));
                    TableInfo tableInfo3 = new TableInfo("WorkTag", hashMap3, hashSet5, hashSet6);
                    TableInfo read3 = TableInfo.read(supportSQLiteDatabase2, "WorkTag");
                    if (tableInfo3.equals(read3)) {
                        HashMap hashMap4 = new HashMap(2);
                        hashMap4.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 1));
                        hashMap4.put("system_id", new TableInfo.Column("system_id", "INTEGER", true, 0));
                        HashSet hashSet7 = new HashSet(1);
                        hashSet7.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{str})));
                        TableInfo tableInfo4 = new TableInfo("SystemIdInfo", hashMap4, hashSet7, new HashSet(0));
                        TableInfo read4 = TableInfo.read(supportSQLiteDatabase2, "SystemIdInfo");
                        if (tableInfo4.equals(read4)) {
                            HashMap hashMap5 = new HashMap(2);
                            hashMap5.put("name", new TableInfo.Column("name", "TEXT", true, 1));
                            hashMap5.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 2));
                            HashSet hashSet8 = new HashSet(1);
                            hashSet8.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{str})));
                            HashSet hashSet9 = new HashSet(1);
                            hashSet9.add(new TableInfo.Index("index_WorkName_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"})));
                            TableInfo tableInfo5 = new TableInfo("WorkName", hashMap5, hashSet8, hashSet9);
                            TableInfo read5 = TableInfo.read(supportSQLiteDatabase2, "WorkName");
                            if (!tableInfo5.equals(read5)) {
                                throw new IllegalStateException("Migration didn't properly handle WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + tableInfo5 + "\n Found:\n" + read5);
                            }
                            return;
                        }
                        throw new IllegalStateException("Migration didn't properly handle SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
                    }
                    throw new IllegalStateException("Migration didn't properly handle WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
                }
                throw new IllegalStateException("Migration didn't properly handle WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
            }
            throw new IllegalStateException("Migration didn't properly handle Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
        }
    }

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        boolean z = Build.VERSION.SDK_INT >= 21;
        if (!z) {
            try {
                writableDatabase.execSQL("PRAGMA foreign_keys = FALSE");
            } catch (Throwable th) {
                super.endTransaction();
                if (!z) {
                    writableDatabase.execSQL("PRAGMA foreign_keys = TRUE");
                }
                writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
                if (!writableDatabase.inTransaction()) {
                    writableDatabase.execSQL("VACUUM");
                }
                throw th;
            }
        }
        super.beginTransaction();
        if (z) {
            writableDatabase.execSQL("PRAGMA defer_foreign_keys = TRUE");
        }
        writableDatabase.execSQL("DELETE FROM `Dependency`");
        writableDatabase.execSQL("DELETE FROM `WorkSpec`");
        writableDatabase.execSQL("DELETE FROM `WorkTag`");
        writableDatabase.execSQL("DELETE FROM `SystemIdInfo`");
        writableDatabase.execSQL("DELETE FROM `WorkName`");
        super.setTransactionSuccessful();
        super.endTransaction();
        if (!z) {
            writableDatabase.execSQL("PRAGMA foreign_keys = TRUE");
        }
        writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
        if (!writableDatabase.inTransaction()) {
            writableDatabase.execSQL("VACUUM");
        }
    }

    /* access modifiers changed from: protected */
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName");
    }

    /* access modifiers changed from: protected */
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new C1084a(6), "c84d23ade98552f1cec71088c1f0794c", "1db8206f0da6aa81bbdd2d99a82d9e14")).build());
    }

    public DependencyDao dependencyDao() {
        DependencyDao dependencyDao;
        if (this.f5111k != null) {
            return this.f5111k;
        }
        synchronized (this) {
            if (this.f5111k == null) {
                this.f5111k = new DependencyDao_Impl(this);
            }
            dependencyDao = this.f5111k;
        }
        return dependencyDao;
    }

    public SystemIdInfoDao systemIdInfoDao() {
        SystemIdInfoDao systemIdInfoDao;
        if (this.f5113m != null) {
            return this.f5113m;
        }
        synchronized (this) {
            if (this.f5113m == null) {
                this.f5113m = new SystemIdInfoDao_Impl(this);
            }
            systemIdInfoDao = this.f5113m;
        }
        return systemIdInfoDao;
    }

    public WorkNameDao workNameDao() {
        WorkNameDao workNameDao;
        if (this.f5114n != null) {
            return this.f5114n;
        }
        synchronized (this) {
            if (this.f5114n == null) {
                this.f5114n = new WorkNameDao_Impl(this);
            }
            workNameDao = this.f5114n;
        }
        return workNameDao;
    }

    public WorkSpecDao workSpecDao() {
        WorkSpecDao workSpecDao;
        if (this.f5110j != null) {
            return this.f5110j;
        }
        synchronized (this) {
            if (this.f5110j == null) {
                this.f5110j = new WorkSpecDao_Impl(this);
            }
            workSpecDao = this.f5110j;
        }
        return workSpecDao;
    }

    public WorkTagDao workTagDao() {
        WorkTagDao workTagDao;
        if (this.f5112l != null) {
            return this.f5112l;
        }
        synchronized (this) {
            if (this.f5112l == null) {
                this.f5112l = new WorkTagDao_Impl(this);
            }
            workTagDao = this.f5112l;
        }
        return workTagDao;
    }
}
