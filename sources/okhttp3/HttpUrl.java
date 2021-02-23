package okhttp3;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.Buffer;

public final class HttpUrl {

    /* renamed from: j */
    private static final char[] f19857j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    final String f19858a;

    /* renamed from: b */
    private final String f19859b;

    /* renamed from: c */
    private final String f19860c;

    /* renamed from: d */
    final String f19861d;

    /* renamed from: e */
    final int f19862e;

    /* renamed from: f */
    private final List<String> f19863f;
    @Nullable

    /* renamed from: g */
    private final List<String> f19864g;
    @Nullable

    /* renamed from: h */
    private final String f19865h;

    /* renamed from: i */
    private final String f19866i;

    public static final class Builder {
        @Nullable

        /* renamed from: a */
        String f19867a;

        /* renamed from: b */
        String f19868b = "";

        /* renamed from: c */
        String f19869c = "";
        @Nullable

        /* renamed from: d */
        String f19870d;

        /* renamed from: e */
        int f19871e = -1;

        /* renamed from: f */
        final List<String> f19872f;
        @Nullable

        /* renamed from: g */
        List<String> f19873g;
        @Nullable

        /* renamed from: h */
        String f19874h;

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.f19872f = arrayList;
            arrayList.add("");
        }

        /* renamed from: a */
        private Builder m11958a(String str, boolean z) {
            int i = 0;
            do {
                int delimiterOffset = Util.delimiterOffset(str, i, str.length(), "/\\");
                m11965j(str, i, delimiterOffset, delimiterOffset < str.length(), z);
                i = delimiterOffset + 1;
            } while (i <= str.length());
            return this;
        }

        /* renamed from: b */
        private static String m11959b(String str, int i, int i2) {
            return Util.canonicalizeHost(HttpUrl.m11952g(str, i, i2, false));
        }

        /* renamed from: d */
        private boolean m11960d(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        /* renamed from: e */
        private boolean m11961e(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        /* renamed from: g */
        private static int m11962g(String str, int i, int i2) {
            try {
                int parseInt = Integer.parseInt(HttpUrl.m11946a(str, i, i2, "", false, false, false, true, (Charset) null));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }

        /* renamed from: h */
        private void m11963h() {
            List<String> list = this.f19872f;
            if (!list.remove(list.size() - 1).isEmpty() || this.f19872f.isEmpty()) {
                this.f19872f.add("");
                return;
            }
            List<String> list2 = this.f19872f;
            list2.set(list2.size() - 1, "");
        }

        /* renamed from: i */
        private static int m11964i(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i >= i2) {
                            break;
                        }
                    } while (str.charAt(i) == ']');
                }
                i++;
            }
            return i2;
        }

        /* renamed from: j */
        private void m11965j(String str, int i, int i2, boolean z, boolean z2) {
            String a = HttpUrl.m11946a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, (Charset) null);
            if (!m11960d(a)) {
                if (m11961e(a)) {
                    m11963h();
                    return;
                }
                List<String> list = this.f19872f;
                if (list.get(list.size() - 1).isEmpty()) {
                    List<String> list2 = this.f19872f;
                    list2.set(list2.size() - 1, a);
                } else {
                    this.f19872f.add(a);
                }
                if (z) {
                    this.f19872f.add("");
                }
            }
        }

        /* renamed from: l */
        private void m11966l(String str) {
            for (int size = this.f19873g.size() - 2; size >= 0; size -= 2) {
                if (str.equals(this.f19873g.get(size))) {
                    this.f19873g.remove(size + 1);
                    this.f19873g.remove(size);
                    if (this.f19873g.isEmpty()) {
                        this.f19873g = null;
                        return;
                    }
                }
            }
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0044 A[SYNTHETIC] */
        /* renamed from: m */
        private void m11967m(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L_0x0003
                return
            L_0x0003:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L_0x001e
                r1 = 92
                if (r0 != r1) goto L_0x0013
                goto L_0x001e
            L_0x0013:
                java.util.List<java.lang.String> r0 = r10.f19872f
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L_0x0029
            L_0x001e:
                java.util.List<java.lang.String> r0 = r10.f19872f
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f19872f
                r0.add(r2)
                goto L_0x0041
            L_0x0029:
                r6 = r12
                if (r6 >= r13) goto L_0x0044
                java.lang.String r12 = "/\\"
                int r12 = okhttp3.internal.Util.delimiterOffset((java.lang.String) r11, (int) r6, (int) r13, (java.lang.String) r12)
                if (r12 >= r13) goto L_0x0036
                r0 = 1
                goto L_0x0037
            L_0x0036:
                r0 = 0
            L_0x0037:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.m11965j(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L_0x0029
            L_0x0041:
                int r12 = r12 + 1
                goto L_0x0029
            L_0x0044:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.m11967m(java.lang.String, int, int):void");
        }

        /* renamed from: n */
        private static int m11968n(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char charAt2 = str.charAt(i);
                    if ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && !((charAt2 >= '0' && charAt2 <= '9') || charAt2 == '+' || charAt2 == '-' || charAt2 == '.'))) {
                        if (charAt2 == ':') {
                            return i;
                        }
                    }
                }
            }
            return -1;
        }

        /* renamed from: o */
        private static int m11969o(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        public Builder addEncodedPathSegment(String str) {
            if (str != null) {
                m11965j(str, 0, str.length(), false, true);
                return this;
            }
            throw new NullPointerException("encodedPathSegment == null");
        }

        public Builder addEncodedPathSegments(String str) {
            if (str != null) {
                m11958a(str, true);
                return this;
            }
            throw new NullPointerException("encodedPathSegments == null");
        }

        public Builder addEncodedQueryParameter(String str, @Nullable String str2) {
            if (str != null) {
                if (this.f19873g == null) {
                    this.f19873g = new ArrayList();
                }
                this.f19873g.add(HttpUrl.m11947b(str, " \"'<>#&=", true, false, true, true));
                this.f19873g.add(str2 != null ? HttpUrl.m11947b(str2, " \"'<>#&=", true, false, true, true) : null);
                return this;
            }
            throw new NullPointerException("encodedName == null");
        }

        public Builder addPathSegment(String str) {
            if (str != null) {
                m11965j(str, 0, str.length(), false, false);
                return this;
            }
            throw new NullPointerException("pathSegment == null");
        }

        public Builder addPathSegments(String str) {
            if (str != null) {
                m11958a(str, false);
                return this;
            }
            throw new NullPointerException("pathSegments == null");
        }

        public Builder addQueryParameter(String str, @Nullable String str2) {
            if (str != null) {
                if (this.f19873g == null) {
                    this.f19873g = new ArrayList();
                }
                this.f19873g.add(HttpUrl.m11947b(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
                this.f19873g.add(str2 != null ? HttpUrl.m11947b(str2, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true) : null);
                return this;
            }
            throw new NullPointerException("name == null");
        }

        public HttpUrl build() {
            if (this.f19867a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.f19870d != null) {
                return new HttpUrl(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public int mo22039c() {
            int i = this.f19871e;
            return i != -1 ? i : HttpUrl.defaultPort(this.f19867a);
        }

        public Builder encodedFragment(@Nullable String str) {
            this.f19874h = str != null ? HttpUrl.m11947b(str, "", true, false, false, false) : null;
            return this;
        }

        public Builder encodedPassword(String str) {
            if (str != null) {
                this.f19869c = HttpUrl.m11947b(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                return this;
            }
            throw new NullPointerException("encodedPassword == null");
        }

        public Builder encodedPath(String str) {
            if (str == null) {
                throw new NullPointerException("encodedPath == null");
            } else if (str.startsWith("/")) {
                m11967m(str, 0, str.length());
                return this;
            } else {
                throw new IllegalArgumentException("unexpected encodedPath: " + str);
            }
        }

        public Builder encodedQuery(@Nullable String str) {
            this.f19873g = str != null ? HttpUrl.m11957l(HttpUrl.m11947b(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public Builder encodedUsername(String str) {
            if (str != null) {
                this.f19868b = HttpUrl.m11947b(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                return this;
            }
            throw new NullPointerException("encodedUsername == null");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public Builder mo22045f(@Nullable HttpUrl httpUrl, String str) {
            int delimiterOffset;
            int i;
            HttpUrl httpUrl2 = httpUrl;
            String str2 = str;
            int skipLeadingAsciiWhitespace = Util.skipLeadingAsciiWhitespace(str2, 0, str.length());
            int skipTrailingAsciiWhitespace = Util.skipTrailingAsciiWhitespace(str2, skipLeadingAsciiWhitespace, str.length());
            int n = m11968n(str2, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace);
            if (n != -1) {
                if (str.regionMatches(true, skipLeadingAsciiWhitespace, "https:", 0, 6)) {
                    this.f19867a = "https";
                    skipLeadingAsciiWhitespace += 6;
                } else if (str.regionMatches(true, skipLeadingAsciiWhitespace, "http:", 0, 5)) {
                    this.f19867a = "http";
                    skipLeadingAsciiWhitespace += 5;
                } else {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str2.substring(0, n) + "'");
                }
            } else if (httpUrl2 != null) {
                this.f19867a = httpUrl2.f19858a;
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int o = m11969o(str2, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace);
            char c = '?';
            char c2 = '#';
            if (o >= 2 || httpUrl2 == null || !httpUrl2.f19858a.equals(this.f19867a)) {
                int i2 = skipLeadingAsciiWhitespace + o;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    delimiterOffset = Util.delimiterOffset(str2, i2, skipTrailingAsciiWhitespace, "@/\\?#");
                    char charAt = delimiterOffset != skipTrailingAsciiWhitespace ? str2.charAt(delimiterOffset) : 65535;
                    if (charAt == 65535 || charAt == c2 || charAt == '/' || charAt == '\\' || charAt == c) {
                        int i3 = delimiterOffset;
                        int i4 = m11964i(str2, i2, i3);
                        int i5 = i4 + 1;
                    } else {
                        if (charAt == '@') {
                            if (!z) {
                                int delimiterOffset2 = Util.delimiterOffset(str2, i2, delimiterOffset, ':');
                                int i6 = delimiterOffset2;
                                String str3 = "%40";
                                i = delimiterOffset;
                                String a = HttpUrl.m11946a(str, i2, delimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null);
                                if (z2) {
                                    a = this.f19868b + str3 + a;
                                }
                                this.f19868b = a;
                                if (i6 != i) {
                                    this.f19869c = HttpUrl.m11946a(str, i6 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null);
                                    z = true;
                                }
                                z2 = true;
                            } else {
                                i = delimiterOffset;
                                this.f19869c += "%40" + HttpUrl.m11946a(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null);
                            }
                            i2 = i + 1;
                        }
                        c = '?';
                        c2 = '#';
                    }
                }
                int i32 = delimiterOffset;
                int i42 = m11964i(str2, i2, i32);
                int i52 = i42 + 1;
                if (i52 < i32) {
                    this.f19870d = m11959b(str2, i2, i42);
                    int g = m11962g(str2, i52, i32);
                    this.f19871e = g;
                    if (g == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str2.substring(i52, i32) + '\"');
                    }
                } else {
                    this.f19870d = m11959b(str2, i2, i42);
                    this.f19871e = HttpUrl.defaultPort(this.f19867a);
                }
                if (this.f19870d != null) {
                    skipLeadingAsciiWhitespace = i32;
                } else {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str2.substring(i2, i42) + '\"');
                }
            } else {
                this.f19868b = httpUrl.encodedUsername();
                this.f19869c = httpUrl.encodedPassword();
                this.f19870d = httpUrl2.f19861d;
                this.f19871e = httpUrl2.f19862e;
                this.f19872f.clear();
                this.f19872f.addAll(httpUrl.encodedPathSegments());
                if (skipLeadingAsciiWhitespace == skipTrailingAsciiWhitespace || str2.charAt(skipLeadingAsciiWhitespace) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
            }
            int delimiterOffset3 = Util.delimiterOffset(str2, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace, "?#");
            m11967m(str2, skipLeadingAsciiWhitespace, delimiterOffset3);
            if (delimiterOffset3 < skipTrailingAsciiWhitespace && str2.charAt(delimiterOffset3) == '?') {
                int delimiterOffset4 = Util.delimiterOffset(str2, delimiterOffset3, skipTrailingAsciiWhitespace, '#');
                this.f19873g = HttpUrl.m11957l(HttpUrl.m11946a(str, delimiterOffset3 + 1, delimiterOffset4, " \"'<>#", true, false, true, true, (Charset) null));
                delimiterOffset3 = delimiterOffset4;
            }
            if (delimiterOffset3 < skipTrailingAsciiWhitespace && str2.charAt(delimiterOffset3) == '#') {
                this.f19874h = HttpUrl.m11946a(str, 1 + delimiterOffset3, skipTrailingAsciiWhitespace, "", true, false, false, false, (Charset) null);
            }
            return this;
        }

        public Builder fragment(@Nullable String str) {
            this.f19874h = str != null ? HttpUrl.m11947b(str, "", false, false, false, false) : null;
            return this;
        }

        public Builder host(String str) {
            if (str != null) {
                String b = m11959b(str, 0, str.length());
                if (b != null) {
                    this.f19870d = b;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            throw new NullPointerException("host == null");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public Builder mo22048k() {
            int size = this.f19872f.size();
            for (int i = 0; i < size; i++) {
                this.f19872f.set(i, HttpUrl.m11947b(this.f19872f.get(i), "[]", true, true, false, true));
            }
            List<String> list = this.f19873g;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.f19873g.get(i2);
                    if (str != null) {
                        this.f19873g.set(i2, HttpUrl.m11947b(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.f19874h;
            if (str2 != null) {
                this.f19874h = HttpUrl.m11947b(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public Builder password(String str) {
            if (str != null) {
                this.f19869c = HttpUrl.m11947b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("password == null");
        }

        public Builder port(int i) {
            if (i <= 0 || i > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i);
            }
            this.f19871e = i;
            return this;
        }

        public Builder query(@Nullable String str) {
            this.f19873g = str != null ? HttpUrl.m11957l(HttpUrl.m11947b(str, " \"'<>#", false, false, true, true)) : null;
            return this;
        }

        public Builder removeAllEncodedQueryParameters(String str) {
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            } else if (this.f19873g == null) {
                return this;
            } else {
                m11966l(HttpUrl.m11947b(str, " \"'<>#&=", true, false, true, true));
                return this;
            }
        }

        public Builder removeAllQueryParameters(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (this.f19873g == null) {
                return this;
            } else {
                m11966l(HttpUrl.m11947b(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
                return this;
            }
        }

        public Builder removePathSegment(int i) {
            this.f19872f.remove(i);
            if (this.f19872f.isEmpty()) {
                this.f19872f.add("");
            }
            return this;
        }

        public Builder scheme(String str) {
            if (str != null) {
                if (str.equalsIgnoreCase("http")) {
                    this.f19867a = "http";
                } else if (str.equalsIgnoreCase("https")) {
                    this.f19867a = "https";
                } else {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                return this;
            }
            throw new NullPointerException("scheme == null");
        }

        public Builder setEncodedPathSegment(int i, String str) {
            if (str != null) {
                String a = HttpUrl.m11946a(str, 0, str.length(), " \"<>^`{}|/\\?#", true, false, false, true, (Charset) null);
                this.f19872f.set(i, a);
                if (!m11960d(a) && !m11961e(a)) {
                    return this;
                }
                throw new IllegalArgumentException("unexpected path segment: " + str);
            }
            throw new NullPointerException("encodedPathSegment == null");
        }

        public Builder setEncodedQueryParameter(String str, @Nullable String str2) {
            removeAllEncodedQueryParameters(str);
            addEncodedQueryParameter(str, str2);
            return this;
        }

        public Builder setPathSegment(int i, String str) {
            if (str != null) {
                String a = HttpUrl.m11946a(str, 0, str.length(), " \"<>^`{}|/\\?#", false, false, false, true, (Charset) null);
                if (m11960d(a) || m11961e(a)) {
                    throw new IllegalArgumentException("unexpected path segment: " + str);
                }
                this.f19872f.set(i, a);
                return this;
            }
            throw new NullPointerException("pathSegment == null");
        }

        public Builder setQueryParameter(String str, @Nullable String str2) {
            removeAllQueryParameters(str);
            addQueryParameter(str, str2);
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.f19867a;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (!this.f19868b.isEmpty() || !this.f19869c.isEmpty()) {
                sb.append(this.f19868b);
                if (!this.f19869c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f19869c);
                }
                sb.append('@');
            }
            String str2 = this.f19870d;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.f19870d);
                    sb.append(']');
                } else {
                    sb.append(this.f19870d);
                }
            }
            if (!(this.f19871e == -1 && this.f19867a == null)) {
                int c = mo22039c();
                String str3 = this.f19867a;
                if (str3 == null || c != HttpUrl.defaultPort(str3)) {
                    sb.append(':');
                    sb.append(c);
                }
            }
            HttpUrl.m11951f(sb, this.f19872f);
            if (this.f19873g != null) {
                sb.append('?');
                HttpUrl.m11950e(sb, this.f19873g);
            }
            if (this.f19874h != null) {
                sb.append('#');
                sb.append(this.f19874h);
            }
            return sb.toString();
        }

        public Builder username(String str) {
            if (str != null) {
                this.f19868b = HttpUrl.m11947b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("username == null");
        }
    }

    HttpUrl(Builder builder) {
        this.f19858a = builder.f19867a;
        this.f19859b = m11953h(builder.f19868b, false);
        this.f19860c = m11953h(builder.f19869c, false);
        this.f19861d = builder.f19870d;
        this.f19862e = builder.mo22039c();
        this.f19863f = m11954i(builder.f19872f, false);
        List<String> list = builder.f19873g;
        String str = null;
        this.f19864g = list != null ? m11954i(list, true) : null;
        String str2 = builder.f19874h;
        this.f19865h = str2 != null ? m11953h(str2, false) : str;
        this.f19866i = builder.toString();
    }

    /* renamed from: a */
    static String m11946a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        String str3 = str;
        int i3 = i2;
        int i4 = i;
        while (i4 < i3) {
            int codePointAt = str.codePointAt(i4);
            if (codePointAt < 32 || codePointAt == 127 || (codePointAt >= 128 && z4)) {
                String str4 = str2;
            } else {
                String str5 = str2;
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || m11956k(str, i4, i2)))) && (codePointAt != 43 || !z3))) {
                    i4 += Character.charCount(codePointAt);
                }
            }
            Buffer buffer = new Buffer();
            int i5 = i;
            buffer.writeUtf8(str, i, i4);
            m11949d(buffer, str, i4, i2, str2, z, z2, z3, z4, charset);
            return buffer.readUtf8();
        }
        int i6 = i;
        return str.substring(i, i2);
    }

    /* renamed from: b */
    static String m11947b(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return m11946a(str, 0, str.length(), str2, z, z2, z3, z4, (Charset) null);
    }

    /* renamed from: c */
    static String m11948c(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        return m11946a(str, 0, str.length(), str2, z, z2, z3, z4, charset);
    }

    /* renamed from: d */
    static void m11949d(Buffer buffer, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        Buffer buffer2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt == 43 && z3) {
                    buffer.writeUtf8(z ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !m11956k(str, i, i2)))))) {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    if (charset == null || charset.equals(Util.UTF_8)) {
                        buffer2.writeUtf8CodePoint(codePointAt);
                    } else {
                        buffer2.writeString(str, i, Character.charCount(codePointAt) + i, charset);
                    }
                    while (!buffer2.exhausted()) {
                        byte readByte = buffer2.readByte() & 255;
                        buffer.writeByte(37);
                        char[] cArr = f19857j;
                        buffer.writeByte((int) cArr[(readByte >> 4) & 15]);
                        buffer.writeByte((int) cArr[readByte & 15]);
                    }
                } else {
                    buffer.writeUtf8CodePoint(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    public static int defaultPort(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    /* renamed from: e */
    static void m11950e(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    /* renamed from: f */
    static void m11951f(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    /* renamed from: g */
    static String m11952g(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, i, i3);
                m11955j(buffer, str, i3, i2, z);
                return buffer.readUtf8();
            }
        }
        return str.substring(i, i2);
    }

    public static HttpUrl get(String str) {
        Builder builder = new Builder();
        builder.mo22045f((HttpUrl) null, str);
        return builder.build();
    }

    /* renamed from: h */
    static String m11953h(String str, boolean z) {
        return m11952g(str, 0, str.length(), z);
    }

    /* renamed from: i */
    private List<String> m11954i(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? m11953h(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: j */
    static void m11955j(Buffer buffer, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt == 37 && (i3 = i + 2) < i2) {
                int decodeHexDigit = Util.decodeHexDigit(str.charAt(i + 1));
                int decodeHexDigit2 = Util.decodeHexDigit(str.charAt(i3));
                if (!(decodeHexDigit == -1 || decodeHexDigit2 == -1)) {
                    buffer.writeByte((decodeHexDigit << 4) + decodeHexDigit2);
                    i = i3;
                    i += Character.charCount(codePointAt);
                }
            } else if (codePointAt == 43 && z) {
                buffer.writeByte(32);
                i += Character.charCount(codePointAt);
            }
            buffer.writeUtf8CodePoint(codePointAt);
            i += Character.charCount(codePointAt);
        }
    }

    /* renamed from: k */
    static boolean m11956k(String str, int i, int i2) {
        int i3 = i + 2;
        if (i3 >= i2 || str.charAt(i) != '%' || Util.decodeHexDigit(str.charAt(i + 1)) == -1 || Util.decodeHexDigit(str.charAt(i3)) == -1) {
            return false;
        }
        return true;
    }

    /* renamed from: l */
    static List<String> m11957l(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add((Object) null);
            } else {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    @Nullable
    public static HttpUrl parse(String str) {
        try {
            return get(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @Nullable
    public String encodedFragment() {
        if (this.f19865h == null) {
            return null;
        }
        return this.f19866i.substring(this.f19866i.indexOf(35) + 1);
    }

    public String encodedPassword() {
        if (this.f19860c.isEmpty()) {
            return "";
        }
        int indexOf = this.f19866i.indexOf(64);
        return this.f19866i.substring(this.f19866i.indexOf(58, this.f19858a.length() + 3) + 1, indexOf);
    }

    public String encodedPath() {
        int indexOf = this.f19866i.indexOf(47, this.f19858a.length() + 3);
        String str = this.f19866i;
        return this.f19866i.substring(indexOf, Util.delimiterOffset(str, indexOf, str.length(), "?#"));
    }

    public List<String> encodedPathSegments() {
        int indexOf = this.f19866i.indexOf(47, this.f19858a.length() + 3);
        String str = this.f19866i;
        int delimiterOffset = Util.delimiterOffset(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < delimiterOffset) {
            int i = indexOf + 1;
            int delimiterOffset2 = Util.delimiterOffset(this.f19866i, i, delimiterOffset, '/');
            arrayList.add(this.f19866i.substring(i, delimiterOffset2));
            indexOf = delimiterOffset2;
        }
        return arrayList;
    }

    @Nullable
    public String encodedQuery() {
        if (this.f19864g == null) {
            return null;
        }
        int indexOf = this.f19866i.indexOf(63) + 1;
        String str = this.f19866i;
        return this.f19866i.substring(indexOf, Util.delimiterOffset(str, indexOf, str.length(), '#'));
    }

    public String encodedUsername() {
        if (this.f19859b.isEmpty()) {
            return "";
        }
        int length = this.f19858a.length() + 3;
        String str = this.f19866i;
        return this.f19866i.substring(length, Util.delimiterOffset(str, length, str.length(), ":@"));
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof HttpUrl) && ((HttpUrl) obj).f19866i.equals(this.f19866i);
    }

    @Nullable
    public String fragment() {
        return this.f19865h;
    }

    public int hashCode() {
        return this.f19866i.hashCode();
    }

    public String host() {
        return this.f19861d;
    }

    public boolean isHttps() {
        return this.f19858a.equals("https");
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.f19867a = this.f19858a;
        builder.f19868b = encodedUsername();
        builder.f19869c = encodedPassword();
        builder.f19870d = this.f19861d;
        builder.f19871e = this.f19862e != defaultPort(this.f19858a) ? this.f19862e : -1;
        builder.f19872f.clear();
        builder.f19872f.addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.f19874h = encodedFragment();
        return builder;
    }

    public String password() {
        return this.f19860c;
    }

    public List<String> pathSegments() {
        return this.f19863f;
    }

    public int pathSize() {
        return this.f19863f.size();
    }

    public int port() {
        return this.f19862e;
    }

    @Nullable
    public String query() {
        if (this.f19864g == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        m11950e(sb, this.f19864g);
        return sb.toString();
    }

    @Nullable
    public String queryParameter(String str) {
        List<String> list = this.f19864g;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            if (str.equals(this.f19864g.get(i))) {
                return this.f19864g.get(i + 1);
            }
        }
        return null;
    }

    public String queryParameterName(int i) {
        List<String> list = this.f19864g;
        if (list != null) {
            return list.get(i * 2);
        }
        throw new IndexOutOfBoundsException();
    }

    public Set<String> queryParameterNames() {
        if (this.f19864g == null) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = this.f19864g.size();
        for (int i = 0; i < size; i += 2) {
            linkedHashSet.add(this.f19864g.get(i));
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public String queryParameterValue(int i) {
        List<String> list = this.f19864g;
        if (list != null) {
            return list.get((i * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public List<String> queryParameterValues(String str) {
        if (this.f19864g == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = this.f19864g.size();
        for (int i = 0; i < size; i += 2) {
            if (str.equals(this.f19864g.get(i))) {
                arrayList.add(this.f19864g.get(i + 1));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public int querySize() {
        List<String> list = this.f19864g;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public String redact() {
        return newBuilder("/...").username("").password("").build().toString();
    }

    @Nullable
    public HttpUrl resolve(String str) {
        Builder newBuilder = newBuilder(str);
        if (newBuilder != null) {
            return newBuilder.build();
        }
        return null;
    }

    public String scheme() {
        return this.f19858a;
    }

    public String toString() {
        return this.f19866i;
    }

    @Nullable
    public String topPrivateDomain() {
        if (Util.verifyAsIpAddress(this.f19861d)) {
            return null;
        }
        return PublicSuffixDatabase.get().getEffectiveTldPlusOne(this.f19861d);
    }

    public URI uri() {
        Builder newBuilder = newBuilder();
        newBuilder.mo22048k();
        String builder = newBuilder.toString();
        try {
            return new URI(builder);
        } catch (URISyntaxException e) {
            try {
                return URI.create(builder.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public URL url() {
        try {
            return new URL(this.f19866i);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public String username() {
        return this.f19859b;
    }

    @Nullable
    public static HttpUrl get(URL url) {
        return parse(url.toString());
    }

    @Nullable
    public static HttpUrl get(URI uri) {
        return parse(uri.toString());
    }

    @Nullable
    public Builder newBuilder(String str) {
        try {
            Builder builder = new Builder();
            builder.mo22045f(this, str);
            return builder;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
