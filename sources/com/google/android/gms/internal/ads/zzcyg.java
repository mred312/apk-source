package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcyg extends zzxf {

    /* renamed from: a */
    private final zzvn f15049a;

    /* renamed from: b */
    private final Context f15050b;

    /* renamed from: c */
    private final zzdkv f15051c;

    /* renamed from: d */
    private final String f15052d;

    /* renamed from: e */
    private final zzcxq f15053e;

    /* renamed from: f */
    private final zzdlf f15054f;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable

    /* renamed from: g */
    public zzbyx f15055g;
    @GuardedBy("this")

    /* renamed from: h */
    private boolean f15056h = false;

    public zzcyg(Context context, zzvn zzvn, String str, zzdkv zzdkv, zzcxq zzcxq, zzdlf zzdlf) {
        this.f15049a = zzvn;
        this.f15052d = str;
        this.f15050b = context;
        this.f15051c = zzdkv;
        this.f15053e = zzcxq;
        this.f15054f = zzdlf;
    }

    /* renamed from: c */
    private final synchronized boolean m8309c() {
        zzbyx zzbyx;
        zzbyx = this.f15055g;
        return zzbyx != null && !zzbyx.isClosed();
    }

    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzbyx zzbyx = this.f15055g;
        if (zzbyx != null) {
            zzbyx.zzajy().zzce((Context) null);
        }
    }

    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    public final synchronized String getAdUnitId() {
        return this.f15052d;
    }

    public final synchronized String getMediationAdapterClassName() {
        zzbyx zzbyx = this.f15055g;
        if (zzbyx == null || zzbyx.zzajz() == null) {
            return null;
        }
        return this.f15055g.zzajz().getMediationAdapterClassName();
    }

    public final zzys getVideoController() {
        return null;
    }

    public final synchronized boolean isLoading() {
        return this.f15051c.isLoading();
    }

    public final synchronized boolean isReady() {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return m8309c();
    }

    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        zzbyx zzbyx = this.f15055g;
        if (zzbyx != null) {
            zzbyx.zzajy().zzcc((Context) null);
        }
    }

    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        zzbyx zzbyx = this.f15055g;
        if (zzbyx != null) {
            zzbyx.zzajy().zzcd((Context) null);
        }
    }

    public final synchronized void setImmersiveMode(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.f15056h = z;
    }

    public final void setManualImpressionsEnabled(boolean z) {
    }

    public final void setUserId(String str) {
    }

    public final synchronized void showInterstitial() {
        Preconditions.checkMainThread("showInterstitial must be called on the main UI thread.");
        zzbyx zzbyx = this.f15055g;
        if (zzbyx != null) {
            zzbyx.zzbh(this.f15056h);
        }
    }

    public final void stopLoading() {
    }

    public final void zza(zzaak zzaak) {
    }

    public final void zza(zzart zzart) {
    }

    public final void zza(zzarz zzarz, String str) {
    }

    public final void zza(zzsl zzsl) {
    }

    public final void zza(zzvn zzvn) {
    }

    public final void zza(zzvw zzvw) {
    }

    public final void zza(zzws zzws) {
    }

    public final void zza(zzxu zzxu) {
    }

    public final void zza(zzyy zzyy) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zza(com.google.android.gms.internal.ads.zzvk r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x0052 }
            com.google.android.gms.ads.internal.zzp.zzkq()     // Catch:{ all -> 0x0052 }
            android.content.Context r0 = r4.f15050b     // Catch:{ all -> 0x0052 }
            boolean r0 = com.google.android.gms.ads.internal.util.zzm.zzbb(r0)     // Catch:{ all -> 0x0052 }
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x002b
            com.google.android.gms.internal.ads.zzvc r0 = r5.zzchn     // Catch:{ all -> 0x0052 }
            if (r0 != 0) goto L_0x002b
            java.lang.String r5 = "Failed to load the ad because app ID is missing."
            com.google.android.gms.internal.ads.zzaza.zzey(r5)     // Catch:{ all -> 0x0052 }
            com.google.android.gms.internal.ads.zzcxq r5 = r4.f15053e     // Catch:{ all -> 0x0052 }
            if (r5 == 0) goto L_0x0029
            com.google.android.gms.internal.ads.zzdok r0 = com.google.android.gms.internal.ads.zzdok.APP_ID_MISSING     // Catch:{ all -> 0x0052 }
            com.google.android.gms.internal.ads.zzve r0 = com.google.android.gms.internal.ads.zzdoi.zza(r0, r2, r2)     // Catch:{ all -> 0x0052 }
            r5.zzk(r0)     // Catch:{ all -> 0x0052 }
        L_0x0029:
            monitor-exit(r4)
            return r1
        L_0x002b:
            boolean r0 = r4.m8309c()     // Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x0033
            monitor-exit(r4)
            return r1
        L_0x0033:
            android.content.Context r0 = r4.f15050b     // Catch:{ all -> 0x0052 }
            boolean r1 = r5.zzchb     // Catch:{ all -> 0x0052 }
            com.google.android.gms.internal.ads.zzdob.zze(r0, r1)     // Catch:{ all -> 0x0052 }
            r4.f15055g = r2     // Catch:{ all -> 0x0052 }
            com.google.android.gms.internal.ads.zzdkv r0 = r4.f15051c     // Catch:{ all -> 0x0052 }
            java.lang.String r1 = r4.f15052d     // Catch:{ all -> 0x0052 }
            com.google.android.gms.internal.ads.zzdks r2 = new com.google.android.gms.internal.ads.zzdks     // Catch:{ all -> 0x0052 }
            com.google.android.gms.internal.ads.zzvn r3 = r4.f15049a     // Catch:{ all -> 0x0052 }
            r2.<init>(r3)     // Catch:{ all -> 0x0052 }
            com.google.android.gms.internal.ads.kr r3 = new com.google.android.gms.internal.ads.kr     // Catch:{ all -> 0x0052 }
            r3.<init>(r4)     // Catch:{ all -> 0x0052 }
            boolean r5 = r0.zza(r5, r1, r2, r3)     // Catch:{ all -> 0x0052 }
            monitor-exit(r4)
            return r5
        L_0x0052:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcyg.zza(com.google.android.gms.internal.ads.zzvk):boolean");
    }

    public final void zzbl(String str) {
    }

    public final IObjectWrapper zzkd() {
        return null;
    }

    public final void zzke() {
    }

    public final zzvn zzkf() {
        return null;
    }

    public final synchronized String zzkg() {
        zzbyx zzbyx = this.f15055g;
        if (zzbyx == null || zzbyx.zzajz() == null) {
            return null;
        }
        return this.f15055g.zzajz().getMediationAdapterClassName();
    }

    public final synchronized zzyn zzkh() {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcxv)).booleanValue()) {
            return null;
        }
        zzbyx zzbyx = this.f15055g;
        if (zzbyx == null) {
            return null;
        }
        return zzbyx.zzajz();
    }

    public final zzxo zzki() {
        return this.f15053e.zzaru();
    }

    public final zzwt zzkj() {
        return this.f15053e.zzart();
    }

    public final void zza(zzwt zzwt) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.f15053e.zzc(zzwt);
    }

    public final void zza(zzxo zzxo) {
        Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        this.f15053e.zzb(zzxo);
    }

    public final synchronized void zza(zzacb zzacb) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.f15051c.zza(zzacb);
    }

    public final void zza(zzym zzym) {
        Preconditions.checkMainThread("setPaidEventListener must be called on the main UI thread.");
        this.f15053e.zzb(zzym);
    }

    public final void zza(zzxj zzxj) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    public final void zza(zzaup zzaup) {
        this.f15054f.zzb(zzaup);
    }
}
