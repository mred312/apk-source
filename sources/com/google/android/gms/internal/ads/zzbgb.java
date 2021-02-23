package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzbgb extends C2505v9 implements zzbgc {

    /* renamed from: a */
    private final zzbfz f13245a;
    @GuardedBy("this")

    /* renamed from: b */
    private boolean f13246b;
    @GuardedBy("this")

    /* renamed from: c */
    private boolean f13247c;

    public zzbgb(Context context, zzbfz zzbfz) {
        super(context);
        zzp.zzku().zzww();
        this.f13245a = zzbfz;
        super.setWebViewClient(zzbfz);
    }

    /* renamed from: b */
    private final synchronized void m7751b() {
        if (!this.f13247c) {
            this.f13247c = true;
            zzp.zzku().zzwx();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo16242a() {
        super.destroy();
    }

    public /* bridge */ /* synthetic */ void addJavascriptInterface(Object obj, String str) {
        super.addJavascriptInterface(obj, str);
    }

    public synchronized void destroy() {
        if (!this.f13246b) {
            this.f13246b = true;
            this.f13245a.mo16232a(this);
            zzbd(false);
            zzd.zzee("Initiating WebView self destruct sequence in 3...");
            zzd.zzee("Loading blank page in WebView, 2...");
            try {
                super.loadUrl("about:blank");
            } catch (UnsatisfiedLinkError e) {
                zzp.zzku().zza(e, "AdWebViewImpl.loadUrlUnsafe");
                zzaza.zze("#007 Could not call remote method.", e);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        return;
     */
    @android.annotation.TargetApi(19)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void evaluateJavascript(java.lang.String r2, android.webkit.ValueCallback<java.lang.String> r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.isDestroyed()     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0014
            java.lang.String r2 = "#004 The webview is destroyed. Ignoring action."
            com.google.android.gms.internal.ads.zzaza.zzfa(r2)     // Catch:{ all -> 0x0019 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbgb.evaluateJavascript(java.lang.String, android.webkit.ValueCallback):void");
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        try {
            synchronized (this) {
                if (!isDestroyed()) {
                    zzbd(true);
                }
                m7751b();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    public final synchronized boolean isDestroyed() {
        return this.f13246b;
    }

    public synchronized void loadData(String str, String str2, String str3) {
        if (!isDestroyed()) {
            super.loadData(str, str2, str3);
        } else {
            zzaza.zzfa("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!isDestroyed()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            zzaza.zzfa("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public synchronized void loadUrl(String str) {
        if (!isDestroyed()) {
            super.loadUrl(str);
        } else {
            zzaza.zzfa("#004 The webview is destroyed. Ignoring action.");
        }
    }

    /* access modifiers changed from: protected */
    @TargetApi(21)
    public void onDraw(Canvas canvas) {
        if (!isDestroyed()) {
            super.onDraw(canvas);
        }
    }

    public void onPause() {
        if (!isDestroyed()) {
            super.onPause();
        }
    }

    public void onResume() {
        if (!isDestroyed()) {
            super.onResume();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return !isDestroyed() && super.onTouchEvent(motionEvent);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
    }

    public void stopLoading() {
        if (!isDestroyed()) {
            super.stopLoading();
        }
    }

    public final synchronized void zza(zzbfy zzbfy) {
        zzd.zzee("Blank page loaded, 1...");
        zzacy();
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public synchronized void zzacy() {
        zzd.zzee("Destroying WebView!");
        m7751b();
        zzazj.zzegt.execute(new C2618y9(this));
    }

    /* access modifiers changed from: protected */
    @GuardedBy("this")
    public void zzbd(boolean z) {
    }

    public /* bridge */ /* synthetic */ void zzcy(String str) {
        super.zzcy(str);
    }
}
