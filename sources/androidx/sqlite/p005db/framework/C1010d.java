package androidx.sqlite.p005db.framework;

import android.database.sqlite.SQLiteStatement;
import androidx.sqlite.p005db.SupportSQLiteStatement;

/* renamed from: androidx.sqlite.db.framework.d */
/* compiled from: FrameworkSQLiteStatement */
class C1010d extends C1009c implements SupportSQLiteStatement {

    /* renamed from: b */
    private final SQLiteStatement f4680b;

    C1010d(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f4680b = sQLiteStatement;
    }

    public void execute() {
        this.f4680b.execute();
    }

    public long executeInsert() {
        return this.f4680b.executeInsert();
    }

    public int executeUpdateDelete() {
        return this.f4680b.executeUpdateDelete();
    }

    public long simpleQueryForLong() {
        return this.f4680b.simpleQueryForLong();
    }

    public String simpleQueryForString() {
        return this.f4680b.simpleQueryForString();
    }
}
