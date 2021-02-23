package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzze {

    /* renamed from: a */
    private final zzanj f17177a;

    /* renamed from: b */
    private final Context f17178b;

    /* renamed from: c */
    private AdListener f17179c;

    /* renamed from: d */
    private zzva f17180d;

    /* renamed from: e */
    private zzxg f17181e;

    /* renamed from: f */
    private String f17182f;

    /* renamed from: g */
    private AdMetadataListener f17183g;

    /* renamed from: h */
    private AppEventListener f17184h;

    /* renamed from: i */
    private OnCustomRenderedAdLoadedListener f17185i;

    /* renamed from: j */
    private RewardedVideoAdListener f17186j;

    /* renamed from: k */
    private boolean f17187k;

    /* renamed from: l */
    private boolean f17188l;
    @Nullable

    /* renamed from: m */
    private OnPaidEventListener f17189m;

    public zzze(Context context) {
        this(context, zzvl.zzcho, (PublisherInterstitialAd) null);
    }

    /* renamed from: a */
    private final void m9294a(String str) {
        if (this.f17181e == null) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63);
            sb.append("The ad unit ID must be set on InterstitialAd before ");
            sb.append(str);
            sb.append(" is called.");
            throw new IllegalStateException(sb.toString());
        }
    }

    public final AdListener getAdListener() {
        return this.f17179c;
    }

    public final Bundle getAdMetadata() {
        try {
            zzxg zzxg = this.f17181e;
            if (zzxg != null) {
                return zzxg.getAdMetadata();
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
        return new Bundle();
    }

    public final String getAdUnitId() {
        return this.f17182f;
    }

    public final AppEventListener getAppEventListener() {
        return this.f17184h;
    }

    public final String getMediationAdapterClassName() {
        try {
            zzxg zzxg = this.f17181e;
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
        return this.f17185i;
    }

    public final ResponseInfo getResponseInfo() {
        zzyn zzyn = null;
        try {
            zzxg zzxg = this.f17181e;
            if (zzxg != null) {
                zzyn = zzxg.zzkh();
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
        return ResponseInfo.zza(zzyn);
    }

    public final boolean isLoaded() {
        try {
            zzxg zzxg = this.f17181e;
            if (zzxg == null) {
                return false;
            }
            return zzxg.isReady();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final boolean isLoading() {
        try {
            zzxg zzxg = this.f17181e;
            if (zzxg == null) {
                return false;
            }
            return zzxg.isLoading();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final void setAdListener(AdListener adListener) {
        try {
            this.f17179c = adListener;
            zzxg zzxg = this.f17181e;
            if (zzxg != null) {
                zzxg.zza((zzwt) adListener != null ? new zzvg(adListener) : null);
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        try {
            this.f17183g = adMetadataListener;
            zzxg zzxg = this.f17181e;
            if (zzxg != null) {
                zzxg.zza((zzxj) adMetadataListener != null ? new zzvh(adMetadataListener) : null);
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setAdUnitId(String str) {
        if (this.f17182f == null) {
            this.f17182f = str;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.f17184h = appEventListener;
            zzxg zzxg = this.f17181e;
            if (zzxg != null) {
                zzxg.zza((zzxo) appEventListener != null ? new zzvt(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setImmersiveMode(boolean z) {
        try {
            this.f17188l = z;
            zzxg zzxg = this.f17181e;
            if (zzxg != null) {
                zzxg.setImmersiveMode(z);
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        try {
            this.f17185i = onCustomRenderedAdLoadedListener;
            zzxg zzxg = this.f17181e;
            if (zzxg != null) {
                zzxg.zza((zzacb) onCustomRenderedAdLoadedListener != null ? new zzacc(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        try {
            this.f17189m = onPaidEventListener;
            zzxg zzxg = this.f17181e;
            if (zzxg != null) {
                zzxg.zza((zzym) new zzaaf(onPaidEventListener));
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        try {
            this.f17186j = rewardedVideoAdListener;
            zzxg zzxg = this.f17181e;
            if (zzxg != null) {
                zzxg.zza((zzaup) rewardedVideoAdListener != null ? new zzaus(rewardedVideoAdListener) : null);
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void show() {
        try {
            m9294a("show");
            this.f17181e.showInterstitial();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzza zzza) {
        try {
            if (this.f17181e == null) {
                if (this.f17182f == null) {
                    m9294a("loadAd");
                }
                zzvn zzpp = this.f17187k ? zzvn.zzpp() : new zzvn();
                zzvx zzqb = zzwq.zzqb();
                Context context = this.f17178b;
                zzxg zzxg = (zzxg) new fj0(zzqb, context, zzpp, this.f17182f, this.f17177a).mo14405b(context, false);
                this.f17181e = zzxg;
                if (this.f17179c != null) {
                    zzxg.zza((zzwt) new zzvg(this.f17179c));
                }
                if (this.f17180d != null) {
                    this.f17181e.zza((zzws) new zzuz(this.f17180d));
                }
                if (this.f17183g != null) {
                    this.f17181e.zza((zzxj) new zzvh(this.f17183g));
                }
                if (this.f17184h != null) {
                    this.f17181e.zza((zzxo) new zzvt(this.f17184h));
                }
                if (this.f17185i != null) {
                    this.f17181e.zza((zzacb) new zzacc(this.f17185i));
                }
                if (this.f17186j != null) {
                    this.f17181e.zza((zzaup) new zzaus(this.f17186j));
                }
                this.f17181e.zza((zzym) new zzaaf(this.f17189m));
                this.f17181e.setImmersiveMode(this.f17188l);
            }
            if (this.f17181e.zza(zzvl.zza(this.f17178b, zzza))) {
                this.f17177a.zzf(zzza.zzqu());
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zzd(boolean z) {
        this.f17187k = true;
    }

    public zzze(Context context, PublisherInterstitialAd publisherInterstitialAd) {
        this(context, zzvl.zzcho, publisherInterstitialAd);
    }

    @VisibleForTesting
    private zzze(Context context, zzvl zzvl, PublisherInterstitialAd publisherInterstitialAd) {
        this.f17177a = new zzanj();
        this.f17178b = context;
    }

    public final void zza(zzva zzva) {
        try {
            this.f17180d = zzva;
            zzxg zzxg = this.f17181e;
            if (zzxg != null) {
                zzxg.zza((zzws) zzva != null ? new zzuz(zzva) : null);
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }
}
