package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Message;
import android.support.p000v4.media.session.PlaybackStateCompat;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.PlatformVersion;

@TargetApi(11)
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbdn extends WebChromeClient {

    /* renamed from: a */
    private final zzbdv f13172a;

    public zzbdn(zzbdv zzbdv) {
        this.f13172a = zzbdv;
    }

    /* renamed from: a */
    private static Context m7724a(WebView webView) {
        if (!(webView instanceof zzbdv)) {
            return webView.getContext();
        }
        zzbdv zzbdv = (zzbdv) webView;
        Activity zzaaj = zzbdv.zzaaj();
        if (zzaaj != null) {
            return zzaaj;
        }
        return zzbdv.getContext();
    }

    /* renamed from: b */
    private final boolean m7725b(Context context, String str, String str2, String str3, String str4, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        zza zzabx;
        try {
            zzbdv zzbdv = this.f13172a;
            if (zzbdv == null || zzbdv.zzacs() == null || this.f13172a.zzacs().zzabx() == null || (zzabx = this.f13172a.zzacs().zzabx()) == null || zzabx.zzjy()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(str2);
                if (z) {
                    LinearLayout linearLayout = new LinearLayout(context);
                    linearLayout.setOrientation(1);
                    TextView textView = new TextView(context);
                    textView.setText(str3);
                    EditText editText = new EditText(context);
                    editText.setText(str4);
                    linearLayout.addView(textView);
                    linearLayout.addView(editText);
                    builder.setView(linearLayout).setPositiveButton(17039370, new C2467u8(jsPromptResult, editText)).setNegativeButton(17039360, new C2352r8(jsPromptResult)).setOnCancelListener(new C2389s8(jsPromptResult)).create().show();
                } else {
                    builder.setMessage(str3).setPositiveButton(17039370, new C2278p8(jsResult)).setNegativeButton(17039360, new C2315q8(jsResult)).setOnCancelListener(new C2241o8(jsResult)).create().show();
                }
                return true;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(str3).length());
            sb.append("window.");
            sb.append(str);
            sb.append("('");
            sb.append(str3);
            sb.append("')");
            zzabx.zzbk(sb.toString());
            return false;
        } catch (WindowManager.BadTokenException e) {
            zzaza.zzd("Fail to display Dialog.", e);
        }
    }

    public final void onCloseWindow(WebView webView) {
        if (!(webView instanceof zzbdv)) {
            zzaza.zzfa("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        zze zzaco = ((zzbdv) webView).zzaco();
        if (zzaco == null) {
            zzaza.zzfa("Tried to close an AdWebView not associated with an overlay.");
        } else {
            zzaco.close();
        }
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String message = consoleMessage.message();
        String sourceId = consoleMessage.sourceId();
        int lineNumber = consoleMessage.lineNumber();
        StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 19 + String.valueOf(sourceId).length());
        sb.append("JS: ");
        sb.append(message);
        sb.append(" (");
        sb.append(sourceId);
        sb.append(":");
        sb.append(lineNumber);
        sb.append(")");
        String sb2 = sb.toString();
        if (sb2.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        int i = C2430t8.f11142a[consoleMessage.messageLevel().ordinal()];
        if (i == 1) {
            zzaza.zzey(sb2);
        } else if (i == 2) {
            zzaza.zzfa(sb2);
        } else if (i == 3 || i == 4) {
            zzaza.zzez(sb2);
        } else if (i != 5) {
            zzaza.zzez(sb2);
        } else {
            zzaza.zzeb(sb2);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        if (this.f13172a.zzact() != null) {
            webView2.setWebViewClient(this.f13172a.zzact());
        }
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        long j4 = 5242880 - j3;
        if (j4 <= 0) {
            quotaUpdater.updateQuota(j);
            return;
        }
        if (j != 0) {
            if (j2 == 0) {
                j = Math.min(j + Math.min(PlaybackStateCompat.ACTION_PREPARE_FROM_URI, j4), PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
            } else if (j2 <= Math.min(PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED - j, j4)) {
                j += j2;
            }
            j2 = j;
        } else if (j2 > j4 || j2 > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            j2 = 0;
        }
        quotaUpdater.updateQuota(j2);
    }

    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        boolean z;
        if (callback != null) {
            zzp.zzkq();
            if (!zzm.zzp(this.f13172a.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
                zzp.zzkq();
                if (!zzm.zzp(this.f13172a.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
                    z = false;
                    callback.invoke(str, z, true);
                }
            }
            z = true;
            callback.invoke(str, z, true);
        }
    }

    public final void onHideCustomView() {
        zze zzaco = this.f13172a.zzaco();
        if (zzaco == null) {
            zzaza.zzfa("Could not get ad overlay when hiding custom view.");
        } else {
            zzaco.zzvc();
        }
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return m7725b(m7724a(webView), "alert", str, str2, (String) null, jsResult, (JsPromptResult) null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return m7725b(m7724a(webView), "onBeforeUnload", str, str2, (String) null, jsResult, (JsPromptResult) null, false);
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return m7725b(m7724a(webView), "confirm", str, str2, (String) null, jsResult, (JsPromptResult) null, false);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return m7725b(m7724a(webView), "prompt", str, str2, str3, (JsResult) null, jsPromptResult, true);
    }

    @TargetApi(21)
    public final void onPermissionRequest(PermissionRequest permissionRequest) {
        if (!PlatformVersion.isAtLeastLollipop() || zzadm.zzddu.get().booleanValue()) {
            super.onPermissionRequest(permissionRequest);
            return;
        }
        zzbdv zzbdv = this.f13172a;
        if (zzbdv == null || zzbdv.zzacs() == null || this.f13172a.zzacs().zzack() == null) {
            super.onPermissionRequest(permissionRequest);
            return;
        }
        String[] zza = this.f13172a.zzacs().zzack().zza(permissionRequest.getResources());
        if (zza.length > 0) {
            permissionRequest.grant(zza);
        } else {
            permissionRequest.deny();
        }
    }

    public final void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        long j3 = j + PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        if (5242880 - j2 < j3) {
            quotaUpdater.updateQuota(0);
        } else {
            quotaUpdater.updateQuota(j3);
        }
    }

    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, -1, customViewCallback);
    }

    @Deprecated
    public final void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        zze zzaco = this.f13172a.zzaco();
        if (zzaco == null) {
            zzaza.zzfa("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        zzaco.zza(view, customViewCallback);
        zzaco.setRequestedOrientation(i);
    }
}
