package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class sa0 extends n80 {

    /* renamed from: a */
    private final ua0 f11057a;

    /* renamed from: b */
    private zzejd f11058b = m6890a();

    /* renamed from: c */
    private final /* synthetic */ ta0 f11059c;

    sa0(ta0 ta0) {
        this.f11059c = ta0;
        this.f11057a = new ua0(ta0, (sa0) null);
    }

    /* renamed from: a */
    private final zzejd m6890a() {
        if (this.f11057a.hasNext()) {
            return (zzejd) ((s80) this.f11057a.next()).iterator();
        }
        return null;
    }

    public final boolean hasNext() {
        return this.f11058b != null;
    }

    public final byte nextByte() {
        zzejd zzejd = this.f11058b;
        if (zzejd != null) {
            byte nextByte = zzejd.nextByte();
            if (!this.f11058b.hasNext()) {
                this.f11058b = m6890a();
            }
            return nextByte;
        }
        throw new NoSuchElementException();
    }
}
