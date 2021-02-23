package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

public abstract class ResponseBody implements Closeable {
    @Nullable

    /* renamed from: a */
    private Reader f19996a;

    /* renamed from: okhttp3.ResponseBody$a */
    class C3539a extends ResponseBody {

        /* renamed from: b */
        final /* synthetic */ MediaType f19997b;

        /* renamed from: c */
        final /* synthetic */ long f19998c;

        /* renamed from: d */
        final /* synthetic */ BufferedSource f19999d;

        C3539a(MediaType mediaType, long j, BufferedSource bufferedSource) {
            this.f19997b = mediaType;
            this.f19998c = j;
            this.f19999d = bufferedSource;
        }

        public long contentLength() {
            return this.f19998c;
        }

        @Nullable
        public MediaType contentType() {
            return this.f19997b;
        }

        public BufferedSource source() {
            return this.f19999d;
        }
    }

    /* renamed from: okhttp3.ResponseBody$b */
    static final class C3540b extends Reader {

        /* renamed from: a */
        private final BufferedSource f20000a;

        /* renamed from: b */
        private final Charset f20001b;

        /* renamed from: c */
        private boolean f20002c;
        @Nullable

        /* renamed from: d */
        private Reader f20003d;

        C3540b(BufferedSource bufferedSource, Charset charset) {
            this.f20000a = bufferedSource;
            this.f20001b = charset;
        }

        public void close() {
            this.f20002c = true;
            Reader reader = this.f20003d;
            if (reader != null) {
                reader.close();
            } else {
                this.f20000a.close();
            }
        }

        public int read(char[] cArr, int i, int i2) {
            if (!this.f20002c) {
                Reader reader = this.f20003d;
                if (reader == null) {
                    InputStreamReader inputStreamReader = new InputStreamReader(this.f20000a.inputStream(), Util.bomAwareCharset(this.f20000a, this.f20001b));
                    this.f20003d = inputStreamReader;
                    reader = inputStreamReader;
                }
                return reader.read(cArr, i, i2);
            }
            throw new IOException("Stream closed");
        }
    }

    /* renamed from: a */
    private Charset m11980a() {
        MediaType contentType = contentType();
        return contentType != null ? contentType.charset(Util.UTF_8) : Util.UTF_8;
    }

    public static ResponseBody create(@Nullable MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null) {
            Charset charset2 = mediaType.charset();
            if (charset2 == null) {
                mediaType = MediaType.parse(mediaType + "; charset=utf-8");
            } else {
                charset = charset2;
            }
        }
        Buffer writeString = new Buffer().writeString(str, charset);
        return create(mediaType, writeString.size(), writeString);
    }

    public final InputStream byteStream() {
        return source().inputStream();
    }

    /* JADX INFO: finally extract failed */
    public final byte[] bytes() {
        long contentLength = contentLength();
        if (contentLength <= 2147483647L) {
            BufferedSource source = source();
            try {
                byte[] readByteArray = source.readByteArray();
                Util.closeQuietly((Closeable) source);
                if (contentLength == -1 || contentLength == ((long) readByteArray.length)) {
                    return readByteArray;
                }
                throw new IOException("Content-Length (" + contentLength + ") and stream length (" + readByteArray.length + ") disagree");
            } catch (Throwable th) {
                Util.closeQuietly((Closeable) source);
                throw th;
            }
        } else {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
    }

    public final Reader charStream() {
        Reader reader = this.f19996a;
        if (reader != null) {
            return reader;
        }
        C3540b bVar = new C3540b(source(), m11980a());
        this.f19996a = bVar;
        return bVar;
    }

    public void close() {
        Util.closeQuietly((Closeable) source());
    }

    public abstract long contentLength();

    @Nullable
    public abstract MediaType contentType();

    public abstract BufferedSource source();

    public final String string() {
        BufferedSource source = source();
        try {
            return source.readString(Util.bomAwareCharset(source, m11980a()));
        } finally {
            Util.closeQuietly((Closeable) source);
        }
    }

    public static ResponseBody create(@Nullable MediaType mediaType, byte[] bArr) {
        return create(mediaType, (long) bArr.length, new Buffer().write(bArr));
    }

    public static ResponseBody create(@Nullable MediaType mediaType, ByteString byteString) {
        return create(mediaType, (long) byteString.size(), new Buffer().write(byteString));
    }

    public static ResponseBody create(@Nullable MediaType mediaType, long j, BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            return new C3539a(mediaType, j, bufferedSource);
        }
        throw new NullPointerException("source == null");
    }
}
