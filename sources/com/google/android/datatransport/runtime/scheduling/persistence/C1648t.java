package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.t */
/* compiled from: SQLiteEventStore */
final /* synthetic */ class C1648t implements SQLiteEventStore.C1623b {

    /* renamed from: a */
    private final String f7399a;

    private C1648t(String str) {
        this.f7399a = str;
    }

    /* renamed from: a */
    public static SQLiteEventStore.C1623b m5205a(String str) {
        return new C1648t(str);
    }

    public Object apply(Object obj) {
        return SQLiteEventStore.m5152x(this.f7399a, (SQLiteDatabase) obj);
    }
}
