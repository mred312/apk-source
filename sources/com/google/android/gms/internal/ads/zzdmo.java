package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdmo extends zzaul {

    /* renamed from: a */
    private final zzdma f15775a;

    /* renamed from: b */
    private final zzdlf f15776b;

    /* renamed from: c */
    private final zzdni f15777c;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable

    /* renamed from: d */
    public zzchc f15778d;
    @GuardedBy("this")

    /* renamed from: e */
    private boolean f15779e = false;

    public zzdmo(zzdma zzdma, zzdlf zzdlf, zzdni zzdni) {
        this.f15775a = zzdma;
        this.f15776b = zzdlf;
        this.f15777c = zzdni;
    }

    /* renamed from: c */
    private final synchronized boolean m8421c() {
        zzchc zzchc;
        zzchc = this.f15778d;
        return zzchc != null && !zzchc.isClosed();
    }

    public final void destroy() {
        zzl((IObjectWrapper) null);
    }

    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("getAdMetadata can only be called from the UI thread.");
        zzchc zzchc = this.f15778d;
        return zzchc != null ? zzchc.getAdMetadata() : new Bundle();
    }

    public final synchronized String getMediationAdapterClassName() {
        zzchc zzchc = this.f15778d;
        if (zzchc == null || zzchc.zzajz() == null) {
            return null;
        }
        return this.f15778d.zzajz().getMediationAdapterClassName();
    }

    public final boolean isLoaded() {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return m8421c();
    }

    public final void pause() {
        zzj((IObjectWrapper) null);
    }

    public final void resume() {
        zzk((IObjectWrapper) null);
    }

    public final void setAppPackageName(String str) {
    }

    public final synchronized void setCustomData(String str) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcon)).booleanValue()) {
            Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setCustomData");
            this.f15777c.zzdxz = str;
        }
    }

    public final synchronized void setImmersiveMode(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.f15779e = z;
    }

    public final synchronized void setUserId(String str) {
        Preconditions.checkMainThread("setUserId must be called on the main UI thread.");
        this.f15777c.zzdxy = str;
    }

    public final synchronized void show() {
        zzi((IObjectWrapper) null);
    }

    public final synchronized void zza(zzauv zzauv) {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        if (!zzabh.zzcp(zzauv.zzbum)) {
            if (m8421c()) {
                if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcvd)).booleanValue()) {
                    return;
                }
            }
            zzdmb zzdmb = new zzdmb((String) null);
            this.f15778d = null;
            this.f15775a.mo17142h(zzdnf.zzhic);
            this.f15775a.zza(zzauv.zzdsr, zzauv.zzbum, zzdmb, new C2192my(this));
        }
    }

    public final synchronized void zzi(@Nullable IObjectWrapper iObjectWrapper) {
        Activity activity;
        Preconditions.checkMainThread("showAd must be called on the main UI thread.");
        if (this.f15778d != null) {
            if (iObjectWrapper != null) {
                Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
                if (unwrap instanceof Activity) {
                    activity = (Activity) unwrap;
                    this.f15778d.zzb(this.f15779e, activity);
                }
            }
            activity = null;
            this.f15778d.zzb(this.f15779e, activity);
        }
    }

    public final synchronized void zzj(IObjectWrapper iObjectWrapper) {
        Context context;
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.f15778d != null) {
            if (iObjectWrapper == null) {
                context = null;
            } else {
                context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            }
            this.f15778d.zzajy().zzcc(context);
        }
    }

    public final synchronized void zzk(IObjectWrapper iObjectWrapper) {
        Context context;
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.f15778d != null) {
            if (iObjectWrapper == null) {
                context = null;
            } else {
                context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            }
            this.f15778d.zzajy().zzcd(context);
        }
    }

    public final synchronized zzyn zzkh() {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcxv)).booleanValue()) {
            return null;
        }
        zzchc zzchc = this.f15778d;
        if (zzchc == null) {
            return null;
        }
        return zzchc.zzajz();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.content.Context} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzl(com.google.android.gms.dynamic.IObjectWrapper r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "destroy must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzdlf r0 = r2.f15776b     // Catch:{ all -> 0x0025 }
            r1 = 0
            r0.zza(r1)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzchc r0 = r2.f15778d     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0023
            if (r3 != 0) goto L_0x0013
            goto L_0x001a
        L_0x0013:
            java.lang.Object r3 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r3)     // Catch:{ all -> 0x0025 }
            r1 = r3
            android.content.Context r1 = (android.content.Context) r1     // Catch:{ all -> 0x0025 }
        L_0x001a:
            com.google.android.gms.internal.ads.zzchc r3 = r2.f15778d     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzbso r3 = r3.zzajy()     // Catch:{ all -> 0x0025 }
            r3.zzce(r1)     // Catch:{ all -> 0x0025 }
        L_0x0023:
            monitor-exit(r2)
            return
        L_0x0025:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdmo.zzl(com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    public final boolean zzrf() {
        zzchc zzchc = this.f15778d;
        return zzchc != null && zzchc.zzrf();
    }

    public final void zza(zzaup zzaup) {
        Preconditions.checkMainThread("setRewardedVideoAdListener can only be called from the UI thread.");
        this.f15776b.zzb(zzaup);
    }

    public final void zza(zzaug zzaug) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.f15776b.zzb(zzaug);
    }

    public final void zza(zzxj zzxj) {
        Preconditions.checkMainThread("setAdMetadataListener can only be called from the UI thread.");
        if (zzxj == null) {
            this.f15776b.zza((AdMetadataListener) null);
        } else {
            this.f15776b.zza(new C2155ly(this, zzxj));
        }
    }
}
