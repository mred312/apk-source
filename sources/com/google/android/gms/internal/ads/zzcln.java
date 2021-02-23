package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcln implements AppEventListener, zzbru, zzbrz, zzbsm, zzbsp, zzbtj, zzbui, zzdru, zzva {

    /* renamed from: a */
    private final List<Object> f14555a;

    /* renamed from: b */
    private final zzclb f14556b;

    /* renamed from: c */
    private long f14557c;

    public zzcln(zzclb zzclb, zzbgm zzbgm) {
        this.f14556b = zzclb;
        this.f14555a = Collections.singletonList(zzbgm);
    }

    /* renamed from: a */
    private final void m8186a(Class<?> cls, String str, Object... objArr) {
        zzclb zzclb = this.f14556b;
        List<Object> list = this.f14555a;
        String valueOf = String.valueOf(cls.getSimpleName());
        zzclb.zza(list, valueOf.length() != 0 ? "Event-".concat(valueOf) : new String("Event-"), str, objArr);
    }

    public final void onAdClicked() {
        m8186a(zzva.class, "onAdClicked", new Object[0]);
    }

    public final void onAdClosed() {
        m8186a(zzbru.class, "onAdClosed", new Object[0]);
    }

    public final void onAdImpression() {
        m8186a(zzbsm.class, "onAdImpression", new Object[0]);
    }

    public final void onAdLeftApplication() {
        m8186a(zzbru.class, "onAdLeftApplication", new Object[0]);
    }

    public final void onAdLoaded() {
        long elapsedRealtime = zzp.zzkx().elapsedRealtime() - this.f14557c;
        StringBuilder sb = new StringBuilder(41);
        sb.append("Ad Request Latency : ");
        sb.append(elapsedRealtime);
        zzd.zzee(sb.toString());
        m8186a(zzbtj.class, "onAdLoaded", new Object[0]);
    }

    public final void onAdOpened() {
        m8186a(zzbru.class, "onAdOpened", new Object[0]);
    }

    public final void onAppEvent(String str, String str2) {
        m8186a(AppEventListener.class, "onAppEvent", str, str2);
    }

    public final void onRewardedVideoCompleted() {
        m8186a(zzbru.class, "onRewardedVideoCompleted", new Object[0]);
    }

    public final void onRewardedVideoStarted() {
        m8186a(zzbru.class, "onRewardedVideoStarted", new Object[0]);
    }

    public final void zza(zzdrl zzdrl, String str) {
        m8186a(zzdrm.class, "onTaskCreated", str);
    }

    @ParametersAreNonnullByDefault
    public final void zzb(zzauf zzauf, String str, String str2) {
        m8186a(zzbru.class, "onRewarded", zzauf, str, str2);
    }

    public final void zzb(zzdnj zzdnj) {
    }

    public final void zzc(zzdrl zzdrl, String str) {
        m8186a(zzdrm.class, "onTaskSucceeded", str);
    }

    public final void zzcc(Context context) {
        m8186a(zzbsp.class, "onPause", context);
    }

    public final void zzcd(Context context) {
        m8186a(zzbsp.class, "onResume", context);
    }

    public final void zzce(Context context) {
        m8186a(zzbsp.class, "onDestroy", context);
    }

    public final void zzd(zzatl zzatl) {
        this.f14557c = zzp.zzkx().elapsedRealtime();
        m8186a(zzbui.class, "onAdRequest", new Object[0]);
    }

    public final void zzk(zzve zzve) {
        m8186a(zzbrz.class, "onAdFailedToLoad", Integer.valueOf(zzve.errorCode), zzve.zzcgs, zzve.zzcgt);
    }

    public final void zza(zzdrl zzdrl, String str, Throwable th) {
        m8186a(zzdrm.class, "onTaskFailed", str, th.getClass().getSimpleName());
    }

    public final void zzb(zzdrl zzdrl, String str) {
        m8186a(zzdrm.class, "onTaskStarted", str);
    }
}
