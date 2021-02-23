package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.p005db.SupportSQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class SharedSQLiteStatement {

    /* renamed from: a */
    private final AtomicBoolean f4554a = new AtomicBoolean(false);

    /* renamed from: b */
    private final RoomDatabase f4555b;

    /* renamed from: c */
    private volatile SupportSQLiteStatement f4556c;

    public SharedSQLiteStatement(RoomDatabase roomDatabase) {
        this.f4555b = roomDatabase;
    }

    /* renamed from: a */
    private SupportSQLiteStatement m3608a() {
        return this.f4555b.compileStatement(createQuery());
    }

    /* renamed from: b */
    private SupportSQLiteStatement m3609b(boolean z) {
        if (!z) {
            return m3608a();
        }
        if (this.f4556c == null) {
            this.f4556c = m3608a();
        }
        return this.f4556c;
    }

    public SupportSQLiteStatement acquire() {
        assertNotMainThread();
        return m3609b(this.f4554a.compareAndSet(false, true));
    }

    /* access modifiers changed from: protected */
    public void assertNotMainThread() {
        this.f4555b.assertNotMainThread();
    }

    /* access modifiers changed from: protected */
    public abstract String createQuery();

    public void release(SupportSQLiteStatement supportSQLiteStatement) {
        if (supportSQLiteStatement == this.f4556c) {
            this.f4554a.set(false);
        }
    }
}
