package okhttp3.internal.http2;

import android.support.p000v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Header;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http2Stream {

    /* renamed from: a */
    long f20100a = 0;

    /* renamed from: b */
    long f20101b;

    /* renamed from: c */
    final int f20102c;

    /* renamed from: d */
    final Http2Connection f20103d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Deque<Headers> f20104e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Header.C3936a f20105f;

    /* renamed from: g */
    private boolean f20106g;

    /* renamed from: h */
    private final C3554b f20107h;

    /* renamed from: i */
    final C3553a f20108i;

    /* renamed from: j */
    final C3555c f20109j;

    /* renamed from: k */
    final C3555c f20110k;

    /* renamed from: l */
    ErrorCode f20111l;

    /* renamed from: okhttp3.internal.http2.Http2Stream$a */
    final class C3553a implements Sink {

        /* renamed from: a */
        private final Buffer f20112a = new Buffer();

        /* renamed from: b */
        boolean f20113b;

        /* renamed from: c */
        boolean f20114c;

        C3553a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            r1.f20110k.mo22365g();
            r11.f20115d.mo22341e();
            r9 = java.lang.Math.min(r11.f20115d.f20101b, r11.f20112a.size());
            r1 = r11.f20115d;
            r1.f20101b -= r9;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m12042a(boolean r12) {
            /*
                r11 = this;
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                monitor-enter(r0)
                okhttp3.internal.http2.Http2Stream r1 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x007f }
                okhttp3.internal.http2.Http2Stream$c r1 = r1.f20110k     // Catch:{ all -> 0x007f }
                r1.enter()     // Catch:{ all -> 0x007f }
            L_0x000a:
                okhttp3.internal.http2.Http2Stream r1 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x0076 }
                long r2 = r1.f20101b     // Catch:{ all -> 0x0076 }
                r4 = 0
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 > 0) goto L_0x0024
                boolean r2 = r11.f20114c     // Catch:{ all -> 0x0076 }
                if (r2 != 0) goto L_0x0024
                boolean r2 = r11.f20113b     // Catch:{ all -> 0x0076 }
                if (r2 != 0) goto L_0x0024
                okhttp3.internal.http2.ErrorCode r2 = r1.f20111l     // Catch:{ all -> 0x0076 }
                if (r2 != 0) goto L_0x0024
                r1.mo22353k()     // Catch:{ all -> 0x0076 }
                goto L_0x000a
            L_0x0024:
                okhttp3.internal.http2.Http2Stream$c r1 = r1.f20110k     // Catch:{ all -> 0x007f }
                r1.mo22365g()     // Catch:{ all -> 0x007f }
                okhttp3.internal.http2.Http2Stream r1 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x007f }
                r1.mo22341e()     // Catch:{ all -> 0x007f }
                okhttp3.internal.http2.Http2Stream r1 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x007f }
                long r1 = r1.f20101b     // Catch:{ all -> 0x007f }
                okio.Buffer r3 = r11.f20112a     // Catch:{ all -> 0x007f }
                long r3 = r3.size()     // Catch:{ all -> 0x007f }
                long r9 = java.lang.Math.min(r1, r3)     // Catch:{ all -> 0x007f }
                okhttp3.internal.http2.Http2Stream r1 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x007f }
                long r2 = r1.f20101b     // Catch:{ all -> 0x007f }
                long r2 = r2 - r9
                r1.f20101b = r2     // Catch:{ all -> 0x007f }
                monitor-exit(r0)     // Catch:{ all -> 0x007f }
                okhttp3.internal.http2.Http2Stream$c r0 = r1.f20110k
                r0.enter()
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x006d }
                okhttp3.internal.http2.Http2Connection r5 = r0.f20103d     // Catch:{ all -> 0x006d }
                int r6 = r0.f20102c     // Catch:{ all -> 0x006d }
                if (r12 == 0) goto L_0x005e
                okio.Buffer r12 = r11.f20112a     // Catch:{ all -> 0x006d }
                long r0 = r12.size()     // Catch:{ all -> 0x006d }
                int r12 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r12 != 0) goto L_0x005e
                r12 = 1
                r7 = 1
                goto L_0x0060
            L_0x005e:
                r12 = 0
                r7 = 0
            L_0x0060:
                okio.Buffer r8 = r11.f20112a     // Catch:{ all -> 0x006d }
                r5.writeData(r6, r7, r8, r9)     // Catch:{ all -> 0x006d }
                okhttp3.internal.http2.Http2Stream r12 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Stream$c r12 = r12.f20110k
                r12.mo22365g()
                return
            L_0x006d:
                r12 = move-exception
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Stream$c r0 = r0.f20110k
                r0.mo22365g()
                throw r12
            L_0x0076:
                r12 = move-exception
                okhttp3.internal.http2.Http2Stream r1 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x007f }
                okhttp3.internal.http2.Http2Stream$c r1 = r1.f20110k     // Catch:{ all -> 0x007f }
                r1.mo22365g()     // Catch:{ all -> 0x007f }
                throw r12     // Catch:{ all -> 0x007f }
            L_0x007f:
                r12 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x007f }
                goto L_0x0083
            L_0x0082:
                throw r12
            L_0x0083:
                goto L_0x0082
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.C3553a.m12042a(boolean):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
            if (r8.f20112a.size() <= 0) goto L_0x002d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
            if (r8.f20112a.size() <= 0) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
            m12042a(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
            r0 = r8.f20115d;
            r0.f20103d.writeData(r0.f20102c, true, (okio.Buffer) null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
            r2 = r8.f20115d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r8.f20113b = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003f, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
            r8.f20115d.f20103d.flush();
            r8.f20115d.mo22340d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x004c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
            if (r8.f20115d.f20108i.f20114c != false) goto L_0x003a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() {
            /*
                r8 = this;
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                monitor-enter(r0)
                boolean r1 = r8.f20113b     // Catch:{ all -> 0x0050 }
                if (r1 == 0) goto L_0x0009
                monitor-exit(r0)     // Catch:{ all -> 0x0050 }
                return
            L_0x0009:
                monitor-exit(r0)     // Catch:{ all -> 0x0050 }
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Stream$a r0 = r0.f20108i
                boolean r0 = r0.f20114c
                r1 = 1
                if (r0 != 0) goto L_0x003a
                okio.Buffer r0 = r8.f20112a
                long r2 = r0.size()
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x002d
            L_0x001f:
                okio.Buffer r0 = r8.f20112a
                long r2 = r0.size()
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x003a
                r8.m12042a(r1)
                goto L_0x001f
            L_0x002d:
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Connection r2 = r0.f20103d
                int r3 = r0.f20102c
                r4 = 1
                r5 = 0
                r6 = 0
                r2.writeData(r3, r4, r5, r6)
            L_0x003a:
                okhttp3.internal.http2.Http2Stream r2 = okhttp3.internal.http2.Http2Stream.this
                monitor-enter(r2)
                r8.f20113b = r1     // Catch:{ all -> 0x004d }
                monitor-exit(r2)     // Catch:{ all -> 0x004d }
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Connection r0 = r0.f20103d
                r0.flush()
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                r0.mo22340d()
                return
            L_0x004d:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x004d }
                throw r0
            L_0x0050:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0050 }
                goto L_0x0054
            L_0x0053:
                throw r1
            L_0x0054:
                goto L_0x0053
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.C3553a.close():void");
        }

        public void flush() {
            synchronized (Http2Stream.this) {
                Http2Stream.this.mo22341e();
            }
            while (this.f20112a.size() > 0) {
                m12042a(false);
                Http2Stream.this.f20103d.flush();
            }
        }

        public Timeout timeout() {
            return Http2Stream.this.f20110k;
        }

        public void write(Buffer buffer, long j) {
            this.f20112a.write(buffer, j);
            while (this.f20112a.size() >= PlaybackStateCompat.ACTION_PREPARE) {
                m12042a(false);
            }
        }
    }

    /* renamed from: okhttp3.internal.http2.Http2Stream$b */
    private final class C3554b implements Source {

        /* renamed from: a */
        private final Buffer f20116a = new Buffer();

        /* renamed from: b */
        private final Buffer f20117b = new Buffer();

        /* renamed from: c */
        private final long f20118c;

        /* renamed from: d */
        boolean f20119d;

        /* renamed from: e */
        boolean f20120e;

        C3554b(long j) {
            this.f20118c = j;
        }

        /* renamed from: b */
        private void m12043b(long j) {
            Http2Stream.this.f20103d.mo25053q(j);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo22362a(BufferedSource bufferedSource, long j) {
            boolean z;
            boolean z2;
            boolean z3;
            while (j > 0) {
                synchronized (Http2Stream.this) {
                    z = this.f20120e;
                    z2 = true;
                    z3 = this.f20117b.size() + j > this.f20118c;
                }
                if (z3) {
                    bufferedSource.skip(j);
                    Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    bufferedSource.skip(j);
                    return;
                } else {
                    long read = bufferedSource.read(this.f20116a, j);
                    if (read != -1) {
                        j -= read;
                        synchronized (Http2Stream.this) {
                            if (this.f20117b.size() != 0) {
                                z2 = false;
                            }
                            this.f20117b.writeAll(this.f20116a);
                            if (z2) {
                                Http2Stream.this.notifyAll();
                            }
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        public void close() {
            long size;
            Header.C3936a aVar;
            ArrayList<Headers> arrayList;
            synchronized (Http2Stream.this) {
                this.f20119d = true;
                size = this.f20117b.size();
                this.f20117b.clear();
                aVar = null;
                if (Http2Stream.this.f20104e.isEmpty() || Http2Stream.this.f20105f == null) {
                    arrayList = null;
                } else {
                    ArrayList arrayList2 = new ArrayList(Http2Stream.this.f20104e);
                    Http2Stream.this.f20104e.clear();
                    ArrayList arrayList3 = arrayList2;
                    aVar = Http2Stream.this.f20105f;
                    arrayList = arrayList3;
                }
                Http2Stream.this.notifyAll();
            }
            if (size > 0) {
                m12043b(size);
            }
            Http2Stream.this.mo22340d();
            if (aVar != null) {
                for (Headers a : arrayList) {
                    aVar.mo25035a(a);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v33, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: okhttp3.Headers} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long read(okio.Buffer r17, long r18) {
            /*
                r16 = this;
                r1 = r16
                r2 = r18
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 < 0) goto L_0x00e0
            L_0x000a:
                okhttp3.internal.http2.Http2Stream r6 = okhttp3.internal.http2.Http2Stream.this
                monitor-enter(r6)
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x00dd }
                okhttp3.internal.http2.Http2Stream$c r0 = r0.f20109j     // Catch:{ all -> 0x00dd }
                r0.enter()     // Catch:{ all -> 0x00dd }
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x00d4 }
                okhttp3.internal.http2.ErrorCode r7 = r0.f20111l     // Catch:{ all -> 0x00d4 }
                if (r7 == 0) goto L_0x001b
                goto L_0x001c
            L_0x001b:
                r7 = 0
            L_0x001c:
                boolean r9 = r1.f20119d     // Catch:{ all -> 0x00d4 }
                if (r9 != 0) goto L_0x00cc
                java.util.Deque r0 = r0.f20104e     // Catch:{ all -> 0x00d4 }
                boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x00d4 }
                if (r0 != 0) goto L_0x0049
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x00d4 }
                okhttp3.internal.http2.Header$a r0 = r0.f20105f     // Catch:{ all -> 0x00d4 }
                if (r0 == 0) goto L_0x0049
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x00d4 }
                java.util.Deque r0 = r0.f20104e     // Catch:{ all -> 0x00d4 }
                java.lang.Object r0 = r0.removeFirst()     // Catch:{ all -> 0x00d4 }
                r8 = r0
                okhttp3.Headers r8 = (okhttp3.Headers) r8     // Catch:{ all -> 0x00d4 }
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x00d4 }
                okhttp3.internal.http2.Header$a r0 = r0.f20105f     // Catch:{ all -> 0x00d4 }
                r13 = r17
                r10 = r0
                goto L_0x00a6
            L_0x0049:
                okio.Buffer r0 = r1.f20117b     // Catch:{ all -> 0x00d4 }
                long r11 = r0.size()     // Catch:{ all -> 0x00d4 }
                int r0 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x008d
                okio.Buffer r0 = r1.f20117b     // Catch:{ all -> 0x00d4 }
                long r11 = r0.size()     // Catch:{ all -> 0x00d4 }
                long r11 = java.lang.Math.min(r2, r11)     // Catch:{ all -> 0x00d4 }
                r13 = r17
                long r11 = r0.read(r13, r11)     // Catch:{ all -> 0x00d4 }
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x00d4 }
                long r14 = r0.f20100a     // Catch:{ all -> 0x00d4 }
                long r14 = r14 + r11
                r0.f20100a = r14     // Catch:{ all -> 0x00d4 }
                if (r7 != 0) goto L_0x008a
                okhttp3.internal.http2.Http2Connection r0 = r0.f20103d     // Catch:{ all -> 0x00d4 }
                okhttp3.internal.http2.Settings r0 = r0.f21215n     // Catch:{ all -> 0x00d4 }
                int r0 = r0.mo25086d()     // Catch:{ all -> 0x00d4 }
                int r0 = r0 / 2
                long r8 = (long) r0     // Catch:{ all -> 0x00d4 }
                int r0 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
                if (r0 < 0) goto L_0x008a
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x00d4 }
                okhttp3.internal.http2.Http2Connection r8 = r0.f20103d     // Catch:{ all -> 0x00d4 }
                int r9 = r0.f20102c     // Catch:{ all -> 0x00d4 }
                long r14 = r0.f20100a     // Catch:{ all -> 0x00d4 }
                r8.mo25061v(r9, r14)     // Catch:{ all -> 0x00d4 }
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x00d4 }
                r0.f20100a = r4     // Catch:{ all -> 0x00d4 }
            L_0x008a:
                r8 = 0
                r10 = 0
                goto L_0x00a8
            L_0x008d:
                r13 = r17
                boolean r0 = r1.f20120e     // Catch:{ all -> 0x00d4 }
                if (r0 != 0) goto L_0x00a4
                if (r7 != 0) goto L_0x00a4
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x00d4 }
                r0.mo22353k()     // Catch:{ all -> 0x00d4 }
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x00dd }
                okhttp3.internal.http2.Http2Stream$c r0 = r0.f20109j     // Catch:{ all -> 0x00dd }
                r0.mo22365g()     // Catch:{ all -> 0x00dd }
                monitor-exit(r6)     // Catch:{ all -> 0x00dd }
                goto L_0x000a
            L_0x00a4:
                r8 = 0
                r10 = 0
            L_0x00a6:
                r11 = -1
            L_0x00a8:
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x00dd }
                okhttp3.internal.http2.Http2Stream$c r0 = r0.f20109j     // Catch:{ all -> 0x00dd }
                r0.mo22365g()     // Catch:{ all -> 0x00dd }
                monitor-exit(r6)     // Catch:{ all -> 0x00dd }
                if (r8 == 0) goto L_0x00b9
                if (r10 == 0) goto L_0x00b9
                r10.mo25035a(r8)
                goto L_0x000a
            L_0x00b9:
                r2 = -1
                int r0 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
                if (r0 == 0) goto L_0x00c3
                r1.m12043b(r11)
                return r11
            L_0x00c3:
                if (r7 != 0) goto L_0x00c6
                return r2
            L_0x00c6:
                okhttp3.internal.http2.StreamResetException r0 = new okhttp3.internal.http2.StreamResetException
                r0.<init>(r7)
                throw r0
            L_0x00cc:
                java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00d4 }
                java.lang.String r2 = "stream closed"
                r0.<init>(r2)     // Catch:{ all -> 0x00d4 }
                throw r0     // Catch:{ all -> 0x00d4 }
            L_0x00d4:
                r0 = move-exception
                okhttp3.internal.http2.Http2Stream r2 = okhttp3.internal.http2.Http2Stream.this     // Catch:{ all -> 0x00dd }
                okhttp3.internal.http2.Http2Stream$c r2 = r2.f20109j     // Catch:{ all -> 0x00dd }
                r2.mo22365g()     // Catch:{ all -> 0x00dd }
                throw r0     // Catch:{ all -> 0x00dd }
            L_0x00dd:
                r0 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x00dd }
                throw r0
            L_0x00e0:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "byteCount < 0: "
                r4.append(r5)
                r4.append(r2)
                java.lang.String r2 = r4.toString()
                r0.<init>(r2)
                goto L_0x00f8
            L_0x00f7:
                throw r0
            L_0x00f8:
                goto L_0x00f7
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.C3554b.read(okio.Buffer, long):long");
        }

        public Timeout timeout() {
            return Http2Stream.this.f20109j;
        }
    }

    /* renamed from: okhttp3.internal.http2.Http2Stream$c */
    class C3555c extends AsyncTimeout {
        C3555c() {
        }

        /* renamed from: g */
        public void mo22365g() {
            if (exit()) {
                throw newTimeoutException((IOException) null);
            }
        }

        /* access modifiers changed from: protected */
        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* access modifiers changed from: protected */
        public void timedOut() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
        }
    }

    Http2Stream(int i, Http2Connection http2Connection, boolean z, boolean z2, @Nullable Headers headers) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f20104e = arrayDeque;
        this.f20109j = new C3555c();
        this.f20110k = new C3555c();
        this.f20111l = null;
        if (http2Connection != null) {
            this.f20102c = i;
            this.f20103d = http2Connection;
            this.f20101b = (long) http2Connection.f21216o.mo25086d();
            C3554b bVar = new C3554b((long) http2Connection.f21215n.mo25086d());
            this.f20107h = bVar;
            C3553a aVar = new C3553a();
            this.f20108i = aVar;
            bVar.f20120e = z2;
            aVar.f20114c = z;
            if (headers != null) {
                arrayDeque.add(headers);
            }
            if (isLocallyInitiated() && headers != null) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            } else if (!isLocallyInitiated() && headers == null) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            throw new NullPointerException("connection == null");
        }
    }

    /* renamed from: f */
    private boolean m12033f(ErrorCode errorCode) {
        synchronized (this) {
            if (this.f20111l != null) {
                return false;
            }
            if (this.f20107h.f20120e && this.f20108i.f20114c) {
                return false;
            }
            this.f20111l = errorCode;
            notifyAll();
            this.f20103d.mo25049o(this.f20102c);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo22337c(long j) {
        this.f20101b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void close(ErrorCode errorCode) {
        if (m12033f(errorCode)) {
            this.f20103d.mo25059t(this.f20102c, errorCode);
        }
    }

    public void closeLater(ErrorCode errorCode) {
        if (m12033f(errorCode)) {
            this.f20103d.mo25060u(this.f20102c, errorCode);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo22340d() {
        boolean z;
        boolean isOpen;
        synchronized (this) {
            C3554b bVar = this.f20107h;
            if (!bVar.f20120e && bVar.f20119d) {
                C3553a aVar = this.f20108i;
                if (aVar.f20114c || aVar.f20113b) {
                    z = true;
                    isOpen = isOpen();
                }
            }
            z = false;
            isOpen = isOpen();
        }
        if (z) {
            close(ErrorCode.CANCEL);
        } else if (!isOpen) {
            this.f20103d.mo25049o(this.f20102c);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo22341e() {
        C3553a aVar = this.f20108i;
        if (aVar.f20113b) {
            throw new IOException("stream closed");
        } else if (aVar.f20114c) {
            throw new IOException("stream finished");
        } else if (this.f20111l != null) {
            throw new StreamResetException(this.f20111l);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo22342g(BufferedSource bufferedSource, int i) {
        this.f20107h.mo22362a(bufferedSource, (long) i);
    }

    public Http2Connection getConnection() {
        return this.f20103d;
    }

    public synchronized ErrorCode getErrorCode() {
        return this.f20111l;
    }

    public int getId() {
        return this.f20102c;
    }

    public Sink getSink() {
        synchronized (this) {
            if (!this.f20106g) {
                if (!isLocallyInitiated()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
        }
        return this.f20108i;
    }

    public Source getSource() {
        return this.f20107h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo22348h() {
        boolean isOpen;
        synchronized (this) {
            this.f20107h.f20120e = true;
            isOpen = isOpen();
            notifyAll();
        }
        if (!isOpen) {
            this.f20103d.mo25049o(this.f20102c);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo22349i(List<Header> list) {
        boolean isOpen;
        synchronized (this) {
            this.f20106g = true;
            this.f20104e.add(Util.toHeaders(list));
            isOpen = isOpen();
            notifyAll();
        }
        if (!isOpen) {
            this.f20103d.mo25049o(this.f20102c);
        }
    }

    public boolean isLocallyInitiated() {
        if (this.f20103d.f21202a == ((this.f20102c & 1) == 1)) {
            return true;
        }
        return false;
    }

    public synchronized boolean isOpen() {
        if (this.f20111l != null) {
            return false;
        }
        C3554b bVar = this.f20107h;
        if (bVar.f20120e || bVar.f20119d) {
            C3553a aVar = this.f20108i;
            if ((aVar.f20114c || aVar.f20113b) && this.f20106g) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public synchronized void mo22352j(ErrorCode errorCode) {
        if (this.f20111l == null) {
            this.f20111l = errorCode;
            notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo22353k() {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public Timeout readTimeout() {
        return this.f20109j;
    }

    public synchronized void setHeadersListener(Header.C3936a aVar) {
        this.f20105f = aVar;
        if (!this.f20104e.isEmpty() && aVar != null) {
            notifyAll();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
        r2.f20109j.mo22365g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized okhttp3.Headers takeHeaders() {
        /*
            r2 = this;
            monitor-enter(r2)
            okhttp3.internal.http2.Http2Stream$c r0 = r2.f20109j     // Catch:{ all -> 0x003c }
            r0.enter()     // Catch:{ all -> 0x003c }
        L_0x0006:
            java.util.Deque<okhttp3.Headers> r0 = r2.f20104e     // Catch:{ all -> 0x0035 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0016
            okhttp3.internal.http2.ErrorCode r0 = r2.f20111l     // Catch:{ all -> 0x0035 }
            if (r0 != 0) goto L_0x0016
            r2.mo22353k()     // Catch:{ all -> 0x0035 }
            goto L_0x0006
        L_0x0016:
            okhttp3.internal.http2.Http2Stream$c r0 = r2.f20109j     // Catch:{ all -> 0x003c }
            r0.mo22365g()     // Catch:{ all -> 0x003c }
            java.util.Deque<okhttp3.Headers> r0 = r2.f20104e     // Catch:{ all -> 0x003c }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x003c }
            if (r0 != 0) goto L_0x002d
            java.util.Deque<okhttp3.Headers> r0 = r2.f20104e     // Catch:{ all -> 0x003c }
            java.lang.Object r0 = r0.removeFirst()     // Catch:{ all -> 0x003c }
            okhttp3.Headers r0 = (okhttp3.Headers) r0     // Catch:{ all -> 0x003c }
            monitor-exit(r2)
            return r0
        L_0x002d:
            okhttp3.internal.http2.StreamResetException r0 = new okhttp3.internal.http2.StreamResetException     // Catch:{ all -> 0x003c }
            okhttp3.internal.http2.ErrorCode r1 = r2.f20111l     // Catch:{ all -> 0x003c }
            r0.<init>(r1)     // Catch:{ all -> 0x003c }
            throw r0     // Catch:{ all -> 0x003c }
        L_0x0035:
            r0 = move-exception
            okhttp3.internal.http2.Http2Stream$c r1 = r2.f20109j     // Catch:{ all -> 0x003c }
            r1.mo22365g()     // Catch:{ all -> 0x003c }
            throw r0     // Catch:{ all -> 0x003c }
        L_0x003c:
            r0 = move-exception
            monitor-exit(r2)
            goto L_0x0040
        L_0x003f:
            throw r0
        L_0x0040:
            goto L_0x003f
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.takeHeaders():okhttp3.Headers");
    }

    public void writeHeaders(List<Header> list, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (list != null) {
            synchronized (this) {
                z2 = true;
                this.f20106g = true;
                if (!z) {
                    this.f20108i.f20114c = true;
                    z3 = true;
                    z4 = true;
                } else {
                    z3 = false;
                    z4 = false;
                }
            }
            if (!z3) {
                synchronized (this.f20103d) {
                    if (this.f20103d.f21214m != 0) {
                        z2 = false;
                    }
                }
                z3 = z2;
            }
            this.f20103d.mo25055s(this.f20102c, z4, list);
            if (z3) {
                this.f20103d.flush();
                return;
            }
            return;
        }
        throw new NullPointerException("headers == null");
    }

    public Timeout writeTimeout() {
        return this.f20110k;
    }
}
