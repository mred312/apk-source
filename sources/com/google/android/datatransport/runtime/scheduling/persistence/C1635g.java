package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.g */
/* compiled from: SQLiteEventStore */
final /* synthetic */ class C1635g implements SQLiteEventStore.C1623b {

    /* renamed from: a */
    private final long f7382a;

    private C1635g(long j) {
        this.f7382a = j;
    }

    /* renamed from: a */
    public static SQLiteEventStore.C1623b m5190a(long j) {
        return new C1635g(j);
    }

    public Object apply(Object obj) {
        return Integer.valueOf(((SQLiteDatabase) obj).delete("events", "timestamp_ms < ?", new String[]{String.valueOf(this.f7382a)}));
    }
}
