package androidx.sqlite.p005db;

import androidx.annotation.Nullable;

/* renamed from: androidx.sqlite.db.SimpleSQLiteQuery */
public final class SimpleSQLiteQuery implements SupportSQLiteQuery {

    /* renamed from: a */
    private final String f4653a;
    @Nullable

    /* renamed from: b */
    private final Object[] f4654b;

    public SimpleSQLiteQuery(String str, @Nullable Object[] objArr) {
        this.f4653a = str;
        this.f4654b = objArr;
    }

    /* renamed from: a */
    private static void m3654a(SupportSQLiteProgram supportSQLiteProgram, int i, Object obj) {
        if (obj == null) {
            supportSQLiteProgram.bindNull(i);
        } else if (obj instanceof byte[]) {
            supportSQLiteProgram.bindBlob(i, (byte[]) obj);
        } else if (obj instanceof Float) {
            supportSQLiteProgram.bindDouble(i, (double) ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            supportSQLiteProgram.bindDouble(i, ((Double) obj).doubleValue());
        } else if (obj instanceof Long) {
            supportSQLiteProgram.bindLong(i, ((Long) obj).longValue());
        } else if (obj instanceof Integer) {
            supportSQLiteProgram.bindLong(i, (long) ((Integer) obj).intValue());
        } else if (obj instanceof Short) {
            supportSQLiteProgram.bindLong(i, (long) ((Short) obj).shortValue());
        } else if (obj instanceof Byte) {
            supportSQLiteProgram.bindLong(i, (long) ((Byte) obj).byteValue());
        } else if (obj instanceof String) {
            supportSQLiteProgram.bindString(i, (String) obj);
        } else if (obj instanceof Boolean) {
            supportSQLiteProgram.bindLong(i, ((Boolean) obj).booleanValue() ? 1 : 0);
        } else {
            throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i + " Supported types: null, byte[], float, double, long, int, short, byte," + " string");
        }
    }

    public static void bind(SupportSQLiteProgram supportSQLiteProgram, Object[] objArr) {
        if (objArr != null) {
            int length = objArr.length;
            int i = 0;
            while (i < length) {
                Object obj = objArr[i];
                i++;
                m3654a(supportSQLiteProgram, i, obj);
            }
        }
    }

    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        bind(supportSQLiteProgram, this.f4654b);
    }

    public int getArgCount() {
        Object[] objArr = this.f4654b;
        if (objArr == null) {
            return 0;
        }
        return objArr.length;
    }

    public String getSql() {
        return this.f4653a;
    }

    public SimpleSQLiteQuery(String str) {
        this(str, (Object[]) null);
    }
}
