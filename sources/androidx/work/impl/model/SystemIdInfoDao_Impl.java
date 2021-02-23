package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.p005db.SupportSQLiteStatement;

public final class SystemIdInfoDao_Impl implements SystemIdInfoDao {

    /* renamed from: a */
    private final RoomDatabase f5275a;

    /* renamed from: b */
    private final EntityInsertionAdapter f5276b;

    /* renamed from: c */
    private final SharedSQLiteStatement f5277c;

    /* renamed from: androidx.work.impl.model.SystemIdInfoDao_Impl$a */
    class C1107a extends EntityInsertionAdapter<SystemIdInfo> {
        C1107a(SystemIdInfoDao_Impl systemIdInfoDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: c */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, SystemIdInfo systemIdInfo) {
            String str = systemIdInfo.workSpecId;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            supportSQLiteStatement.bindLong(2, (long) systemIdInfo.systemId);
        }

        public String createQuery() {
            return "INSERT OR REPLACE INTO `SystemIdInfo`(`work_spec_id`,`system_id`) VALUES (?,?)";
        }
    }

    /* renamed from: androidx.work.impl.model.SystemIdInfoDao_Impl$b */
    class C1108b extends SharedSQLiteStatement {
        C1108b(SystemIdInfoDao_Impl systemIdInfoDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM SystemIdInfo where work_spec_id=?";
        }
    }

    public SystemIdInfoDao_Impl(RoomDatabase roomDatabase) {
        this.f5275a = roomDatabase;
        this.f5276b = new C1107a(this, roomDatabase);
        this.f5277c = new C1108b(this, roomDatabase);
    }

    public SystemIdInfo getSystemIdInfo(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM SystemIdInfo WHERE work_spec_id=?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f5275a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f5275a, acquire, false);
        try {
            return query.moveToFirst() ? new SystemIdInfo(query.getString(CursorUtil.getColumnIndexOrThrow(query, "work_spec_id")), query.getInt(CursorUtil.getColumnIndexOrThrow(query, "system_id"))) : null;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public void insertSystemIdInfo(SystemIdInfo systemIdInfo) {
        this.f5275a.assertNotSuspendingTransaction();
        this.f5275a.beginTransaction();
        try {
            this.f5276b.insert(systemIdInfo);
            this.f5275a.setTransactionSuccessful();
        } finally {
            this.f5275a.endTransaction();
        }
    }

    public void removeSystemIdInfo(String str) {
        this.f5275a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f5277c.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f5275a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.f5275a.setTransactionSuccessful();
        } finally {
            this.f5275a.endTransaction();
            this.f5277c.release(acquire);
        }
    }
}
