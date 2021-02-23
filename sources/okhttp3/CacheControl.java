package okhttp3;

import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class CacheControl {
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();

    /* renamed from: a */
    private final boolean f19767a;

    /* renamed from: b */
    private final boolean f19768b;

    /* renamed from: c */
    private final int f19769c;

    /* renamed from: d */
    private final int f19770d;

    /* renamed from: e */
    private final boolean f19771e;

    /* renamed from: f */
    private final boolean f19772f;

    /* renamed from: g */
    private final boolean f19773g;

    /* renamed from: h */
    private final int f19774h;

    /* renamed from: i */
    private final int f19775i;

    /* renamed from: j */
    private final boolean f19776j;

    /* renamed from: k */
    private final boolean f19777k;

    /* renamed from: l */
    private final boolean f19778l;
    @Nullable

    /* renamed from: m */
    String f19779m;

    public static final class Builder {

        /* renamed from: a */
        boolean f19780a;

        /* renamed from: b */
        boolean f19781b;

        /* renamed from: c */
        int f19782c = -1;

        /* renamed from: d */
        int f19783d = -1;

        /* renamed from: e */
        int f19784e = -1;

        /* renamed from: f */
        boolean f19785f;

        /* renamed from: g */
        boolean f19786g;

        /* renamed from: h */
        boolean f19787h;

        public CacheControl build() {
            return new CacheControl(this);
        }

        public Builder immutable() {
            this.f19787h = true;
            return this;
        }

        public Builder maxAge(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds((long) i);
                this.f19782c = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxAge < 0: " + i);
        }

        public Builder maxStale(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds((long) i);
                this.f19783d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i);
        }

        public Builder minFresh(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds((long) i);
                this.f19784e = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("minFresh < 0: " + i);
        }

        public Builder noCache() {
            this.f19780a = true;
            return this;
        }

        public Builder noStore() {
            this.f19781b = true;
            return this;
        }

        public Builder noTransform() {
            this.f19786g = true;
            return this;
        }

        public Builder onlyIfCached() {
            this.f19785f = true;
            return this;
        }
    }

    private CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, @Nullable String str) {
        this.f19767a = z;
        this.f19768b = z2;
        this.f19769c = i;
        this.f19770d = i2;
        this.f19771e = z3;
        this.f19772f = z4;
        this.f19773g = z5;
        this.f19774h = i3;
        this.f19775i = i4;
        this.f19776j = z6;
        this.f19777k = z7;
        this.f19778l = z8;
        this.f19779m = str;
    }

    /* renamed from: a */
    private String m11907a() {
        StringBuilder sb = new StringBuilder();
        if (this.f19767a) {
            sb.append("no-cache, ");
        }
        if (this.f19768b) {
            sb.append("no-store, ");
        }
        if (this.f19769c != -1) {
            sb.append("max-age=");
            sb.append(this.f19769c);
            sb.append(", ");
        }
        if (this.f19770d != -1) {
            sb.append("s-maxage=");
            sb.append(this.f19770d);
            sb.append(", ");
        }
        if (this.f19771e) {
            sb.append("private, ");
        }
        if (this.f19772f) {
            sb.append("public, ");
        }
        if (this.f19773g) {
            sb.append("must-revalidate, ");
        }
        if (this.f19774h != -1) {
            sb.append("max-stale=");
            sb.append(this.f19774h);
            sb.append(", ");
        }
        if (this.f19775i != -1) {
            sb.append("min-fresh=");
            sb.append(this.f19775i);
            sb.append(", ");
        }
        if (this.f19776j) {
            sb.append("only-if-cached, ");
        }
        if (this.f19777k) {
            sb.append("no-transform, ");
        }
        if (this.f19778l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static okhttp3.CacheControl parse(okhttp3.Headers r22) {
        /*
            r0 = r22
            int r1 = r22.size()
            r6 = 0
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = -1
            r12 = -1
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = -1
            r17 = -1
            r18 = 0
            r19 = 0
            r20 = 0
        L_0x001a:
            if (r6 >= r1) goto L_0x013f
            java.lang.String r2 = r0.name(r6)
            java.lang.String r4 = r0.value(r6)
            java.lang.String r3 = "Cache-Control"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0031
            if (r8 == 0) goto L_0x002f
            goto L_0x0039
        L_0x002f:
            r8 = r4
            goto L_0x003a
        L_0x0031:
            java.lang.String r3 = "Pragma"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x0138
        L_0x0039:
            r7 = 0
        L_0x003a:
            r2 = 0
        L_0x003b:
            int r3 = r4.length()
            if (r2 >= r3) goto L_0x0138
            java.lang.String r3 = "=,;"
            int r3 = okhttp3.internal.http.HttpHeaders.skipUntil(r4, r2, r3)
            java.lang.String r2 = r4.substring(r2, r3)
            java.lang.String r2 = r2.trim()
            int r5 = r4.length()
            if (r3 == r5) goto L_0x0099
            char r5 = r4.charAt(r3)
            r0 = 44
            if (r5 == r0) goto L_0x0099
            char r0 = r4.charAt(r3)
            r5 = 59
            if (r0 != r5) goto L_0x0066
            goto L_0x0099
        L_0x0066:
            int r3 = r3 + 1
            int r0 = okhttp3.internal.http.HttpHeaders.skipWhitespace(r4, r3)
            int r3 = r4.length()
            if (r0 >= r3) goto L_0x0089
            char r3 = r4.charAt(r0)
            r5 = 34
            if (r3 != r5) goto L_0x0089
            int r0 = r0 + 1
            java.lang.String r3 = "\""
            int r3 = okhttp3.internal.http.HttpHeaders.skipUntil(r4, r0, r3)
            java.lang.String r0 = r4.substring(r0, r3)
            r5 = 1
            int r3 = r3 + r5
            goto L_0x009d
        L_0x0089:
            r5 = 1
            java.lang.String r3 = ",;"
            int r3 = okhttp3.internal.http.HttpHeaders.skipUntil(r4, r0, r3)
            java.lang.String r0 = r4.substring(r0, r3)
            java.lang.String r0 = r0.trim()
            goto L_0x009d
        L_0x0099:
            r5 = 1
            int r3 = r3 + 1
            r0 = 0
        L_0x009d:
            java.lang.String r5 = "no-cache"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00a9
            r5 = -1
            r9 = 1
            goto L_0x0133
        L_0x00a9:
            java.lang.String r5 = "no-store"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00b5
            r5 = -1
            r10 = 1
            goto L_0x0133
        L_0x00b5:
            java.lang.String r5 = "max-age"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00c4
            r5 = -1
            int r11 = okhttp3.internal.http.HttpHeaders.parseSeconds(r0, r5)
            goto L_0x0133
        L_0x00c4:
            java.lang.String r5 = "s-maxage"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00d2
            r5 = -1
            int r12 = okhttp3.internal.http.HttpHeaders.parseSeconds(r0, r5)
            goto L_0x0133
        L_0x00d2:
            java.lang.String r5 = "private"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00dd
            r5 = -1
            r13 = 1
            goto L_0x0133
        L_0x00dd:
            java.lang.String r5 = "public"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00e8
            r5 = -1
            r14 = 1
            goto L_0x0133
        L_0x00e8:
            java.lang.String r5 = "must-revalidate"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00f3
            r5 = -1
            r15 = 1
            goto L_0x0133
        L_0x00f3:
            java.lang.String r5 = "max-stale"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x0104
            r2 = 2147483647(0x7fffffff, float:NaN)
            int r16 = okhttp3.internal.http.HttpHeaders.parseSeconds(r0, r2)
            r5 = -1
            goto L_0x0133
        L_0x0104:
            java.lang.String r5 = "min-fresh"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x0112
            r5 = -1
            int r17 = okhttp3.internal.http.HttpHeaders.parseSeconds(r0, r5)
            goto L_0x0133
        L_0x0112:
            r5 = -1
            java.lang.String r0 = "only-if-cached"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x011e
            r18 = 1
            goto L_0x0133
        L_0x011e:
            java.lang.String r0 = "no-transform"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0129
            r19 = 1
            goto L_0x0133
        L_0x0129:
            java.lang.String r0 = "immutable"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0133
            r20 = 1
        L_0x0133:
            r0 = r22
            r2 = r3
            goto L_0x003b
        L_0x0138:
            r5 = -1
            int r6 = r6 + 1
            r0 = r22
            goto L_0x001a
        L_0x013f:
            if (r7 != 0) goto L_0x0144
            r21 = 0
            goto L_0x0146
        L_0x0144:
            r21 = r8
        L_0x0146:
            okhttp3.CacheControl r0 = new okhttp3.CacheControl
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.CacheControl.parse(okhttp3.Headers):okhttp3.CacheControl");
    }

    public boolean immutable() {
        return this.f19778l;
    }

    public boolean isPrivate() {
        return this.f19771e;
    }

    public boolean isPublic() {
        return this.f19772f;
    }

    public int maxAgeSeconds() {
        return this.f19769c;
    }

    public int maxStaleSeconds() {
        return this.f19774h;
    }

    public int minFreshSeconds() {
        return this.f19775i;
    }

    public boolean mustRevalidate() {
        return this.f19773g;
    }

    public boolean noCache() {
        return this.f19767a;
    }

    public boolean noStore() {
        return this.f19768b;
    }

    public boolean noTransform() {
        return this.f19777k;
    }

    public boolean onlyIfCached() {
        return this.f19776j;
    }

    public int sMaxAgeSeconds() {
        return this.f19770d;
    }

    public String toString() {
        String str = this.f19779m;
        if (str != null) {
            return str;
        }
        String a = m11907a();
        this.f19779m = a;
        return a;
    }

    CacheControl(Builder builder) {
        this.f19767a = builder.f19780a;
        this.f19768b = builder.f19781b;
        this.f19769c = builder.f19782c;
        this.f19770d = -1;
        this.f19771e = false;
        this.f19772f = false;
        this.f19773g = false;
        this.f19774h = builder.f19783d;
        this.f19775i = builder.f19784e;
        this.f19776j = builder.f19785f;
        this.f19777k = builder.f19786g;
        this.f19778l = builder.f19787h;
    }
}
