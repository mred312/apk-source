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
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
@VisibleForTesting
/* renamed from: com.google.android.gms.internal.ads.u9 */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2468u9 extends zzbgb implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzakj, zzbdv {
    @GuardedBy("this")

    /* renamed from: A */
    private boolean f11257A;
    @GuardedBy("this")

    /* renamed from: B */
    private boolean f11258B;
    @GuardedBy("this")

    /* renamed from: C */
    private zzadx f11259C;
    @GuardedBy("this")

    /* renamed from: D */
    private zzads f11260D;
    @GuardedBy("this")

    /* renamed from: E */
    private zzsc f11261E;
    @GuardedBy("this")

    /* renamed from: F */
    private int f11262F;
    /* access modifiers changed from: private */
    @GuardedBy("this")

    /* renamed from: G */
    public int f11263G;

    /* renamed from: H */
    private zzabq f11264H;

    /* renamed from: I */
    private zzabq f11265I;

    /* renamed from: J */
    private zzabq f11266J;

    /* renamed from: K */
    private zzabt f11267K;

    /* renamed from: L */
    private int f11268L;
    @GuardedBy("this")

    /* renamed from: M */
    private zze f11269M;

    /* renamed from: N */
    private zzbz f11270N;

    /* renamed from: O */
    private final AtomicReference<IObjectWrapper> f11271O = new AtomicReference<>();

    /* renamed from: P */
    private int f11272P = -1;

    /* renamed from: Q */
    private int f11273Q = -1;

    /* renamed from: R */
    private int f11274R = -1;

    /* renamed from: S */
    private int f11275S = -1;

    /* renamed from: T */
    private Map<String, zzbcx> f11276T;

    /* renamed from: U */
    private final WindowManager f11277U;

    /* renamed from: d */
    private final zzbfk f11278d;

    /* renamed from: e */
    private final zzbfm f11279e;
    @Nullable

    /* renamed from: f */
    private final zzef f11280f;

    /* renamed from: g */
    private final zzacg f11281g;

    /* renamed from: h */
    private final zzazh f11282h;

    /* renamed from: i */
    private final zzk f11283i;

    /* renamed from: j */
    private final zzb f11284j;

    /* renamed from: k */
    private final DisplayMetrics f11285k;

    /* renamed from: l */
    private final zzts f11286l;
    @Nullable

    /* renamed from: m */
    private final zzsu f11287m;

    /* renamed from: n */
    private final boolean f11288n;
    @Nullable

    /* renamed from: o */
    private zzdmu f11289o;
    @Nullable

    /* renamed from: p */
    private zzdmz f11290p;
    @GuardedBy("this")

    /* renamed from: q */
    private zze f11291q;
    @GuardedBy("this")

    /* renamed from: r */
    private zzbfn f11292r;
    @GuardedBy("this")

    /* renamed from: s */
    private String f11293s;
    @GuardedBy("this")

    /* renamed from: t */
    private boolean f11294t;
    @GuardedBy("this")

    /* renamed from: u */
    private boolean f11295u;
    @GuardedBy("this")

    /* renamed from: v */
    private boolean f11296v;
    @GuardedBy("this")

    /* renamed from: w */
    private int f11297w;
    @GuardedBy("this")

    /* renamed from: x */
    private boolean f11298x = true;
    @GuardedBy("this")

    /* renamed from: y */
    private String f11299y = "";
    @GuardedBy("this")

    /* renamed from: z */
    private zzbep f11300z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @VisibleForTesting
    protected C2468u9(zzbfk zzbfk, zzbfm zzbfm, zzbfn zzbfn, String str, boolean z, boolean z2, @Nullable zzef zzef, zzacg zzacg, zzazh zzazh, zzabs zzabs, zzk zzk, zzb zzb, zzts zzts, zzsu zzsu, boolean z3, zzdmu zzdmu, zzdmz zzdmz) {
        super(zzbfk, zzbfm);
        zzdmz zzdmz2;
        zzazh zzazh2 = zzazh;
        this.f11278d = zzbfk;
        this.f11279e = zzbfm;
        this.f11292r = zzbfn;
        this.f11293s = str;
        this.f11295u = z;
        this.f11297w = -1;
        this.f11280f = zzef;
        this.f11281g = zzacg;
        this.f11282h = zzazh2;
        this.f11283i = zzk;
        this.f11284j = zzb;
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        this.f11277U = windowManager;
        zzp.zzkq();
        this.f11285k = zzm.zza(windowManager);
        this.f11286l = zzts;
        this.f11287m = zzsu;
        this.f11288n = z3;
        this.f11289o = zzdmu;
        this.f11290p = zzdmz;
        this.f11270N = new zzbz(zzbfk.zzaaj(), this, this, (ViewTreeObserver.OnScrollChangedListener) null);
        zzp.zzkq().zza((Context) zzbfk, zzazh2.zzbrf, getSettings());
        setDownloadListener(this);
        m7029h();
        if (PlatformVersion.isAtLeastJellyBeanMR1()) {
            addJavascriptInterface(zzbet.zzc(this), "googleAdsJsInterface");
        }
        m7033l();
        zzabt zzabt = new zzabt(new zzabs(true, "make_wv", this.f11293s));
        this.f11267K = zzabt;
        zzabt.zzry().zzc(zzabs);
        if (!(!((Boolean) zzwq.zzqe().zzd(zzabf.zzcqn)).booleanValue() || (zzdmz2 = this.f11290p) == null || zzdmz2.zzbvf == null)) {
            this.f11267K.zzry().zzh("gqi", this.f11290p.zzbvf);
        }
        zzabq zzb2 = zzabn.zzb(this.f11267K.zzry());
        this.f11265I = zzb2;
        this.f11267K.zza("native:view_create", zzb2);
        this.f11266J = null;
        this.f11264H = null;
        zzp.zzks().zzbg(zzbfk);
    }

    /* renamed from: e */
    static final /* synthetic */ void m7026e(boolean z, int i, zzue.zzi.zza zza) {
        zzue.zzae.zza zzpj = zzue.zzae.zzpj();
        if (zzpj.zzpi() != z) {
            zzpj.zzw(z);
        }
        zza.zzb((zzue.zzae) ((zzekh) zzpj.zzcu(i).zzbhv()));
    }

    /* renamed from: f */
    private final boolean m7027f() {
        int i;
        int i2;
        boolean z = false;
        if (!this.f11279e.zzaby() && !this.f11279e.zzabz()) {
            return false;
        }
        zzwq.zzqa();
        DisplayMetrics displayMetrics = this.f11285k;
        int zzb = zzayr.zzb(displayMetrics, displayMetrics.widthPixels);
        zzwq.zzqa();
        DisplayMetrics displayMetrics2 = this.f11285k;
        int zzb2 = zzayr.zzb(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzaaj = this.f11278d.zzaaj();
        if (zzaaj == null || zzaaj.getWindow() == null) {
            i2 = zzb;
            i = zzb2;
        } else {
            zzp.zzkq();
            int[] zzf = zzm.zzf(zzaaj);
            zzwq.zzqa();
            int zzb3 = zzayr.zzb(this.f11285k, zzf[0]);
            zzwq.zzqa();
            i = zzayr.zzb(this.f11285k, zzf[1]);
            i2 = zzb3;
        }
        int i3 = this.f11273Q;
        if (i3 == zzb && this.f11272P == zzb2 && this.f11274R == i2 && this.f11275S == i) {
            return false;
        }
        if (!(i3 == zzb && this.f11272P == zzb2)) {
            z = true;
        }
        this.f11273Q = zzb;
        this.f11272P = zzb2;
        this.f11274R = i2;
        this.f11275S = i;
        new zzaqu(this).zza(zzb, zzb2, i2, i, this.f11285k.density, this.f11277U.getDefaultDisplay().getRotation());
        return z;
    }

    /* renamed from: g */
    private final void m7028g() {
        zzabn.zza(this.f11267K.zzry(), this.f11265I, "aeh2");
    }

    /* renamed from: h */
    private final synchronized void m7029h() {
        if (!this.f11295u) {
            if (!this.f11292r.zzady()) {
                if (Build.VERSION.SDK_INT < 18) {
                    zzaza.zzeb("Disabling hardware acceleration on an AdView.");
                    m7030i();
                    return;
                }
                zzaza.zzeb("Enabling hardware acceleration on an AdView.");
                m7031j();
                return;
            }
        }
        zzaza.zzeb("Enabling hardware acceleration on an overlay.");
        m7031j();
    }

    /* renamed from: i */
    private final synchronized void m7030i() {
        if (!this.f11296v) {
            zzp.zzks();
            setLayerType(1, (Paint) null);
        }
        this.f11296v = true;
    }

    /* renamed from: j */
    private final synchronized void m7031j() {
        if (this.f11296v) {
            zzp.zzks();
            setLayerType(0, (Paint) null);
        }
        this.f11296v = false;
    }

    /* renamed from: k */
    private final synchronized void m7032k() {
        Map<String, zzbcx> map = this.f11276T;
        if (map != null) {
            for (zzbcx release : map.values()) {
                release.release();
            }
        }
        this.f11276T = null;
    }

    /* renamed from: l */
    private final void m7033l() {
        zzabs zzry;
        zzabt zzabt = this.f11267K;
        if (zzabt != null && (zzry = zzabt.zzry()) != null && zzp.zzku().zzwt() != null) {
            zzp.zzku().zzwt().zza(zzry);
        }
    }

    /* renamed from: m */
    private final void m7034m(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        zzaki.zza((zzakj) this, "onAdVisibilityChanged", (Map) hashMap);
    }

    public final synchronized String getRequestId() {
        return this.f11299y;
    }

    public final View getView() {
        return this;
    }

    public final WebView getWebView() {
        return this;
    }

    public final void onAdClicked() {
        zzbfm zzbfm = this.f11279e;
        if (zzbfm != null) {
            zzbfm.onAdClicked();
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isDestroyed()) {
            this.f11270N.onAttachedToWindow();
        }
        boolean z = this.f11257A;
        zzbfm zzbfm = this.f11279e;
        if (zzbfm != null && zzbfm.zzabz()) {
            if (!this.f11258B) {
                this.f11279e.zzacb();
                this.f11279e.zzacc();
                this.f11258B = true;
            }
            m7027f();
            z = true;
        }
        m7034m(z);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        zzbfm zzbfm;
        synchronized (this) {
            if (!isDestroyed()) {
                this.f11270N.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
            if (this.f11258B && (zzbfm = this.f11279e) != null && zzbfm.zzabz() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.f11279e.zzacb();
                this.f11279e.zzacc();
                this.f11258B = false;
            }
        }
        m7034m(false);
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
        if (Build.VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
            super.onDraw(canvas);
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
        boolean f = m7027f();
        zze zzaco = zzaco();
        if (zzaco != null && f) {
            zzaco.zzvi();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01b6 A[SYNTHETIC, Splitter:B:109:0x01b6] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x013b  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:116:0x01ca=Splitter:B:116:0x01ca, B:64:0x00dc=Splitter:B:64:0x00dc} */
    @android.annotation.SuppressLint({"DrawAllocation"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onMeasure(int r9, int r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.isDestroyed()     // Catch:{ all -> 0x01cf }
            r1 = 0
            if (r0 == 0) goto L_0x000d
            r8.setMeasuredDimension(r1, r1)     // Catch:{ all -> 0x01cf }
            monitor-exit(r8)
            return
        L_0x000d:
            boolean r0 = r8.isInEditMode()     // Catch:{ all -> 0x01cf }
            if (r0 != 0) goto L_0x01ca
            boolean r0 = r8.f11295u     // Catch:{ all -> 0x01cf }
            if (r0 != 0) goto L_0x01ca
            com.google.android.gms.internal.ads.zzbfn r0 = r8.f11292r     // Catch:{ all -> 0x01cf }
            boolean r0 = r0.zzadz()     // Catch:{ all -> 0x01cf }
            if (r0 == 0) goto L_0x0021
            goto L_0x01ca
        L_0x0021:
            com.google.android.gms.internal.ads.zzbfn r0 = r8.f11292r     // Catch:{ all -> 0x01cf }
            boolean r0 = r0.zzaeb()     // Catch:{ all -> 0x01cf }
            if (r0 == 0) goto L_0x002e
            super.onMeasure(r9, r10)     // Catch:{ all -> 0x01cf }
            monitor-exit(r8)
            return
        L_0x002e:
            com.google.android.gms.internal.ads.zzbfn r0 = r8.f11292r     // Catch:{ all -> 0x01cf }
            boolean r0 = r0.zzaea()     // Catch:{ all -> 0x01cf }
            if (r0 == 0) goto L_0x0091
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcsh     // Catch:{ all -> 0x01cf }
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x01cf }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x01cf }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x01cf }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x01cf }
            if (r0 == 0) goto L_0x004d
            super.onMeasure(r9, r10)     // Catch:{ all -> 0x01cf }
            monitor-exit(r8)
            return
        L_0x004d:
            com.google.android.gms.internal.ads.zzbep r0 = r8.zzaah()     // Catch:{ all -> 0x01cf }
            r1 = 0
            if (r0 == 0) goto L_0x0059
            float r0 = r0.getAspectRatio()     // Catch:{ all -> 0x01cf }
            goto L_0x005a
        L_0x0059:
            r0 = 0
        L_0x005a:
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0063
            super.onMeasure(r9, r10)     // Catch:{ all -> 0x01cf }
            monitor-exit(r8)
            return
        L_0x0063:
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01cf }
            int r10 = android.view.View.MeasureSpec.getSize(r10)     // Catch:{ all -> 0x01cf }
            float r1 = (float) r10     // Catch:{ all -> 0x01cf }
            float r1 = r1 * r0
            int r1 = (int) r1     // Catch:{ all -> 0x01cf }
            float r2 = (float) r9     // Catch:{ all -> 0x01cf }
            float r2 = r2 / r0
            int r2 = (int) r2     // Catch:{ all -> 0x01cf }
            if (r10 != 0) goto L_0x007c
            if (r2 == 0) goto L_0x007c
            float r10 = (float) r2     // Catch:{ all -> 0x01cf }
            float r10 = r10 * r0
            int r1 = (int) r10     // Catch:{ all -> 0x01cf }
            r10 = r2
            goto L_0x0084
        L_0x007c:
            if (r9 != 0) goto L_0x0084
            if (r1 == 0) goto L_0x0084
            float r9 = (float) r1     // Catch:{ all -> 0x01cf }
            float r9 = r9 / r0
            int r2 = (int) r9     // Catch:{ all -> 0x01cf }
            r9 = r1
        L_0x0084:
            int r9 = java.lang.Math.min(r1, r9)     // Catch:{ all -> 0x01cf }
            int r10 = java.lang.Math.min(r2, r10)     // Catch:{ all -> 0x01cf }
            r8.setMeasuredDimension(r9, r10)     // Catch:{ all -> 0x01cf }
            monitor-exit(r8)
            return
        L_0x0091:
            com.google.android.gms.internal.ads.zzbfn r0 = r8.f11292r     // Catch:{ all -> 0x01cf }
            boolean r0 = r0.isFluid()     // Catch:{ all -> 0x01cf }
            if (r0 == 0) goto L_0x00e1
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcsk     // Catch:{ all -> 0x01cf }
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x01cf }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x01cf }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x01cf }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x01cf }
            if (r0 != 0) goto L_0x00dc
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR1()     // Catch:{ all -> 0x01cf }
            if (r0 != 0) goto L_0x00b2
            goto L_0x00dc
        L_0x00b2:
            java.lang.String r0 = "/contentHeight"
            com.google.android.gms.internal.ads.w9 r1 = new com.google.android.gms.internal.ads.w9     // Catch:{ all -> 0x01cf }
            r1.<init>(r8)     // Catch:{ all -> 0x01cf }
            r8.zza((java.lang.String) r0, (com.google.android.gms.internal.ads.zzahv<? super com.google.android.gms.internal.ads.zzbdv>) r1)     // Catch:{ all -> 0x01cf }
            java.lang.String r0 = "(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();"
            r8.zzcy(r0)     // Catch:{ all -> 0x01cf }
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01cf }
            int r0 = r8.f11263G     // Catch:{ all -> 0x01cf }
            r1 = -1
            if (r0 == r1) goto L_0x00d3
            float r10 = (float) r0     // Catch:{ all -> 0x01cf }
            android.util.DisplayMetrics r0 = r8.f11285k     // Catch:{ all -> 0x01cf }
            float r0 = r0.density     // Catch:{ all -> 0x01cf }
            float r10 = r10 * r0
            int r10 = (int) r10     // Catch:{ all -> 0x01cf }
            goto L_0x00d7
        L_0x00d3:
            int r10 = android.view.View.MeasureSpec.getSize(r10)     // Catch:{ all -> 0x01cf }
        L_0x00d7:
            r8.setMeasuredDimension(r9, r10)     // Catch:{ all -> 0x01cf }
            monitor-exit(r8)
            return
        L_0x00dc:
            super.onMeasure(r9, r10)     // Catch:{ all -> 0x01cf }
            monitor-exit(r8)
            return
        L_0x00e1:
            com.google.android.gms.internal.ads.zzbfn r0 = r8.f11292r     // Catch:{ all -> 0x01cf }
            boolean r0 = r0.zzady()     // Catch:{ all -> 0x01cf }
            if (r0 == 0) goto L_0x00f4
            android.util.DisplayMetrics r9 = r8.f11285k     // Catch:{ all -> 0x01cf }
            int r10 = r9.widthPixels     // Catch:{ all -> 0x01cf }
            int r9 = r9.heightPixels     // Catch:{ all -> 0x01cf }
            r8.setMeasuredDimension(r10, r9)     // Catch:{ all -> 0x01cf }
            monitor-exit(r8)
            return
        L_0x00f4:
            int r0 = android.view.View.MeasureSpec.getMode(r9)     // Catch:{ all -> 0x01cf }
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01cf }
            int r2 = android.view.View.MeasureSpec.getMode(r10)     // Catch:{ all -> 0x01cf }
            int r10 = android.view.View.MeasureSpec.getSize(r10)     // Catch:{ all -> 0x01cf }
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
            com.google.android.gms.internal.ads.zzbfn r2 = r8.f11292r     // Catch:{ all -> 0x01cf }
            int r3 = r2.widthPixels     // Catch:{ all -> 0x01cf }
            r4 = 1
            if (r3 > r0) goto L_0x0128
            int r2 = r2.heightPixels     // Catch:{ all -> 0x01cf }
            if (r2 <= r5) goto L_0x0126
            goto L_0x0128
        L_0x0126:
            r2 = 0
            goto L_0x0129
        L_0x0128:
            r2 = 1
        L_0x0129:
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzabf.zzcvc     // Catch:{ all -> 0x01cf }
            com.google.android.gms.internal.ads.zzabb r6 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x01cf }
            java.lang.Object r3 = r6.zzd(r3)     // Catch:{ all -> 0x01cf }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x01cf }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x01cf }
            if (r3 == 0) goto L_0x015a
            com.google.android.gms.internal.ads.zzbfn r3 = r8.f11292r     // Catch:{ all -> 0x01cf }
            int r6 = r3.widthPixels     // Catch:{ all -> 0x01cf }
            float r6 = (float) r6     // Catch:{ all -> 0x01cf }
            android.util.DisplayMetrics r7 = r8.f11285k     // Catch:{ all -> 0x01cf }
            float r7 = r7.density     // Catch:{ all -> 0x01cf }
            float r6 = r6 / r7
            float r0 = (float) r0     // Catch:{ all -> 0x01cf }
            float r0 = r0 / r7
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x0156
            int r0 = r3.heightPixels     // Catch:{ all -> 0x01cf }
            float r0 = (float) r0     // Catch:{ all -> 0x01cf }
            float r0 = r0 / r7
            float r3 = (float) r5     // Catch:{ all -> 0x01cf }
            float r3 = r3 / r7
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 > 0) goto L_0x0156
            goto L_0x0157
        L_0x0156:
            r4 = 0
        L_0x0157:
            if (r2 == 0) goto L_0x015a
            r2 = r4
        L_0x015a:
            r0 = 8
            if (r2 == 0) goto L_0x01b6
            com.google.android.gms.internal.ads.zzbfn r2 = r8.f11292r     // Catch:{ all -> 0x01cf }
            int r3 = r2.widthPixels     // Catch:{ all -> 0x01cf }
            float r3 = (float) r3     // Catch:{ all -> 0x01cf }
            android.util.DisplayMetrics r4 = r8.f11285k     // Catch:{ all -> 0x01cf }
            float r4 = r4.density     // Catch:{ all -> 0x01cf }
            float r3 = r3 / r4
            int r3 = (int) r3     // Catch:{ all -> 0x01cf }
            int r2 = r2.heightPixels     // Catch:{ all -> 0x01cf }
            float r2 = (float) r2     // Catch:{ all -> 0x01cf }
            float r2 = r2 / r4
            int r2 = (int) r2     // Catch:{ all -> 0x01cf }
            float r9 = (float) r9     // Catch:{ all -> 0x01cf }
            float r9 = r9 / r4
            int r9 = (int) r9     // Catch:{ all -> 0x01cf }
            float r10 = (float) r10     // Catch:{ all -> 0x01cf }
            float r10 = r10 / r4
            int r10 = (int) r10     // Catch:{ all -> 0x01cf }
            r4 = 103(0x67, float:1.44E-43)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01cf }
            r5.<init>(r4)     // Catch:{ all -> 0x01cf }
            java.lang.String r4 = "Not enough space to show ad. Needs "
            r5.append(r4)     // Catch:{ all -> 0x01cf }
            r5.append(r3)     // Catch:{ all -> 0x01cf }
            java.lang.String r3 = "x"
            r5.append(r3)     // Catch:{ all -> 0x01cf }
            r5.append(r2)     // Catch:{ all -> 0x01cf }
            java.lang.String r2 = " dp, but only has "
            r5.append(r2)     // Catch:{ all -> 0x01cf }
            r5.append(r9)     // Catch:{ all -> 0x01cf }
            java.lang.String r9 = "x"
            r5.append(r9)     // Catch:{ all -> 0x01cf }
            r5.append(r10)     // Catch:{ all -> 0x01cf }
            java.lang.String r9 = " dp."
            r5.append(r9)     // Catch:{ all -> 0x01cf }
            java.lang.String r9 = r5.toString()     // Catch:{ all -> 0x01cf }
            com.google.android.gms.internal.ads.zzaza.zzfa(r9)     // Catch:{ all -> 0x01cf }
            int r9 = r8.getVisibility()     // Catch:{ all -> 0x01cf }
            if (r9 == r0) goto L_0x01b1
            r9 = 4
            r8.setVisibility(r9)     // Catch:{ all -> 0x01cf }
        L_0x01b1:
            r8.setMeasuredDimension(r1, r1)     // Catch:{ all -> 0x01cf }
            monitor-exit(r8)
            return
        L_0x01b6:
            int r9 = r8.getVisibility()     // Catch:{ all -> 0x01cf }
            if (r9 == r0) goto L_0x01bf
            r8.setVisibility(r1)     // Catch:{ all -> 0x01cf }
        L_0x01bf:
            com.google.android.gms.internal.ads.zzbfn r9 = r8.f11292r     // Catch:{ all -> 0x01cf }
            int r10 = r9.widthPixels     // Catch:{ all -> 0x01cf }
            int r9 = r9.heightPixels     // Catch:{ all -> 0x01cf }
            r8.setMeasuredDimension(r10, r9)     // Catch:{ all -> 0x01cf }
            monitor-exit(r8)
            return
        L_0x01ca:
            super.onMeasure(r9, r10)     // Catch:{ all -> 0x01cf }
            monitor-exit(r8)
            return
        L_0x01cf:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C2468u9.onMeasure(int, int):void");
    }

    public final void onPause() {
        try {
            super.onPause();
        } catch (Exception e) {
            zzaza.zzc("Could not pause webview.", e);
        }
    }

    public final void onResume() {
        try {
            super.onResume();
        } catch (Exception e) {
            zzaza.zzc("Could not resume webview.", e);
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f11279e.zzabz() || this.f11279e.zzaca()) {
            zzef zzef = this.f11280f;
            if (zzef != null) {
                zzef.zza(motionEvent);
            }
            zzacg zzacg = this.f11281g;
            if (zzacg != null) {
                zzacg.zza(motionEvent);
            }
        } else {
            synchronized (this) {
                zzadx zzadx = this.f11259C;
                if (zzadx != null) {
                    zzadx.zzc(motionEvent);
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        new WeakReference(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    public final synchronized void setRequestedOrientation(int i) {
        this.f11297w = i;
        zze zze = this.f11291q;
        if (zze != null) {
            zze.setRequestedOrientation(i);
        }
    }

    public final void stopLoading() {
        try {
            super.stopLoading();
        } catch (Exception e) {
            zzaza.zzc("Could not stop loading webview.", e);
        }
    }

    public final void zza(String str, Map map) {
        zzaki.zza((zzakj) this, str, map);
    }

    public final void zza(String str, JSONObject jSONObject) {
        zzaki.zza((zzakj) this, str, jSONObject);
    }

    public final void zza(boolean z, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put(FirebaseAnalytics.Param.SUCCESS, z ? "1" : "0");
        hashMap.put("duration", Long.toString(j));
        zzaki.zza((zzakj) this, "onCacheAccessComplete", (Map) hashMap);
    }

    public final zzbax zzaag() {
        return null;
    }

    public final synchronized zzbep zzaah() {
        return this.f11300z;
    }

    public final zzabq zzaai() {
        return this.f11265I;
    }

    public final Activity zzaaj() {
        return this.f11278d.zzaaj();
    }

    public final zzb zzaak() {
        return this.f11284j;
    }

    public final synchronized String zzaal() {
        zzdmz zzdmz = this.f11290p;
        if (zzdmz == null) {
            return null;
        }
        return zzdmz.zzbvf;
    }

    public final synchronized int zzaam() {
        return this.f11268L;
    }

    public final zzabt zzaan() {
        return this.f11267K;
    }

    public final zzazh zzaao() {
        return this.f11282h;
    }

    public final int zzaap() {
        return getMeasuredHeight();
    }

    public final int zzaaq() {
        return getMeasuredWidth();
    }

    public final synchronized void zzaar() {
        zzads zzads = this.f11260D;
        if (zzads != null) {
            zzads.zzsq();
        }
    }

    public final zzdmu zzabw() {
        return this.f11289o;
    }

    public final void zzacl() {
        m7028g();
        HashMap hashMap = new HashMap(1);
        hashMap.put(MediationMetaData.KEY_VERSION, this.f11282h.zzbrf);
        zzaki.zza((zzakj) this, "onhide", (Map) hashMap);
    }

    public final void zzacm() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(zzp.zzkv().zzql()));
        hashMap.put("app_volume", String.valueOf(zzp.zzkv().zzqk()));
        hashMap.put("device_volume", String.valueOf(zzad.zzbi(getContext())));
        zzaki.zza((zzakj) this, "volume", (Map) hashMap);
    }

    public final Context zzacn() {
        return this.f11278d.zzacn();
    }

    public final synchronized zze zzaco() {
        return this.f11291q;
    }

    public final synchronized zze zzacp() {
        return this.f11269M;
    }

    public final synchronized zzbfn zzacq() {
        return this.f11292r;
    }

    public final synchronized String zzacr() {
        return this.f11293s;
    }

    public final /* synthetic */ zzbfg zzacs() {
        return this.f11279e;
    }

    public final WebViewClient zzact() {
        return this.f11279e;
    }

    public final synchronized boolean zzacu() {
        return this.f11294t;
    }

    public final zzef zzacv() {
        return this.f11280f;
    }

    public final IObjectWrapper zzacw() {
        return this.f11271O.get();
    }

    public final synchronized boolean zzacx() {
        return this.f11295u;
    }

    public final void zzacy() {
    }

    public final synchronized boolean zzacz() {
        return this.f11298x;
    }

    public final synchronized boolean zzada() {
        return this.f11262F > 0;
    }

    public final void zzadb() {
        this.f11270N.zzyz();
    }

    public final void zzadc() {
        if (this.f11266J == null) {
            zzabq zzb = zzabn.zzb(this.f11267K.zzry());
            this.f11266J = zzb;
            this.f11267K.zza("native:view_load", zzb);
        }
    }

    public final synchronized zzadx zzadd() {
        return this.f11259C;
    }

    public final void zzade() {
        setBackgroundColor(0);
    }

    public final void zzadf() {
        zzd.zzee("Cannot add text view to inner AdWebView");
    }

    public final synchronized zzsc zzadg() {
        return this.f11261E;
    }

    public final boolean zzadh() {
        return false;
    }

    public final zzsu zzadi() {
        return this.f11287m;
    }

    public final boolean zzadj() {
        return ((Boolean) zzwq.zzqe().zzd(zzabf.zzcwz)).booleanValue() && this.f11287m != null && this.f11288n;
    }

    public final zzdmz zzadk() {
        return this.f11290p;
    }

    public final synchronized void zzal(boolean z) {
        zze zze = this.f11291q;
        if (zze != null) {
            zze.zza(this.f11279e.zzaby(), z);
        } else {
            this.f11294t = z;
        }
    }

    public final void zzaq(IObjectWrapper iObjectWrapper) {
        this.f11271O.set(iObjectWrapper);
    }

    public final void zzau(boolean z) {
        this.f11279e.zzau(z);
    }

    public final void zzaw(boolean z) {
        this.f11279e.zzaw(z);
    }

    public final synchronized void zzaz(boolean z) {
        boolean z2 = z != this.f11295u;
        this.f11295u = z;
        m7029h();
        if (z2) {
            if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcnb)).booleanValue() || !this.f11292r.zzady()) {
                new zzaqu(this).zzdv(z ? "expanded" : "default");
            }
        }
    }

    public final synchronized void zzb(String str, String str2, @Nullable String str3) {
        String str4 = str;
        super.loadDataWithBaseURL(str4, zzbfd.zzf(str2, zzbfd.zzadu()), "text/html", Key.STRING_CHARSET_NAME, str3);
    }

    public final void zzb(String str, JSONObject jSONObject) {
        zzaki.zzb(this, str, jSONObject);
    }

    public final synchronized void zzba(boolean z) {
        this.f11298x = z;
    }

    public final synchronized void zzbb(boolean z) {
        zze zze;
        int i = this.f11262F + (z ? 1 : -1);
        this.f11262F = i;
        if (i <= 0 && (zze = this.f11291q) != null) {
            zze.zzvl();
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void zzbd(boolean z) {
        if (!z) {
            m7033l();
            this.f11270N.zzza();
            zze zze = this.f11291q;
            if (zze != null) {
                zze.close();
                this.f11291q.onDestroy();
                this.f11291q = null;
            }
        }
        this.f11271O.set((Object) null);
        this.f11279e.destroy();
        zzp.zzlm();
        zzbcu.zzc(this);
        m7032k();
    }

    public final void zzbx(Context context) {
        this.f11278d.setBaseContext(context);
        this.f11270N.zzj(this.f11278d.zzaaj());
    }

    public final boolean zzc(boolean z, int i) {
        destroy();
        this.f11286l.zza((zztv) new C2431t9(z, i));
        this.f11286l.zza(zztu.zza.C3991zza.ANDROID_WEBVIEW_CRASH);
        return true;
    }

    public final synchronized void zzcy(String str) {
        if (!isDestroyed()) {
            super.zzcy(str);
        } else {
            zzaza.zzfa("The webview is destroyed. Ignoring action.");
        }
    }

    public final synchronized void zzdq(int i) {
        this.f11268L = i;
    }

    public final void zzdv(int i) {
        if (i == 0) {
            zzabn.zza(this.f11267K.zzry(), this.f11265I, "aebb2");
        }
        m7028g();
        if (this.f11267K.zzry() != null) {
            this.f11267K.zzry().zzh("close_type", String.valueOf(i));
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put(MediationMetaData.KEY_VERSION, this.f11282h.zzbrf);
        zzaki.zza((zzakj) this, "onhide", (Map) hashMap);
    }

    public final synchronized zzbcx zzff(String str) {
        Map<String, zzbcx> map = this.f11276T;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public final void zzj(String str, String str2) {
        zzaki.zza((zzakj) this, str, str2);
    }

    public final synchronized void zzkm() {
        zzk zzk = this.f11283i;
        if (zzk != null) {
            zzk.zzkm();
        }
    }

    public final synchronized void zzkn() {
        zzk zzk = this.f11283i;
        if (zzk != null) {
            zzk.zzkn();
        }
    }

    public final void zzvj() {
        if (this.f11264H == null) {
            zzabn.zza(this.f11267K.zzry(), this.f11265I, "aes2");
            zzabq zzb = zzabn.zzb(this.f11267K.zzry());
            this.f11264H = zzb;
            this.f11267K.zza("native:view_show", zzb);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put(MediationMetaData.KEY_VERSION, this.f11282h.zzbrf);
        zzaki.zza((zzakj) this, "onshow", (Map) hashMap);
    }

    public final void zzvk() {
        zze zzaco = zzaco();
        if (zzaco != null) {
            zzaco.zzvk();
        }
    }

    public final synchronized void zzb(zze zze) {
        this.f11269M = zze;
    }

    public final synchronized void zza(zze zze) {
        this.f11291q = zze;
    }

    public final void zzb(boolean z, int i) {
        this.f11279e.zzb(z, i);
    }

    public final synchronized void zza(zzbfn zzbfn) {
        this.f11292r = zzbfn;
        requestLayout();
    }

    public final void zzb(String str, zzahv<? super zzbdv> zzahv) {
        zzbfm zzbfm = this.f11279e;
        if (zzbfm != null) {
            zzbfm.zzb(str, zzahv);
        }
    }

    public final synchronized void zza(String str, zzbcx zzbcx) {
        if (this.f11276T == null) {
            this.f11276T = new HashMap();
        }
        this.f11276T.put(str, zzbcx);
    }

    public final synchronized void zza(zzadx zzadx) {
        this.f11259C = zzadx;
    }

    public final synchronized void zza(zzads zzads) {
        this.f11260D = zzads;
    }

    public final synchronized void zza(zzsc zzsc) {
        this.f11261E = zzsc;
    }

    public final synchronized void zza(zzbep zzbep) {
        if (this.f11300z != null) {
            zzaza.zzey("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.f11300z = zzbep;
        }
    }

    public final void zza(com.google.android.gms.ads.internal.overlay.zzb zzb) {
        this.f11279e.zza(zzb);
    }

    public final void zza(boolean z, int i, String str) {
        this.f11279e.zza(z, i, str);
    }

    public final void zza(boolean z, int i, String str, String str2) {
        this.f11279e.zza(z, i, str, str2);
    }

    public final void zza(zzqv zzqv) {
        boolean z;
        synchronized (this) {
            z = zzqv.zzbqz;
            this.f11257A = z;
        }
        m7034m(z);
    }

    public final void zza(String str, zzahv<? super zzbdv> zzahv) {
        zzbfm zzbfm = this.f11279e;
        if (zzbfm != null) {
            zzbfm.zza(str, zzahv);
        }
    }

    public final void zza(String str, Predicate<zzahv<? super zzbdv>> predicate) {
        zzbfm zzbfm = this.f11279e;
        if (zzbfm != null) {
            zzbfm.zza(str, predicate);
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
        this.f11287m.zza(activity, this);
        this.f11287m.zzc(str, str2);
        if (viewGroup != null) {
            viewGroup.addView(this.f11287m.getView());
        } else {
            zzaza.zzey("The FrameLayout object cannot be null.");
        }
    }

    public final void zza(zzdmu zzdmu, zzdmz zzdmz) {
        this.f11289o = zzdmu;
        this.f11290p = zzdmz;
    }
}
