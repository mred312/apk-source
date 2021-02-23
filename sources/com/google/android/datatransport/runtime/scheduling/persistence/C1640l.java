package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.l */
/* compiled from: SQLiteEventStore */
final /* synthetic */ class C1640l implements SQLiteEventStore.C1625d {

    /* renamed from: a */
    private final SQLiteDatabase f7389a;

    private C1640l(SQLiteDatabase sQLiteDatabase) {
        this.f7389a = sQLiteDatabase;
    }

    /* renamed from: b */
    public static SQLiteEventStore.C1625d m5195b(SQLiteDatabase sQLiteDatabase) {
        return new C1640l(sQLiteDatabase);
    }

    /* renamed from: a */
    public Object mo11513a() {
        return this.f7389a.beginTransaction();
    }
}
