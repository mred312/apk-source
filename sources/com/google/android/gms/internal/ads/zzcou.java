package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcou extends zzatb {

    /* renamed from: a */
    private final Context f14656a;

    /* renamed from: b */
    private final Executor f14657b;

    /* renamed from: c */
    private final zzaty f14658c;

    /* renamed from: d */
    private final zzatz f14659d;

    /* renamed from: e */
    private final zzbjl f14660e;

    /* renamed from: f */
    private final HashMap<String, zzcpf> f14661f;

    public zzcou(Context context, Executor executor, zzaty zzaty, zzbjl zzbjl, zzatz zzatz, HashMap<String, zzcpf> hashMap) {
        zzabf.initialize(context);
        this.f14656a = context;
        this.f14657b = executor;
        this.f14658c = zzaty;
        this.f14659d = zzatz;
        this.f14660e = zzbjl;
        this.f14661f = hashMap;
    }

    /* renamed from: a */
    private static zzdyz<JSONObject> m8221a(zzatl zzatl, zzdro zzdro, zzdga zzdga) {
        C2668zm zmVar = new C2668zm(zzdga);
        return zzdro.zza(zzdrl.GMS_SIGNALS, zzdyr.zzag(zzatl.zzdvx)).zza(zmVar).zzb(C2631ym.f12220a).zzaww();
    }

    /* renamed from: b */
    private static zzdyz<zzatr> m8222b(zzdyz<JSONObject> zzdyz, zzdro zzdro, zzaml zzaml) {
        return zzdro.zza(zzdrl.BUILD_URL, zzdyz).zza(zzaml.zza("AFMA_getAdDictionary", zzamg.zzdjy, C1811cn.f8023a)).zzaww();
    }

    /* renamed from: d */
    private final void m8223d(zzdyz<InputStream> zzdyz, zzatf zzatf) {
        zzdyr.zza(zzdyr.zzb(zzdyz, new C1959gn(this), (Executor) zzazj.zzegp), new C1996hn(this, zzatf), zzazj.zzegu);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ InputStream mo16945c(zzdyz zzdyz, zzdyz zzdyz2) {
        String zzvy = ((zzatr) zzdyz.get()).zzvy();
        this.f14661f.put(zzvy, new zzcpf((zzatr) zzdyz.get(), (JSONObject) zzdyz2.get()));
        return new ByteArrayInputStream(zzvy.getBytes(zzdvk.UTF_8));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final /* synthetic */ void mo16946e() {
        zzazm.zza(this.f14659d.zzwa(), "persistFlags");
    }

    public final zzasu zza(zzass zzass) {
        return null;
    }

    public final void zza(zzass zzass, zzatd zzatd) {
    }

    public final void zza(zzatl zzatl, zzatf zzatf) {
        zzdyz<InputStream> zzb = zzb(zzatl, Binder.getCallingUid());
        m8223d(zzb, zzatf);
        zzb.addListener(new C1737an(this), this.f14657b);
    }

    public final zzdyz<InputStream> zzb(zzatl zzatl, int i) {
        zzaml zza = zzp.zzld().zza(this.f14656a, zzazh.zzzi());
        zzdga zza2 = this.f14660e.zza(zzatl, i);
        zzamd<I, O> zza3 = zza.zza("google.afma.response.normalize", zzcpi.zzgol, zzamg.zzdjz);
        zzcpj zzcpj = new zzcpj(this.f14656a, zzatl.zzdsm.zzbrf, this.f14658c, zzatl.zzdtm, i);
        zzdro zzagn = zza2.zzagn();
        zzcpf zzcpf = null;
        if (!zzadf.zzddc.get().booleanValue()) {
            String str = zzatl.zzdwb;
            if (str != null && !str.isEmpty()) {
                zzd.zzee("Request contained a PoolKey but split request is disabled.");
            }
        } else {
            String str2 = zzatl.zzdwb;
            if (str2 != null && !str2.isEmpty() && (zzcpf = this.f14661f.remove(zzatl.zzdwb)) == null) {
                zzd.zzee("Request contained a PoolKey but no matching parameters were found.");
            }
        }
        if (zzcpf == null) {
            zzdyz<JSONObject> a = m8221a(zzatl, zzagn, zza2);
            zzdyz<zzatr> b = m8222b(a, zzagn, zza);
            zzdqx zzaww = zzagn.zza(zzdrl.HTTP, (zzdyz<?>[]) new zzdyz[]{b, a}).zzb(new C2518vm(a, b)).zzb(zzcpj).zzaww();
            return zzagn.zza(zzdrl.PRE_PROCESS, (zzdyz<?>[]) new zzdyz[]{a, b, zzaww}).zzb(new C2593xm(zzaww, a, b)).zza(zza3).zzaww();
        }
        zzdqx zzaww2 = zzagn.zza(zzdrl.HTTP, zzdyr.zzag(new zzcpm(zzcpf.zzgoi, zzcpf.zzgoh))).zzb(zzcpj).zzaww();
        zzdyz zzag = zzdyr.zzag(zzcpf);
        return zzagn.zza(zzdrl.PRE_PROCESS, (zzdyz<?>[]) new zzdyz[]{zzaww2, zzag}).zzb(new C2555wm(zzaww2, zzag)).zza(zza3).zzaww();
    }

    public final zzdyz<InputStream> zzc(zzatl zzatl, int i) {
        if (!zzadf.zzddc.get().booleanValue()) {
            return zzdyr.immediateFailedFuture(new Exception("Split request is disabled."));
        }
        zzdpk zzdpk = zzatl.zzdwa;
        if (zzdpk == null) {
            return zzdyr.immediateFailedFuture(new Exception("Pool configuration missing from request."));
        }
        if (zzdpk.zzhln == 0 || zzdpk.zzhlo == 0) {
            return zzdyr.immediateFailedFuture(new Exception("Caching is disabled."));
        }
        zzaml zza = zzp.zzld().zza(this.f14656a, zzazh.zzzi());
        zzdga zza2 = this.f14660e.zza(zzatl, i);
        zzdro zzagn = zza2.zzagn();
        zzdyz<JSONObject> a = m8221a(zzatl, zzagn, zza2);
        zzdyz<zzatr> b = m8222b(a, zzagn, zza);
        return zzagn.zza(zzdrl.GET_URL_AND_CACHE_KEY, (zzdyz<?>[]) new zzdyz[]{a, b}).zzb(new C1885en(this, b, a)).zzaww();
    }

    public final zzdyz<InputStream> zzd(zzatl zzatl, int i) {
        zzaml zza = zzp.zzld().zza(this.f14656a, zzazh.zzzi());
        if (!zzadl.zzddt.get().booleanValue()) {
            return zzdyr.immediateFailedFuture(new Exception("Signal collection disabled."));
        }
        zzdga zza2 = this.f14660e.zza(zzatl, i);
        zzdfl<JSONObject> zzagm = zza2.zzagm();
        return zza2.zzagn().zza(zzdrl.GET_SIGNALS, zzdyr.zzag(zzatl.zzdvx)).zza(new C1848dn(zzagm)).zzw(zzdrl.JS_SIGNALS).zza(zza.zza("google.afma.request.getSignals", zzamg.zzdjy, zzamg.zzdjz)).zzaww();
    }

    public final zzdyz<InputStream> zzgj(String str) {
        if (!zzadf.zzddc.get().booleanValue()) {
            return zzdyr.immediateFailedFuture(new Exception("Split request is disabled."));
        }
        C1922fn fnVar = new C1922fn(this);
        if (this.f14661f.remove(str) != null) {
            return zzdyr.zzag(fnVar);
        }
        String valueOf = String.valueOf(str);
        return zzdyr.immediateFailedFuture(new Exception(valueOf.length() != 0 ? "URL to be removed not found for cache key: ".concat(valueOf) : new String("URL to be removed not found for cache key: ")));
    }

    public final void zza(String str, zzatf zzatf) {
        m8223d(zzgj(str), zzatf);
    }

    public final void zzc(zzatl zzatl, zzatf zzatf) {
        m8223d(zzc(zzatl, Binder.getCallingUid()), zzatf);
    }

    public final void zzb(zzatl zzatl, zzatf zzatf) {
        m8223d(zzd(zzatl, Binder.getCallingUid()), zzatf);
    }
}
