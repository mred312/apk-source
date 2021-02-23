package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.r */
/* compiled from: SQLiteEventStore */
final /* synthetic */ class C1646r implements SQLiteEventStore.C1623b {

    /* renamed from: a */
    private final SQLiteEventStore f7395a;

    /* renamed from: b */
    private final TransportContext f7396b;

    /* renamed from: c */
    private final EventInternal f7397c;

    private C1646r(SQLiteEventStore sQLiteEventStore, TransportContext transportContext, EventInternal eventInternal) {
        this.f7395a = sQLiteEventStore;
        this.f7396b = transportContext;
        this.f7397c = eventInternal;
    }

    /* renamed from: a */
    public static SQLiteEventStore.C1623b m5203a(SQLiteEventStore sQLiteEventStore, TransportContext transportContext, EventInternal eventInternal) {
        return new C1646r(sQLiteEventStore, transportContext, eventInternal);
    }

    public Object apply(Object obj) {
        return SQLiteEventStore.m5150v(this.f7395a, this.f7396b, this.f7397c, (SQLiteDatabase) obj);
    }
}
