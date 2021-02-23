package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.e */
/* compiled from: SQLiteEventStore */
final /* synthetic */ class C1633e implements SQLiteEventStore.C1623b {

    /* renamed from: a */
    private final SQLiteEventStore f7379a;

    /* renamed from: b */
    private final TransportContext f7380b;

    private C1633e(SQLiteEventStore sQLiteEventStore, TransportContext transportContext) {
        this.f7379a = sQLiteEventStore;
        this.f7380b = transportContext;
    }

    /* renamed from: a */
    public static SQLiteEventStore.C1623b m5188a(SQLiteEventStore sQLiteEventStore, TransportContext transportContext) {
        return new C1633e(sQLiteEventStore, transportContext);
    }

    public Object apply(Object obj) {
        return SQLiteEventStore.m5147s(this.f7379a, this.f7380b, (SQLiteDatabase) obj);
    }
}
