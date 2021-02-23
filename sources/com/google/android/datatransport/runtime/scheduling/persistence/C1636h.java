package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.h */
/* compiled from: SQLiteEventStore */
final /* synthetic */ class C1636h implements SQLiteEventStore.C1623b {

    /* renamed from: a */
    private static final C1636h f7383a = new C1636h();

    private C1636h() {
    }

    /* renamed from: a */
    public static SQLiteEventStore.C1623b m5191a() {
        return f7383a;
    }

    public Object apply(Object obj) {
        return SQLiteEventStore.m5138j((SQLiteDatabase) obj);
    }
}
