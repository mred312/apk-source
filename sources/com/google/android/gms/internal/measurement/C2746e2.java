package com.google.android.gms.internal.measurement;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.measurement.e2 */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
abstract class C2746e2<T> implements Iterator<T> {

    /* renamed from: a */
    private int f17278a;

    /* renamed from: b */
    private int f17279b;

    /* renamed from: c */
    private int f17280c;

    /* renamed from: d */
    private final /* synthetic */ C2900x1 f17281d;

    private C2746e2(C2900x1 x1Var) {
        this.f17281d = x1Var;
        this.f17278a = x1Var.f17509e;
        this.f17279b = x1Var.mo18968p();
        this.f17280c = -1;
    }

    /* renamed from: b */
    private final void m9376b() {
        if (this.f17281d.f17509e != this.f17278a) {
            throw new ConcurrentModificationException();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract T mo18539a(int i);

    public boolean hasNext() {
        return this.f17279b >= 0;
    }

    public T next() {
        m9376b();
        if (hasNext()) {
            int i = this.f17279b;
            this.f17280c = i;
            T a = mo18539a(i);
            this.f17279b = this.f17281d.mo18956a(this.f17279b);
            return a;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        m9376b();
        zzeb.zzb(this.f17280c >= 0, (Object) "no calls to next() since the last call to remove()");
        this.f17278a += 32;
        C2900x1 x1Var = this.f17281d;
        x1Var.remove(x1Var.f17507c[this.f17280c]);
        this.f17279b = C2900x1.m9902h(this.f17279b, this.f17280c);
        this.f17280c = -1;
    }

    /* synthetic */ C2746e2(C2900x1 x1Var, C2714a2 a2Var) {
        this(x1Var);
    }
}
