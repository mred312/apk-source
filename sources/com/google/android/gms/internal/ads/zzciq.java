package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzciq {

    /* renamed from: a */
    private final zzcil f14439a;

    /* renamed from: b */
    private final AtomicReference<zzani> f14440b = new AtomicReference<>();

    zzciq(zzcil zzcil) {
        this.f14439a = zzcil;
    }

    /* renamed from: a */
    private final zzani m8166a() {
        zzani zzani = this.f14440b.get();
        if (zzani != null) {
            return zzani;
        }
        zzaza.zzfa("Unexpected call to adapter creator.");
        throw new RemoteException();
    }

    /* renamed from: b */
    private final zzann m8167b(String str, JSONObject jSONObject) {
        zzani a = m8166a();
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            try {
                if (a.zzdf(jSONObject.getString("class_name"))) {
                    return a.zzde("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
                }
                return a.zzde("com.google.ads.mediation.customevent.CustomEventAdapter");
            } catch (JSONException e) {
                zzaza.zzc("Invalid custom event.", e);
            }
        }
        return a.zzde(str);
    }

    public final boolean zzapg() {
        return this.f14440b.get() != null;
    }

    public final void zzb(zzani zzani) {
        this.f14440b.compareAndSet((Object) null, zzani);
    }

    public final zzdoe zzd(String str, JSONObject jSONObject) {
        zzann zzann;
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                zzann = new zzaoe((MediationAdapter) new AdMobAdapter());
            } else if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
                zzann = new zzaoe((MediationAdapter) new AdUrlAdapter());
            } else if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(str)) {
                zzann = new zzaoe((MediationAdapter) new zzaqe());
            } else {
                zzann = m8167b(str, jSONObject);
            }
            zzdoe zzdoe = new zzdoe(zzann);
            this.f14439a.mo16874b(str, zzdoe);
            return zzdoe;
        } catch (Throwable th) {
            throw new zzdnr(th);
        }
    }

    public final zzapo zzdg(String str) {
        zzapo zzdg = m8166a().zzdg(str);
        this.f14439a.mo16873a(str, zzdg);
        return zzdg;
    }
}
