package okhttp3.internal.http1;

import android.support.p000v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http1Codec implements HttpCodec {

    /* renamed from: a */
    final OkHttpClient f21162a;

    /* renamed from: b */
    final StreamAllocation f21163b;

    /* renamed from: c */
    final BufferedSource f21164c;

    /* renamed from: d */
    final BufferedSink f21165d;

    /* renamed from: e */
    int f21166e = 0;

    /* renamed from: f */
    private long f21167f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;

    /* renamed from: okhttp3.internal.http1.Http1Codec$b */
    private abstract class C3930b implements Source {

        /* renamed from: a */
        protected final ForwardingTimeout f21168a;

        /* renamed from: b */
        protected boolean f21169b;

        /* renamed from: c */
        protected long f21170c;

        private C3930b() {
            this.f21168a = new ForwardingTimeout(Http1Codec.this.f21164c.timeout());
            this.f21170c = 0;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo25031a(boolean z, IOException iOException) {
            Http1Codec http1Codec = Http1Codec.this;
            int i = http1Codec.f21166e;
            if (i != 6) {
                if (i == 5) {
                    http1Codec.mo25022a(this.f21168a);
                    Http1Codec http1Codec2 = Http1Codec.this;
                    http1Codec2.f21166e = 6;
                    StreamAllocation streamAllocation = http1Codec2.f21163b;
                    if (streamAllocation != null) {
                        streamAllocation.streamFinished(!z, http1Codec2, this.f21170c, iOException);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("state: " + Http1Codec.this.f21166e);
            }
        }

        public long read(Buffer buffer, long j) {
            try {
                long read = Http1Codec.this.f21164c.read(buffer, j);
                if (read > 0) {
                    this.f21170c += read;
                }
                return read;
            } catch (IOException e) {
                mo25031a(false, e);
                throw e;
            }
        }

        public Timeout timeout() {
            return this.f21168a;
        }
    }

    /* renamed from: okhttp3.internal.http1.Http1Codec$c */
    private final class C3931c implements Sink {

        /* renamed from: a */
        private final ForwardingTimeout f21172a;

        /* renamed from: b */
        private boolean f21173b;

        C3931c() {
            this.f21172a = new ForwardingTimeout(Http1Codec.this.f21165d.timeout());
        }

        public synchronized void close() {
            if (!this.f21173b) {
                this.f21173b = true;
                Http1Codec.this.f21165d.writeUtf8("0\r\n\r\n");
                Http1Codec.this.mo25022a(this.f21172a);
                Http1Codec.this.f21166e = 3;
            }
        }

        public synchronized void flush() {
            if (!this.f21173b) {
                Http1Codec.this.f21165d.flush();
            }
        }

        public Timeout timeout() {
            return this.f21172a;
        }

        public void write(Buffer buffer, long j) {
            if (this.f21173b) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                Http1Codec.this.f21165d.writeHexadecimalUnsignedLong(j);
                Http1Codec.this.f21165d.writeUtf8("\r\n");
                Http1Codec.this.f21165d.write(buffer, j);
                Http1Codec.this.f21165d.writeUtf8("\r\n");
            }
        }
    }

    /* renamed from: okhttp3.internal.http1.Http1Codec$d */
    private class C3932d extends C3930b {

        /* renamed from: e */
        private final HttpUrl f21175e;

        /* renamed from: f */
        private long f21176f = -1;

        /* renamed from: g */
        private boolean f21177g = true;

        C3932d(HttpUrl httpUrl) {
            super();
            this.f21175e = httpUrl;
        }

        /* renamed from: b */
        private void m14263b() {
            if (this.f21176f != -1) {
                Http1Codec.this.f21164c.readUtf8LineStrict();
            }
            try {
                this.f21176f = Http1Codec.this.f21164c.readHexadecimalUnsignedLong();
                String trim = Http1Codec.this.f21164c.readUtf8LineStrict().trim();
                if (this.f21176f < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f21176f + trim + "\"");
                } else if (this.f21176f == 0) {
                    this.f21177g = false;
                    HttpHeaders.receiveHeaders(Http1Codec.this.f21162a.cookieJar(), this.f21175e, Http1Codec.this.readHeaders());
                    mo25031a(true, (IOException) null);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        public void close() {
            if (!this.f21169b) {
                if (this.f21177g && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    mo25031a(false, (IOException) null);
                }
                this.f21169b = true;
            }
        }

        public long read(Buffer buffer, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f21169b) {
                throw new IllegalStateException("closed");
            } else if (!this.f21177g) {
                return -1;
            } else {
                long j2 = this.f21176f;
                if (j2 == 0 || j2 == -1) {
                    m14263b();
                    if (!this.f21177g) {
                        return -1;
                    }
                }
                long read = super.read(buffer, Math.min(j, this.f21176f));
                if (read != -1) {
                    this.f21176f -= read;
                    return read;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                mo25031a(false, protocolException);
                throw protocolException;
            }
        }
    }

    /* renamed from: okhttp3.internal.http1.Http1Codec$e */
    private final class C3933e implements Sink {

        /* renamed from: a */
        private final ForwardingTimeout f21179a;

        /* renamed from: b */
        private boolean f21180b;

        /* renamed from: c */
        private long f21181c;

        C3933e(long j) {
            this.f21179a = new ForwardingTimeout(Http1Codec.this.f21165d.timeout());
            this.f21181c = j;
        }

        public void close() {
            if (!this.f21180b) {
                this.f21180b = true;
                if (this.f21181c <= 0) {
                    Http1Codec.this.mo25022a(this.f21179a);
                    Http1Codec.this.f21166e = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }

        public void flush() {
            if (!this.f21180b) {
                Http1Codec.this.f21165d.flush();
            }
        }

        public Timeout timeout() {
            return this.f21179a;
        }

        public void write(Buffer buffer, long j) {
            if (!this.f21180b) {
                Util.checkOffsetAndCount(buffer.size(), 0, j);
                if (j <= this.f21181c) {
                    Http1Codec.this.f21165d.write(buffer, j);
                    this.f21181c -= j;
                    return;
                }
                throw new ProtocolException("expected " + this.f21181c + " bytes but received " + j);
            }
            throw new IllegalStateException("closed");
        }
    }

    /* renamed from: okhttp3.internal.http1.Http1Codec$f */
    private class C3934f extends C3930b {

        /* renamed from: e */
        private long f21183e;

        C3934f(Http1Codec http1Codec, long j) {
            super();
            this.f21183e = j;
            if (j == 0) {
                mo25031a(true, (IOException) null);
            }
        }

        public void close() {
            if (!this.f21169b) {
                if (this.f21183e != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    mo25031a(false, (IOException) null);
                }
                this.f21169b = true;
            }
        }

        public long read(Buffer buffer, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (!this.f21169b) {
                long j2 = this.f21183e;
                if (j2 == 0) {
                    return -1;
                }
                long read = super.read(buffer, Math.min(j2, j));
                if (read != -1) {
                    long j3 = this.f21183e - read;
                    this.f21183e = j3;
                    if (j3 == 0) {
                        mo25031a(true, (IOException) null);
                    }
                    return read;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                mo25031a(false, protocolException);
                throw protocolException;
            } else {
                throw new IllegalStateException("closed");
            }
        }
    }

    /* renamed from: okhttp3.internal.http1.Http1Codec$g */
    private class C3935g extends C3930b {

        /* renamed from: e */
        private boolean f21184e;

        C3935g(Http1Codec http1Codec) {
            super();
        }

        public void close() {
            if (!this.f21169b) {
                if (!this.f21184e) {
                    mo25031a(false, (IOException) null);
                }
                this.f21169b = true;
            }
        }

        public long read(Buffer buffer, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f21169b) {
                throw new IllegalStateException("closed");
            } else if (this.f21184e) {
                return -1;
            } else {
                long read = super.read(buffer, j);
                if (read != -1) {
                    return read;
                }
                this.f21184e = true;
                mo25031a(true, (IOException) null);
                return -1;
            }
        }
    }

    public Http1Codec(OkHttpClient okHttpClient, StreamAllocation streamAllocation, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.f21162a = okHttpClient;
        this.f21163b = streamAllocation;
        this.f21164c = bufferedSource;
        this.f21165d = bufferedSink;
    }

    /* renamed from: b */
    private String m14260b() {
        String readUtf8LineStrict = this.f21164c.readUtf8LineStrict(this.f21167f);
        this.f21167f -= (long) readUtf8LineStrict.length();
        return readUtf8LineStrict;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25022a(ForwardingTimeout forwardingTimeout) {
        Timeout delegate = forwardingTimeout.delegate();
        forwardingTimeout.setDelegate(Timeout.NONE);
        delegate.clearDeadline();
        delegate.clearTimeout();
    }

    public void cancel() {
        RealConnection connection = this.f21163b.connection();
        if (connection != null) {
            connection.cancel();
        }
    }

    public Sink createRequestBody(Request request, long j) {
        if ("chunked".equalsIgnoreCase(request.header("Transfer-Encoding"))) {
            return newChunkedSink();
        }
        if (j != -1) {
            return newFixedLengthSink(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public void finishRequest() {
        this.f21165d.flush();
    }

    public void flushRequest() {
        this.f21165d.flush();
    }

    public boolean isClosed() {
        return this.f21166e == 6;
    }

    public Sink newChunkedSink() {
        if (this.f21166e == 1) {
            this.f21166e = 2;
            return new C3931c();
        }
        throw new IllegalStateException("state: " + this.f21166e);
    }

    public Source newChunkedSource(HttpUrl httpUrl) {
        if (this.f21166e == 4) {
            this.f21166e = 5;
            return new C3932d(httpUrl);
        }
        throw new IllegalStateException("state: " + this.f21166e);
    }

    public Sink newFixedLengthSink(long j) {
        if (this.f21166e == 1) {
            this.f21166e = 2;
            return new C3933e(j);
        }
        throw new IllegalStateException("state: " + this.f21166e);
    }

    public Source newFixedLengthSource(long j) {
        if (this.f21166e == 4) {
            this.f21166e = 5;
            return new C3934f(this, j);
        }
        throw new IllegalStateException("state: " + this.f21166e);
    }

    public Source newUnknownLengthSource() {
        if (this.f21166e == 4) {
            StreamAllocation streamAllocation = this.f21163b;
            if (streamAllocation != null) {
                this.f21166e = 5;
                streamAllocation.noNewStreams();
                return new C3935g(this);
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.f21166e);
    }

    public ResponseBody openResponseBody(Response response) {
        StreamAllocation streamAllocation = this.f21163b;
        streamAllocation.eventListener.responseBodyStart(streamAllocation.call);
        String header = response.header("Content-Type");
        if (!HttpHeaders.hasBody(response)) {
            return new RealResponseBody(header, 0, Okio.buffer(newFixedLengthSource(0)));
        }
        if ("chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return new RealResponseBody(header, -1, Okio.buffer(newChunkedSource(response.request().url())));
        }
        long contentLength = HttpHeaders.contentLength(response);
        if (contentLength != -1) {
            return new RealResponseBody(header, contentLength, Okio.buffer(newFixedLengthSource(contentLength)));
        }
        return new RealResponseBody(header, -1, Okio.buffer(newUnknownLengthSource()));
    }

    public Headers readHeaders() {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String b = m14260b();
            if (b.length() == 0) {
                return builder.build();
            }
            Internal.instance.addLenient(builder, b);
        }
    }

    public Response.Builder readResponseHeaders(boolean z) {
        int i = this.f21166e;
        if (i == 1 || i == 3) {
            try {
                StatusLine parse = StatusLine.parse(m14260b());
                Response.Builder headers = new Response.Builder().protocol(parse.protocol).code(parse.code).message(parse.message).headers(readHeaders());
                if (z && parse.code == 100) {
                    return null;
                }
                if (parse.code == 100) {
                    this.f21166e = 3;
                    return headers;
                }
                this.f21166e = 4;
                return headers;
            } catch (EOFException e) {
                IOException iOException = new IOException("unexpected end of stream on " + this.f21163b);
                iOException.initCause(e);
                throw iOException;
            }
        } else {
            throw new IllegalStateException("state: " + this.f21166e);
        }
    }

    public void writeRequest(Headers headers, String str) {
        if (this.f21166e == 0) {
            this.f21165d.writeUtf8(str).writeUtf8("\r\n");
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                this.f21165d.writeUtf8(headers.name(i)).writeUtf8(": ").writeUtf8(headers.value(i)).writeUtf8("\r\n");
            }
            this.f21165d.writeUtf8("\r\n");
            this.f21166e = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.f21166e);
    }

    public void writeRequestHeaders(Request request) {
        writeRequest(request.headers(), RequestLine.get(request, this.f21163b.connection().route().proxy().type()));
    }
}
