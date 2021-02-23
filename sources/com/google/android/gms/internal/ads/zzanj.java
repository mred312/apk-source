package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.mediation.customevent.CustomEventAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzanj extends zzanl {

    /* renamed from: a */
    private Map<Class<? extends NetworkExtras>, NetworkExtras> f12555a;

    static {
        new zzapu();
    }

    /* renamed from: a */
    private final <NetworkExtrasT extends com.google.ads.mediation.NetworkExtras, ServerParametersT extends MediationServerParameters> zzann m7502a(String str) {
        try {
            Class<?> cls = Class.forName(str, false, zzanj.class.getClassLoader());
            if (MediationAdapter.class.isAssignableFrom(cls)) {
                MediationAdapter mediationAdapter = (MediationAdapter) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                return new zzaom(mediationAdapter, (com.google.ads.mediation.NetworkExtras) this.f12555a.get(mediationAdapter.getAdditionalParametersType()));
            } else if (com.google.android.gms.ads.mediation.MediationAdapter.class.isAssignableFrom(cls)) {
                return new zzaoe((com.google.android.gms.ads.mediation.MediationAdapter) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } else {
                if (Adapter.class.isAssignableFrom(cls)) {
                    return new zzaoe((Adapter) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                }
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 64);
                sb.append("Could not instantiate mediation adapter: ");
                sb.append(str);
                sb.append(" (not a valid adapter).");
                zzaza.zzfa(sb.toString());
                throw new RemoteException();
            }
        } catch (Throwable unused) {
            return m7503b(str);
        }
    }

    /* renamed from: b */
    private final zzann m7503b(String str) {
        try {
            zzaza.zzeb("Reflection failed, retrying using direct instantiation");
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                return new zzaoe((com.google.android.gms.ads.mediation.MediationAdapter) new AdMobAdapter());
            }
            if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
                return new zzaoe((com.google.android.gms.ads.mediation.MediationAdapter) new AdUrlAdapter());
            }
            if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                return new zzaoe((com.google.android.gms.ads.mediation.MediationAdapter) new CustomEventAdapter());
            }
            if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                com.google.ads.mediation.customevent.CustomEventAdapter customEventAdapter = new com.google.ads.mediation.customevent.CustomEventAdapter();
                return new zzaom(customEventAdapter, (CustomEventExtras) this.f12555a.get(customEventAdapter.getAdditionalParametersType()));
            }
            throw new RemoteException();
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 43);
            sb.append("Could not instantiate mediation adapter: ");
            sb.append(str);
            sb.append(". ");
            zzaza.zzd(sb.toString(), th);
        }
    }

    public final zzann zzde(String str) {
        return m7502a(str);
    }

    public final boolean zzdf(String str) {
        try {
            return CustomEvent.class.isAssignableFrom(Class.forName(str, false, zzanj.class.getClassLoader()));
        } catch (Throwable unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 80);
            sb.append("Could not load custom event implementation class: ");
            sb.append(str);
            sb.append(", assuming old implementation.");
            zzaza.zzfa(sb.toString());
            return false;
        }
    }

    public final zzapo zzdg(String str) {
        return zzapu.zzdp(str);
    }

    public final void zzf(Map<Class<? extends NetworkExtras>, NetworkExtras> map) {
        this.f12555a = map;
    }
}
