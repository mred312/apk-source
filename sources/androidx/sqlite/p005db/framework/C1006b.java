package androidx.sqlite.p005db.framework;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.RequiresApi;
import androidx.sqlite.p005db.SupportSQLiteDatabase;
import androidx.sqlite.p005db.SupportSQLiteOpenHelper;

/* renamed from: androidx.sqlite.db.framework.b */
/* compiled from: FrameworkSQLiteOpenHelper */
class C1006b implements SupportSQLiteOpenHelper {

    /* renamed from: a */
    private final C1007a f4673a;

    /* renamed from: androidx.sqlite.db.framework.b$a */
    /* compiled from: FrameworkSQLiteOpenHelper */
    static class C1007a extends SQLiteOpenHelper {

        /* renamed from: a */
        final C1003a[] f4674a;

        /* renamed from: b */
        final SupportSQLiteOpenHelper.Callback f4675b;

        /* renamed from: c */
        private boolean f4676c;

        /* renamed from: androidx.sqlite.db.framework.b$a$a */
        /* compiled from: FrameworkSQLiteOpenHelper */
        class C1008a implements DatabaseErrorHandler {

            /* renamed from: a */
            final /* synthetic */ SupportSQLiteOpenHelper.Callback f4677a;

            /* renamed from: b */
            final /* synthetic */ C1003a[] f4678b;

            C1008a(SupportSQLiteOpenHelper.Callback callback, C1003a[] aVarArr) {
                this.f4677a = callback;
                this.f4678b = aVarArr;
            }

            public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                this.f4677a.onCorruption(C1007a.m3661c(this.f4678b, sQLiteDatabase));
            }
        }

        C1007a(Context context, String str, C1003a[] aVarArr, SupportSQLiteOpenHelper.Callback callback) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, callback.version, new C1008a(callback, aVarArr));
            this.f4675b = callback;
            this.f4674a = aVarArr;
        }

        /* renamed from: c */
        static C1003a m3661c(C1003a[] aVarArr, SQLiteDatabase sQLiteDatabase) {
            C1003a aVar = aVarArr[0];
            if (aVar == null || !aVar.mo8065a(sQLiteDatabase)) {
                aVarArr[0] = new C1003a(sQLiteDatabase);
            }
            return aVarArr[0];
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public synchronized SupportSQLiteDatabase mo8069a() {
            this.f4676c = false;
            SQLiteDatabase readableDatabase = super.getReadableDatabase();
            if (this.f4676c) {
                close();
                return mo8069a();
            }
            return mo8070b(readableDatabase);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C1003a mo8070b(SQLiteDatabase sQLiteDatabase) {
            return m3661c(this.f4674a, sQLiteDatabase);
        }

        public synchronized void close() {
            super.close();
            this.f4674a[0] = null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public synchronized SupportSQLiteDatabase mo8072d() {
            this.f4676c = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (this.f4676c) {
                close();
                return mo8072d();
            }
            return mo8070b(writableDatabase);
        }

        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.f4675b.onConfigure(mo8070b(sQLiteDatabase));
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.f4675b.onCreate(mo8070b(sQLiteDatabase));
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.f4676c = true;
            this.f4675b.onDowngrade(mo8070b(sQLiteDatabase), i, i2);
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (!this.f4676c) {
                this.f4675b.onOpen(mo8070b(sQLiteDatabase));
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.f4676c = true;
            this.f4675b.onUpgrade(mo8070b(sQLiteDatabase), i, i2);
        }
    }

    C1006b(Context context, String str, SupportSQLiteOpenHelper.Callback callback) {
        this.f4673a = m3660a(context, str, callback);
    }

    /* renamed from: a */
    private C1007a m3660a(Context context, String str, SupportSQLiteOpenHelper.Callback callback) {
        return new C1007a(context, str, new C1003a[1], callback);
    }

    public void close() {
        this.f4673a.close();
    }

    public String getDatabaseName() {
        return this.f4673a.getDatabaseName();
    }

    public SupportSQLiteDatabase getReadableDatabase() {
        return this.f4673a.mo8069a();
    }

    public SupportSQLiteDatabase getWritableDatabase() {
        return this.f4673a.mo8072d();
    }

    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.f4673a.setWriteAheadLoggingEnabled(z);
    }
}
