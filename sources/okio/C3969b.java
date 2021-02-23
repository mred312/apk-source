package okio;

import android.support.p000v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* renamed from: okio.b */
/* compiled from: RealBufferedSink */
final class C3969b implements BufferedSink {

    /* renamed from: a */
    public final Buffer f21388a = new Buffer();

    /* renamed from: b */
    public final Sink f21389b;

    /* renamed from: c */
    boolean f21390c;

    C3969b(Sink sink) {
        if (sink != null) {
            this.f21389b = sink;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    public Buffer buffer() {
        return this.f21388a;
    }

    public void close() {
        if (!this.f21390c) {
            try {
                Buffer buffer = this.f21388a;
                long j = buffer.f20194b;
                if (j > 0) {
                    this.f21389b.write(buffer, j);
                }
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.f21389b.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            this.f21390c = true;
            if (th != null) {
                C3972g.m14449f(th);
                throw null;
            }
        }
    }

    public BufferedSink emit() {
        if (!this.f21390c) {
            long size = this.f21388a.size();
            if (size > 0) {
                this.f21389b.write(this.f21388a, size);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink emitCompleteSegments() {
        if (!this.f21390c) {
            long completeSegmentByteCount = this.f21388a.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                this.f21389b.write(this.f21388a, completeSegmentByteCount);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public void flush() {
        if (!this.f21390c) {
            Buffer buffer = this.f21388a;
            long j = buffer.f20194b;
            if (j > 0) {
                this.f21389b.write(buffer, j);
            }
            this.f21389b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public boolean isOpen() {
        return !this.f21390c;
    }

    public OutputStream outputStream() {
        return new C3970a();
    }

    public Timeout timeout() {
        return this.f21389b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f21389b + ")";
    }

    public void write(Buffer buffer, long j) {
        if (!this.f21390c) {
            this.f21388a.write(buffer, j);
            emitCompleteSegments();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public long writeAll(Source source) {
        if (source != null) {
            long j = 0;
            while (true) {
                long read = source.read(this.f21388a, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
                if (read == -1) {
                    return j;
                }
                j += read;
                emitCompleteSegments();
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public BufferedSink writeByte(int i) {
        if (!this.f21390c) {
            this.f21388a.writeByte(i);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeDecimalLong(long j) {
        if (!this.f21390c) {
            this.f21388a.writeDecimalLong(j);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeHexadecimalUnsignedLong(long j) {
        if (!this.f21390c) {
            this.f21388a.writeHexadecimalUnsignedLong(j);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeInt(int i) {
        if (!this.f21390c) {
            this.f21388a.writeInt(i);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeIntLe(int i) {
        if (!this.f21390c) {
            this.f21388a.writeIntLe(i);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeLong(long j) {
        if (!this.f21390c) {
            this.f21388a.writeLong(j);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeLongLe(long j) {
        if (!this.f21390c) {
            this.f21388a.writeLongLe(j);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeShort(int i) {
        if (!this.f21390c) {
            this.f21388a.writeShort(i);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeShortLe(int i) {
        if (!this.f21390c) {
            this.f21388a.writeShortLe(i);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeString(String str, Charset charset) {
        if (!this.f21390c) {
            this.f21388a.writeString(str, charset);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeUtf8(String str) {
        if (!this.f21390c) {
            this.f21388a.writeUtf8(str);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeUtf8CodePoint(int i) {
        if (!this.f21390c) {
            this.f21388a.writeUtf8CodePoint(i);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: okio.b$a */
    /* compiled from: RealBufferedSink */
    class C3970a extends OutputStream {
        C3970a() {
        }

        public void close() {
            C3969b.this.close();
        }

        public void flush() {
            C3969b bVar = C3969b.this;
            if (!bVar.f21390c) {
                bVar.flush();
            }
        }

        public String toString() {
            return C3969b.this + ".outputStream()";
        }

        public void write(int i) {
            C3969b bVar = C3969b.this;
            if (!bVar.f21390c) {
                bVar.f21388a.writeByte((int) (byte) i);
                C3969b.this.emitCompleteSegments();
                return;
            }
            throw new IOException("closed");
        }

        public void write(byte[] bArr, int i, int i2) {
            C3969b bVar = C3969b.this;
            if (!bVar.f21390c) {
                bVar.f21388a.write(bArr, i, i2);
                C3969b.this.emitCompleteSegments();
                return;
            }
            throw new IOException("closed");
        }
    }

    public BufferedSink write(ByteString byteString) {
        if (!this.f21390c) {
            this.f21388a.write(byteString);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeString(String str, int i, int i2, Charset charset) {
        if (!this.f21390c) {
            this.f21388a.writeString(str, i, i2, charset);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeUtf8(String str, int i, int i2) {
        if (!this.f21390c) {
            this.f21388a.writeUtf8(str, i, i2);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink write(byte[] bArr) {
        if (!this.f21390c) {
            this.f21388a.write(bArr);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink write(byte[] bArr, int i, int i2) {
        if (!this.f21390c) {
            this.f21388a.write(bArr, i, i2);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public int write(ByteBuffer byteBuffer) {
        if (!this.f21390c) {
            int write = this.f21388a.write(byteBuffer);
            emitCompleteSegments();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink write(Source source, long j) {
        while (j > 0) {
            long read = source.read(this.f21388a, j);
            if (read != -1) {
                j -= read;
                emitCompleteSegments();
            } else {
                throw new EOFException();
            }
        }
        return this;
    }
}
