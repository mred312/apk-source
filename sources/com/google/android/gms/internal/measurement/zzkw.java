package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
public final class zzkw extends AbstractList<String> implements zzis, RandomAccess {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzis f17747a;

    public zzkw(zzis zzis) {
        this.f17747a = zzis;
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.f17747a.get(i);
    }

    public final Iterator<String> iterator() {
        return new C2770g6(this);
    }

    public final ListIterator<String> listIterator(int i) {
        return new C2750e6(this, i);
    }

    public final int size() {
        return this.f17747a.size();
    }

    public final void zza(zzgr zzgr) {
        throw new UnsupportedOperationException();
    }

    public final Object zzb(int i) {
        return this.f17747a.zzb(i);
    }

    public final List<?> zzd() {
        return this.f17747a.zzd();
    }

    public final zzis zze() {
        return this;
    }
}
