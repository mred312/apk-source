package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class bi0 implements Runnable {

    /* renamed from: a */
    private final ci0 f7921a;

    /* renamed from: b */
    private final zztc f7922b;

    /* renamed from: c */
    private final zztf f7923c;

    /* renamed from: d */
    private final zzazq f7924d;

    bi0(ci0 ci0, zztc zztc, zztf zztf, zzazq zzazq) {
        this.f7921a = ci0;
        this.f7922b = zztc;
        this.f7923c = zztf;
        this.f7924d = zzazq;
    }

    public final void run() {
        zzta zzta;
        ci0 ci0 = this.f7921a;
        zztc zztc = this.f7922b;
        zztf zztf = this.f7923c;
        zzazq zzazq = this.f7924d;
        try {
            zztg zznc = zztc.zznc();
            if (zztc.zznd()) {
                zzta = zznc.zzc(zztf);
            } else {
                zzta = zznc.zza(zztf);
            }
            if (!zzta.zzmv()) {
                zzazq.setException(new RuntimeException("No entry contents."));
                ci0.f8015c.m9107a();
                return;
            }
            di0 di0 = new di0(ci0, zzta.zzmw(), 1);
            int read = di0.read();
            if (read != -1) {
                di0.unread(read);
                zzazq.set(zztt.zza(di0, zzta.zzmy(), zzta.zznb(), zzta.zzna(), zzta.zzmz()));
                return;
            }
            throw new IOException("Unable to read from cache.");
        } catch (RemoteException | IOException e) {
            zzaza.zzc("Unable to obtain a cache service instance.", e);
            zzazq.setException(e);
            ci0.f8015c.m9107a();
        }
    }
}
