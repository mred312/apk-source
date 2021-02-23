package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbly extends zzsj {

    /* renamed from: a */
    private final zzblv f13477a;

    /* renamed from: b */
    private final zzxg f13478b;

    /* renamed from: c */
    private final zzdir f13479c;

    public zzbly(zzblv zzblv, zzxg zzxg, zzdir zzdir) {
        this.f13477a = zzblv;
        this.f13478b = zzxg;
        this.f13479c = zzdir;
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzsq zzsq) {
        try {
            this.f13479c.zza(zzsq);
            this.f13477a.zza((Activity) ObjectWrapper.unwrap(iObjectWrapper), zzsq);
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzsm zzsm) {
    }

    public final zzxg zzdx() {
        return this.f13478b;
    }

    public final zzyn zzkh() {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcxv)).booleanValue()) {
            return null;
        }
        return this.f13477a.zzajz();
    }
}
