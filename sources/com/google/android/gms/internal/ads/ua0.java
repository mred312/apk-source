package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class ua0 implements Iterator<s80> {

    /* renamed from: a */
    private final ArrayDeque<ta0> f11316a;

    /* renamed from: b */
    private s80 f11317b;

    private ua0(zzeiu zzeiu) {
        if (zzeiu instanceof ta0) {
            ta0 ta0 = (ta0) zzeiu;
            ArrayDeque<ta0> arrayDeque = new ArrayDeque<>(ta0.zzbfu());
            this.f11316a = arrayDeque;
            arrayDeque.push(ta0);
            this.f11317b = m7040a(ta0.f11157d);
            return;
        }
        this.f11316a = null;
        this.f11317b = (s80) zzeiu;
    }

    /* renamed from: a */
    private final s80 m7040a(zzeiu zzeiu) {
        while (zzeiu instanceof ta0) {
            ta0 ta0 = (ta0) zzeiu;
            this.f11316a.push(ta0);
            zzeiu = ta0.f11157d;
        }
        return (s80) zzeiu;
    }

    public final boolean hasNext() {
        return this.f11317b != null;
    }

    public final /* synthetic */ Object next() {
        s80 s80;
        s80 s802 = this.f11317b;
        if (s802 != null) {
            while (true) {
                ArrayDeque<ta0> arrayDeque = this.f11316a;
                if (arrayDeque != null && !arrayDeque.isEmpty()) {
                    s80 = m7040a(this.f11316a.pop().f11158e);
                    if (!s80.isEmpty()) {
                        break;
                    }
                } else {
                    s80 = null;
                }
            }
            s80 = null;
            this.f11317b = s80;
            return s802;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ ua0(zzeiu zzeiu, sa0 sa0) {
        this(zzeiu);
    }
}
