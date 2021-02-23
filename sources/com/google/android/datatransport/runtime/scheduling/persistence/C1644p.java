package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.p */
/* compiled from: SQLiteEventStore */
final /* synthetic */ class C1644p implements SQLiteEventStore.C1623b {

    /* renamed from: a */
    private static final C1644p f7393a = new C1644p();

    private C1644p() {
    }

    /* renamed from: a */
    public static SQLiteEventStore.C1623b m5201a() {
        return f7393a;
    }

    public Object apply(Object obj) {
        return Boolean.valueOf(((Cursor) obj).moveToNext());
    }
}
