package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.p005db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;

public final class WorkNameDao_Impl implements WorkNameDao {

    /* renamed from: a */
    private final RoomDatabase f5278a;

    /* renamed from: b */
    private final EntityInsertionAdapter f5279b;

    /* renamed from: androidx.work.impl.model.WorkNameDao_Impl$a */
    class C1109a extends EntityInsertionAdapter<WorkName> {
        C1109a(WorkNameDao_Impl workNameDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: c */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkName workName) {
            String str = workName.name;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = workName.workSpecId;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
        }

        public String createQuery() {
            return "INSERT OR IGNORE INTO `WorkName`(`name`,`work_spec_id`) VALUES (?,?)";
        }
    }

    public WorkNameDao_Impl(RoomDatabase roomDatabase) {
        this.f5278a = roomDatabase;
        this.f5279b = new C1109a(this, roomDatabase);
    }

    public List<String> getWorkSpecIdsWithName(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT work_spec_id FROM workname WHERE name=?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f5278a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f5278a, acquire, false);
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

    public void insert(WorkName workName) {
        this.f5278a.assertNotSuspendingTransaction();
        this.f5278a.beginTransaction();
        try {
            this.f5279b.insert(workName);
            this.f5278a.setTransactionSuccessful();
        } finally {
            this.f5278a.endTransaction();
        }
    }
}
