package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.f */
/* compiled from: SQLiteEventStore */
final /* synthetic */ class C1634f implements SQLiteEventStore.C1623b {

    /* renamed from: a */
    private static final C1634f f7381a = new C1634f();

    private C1634f() {
    }

    /* renamed from: a */
    public static SQLiteEventStore.C1623b m5189a() {
        return f7381a;
    }

    public Object apply(Object obj) {
        return SQLiteEventStore.m5146r((SQLiteDatabase) obj);
    }
}
