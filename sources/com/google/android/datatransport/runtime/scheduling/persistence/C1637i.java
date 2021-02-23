package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.List;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.i */
/* compiled from: SQLiteEventStore */
final /* synthetic */ class C1637i implements SQLiteEventStore.C1623b {

    /* renamed from: a */
    private final SQLiteEventStore f7384a;

    /* renamed from: b */
    private final List f7385b;

    /* renamed from: c */
    private final TransportContext f7386c;

    private C1637i(SQLiteEventStore sQLiteEventStore, List list, TransportContext transportContext) {
        this.f7384a = sQLiteEventStore;
        this.f7385b = list;
        this.f7386c = transportContext;
    }

    /* renamed from: a */
    public static SQLiteEventStore.C1623b m5192a(SQLiteEventStore sQLiteEventStore, List list, TransportContext transportContext) {
        return new C1637i(sQLiteEventStore, list, transportContext);
    }

    public Object apply(Object obj) {
        return SQLiteEventStore.m5148t(this.f7384a, this.f7385b, this.f7386c, (Cursor) obj);
    }
}
