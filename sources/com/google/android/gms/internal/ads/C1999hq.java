package com.google.android.gms.internal.ads;

import android.os.IBinder;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdError;

/* renamed from: com.google.android.gms.internal.ads.hq */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1999hq implements zzbtf {

    /* renamed from: a */
    private boolean f9230a = false;

    /* renamed from: b */
    private final /* synthetic */ zzcrb f9231b;

    /* renamed from: c */
    private final /* synthetic */ zzazq f9232c;

    C1999hq(zzcvy zzcvy, zzcrb zzcrb, zzazq zzazq) {
        this.f9231b = zzcrb;
        this.f9232c = zzazq;
    }

    /* renamed from: a */
    private final void m6304a(zzve zzve) {
        zzdok zzdok = zzdok.INTERNAL_ERROR;
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcvf)).booleanValue()) {
            zzdok = zzdok.NO_FILL;
        }
        this.f9232c.setException(new zzcrd(zzdok, zzve));
    }

    public final void onAdFailedToLoad(int i) {
        if (!this.f9230a) {
            m6304a(new zzve(i, zzcvy.m8285b(this.f9231b.zzchy, i), AdError.UNDEFINED_DOMAIN, (zzve) null, (IBinder) null));
        }
    }

    public final synchronized void onAdLoaded() {
        this.f9232c.set(null);
    }

    public final synchronized void zzf(int i, @Nullable String str) {
        if (!this.f9230a) {
            this.f9230a = true;
            if (str == null) {
                str = zzcvy.m8285b(this.f9231b.zzchy, i);
            }
            m6304a(new zzve(i, str, AdError.UNDEFINED_DOMAIN, (zzve) null, (IBinder) null));
        }
    }

    public final synchronized void zzk(zzve zzve) {
        this.f9230a = true;
        m6304a(zzve);
    }
}
