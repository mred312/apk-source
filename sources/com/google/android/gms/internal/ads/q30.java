package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
abstract class q30<T> extends AtomicReference<Runnable> implements Runnable {

    /* renamed from: a */
    private static final Runnable f10677a = new s30();

    /* renamed from: b */
    private static final Runnable f10678b = new s30();

    /* renamed from: c */
    private static final Runnable f10679c = new s30();

    q30() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo14632a() {
        Runnable runnable = (Runnable) get();
        if ((runnable instanceof Thread) && compareAndSet(runnable, f10678b)) {
            try {
                ((Thread) runnable).interrupt();
            } finally {
                if (((Runnable) getAndSet(f10677a)) == f10679c) {
                    LockSupport.unpark((Thread) runnable);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract boolean mo13732b();

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract T mo13733c();

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public abstract String mo13734d();

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public abstract void mo13735e(@NullableDecl T t, @NullableDecl Throwable th);

    public final void run() {
        Object obj;
        Thread currentThread = Thread.currentThread();
        if (compareAndSet((Object) null, currentThread)) {
            boolean z = !mo13732b();
            if (z) {
                try {
                    obj = mo13733c();
                } catch (Throwable th) {
                    if (!compareAndSet(currentThread, f10677a)) {
                        Runnable runnable = (Runnable) get();
                        boolean z2 = false;
                        int i = 0;
                        while (true) {
                            Runnable runnable2 = f10678b;
                            if (runnable != runnable2 && runnable != f10679c) {
                                break;
                            }
                            i++;
                            if (i > 1000) {
                                Runnable runnable3 = f10679c;
                                if (runnable == runnable3 || compareAndSet(runnable2, runnable3)) {
                                    z2 = Thread.interrupted() || z2;
                                    LockSupport.park(this);
                                }
                            } else {
                                Thread.yield();
                            }
                            runnable = (Runnable) get();
                        }
                        if (z2) {
                            currentThread.interrupt();
                        }
                    }
                    if (z) {
                        mo13735e((Object) null, th);
                        return;
                    }
                    return;
                }
            } else {
                obj = null;
            }
            if (!compareAndSet(currentThread, f10677a)) {
                Runnable runnable4 = (Runnable) get();
                boolean z3 = false;
                int i2 = 0;
                while (true) {
                    Runnable runnable5 = f10678b;
                    if (runnable4 != runnable5 && runnable4 != f10679c) {
                        break;
                    }
                    i2++;
                    if (i2 > 1000) {
                        Runnable runnable6 = f10679c;
                        if (runnable4 == runnable6 || compareAndSet(runnable5, runnable6)) {
                            z3 = Thread.interrupted() || z3;
                            LockSupport.park(this);
                        }
                    } else {
                        Thread.yield();
                    }
                    runnable4 = (Runnable) get();
                }
                if (z3) {
                    currentThread.interrupt();
                }
            }
            if (z) {
                mo13735e(obj, (Throwable) null);
            }
        }
    }

    public final String toString() {
        String str;
        Runnable runnable = (Runnable) get();
        if (runnable == f10677a) {
            str = "running=[DONE]";
        } else if (runnable == f10678b) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            String name = ((Thread) runnable).getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 21);
            sb.append("running=[RUNNING ON ");
            sb.append(name);
            sb.append("]");
            str = sb.toString();
        } else {
            str = "running=[NOT STARTED YET]";
        }
        String d = mo13734d();
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(d).length());
        sb2.append(str);
        sb2.append(", ");
        sb2.append(d);
        return sb2.toString();
    }
}
