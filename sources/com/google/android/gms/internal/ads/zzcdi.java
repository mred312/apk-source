package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.ads.mediation.facebook.FacebookAdapter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcdi {

    /* renamed from: a */
    private final zzchp f14142a;

    /* renamed from: b */
    private final zzcgh f14143b;

    /* renamed from: c */
    private final zzbkr f14144c;

    /* renamed from: d */
    private final zzccm f14145d;

    public zzcdi(zzchp zzchp, zzcgh zzcgh, zzbkr zzbkr, zzccm zzccm) {
        this.f14142a = zzchp;
        this.f14143b = zzcgh;
        this.f14144c = zzbkr;
        this.f14145d = zzccm;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo16704a(zzbdv zzbdv, Map map) {
        zzaza.zzez("Hiding native ads overlay.");
        zzbdv.getView().setVisibility(8);
        this.f14144c.zzbe(false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo16705b(Map map, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "htmlLoaded");
        hashMap.put(FacebookAdapter.KEY_ID, (String) map.get(FacebookAdapter.KEY_ID));
        this.f14143b.zza("sendMessageToNativeJs", (Map<String, ?>) hashMap);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ void mo16706c(zzbdv zzbdv, Map map) {
        zzaza.zzez("Showing native ads overlay.");
        zzbdv.getView().setVisibility(0);
        this.f14144c.zzbe(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ void mo16707d(zzbdv zzbdv, Map map) {
        this.f14145d.zzams();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final /* synthetic */ void mo16708e(zzbdv zzbdv, Map map) {
        this.f14143b.zza("sendMessageToNativeJs", (Map<String, ?>) map);
    }

    public final View zzaon() {
        zzbdv zzd = this.f14142a.zzd(zzvn.zzpo());
        zzd.getView().setVisibility(8);
        zzd.zza("/sendMessageToSdk", (zzahv<? super zzbdv>) new C2361rh(this));
        zzd.zza("/adMuted", (zzahv<? super zzbdv>) new C2439th(this));
        this.f14143b.zza(new WeakReference(zzd), "/loadHtml", new C2402sh(this));
        this.f14143b.zza(new WeakReference(zzd), "/showOverlay", new C2513vh(this));
        this.f14143b.zza(new WeakReference(zzd), "/hideOverlay", new C2476uh(this));
        return zzd.getView();
    }
}
