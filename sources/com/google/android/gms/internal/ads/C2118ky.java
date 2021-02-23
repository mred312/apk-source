package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;

/* renamed from: com.google.android.gms.internal.ads.ky */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2118ky extends AdMetadataListener {

    /* renamed from: a */
    private final /* synthetic */ zzyh f9782a;

    /* renamed from: b */
    private final /* synthetic */ zzdmi f9783b;

    C2118ky(zzdmi zzdmi, zzyh zzyh) {
        this.f9783b = zzdmi;
        this.f9782a = zzyh;
    }

    public final void onAdMetadataChanged() {
        if (this.f9783b.f15762f != null) {
            try {
                this.f9782a.onAdMetadataChanged();
            } catch (RemoteException e) {
                zzaza.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
