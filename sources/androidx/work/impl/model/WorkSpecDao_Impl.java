package androidx.work.impl.model;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.p005db.SupportSQLiteStatement;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

public final class WorkSpecDao_Impl implements WorkSpecDao {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final RoomDatabase f5284a;

    /* renamed from: b */
    private final EntityInsertionAdapter f5285b;

    /* renamed from: c */
    private final SharedSQLiteStatement f5286c;

    /* renamed from: d */
    private final SharedSQLiteStatement f5287d;

    /* renamed from: e */
    private final SharedSQLiteStatement f5288e;

    /* renamed from: f */
    private final SharedSQLiteStatement f5289f;

    /* renamed from: g */
    private final SharedSQLiteStatement f5290g;

    /* renamed from: h */
    private final SharedSQLiteStatement f5291h;

    /* renamed from: i */
    private final SharedSQLiteStatement f5292i;

    /* renamed from: j */
    private final SharedSQLiteStatement f5293j;

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$a */
    class C1111a implements Callable<List<WorkSpec.WorkInfoPojo>> {

        /* renamed from: a */
        final /* synthetic */ RoomSQLiteQuery f5294a;

        C1111a(RoomSQLiteQuery roomSQLiteQuery) {
            this.f5294a = roomSQLiteQuery;
        }

        /* renamed from: a */
        public List<WorkSpec.WorkInfoPojo> call() {
            Cursor query;
            WorkSpecDao_Impl.this.f5284a.beginTransaction();
            try {
                query = DBUtil.query(WorkSpecDao_Impl.this.f5284a, this.f5294a, true);
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, FacebookAdapter.KEY_ID);
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, RemoteConfigConstants.ResponseFieldKey.STATE);
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "output");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                ArrayMap arrayMap = new ArrayMap();
                while (query.moveToNext()) {
                    if (!query.isNull(columnIndexOrThrow)) {
                        String string = query.getString(columnIndexOrThrow);
                        if (((ArrayList) arrayMap.get(string)) == null) {
                            arrayMap.put(string, new ArrayList());
                        }
                    }
                }
                query.moveToPosition(-1);
                WorkSpecDao_Impl.this.m4000a(arrayMap);
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    ArrayList arrayList2 = null;
                    if (!query.isNull(columnIndexOrThrow)) {
                        arrayList2 = (ArrayList) arrayMap.get(query.getString(columnIndexOrThrow));
                    }
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                    workInfoPojo.f5283id = query.getString(columnIndexOrThrow);
                    workInfoPojo.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                    workInfoPojo.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow3));
                    workInfoPojo.runAttemptCount = query.getInt(columnIndexOrThrow4);
                    workInfoPojo.tags = arrayList2;
                    arrayList.add(workInfoPojo);
                }
                WorkSpecDao_Impl.this.f5284a.setTransactionSuccessful();
                query.close();
                WorkSpecDao_Impl.this.f5284a.endTransaction();
                return arrayList;
            } catch (Throwable th) {
                WorkSpecDao_Impl.this.f5284a.endTransaction();
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f5294a.release();
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$b */
    class C1112b implements Callable<List<WorkSpec.WorkInfoPojo>> {

        /* renamed from: a */
        final /* synthetic */ RoomSQLiteQuery f5296a;

        C1112b(RoomSQLiteQuery roomSQLiteQuery) {
            this.f5296a = roomSQLiteQuery;
        }

        /* renamed from: a */
        public List<WorkSpec.WorkInfoPojo> call() {
            Cursor query;
            WorkSpecDao_Impl.this.f5284a.beginTransaction();
            try {
                query = DBUtil.query(WorkSpecDao_Impl.this.f5284a, this.f5296a, true);
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, FacebookAdapter.KEY_ID);
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, RemoteConfigConstants.ResponseFieldKey.STATE);
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "output");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                ArrayMap arrayMap = new ArrayMap();
                while (query.moveToNext()) {
                    if (!query.isNull(columnIndexOrThrow)) {
                        String string = query.getString(columnIndexOrThrow);
                        if (((ArrayList) arrayMap.get(string)) == null) {
                            arrayMap.put(string, new ArrayList());
                        }
                    }
                }
                query.moveToPosition(-1);
                WorkSpecDao_Impl.this.m4000a(arrayMap);
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    ArrayList arrayList2 = null;
                    if (!query.isNull(columnIndexOrThrow)) {
                        arrayList2 = (ArrayList) arrayMap.get(query.getString(columnIndexOrThrow));
                    }
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                    workInfoPojo.f5283id = query.getString(columnIndexOrThrow);
                    workInfoPojo.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                    workInfoPojo.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow3));
                    workInfoPojo.runAttemptCount = query.getInt(columnIndexOrThrow4);
                    workInfoPojo.tags = arrayList2;
                    arrayList.add(workInfoPojo);
                }
                WorkSpecDao_Impl.this.f5284a.setTransactionSuccessful();
                query.close();
                WorkSpecDao_Impl.this.f5284a.endTransaction();
                return arrayList;
            } catch (Throwable th) {
                WorkSpecDao_Impl.this.f5284a.endTransaction();
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f5296a.release();
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$c */
    class C1113c implements Callable<List<WorkSpec.WorkInfoPojo>> {

        /* renamed from: a */
        final /* synthetic */ RoomSQLiteQuery f5298a;

        C1113c(RoomSQLiteQuery roomSQLiteQuery) {
            this.f5298a = roomSQLiteQuery;
        }

        /* renamed from: a */
        public List<WorkSpec.WorkInfoPojo> call() {
            Cursor query;
            WorkSpecDao_Impl.this.f5284a.beginTransaction();
            try {
                query = DBUtil.query(WorkSpecDao_Impl.this.f5284a, this.f5298a, true);
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, FacebookAdapter.KEY_ID);
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, RemoteConfigConstants.ResponseFieldKey.STATE);
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "output");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                ArrayMap arrayMap = new ArrayMap();
                while (query.moveToNext()) {
                    if (!query.isNull(columnIndexOrThrow)) {
                        String string = query.getString(columnIndexOrThrow);
                        if (((ArrayList) arrayMap.get(string)) == null) {
                            arrayMap.put(string, new ArrayList());
                        }
                    }
                }
                query.moveToPosition(-1);
                WorkSpecDao_Impl.this.m4000a(arrayMap);
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    ArrayList arrayList2 = null;
                    if (!query.isNull(columnIndexOrThrow)) {
                        arrayList2 = (ArrayList) arrayMap.get(query.getString(columnIndexOrThrow));
                    }
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                    workInfoPojo.f5283id = query.getString(columnIndexOrThrow);
                    workInfoPojo.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                    workInfoPojo.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow3));
                    workInfoPojo.runAttemptCount = query.getInt(columnIndexOrThrow4);
                    workInfoPojo.tags = arrayList2;
                    arrayList.add(workInfoPojo);
                }
                WorkSpecDao_Impl.this.f5284a.setTransactionSuccessful();
                query.close();
                WorkSpecDao_Impl.this.f5284a.endTransaction();
                return arrayList;
            } catch (Throwable th) {
                WorkSpecDao_Impl.this.f5284a.endTransaction();
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f5298a.release();
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$d */
    class C1114d extends EntityInsertionAdapter<WorkSpec> {
        C1114d(WorkSpecDao_Impl workSpecDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: c */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkSpec workSpec) {
            String str = workSpec.f5281id;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            supportSQLiteStatement.bindLong(2, (long) WorkTypeConverters.stateToInt(workSpec.state));
            String str2 = workSpec.workerClassName;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str2);
            }
            String str3 = workSpec.inputMergerClassName;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str3);
            }
            byte[] byteArray = Data.toByteArray(workSpec.input);
            if (byteArray == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindBlob(5, byteArray);
            }
            byte[] byteArray2 = Data.toByteArray(workSpec.output);
            if (byteArray2 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindBlob(6, byteArray2);
            }
            supportSQLiteStatement.bindLong(7, workSpec.initialDelay);
            supportSQLiteStatement.bindLong(8, workSpec.intervalDuration);
            supportSQLiteStatement.bindLong(9, workSpec.flexDuration);
            supportSQLiteStatement.bindLong(10, (long) workSpec.runAttemptCount);
            supportSQLiteStatement.bindLong(11, (long) WorkTypeConverters.backoffPolicyToInt(workSpec.backoffPolicy));
            supportSQLiteStatement.bindLong(12, workSpec.backoffDelayDuration);
            supportSQLiteStatement.bindLong(13, workSpec.periodStartTime);
            supportSQLiteStatement.bindLong(14, workSpec.minimumRetentionDuration);
            supportSQLiteStatement.bindLong(15, workSpec.scheduleRequestedAt);
            Constraints constraints = workSpec.constraints;
            if (constraints != null) {
                supportSQLiteStatement.bindLong(16, (long) WorkTypeConverters.networkTypeToInt(constraints.getRequiredNetworkType()));
                supportSQLiteStatement.bindLong(17, constraints.requiresCharging() ? 1 : 0);
                supportSQLiteStatement.bindLong(18, constraints.requiresDeviceIdle() ? 1 : 0);
                supportSQLiteStatement.bindLong(19, constraints.requiresBatteryNotLow() ? 1 : 0);
                supportSQLiteStatement.bindLong(20, constraints.requiresStorageNotLow() ? 1 : 0);
                supportSQLiteStatement.bindLong(21, constraints.getTriggerContentUpdateDelay());
                supportSQLiteStatement.bindLong(22, constraints.getTriggerMaxContentDelay());
                byte[] contentUriTriggersToByteArray = WorkTypeConverters.contentUriTriggersToByteArray(constraints.getContentUriTriggers());
                if (contentUriTriggersToByteArray == null) {
                    supportSQLiteStatement.bindNull(23);
                } else {
                    supportSQLiteStatement.bindBlob(23, contentUriTriggersToByteArray);
                }
            } else {
                supportSQLiteStatement.bindNull(16);
                supportSQLiteStatement.bindNull(17);
                supportSQLiteStatement.bindNull(18);
                supportSQLiteStatement.bindNull(19);
                supportSQLiteStatement.bindNull(20);
                supportSQLiteStatement.bindNull(21);
                supportSQLiteStatement.bindNull(22);
                supportSQLiteStatement.bindNull(23);
            }
        }

        public String createQuery() {
            return "INSERT OR IGNORE INTO `WorkSpec`(`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$e */
    class C1115e extends SharedSQLiteStatement {
        C1115e(WorkSpecDao_Impl workSpecDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM workspec WHERE id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$f */
    class C1116f extends SharedSQLiteStatement {
        C1116f(WorkSpecDao_Impl workSpecDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "UPDATE workspec SET output=? WHERE id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$g */
    class C1117g extends SharedSQLiteStatement {
        C1117g(WorkSpecDao_Impl workSpecDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "UPDATE workspec SET period_start_time=? WHERE id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$h */
    class C1118h extends SharedSQLiteStatement {
        C1118h(WorkSpecDao_Impl workSpecDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$i */
    class C1119i extends SharedSQLiteStatement {
        C1119i(WorkSpecDao_Impl workSpecDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$j */
    class C1120j extends SharedSQLiteStatement {
        C1120j(WorkSpecDao_Impl workSpecDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$k */
    class C1121k extends SharedSQLiteStatement {
        C1121k(WorkSpecDao_Impl workSpecDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$l */
    class C1122l extends SharedSQLiteStatement {
        C1122l(WorkSpecDao_Impl workSpecDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
        }
    }

    public WorkSpecDao_Impl(RoomDatabase roomDatabase) {
        this.f5284a = roomDatabase;
        this.f5285b = new C1114d(this, roomDatabase);
        this.f5286c = new C1115e(this, roomDatabase);
        this.f5287d = new C1116f(this, roomDatabase);
        this.f5288e = new C1117g(this, roomDatabase);
        this.f5289f = new C1118h(this, roomDatabase);
        this.f5290g = new C1119i(this, roomDatabase);
        this.f5291h = new C1120j(this, roomDatabase);
        this.f5292i = new C1121k(this, roomDatabase);
        this.f5293j = new C1122l(this, roomDatabase);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4000a(ArrayMap<String, ArrayList<String>> arrayMap) {
        ArrayList arrayList;
        int i;
        Set<String> keySet = arrayMap.keySet();
        if (!keySet.isEmpty()) {
            if (arrayMap.size() > 999) {
                ArrayMap arrayMap2 = new ArrayMap((int) RoomDatabase.MAX_BIND_PARAMETER_CNT);
                int size = arrayMap.size();
                int i2 = 0;
                loop0:
                while (true) {
                    i = 0;
                    while (i2 < size) {
                        arrayMap2.put(arrayMap.keyAt(i2), arrayMap.valueAt(i2));
                        i2++;
                        i++;
                        if (i == 999) {
                            m4000a(arrayMap2);
                            arrayMap2 = new ArrayMap((int) RoomDatabase.MAX_BIND_PARAMETER_CNT);
                        }
                    }
                    break loop0;
                }
                if (i > 0) {
                    m4000a(arrayMap2);
                    return;
                }
                return;
            }
            StringBuilder newStringBuilder = StringUtil.newStringBuilder();
            newStringBuilder.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
            int size2 = keySet.size();
            StringUtil.appendPlaceholders(newStringBuilder, size2);
            newStringBuilder.append(")");
            RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size2 + 0);
            int i3 = 1;
            for (String next : keySet) {
                if (next == null) {
                    acquire.bindNull(i3);
                } else {
                    acquire.bindString(i3, next);
                }
                i3++;
            }
            Cursor query = DBUtil.query(this.f5284a, acquire, false);
            try {
                int columnIndex = CursorUtil.getColumnIndex(query, "work_spec_id");
                if (columnIndex != -1) {
                    while (query.moveToNext()) {
                        if (!query.isNull(columnIndex) && (arrayList = arrayMap.get(query.getString(columnIndex))) != null) {
                            arrayList.add(query.getString(0));
                        }
                    }
                    query.close();
                }
            } finally {
                query.close();
            }
        }
    }

    public void delete(String str) {
        this.f5284a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f5286c.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f5284a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.f5284a.setTransactionSuccessful();
        } finally {
            this.f5284a.endTransaction();
            this.f5286c.release(acquire);
        }
    }

    public List<String> getAllUnfinishedWork() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
        this.f5284a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f5284a, acquire, false);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<String> getAllWorkSpecIds() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec", 0);
        this.f5284a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f5284a, acquire, false);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<WorkSpec> getEligibleWorkForScheduling(int i) {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        acquire.bindLong(1, (long) i);
        this.f5284a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f5284a, acquire, false);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, FacebookAdapter.KEY_ID);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, RemoteConfigConstants.ResponseFieldKey.STATE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "period_start_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
                int i2 = columnIndexOrThrow14;
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
                int i3 = columnIndexOrThrow13;
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
                int i4 = columnIndexOrThrow12;
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
                int i5 = columnIndexOrThrow11;
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
                int i6 = columnIndexOrThrow10;
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
                int i7 = columnIndexOrThrow9;
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
                int i8 = columnIndexOrThrow8;
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
                int i9 = columnIndexOrThrow7;
                int i10 = columnIndexOrThrow6;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    int i11 = columnIndexOrThrow;
                    String string2 = query.getString(columnIndexOrThrow3);
                    int i12 = columnIndexOrThrow3;
                    Constraints constraints = new Constraints();
                    int i13 = columnIndexOrThrow16;
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(query.getInt(columnIndexOrThrow16)));
                    constraints.setRequiresCharging(query.getInt(columnIndexOrThrow17) != 0);
                    constraints.setRequiresDeviceIdle(query.getInt(columnIndexOrThrow18) != 0);
                    constraints.setRequiresBatteryNotLow(query.getInt(columnIndexOrThrow19) != 0);
                    constraints.setRequiresStorageNotLow(query.getInt(columnIndexOrThrow20) != 0);
                    int i14 = columnIndexOrThrow17;
                    int i15 = columnIndexOrThrow19;
                    constraints.setTriggerContentUpdateDelay(query.getLong(columnIndexOrThrow21));
                    constraints.setTriggerMaxContentDelay(query.getLong(columnIndexOrThrow22));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow23)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow4);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow5));
                    int i16 = i10;
                    workSpec.output = Data.fromByteArray(query.getBlob(i16));
                    int i17 = columnIndexOrThrow18;
                    int i18 = i9;
                    int i19 = i14;
                    workSpec.initialDelay = query.getLong(i18);
                    int i20 = columnIndexOrThrow4;
                    int i21 = i8;
                    int i22 = columnIndexOrThrow5;
                    workSpec.intervalDuration = query.getLong(i21);
                    int i23 = i18;
                    int i24 = i7;
                    int i25 = i21;
                    workSpec.flexDuration = query.getLong(i24);
                    int i26 = i6;
                    workSpec.runAttemptCount = query.getInt(i26);
                    int i27 = i5;
                    i10 = i16;
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(i27));
                    i6 = i26;
                    i5 = i27;
                    int i28 = i4;
                    workSpec.backoffDelayDuration = query.getLong(i28);
                    int i29 = i3;
                    int i30 = i20;
                    workSpec.periodStartTime = query.getLong(i29);
                    int i31 = i24;
                    int i32 = i2;
                    int i33 = i23;
                    workSpec.minimumRetentionDuration = query.getLong(i32);
                    int i34 = i29;
                    int i35 = columnIndexOrThrow15;
                    int i36 = i32;
                    workSpec.scheduleRequestedAt = query.getLong(i35);
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    i4 = i28;
                    columnIndexOrThrow17 = i19;
                    columnIndexOrThrow = i11;
                    columnIndexOrThrow3 = i12;
                    columnIndexOrThrow19 = i15;
                    columnIndexOrThrow16 = i13;
                    i9 = i33;
                    i2 = i36;
                    columnIndexOrThrow15 = i35;
                    columnIndexOrThrow4 = i30;
                    i3 = i34;
                    columnIndexOrThrow5 = i22;
                    i8 = i25;
                    i7 = i31;
                    columnIndexOrThrow18 = i17;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<Data> getInputsFromPrerequisites(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f5284a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f5284a, acquire, false);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(Data.fromByteArray(query.getBlob(0)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<WorkSpec> getRunningWork() {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=1", 0);
        this.f5284a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f5284a, acquire, false);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, FacebookAdapter.KEY_ID);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, RemoteConfigConstants.ResponseFieldKey.STATE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "period_start_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
                int i = columnIndexOrThrow14;
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
                int i2 = columnIndexOrThrow13;
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
                int i3 = columnIndexOrThrow12;
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
                int i4 = columnIndexOrThrow11;
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
                int i5 = columnIndexOrThrow10;
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
                int i6 = columnIndexOrThrow9;
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
                int i7 = columnIndexOrThrow8;
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
                int i8 = columnIndexOrThrow7;
                int i9 = columnIndexOrThrow6;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    int i10 = columnIndexOrThrow;
                    String string2 = query.getString(columnIndexOrThrow3);
                    int i11 = columnIndexOrThrow3;
                    Constraints constraints = new Constraints();
                    int i12 = columnIndexOrThrow16;
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(query.getInt(columnIndexOrThrow16)));
                    constraints.setRequiresCharging(query.getInt(columnIndexOrThrow17) != 0);
                    constraints.setRequiresDeviceIdle(query.getInt(columnIndexOrThrow18) != 0);
                    constraints.setRequiresBatteryNotLow(query.getInt(columnIndexOrThrow19) != 0);
                    constraints.setRequiresStorageNotLow(query.getInt(columnIndexOrThrow20) != 0);
                    int i13 = columnIndexOrThrow17;
                    int i14 = columnIndexOrThrow18;
                    constraints.setTriggerContentUpdateDelay(query.getLong(columnIndexOrThrow21));
                    constraints.setTriggerMaxContentDelay(query.getLong(columnIndexOrThrow22));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow23)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow4);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow5));
                    int i15 = i9;
                    workSpec.output = Data.fromByteArray(query.getBlob(i15));
                    int i16 = columnIndexOrThrow4;
                    int i17 = i8;
                    int i18 = columnIndexOrThrow5;
                    workSpec.initialDelay = query.getLong(i17);
                    int i19 = i13;
                    int i20 = i7;
                    int i21 = i17;
                    workSpec.intervalDuration = query.getLong(i20);
                    int i22 = i20;
                    int i23 = i6;
                    int i24 = i19;
                    workSpec.flexDuration = query.getLong(i23);
                    int i25 = i5;
                    workSpec.runAttemptCount = query.getInt(i25);
                    int i26 = i4;
                    i9 = i15;
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(i26));
                    int i27 = i22;
                    int i28 = i3;
                    int i29 = i23;
                    workSpec.backoffDelayDuration = query.getLong(i28);
                    i5 = i25;
                    int i30 = i2;
                    workSpec.periodStartTime = query.getLong(i30);
                    i2 = i30;
                    int i31 = i;
                    workSpec.minimumRetentionDuration = query.getLong(i31);
                    i = i31;
                    int i32 = i26;
                    int i33 = columnIndexOrThrow15;
                    workSpec.scheduleRequestedAt = query.getLong(i33);
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow15 = i33;
                    columnIndexOrThrow4 = i16;
                    columnIndexOrThrow17 = i24;
                    columnIndexOrThrow5 = i18;
                    columnIndexOrThrow3 = i11;
                    columnIndexOrThrow18 = i14;
                    i6 = i29;
                    i8 = i21;
                    i3 = i28;
                    i7 = i27;
                    columnIndexOrThrow = i10;
                    i4 = i32;
                    columnIndexOrThrow16 = i12;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<WorkSpec> getScheduledWork() {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.f5284a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f5284a, acquire, false);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, FacebookAdapter.KEY_ID);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, RemoteConfigConstants.ResponseFieldKey.STATE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "period_start_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
                int i = columnIndexOrThrow14;
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
                int i2 = columnIndexOrThrow13;
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
                int i3 = columnIndexOrThrow12;
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
                int i4 = columnIndexOrThrow11;
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
                int i5 = columnIndexOrThrow10;
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
                int i6 = columnIndexOrThrow9;
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
                int i7 = columnIndexOrThrow8;
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
                int i8 = columnIndexOrThrow7;
                int i9 = columnIndexOrThrow6;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    int i10 = columnIndexOrThrow;
                    String string2 = query.getString(columnIndexOrThrow3);
                    int i11 = columnIndexOrThrow3;
                    Constraints constraints = new Constraints();
                    int i12 = columnIndexOrThrow16;
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(query.getInt(columnIndexOrThrow16)));
                    constraints.setRequiresCharging(query.getInt(columnIndexOrThrow17) != 0);
                    constraints.setRequiresDeviceIdle(query.getInt(columnIndexOrThrow18) != 0);
                    constraints.setRequiresBatteryNotLow(query.getInt(columnIndexOrThrow19) != 0);
                    constraints.setRequiresStorageNotLow(query.getInt(columnIndexOrThrow20) != 0);
                    int i13 = columnIndexOrThrow17;
                    int i14 = columnIndexOrThrow18;
                    constraints.setTriggerContentUpdateDelay(query.getLong(columnIndexOrThrow21));
                    constraints.setTriggerMaxContentDelay(query.getLong(columnIndexOrThrow22));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow23)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow4);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow5));
                    int i15 = i9;
                    workSpec.output = Data.fromByteArray(query.getBlob(i15));
                    int i16 = columnIndexOrThrow4;
                    int i17 = i8;
                    int i18 = columnIndexOrThrow5;
                    workSpec.initialDelay = query.getLong(i17);
                    int i19 = i13;
                    int i20 = i7;
                    int i21 = i17;
                    workSpec.intervalDuration = query.getLong(i20);
                    int i22 = i20;
                    int i23 = i6;
                    int i24 = i19;
                    workSpec.flexDuration = query.getLong(i23);
                    int i25 = i5;
                    workSpec.runAttemptCount = query.getInt(i25);
                    int i26 = i4;
                    i9 = i15;
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(i26));
                    int i27 = i22;
                    int i28 = i3;
                    int i29 = i23;
                    workSpec.backoffDelayDuration = query.getLong(i28);
                    i5 = i25;
                    int i30 = i2;
                    workSpec.periodStartTime = query.getLong(i30);
                    i2 = i30;
                    int i31 = i;
                    workSpec.minimumRetentionDuration = query.getLong(i31);
                    i = i31;
                    int i32 = i26;
                    int i33 = columnIndexOrThrow15;
                    workSpec.scheduleRequestedAt = query.getLong(i33);
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow15 = i33;
                    columnIndexOrThrow4 = i16;
                    columnIndexOrThrow17 = i24;
                    columnIndexOrThrow5 = i18;
                    columnIndexOrThrow3 = i11;
                    columnIndexOrThrow18 = i14;
                    i6 = i29;
                    i8 = i21;
                    i3 = i28;
                    i7 = i27;
                    columnIndexOrThrow = i10;
                    i4 = i32;
                    columnIndexOrThrow16 = i12;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public WorkInfo.State getState(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f5284a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f5284a, acquire, false);
        try {
            return query.moveToFirst() ? WorkTypeConverters.intToState(query.getInt(0)) : null;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<String> getUnfinishedWorkWithName(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f5284a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f5284a, acquire, false);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<String> getUnfinishedWorkWithTag(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f5284a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f5284a, acquire, false);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public WorkSpec getWorkSpec(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        WorkSpec workSpec;
        String str2 = str;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE id=?", 1);
        if (str2 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str2);
        }
        this.f5284a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f5284a, acquire, false);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, FacebookAdapter.KEY_ID);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, RemoteConfigConstants.ResponseFieldKey.STATE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "period_start_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
                int i = columnIndexOrThrow14;
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
                int i2 = columnIndexOrThrow13;
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
                int i3 = columnIndexOrThrow12;
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
                int i4 = columnIndexOrThrow11;
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
                int i5 = columnIndexOrThrow10;
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
                int i6 = columnIndexOrThrow9;
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
                int i7 = columnIndexOrThrow8;
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
                if (query.moveToFirst()) {
                    String string = query.getString(columnIndexOrThrow);
                    String string2 = query.getString(columnIndexOrThrow3);
                    int i8 = columnIndexOrThrow7;
                    Constraints constraints = new Constraints();
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(query.getInt(columnIndexOrThrow16)));
                    constraints.setRequiresCharging(query.getInt(columnIndexOrThrow17) != 0);
                    constraints.setRequiresDeviceIdle(query.getInt(columnIndexOrThrow18) != 0);
                    constraints.setRequiresBatteryNotLow(query.getInt(columnIndexOrThrow19) != 0);
                    constraints.setRequiresStorageNotLow(query.getInt(columnIndexOrThrow20) != 0);
                    constraints.setTriggerContentUpdateDelay(query.getLong(columnIndexOrThrow21));
                    constraints.setTriggerMaxContentDelay(query.getLong(columnIndexOrThrow22));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow23)));
                    workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow4);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow5));
                    workSpec.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow6));
                    workSpec.initialDelay = query.getLong(i8);
                    workSpec.intervalDuration = query.getLong(i7);
                    workSpec.flexDuration = query.getLong(i6);
                    workSpec.runAttemptCount = query.getInt(i5);
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(i4));
                    workSpec.backoffDelayDuration = query.getLong(i3);
                    workSpec.periodStartTime = query.getLong(i2);
                    workSpec.minimumRetentionDuration = query.getLong(i);
                    workSpec.scheduleRequestedAt = query.getLong(columnIndexOrThrow15);
                    workSpec.constraints = constraints;
                } else {
                    workSpec = null;
                }
                query.close();
                roomSQLiteQuery.release();
                return workSpec;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<WorkSpec.IdAndState> getWorkSpecIdAndStatesForName(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f5284a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f5284a, acquire, false);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, FacebookAdapter.KEY_ID);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, RemoteConfigConstants.ResponseFieldKey.STATE);
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                WorkSpec.IdAndState idAndState = new WorkSpec.IdAndState();
                idAndState.f5282id = query.getString(columnIndexOrThrow);
                idAndState.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                arrayList.add(idAndState);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public WorkSpec[] getWorkSpecs(List<String> list) {
        RoomSQLiteQuery roomSQLiteQuery;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT * FROM workspec WHERE id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size + 0);
        int i = 1;
        for (String next : list) {
            if (next == null) {
                acquire.bindNull(i);
            } else {
                acquire.bindString(i, next);
            }
            i++;
        }
        this.f5284a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f5284a, acquire, false);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, FacebookAdapter.KEY_ID);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, RemoteConfigConstants.ResponseFieldKey.STATE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "period_start_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
                int i2 = columnIndexOrThrow14;
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
                int i3 = columnIndexOrThrow13;
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
                int i4 = columnIndexOrThrow12;
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
                int i5 = columnIndexOrThrow11;
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
                int i6 = columnIndexOrThrow10;
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
                int i7 = columnIndexOrThrow9;
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
                int i8 = columnIndexOrThrow8;
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
                int i9 = columnIndexOrThrow7;
                WorkSpec[] workSpecArr = new WorkSpec[query.getCount()];
                int i10 = 0;
                while (query.moveToNext()) {
                    WorkSpec[] workSpecArr2 = workSpecArr;
                    String string = query.getString(columnIndexOrThrow);
                    int i11 = columnIndexOrThrow;
                    String string2 = query.getString(columnIndexOrThrow3);
                    int i12 = columnIndexOrThrow3;
                    Constraints constraints = new Constraints();
                    int i13 = columnIndexOrThrow16;
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(query.getInt(columnIndexOrThrow16)));
                    constraints.setRequiresCharging(query.getInt(columnIndexOrThrow17) != 0);
                    constraints.setRequiresDeviceIdle(query.getInt(columnIndexOrThrow18) != 0);
                    constraints.setRequiresBatteryNotLow(query.getInt(columnIndexOrThrow19) != 0);
                    constraints.setRequiresStorageNotLow(query.getInt(columnIndexOrThrow20) != 0);
                    int i14 = columnIndexOrThrow17;
                    constraints.setTriggerContentUpdateDelay(query.getLong(columnIndexOrThrow21));
                    constraints.setTriggerMaxContentDelay(query.getLong(columnIndexOrThrow22));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow23)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow4);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow5));
                    workSpec.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow6));
                    int i15 = columnIndexOrThrow19;
                    int i16 = i9;
                    workSpec.initialDelay = query.getLong(i16);
                    int i17 = i8;
                    int i18 = columnIndexOrThrow18;
                    workSpec.intervalDuration = query.getLong(i17);
                    int i19 = columnIndexOrThrow4;
                    int i20 = i7;
                    int i21 = columnIndexOrThrow5;
                    workSpec.flexDuration = query.getLong(i20);
                    int i22 = i6;
                    workSpec.runAttemptCount = query.getInt(i22);
                    int i23 = i5;
                    i9 = i16;
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(i23));
                    int i24 = i20;
                    int i25 = i4;
                    int i26 = i17;
                    workSpec.backoffDelayDuration = query.getLong(i25);
                    int i27 = i3;
                    int i28 = i19;
                    workSpec.periodStartTime = query.getLong(i27);
                    i6 = i22;
                    int i29 = i23;
                    int i30 = i2;
                    workSpec.minimumRetentionDuration = query.getLong(i30);
                    int i31 = i27;
                    i2 = i30;
                    int i32 = columnIndexOrThrow15;
                    workSpec.scheduleRequestedAt = query.getLong(i32);
                    workSpec.constraints = constraints;
                    workSpecArr2[i10] = workSpec;
                    i10++;
                    columnIndexOrThrow15 = i32;
                    columnIndexOrThrow19 = i15;
                    columnIndexOrThrow4 = i28;
                    workSpecArr = workSpecArr2;
                    columnIndexOrThrow3 = i12;
                    columnIndexOrThrow17 = i14;
                    columnIndexOrThrow16 = i13;
                    i3 = i31;
                    columnIndexOrThrow5 = i21;
                    i7 = i24;
                    i5 = i29;
                    columnIndexOrThrow18 = i18;
                    i8 = i26;
                    i4 = i25;
                    columnIndexOrThrow = i11;
                }
                WorkSpec[] workSpecArr3 = workSpecArr;
                query.close();
                roomSQLiteQuery.release();
                return workSpecArr3;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: androidx.work.impl.model.WorkSpec$WorkInfoPojo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: androidx.work.impl.model.WorkSpec$WorkInfoPojo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: androidx.work.impl.model.WorkSpec$WorkInfoPojo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: java.util.ArrayList} */
    /* JADX WARNING: type inference failed for: r7v2 */
    /* JADX WARNING: type inference failed for: r7v3, types: [java.util.List<java.lang.String>] */
    /* JADX WARNING: type inference failed for: r7v12 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.work.impl.model.WorkSpec.WorkInfoPojo getWorkStatusPojoForId(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "SELECT id, state, output, run_attempt_count FROM workspec WHERE id=?"
            r1 = 1
            androidx.room.RoomSQLiteQuery r0 = androidx.room.RoomSQLiteQuery.acquire(r0, r1)
            if (r9 != 0) goto L_0x000d
            r0.bindNull(r1)
            goto L_0x0010
        L_0x000d:
            r0.bindString(r1, r9)
        L_0x0010:
            androidx.room.RoomDatabase r9 = r8.f5284a
            r9.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r9 = r8.f5284a
            r9.beginTransaction()
            androidx.room.RoomDatabase r9 = r8.f5284a     // Catch:{ all -> 0x00c5 }
            android.database.Cursor r9 = androidx.room.util.DBUtil.query(r9, r0, r1)     // Catch:{ all -> 0x00c5 }
            java.lang.String r1 = "id"
            int r1 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r9, r1)     // Catch:{ all -> 0x00bd }
            java.lang.String r2 = "state"
            int r2 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r9, r2)     // Catch:{ all -> 0x00bd }
            java.lang.String r3 = "output"
            int r3 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r9, r3)     // Catch:{ all -> 0x00bd }
            java.lang.String r4 = "run_attempt_count"
            int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r9, r4)     // Catch:{ all -> 0x00bd }
            androidx.collection.ArrayMap r5 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x00bd }
            r5.<init>()     // Catch:{ all -> 0x00bd }
        L_0x003d:
            boolean r6 = r9.moveToNext()     // Catch:{ all -> 0x00bd }
            if (r6 == 0) goto L_0x005e
            boolean r6 = r9.isNull(r1)     // Catch:{ all -> 0x00bd }
            if (r6 != 0) goto L_0x003d
            java.lang.String r6 = r9.getString(r1)     // Catch:{ all -> 0x00bd }
            java.lang.Object r7 = r5.get(r6)     // Catch:{ all -> 0x00bd }
            java.util.ArrayList r7 = (java.util.ArrayList) r7     // Catch:{ all -> 0x00bd }
            if (r7 != 0) goto L_0x003d
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x00bd }
            r7.<init>()     // Catch:{ all -> 0x00bd }
            r5.put(r6, r7)     // Catch:{ all -> 0x00bd }
            goto L_0x003d
        L_0x005e:
            r6 = -1
            r9.moveToPosition(r6)     // Catch:{ all -> 0x00bd }
            r8.m4000a(r5)     // Catch:{ all -> 0x00bd }
            boolean r6 = r9.moveToFirst()     // Catch:{ all -> 0x00bd }
            r7 = 0
            if (r6 == 0) goto L_0x00ac
            boolean r6 = r9.isNull(r1)     // Catch:{ all -> 0x00bd }
            if (r6 != 0) goto L_0x007d
            java.lang.String r6 = r9.getString(r1)     // Catch:{ all -> 0x00bd }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ all -> 0x00bd }
            r7 = r5
            java.util.ArrayList r7 = (java.util.ArrayList) r7     // Catch:{ all -> 0x00bd }
        L_0x007d:
            if (r7 != 0) goto L_0x0084
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x00bd }
            r7.<init>()     // Catch:{ all -> 0x00bd }
        L_0x0084:
            androidx.work.impl.model.WorkSpec$WorkInfoPojo r5 = new androidx.work.impl.model.WorkSpec$WorkInfoPojo     // Catch:{ all -> 0x00bd }
            r5.<init>()     // Catch:{ all -> 0x00bd }
            java.lang.String r1 = r9.getString(r1)     // Catch:{ all -> 0x00bd }
            r5.f5283id = r1     // Catch:{ all -> 0x00bd }
            int r1 = r9.getInt(r2)     // Catch:{ all -> 0x00bd }
            androidx.work.WorkInfo$State r1 = androidx.work.impl.model.WorkTypeConverters.intToState(r1)     // Catch:{ all -> 0x00bd }
            r5.state = r1     // Catch:{ all -> 0x00bd }
            byte[] r1 = r9.getBlob(r3)     // Catch:{ all -> 0x00bd }
            androidx.work.Data r1 = androidx.work.Data.fromByteArray(r1)     // Catch:{ all -> 0x00bd }
            r5.output = r1     // Catch:{ all -> 0x00bd }
            int r1 = r9.getInt(r4)     // Catch:{ all -> 0x00bd }
            r5.runAttemptCount = r1     // Catch:{ all -> 0x00bd }
            r5.tags = r7     // Catch:{ all -> 0x00bd }
            r7 = r5
        L_0x00ac:
            androidx.room.RoomDatabase r1 = r8.f5284a     // Catch:{ all -> 0x00bd }
            r1.setTransactionSuccessful()     // Catch:{ all -> 0x00bd }
            r9.close()     // Catch:{ all -> 0x00c5 }
            r0.release()     // Catch:{ all -> 0x00c5 }
            androidx.room.RoomDatabase r9 = r8.f5284a
            r9.endTransaction()
            return r7
        L_0x00bd:
            r1 = move-exception
            r9.close()     // Catch:{ all -> 0x00c5 }
            r0.release()     // Catch:{ all -> 0x00c5 }
            throw r1     // Catch:{ all -> 0x00c5 }
        L_0x00c5:
            r9 = move-exception
            androidx.room.RoomDatabase r0 = r8.f5284a
            r0.endTransaction()
            goto L_0x00cd
        L_0x00cc:
            throw r9
        L_0x00cd:
            goto L_0x00cc
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpecDao_Impl.getWorkStatusPojoForId(java.lang.String):androidx.work.impl.model.WorkSpec$WorkInfoPojo");
    }

    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForIds(List<String> list) {
        Cursor query;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size + 0);
        int i = 1;
        for (String next : list) {
            if (next == null) {
                acquire.bindNull(i);
            } else {
                acquire.bindString(i, next);
            }
            i++;
        }
        this.f5284a.assertNotSuspendingTransaction();
        this.f5284a.beginTransaction();
        try {
            query = DBUtil.query(this.f5284a, acquire, true);
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, FacebookAdapter.KEY_ID);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, RemoteConfigConstants.ResponseFieldKey.STATE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            ArrayMap arrayMap = new ArrayMap();
            while (query.moveToNext()) {
                if (!query.isNull(columnIndexOrThrow)) {
                    String string = query.getString(columnIndexOrThrow);
                    if (((ArrayList) arrayMap.get(string)) == null) {
                        arrayMap.put(string, new ArrayList());
                    }
                }
            }
            query.moveToPosition(-1);
            m4000a(arrayMap);
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                ArrayList arrayList2 = null;
                if (!query.isNull(columnIndexOrThrow)) {
                    arrayList2 = (ArrayList) arrayMap.get(query.getString(columnIndexOrThrow));
                }
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                workInfoPojo.f5283id = query.getString(columnIndexOrThrow);
                workInfoPojo.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                workInfoPojo.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow3));
                workInfoPojo.runAttemptCount = query.getInt(columnIndexOrThrow4);
                workInfoPojo.tags = arrayList2;
                arrayList.add(workInfoPojo);
            }
            this.f5284a.setTransactionSuccessful();
            query.close();
            acquire.release();
            this.f5284a.endTransaction();
            return arrayList;
        } catch (Throwable th) {
            this.f5284a.endTransaction();
            throw th;
        }
    }

    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForName(String str) {
        Cursor query;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f5284a.assertNotSuspendingTransaction();
        this.f5284a.beginTransaction();
        try {
            query = DBUtil.query(this.f5284a, acquire, true);
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, FacebookAdapter.KEY_ID);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, RemoteConfigConstants.ResponseFieldKey.STATE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            ArrayMap arrayMap = new ArrayMap();
            while (query.moveToNext()) {
                if (!query.isNull(columnIndexOrThrow)) {
                    String string = query.getString(columnIndexOrThrow);
                    if (((ArrayList) arrayMap.get(string)) == null) {
                        arrayMap.put(string, new ArrayList());
                    }
                }
            }
            query.moveToPosition(-1);
            m4000a(arrayMap);
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                ArrayList arrayList2 = null;
                if (!query.isNull(columnIndexOrThrow)) {
                    arrayList2 = (ArrayList) arrayMap.get(query.getString(columnIndexOrThrow));
                }
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                workInfoPojo.f5283id = query.getString(columnIndexOrThrow);
                workInfoPojo.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                workInfoPojo.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow3));
                workInfoPojo.runAttemptCount = query.getInt(columnIndexOrThrow4);
                workInfoPojo.tags = arrayList2;
                arrayList.add(workInfoPojo);
            }
            this.f5284a.setTransactionSuccessful();
            query.close();
            acquire.release();
            this.f5284a.endTransaction();
            return arrayList;
        } catch (Throwable th) {
            this.f5284a.endTransaction();
            throw th;
        }
    }

    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForTag(String str) {
        Cursor query;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f5284a.assertNotSuspendingTransaction();
        this.f5284a.beginTransaction();
        try {
            query = DBUtil.query(this.f5284a, acquire, true);
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, FacebookAdapter.KEY_ID);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, RemoteConfigConstants.ResponseFieldKey.STATE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            ArrayMap arrayMap = new ArrayMap();
            while (query.moveToNext()) {
                if (!query.isNull(columnIndexOrThrow)) {
                    String string = query.getString(columnIndexOrThrow);
                    if (((ArrayList) arrayMap.get(string)) == null) {
                        arrayMap.put(string, new ArrayList());
                    }
                }
            }
            query.moveToPosition(-1);
            m4000a(arrayMap);
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                ArrayList arrayList2 = null;
                if (!query.isNull(columnIndexOrThrow)) {
                    arrayList2 = (ArrayList) arrayMap.get(query.getString(columnIndexOrThrow));
                }
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                workInfoPojo.f5283id = query.getString(columnIndexOrThrow);
                workInfoPojo.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                workInfoPojo.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow3));
                workInfoPojo.runAttemptCount = query.getInt(columnIndexOrThrow4);
                workInfoPojo.tags = arrayList2;
                arrayList.add(workInfoPojo);
            }
            this.f5284a.setTransactionSuccessful();
            query.close();
            acquire.release();
            this.f5284a.endTransaction();
            return arrayList;
        } catch (Throwable th) {
            this.f5284a.endTransaction();
            throw th;
        }
    }

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForIds(List<String> list) {
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size + 0);
        int i = 1;
        for (String next : list) {
            if (next == null) {
                acquire.bindNull(i);
            } else {
                acquire.bindString(i, next);
            }
            i++;
        }
        return this.f5284a.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "workspec"}, true, new C1111a(acquire));
    }

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForName(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return this.f5284a.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "workspec", "workname"}, true, new C1113c(acquire));
    }

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForTag(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return this.f5284a.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "workspec", "worktag"}, true, new C1112b(acquire));
    }

    public int incrementWorkSpecRunAttemptCount(String str) {
        this.f5284a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f5289f.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f5284a.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.f5284a.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.f5284a.endTransaction();
            this.f5289f.release(acquire);
        }
    }

    public void insertWorkSpec(WorkSpec workSpec) {
        this.f5284a.assertNotSuspendingTransaction();
        this.f5284a.beginTransaction();
        try {
            this.f5285b.insert(workSpec);
            this.f5284a.setTransactionSuccessful();
        } finally {
            this.f5284a.endTransaction();
        }
    }

    public int markWorkSpecScheduled(String str, long j) {
        this.f5284a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f5291h.acquire();
        acquire.bindLong(1, j);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.f5284a.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.f5284a.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.f5284a.endTransaction();
            this.f5291h.release(acquire);
        }
    }

    public void pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast() {
        this.f5284a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f5293j.acquire();
        this.f5284a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.f5284a.setTransactionSuccessful();
        } finally {
            this.f5284a.endTransaction();
            this.f5293j.release(acquire);
        }
    }

    public int resetScheduledState() {
        this.f5284a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f5292i.acquire();
        this.f5284a.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.f5284a.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.f5284a.endTransaction();
            this.f5292i.release(acquire);
        }
    }

    public int resetWorkSpecRunAttemptCount(String str) {
        this.f5284a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f5290g.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f5284a.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.f5284a.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.f5284a.endTransaction();
            this.f5290g.release(acquire);
        }
    }

    public void setOutput(String str, Data data) {
        this.f5284a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f5287d.acquire();
        byte[] byteArray = Data.toByteArray(data);
        if (byteArray == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindBlob(1, byteArray);
        }
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.f5284a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.f5284a.setTransactionSuccessful();
        } finally {
            this.f5284a.endTransaction();
            this.f5287d.release(acquire);
        }
    }

    public void setPeriodStartTime(String str, long j) {
        this.f5284a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f5288e.acquire();
        acquire.bindLong(1, j);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.f5284a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.f5284a.setTransactionSuccessful();
        } finally {
            this.f5284a.endTransaction();
            this.f5288e.release(acquire);
        }
    }

    public int setState(WorkInfo.State state, String... strArr) {
        this.f5284a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("UPDATE workspec SET state=");
        newStringBuilder.append("?");
        newStringBuilder.append(" WHERE id IN (");
        StringUtil.appendPlaceholders(newStringBuilder, strArr.length);
        newStringBuilder.append(")");
        SupportSQLiteStatement compileStatement = this.f5284a.compileStatement(newStringBuilder.toString());
        compileStatement.bindLong(1, (long) WorkTypeConverters.stateToInt(state));
        int i = 2;
        for (String str : strArr) {
            if (str == null) {
                compileStatement.bindNull(i);
            } else {
                compileStatement.bindString(i, str);
            }
            i++;
        }
        this.f5284a.beginTransaction();
        try {
            int executeUpdateDelete = compileStatement.executeUpdateDelete();
            this.f5284a.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.f5284a.endTransaction();
        }
    }
}
