package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(14)
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzrk extends Thread {

    /* renamed from: a */
    private boolean f16939a;

    /* renamed from: b */
    private boolean f16940b;

    /* renamed from: c */
    private final Object f16941c;

    /* renamed from: d */
    private final zzrh f16942d;

    /* renamed from: e */
    private final int f16943e;

    /* renamed from: f */
    private final int f16944f;

    /* renamed from: g */
    private final int f16945g;

    /* renamed from: h */
    private final int f16946h;

    /* renamed from: i */
    private final int f16947i;

    /* renamed from: j */
    private final int f16948j;

    /* renamed from: k */
    private final int f16949k;

    /* renamed from: l */
    private final int f16950l;

    /* renamed from: m */
    private final String f16951m;

    /* renamed from: n */
    private final boolean f16952n;

    /* renamed from: o */
    private final boolean f16953o;

    /* renamed from: p */
    private final boolean f16954p;

    public zzrk() {
        this(new zzrh());
    }

    @VisibleForTesting
    /* renamed from: a */
    private final rh0 m9082a(@Nullable View view, zzre zzre) {
        boolean z;
        if (view == null) {
            return new rh0(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new rh0(this, 0, 0);
            }
            zzre.zzb(text.toString(), globalVisibleRect, view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
            return new rh0(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof zzbdv)) {
            WebView webView = (WebView) view;
            if (!PlatformVersion.isAtLeastKitKat()) {
                z = false;
            } else {
                zzre.zzmd();
                webView.post(new ph0(this, zzre, webView, globalVisibleRect));
                z = true;
            }
            if (z) {
                return new rh0(this, 0, 1);
            }
            return new rh0(this, 0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new rh0(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                rh0 a = m9082a(viewGroup.getChildAt(i3), zzre);
                i += a.f10802a;
                i2 += a.f10803b;
            }
            return new rh0(this, i, i2);
        }
    }

    @VisibleForTesting
    /* renamed from: d */
    private static boolean m9083d() {
        boolean z;
        try {
            Context context = zzp.zzkt().getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null) {
                return false;
            }
            if (keyguardManager == null) {
                return false;
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (Process.myPid() == next.pid) {
                    if (next.importance != 100 || keyguardManager.inKeyguardRestrictedInputMode()) {
                        return false;
                    }
                    PowerManager powerManager = (PowerManager) context.getSystemService("power");
                    if (powerManager == null) {
                        z = false;
                    } else {
                        z = powerManager.isScreenOn();
                    }
                    if (z) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            zzp.zzku().zza(th, "ContentFetchTask.isInForeground");
            return false;
        }
    }

    /* renamed from: e */
    private final void m9084e() {
        synchronized (this.f16941c) {
            this.f16940b = true;
            StringBuilder sb = new StringBuilder(42);
            sb.append("ContentFetchThread: paused, mPause = ");
            sb.append(true);
            zzaza.zzeb(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: b */
    public final void mo18193b(zzre zzre, WebView webView, String str, boolean z) {
        zzre.zzmc();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (this.f16952n || TextUtils.isEmpty(webView.getTitle())) {
                    zzre.zza(optString, z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                } else {
                    String title = webView.getTitle();
                    StringBuilder sb = new StringBuilder(String.valueOf(title).length() + 1 + String.valueOf(optString).length());
                    sb.append(title);
                    sb.append("\n");
                    sb.append(optString);
                    zzre.zza(sb.toString(), z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                }
            }
            if (zzre.zzlx()) {
                this.f16942d.zzb(zzre);
            }
        } catch (JSONException unused) {
            zzaza.zzeb("Json string may be malformed.");
        } catch (Throwable th) {
            zzaza.zzb("Failed to get webview content.", th);
            zzp.zzku().zza(th, "ContentFetchTask.processWebViewContent");
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: c */
    public final void mo18194c(View view) {
        try {
            zzre zzre = new zzre(this.f16944f, this.f16945g, this.f16946h, this.f16947i, this.f16948j, this.f16949k, this.f16950l, this.f16953o);
            Context context = zzp.zzkt().getContext();
            if (context != null && !TextUtils.isEmpty(this.f16951m)) {
                String str = (String) view.getTag(context.getResources().getIdentifier((String) zzwq.zzqe().zzd(zzabf.zzcng), FacebookAdapter.KEY_ID, context.getPackageName()));
                if (str != null && str.equals(this.f16951m)) {
                    return;
                }
            }
            rh0 a = m9082a(view, zzre);
            zzre.zzmf();
            if (a.f10802a != 0 || a.f10803b != 0) {
                if (a.f10803b != 0 || zzre.mo18167d() != 0) {
                    if (a.f10803b != 0 || !this.f16942d.zza(zzre)) {
                        this.f16942d.zzc(zzre);
                    }
                }
            }
        } catch (Exception e) {
            zzaza.zzc("Exception in fetchContentOnUIThread", e);
            zzp.zzku().zza(e, "ContentFetchTask.fetchContent");
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0084 */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0084 A[LOOP:1: B:30:0x0084->B:42:0x0084, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r4 = this;
        L_0x0000:
            boolean r0 = m9083d()     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            if (r0 == 0) goto L_0x005a
            com.google.android.gms.internal.ads.zzrg r0 = com.google.android.gms.ads.internal.zzp.zzkt()     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            android.app.Activity r0 = r0.getActivity()     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            if (r0 != 0) goto L_0x0019
            java.lang.String r0 = "ContentFetchThread: no activity. Sleeping."
            com.google.android.gms.internal.ads.zzaza.zzeb(r0)     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            r4.m9084e()     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            goto L_0x0062
        L_0x0019:
            if (r0 == 0) goto L_0x0062
            r1 = 0
            android.view.Window r2 = r0.getWindow()     // Catch:{ Exception -> 0x003d }
            if (r2 == 0) goto L_0x004c
            android.view.Window r2 = r0.getWindow()     // Catch:{ Exception -> 0x003d }
            android.view.View r2 = r2.getDecorView()     // Catch:{ Exception -> 0x003d }
            if (r2 == 0) goto L_0x004c
            android.view.Window r0 = r0.getWindow()     // Catch:{ Exception -> 0x003d }
            android.view.View r0 = r0.getDecorView()     // Catch:{ Exception -> 0x003d }
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r0.findViewById(r2)     // Catch:{ Exception -> 0x003d }
            r1 = r0
            goto L_0x004c
        L_0x003d:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzayg r2 = com.google.android.gms.ads.internal.zzp.zzku()     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            java.lang.String r3 = "ContentFetchTask.extractContent"
            r2.zza(r0, r3)     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            java.lang.String r0 = "Failed getting root view of activity. Content not extracted."
            com.google.android.gms.internal.ads.zzaza.zzeb(r0)     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
        L_0x004c:
            if (r1 == 0) goto L_0x0062
            if (r1 != 0) goto L_0x0051
            goto L_0x0062
        L_0x0051:
            com.google.android.gms.internal.ads.qh0 r0 = new com.google.android.gms.internal.ads.qh0     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            r0.<init>(r4, r1)     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            r1.post(r0)     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            goto L_0x0062
        L_0x005a:
            java.lang.String r0 = "ContentFetchTask: sleeping"
            com.google.android.gms.internal.ads.zzaza.zzeb(r0)     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            r4.m9084e()     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
        L_0x0062:
            int r0 = r4.f16943e     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            int r0 = r0 * 1000
            long r0 = (long) r0     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            goto L_0x0081
        L_0x006b:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.internal.ads.zzaza.zzc(r1, r0)
            com.google.android.gms.internal.ads.zzayg r1 = com.google.android.gms.ads.internal.zzp.zzku()
            java.lang.String r2 = "ContentFetchTask.run"
            r1.zza(r0, r2)
            goto L_0x0081
        L_0x007b:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.internal.ads.zzaza.zzc(r1, r0)
        L_0x0081:
            java.lang.Object r0 = r4.f16941c
            monitor-enter(r0)
        L_0x0084:
            boolean r1 = r4.f16940b     // Catch:{ all -> 0x0096 }
            if (r1 == 0) goto L_0x0093
            java.lang.String r1 = "ContentFetchTask: waiting"
            com.google.android.gms.internal.ads.zzaza.zzeb(r1)     // Catch:{ InterruptedException -> 0x0084 }
            java.lang.Object r1 = r4.f16941c     // Catch:{ InterruptedException -> 0x0084 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0084 }
            goto L_0x0084
        L_0x0093:
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            goto L_0x0000
        L_0x0096:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            goto L_0x009a
        L_0x0099:
            throw r1
        L_0x009a:
            goto L_0x0099
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrk.run():void");
    }

    public final void wakeup() {
        synchronized (this.f16941c) {
            this.f16940b = false;
            this.f16941c.notifyAll();
            zzaza.zzeb("ContentFetchThread: wakeup");
        }
    }

    public final void zzmh() {
        synchronized (this.f16941c) {
            if (this.f16939a) {
                zzaza.zzeb("Content hash thread already started, quiting...");
                return;
            }
            this.f16939a = true;
            start();
        }
    }

    public final zzre zzmj() {
        return this.f16942d.zzo(this.f16954p);
    }

    public final boolean zzml() {
        return this.f16940b;
    }

    @VisibleForTesting
    private zzrk(zzrh zzrh) {
        this.f16939a = false;
        this.f16940b = false;
        this.f16942d = zzrh;
        this.f16941c = new Object();
        this.f16944f = zzacv.zzdbv.get().intValue();
        this.f16945g = zzacv.zzdbs.get().intValue();
        this.f16946h = zzacv.zzdbw.get().intValue();
        this.f16947i = zzacv.zzdbu.get().intValue();
        this.f16948j = ((Integer) zzwq.zzqe().zzd(zzabf.zzcnd)).intValue();
        this.f16949k = ((Integer) zzwq.zzqe().zzd(zzabf.zzcne)).intValue();
        this.f16950l = ((Integer) zzwq.zzqe().zzd(zzabf.zzcnf)).intValue();
        this.f16943e = zzacv.zzdbx.get().intValue();
        this.f16951m = (String) zzwq.zzqe().zzd(zzabf.zzcnh);
        this.f16952n = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcni)).booleanValue();
        this.f16953o = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcnj)).booleanValue();
        this.f16954p = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcnk)).booleanValue();
        setName("ContentFetchTask");
    }
}
