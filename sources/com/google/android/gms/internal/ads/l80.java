package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
final class l80 extends n80 {

    /* renamed from: a */
    private int f9815a = 0;

    /* renamed from: b */
    private final int f9816b;

    /* renamed from: c */
    private final /* synthetic */ zzeiu f9817c;

    l80(zzeiu zzeiu) {
        this.f9817c = zzeiu;
        this.f9816b = zzeiu.size();
    }

    public final boolean hasNext() {
        return this.f9815a < this.f9816b;
    }

    public final byte nextByte() {
        int i = this.f9815a;
        if (i < this.f9816b) {
            this.f9815a = i + 1;
            return this.f9817c.mo14574d(i);
        }
        throw new NoSuchElementException();
    }
}
