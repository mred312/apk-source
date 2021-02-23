package androidx.recyclerview.widget;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: androidx.recyclerview.widget.g */
/* compiled from: MessageThreadUtil */
class C0948g<T> implements ThreadUtil<T> {

    /* renamed from: androidx.recyclerview.widget.g$a */
    /* compiled from: MessageThreadUtil */
    class C0949a implements ThreadUtil.MainThreadCallback<T> {

        /* renamed from: a */
        final C0953c f4449a = new C0953c();

        /* renamed from: b */
        private final Handler f4450b = new Handler(Looper.getMainLooper());

        /* renamed from: c */
        private Runnable f4451c = new C0950a();

        /* renamed from: d */
        final /* synthetic */ ThreadUtil.MainThreadCallback f4452d;

        /* renamed from: androidx.recyclerview.widget.g$a$a */
        /* compiled from: MessageThreadUtil */
        class C0950a implements Runnable {
            C0950a() {
            }

            public void run() {
                C0954d a = C0949a.this.f4449a.mo7697a();
                while (a != null) {
                    int i = a.f4464b;
                    if (i == 1) {
                        C0949a.this.f4452d.updateItemCount(a.f4465c, a.f4466d);
                    } else if (i == 2) {
                        C0949a.this.f4452d.addTile(a.f4465c, (TileList.Tile) a.f4470h);
                    } else if (i != 3) {
                        Log.e("ThreadUtil", "Unsupported message, what=" + a.f4464b);
                    } else {
                        C0949a.this.f4452d.removeTile(a.f4465c, a.f4466d);
                    }
                    a = C0949a.this.f4449a.mo7697a();
                }
            }
        }

        C0949a(C0948g gVar, ThreadUtil.MainThreadCallback mainThreadCallback) {
            this.f4452d = mainThreadCallback;
        }

        /* renamed from: a */
        private void m3529a(C0954d dVar) {
            this.f4449a.mo7699c(dVar);
            this.f4450b.post(this.f4451c);
        }

        public void addTile(int i, TileList.Tile<T> tile) {
            m3529a(C0954d.m3539c(2, i, tile));
        }

        public void removeTile(int i, int i2) {
            m3529a(C0954d.m3537a(3, i, i2));
        }

        public void updateItemCount(int i, int i2) {
            m3529a(C0954d.m3537a(1, i, i2));
        }
    }

    /* renamed from: androidx.recyclerview.widget.g$b */
    /* compiled from: MessageThreadUtil */
    class C0951b implements ThreadUtil.BackgroundCallback<T> {

        /* renamed from: a */
        final C0953c f4454a = new C0953c();

        /* renamed from: b */
        private final Executor f4455b = AsyncTask.THREAD_POOL_EXECUTOR;

        /* renamed from: c */
        AtomicBoolean f4456c = new AtomicBoolean(false);

        /* renamed from: d */
        private Runnable f4457d = new C0952a();

        /* renamed from: e */
        final /* synthetic */ ThreadUtil.BackgroundCallback f4458e;

        /* renamed from: androidx.recyclerview.widget.g$b$a */
        /* compiled from: MessageThreadUtil */
        class C0952a implements Runnable {
            C0952a() {
            }

            public void run() {
                while (true) {
                    C0954d a = C0951b.this.f4454a.mo7697a();
                    if (a == null) {
                        C0951b.this.f4456c.set(false);
                        return;
                    }
                    int i = a.f4464b;
                    if (i == 1) {
                        C0951b.this.f4454a.mo7698b(1);
                        C0951b.this.f4458e.refresh(a.f4465c);
                    } else if (i == 2) {
                        C0951b.this.f4454a.mo7698b(2);
                        C0951b.this.f4454a.mo7698b(3);
                        C0951b.this.f4458e.updateRange(a.f4465c, a.f4466d, a.f4467e, a.f4468f, a.f4469g);
                    } else if (i == 3) {
                        C0951b.this.f4458e.loadTile(a.f4465c, a.f4466d);
                    } else if (i != 4) {
                        Log.e("ThreadUtil", "Unsupported message, what=" + a.f4464b);
                    } else {
                        C0951b.this.f4458e.recycleTile((TileList.Tile) a.f4470h);
                    }
                }
            }
        }

        C0951b(C0948g gVar, ThreadUtil.BackgroundCallback backgroundCallback) {
            this.f4458e = backgroundCallback;
        }

        /* renamed from: a */
        private void m3530a() {
            if (this.f4456c.compareAndSet(false, true)) {
                this.f4455b.execute(this.f4457d);
            }
        }

        /* renamed from: b */
        private void m3531b(C0954d dVar) {
            this.f4454a.mo7699c(dVar);
            m3530a();
        }

        /* renamed from: c */
        private void m3532c(C0954d dVar) {
            this.f4454a.mo7700d(dVar);
            m3530a();
        }

        public void loadTile(int i, int i2) {
            m3531b(C0954d.m3537a(3, i, i2));
        }

        public void recycleTile(TileList.Tile<T> tile) {
            m3531b(C0954d.m3539c(4, 0, tile));
        }

        public void refresh(int i) {
            m3532c(C0954d.m3539c(1, i, (Object) null));
        }

        public void updateRange(int i, int i2, int i3, int i4, int i5) {
            m3532c(C0954d.m3538b(2, i, i2, i3, i4, i5, (Object) null));
        }
    }

    /* renamed from: androidx.recyclerview.widget.g$c */
    /* compiled from: MessageThreadUtil */
    static class C0953c {

        /* renamed from: a */
        private C0954d f4460a;

        C0953c() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public synchronized C0954d mo7697a() {
            C0954d dVar = this.f4460a;
            if (dVar == null) {
                return null;
            }
            this.f4460a = dVar.f4463a;
            return dVar;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0013  */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void mo7698b(int r5) {
            /*
                r4 = this;
                monitor-enter(r4)
            L_0x0001:
                androidx.recyclerview.widget.g$d r0 = r4.f4460a     // Catch:{ all -> 0x0028 }
                if (r0 == 0) goto L_0x0011
                int r1 = r0.f4464b     // Catch:{ all -> 0x0028 }
                if (r1 != r5) goto L_0x0011
                androidx.recyclerview.widget.g$d r1 = r0.f4463a     // Catch:{ all -> 0x0028 }
                r4.f4460a = r1     // Catch:{ all -> 0x0028 }
                r0.mo7701d()     // Catch:{ all -> 0x0028 }
                goto L_0x0001
            L_0x0011:
                if (r0 == 0) goto L_0x0026
                androidx.recyclerview.widget.g$d r1 = r0.f4463a     // Catch:{ all -> 0x0028 }
            L_0x0015:
                if (r1 == 0) goto L_0x0026
                androidx.recyclerview.widget.g$d r2 = r1.f4463a     // Catch:{ all -> 0x0028 }
                int r3 = r1.f4464b     // Catch:{ all -> 0x0028 }
                if (r3 != r5) goto L_0x0023
                r0.f4463a = r2     // Catch:{ all -> 0x0028 }
                r1.mo7701d()     // Catch:{ all -> 0x0028 }
                goto L_0x0024
            L_0x0023:
                r0 = r1
            L_0x0024:
                r1 = r2
                goto L_0x0015
            L_0x0026:
                monitor-exit(r4)
                return
            L_0x0028:
                r5 = move-exception
                monitor-exit(r4)
                goto L_0x002c
            L_0x002b:
                throw r5
            L_0x002c:
                goto L_0x002b
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.C0948g.C0953c.mo7698b(int):void");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public synchronized void mo7699c(C0954d dVar) {
            C0954d dVar2 = this.f4460a;
            if (dVar2 == null) {
                this.f4460a = dVar;
                return;
            }
            while (true) {
                C0954d dVar3 = dVar2.f4463a;
                if (dVar3 != null) {
                    dVar2 = dVar3;
                } else {
                    dVar2.f4463a = dVar;
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public synchronized void mo7700d(C0954d dVar) {
            dVar.f4463a = this.f4460a;
            this.f4460a = dVar;
        }
    }

    /* renamed from: androidx.recyclerview.widget.g$d */
    /* compiled from: MessageThreadUtil */
    static class C0954d {

        /* renamed from: i */
        private static C0954d f4461i;

        /* renamed from: j */
        private static final Object f4462j = new Object();

        /* renamed from: a */
        C0954d f4463a;

        /* renamed from: b */
        public int f4464b;

        /* renamed from: c */
        public int f4465c;

        /* renamed from: d */
        public int f4466d;

        /* renamed from: e */
        public int f4467e;

        /* renamed from: f */
        public int f4468f;

        /* renamed from: g */
        public int f4469g;

        /* renamed from: h */
        public Object f4470h;

        C0954d() {
        }

        /* renamed from: a */
        static C0954d m3537a(int i, int i2, int i3) {
            return m3538b(i, i2, i3, 0, 0, 0, (Object) null);
        }

        /* renamed from: b */
        static C0954d m3538b(int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
            C0954d dVar;
            synchronized (f4462j) {
                dVar = f4461i;
                if (dVar == null) {
                    dVar = new C0954d();
                } else {
                    f4461i = dVar.f4463a;
                    dVar.f4463a = null;
                }
                dVar.f4464b = i;
                dVar.f4465c = i2;
                dVar.f4466d = i3;
                dVar.f4467e = i4;
                dVar.f4468f = i5;
                dVar.f4469g = i6;
                dVar.f4470h = obj;
            }
            return dVar;
        }

        /* renamed from: c */
        static C0954d m3539c(int i, int i2, Object obj) {
            return m3538b(i, i2, 0, 0, 0, 0, obj);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo7701d() {
            this.f4463a = null;
            this.f4469g = 0;
            this.f4468f = 0;
            this.f4467e = 0;
            this.f4466d = 0;
            this.f4465c = 0;
            this.f4464b = 0;
            this.f4470h = null;
            synchronized (f4462j) {
                C0954d dVar = f4461i;
                if (dVar != null) {
                    this.f4463a = dVar;
                }
                f4461i = this;
            }
        }
    }

    C0948g() {
    }

    /* renamed from: a */
    public ThreadUtil.BackgroundCallback<T> mo7603a(ThreadUtil.BackgroundCallback<T> backgroundCallback) {
        return new C0951b(this, backgroundCallback);
    }

    /* renamed from: b */
    public ThreadUtil.MainThreadCallback<T> mo7604b(ThreadUtil.MainThreadCallback<T> mainThreadCallback) {
        return new C0949a(this, mainThreadCallback);
    }
}
