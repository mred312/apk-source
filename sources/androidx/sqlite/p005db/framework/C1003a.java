package androidx.sqlite.p005db.framework;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import androidx.sqlite.p005db.SimpleSQLiteQuery;
import androidx.sqlite.p005db.SupportSQLiteDatabase;
import androidx.sqlite.p005db.SupportSQLiteQuery;
import androidx.sqlite.p005db.SupportSQLiteStatement;
import java.util.List;
import java.util.Locale;

/* renamed from: androidx.sqlite.db.framework.a */
/* compiled from: FrameworkSQLiteDatabase */
class C1003a implements SupportSQLiteDatabase {

    /* renamed from: b */
    private static final String[] f4668b = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: c */
    private static final String[] f4669c = new String[0];

    /* renamed from: a */
    private final SQLiteDatabase f4670a;

    /* renamed from: androidx.sqlite.db.framework.a$a */
    /* compiled from: FrameworkSQLiteDatabase */
    class C1004a implements SQLiteDatabase.CursorFactory {

        /* renamed from: a */
        final /* synthetic */ SupportSQLiteQuery f4671a;

        C1004a(C1003a aVar, SupportSQLiteQuery supportSQLiteQuery) {
            this.f4671a = supportSQLiteQuery;
        }

        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.f4671a.bindTo(new C1009c(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    /* renamed from: androidx.sqlite.db.framework.a$b */
    /* compiled from: FrameworkSQLiteDatabase */
    class C1005b implements SQLiteDatabase.CursorFactory {

        /* renamed from: a */
        final /* synthetic */ SupportSQLiteQuery f4672a;

        C1005b(C1003a aVar, SupportSQLiteQuery supportSQLiteQuery) {
            this.f4672a = supportSQLiteQuery;
        }

        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.f4672a.bindTo(new C1009c(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    C1003a(SQLiteDatabase sQLiteDatabase) {
        this.f4670a = sQLiteDatabase;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo8065a(SQLiteDatabase sQLiteDatabase) {
        return this.f4670a == sQLiteDatabase;
    }

    public void beginTransaction() {
        this.f4670a.beginTransaction();
    }

    public void beginTransactionNonExclusive() {
        this.f4670a.beginTransactionNonExclusive();
    }

    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        this.f4670a.beginTransactionWithListener(sQLiteTransactionListener);
    }

    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        this.f4670a.beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
    }

    public void close() {
        this.f4670a.close();
    }

    public SupportSQLiteStatement compileStatement(String str) {
        return new C1010d(this.f4670a.compileStatement(str));
    }

    public int delete(String str, String str2, Object[] objArr) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(str);
        if (TextUtils.isEmpty(str2)) {
            str3 = "";
        } else {
            str3 = " WHERE " + str2;
        }
        sb.append(str3);
        SupportSQLiteStatement compileStatement = compileStatement(sb.toString());
        SimpleSQLiteQuery.bind(compileStatement, objArr);
        return compileStatement.executeUpdateDelete();
    }

    @RequiresApi(api = 16)
    public void disableWriteAheadLogging() {
        this.f4670a.disableWriteAheadLogging();
    }

    public boolean enableWriteAheadLogging() {
        return this.f4670a.enableWriteAheadLogging();
    }

    public void endTransaction() {
        this.f4670a.endTransaction();
    }

    public void execSQL(String str) {
        this.f4670a.execSQL(str);
    }

    public List<Pair<String, String>> getAttachedDbs() {
        return this.f4670a.getAttachedDbs();
    }

    public long getMaximumSize() {
        return this.f4670a.getMaximumSize();
    }

    public long getPageSize() {
        return this.f4670a.getPageSize();
    }

    public String getPath() {
        return this.f4670a.getPath();
    }

    public int getVersion() {
        return this.f4670a.getVersion();
    }

    public boolean inTransaction() {
        return this.f4670a.inTransaction();
    }

    public long insert(String str, int i, ContentValues contentValues) {
        return this.f4670a.insertWithOnConflict(str, (String) null, contentValues, i);
    }

    public boolean isDatabaseIntegrityOk() {
        return this.f4670a.isDatabaseIntegrityOk();
    }

    public boolean isDbLockedByCurrentThread() {
        return this.f4670a.isDbLockedByCurrentThread();
    }

    public boolean isOpen() {
        return this.f4670a.isOpen();
    }

    public boolean isReadOnly() {
        return this.f4670a.isReadOnly();
    }

    @RequiresApi(api = 16)
    public boolean isWriteAheadLoggingEnabled() {
        return this.f4670a.isWriteAheadLoggingEnabled();
    }

    public boolean needUpgrade(int i) {
        return this.f4670a.needUpgrade(i);
    }

    public Cursor query(String str) {
        return query((SupportSQLiteQuery) new SimpleSQLiteQuery(str));
    }

    @RequiresApi(api = 16)
    public void setForeignKeyConstraintsEnabled(boolean z) {
        this.f4670a.setForeignKeyConstraintsEnabled(z);
    }

    public void setLocale(Locale locale) {
        this.f4670a.setLocale(locale);
    }

    public void setMaxSqlCacheSize(int i) {
        this.f4670a.setMaxSqlCacheSize(i);
    }

    public long setMaximumSize(long j) {
        return this.f4670a.setMaximumSize(j);
    }

    public void setPageSize(long j) {
        this.f4670a.setPageSize(j);
    }

    public void setTransactionSuccessful() {
        this.f4670a.setTransactionSuccessful();
    }

    public void setVersion(int i) {
        this.f4670a.setVersion(i);
    }

    public int update(String str, int i, ContentValues contentValues, String str2, Object[] objArr) {
        int i2;
        if (contentValues == null || contentValues.size() == 0) {
            throw new IllegalArgumentException("Empty values");
        }
        StringBuilder sb = new StringBuilder(120);
        sb.append("UPDATE ");
        sb.append(f4668b[i]);
        sb.append(str);
        sb.append(" SET ");
        int size = contentValues.size();
        if (objArr == null) {
            i2 = size;
        } else {
            i2 = objArr.length + size;
        }
        Object[] objArr2 = new Object[i2];
        int i3 = 0;
        for (String next : contentValues.keySet()) {
            sb.append(i3 > 0 ? "," : "");
            sb.append(next);
            objArr2[i3] = contentValues.get(next);
            sb.append("=?");
            i3++;
        }
        if (objArr != null) {
            for (int i4 = size; i4 < i2; i4++) {
                objArr2[i4] = objArr[i4 - size];
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(" WHERE ");
            sb.append(str2);
        }
        SupportSQLiteStatement compileStatement = compileStatement(sb.toString());
        SimpleSQLiteQuery.bind(compileStatement, objArr2);
        return compileStatement.executeUpdateDelete();
    }

    public boolean yieldIfContendedSafely() {
        return this.f4670a.yieldIfContendedSafely();
    }

    public void execSQL(String str, Object[] objArr) {
        this.f4670a.execSQL(str, objArr);
    }

    public Cursor query(String str, Object[] objArr) {
        return query((SupportSQLiteQuery) new SimpleSQLiteQuery(str, objArr));
    }

    public boolean yieldIfContendedSafely(long j) {
        return this.f4670a.yieldIfContendedSafely(j);
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        return this.f4670a.rawQueryWithFactory(new C1004a(this, supportSQLiteQuery), supportSQLiteQuery.getSql(), f4669c, (String) null);
    }

    @RequiresApi(api = 16)
    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        return this.f4670a.rawQueryWithFactory(new C1005b(this, supportSQLiteQuery), supportSQLiteQuery.getSql(), f4669c, (String) null, cancellationSignal);
    }
}
