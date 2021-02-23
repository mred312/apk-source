package androidx.sqlite.p005db;

import java.util.regex.Pattern;

/* renamed from: androidx.sqlite.db.SupportSQLiteQueryBuilder */
public final class SupportSQLiteQueryBuilder {

    /* renamed from: j */
    private static final Pattern f4658j = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");

    /* renamed from: a */
    private boolean f4659a = false;

    /* renamed from: b */
    private final String f4660b;

    /* renamed from: c */
    private String[] f4661c = null;

    /* renamed from: d */
    private String f4662d;

    /* renamed from: e */
    private Object[] f4663e;

    /* renamed from: f */
    private String f4664f = null;

    /* renamed from: g */
    private String f4665g = null;

    /* renamed from: h */
    private String f4666h = null;

    /* renamed from: i */
    private String f4667i = null;

    private SupportSQLiteQueryBuilder(String str) {
        this.f4660b = str;
    }

    /* renamed from: a */
    private static void m3656a(StringBuilder sb, String str, String str2) {
        if (!m3658c(str2)) {
            sb.append(str);
            sb.append(str2);
        }
    }

    /* renamed from: b */
    private static void m3657b(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(' ');
    }

    public static SupportSQLiteQueryBuilder builder(String str) {
        return new SupportSQLiteQueryBuilder(str);
    }

    /* renamed from: c */
    private static boolean m3658c(String str) {
        return str == null || str.length() == 0;
    }

    public SupportSQLiteQueryBuilder columns(String[] strArr) {
        this.f4661c = strArr;
        return this;
    }

    public SupportSQLiteQuery create() {
        if (!m3658c(this.f4664f) || m3658c(this.f4665g)) {
            StringBuilder sb = new StringBuilder(120);
            sb.append("SELECT ");
            if (this.f4659a) {
                sb.append("DISTINCT ");
            }
            String[] strArr = this.f4661c;
            if (strArr == null || strArr.length == 0) {
                sb.append(" * ");
            } else {
                m3657b(sb, strArr);
            }
            sb.append(" FROM ");
            sb.append(this.f4660b);
            m3656a(sb, " WHERE ", this.f4662d);
            m3656a(sb, " GROUP BY ", this.f4664f);
            m3656a(sb, " HAVING ", this.f4665g);
            m3656a(sb, " ORDER BY ", this.f4666h);
            m3656a(sb, " LIMIT ", this.f4667i);
            return new SimpleSQLiteQuery(sb.toString(), this.f4663e);
        }
        throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
    }

    public SupportSQLiteQueryBuilder distinct() {
        this.f4659a = true;
        return this;
    }

    public SupportSQLiteQueryBuilder groupBy(String str) {
        this.f4664f = str;
        return this;
    }

    public SupportSQLiteQueryBuilder having(String str) {
        this.f4665g = str;
        return this;
    }

    public SupportSQLiteQueryBuilder limit(String str) {
        if (m3658c(str) || f4658j.matcher(str).matches()) {
            this.f4667i = str;
            return this;
        }
        throw new IllegalArgumentException("invalid LIMIT clauses:" + str);
    }

    public SupportSQLiteQueryBuilder orderBy(String str) {
        this.f4666h = str;
        return this;
    }

    public SupportSQLiteQueryBuilder selection(String str, Object[] objArr) {
        this.f4662d = str;
        this.f4663e = objArr;
        return this;
    }
}
