package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zztx {
    @VisibleForTesting

    /* renamed from: a */
    zzgy f17019a;
    @VisibleForTesting

    /* renamed from: b */
    boolean f17020b;

    public zztx(Context context, String str, String str2) {
        zzabf.initialize(context);
        try {
            this.f17019a = (zzgy) zzazd.zza(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", ii0.f9329a);
            ObjectWrapper.wrap(context);
            this.f17019a.zza(ObjectWrapper.wrap(context), str, (String) null);
            this.f17020b = true;
        } catch (RemoteException | zzazf | NullPointerException unused) {
            zzaza.zzeb("Cannot dynamite load clearcut");
        }
    }

    public final zzub zzf(byte[] bArr) {
        return new zzub(this, bArr);
    }

    public zztx(Context context) {
        zzabf.initialize(context);
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcuc)).booleanValue()) {
            try {
                this.f17019a = (zzgy) zzazd.zza(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", hi0.f9221a);
                ObjectWrapper.wrap(context);
                this.f17019a.zza(ObjectWrapper.wrap(context), "GMA_SDK");
                this.f17020b = true;
            } catch (RemoteException | zzazf | NullPointerException unused) {
                zzaza.zzeb("Cannot dynamite load clearcut");
            }
        }
    }

    public zztx() {
    }
}
