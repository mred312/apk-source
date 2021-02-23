package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzagk extends UnifiedNativeAd {

    /* renamed from: a */
    private final zzagj f12447a;

    /* renamed from: b */
    private final List<NativeAd.Image> f12448b = new ArrayList();

    /* renamed from: c */
    private final zzaek f12449c;

    /* renamed from: d */
    private final VideoController f12450d = new VideoController();

    /* renamed from: e */
    private final NativeAd.AdChoicesInfo f12451e;

    /* renamed from: f */
    private final List<MuteThisAdReason> f12452f = new ArrayList();

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ae A[Catch:{ RemoteException -> 0x00bb }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzagk(com.google.android.gms.internal.ads.zzagj r6) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            r5.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.f12448b = r1
            com.google.android.gms.ads.VideoController r1 = new com.google.android.gms.ads.VideoController
            r1.<init>()
            r5.f12450d = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.f12452f = r1
            r5.f12447a = r6
            r1 = 0
            java.util.List r6 = r6.getImages()     // Catch:{ RemoteException -> 0x005a }
            if (r6 == 0) goto L_0x005e
            java.util.Iterator r6 = r6.iterator()     // Catch:{ RemoteException -> 0x005a }
        L_0x0027:
            boolean r2 = r6.hasNext()     // Catch:{ RemoteException -> 0x005a }
            if (r2 == 0) goto L_0x005e
            java.lang.Object r2 = r6.next()     // Catch:{ RemoteException -> 0x005a }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x005a }
            if (r3 == 0) goto L_0x004c
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x005a }
            if (r2 == 0) goto L_0x004c
            java.lang.String r3 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)     // Catch:{ RemoteException -> 0x005a }
            boolean r4 = r3 instanceof com.google.android.gms.internal.ads.zzaej     // Catch:{ RemoteException -> 0x005a }
            if (r4 == 0) goto L_0x0046
            com.google.android.gms.internal.ads.zzaej r3 = (com.google.android.gms.internal.ads.zzaej) r3     // Catch:{ RemoteException -> 0x005a }
            goto L_0x004d
        L_0x0046:
            com.google.android.gms.internal.ads.zzael r3 = new com.google.android.gms.internal.ads.zzael     // Catch:{ RemoteException -> 0x005a }
            r3.<init>(r2)     // Catch:{ RemoteException -> 0x005a }
            goto L_0x004d
        L_0x004c:
            r3 = r1
        L_0x004d:
            if (r3 == 0) goto L_0x0027
            java.util.List<com.google.android.gms.ads.formats.NativeAd$Image> r2 = r5.f12448b     // Catch:{ RemoteException -> 0x005a }
            com.google.android.gms.internal.ads.zzaek r4 = new com.google.android.gms.internal.ads.zzaek     // Catch:{ RemoteException -> 0x005a }
            r4.<init>(r3)     // Catch:{ RemoteException -> 0x005a }
            r2.add(r4)     // Catch:{ RemoteException -> 0x005a }
            goto L_0x0027
        L_0x005a:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzaza.zzc(r0, r6)
        L_0x005e:
            com.google.android.gms.internal.ads.zzagj r6 = r5.f12447a     // Catch:{ RemoteException -> 0x008d }
            java.util.List r6 = r6.getMuteThisAdReasons()     // Catch:{ RemoteException -> 0x008d }
            if (r6 == 0) goto L_0x0091
            java.util.Iterator r6 = r6.iterator()     // Catch:{ RemoteException -> 0x008d }
        L_0x006a:
            boolean r2 = r6.hasNext()     // Catch:{ RemoteException -> 0x008d }
            if (r2 == 0) goto L_0x0091
            java.lang.Object r2 = r6.next()     // Catch:{ RemoteException -> 0x008d }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x008d }
            if (r3 == 0) goto L_0x007f
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x008d }
            com.google.android.gms.internal.ads.zzyd r2 = com.google.android.gms.internal.ads.zzyg.zzg(r2)     // Catch:{ RemoteException -> 0x008d }
            goto L_0x0080
        L_0x007f:
            r2 = r1
        L_0x0080:
            if (r2 == 0) goto L_0x006a
            java.util.List<com.google.android.gms.ads.MuteThisAdReason> r3 = r5.f12452f     // Catch:{ RemoteException -> 0x008d }
            com.google.android.gms.internal.ads.zzyi r4 = new com.google.android.gms.internal.ads.zzyi     // Catch:{ RemoteException -> 0x008d }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x008d }
            r3.add(r4)     // Catch:{ RemoteException -> 0x008d }
            goto L_0x006a
        L_0x008d:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzaza.zzc(r0, r6)
        L_0x0091:
            com.google.android.gms.internal.ads.zzagj r6 = r5.f12447a     // Catch:{ RemoteException -> 0x009f }
            com.google.android.gms.internal.ads.zzaej r6 = r6.zzsw()     // Catch:{ RemoteException -> 0x009f }
            if (r6 == 0) goto L_0x00a3
            com.google.android.gms.internal.ads.zzaek r2 = new com.google.android.gms.internal.ads.zzaek     // Catch:{ RemoteException -> 0x009f }
            r2.<init>(r6)     // Catch:{ RemoteException -> 0x009f }
            goto L_0x00a4
        L_0x009f:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzaza.zzc(r0, r6)
        L_0x00a3:
            r2 = r1
        L_0x00a4:
            r5.f12449c = r2
            com.google.android.gms.internal.ads.zzagj r6 = r5.f12447a     // Catch:{ RemoteException -> 0x00bb }
            com.google.android.gms.internal.ads.zzaeb r6 = r6.zzsx()     // Catch:{ RemoteException -> 0x00bb }
            if (r6 == 0) goto L_0x00bf
            com.google.android.gms.internal.ads.zzaec r6 = new com.google.android.gms.internal.ads.zzaec     // Catch:{ RemoteException -> 0x00bb }
            com.google.android.gms.internal.ads.zzagj r2 = r5.f12447a     // Catch:{ RemoteException -> 0x00bb }
            com.google.android.gms.internal.ads.zzaeb r2 = r2.zzsx()     // Catch:{ RemoteException -> 0x00bb }
            r6.<init>(r2)     // Catch:{ RemoteException -> 0x00bb }
            r1 = r6
            goto L_0x00bf
        L_0x00bb:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzaza.zzc(r0, r6)
        L_0x00bf:
            r5.f12451e = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagk.<init>(com.google.android.gms.internal.ads.zzagj):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final IObjectWrapper zzjr() {
        try {
            return this.f12447a.zzsv();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final void cancelUnconfirmedClick() {
        try {
            this.f12447a.cancelUnconfirmedClick();
        } catch (RemoteException e) {
            zzaza.zzc("Failed to cancelUnconfirmedClick", e);
        }
    }

    public final void destroy() {
        try {
            this.f12447a.destroy();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void enableCustomClickGesture() {
        try {
            this.f12447a.zztg();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.f12451e;
    }

    public final String getAdvertiser() {
        try {
            return this.f12447a.getAdvertiser();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final String getBody() {
        try {
            return this.f12447a.getBody();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final String getCallToAction() {
        try {
            return this.f12447a.getCallToAction();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final Bundle getExtras() {
        try {
            Bundle extras = this.f12447a.getExtras();
            if (extras != null) {
                return extras;
            }
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
        return new Bundle();
    }

    public final String getHeadline() {
        try {
            return this.f12447a.getHeadline();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final NativeAd.Image getIcon() {
        return this.f12449c;
    }

    public final List<NativeAd.Image> getImages() {
        return this.f12448b;
    }

    public final MediaContent getMediaContent() {
        try {
            if (this.f12447a.zzth() != null) {
                return new zzzm(this.f12447a.zzth());
            }
            return null;
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final String getMediationAdapterClassName() {
        try {
            return this.f12447a.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final List<MuteThisAdReason> getMuteThisAdReasons() {
        return this.f12452f;
    }

    public final String getPrice() {
        try {
            return this.f12447a.getPrice();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final ResponseInfo getResponseInfo() {
        zzyn zzyn;
        try {
            zzyn = this.f12447a.zzkh();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            zzyn = null;
        }
        return ResponseInfo.zza(zzyn);
    }

    public final Double getStarRating() {
        try {
            double starRating = this.f12447a.getStarRating();
            if (starRating == -1.0d) {
                return null;
            }
            return Double.valueOf(starRating);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final String getStore() {
        try {
            return this.f12447a.getStore();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            if (this.f12447a.getVideoController() != null) {
                this.f12450d.zza(this.f12447a.getVideoController());
            }
        } catch (RemoteException e) {
            zzaza.zzc("Exception occurred while getting video controller", e);
        }
        return this.f12450d;
    }

    public final boolean isCustomClickGestureEnabled() {
        try {
            return this.f12447a.isCustomClickGestureEnabled();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return false;
        }
    }

    public final boolean isCustomMuteThisAdEnabled() {
        try {
            return this.f12447a.isCustomMuteThisAdEnabled();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return false;
        }
    }

    public final void muteThisAd(MuteThisAdReason muteThisAdReason) {
        try {
            if (!isCustomMuteThisAdEnabled()) {
                zzaza.zzey("Ad is not custom mute enabled");
            } else if (muteThisAdReason == null) {
                this.f12447a.zza((zzyd) null);
            } else if (muteThisAdReason instanceof zzyi) {
                this.f12447a.zza(((zzyi) muteThisAdReason).zzqp());
            } else {
                zzaza.zzey("Use mute reason from UnifiedNativeAd.getMuteThisAdReasons() or null");
            }
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void performClick(Bundle bundle) {
        try {
            this.f12447a.performClick(bundle);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void recordCustomClickGesture() {
        try {
            this.f12447a.recordCustomClickGesture();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.f12447a.recordImpression(bundle);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return false;
        }
    }

    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.f12447a.reportTouchEvent(bundle);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void setMuteThisAdListener(MuteThisAdListener muteThisAdListener) {
        try {
            this.f12447a.zza((zzxz) new zzye(muteThisAdListener));
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.f12447a.zza((zzym) new zzaaf(onPaidEventListener));
        } catch (RemoteException e) {
            zzaza.zzc("Failed to setOnPaidEventListener", e);
        }
    }

    public final void setUnconfirmedClickListener(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        try {
            this.f12447a.zza((zzage) new zzagw(unconfirmedClickListener));
        } catch (RemoteException e) {
            zzaza.zzc("Failed to setUnconfirmedClickListener", e);
        }
    }

    public final Object zzjw() {
        try {
            IObjectWrapper zzsy = this.f12447a.zzsy();
            if (zzsy != null) {
                return ObjectWrapper.unwrap(zzsy);
            }
            return null;
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }
}
