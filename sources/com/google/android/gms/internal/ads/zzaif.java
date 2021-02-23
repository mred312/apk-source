package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzaif implements zzahv<Object> {

    /* renamed from: a */
    private final Object f12476a = new Object();
    @GuardedBy("lock")

    /* renamed from: b */
    private final Map<String, zzaih> f12477b = new HashMap();

    public final void zza(String str, zzaih zzaih) {
        synchronized (this.f12476a) {
            this.f12477b.put(str, zzaih);
        }
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str;
        String str2 = map.get(FacebookAdapter.KEY_ID);
        String str3 = map.get("fail");
        String str4 = map.get("fail_reason");
        String str5 = map.get("fail_stack");
        String str6 = map.get("result");
        if (TextUtils.isEmpty(str5)) {
            str4 = "Unknown Fail Reason.";
        }
        if (TextUtils.isEmpty(str5)) {
            str = "";
        } else {
            String valueOf = String.valueOf(str5);
            str = valueOf.length() != 0 ? "\n".concat(valueOf) : new String("\n");
        }
        synchronized (this.f12476a) {
            zzaih remove = this.f12477b.remove(str2);
            if (remove == null) {
                String valueOf2 = String.valueOf(str2);
                zzaza.zzfa(valueOf2.length() != 0 ? "Received result for unexpected method invocation: ".concat(valueOf2) : new String("Received result for unexpected method invocation: "));
            } else if (!TextUtils.isEmpty(str3)) {
                String valueOf3 = String.valueOf(str4);
                String valueOf4 = String.valueOf(str);
                remove.onFailure(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3));
            } else if (str6 == null) {
                remove.zzc((JSONObject) null);
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str6);
                    if (zzd.zzxn()) {
                        String valueOf5 = String.valueOf(jSONObject.toString(2));
                        zzd.zzee(valueOf5.length() != 0 ? "Result GMSG: ".concat(valueOf5) : new String("Result GMSG: "));
                    }
                    remove.zzc(jSONObject);
                } catch (JSONException e) {
                    remove.onFailure(e.getMessage());
                }
            }
        }
    }

    public final <EngineT extends zzaky> zzdyz<JSONObject> zza(EngineT enginet, String str, JSONObject jSONObject) {
        zzazq zzazq = new zzazq();
        zzp.zzkq();
        String zzyf = zzm.zzyf();
        zza(zzyf, (zzaih) new C2496v0(this, zzazq));
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(FacebookAdapter.KEY_ID, zzyf);
            jSONObject2.put("args", jSONObject);
            enginet.zza(str, jSONObject2);
        } catch (Exception e) {
            zzazq.setException(e);
        }
        return zzazq;
    }
}
