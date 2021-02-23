package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzp;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcnw extends zzcnu {
    public zzcnw(Context context) {
        this.zzgni = new zzast(context, zzp.zzle().zzyw(), this, this);
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.mLock) {
            if (!this.zzgng) {
                this.zzgng = true;
                try {
                    this.zzgni.zzvq().zzb(this.zzgnh, new zzcnt(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zzdkm.setException(new zzcoh(zzdok.INTERNAL_ERROR));
                } catch (Throwable th) {
                    zzp.zzku().zza(th, "RemoteSignalsClientTask.onConnected");
                    this.zzdkm.setException(new zzcoh(zzdok.INTERNAL_ERROR));
                }
            }
        }
    }

    public final zzdyz<InputStream> zzj(zzatl zzatl) {
        synchronized (this.mLock) {
            if (this.zzgnf) {
                zzazq<InputStream> zzazq = this.zzdkm;
                return zzazq;
            }
            this.zzgnf = true;
            this.zzgnh = zzatl;
            this.zzgni.checkAvailabilityAndConnect();
            this.zzdkm.addListener(new C1884em(this), zzazj.zzegu);
            zzazq<InputStream> zzazq2 = this.zzdkm;
            return zzazq2;
        }
    }
}
