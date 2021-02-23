package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.p009io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class Cache implements Closeable, Flushable {

    /* renamed from: a */
    final InternalCache f19731a;

    /* renamed from: b */
    final DiskLruCache f19732b;

    /* renamed from: c */
    int f19733c;

    /* renamed from: d */
    int f19734d;

    /* renamed from: e */
    private int f19735e;

    /* renamed from: f */
    private int f19736f;

    /* renamed from: g */
    private int f19737g;

    /* renamed from: okhttp3.Cache$b */
    class C3524b implements Iterator<String> {

        /* renamed from: a */
        final Iterator<DiskLruCache.Snapshot> f19738a;
        @Nullable

        /* renamed from: b */
        String f19739b;

        /* renamed from: c */
        boolean f19740c;

        C3524b() {
            this.f19738a = Cache.this.f19732b.snapshots();
        }

        /* renamed from: a */
        public String next() {
            if (hasNext()) {
                String str = this.f19739b;
                this.f19739b = null;
                this.f19740c = true;
                return str;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.f19739b != null) {
                return true;
            }
            this.f19740c = false;
            while (this.f19738a.hasNext()) {
                DiskLruCache.Snapshot next = this.f19738a.next();
                try {
                    this.f19739b = Okio.buffer(next.getSource(0)).readUtf8LineStrict();
                    return true;
                } catch (IOException unused) {
                } finally {
                    next.close();
                }
            }
            return false;
        }

        public void remove() {
            if (this.f19740c) {
                this.f19738a.remove();
                return;
            }
            throw new IllegalStateException("remove() before next()");
        }
    }

    /* renamed from: okhttp3.Cache$d */
    private static class C3525d extends ResponseBody {

        /* renamed from: b */
        final DiskLruCache.Snapshot f19742b;

        /* renamed from: c */
        private final BufferedSource f19743c;
        @Nullable

        /* renamed from: d */
        private final String f19744d;
        @Nullable

        /* renamed from: e */
        private final String f19745e;

        /* renamed from: okhttp3.Cache$d$a */
        class C3526a extends ForwardingSource {

            /* renamed from: b */
            final /* synthetic */ DiskLruCache.Snapshot f19746b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C3526a(C3525d dVar, Source source, DiskLruCache.Snapshot snapshot) {
                super(source);
                this.f19746b = snapshot;
            }

            public void close() {
                this.f19746b.close();
                super.close();
            }
        }

        C3525d(DiskLruCache.Snapshot snapshot, String str, String str2) {
            this.f19742b = snapshot;
            this.f19744d = str;
            this.f19745e = str2;
            this.f19743c = Okio.buffer((Source) new C3526a(this, snapshot.getSource(1), snapshot));
        }

        public long contentLength() {
            try {
                String str = this.f19745e;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1;
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        public MediaType contentType() {
            String str = this.f19744d;
            if (str != null) {
                return MediaType.parse(str);
            }
            return null;
        }

        public BufferedSource source() {
            return this.f19743c;
        }
    }

    /* renamed from: okhttp3.Cache$a */
    class C3528a implements InternalCache {
        C3528a() {
        }

        public Response get(Request request) {
            return Cache.this.mo21775b(request);
        }

        public CacheRequest put(Response response) {
            return Cache.this.mo21776c(response);
        }

        public void remove(Request request) {
            Cache.this.mo21780e(request);
        }

        public void trackConditionalCacheHit() {
            Cache.this.mo21782f();
        }

        public void trackResponse(CacheStrategy cacheStrategy) {
            Cache.this.mo21784g(cacheStrategy);
        }

        public void update(Response response, Response response2) {
            Cache.this.mo21785h(response, response2);
        }
    }

    /* renamed from: okhttp3.Cache$c */
    private final class C3529c implements CacheRequest {

        /* renamed from: a */
        private final DiskLruCache.Editor f19760a;

        /* renamed from: b */
        private Sink f19761b;

        /* renamed from: c */
        private Sink f19762c;

        /* renamed from: d */
        boolean f19763d;

        /* renamed from: okhttp3.Cache$c$a */
        class C3530a extends ForwardingSink {

            /* renamed from: b */
            final /* synthetic */ DiskLruCache.Editor f19765b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C3530a(Sink sink, Cache cache, DiskLruCache.Editor editor) {
                super(sink);
                this.f19765b = editor;
            }

            public void close() {
                synchronized (Cache.this) {
                    C3529c cVar = C3529c.this;
                    if (!cVar.f19763d) {
                        cVar.f19763d = true;
                        Cache.this.f19733c++;
                        super.close();
                        this.f19765b.commit();
                    }
                }
            }
        }

        C3529c(DiskLruCache.Editor editor) {
            this.f19760a = editor;
            Sink newSink = editor.newSink(1);
            this.f19761b = newSink;
            this.f19762c = new C3530a(newSink, Cache.this, editor);
        }

        public void abort() {
            synchronized (Cache.this) {
                if (!this.f19763d) {
                    this.f19763d = true;
                    Cache.this.f19734d++;
                    Util.closeQuietly((Closeable) this.f19761b);
                    try {
                        this.f19760a.abort();
                    } catch (IOException unused) {
                    }
                }
            }
        }

        public Sink body() {
            return this.f19762c;
        }
    }

    public Cache(File file, long j) {
        this(file, j, FileSystem.SYSTEM);
    }

    /* renamed from: a */
    private void m11892a(@Nullable DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: d */
    static int m11893d(BufferedSource bufferedSource) {
        try {
            long readDecimalLong = bufferedSource.readDecimalLong();
            String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
            if (readDecimalLong >= 0 && readDecimalLong <= 2147483647L && readUtf8LineStrict.isEmpty()) {
                return (int) readDecimalLong;
            }
            throw new IOException("expected an int but was \"" + readDecimalLong + readUtf8LineStrict + "\"");
        } catch (NumberFormatException e) {
            throw new IOException(e.getMessage());
        }
    }

    public static String key(HttpUrl httpUrl) {
        return ByteString.encodeUtf8(httpUrl.toString()).md5().hex();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: b */
    public Response mo21775b(Request request) {
        try {
            DiskLruCache.Snapshot snapshot = this.f19732b.get(key(request.url()));
            if (snapshot == null) {
                return null;
            }
            try {
                C3527e eVar = new C3527e(snapshot.getSource(0));
                Response d = eVar.mo21805d(snapshot);
                if (eVar.mo21804b(request, d)) {
                    return d;
                }
                Util.closeQuietly((Closeable) d.body());
                return null;
            } catch (IOException unused) {
                Util.closeQuietly((Closeable) snapshot);
                return null;
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: c */
    public CacheRequest mo21776c(Response response) {
        DiskLruCache.Editor editor;
        String method = response.request().method();
        if (HttpMethod.invalidatesCache(response.request().method())) {
            try {
                mo21780e(response.request());
            } catch (IOException unused) {
            }
            return null;
        } else if (!method.equals("GET") || HttpHeaders.hasVaryAll(response)) {
            return null;
        } else {
            C3527e eVar = new C3527e(response);
            try {
                editor = this.f19732b.edit(key(response.request().url()));
                if (editor == null) {
                    return null;
                }
                try {
                    eVar.mo21806f(editor);
                    return new C3529c(editor);
                } catch (IOException unused2) {
                    m11892a(editor);
                    return null;
                }
            } catch (IOException unused3) {
                editor = null;
                m11892a(editor);
                return null;
            }
        }
    }

    public void close() {
        this.f19732b.close();
    }

    public void delete() {
        this.f19732b.delete();
    }

    public File directory() {
        return this.f19732b.getDirectory();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo21780e(Request request) {
        this.f19732b.remove(key(request.url()));
    }

    public void evictAll() {
        this.f19732b.evictAll();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public synchronized void mo21782f() {
        this.f19736f++;
    }

    public void flush() {
        this.f19732b.flush();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public synchronized void mo21784g(CacheStrategy cacheStrategy) {
        this.f19737g++;
        if (cacheStrategy.networkRequest != null) {
            this.f19735e++;
        } else if (cacheStrategy.cacheResponse != null) {
            this.f19736f++;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo21785h(Response response, Response response2) {
        DiskLruCache.Editor editor;
        C3527e eVar = new C3527e(response2);
        try {
            editor = ((C3525d) response.body()).f19742b.edit();
            if (editor != null) {
                try {
                    eVar.mo21806f(editor);
                    editor.commit();
                } catch (IOException unused) {
                }
            }
        } catch (IOException unused2) {
            editor = null;
            m11892a(editor);
        }
    }

    public synchronized int hitCount() {
        return this.f19736f;
    }

    public void initialize() {
        this.f19732b.initialize();
    }

    public boolean isClosed() {
        return this.f19732b.isClosed();
    }

    public long maxSize() {
        return this.f19732b.getMaxSize();
    }

    public synchronized int networkCount() {
        return this.f19735e;
    }

    public synchronized int requestCount() {
        return this.f19737g;
    }

    public long size() {
        return this.f19732b.size();
    }

    public Iterator<String> urls() {
        return new C3524b();
    }

    public synchronized int writeAbortCount() {
        return this.f19734d;
    }

    public synchronized int writeSuccessCount() {
        return this.f19733c;
    }

    Cache(File file, long j, FileSystem fileSystem) {
        this.f19731a = new C3528a();
        this.f19732b = DiskLruCache.create(fileSystem, file, 201105, 2, j);
    }

    /* renamed from: okhttp3.Cache$e */
    private static final class C3527e {

        /* renamed from: k */
        private static final String f19747k = (Platform.get().getPrefix() + "-Sent-Millis");

        /* renamed from: l */
        private static final String f19748l = (Platform.get().getPrefix() + "-Received-Millis");

        /* renamed from: a */
        private final String f19749a;

        /* renamed from: b */
        private final Headers f19750b;

        /* renamed from: c */
        private final String f19751c;

        /* renamed from: d */
        private final Protocol f19752d;

        /* renamed from: e */
        private final int f19753e;

        /* renamed from: f */
        private final String f19754f;

        /* renamed from: g */
        private final Headers f19755g;
        @Nullable

        /* renamed from: h */
        private final Handshake f19756h;

        /* renamed from: i */
        private final long f19757i;

        /* renamed from: j */
        private final long f19758j;

        C3527e(Source source) {
            TlsVersion tlsVersion;
            try {
                BufferedSource buffer = Okio.buffer(source);
                this.f19749a = buffer.readUtf8LineStrict();
                this.f19751c = buffer.readUtf8LineStrict();
                Headers.Builder builder = new Headers.Builder();
                int d = Cache.m11893d(buffer);
                for (int i = 0; i < d; i++) {
                    builder.mo21988a(buffer.readUtf8LineStrict());
                }
                this.f19750b = builder.build();
                StatusLine parse = StatusLine.parse(buffer.readUtf8LineStrict());
                this.f19752d = parse.protocol;
                this.f19753e = parse.code;
                this.f19754f = parse.message;
                Headers.Builder builder2 = new Headers.Builder();
                int d2 = Cache.m11893d(buffer);
                for (int i2 = 0; i2 < d2; i2++) {
                    builder2.mo21988a(buffer.readUtf8LineStrict());
                }
                String str = f19747k;
                String str2 = builder2.get(str);
                String str3 = f19748l;
                String str4 = builder2.get(str3);
                builder2.removeAll(str);
                builder2.removeAll(str3);
                long j = 0;
                this.f19757i = str2 != null ? Long.parseLong(str2) : 0;
                this.f19758j = str4 != null ? Long.parseLong(str4) : j;
                this.f19755g = builder2.build();
                if (m11901a()) {
                    String readUtf8LineStrict = buffer.readUtf8LineStrict();
                    if (readUtf8LineStrict.length() <= 0) {
                        CipherSuite forJavaName = CipherSuite.forJavaName(buffer.readUtf8LineStrict());
                        List<Certificate> c = m11902c(buffer);
                        List<Certificate> c2 = m11902c(buffer);
                        if (!buffer.exhausted()) {
                            tlsVersion = TlsVersion.forJavaName(buffer.readUtf8LineStrict());
                        } else {
                            tlsVersion = TlsVersion.SSL_3_0;
                        }
                        this.f19756h = Handshake.get(tlsVersion, forJavaName, c, c2);
                    } else {
                        throw new IOException("expected \"\" but was \"" + readUtf8LineStrict + "\"");
                    }
                } else {
                    this.f19756h = null;
                }
            } finally {
                source.close();
            }
        }

        /* renamed from: a */
        private boolean m11901a() {
            return this.f19749a.startsWith("https://");
        }

        /* renamed from: c */
        private List<Certificate> m11902c(BufferedSource bufferedSource) {
            int d = Cache.m11893d(bufferedSource);
            if (d == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(d);
                for (int i = 0; i < d; i++) {
                    String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
                    Buffer buffer = new Buffer();
                    buffer.write(ByteString.decodeBase64(readUtf8LineStrict));
                    arrayList.add(instance.generateCertificate(buffer.inputStream()));
                }
                return arrayList;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        /* renamed from: e */
        private void m11903e(BufferedSink bufferedSink, List<Certificate> list) {
            try {
                bufferedSink.writeDecimalLong((long) list.size()).writeByte(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bufferedSink.writeUtf8(ByteString.m12083of(list.get(i).getEncoded()).base64()).writeByte(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        /* renamed from: b */
        public boolean mo21804b(Request request, Response response) {
            return this.f19749a.equals(request.url().toString()) && this.f19751c.equals(request.method()) && HttpHeaders.varyMatches(response, this.f19750b, request);
        }

        /* renamed from: d */
        public Response mo21805d(DiskLruCache.Snapshot snapshot) {
            String str = this.f19755g.get("Content-Type");
            String str2 = this.f19755g.get("Content-Length");
            return new Response.Builder().request(new Request.Builder().url(this.f19749a).method(this.f19751c, (RequestBody) null).headers(this.f19750b).build()).protocol(this.f19752d).code(this.f19753e).message(this.f19754f).headers(this.f19755g).body(new C3525d(snapshot, str, str2)).handshake(this.f19756h).sentRequestAtMillis(this.f19757i).receivedResponseAtMillis(this.f19758j).build();
        }

        /* renamed from: f */
        public void mo21806f(DiskLruCache.Editor editor) {
            BufferedSink buffer = Okio.buffer(editor.newSink(0));
            buffer.writeUtf8(this.f19749a).writeByte(10);
            buffer.writeUtf8(this.f19751c).writeByte(10);
            buffer.writeDecimalLong((long) this.f19750b.size()).writeByte(10);
            int size = this.f19750b.size();
            for (int i = 0; i < size; i++) {
                buffer.writeUtf8(this.f19750b.name(i)).writeUtf8(": ").writeUtf8(this.f19750b.value(i)).writeByte(10);
            }
            buffer.writeUtf8(new StatusLine(this.f19752d, this.f19753e, this.f19754f).toString()).writeByte(10);
            buffer.writeDecimalLong((long) (this.f19755g.size() + 2)).writeByte(10);
            int size2 = this.f19755g.size();
            for (int i2 = 0; i2 < size2; i2++) {
                buffer.writeUtf8(this.f19755g.name(i2)).writeUtf8(": ").writeUtf8(this.f19755g.value(i2)).writeByte(10);
            }
            buffer.writeUtf8(f19747k).writeUtf8(": ").writeDecimalLong(this.f19757i).writeByte(10);
            buffer.writeUtf8(f19748l).writeUtf8(": ").writeDecimalLong(this.f19758j).writeByte(10);
            if (m11901a()) {
                buffer.writeByte(10);
                buffer.writeUtf8(this.f19756h.cipherSuite().javaName()).writeByte(10);
                m11903e(buffer, this.f19756h.peerCertificates());
                m11903e(buffer, this.f19756h.localCertificates());
                buffer.writeUtf8(this.f19756h.tlsVersion().javaName()).writeByte(10);
            }
            buffer.close();
        }

        C3527e(Response response) {
            this.f19749a = response.request().url().toString();
            this.f19750b = HttpHeaders.varyHeaders(response);
            this.f19751c = response.request().method();
            this.f19752d = response.protocol();
            this.f19753e = response.code();
            this.f19754f = response.message();
            this.f19755g = response.headers();
            this.f19756h = response.handshake();
            this.f19757i = response.sentRequestAtMillis();
            this.f19758j = response.receivedResponseAtMillis();
        }
    }
}
