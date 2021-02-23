package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.s */
/* compiled from: SQLiteEventStore */
final /* synthetic */ class C1647s implements SQLiteEventStore.C1623b {

    /* renamed from: a */
    private static final C1647s f7398a = new C1647s();

    private C1647s() {
    }

    /* renamed from: a */
    public static SQLiteEventStore.C1623b m5204a() {
        return f7398a;
    }

    public Object apply(Object obj) {
        return SQLiteEventStore.m5143o((Cursor) obj);
    }
}
