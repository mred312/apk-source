package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.ConnectionResult;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcnx extends zzcnu {

    /* renamed from: a */
    private String f14645a;

    /* renamed from: b */
    private int f14646b = C2069jm.f9533a;

    public zzcnx(Context context) {
        this.zzgni = new zzast(context, zzp.zzle().zzyw(), this, this);
    }

    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.mLock) {
            if (!this.zzgng) {
                this.zzgng = true;
                try {
                    int i = this.f14646b;
                    if (i == C2069jm.f9534b) {
                        this.zzgni.zzvq().zzc(this.zzgnh, new zzcnt(this));
                    } else if (i == C2069jm.f9535c) {
                        this.zzgni.zzvq().zza(this.f14645a, (zzatf) new zzcnt(this));
                    } else {
                        this.zzdkm.setException(new zzcoh(zzdok.INTERNAL_ERROR));
                    }
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zzdkm.setException(new zzcoh(zzdok.INTERNAL_ERROR));
                } catch (Throwable th) {
                    zzp.zzku().zza(th, "RemoteUrlAndCacheKeyClientTask.onConnected");
                    this.zzdkm.setException(new zzcoh(zzdok.INTERNAL_ERROR));
                }
            }
        }
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzaza.zzeb("Cannot connect to remote service, fallback to local instance.");
        this.zzdkm.setException(new zzcoh(zzdok.INTERNAL_ERROR));
    }

    public final zzdyz<InputStream> zzgi(String str) {
        synchronized (this.mLock) {
            int i = this.f14646b;
            if (i != C2069jm.f9533a && i != C2069jm.f9535c) {
                zzdyz<InputStream> immediateFailedFuture = zzdyr.immediateFailedFuture(new zzcoh(zzdok.INVALID_REQUEST));
                return immediateFailedFuture;
            } else if (this.zzgnf) {
                zzazq<InputStream> zzazq = this.zzdkm;
                return zzazq;
            } else {
                this.f14646b = C2069jm.f9535c;
                this.zzgnf = true;
                this.f14645a = str;
                this.zzgni.checkAvailabilityAndConnect();
                this.zzdkm.addListener(new C1921fm(this), zzazj.zzegu);
                zzazq<InputStream> zzazq2 = this.zzdkm;
                return zzazq2;
            }
        }
    }

    public final zzdyz<InputStream> zzk(zzatl zzatl) {
        synchronized (this.mLock) {
            int i = this.f14646b;
            if (i != C2069jm.f9533a && i != C2069jm.f9534b) {
                zzdyz<InputStream> immediateFailedFuture = zzdyr.immediateFailedFuture(new zzcoh(zzdok.INVALID_REQUEST));
                return immediateFailedFuture;
            } else if (this.zzgnf) {
                zzazq<InputStream> zzazq = this.zzdkm;
                return zzazq;
            } else {
                this.f14646b = C2069jm.f9534b;
                this.zzgnf = true;
                this.zzgnh = zzatl;
                this.zzgni.checkAvailabilityAndConnect();
                this.zzdkm.addListener(new C1995hm(this), zzazj.zzegu);
                zzazq<InputStream> zzazq2 = this.zzdkm;
                return zzazq2;
            }
        }
    }
}
