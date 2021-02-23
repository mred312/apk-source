package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdjf extends zzxf implements zzp, zzsc {

    /* renamed from: a */
    private final zzbgm f15689a;

    /* renamed from: b */
    private final Context f15690b;

    /* renamed from: c */
    private AtomicBoolean f15691c = new AtomicBoolean();

    /* renamed from: d */
    private final String f15692d;

    /* renamed from: e */
    private final zzdjd f15693e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final zzdir f15694f;
    @GuardedBy("this")

    /* renamed from: g */
    private long f15695g = -1;
    @GuardedBy("this")
    @Nullable

    /* renamed from: h */
    private zzbkv f15696h;
    @GuardedBy("this")
    @Nullable
    protected zzblv zzhee;

    public zzdjf(zzbgm zzbgm, Context context, String str, zzdjd zzdjd, zzdir zzdir) {
        this.f15689a = zzbgm;
        this.f15690b = context;
        this.f15692d = str;
        this.f15693e = zzdjd;
        this.f15694f = zzdir;
        zzdir.zza((zzp) this);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m8390b(zzblv zzblv) {
        zzblv.zza(this);
    }

    /* renamed from: f */
    private final synchronized void m8392f(int i) {
        if (this.f15691c.compareAndSet(false, true)) {
            this.f15694f.onAdClosed();
            zzbkv zzbkv = this.f15696h;
            if (zzbkv != null) {
                com.google.android.gms.ads.internal.zzp.zzkt().zzb(zzbkv);
            }
            if (this.zzhee != null) {
                long j = -1;
                if (this.f15695g != -1) {
                    j = com.google.android.gms.ads.internal.zzp.zzkx().elapsedRealtime() - this.f15695g;
                }
                this.zzhee.zzb(j, i);
            }
            destroy();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ void mo17123d() {
        this.f15689a.zzaek().execute(new C2005hw(this));
    }

    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzblv zzblv = this.zzhee;
        if (zzblv != null) {
            zzblv.destroy();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final /* synthetic */ void mo17124e() {
        m8392f(zzblb.zzfsj);
    }

    public final Bundle getAdMetadata() {
        return new Bundle();
    }

    public final synchronized String getAdUnitId() {
        return this.f15692d;
    }

    public final synchronized String getMediationAdapterClassName() {
        return null;
    }

    public final synchronized zzys getVideoController() {
        return null;
    }

    public final synchronized boolean isLoading() {
        return this.f15693e.isLoading();
    }

    public final boolean isReady() {
        return false;
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public final synchronized void onUserLeaveHint() {
        zzblv zzblv = this.zzhee;
        if (zzblv != null) {
            zzblv.zzb(com.google.android.gms.ads.internal.zzp.zzkx().elapsedRealtime() - this.f15695g, zzblb.zzfsf);
        }
    }

    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    public final void setImmersiveMode(boolean z) {
    }

    public final synchronized void setManualImpressionsEnabled(boolean z) {
    }

    public final void setUserId(String str) {
    }

    public final synchronized void showInterstitial() {
    }

    public final void stopLoading() {
    }

    public final void zza(zzart zzart) {
    }

    public final void zza(zzarz zzarz, String str) {
    }

    public final void zza(zzaup zzaup) {
    }

    public final void zza(zzvw zzvw) {
        this.f15693e.zza(zzvw);
    }

    public final void zza(zzws zzws) {
    }

    public final void zza(zzwt zzwt) {
    }

    public final void zza(zzxj zzxj) {
    }

    public final void zza(zzxo zzxo) {
    }

    public final void zza(zzym zzym) {
    }

    public final void zza(zzyy zzyy) {
    }

    public final void zzbl(String str) {
    }

    public final IObjectWrapper zzkd() {
        return null;
    }

    public final synchronized void zzke() {
    }

    public final synchronized zzvn zzkf() {
        return null;
    }

    public final synchronized String zzkg() {
        return null;
    }

    public final synchronized zzyn zzkh() {
        return null;
    }

    public final zzxo zzki() {
        return null;
    }

    public final zzwt zzkj() {
        return null;
    }

    public final void zzms() {
        m8392f(zzblb.zzfsh);
    }

    public final synchronized void zzux() {
        if (this.zzhee != null) {
            this.f15695g = com.google.android.gms.ads.internal.zzp.zzkx().elapsedRealtime();
            int zzaip = this.zzhee.zzaip();
            if (zzaip > 0) {
                zzbkv zzbkv = new zzbkv(this.f15689a.zzael(), com.google.android.gms.ads.internal.zzp.zzkx());
                this.f15696h = zzbkv;
                zzbkv.zza(zzaip, new C2079jw(this));
            }
        }
    }

    public final synchronized boolean zza(zzvk zzvk) {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        com.google.android.gms.ads.internal.zzp.zzkq();
        if (zzm.zzbb(this.f15690b) && zzvk.zzchn == null) {
            zzaza.zzey("Failed to load the ad because app ID is missing.");
            this.f15694f.zzk(zzdoi.zza(zzdok.APP_ID_MISSING, (String) null, (zzve) null));
            return false;
        } else if (isLoading()) {
            return false;
        } else {
            this.f15691c = new AtomicBoolean();
            return this.f15693e.zza(zzvk, this.f15692d, new C2042iw(this), new C2153lw(this));
        }
    }

    public final void zza(zzl zzl) {
        int i = C2116kw.f9780a[zzl.ordinal()];
        if (i == 1) {
            m8392f(zzblb.zzfsh);
        } else if (i == 2) {
            m8392f(zzblb.zzfsg);
        } else if (i == 3) {
            m8392f(zzblb.zzfsi);
        } else if (i == 4) {
            m8392f(zzblb.zzfsk);
        }
    }

    public final void zza(zzsl zzsl) {
        this.f15694f.zzb(zzsl);
    }

    public final synchronized void zza(zzvn zzvn) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
    }

    public final synchronized void zza(zzxu zzxu) {
    }

    public final synchronized void zza(zzaak zzaak) {
    }

    public final synchronized void zza(zzacb zzacb) {
    }
}
