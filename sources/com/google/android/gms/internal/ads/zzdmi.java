package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdmi extends zzavg {

    /* renamed from: a */
    private final zzdma f15757a;

    /* renamed from: b */
    private final zzdlf f15758b;

    /* renamed from: c */
    private final String f15759c;

    /* renamed from: d */
    private final zzdni f15760d;

    /* renamed from: e */
    private final Context f15761e;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable

    /* renamed from: f */
    public zzchc f15762f;

    public zzdmi(@Nullable String str, zzdma zzdma, Context context, zzdlf zzdlf, zzdni zzdni) {
        this.f15759c = str;
        this.f15757a = zzdma;
        this.f15758b = zzdlf;
        this.f15760d = zzdni;
        this.f15761e = context;
    }

    /* renamed from: c */
    private final synchronized void m8418c(zzvk zzvk, zzavp zzavp, int i) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.f15758b.zzb(zzavp);
        zzp.zzkq();
        if (zzm.zzbb(this.f15761e) && zzvk.zzchn == null) {
            zzaza.zzey("Failed to load the ad because app ID is missing.");
            this.f15758b.zzk(zzdoi.zza(zzdok.APP_ID_MISSING, (String) null, (zzve) null));
        } else if (this.f15762f == null) {
            zzdmb zzdmb = new zzdmb((String) null);
            this.f15757a.mo17142h(i);
            this.f15757a.zza(zzvk, this.f15759c, zzdmb, new C2081jy(this));
        }
    }

    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzchc zzchc = this.f15762f;
        return zzchc != null ? zzchc.getAdMetadata() : new Bundle();
    }

    public final synchronized String getMediationAdapterClassName() {
        zzchc zzchc = this.f15762f;
        if (zzchc == null || zzchc.zzajz() == null) {
            return null;
        }
        return this.f15762f.zzajz().getMediationAdapterClassName();
    }

    public final boolean isLoaded() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzchc zzchc = this.f15762f;
        return zzchc != null && !zzchc.isUsed();
    }

    public final synchronized void zza(zzvk zzvk, zzavp zzavp) {
        m8418c(zzvk, zzavp, zzdnf.zzhid);
    }

    public final synchronized void zzb(zzvk zzvk, zzavp zzavp) {
        m8418c(zzvk, zzavp, zzdnf.zzhie);
    }

    public final synchronized void zzh(IObjectWrapper iObjectWrapper) {
        zza(iObjectWrapper, false);
    }

    public final zzyn zzkh() {
        zzchc zzchc;
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcxv)).booleanValue() && (zzchc = this.f15762f) != null) {
            return zzchc.zzajz();
        }
        return null;
    }

    @Nullable
    public final zzavc zzre() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzchc zzchc = this.f15762f;
        if (zzchc != null) {
            return zzchc.zzre();
        }
        return null;
    }

    public final synchronized void zza(IObjectWrapper iObjectWrapper, boolean z) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.f15762f == null) {
            zzaza.zzfa("Rewarded can not be shown before loaded");
            this.f15758b.zzj(zzdoi.zza(zzdok.NOT_READY, (String) null, (zzve) null));
            return;
        }
        this.f15762f.zzb(z, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zza(zzavi zzavi) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.f15758b.zzb(zzavi);
    }

    public final void zza(zzavq zzavq) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.f15758b.zzb(zzavq);
    }

    public final void zza(zzyh zzyh) {
        if (zzyh == null) {
            this.f15758b.zza((AdMetadataListener) null);
        } else {
            this.f15758b.zza(new C2118ky(this, zzyh));
        }
    }

    public final synchronized void zza(zzavy zzavy) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdni zzdni = this.f15760d;
        zzdni.zzdxy = zzavy.zzdxy;
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcon)).booleanValue()) {
            zzdni.zzdxz = zzavy.zzdxz;
        }
    }

    public final void zza(zzym zzym) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        this.f15758b.zzd(zzym);
    }
}
