package okhttp3;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;

public final class FormBody extends RequestBody {

    /* renamed from: c */
    private static final MediaType f19845c = MediaType.get("application/x-www-form-urlencoded");

    /* renamed from: a */
    private final List<String> f19846a;

    /* renamed from: b */
    private final List<String> f19847b;

    public static final class Builder {

        /* renamed from: a */
        private final List<String> f19848a;

        /* renamed from: b */
        private final List<String> f19849b;

        /* renamed from: c */
        private final Charset f19850c;

        public Builder() {
            this((Charset) null);
        }

        public Builder add(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str2 != null) {
                this.f19848a.add(HttpUrl.m11948c(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f19850c));
                this.f19849b.add(HttpUrl.m11948c(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f19850c));
                return this;
            } else {
                throw new NullPointerException("value == null");
            }
        }

        public Builder addEncoded(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str2 != null) {
                this.f19848a.add(HttpUrl.m11948c(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.f19850c));
                this.f19849b.add(HttpUrl.m11948c(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.f19850c));
                return this;
            } else {
                throw new NullPointerException("value == null");
            }
        }

        public FormBody build() {
            return new FormBody(this.f19848a, this.f19849b);
        }

        public Builder(Charset charset) {
            this.f19848a = new ArrayList();
            this.f19849b = new ArrayList();
            this.f19850c = charset;
        }
    }

    FormBody(List<String> list, List<String> list2) {
        this.f19846a = Util.immutableList(list);
        this.f19847b = Util.immutableList(list2);
    }

    /* renamed from: a */
    private long m11938a(@Nullable BufferedSink bufferedSink, boolean z) {
        Buffer buffer;
        if (z) {
            buffer = new Buffer();
        } else {
            buffer = bufferedSink.buffer();
        }
        int size = this.f19846a.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                buffer.writeByte(38);
            }
            buffer.writeUtf8(this.f19846a.get(i));
            buffer.writeByte(61);
            buffer.writeUtf8(this.f19847b.get(i));
        }
        if (!z) {
            return 0;
        }
        long size2 = buffer.size();
        buffer.clear();
        return size2;
    }

    public long contentLength() {
        return m11938a((BufferedSink) null, true);
    }

    public MediaType contentType() {
        return f19845c;
    }

    public String encodedName(int i) {
        return this.f19846a.get(i);
    }

    public String encodedValue(int i) {
        return this.f19847b.get(i);
    }

    public String name(int i) {
        return HttpUrl.m11953h(encodedName(i), true);
    }

    public int size() {
        return this.f19846a.size();
    }

    public String value(int i) {
        return HttpUrl.m11953h(encodedValue(i), true);
    }

    public void writeTo(BufferedSink bufferedSink) {
        m11938a(bufferedSink, false);
    }
}
