package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzaef implements NativeCustomTemplateAd.DisplayOpenMeasurement {

    /* renamed from: a */
    private final zzaff f12422a;

    public zzaef(zzaff zzaff) {
        this.f12422a = zzaff;
        try {
            zzaff.zztd();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void setView(View view) {
        try {
            this.f12422a.zzq(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final boolean start() {
        try {
            return this.f12422a.zztc();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return false;
        }
    }
}
