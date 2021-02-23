package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzzc {

    /* renamed from: a */
    private final zzanj f17151a;

    /* renamed from: b */
    private final AtomicBoolean f17152b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final VideoController f17153c;
    @VisibleForTesting

    /* renamed from: d */
    private final zzwp f17154d;

    /* renamed from: e */
    private zzva f17155e;

    /* renamed from: f */
    private AdListener f17156f;

    /* renamed from: g */
    private AdSize[] f17157g;

    /* renamed from: h */
    private AppEventListener f17158h;

    /* renamed from: i */
    private zzxg f17159i;

    /* renamed from: j */
    private OnCustomRenderedAdLoadedListener f17160j;

    /* renamed from: k */
    private VideoOptions f17161k;

    /* renamed from: l */
    private String f17162l;

    /* renamed from: m */
    private ViewGroup f17163m;

    /* renamed from: n */
    private int f17164n;

    /* renamed from: o */
    private boolean f17165o;
    @Nullable

    /* renamed from: p */
    private OnPaidEventListener f17166p;

    public zzzc(ViewGroup viewGroup) {
        this(viewGroup, (AttributeSet) null, false, zzvl.zzcho, 0);
    }

    /* renamed from: b */
    private static zzvn m9284b(Context context, AdSize[] adSizeArr, int i) {
        for (AdSize equals : adSizeArr) {
            if (equals.equals(AdSize.INVALID)) {
                return zzvn.zzpr();
            }
        }
        zzvn zzvn = new zzvn(context, adSizeArr);
        zzvn.zzchs = m9285c(i);
        return zzvn;
    }

    /* renamed from: c */
    private static boolean m9285c(int i) {
        return i == 1;
    }

    public final void destroy() {
        try {
            zzxg zzxg = this.f17159i;
            if (zzxg != null) {
                zzxg.destroy();
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final AdListener getAdListener() {
        return this.f17156f;
    }

    public final AdSize getAdSize() {
        zzvn zzkf;
        try {
            zzxg zzxg = this.f17159i;
            if (!(zzxg == null || (zzkf = zzxg.zzkf()) == null)) {
                return zzkf.zzps();
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
        AdSize[] adSizeArr = this.f17157g;
        if (adSizeArr != null) {
            return adSizeArr[0];
        }
        return null;
    }

    public final AdSize[] getAdSizes() {
        return this.f17157g;
    }

    public final String getAdUnitId() {
        zzxg zzxg;
        if (this.f17162l == null && (zzxg = this.f17159i) != null) {
            try {
                this.f17162l = zzxg.getAdUnitId();
            } catch (RemoteException e) {
                zzaza.zze("#007 Could not call remote method.", e);
            }
        }
        return this.f17162l;
    }

    public final AppEventListener getAppEventListener() {
        return this.f17158h;
    }

    public final String getMediationAdapterClassName() {
        try {
            zzxg zzxg = this.f17159i;
            if (zzxg != null) {
                return zzxg.zzkg();
            }
            return null;
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.f17160j;
    }

    @Nullable
    public final ResponseInfo getResponseInfo() {
        zzyn zzyn = null;
        try {
            zzxg zzxg = this.f17159i;
            if (zzxg != null) {
                zzyn = zzxg.zzkh();
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
        return ResponseInfo.zza(zzyn);
    }

    public final VideoController getVideoController() {
        return this.f17153c;
    }

    public final VideoOptions getVideoOptions() {
        return this.f17161k;
    }

    public final boolean isLoading() {
        try {
            zzxg zzxg = this.f17159i;
            if (zzxg != null) {
                return zzxg.isLoading();
            }
            return false;
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final void pause() {
        try {
            zzxg zzxg = this.f17159i;
            if (zzxg != null) {
                zzxg.pause();
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void recordManualImpression() {
        if (!this.f17152b.getAndSet(true)) {
            try {
                zzxg zzxg = this.f17159i;
                if (zzxg != null) {
                    zzxg.zzke();
                }
            } catch (RemoteException e) {
                zzaza.zze("#007 Could not call remote method.", e);
            }
        }
    }

    public final void resume() {
        try {
            zzxg zzxg = this.f17159i;
            if (zzxg != null) {
                zzxg.resume();
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setAdListener(AdListener adListener) {
        this.f17156f = adListener;
        this.f17154d.zza(adListener);
    }

    public final void setAdSizes(AdSize... adSizeArr) {
        if (this.f17157g == null) {
            zza(adSizeArr);
            return;
        }
        throw new IllegalStateException("The ad size can only be set once on AdView.");
    }

    public final void setAdUnitId(String str) {
        if (this.f17162l == null) {
            this.f17162l = str;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.f17158h = appEventListener;
            zzxg zzxg = this.f17159i;
            if (zzxg != null) {
                zzxg.zza((zzxo) appEventListener != null ? new zzvt(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.f17165o = z;
        try {
            zzxg zzxg = this.f17159i;
            if (zzxg != null) {
                zzxg.setManualImpressionsEnabled(z);
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.f17160j = onCustomRenderedAdLoadedListener;
        try {
            zzxg zzxg = this.f17159i;
            if (zzxg != null) {
                zzxg.zza((zzacb) onCustomRenderedAdLoadedListener != null ? new zzacc(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        try {
            this.f17166p = onPaidEventListener;
            zzxg zzxg = this.f17159i;
            if (zzxg != null) {
                zzxg.zza((zzym) new zzaaf(onPaidEventListener));
            }
        } catch (RemoteException e) {
            zzaza.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        zzaak zzaak;
        this.f17161k = videoOptions;
        try {
            zzxg zzxg = this.f17159i;
            if (zzxg != null) {
                if (videoOptions == null) {
                    zzaak = null;
                } else {
                    zzaak = new zzaak(videoOptions);
                }
                zzxg.zza(zzaak);
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzza zzza) {
        zzxg zzxg;
        try {
            zzxg zzxg2 = this.f17159i;
            if (zzxg2 == null) {
                if ((this.f17157g == null || this.f17162l == null) && zzxg2 == null) {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
                Context context = this.f17163m.getContext();
                zzvn b = m9284b(context, this.f17157g, this.f17164n);
                if ("search_v2".equals(b.zzacv)) {
                    zzxg = (zzxg) new gj0(zzwq.zzqb(), context, b, this.f17162l).mo14405b(context, false);
                } else {
                    zzxg = (zzxg) new yi0(zzwq.zzqb(), context, b, this.f17162l, this.f17151a).mo14405b(context, false);
                }
                this.f17159i = zzxg;
                zzxg.zza((zzwt) new zzvg(this.f17154d));
                if (this.f17155e != null) {
                    this.f17159i.zza((zzws) new zzuz(this.f17155e));
                }
                if (this.f17158h != null) {
                    this.f17159i.zza((zzxo) new zzvt(this.f17158h));
                }
                if (this.f17160j != null) {
                    this.f17159i.zza((zzacb) new zzacc(this.f17160j));
                }
                if (this.f17161k != null) {
                    this.f17159i.zza(new zzaak(this.f17161k));
                }
                this.f17159i.zza((zzym) new zzaaf(this.f17166p));
                this.f17159i.setManualImpressionsEnabled(this.f17165o);
                try {
                    IObjectWrapper zzkd = this.f17159i.zzkd();
                    if (zzkd != null) {
                        this.f17163m.addView((View) ObjectWrapper.unwrap(zzkd));
                    }
                } catch (RemoteException e) {
                    zzaza.zze("#007 Could not call remote method.", e);
                }
            }
            if (this.f17159i.zza(zzvl.zza(this.f17163m.getContext(), zzza))) {
                this.f17151a.zzf(zzza.zzqu());
            }
        } catch (RemoteException e2) {
            zzaza.zze("#007 Could not call remote method.", e2);
        }
    }

    public final zzys zzdw() {
        zzxg zzxg = this.f17159i;
        if (zzxg == null) {
            return null;
        }
        try {
            return zzxg.getVideoController();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public zzzc(ViewGroup viewGroup, int i) {
        this(viewGroup, (AttributeSet) null, false, zzvl.zzcho, i);
    }

    public zzzc(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzvl.zzcho, 0);
    }

    public zzzc(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i) {
        this(viewGroup, attributeSet, false, zzvl.zzcho, i);
    }

    @VisibleForTesting
    private zzzc(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzvl zzvl, zzxg zzxg, int i) {
        zzvn zzvn;
        this.f17151a = new zzanj();
        this.f17153c = new VideoController();
        this.f17154d = new nj0(this);
        this.f17163m = viewGroup;
        this.f17159i = null;
        this.f17152b = new AtomicBoolean(false);
        this.f17164n = i;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzvy zzvy = new zzvy(context, attributeSet);
                this.f17157g = zzvy.zzy(z);
                this.f17162l = zzvy.getAdUnitId();
                if (viewGroup.isInEditMode()) {
                    zzayr zzqa = zzwq.zzqa();
                    AdSize adSize = this.f17157g[0];
                    int i2 = this.f17164n;
                    if (adSize.equals(AdSize.INVALID)) {
                        zzvn = zzvn.zzpr();
                    } else {
                        zzvn zzvn2 = new zzvn(context, adSize);
                        zzvn2.zzchs = m9285c(i2);
                        zzvn = zzvn2;
                    }
                    zzqa.zza(viewGroup, zzvn, "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                zzwq.zzqa().zza(viewGroup, new zzvn(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }

    @VisibleForTesting
    private zzzc(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzvl zzvl, int i) {
        this(viewGroup, attributeSet, z, zzvl, (zzxg) null, i);
    }

    public final void zza(zzva zzva) {
        try {
            this.f17155e = zzva;
            zzxg zzxg = this.f17159i;
            if (zzxg != null) {
                zzxg.zza((zzws) zzva != null ? new zzuz(zzva) : null);
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zza(AdSize... adSizeArr) {
        this.f17157g = adSizeArr;
        try {
            zzxg zzxg = this.f17159i;
            if (zzxg != null) {
                zzxg.zza(m9284b(this.f17163m.getContext(), this.f17157g, this.f17164n));
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
        this.f17163m.requestLayout();
    }

    public final boolean zza(zzxg zzxg) {
        if (zzxg == null) {
            return false;
        }
        try {
            IObjectWrapper zzkd = zzxg.zzkd();
            if (zzkd == null || ((View) ObjectWrapper.unwrap(zzkd)).getParent() != null) {
                return false;
            }
            this.f17163m.addView((View) ObjectWrapper.unwrap(zzkd));
            this.f17159i = zzxg;
            return true;
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return false;
        }
    }
}
