package com.google.android.gms.internal.ads;

import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class rb0 implements ListIterator<String> {

    /* renamed from: a */
    private ListIterator<String> f10782a;

    /* renamed from: b */
    private final /* synthetic */ int f10783b;

    /* renamed from: c */
    private final /* synthetic */ zzenk f10784c;

    rb0(zzenk zzenk, int i) {
        this.f10784c = zzenk;
        this.f10783b = i;
        this.f10782a = zzenk.f16286a.listIterator(i);
    }

    public final /* synthetic */ void add(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }

    public final boolean hasNext() {
        return this.f10782a.hasNext();
    }

    public final boolean hasPrevious() {
        return this.f10782a.hasPrevious();
    }

    public final /* synthetic */ Object next() {
        return this.f10782a.next();
    }

    public final int nextIndex() {
        return this.f10782a.nextIndex();
    }

    public final /* synthetic */ Object previous() {
        return this.f10782a.previous();
    }

    public final int previousIndex() {
        return this.f10782a.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }
}
