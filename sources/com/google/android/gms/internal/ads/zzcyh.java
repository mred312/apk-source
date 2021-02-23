package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcyh {

    /* renamed from: a */
    private final zzcyl<zzboc> f15057a;

    /* renamed from: b */
    private final String f15058b;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable

    /* renamed from: c */
    public zzyn f15059c;
    /* access modifiers changed from: private */
    @GuardedBy("this")

    /* renamed from: d */
    public boolean f15060d;

    public zzcyh(zzcyl<zzboc> zzcyl, String str) {
        this.f15057a = zzcyl;
        this.f15058b = str;
    }

    public final synchronized String getMediationAdapterClassName() {
        try {
            zzyn zzyn = this.f15059c;
            if (zzyn == null) {
                return null;
            }
            return zzyn.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final synchronized boolean isLoading() {
        return this.f15057a.isLoading();
    }

    public final synchronized void zza(zzvk zzvk, int i) {
        this.f15059c = null;
        this.f15057a.zza(zzvk, this.f15058b, new zzcyq(i), new C2148lr(this));
    }

    public final synchronized String zzkg() {
        try {
            zzyn zzyn = this.f15059c;
            if (zzyn == null) {
                return null;
            }
            return zzyn.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return null;
        }
    }
}
