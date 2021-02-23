package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzp {

    /* renamed from: a */
    private final zzfv f18730a;

    public zzp(zzfv zzfv) {
        this.f18730a = zzfv;
    }

    /* renamed from: d */
    private final boolean m11037d() {
        if (m11038e() && this.f18730a.zzl().currentTimeMillis() - this.f18730a.zzb().f18224A.zza() > this.f18730a.zza().zza((String) null, zzat.zzcd)) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    private final boolean m11038e() {
        return this.f18730a.zzb().f18224A.zza() > 0;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: a */
    public final void mo20596a() {
        this.f18730a.zzp().zzc();
        if (m11038e()) {
            if (m11037d()) {
                this.f18730a.zzb().f18250z.zza((String) null);
                Bundle bundle = new Bundle();
                bundle.putString(FirebaseAnalytics.Param.SOURCE, "(not set)");
                bundle.putString(FirebaseAnalytics.Param.MEDIUM, "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1);
                this.f18730a.zzg().zza("auto", "_cmpx", bundle);
            } else {
                String zza = this.f18730a.zzb().f18250z.zza();
                if (TextUtils.isEmpty(zza)) {
                    this.f18730a.zzq().zzf().zza("Cache still valid but referrer not found");
                } else {
                    long zza2 = ((this.f18730a.zzb().f18224A.zza() / 3600000) - 1) * 3600000;
                    Uri parse = Uri.parse(zza);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(parse.getPath(), bundle2);
                    for (String next : parse.getQueryParameterNames()) {
                        bundle2.putString(next, parse.getQueryParameter(next));
                    }
                    ((Bundle) pair.second).putLong("_cc", zza2);
                    this.f18730a.zzg().zza((String) pair.first, "_cmp", (Bundle) pair.second);
                }
                this.f18730a.zzb().f18250z.zza((String) null);
            }
            this.f18730a.zzb().f18224A.zza(0);
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: b */
    public final void mo20597b(String str, Bundle bundle) {
        String str2;
        this.f18730a.zzp().zzc();
        if (!this.f18730a.zzaa()) {
            if (bundle == null || bundle.isEmpty()) {
                str2 = null;
            } else {
                if (str == null || str.isEmpty()) {
                    str = "auto";
                }
                Uri.Builder builder = new Uri.Builder();
                builder.path(str);
                for (String str3 : bundle.keySet()) {
                    builder.appendQueryParameter(str3, bundle.getString(str3));
                }
                str2 = builder.build().toString();
            }
            if (!TextUtils.isEmpty(str2)) {
                this.f18730a.zzb().f18250z.zza(str2);
                this.f18730a.zzb().f18224A.zza(this.f18730a.zzl().currentTimeMillis());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo20598c() {
        if (m11038e() && m11037d()) {
            this.f18730a.zzb().f18250z.zza((String) null);
        }
    }
}
