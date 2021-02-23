package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.internal.overlay.zzl;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzcwb extends zzanr {

    /* renamed from: a */
    private final zzbrt f14961a;

    /* renamed from: b */
    private final zzbsl f14962b;

    /* renamed from: c */
    private final zzbsu f14963c;

    /* renamed from: d */
    private final zzbte f14964d;

    /* renamed from: e */
    private final zzbvy f14965e;

    /* renamed from: f */
    private final zzbtr f14966f;

    /* renamed from: g */
    private final zzbyn f14967g;

    /* renamed from: h */
    private final zzbvv f14968h;

    /* renamed from: i */
    private final zzbsb f14969i;

    public zzcwb(zzbrt zzbrt, zzbsl zzbsl, zzbsu zzbsu, zzbte zzbte, zzbvy zzbvy, zzbtr zzbtr, zzbyn zzbyn, zzbvv zzbvv, zzbsb zzbsb) {
        this.f14961a = zzbrt;
        this.f14962b = zzbsl;
        this.f14963c = zzbsu;
        this.f14964d = zzbte;
        this.f14965e = zzbvy;
        this.f14966f = zzbtr;
        this.f14967g = zzbyn;
        this.f14968h = zzbvv;
        this.f14969i = zzbsb;
    }

    public final void onAdClicked() {
        this.f14961a.onAdClicked();
    }

    public final void onAdClosed() {
        this.f14966f.zza(zzl.OTHER);
    }

    public final void onAdFailedToLoad(int i) {
    }

    public void onAdImpression() {
        this.f14962b.onAdImpression();
        this.f14968h.zzakm();
    }

    public final void onAdLeftApplication() {
        this.f14963c.onAdLeftApplication();
    }

    public final void onAdLoaded() {
        this.f14964d.onAdLoaded();
    }

    public final void onAdOpened() {
        this.f14966f.zzux();
        this.f14968h.zzako();
    }

    public final void onAppEvent(String str, String str2) {
        this.f14965e.onAppEvent(str, str2);
    }

    public void onVideoEnd() {
        this.f14967g.onVideoEnd();
    }

    public final void onVideoPause() {
        this.f14967g.onVideoPause();
    }

    public final void onVideoPlay() {
        this.f14967g.onVideoPlay();
    }

    public final void zza(zzaff zzaff, String str) {
    }

    public final void zza(zzant zzant) {
    }

    public void zza(zzavc zzavc) {
    }

    public final void zzb(Bundle bundle) {
    }

    public void zzb(zzava zzava) {
    }

    public final void zzc(int i, String str) {
    }

    public final void zzc(zzve zzve) {
    }

    @Deprecated
    public final void zzdc(int i) {
        zze(new zzve(i, "", AdError.UNDEFINED_DOMAIN, (zzve) null, (IBinder) null));
    }

    public final void zzdj(String str) {
    }

    public final void zzdk(String str) {
        zze(new zzve(0, str, AdError.UNDEFINED_DOMAIN, (zzve) null, (IBinder) null));
    }

    public final void zze(zzve zzve) {
        this.f14969i.zzl(zzdoi.zza(zzdok.MEDIATION_SHOW_ERROR, zzve));
    }

    public void zzun() {
        this.f14967g.onVideoStart();
    }

    public void zzuo() {
    }
}
