package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzyi implements MuteThisAdReason {

    /* renamed from: a */
    private final String f17107a;

    /* renamed from: b */
    private zzyd f17108b;

    public zzyi(zzyd zzyd) {
        String str;
        this.f17108b = zzyd;
        try {
            str = zzyd.getDescription();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            str = null;
        }
        this.f17107a = str;
    }

    public final String getDescription() {
        return this.f17107a;
    }

    public final String toString() {
        return this.f17107a;
    }

    public final zzyd zzqp() {
        return this.f17108b;
    }
}
