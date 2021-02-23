package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.z */
/* compiled from: SchemaManager */
final /* synthetic */ class C1654z implements SchemaManager.Migration {

    /* renamed from: a */
    private static final C1654z f7406a = new C1654z();

    private C1654z() {
    }

    /* renamed from: a */
    public static SchemaManager.Migration m5211a() {
        return f7406a;
    }

    public void upgrade(SQLiteDatabase sQLiteDatabase) {
        SchemaManager.m5161e(sQLiteDatabase);
    }
}
