package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzep extends C3059n4 {

    /* renamed from: b */
    private static final AtomicReference<String[]> f18533b = new AtomicReference<>();

    /* renamed from: c */
    private static final AtomicReference<String[]> f18534c = new AtomicReference<>();

    /* renamed from: d */
    private static final AtomicReference<String[]> f18535d = new AtomicReference<>();

    zzep(zzfv zzfv) {
        super(zzfv);
    }

    @Nullable
    /* renamed from: b */
    private static String m10769b(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        Preconditions.checkNotNull(atomicReference);
        Preconditions.checkArgument(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            if (zzkw.m10994R(str, strArr[i])) {
                synchronized (atomicReference) {
                    String[] strArr3 = atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i] == null) {
                        strArr3[i] = strArr2[i] + "(" + strArr[i] + ")";
                    }
                    str2 = strArr3[i];
                }
                return str2;
            }
        }
        return str;
    }

    @Nullable
    /* renamed from: c */
    private final String m10770c(Object[] objArr) {
        String str;
        if (objArr == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Bundle bundle : objArr) {
            if (bundle instanceof Bundle) {
                str = zza(bundle);
            } else {
                str = String.valueOf(bundle);
            }
            if (str != null) {
                if (sb.length() != 1) {
                    sb.append(", ");
                }
                sb.append(str);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private final boolean zzf() {
        return this.zzy.zzk() && this.zzy.zzq().zza(3);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zza(String str) {
        if (str == null) {
            return null;
        }
        if (!zzf()) {
            return str;
        }
        return m10769b(str, zzgs.zzc, zzgs.zza, f18533b);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzb(String str) {
        if (str == null) {
            return null;
        }
        if (!zzf()) {
            return str;
        }
        return m10769b(str, zzgv.zzb, zzgv.zza, f18534c);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzc(String str) {
        if (str == null) {
            return null;
        }
        if (!zzf()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return m10769b(str, zzgu.zzb, zzgu.zza, f18535d);
        }
        return "experiment_id" + "(" + str + ")";
    }

    /* access modifiers changed from: protected */
    public final boolean zzd() {
        return false;
    }

    public final /* bridge */ /* synthetic */ zzal zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ Clock zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Context zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ zzep zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzkw zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzfo zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzer zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ C3049m3 zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzy zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzx zzt() {
        return super.zzt();
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zza(zzar zzar) {
        String str = null;
        if (zzar == null) {
            return null;
        }
        if (!zzf()) {
            return zzar.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("origin=");
        sb.append(zzar.zzc);
        sb.append(",name=");
        sb.append(zza(zzar.zza));
        sb.append(",params=");
        zzam zzam = zzar.zzb;
        if (zzam != null) {
            if (!zzf()) {
                str = zzam.toString();
            } else {
                str = zza(zzam.zzb());
            }
        }
        sb.append(str);
        return sb.toString();
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zza(Bundle bundle) {
        String str;
        if (bundle == null) {
            return null;
        }
        if (!zzf()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Bundle[{");
        for (String str2 : bundle.keySet()) {
            if (sb.length() != 8) {
                sb.append(", ");
            }
            sb.append(zzb(str2));
            sb.append("=");
            Object obj = bundle.get(str2);
            if (obj instanceof Bundle) {
                str = m10770c(new Object[]{obj});
            } else if (obj instanceof Object[]) {
                str = m10770c((Object[]) obj);
            } else if (obj instanceof ArrayList) {
                str = m10770c(((ArrayList) obj).toArray());
            } else {
                str = String.valueOf(obj);
            }
            sb.append(str);
        }
        sb.append("}]");
        return sb.toString();
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
