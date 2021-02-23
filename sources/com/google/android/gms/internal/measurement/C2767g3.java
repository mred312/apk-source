package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.measurement.g3 */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
final class C2767g3 extends C2775h3 {

    /* renamed from: a */
    private int f17319a = 0;

    /* renamed from: b */
    private final int f17320b;

    /* renamed from: c */
    private final /* synthetic */ zzgr f17321c;

    C2767g3(zzgr zzgr) {
        this.f17321c = zzgr;
        this.f17320b = zzgr.zza();
    }

    public final boolean hasNext() {
        return this.f17319a < this.f17320b;
    }

    public final byte zza() {
        int i = this.f17319a;
        if (i < this.f17320b) {
            this.f17319a = i + 1;
            return this.f17321c.mo18674c(i);
        }
        throw new NoSuchElementException();
    }
}
