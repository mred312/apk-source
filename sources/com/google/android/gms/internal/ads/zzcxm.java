package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbrg;
import com.google.android.gms.internal.ads.zzbwp;
import java.util.Collections;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcxm extends zzxf implements zzbue {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzbgm f15033a;

    /* renamed from: b */
    private final Context f15034b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final ViewGroup f15035c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final zzcxq f15036d = new zzcxq();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final zzcyd f15037e = new zzcyd();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final zzbua f15038f;

    /* renamed from: g */
    private zzvn f15039g;
    @GuardedBy("this")

    /* renamed from: h */
    private final zzdnp f15040h;
    @GuardedBy("this")
    @Nullable

    /* renamed from: i */
    private zzacb f15041i;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable

    /* renamed from: j */
    public zzbme f15042j;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable

    /* renamed from: k */
    public zzdyz<zzbme> f15043k;

    public zzcxm(zzbgm zzbgm, Context context, zzvn zzvn, String str) {
        zzdnp zzdnp = new zzdnp();
        this.f15040h = zzdnp;
        this.f15035c = new FrameLayout(context);
        this.f15033a = zzbgm;
        this.f15034b = context;
        zzdnp.zzf(zzvn).zzgq(str);
        zzbua zzaeo = zzbgm.zzaeo();
        this.f15038f = zzaeo;
        zzaeo.zza(this, zzbgm.zzaek());
        this.f15039g = zzvn;
    }

    /* renamed from: e */
    private final synchronized zzbna m8300e(zzdnn zzdnn) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyp)).booleanValue()) {
            return this.f15033a.zzaer().zzd(new zzbrg.zza().zzcg(this.f15034b).zza(zzdnn).zzakx()).zzd(new zzbwp.zza().zzalt()).zza(new zzcwq(this.f15041i)).zzb(new zzcap(zzccl.zzgdq, (zzwt) null)).zza(new zzbnv(this.f15038f)).zzd(new zzblz(this.f15035c)).zzagz();
        }
        return this.f15033a.zzaer().zzd(new zzbrg.zza().zzcg(this.f15034b).zza(zzdnn).zzakx()).zzd(new zzbwp.zza().zza((zzva) this.f15036d, this.f15033a.zzaek()).zza((zzva) this.f15037e, this.f15033a.zzaek()).zza((zzbsm) this.f15036d, this.f15033a.zzaek()).zza((zzbru) this.f15036d, this.f15033a.zzaek()).zza((zzbtj) this.f15036d, this.f15033a.zzaek()).zza((zzbrz) this.f15036d, this.f15033a.zzaek()).zza((AppEventListener) this.f15036d, this.f15033a.zzaek()).zza((zzbub) this.f15036d, this.f15033a.zzaek()).zzalt()).zza(new zzcwq(this.f15041i)).zzb(new zzcap(zzccl.zzgdq, (zzwt) null)).zza(new zzbnv(this.f15038f)).zzd(new zzblz(this.f15035c)).zzagz();
    }

    /* renamed from: i */
    private final synchronized void m8304i(zzvn zzvn) {
        this.f15040h.zzf(zzvn);
        this.f15040h.zzbn(this.f15039g.zzchw);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        return false;
     */
    /* renamed from: k */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean m8306k(com.google.android.gms.internal.ads.zzvk r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x0088 }
            com.google.android.gms.ads.internal.zzp.zzkq()     // Catch:{ all -> 0x0088 }
            android.content.Context r0 = r4.f15034b     // Catch:{ all -> 0x0088 }
            boolean r0 = com.google.android.gms.ads.internal.util.zzm.zzbb(r0)     // Catch:{ all -> 0x0088 }
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x002b
            com.google.android.gms.internal.ads.zzvc r0 = r5.zzchn     // Catch:{ all -> 0x0088 }
            if (r0 != 0) goto L_0x002b
            java.lang.String r5 = "Failed to load the ad because app ID is missing."
            com.google.android.gms.internal.ads.zzaza.zzey(r5)     // Catch:{ all -> 0x0088 }
            com.google.android.gms.internal.ads.zzcxq r5 = r4.f15036d     // Catch:{ all -> 0x0088 }
            if (r5 == 0) goto L_0x0029
            com.google.android.gms.internal.ads.zzdok r0 = com.google.android.gms.internal.ads.zzdok.APP_ID_MISSING     // Catch:{ all -> 0x0088 }
            com.google.android.gms.internal.ads.zzve r0 = com.google.android.gms.internal.ads.zzdoi.zza(r0, r2, r2)     // Catch:{ all -> 0x0088 }
            r5.zzk(r0)     // Catch:{ all -> 0x0088 }
        L_0x0029:
            monitor-exit(r4)
            return r1
        L_0x002b:
            com.google.android.gms.internal.ads.zzdyz<com.google.android.gms.internal.ads.zzbme> r0 = r4.f15043k     // Catch:{ all -> 0x0088 }
            if (r0 == 0) goto L_0x0031
            monitor-exit(r4)
            return r1
        L_0x0031:
            android.content.Context r0 = r4.f15034b     // Catch:{ all -> 0x0088 }
            boolean r3 = r5.zzchb     // Catch:{ all -> 0x0088 }
            com.google.android.gms.internal.ads.zzdob.zze(r0, r3)     // Catch:{ all -> 0x0088 }
            com.google.android.gms.internal.ads.zzdnp r0 = r4.f15040h     // Catch:{ all -> 0x0088 }
            com.google.android.gms.internal.ads.zzdnp r5 = r0.zzh(r5)     // Catch:{ all -> 0x0088 }
            com.google.android.gms.internal.ads.zzdnn r5 = r5.zzaus()     // Catch:{ all -> 0x0088 }
            com.google.android.gms.internal.ads.zzacn<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzadc.zzdcx     // Catch:{ all -> 0x0088 }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0088 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0088 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0088 }
            if (r0 == 0) goto L_0x0069
            com.google.android.gms.internal.ads.zzdnp r0 = r4.f15040h     // Catch:{ all -> 0x0088 }
            com.google.android.gms.internal.ads.zzvn r0 = r0.zzkf()     // Catch:{ all -> 0x0088 }
            boolean r0 = r0.zzcht     // Catch:{ all -> 0x0088 }
            if (r0 == 0) goto L_0x0069
            com.google.android.gms.internal.ads.zzcxq r0 = r4.f15036d     // Catch:{ all -> 0x0088 }
            if (r0 == 0) goto L_0x0069
            com.google.android.gms.internal.ads.zzdok r5 = com.google.android.gms.internal.ads.zzdok.INVALID_AD_SIZE     // Catch:{ all -> 0x0088 }
            com.google.android.gms.internal.ads.zzve r5 = com.google.android.gms.internal.ads.zzdoi.zza(r5, r2, r2)     // Catch:{ all -> 0x0088 }
            r0.zzk(r5)     // Catch:{ all -> 0x0088 }
            monitor-exit(r4)
            return r1
        L_0x0069:
            com.google.android.gms.internal.ads.zzbna r5 = r4.m8300e(r5)     // Catch:{ all -> 0x0088 }
            com.google.android.gms.internal.ads.zzboz r0 = r5.zzagh()     // Catch:{ all -> 0x0088 }
            com.google.android.gms.internal.ads.zzdyz r0 = r0.zzakj()     // Catch:{ all -> 0x0088 }
            r4.f15043k = r0     // Catch:{ all -> 0x0088 }
            com.google.android.gms.internal.ads.vq r1 = new com.google.android.gms.internal.ads.vq     // Catch:{ all -> 0x0088 }
            r1.<init>(r4, r5)     // Catch:{ all -> 0x0088 }
            com.google.android.gms.internal.ads.zzbgm r5 = r4.f15033a     // Catch:{ all -> 0x0088 }
            java.util.concurrent.Executor r5 = r5.zzaek()     // Catch:{ all -> 0x0088 }
            com.google.android.gms.internal.ads.zzdyr.zza(r0, r1, r5)     // Catch:{ all -> 0x0088 }
            r5 = 1
            monitor-exit(r4)
            return r5
        L_0x0088:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcxm.m8306k(com.google.android.gms.internal.ads.zzvk):boolean");
    }

    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzbme zzbme = this.f15042j;
        if (zzbme != null) {
            zzbme.destroy();
        }
    }

    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    public final synchronized String getAdUnitId() {
        return this.f15040h.zzauq();
    }

    public final synchronized String getMediationAdapterClassName() {
        zzbme zzbme = this.f15042j;
        if (zzbme == null || zzbme.zzajz() == null) {
            return null;
        }
        return this.f15042j.zzajz().getMediationAdapterClassName();
    }

    public final synchronized zzys getVideoController() {
        Preconditions.checkMainThread("getVideoController must be called from the main thread.");
        zzbme zzbme = this.f15042j;
        if (zzbme == null) {
            return null;
        }
        return zzbme.getVideoController();
    }

    public final synchronized boolean isLoading() {
        zzdyz<zzbme> zzdyz;
        zzdyz = this.f15043k;
        return zzdyz != null && !zzdyz.isDone();
    }

    public final boolean isReady() {
        return false;
    }

    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        zzbme zzbme = this.f15042j;
        if (zzbme != null) {
            zzbme.zzajy().zzcc((Context) null);
        }
    }

    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        zzbme zzbme = this.f15042j;
        if (zzbme != null) {
            zzbme.zzajy().zzcd((Context) null);
        }
    }

    public final void setImmersiveMode(boolean z) {
    }

    public final synchronized void setManualImpressionsEnabled(boolean z) {
        Preconditions.checkMainThread("setManualImpressionsEnabled must be called from the main thread.");
        this.f15040h.zzbo(z);
    }

    public final void setUserId(String str) {
    }

    public final void showInterstitial() {
    }

    public final void stopLoading() {
    }

    public final void zza(zzart zzart) {
    }

    public final void zza(zzarz zzarz, String str) {
    }

    public final void zza(zzaup zzaup) {
    }

    public final void zza(zzsl zzsl) {
    }

    public final void zza(zzvw zzvw) {
    }

    public final void zza(zzyy zzyy) {
    }

    public final synchronized boolean zza(zzvk zzvk) {
        m8304i(this.f15039g);
        return m8306k(zzvk);
    }

    public final synchronized void zzald() {
        boolean z;
        ViewParent parent = this.f15035c.getParent();
        if (!(parent instanceof View)) {
            z = false;
        } else {
            View view = (View) parent;
            z = zzp.zzkq().zza(view, view.getContext());
        }
        if (z) {
            zzvn zzkf = this.f15040h.zzkf();
            zzbme zzbme = this.f15042j;
            if (!(zzbme == null || zzbme.zzajh() == null || !this.f15040h.zzaut())) {
                zzkf = zzdns.zzb(this.f15034b, Collections.singletonList(this.f15042j.zzajh()));
            }
            m8304i(zzkf);
            m8306k(this.f15040h.zzaup());
            return;
        }
        this.f15038f.zzdx(60);
    }

    public final void zzbl(String str) {
    }

    public final IObjectWrapper zzkd() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.f15035c);
    }

    public final synchronized void zzke() {
        Preconditions.checkMainThread("recordManualImpression must be called on the main UI thread.");
        zzbme zzbme = this.f15042j;
        if (zzbme != null) {
            zzbme.zzke();
        }
    }

    public final synchronized zzvn zzkf() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        zzbme zzbme = this.f15042j;
        if (zzbme != null) {
            return zzdns.zzb(this.f15034b, Collections.singletonList(zzbme.zzaiy()));
        }
        return this.f15040h.zzkf();
    }

    public final synchronized String zzkg() {
        zzbme zzbme = this.f15042j;
        if (zzbme == null || zzbme.zzajz() == null) {
            return null;
        }
        return this.f15042j.zzajz().getMediationAdapterClassName();
    }

    public final synchronized zzyn zzkh() {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcxv)).booleanValue()) {
            return null;
        }
        zzbme zzbme = this.f15042j;
        if (zzbme == null) {
            return null;
        }
        return zzbme.zzajz();
    }

    public final zzxo zzki() {
        return this.f15036d.zzaru();
    }

    public final zzwt zzkj() {
        return this.f15036d.zzart();
    }

    public final void zza(zzwt zzwt) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.f15036d.zzc(zzwt);
    }

    public final void zza(zzxo zzxo) {
        Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        this.f15036d.zzb(zzxo);
    }

    public final synchronized void zza(zzvn zzvn) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        this.f15040h.zzf(zzvn);
        this.f15039g = zzvn;
        zzbme zzbme = this.f15042j;
        if (zzbme != null) {
            zzbme.zza(this.f15035c, zzvn);
        }
    }

    public final synchronized void zza(zzxu zzxu) {
        Preconditions.checkMainThread("setCorrelationIdProvider must be called on the main UI thread");
        this.f15040h.zzc(zzxu);
    }

    public final synchronized void zza(zzaak zzaak) {
        Preconditions.checkMainThread("setVideoOptions must be called on the main UI thread.");
        this.f15040h.zzc(zzaak);
    }

    public final void zza(zzws zzws) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.f15037e.zzb(zzws);
    }

    public final synchronized void zza(zzacb zzacb) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.f15041i = zzacb;
    }

    public final void zza(zzym zzym) {
        Preconditions.checkMainThread("setPaidEventListener must be called on the main UI thread.");
        this.f15036d.zzb(zzym);
    }

    public final void zza(zzxj zzxj) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }
}
