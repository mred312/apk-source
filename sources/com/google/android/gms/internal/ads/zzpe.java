package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzpe {

    /* renamed from: a */
    private boolean f16818a;

    public final synchronized void block() {
        while (!this.f16818a) {
            wait();
        }
    }

    public final synchronized boolean open() {
        if (this.f16818a) {
            return false;
        }
        this.f16818a = true;
        notifyAll();
        return true;
    }

    public final synchronized boolean zziu() {
        boolean z;
        z = this.f16818a;
        this.f16818a = false;
        return z;
    }
}
