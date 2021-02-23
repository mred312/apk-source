package okhttp3;

import com.facebook.ads.AdError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;

public final class Cookie {

    /* renamed from: j */
    private static final Pattern f19815j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: k */
    private static final Pattern f19816k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: l */
    private static final Pattern f19817l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: m */
    private static final Pattern f19818m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a */
    private final String f19819a;

    /* renamed from: b */
    private final String f19820b;

    /* renamed from: c */
    private final long f19821c;

    /* renamed from: d */
    private final String f19822d;

    /* renamed from: e */
    private final String f19823e;

    /* renamed from: f */
    private final boolean f19824f;

    /* renamed from: g */
    private final boolean f19825g;

    /* renamed from: h */
    private final boolean f19826h;

    /* renamed from: i */
    private final boolean f19827i;

    public static final class Builder {
        @Nullable

        /* renamed from: a */
        String f19828a;
        @Nullable

        /* renamed from: b */
        String f19829b;

        /* renamed from: c */
        long f19830c = HttpDate.MAX_DATE;
        @Nullable

        /* renamed from: d */
        String f19831d;

        /* renamed from: e */
        String f19832e = "/";

        /* renamed from: f */
        boolean f19833f;

        /* renamed from: g */
        boolean f19834g;

        /* renamed from: h */
        boolean f19835h;

        /* renamed from: i */
        boolean f19836i;

        /* renamed from: a */
        private Builder m11929a(String str, boolean z) {
            if (str != null) {
                String canonicalizeHost = Util.canonicalizeHost(str);
                if (canonicalizeHost != null) {
                    this.f19831d = canonicalizeHost;
                    this.f19836i = z;
                    return this;
                }
                throw new IllegalArgumentException("unexpected domain: " + str);
            }
            throw new NullPointerException("domain == null");
        }

        public Cookie build() {
            return new Cookie(this);
        }

        public Builder domain(String str) {
            m11929a(str, false);
            return this;
        }

        public Builder expiresAt(long j) {
            if (j <= 0) {
                j = Long.MIN_VALUE;
            }
            if (j > HttpDate.MAX_DATE) {
                j = 253402300799999L;
            }
            this.f19830c = j;
            this.f19835h = true;
            return this;
        }

        public Builder hostOnlyDomain(String str) {
            m11929a(str, true);
            return this;
        }

        public Builder httpOnly() {
            this.f19834g = true;
            return this;
        }

        public Builder name(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str.trim().equals(str)) {
                this.f19828a = str;
                return this;
            } else {
                throw new IllegalArgumentException("name is not trimmed");
            }
        }

        public Builder path(String str) {
            if (str.startsWith("/")) {
                this.f19832e = str;
                return this;
            }
            throw new IllegalArgumentException("path must start with '/'");
        }

        public Builder secure() {
            this.f19833f = true;
            return this;
        }

        public Builder value(String str) {
            if (str == null) {
                throw new NullPointerException("value == null");
            } else if (str.trim().equals(str)) {
                this.f19829b = str;
                return this;
            } else {
                throw new IllegalArgumentException("value is not trimmed");
            }
        }
    }

    private Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f19819a = str;
        this.f19820b = str2;
        this.f19821c = j;
        this.f19822d = str3;
        this.f19823e = str4;
        this.f19824f = z;
        this.f19825g = z2;
        this.f19827i = z3;
        this.f19826h = z4;
    }

    /* renamed from: a */
    private static int m11921a(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (((charAt < ' ' && charAt != 9) || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: b */
    private static boolean m11922b(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (!str.endsWith(str2) || str.charAt((str.length() - str2.length()) - 1) != '.' || Util.verifyAsIpAddress(str)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x010e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010f  */
    @javax.annotation.Nullable
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static okhttp3.Cookie m11923c(long r23, okhttp3.HttpUrl r25, java.lang.String r26) {
        /*
            r0 = r26
            int r1 = r26.length()
            r2 = 0
            r3 = 59
            int r4 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r0, (int) r2, (int) r1, (char) r3)
            r5 = 61
            int r6 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r0, (int) r2, (int) r4, (char) r5)
            r7 = 0
            if (r6 != r4) goto L_0x0017
            return r7
        L_0x0017:
            java.lang.String r9 = okhttp3.internal.Util.trimSubstring(r0, r2, r6)
            boolean r8 = r9.isEmpty()
            if (r8 != 0) goto L_0x0135
            int r8 = okhttp3.internal.Util.indexOfControlOrNonAscii(r9)
            r10 = -1
            if (r8 == r10) goto L_0x002a
            goto L_0x0135
        L_0x002a:
            r8 = 1
            int r6 = r6 + r8
            java.lang.String r6 = okhttp3.internal.Util.trimSubstring(r0, r6, r4)
            int r11 = okhttp3.internal.Util.indexOfControlOrNonAscii(r6)
            if (r11 == r10) goto L_0x0037
            return r7
        L_0x0037:
            int r4 = r4 + r8
            r10 = -1
            r12 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            r8 = r7
            r14 = r8
            r19 = r10
            r21 = r12
            r15 = 0
            r16 = 0
            r17 = 1
            r18 = 0
        L_0x004c:
            if (r4 >= r1) goto L_0x00ba
            int r7 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r0, (int) r4, (int) r1, (char) r3)
            int r3 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r0, (int) r4, (int) r7, (char) r5)
            java.lang.String r4 = okhttp3.internal.Util.trimSubstring(r0, r4, r3)
            if (r3 >= r7) goto L_0x0063
            int r3 = r3 + 1
            java.lang.String r3 = okhttp3.internal.Util.trimSubstring(r0, r3, r7)
            goto L_0x0065
        L_0x0063:
            java.lang.String r3 = ""
        L_0x0065:
            java.lang.String r5 = "expires"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0076
            int r4 = r3.length()     // Catch:{ IllegalArgumentException -> 0x00b2 }
            long r21 = m11925e(r3, r2, r4)     // Catch:{ IllegalArgumentException -> 0x00b2 }
            goto L_0x0082
        L_0x0076:
            java.lang.String r5 = "max-age"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0085
            long r19 = m11926f(r3)     // Catch:{  }
        L_0x0082:
            r18 = 1
            goto L_0x00b2
        L_0x0085:
            java.lang.String r5 = "domain"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0094
            java.lang.String r14 = m11924d(r3)     // Catch:{ IllegalArgumentException -> 0x00b2 }
            r17 = 0
            goto L_0x00b2
        L_0x0094:
            java.lang.String r5 = "path"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x009e
            r8 = r3
            goto L_0x00b2
        L_0x009e:
            java.lang.String r3 = "secure"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x00a8
            r15 = 1
            goto L_0x00b2
        L_0x00a8:
            java.lang.String r3 = "httponly"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x00b2
            r16 = 1
        L_0x00b2:
            int r4 = r7 + 1
            r3 = 59
            r5 = 61
            r7 = 0
            goto L_0x004c
        L_0x00ba:
            r0 = -9223372036854775808
            int r3 = (r19 > r0 ? 1 : (r19 == r0 ? 0 : -1))
            if (r3 != 0) goto L_0x00c2
        L_0x00c0:
            r11 = r0
            goto L_0x00e7
        L_0x00c2:
            int r0 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
            if (r0 == 0) goto L_0x00e5
            r0 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
            int r3 = (r19 > r0 ? 1 : (r19 == r0 ? 0 : -1))
            if (r3 > 0) goto L_0x00d4
            r0 = 1000(0x3e8, double:4.94E-321)
            long r19 = r19 * r0
            goto L_0x00d9
        L_0x00d4:
            r19 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x00d9:
            long r0 = r23 + r19
            int r3 = (r0 > r23 ? 1 : (r0 == r23 ? 0 : -1))
            if (r3 < 0) goto L_0x00e3
            int r3 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r3 <= 0) goto L_0x00c0
        L_0x00e3:
            r11 = r12
            goto L_0x00e7
        L_0x00e5:
            r11 = r21
        L_0x00e7:
            java.lang.String r0 = r25.host()
            if (r14 != 0) goto L_0x00f0
            r13 = r0
            r1 = 0
            goto L_0x00fa
        L_0x00f0:
            boolean r1 = m11922b(r0, r14)
            if (r1 != 0) goto L_0x00f8
            r1 = 0
            return r1
        L_0x00f8:
            r1 = 0
            r13 = r14
        L_0x00fa:
            int r0 = r0.length()
            int r3 = r13.length()
            if (r0 == r3) goto L_0x010f
            okhttp3.internal.publicsuffix.PublicSuffixDatabase r0 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.get()
            java.lang.String r0 = r0.getEffectiveTldPlusOne(r13)
            if (r0 != 0) goto L_0x010f
            return r1
        L_0x010f:
            java.lang.String r0 = "/"
            if (r8 == 0) goto L_0x011c
            boolean r1 = r8.startsWith(r0)
            if (r1 != 0) goto L_0x011a
            goto L_0x011c
        L_0x011a:
            r14 = r8
            goto L_0x012d
        L_0x011c:
            java.lang.String r1 = r25.encodedPath()
            r3 = 47
            int r3 = r1.lastIndexOf(r3)
            if (r3 == 0) goto L_0x012c
            java.lang.String r0 = r1.substring(r2, r3)
        L_0x012c:
            r14 = r0
        L_0x012d:
            okhttp3.Cookie r0 = new okhttp3.Cookie
            r8 = r0
            r10 = r6
            r8.<init>(r9, r10, r11, r13, r14, r15, r16, r17, r18)
            return r0
        L_0x0135:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cookie.m11923c(long, okhttp3.HttpUrl, java.lang.String):okhttp3.Cookie");
    }

    /* renamed from: d */
    private static String m11924d(String str) {
        if (!str.endsWith(".")) {
            if (str.startsWith(".")) {
                str = str.substring(1);
            }
            String canonicalizeHost = Util.canonicalizeHost(str);
            if (canonicalizeHost != null) {
                return canonicalizeHost;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: e */
    private static long m11925e(String str, int i, int i2) {
        int a = m11921a(str, i, i2, false);
        Matcher matcher = f19818m.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        while (a < i2) {
            int a2 = m11921a(str, a + 1, i2, true);
            matcher.region(a, a2);
            if (i4 == -1 && matcher.usePattern(f19818m).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
                i7 = Integer.parseInt(matcher.group(2));
                i8 = Integer.parseInt(matcher.group(3));
            } else if (i5 != -1 || !matcher.usePattern(f19817l).matches()) {
                if (i6 == -1) {
                    Pattern pattern = f19816k;
                    if (matcher.usePattern(pattern).matches()) {
                        i6 = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                    }
                }
                if (i3 == -1 && matcher.usePattern(f19815j).matches()) {
                    i3 = Integer.parseInt(matcher.group(1));
                }
            } else {
                i5 = Integer.parseInt(matcher.group(1));
            }
            a = m11921a(str, a2 + 1, i2, false);
        }
        if (i3 >= 70 && i3 <= 99) {
            i3 += 1900;
        }
        if (i3 >= 0 && i3 <= 69) {
            i3 += AdError.SERVER_ERROR_CODE;
        }
        if (i3 < 1601) {
            throw new IllegalArgumentException();
        } else if (i6 == -1) {
            throw new IllegalArgumentException();
        } else if (i5 < 1 || i5 > 31) {
            throw new IllegalArgumentException();
        } else if (i4 < 0 || i4 > 23) {
            throw new IllegalArgumentException();
        } else if (i7 < 0 || i7 > 59) {
            throw new IllegalArgumentException();
        } else if (i8 < 0 || i8 > 59) {
            throw new IllegalArgumentException();
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i3);
            gregorianCalendar.set(2, i6 - 1);
            gregorianCalendar.set(5, i5);
            gregorianCalendar.set(11, i4);
            gregorianCalendar.set(12, i7);
            gregorianCalendar.set(13, i8);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    /* renamed from: f */
    private static long m11926f(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e) {
            if (!str.matches("-?\\d+")) {
                throw e;
            } else if (str.startsWith("-")) {
                return Long.MIN_VALUE;
            } else {
                return Long.MAX_VALUE;
            }
        }
    }

    /* renamed from: g */
    private static boolean m11927g(HttpUrl httpUrl, String str) {
        String encodedPath = httpUrl.encodedPath();
        if (encodedPath.equals(str)) {
            return true;
        }
        if (!encodedPath.startsWith(str)) {
            return false;
        }
        if (!str.endsWith("/") && encodedPath.charAt(str.length()) != '/') {
            return false;
        }
        return true;
    }

    @Nullable
    public static Cookie parse(HttpUrl httpUrl, String str) {
        return m11923c(System.currentTimeMillis(), httpUrl, str);
    }

    public static List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        List<String> values = headers.values("Set-Cookie");
        int size = values.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            Cookie parse = parse(httpUrl, values.get(i));
            if (parse != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(parse);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public String domain() {
        return this.f19822d;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        if (cookie.f19819a.equals(this.f19819a) && cookie.f19820b.equals(this.f19820b) && cookie.f19822d.equals(this.f19822d) && cookie.f19823e.equals(this.f19823e) && cookie.f19821c == this.f19821c && cookie.f19824f == this.f19824f && cookie.f19825g == this.f19825g && cookie.f19826h == this.f19826h && cookie.f19827i == this.f19827i) {
            return true;
        }
        return false;
    }

    public long expiresAt() {
        return this.f19821c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public String mo21900h(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f19819a);
        sb.append('=');
        sb.append(this.f19820b);
        if (this.f19826h) {
            if (this.f19821c == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(HttpDate.format(new Date(this.f19821c)));
            }
        }
        if (!this.f19827i) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.f19822d);
        }
        sb.append("; path=");
        sb.append(this.f19823e);
        if (this.f19824f) {
            sb.append("; secure");
        }
        if (this.f19825g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public int hashCode() {
        long j = this.f19821c;
        return ((((((((((((((((527 + this.f19819a.hashCode()) * 31) + this.f19820b.hashCode()) * 31) + this.f19822d.hashCode()) * 31) + this.f19823e.hashCode()) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + (this.f19824f ^ true ? 1 : 0)) * 31) + (this.f19825g ^ true ? 1 : 0)) * 31) + (this.f19826h ^ true ? 1 : 0)) * 31) + (this.f19827i ^ true ? 1 : 0);
    }

    public boolean hostOnly() {
        return this.f19827i;
    }

    public boolean httpOnly() {
        return this.f19825g;
    }

    public boolean matches(HttpUrl httpUrl) {
        boolean z;
        if (this.f19827i) {
            z = httpUrl.host().equals(this.f19822d);
        } else {
            z = m11922b(httpUrl.host(), this.f19822d);
        }
        if (!z || !m11927g(httpUrl, this.f19823e)) {
            return false;
        }
        if (!this.f19824f || httpUrl.isHttps()) {
            return true;
        }
        return false;
    }

    public String name() {
        return this.f19819a;
    }

    public String path() {
        return this.f19823e;
    }

    public boolean persistent() {
        return this.f19826h;
    }

    public boolean secure() {
        return this.f19824f;
    }

    public String toString() {
        return mo21900h(false);
    }

    public String value() {
        return this.f19820b;
    }

    Cookie(Builder builder) {
        String str = builder.f19828a;
        if (str != null) {
            String str2 = builder.f19829b;
            if (str2 != null) {
                String str3 = builder.f19831d;
                if (str3 != null) {
                    this.f19819a = str;
                    this.f19820b = str2;
                    this.f19821c = builder.f19830c;
                    this.f19822d = str3;
                    this.f19823e = builder.f19832e;
                    this.f19824f = builder.f19833f;
                    this.f19825g = builder.f19834g;
                    this.f19826h = builder.f19835h;
                    this.f19827i = builder.f19836i;
                    return;
                }
                throw new NullPointerException("builder.domain == null");
            }
            throw new NullPointerException("builder.value == null");
        }
        throw new NullPointerException("builder.name == null");
    }
}
