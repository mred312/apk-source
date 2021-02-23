package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.Map;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.k */
/* compiled from: SQLiteEventStore */
final /* synthetic */ class C1639k implements SQLiteEventStore.C1623b {

    /* renamed from: a */
    private final Map f7388a;

    private C1639k(Map map) {
        this.f7388a = map;
    }

    /* renamed from: a */
    public static SQLiteEventStore.C1623b m5194a(Map map) {
        return new C1639k(map);
    }

    public Object apply(Object obj) {
        return SQLiteEventStore.m5149u(this.f7388a, (Cursor) obj);
    }
}
