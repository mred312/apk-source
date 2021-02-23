package com.bumptech.glide.load;

import androidx.annotation.Nullable;
import java.io.IOException;

public final class HttpException extends IOException {
    public static final int UNKNOWN = -1;
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private final int f5603a;

    public HttpException(int i) {
        this("Http request failed with status code: " + i, i);
    }

    public int getStatusCode() {
        return this.f5603a;
    }

    public HttpException(String str) {
        this(str, -1);
    }

    public HttpException(String str, int i) {
        this(str, i, (Throwable) null);
    }

    public HttpException(String str, int i, @Nullable Throwable th) {
        super(str, th);
        this.f5603a = i;
    }
}
