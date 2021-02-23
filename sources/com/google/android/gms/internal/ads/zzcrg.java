package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcrg {

    /* renamed from: a */
    private final List<zzvr> f14734a = Collections.synchronizedList(new ArrayList());

    /* renamed from: b */
    private final Map<String, zzvr> f14735b = Collections.synchronizedMap(new HashMap());

    /* renamed from: c */
    private zzdmu f14736c = null;

    public final List<zzvr> getAdapterResponses() {
        return this.f14734a;
    }

    public final void zza(zzdmu zzdmu, long j, @Nullable zzve zzve) {
        String str = zzdmu.zzdkx;
        if (this.f14735b.containsKey(str)) {
            if (this.f14736c == null) {
                this.f14736c = zzdmu;
            }
            zzvr zzvr = this.f14735b.get(str);
            zzvr.zzchz = j;
            zzvr.zzcia = zzve;
        }
    }

    public final zzbrp zzarl() {
        return new zzbrp(this.f14736c, "", this);
    }

    public final void zzd(zzdmu zzdmu) {
        String str = zzdmu.zzdkx;
        if (!this.f14735b.containsKey(str)) {
            Bundle bundle = new Bundle();
            Iterator<String> keys = zzdmu.zzhha.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    bundle.putString(next, zzdmu.zzhha.getString(next));
                } catch (JSONException unused) {
                }
            }
            zzvr zzvr = new zzvr(zzdmu.zzhhe, 0, (zzve) null, bundle);
            this.f14734a.add(zzvr);
            this.f14735b.put(str, zzvr);
        }
    }
}
