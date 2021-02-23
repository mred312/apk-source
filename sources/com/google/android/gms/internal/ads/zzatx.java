package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzatx extends zzatz {

    /* renamed from: a */
    private final Object f12845a = new Object();

    /* renamed from: b */
    private final Context f12846b;
    @Nullable

    /* renamed from: c */
    private SharedPreferences f12847c;

    /* renamed from: d */
    private final zzamd<JSONObject, JSONObject> f12848d;

    public zzatx(Context context, zzamd<JSONObject, JSONObject> zzamd) {
        this.f12846b = context.getApplicationContext();
        this.f12848d = zzamd;
    }

    public static JSONObject zzw(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("js", zzazh.zzzi().zzbrf);
            jSONObject.put("mf", zzadb.zzdct.get());
            jSONObject.put("cl", "334274230");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", "HEAD");
            jSONObject.put("admob_module_version", GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            jSONObject.put("dynamite_local_version", ModuleDescriptor.MODULE_VERSION);
            jSONObject.put("dynamite_version", DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID));
            jSONObject.put("container_version", 12451009);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ Void mo15722a(JSONObject jSONObject) {
        zzabf.zza(this.f12846b, 1, jSONObject);
        this.f12847c.edit().putLong("js_last_update", zzp.zzkx().currentTimeMillis()).apply();
        return null;
    }

    public final zzdyz<Void> zzwa() {
        synchronized (this.f12845a) {
            if (this.f12847c == null) {
                this.f12847c = this.f12846b.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        if (zzp.zzkx().currentTimeMillis() - this.f12847c.getLong("js_last_update", 0) < zzadb.zzdcu.get().longValue()) {
            return zzdyr.zzag(null);
        }
        return zzdyr.zzb(this.f12848d.zzi(zzw(this.f12846b)), new C2162m4(this), (Executor) zzazj.zzegu);
    }
}
