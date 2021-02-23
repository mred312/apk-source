package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcxi extends zzxf {

    /* renamed from: a */
    private final Context f15022a;

    /* renamed from: b */
    private final zzwt f15023b;

    /* renamed from: c */
    private final zzdnn f15024c;

    /* renamed from: d */
    private final zzbme f15025d;

    /* renamed from: e */
    private final ViewGroup f15026e;

    public zzcxi(Context context, @Nullable zzwt zzwt, zzdnn zzdnn, zzbme zzbme) {
        this.f15022a = context;
        this.f15023b = zzwt;
        this.f15024c = zzdnn;
        this.f15025d = zzbme;
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.removeAllViews();
        frameLayout.addView(zzbme.zzaiz(), zzp.zzks().zzyk());
        frameLayout.setMinimumHeight(zzkf().heightPixels);
        frameLayout.setMinimumWidth(zzkf().widthPixels);
        this.f15026e = frameLayout;
    }

    public final void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.f15025d.destroy();
    }

    public final Bundle getAdMetadata() {
        zzaza.zzez("getAdMetadata is not supported in Publisher AdView returned by AdLoader.");
        return new Bundle();
    }

    public final String getAdUnitId() {
        return this.f15024c.zzhip;
    }

    public final String getMediationAdapterClassName() {
        if (this.f15025d.zzajz() != null) {
            return this.f15025d.zzajz().getMediationAdapterClassName();
        }
        return null;
    }

    public final zzys getVideoController() {
        return this.f15025d.getVideoController();
    }

    public final boolean isLoading() {
        return false;
    }

    public final boolean isReady() {
        return false;
    }

    public final void pause() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.f15025d.zzajy().zzcc((Context) null);
    }

    public final void resume() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.f15025d.zzajy().zzcd((Context) null);
    }

    public final void setImmersiveMode(boolean z) {
    }

    public final void setManualImpressionsEnabled(boolean z) {
        zzaza.zzez("setManualImpressionsEnabled is not supported in Publisher AdView returned by AdLoader.");
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

    public final boolean zza(zzvk zzvk) {
        zzaza.zzez("loadAd is not supported for a Publisher AdView returned from AdLoader.");
        return false;
    }

    public final void zzbl(String str) {
    }

    public final IObjectWrapper zzkd() {
        return ObjectWrapper.wrap(this.f15026e);
    }

    public final void zzke() {
        this.f15025d.zzke();
    }

    public final zzvn zzkf() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        return zzdns.zzb(this.f15022a, Collections.singletonList(this.f15025d.zzaiy()));
    }

    public final String zzkg() {
        if (this.f15025d.zzajz() != null) {
            return this.f15025d.zzajz().getMediationAdapterClassName();
        }
        return null;
    }

    public final zzyn zzkh() {
        return this.f15025d.zzajz();
    }

    public final zzxo zzki() {
        return this.f15024c.zzhiu;
    }

    public final zzwt zzkj() {
        return this.f15023b;
    }

    public final void zza(zzaak zzaak) {
        zzaza.zzez("setVideoOptions is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzvn zzvn) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        zzbme zzbme = this.f15025d;
        if (zzbme != null) {
            zzbme.zza(this.f15026e, zzvn);
        }
    }

    public final void zza(zzacb zzacb) {
        zzaza.zzez("setOnCustomRenderedAdLoadedListener is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzws zzws) {
        zzaza.zzez("setAdClickListener is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzxu zzxu) {
        zzaza.zzez("setCorrelationIdProvider is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzwt zzwt) {
        zzaza.zzez("setAdListener is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzxo zzxo) {
        zzaza.zzez("setAppEventListener is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzxj zzxj) {
        zzaza.zzez("setAdMetadataListener is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzym zzym) {
        zzaza.zzez("setOnPaidEventListener is not supported in Publisher AdView returned by AdLoader.");
    }
}
