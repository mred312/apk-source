package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.gms.ads.internal.util.zzbq;
import com.google.android.gms.ads.internal.zza;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcdq {

    /* renamed from: a */
    private final zzchp f14150a;

    /* renamed from: b */
    private final zzcgh f14151b;

    /* renamed from: c */
    private ViewTreeObserver.OnScrollChangedListener f14152c = null;

    public zzcdq(zzchp zzchp, zzcgh zzcgh) {
        this.f14150a = zzchp;
        this.f14151b = zzcgh;
    }

    /* renamed from: a */
    private static int m7933a(Context context, String str, int i) {
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
        zzwq.zzqa();
        return zzayr.zzc(context, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo16710b(View view, WindowManager windowManager, zzbdv zzbdv, Map map) {
        int i;
        zzbdv.zzacs().zza((zzbfj) new C1806ci(this, map));
        if (map != null) {
            Context context = view.getContext();
            int a = m7933a(context, (String) map.get("validator_width"), ((Integer) zzwq.zzqe().zzd(zzabf.zzcyl)).intValue());
            int a2 = m7933a(context, (String) map.get("validator_height"), ((Integer) zzwq.zzqe().zzd(zzabf.zzcym)).intValue());
            int a3 = m7933a(context, (String) map.get("validator_x"), 0);
            int a4 = m7933a(context, (String) map.get("validator_y"), 0);
            zzbdv.zza(zzbfn.zzq(a, a2));
            try {
                zzbdv.getWebView().getSettings().setUseWideViewPort(((Boolean) zzwq.zzqe().zzd(zzabf.zzcyn)).booleanValue());
                zzbdv.getWebView().getSettings().setLoadWithOverviewMode(((Boolean) zzwq.zzqe().zzd(zzabf.zzcyo)).booleanValue());
            } catch (NullPointerException unused) {
            }
            WindowManager.LayoutParams zzyx = zzbq.zzyx();
            zzyx.x = a3;
            zzyx.y = a4;
            windowManager.updateViewLayout(zzbdv.getView(), zzyx);
            String str = (String) map.get(AdUnitActivity.EXTRA_ORIENTATION);
            Rect rect = new Rect();
            if (view.getGlobalVisibleRect(rect)) {
                if ("1".equals(str) || "2".equals(str)) {
                    i = rect.bottom;
                } else {
                    i = rect.top;
                }
                this.f14152c = new C1732ai(view, zzbdv, str, zzyx, i - a4, windowManager);
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnScrollChangedListener(this.f14152c);
                }
            }
            String str2 = (String) map.get("overlay_url");
            if (!TextUtils.isEmpty(str2)) {
                zzbdv.loadUrl(str2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ void mo16711c(WindowManager windowManager, View view, zzbdv zzbdv, Map map) {
        zzaza.zzeb("Hide native ad policy validator overlay.");
        zzbdv.getView().setVisibility(8);
        if (zzbdv.getView().getWindowToken() != null) {
            windowManager.removeView(zzbdv.getView());
        }
        zzbdv.destroy();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (this.f14152c != null && viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this.f14152c);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ void mo16712d(Map map, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "validatorHtmlLoaded");
        hashMap.put(FacebookAdapter.KEY_ID, (String) map.get(FacebookAdapter.KEY_ID));
        this.f14151b.zza("sendMessageToNativeJs", (Map<String, ?>) hashMap);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final /* synthetic */ void mo16713e(zzbdv zzbdv, Map map) {
        this.f14151b.zza("sendMessageToNativeJs", (Map<String, ?>) map);
    }

    public final View zza(@NonNull View view, @NonNull WindowManager windowManager) {
        zzbdv zzd = this.f14150a.zzd(zzvn.zzpo());
        zzd.getView().setVisibility(4);
        zzd.getView().setContentDescription("policy_validator");
        zzd.zza("/sendMessageToSdk", (zzahv<? super zzbdv>) new C2588xh(this));
        zzd.zza("/hideValidatorOverlay", (zzahv<? super zzbdv>) new C2663zh(this, windowManager, view));
        zzd.zza("/open", (zzahv<? super zzbdv>) new zzahz((zza) null, (zzaqk) null, (zzcqo) null, (zzckq) null));
        this.f14151b.zza(new WeakReference(zzd), "/loadNativeAdPolicyViolations", new C2626yh(this, view, windowManager));
        this.f14151b.zza(new WeakReference(zzd), "/showValidatorOverlay", C1769bi.f7920a);
        return zzd.getView();
    }
}
