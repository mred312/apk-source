package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdid extends zzxf implements zzz, zzbto, zzsc {

    /* renamed from: a */
    private final zzbgm f15652a;

    /* renamed from: b */
    private final Context f15653b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final ViewGroup f15654c;

    /* renamed from: d */
    private AtomicBoolean f15655d = new AtomicBoolean();

    /* renamed from: e */
    private final String f15656e;

    /* renamed from: f */
    private final zzdib f15657f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final zzdir f15658g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final zzazh f15659h;

    /* renamed from: i */
    private long f15660i = -1;
    @Nullable

    /* renamed from: j */
    private zzbkv f15661j;
    @GuardedBy("this")
    @Nullable
    protected zzbll zzhdi;

    public zzdid(zzbgm zzbgm, Context context, String str, zzdib zzdib, zzdir zzdir, zzazh zzazh) {
        this.f15654c = new FrameLayout(context);
        this.f15652a = zzbgm;
        this.f15653b = context;
        this.f15656e = str;
        this.f15657f = zzdib;
        this.f15658g = zzdir;
        zzdir.zza((zzbto) this);
        this.f15659h = zzazh;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final zzr m8368b(zzbll zzbll) {
        boolean zzaby = zzbll.zzaby();
        int intValue = ((Integer) zzwq.zzqe().zzd(zzabf.zzcub)).intValue();
        zzq zzq = new zzq();
        zzq.size = 50;
        zzq.paddingLeft = zzaby ? intValue : 0;
        zzq.paddingRight = zzaby ? 0 : intValue;
        zzq.paddingTop = 0;
        zzq.paddingBottom = intValue;
        return new zzr(this.f15653b, zzq, this);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final zzvn m8370d() {
        return zzdns.zzb(this.f15653b, Collections.singletonList(this.zzhdi.zzaiy()));
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public static RelativeLayout.LayoutParams m8371g(zzbll zzbll) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(zzbll.zzaby() ? 11 : 9);
        return layoutParams;
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public final void m8375k(zzbll zzbll) {
        zzbll.zza((zzsc) this);
    }

    /* renamed from: n */
    private final synchronized void m8378n(int i) {
        if (this.f15655d.compareAndSet(false, true)) {
            zzbll zzbll = this.zzhdi;
            if (!(zzbll == null || zzbll.zzajb() == null)) {
                this.f15658g.zzb(this.zzhdi.zzajb());
            }
            this.f15658g.onAdClosed();
            this.f15654c.removeAllViews();
            zzbkv zzbkv = this.f15661j;
            if (zzbkv != null) {
                zzp.zzkt().zzb(zzbkv);
            }
            if (this.zzhdi != null) {
                long j = -1;
                if (this.f15660i != -1) {
                    j = zzp.zzkx().elapsedRealtime() - this.f15660i;
                }
                this.zzhdi.zzb(j, i);
            }
            destroy();
        }
    }

    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzbll zzbll = this.zzhdi;
        if (zzbll != null) {
            zzbll.destroy();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final /* synthetic */ void mo17109e() {
        zzwq.zzqa();
        if (zzayr.zzze()) {
            m8378n(zzblb.zzfsj);
        } else {
            this.f15652a.zzaek().execute(new C2226nv(this));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final /* synthetic */ void mo17110f() {
        m8378n(zzblb.zzfsj);
    }

    public final Bundle getAdMetadata() {
        return new Bundle();
    }

    public final synchronized String getAdUnitId() {
        return this.f15656e;
    }

    public final synchronized String getMediationAdapterClassName() {
        return null;
    }

    public final synchronized zzys getVideoController() {
        return null;
    }

    public final synchronized boolean isLoading() {
        return this.f15657f.isLoading();
    }

    public final boolean isReady() {
        return false;
    }

    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    public final void setImmersiveMode(boolean z) {
    }

    public final synchronized void setManualImpressionsEnabled(boolean z) {
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

    public final void zza(zzvw zzvw) {
        this.f15657f.zza(zzvw);
    }

    public final void zza(zzws zzws) {
    }

    public final void zza(zzwt zzwt) {
    }

    public final void zza(zzxj zzxj) {
    }

    public final void zza(zzxo zzxo) {
    }

    public final void zza(zzym zzym) {
    }

    public final void zza(zzyy zzyy) {
    }

    public final void zzakz() {
        if (this.zzhdi != null) {
            this.f15660i = zzp.zzkx().elapsedRealtime();
            int zzaip = this.zzhdi.zzaip();
            if (zzaip > 0) {
                zzbkv zzbkv = new zzbkv(this.f15652a.zzael(), zzp.zzkx());
                this.f15661j = zzbkv;
                zzbkv.zza(zzaip, new C2301pv(this));
            }
        }
    }

    public final void zzbl(String str) {
    }

    public final IObjectWrapper zzkd() {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.f15654c);
    }

    public final synchronized void zzke() {
    }

    public final synchronized zzvn zzkf() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        zzbll zzbll = this.zzhdi;
        if (zzbll == null) {
            return null;
        }
        return zzdns.zzb(this.f15653b, Collections.singletonList(zzbll.zzaiy()));
    }

    public final synchronized String zzkg() {
        return null;
    }

    public final synchronized zzyn zzkh() {
        return null;
    }

    public final zzxo zzki() {
        return null;
    }

    public final zzwt zzkj() {
        return null;
    }

    public final void zzms() {
        m8378n(zzblb.zzfsh);
    }

    public final void zzvd() {
        m8378n(zzblb.zzfsi);
    }

    public final synchronized boolean zza(zzvk zzvk) {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        zzp.zzkq();
        if (zzm.zzbb(this.f15653b) && zzvk.zzchn == null) {
            zzaza.zzey("Failed to load the ad because app ID is missing.");
            this.f15658g.zzk(zzdoi.zza(zzdok.APP_ID_MISSING, (String) null, (zzve) null));
            return false;
        } else if (isLoading()) {
            return false;
        } else {
            this.f15655d = new AtomicBoolean();
            return this.f15657f.zza(zzvk, this.f15656e, new C2264ov(this), new C2338qv(this));
        }
    }

    public final void zza(zzsl zzsl) {
        this.f15658g.zzb(zzsl);
    }

    public final synchronized void zza(zzvn zzvn) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
    }

    public final synchronized void zza(zzxu zzxu) {
    }

    public final synchronized void zza(zzaak zzaak) {
    }

    public final synchronized void zza(zzacb zzacb) {
    }
}
