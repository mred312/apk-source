package com.bumptech.glide.util;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ContentLengthInputStream extends FilterInputStream {

    /* renamed from: a */
    private final long f6494a;

    /* renamed from: b */
    private int f6495b;

    private ContentLengthInputStream(@NonNull InputStream inputStream, long j) {
        super(inputStream);
        this.f6494a = j;
    }

    /* renamed from: a */
    private int m4759a(int i) {
        if (i >= 0) {
            this.f6495b += i;
        } else if (this.f6494a - ((long) this.f6495b) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f6494a + ", but read: " + this.f6495b);
        }
        return i;
    }

    /* renamed from: b */
    private static int m4760b(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                if (Log.isLoggable("ContentLengthStream", 3)) {
                    Log.d("ContentLengthStream", "failed to parse content length header: " + str, e);
                }
            }
        }
        return -1;
    }

    @NonNull
    public static InputStream obtain(@NonNull InputStream inputStream, @Nullable String str) {
        return obtain(inputStream, (long) m4760b(str));
    }

    public synchronized int available() {
        return (int) Math.max(this.f6494a - ((long) this.f6495b), (long) this.in.available());
    }

    public synchronized int read() {
        int read;
        read = super.read();
        m4759a(read >= 0 ? 1 : -1);
        return read;
    }

    @NonNull
    public static InputStream obtain(@NonNull InputStream inputStream, long j) {
        return new ContentLengthInputStream(inputStream, j);
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public synchronized int read(byte[] bArr, int i, int i2) {
        int read;
        read = super.read(bArr, i, i2);
        m4759a(read);
        return read;
    }
}
