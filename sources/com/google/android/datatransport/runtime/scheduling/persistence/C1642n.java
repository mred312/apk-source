package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.n */
/* compiled from: SQLiteEventStore */
final /* synthetic */ class C1642n implements SQLiteEventStore.C1625d {

    /* renamed from: a */
    private final SchemaManager f7391a;

    private C1642n(SchemaManager schemaManager) {
        this.f7391a = schemaManager;
    }

    /* renamed from: b */
    public static SQLiteEventStore.C1625d m5198b(SchemaManager schemaManager) {
        return new C1642n(schemaManager);
    }

    /* renamed from: a */
    public Object mo11513a() {
        return this.f7391a.getWritableDatabase();
    }
}
