package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzak {

    /* renamed from: a */
    final String f18498a;

    /* renamed from: b */
    final String f18499b;

    /* renamed from: c */
    private final String f18500c;

    /* renamed from: d */
    final long f18501d;

    /* renamed from: e */
    final long f18502e;

    /* renamed from: f */
    final zzam f18503f;

    private zzak(zzfv zzfv, String str, String str2, String str3, long j, long j2, zzam zzam) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzam);
        this.f18498a = str2;
        this.f18499b = str3;
        this.f18500c = TextUtils.isEmpty(str) ? null : str;
        this.f18501d = j;
        this.f18502e = j2;
        if (j2 != 0 && j2 > j) {
            zzfv.zzq().zzh().zza("Event created with reverse previous/current timestamps. appId, name", zzer.zza(str2), zzer.zza(str3));
        }
        this.f18503f = zzam;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final zzak mo20231a(zzfv zzfv, long j) {
        return new zzak(zzfv, this.f18500c, this.f18498a, this.f18499b, this.f18501d, j, this.f18503f);
    }

    public final String toString() {
        String str = this.f18498a;
        String str2 = this.f18499b;
        String valueOf = String.valueOf(this.f18503f);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("Event{appId='");
        sb.append(str);
        sb.append("', name='");
        sb.append(str2);
        sb.append("', params=");
        sb.append(valueOf);
        sb.append('}');
        return sb.toString();
    }

    zzak(zzfv zzfv, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzam zzam;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.f18498a = str2;
        this.f18499b = str3;
        this.f18500c = TextUtils.isEmpty(str) ? null : str;
        this.f18501d = j;
        this.f18502e = j2;
        if (j2 != 0 && j2 > j) {
            zzfv.zzq().zzh().zza("Event created with reverse previous/current timestamps. appId", zzer.zza(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzam = new zzam(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String str4 = (String) it.next();
                if (str4 == null) {
                    zzfv.zzq().zze().zza("Param name can't be null");
                    it.remove();
                } else {
                    Object k = zzfv.zzh().mo20571k(str4, bundle2.get(str4));
                    if (k == null) {
                        zzfv.zzq().zzh().zza("Param value can't be null", zzfv.zzi().zzb(str4));
                        it.remove();
                    } else {
                        zzfv.zzh().mo20573n(bundle2, str4, k);
                    }
                }
            }
            zzam = new zzam(bundle2);
        }
        this.f18503f = zzam;
    }
}
