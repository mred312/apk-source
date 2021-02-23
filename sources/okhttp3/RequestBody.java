package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import okio.Source;

public abstract class RequestBody {

    /* renamed from: okhttp3.RequestBody$a */
    class C3536a extends RequestBody {

        /* renamed from: a */
        final /* synthetic */ MediaType f19963a;

        /* renamed from: b */
        final /* synthetic */ ByteString f19964b;

        C3536a(MediaType mediaType, ByteString byteString) {
            this.f19963a = mediaType;
            this.f19964b = byteString;
        }

        public long contentLength() {
            return (long) this.f19964b.size();
        }

        @Nullable
        public MediaType contentType() {
            return this.f19963a;
        }

        public void writeTo(BufferedSink bufferedSink) {
            bufferedSink.write(this.f19964b);
        }
    }

    /* renamed from: okhttp3.RequestBody$b */
    class C3537b extends RequestBody {

        /* renamed from: a */
        final /* synthetic */ MediaType f19965a;

        /* renamed from: b */
        final /* synthetic */ int f19966b;

        /* renamed from: c */
        final /* synthetic */ byte[] f19967c;

        /* renamed from: d */
        final /* synthetic */ int f19968d;

        C3537b(MediaType mediaType, int i, byte[] bArr, int i2) {
            this.f19965a = mediaType;
            this.f19966b = i;
            this.f19967c = bArr;
            this.f19968d = i2;
        }

        public long contentLength() {
            return (long) this.f19966b;
        }

        @Nullable
        public MediaType contentType() {
            return this.f19965a;
        }

        public void writeTo(BufferedSink bufferedSink) {
            bufferedSink.write(this.f19967c, this.f19968d, this.f19966b);
        }
    }

    /* renamed from: okhttp3.RequestBody$c */
    class C3538c extends RequestBody {

        /* renamed from: a */
        final /* synthetic */ MediaType f19969a;

        /* renamed from: b */
        final /* synthetic */ File f19970b;

        C3538c(MediaType mediaType, File file) {
            this.f19969a = mediaType;
            this.f19970b = file;
        }

        public long contentLength() {
            return this.f19970b.length();
        }

        @Nullable
        public MediaType contentType() {
            return this.f19969a;
        }

        public void writeTo(BufferedSink bufferedSink) {
            Source source = null;
            try {
                source = Okio.source(this.f19970b);
                bufferedSink.writeAll(source);
            } finally {
                Util.closeQuietly((Closeable) source);
            }
        }
    }

    public static RequestBody create(@Nullable MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null) {
            Charset charset2 = mediaType.charset();
            if (charset2 == null) {
                mediaType = MediaType.parse(mediaType + "; charset=utf-8");
            } else {
                charset = charset2;
            }
        }
        return create(mediaType, str.getBytes(charset));
    }

    public long contentLength() {
        return -1;
    }

    @Nullable
    public abstract MediaType contentType();

    public abstract void writeTo(BufferedSink bufferedSink);

    public static RequestBody create(@Nullable MediaType mediaType, ByteString byteString) {
        return new C3536a(mediaType, byteString);
    }

    public static RequestBody create(@Nullable MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(@Nullable MediaType mediaType, byte[] bArr, int i, int i2) {
        if (bArr != null) {
            Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
            return new C3537b(mediaType, i2, bArr, i);
        }
        throw new NullPointerException("content == null");
    }

    public static RequestBody create(@Nullable MediaType mediaType, File file) {
        if (file != null) {
            return new C3538c(mediaType, file);
        }
        throw new NullPointerException("file == null");
    }
}
