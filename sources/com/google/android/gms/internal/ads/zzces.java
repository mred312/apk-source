package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzces {

    /* renamed from: a */
    private final Context f14200a;

    /* renamed from: b */
    private final zzcej f14201b;

    /* renamed from: c */
    private final zzef f14202c;

    /* renamed from: d */
    private final zzazh f14203d;

    /* renamed from: e */
    private final zzb f14204e;

    /* renamed from: f */
    private final zzts f14205f;

    /* renamed from: g */
    private final Executor f14206g;

    /* renamed from: h */
    private final zzadz f14207h;

    /* renamed from: i */
    private final zzcff f14208i;

    /* renamed from: j */
    private final ScheduledExecutorService f14209j;

    public zzces(Context context, zzcej zzcej, zzef zzef, zzazh zzazh, zzb zzb, zzts zzts, Executor executor, zzdnn zzdnn, zzcff zzcff, ScheduledExecutorService scheduledExecutorService) {
        this.f14200a = context;
        this.f14201b = zzcej;
        this.f14202c = zzef;
        this.f14203d = zzazh;
        this.f14204e = zzb;
        this.f14205f = zzts;
        this.f14206g = executor;
        this.f14207h = zzdnn.zzdnh;
        this.f14208i = zzcff;
        this.f14209j = scheduledExecutorService;
    }

    /* renamed from: b */
    private static <T> zzdyz<T> m7944b(zzdyz<T> zzdyz, T t) {
        return zzdyr.zzb(zzdyz, Exception.class, new C2213ni((Object) null), zzazj.zzegu);
    }

    /* renamed from: c */
    private final zzdyz<List<zzadv>> m7945c(@Nullable JSONArray jSONArray, boolean z, boolean z2) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzdyr.zzag(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = z2 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            arrayList.add(m7946d(jSONArray.optJSONObject(i), z));
        }
        return zzdyr.zzb(zzdyr.zzi(arrayList), C1991hi.f9220a, this.f14206g);
    }

    /* renamed from: d */
    private final zzdyz<zzadv> m7946d(@Nullable JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return zzdyr.zzag(null);
        }
        String optString = jSONObject.optString(ImagesContract.URL);
        if (TextUtils.isEmpty(optString)) {
            return zzdyr.zzag(null);
        }
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        int optInt = jSONObject.optInt("width", -1);
        int optInt2 = jSONObject.optInt("height", -1);
        if (z) {
            return zzdyr.zzag(new zzadv((Drawable) null, Uri.parse(optString), optDouble, optInt, optInt2));
        }
        return m7947e(jSONObject.optBoolean("require"), zzdyr.zzb(this.f14201b.zza(optString, optDouble, optBoolean), new C2065ji(optString, optDouble, optInt, optInt2), this.f14206g), (Object) null);
    }

    /* renamed from: e */
    private static <T> zzdyz<T> m7947e(boolean z, zzdyz<T> zzdyz, T t) {
        if (z) {
            return zzdyr.zzb(zzdyz, new C2176mi(zzdyz), (Executor) zzazj.zzegu);
        }
        return m7944b(zzdyz, (Object) null);
    }

    /* renamed from: g */
    private static Integer m7948g(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    @Nullable
    /* renamed from: h */
    private static zzzk m7949h(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("reason");
        String optString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new zzzk(optString, optString2);
    }

    public static List<zzzk> zzj(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("mute");
        if (optJSONObject == null) {
            return zzdwm.zzayv();
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("reasons");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return zzdwm.zzayv();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            zzzk h = m7949h(optJSONArray.optJSONObject(i));
            if (h != null) {
                arrayList.add(h);
            }
        }
        return zzdwm.zzb(arrayList);
    }

    @Nullable
    public static zzzk zzk(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("mute");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return m7949h(optJSONObject);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzadq mo16720a(JSONObject jSONObject, List list) {
        Integer num = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        String optString = jSONObject.optString("text");
        Integer g = m7948g(jSONObject, "bg_color");
        Integer g2 = m7948g(jSONObject, "text_color");
        int optInt = jSONObject.optInt("text_size", -1);
        boolean optBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int optInt2 = jSONObject.optInt("animation_ms", 1000);
        int optInt3 = jSONObject.optInt("presentation_ms", 4000);
        if (optInt > 0) {
            num = Integer.valueOf(optInt);
        }
        return new zzadq(optString, list, g, g2, num, optInt3 + optInt2, this.f14207h.zzbnp, optBoolean);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final /* synthetic */ zzdyz mo16721f(String str, Object obj) {
        zzp.zzkr();
        zzbdv zza = zzbed.zza(this.f14200a, zzbfn.zzadv(), "native-omid", false, false, this.f14202c, (zzacg) null, this.f14203d, (zzabs) null, (zzk) null, this.f14204e, this.f14205f, (zzsu) null, false, (zzdmu) null, (zzdmz) null);
        zzazr zzl = zzazr.zzl(zza);
        zza.zzacs().zza((zzbfj) new C2251oi(zzl));
        zza.loadData(str, "text/html", Key.STRING_CHARSET_NAME);
        return zzl;
    }

    public final zzdyz<zzadv> zzc(JSONObject jSONObject, String str) {
        return m7946d(jSONObject.optJSONObject(str), this.f14207h.zzdeo);
    }

    public final zzdyz<List<zzadv>> zzd(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        zzadz zzadz = this.f14207h;
        return m7945c(optJSONArray, zzadz.zzdeo, zzadz.zzbno);
    }

    public final zzdyz<zzadq> zze(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return zzdyr.zzag(null);
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("images");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("image");
        if (optJSONArray == null && optJSONObject2 != null) {
            optJSONArray = new JSONArray();
            optJSONArray.put(optJSONObject2);
        }
        return m7947e(optJSONObject.optBoolean("require"), zzdyr.zzb(m7945c(optJSONArray, false, true), new C2028ii(this, optJSONObject), this.f14206g), (Object) null);
    }

    public final zzdyz<zzbdv> zzm(JSONObject jSONObject) {
        JSONObject zza = zzbk.zza(jSONObject, "html_containers", "instream");
        if (zza == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("video");
            if (optJSONObject == null) {
                return zzdyr.zzag(null);
            }
            if (TextUtils.isEmpty(optJSONObject.optString("vast_xml"))) {
                zzaza.zzfa("Required field 'vast_xml' is missing");
                return zzdyr.zzag(null);
            }
            return m7944b(zzdyr.zza(this.f14208i.zzn(optJSONObject), (long) ((Integer) zzwq.zzqe().zzd(zzabf.zzcrz)).intValue(), TimeUnit.SECONDS, this.f14209j), (Object) null);
        }
        zzdyz<zzbdv> zzo = this.f14208i.zzo(zza.optString("base_url"), zza.optString("html"));
        return zzdyr.zzb(zzo, new C2102ki(zzo), (Executor) zzazj.zzegu);
    }
}
