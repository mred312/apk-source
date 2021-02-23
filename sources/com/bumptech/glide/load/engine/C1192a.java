package com.bumptech.glide.load.engine;

import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.C1256l;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* renamed from: com.bumptech.glide.load.engine.a */
/* compiled from: ActiveResources */
final class C1192a {

    /* renamed from: a */
    private final boolean f5698a;

    /* renamed from: b */
    private final Executor f5699b;
    @VisibleForTesting

    /* renamed from: c */
    final Map<Key, C1197d> f5700c;

    /* renamed from: d */
    private final ReferenceQueue<C1256l<?>> f5701d;

    /* renamed from: e */
    private C1256l.C1257a f5702e;

    /* renamed from: f */
    private volatile boolean f5703f;
    @Nullable

    /* renamed from: g */
    private volatile C1196c f5704g;

    /* renamed from: com.bumptech.glide.load.engine.a$a */
    /* compiled from: ActiveResources */
    class C1193a implements ThreadFactory {

        /* renamed from: com.bumptech.glide.load.engine.a$a$a */
        /* compiled from: ActiveResources */
        class C1194a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Runnable f5705a;

            C1194a(C1193a aVar, Runnable runnable) {
                this.f5705a = runnable;
            }

            public void run() {
                Process.setThreadPriority(10);
                this.f5705a.run();
            }
        }

        C1193a() {
        }

        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(new C1194a(this, runnable), "glide-active-resources");
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.a$b */
    /* compiled from: ActiveResources */
    class C1195b implements Runnable {
        C1195b() {
        }

        public void run() {
            C1192a.this.mo9488b();
        }
    }

    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.a$c */
    /* compiled from: ActiveResources */
    interface C1196c {
        /* renamed from: a */
        void mo9497a();
    }

    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.a$d */
    /* compiled from: ActiveResources */
    static final class C1197d extends WeakReference<C1256l<?>> {

        /* renamed from: a */
        final Key f5707a;

        /* renamed from: b */
        final boolean f5708b;
        @Nullable

        /* renamed from: c */
        Resource<?> f5709c;

        C1197d(@NonNull Key key, @NonNull C1256l<?> lVar, @NonNull ReferenceQueue<? super C1256l<?>> referenceQueue, boolean z) {
            super(lVar, referenceQueue);
            this.f5707a = (Key) Preconditions.checkNotNull(key);
            this.f5709c = (!lVar.mo9685c() || !z) ? null : (Resource) Preconditions.checkNotNull(lVar.mo9684b());
            this.f5708b = lVar.mo9685c();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo9498a() {
            this.f5709c = null;
            clear();
        }
    }

    C1192a(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new C1193a()));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo9487a(Key key, C1256l<?> lVar) {
        C1197d put = this.f5700c.put(key, new C1197d(key, lVar, this.f5701d, this.f5698a));
        if (put != null) {
            put.mo9498a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo9488b() {
        while (!this.f5703f) {
            try {
                mo9489c((C1197d) this.f5701d.remove());
                C1196c cVar = this.f5704g;
                if (cVar != null) {
                    cVar.mo9497a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo9489c(@NonNull C1197d dVar) {
        synchronized (this) {
            this.f5700c.remove(dVar.f5707a);
            if (dVar.f5708b) {
                Resource<?> resource = dVar.f5709c;
                if (resource != null) {
                    this.f5702e.onResourceReleased(dVar.f5707a, new C1256l(resource, true, false, dVar.f5707a, this.f5702e));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public synchronized void mo9490d(Key key) {
        C1197d remove = this.f5700c.remove(key);
        if (remove != null) {
            remove.mo9498a();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        return r0;
     */
    @androidx.annotation.Nullable
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.bumptech.glide.load.engine.C1256l<?> mo9491e(com.bumptech.glide.load.Key r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Map<com.bumptech.glide.load.Key, com.bumptech.glide.load.engine.a$d> r0 = r1.f5700c     // Catch:{ all -> 0x001b }
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x001b }
            com.bumptech.glide.load.engine.a$d r2 = (com.bumptech.glide.load.engine.C1192a.C1197d) r2     // Catch:{ all -> 0x001b }
            if (r2 != 0) goto L_0x000e
            r2 = 0
            monitor-exit(r1)
            return r2
        L_0x000e:
            java.lang.Object r0 = r2.get()     // Catch:{ all -> 0x001b }
            com.bumptech.glide.load.engine.l r0 = (com.bumptech.glide.load.engine.C1256l) r0     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.mo9489c(r2)     // Catch:{ all -> 0x001b }
        L_0x0019:
            monitor-exit(r1)
            return r0
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.C1192a.mo9491e(com.bumptech.glide.load.Key):com.bumptech.glide.load.engine.l");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo9492f(C1256l.C1257a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f5702e = aVar;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: g */
    public void mo9493g() {
        this.f5703f = true;
        Executor executor = this.f5699b;
        if (executor instanceof ExecutorService) {
            com.bumptech.glide.util.Executors.shutdownAndAwaitTermination((ExecutorService) executor);
        }
    }

    @VisibleForTesting
    C1192a(boolean z, Executor executor) {
        this.f5700c = new HashMap();
        this.f5701d = new ReferenceQueue<>();
        this.f5698a = z;
        this.f5699b = executor;
        executor.execute(new C1195b());
    }
}
