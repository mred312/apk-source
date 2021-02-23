package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.j */
/* compiled from: SQLiteEventStore */
final /* synthetic */ class C1638j implements SQLiteEventStore.C1623b {

    /* renamed from: a */
    private static final C1638j f7387a = new C1638j();

    private C1638j() {
    }

    /* renamed from: a */
    public static SQLiteEventStore.C1623b m5193a() {
        return f7387a;
    }

    public Object apply(Object obj) {
        return SQLiteEventStore.m5151w((Cursor) obj);
    }
}
