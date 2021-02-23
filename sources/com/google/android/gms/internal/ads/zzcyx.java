package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.util.zzbq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbrg;
import com.google.android.gms.internal.ads.zzbwp;
import com.google.android.gms.internal.ads.zzczo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcyx extends zzaxt {

    /* renamed from: k */
    private static final List<String> f15075k = new ArrayList(Arrays.asList(new String[]{"/aclk", "/pcs/click"}));

    /* renamed from: l */
    private static final List<String> f15076l = new ArrayList(Arrays.asList(new String[]{".doubleclick.net", ".googleadservices.com"}));

    /* renamed from: m */
    private static final List<String> f15077m = new ArrayList(Arrays.asList(new String[]{"/pagead/adview", "/pcs/view", "/pagead/conversion"}));

    /* renamed from: n */
    private static final List<String> f15078n = new ArrayList(Arrays.asList(new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"}));

    /* renamed from: a */
    private zzbgm f15079a;

    /* renamed from: b */
    private Context f15080b;

    /* renamed from: c */
    private zzef f15081c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public zzazh f15082d;

    /* renamed from: e */
    private zzdod<zzcgh> f15083e;

    /* renamed from: f */
    private final zzdzc f15084f;

    /* renamed from: g */
    private final ScheduledExecutorService f15085g;
    @Nullable

    /* renamed from: h */
    private zzasl f15086h;

    /* renamed from: i */
    private Point f15087i = new Point();

    /* renamed from: j */
    private Point f15088j = new Point();

    public zzcyx(zzbgm zzbgm, Context context, zzef zzef, zzazh zzazh, zzdod<zzcgh> zzdod, zzdzc zzdzc, ScheduledExecutorService scheduledExecutorService) {
        this.f15079a = zzbgm;
        this.f15080b = context;
        this.f15081c = zzef;
        this.f15082d = zzazh;
        this.f15083e = zzdod;
        this.f15084f = zzdzc;
        this.f15085g = scheduledExecutorService;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final Uri mo17063k(Uri uri, IObjectWrapper iObjectWrapper) {
        try {
            uri = this.f15081c.zza(uri, this.f15080b, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null);
        } catch (zzei e) {
            zzaza.zzd("", e);
        }
        if (uri.getQueryParameter("ms") != null) {
            return uri;
        }
        throw new Exception("Failed to append spam signals to click url.");
    }

    /* renamed from: b */
    private static Uri m8317b(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl=");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl=");
        }
        if (indexOf == -1) {
            return uri.buildUpon().appendQueryParameter(str, str2).build();
        }
        int i = indexOf + 1;
        return Uri.parse(uri2.substring(0, i) + str + "=" + str2 + "&" + uri2.substring(i));
    }

    /* renamed from: g */
    static /* synthetic */ ArrayList m8320g(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (!m8325o(uri) || TextUtils.isEmpty(str)) {
                arrayList.add(uri);
            } else {
                arrayList.add(m8317b(uri, "nas", str));
            }
        }
        return arrayList;
    }

    /* renamed from: i */
    private static boolean m8321i(@NonNull Uri uri, List<String> list, List<String> list2) {
        String host = uri.getHost();
        String path = uri.getPath();
        if (!(host == null || path == null)) {
            for (String contains : list) {
                if (path.contains(contains)) {
                    for (String endsWith : list2) {
                        if (host.endsWith(endsWith)) {
                            return true;
                        }
                    }
                    continue;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.zzdse;
     */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean m8322j() {
        /*
            r1 = this;
            com.google.android.gms.internal.ads.zzasl r0 = r1.f15086h
            if (r0 == 0) goto L_0x0010
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r0 = r0.zzdse
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0010
            r0 = 1
            return r0
        L_0x0010:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcyx.m8322j():boolean");
    }

    /* renamed from: m */
    static /* synthetic */ Uri m8323m(Uri uri, String str) {
        return !TextUtils.isEmpty(str) ? m8317b(uri, "nas", str) : uri;
    }

    /* renamed from: n */
    private final zzdyz<String> m8324n(String str) {
        zzcgh[] zzcghArr = new zzcgh[1];
        zzdyz<O> zzb = zzdyr.zzb(this.f15083e.zzaux(), new C1816cs(this, zzcghArr, str), (Executor) this.f15084f);
        zzb.addListener(new C1779bs(this, zzcghArr), this.f15084f);
        return zzdyi.zzg(zzb).zza((long) ((Integer) zzwq.zzqe().zzd(zzabf.zzcya)).intValue(), TimeUnit.MILLISECONDS, this.f15085g).zza(C1742as.f7850a, this.f15084f).zza(Exception.class, C2673zr.f12319a, (Executor) this.f15084f);
    }

    @VisibleForTesting
    /* renamed from: o */
    private static boolean m8325o(@NonNull Uri uri) {
        return m8321i(uri, f15077m, f15078n);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ zzdyz mo17060d(zzcgh[] zzcghArr, String str, zzcgh zzcgh) {
        zzcghArr[0] = zzcgh;
        Context context = this.f15080b;
        zzasl zzasl = this.f15086h;
        Map<String, WeakReference<View>> map = zzasl.zzdse;
        JSONObject zza = zzbq.zza(context, map, map, zzasl.zzaaq);
        JSONObject zza2 = zzbq.zza(this.f15080b, this.f15086h.zzaaq);
        JSONObject zzt = zzbq.zzt(this.f15086h.zzaaq);
        JSONObject zzb = zzbq.zzb(this.f15080b, this.f15086h.zzaaq);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("asset_view_signal", zza);
        jSONObject.put("ad_view_signal", zza2);
        jSONObject.put("scroll_view_signal", zzt);
        jSONObject.put("lock_screen_signal", zzb);
        if (str == "google.afma.nativeAds.getPublisherCustomRenderedClickSignals") {
            jSONObject.put("click_signal", zzbq.zza((String) null, this.f15080b, this.f15088j, this.f15087i));
        }
        return zzcgh.zzc(str, jSONObject);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final /* synthetic */ ArrayList mo17061f(List list, IObjectWrapper iObjectWrapper) {
        String zza = this.f15081c.zzca() != null ? this.f15081c.zzca().zza(this.f15080b, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null) : "";
        if (!TextUtils.isEmpty(zza)) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Uri uri = (Uri) it.next();
                if (!m8325o(uri)) {
                    String valueOf = String.valueOf(uri);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                    sb.append("Not a Google URL: ");
                    sb.append(valueOf);
                    zzaza.zzfa(sb.toString());
                    arrayList.add(uri);
                } else {
                    arrayList.add(m8317b(uri, "ms", zza));
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
            throw new Exception("Empty impression URLs result.");
        }
        throw new Exception("Failed to get view signals.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final /* synthetic */ void mo17062h(zzcgh[] zzcghArr) {
        if (zzcghArr[0] != null) {
            this.f15083e.zzd(zzdyr.zzag(zzcghArr[0]));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public final /* synthetic */ zzdyz mo17064l(ArrayList arrayList) {
        return zzdyr.zzb(m8324n("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), new C2636yr(this, arrayList), (Executor) this.f15084f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public final /* synthetic */ zzdyz mo17065p(Uri uri) {
        return zzdyr.zzb(m8324n("google.afma.nativeAds.getPublisherCustomRenderedClickSignals"), new C2598xr(this, uri), (Executor) this.f15084f);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzaxw zzaxw, zzaxp zzaxp) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        this.f15080b = context;
        String str = zzaxw.zzbum;
        String str2 = zzaxw.zzbrc;
        zzvn zzvn = zzaxw.zzead;
        zzvk zzvk = zzaxw.zzeae;
        zzcyy zzafa = this.f15079a.zzafa();
        zzbrg.zza zzcg = new zzbrg.zza().zzcg(context);
        zzdnp zzdnp = new zzdnp();
        if (str == null) {
            str = "adUnitId";
        }
        zzdnp zzgq = zzdnp.zzgq(str);
        if (zzvk == null) {
            zzvk = new zzvj().zzpn();
        }
        zzdnp zzh = zzgq.zzh(zzvk);
        if (zzvn == null) {
            zzvn = new zzvn();
        }
        zzdyr.zza(zzafa.zzg(zzcg.zza(zzh.zzf(zzvn).zzaus()).zzakx()).zza(new zzczo(new zzczo.zza().zzgp(str2))).zzg(new zzbwp.zza().zzalt()).zzahp().zzahv(), new C1890es(this, zzaxp), this.f15079a.zzaek());
    }

    public final void zzan(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcxz)).booleanValue()) {
            MotionEvent motionEvent = (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper);
            zzasl zzasl = this.f15086h;
            this.f15087i = zzbq.zza(motionEvent, zzasl == null ? null : zzasl.zzaaq);
            if (motionEvent.getAction() == 0) {
                this.f15088j = this.f15087i;
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            Point point = this.f15087i;
            obtain.setLocation((float) point.x, (float) point.y);
            this.f15081c.zza(obtain);
            obtain.recycle();
        }
    }

    public final IObjectWrapper zzao(IObjectWrapper iObjectWrapper) {
        return null;
    }

    public final IObjectWrapper zzb(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return null;
    }

    public final void zzb(List<Uri> list, IObjectWrapper iObjectWrapper, zzasa zzasa) {
        try {
            if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcxz)).booleanValue()) {
                zzasa.onError("The updating URL feature is not enabled.");
            } else if (list.size() != 1) {
                zzasa.onError("There should be only 1 click URL.");
            } else {
                Uri uri = list.get(0);
                if (!m8321i(uri, f15075k, f15076l)) {
                    String valueOf = String.valueOf(uri);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                    sb.append("Not a Google URL: ");
                    sb.append(valueOf);
                    zzaza.zzfa(sb.toString());
                    zzasa.onSuccess(list);
                    return;
                }
                zzdyz zze = this.f15084f.zze(new C2560wr(this, uri, iObjectWrapper));
                if (m8322j()) {
                    zze = zzdyr.zzb(zze, new C2523vr(this), (Executor) this.f15084f);
                } else {
                    zzaza.zzez("Asset view map is empty.");
                }
                zzdyr.zza(zze, new C1927fs(this, zzasa), this.f15079a.zzaek());
            }
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void zza(zzasl zzasl) {
        this.f15086h = zzasl;
        this.f15083e.ensureSize(1);
    }

    public final void zza(List<Uri> list, IObjectWrapper iObjectWrapper, zzasa zzasa) {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcxz)).booleanValue()) {
            try {
                zzasa.onError("The updating URL feature is not enabled.");
            } catch (RemoteException e) {
                zzaza.zzc("", e);
            }
        } else {
            zzdyz zze = this.f15084f.zze(new C2486ur(this, list, iObjectWrapper));
            if (m8322j()) {
                zze = zzdyr.zzb(zze, new C2412sr(this), (Executor) this.f15084f);
            } else {
                zzaza.zzez("Asset view map is empty.");
            }
            zzdyr.zza(zze, new C1853ds(this, zzasa), this.f15079a.zzaek());
        }
    }
}
