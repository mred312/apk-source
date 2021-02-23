package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Predicate;

/* renamed from: com.google.android.gms.internal.ads.j1 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2048j1 implements Predicate {

    /* renamed from: a */
    private final zzahv f9361a;

    C2048j1(zzahv zzahv) {
        this.f9361a = zzahv;
    }

    public final boolean apply(Object obj) {
        zzahv zzahv = (zzahv) obj;
        return (zzahv instanceof C2271p1) && C2271p1.m6603a((C2271p1) zzahv).equals(this.f9361a);
    }
}
