package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
abstract class j10<T> implements Iterator<T> {

    /* renamed from: a */
    private int f9362a = k10.f9556b;
    @NullableDecl

    /* renamed from: b */
    private T f9363b;

    protected j10() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract T mo14280a();

    /* access modifiers changed from: protected */
    @NullableDecl
    /* renamed from: b */
    public final T mo14281b() {
        this.f9362a = k10.f9557c;
        return null;
    }

    public final boolean hasNext() {
        int i = this.f9362a;
        int i2 = k10.f9558d;
        if (i != i2) {
            int i3 = l10.f9795a[i - 1];
            if (i3 == 1) {
                return false;
            }
            if (i3 == 2) {
                return true;
            }
            this.f9362a = i2;
            this.f9363b = mo14280a();
            if (this.f9362a == k10.f9557c) {
                return false;
            }
            this.f9362a = k10.f9555a;
            return true;
        }
        throw new IllegalStateException();
    }

    public final T next() {
        if (hasNext()) {
            this.f9362a = k10.f9556b;
            T t = this.f9363b;
            this.f9363b = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
