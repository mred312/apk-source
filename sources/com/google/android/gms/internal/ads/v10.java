package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
final class v10 implements Iterable<String> {

    /* renamed from: a */
    private final /* synthetic */ CharSequence f11462a;

    /* renamed from: b */
    private final /* synthetic */ zzdvx f11463b;

    v10(zzdvx zzdvx, CharSequence charSequence) {
        this.f11463b = zzdvx;
        this.f11462a = charSequence;
    }

    public final Iterator<String> iterator() {
        return this.f11463b.m8533d(this.f11462a);
    }

    public final String toString() {
        StringBuilder zza = zzdvl.zzhe(", ").zza(new StringBuilder("["), iterator());
        zza.append(']');
        return zza.toString();
    }
}
