package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcdz implements zzccm {
    @Nullable

    /* renamed from: a */
    private final zzanv f14157a;
    @Nullable

    /* renamed from: b */
    private final zzanw f14158b;
    @Nullable

    /* renamed from: c */
    private final zzaob f14159c;

    /* renamed from: d */
    private final zzbsl f14160d;

    /* renamed from: e */
    private final zzbrt f14161e;

    /* renamed from: f */
    private final Context f14162f;

    /* renamed from: g */
    private final zzdmu f14163g;

    /* renamed from: h */
    private final zzazh f14164h;

    /* renamed from: i */
    private final zzdnn f14165i;

    /* renamed from: j */
    private boolean f14166j = false;

    /* renamed from: k */
    private boolean f14167k = false;

    /* renamed from: l */
    private boolean f14168l = true;

    public zzcdz(@Nullable zzanv zzanv, @Nullable zzanw zzanw, @Nullable zzaob zzaob, zzbsl zzbsl, zzbrt zzbrt, Context context, zzdmu zzdmu, zzazh zzazh, zzdnn zzdnn) {
        this.f14157a = zzanv;
        this.f14158b = zzanw;
        this.f14159c = zzaob;
        this.f14160d = zzbsl;
        this.f14161e = zzbrt;
        this.f14162f = context;
        this.f14163g = zzdmu;
        this.f14164h = zzazh;
        this.f14165i = zzdnn;
    }

    /* renamed from: a */
    private final void m7938a(View view) {
        try {
            zzaob zzaob = this.f14159c;
            if (zzaob == null || zzaob.getOverrideClickHandling()) {
                zzanv zzanv = this.f14157a;
                if (zzanv == null || zzanv.getOverrideClickHandling()) {
                    zzanw zzanw = this.f14158b;
                    if (zzanw != null && !zzanw.getOverrideClickHandling()) {
                        this.f14158b.zzu(ObjectWrapper.wrap(view));
                        this.f14161e.onAdClicked();
                        return;
                    }
                    return;
                }
                this.f14157a.zzu(ObjectWrapper.wrap(view));
                this.f14161e.onAdClicked();
                return;
            }
            this.f14159c.zzu(ObjectWrapper.wrap(view));
            this.f14161e.onAdClicked();
        } catch (RemoteException e) {
            zzaza.zzd("Failed to call handleClick", e);
        }
    }

    /* renamed from: b */
    private static HashMap<String, View> m7939b(Map<String, WeakReference<View>> map) {
        HashMap<String, View> hashMap = new HashMap<>();
        if (map == null) {
            return hashMap;
        }
        synchronized (map) {
            for (Map.Entry next : map.entrySet()) {
                View view = (View) ((WeakReference) next.getValue()).get();
                if (view != null) {
                    hashMap.put((String) next.getKey(), view);
                }
            }
        }
        return hashMap;
    }

    /* renamed from: c */
    private final boolean m7940c(@Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2) {
        View view;
        JSONObject jSONObject = this.f14163g.zzhhr;
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcqi)).booleanValue() && jSONObject.length() != 0) {
            if (map == null) {
                map = new HashMap<>();
            }
            if (map2 == null) {
                map2 = new HashMap<>();
            }
            HashMap hashMap = new HashMap();
            hashMap.putAll(map);
            hashMap.putAll(map2);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray optJSONArray = jSONObject.optJSONArray(next);
                if (optJSONArray != null) {
                    WeakReference weakReference = (WeakReference) hashMap.get(next);
                    if (weakReference == null || (view = (View) weakReference.get()) == null) {
                        return false;
                    }
                    Class<?> cls = view.getClass();
                    try {
                        ArrayList arrayList = new ArrayList();
                        zzbk.zza(optJSONArray, (List<String>) arrayList);
                        zzp.zzkq();
                        if (!zzm.zza(this.f14162f.getClassLoader(), cls, (List<String>) arrayList)) {
                            return false;
                        }
                    } catch (JSONException unused) {
                        continue;
                    }
                }
            }
        }
        return true;
    }

    public final void cancelUnconfirmedClick() {
    }

    public final void destroy() {
    }

    public final boolean isCustomClickGestureEnabled() {
        return this.f14163g.zzdmh;
    }

    public final void setClickConfirmingView(View view) {
    }

    @Nullable
    public final JSONObject zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        return null;
    }

    public final void zza(View view, MotionEvent motionEvent, @Nullable View view2) {
    }

    public final void zza(View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            this.f14168l = m7940c(map, map2);
            HashMap<String, View> b = m7939b(map);
            HashMap<String, View> b2 = m7939b(map2);
            zzaob zzaob = this.f14159c;
            if (zzaob != null) {
                zzaob.zzc(wrap, ObjectWrapper.wrap(b), ObjectWrapper.wrap(b2));
                return;
            }
            zzanv zzanv = this.f14157a;
            if (zzanv != null) {
                zzanv.zzc(wrap, ObjectWrapper.wrap(b), ObjectWrapper.wrap(b2));
                this.f14157a.zzv(wrap);
                return;
            }
            zzanw zzanw = this.f14158b;
            if (zzanw != null) {
                zzanw.zzc(wrap, ObjectWrapper.wrap(b), ObjectWrapper.wrap(b2));
                this.f14158b.zzv(wrap);
            }
        } catch (RemoteException e) {
            zzaza.zzd("Failed to call trackView", e);
        }
    }

    public final void zza(zzage zzage) {
    }

    public final void zzamr() {
    }

    public final void zzams() {
        zzaza.zzfa("Mute This Ad is not supported for 3rd party ads");
    }

    public final void zzamt() {
    }

    public final void zzb(@Nullable View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2) {
        try {
            boolean z = this.f14166j;
            if (!z && this.f14163g.zzhhc != null) {
                this.f14166j = z | zzp.zzla().zzb(this.f14162f, this.f14164h.zzbrf, this.f14163g.zzhhc.toString(), this.f14165i.zzhip);
            }
            if (this.f14168l) {
                zzaob zzaob = this.f14159c;
                if (zzaob == null || zzaob.getOverrideImpressionRecording()) {
                    zzanv zzanv = this.f14157a;
                    if (zzanv == null || zzanv.getOverrideImpressionRecording()) {
                        zzanw zzanw = this.f14158b;
                        if (zzanw != null && !zzanw.getOverrideImpressionRecording()) {
                            this.f14158b.recordImpression();
                            this.f14160d.onAdImpression();
                            return;
                        }
                        return;
                    }
                    this.f14157a.recordImpression();
                    this.f14160d.onAdImpression();
                    return;
                }
                this.f14159c.recordImpression();
                this.f14160d.onAdImpression();
            }
        } catch (RemoteException e) {
            zzaza.zzd("Failed to call recordImpression", e);
        }
    }

    public final void zzf(Bundle bundle) {
    }

    public final void zzfw(String str) {
    }

    public final void zzg(Bundle bundle) {
    }

    public final boolean zzh(Bundle bundle) {
        return false;
    }

    public final void zztg() {
        this.f14167k = true;
    }

    public final void zza(View view, @Nullable Map<String, WeakReference<View>> map) {
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            zzaob zzaob = this.f14159c;
            if (zzaob != null) {
                zzaob.zzw(wrap);
                return;
            }
            zzanv zzanv = this.f14157a;
            if (zzanv != null) {
                zzanv.zzw(wrap);
                return;
            }
            zzanw zzanw = this.f14158b;
            if (zzanw != null) {
                zzanw.zzw(wrap);
            }
        } catch (RemoteException e) {
            zzaza.zzd("Failed to call untrackView", e);
        }
    }

    public final void zza(View view, @Nullable View view2, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.f14167k || !this.f14163g.zzdmh) {
            m7938a(view);
        }
    }

    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.f14167k) {
            zzaza.zzfa("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (!this.f14163g.zzdmh) {
            zzaza.zzfa("Custom click reporting for 3p ads failed. Ad unit id not whitelisted.");
        } else {
            m7938a(view);
        }
    }

    public final void zza(@Nullable zzyd zzyd) {
        zzaza.zzfa("Mute This Ad is not supported for 3rd party ads");
    }

    public final void zza(zzxz zzxz) {
        zzaza.zzfa("Mute This Ad is not supported for 3rd party ads");
    }
}
