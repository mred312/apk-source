package com.google.android.gms.internal.ads;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzaqu {

    /* renamed from: a */
    private final zzbdv f12647a;

    /* renamed from: b */
    private final String f12648b;

    public zzaqu(zzbdv zzbdv) {
        this(zzbdv, "");
    }

    public final void zza(int i, int i2, int i3, int i4) {
        try {
            this.f12647a.zzb("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzaza.zzc("Error occurred while dispatching size change.", e);
        }
    }

    public final void zzb(int i, int i2, int i3, int i4) {
        try {
            this.f12647a.zzb("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzaza.zzc("Error occurred while dispatching default position.", e);
        }
    }

    public final void zzdt(String str) {
        try {
            JSONObject put = new JSONObject().put("message", str).put("action", this.f12648b);
            zzbdv zzbdv = this.f12647a;
            if (zzbdv != null) {
                zzbdv.zzb("onError", put);
            }
        } catch (JSONException e) {
            zzaza.zzc("Error occurred while dispatching error event.", e);
        }
    }

    public final void zzdu(String str) {
        try {
            this.f12647a.zzb("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e) {
            zzaza.zzc("Error occurred while dispatching ready Event.", e);
        }
    }

    public final void zzdv(String str) {
        try {
            this.f12647a.zzb("onStateChanged", new JSONObject().put(RemoteConfigConstants.ResponseFieldKey.STATE, str));
        } catch (JSONException e) {
            zzaza.zzc("Error occurred while dispatching state change.", e);
        }
    }

    public zzaqu(zzbdv zzbdv, String str) {
        this.f12647a = zzbdv;
        this.f12648b = str;
    }

    public final void zza(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.f12647a.zzb("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", (double) f).put("rotation", i5));
        } catch (JSONException e) {
            zzaza.zzc("Error occurred while obtaining screen information.", e);
        }
    }
}
