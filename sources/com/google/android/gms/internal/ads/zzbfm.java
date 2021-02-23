package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzb;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbfm extends zzbfz implements zzbfg {

    /* renamed from: d */
    private final zzakn<zzbdv> f13219d = new zzakn<>();

    /* renamed from: e */
    private final Object f13220e = new Object();

    /* renamed from: f */
    private zzva f13221f;

    /* renamed from: g */
    private zzp f13222g;

    /* renamed from: h */
    private zzbfj f13223h;

    /* renamed from: i */
    private zzbfi f13224i;

    /* renamed from: j */
    private zzagy f13225j;

    /* renamed from: k */
    private zzaha f13226k;

    /* renamed from: l */
    private boolean f13227l = false;

    /* renamed from: m */
    private volatile boolean f13228m;
    @GuardedBy("lock")

    /* renamed from: n */
    private boolean f13229n;
    @GuardedBy("lock")

    /* renamed from: o */
    private boolean f13230o;

    /* renamed from: p */
    private zzu f13231p;

    /* renamed from: q */
    private zzaqv f13232q;

    /* renamed from: r */
    private zza f13233r;

    /* renamed from: s */
    private zzaqk f13234s;
    @Nullable

    /* renamed from: t */
    private zzawq f13235t;

    /* renamed from: u */
    private boolean f13236u;

    /* renamed from: v */
    private boolean f13237v;

    /* renamed from: w */
    private int f13238w;

    /* renamed from: x */
    private boolean f13239x;

    /* renamed from: y */
    private View.OnAttachStateChangeListener f13240y;
    protected zzbdv zzepg;

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m7742b(View view, zzawq zzawq, int i) {
        if (zzawq.zzwd() && i > 0) {
            zzawq.zzl(view);
            if (zzawq.zzwd()) {
                zzm.zzedd.postDelayed(new C2242o9(this, view, zzawq, i), 100);
            }
        }
    }

    /* renamed from: c */
    private final void m7743c(AdOverlayInfoParcel adOverlayInfoParcel) {
        zzb zzb;
        zzaqk zzaqk = this.f13234s;
        boolean zzuy = zzaqk != null ? zzaqk.zzuy() : false;
        com.google.android.gms.ads.internal.zzp.zzkp();
        zzo.zza(this.zzepg.getContext(), adOverlayInfoParcel, !zzuy);
        zzawq zzawq = this.f13235t;
        if (zzawq != null) {
            String str = adOverlayInfoParcel.url;
            if (str == null && (zzb = adOverlayInfoParcel.zzdrl) != null) {
                str = zzb.url;
            }
            zzawq.zzdw(str);
        }
    }

    /* renamed from: f */
    private final void m7745f() {
        if (this.f13240y != null) {
            this.zzepg.getView().removeOnAttachStateChangeListener(this.f13240y);
        }
    }

    /* renamed from: g */
    private final void m7746g() {
        if (this.f13223h != null && ((this.f13236u && this.f13238w <= 0) || this.f13237v)) {
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcqn)).booleanValue() && this.zzepg.zzaan() != null) {
                zzabn.zza(this.zzepg.zzaan().zzry(), this.zzepg.zzaai(), "awfllc");
            }
            this.f13223h.zzai(true ^ this.f13237v);
            this.f13223h = null;
        }
        this.zzepg.zzadc();
    }

    /* renamed from: h */
    private static WebResourceResponse m7747h() {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcob)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    /* renamed from: i */
    private final WebResourceResponse m7748i(zzbfy zzbfy) {
        HttpURLConnection httpURLConnection;
        URL url = new URL(zzbfy.url);
        int i = 0;
        while (true) {
            i++;
            if (i <= 20) {
                URLConnection openConnection = url.openConnection();
                openConnection.setConnectTimeout(10000);
                openConnection.setReadTimeout(10000);
                for (Map.Entry next : zzbfy.zzal.entrySet()) {
                    openConnection.addRequestProperty((String) next.getKey(), (String) next.getValue());
                }
                if (openConnection instanceof HttpURLConnection) {
                    httpURLConnection = (HttpURLConnection) openConnection;
                    com.google.android.gms.ads.internal.zzp.zzkq().zza(this.zzepg.getContext(), this.zzepg.zzaao().zzbrf, false, httpURLConnection);
                    zzayu zzayu = new zzayu();
                    zzayu.zza(httpURLConnection, (byte[]) null);
                    int responseCode = httpURLConnection.getResponseCode();
                    zzayu.zza(httpURLConnection, responseCode);
                    if (responseCode < 300 || responseCode >= 400) {
                        com.google.android.gms.ads.internal.zzp.zzkq();
                    } else {
                        String headerField = httpURLConnection.getHeaderField("Location");
                        if (headerField == null) {
                            throw new IOException("Missing Location header in redirect");
                        } else if (headerField.startsWith("tel:")) {
                            return null;
                        } else {
                            URL url2 = new URL(url, headerField);
                            String protocol = url2.getProtocol();
                            if (protocol == null) {
                                zzaza.zzfa("Protocol is null");
                                return m7747h();
                            } else if (protocol.equals("http") || protocol.equals("https")) {
                                String valueOf = String.valueOf(headerField);
                                zzaza.zzeb(valueOf.length() != 0 ? "Redirecting to ".concat(valueOf) : new String("Redirecting to "));
                                httpURLConnection.disconnect();
                                url = url2;
                            } else {
                                String valueOf2 = String.valueOf(protocol);
                                zzaza.zzfa(valueOf2.length() != 0 ? "Unsupported scheme: ".concat(valueOf2) : new String("Unsupported scheme: "));
                                return m7747h();
                            }
                        }
                    }
                } else {
                    throw new IOException("Invalid protocol.");
                }
            } else {
                StringBuilder sb = new StringBuilder(32);
                sb.append("Too many redirects (20)");
                throw new IOException(sb.toString());
            }
        }
        com.google.android.gms.ads.internal.zzp.zzkq();
        return zzm.zzd(httpURLConnection);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo16209d(zzbdv zzbdv, boolean z) {
        zzaqv zzaqv = new zzaqv(zzbdv, zzbdv.zzacn(), new zzaam(zzbdv.getContext()));
        this.zzepg = zzbdv;
        this.f13228m = z;
        this.f13232q = zzaqv;
        this.f13234s = null;
        this.f13219d.zzg(zzbdv);
    }

    public final void destroy() {
        zzawq zzawq = this.f13235t;
        if (zzawq != null) {
            zzawq.zzwf();
            this.f13235t = null;
        }
        m7745f();
        this.f13219d.reset();
        this.f13219d.zzg(null);
        synchronized (this.f13220e) {
            this.f13221f = null;
            this.f13222g = null;
            this.f13223h = null;
            this.f13224i = null;
            this.f13225j = null;
            this.f13226k = null;
            this.f13231p = null;
            zzaqk zzaqk = this.f13234s;
            if (zzaqk != null) {
                zzaqk.zzac(true);
                this.f13234s = null;
            }
        }
    }

    public final void onAdClicked() {
        zzva zzva = this.f13221f;
        if (zzva != null) {
            zzva.onAdClicked();
        }
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        zzsu zzadi = this.zzepg.zzadi();
        if (zzadi != null && webView == zzadi.getWebView()) {
            zzadi.onPageStarted(webView, str, bitmap);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @TargetApi(26)
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzepg.zzc(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }

    public final void zza(int i, int i2, boolean z) {
        this.f13232q.zzj(i, i2);
        zzaqk zzaqk = this.f13234s;
        if (zzaqk != null) {
            zzaqk.zza(i, i2, false);
        }
    }

    public final zza zzabx() {
        return this.f13233r;
    }

    public final boolean zzaby() {
        return this.f13228m;
    }

    public final boolean zzabz() {
        boolean z;
        synchronized (this.f13220e) {
            z = this.f13229n;
        }
        return z;
    }

    public final boolean zzaca() {
        boolean z;
        synchronized (this.f13220e) {
            z = this.f13230o;
        }
        return z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zzacb() {
        synchronized (this.f13220e) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzacc() {
        synchronized (this.f13220e) {
        }
        return null;
    }

    public final void zzace() {
        zzawq zzawq = this.f13235t;
        if (zzawq != null) {
            WebView webView = this.zzepg.getWebView();
            if (ViewCompat.isAttachedToWindow(webView)) {
                m7742b(webView, zzawq, 10);
                return;
            }
            m7745f();
            this.f13240y = new C2353r9(this, zzawq);
            this.zzepg.getView().addOnAttachStateChangeListener(this.f13240y);
        }
    }

    public final void zzacf() {
        synchronized (this.f13220e) {
        }
        this.f13238w++;
        m7746g();
    }

    public final void zzacg() {
        this.f13238w--;
        m7746g();
    }

    public final void zzach() {
        this.f13237v = true;
        m7746g();
    }

    public final zzawq zzack() {
        return this.f13235t;
    }

    public final void zzau(boolean z) {
        this.f13227l = z;
    }

    public final void zzaw(boolean z) {
        this.f13239x = z;
    }

    public final void zzax(boolean z) {
        synchronized (this.f13220e) {
            this.f13229n = true;
        }
    }

    public final void zzay(boolean z) {
        synchronized (this.f13220e) {
            this.f13230o = z;
        }
    }

    public final void zzb(String str, zzahv<? super zzbdv> zzahv) {
        this.f13219d.zzb(str, zzahv);
    }

    public final boolean zzc(zzbfy zzbfy) {
        String valueOf = String.valueOf(zzbfy.url);
        zzd.zzee(valueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(valueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri uri = zzbfy.uri;
        if (this.f13219d.zzg(uri)) {
            return true;
        }
        if (this.f13227l) {
            String scheme = uri.getScheme();
            if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                zzva zzva = this.f13221f;
                if (zzva != null) {
                    zzva.onAdClicked();
                    zzawq zzawq = this.f13235t;
                    if (zzawq != null) {
                        zzawq.zzdw(zzbfy.url);
                    }
                    this.f13221f = null;
                }
                return false;
            }
        }
        if (!this.zzepg.getWebView().willNotDraw()) {
            try {
                zzef zzacv = this.zzepg.zzacv();
                if (zzacv != null && zzacv.zzb(uri)) {
                    uri = zzacv.zza(uri, this.zzepg.getContext(), this.zzepg.getView(), this.zzepg.zzaaj());
                }
            } catch (zzei unused) {
                String valueOf2 = String.valueOf(zzbfy.url);
                zzaza.zzfa(valueOf2.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf2) : new String("Unable to append parameter to URL: "));
            }
            zza zza = this.f13233r;
            if (zza == null || zza.zzjy()) {
                zza(new zzb("android.intent.action.VIEW", uri.toString(), (String) null, (String) null, (String) null, (String) null, (String) null));
            } else {
                this.f13233r.zzbk(zzbfy.url);
            }
        } else {
            String valueOf3 = String.valueOf(zzbfy.url);
            zzaza.zzfa(valueOf3.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf3) : new String("AdWebView unable to handle URL: "));
        }
        return true;
    }

    @Nullable
    public final WebResourceResponse zzd(zzbfy zzbfy) {
        WebResourceResponse webResourceResponse;
        zzta zza;
        String str;
        zzawq zzawq = this.f13235t;
        if (zzawq != null) {
            zzawq.zza(zzbfy.url, zzbfy.zzal, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(zzbfy.url).getName())) {
            webResourceResponse = null;
        } else {
            zzvf();
            if (this.zzepg.zzacq().zzady()) {
                str = (String) zzwq.zzqe().zzd(zzabf.zzcmz);
            } else if (this.zzepg.zzacx()) {
                str = (String) zzwq.zzqe().zzd(zzabf.zzcmy);
            } else {
                str = (String) zzwq.zzqe().zzd(zzabf.zzcmx);
            }
            com.google.android.gms.ads.internal.zzp.zzkq();
            webResourceResponse = zzm.zzd(this.zzepg.getContext(), this.zzepg.zzaao().zzbrf, str);
        }
        if (webResourceResponse != null) {
            return webResourceResponse;
        }
        try {
            if (!zzaxm.zzc(zzbfy.url, this.zzepg.getContext(), this.f13239x).equals(zzbfy.url)) {
                return m7748i(zzbfy);
            }
            zztf zzbs = zztf.zzbs(zzbfy.url);
            if (zzbs != null && (zza = com.google.android.gms.ads.internal.zzp.zzkw().zza(zzbs)) != null && zza.zzmv()) {
                return new WebResourceResponse("", "", zza.zzmw());
            }
            if (!zzayu.isEnabled() || !zzacw.zzdbz.get().booleanValue()) {
                return null;
            }
            return m7748i(zzbfy);
        } catch (Exception | NoClassDefFoundError e) {
            com.google.android.gms.ads.internal.zzp.zzku().zza(e, "AdWebViewClient.interceptRequest");
            return m7747h();
        }
    }

    public final void zzh(Uri uri) {
        this.f13219d.zzh(uri);
    }

    public final void zzi(int i, int i2) {
        zzaqk zzaqk = this.f13234s;
        if (zzaqk != null) {
            zzaqk.zzi(i, i2);
        }
    }

    public final void zzvf() {
        synchronized (this.f13220e) {
            this.f13227l = false;
            this.f13228m = true;
            zzazj.zzegt.execute(new C2279p9(this));
        }
    }

    public final void zzb(boolean z, int i) {
        zzva zzva = (!this.zzepg.zzacx() || this.zzepg.zzacq().zzady()) ? this.f13221f : null;
        zzp zzp = this.f13222g;
        zzu zzu = this.f13231p;
        zzbdv zzbdv = this.zzepg;
        m7743c(new AdOverlayInfoParcel(zzva, zzp, zzu, zzbdv, z, i, zzbdv.zzaao()));
    }

    public final void zza(String str, zzahv<? super zzbdv> zzahv) {
        this.f13219d.zza(str, zzahv);
    }

    public final void zza(String str, Predicate<zzahv<? super zzbdv>> predicate) {
        this.f13219d.zza(str, predicate);
    }

    public final void zza(zzva zzva, zzagy zzagy, zzp zzp, zzaha zzaha, zzu zzu, boolean z, @Nullable zzahu zzahu, zza zza, zzaqx zzaqx, @Nullable zzawq zzawq, @Nullable zzcqo zzcqo, @Nullable zzdrz zzdrz, @Nullable zzckq zzckq) {
        if (zza == null) {
            zza = new zza(this.zzepg.getContext(), zzawq, (zzasw) null);
        }
        this.f13234s = new zzaqk(this.zzepg, zzaqx);
        this.f13235t = zzawq;
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcom)).booleanValue()) {
            zza("/adMetadata", (zzahv<? super zzbdv>) new zzagz(zzagy));
        }
        zza("/appEvent", (zzahv<? super zzbdv>) new zzahb(zzaha));
        zza("/backButton", (zzahv<? super zzbdv>) zzahc.zzdgd);
        zza("/refresh", (zzahv<? super zzbdv>) zzahc.zzdge);
        zza("/canOpenApp", (zzahv<? super zzbdv>) zzahc.zzdfu);
        zza("/canOpenURLs", (zzahv<? super zzbdv>) zzahc.zzdft);
        zza("/canOpenIntents", (zzahv<? super zzbdv>) zzahc.zzdfv);
        zza("/close", (zzahv<? super zzbdv>) zzahc.zzdfx);
        zza("/customClose", (zzahv<? super zzbdv>) zzahc.zzdfy);
        zza("/instrument", (zzahv<? super zzbdv>) zzahc.zzdgh);
        zza("/delayPageLoaded", (zzahv<? super zzbdv>) zzahc.zzdgj);
        zza("/delayPageClosed", (zzahv<? super zzbdv>) zzahc.zzdgk);
        zza("/getLocationInfo", (zzahv<? super zzbdv>) zzahc.zzdgl);
        zza("/log", (zzahv<? super zzbdv>) zzahc.zzdga);
        zza("/mraid", (zzahv<? super zzbdv>) new zzahw(zza, this.f13234s, zzaqx));
        zza("/mraidLoaded", (zzahv<? super zzbdv>) this.f13232q);
        zza("/open", (zzahv<? super zzbdv>) new zzahz(zza, this.f13234s, zzcqo, zzckq));
        zza("/precache", (zzahv<? super zzbdv>) new zzbdc());
        zza("/touch", (zzahv<? super zzbdv>) zzahc.zzdgc);
        zza("/video", (zzahv<? super zzbdv>) zzahc.zzdgf);
        zza("/videoMeta", (zzahv<? super zzbdv>) zzahc.zzdgg);
        if (zzcqo == null || zzdrz == null) {
            zza("/click", (zzahv<? super zzbdv>) zzahc.zzdfw);
            zza("/httpTrack", (zzahv<? super zzbdv>) zzahc.zzdfz);
        } else {
            zza("/click", (zzahv<? super zzbdv>) zzdnu.zza(zzcqo, zzdrz));
            zza("/httpTrack", (zzahv<? super zzbdv>) zzdnu.zzb(zzcqo, zzdrz));
        }
        if (com.google.android.gms.ads.internal.zzp.zzlo().zzz(this.zzepg.getContext())) {
            zza("/logScionEvent", (zzahv<? super zzbdv>) new zzahx(this.zzepg.getContext()));
        }
        this.f13221f = zzva;
        this.f13222g = zzp;
        this.f13225j = zzagy;
        this.f13226k = zzaha;
        this.f13231p = zzu;
        this.f13233r = zza;
        this.f13227l = z;
    }

    public final void zzb(zzbfy zzbfy) {
        this.f13219d.zzg(zzbfy.uri);
    }

    public final void zza(zzbfy zzbfy) {
        this.f13236u = true;
        zzbfi zzbfi = this.f13224i;
        if (zzbfi != null) {
            zzbfi.zztu();
            this.f13224i = null;
        }
        m7746g();
    }

    public final void zza(zzb zzb) {
        zzp zzp;
        boolean zzacx = this.zzepg.zzacx();
        zzva zzva = (!zzacx || this.zzepg.zzacq().zzady()) ? this.f13221f : null;
        if (zzacx) {
            zzp = null;
        } else {
            zzp = this.f13222g;
        }
        m7743c(new AdOverlayInfoParcel(zzb, zzva, zzp, this.f13231p, this.zzepg.zzaao()));
    }

    public final void zza(boolean z, int i, String str) {
        C2316q9 q9Var;
        boolean zzacx = this.zzepg.zzacx();
        zzva zzva = (!zzacx || this.zzepg.zzacq().zzady()) ? this.f13221f : null;
        if (zzacx) {
            q9Var = null;
        } else {
            q9Var = new C2316q9(this.zzepg, this.f13222g);
        }
        zzagy zzagy = this.f13225j;
        zzaha zzaha = this.f13226k;
        zzu zzu = this.f13231p;
        zzbdv zzbdv = this.zzepg;
        m7743c(new AdOverlayInfoParcel(zzva, (zzp) q9Var, zzagy, zzaha, zzu, zzbdv, z, i, str, zzbdv.zzaao()));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        C2316q9 q9Var;
        boolean zzacx = this.zzepg.zzacx();
        zzva zzva = (!zzacx || this.zzepg.zzacq().zzady()) ? this.f13221f : null;
        if (zzacx) {
            q9Var = null;
        } else {
            q9Var = new C2316q9(this.zzepg, this.f13222g);
        }
        zzagy zzagy = this.f13225j;
        zzaha zzaha = this.f13226k;
        zzu zzu = this.f13231p;
        zzbdv zzbdv = this.zzepg;
        m7743c(new AdOverlayInfoParcel(zzva, q9Var, zzagy, zzaha, zzu, zzbdv, z, i, str, str2, zzbdv.zzaao()));
    }

    public final void zza(zzbfj zzbfj) {
        this.f13223h = zzbfj;
    }

    public final void zza(zzbfi zzbfi) {
        this.f13224i = zzbfi;
    }
}
