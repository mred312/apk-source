package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcgh {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C2103kj f14310a = new C2103kj((C1992hj) null);

    /* renamed from: b */
    private final zzb f14311b;

    /* renamed from: c */
    private final Context f14312c;

    /* renamed from: d */
    private final zzckq f14313d;

    /* renamed from: e */
    private final Executor f14314e;

    /* renamed from: f */
    private final zzef f14315f;

    /* renamed from: g */
    private final zzazh f14316g;

    /* renamed from: h */
    private final zzaif f14317h;

    /* renamed from: i */
    private final zzcqo f14318i;

    /* renamed from: j */
    private final zzdrz f14319j;

    /* renamed from: k */
    private zzdyz<zzbdv> f14320k;

    zzcgh(zzcgu zzcgu) {
        this.f14312c = zzcgu.f14333c;
        this.f14314e = zzcgu.f14336f;
        this.f14315f = zzcgu.f14337g;
        this.f14316g = zzcgu.f14338h;
        this.f14311b = zzcgu.f14331a;
        zzbed unused = zzcgu.f14332b;
        this.f14317h = new zzaif();
        this.f14318i = zzcgu.f14335e;
        this.f14319j = zzcgu.f14339i;
        this.f14313d = zzcgu.f14334d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ zzdyz mo16840b(String str, JSONObject jSONObject, zzbdv zzbdv) {
        return this.f14317h.zza(zzbdv, str, jSONObject);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ zzbdv mo16841c(zzbdv zzbdv) {
        zzbdv zzbdv2 = zzbdv;
        zzbdv2.zza("/result", (zzahv<? super zzbdv>) this.f14317h);
        zzbfg zzacs = zzbdv.zzacs();
        C2103kj kjVar = this.f14310a;
        zzacs.zza((zzva) null, kjVar, kjVar, kjVar, kjVar, false, (zzahu) null, new zza(this.f14312c, (zzawq) null, (zzasw) null), (zzaqx) null, (zzawq) null, this.f14318i, this.f14319j, this.f14313d);
        return zzbdv2;
    }

    public final synchronized void destroy() {
        zzdyz<zzbdv> zzdyz = this.f14320k;
        if (zzdyz != null) {
            zzdyr.zza(zzdyz, new C1992hj(this), this.f14314e);
            this.f14320k = null;
        }
    }

    public final synchronized void zza(String str, zzahv<Object> zzahv) {
        zzdyz<zzbdv> zzdyz = this.f14320k;
        if (zzdyz != null) {
            zzdyr.zza(zzdyz, new C1955gj(this, str, zzahv), this.f14314e);
        }
    }

    public final synchronized void zzaou() {
        zzdyz<zzbdv> zzb = zzdyr.zzb(zzbed.zza(this.f14312c, this.f14316g, (String) zzwq.zzqe().zzd(zzabf.zzcrv), this.f14315f, this.f14311b), new C1918fj(this), this.f14314e);
        this.f14320k = zzb;
        zzazm.zza(zzb, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void zzb(String str, zzahv<Object> zzahv) {
        zzdyz<zzbdv> zzdyz = this.f14320k;
        if (zzdyz != null) {
            zzdyr.zza(zzdyz, new C2066jj(this, str, zzahv), this.f14314e);
        }
    }

    public final synchronized zzdyz<JSONObject> zzc(String str, JSONObject jSONObject) {
        zzdyz<zzbdv> zzdyz = this.f14320k;
        if (zzdyz == null) {
            return zzdyr.zzag(null);
        }
        return zzdyr.zzb(zzdyz, new C1881ej(this, str, jSONObject), this.f14314e);
    }

    public final synchronized void zza(String str, Map<String, ?> map) {
        zzdyz<zzbdv> zzdyz = this.f14320k;
        if (zzdyz != null) {
            zzdyr.zza(zzdyz, new C2029ij(this, str, map), this.f14314e);
        }
    }

    public final synchronized void zza(zzdmu zzdmu, zzdmz zzdmz) {
        zzdyz<zzbdv> zzdyz = this.f14320k;
        if (zzdyz != null) {
            zzdyr.zza(zzdyz, new C2140lj(this, zzdmu, zzdmz), this.f14314e);
        }
    }

    public final <T> void zza(WeakReference<T> weakReference, String str, zzahv<T> zzahv) {
        zza(str, (zzahv<Object>) new C2214nj(this, weakReference, str, zzahv, (C1992hj) null));
    }
}
