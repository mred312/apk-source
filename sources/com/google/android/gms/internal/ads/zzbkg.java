package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzad;
import com.google.android.gms.ads.internal.zzp;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbkg implements zzame<zzbkk> {

    /* renamed from: a */
    private final Context f13398a;

    /* renamed from: b */
    private final zzqr f13399b;

    /* renamed from: c */
    private final PowerManager f13400c;

    public zzbkg(Context context, zzqr zzqr) {
        this.f13398a = context;
        this.f13399b = zzqr;
        this.f13400c = (PowerManager) context.getSystemService("power");
    }

    /* renamed from: zza */
    public final JSONObject zzj(zzbkk zzbkk) {
        JSONObject jSONObject;
        boolean z;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        zzqv zzqv = zzbkk.zzfrj;
        if (zzqv == null) {
            jSONObject = new JSONObject();
        } else if (this.f13399b.zzlw() != null) {
            boolean z2 = zzqv.zzbrl;
            JSONObject jSONObject3 = new JSONObject();
            JSONObject put = jSONObject3.put("afmaVersion", this.f13399b.zzlv()).put("activeViewJSON", this.f13399b.zzlw()).put("timestamp", zzbkk.timestamp).put("adFormat", this.f13399b.zzlu()).put("hashCode", this.f13399b.getUniqueId()).put("isMraid", false).put("isStopped", false).put("isPaused", zzbkk.zzfrg).put("isNative", this.f13399b.isNative());
            if (Build.VERSION.SDK_INT >= 20) {
                z = this.f13400c.isInteractive();
            } else {
                z = this.f13400c.isScreenOn();
            }
            put.put("isScreenOn", z).put("appMuted", zzp.zzkv().zzql()).put("appVolume", (double) zzp.zzkv().zzqk()).put("deviceVolume", (double) zzad.zzbi(this.f13398a.getApplicationContext()));
            Rect rect = new Rect();
            Display defaultDisplay = ((WindowManager) this.f13398a.getSystemService("window")).getDefaultDisplay();
            rect.right = defaultDisplay.getWidth();
            rect.bottom = defaultDisplay.getHeight();
            jSONObject3.put("windowVisibility", zzqv.zzaai).put("isAttachedToWindow", z2).put("viewBox", new JSONObject().put("top", zzqv.zzbrm.top).put("bottom", zzqv.zzbrm.bottom).put("left", zzqv.zzbrm.left).put("right", zzqv.zzbrm.right)).put("adBox", new JSONObject().put("top", zzqv.zzbrn.top).put("bottom", zzqv.zzbrn.bottom).put("left", zzqv.zzbrn.left).put("right", zzqv.zzbrn.right)).put("globalVisibleBox", new JSONObject().put("top", zzqv.zzbro.top).put("bottom", zzqv.zzbro.bottom).put("left", zzqv.zzbro.left).put("right", zzqv.zzbro.right)).put("globalVisibleBoxVisible", zzqv.zzbrp).put("localVisibleBox", new JSONObject().put("top", zzqv.zzbrq.top).put("bottom", zzqv.zzbrq.bottom).put("left", zzqv.zzbrq.left).put("right", zzqv.zzbrq.right)).put("localVisibleBoxVisible", zzqv.zzbrr).put("hitBox", new JSONObject().put("top", zzqv.zzbrs.top).put("bottom", zzqv.zzbrs.bottom).put("left", zzqv.zzbrs.left).put("right", zzqv.zzbrs.right)).put("screenDensity", (double) this.f13398a.getResources().getDisplayMetrics().density);
            jSONObject3.put("isVisible", zzbkk.zzbqz);
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcpx)).booleanValue()) {
                JSONArray jSONArray2 = new JSONArray();
                List<Rect> list = zzqv.zzbru;
                if (list != null) {
                    for (Rect next : list) {
                        jSONArray2.put(new JSONObject().put("top", next.top).put("bottom", next.bottom).put("left", next.left).put("right", next.right));
                    }
                }
                jSONObject3.put("scrollableContainerBoxes", jSONArray2);
            }
            if (!TextUtils.isEmpty(zzbkk.zzfri)) {
                jSONObject3.put("doneReasonCode", "u");
            }
            jSONObject = jSONObject3;
        } else {
            throw new JSONException("Active view Info cannot be null.");
        }
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }
}
