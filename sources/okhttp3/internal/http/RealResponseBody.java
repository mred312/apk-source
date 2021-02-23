package okhttp3.internal.http;

import javax.annotation.Nullable;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

public final class RealResponseBody extends ResponseBody {
    @Nullable

    /* renamed from: b */
    private final String f20097b;

    /* renamed from: c */
    private final long f20098c;

    /* renamed from: d */
    private final BufferedSource f20099d;

    public RealResponseBody(@Nullable String str, long j, BufferedSource bufferedSource) {
        this.f20097b = str;
        this.f20098c = j;
        this.f20099d = bufferedSource;
    }

    public long contentLength() {
        return this.f20098c;
    }

    public MediaType contentType() {
        String str = this.f20097b;
        if (str != null) {
            return MediaType.parse(str);
        }
        return null;
    }

    public BufferedSource source() {
        return this.f20099d;
    }
}
