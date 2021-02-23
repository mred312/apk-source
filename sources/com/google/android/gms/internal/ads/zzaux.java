package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzaux implements RewardedVideoAd {
    @NonNull

    /* renamed from: a */
    private final zzaui f12857a;

    /* renamed from: b */
    private final Context f12858b;

    /* renamed from: c */
    private final Object f12859c = new Object();

    /* renamed from: d */
    private final zzaus f12860d = new zzaus((RewardedVideoAdListener) null);

    /* renamed from: e */
    private String f12861e;

    /* renamed from: f */
    private String f12862f;

    public zzaux(Context context, @Nullable zzaui zzaui) {
        this.f12857a = zzaui == null ? new zzaaa() : zzaui;
        this.f12858b = context.getApplicationContext();
    }

    /* renamed from: a */
    private final void m7562a(String str, zzza zzza) {
        synchronized (this.f12859c) {
            zzaui zzaui = this.f12857a;
            if (zzaui != null) {
                try {
                    zzaui.zza(zzvl.zza(this.f12858b, zzza, str));
                } catch (RemoteException e) {
                    zzaza.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void destroy() {
        destroy((Context) null);
    }

    public final Bundle getAdMetadata() {
        synchronized (this.f12859c) {
            zzaui zzaui = this.f12857a;
            if (zzaui != null) {
                try {
                    Bundle adMetadata = zzaui.getAdMetadata();
                    return adMetadata;
                } catch (RemoteException e) {
                    zzaza.zze("#007 Could not call remote method.", e);
                }
            }
            Bundle bundle = new Bundle();
            return bundle;
        }
    }

    public final String getCustomData() {
        String str;
        synchronized (this.f12859c) {
            str = this.f12862f;
        }
        return str;
    }

    public final String getMediationAdapterClassName() {
        try {
            zzaui zzaui = this.f12857a;
            if (zzaui != null) {
                return zzaui.getMediationAdapterClassName();
            }
            return null;
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final ResponseInfo getResponseInfo() {
        zzyn zzyn = null;
        try {
            zzaui zzaui = this.f12857a;
            if (zzaui != null) {
                zzyn = zzaui.zzkh();
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
        return ResponseInfo.zza(zzyn);
    }

    public final RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener rewardedVideoAdListener;
        synchronized (this.f12859c) {
            rewardedVideoAdListener = this.f12860d.getRewardedVideoAdListener();
        }
        return rewardedVideoAdListener;
    }

    public final String getUserId() {
        String str;
        synchronized (this.f12859c) {
            str = this.f12861e;
        }
        return str;
    }

    public final boolean isLoaded() {
        synchronized (this.f12859c) {
            zzaui zzaui = this.f12857a;
            if (zzaui == null) {
                return false;
            }
            try {
                boolean isLoaded = zzaui.isLoaded();
                return isLoaded;
            } catch (RemoteException e) {
                zzaza.zze("#007 Could not call remote method.", e);
                return false;
            }
        }
    }

    public final void loadAd(String str, AdRequest adRequest) {
        m7562a(str, adRequest.zzds());
    }

    public final void pause() {
        pause((Context) null);
    }

    public final void resume() {
        resume((Context) null);
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        synchronized (this.f12859c) {
            zzaui zzaui = this.f12857a;
            if (zzaui != null) {
                try {
                    zzaui.zza((zzxj) new zzvh(adMetadataListener));
                } catch (RemoteException e) {
                    zzaza.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void setCustomData(String str) {
        synchronized (this.f12859c) {
            zzaui zzaui = this.f12857a;
            if (zzaui != null) {
                try {
                    zzaui.setCustomData(str);
                    this.f12862f = str;
                } catch (RemoteException e) {
                    zzaza.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void setImmersiveMode(boolean z) {
        synchronized (this.f12859c) {
            zzaui zzaui = this.f12857a;
            if (zzaui != null) {
                try {
                    zzaui.setImmersiveMode(z);
                } catch (RemoteException e) {
                    zzaza.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        synchronized (this.f12859c) {
            this.f12860d.setRewardedVideoAdListener(rewardedVideoAdListener);
            zzaui zzaui = this.f12857a;
            if (zzaui != null) {
                try {
                    zzaui.zza((zzaup) this.f12860d);
                } catch (RemoteException e) {
                    zzaza.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void setUserId(String str) {
        synchronized (this.f12859c) {
            this.f12861e = str;
            zzaui zzaui = this.f12857a;
            if (zzaui != null) {
                try {
                    zzaui.setUserId(str);
                } catch (RemoteException e) {
                    zzaza.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void show() {
        synchronized (this.f12859c) {
            zzaui zzaui = this.f12857a;
            if (zzaui != null) {
                try {
                    zzaui.show();
                } catch (RemoteException e) {
                    zzaza.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void destroy(Context context) {
        synchronized (this.f12859c) {
            this.f12860d.setRewardedVideoAdListener((RewardedVideoAdListener) null);
            zzaui zzaui = this.f12857a;
            if (zzaui != null) {
                try {
                    zzaui.zzl(ObjectWrapper.wrap(context));
                } catch (RemoteException e) {
                    zzaza.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void loadAd(String str, PublisherAdRequest publisherAdRequest) {
        m7562a(str, publisherAdRequest.zzds());
    }

    public final void pause(Context context) {
        synchronized (this.f12859c) {
            zzaui zzaui = this.f12857a;
            if (zzaui != null) {
                try {
                    zzaui.zzj(ObjectWrapper.wrap(context));
                } catch (RemoteException e) {
                    zzaza.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void resume(Context context) {
        synchronized (this.f12859c) {
            zzaui zzaui = this.f12857a;
            if (zzaui != null) {
                try {
                    zzaui.zzk(ObjectWrapper.wrap(context));
                } catch (RemoteException e) {
                    zzaza.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }
}
