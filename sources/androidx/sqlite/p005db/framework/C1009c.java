package androidx.sqlite.p005db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.p005db.SupportSQLiteProgram;

/* renamed from: androidx.sqlite.db.framework.c */
/* compiled from: FrameworkSQLiteProgram */
class C1009c implements SupportSQLiteProgram {

    /* renamed from: a */
    private final SQLiteProgram f4679a;

    C1009c(SQLiteProgram sQLiteProgram) {
        this.f4679a = sQLiteProgram;
    }

    public void bindBlob(int i, byte[] bArr) {
        this.f4679a.bindBlob(i, bArr);
    }

    public void bindDouble(int i, double d) {
        this.f4679a.bindDouble(i, d);
    }

    public void bindLong(int i, long j) {
        this.f4679a.bindLong(i, j);
    }

    public void bindNull(int i) {
        this.f4679a.bindNull(i);
    }

    public void bindString(int i, String str) {
        this.f4679a.bindString(i, str);
    }

    public void clearBindings() {
        this.f4679a.clearBindings();
    }

    public void close() {
        this.f4679a.close();
    }
}
