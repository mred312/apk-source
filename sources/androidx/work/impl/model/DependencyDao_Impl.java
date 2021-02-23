package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.p005db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;

public final class DependencyDao_Impl implements DependencyDao {

    /* renamed from: a */
    private final RoomDatabase f5273a;

    /* renamed from: b */
    private final EntityInsertionAdapter f5274b;

    /* renamed from: androidx.work.impl.model.DependencyDao_Impl$a */
    class C1106a extends EntityInsertionAdapter<Dependency> {
        C1106a(DependencyDao_Impl dependencyDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: c */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, Dependency dependency) {
            String str = dependency.workSpecId;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = dependency.prerequisiteId;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
        }

        public String createQuery() {
            return "INSERT OR IGNORE INTO `Dependency`(`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
        }
    }

    public DependencyDao_Impl(RoomDatabase roomDatabase) {
        this.f5273a = roomDatabase;
        this.f5274b = new C1106a(this, roomDatabase);
    }

    public List<String> getDependentWorkIds(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f5273a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f5273a, acquire, false);
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

    public List<String> getPrerequisites(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT prerequisite_id FROM dependency WHERE work_spec_id=?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f5273a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f5273a, acquire, false);
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

    public boolean hasCompletedAllPrerequisites(String str) {
        boolean z = true;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f5273a.assertNotSuspendingTransaction();
        boolean z2 = false;
        Cursor query = DBUtil.query(this.f5273a, acquire, false);
        try {
            if (query.moveToFirst()) {
                if (query.getInt(0) == 0) {
                    z = false;
                }
                z2 = z;
            }
            return z2;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public boolean hasDependents(String str) {
        boolean z = true;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f5273a.assertNotSuspendingTransaction();
        boolean z2 = false;
        Cursor query = DBUtil.query(this.f5273a, acquire, false);
        try {
            if (query.moveToFirst()) {
                if (query.getInt(0) == 0) {
                    z = false;
                }
                z2 = z;
            }
            return z2;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public void insertDependency(Dependency dependency) {
        this.f5273a.assertNotSuspendingTransaction();
        this.f5273a.beginTransaction();
        try {
            this.f5274b.insert(dependency);
            this.f5273a.setTransactionSuccessful();
        } finally {
            this.f5273a.endTransaction();
        }
    }
}
