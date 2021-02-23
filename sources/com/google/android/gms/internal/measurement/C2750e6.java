package com.google.android.gms.internal.measurement;

import java.util.ListIterator;

/* renamed from: com.google.android.gms.internal.measurement.e6 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2750e6 implements ListIterator<String> {

    /* renamed from: a */
    private ListIterator<String> f17283a;

    /* renamed from: b */
    private final /* synthetic */ int f17284b;

    /* renamed from: c */
    private final /* synthetic */ zzkw f17285c;

    C2750e6(zzkw zzkw, int i) {
        this.f17285c = zzkw;
        this.f17284b = i;
        this.f17283a = zzkw.f17747a.listIterator(i);
    }

    public final /* synthetic */ void add(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }

    public final boolean hasNext() {
        return this.f17283a.hasNext();
    }

    public final boolean hasPrevious() {
        return this.f17283a.hasPrevious();
    }

    public final /* synthetic */ Object next() {
        return this.f17283a.next();
    }

    public final int nextIndex() {
        return this.f17283a.nextIndex();
    }

    public final /* synthetic */ Object previous() {
        return this.f17283a.previous();
    }

    public final int previousIndex() {
        return this.f17283a.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }
}
