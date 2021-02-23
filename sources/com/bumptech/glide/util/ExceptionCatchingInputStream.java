package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public class ExceptionCatchingInputStream extends InputStream {

    /* renamed from: c */
    private static final Queue<ExceptionCatchingInputStream> f6496c = Util.createQueue(0);

    /* renamed from: a */
    private InputStream f6497a;

    /* renamed from: b */
    private IOException f6498b;

    ExceptionCatchingInputStream() {
    }

    @NonNull
    public static ExceptionCatchingInputStream obtain(@NonNull InputStream inputStream) {
        ExceptionCatchingInputStream poll;
        Queue<ExceptionCatchingInputStream> queue = f6496c;
        synchronized (queue) {
            poll = queue.poll();
        }
        if (poll == null) {
            poll = new ExceptionCatchingInputStream();
        }
        poll.mo10240a(inputStream);
        return poll;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10240a(@NonNull InputStream inputStream) {
        this.f6497a = inputStream;
    }

    public int available() {
        return this.f6497a.available();
    }

    public void close() {
        this.f6497a.close();
    }

    @Nullable
    public IOException getException() {
        return this.f6498b;
    }

    public void mark(int i) {
        this.f6497a.mark(i);
    }

    public boolean markSupported() {
        return this.f6497a.markSupported();
    }

    public int read(byte[] bArr) {
        try {
            return this.f6497a.read(bArr);
        } catch (IOException e) {
            this.f6498b = e;
            return -1;
        }
    }

    public void release() {
        this.f6498b = null;
        this.f6497a = null;
        Queue<ExceptionCatchingInputStream> queue = f6496c;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    public synchronized void reset() {
        this.f6497a.reset();
    }

    public long skip(long j) {
        try {
            return this.f6497a.skip(j);
        } catch (IOException e) {
            this.f6498b = e;
            return 0;
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.f6497a.read(bArr, i, i2);
        } catch (IOException e) {
            this.f6498b = e;
            return -1;
        }
    }

    public int read() {
        try {
            return this.f6497a.read();
        } catch (IOException e) {
            this.f6498b = e;
            return -1;
        }
    }
}
