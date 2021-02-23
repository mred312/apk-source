package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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
import com.google.android.gms.internal.ads.zztu;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzbdu extends WebViewClient implements zzbfg {
    @Nullable

    /* renamed from: a */
    private final zzts f13173a;

    /* renamed from: b */
    private final HashMap<String, List<zzahv<? super zzbdv>>> f13174b;

    /* renamed from: c */
    private final Object f13175c;

    /* renamed from: d */
    private zzva f13176d;

    /* renamed from: e */
    private zzp f13177e;

    /* renamed from: f */
    private zzbfj f13178f;

    /* renamed from: g */
    private zzbfi f13179g;

    /* renamed from: h */
    private zzagy f13180h;

    /* renamed from: i */
    private zzaha f13181i;

    /* renamed from: j */
    private boolean f13182j;
    @GuardedBy("lock")

    /* renamed from: k */
    private boolean f13183k;
    @GuardedBy("lock")

    /* renamed from: l */
    private boolean f13184l;
    @GuardedBy("lock")

    /* renamed from: m */
    private boolean f13185m;

    /* renamed from: n */
    private zzu f13186n;

    /* renamed from: o */
    private final zzaqv f13187o;

    /* renamed from: p */
    private zza f13188p;

    /* renamed from: q */
    private zzaqk f13189q;

    /* renamed from: r */
    private boolean f13190r;

    /* renamed from: s */
    private boolean f13191s;

    /* renamed from: t */
    private int f13192t;

    /* renamed from: u */
    private boolean f13193u;

    /* renamed from: v */
    private View.OnAttachStateChangeListener f13194v;
    protected zzbdv zzepg;
    @Nullable
    protected zzawq zzepr;

    public zzbdu(zzbdv zzbdv, zzts zzts, boolean z) {
        this(zzbdv, zzts, z, new zzaqv(zzbdv, zzbdv.zzacn(), new zzaam(zzbdv.getContext())), (zzaqk) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m7726a(View view, zzawq zzawq, int i) {
        if (zzawq.zzwd() && i > 0) {
            zzawq.zzl(view);
            if (zzawq.zzwd()) {
                zzm.zzedd.postDelayed(new C2617y8(this, view, zzawq, i), 100);
            }
        }
    }

    /* renamed from: b */
    private final void m7727b(AdOverlayInfoParcel adOverlayInfoParcel) {
        zzb zzb;
        zzaqk zzaqk = this.f13189q;
        boolean zzuy = zzaqk != null ? zzaqk.zzuy() : false;
        com.google.android.gms.ads.internal.zzp.zzkp();
        zzo.zza(this.zzepg.getContext(), adOverlayInfoParcel, !zzuy);
        zzawq zzawq = this.zzepr;
        if (zzawq != null) {
            String str = adOverlayInfoParcel.url;
            if (str == null && (zzb = adOverlayInfoParcel.zzdrl) != null) {
                str = zzb.url;
            }
            zzawq.zzdw(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public final void m7730e(Map<String, String> map, List<zzahv<? super zzbdv>> list, String str) {
        if (zzaza.isLoggable(2)) {
            String valueOf = String.valueOf(str);
            zzd.zzee(valueOf.length() != 0 ? "Received GMSG: ".concat(valueOf) : new String("Received GMSG: "));
            for (String next : map.keySet()) {
                String str2 = map.get(next);
                StringBuilder sb = new StringBuilder(String.valueOf(next).length() + 4 + String.valueOf(str2).length());
                sb.append("  ");
                sb.append(next);
                sb.append(": ");
                sb.append(str2);
                zzd.zzee(sb.toString());
            }
        }
        for (zzahv<? super zzbdv> zza : list) {
            zza.zza(this.zzepg, map);
        }
    }

    /* renamed from: f */
    private final void m7731f() {
        if (this.f13194v != null) {
            this.zzepg.getView().removeOnAttachStateChangeListener(this.f13194v);
        }
    }

    /* renamed from: g */
    private final void m7732g() {
        if (this.f13178f != null && ((this.f13190r && this.f13192t <= 0) || this.f13191s)) {
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcqn)).booleanValue() && this.zzepg.zzaan() != null) {
                zzabn.zza(this.zzepg.zzaan().zzry(), this.zzepg.zzaai(), "awfllc");
            }
            this.f13178f.zzai(true ^ this.f13191s);
            this.f13178f = null;
        }
        this.zzepg.zzadc();
    }

    /* renamed from: h */
    private static WebResourceResponse m7733h() {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcob)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    /* renamed from: i */
    private final WebResourceResponse m7734i(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection;
        URL url = new URL(str);
        int i = 0;
        while (true) {
            i++;
            if (i <= 20) {
                URLConnection openConnection = url.openConnection();
                openConnection.setConnectTimeout(10000);
                openConnection.setReadTimeout(10000);
                for (Map.Entry next : map.entrySet()) {
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
                                return m7733h();
                            } else if (protocol.equals("http") || protocol.equals("https")) {
                                String valueOf = String.valueOf(headerField);
                                zzaza.zzeb(valueOf.length() != 0 ? "Redirecting to ".concat(valueOf) : new String("Redirecting to "));
                                httpURLConnection.disconnect();
                                url = url2;
                            } else {
                                String valueOf2 = String.valueOf(protocol);
                                zzaza.zzfa(valueOf2.length() != 0 ? "Unsupported scheme: ".concat(valueOf2) : new String("Unsupported scheme: "));
                                return m7733h();
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

    public void onAdClicked() {
        zzva zzva = this.f13176d;
        if (zzva != null) {
            zzva.onAdClicked();
        }
    }

    public final void onLoadResource(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzd.zzee(valueOf.length() != 0 ? "Loading resource: ".concat(valueOf) : new String("Loading resource: "));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzh(parse);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r1 == null) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        r1.zztu();
        r0.f13179g = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        m7732g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        r0.f13190r = true;
        r1 = r0.f13179g;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPageFinished(android.webkit.WebView r1, java.lang.String r2) {
        /*
            r0 = this;
            java.lang.Object r1 = r0.f13175c
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzbdv r2 = r0.zzepg     // Catch:{ all -> 0x0029 }
            boolean r2 = r2.isDestroyed()     // Catch:{ all -> 0x0029 }
            if (r2 == 0) goto L_0x0017
            java.lang.String r2 = "Blank page loaded, 1..."
            com.google.android.gms.ads.internal.util.zzd.zzee(r2)     // Catch:{ all -> 0x0029 }
            com.google.android.gms.internal.ads.zzbdv r2 = r0.zzepg     // Catch:{ all -> 0x0029 }
            r2.zzacy()     // Catch:{ all -> 0x0029 }
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            return
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            r1 = 1
            r0.f13190r = r1
            com.google.android.gms.internal.ads.zzbfi r1 = r0.f13179g
            if (r1 == 0) goto L_0x0025
            r1.zztu()
            r1 = 0
            r0.f13179g = r1
        L_0x0025:
            r0.m7732g()
            return
        L_0x0029:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdu.onPageFinished(android.webkit.WebView, java.lang.String):void");
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        zzsu zzadi = this.zzepg.zzadi();
        if (zzadi != null && webView == zzadi.getWebView()) {
            zzadi.onPageStarted(webView, str, bitmap);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @TargetApi(26)
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzepg.zzc(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }

    public final void reset() {
        zzawq zzawq = this.zzepr;
        if (zzawq != null) {
            zzawq.zzwf();
            this.zzepr = null;
        }
        m7731f();
        synchronized (this.f13175c) {
            this.f13174b.clear();
            this.f13176d = null;
            this.f13177e = null;
            this.f13178f = null;
            this.f13179g = null;
            this.f13180h = null;
            this.f13181i = null;
            this.f13182j = false;
            this.f13183k = false;
            this.f13184l = false;
            this.f13186n = null;
            zzaqk zzaqk = this.f13189q;
            if (zzaqk != null) {
                zzaqk.zzac(true);
                this.f13189q = null;
            }
        }
    }

    @TargetApi(11)
    @Nullable
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzd(str, Collections.emptyMap());
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                        return true;
                    default:
                        return false;
                }
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzd.zzee(valueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(valueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri parse = Uri.parse(str);
        if (!"gmsg".equalsIgnoreCase(parse.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            if (this.f13182j && webView == this.zzepg.getWebView()) {
                String scheme = parse.getScheme();
                if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                    zzva zzva = this.f13176d;
                    if (zzva != null) {
                        zzva.onAdClicked();
                        zzawq zzawq = this.zzepr;
                        if (zzawq != null) {
                            zzawq.zzdw(str);
                        }
                        this.f13176d = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (!this.zzepg.getWebView().willNotDraw()) {
                try {
                    zzef zzacv = this.zzepg.zzacv();
                    if (zzacv != null && zzacv.zzb(parse)) {
                        parse = zzacv.zza(parse, this.zzepg.getContext(), this.zzepg.getView(), this.zzepg.zzaaj());
                    }
                } catch (zzei unused) {
                    String valueOf2 = String.valueOf(str);
                    zzaza.zzfa(valueOf2.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf2) : new String("Unable to append parameter to URL: "));
                }
                zza zza = this.f13188p;
                if (zza == null || zza.zzjy()) {
                    zza(new zzb("android.intent.action.VIEW", parse.toString(), (String) null, (String) null, (String) null, (String) null, (String) null));
                } else {
                    this.f13188p.zzbk(str);
                }
            } else {
                String valueOf3 = String.valueOf(str);
                zzaza.zzfa(valueOf3.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf3) : new String("AdWebView unable to handle URL: "));
            }
        } else {
            zzh(parse);
        }
        return true;
    }

    public final void zza(int i, int i2, boolean z) {
        this.f13187o.zzj(i, i2);
        zzaqk zzaqk = this.f13189q;
        if (zzaqk != null) {
            zzaqk.zza(i, i2, false);
        }
    }

    public final zza zzabx() {
        return this.f13188p;
    }

    public final boolean zzaby() {
        boolean z;
        synchronized (this.f13175c) {
            z = this.f13183k;
        }
        return z;
    }

    public final boolean zzabz() {
        boolean z;
        synchronized (this.f13175c) {
            z = this.f13184l;
        }
        return z;
    }

    public final boolean zzaca() {
        boolean z;
        synchronized (this.f13175c) {
            z = this.f13185m;
        }
        return z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zzacb() {
        synchronized (this.f13175c) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzacc() {
        synchronized (this.f13175c) {
        }
        return null;
    }

    public final void zzace() {
        zzawq zzawq = this.zzepr;
        if (zzawq != null) {
            WebView webView = this.zzepg.getWebView();
            if (ViewCompat.isAttachedToWindow(webView)) {
                m7726a(webView, zzawq, 10);
                return;
            }
            m7731f();
            this.f13194v = new C2579x8(this, zzawq);
            this.zzepg.getView().addOnAttachStateChangeListener(this.f13194v);
        }
    }

    public final void zzacf() {
        synchronized (this.f13175c) {
        }
        this.f13192t++;
        m7732g();
    }

    public final void zzacg() {
        this.f13192t--;
        m7732g();
    }

    public final void zzach() {
        zzts zzts = this.f13173a;
        if (zzts != null) {
            zzts.zza(zztu.zza.C3991zza.DELAY_PAGE_LOAD_CANCELLED_AD);
        }
        this.f13191s = true;
        m7732g();
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcvr)).booleanValue()) {
            this.zzepg.destroy();
        }
    }

    public final zzawq zzack() {
        return this.zzepr;
    }

    public final void zzau(boolean z) {
        this.f13182j = z;
    }

    public final void zzaw(boolean z) {
        this.f13193u = z;
    }

    public final void zzax(boolean z) {
        synchronized (this.f13175c) {
            this.f13184l = true;
        }
    }

    public final void zzay(boolean z) {
        synchronized (this.f13175c) {
            this.f13185m = z;
        }
    }

    public final void zzb(boolean z, int i) {
        zzva zzva = (!this.zzepg.zzacx() || this.zzepg.zzacq().zzady()) ? this.f13176d : null;
        zzp zzp = this.f13177e;
        zzu zzu = this.f13186n;
        zzbdv zzbdv = this.zzepg;
        m7727b(new AdOverlayInfoParcel(zzva, zzp, zzu, zzbdv, z, i, zzbdv.zzaao()));
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final WebResourceResponse zzd(String str, Map<String, String> map) {
        zzta zza;
        try {
            String zzc = zzaxm.zzc(str, this.zzepg.getContext(), this.f13193u);
            if (!zzc.equals(str)) {
                return m7734i(zzc, map);
            }
            zztf zzbs = zztf.zzbs(str);
            if (zzbs != null && (zza = com.google.android.gms.ads.internal.zzp.zzkw().zza(zzbs)) != null && zza.zzmv()) {
                return new WebResourceResponse("", "", zza.zzmw());
            }
            if (!zzayu.isEnabled() || !zzacw.zzdbz.get().booleanValue()) {
                return null;
            }
            return m7734i(str, map);
        } catch (Exception | NoClassDefFoundError e) {
            com.google.android.gms.ads.internal.zzp.zzku().zza(e, "AdWebViewClient.interceptRequest");
            return m7733h();
        }
    }

    public final void zzh(Uri uri) {
        String path = uri.getPath();
        List list = this.f13174b.get(path);
        if (list != null) {
            if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcvn)).booleanValue()) {
                com.google.android.gms.ads.internal.zzp.zzkq();
                m7730e(zzm.zzj(uri), list, path);
                return;
            }
            zzdyr.zza(com.google.android.gms.ads.internal.zzp.zzkq().zzi(uri), new C1723a9(this, list, path), zzazj.zzegu);
            return;
        }
        String valueOf = String.valueOf(uri);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 32);
        sb.append("No GMSG handler found for GMSG: ");
        sb.append(valueOf);
        zzd.zzee(sb.toString());
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcxu)).booleanValue() && com.google.android.gms.ads.internal.zzp.zzku().zzwt() != null) {
            zzazj.zzegp.execute(new C2504v8(path));
        }
    }

    public final void zzi(int i, int i2) {
        zzaqk zzaqk = this.f13189q;
        if (zzaqk != null) {
            zzaqk.zzi(i, i2);
        }
    }

    public final void zzvf() {
        synchronized (this.f13175c) {
            this.f13182j = false;
            this.f13183k = true;
            zzazj.zzegt.execute(new C2541w8(this));
        }
    }

    public final void zza(zzva zzva, zzagy zzagy, zzp zzp, zzaha zzaha, zzu zzu, boolean z, @Nullable zzahu zzahu, zza zza, zzaqx zzaqx, @Nullable zzawq zzawq, @Nullable zzcqo zzcqo, @Nullable zzdrz zzdrz, @Nullable zzckq zzckq) {
        if (zza == null) {
            zza = new zza(this.zzepg.getContext(), zzawq, (zzasw) null);
        }
        this.f13189q = new zzaqk(this.zzepg, zzaqx);
        this.zzepr = zzawq;
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
        zza("/mraid", (zzahv<? super zzbdv>) new zzahw(zza, this.f13189q, zzaqx));
        zza("/mraidLoaded", (zzahv<? super zzbdv>) this.f13187o);
        zza("/open", (zzahv<? super zzbdv>) new zzahz(zza, this.f13189q, zzcqo, zzckq));
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
        this.f13176d = zzva;
        this.f13177e = zzp;
        this.f13180h = zzagy;
        this.f13181i = zzaha;
        this.f13186n = zzu;
        this.f13188p = zza;
        this.f13182j = z;
    }

    @VisibleForTesting
    private zzbdu(zzbdv zzbdv, zzts zzts, boolean z, zzaqv zzaqv, zzaqk zzaqk) {
        this.f13174b = new HashMap<>();
        this.f13175c = new Object();
        this.f13182j = false;
        this.f13173a = zzts;
        this.zzepg = zzbdv;
        this.f13183k = z;
        this.f13187o = zzaqv;
        this.f13189q = null;
    }

    public final void zzb(String str, zzahv<? super zzbdv> zzahv) {
        synchronized (this.f13175c) {
            List list = this.f13174b.get(str);
            if (list != null) {
                list.remove(zzahv);
            }
        }
    }

    public final void zza(zzb zzb) {
        zzp zzp;
        boolean zzacx = this.zzepg.zzacx();
        zzva zzva = (!zzacx || this.zzepg.zzacq().zzady()) ? this.f13176d : null;
        if (zzacx) {
            zzp = null;
        } else {
            zzp = this.f13177e;
        }
        m7727b(new AdOverlayInfoParcel(zzb, zzva, zzp, this.f13186n, this.zzepg.zzaao()));
    }

    public final void zza(boolean z, int i, String str) {
        C2654z8 z8Var;
        boolean zzacx = this.zzepg.zzacx();
        zzva zzva = (!zzacx || this.zzepg.zzacq().zzady()) ? this.f13176d : null;
        if (zzacx) {
            z8Var = null;
        } else {
            z8Var = new C2654z8(this.zzepg, this.f13177e);
        }
        zzagy zzagy = this.f13180h;
        zzaha zzaha = this.f13181i;
        zzu zzu = this.f13186n;
        zzbdv zzbdv = this.zzepg;
        m7727b(new AdOverlayInfoParcel(zzva, (zzp) z8Var, zzagy, zzaha, zzu, zzbdv, z, i, str, zzbdv.zzaao()));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        C2654z8 z8Var;
        boolean zzacx = this.zzepg.zzacx();
        zzva zzva = (!zzacx || this.zzepg.zzacq().zzady()) ? this.f13176d : null;
        if (zzacx) {
            z8Var = null;
        } else {
            z8Var = new C2654z8(this.zzepg, this.f13177e);
        }
        zzagy zzagy = this.f13180h;
        zzaha zzaha = this.f13181i;
        zzu zzu = this.f13186n;
        zzbdv zzbdv = this.zzepg;
        m7727b(new AdOverlayInfoParcel(zzva, z8Var, zzagy, zzaha, zzu, zzbdv, z, i, str, str2, zzbdv.zzaao()));
    }

    public final void zza(String str, zzahv<? super zzbdv> zzahv) {
        synchronized (this.f13175c) {
            List list = this.f13174b.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.f13174b.put(str, list);
            }
            list.add(zzahv);
        }
    }

    public final void zza(String str, Predicate<zzahv<? super zzbdv>> predicate) {
        synchronized (this.f13175c) {
            List<zzahv> list = this.f13174b.get(str);
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (zzahv zzahv : list) {
                    if (predicate.apply(zzahv)) {
                        arrayList.add(zzahv);
                    }
                }
                list.removeAll(arrayList);
            }
        }
    }

    public final void zza(zzbfj zzbfj) {
        this.f13178f = zzbfj;
    }

    public final void zza(zzbfi zzbfi) {
        this.f13179g = zzbfi;
    }
}
