package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcxq implements AppEventListener, zzbru, zzbrz, zzbsm, zzbtj, zzbub, zzva {

    /* renamed from: a */
    private final AtomicReference<zzwt> f15044a = new AtomicReference<>();

    /* renamed from: b */
    private final AtomicReference<zzxo> f15045b = new AtomicReference<>();

    /* renamed from: c */
    private final AtomicReference<zzym> f15046c = new AtomicReference<>();

    public final void onAdClicked() {
        zzdkb.zza(this.f15044a, C1852dr.f8287a);
    }

    public final void onAdClosed() {
        zzdkb.zza(this.f15044a, C2635yq.f12230a);
    }

    public final void onAdImpression() {
        zzdkb.zza(this.f15044a, C1963gr.f8807a);
    }

    public final void onAdLeftApplication() {
        zzdkb.zza(this.f15044a, C1815cr.f8031a);
    }

    public final void onAdLoaded() {
        zzdkb.zza(this.f15044a, C1778br.f7934a);
    }

    public final void onAdOpened() {
        zzdkb.zza(this.f15044a, C1889er.f8396a);
    }

    public final void onAppEvent(String str, String str2) {
        zzdkb.zza(this.f15045b, new C2000hr(str, str2));
    }

    public final void onRewardedVideoCompleted() {
    }

    public final void onRewardedVideoStarted() {
    }

    public final synchronized zzwt zzart() {
        return this.f15044a.get();
    }

    public final synchronized zzxo zzaru() {
        return this.f15045b.get();
    }

    public final void zzb(zzauf zzauf, String str, String str2) {
    }

    public final void zzb(zzxo zzxo) {
        this.f15045b.set(zzxo);
    }

    public final void zzc(zzwt zzwt) {
        this.f15044a.set(zzwt);
    }

    public final void zzk(zzve zzve) {
        zzdkb.zza(this.f15044a, new C1741ar(zzve));
        zzdkb.zza(this.f15044a, new C2672zq(zzve));
    }

    public final void zzb(zzym zzym) {
        this.f15046c.set(zzym);
    }

    public final void zzb(@NonNull zzvp zzvp) {
        zzdkb.zza(this.f15046c, new C1926fr(zzvp));
    }
}
