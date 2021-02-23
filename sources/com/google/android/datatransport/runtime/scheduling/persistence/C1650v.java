package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.v */
/* compiled from: SQLiteEventStore */
final /* synthetic */ class C1650v implements SQLiteEventStore.C1623b {

    /* renamed from: a */
    private final SQLiteEventStore f7401a;

    /* renamed from: b */
    private final TransportContext f7402b;

    private C1650v(SQLiteEventStore sQLiteEventStore, TransportContext transportContext) {
        this.f7401a = sQLiteEventStore;
        this.f7402b = transportContext;
    }

    /* renamed from: a */
    public static SQLiteEventStore.C1623b m5207a(SQLiteEventStore sQLiteEventStore, TransportContext transportContext) {
        return new C1650v(sQLiteEventStore, transportContext);
    }

    public Object apply(Object obj) {
        return SQLiteEventStore.m5144p(this.f7401a, this.f7402b, (SQLiteDatabase) obj);
    }
}
