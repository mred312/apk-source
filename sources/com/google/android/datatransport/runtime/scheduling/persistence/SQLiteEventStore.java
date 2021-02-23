package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.Monotonic;
import com.google.android.datatransport.runtime.time.WallTime;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@WorkerThread
public class SQLiteEventStore implements EventStore, SynchronizationGuard {

    /* renamed from: e */
    private static final Encoding f7341e = Encoding.m5015of("proto");

    /* renamed from: a */
    private final SchemaManager f7342a;

    /* renamed from: b */
    private final Clock f7343b;

    /* renamed from: c */
    private final Clock f7344c;

    /* renamed from: d */
    private final C1630c f7345d;

    /* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$b */
    interface C1623b<T, U> {
        U apply(T t);
    }

    /* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$c */
    private static class C1624c {

        /* renamed from: a */
        final String f7346a;

        /* renamed from: b */
        final String f7347b;

        private C1624c(String str, String str2) {
            this.f7346a = str;
            this.f7347b = str2;
        }
    }

    /* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$d */
    interface C1625d<T> {
        /* renamed from: a */
        T mo11513a();
    }

    @Inject
    SQLiteEventStore(@WallTime Clock clock, @Monotonic Clock clock2, C1630c cVar, SchemaManager schemaManager) {
        this.f7342a = schemaManager;
        this.f7343b = clock;
        this.f7344c = clock2;
        this.f7345d = cVar;
    }

    /* renamed from: A */
    private Map<Long, Set<C1624c>> m5123A(SQLiteDatabase sQLiteDatabase, List<PersistedEvent> list) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).getId());
            if (i < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        m5129G(sQLiteDatabase2.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), (String[]) null, (String) null, (String) null, (String) null), C1639k.m5194a(hashMap));
        return hashMap;
    }

    /* renamed from: B */
    private static byte[] m5124B(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    /* renamed from: C */
    private byte[] m5125C(long j) {
        return (byte[]) m5129G(mo11508c().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j)}, (String) null, (String) null, "sequence_num"), C1638j.m5193a());
    }

    /* renamed from: D */
    private <T> T m5126D(C1625d<T> dVar, C1623b<Throwable, T> bVar) {
        long time = this.f7344c.getTime();
        while (true) {
            try {
                return dVar.mo11513a();
            } catch (SQLiteDatabaseLockedException e) {
                if (this.f7344c.getTime() >= ((long) this.f7345d.mo11520b()) + time) {
                    return bVar.apply(e);
                }
                SystemClock.sleep(50);
            }
        }
    }

    /* renamed from: E */
    private static Encoding m5127E(@Nullable String str) {
        if (str == null) {
            return f7341e;
        }
        return Encoding.m5015of(str);
    }

    /* renamed from: F */
    private static String m5128F(Iterable<PersistedEvent> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<PersistedEvent> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getId());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    /* renamed from: G */
    private static <T> T m5129G(Cursor cursor, C1623b<Cursor, T> bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    /* renamed from: a */
    private void m5130a(SQLiteDatabase sQLiteDatabase) {
        m5126D(C1640l.m5195b(sQLiteDatabase), C1641m.m5197a());
    }

    /* renamed from: b */
    private long m5131b(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        Long e = m5133e(sQLiteDatabase, transportContext);
        if (e != null) {
            return e.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", transportContext.getBackendName());
        contentValues.put("priority", Integer.valueOf(PriorityMapping.toInt(transportContext.getPriority())));
        contentValues.put("next_request_ms", 0);
        if (transportContext.getExtras() != null) {
            contentValues.put("extras", Base64.encodeToString(transportContext.getExtras(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", (String) null, contentValues);
    }

    /* renamed from: d */
    private long m5132d() {
        return mo11508c().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    @Nullable
    /* renamed from: e */
    private Long m5133e(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{transportContext.getBackendName(), String.valueOf(PriorityMapping.toInt(transportContext.getPriority()))}));
        if (transportContext.getExtras() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(transportContext.getExtras(), 0));
        }
        return (Long) m5129G(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), (String) null, (String) null, (String) null), C1647s.m5204a());
    }

    /* renamed from: f */
    private <T> T m5134f(C1623b<SQLiteDatabase, T> bVar) {
        SQLiteDatabase c = mo11508c();
        c.beginTransaction();
        try {
            T apply = bVar.apply(c);
            c.setTransactionSuccessful();
            return apply;
        } finally {
            c.endTransaction();
        }
    }

    /* renamed from: g */
    private boolean m5135g() {
        return m5132d() * getPageSize() >= this.f7345d.mo11525f();
    }

    private long getPageSize() {
        return mo11508c().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    /* renamed from: h */
    private List<PersistedEvent> m5136h(List<PersistedEvent> list, Map<Long, Set<C1624c>> map) {
        ListIterator<PersistedEvent> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            PersistedEvent next = listIterator.next();
            if (map.containsKey(Long.valueOf(next.getId()))) {
                EventInternal.Builder builder = next.getEvent().toBuilder();
                for (C1624c cVar : map.get(Long.valueOf(next.getId()))) {
                    builder.addMetadata(cVar.f7346a, cVar.f7347b);
                }
                listIterator.set(PersistedEvent.create(next.getId(), next.getTransportContext(), builder.build()));
            }
        }
        return list;
    }

    /* renamed from: j */
    static /* synthetic */ Object m5138j(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.delete("events", (String) null, new String[0]);
        sQLiteDatabase.delete("transport_contexts", (String) null, new String[0]);
        return null;
    }

    /* renamed from: l */
    static /* synthetic */ Object m5140l(Throwable th) {
        throw new SynchronizationException("Timed out while trying to acquire the lock.", th);
    }

    /* renamed from: m */
    static /* synthetic */ SQLiteDatabase m5141m(Throwable th) {
        throw new SynchronizationException("Timed out while trying to open db.", th);
    }

    /* renamed from: n */
    static /* synthetic */ Long m5142n(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    /* renamed from: o */
    static /* synthetic */ Long m5143o(Cursor cursor) {
        if (!cursor.moveToNext()) {
            return null;
        }
        return Long.valueOf(cursor.getLong(0));
    }

    /* renamed from: p */
    static /* synthetic */ Boolean m5144p(SQLiteEventStore sQLiteEventStore, TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        Long e = sQLiteEventStore.m5133e(sQLiteDatabase, transportContext);
        if (e == null) {
            return Boolean.FALSE;
        }
        return (Boolean) m5129G(sQLiteEventStore.mo11508c().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{e.toString()}), C1644p.m5201a());
    }

    /* renamed from: q */
    static /* synthetic */ List m5145q(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(TransportContext.builder().setBackendName(cursor.getString(1)).setPriority(PriorityMapping.valueOf(cursor.getInt(2))).setExtras(m5124B(cursor.getString(3))).build());
        }
        return arrayList;
    }

    /* renamed from: r */
    static /* synthetic */ List m5146r(SQLiteDatabase sQLiteDatabase) {
        return (List) m5129G(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), C1643o.m5200a());
    }

    /* renamed from: s */
    static /* synthetic */ List m5147s(SQLiteEventStore sQLiteEventStore, TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        List<PersistedEvent> z = sQLiteEventStore.m5154z(sQLiteDatabase, transportContext);
        sQLiteEventStore.m5136h(z, sQLiteEventStore.m5123A(sQLiteDatabase, z));
        return z;
    }

    /* renamed from: t */
    static /* synthetic */ Object m5148t(SQLiteEventStore sQLiteEventStore, List list, TransportContext transportContext, Cursor cursor) {
        while (cursor.moveToNext()) {
            boolean z = false;
            long j = cursor.getLong(0);
            if (cursor.getInt(7) != 0) {
                z = true;
            }
            EventInternal.Builder uptimeMillis = EventInternal.builder().setTransportName(cursor.getString(1)).setEventMillis(cursor.getLong(2)).setUptimeMillis(cursor.getLong(3));
            if (z) {
                uptimeMillis.setEncodedPayload(new EncodedPayload(m5127E(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                uptimeMillis.setEncodedPayload(new EncodedPayload(m5127E(cursor.getString(4)), sQLiteEventStore.m5125C(j)));
            }
            if (!cursor.isNull(6)) {
                uptimeMillis.setCode(Integer.valueOf(cursor.getInt(6)));
            }
            list.add(PersistedEvent.create(j, transportContext, uptimeMillis.build()));
        }
        return null;
    }

    /* renamed from: u */
    static /* synthetic */ Object m5149u(Map map, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j = cursor.getLong(0);
            Set set = (Set) map.get(Long.valueOf(j));
            if (set == null) {
                set = new HashSet();
                map.put(Long.valueOf(j), set);
            }
            set.add(new C1624c(cursor.getString(1), cursor.getString(2)));
        }
        return null;
    }

    /* renamed from: v */
    static /* synthetic */ Long m5150v(SQLiteEventStore sQLiteEventStore, TransportContext transportContext, EventInternal eventInternal, SQLiteDatabase sQLiteDatabase) {
        if (sQLiteEventStore.m5135g()) {
            return -1L;
        }
        long b = sQLiteEventStore.m5131b(sQLiteDatabase, transportContext);
        int e = sQLiteEventStore.f7345d.mo11523e();
        byte[] bytes = eventInternal.getEncodedPayload().getBytes();
        boolean z = bytes.length <= e;
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(b));
        contentValues.put("transport_name", eventInternal.getTransportName());
        contentValues.put("timestamp_ms", Long.valueOf(eventInternal.getEventMillis()));
        contentValues.put("uptime_ms", Long.valueOf(eventInternal.getUptimeMillis()));
        contentValues.put("payload_encoding", eventInternal.getEncodedPayload().getEncoding().getName());
        contentValues.put("code", eventInternal.getCode());
        contentValues.put("num_attempts", 0);
        contentValues.put("inline", Boolean.valueOf(z));
        contentValues.put("payload", z ? bytes : new byte[0]);
        long insert = sQLiteDatabase.insert("events", (String) null, contentValues);
        if (!z) {
            double length = (double) bytes.length;
            double d = (double) e;
            Double.isNaN(length);
            Double.isNaN(d);
            int ceil = (int) Math.ceil(length / d);
            for (int i = 1; i <= ceil; i++) {
                byte[] copyOfRange = Arrays.copyOfRange(bytes, (i - 1) * e, Math.min(i * e, bytes.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(insert));
                contentValues2.put("sequence_num", Integer.valueOf(i));
                contentValues2.put("bytes", copyOfRange);
                sQLiteDatabase.insert("event_payloads", (String) null, contentValues2);
            }
        }
        for (Map.Entry next : eventInternal.getMetadata().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(insert));
            contentValues3.put("name", (String) next.getKey());
            contentValues3.put("value", (String) next.getValue());
            sQLiteDatabase.insert("event_metadata", (String) null, contentValues3);
        }
        return Long.valueOf(insert);
    }

    /* renamed from: w */
    static /* synthetic */ byte[] m5151w(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            i += blob.length;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            byte[] bArr2 = (byte[]) arrayList.get(i3);
            System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
            i2 += bArr2.length;
        }
        return bArr;
    }

    /* renamed from: x */
    static /* synthetic */ Object m5152x(String str, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    /* renamed from: y */
    static /* synthetic */ Object m5153y(long j, TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{transportContext.getBackendName(), String.valueOf(PriorityMapping.toInt(transportContext.getPriority()))}) < 1) {
            contentValues.put("backend_name", transportContext.getBackendName());
            contentValues.put("priority", Integer.valueOf(PriorityMapping.toInt(transportContext.getPriority())));
            sQLiteDatabase.insert("transport_contexts", (String) null, contentValues);
        }
        return null;
    }

    /* renamed from: z */
    private List<PersistedEvent> m5154z(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        ArrayList arrayList = new ArrayList();
        Long e = m5133e(sQLiteDatabase, transportContext);
        if (e == null) {
            return arrayList;
        }
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        m5129G(sQLiteDatabase2.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{e.toString()}, (String) null, (String) null, (String) null, String.valueOf(this.f7345d.mo11522d())), C1637i.m5192a(this, arrayList, transportContext));
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: c */
    public SQLiteDatabase mo11508c() {
        SchemaManager schemaManager = this.f7342a;
        schemaManager.getClass();
        return (SQLiteDatabase) m5126D(C1642n.m5198b(schemaManager), C1645q.m5202a());
    }

    public int cleanUp() {
        return ((Integer) m5134f(C1635g.m5190a(this.f7343b.getTime() - this.f7345d.mo11521c()))).intValue();
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public void clearDb() {
        m5134f(C1636h.m5191a());
    }

    public void close() {
        this.f7342a.close();
    }

    public long getNextCallTime(TransportContext transportContext) {
        return ((Long) m5129G(mo11508c().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{transportContext.getBackendName(), String.valueOf(PriorityMapping.toInt(transportContext.getPriority()))}), C1649u.m5206a())).longValue();
    }

    public boolean hasPendingEventsFor(TransportContext transportContext) {
        return ((Boolean) m5134f(C1650v.m5207a(this, transportContext))).booleanValue();
    }

    public Iterable<TransportContext> loadActiveContexts() {
        return (Iterable) m5134f(C1634f.m5189a());
    }

    public Iterable<PersistedEvent> loadBatch(TransportContext transportContext) {
        return (Iterable) m5134f(C1633e.m5188a(this, transportContext));
    }

    @Nullable
    public PersistedEvent persist(TransportContext transportContext, EventInternal eventInternal) {
        Logging.m5074d("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", transportContext.getPriority(), eventInternal.getTransportName(), transportContext.getBackendName());
        long longValue = ((Long) m5134f(C1646r.m5203a(this, transportContext, eventInternal))).longValue();
        if (longValue < 1) {
            return null;
        }
        return PersistedEvent.create(longValue, transportContext, eventInternal);
    }

    public void recordFailure(Iterable<PersistedEvent> iterable) {
        if (iterable.iterator().hasNext()) {
            m5134f(C1648t.m5205a("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + m5128F(iterable)));
        }
    }

    public void recordNextCallTime(TransportContext transportContext, long j) {
        m5134f(C1632d.m5187a(j, transportContext));
    }

    public void recordSuccess(Iterable<PersistedEvent> iterable) {
        if (iterable.iterator().hasNext()) {
            mo11508c().compileStatement("DELETE FROM events WHERE _id in " + m5128F(iterable)).execute();
        }
    }

    public <T> T runCriticalSection(SynchronizationGuard.CriticalSection<T> criticalSection) {
        SQLiteDatabase c = mo11508c();
        m5130a(c);
        try {
            T execute = criticalSection.execute();
            c.setTransactionSuccessful();
            return execute;
        } finally {
            c.endTransaction();
        }
    }
}
