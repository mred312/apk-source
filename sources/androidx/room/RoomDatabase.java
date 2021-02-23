package androidx.room;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.collection.SparseArrayCompat;
import androidx.core.app.ActivityManagerCompat;
import androidx.room.migration.Migration;
import androidx.room.util.SneakyThrow;
import androidx.sqlite.p005db.SimpleSQLiteQuery;
import androidx.sqlite.p005db.SupportSQLiteDatabase;
import androidx.sqlite.p005db.SupportSQLiteOpenHelper;
import androidx.sqlite.p005db.SupportSQLiteQuery;
import androidx.sqlite.p005db.SupportSQLiteStatement;
import androidx.sqlite.p005db.framework.FrameworkSQLiteOpenHelperFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class RoomDatabase {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int MAX_BIND_PARAMETER_CNT = 999;

    /* renamed from: a */
    private Executor f4515a;

    /* renamed from: b */
    private Executor f4516b;

    /* renamed from: c */
    private SupportSQLiteOpenHelper f4517c;

    /* renamed from: d */
    private final InvalidationTracker f4518d;

    /* renamed from: e */
    private boolean f4519e;

    /* renamed from: f */
    boolean f4520f;

    /* renamed from: g */
    private final ReentrantReadWriteLock f4521g = new ReentrantReadWriteLock();

    /* renamed from: h */
    private final ThreadLocal<Integer> f4522h = new ThreadLocal<>();
    @Deprecated
    @Nullable
    protected List<Callback> mCallbacks;
    @Deprecated
    protected volatile SupportSQLiteDatabase mDatabase;

    public static class Builder<T extends RoomDatabase> {

        /* renamed from: a */
        private final Class<T> f4523a;

        /* renamed from: b */
        private final String f4524b;

        /* renamed from: c */
        private final Context f4525c;

        /* renamed from: d */
        private ArrayList<Callback> f4526d;

        /* renamed from: e */
        private Executor f4527e;

        /* renamed from: f */
        private Executor f4528f;

        /* renamed from: g */
        private SupportSQLiteOpenHelper.Factory f4529g;

        /* renamed from: h */
        private boolean f4530h;

        /* renamed from: i */
        private JournalMode f4531i = JournalMode.AUTOMATIC;

        /* renamed from: j */
        private boolean f4532j;

        /* renamed from: k */
        private boolean f4533k = true;

        /* renamed from: l */
        private boolean f4534l;

        /* renamed from: m */
        private final MigrationContainer f4535m = new MigrationContainer();

        /* renamed from: n */
        private Set<Integer> f4536n;

        /* renamed from: o */
        private Set<Integer> f4537o;

        Builder(@NonNull Context context, @NonNull Class<T> cls, @Nullable String str) {
            this.f4525c = context;
            this.f4523a = cls;
            this.f4524b = str;
        }

        @NonNull
        public Builder<T> addCallback(@NonNull Callback callback) {
            if (this.f4526d == null) {
                this.f4526d = new ArrayList<>();
            }
            this.f4526d.add(callback);
            return this;
        }

        @NonNull
        public Builder<T> addMigrations(@NonNull Migration... migrationArr) {
            if (this.f4537o == null) {
                this.f4537o = new HashSet();
            }
            for (Migration migration : migrationArr) {
                this.f4537o.add(Integer.valueOf(migration.startVersion));
                this.f4537o.add(Integer.valueOf(migration.endVersion));
            }
            this.f4535m.addMigrations(migrationArr);
            return this;
        }

        @NonNull
        public Builder<T> allowMainThreadQueries() {
            this.f4530h = true;
            return this;
        }

        @SuppressLint({"RestrictedApi"})
        @NonNull
        public T build() {
            Executor executor;
            if (this.f4525c == null) {
                throw new IllegalArgumentException("Cannot provide null context for the database.");
            } else if (this.f4523a != null) {
                Executor executor2 = this.f4527e;
                if (executor2 == null && this.f4528f == null) {
                    Executor iOThreadExecutor = ArchTaskExecutor.getIOThreadExecutor();
                    this.f4528f = iOThreadExecutor;
                    this.f4527e = iOThreadExecutor;
                } else if (executor2 != null && this.f4528f == null) {
                    this.f4528f = executor2;
                } else if (executor2 == null && (executor = this.f4528f) != null) {
                    this.f4527e = executor;
                }
                Set<Integer> set = this.f4537o;
                if (!(set == null || this.f4536n == null)) {
                    for (Integer next : set) {
                        if (this.f4536n.contains(next)) {
                            throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + next);
                        }
                    }
                }
                if (this.f4529g == null) {
                    this.f4529g = new FrameworkSQLiteOpenHelperFactory();
                }
                Context context = this.f4525c;
                DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(context, this.f4524b, this.f4529g, this.f4535m, this.f4526d, this.f4530h, this.f4531i.mo7856a(context), this.f4527e, this.f4528f, this.f4532j, this.f4533k, this.f4534l, this.f4536n);
                T t = (RoomDatabase) Room.m3596a(this.f4523a, "_Impl");
                t.init(databaseConfiguration);
                return t;
            } else {
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
        }

        @NonNull
        public Builder<T> enableMultiInstanceInvalidation() {
            this.f4532j = this.f4524b != null;
            return this;
        }

        @NonNull
        public Builder<T> fallbackToDestructiveMigration() {
            this.f4533k = false;
            this.f4534l = true;
            return this;
        }

        @NonNull
        public Builder<T> fallbackToDestructiveMigrationFrom(int... iArr) {
            if (this.f4536n == null) {
                this.f4536n = new HashSet(iArr.length);
            }
            for (int valueOf : iArr) {
                this.f4536n.add(Integer.valueOf(valueOf));
            }
            return this;
        }

        @NonNull
        public Builder<T> fallbackToDestructiveMigrationOnDowngrade() {
            this.f4533k = true;
            this.f4534l = true;
            return this;
        }

        @NonNull
        public Builder<T> openHelperFactory(@Nullable SupportSQLiteOpenHelper.Factory factory) {
            this.f4529g = factory;
            return this;
        }

        @NonNull
        public Builder<T> setJournalMode(@NonNull JournalMode journalMode) {
            this.f4531i = journalMode;
            return this;
        }

        @NonNull
        public Builder<T> setQueryExecutor(@NonNull Executor executor) {
            this.f4527e = executor;
            return this;
        }

        @NonNull
        public Builder<T> setTransactionExecutor(@NonNull Executor executor) {
            this.f4528f = executor;
            return this;
        }
    }

    public static abstract class Callback {
        public void onCreate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public void onOpen(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }
    }

    public enum JournalMode {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        /* access modifiers changed from: package-private */
        @SuppressLint({"NewApi"})
        /* renamed from: a */
        public JournalMode mo7856a(Context context) {
            ActivityManager activityManager;
            if (this != AUTOMATIC) {
                return this;
            }
            if (Build.VERSION.SDK_INT < 16 || (activityManager = (ActivityManager) context.getSystemService("activity")) == null || ActivityManagerCompat.isLowRamDevice(activityManager)) {
                return TRUNCATE;
            }
            return WRITE_AHEAD_LOGGING;
        }
    }

    public static class MigrationContainer {

        /* renamed from: a */
        private SparseArrayCompat<SparseArrayCompat<Migration>> f4539a = new SparseArrayCompat<>();

        /* renamed from: a */
        private void m3600a(Migration migration) {
            int i = migration.startVersion;
            int i2 = migration.endVersion;
            SparseArrayCompat sparseArrayCompat = this.f4539a.get(i);
            if (sparseArrayCompat == null) {
                sparseArrayCompat = new SparseArrayCompat();
                this.f4539a.put(i, sparseArrayCompat);
            }
            Migration migration2 = (Migration) sparseArrayCompat.get(i2);
            if (migration2 != null) {
                Log.w("ROOM", "Overriding migration " + migration2 + " with " + migration);
            }
            sparseArrayCompat.append(i2, migration);
        }

        /* renamed from: b */
        private List<Migration> m3601b(List<Migration> list, boolean z, int i, int i2) {
            boolean z2;
            int i3;
            int i4;
            int i5 = z ? -1 : 1;
            do {
                if (z) {
                    if (i >= i2) {
                        return list;
                    }
                } else if (i <= i2) {
                    return list;
                }
                SparseArrayCompat sparseArrayCompat = this.f4539a.get(i);
                if (sparseArrayCompat != null) {
                    int size = sparseArrayCompat.size();
                    z2 = false;
                    if (z) {
                        i4 = size - 1;
                        i3 = -1;
                    } else {
                        i3 = size;
                        i4 = 0;
                    }
                    while (true) {
                        if (i4 == i3) {
                            break;
                        }
                        int keyAt = sparseArrayCompat.keyAt(i4);
                        if (!z ? !(keyAt < i2 || keyAt >= i) : !(keyAt > i2 || keyAt <= i)) {
                            list.add(sparseArrayCompat.valueAt(i4));
                            i = keyAt;
                            z2 = true;
                            continue;
                            break;
                        }
                        i4 += i5;
                    }
                } else {
                    return null;
                }
            } while (z2);
            return null;
        }

        public void addMigrations(@NonNull Migration... migrationArr) {
            for (Migration a : migrationArr) {
                m3600a(a);
            }
        }

        @Nullable
        public List<Migration> findMigrationPath(int i, int i2) {
            if (i == i2) {
                return Collections.emptyList();
            }
            return m3601b(new ArrayList(), i2 > i, i, i2);
        }
    }

    public RoomDatabase() {
        new ConcurrentHashMap();
        this.f4518d = createInvalidationTracker();
    }

    /* renamed from: b */
    private static boolean m3597b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Lock mo7819a() {
        return this.f4521g.readLock();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void assertNotMainThread() {
        if (!this.f4519e && m3597b()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void assertNotSuspendingTransaction() {
        if (!inTransaction() && this.f4522h.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    @Deprecated
    public void beginTransaction() {
        assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = this.f4517c.getWritableDatabase();
        this.f4518d.mo7795j(writableDatabase);
        writableDatabase.beginTransaction();
    }

    @WorkerThread
    public abstract void clearAllTables();

    public void close() {
        if (isOpen()) {
            ReentrantReadWriteLock.WriteLock writeLock = this.f4521g.writeLock();
            try {
                writeLock.lock();
                this.f4518d.mo7793g();
                this.f4517c.close();
            } finally {
                writeLock.unlock();
            }
        }
    }

    public SupportSQLiteStatement compileStatement(@NonNull String str) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return this.f4517c.getWritableDatabase().compileStatement(str);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract InvalidationTracker createInvalidationTracker();

    /* access modifiers changed from: protected */
    @NonNull
    public abstract SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration);

    @Deprecated
    public void endTransaction() {
        this.f4517c.getWritableDatabase().endTransaction();
        if (!inTransaction()) {
            this.f4518d.refreshVersionsAsync();
        }
    }

    @NonNull
    public InvalidationTracker getInvalidationTracker() {
        return this.f4518d;
    }

    @NonNull
    public SupportSQLiteOpenHelper getOpenHelper() {
        return this.f4517c;
    }

    @NonNull
    public Executor getQueryExecutor() {
        return this.f4515a;
    }

    @NonNull
    public Executor getTransactionExecutor() {
        return this.f4516b;
    }

    public boolean inTransaction() {
        return this.f4517c.getWritableDatabase().inTransaction();
    }

    @CallSuper
    public void init(@NonNull DatabaseConfiguration databaseConfiguration) {
        SupportSQLiteOpenHelper createOpenHelper = createOpenHelper(databaseConfiguration);
        this.f4517c = createOpenHelper;
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 16) {
            if (databaseConfiguration.journalMode == JournalMode.WRITE_AHEAD_LOGGING) {
                z = true;
            }
            createOpenHelper.setWriteAheadLoggingEnabled(z);
        }
        this.mCallbacks = databaseConfiguration.callbacks;
        this.f4515a = databaseConfiguration.queryExecutor;
        this.f4516b = new C0986d(databaseConfiguration.transactionExecutor);
        this.f4519e = databaseConfiguration.allowMainThreadQueries;
        this.f4520f = z;
        if (databaseConfiguration.multiInstanceInvalidation) {
            this.f4518d.mo7792e(databaseConfiguration.context, databaseConfiguration.name);
        }
    }

    /* access modifiers changed from: protected */
    public void internalInitInvalidationTracker(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        this.f4518d.mo7789c(supportSQLiteDatabase);
    }

    public boolean isOpen() {
        SupportSQLiteDatabase supportSQLiteDatabase = this.mDatabase;
        return supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen();
    }

    public Cursor query(String str, @Nullable Object[] objArr) {
        return this.f4517c.getWritableDatabase().query((SupportSQLiteQuery) new SimpleSQLiteQuery(str, objArr));
    }

    public void runInTransaction(@NonNull Runnable runnable) {
        beginTransaction();
        try {
            runnable.run();
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    @Deprecated
    public void setTransactionSuccessful() {
        this.f4517c.getWritableDatabase().setTransactionSuccessful();
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return this.f4517c.getWritableDatabase().query(supportSQLiteQuery);
    }

    public <V> V runInTransaction(@NonNull Callable<V> callable) {
        beginTransaction();
        try {
            V call = callable.call();
            setTransactionSuccessful();
            endTransaction();
            return call;
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            SneakyThrow.reThrow(e2);
            endTransaction();
            return null;
        } catch (Throwable th) {
            endTransaction();
            throw th;
        }
    }
}
