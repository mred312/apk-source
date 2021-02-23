package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.u */
/* compiled from: SQLiteEventStore */
final /* synthetic */ class C1649u implements SQLiteEventStore.C1623b {

    /* renamed from: a */
    private static final C1649u f7400a = new C1649u();

    private C1649u() {
    }

    /* renamed from: a */
    public static SQLiteEventStore.C1623b m5206a() {
        return f7400a;
    }

    public Object apply(Object obj) {
        return SQLiteEventStore.m5142n((Cursor) obj);
    }
}
