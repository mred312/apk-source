package okhttp3.internal.http2;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* renamed from: okhttp3.internal.http2.a */
/* compiled from: Hpack */
final class C3950a {

    /* renamed from: a */
    static final Header[] f21264a;

    /* renamed from: b */
    static final Map<ByteString, Integer> f21265b = m14314b();

    /* renamed from: okhttp3.internal.http2.a$a */
    /* compiled from: Hpack */
    static final class C3951a {

        /* renamed from: a */
        private final List<Header> f21266a;

        /* renamed from: b */
        private final BufferedSource f21267b;

        /* renamed from: c */
        private final int f21268c;

        /* renamed from: d */
        private int f21269d;

        /* renamed from: e */
        Header[] f21270e;

        /* renamed from: f */
        int f21271f;

        /* renamed from: g */
        int f21272g;

        /* renamed from: h */
        int f21273h;

        C3951a(int i, Source source) {
            this(i, i, source);
        }

        /* renamed from: a */
        private void m14315a() {
            int i = this.f21269d;
            int i2 = this.f21273h;
            if (i >= i2) {
                return;
            }
            if (i == 0) {
                m14316b();
            } else {
                m14318d(i2 - i);
            }
        }

        /* renamed from: b */
        private void m14316b() {
            Arrays.fill(this.f21270e, (Object) null);
            this.f21271f = this.f21270e.length - 1;
            this.f21272g = 0;
            this.f21273h = 0;
        }

        /* renamed from: c */
        private int m14317c(int i) {
            return this.f21271f + 1 + i;
        }

        /* renamed from: d */
        private int m14318d(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.f21270e.length;
                while (true) {
                    length--;
                    i2 = this.f21271f;
                    if (length < i2 || i <= 0) {
                        Header[] headerArr = this.f21270e;
                        System.arraycopy(headerArr, i2 + 1, headerArr, i2 + 1 + i3, this.f21272g);
                        this.f21271f += i3;
                    } else {
                        Header[] headerArr2 = this.f21270e;
                        i -= headerArr2[length].f21186a;
                        this.f21273h -= headerArr2[length].f21186a;
                        this.f21272g--;
                        i3++;
                    }
                }
                Header[] headerArr3 = this.f21270e;
                System.arraycopy(headerArr3, i2 + 1, headerArr3, i2 + 1 + i3, this.f21272g);
                this.f21271f += i3;
            }
            return i3;
        }

        /* renamed from: f */
        private ByteString m14319f(int i) {
            if (m14321h(i)) {
                return C3950a.f21264a[i].name;
            }
            int c = m14317c(i - C3950a.f21264a.length);
            if (c >= 0) {
                Header[] headerArr = this.f21270e;
                if (c < headerArr.length) {
                    return headerArr[c].name;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        /* renamed from: g */
        private void m14320g(int i, Header header) {
            this.f21266a.add(header);
            int i2 = header.f21186a;
            if (i != -1) {
                i2 -= this.f21270e[m14317c(i)].f21186a;
            }
            int i3 = this.f21269d;
            if (i2 > i3) {
                m14316b();
                return;
            }
            int d = m14318d((this.f21273h + i2) - i3);
            if (i == -1) {
                int i4 = this.f21272g + 1;
                Header[] headerArr = this.f21270e;
                if (i4 > headerArr.length) {
                    Header[] headerArr2 = new Header[(headerArr.length * 2)];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.f21271f = this.f21270e.length - 1;
                    this.f21270e = headerArr2;
                }
                int i5 = this.f21271f;
                this.f21271f = i5 - 1;
                this.f21270e[i5] = header;
                this.f21272g++;
            } else {
                this.f21270e[i + m14317c(i) + d] = header;
            }
            this.f21273h += i2;
        }

        /* renamed from: h */
        private boolean m14321h(int i) {
            return i >= 0 && i <= C3950a.f21264a.length - 1;
        }

        /* renamed from: i */
        private int m14322i() {
            return this.f21267b.readByte() & 255;
        }

        /* renamed from: l */
        private void m14323l(int i) {
            if (m14321h(i)) {
                this.f21266a.add(C3950a.f21264a[i]);
                return;
            }
            int c = m14317c(i - C3950a.f21264a.length);
            if (c >= 0) {
                Header[] headerArr = this.f21270e;
                if (c < headerArr.length) {
                    this.f21266a.add(headerArr[c]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        /* renamed from: n */
        private void m14324n(int i) {
            m14320g(-1, new Header(m14319f(i), mo25094j()));
        }

        /* renamed from: o */
        private void m14325o() {
            ByteString j = mo25094j();
            C3950a.m14313a(j);
            m14320g(-1, new Header(j, mo25094j()));
        }

        /* renamed from: p */
        private void m14326p(int i) {
            this.f21266a.add(new Header(m14319f(i), mo25094j()));
        }

        /* renamed from: q */
        private void m14327q() {
            ByteString j = mo25094j();
            C3950a.m14313a(j);
            this.f21266a.add(new Header(j, mo25094j()));
        }

        /* renamed from: e */
        public List<Header> mo25093e() {
            ArrayList arrayList = new ArrayList(this.f21266a);
            this.f21266a.clear();
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public ByteString mo25094j() {
            int i = m14322i();
            boolean z = (i & 128) == 128;
            int m = mo25096m(i, 127);
            if (z) {
                return ByteString.m12083of(C3957d.m14385f().mo25121c(this.f21267b.readByteArray((long) m)));
            }
            return this.f21267b.readByteString((long) m);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public void mo25095k() {
            while (!this.f21267b.exhausted()) {
                byte readByte = this.f21267b.readByte() & 255;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                } else if ((readByte & 128) == 128) {
                    m14323l(mo25096m(readByte, 127) - 1);
                } else if (readByte == 64) {
                    m14325o();
                } else if ((readByte & 64) == 64) {
                    m14324n(mo25096m(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int m = mo25096m(readByte, 31);
                    this.f21269d = m;
                    if (m < 0 || m > this.f21268c) {
                        throw new IOException("Invalid dynamic table size update " + this.f21269d);
                    }
                    m14315a();
                } else if (readByte == 16 || readByte == 0) {
                    m14327q();
                } else {
                    m14326p(mo25096m(readByte, 15) - 1);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: m */
        public int mo25096m(int i, int i2) {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int i5 = m14322i();
                if ((i5 & 128) == 0) {
                    return i2 + (i5 << i4);
                }
                i2 += (i5 & 127) << i4;
                i4 += 7;
            }
        }

        C3951a(int i, int i2, Source source) {
            this.f21266a = new ArrayList();
            Header[] headerArr = new Header[8];
            this.f21270e = headerArr;
            this.f21271f = headerArr.length - 1;
            this.f21272g = 0;
            this.f21273h = 0;
            this.f21268c = i;
            this.f21269d = i2;
            this.f21267b = Okio.buffer(source);
        }
    }

    /* renamed from: okhttp3.internal.http2.a$b */
    /* compiled from: Hpack */
    static final class C3952b {

        /* renamed from: a */
        private final Buffer f21274a;

        /* renamed from: b */
        private final boolean f21275b;

        /* renamed from: c */
        private int f21276c;

        /* renamed from: d */
        private boolean f21277d;

        /* renamed from: e */
        int f21278e;

        /* renamed from: f */
        Header[] f21279f;

        /* renamed from: g */
        int f21280g;

        /* renamed from: h */
        int f21281h;

        /* renamed from: i */
        int f21282i;

        C3952b(Buffer buffer) {
            this(4096, true, buffer);
        }

        /* renamed from: a */
        private void m14332a() {
            int i = this.f21278e;
            int i2 = this.f21282i;
            if (i >= i2) {
                return;
            }
            if (i == 0) {
                m14333b();
            } else {
                m14334c(i2 - i);
            }
        }

        /* renamed from: b */
        private void m14333b() {
            Arrays.fill(this.f21279f, (Object) null);
            this.f21280g = this.f21279f.length - 1;
            this.f21281h = 0;
            this.f21282i = 0;
        }

        /* renamed from: c */
        private int m14334c(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.f21279f.length;
                while (true) {
                    length--;
                    i2 = this.f21280g;
                    if (length < i2 || i <= 0) {
                        Header[] headerArr = this.f21279f;
                        System.arraycopy(headerArr, i2 + 1, headerArr, i2 + 1 + i3, this.f21281h);
                        Header[] headerArr2 = this.f21279f;
                        int i4 = this.f21280g;
                        Arrays.fill(headerArr2, i4 + 1, i4 + 1 + i3, (Object) null);
                        this.f21280g += i3;
                    } else {
                        Header[] headerArr3 = this.f21279f;
                        i -= headerArr3[length].f21186a;
                        this.f21282i -= headerArr3[length].f21186a;
                        this.f21281h--;
                        i3++;
                    }
                }
                Header[] headerArr4 = this.f21279f;
                System.arraycopy(headerArr4, i2 + 1, headerArr4, i2 + 1 + i3, this.f21281h);
                Header[] headerArr22 = this.f21279f;
                int i42 = this.f21280g;
                Arrays.fill(headerArr22, i42 + 1, i42 + 1 + i3, (Object) null);
                this.f21280g += i3;
            }
            return i3;
        }

        /* renamed from: d */
        private void m14335d(Header header) {
            int i = header.f21186a;
            int i2 = this.f21278e;
            if (i > i2) {
                m14333b();
                return;
            }
            m14334c((this.f21282i + i) - i2);
            int i3 = this.f21281h + 1;
            Header[] headerArr = this.f21279f;
            if (i3 > headerArr.length) {
                Header[] headerArr2 = new Header[(headerArr.length * 2)];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.f21280g = this.f21279f.length - 1;
                this.f21279f = headerArr2;
            }
            int i4 = this.f21280g;
            this.f21280g = i4 - 1;
            this.f21279f[i4] = header;
            this.f21281h++;
            this.f21282i += i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo25097e(int i) {
            int min = Math.min(i, 16384);
            int i2 = this.f21278e;
            if (i2 != min) {
                if (min < i2) {
                    this.f21276c = Math.min(this.f21276c, min);
                }
                this.f21277d = true;
                this.f21278e = min;
                m14332a();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo25098f(ByteString byteString) {
            if (!this.f21275b || C3957d.m14385f().mo25123e(byteString) >= byteString.size()) {
                mo25100h(byteString.size(), 127, 0);
                this.f21274a.write(byteString);
                return;
            }
            Buffer buffer = new Buffer();
            C3957d.m14385f().mo25122d(byteString, buffer);
            ByteString readByteString = buffer.readByteString();
            mo25100h(readByteString.size(), 127, 128);
            this.f21274a.write(readByteString);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public void mo25099g(List<Header> list) {
            int i;
            int i2;
            if (this.f21277d) {
                int i3 = this.f21276c;
                if (i3 < this.f21278e) {
                    mo25100h(i3, 31, 32);
                }
                this.f21277d = false;
                this.f21276c = Integer.MAX_VALUE;
                mo25100h(this.f21278e, 31, 32);
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                Header header = list.get(i4);
                ByteString asciiLowercase = header.name.toAsciiLowercase();
                ByteString byteString = header.value;
                Integer num = C3950a.f21265b.get(asciiLowercase);
                if (num != null) {
                    i2 = num.intValue() + 1;
                    if (i2 > 1 && i2 < 8) {
                        Header[] headerArr = C3950a.f21264a;
                        if (Util.equal(headerArr[i2 - 1].value, byteString)) {
                            i = i2;
                        } else if (Util.equal(headerArr[i2].value, byteString)) {
                            i = i2;
                            i2++;
                        }
                    }
                    i = i2;
                    i2 = -1;
                } else {
                    i2 = -1;
                    i = -1;
                }
                if (i2 == -1) {
                    int i5 = this.f21280g + 1;
                    int length = this.f21279f.length;
                    while (true) {
                        if (i5 >= length) {
                            break;
                        }
                        if (Util.equal(this.f21279f[i5].name, asciiLowercase)) {
                            if (Util.equal(this.f21279f[i5].value, byteString)) {
                                i2 = C3950a.f21264a.length + (i5 - this.f21280g);
                                break;
                            } else if (i == -1) {
                                i = (i5 - this.f21280g) + C3950a.f21264a.length;
                            }
                        }
                        i5++;
                    }
                }
                if (i2 != -1) {
                    mo25100h(i2, 127, 128);
                } else if (i == -1) {
                    this.f21274a.writeByte(64);
                    mo25098f(asciiLowercase);
                    mo25098f(byteString);
                    m14335d(header);
                } else if (!asciiLowercase.startsWith(Header.PSEUDO_PREFIX) || Header.TARGET_AUTHORITY.equals(asciiLowercase)) {
                    mo25100h(i, 63, 64);
                    mo25098f(byteString);
                    m14335d(header);
                } else {
                    mo25100h(i, 15, 0);
                    mo25098f(byteString);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public void mo25100h(int i, int i2, int i3) {
            if (i < i2) {
                this.f21274a.writeByte(i | i3);
                return;
            }
            this.f21274a.writeByte(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.f21274a.writeByte(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.f21274a.writeByte(i4);
        }

        C3952b(int i, boolean z, Buffer buffer) {
            this.f21276c = Integer.MAX_VALUE;
            Header[] headerArr = new Header[8];
            this.f21279f = headerArr;
            this.f21280g = headerArr.length - 1;
            this.f21281h = 0;
            this.f21282i = 0;
            this.f21278e = i;
            this.f21275b = z;
            this.f21274a = buffer;
        }
    }

    static {
        ByteString byteString = Header.TARGET_METHOD;
        ByteString byteString2 = Header.TARGET_PATH;
        ByteString byteString3 = Header.TARGET_SCHEME;
        ByteString byteString4 = Header.RESPONSE_STATUS;
        f21264a = new Header[]{new Header(Header.TARGET_AUTHORITY, ""), new Header(byteString, "GET"), new Header(byteString, "POST"), new Header(byteString2, "/"), new Header(byteString2, "/index.html"), new Header(byteString3, "http"), new Header(byteString3, "https"), new Header(byteString4, "200"), new Header(byteString4, "204"), new Header(byteString4, "206"), new Header(byteString4, "304"), new Header(byteString4, "400"), new Header(byteString4, "404"), new Header(byteString4, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header((String) FirebaseAnalytics.Param.LOCATION, ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
    }

    /* renamed from: a */
    static ByteString m14313a(ByteString byteString) {
        int size = byteString.size();
        int i = 0;
        while (i < size) {
            byte b = byteString.getByte(i);
            if (b < 65 || b > 90) {
                i++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }

    /* renamed from: b */
    private static Map<ByteString, Integer> m14314b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f21264a.length);
        int i = 0;
        while (true) {
            Header[] headerArr = f21264a;
            if (i >= headerArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(headerArr[i].name)) {
                linkedHashMap.put(headerArr[i].name, Integer.valueOf(i));
            }
            i++;
        }
    }
}
