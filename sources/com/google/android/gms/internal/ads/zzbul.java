package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.reward.AdMetadataListener;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbul extends AdMetadataListener implements AppEventListener, zzp, zzbru, zzbsi, zzbsm, zzbto, zzbub, zzva {

    /* renamed from: a */
    private final zzbvn f13783a = new zzbvn(this);
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: b */
    public zzcxq f13784b;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: c */
    public zzcyd f13785c;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: d */
    public zzdir f13786d;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: e */
    public zzdlf f13787e;

    /* renamed from: e */
    private static <T> void m7868e(T t, C2173mf<T> mfVar) {
        if (t != null) {
            mfVar.zzq(t);
        }
    }

    public final void onAdClicked() {
        m7868e(this.f13784b, C2209ne.f10183a);
        m7868e(this.f13785c, C2321qe.f10714a);
    }

    public final void onAdClosed() {
        m7868e(this.f13784b, C2510ve.f11605a);
        m7868e(this.f13787e, C1914ff.f8454a);
    }

    public final void onAdImpression() {
        m7868e(this.f13784b, C2473ue.f11325a);
    }

    public final void onAdLeftApplication() {
        m7868e(this.f13784b, C1877ef.f8354a);
        m7868e(this.f13787e, C1988hf.f9189a);
    }

    public final void onAdMetadataChanged() {
        m7868e(this.f13787e, C2547we.f11704a);
    }

    public final void onAdOpened() {
        m7868e(this.f13784b, C2098ke.f9750a);
        m7868e(this.f13787e, C2172me.f9956a);
    }

    public final void onAppEvent(String str, String str2) {
        m7868e(this.f13784b, new C2284pe(str, str2));
    }

    public final void onPause() {
        m7868e(this.f13786d, C1840df.f8251a);
    }

    public final void onResume() {
        m7868e(this.f13786d, C1803cf.f7999a);
    }

    public final void onRewardedVideoCompleted() {
        m7868e(this.f13784b, C2135le.f9858a);
        m7868e(this.f13787e, C2247oe.f10363a);
    }

    public final void onRewardedVideoStarted() {
        m7868e(this.f13784b, C1951gf.f8768a);
        m7868e(this.f13787e, C2062jf.f9480a);
    }

    public final void onUserLeaveHint() {
        m7868e(this.f13786d, C1729af.f7810a);
    }

    public final void zza(zzl zzl) {
        m7868e(this.f13786d, new C1766bf(zzl));
    }

    public final zzbvn zzakb() {
        return this.f13783a;
    }

    public final void zzakz() {
        m7868e(this.f13786d, C2436te.f11172a);
    }

    public final void zzb(zzauf zzauf, String str, String str2) {
        m7868e(this.f13784b, new C2025if(zzauf, str, str2));
        m7868e(this.f13787e, new C2136lf(zzauf, str, str2));
    }

    public final void zzj(zzve zzve) {
        m7868e(this.f13787e, new C2623ye(zzve));
    }

    public final void zzux() {
        m7868e(this.f13786d, C2585xe.f11895a);
    }

    public final void zzb(zzvp zzvp) {
        m7868e(this.f13784b, new C2399se(zzvp));
        m7868e(this.f13787e, new C2358re(zzvp));
    }
}
