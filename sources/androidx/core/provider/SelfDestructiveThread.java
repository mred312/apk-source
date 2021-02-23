package androidx.core.provider;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SelfDestructiveThread {

    /* renamed from: a */
    private final Object f2485a = new Object();
    @GuardedBy("mLock")

    /* renamed from: b */
    private HandlerThread f2486b;
    @GuardedBy("mLock")

    /* renamed from: c */
    private Handler f2487c;
    @GuardedBy("mLock")

    /* renamed from: d */
    private int f2488d;

    /* renamed from: e */
    private Handler.Callback f2489e = new C0506a();

    /* renamed from: f */
    private final int f2490f;

    /* renamed from: g */
    private final int f2491g;

    /* renamed from: h */
    private final String f2492h;

    public interface ReplyCallback<T> {
        void onReply(T t);
    }

    /* renamed from: androidx.core.provider.SelfDestructiveThread$a */
    class C0506a implements Handler.Callback {
        C0506a() {
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                SelfDestructiveThread.this.mo4424a();
                return true;
            } else if (i != 1) {
                return true;
            } else {
                SelfDestructiveThread.this.mo4425b((Runnable) message.obj);
                return true;
            }
        }
    }

    /* renamed from: androidx.core.provider.SelfDestructiveThread$b */
    class C0507b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Callable f2494a;

        /* renamed from: b */
        final /* synthetic */ Handler f2495b;

        /* renamed from: c */
        final /* synthetic */ ReplyCallback f2496c;

        /* renamed from: androidx.core.provider.SelfDestructiveThread$b$a */
        class C0508a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Object f2497a;

            C0508a(Object obj) {
                this.f2497a = obj;
            }

            public void run() {
                C0507b.this.f2496c.onReply(this.f2497a);
            }
        }

        C0507b(SelfDestructiveThread selfDestructiveThread, Callable callable, Handler handler, ReplyCallback replyCallback) {
            this.f2494a = callable;
            this.f2495b = handler;
            this.f2496c = replyCallback;
        }

        public void run() {
            Object obj;
            try {
                obj = this.f2494a.call();
            } catch (Exception unused) {
                obj = null;
            }
            this.f2495b.post(new C0508a(obj));
        }
    }

    /* renamed from: androidx.core.provider.SelfDestructiveThread$c */
    class C0509c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AtomicReference f2499a;

        /* renamed from: b */
        final /* synthetic */ Callable f2500b;

        /* renamed from: c */
        final /* synthetic */ ReentrantLock f2501c;

        /* renamed from: d */
        final /* synthetic */ AtomicBoolean f2502d;

        /* renamed from: e */
        final /* synthetic */ Condition f2503e;

        C0509c(SelfDestructiveThread selfDestructiveThread, AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
            this.f2499a = atomicReference;
            this.f2500b = callable;
            this.f2501c = reentrantLock;
            this.f2502d = atomicBoolean;
            this.f2503e = condition;
        }

        public void run() {
            try {
                this.f2499a.set(this.f2500b.call());
            } catch (Exception unused) {
            }
            this.f2501c.lock();
            try {
                this.f2502d.set(false);
                this.f2503e.signal();
            } finally {
                this.f2501c.unlock();
            }
        }
    }

    public SelfDestructiveThread(String str, int i, int i2) {
        this.f2492h = str;
        this.f2491g = i;
        this.f2490f = i2;
        this.f2488d = 0;
    }

    /* renamed from: c */
    private void m1642c(Runnable runnable) {
        synchronized (this.f2485a) {
            if (this.f2486b == null) {
                HandlerThread handlerThread = new HandlerThread(this.f2492h, this.f2491g);
                this.f2486b = handlerThread;
                handlerThread.start();
                this.f2487c = new Handler(this.f2486b.getLooper(), this.f2489e);
                this.f2488d++;
            }
            this.f2487c.removeMessages(0);
            Handler handler = this.f2487c;
            handler.sendMessage(handler.obtainMessage(1, runnable));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4424a() {
        synchronized (this.f2485a) {
            if (!this.f2487c.hasMessages(1)) {
                this.f2486b.quit();
                this.f2486b = null;
                this.f2487c = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4425b(Runnable runnable) {
        runnable.run();
        synchronized (this.f2485a) {
            this.f2487c.removeMessages(0);
            Handler handler = this.f2487c;
            handler.sendMessageDelayed(handler.obtainMessage(0), (long) this.f2490f);
        }
    }

    @VisibleForTesting
    public int getGeneration() {
        int i;
        synchronized (this.f2485a) {
            i = this.f2488d;
        }
        return i;
    }

    @VisibleForTesting
    public boolean isRunning() {
        boolean z;
        synchronized (this.f2485a) {
            z = this.f2486b != null;
        }
        return z;
    }

    public <T> void postAndReply(Callable<T> callable, ReplyCallback<T> replyCallback) {
        m1642c(new C0507b(this, callable, new Handler(), replyCallback));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:9|10|11|12|(4:25|14|15|16)(1:17)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003f */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0045 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T postAndWait(java.util.concurrent.Callable<T> r13, int r14) {
        /*
            r12 = this;
            java.util.concurrent.locks.ReentrantLock r7 = new java.util.concurrent.locks.ReentrantLock
            r7.<init>()
            java.util.concurrent.locks.Condition r8 = r7.newCondition()
            java.util.concurrent.atomic.AtomicReference r9 = new java.util.concurrent.atomic.AtomicReference
            r9.<init>()
            java.util.concurrent.atomic.AtomicBoolean r10 = new java.util.concurrent.atomic.AtomicBoolean
            r0 = 1
            r10.<init>(r0)
            androidx.core.provider.SelfDestructiveThread$c r11 = new androidx.core.provider.SelfDestructiveThread$c
            r0 = r11
            r1 = r12
            r2 = r9
            r3 = r13
            r4 = r7
            r5 = r10
            r6 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r12.m1642c(r11)
            r7.lock()
            boolean r13 = r10.get()     // Catch:{ all -> 0x005c }
            if (r13 != 0) goto L_0x0034
            java.lang.Object r13 = r9.get()     // Catch:{ all -> 0x005c }
            r7.unlock()
            return r13
        L_0x0034:
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x005c }
            long r0 = (long) r14     // Catch:{ all -> 0x005c }
            long r13 = r13.toNanos(r0)     // Catch:{ all -> 0x005c }
        L_0x003b:
            long r13 = r8.awaitNanos(r13)     // Catch:{ InterruptedException -> 0x003f }
        L_0x003f:
            boolean r0 = r10.get()     // Catch:{ all -> 0x005c }
            if (r0 != 0) goto L_0x004d
            java.lang.Object r13 = r9.get()     // Catch:{ all -> 0x005c }
            r7.unlock()
            return r13
        L_0x004d:
            r0 = 0
            int r2 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0054
            goto L_0x003b
        L_0x0054:
            java.lang.InterruptedException r13 = new java.lang.InterruptedException     // Catch:{ all -> 0x005c }
            java.lang.String r14 = "timeout"
            r13.<init>(r14)     // Catch:{ all -> 0x005c }
            throw r13     // Catch:{ all -> 0x005c }
        L_0x005c:
            r13 = move-exception
            r7.unlock()
            goto L_0x0062
        L_0x0061:
            throw r13
        L_0x0062:
            goto L_0x0061
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.SelfDestructiveThread.postAndWait(java.util.concurrent.Callable, int):java.lang.Object");
    }
}
