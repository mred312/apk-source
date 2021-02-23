package androidx.room.paging;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.paging.PositionalDataSource;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.p005db.SupportSQLiteQuery;
import java.util.List;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class LimitOffsetDataSource<T> extends PositionalDataSource<T> {

    /* renamed from: a */
    private final RoomSQLiteQuery f4598a;

    /* renamed from: b */
    private final String f4599b;

    /* renamed from: c */
    private final String f4600c;

    /* renamed from: d */
    private final RoomDatabase f4601d;

    /* renamed from: e */
    private final InvalidationTracker.Observer f4602e;

    /* renamed from: f */
    private final boolean f4603f;

    /* renamed from: androidx.room.paging.LimitOffsetDataSource$a */
    class C0988a extends InvalidationTracker.Observer {
        C0988a(String[] strArr) {
            super(strArr);
        }

        public void onInvalidated(@NonNull Set<String> set) {
            LimitOffsetDataSource.this.invalidate();
        }
    }

    protected LimitOffsetDataSource(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean z, String... strArr) {
        this(roomDatabase, RoomSQLiteQuery.copyFrom(supportSQLiteQuery), z, strArr);
    }

    /* renamed from: a */
    private RoomSQLiteQuery m3618a(int i, int i2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(this.f4600c, this.f4598a.getArgCount() + 2);
        acquire.copyArgumentsFrom(this.f4598a);
        acquire.bindLong(acquire.getArgCount() - 1, (long) i2);
        acquire.bindLong(acquire.getArgCount(), (long) i);
        return acquire;
    }

    /* access modifiers changed from: protected */
    public abstract List<T> convertRows(Cursor cursor);

    public int countItems() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(this.f4599b, this.f4598a.getArgCount());
        acquire.copyArgumentsFrom(this.f4598a);
        Cursor query = this.f4601d.query(acquire);
        try {
            if (query.moveToFirst()) {
                return query.getInt(0);
            }
            query.close();
            acquire.release();
            return 0;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public boolean isInvalid() {
        this.f4601d.getInvalidationTracker().refreshVersionsSync();
        return LimitOffsetDataSource.super.isInvalid();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadInitial(@androidx.annotation.NonNull androidx.paging.PositionalDataSource.LoadInitialParams r7, @androidx.annotation.NonNull androidx.paging.PositionalDataSource.LoadInitialCallback<T> r8) {
        /*
            r6 = this;
            java.util.List r0 = java.util.Collections.emptyList()
            androidx.room.RoomDatabase r1 = r6.f4601d
            r1.beginTransaction()
            r1 = 0
            int r2 = r6.countItems()     // Catch:{ all -> 0x0047 }
            if (r2 == 0) goto L_0x0032
            int r0 = computeInitialLoadPosition(r7, r2)     // Catch:{ all -> 0x0047 }
            int r7 = computeInitialLoadSize(r7, r0, r2)     // Catch:{ all -> 0x0047 }
            androidx.room.RoomSQLiteQuery r7 = r6.m3618a(r0, r7)     // Catch:{ all -> 0x0047 }
            androidx.room.RoomDatabase r3 = r6.f4601d     // Catch:{ all -> 0x0030 }
            android.database.Cursor r1 = r3.query(r7)     // Catch:{ all -> 0x0030 }
            java.util.List r3 = r6.convertRows(r1)     // Catch:{ all -> 0x0030 }
            androidx.room.RoomDatabase r4 = r6.f4601d     // Catch:{ all -> 0x0030 }
            r4.setTransactionSuccessful()     // Catch:{ all -> 0x0030 }
            r5 = r3
            r3 = r7
            r7 = r0
            r0 = r5
            goto L_0x0034
        L_0x0030:
            r8 = move-exception
            goto L_0x0049
        L_0x0032:
            r7 = 0
            r3 = r1
        L_0x0034:
            if (r1 == 0) goto L_0x0039
            r1.close()
        L_0x0039:
            androidx.room.RoomDatabase r1 = r6.f4601d
            r1.endTransaction()
            if (r3 == 0) goto L_0x0043
            r3.release()
        L_0x0043:
            r8.onResult(r0, r7, r2)
            return
        L_0x0047:
            r8 = move-exception
            r7 = r1
        L_0x0049:
            if (r1 == 0) goto L_0x004e
            r1.close()
        L_0x004e:
            androidx.room.RoomDatabase r0 = r6.f4601d
            r0.endTransaction()
            if (r7 == 0) goto L_0x0058
            r7.release()
        L_0x0058:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.paging.LimitOffsetDataSource.loadInitial(androidx.paging.PositionalDataSource$LoadInitialParams, androidx.paging.PositionalDataSource$LoadInitialCallback):void");
    }

    public void loadRange(@NonNull PositionalDataSource.LoadRangeParams loadRangeParams, @NonNull PositionalDataSource.LoadRangeCallback<T> loadRangeCallback) {
        loadRangeCallback.onResult(loadRange(loadRangeParams.startPosition, loadRangeParams.loadSize));
    }

    protected LimitOffsetDataSource(RoomDatabase roomDatabase, RoomSQLiteQuery roomSQLiteQuery, boolean z, String... strArr) {
        this.f4601d = roomDatabase;
        this.f4598a = roomSQLiteQuery;
        this.f4603f = z;
        this.f4599b = "SELECT COUNT(*) FROM ( " + roomSQLiteQuery.getSql() + " )";
        this.f4600c = "SELECT * FROM ( " + roomSQLiteQuery.getSql() + " ) LIMIT ? OFFSET ?";
        C0988a aVar = new C0988a(strArr);
        this.f4602e = aVar;
        roomDatabase.getInvalidationTracker().addWeakObserver(aVar);
    }

    @NonNull
    public List<T> loadRange(int i, int i2) {
        RoomSQLiteQuery a = m3618a(i, i2);
        if (this.f4603f) {
            this.f4601d.beginTransaction();
            Cursor cursor = null;
            try {
                cursor = this.f4601d.query(a);
                List<T> convertRows = convertRows(cursor);
                this.f4601d.setTransactionSuccessful();
                return convertRows;
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
                this.f4601d.endTransaction();
                a.release();
            }
        } else {
            Cursor query = this.f4601d.query(a);
            try {
                return convertRows(query);
            } finally {
                query.close();
                a.release();
            }
        }
    }
}
