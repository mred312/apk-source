package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzub {

    /* renamed from: a */
    private final byte[] f17023a;

    /* renamed from: b */
    private int f17024b;

    /* renamed from: c */
    private int f17025c;

    /* renamed from: d */
    private final /* synthetic */ zztx f17026d;

    private zzub(zztx zztx, byte[] bArr) {
        this.f17026d = zztx;
        this.f17023a = bArr;
    }

    public final synchronized void log() {
        try {
            zztx zztx = this.f17026d;
            if (zztx.f17020b) {
                zztx.f17019a.zzc(this.f17023a);
                this.f17026d.f17019a.zzs(this.f17024b);
                this.f17026d.f17019a.zzt(this.f17025c);
                this.f17026d.f17019a.zza((int[]) null);
                this.f17026d.f17019a.log();
            }
        } catch (RemoteException e) {
            zzaza.zzb("Clearcut log failed", e);
        }
    }

    public final zzub zzbu(int i) {
        this.f17024b = i;
        return this;
    }

    public final zzub zzbv(int i) {
        this.f17025c = i;
        return this;
    }
}
