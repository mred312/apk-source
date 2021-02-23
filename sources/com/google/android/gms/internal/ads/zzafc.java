package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzafc extends NativeContentAd {

    /* renamed from: a */
    private final zzafb f12438a;

    /* renamed from: b */
    private final List<NativeAd.Image> f12439b = new ArrayList();

    /* renamed from: c */
    private final zzaek f12440c;

    /* renamed from: d */
    private final VideoController f12441d = new VideoController();

    /* renamed from: e */
    private final NativeAd.AdChoicesInfo f12442e;

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0074 A[Catch:{ RemoteException -> 0x0081 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzafc(com.google.android.gms.internal.ads.zzafb r6) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            r5.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.f12439b = r1
            com.google.android.gms.ads.VideoController r1 = new com.google.android.gms.ads.VideoController
            r1.<init>()
            r5.f12441d = r1
            r5.f12438a = r6
            r1 = 0
            java.util.List r6 = r6.getImages()     // Catch:{ RemoteException -> 0x0053 }
            if (r6 == 0) goto L_0x0057
            java.util.Iterator r6 = r6.iterator()     // Catch:{ RemoteException -> 0x0053 }
        L_0x0020:
            boolean r2 = r6.hasNext()     // Catch:{ RemoteException -> 0x0053 }
            if (r2 == 0) goto L_0x0057
            java.lang.Object r2 = r6.next()     // Catch:{ RemoteException -> 0x0053 }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x0053 }
            if (r3 == 0) goto L_0x0045
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x0053 }
            if (r2 == 0) goto L_0x0045
            java.lang.String r3 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)     // Catch:{ RemoteException -> 0x0053 }
            boolean r4 = r3 instanceof com.google.android.gms.internal.ads.zzaej     // Catch:{ RemoteException -> 0x0053 }
            if (r4 == 0) goto L_0x003f
            com.google.android.gms.internal.ads.zzaej r3 = (com.google.android.gms.internal.ads.zzaej) r3     // Catch:{ RemoteException -> 0x0053 }
            goto L_0x0046
        L_0x003f:
            com.google.android.gms.internal.ads.zzael r3 = new com.google.android.gms.internal.ads.zzael     // Catch:{ RemoteException -> 0x0053 }
            r3.<init>(r2)     // Catch:{ RemoteException -> 0x0053 }
            goto L_0x0046
        L_0x0045:
            r3 = r1
        L_0x0046:
            if (r3 == 0) goto L_0x0020
            java.util.List<com.google.android.gms.ads.formats.NativeAd$Image> r2 = r5.f12439b     // Catch:{ RemoteException -> 0x0053 }
            com.google.android.gms.internal.ads.zzaek r4 = new com.google.android.gms.internal.ads.zzaek     // Catch:{ RemoteException -> 0x0053 }
            r4.<init>(r3)     // Catch:{ RemoteException -> 0x0053 }
            r2.add(r4)     // Catch:{ RemoteException -> 0x0053 }
            goto L_0x0020
        L_0x0053:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzaza.zzc(r0, r6)
        L_0x0057:
            com.google.android.gms.internal.ads.zzafb r6 = r5.f12438a     // Catch:{ RemoteException -> 0x0065 }
            com.google.android.gms.internal.ads.zzaej r6 = r6.zzsz()     // Catch:{ RemoteException -> 0x0065 }
            if (r6 == 0) goto L_0x0069
            com.google.android.gms.internal.ads.zzaek r2 = new com.google.android.gms.internal.ads.zzaek     // Catch:{ RemoteException -> 0x0065 }
            r2.<init>(r6)     // Catch:{ RemoteException -> 0x0065 }
            goto L_0x006a
        L_0x0065:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzaza.zzc(r0, r6)
        L_0x0069:
            r2 = r1
        L_0x006a:
            r5.f12440c = r2
            com.google.android.gms.internal.ads.zzafb r6 = r5.f12438a     // Catch:{ RemoteException -> 0x0081 }
            com.google.android.gms.internal.ads.zzaeb r6 = r6.zzsx()     // Catch:{ RemoteException -> 0x0081 }
            if (r6 == 0) goto L_0x0085
            com.google.android.gms.internal.ads.zzaec r6 = new com.google.android.gms.internal.ads.zzaec     // Catch:{ RemoteException -> 0x0081 }
            com.google.android.gms.internal.ads.zzafb r2 = r5.f12438a     // Catch:{ RemoteException -> 0x0081 }
            com.google.android.gms.internal.ads.zzaeb r2 = r2.zzsx()     // Catch:{ RemoteException -> 0x0081 }
            r6.<init>(r2)     // Catch:{ RemoteException -> 0x0081 }
            r1 = r6
            goto L_0x0085
        L_0x0081:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzaza.zzc(r0, r6)
        L_0x0085:
            r5.f12442e = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafc.<init>(com.google.android.gms.internal.ads.zzafb):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final IObjectWrapper zzjr() {
        try {
            return this.f12438a.zzsv();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final void destroy() {
        try {
            this.f12438a.destroy();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.f12442e;
    }

    public final CharSequence getAdvertiser() {
        try {
            return this.f12438a.getAdvertiser();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final CharSequence getBody() {
        try {
            return this.f12438a.getBody();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final CharSequence getCallToAction() {
        try {
            return this.f12438a.getCallToAction();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final Bundle getExtras() {
        try {
            return this.f12438a.getExtras();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final CharSequence getHeadline() {
        try {
            return this.f12438a.getHeadline();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final List<NativeAd.Image> getImages() {
        return this.f12439b;
    }

    public final NativeAd.Image getLogo() {
        return this.f12440c;
    }

    public final CharSequence getMediationAdapterClassName() {
        try {
            return this.f12438a.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            if (this.f12438a.getVideoController() != null) {
                this.f12441d.zza(this.f12438a.getVideoController());
            }
        } catch (RemoteException e) {
            zzaza.zzc("Exception occurred while getting video controller", e);
        }
        return this.f12441d;
    }

    public final void performClick(Bundle bundle) {
        try {
            this.f12438a.performClick(bundle);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.f12438a.recordImpression(bundle);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return false;
        }
    }

    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.f12438a.reportTouchEvent(bundle);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }
}
