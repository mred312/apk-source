package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.ConnectionResult;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcns extends zzcnu {
    public zzcns(Context context) {
        this.zzgni = new zzast(context, zzp.zzle().zzyw(), this, this);
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.mLock) {
            if (!this.zzgng) {
                this.zzgng = true;
                try {
                    this.zzgni.zzvq().zza(this.zzgnh, (zzatf) new zzcnt(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zzdkm.setException(new zzcoh(zzdok.INTERNAL_ERROR));
                } catch (Throwable th) {
                    zzp.zzku().zza(th, "RemoteAdRequestClientTask.onConnected");
                    this.zzdkm.setException(new zzcoh(zzdok.INTERNAL_ERROR));
                }
            }
        }
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzaza.zzeb("Cannot connect to remote service, fallback to local instance.");
        this.zzdkm.setException(new zzcoh(zzdok.INTERNAL_ERROR));
    }

    public final zzdyz<InputStream> zzi(zzatl zzatl) {
        synchronized (this.mLock) {
            if (this.zzgnf) {
                zzazq<InputStream> zzazq = this.zzdkm;
                return zzazq;
            }
            this.zzgnf = true;
            this.zzgnh = zzatl;
            this.zzgni.checkAvailabilityAndConnect();
            this.zzdkm.addListener(new C1847dm(this), zzazj.zzegu);
            zzazq<InputStream> zzazq2 = this.zzdkm;
            return zzazq2;
        }
    }
}
