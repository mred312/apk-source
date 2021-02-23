package okhttp3.internal.http2;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class Http2Codec implements HttpCodec {

    /* renamed from: f */
    private static final List<String> f21191f = Util.immutableList((T[]) new String[]{"connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", Header.TARGET_METHOD_UTF8, Header.TARGET_PATH_UTF8, Header.TARGET_SCHEME_UTF8, Header.TARGET_AUTHORITY_UTF8});

    /* renamed from: g */
    private static final List<String> f21192g = Util.immutableList((T[]) new String[]{"connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade"});

    /* renamed from: a */
    private final Interceptor.Chain f21193a;

    /* renamed from: b */
    final StreamAllocation f21194b;

    /* renamed from: c */
    private final Http2Connection f21195c;

    /* renamed from: d */
    private Http2Stream f21196d;

    /* renamed from: e */
    private final Protocol f21197e;

    /* renamed from: okhttp3.internal.http2.Http2Codec$a */
    class C3937a extends ForwardingSource {

        /* renamed from: b */
        boolean f21198b = false;

        /* renamed from: c */
        long f21199c = 0;

        C3937a(Source source) {
            super(source);
        }

        /* renamed from: a */
        private void m14269a(IOException iOException) {
            if (!this.f21198b) {
                this.f21198b = true;
                Http2Codec http2Codec = Http2Codec.this;
                http2Codec.f21194b.streamFinished(false, http2Codec, this.f21199c, iOException);
            }
        }

        public void close() {
            super.close();
            m14269a((IOException) null);
        }

        public long read(Buffer buffer, long j) {
            try {
                long read = delegate().read(buffer, j);
                if (read > 0) {
                    this.f21199c += read;
                }
                return read;
            } catch (IOException e) {
                m14269a(e);
                throw e;
            }
        }
    }

    public Http2Codec(OkHttpClient okHttpClient, Interceptor.Chain chain, StreamAllocation streamAllocation, Http2Connection http2Connection) {
        this.f21193a = chain;
        this.f21194b = streamAllocation;
        this.f21195c = http2Connection;
        List<Protocol> protocols = okHttpClient.protocols();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.f21197e = !protocols.contains(protocol) ? Protocol.HTTP_2 : protocol;
    }

    public static List<Header> http2HeadersList(Request request) {
        Headers headers = request.headers();
        ArrayList arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
        arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(request.url())));
        String header = request.header("Host");
        if (header != null) {
            arrayList.add(new Header(Header.TARGET_AUTHORITY, header));
        }
        arrayList.add(new Header(Header.TARGET_SCHEME, request.url().scheme()));
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            ByteString encodeUtf8 = ByteString.encodeUtf8(headers.name(i).toLowerCase(Locale.US));
            if (!f21191f.contains(encodeUtf8.utf8())) {
                arrayList.add(new Header(encodeUtf8, headers.value(i)));
            }
        }
        return arrayList;
    }

    public static Response.Builder readHttp2HeadersList(Headers headers, Protocol protocol) {
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        StatusLine statusLine = null;
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            String value = headers.value(i);
            if (name.equals(Header.RESPONSE_STATUS_UTF8)) {
                statusLine = StatusLine.parse("HTTP/1.1 " + value);
            } else if (!f21192g.contains(name)) {
                Internal.instance.addLenient(builder, name, value);
            }
        }
        if (statusLine != null) {
            return new Response.Builder().protocol(protocol).code(statusLine.code).message(statusLine.message).headers(builder.build());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public void cancel() {
        Http2Stream http2Stream = this.f21196d;
        if (http2Stream != null) {
            http2Stream.closeLater(ErrorCode.CANCEL);
        }
    }

    public Sink createRequestBody(Request request, long j) {
        return this.f21196d.getSink();
    }

    public void finishRequest() {
        this.f21196d.getSink().close();
    }

    public void flushRequest() {
        this.f21195c.flush();
    }

    public ResponseBody openResponseBody(Response response) {
        StreamAllocation streamAllocation = this.f21194b;
        streamAllocation.eventListener.responseBodyStart(streamAllocation.call);
        return new RealResponseBody(response.header("Content-Type"), HttpHeaders.contentLength(response), Okio.buffer((Source) new C3937a(this.f21196d.getSource())));
    }

    public Response.Builder readResponseHeaders(boolean z) {
        Response.Builder readHttp2HeadersList = readHttp2HeadersList(this.f21196d.takeHeaders(), this.f21197e);
        if (!z || Internal.instance.code(readHttp2HeadersList) != 100) {
            return readHttp2HeadersList;
        }
        return null;
    }

    public void writeRequestHeaders(Request request) {
        if (this.f21196d == null) {
            Http2Stream newStream = this.f21195c.newStream(http2HeadersList(request), request.body() != null);
            this.f21196d = newStream;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            newStream.readTimeout().timeout((long) this.f21193a.readTimeoutMillis(), timeUnit);
            this.f21196d.writeTimeout().timeout((long) this.f21193a.writeTimeoutMillis(), timeUnit);
        }
    }
}
