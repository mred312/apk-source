package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public class zzzd {
    @GuardedBy("InternalMobileAds.class")

    /* renamed from: i */
    private static zzzd f17167i;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ArrayList<OnInitializationCompleteListener> f17168a = new ArrayList<>();

    /* renamed from: b */
    private final Object f17169b = new Object();
    @GuardedBy("lock")

    /* renamed from: c */
    private zzxw f17170c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f17171d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f17172e = false;

    /* renamed from: f */
    private RewardedVideoAd f17173f;
    @NonNull

    /* renamed from: g */
    private RequestConfiguration f17174g = new RequestConfiguration.Builder().build();

    /* renamed from: h */
    private InitializationStatus f17175h;

    /* renamed from: com.google.android.gms.internal.ads.zzzd$a */
    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
    class C2706a extends zzajf {
        private C2706a() {
        }

        public final void zze(List<zzaiz> list) {
            int i = 0;
            boolean unused = zzzd.this.f17171d = false;
            boolean unused2 = zzzd.this.f17172e = true;
            InitializationStatus a = zzzd.m9291g(list);
            ArrayList b = zzzd.zzrb().f17168a;
            int size = b.size();
            while (i < size) {
                Object obj = b.get(i);
                i++;
                ((OnInitializationCompleteListener) obj).onInitializationComplete(a);
            }
            zzzd.zzrb().f17168a.clear();
        }

        /* synthetic */ C2706a(zzzd zzzd, qj0 qj0) {
            this();
        }
    }

    private zzzd() {
    }

    @GuardedBy("lock")
    /* renamed from: c */
    private final void m9288c(@NonNull RequestConfiguration requestConfiguration) {
        try {
            this.f17170c.zza(new zzaae(requestConfiguration));
        } catch (RemoteException e) {
            zzaza.zzc("Unable to set request configuration parcel.", e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public static InitializationStatus m9291g(List<zzaiz> list) {
        HashMap hashMap = new HashMap();
        for (zzaiz next : list) {
            hashMap.put(next.zzdhn, new zzajh(next.zzdho ? AdapterStatus.State.READY : AdapterStatus.State.NOT_READY, next.description, next.zzdhp));
        }
        return new zzajg(hashMap);
    }

    @GuardedBy("lock")
    /* renamed from: h */
    private final void m9292h(Context context) {
        if (this.f17170c == null) {
            this.f17170c = (zzxw) new hj0(zzwq.zzqb(), context).mo14405b(context, false);
        }
    }

    public static zzzd zzrb() {
        zzzd zzzd;
        synchronized (zzzd.class) {
            if (f17167i == null) {
                f17167i = new zzzd();
            }
            zzzd = f17167i;
        }
        return zzzd;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ void mo18471d(OnInitializationCompleteListener onInitializationCompleteListener) {
        onInitializationCompleteListener.onInitializationComplete(this.f17175h);
    }

    public final void disableMediationAdapterInitialization(Context context) {
        synchronized (this.f17169b) {
            m9292h(context);
            try {
                this.f17170c.zzqn();
            } catch (RemoteException unused) {
                zzaza.zzey("Unable to disable mediation adapter initialization.");
            }
        }
    }

    public final InitializationStatus getInitializationStatus() {
        synchronized (this.f17169b) {
            Preconditions.checkState(this.f17170c != null, "MobileAds.initialize() must be called prior to getting initialization status.");
            try {
                InitializationStatus initializationStatus = this.f17175h;
                if (initializationStatus != null) {
                    return initializationStatus;
                }
                InitializationStatus g = m9291g(this.f17170c.zzqm());
                return g;
            } catch (RemoteException unused) {
                zzaza.zzey("Unable to get Initialization status.");
                return null;
            }
        }
    }

    @NonNull
    public final RequestConfiguration getRequestConfiguration() {
        return this.f17174g;
    }

    public final RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        synchronized (this.f17169b) {
            RewardedVideoAd rewardedVideoAd = this.f17173f;
            if (rewardedVideoAd != null) {
                return rewardedVideoAd;
            }
            zzaux zzaux = new zzaux(context, (zzaui) new mj0(zzwq.zzqb(), context, new zzanj()).mo14405b(context, false));
            this.f17173f = zzaux;
            return zzaux;
        }
    }

    public final String getVersionString() {
        String zzhg;
        synchronized (this.f17169b) {
            Preconditions.checkState(this.f17170c != null, "MobileAds.initialize() must be called prior to getting version string.");
            try {
                zzhg = zzdwc.zzhg(this.f17170c.getVersionString());
            } catch (RemoteException e) {
                zzaza.zzc("Unable to get version string.", e);
                return "";
            }
        }
        return zzhg;
    }

    public final void openDebugMenu(Context context, String str) {
        synchronized (this.f17169b) {
            Preconditions.checkState(this.f17170c != null, "MobileAds.initialize() must be called prior to opening debug menu.");
            try {
                this.f17170c.zzb(ObjectWrapper.wrap(context), str);
            } catch (RemoteException e) {
                zzaza.zzc("Unable to open debug menu.", e);
            }
        }
    }

    public final void registerRtbAdapter(Class<? extends RtbAdapter> cls) {
        synchronized (this.f17169b) {
            try {
                this.f17170c.zzce(cls.getCanonicalName());
            } catch (RemoteException e) {
                zzaza.zzc("Unable to register RtbAdapter", e);
            }
        }
    }

    public final void setAppMuted(boolean z) {
        synchronized (this.f17169b) {
            Preconditions.checkState(this.f17170c != null, "MobileAds.initialize() must be called prior to setting app muted state.");
            try {
                this.f17170c.setAppMuted(z);
            } catch (RemoteException e) {
                zzaza.zzc("Unable to set app mute state.", e);
            }
        }
    }

    public final void setAppVolume(float f) {
        boolean z = true;
        Preconditions.checkArgument(0.0f <= f && f <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        synchronized (this.f17169b) {
            if (this.f17170c == null) {
                z = false;
            }
            Preconditions.checkState(z, "MobileAds.initialize() must be called prior to setting the app volume.");
            try {
                this.f17170c.setAppVolume(f);
            } catch (RemoteException e) {
                zzaza.zzc("Unable to set app volume.", e);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setRequestConfiguration(@androidx.annotation.NonNull com.google.android.gms.ads.RequestConfiguration r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x0004
            r0 = 1
            goto L_0x0005
        L_0x0004:
            r0 = 0
        L_0x0005:
            java.lang.String r1 = "Null passed to setRequestConfiguration."
            com.google.android.gms.common.internal.Preconditions.checkArgument(r0, r1)
            java.lang.Object r0 = r4.f17169b
            monitor-enter(r0)
            com.google.android.gms.ads.RequestConfiguration r1 = r4.f17174g     // Catch:{ all -> 0x0030 }
            r4.f17174g = r5     // Catch:{ all -> 0x0030 }
            com.google.android.gms.internal.ads.zzxw r2 = r4.f17170c     // Catch:{ all -> 0x0030 }
            if (r2 != 0) goto L_0x0017
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x0017:
            int r2 = r1.getTagForChildDirectedTreatment()     // Catch:{ all -> 0x0030 }
            int r3 = r5.getTagForChildDirectedTreatment()     // Catch:{ all -> 0x0030 }
            if (r2 != r3) goto L_0x002b
            int r1 = r1.getTagForUnderAgeOfConsent()     // Catch:{ all -> 0x0030 }
            int r2 = r5.getTagForUnderAgeOfConsent()     // Catch:{ all -> 0x0030 }
            if (r1 == r2) goto L_0x002e
        L_0x002b:
            r4.m9288c(r5)     // Catch:{ all -> 0x0030 }
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x0030:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzd.setRequestConfiguration(com.google.android.gms.ads.RequestConfiguration):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(android.content.Context r5, java.lang.String r6, com.google.android.gms.ads.initialization.OnInitializationCompleteListener r7) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f17169b
            monitor-enter(r0)
            boolean r1 = r4.f17171d     // Catch:{ all -> 0x00c7 }
            if (r1 == 0) goto L_0x0014
            if (r7 == 0) goto L_0x0012
            com.google.android.gms.internal.ads.zzzd r5 = zzrb()     // Catch:{ all -> 0x00c7 }
            java.util.ArrayList<com.google.android.gms.ads.initialization.OnInitializationCompleteListener> r5 = r5.f17168a     // Catch:{ all -> 0x00c7 }
            r5.add(r7)     // Catch:{ all -> 0x00c7 }
        L_0x0012:
            monitor-exit(r0)     // Catch:{ all -> 0x00c7 }
            return
        L_0x0014:
            boolean r1 = r4.f17172e     // Catch:{ all -> 0x00c7 }
            if (r1 == 0) goto L_0x0023
            if (r7 == 0) goto L_0x0021
            com.google.android.gms.ads.initialization.InitializationStatus r5 = r4.getInitializationStatus()     // Catch:{ all -> 0x00c7 }
            r7.onInitializationComplete(r5)     // Catch:{ all -> 0x00c7 }
        L_0x0021:
            monitor-exit(r0)     // Catch:{ all -> 0x00c7 }
            return
        L_0x0023:
            r1 = 1
            r4.f17171d = r1     // Catch:{ all -> 0x00c7 }
            if (r7 == 0) goto L_0x0031
            com.google.android.gms.internal.ads.zzzd r1 = zzrb()     // Catch:{ all -> 0x00c7 }
            java.util.ArrayList<com.google.android.gms.ads.initialization.OnInitializationCompleteListener> r1 = r1.f17168a     // Catch:{ all -> 0x00c7 }
            r1.add(r7)     // Catch:{ all -> 0x00c7 }
        L_0x0031:
            if (r5 == 0) goto L_0x00bf
            com.google.android.gms.internal.ads.zzand r1 = com.google.android.gms.internal.ads.zzand.zzuc()     // Catch:{ RemoteException -> 0x00b7 }
            r1.zzc(r5, r6)     // Catch:{ RemoteException -> 0x00b7 }
            r4.m9292h(r5)     // Catch:{ RemoteException -> 0x00b7 }
            if (r7 == 0) goto L_0x004a
            com.google.android.gms.internal.ads.zzxw r1 = r4.f17170c     // Catch:{ RemoteException -> 0x00b7 }
            com.google.android.gms.internal.ads.zzzd$a r2 = new com.google.android.gms.internal.ads.zzzd$a     // Catch:{ RemoteException -> 0x00b7 }
            r3 = 0
            r2.<init>(r4, r3)     // Catch:{ RemoteException -> 0x00b7 }
            r1.zza((com.google.android.gms.internal.ads.zzajc) r2)     // Catch:{ RemoteException -> 0x00b7 }
        L_0x004a:
            com.google.android.gms.internal.ads.zzxw r1 = r4.f17170c     // Catch:{ RemoteException -> 0x00b7 }
            com.google.android.gms.internal.ads.zzanj r2 = new com.google.android.gms.internal.ads.zzanj     // Catch:{ RemoteException -> 0x00b7 }
            r2.<init>()     // Catch:{ RemoteException -> 0x00b7 }
            r1.zza((com.google.android.gms.internal.ads.zzani) r2)     // Catch:{ RemoteException -> 0x00b7 }
            com.google.android.gms.internal.ads.zzxw r1 = r4.f17170c     // Catch:{ RemoteException -> 0x00b7 }
            r1.initialize()     // Catch:{ RemoteException -> 0x00b7 }
            com.google.android.gms.internal.ads.zzxw r1 = r4.f17170c     // Catch:{ RemoteException -> 0x00b7 }
            com.google.android.gms.internal.ads.pj0 r2 = new com.google.android.gms.internal.ads.pj0     // Catch:{ RemoteException -> 0x00b7 }
            r2.<init>(r4, r5)     // Catch:{ RemoteException -> 0x00b7 }
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r2)     // Catch:{ RemoteException -> 0x00b7 }
            r1.zza(r6, r2)     // Catch:{ RemoteException -> 0x00b7 }
            com.google.android.gms.ads.RequestConfiguration r6 = r4.f17174g     // Catch:{ RemoteException -> 0x00b7 }
            int r6 = r6.getTagForChildDirectedTreatment()     // Catch:{ RemoteException -> 0x00b7 }
            r1 = -1
            if (r6 != r1) goto L_0x0078
            com.google.android.gms.ads.RequestConfiguration r6 = r4.f17174g     // Catch:{ RemoteException -> 0x00b7 }
            int r6 = r6.getTagForUnderAgeOfConsent()     // Catch:{ RemoteException -> 0x00b7 }
            if (r6 == r1) goto L_0x007d
        L_0x0078:
            com.google.android.gms.ads.RequestConfiguration r6 = r4.f17174g     // Catch:{ RemoteException -> 0x00b7 }
            r4.m9288c(r6)     // Catch:{ RemoteException -> 0x00b7 }
        L_0x007d:
            com.google.android.gms.internal.ads.zzabf.initialize(r5)     // Catch:{ RemoteException -> 0x00b7 }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r5 = com.google.android.gms.internal.ads.zzabf.zzcuy     // Catch:{ RemoteException -> 0x00b7 }
            com.google.android.gms.internal.ads.zzabb r6 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ RemoteException -> 0x00b7 }
            java.lang.Object r5 = r6.zzd(r5)     // Catch:{ RemoteException -> 0x00b7 }
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ RemoteException -> 0x00b7 }
            boolean r5 = r5.booleanValue()     // Catch:{ RemoteException -> 0x00b7 }
            if (r5 != 0) goto L_0x00bd
            java.lang.String r5 = r4.getVersionString()     // Catch:{ RemoteException -> 0x00b7 }
            java.lang.String r6 = "0"
            boolean r5 = r5.endsWith(r6)     // Catch:{ RemoteException -> 0x00b7 }
            if (r5 != 0) goto L_0x00bd
            java.lang.String r5 = "Google Mobile Ads SDK initialization functionality unavailable for this session. Ad requests can be made at any time."
            com.google.android.gms.internal.ads.zzaza.zzey(r5)     // Catch:{ RemoteException -> 0x00b7 }
            com.google.android.gms.internal.ads.rj0 r5 = new com.google.android.gms.internal.ads.rj0     // Catch:{ RemoteException -> 0x00b7 }
            r5.<init>(r4)     // Catch:{ RemoteException -> 0x00b7 }
            r4.f17175h = r5     // Catch:{ RemoteException -> 0x00b7 }
            if (r7 == 0) goto L_0x00bd
            android.os.Handler r5 = com.google.android.gms.internal.ads.zzayr.zzzz     // Catch:{ RemoteException -> 0x00b7 }
            com.google.android.gms.internal.ads.oj0 r6 = new com.google.android.gms.internal.ads.oj0     // Catch:{ RemoteException -> 0x00b7 }
            r6.<init>(r4, r7)     // Catch:{ RemoteException -> 0x00b7 }
            r5.post(r6)     // Catch:{ RemoteException -> 0x00b7 }
            goto L_0x00bd
        L_0x00b7:
            r5 = move-exception
            java.lang.String r6 = "MobileAdsSettingManager initialization failed"
            com.google.android.gms.internal.ads.zzaza.zzd(r6, r5)     // Catch:{ all -> 0x00c7 }
        L_0x00bd:
            monitor-exit(r0)     // Catch:{ all -> 0x00c7 }
            return
        L_0x00bf:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00c7 }
            java.lang.String r6 = "Context cannot be null."
            r5.<init>(r6)     // Catch:{ all -> 0x00c7 }
            throw r5     // Catch:{ all -> 0x00c7 }
        L_0x00c7:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00c7 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzd.zza(android.content.Context, java.lang.String, com.google.android.gms.ads.initialization.OnInitializationCompleteListener):void");
    }

    public final float zzqk() {
        float f;
        synchronized (this.f17169b) {
            zzxw zzxw = this.f17170c;
            f = 1.0f;
            if (zzxw == null) {
                return 1.0f;
            }
            try {
                f = zzxw.zzqk();
            } catch (RemoteException e) {
                zzaza.zzc("Unable to get app volume.", e);
            }
        }
        return f;
    }

    public final boolean zzql() {
        boolean z;
        synchronized (this.f17169b) {
            zzxw zzxw = this.f17170c;
            z = false;
            if (zzxw == null) {
                return false;
            }
            try {
                z = zzxw.zzql();
            } catch (RemoteException e) {
                zzaza.zzc("Unable to get app mute state.", e);
            }
        }
        return z;
    }
}
