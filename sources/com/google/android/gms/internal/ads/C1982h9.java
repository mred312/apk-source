package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.util.zzad;
import com.google.android.gms.ads.internal.util.zzbz;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zztu;
import com.google.android.gms.internal.ads.zzue;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.unity3d.ads.metadata.MediationMetaData;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
@VisibleForTesting
/* renamed from: com.google.android.gms.internal.ads.h9 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C1982h9 extends WebView implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzbdv {
    @GuardedBy("this")

    /* renamed from: A */
    private String f8851A = "";
    @GuardedBy("this")

    /* renamed from: B */
    private zzbep f8852B;
    @GuardedBy("this")

    /* renamed from: C */
    private boolean f8853C;
    @GuardedBy("this")

    /* renamed from: D */
    private boolean f8854D;
    @GuardedBy("this")

    /* renamed from: E */
    private zzadx f8855E;
    @GuardedBy("this")

    /* renamed from: F */
    private zzads f8856F;
    @GuardedBy("this")

    /* renamed from: G */
    private zzsc f8857G;
    @GuardedBy("this")

    /* renamed from: H */
    private int f8858H;
    /* access modifiers changed from: private */
    @GuardedBy("this")

    /* renamed from: I */
    public int f8859I;

    /* renamed from: J */
    private zzabq f8860J;

    /* renamed from: K */
    private zzabq f8861K;

    /* renamed from: L */
    private zzabq f8862L;

    /* renamed from: M */
    private zzabt f8863M;

    /* renamed from: N */
    private int f8864N;
    @GuardedBy("this")

    /* renamed from: O */
    private zze f8865O;
    @GuardedBy("this")

    /* renamed from: P */
    private boolean f8866P;

    /* renamed from: Q */
    private zzbz f8867Q;

    /* renamed from: R */
    private int f8868R = -1;

    /* renamed from: S */
    private int f8869S = -1;

    /* renamed from: T */
    private int f8870T = -1;

    /* renamed from: U */
    private int f8871U = -1;

    /* renamed from: V */
    private Map<String, zzbcx> f8872V;

    /* renamed from: W */
    private final WindowManager f8873W;

    /* renamed from: a */
    private final zzbfk f8874a;

    /* renamed from: a0 */
    private final zzts f8875a0;
    @Nullable

    /* renamed from: b */
    private final zzef f8876b;
    @Nullable

    /* renamed from: c */
    private final zzacg f8877c;

    /* renamed from: d */
    private final zzazh f8878d;

    /* renamed from: e */
    private final zzk f8879e;

    /* renamed from: f */
    private final zzb f8880f;

    /* renamed from: g */
    private final DisplayMetrics f8881g;

    /* renamed from: h */
    private final float f8882h;
    @Nullable

    /* renamed from: i */
    private final zzsu f8883i;

    /* renamed from: j */
    private final boolean f8884j;
    @Nullable

    /* renamed from: k */
    private zzdmu f8885k;
    @Nullable

    /* renamed from: l */
    private zzdmz f8886l;

    /* renamed from: m */
    private boolean f8887m = false;

    /* renamed from: n */
    private boolean f8888n = false;

    /* renamed from: o */
    private zzbdu f8889o;
    @GuardedBy("this")

    /* renamed from: p */
    private zze f8890p;
    @GuardedBy("this")

    /* renamed from: q */
    private IObjectWrapper f8891q;
    @GuardedBy("this")

    /* renamed from: r */
    private zzbfn f8892r;
    @GuardedBy("this")

    /* renamed from: s */
    private String f8893s;
    @GuardedBy("this")

    /* renamed from: t */
    private boolean f8894t;
    @GuardedBy("this")

    /* renamed from: u */
    private boolean f8895u;
    @GuardedBy("this")

    /* renamed from: v */
    private boolean f8896v;
    @GuardedBy("this")

    /* renamed from: w */
    private boolean f8897w;
    @GuardedBy("this")

    /* renamed from: x */
    private Boolean f8898x;
    @GuardedBy("this")

    /* renamed from: y */
    private int f8899y;
    @GuardedBy("this")

    /* renamed from: z */
    private boolean f8900z = true;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @VisibleForTesting
    private C1982h9(zzbfk zzbfk, zzbfn zzbfn, String str, boolean z, boolean z2, @Nullable zzef zzef, @Nullable zzacg zzacg, zzazh zzazh, zzabs zzabs, zzk zzk, zzb zzb, zzts zzts, zzsu zzsu, boolean z3, zzdmu zzdmu, zzdmz zzdmz) {
        super(zzbfk);
        zzdmz zzdmz2;
        zzazh zzazh2 = zzazh;
        this.f8874a = zzbfk;
        this.f8892r = zzbfn;
        this.f8893s = str;
        this.f8896v = z;
        this.f8899y = -1;
        this.f8876b = zzef;
        this.f8877c = zzacg;
        this.f8878d = zzazh2;
        this.f8879e = zzk;
        this.f8880f = zzb;
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        this.f8873W = windowManager;
        zzp.zzkq();
        DisplayMetrics zza = zzm.zza(windowManager);
        this.f8881g = zza;
        this.f8882h = zza.density;
        this.f8875a0 = zzts;
        this.f8883i = zzsu;
        this.f8884j = z3;
        this.f8885k = zzdmu;
        this.f8886l = zzdmz;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e) {
            zzaza.zzc("Unable to enable Javascript.", e);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        zzp.zzkq().zza((Context) zzbfk, zzazh2.zzbrf, settings);
        zzp.zzks().zza(getContext(), settings);
        setDownloadListener(this);
        m6136i();
        if (PlatformVersion.isAtLeastJellyBeanMR1()) {
            addJavascriptInterface(zzbet.zzc(this), "googleAdsJsInterface");
        }
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        this.f8867Q = new zzbz(this.f8874a.zzaaj(), this, this, (ViewTreeObserver.OnScrollChangedListener) null);
        m6140m();
        zzabt zzabt = new zzabt(new zzabs(true, "make_wv", this.f8893s));
        this.f8863M = zzabt;
        zzabt.zzry().zzc(zzabs);
        if (!(!((Boolean) zzwq.zzqe().zzd(zzabf.zzcqn)).booleanValue() || (zzdmz2 = this.f8886l) == null || zzdmz2.zzbvf == null)) {
            this.f8863M.zzry().zzh("gqi", this.f8886l.zzbvf);
        }
        zzabq zzb2 = zzabn.zzb(this.f8863M.zzry());
        this.f8861K = zzb2;
        this.f8863M.zza("native:view_create", zzb2);
        this.f8862L = null;
        this.f8860J = null;
        zzp.zzks().zzbg(zzbfk);
        zzp.zzku().zzww();
    }

    @VisibleForTesting
    /* renamed from: c */
    private final void m6130c(Boolean bool) {
        synchronized (this) {
            this.f8898x = bool;
        }
        zzp.zzku().zza(bool);
    }

    @TargetApi(19)
    /* renamed from: d */
    private final synchronized void m6131d(String str, ValueCallback<String> valueCallback) {
        if (!isDestroyed()) {
            evaluateJavascript(str, (ValueCallback<String>) null);
        } else {
            zzaza.zzfa("#004 The webview is destroyed. Ignoring action.");
        }
    }

    /* renamed from: e */
    static final /* synthetic */ void m6132e(boolean z, int i, zzue.zzi.zza zza) {
        zzue.zzae.zza zzpj = zzue.zzae.zzpj();
        if (zzpj.zzpi() != z) {
            zzpj.zzw(z);
        }
        zza.zzb((zzue.zzae) ((zzekh) zzpj.zzcu(i).zzbhv()));
    }

    /* renamed from: f */
    private final boolean m6133f() {
        int i;
        int i2;
        boolean z = false;
        if (!this.f8889o.zzaby() && !this.f8889o.zzabz()) {
            return false;
        }
        zzwq.zzqa();
        DisplayMetrics displayMetrics = this.f8881g;
        int zzb = zzayr.zzb(displayMetrics, displayMetrics.widthPixels);
        zzwq.zzqa();
        DisplayMetrics displayMetrics2 = this.f8881g;
        int zzb2 = zzayr.zzb(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzaaj = this.f8874a.zzaaj();
        if (zzaaj == null || zzaaj.getWindow() == null) {
            i2 = zzb;
            i = zzb2;
        } else {
            zzp.zzkq();
            int[] zzf = zzm.zzf(zzaaj);
            zzwq.zzqa();
            int zzb3 = zzayr.zzb(this.f8881g, zzf[0]);
            zzwq.zzqa();
            i = zzayr.zzb(this.f8881g, zzf[1]);
            i2 = zzb3;
        }
        int i3 = this.f8869S;
        if (i3 == zzb && this.f8868R == zzb2 && this.f8870T == i2 && this.f8871U == i) {
            return false;
        }
        if (!(i3 == zzb && this.f8868R == zzb2)) {
            z = true;
        }
        this.f8869S = zzb;
        this.f8868R = zzb2;
        this.f8870T = i2;
        this.f8871U = i;
        new zzaqu(this).zza(zzb, zzb2, i2, i, this.f8881g.density, this.f8873W.getDefaultDisplay().getRotation());
        return z;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:9|10|11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        m6130c(java.lang.Boolean.FALSE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001a */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void m6134g() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzayg r0 = com.google.android.gms.ads.internal.zzp.zzku()     // Catch:{ all -> 0x0021 }
            java.lang.Boolean r0 = r0.zzwu()     // Catch:{ all -> 0x0021 }
            r2.f8898x = r0     // Catch:{ all -> 0x0021 }
            if (r0 != 0) goto L_0x001f
            java.lang.String r0 = "(function(){})()"
            r1 = 0
            r2.evaluateJavascript(r0, r1)     // Catch:{ IllegalStateException -> 0x001a }
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ IllegalStateException -> 0x001a }
            r2.m6130c(r0)     // Catch:{ IllegalStateException -> 0x001a }
            monitor-exit(r2)
            return
        L_0x001a:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0021 }
            r2.m6130c(r0)     // Catch:{ all -> 0x0021 }
        L_0x001f:
            monitor-exit(r2)
            return
        L_0x0021:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C1982h9.m6134g():void");
    }

    /* renamed from: h */
    private final void m6135h() {
        zzabn.zza(this.f8863M.zzry(), this.f8861K, "aeh2");
    }

    /* renamed from: i */
    private final synchronized void m6136i() {
        if (!this.f8896v) {
            if (!this.f8892r.zzady()) {
                if (Build.VERSION.SDK_INT < 18) {
                    zzaza.zzeb("Disabling hardware acceleration on an AdView.");
                    m6137j();
                    return;
                }
                zzaza.zzeb("Enabling hardware acceleration on an AdView.");
                m6138k();
                return;
            }
        }
        zzaza.zzeb("Enabling hardware acceleration on an overlay.");
        m6138k();
    }

    /* renamed from: j */
    private final synchronized void m6137j() {
        if (!this.f8897w) {
            zzp.zzks();
            setLayerType(1, (Paint) null);
        }
        this.f8897w = true;
    }

    /* renamed from: k */
    private final synchronized void m6138k() {
        if (this.f8897w) {
            zzp.zzks();
            setLayerType(0, (Paint) null);
        }
        this.f8897w = false;
    }

    /* renamed from: l */
    private final synchronized void m6139l() {
        Map<String, zzbcx> map = this.f8872V;
        if (map != null) {
            for (zzbcx release : map.values()) {
                release.release();
            }
        }
        this.f8872V = null;
    }

    /* renamed from: m */
    private final void m6140m() {
        zzabs zzry;
        zzabt zzabt = this.f8863M;
        if (zzabt != null && (zzry = zzabt.zzry()) != null && zzp.zzku().zzwt() != null) {
            zzp.zzku().zzwt().zza(zzry);
        }
    }

    /* renamed from: n */
    static C1982h9 m6141n(Context context, zzbfn zzbfn, String str, boolean z, boolean z2, @Nullable zzef zzef, @Nullable zzacg zzacg, zzazh zzazh, zzabs zzabs, zzk zzk, zzb zzb, zzts zzts, zzsu zzsu, boolean z3, zzdmu zzdmu, zzdmz zzdmz) {
        zzbfk zzbfk = r0;
        zzbfk zzbfk2 = new zzbfk(context);
        return new C1982h9(zzbfk, zzbfn, str, z, z2, zzef, zzacg, zzazh, zzabs, zzk, zzb, zzts, zzsu, z3, zzdmu, zzdmz);
    }

    /* renamed from: p */
    private final void m6143p(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        zza("onAdVisibilityChanged", (Map<String, ?>) hashMap);
    }

    /* renamed from: q */
    private final synchronized void m6144q(String str) {
        if (!isDestroyed()) {
            loadUrl(str);
        } else {
            zzaza.zzfa("#004 The webview is destroyed. Ignoring action.");
        }
    }

    /* renamed from: r */
    private final synchronized void m6145r(String str) {
        try {
            super.loadUrl(str);
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError | UnsatisfiedLinkError e) {
            zzp.zzku().zza(e, "AdWebViewImpl.loadUrlUnsafe");
            zzaza.zzd("Could not call loadUrl. ", e);
        }
    }

    /* renamed from: s */
    private final void m6146s(String str) {
        if (PlatformVersion.isAtLeastKitKat()) {
            if (m6147t() == null) {
                m6134g();
            }
            if (m6147t().booleanValue()) {
                m6131d(str, (ValueCallback<String>) null);
                return;
            }
            String valueOf = String.valueOf(str);
            m6144q(valueOf.length() != 0 ? "javascript:".concat(valueOf) : new String("javascript:"));
            return;
        }
        String valueOf2 = String.valueOf(str);
        m6144q(valueOf2.length() != 0 ? "javascript:".concat(valueOf2) : new String("javascript:"));
    }

    @VisibleForTesting
    /* renamed from: t */
    private final synchronized Boolean m6147t() {
        return this.f8898x;
    }

    /* renamed from: u */
    private final synchronized void m6148u() {
        if (!this.f8866P) {
            this.f8866P = true;
            zzp.zzku().zzwx();
        }
    }

    public final synchronized void destroy() {
        m6140m();
        this.f8867Q.zzza();
        zze zze = this.f8890p;
        if (zze != null) {
            zze.close();
            this.f8890p.onDestroy();
            this.f8890p = null;
        }
        this.f8891q = null;
        this.f8889o.reset();
        if (!this.f8895u) {
            zzp.zzlm();
            zzbcu.zzc(this);
            m6139l();
            this.f8895u = true;
            zzd.zzee("Initiating WebView self destruct sequence in 3...");
            zzd.zzee("Loading blank page in WebView, 2...");
            m6145r("about:blank");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        return;
     */
    @android.annotation.TargetApi(19)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void evaluateJavascript(java.lang.String r2, android.webkit.ValueCallback<java.lang.String> r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.isDestroyed()     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0014
            java.lang.String r2 = "#004 The webview is destroyed. Ignoring action."
            com.google.android.gms.internal.ads.zzaza.zzfc(r2)     // Catch:{ all -> 0x0019 }
            if (r3 == 0) goto L_0x0012
            r2 = 0
            r3.onReceiveValue(r2)     // Catch:{ all -> 0x0019 }
        L_0x0012:
            monitor-exit(r1)
            return
        L_0x0014:
            super.evaluateJavascript(r2, r3)     // Catch:{ all -> 0x0019 }
            monitor-exit(r1)
            return
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C1982h9.evaluateJavascript(java.lang.String, android.webkit.ValueCallback):void");
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        try {
            synchronized (this) {
                if (!this.f8895u) {
                    this.f8889o.reset();
                    zzp.zzlm();
                    zzbcu.zzc(this);
                    m6139l();
                    m6148u();
                }
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    public final synchronized String getRequestId() {
        return this.f8851A;
    }

    public final View getView() {
        return this;
    }

    public final WebView getWebView() {
        return this;
    }

    public final synchronized boolean isDestroyed() {
        return this.f8895u;
    }

    public final synchronized void loadData(String str, String str2, String str3) {
        if (!isDestroyed()) {
            super.loadData(str, str2, str3);
        } else {
            zzaza.zzfa("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!isDestroyed()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            zzaza.zzfa("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final synchronized void loadUrl(String str) {
        if (!isDestroyed()) {
            try {
                super.loadUrl(str);
            } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e) {
                zzp.zzku().zza(e, "AdWebViewImpl.loadUrl");
                zzaza.zzd("Could not call loadUrl. ", e);
            }
        } else {
            zzaza.zzfa("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final void onAdClicked() {
        zzbdu zzbdu = this.f8889o;
        if (zzbdu != null) {
            zzbdu.onAdClicked();
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isDestroyed()) {
            this.f8867Q.onAttachedToWindow();
        }
        boolean z = this.f8853C;
        zzbdu zzbdu = this.f8889o;
        if (zzbdu != null && zzbdu.zzabz()) {
            if (!this.f8854D) {
                this.f8889o.zzacb();
                this.f8889o.zzacc();
                this.f8854D = true;
            }
            m6133f();
            z = true;
        }
        m6143p(z);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        zzbdu zzbdu;
        synchronized (this) {
            if (!isDestroyed()) {
                this.f8867Q.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
            if (this.f8854D && (zzbdu = this.f8889o) != null && zzbdu.zzabz() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.f8889o.zzacb();
                this.f8889o.zzacc();
                this.f8854D = false;
            }
        }
        m6143p(false);
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            zzp.zzkq();
            zzm.zza(getContext(), intent);
        } catch (ActivityNotFoundException unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(str4).length());
            sb.append("Couldn't find an Activity to view url/mimetype: ");
            sb.append(str);
            sb.append(" / ");
            sb.append(str4);
            zzaza.zzeb(sb.toString());
        }
    }

    /* access modifiers changed from: protected */
    @TargetApi(21)
    public final void onDraw(Canvas canvas) {
        if (!isDestroyed()) {
            if (Build.VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
                super.onDraw(canvas);
            }
        }
    }

    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > 0.0f && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < 0.0f && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public final void onGlobalLayout() {
        boolean f = m6133f();
        zze zzaco = zzaco();
        if (zzaco != null && f) {
            zzaco.zzvi();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x01e0, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01c0 A[SYNTHETIC, Splitter:B:111:0x01c0] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x013b  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:121:0x01e1=Splitter:B:121:0x01e1, B:64:0x00dc=Splitter:B:64:0x00dc} */
    @android.annotation.SuppressLint({"DrawAllocation"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onMeasure(int r9, int r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.isDestroyed()     // Catch:{ all -> 0x01e6 }
            r1 = 0
            if (r0 == 0) goto L_0x000d
            r8.setMeasuredDimension(r1, r1)     // Catch:{ all -> 0x01e6 }
            monitor-exit(r8)
            return
        L_0x000d:
            boolean r0 = r8.isInEditMode()     // Catch:{ all -> 0x01e6 }
            if (r0 != 0) goto L_0x01e1
            boolean r0 = r8.f8896v     // Catch:{ all -> 0x01e6 }
            if (r0 != 0) goto L_0x01e1
            com.google.android.gms.internal.ads.zzbfn r0 = r8.f8892r     // Catch:{ all -> 0x01e6 }
            boolean r0 = r0.zzadz()     // Catch:{ all -> 0x01e6 }
            if (r0 == 0) goto L_0x0021
            goto L_0x01e1
        L_0x0021:
            com.google.android.gms.internal.ads.zzbfn r0 = r8.f8892r     // Catch:{ all -> 0x01e6 }
            boolean r0 = r0.zzaeb()     // Catch:{ all -> 0x01e6 }
            if (r0 == 0) goto L_0x002e
            super.onMeasure(r9, r10)     // Catch:{ all -> 0x01e6 }
            monitor-exit(r8)
            return
        L_0x002e:
            com.google.android.gms.internal.ads.zzbfn r0 = r8.f8892r     // Catch:{ all -> 0x01e6 }
            boolean r0 = r0.zzaea()     // Catch:{ all -> 0x01e6 }
            if (r0 == 0) goto L_0x0091
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcsh     // Catch:{ all -> 0x01e6 }
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x01e6 }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x01e6 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x01e6 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x01e6 }
            if (r0 == 0) goto L_0x004d
            super.onMeasure(r9, r10)     // Catch:{ all -> 0x01e6 }
            monitor-exit(r8)
            return
        L_0x004d:
            com.google.android.gms.internal.ads.zzbep r0 = r8.zzaah()     // Catch:{ all -> 0x01e6 }
            r1 = 0
            if (r0 == 0) goto L_0x0059
            float r0 = r0.getAspectRatio()     // Catch:{ all -> 0x01e6 }
            goto L_0x005a
        L_0x0059:
            r0 = 0
        L_0x005a:
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0063
            super.onMeasure(r9, r10)     // Catch:{ all -> 0x01e6 }
            monitor-exit(r8)
            return
        L_0x0063:
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01e6 }
            int r10 = android.view.View.MeasureSpec.getSize(r10)     // Catch:{ all -> 0x01e6 }
            float r1 = (float) r10     // Catch:{ all -> 0x01e6 }
            float r1 = r1 * r0
            int r1 = (int) r1     // Catch:{ all -> 0x01e6 }
            float r2 = (float) r9     // Catch:{ all -> 0x01e6 }
            float r2 = r2 / r0
            int r2 = (int) r2     // Catch:{ all -> 0x01e6 }
            if (r10 != 0) goto L_0x007c
            if (r2 == 0) goto L_0x007c
            float r10 = (float) r2     // Catch:{ all -> 0x01e6 }
            float r10 = r10 * r0
            int r1 = (int) r10     // Catch:{ all -> 0x01e6 }
            r10 = r2
            goto L_0x0084
        L_0x007c:
            if (r9 != 0) goto L_0x0084
            if (r1 == 0) goto L_0x0084
            float r9 = (float) r1     // Catch:{ all -> 0x01e6 }
            float r9 = r9 / r0
            int r2 = (int) r9     // Catch:{ all -> 0x01e6 }
            r9 = r1
        L_0x0084:
            int r9 = java.lang.Math.min(r1, r9)     // Catch:{ all -> 0x01e6 }
            int r10 = java.lang.Math.min(r2, r10)     // Catch:{ all -> 0x01e6 }
            r8.setMeasuredDimension(r9, r10)     // Catch:{ all -> 0x01e6 }
            monitor-exit(r8)
            return
        L_0x0091:
            com.google.android.gms.internal.ads.zzbfn r0 = r8.f8892r     // Catch:{ all -> 0x01e6 }
            boolean r0 = r0.isFluid()     // Catch:{ all -> 0x01e6 }
            if (r0 == 0) goto L_0x00e1
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcsk     // Catch:{ all -> 0x01e6 }
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x01e6 }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x01e6 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x01e6 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x01e6 }
            if (r0 != 0) goto L_0x00dc
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR1()     // Catch:{ all -> 0x01e6 }
            if (r0 != 0) goto L_0x00b2
            goto L_0x00dc
        L_0x00b2:
            java.lang.String r0 = "/contentHeight"
            com.google.android.gms.internal.ads.j9 r1 = new com.google.android.gms.internal.ads.j9     // Catch:{ all -> 0x01e6 }
            r1.<init>(r8)     // Catch:{ all -> 0x01e6 }
            r8.zza((java.lang.String) r0, (com.google.android.gms.internal.ads.zzahv<? super com.google.android.gms.internal.ads.zzbdv>) r1)     // Catch:{ all -> 0x01e6 }
            java.lang.String r0 = "(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();"
            r8.m6146s(r0)     // Catch:{ all -> 0x01e6 }
            android.util.DisplayMetrics r0 = r8.f8881g     // Catch:{ all -> 0x01e6 }
            float r0 = r0.density     // Catch:{ all -> 0x01e6 }
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01e6 }
            int r1 = r8.f8859I     // Catch:{ all -> 0x01e6 }
            r2 = -1
            if (r1 == r2) goto L_0x00d3
            float r10 = (float) r1     // Catch:{ all -> 0x01e6 }
            float r10 = r10 * r0
            int r10 = (int) r10     // Catch:{ all -> 0x01e6 }
            goto L_0x00d7
        L_0x00d3:
            int r10 = android.view.View.MeasureSpec.getSize(r10)     // Catch:{ all -> 0x01e6 }
        L_0x00d7:
            r8.setMeasuredDimension(r9, r10)     // Catch:{ all -> 0x01e6 }
            monitor-exit(r8)
            return
        L_0x00dc:
            super.onMeasure(r9, r10)     // Catch:{ all -> 0x01e6 }
            monitor-exit(r8)
            return
        L_0x00e1:
            com.google.android.gms.internal.ads.zzbfn r0 = r8.f8892r     // Catch:{ all -> 0x01e6 }
            boolean r0 = r0.zzady()     // Catch:{ all -> 0x01e6 }
            if (r0 == 0) goto L_0x00f4
            android.util.DisplayMetrics r9 = r8.f8881g     // Catch:{ all -> 0x01e6 }
            int r10 = r9.widthPixels     // Catch:{ all -> 0x01e6 }
            int r9 = r9.heightPixels     // Catch:{ all -> 0x01e6 }
            r8.setMeasuredDimension(r10, r9)     // Catch:{ all -> 0x01e6 }
            monitor-exit(r8)
            return
        L_0x00f4:
            int r0 = android.view.View.MeasureSpec.getMode(r9)     // Catch:{ all -> 0x01e6 }
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01e6 }
            int r2 = android.view.View.MeasureSpec.getMode(r10)     // Catch:{ all -> 0x01e6 }
            int r10 = android.view.View.MeasureSpec.getSize(r10)     // Catch:{ all -> 0x01e6 }
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r4) goto L_0x0114
            if (r0 != r3) goto L_0x0110
            goto L_0x0114
        L_0x0110:
            r0 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0115
        L_0x0114:
            r0 = r9
        L_0x0115:
            if (r2 == r4) goto L_0x0119
            if (r2 != r3) goto L_0x011a
        L_0x0119:
            r5 = r10
        L_0x011a:
            com.google.android.gms.internal.ads.zzbfn r2 = r8.f8892r     // Catch:{ all -> 0x01e6 }
            int r3 = r2.widthPixels     // Catch:{ all -> 0x01e6 }
            r4 = 1
            if (r3 > r0) goto L_0x0128
            int r2 = r2.heightPixels     // Catch:{ all -> 0x01e6 }
            if (r2 <= r5) goto L_0x0126
            goto L_0x0128
        L_0x0126:
            r2 = 0
            goto L_0x0129
        L_0x0128:
            r2 = 1
        L_0x0129:
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzabf.zzcvc     // Catch:{ all -> 0x01e6 }
            com.google.android.gms.internal.ads.zzabb r6 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x01e6 }
            java.lang.Object r3 = r6.zzd(r3)     // Catch:{ all -> 0x01e6 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x01e6 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x01e6 }
            if (r3 == 0) goto L_0x0159
            com.google.android.gms.internal.ads.zzbfn r3 = r8.f8892r     // Catch:{ all -> 0x01e6 }
            int r6 = r3.widthPixels     // Catch:{ all -> 0x01e6 }
            float r6 = (float) r6     // Catch:{ all -> 0x01e6 }
            float r7 = r8.f8882h     // Catch:{ all -> 0x01e6 }
            float r6 = r6 / r7
            float r0 = (float) r0     // Catch:{ all -> 0x01e6 }
            float r0 = r0 / r7
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x0155
            int r0 = r3.heightPixels     // Catch:{ all -> 0x01e6 }
            float r0 = (float) r0     // Catch:{ all -> 0x01e6 }
            float r0 = r0 / r7
            float r3 = (float) r5     // Catch:{ all -> 0x01e6 }
            float r3 = r3 / r7
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 > 0) goto L_0x0155
            r0 = 1
            goto L_0x0156
        L_0x0155:
            r0 = 0
        L_0x0156:
            if (r2 == 0) goto L_0x0159
            r2 = r0
        L_0x0159:
            r0 = 8
            if (r2 == 0) goto L_0x01c0
            com.google.android.gms.internal.ads.zzbfn r2 = r8.f8892r     // Catch:{ all -> 0x01e6 }
            int r3 = r2.widthPixels     // Catch:{ all -> 0x01e6 }
            float r3 = (float) r3     // Catch:{ all -> 0x01e6 }
            float r5 = r8.f8882h     // Catch:{ all -> 0x01e6 }
            float r3 = r3 / r5
            int r3 = (int) r3     // Catch:{ all -> 0x01e6 }
            int r2 = r2.heightPixels     // Catch:{ all -> 0x01e6 }
            float r2 = (float) r2     // Catch:{ all -> 0x01e6 }
            float r2 = r2 / r5
            int r2 = (int) r2     // Catch:{ all -> 0x01e6 }
            float r9 = (float) r9     // Catch:{ all -> 0x01e6 }
            float r9 = r9 / r5
            int r9 = (int) r9     // Catch:{ all -> 0x01e6 }
            float r10 = (float) r10     // Catch:{ all -> 0x01e6 }
            float r10 = r10 / r5
            int r10 = (int) r10     // Catch:{ all -> 0x01e6 }
            r5 = 103(0x67, float:1.44E-43)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e6 }
            r6.<init>(r5)     // Catch:{ all -> 0x01e6 }
            java.lang.String r5 = "Not enough space to show ad. Needs "
            r6.append(r5)     // Catch:{ all -> 0x01e6 }
            r6.append(r3)     // Catch:{ all -> 0x01e6 }
            java.lang.String r3 = "x"
            r6.append(r3)     // Catch:{ all -> 0x01e6 }
            r6.append(r2)     // Catch:{ all -> 0x01e6 }
            java.lang.String r2 = " dp, but only has "
            r6.append(r2)     // Catch:{ all -> 0x01e6 }
            r6.append(r9)     // Catch:{ all -> 0x01e6 }
            java.lang.String r9 = "x"
            r6.append(r9)     // Catch:{ all -> 0x01e6 }
            r6.append(r10)     // Catch:{ all -> 0x01e6 }
            java.lang.String r9 = " dp."
            r6.append(r9)     // Catch:{ all -> 0x01e6 }
            java.lang.String r9 = r6.toString()     // Catch:{ all -> 0x01e6 }
            com.google.android.gms.internal.ads.zzaza.zzfa(r9)     // Catch:{ all -> 0x01e6 }
            int r9 = r8.getVisibility()     // Catch:{ all -> 0x01e6 }
            if (r9 == r0) goto L_0x01ae
            r9 = 4
            r8.setVisibility(r9)     // Catch:{ all -> 0x01e6 }
        L_0x01ae:
            r8.setMeasuredDimension(r1, r1)     // Catch:{ all -> 0x01e6 }
            boolean r9 = r8.f8887m     // Catch:{ all -> 0x01e6 }
            if (r9 != 0) goto L_0x01df
            com.google.android.gms.internal.ads.zzts r9 = r8.f8875a0     // Catch:{ all -> 0x01e6 }
            com.google.android.gms.internal.ads.zztu$zza$zza r10 = com.google.android.gms.internal.ads.zztu.zza.C3991zza.BANNER_SIZE_INVALID     // Catch:{ all -> 0x01e6 }
            r9.zza((com.google.android.gms.internal.ads.zztu.zza.C3991zza) r10)     // Catch:{ all -> 0x01e6 }
            r8.f8887m = r4     // Catch:{ all -> 0x01e6 }
            monitor-exit(r8)
            return
        L_0x01c0:
            int r9 = r8.getVisibility()     // Catch:{ all -> 0x01e6 }
            if (r9 == r0) goto L_0x01c9
            r8.setVisibility(r1)     // Catch:{ all -> 0x01e6 }
        L_0x01c9:
            boolean r9 = r8.f8888n     // Catch:{ all -> 0x01e6 }
            if (r9 != 0) goto L_0x01d6
            com.google.android.gms.internal.ads.zzts r9 = r8.f8875a0     // Catch:{ all -> 0x01e6 }
            com.google.android.gms.internal.ads.zztu$zza$zza r10 = com.google.android.gms.internal.ads.zztu.zza.C3991zza.BANNER_SIZE_VALID     // Catch:{ all -> 0x01e6 }
            r9.zza((com.google.android.gms.internal.ads.zztu.zza.C3991zza) r10)     // Catch:{ all -> 0x01e6 }
            r8.f8888n = r4     // Catch:{ all -> 0x01e6 }
        L_0x01d6:
            com.google.android.gms.internal.ads.zzbfn r9 = r8.f8892r     // Catch:{ all -> 0x01e6 }
            int r10 = r9.widthPixels     // Catch:{ all -> 0x01e6 }
            int r9 = r9.heightPixels     // Catch:{ all -> 0x01e6 }
            r8.setMeasuredDimension(r10, r9)     // Catch:{ all -> 0x01e6 }
        L_0x01df:
            monitor-exit(r8)
            return
        L_0x01e1:
            super.onMeasure(r9, r10)     // Catch:{ all -> 0x01e6 }
            monitor-exit(r8)
            return
        L_0x01e6:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C1982h9.onMeasure(int, int):void");
    }

    public final void onPause() {
        if (!isDestroyed()) {
            try {
                super.onPause();
            } catch (Exception e) {
                zzaza.zzc("Could not pause webview.", e);
            }
        }
    }

    public final void onResume() {
        if (!isDestroyed()) {
            try {
                super.onResume();
            } catch (Exception e) {
                zzaza.zzc("Could not resume webview.", e);
            }
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f8889o.zzabz() || this.f8889o.zzaca()) {
            zzef zzef = this.f8876b;
            if (zzef != null) {
                zzef.zza(motionEvent);
            }
            zzacg zzacg = this.f8877c;
            if (zzacg != null) {
                zzacg.zza(motionEvent);
            }
        } else {
            synchronized (this) {
                zzadx zzadx = this.f8855E;
                if (zzadx != null) {
                    zzadx.zzc(motionEvent);
                }
            }
        }
        if (isDestroyed()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        new WeakReference(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    public final synchronized void setRequestedOrientation(int i) {
        this.f8899y = i;
        zze zze = this.f8890p;
        if (zze != null) {
            zze.setRequestedOrientation(i);
        }
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzbdu) {
            this.f8889o = (zzbdu) webViewClient;
        }
    }

    public final void stopLoading() {
        if (!isDestroyed()) {
            try {
                super.stopLoading();
            } catch (Exception e) {
                zzaza.zzc("Could not stop loading webview.", e);
            }
        }
    }

    public final void zza(String str, Map<String, ?> map) {
        try {
            zzb(str, zzp.zzkq().zzj(map));
        } catch (JSONException unused) {
            zzaza.zzfa("Could not convert parameters to JSON.");
        }
    }

    public final zzbax zzaag() {
        return null;
    }

    public final synchronized zzbep zzaah() {
        return this.f8852B;
    }

    public final zzabq zzaai() {
        return this.f8861K;
    }

    public final Activity zzaaj() {
        return this.f8874a.zzaaj();
    }

    public final zzb zzaak() {
        return this.f8880f;
    }

    public final synchronized String zzaal() {
        zzdmz zzdmz = this.f8886l;
        if (zzdmz == null) {
            return null;
        }
        return zzdmz.zzbvf;
    }

    public final synchronized int zzaam() {
        return this.f8864N;
    }

    public final zzabt zzaan() {
        return this.f8863M;
    }

    public final zzazh zzaao() {
        return this.f8878d;
    }

    public final int zzaap() {
        return getMeasuredHeight();
    }

    public final int zzaaq() {
        return getMeasuredWidth();
    }

    public final synchronized void zzaar() {
        zzads zzads = this.f8856F;
        if (zzads != null) {
            zzads.zzsq();
        }
    }

    public final zzdmu zzabw() {
        return this.f8885k;
    }

    public final void zzacl() {
        m6135h();
        HashMap hashMap = new HashMap(1);
        hashMap.put(MediationMetaData.KEY_VERSION, this.f8878d.zzbrf);
        zza("onhide", (Map<String, ?>) hashMap);
    }

    public final void zzacm() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(zzp.zzkv().zzql()));
        hashMap.put("app_volume", String.valueOf(zzp.zzkv().zzqk()));
        hashMap.put("device_volume", String.valueOf(zzad.zzbi(getContext())));
        zza("volume", (Map<String, ?>) hashMap);
    }

    public final Context zzacn() {
        return this.f8874a.zzacn();
    }

    public final synchronized zze zzaco() {
        return this.f8890p;
    }

    public final synchronized zze zzacp() {
        return this.f8865O;
    }

    public final synchronized zzbfn zzacq() {
        return this.f8892r;
    }

    public final synchronized String zzacr() {
        return this.f8893s;
    }

    public final /* synthetic */ zzbfg zzacs() {
        return this.f8889o;
    }

    public final WebViewClient zzact() {
        return this.f8889o;
    }

    public final synchronized boolean zzacu() {
        return this.f8894t;
    }

    public final zzef zzacv() {
        return this.f8876b;
    }

    public final synchronized IObjectWrapper zzacw() {
        return this.f8891q;
    }

    public final synchronized boolean zzacx() {
        return this.f8896v;
    }

    public final synchronized void zzacy() {
        zzd.zzee("Destroying WebView!");
        m6148u();
        zzm.zzedd.post(new C2019i9(this));
    }

    public final synchronized boolean zzacz() {
        return this.f8900z;
    }

    public final synchronized boolean zzada() {
        return this.f8858H > 0;
    }

    public final void zzadb() {
        this.f8867Q.zzyz();
    }

    public final void zzadc() {
        if (this.f8862L == null) {
            zzabq zzb = zzabn.zzb(this.f8863M.zzry());
            this.f8862L = zzb;
            this.f8863M.zza("native:view_load", zzb);
        }
    }

    public final synchronized zzadx zzadd() {
        return this.f8855E;
    }

    public final void zzade() {
        setBackgroundColor(0);
    }

    public final void zzadf() {
        zzd.zzee("Cannot add text view to inner AdWebView");
    }

    public final synchronized zzsc zzadg() {
        return this.f8857G;
    }

    public final boolean zzadh() {
        return false;
    }

    public final zzsu zzadi() {
        return this.f8883i;
    }

    public final boolean zzadj() {
        return ((Boolean) zzwq.zzqe().zzd(zzabf.zzcwz)).booleanValue() && this.f8883i != null && this.f8884j;
    }

    public final zzdmz zzadk() {
        return this.f8886l;
    }

    public final synchronized void zzal(boolean z) {
        zze zze = this.f8890p;
        if (zze != null) {
            zze.zza(this.f8889o.zzaby(), z);
        } else {
            this.f8894t = z;
        }
    }

    public final synchronized void zzaq(IObjectWrapper iObjectWrapper) {
        this.f8891q = iObjectWrapper;
    }

    public final void zzau(boolean z) {
        this.f8889o.zzau(z);
    }

    public final void zzaw(boolean z) {
        this.f8889o.zzaw(z);
    }

    public final synchronized void zzaz(boolean z) {
        boolean z2 = z != this.f8896v;
        this.f8896v = z;
        m6136i();
        if (z2) {
            if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcnb)).booleanValue() || !this.f8892r.zzady()) {
                new zzaqu(this).zzdv(z ? "expanded" : "default");
            }
        }
    }

    public final synchronized void zzb(String str, String str2, @Nullable String str3) {
        if (!isDestroyed()) {
            String str4 = str;
            super.loadDataWithBaseURL(str4, zzbfd.zzf(str2, zzbfd.zzadu()), "text/html", Key.STRING_CHARSET_NAME, str3);
            return;
        }
        zzaza.zzfa("#004 The webview is destroyed. Ignoring action.");
    }

    public final synchronized void zzba(boolean z) {
        this.f8900z = z;
    }

    public final synchronized void zzbb(boolean z) {
        zze zze;
        int i = this.f8858H + (z ? 1 : -1);
        this.f8858H = i;
        if (i <= 0 && (zze = this.f8890p) != null) {
            zze.zzvl();
        }
    }

    public final void zzbx(Context context) {
        this.f8874a.setBaseContext(context);
        this.f8867Q.zzj(this.f8874a.zzaaj());
    }

    public final boolean zzc(boolean z, int i) {
        destroy();
        this.f8875a0.zza((zztv) new C1945g9(z, i));
        this.f8875a0.zza(zztu.zza.C3991zza.ANDROID_WEBVIEW_CRASH);
        return true;
    }

    public final void zzcy(String str) {
        m6146s(str);
    }

    public final synchronized void zzdq(int i) {
        this.f8864N = i;
    }

    public final void zzdv(int i) {
        if (i == 0) {
            zzabn.zza(this.f8863M.zzry(), this.f8861K, "aebb2");
        }
        m6135h();
        if (this.f8863M.zzry() != null) {
            this.f8863M.zzry().zzh("close_type", String.valueOf(i));
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put(MediationMetaData.KEY_VERSION, this.f8878d.zzbrf);
        zza("onhide", (Map<String, ?>) hashMap);
    }

    public final synchronized zzbcx zzff(String str) {
        Map<String, zzbcx> map = this.f8872V;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public final synchronized void zzkm() {
        zzk zzk = this.f8879e;
        if (zzk != null) {
            zzk.zzkm();
        }
    }

    public final synchronized void zzkn() {
        zzk zzk = this.f8879e;
        if (zzk != null) {
            zzk.zzkn();
        }
    }

    public final void zzvj() {
        if (this.f8860J == null) {
            zzabn.zza(this.f8863M.zzry(), this.f8861K, "aes2");
            zzabq zzb = zzabn.zzb(this.f8863M.zzry());
            this.f8860J = zzb;
            this.f8863M.zza("native:view_show", zzb);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put(MediationMetaData.KEY_VERSION, this.f8878d.zzbrf);
        zza("onshow", (Map<String, ?>) hashMap);
    }

    public final void zzvk() {
        zze zzaco = zzaco();
        if (zzaco != null) {
            zzaco.zzvk();
        }
    }

    public final void zza(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(jSONObject2).length());
        sb.append(str);
        sb.append("(");
        sb.append(jSONObject2);
        sb.append(");");
        m6146s(sb.toString());
    }

    public final void zzb(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        String valueOf = String.valueOf(sb.toString());
        zzaza.zzeb(valueOf.length() != 0 ? "Dispatching AFMA event: ".concat(valueOf) : new String("Dispatching AFMA event: "));
        m6146s(sb.toString());
    }

    public final void zza(boolean z, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put(FirebaseAnalytics.Param.SUCCESS, z ? "1" : "0");
        hashMap.put("duration", Long.toString(j));
        zza("onCacheAccessComplete", (Map<String, ?>) hashMap);
    }

    public final synchronized void zza(zze zze) {
        this.f8890p = zze;
    }

    public final synchronized void zza(zzbfn zzbfn) {
        this.f8892r = zzbfn;
        requestLayout();
    }

    public final synchronized void zza(String str, zzbcx zzbcx) {
        if (this.f8872V == null) {
            this.f8872V = new HashMap();
        }
        this.f8872V.put(str, zzbcx);
    }

    public final synchronized void zzb(zze zze) {
        this.f8865O = zze;
    }

    public final void zzb(boolean z, int i) {
        this.f8889o.zzb(z, i);
    }

    public final void zzb(String str, zzahv<? super zzbdv> zzahv) {
        zzbdu zzbdu = this.f8889o;
        if (zzbdu != null) {
            zzbdu.zzb(str, zzahv);
        }
    }

    public final synchronized void zza(zzads zzads) {
        this.f8856F = zzads;
    }

    public final synchronized void zza(zzsc zzsc) {
        this.f8857G = zzsc;
    }

    public final synchronized void zza(zzadx zzadx) {
        this.f8855E = zzadx;
    }

    public final synchronized void zza(zzbep zzbep) {
        if (this.f8852B != null) {
            zzaza.zzey("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.f8852B = zzbep;
        }
    }

    public final void zza(com.google.android.gms.ads.internal.overlay.zzb zzb) {
        this.f8889o.zza(zzb);
    }

    public final void zza(boolean z, int i, String str) {
        this.f8889o.zza(z, i, str);
    }

    public final void zza(boolean z, int i, String str, String str2) {
        this.f8889o.zza(z, i, str, str2);
    }

    public final void zza(zzqv zzqv) {
        boolean z;
        synchronized (this) {
            z = zzqv.zzbqz;
            this.f8853C = z;
        }
        m6143p(z);
    }

    public final void zza(String str, zzahv<? super zzbdv> zzahv) {
        zzbdu zzbdu = this.f8889o;
        if (zzbdu != null) {
            zzbdu.zza(str, zzahv);
        }
    }

    public final void zza(String str, Predicate<zzahv<? super zzbdv>> predicate) {
        zzbdu zzbdu = this.f8889o;
        if (zzbdu != null) {
            zzbdu.zza(str, predicate);
        }
    }

    public final void zza(ViewGroup viewGroup, Activity activity, String str, String str2) {
        if (!zzadj()) {
            zzd.zzee("AR ad is not enabled or the ad from the server is not an AR ad.");
            return;
        }
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
        zzd.zzee("Initializing ArWebView object.");
        this.f8883i.zza(activity, this);
        this.f8883i.zzc(str, str2);
        if (viewGroup != null) {
            viewGroup.addView(this.f8883i.getView());
        } else {
            zzaza.zzey("The FrameLayout object cannot be null.");
        }
    }

    public final void zza(zzdmu zzdmu, zzdmz zzdmz) {
        this.f8885k = zzdmu;
        this.f8886l = zzdmz;
    }
}
