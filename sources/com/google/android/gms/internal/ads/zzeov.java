package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzeov<E> extends AbstractList<E> {

    /* renamed from: c */
    private static final zzeox f16337c = zzeox.zzn(zzeov.class);

    /* renamed from: a */
    List<E> f16338a;

    /* renamed from: b */
    Iterator<E> f16339b;

    public zzeov(List<E> list, Iterator<E> it) {
        this.f16338a = list;
        this.f16339b = it;
    }

    public E get(int i) {
        if (this.f16338a.size() > i) {
            return this.f16338a.get(i);
        }
        if (this.f16339b.hasNext()) {
            this.f16338a.add(this.f16339b.next());
            return get(i);
        }
        throw new NoSuchElementException();
    }

    public Iterator<E> iterator() {
        return new oc0(this);
    }

    public int size() {
        zzeox zzeox = f16337c;
        zzeox.zzii("potentially expensive size() call");
        zzeox.zzii("blowup running");
        while (this.f16339b.hasNext()) {
            this.f16338a.add(this.f16339b.next());
        }
        return this.f16338a.size();
    }
}
