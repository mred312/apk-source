package okhttp3;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;

public final class MultipartBody extends RequestBody {
    public static final MediaType ALTERNATIVE = MediaType.get("multipart/alternative");
    public static final MediaType DIGEST = MediaType.get("multipart/digest");
    public static final MediaType FORM = MediaType.get("multipart/form-data");
    public static final MediaType MIXED = MediaType.get("multipart/mixed");
    public static final MediaType PARALLEL = MediaType.get("multipart/parallel");

    /* renamed from: f */
    private static final byte[] f19881f = {58, 32};

    /* renamed from: g */
    private static final byte[] f19882g = {13, 10};

    /* renamed from: h */
    private static final byte[] f19883h = {45, 45};

    /* renamed from: a */
    private final ByteString f19884a;

    /* renamed from: b */
    private final MediaType f19885b;

    /* renamed from: c */
    private final MediaType f19886c;

    /* renamed from: d */
    private final List<Part> f19887d;

    /* renamed from: e */
    private long f19888e = -1;

    public static final class Builder {

        /* renamed from: a */
        private final ByteString f19889a;

        /* renamed from: b */
        private MediaType f19890b;

        /* renamed from: c */
        private final List<Part> f19891c;

        public Builder() {
            this(UUID.randomUUID().toString());
        }

        public Builder addFormDataPart(String str, String str2) {
            return addPart(Part.createFormData(str, str2));
        }

        public Builder addPart(RequestBody requestBody) {
            return addPart(Part.create(requestBody));
        }

        public MultipartBody build() {
            if (!this.f19891c.isEmpty()) {
                return new MultipartBody(this.f19889a, this.f19890b, this.f19891c);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }

        public Builder setType(MediaType mediaType) {
            if (mediaType == null) {
                throw new NullPointerException("type == null");
            } else if (mediaType.type().equals("multipart")) {
                this.f19890b = mediaType;
                return this;
            } else {
                throw new IllegalArgumentException("multipart != " + mediaType);
            }
        }

        public Builder(String str) {
            this.f19890b = MultipartBody.MIXED;
            this.f19891c = new ArrayList();
            this.f19889a = ByteString.encodeUtf8(str);
        }

        public Builder addFormDataPart(String str, @Nullable String str2, RequestBody requestBody) {
            return addPart(Part.createFormData(str, str2, requestBody));
        }

        public Builder addPart(@Nullable Headers headers, RequestBody requestBody) {
            return addPart(Part.create(headers, requestBody));
        }

        public Builder addPart(Part part) {
            if (part != null) {
                this.f19891c.add(part);
                return this;
            }
            throw new NullPointerException("part == null");
        }
    }

    public static final class Part {
        @Nullable

        /* renamed from: a */
        final Headers f19892a;

        /* renamed from: b */
        final RequestBody f19893b;

        private Part(@Nullable Headers headers, RequestBody requestBody) {
            this.f19892a = headers;
            this.f19893b = requestBody;
        }

        public static Part create(RequestBody requestBody) {
            return create((Headers) null, requestBody);
        }

        public static Part createFormData(String str, String str2) {
            return createFormData(str, (String) null, RequestBody.create((MediaType) null, str2));
        }

        public RequestBody body() {
            return this.f19893b;
        }

        @Nullable
        public Headers headers() {
            return this.f19892a;
        }

        public static Part create(@Nullable Headers headers, RequestBody requestBody) {
            if (requestBody == null) {
                throw new NullPointerException("body == null");
            } else if (headers != null && headers.get("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            } else if (headers == null || headers.get("Content-Length") == null) {
                return new Part(headers, requestBody);
            } else {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
        }

        public static Part createFormData(String str, @Nullable String str2, RequestBody requestBody) {
            if (str != null) {
                StringBuilder sb = new StringBuilder("form-data; name=");
                MultipartBody.m11973a(sb, str);
                if (str2 != null) {
                    sb.append("; filename=");
                    MultipartBody.m11973a(sb, str2);
                }
                return create(Headers.m11943of("Content-Disposition", sb.toString()), requestBody);
            }
            throw new NullPointerException("name == null");
        }
    }

    MultipartBody(ByteString byteString, MediaType mediaType, List<Part> list) {
        this.f19884a = byteString;
        this.f19885b = mediaType;
        this.f19886c = MediaType.get(mediaType + "; boundary=" + byteString.utf8());
        this.f19887d = Util.immutableList(list);
    }

    /* renamed from: a */
    static StringBuilder m11973a(StringBuilder sb, String str) {
        sb.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == 10) {
                sb.append("%0A");
            } else if (charAt == 13) {
                sb.append("%0D");
            } else if (charAt != '\"') {
                sb.append(charAt);
            } else {
                sb.append("%22");
            }
        }
        sb.append('\"');
        return sb;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: okio.Buffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: okio.Buffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: okio.Buffer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long m11974b(@javax.annotation.Nullable okio.BufferedSink r13, boolean r14) {
        /*
            r12 = this;
            if (r14 == 0) goto L_0x0009
            okio.Buffer r13 = new okio.Buffer
            r13.<init>()
            r0 = r13
            goto L_0x000a
        L_0x0009:
            r0 = 0
        L_0x000a:
            java.util.List<okhttp3.MultipartBody$Part> r1 = r12.f19887d
            int r1 = r1.size()
            r2 = 0
            r3 = 0
            r5 = 0
        L_0x0014:
            if (r5 >= r1) goto L_0x00a4
            java.util.List<okhttp3.MultipartBody$Part> r6 = r12.f19887d
            java.lang.Object r6 = r6.get(r5)
            okhttp3.MultipartBody$Part r6 = (okhttp3.MultipartBody.Part) r6
            okhttp3.Headers r7 = r6.f19892a
            okhttp3.RequestBody r6 = r6.f19893b
            byte[] r8 = f19883h
            r13.write((byte[]) r8)
            okio.ByteString r8 = r12.f19884a
            r13.write((okio.ByteString) r8)
            byte[] r8 = f19882g
            r13.write((byte[]) r8)
            if (r7 == 0) goto L_0x0058
            int r8 = r7.size()
            r9 = 0
        L_0x0038:
            if (r9 >= r8) goto L_0x0058
            java.lang.String r10 = r7.name(r9)
            okio.BufferedSink r10 = r13.writeUtf8(r10)
            byte[] r11 = f19881f
            okio.BufferedSink r10 = r10.write((byte[]) r11)
            java.lang.String r11 = r7.value(r9)
            okio.BufferedSink r10 = r10.writeUtf8(r11)
            byte[] r11 = f19882g
            r10.write((byte[]) r11)
            int r9 = r9 + 1
            goto L_0x0038
        L_0x0058:
            okhttp3.MediaType r7 = r6.contentType()
            if (r7 == 0) goto L_0x0071
            java.lang.String r8 = "Content-Type: "
            okio.BufferedSink r8 = r13.writeUtf8(r8)
            java.lang.String r7 = r7.toString()
            okio.BufferedSink r7 = r8.writeUtf8(r7)
            byte[] r8 = f19882g
            r7.write((byte[]) r8)
        L_0x0071:
            long r7 = r6.contentLength()
            r9 = -1
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x008b
            java.lang.String r9 = "Content-Length: "
            okio.BufferedSink r9 = r13.writeUtf8(r9)
            okio.BufferedSink r9 = r9.writeDecimalLong(r7)
            byte[] r10 = f19882g
            r9.write((byte[]) r10)
            goto L_0x0091
        L_0x008b:
            if (r14 == 0) goto L_0x0091
            r0.clear()
            return r9
        L_0x0091:
            byte[] r9 = f19882g
            r13.write((byte[]) r9)
            if (r14 == 0) goto L_0x009a
            long r3 = r3 + r7
            goto L_0x009d
        L_0x009a:
            r6.writeTo(r13)
        L_0x009d:
            r13.write((byte[]) r9)
            int r5 = r5 + 1
            goto L_0x0014
        L_0x00a4:
            byte[] r1 = f19883h
            r13.write((byte[]) r1)
            okio.ByteString r2 = r12.f19884a
            r13.write((okio.ByteString) r2)
            r13.write((byte[]) r1)
            byte[] r1 = f19882g
            r13.write((byte[]) r1)
            if (r14 == 0) goto L_0x00c0
            long r13 = r0.size()
            long r3 = r3 + r13
            r0.clear()
        L_0x00c0:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.MultipartBody.m11974b(okio.BufferedSink, boolean):long");
    }

    public String boundary() {
        return this.f19884a.utf8();
    }

    public long contentLength() {
        long j = this.f19888e;
        if (j != -1) {
            return j;
        }
        long b = m11974b((BufferedSink) null, true);
        this.f19888e = b;
        return b;
    }

    public MediaType contentType() {
        return this.f19886c;
    }

    public Part part(int i) {
        return this.f19887d.get(i);
    }

    public List<Part> parts() {
        return this.f19887d;
    }

    public int size() {
        return this.f19887d.size();
    }

    public MediaType type() {
        return this.f19885b;
    }

    public void writeTo(BufferedSink bufferedSink) {
        m11974b(bufferedSink, false);
    }
}
