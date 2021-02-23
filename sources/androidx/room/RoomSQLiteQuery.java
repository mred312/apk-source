package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.p005db.SupportSQLiteProgram;
import androidx.sqlite.p005db.SupportSQLiteQuery;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {
    @VisibleForTesting

    /* renamed from: i */
    static final TreeMap<Integer, RoomSQLiteQuery> f4544i = new TreeMap<>();

    /* renamed from: a */
    private volatile String f4545a;
    @VisibleForTesting

    /* renamed from: b */
    final long[] f4546b;
    @VisibleForTesting

    /* renamed from: c */
    final double[] f4547c;
    @VisibleForTesting

    /* renamed from: d */
    final String[] f4548d;
    @VisibleForTesting

    /* renamed from: e */
    final byte[][] f4549e;

    /* renamed from: f */
    private final int[] f4550f;
    @VisibleForTesting

    /* renamed from: g */
    final int f4551g;
    @VisibleForTesting

    /* renamed from: h */
    int f4552h;

    /* renamed from: androidx.room.RoomSQLiteQuery$a */
    static class C0972a implements SupportSQLiteProgram {

        /* renamed from: a */
        final /* synthetic */ RoomSQLiteQuery f4553a;

        C0972a(RoomSQLiteQuery roomSQLiteQuery) {
            this.f4553a = roomSQLiteQuery;
        }

        public void bindBlob(int i, byte[] bArr) {
            this.f4553a.bindBlob(i, bArr);
        }

        public void bindDouble(int i, double d) {
            this.f4553a.bindDouble(i, d);
        }

        public void bindLong(int i, long j) {
            this.f4553a.bindLong(i, j);
        }

        public void bindNull(int i) {
            this.f4553a.bindNull(i);
        }

        public void bindString(int i, String str) {
            this.f4553a.bindString(i, str);
        }

        public void clearBindings() {
            this.f4553a.clearBindings();
        }

        public void close() {
        }
    }

    private RoomSQLiteQuery(int i) {
        this.f4551g = i;
        int i2 = i + 1;
        this.f4550f = new int[i2];
        this.f4546b = new long[i2];
        this.f4547c = new double[i2];
        this.f4548d = new String[i2];
        this.f4549e = new byte[i2][];
    }

    public static RoomSQLiteQuery acquire(String str, int i) {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = f4544i;
        synchronized (treeMap) {
            Map.Entry<Integer, RoomSQLiteQuery> ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i));
            if (ceilingEntry != null) {
                treeMap.remove(ceilingEntry.getKey());
                RoomSQLiteQuery value = ceilingEntry.getValue();
                value.mo7871a(str, i);
                return value;
            }
            RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(i);
            roomSQLiteQuery.mo7871a(str, i);
            return roomSQLiteQuery;
        }
    }

    /* renamed from: b */
    private static void m3606b() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = f4544i;
        if (treeMap.size() > 15) {
            int size = treeMap.size() - 10;
            Iterator<Integer> it = treeMap.descendingKeySet().iterator();
            while (true) {
                int i = size - 1;
                if (size > 0) {
                    it.next();
                    it.remove();
                    size = i;
                } else {
                    return;
                }
            }
        }
    }

    public static RoomSQLiteQuery copyFrom(SupportSQLiteQuery supportSQLiteQuery) {
        RoomSQLiteQuery acquire = acquire(supportSQLiteQuery.getSql(), supportSQLiteQuery.getArgCount());
        supportSQLiteQuery.bindTo(new C0972a(acquire));
        return acquire;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7871a(String str, int i) {
        this.f4545a = str;
        this.f4552h = i;
    }

    public void bindBlob(int i, byte[] bArr) {
        this.f4550f[i] = 5;
        this.f4549e[i] = bArr;
    }

    public void bindDouble(int i, double d) {
        this.f4550f[i] = 3;
        this.f4547c[i] = d;
    }

    public void bindLong(int i, long j) {
        this.f4550f[i] = 2;
        this.f4546b[i] = j;
    }

    public void bindNull(int i) {
        this.f4550f[i] = 1;
    }

    public void bindString(int i, String str) {
        this.f4550f[i] = 4;
        this.f4548d[i] = str;
    }

    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        for (int i = 1; i <= this.f4552h; i++) {
            int i2 = this.f4550f[i];
            if (i2 == 1) {
                supportSQLiteProgram.bindNull(i);
            } else if (i2 == 2) {
                supportSQLiteProgram.bindLong(i, this.f4546b[i]);
            } else if (i2 == 3) {
                supportSQLiteProgram.bindDouble(i, this.f4547c[i]);
            } else if (i2 == 4) {
                supportSQLiteProgram.bindString(i, this.f4548d[i]);
            } else if (i2 == 5) {
                supportSQLiteProgram.bindBlob(i, this.f4549e[i]);
            }
        }
    }

    public void clearBindings() {
        Arrays.fill(this.f4550f, 1);
        Arrays.fill(this.f4548d, (Object) null);
        Arrays.fill(this.f4549e, (Object) null);
        this.f4545a = null;
    }

    public void close() {
    }

    public void copyArgumentsFrom(RoomSQLiteQuery roomSQLiteQuery) {
        int argCount = roomSQLiteQuery.getArgCount() + 1;
        System.arraycopy(roomSQLiteQuery.f4550f, 0, this.f4550f, 0, argCount);
        System.arraycopy(roomSQLiteQuery.f4546b, 0, this.f4546b, 0, argCount);
        System.arraycopy(roomSQLiteQuery.f4548d, 0, this.f4548d, 0, argCount);
        System.arraycopy(roomSQLiteQuery.f4549e, 0, this.f4549e, 0, argCount);
        System.arraycopy(roomSQLiteQuery.f4547c, 0, this.f4547c, 0, argCount);
    }

    public int getArgCount() {
        return this.f4552h;
    }

    public String getSql() {
        return this.f4545a;
    }

    public void release() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = f4544i;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f4551g), this);
            m3606b();
        }
    }
}
