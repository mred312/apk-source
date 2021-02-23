package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.lifecycle.LiveData;
import androidx.sqlite.p005db.SimpleSQLiteQuery;
import androidx.sqlite.p005db.SupportSQLiteDatabase;
import androidx.sqlite.p005db.SupportSQLiteStatement;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

public class InvalidationTracker {

    /* renamed from: m */
    private static final String[] f4483m = {"UPDATE", "DELETE", "INSERT"};
    @VisibleForTesting
    @NonNull

    /* renamed from: a */
    final ArrayMap<String, Integer> f4484a;

    /* renamed from: b */
    final String[] f4485b;
    @NonNull

    /* renamed from: c */
    private Map<String, Set<String>> f4486c;

    /* renamed from: d */
    final RoomDatabase f4487d;

    /* renamed from: e */
    AtomicBoolean f4488e;

    /* renamed from: f */
    private volatile boolean f4489f;

    /* renamed from: g */
    volatile SupportSQLiteStatement f4490g;

    /* renamed from: h */
    private C0964b f4491h;

    /* renamed from: i */
    private final C0973a f4492i;
    @VisibleForTesting
    @SuppressLint({"RestrictedApi"})

    /* renamed from: j */
    final SafeIterableMap<Observer, C0965c> f4493j;

    /* renamed from: k */
    private C0974b f4494k;
    @VisibleForTesting

    /* renamed from: l */
    Runnable f4495l;

    /* renamed from: androidx.room.InvalidationTracker$a */
    class C0963a implements Runnable {
        C0963a() {
        }

        /* JADX INFO: finally extract failed */
        /* renamed from: a */
        private Set<Integer> m3588a() {
            ArraySet arraySet = new ArraySet();
            Cursor query = InvalidationTracker.this.f4487d.query(new SimpleSQLiteQuery("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
            while (query.moveToNext()) {
                try {
                    arraySet.add(Integer.valueOf(query.getInt(0)));
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            }
            query.close();
            if (!arraySet.isEmpty()) {
                InvalidationTracker.this.f4490g.executeUpdateDelete();
            }
            return arraySet;
        }

        public void run() {
            SupportSQLiteDatabase writableDatabase;
            Lock a = InvalidationTracker.this.f4487d.mo7819a();
            Set<Integer> set = null;
            try {
                a.lock();
                if (!InvalidationTracker.this.mo7788b()) {
                    a.unlock();
                } else if (!InvalidationTracker.this.f4488e.compareAndSet(true, false)) {
                    a.unlock();
                } else if (InvalidationTracker.this.f4487d.inTransaction()) {
                    a.unlock();
                } else {
                    RoomDatabase roomDatabase = InvalidationTracker.this.f4487d;
                    if (roomDatabase.f4520f) {
                        writableDatabase = roomDatabase.getOpenHelper().getWritableDatabase();
                        writableDatabase.beginTransaction();
                        set = m3588a();
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } else {
                        set = m3588a();
                    }
                    a.unlock();
                    if (set != null && !set.isEmpty()) {
                        synchronized (InvalidationTracker.this.f4493j) {
                            Iterator<Map.Entry<Observer, C0965c>> it = InvalidationTracker.this.f4493j.iterator();
                            while (it.hasNext()) {
                                ((C0965c) it.next().getValue()).mo7807a(set);
                            }
                        }
                    }
                }
            } catch (SQLiteException | IllegalStateException e) {
                try {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
                } catch (Throwable th) {
                    a.unlock();
                    throw th;
                }
            } catch (Throwable th2) {
                writableDatabase.endTransaction();
                throw th2;
            }
        }
    }

    /* renamed from: androidx.room.InvalidationTracker$b */
    static class C0964b {

        /* renamed from: a */
        final long[] f4498a;

        /* renamed from: b */
        final boolean[] f4499b;

        /* renamed from: c */
        final int[] f4500c;

        /* renamed from: d */
        boolean f4501d;

        /* renamed from: e */
        boolean f4502e;

        C0964b(int i) {
            long[] jArr = new long[i];
            this.f4498a = jArr;
            boolean[] zArr = new boolean[i];
            this.f4499b = zArr;
            this.f4500c = new int[i];
            Arrays.fill(jArr, 0);
            Arrays.fill(zArr, false);
        }

        /* access modifiers changed from: package-private */
        @Nullable
        /* renamed from: a */
        public int[] mo7803a() {
            synchronized (this) {
                if (this.f4501d) {
                    if (!this.f4502e) {
                        int length = this.f4498a.length;
                        int i = 0;
                        while (true) {
                            int i2 = 1;
                            if (i < length) {
                                boolean z = this.f4498a[i] > 0;
                                boolean[] zArr = this.f4499b;
                                if (z != zArr[i]) {
                                    int[] iArr = this.f4500c;
                                    if (!z) {
                                        i2 = 2;
                                    }
                                    iArr[i] = i2;
                                } else {
                                    this.f4500c[i] = 0;
                                }
                                zArr[i] = z;
                                i++;
                            } else {
                                this.f4502e = true;
                                this.f4501d = false;
                                int[] iArr2 = this.f4500c;
                                return iArr2;
                            }
                        }
                    }
                }
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo7804b(int... iArr) {
            boolean z;
            synchronized (this) {
                z = false;
                for (int i : iArr) {
                    long[] jArr = this.f4498a;
                    long j = jArr[i];
                    jArr[i] = 1 + j;
                    if (j == 0) {
                        this.f4501d = true;
                        z = true;
                    }
                }
            }
            return z;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public boolean mo7805c(int... iArr) {
            boolean z;
            synchronized (this) {
                z = false;
                for (int i : iArr) {
                    long[] jArr = this.f4498a;
                    long j = jArr[i];
                    jArr[i] = j - 1;
                    if (j == 1) {
                        this.f4501d = true;
                        z = true;
                    }
                }
            }
            return z;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo7806d() {
            synchronized (this) {
                this.f4502e = false;
            }
        }
    }

    /* renamed from: androidx.room.InvalidationTracker$c */
    static class C0965c {

        /* renamed from: a */
        final int[] f4503a;

        /* renamed from: b */
        private final String[] f4504b;

        /* renamed from: c */
        final Observer f4505c;

        /* renamed from: d */
        private final Set<String> f4506d;

        C0965c(Observer observer, int[] iArr, String[] strArr) {
            this.f4505c = observer;
            this.f4503a = iArr;
            this.f4504b = strArr;
            if (iArr.length == 1) {
                ArraySet arraySet = new ArraySet();
                arraySet.add(strArr[0]);
                this.f4506d = Collections.unmodifiableSet(arraySet);
                return;
            }
            this.f4506d = null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo7807a(Set<Integer> set) {
            int length = this.f4503a.length;
            Set set2 = null;
            for (int i = 0; i < length; i++) {
                if (set.contains(Integer.valueOf(this.f4503a[i]))) {
                    if (length == 1) {
                        set2 = this.f4506d;
                    } else {
                        if (set2 == null) {
                            set2 = new ArraySet(length);
                        }
                        set2.add(this.f4504b[i]);
                    }
                }
            }
            if (set2 != null) {
                this.f4505c.onInvalidated(set2);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo7808b(String[] strArr) {
            Set<String> set = null;
            if (this.f4504b.length == 1) {
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (strArr[i].equalsIgnoreCase(this.f4504b[0])) {
                        set = this.f4506d;
                        break;
                    } else {
                        i++;
                    }
                }
            } else {
                ArraySet arraySet = new ArraySet();
                for (String str : strArr) {
                    String[] strArr2 = this.f4504b;
                    int length2 = strArr2.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length2) {
                            break;
                        }
                        String str2 = strArr2[i2];
                        if (str2.equalsIgnoreCase(str)) {
                            arraySet.add(str2);
                            break;
                        }
                        i2++;
                    }
                }
                if (arraySet.size() > 0) {
                    set = arraySet;
                }
            }
            if (set != null) {
                this.f4505c.onInvalidated(set);
            }
        }
    }

    /* renamed from: androidx.room.InvalidationTracker$d */
    static class C0966d extends Observer {

        /* renamed from: b */
        final InvalidationTracker f4507b;

        /* renamed from: c */
        final WeakReference<Observer> f4508c;

        C0966d(InvalidationTracker invalidationTracker, Observer observer) {
            super(observer.f4496a);
            this.f4507b = invalidationTracker;
            this.f4508c = new WeakReference<>(observer);
        }

        public void onInvalidated(@NonNull Set<String> set) {
            Observer observer = (Observer) this.f4508c.get();
            if (observer == null) {
                this.f4507b.removeObserver(this);
            } else {
                observer.onInvalidated(set);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(RoomDatabase roomDatabase, String... strArr) {
        this(roomDatabase, new HashMap(), Collections.emptyMap(), strArr);
    }

    /* renamed from: a */
    private static void m3576a(StringBuilder sb, String str, String str2) {
        sb.append("`");
        sb.append("room_table_modification_trigger_");
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        sb.append("`");
    }

    /* renamed from: d */
    private String[] m3577d(String[] strArr) {
        ArraySet arraySet = new ArraySet();
        for (String str : strArr) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (this.f4486c.containsKey(lowerCase)) {
                arraySet.addAll(this.f4486c.get(lowerCase));
            } else {
                arraySet.add(str);
            }
        }
        return (String[]) arraySet.toArray(new String[arraySet.size()]);
    }

    /* renamed from: f */
    private void m3578f(SupportSQLiteDatabase supportSQLiteDatabase, int i) {
        supportSQLiteDatabase.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i + ", 0)");
        String str = this.f4485b[i];
        StringBuilder sb = new StringBuilder();
        for (String str2 : f4483m) {
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            m3576a(sb, str, str2);
            sb.append(" AFTER ");
            sb.append(str2);
            sb.append(" ON `");
            sb.append(str);
            sb.append("` BEGIN UPDATE ");
            sb.append("room_table_modification_log");
            sb.append(" SET ");
            sb.append("invalidated");
            sb.append(" = 1");
            sb.append(" WHERE ");
            sb.append("table_id");
            sb.append(" = ");
            sb.append(i);
            sb.append(" AND ");
            sb.append("invalidated");
            sb.append(" = 0");
            sb.append("; END");
            supportSQLiteDatabase.execSQL(sb.toString());
        }
    }

    /* renamed from: h */
    private void m3579h(SupportSQLiteDatabase supportSQLiteDatabase, int i) {
        String str = this.f4485b[i];
        StringBuilder sb = new StringBuilder();
        for (String a : f4483m) {
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            m3576a(sb, str, a);
            supportSQLiteDatabase.execSQL(sb.toString());
        }
    }

    /* renamed from: k */
    private String[] m3580k(String[] strArr) {
        String[] d = m3577d(strArr);
        int length = d.length;
        int i = 0;
        while (i < length) {
            String str = d[i];
            if (this.f4484a.containsKey(str.toLowerCase(Locale.US))) {
                i++;
            } else {
                throw new IllegalArgumentException("There is no table with name " + str);
            }
        }
        return d;
    }

    @WorkerThread
    @SuppressLint({"RestrictedApi"})
    public void addObserver(@NonNull Observer observer) {
        C0965c putIfAbsent;
        String[] d = m3577d(observer.f4496a);
        int[] iArr = new int[d.length];
        int length = d.length;
        int i = 0;
        while (i < length) {
            Integer num = this.f4484a.get(d[i].toLowerCase(Locale.US));
            if (num != null) {
                iArr[i] = num.intValue();
                i++;
            } else {
                throw new IllegalArgumentException("There is no table with name " + d[i]);
            }
        }
        C0965c cVar = new C0965c(observer, iArr, d);
        synchronized (this.f4493j) {
            putIfAbsent = this.f4493j.putIfAbsent(observer, cVar);
        }
        if (putIfAbsent == null && this.f4491h.mo7804b(iArr)) {
            mo7794i();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addWeakObserver(Observer observer) {
        addObserver(new C0966d(this, observer));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo7788b() {
        if (!this.f4487d.isOpen()) {
            return false;
        }
        if (!this.f4489f) {
            this.f4487d.getOpenHelper().getWritableDatabase();
        }
        if (this.f4489f) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo7789c(SupportSQLiteDatabase supportSQLiteDatabase) {
        synchronized (this) {
            if (this.f4489f) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            supportSQLiteDatabase.execSQL("PRAGMA temp_store = MEMORY;");
            supportSQLiteDatabase.execSQL("PRAGMA recursive_triggers='ON';");
            supportSQLiteDatabase.execSQL("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            mo7795j(supportSQLiteDatabase);
            this.f4490g = supportSQLiteDatabase.compileStatement("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
            this.f4489f = true;
        }
    }

    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> LiveData<T> createLiveData(String[] strArr, Callable<T> callable) {
        return createLiveData(strArr, false, callable);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo7792e(Context context, String str) {
        this.f4494k = new C0974b(context, str, this, this.f4487d.getQueryExecutor());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo7793g() {
        C0974b bVar = this.f4494k;
        if (bVar != null) {
            bVar.mo7893a();
            this.f4494k = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo7794i() {
        if (this.f4487d.isOpen()) {
            mo7795j(this.f4487d.getOpenHelper().getWritableDatabase());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo7795j(SupportSQLiteDatabase supportSQLiteDatabase) {
        if (!supportSQLiteDatabase.inTransaction()) {
            while (true) {
                try {
                    Lock a = this.f4487d.mo7819a();
                    a.lock();
                    try {
                        int[] a2 = this.f4491h.mo7803a();
                        if (a2 == null) {
                            a.unlock();
                            return;
                        }
                        int length = a2.length;
                        supportSQLiteDatabase.beginTransaction();
                        for (int i = 0; i < length; i++) {
                            int i2 = a2[i];
                            if (i2 == 1) {
                                m3578f(supportSQLiteDatabase, i);
                            } else if (i2 == 2) {
                                m3579h(supportSQLiteDatabase, i);
                            }
                        }
                        supportSQLiteDatabase.setTransactionSuccessful();
                        supportSQLiteDatabase.endTransaction();
                        this.f4491h.mo7806d();
                        a.unlock();
                    } catch (Throwable th) {
                        a.unlock();
                        throw th;
                    }
                } catch (SQLiteException | IllegalStateException e) {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
                    return;
                }
            }
        }
    }

    @VisibleForTesting(otherwise = 3)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void notifyObserversByTableNames(String... strArr) {
        synchronized (this.f4493j) {
            Iterator<Map.Entry<Observer, C0965c>> it = this.f4493j.iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                if (!((Observer) next.getKey()).mo7800a()) {
                    ((C0965c) next.getValue()).mo7808b(strArr);
                }
            }
        }
    }

    public void refreshVersionsAsync() {
        if (this.f4488e.compareAndSet(false, true)) {
            this.f4487d.getQueryExecutor().execute(this.f4495l);
        }
    }

    @WorkerThread
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void refreshVersionsSync() {
        mo7794i();
        this.f4495l.run();
    }

    @WorkerThread
    @SuppressLint({"RestrictedApi"})
    public void removeObserver(@NonNull Observer observer) {
        C0965c remove;
        synchronized (this.f4493j) {
            remove = this.f4493j.remove(observer);
        }
        if (remove != null && this.f4491h.mo7805c(remove.f4503a)) {
            mo7794i();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(RoomDatabase roomDatabase, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        this.f4488e = new AtomicBoolean(false);
        this.f4489f = false;
        this.f4493j = new SafeIterableMap<>();
        this.f4495l = new C0963a();
        this.f4487d = roomDatabase;
        this.f4491h = new C0964b(strArr.length);
        this.f4484a = new ArrayMap<>();
        this.f4486c = map2;
        this.f4492i = new C0973a(roomDatabase);
        int length = strArr.length;
        this.f4485b = new String[length];
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            Locale locale = Locale.US;
            String lowerCase = str.toLowerCase(locale);
            this.f4484a.put(lowerCase, Integer.valueOf(i));
            String str2 = map.get(strArr[i]);
            if (str2 != null) {
                this.f4485b[i] = str2.toLowerCase(locale);
            } else {
                this.f4485b[i] = lowerCase;
            }
        }
        for (Map.Entry next : map.entrySet()) {
            Locale locale2 = Locale.US;
            String lowerCase2 = ((String) next.getValue()).toLowerCase(locale2);
            if (this.f4484a.containsKey(lowerCase2)) {
                String lowerCase3 = ((String) next.getKey()).toLowerCase(locale2);
                ArrayMap<String, Integer> arrayMap = this.f4484a;
                arrayMap.put(lowerCase3, arrayMap.get(lowerCase2));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> LiveData<T> createLiveData(String[] strArr, boolean z, Callable<T> callable) {
        return this.f4492i.mo7890a(m3580k(strArr), z, callable);
    }

    public static abstract class Observer {

        /* renamed from: a */
        final String[] f4496a;

        protected Observer(@NonNull String str, String... strArr) {
            String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length + 1);
            this.f4496a = strArr2;
            strArr2[strArr.length] = str;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo7800a() {
            return false;
        }

        public abstract void onInvalidated(@NonNull Set<String> set);

        public Observer(@NonNull String[] strArr) {
            this.f4496a = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
    }
}
