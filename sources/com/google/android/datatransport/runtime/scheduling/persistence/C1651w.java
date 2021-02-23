package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.w */
/* compiled from: SchemaManager */
final /* synthetic */ class C1651w implements SchemaManager.Migration {

    /* renamed from: a */
    private static final C1651w f7403a = new C1651w();

    private C1651w() {
    }

    /* renamed from: a */
    public static SchemaManager.Migration m5208a() {
        return f7403a;
    }

    public void upgrade(SQLiteDatabase sQLiteDatabase) {
        SchemaManager.m5158b(sQLiteDatabase);
    }
}
