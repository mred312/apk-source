package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzbq;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcbb implements zzccm {

    /* renamed from: a */
    private final Context f13938a;

    /* renamed from: b */
    private final zzccl f13939b;

    /* renamed from: c */
    private final JSONObject f13940c;

    /* renamed from: d */
    private final zzcgh f13941d;

    /* renamed from: e */
    private final zzcce f13942e;

    /* renamed from: f */
    private final zzef f13943f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final zzbsl f13944g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final zzbrt f13945h;

    /* renamed from: i */
    private final zzdmu f13946i;

    /* renamed from: j */
    private final zzazh f13947j;

    /* renamed from: k */
    private final zzdnn f13948k;

    /* renamed from: l */
    private final zzbki f13949l;

    /* renamed from: m */
    private final zzcdd f13950m;

    /* renamed from: n */
    private final Clock f13951n;

    /* renamed from: o */
    private final zzbxx f13952o;

    /* renamed from: p */
    private final zzdrz f13953p;

    /* renamed from: q */
    private boolean f13954q = false;

    /* renamed from: r */
    private boolean f13955r;

    /* renamed from: s */
    private boolean f13956s = false;

    /* renamed from: t */
    private boolean f13957t = false;

    /* renamed from: u */
    private Point f13958u = new Point();

    /* renamed from: v */
    private Point f13959v = new Point();

    /* renamed from: w */
    private long f13960w = 0;

    /* renamed from: x */
    private long f13961x = 0;

    /* renamed from: y */
    private zzxz f13962y;

    public zzcbb(Context context, zzccl zzccl, JSONObject jSONObject, zzcgh zzcgh, zzcce zzcce, zzef zzef, zzbsl zzbsl, zzbrt zzbrt, zzdmu zzdmu, zzazh zzazh, zzdnn zzdnn, zzbki zzbki, zzcdd zzcdd, Clock clock, zzbxx zzbxx, zzdrz zzdrz) {
        this.f13938a = context;
        this.f13939b = zzccl;
        this.f13940c = jSONObject;
        this.f13941d = zzcgh;
        this.f13942e = zzcce;
        this.f13943f = zzef;
        this.f13944g = zzbsl;
        this.f13945h = zzbrt;
        this.f13946i = zzdmu;
        this.f13947j = zzazh;
        this.f13948k = zzdnn;
        this.f13949l = zzbki;
        this.f13950m = zzcdd;
        this.f13951n = clock;
        this.f13952o = zzbxx;
        this.f13953p = zzdrz;
    }

    @VisibleForTesting
    /* renamed from: b */
    private final void m7902b(@Nullable View view, @Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2, @Nullable JSONObject jSONObject3, @Nullable JSONObject jSONObject4, @Nullable String str, @Nullable JSONObject jSONObject5, @Nullable JSONObject jSONObject6, boolean z, boolean z2) {
        Preconditions.checkMainThread("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("ad", this.f13940c);
            jSONObject7.put("asset_view_signal", jSONObject2);
            jSONObject7.put("ad_view_signal", jSONObject);
            jSONObject7.put("click_signal", jSONObject5);
            jSONObject7.put("scroll_view_signal", jSONObject3);
            jSONObject7.put("lock_screen_signal", jSONObject4);
            boolean z3 = false;
            jSONObject7.put("has_custom_click_handler", this.f13939b.zzgb(this.f13942e.getCustomTemplateId()) != null);
            jSONObject7.put("provided_signals", jSONObject6);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("asset_id", str);
            jSONObject8.put("template", this.f13942e.zzanc());
            jSONObject8.put("view_aware_api_used", z);
            zzadz zzadz = this.f13948k.zzdnh;
            jSONObject8.put("custom_mute_requested", zzadz != null && zzadz.zzbnr);
            jSONObject8.put("custom_mute_enabled", !this.f13942e.getMuteThisAdReasons().isEmpty() && this.f13942e.zzanf() != null);
            if (this.f13950m.zzaol() != null && this.f13940c.optBoolean("custom_one_point_five_click_enabled", false)) {
                jSONObject8.put("custom_one_point_five_click_eligible", true);
            }
            jSONObject8.put("timestamp", this.f13951n.currentTimeMillis());
            if (this.f13957t && m7904d()) {
                jSONObject8.put("custom_click_gesture_eligible", true);
            }
            if (z2) {
                jSONObject8.put("is_custom_click_gesture", true);
            }
            if (this.f13939b.zzgb(this.f13942e.getCustomTemplateId()) != null) {
                z3 = true;
            }
            jSONObject8.put("has_custom_click_handler", z3);
            jSONObject8.put("click_signals", m7908h(view));
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzctq)).booleanValue()) {
                jSONObject8.put("open_chrome_custom_tab", true);
            }
            jSONObject7.put("click", jSONObject8);
            JSONObject jSONObject9 = new JSONObject();
            long currentTimeMillis = this.f13951n.currentTimeMillis();
            jSONObject9.put("time_from_last_touch_down", currentTimeMillis - this.f13960w);
            jSONObject9.put("time_from_last_touch", currentTimeMillis - this.f13961x);
            jSONObject7.put("touch_signal", jSONObject9);
            zzazm.zza(this.f13941d.zzc("google.afma.nativeAds.handleClick", jSONObject7), "Error during performing handleClick");
        } catch (JSONException e) {
            zzaza.zzc("Unable to create click JSON.", e);
        }
    }

    /* renamed from: c */
    private final boolean m7903c(@Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2, @Nullable JSONObject jSONObject3, @Nullable JSONObject jSONObject4, @Nullable String str, @Nullable JSONObject jSONObject5, boolean z) {
        Preconditions.checkMainThread("recordImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("ad", this.f13940c);
            jSONObject6.put("asset_view_signal", jSONObject2);
            jSONObject6.put("ad_view_signal", jSONObject);
            jSONObject6.put("scroll_view_signal", jSONObject3);
            jSONObject6.put("lock_screen_signal", jSONObject4);
            jSONObject6.put("provided_signals", jSONObject5);
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcrp)).booleanValue()) {
                jSONObject6.put("view_signals", str);
            }
            jSONObject6.put("policy_validator_enabled", z);
            jSONObject6.put("screen", zzbq.zzbm(this.f13938a));
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzczf)).booleanValue()) {
                this.f13941d.zza("/clickRecorded", (zzahv<Object>) new C1879eh(this));
            } else {
                this.f13941d.zza("/logScionEvent", (zzahv<Object>) new C1768bh(this));
            }
            this.f13941d.zza("/nativeImpression", (zzahv<Object>) new C1842dh(this));
            zzazm.zza(this.f13941d.zzc("google.afma.nativeAds.handleImpression", jSONObject6), "Error during performing handleImpression");
            boolean z2 = this.f13954q;
            if (z2 || this.f13946i.zzhhc == null) {
                return true;
            }
            this.f13954q = z2 | zzp.zzla().zzb(this.f13938a, this.f13947j.zzbrf, this.f13946i.zzhhc.toString(), this.f13948k.zzhip);
            return true;
        } catch (JSONException e) {
            zzaza.zzc("Unable to create impression JSON.", e);
            return false;
        }
    }

    /* renamed from: d */
    private final boolean m7904d() {
        return this.f13940c.optBoolean("allow_custom_click_gesture", false);
    }

    @Nullable
    /* renamed from: f */
    private final String m7906f(@Nullable View view, @Nullable Map<String, WeakReference<View>> map) {
        if (!(map == null || view == null)) {
            for (Map.Entry next : map.entrySet()) {
                if (view.equals((View) ((WeakReference) next.getValue()).get())) {
                    return (String) next.getKey();
                }
            }
        }
        int zzanc = this.f13942e.zzanc();
        if (zzanc == 1) {
            return "1099";
        }
        if (zzanc == 2) {
            return "2099";
        }
        if (zzanc != 6) {
            return null;
        }
        return "3099";
    }

    /* renamed from: g */
    private final boolean m7907g(String str) {
        JSONObject optJSONObject = this.f13940c.optJSONObject("allow_pub_event_reporting");
        if (optJSONObject == null || !optJSONObject.optBoolean(str, false)) {
            return false;
        }
        return true;
    }

    /* renamed from: h */
    private final String m7908h(View view) {
        try {
            JSONObject optJSONObject = this.f13940c.optJSONObject("tracking_urls_and_actions");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            return this.f13943f.zzca().zza(this.f13938a, optJSONObject.optString("click_string"), view);
        } catch (Exception e) {
            zzaza.zzc("Exception obtaining click signals", e);
            return null;
        }
    }

    /* renamed from: i */
    private final String m7909i(View view) {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcrp)).booleanValue()) {
            return null;
        }
        try {
            return this.f13943f.zzca().zza(this.f13938a, view, (Activity) null);
        } catch (Exception unused) {
            zzaza.zzey("Exception getting data.");
            return null;
        }
    }

    public final void cancelUnconfirmedClick() {
        if (this.f13940c.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.f13950m.cancelUnconfirmedClick();
        }
    }

    public final void destroy() {
        this.f13941d.destroy();
    }

    public final boolean isCustomClickGestureEnabled() {
        return m7904d();
    }

    public final void setClickConfirmingView(View view) {
        if (!this.f13940c.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzaza.zzfa("setClickConfirmingView: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
            return;
        }
        zzcdd zzcdd = this.f13950m;
        if (view != null) {
            view.setOnClickListener(zzcdd);
            view.setClickable(true);
            zzcdd.f14130g = new WeakReference<>(view);
        }
    }

    public final void zza(View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        this.f13958u = new Point();
        this.f13959v = new Point();
        if (!this.f13955r) {
            this.f13952o.zzv(view);
            this.f13955r = true;
        }
        view.setOnTouchListener(onTouchListener);
        view.setClickable(true);
        view.setOnClickListener(onClickListener);
        this.f13949l.zzo(this);
        boolean zzdi = zzbq.zzdi(this.f13947j.zzegm);
        if (map != null) {
            for (Map.Entry<String, WeakReference<View>> value : map.entrySet()) {
                View view2 = (View) ((WeakReference) value.getValue()).get();
                if (view2 != null) {
                    if (zzdi) {
                        view2.setOnTouchListener(onTouchListener);
                    }
                    view2.setClickable(true);
                    view2.setOnClickListener(onClickListener);
                }
            }
        }
        if (map2 != null) {
            for (Map.Entry<String, WeakReference<View>> value2 : map2.entrySet()) {
                View view3 = (View) ((WeakReference) value2.getValue()).get();
                if (view3 != null) {
                    if (zzdi) {
                        view3.setOnTouchListener(onTouchListener);
                    }
                    view3.setClickable(false);
                }
            }
        }
    }

    public final void zzamr() {
        m7903c((JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (String) null, (JSONObject) null, false);
    }

    public final void zzams() {
        try {
            zzxz zzxz = this.f13962y;
            if (zzxz != null) {
                zzxz.onAdMuted();
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zzamt() {
        Preconditions.checkMainThread("recordDownloadedImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.f13940c);
            zzazm.zza(this.f13941d.zzc("google.afma.nativeAds.handleDownloadedImpression", jSONObject), "Error during performing handleDownloadedImpression");
        } catch (JSONException e) {
            zzaza.zzc("", e);
        }
    }

    public final void zzb(@Nullable View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2) {
        m7903c(zzbq.zza(this.f13938a, view), zzbq.zza(this.f13938a, map, map2, view), zzbq.zzt(view), zzbq.zzb(this.f13938a, view), m7909i(view), (JSONObject) null, zzbq.zza(this.f13938a, this.f13946i));
    }

    public final void zzf(@Nullable Bundle bundle) {
        if (bundle == null) {
            zzaza.zzeb("Click data is null. No click is reported.");
        } else if (!m7907g("click_reporting")) {
            zzaza.zzey("The ad slot cannot handle external click events. You must be whitelisted to be able to report your click events.");
        } else {
            Bundle bundle2 = bundle.getBundle("click_signal");
            m7902b((View) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, bundle2 != null ? bundle2.getString("asset_id") : null, (JSONObject) null, zzp.zzkq().zza(bundle, (JSONObject) null), false, false);
        }
    }

    public final void zzfw(String str) {
        m7902b((View) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, str, (JSONObject) null, (JSONObject) null, false, false);
    }

    public final void zzg(@Nullable Bundle bundle) {
        if (bundle == null) {
            zzaza.zzeb("Touch event data is null. No touch event is reported.");
        } else if (!m7907g("touch_reporting")) {
            zzaza.zzey("The ad slot cannot handle external touch events. You must be whitelisted to be able to report your touch events.");
        } else {
            int i = bundle.getInt("duration_ms");
            this.f13943f.zzca().zza((int) bundle.getFloat("x"), (int) bundle.getFloat("y"), i);
        }
    }

    public final boolean zzh(Bundle bundle) {
        if (!m7907g("impression_reporting")) {
            zzaza.zzey("The ad slot cannot handle external impression events. You must be whitelisted to whitelisted to be able to report your impression events.");
            return false;
        }
        return m7903c((JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (String) null, zzp.zzkq().zza(bundle, (JSONObject) null), false);
    }

    public final void zztg() {
        this.f13957t = true;
    }

    public final void zza(View view, @Nullable Map<String, WeakReference<View>> map) {
        this.f13958u = new Point();
        this.f13959v = new Point();
        this.f13952o.zzw(view);
        this.f13955r = false;
    }

    public final void zza(View view, @Nullable View view2, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, boolean z) {
        View view3 = view2;
        Map<String, WeakReference<View>> map3 = map;
        JSONObject zza = zzbq.zza(this.f13938a, map, map2, view2);
        JSONObject zza2 = zzbq.zza(this.f13938a, view2);
        JSONObject zzt = zzbq.zzt(view2);
        JSONObject zzb = zzbq.zzb(this.f13938a, view2);
        View view4 = view;
        String f = m7906f(view, map);
        m7902b(((Boolean) zzwq.zzqe().zzd(zzabf.zzcrq)).booleanValue() ? view3 : view4, zza2, zza, zzt, zzb, f, zzbq.zza(f, this.f13938a, this.f13959v, this.f13958u), (JSONObject) null, z, false);
    }

    public final void zza(@Nullable View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, boolean z) {
        View view2 = view;
        Map<String, WeakReference<View>> map3 = map;
        if (!this.f13957t) {
            zzaza.zzeb("Custom click reporting failed. enableCustomClickGesture is not set.");
        } else if (!m7904d()) {
            zzaza.zzeb("Custom click reporting failed. Ad unit id not whitelisted.");
        } else {
            Map<String, WeakReference<View>> map4 = map2;
            JSONObject zza = zzbq.zza(this.f13938a, map, map2, view);
            JSONObject zza2 = zzbq.zza(this.f13938a, view);
            JSONObject zzt = zzbq.zzt(view);
            JSONObject zzb = zzbq.zzb(this.f13938a, view);
            String f = m7906f((View) null, map);
            m7902b(view, zza2, zza, zzt, zzb, f, zzbq.zza(f, this.f13938a, this.f13959v, this.f13958u), (JSONObject) null, z, true);
        }
    }

    public final void zza(@Nullable View view, MotionEvent motionEvent, @Nullable View view2) {
        this.f13958u = zzbq.zza(motionEvent, view2);
        long currentTimeMillis = this.f13951n.currentTimeMillis();
        this.f13961x = currentTimeMillis;
        if (motionEvent.getAction() == 0) {
            this.f13960w = currentTimeMillis;
            this.f13959v = this.f13958u;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        Point point = this.f13958u;
        obtain.setLocation((float) point.x, (float) point.y);
        this.f13943f.zza(obtain);
        obtain.recycle();
    }

    @Nullable
    public final JSONObject zza(@Nullable View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2) {
        JSONObject zza = zzbq.zza(this.f13938a, map, map2, view);
        JSONObject zza2 = zzbq.zza(this.f13938a, view);
        JSONObject zzt = zzbq.zzt(view);
        JSONObject zzb = zzbq.zzb(this.f13938a, view);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("asset_view_signal", zza);
            jSONObject.put("ad_view_signal", zza2);
            jSONObject.put("scroll_view_signal", zzt);
            jSONObject.put("lock_screen_signal", zzb);
            return jSONObject;
        } catch (JSONException e) {
            zzaza.zzc("Unable to create native ad view signals JSON.", e);
            return null;
        }
    }

    public final void zza(zzage zzage) {
        if (!this.f13940c.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzaza.zzfa("setUnconfirmedClickListener: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
        } else {
            this.f13950m.zza(zzage);
        }
    }

    public final void zza(@Nullable zzyd zzyd) {
        try {
            if (!this.f13956s) {
                if (zzyd != null || this.f13942e.zzanf() == null) {
                    this.f13956s = true;
                    this.f13953p.zzeo(zzyd.zzqo());
                    zzams();
                    return;
                }
                this.f13956s = true;
                this.f13953p.zzeo(this.f13942e.zzanf().zzqo());
                zzams();
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzxz zzxz) {
        this.f13962y = zzxz;
    }
}
