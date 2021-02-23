package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.y */
/* compiled from: SchemaManager */
final /* synthetic */ class C1653y implements SchemaManager.Migration {

    /* renamed from: a */
    private static final C1653y f7405a = new C1653y();

    private C1653y() {
    }

    /* renamed from: a */
    public static SchemaManager.Migration m5210a() {
        return f7405a;
    }

    public void upgrade(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
    }
}
