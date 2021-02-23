package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcff {

    /* renamed from: a */
    private final zzdnn f14263a;

    /* renamed from: b */
    private final Executor f14264b;

    /* renamed from: c */
    private final zzchp f14265c;

    public zzcff(zzdnn zzdnn, Executor executor, zzchp zzchp) {
        this.f14263a = zzdnn;
        this.f14264b = executor;
        this.f14265c = zzchp;
    }

    /* renamed from: e */
    private final void m8128e(zzbdv zzbdv) {
        zzbdv.zza("/video", (zzahv<? super zzbdv>) zzahc.zzdgf);
        zzbdv.zza("/videoMeta", (zzahv<? super zzbdv>) zzahc.zzdgg);
        zzbdv.zza("/precache", (zzahv<? super zzbdv>) new zzbdc());
        zzbdv.zza("/delayPageLoaded", (zzahv<? super zzbdv>) zzahc.zzdgj);
        zzbdv.zza("/instrument", (zzahv<? super zzbdv>) zzahc.zzdgh);
        zzbdv.zza("/log", (zzahv<? super zzbdv>) zzahc.zzdga);
        zzbdv.zza("/videoClicked", (zzahv<? super zzbdv>) zzahc.zzdgb);
        zzbdv.zzacs().zzax(true);
        zzbdv.zza("/click", (zzahv<? super zzbdv>) zzahc.zzdfw);
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcry)).booleanValue()) {
            zzbdv.zza("/getNativeAdViewSignals", (zzahv<? super zzbdv>) zzahc.zzdgm);
        }
        if (this.f14263a.zzdui != null) {
            zzbdv.zzacs().zzay(true);
            zzbdv.zza("/open", (zzahv<? super zzbdv>) new zzahz((zza) null, (zzaqk) null, (zzcqo) null, (zzckq) null));
        } else {
            zzbdv.zzacs().zzay(false);
        }
        if (zzp.zzlo().zzz(zzbdv.getContext())) {
            zzbdv.zza("/logScionEvent", (zzahv<? super zzbdv>) new zzahx(zzbdv.getContext()));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzdyz mo16827a(String str, String str2, Object obj) {
        zzbdv zzd = this.f14265c.zzd(zzvn.zzpo());
        zzazr zzl = zzazr.zzl(zzd);
        m8128e(zzd);
        if (this.f14263a.zzdui != null) {
            zzd.zza(zzbfn.zzadx());
        } else {
            zzd.zza(zzbfn.zzadw());
        }
        zzd.zzacs().zza((zzbfj) new C2551wi(this, zzd, zzl));
        zzd.zzb(str, str2, (String) null);
        return zzl;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ zzdyz mo16828b(JSONObject jSONObject, zzbdv zzbdv) {
        zzazr zzl = zzazr.zzl(zzbdv);
        if (this.f14263a.zzdui != null) {
            zzbdv.zza(zzbfn.zzadx());
        } else {
            zzbdv.zza(zzbfn.zzadw());
        }
        zzbdv.zzacs().zza((zzbfj) new C2514vi(this, zzbdv, zzl));
        zzbdv.zza("google.afma.nativeAds.renderVideo", jSONObject);
        return zzl;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ void mo16829c(zzbdv zzbdv, zzazr zzazr, boolean z) {
        if (z) {
            if (!(this.f14263a.zzhin == null || zzbdv.zzaah() == null)) {
                zzbdv.zzaah().zzb(this.f14263a.zzhin);
            }
            zzazr.zzzj();
            return;
        }
        zzazr.setException(new zzcuq(zzdok.INTERNAL_ERROR, "Instream video Web View failed to load."));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ void mo16830d(zzbdv zzbdv, zzazr zzazr, boolean z) {
        if (!(this.f14263a.zzhin == null || zzbdv.zzaah() == null)) {
            zzbdv.zzaah().zzb(this.f14263a.zzhin);
        }
        zzazr.zzzj();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final /* synthetic */ zzdyz mo16831f(Object obj) {
        zzbdv zzd = this.f14265c.zzd(zzvn.zzpo());
        zzazr zzl = zzazr.zzl(zzd);
        m8128e(zzd);
        zzd.zzacs().zza((zzbfi) new C2440ti(zzl));
        zzd.loadUrl((String) zzwq.zzqe().zzd(zzabf.zzcrx));
        return zzl;
    }

    public final zzdyz<zzbdv> zzn(JSONObject jSONObject) {
        return zzdyr.zzb(zzdyr.zzb(zzdyr.zzag(null), new C2477ui(this), this.f14264b), new C2403si(this, jSONObject), this.f14264b);
    }

    public final zzdyz<zzbdv> zzo(String str, String str2) {
        return zzdyr.zzb(zzdyr.zzag(null), new C2362ri(this, str, str2), this.f14264b);
    }
}
