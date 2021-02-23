package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public final class zzenk extends AbstractList<String> implements zzekz, RandomAccess {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzekz f16286a;

    public zzenk(zzekz zzekz) {
        this.f16286a = zzekz;
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.f16286a.get(i);
    }

    public final Iterator<String> iterator() {
        return new tb0(this);
    }

    public final ListIterator<String> listIterator(int i) {
        return new rb0(this, i);
    }

    public final int size() {
        return this.f16286a.size();
    }

    public final void zzak(zzeiu zzeiu) {
        throw new UnsupportedOperationException();
    }

    public final List<?> zzbiu() {
        return this.f16286a.zzbiu();
    }

    public final zzekz zzbiv() {
        return this;
    }

    public final Object zzhi(int i) {
        return this.f16286a.zzhi(i);
    }
}
