package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.instream.InstreamAd;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzajy {

    /* renamed from: a */
    private final Context f12494a;

    /* renamed from: b */
    private final zzwz f12495b;

    public zzajy(Context context, String str) {
        this((Context) Preconditions.checkNotNull(context, "context cannot be null"), zzwq.zzqb().zzb(context, str, new zzanj()));
    }

    public final zzajy zza(InstreamAd.InstreamAdLoadCallback instreamAdLoadCallback) {
        try {
            this.f12495b.zza((zzajt) new zzajw(instreamAdLoadCallback));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
        return this;
    }

    public final zzajz zztr() {
        try {
            return new zzajz(this.f12494a, this.f12495b.zzqj());
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final zzajy zza(zzajx zzajx) {
        try {
            this.f12495b.zza(new zzajl(zzajx));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
        return this;
    }

    private zzajy(Context context, zzwz zzwz) {
        this.f12494a = context;
        this.f12495b = zzwz;
    }
}
