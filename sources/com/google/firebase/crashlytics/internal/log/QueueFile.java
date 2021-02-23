package com.google.firebase.crashlytics.internal.log;

import android.support.p000v4.media.session.PlaybackStateCompat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

class QueueFile implements Closeable {

    /* renamed from: g */
    private static final Logger f19214g = Logger.getLogger(QueueFile.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final RandomAccessFile f19215a;

    /* renamed from: b */
    int f19216b;

    /* renamed from: c */
    private int f19217c;

    /* renamed from: d */
    private C3340b f19218d;

    /* renamed from: e */
    private C3340b f19219e;

    /* renamed from: f */
    private final byte[] f19220f = new byte[16];

    public interface ElementReader {
        void read(InputStream inputStream, int i);
    }

    /* renamed from: com.google.firebase.crashlytics.internal.log.QueueFile$a */
    class C3339a implements ElementReader {

        /* renamed from: a */
        boolean f19221a = true;

        /* renamed from: b */
        final /* synthetic */ StringBuilder f19222b;

        C3339a(QueueFile queueFile, StringBuilder sb) {
            this.f19222b = sb;
        }

        public void read(InputStream inputStream, int i) {
            if (this.f19221a) {
                this.f19221a = false;
            } else {
                this.f19222b.append(", ");
            }
            this.f19222b.append(i);
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.log.QueueFile$b */
    static class C3340b {

        /* renamed from: c */
        static final C3340b f19223c = new C3340b(0, 0);

        /* renamed from: a */
        final int f19224a;

        /* renamed from: b */
        final int f19225b;

        C3340b(int i, int i2) {
            this.f19224a = i;
            this.f19225b = i2;
        }

        public String toString() {
            return C3340b.class.getSimpleName() + "[position = " + this.f19224a + ", length = " + this.f19225b + "]";
        }
    }

    /* renamed from: com.google.firebase.crashlytics.internal.log.QueueFile$c */
    private final class C3341c extends InputStream {

        /* renamed from: a */
        private int f19226a;

        /* renamed from: b */
        private int f19227b;

        /* synthetic */ C3341c(QueueFile queueFile, C3340b bVar, C3339a aVar) {
            this(bVar);
        }

        public int read(byte[] bArr, int i, int i2) {
            Object unused = QueueFile.m11496l(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = this.f19227b;
            if (i3 <= 0) {
                return -1;
            }
            if (i2 > i3) {
                i2 = i3;
            }
            QueueFile.this.m11502s(this.f19226a, bArr, i, i2);
            this.f19226a = QueueFile.this.m11505w(this.f19226a + i2);
            this.f19227b -= i2;
            return i2;
        }

        private C3341c(C3340b bVar) {
            this.f19226a = QueueFile.this.m11505w(bVar.f19224a + 4);
            this.f19227b = bVar.f19225b;
        }

        public int read() {
            if (this.f19227b == 0) {
                return -1;
            }
            QueueFile.this.f19215a.seek((long) this.f19226a);
            int read = QueueFile.this.f19215a.read();
            this.f19226a = QueueFile.this.m11505w(this.f19226a + 1);
            this.f19227b--;
            return read;
        }
    }

    public QueueFile(File file) {
        if (!file.exists()) {
            m11495j(file);
        }
        this.f19215a = m11497m(file);
        m11499o();
    }

    /* renamed from: h */
    private void m11494h(int i) {
        int i2 = i + 4;
        int q = m11501q();
        if (q < i2) {
            int i3 = this.f19216b;
            do {
                q += i3;
                i3 <<= 1;
            } while (q < i2);
            m11504u(i3);
            C3340b bVar = this.f19219e;
            int w = m11505w(bVar.f19224a + 4 + bVar.f19225b);
            if (w < this.f19218d.f19224a) {
                FileChannel channel = this.f19215a.getChannel();
                channel.position((long) this.f19216b);
                long j = (long) (w - 4);
                if (channel.transferTo(16, j, channel) != j) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            int i4 = this.f19219e.f19224a;
            int i5 = this.f19218d.f19224a;
            if (i4 < i5) {
                int i6 = (this.f19216b + i4) - 16;
                m11506x(i3, this.f19217c, i5, i6);
                this.f19219e = new C3340b(i6, this.f19219e.f19225b);
            } else {
                m11506x(i3, this.f19217c, i5, i4);
            }
            this.f19216b = i3;
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: j */
    private static void m11495j(File file) {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile m = m11497m(file2);
        try {
            m.setLength(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
            m.seek(0);
            byte[] bArr = new byte[16];
            m11508z(bArr, 4096, 0, 0, 0);
            m.write(bArr);
            m.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            m.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public static <T> T m11496l(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: m */
    private static RandomAccessFile m11497m(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    /* renamed from: n */
    private C3340b m11498n(int i) {
        if (i == 0) {
            return C3340b.f19223c;
        }
        this.f19215a.seek((long) i);
        return new C3340b(i, this.f19215a.readInt());
    }

    /* renamed from: o */
    private void m11499o() {
        this.f19215a.seek(0);
        this.f19215a.readFully(this.f19220f);
        int p = m11500p(this.f19220f, 0);
        this.f19216b = p;
        if (((long) p) <= this.f19215a.length()) {
            this.f19217c = m11500p(this.f19220f, 4);
            int p2 = m11500p(this.f19220f, 8);
            int p3 = m11500p(this.f19220f, 12);
            this.f19218d = m11498n(p2);
            this.f19219e = m11498n(p3);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.f19216b + ", Actual length: " + this.f19215a.length());
    }

    /* renamed from: p */
    private static int m11500p(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16) + ((bArr[i + 2] & 255) << 8) + (bArr[i + 3] & 255);
    }

    /* renamed from: q */
    private int m11501q() {
        return this.f19216b - mo21068v();
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m11502s(int i, byte[] bArr, int i2, int i3) {
        int w = m11505w(i);
        int i4 = w + i3;
        int i5 = this.f19216b;
        if (i4 <= i5) {
            this.f19215a.seek((long) w);
            this.f19215a.readFully(bArr, i2, i3);
            return;
        }
        int i6 = i5 - w;
        this.f19215a.seek((long) w);
        this.f19215a.readFully(bArr, i2, i6);
        this.f19215a.seek(16);
        this.f19215a.readFully(bArr, i2 + i6, i3 - i6);
    }

    /* renamed from: t */
    private void m11503t(int i, byte[] bArr, int i2, int i3) {
        int w = m11505w(i);
        int i4 = w + i3;
        int i5 = this.f19216b;
        if (i4 <= i5) {
            this.f19215a.seek((long) w);
            this.f19215a.write(bArr, i2, i3);
            return;
        }
        int i6 = i5 - w;
        this.f19215a.seek((long) w);
        this.f19215a.write(bArr, i2, i6);
        this.f19215a.seek(16);
        this.f19215a.write(bArr, i2 + i6, i3 - i6);
    }

    /* renamed from: u */
    private void m11504u(int i) {
        this.f19215a.setLength((long) i);
        this.f19215a.getChannel().force(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public int m11505w(int i) {
        int i2 = this.f19216b;
        return i < i2 ? i : (i + 16) - i2;
    }

    /* renamed from: x */
    private void m11506x(int i, int i2, int i3, int i4) {
        m11508z(this.f19220f, i, i2, i3, i4);
        this.f19215a.seek(0);
        this.f19215a.write(this.f19220f);
    }

    /* renamed from: y */
    private static void m11507y(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    /* renamed from: z */
    private static void m11508z(byte[] bArr, int... iArr) {
        int i = 0;
        for (int y : iArr) {
            m11507y(bArr, i, y);
            i += 4;
        }
    }

    public synchronized void close() {
        this.f19215a.close();
    }

    /* renamed from: e */
    public void mo21061e(byte[] bArr) {
        mo21062f(bArr, 0, bArr.length);
    }

    /* renamed from: f */
    public synchronized void mo21062f(byte[] bArr, int i, int i2) {
        int i3;
        m11496l(bArr, "buffer");
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        m11494h(i2);
        boolean k = mo21065k();
        if (k) {
            i3 = 16;
        } else {
            C3340b bVar = this.f19219e;
            i3 = m11505w(bVar.f19224a + 4 + bVar.f19225b);
        }
        C3340b bVar2 = new C3340b(i3, i2);
        m11507y(this.f19220f, 0, i2);
        m11503t(bVar2.f19224a, this.f19220f, 0, 4);
        m11503t(bVar2.f19224a + 4, bArr, i, i2);
        m11506x(this.f19216b, this.f19217c + 1, k ? bVar2.f19224a : this.f19218d.f19224a, bVar2.f19224a);
        this.f19219e = bVar2;
        this.f19217c++;
        if (k) {
            this.f19218d = bVar2;
        }
    }

    /* renamed from: g */
    public synchronized void mo21063g() {
        m11506x(4096, 0, 0, 0);
        this.f19217c = 0;
        C3340b bVar = C3340b.f19223c;
        this.f19218d = bVar;
        this.f19219e = bVar;
        if (this.f19216b > 4096) {
            m11504u(4096);
        }
        this.f19216b = 4096;
    }

    /* renamed from: i */
    public synchronized void mo21064i(ElementReader elementReader) {
        int i = this.f19218d.f19224a;
        for (int i2 = 0; i2 < this.f19217c; i2++) {
            C3340b n = m11498n(i);
            elementReader.read(new C3341c(this, n, (C3339a) null), n.f19225b);
            i = m11505w(n.f19224a + 4 + n.f19225b);
        }
    }

    /* renamed from: k */
    public synchronized boolean mo21065k() {
        return this.f19217c == 0;
    }

    /* renamed from: r */
    public synchronized void mo21066r() {
        if (mo21065k()) {
            throw new NoSuchElementException();
        } else if (this.f19217c == 1) {
            mo21063g();
        } else {
            C3340b bVar = this.f19218d;
            int w = m11505w(bVar.f19224a + 4 + bVar.f19225b);
            m11502s(w, this.f19220f, 0, 4);
            int p = m11500p(this.f19220f, 0);
            m11506x(this.f19216b, this.f19217c - 1, w, this.f19219e.f19224a);
            this.f19217c--;
            this.f19218d = new C3340b(w, p);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(QueueFile.class.getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.f19216b);
        sb.append(", size=");
        sb.append(this.f19217c);
        sb.append(", first=");
        sb.append(this.f19218d);
        sb.append(", last=");
        sb.append(this.f19219e);
        sb.append(", element lengths=[");
        try {
            mo21064i(new C3339a(this, sb));
        } catch (IOException e) {
            f19214g.log(Level.WARNING, "read error", e);
        }
        sb.append("]]");
        return sb.toString();
    }

    /* renamed from: v */
    public int mo21068v() {
        if (this.f19217c == 0) {
            return 16;
        }
        C3340b bVar = this.f19219e;
        int i = bVar.f19224a;
        int i2 = this.f19218d.f19224a;
        if (i >= i2) {
            return (i - i2) + 4 + bVar.f19225b + 16;
        }
        return (((i + 4) + bVar.f19225b) + this.f19216b) - i2;
    }
}
