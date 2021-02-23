package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.d */
/* compiled from: SQLiteEventStore */
final /* synthetic */ class C1632d implements SQLiteEventStore.C1623b {

    /* renamed from: a */
    private final long f7377a;

    /* renamed from: b */
    private final TransportContext f7378b;

    private C1632d(long j, TransportContext transportContext) {
        this.f7377a = j;
        this.f7378b = transportContext;
    }

    /* renamed from: a */
    public static SQLiteEventStore.C1623b m5187a(long j, TransportContext transportContext) {
        return new C1632d(j, transportContext);
    }

    public Object apply(Object obj) {
        return SQLiteEventStore.m5153y(this.f7377a, this.f7378b, (SQLiteDatabase) obj);
    }
}
