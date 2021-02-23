package okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.C3541a;
import okhttp3.internal.Util;

public final class Dispatcher {

    /* renamed from: a */
    private int f19837a = 64;

    /* renamed from: b */
    private int f19838b = 5;
    @Nullable

    /* renamed from: c */
    private Runnable f19839c;
    @Nullable

    /* renamed from: d */
    private ExecutorService f19840d;

    /* renamed from: e */
    private final Deque<C3541a.C3543b> f19841e = new ArrayDeque();

    /* renamed from: f */
    private final Deque<C3541a.C3543b> f19842f = new ArrayDeque();

    /* renamed from: g */
    private final Deque<C3541a> f19843g = new ArrayDeque();

    public Dispatcher(ExecutorService executorService) {
        this.f19840d = executorService;
    }

    /* renamed from: c */
    private <T> void m11930c(Deque<T> deque, T t) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                runnable = this.f19839c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (!m11931f() && runnable != null) {
            runnable.run();
        }
    }

    /* renamed from: f */
    private boolean m11931f() {
        int i;
        boolean z;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<C3541a.C3543b> it = this.f19841e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C3541a.C3543b next = it.next();
                if (this.f19842f.size() >= this.f19837a) {
                    break;
                } else if (m11932g(next) < this.f19838b) {
                    it.remove();
                    arrayList.add(next);
                    this.f19842f.add(next);
                }
            }
            z = runningCallsCount() > 0;
        }
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((C3541a.C3543b) arrayList.get(i)).mo22278k(executorService());
        }
        return z;
    }

    /* renamed from: g */
    private int m11932g(C3541a.C3543b bVar) {
        int i = 0;
        for (C3541a.C3543b next : this.f19842f) {
            if (!next.mo22279l().f20012f && next.mo22280m().equals(bVar.mo22280m())) {
                i++;
            }
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo21920a(C3541a.C3543b bVar) {
        synchronized (this) {
            this.f19841e.add(bVar);
        }
        m11931f();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo21921b(C3541a aVar) {
        this.f19843g.add(aVar);
    }

    public synchronized void cancelAll() {
        for (C3541a.C3543b l : this.f19841e) {
            l.mo22279l().cancel();
        }
        for (C3541a.C3543b l2 : this.f19842f) {
            l2.mo22279l().cancel();
        }
        for (C3541a cancel : this.f19843g) {
            cancel.cancel();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo21923d(C3541a.C3543b bVar) {
        m11930c(this.f19842f, bVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo21924e(C3541a aVar) {
        m11930c(this.f19843g, aVar);
    }

    public synchronized ExecutorService executorService() {
        if (this.f19840d == null) {
            this.f19840d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));
        }
        return this.f19840d;
    }

    public synchronized int getMaxRequests() {
        return this.f19837a;
    }

    public synchronized int getMaxRequestsPerHost() {
        return this.f19838b;
    }

    public synchronized List<Call> queuedCalls() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (C3541a.C3543b l : this.f19841e) {
            arrayList.add(l.mo22279l());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized int queuedCallsCount() {
        return this.f19841e.size();
    }

    public synchronized List<Call> runningCalls() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.f19843g);
        for (C3541a.C3543b l : this.f19842f) {
            arrayList.add(l.mo22279l());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized int runningCallsCount() {
        return this.f19842f.size() + this.f19843g.size();
    }

    public synchronized void setIdleCallback(@Nullable Runnable runnable) {
        this.f19839c = runnable;
    }

    public void setMaxRequests(int i) {
        if (i >= 1) {
            synchronized (this) {
                this.f19837a = i;
            }
            m11931f();
            return;
        }
        throw new IllegalArgumentException("max < 1: " + i);
    }

    public void setMaxRequestsPerHost(int i) {
        if (i >= 1) {
            synchronized (this) {
                this.f19838b = i;
            }
            m11931f();
            return;
        }
        throw new IllegalArgumentException("max < 1: " + i);
    }

    public Dispatcher() {
    }
}
