package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.o */
/* compiled from: SQLiteEventStore */
final /* synthetic */ class C1643o implements SQLiteEventStore.C1623b {

    /* renamed from: a */
    private static final C1643o f7392a = new C1643o();

    private C1643o() {
    }

    /* renamed from: a */
    public static SQLiteEventStore.C1623b m5200a() {
        return f7392a;
    }

    public Object apply(Object obj) {
        return SQLiteEventStore.m5145q((Cursor) obj);
    }
}
