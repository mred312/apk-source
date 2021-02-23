package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.x */
/* compiled from: SchemaManager */
final /* synthetic */ class C1652x implements SchemaManager.Migration {

    /* renamed from: a */
    private static final C1652x f7404a = new C1652x();

    private C1652x() {
    }

    /* renamed from: a */
    public static SchemaManager.Migration m5209a() {
        return f7404a;
    }

    public void upgrade(SQLiteDatabase sQLiteDatabase) {
        SchemaManager.m5159c(sQLiteDatabase);
    }
}
