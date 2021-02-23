package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzer extends C3059n4 {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public char f18536b = 0;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public long f18537c = -1;
    @GuardedBy("this")

    /* renamed from: d */
    private String f18538d;

    /* renamed from: e */
    private final zzet f18539e = new zzet(this, 6, false, false);

    /* renamed from: f */
    private final zzet f18540f = new zzet(this, 6, true, false);

    /* renamed from: g */
    private final zzet f18541g = new zzet(this, 6, false, true);

    /* renamed from: h */
    private final zzet f18542h = new zzet(this, 5, false, false);

    /* renamed from: i */
    private final zzet f18543i = new zzet(this, 5, true, false);

    /* renamed from: j */
    private final zzet f18544j = new zzet(this, 5, false, true);

    /* renamed from: k */
    private final zzet f18545k = new zzet(this, 4, false, false);

    /* renamed from: l */
    private final zzet f18546l = new zzet(this, 3, false, false);

    /* renamed from: m */
    private final zzet f18547m = new zzet(this, 2, false, false);

    zzer(zzfv zzfv) {
        super(zzfv);
    }

    @VisibleForTesting
    /* renamed from: e */
    private static String m10774e(boolean z, Object obj) {
        String className;
        String str = "";
        if (obj == null) {
            return str;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf((long) ((Integer) obj).intValue());
        }
        int i = 0;
        if (obj instanceof Long) {
            if (!z) {
                return String.valueOf(obj);
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return String.valueOf(obj);
            }
            if (String.valueOf(obj).charAt(0) == '-') {
                str = "-";
            }
            String valueOf = String.valueOf(Math.abs(l.longValue()));
            long round = Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1)));
            long round2 = Math.round(Math.pow(10.0d, (double) valueOf.length()) - 1.0d);
            StringBuilder sb = new StringBuilder(str.length() + 43 + str.length());
            sb.append(str);
            sb.append(round);
            sb.append("...");
            sb.append(str);
            sb.append(round2);
            return sb.toString();
        } else if (obj instanceof Boolean) {
            return String.valueOf(obj);
        } else {
            if (obj instanceof Throwable) {
                Throwable th = (Throwable) obj;
                StringBuilder sb2 = new StringBuilder(z ? th.getClass().getName() : th.toString());
                String zzb = zzb(zzfv.class.getCanonicalName());
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i];
                    if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && zzb(className).equals(zzb)) {
                        sb2.append(": ");
                        sb2.append(stackTraceElement);
                        break;
                    }
                    i++;
                }
                return sb2.toString();
            } else if (obj instanceof C2964d3) {
                return ((C2964d3) obj).f18011a;
            } else {
                if (z) {
                    return "-";
                }
                return String.valueOf(obj);
            }
        }
    }

    /* renamed from: f */
    static String m10775f(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        String e = m10774e(z, obj);
        String e2 = m10774e(z, obj2);
        String e3 = m10774e(z, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(e)) {
            sb.append(str2);
            sb.append(e);
            str2 = str3;
        }
        if (!TextUtils.isEmpty(e2)) {
            sb.append(str2);
            sb.append(e2);
        } else {
            str3 = str2;
        }
        if (!TextUtils.isEmpty(e3)) {
            sb.append(str3);
            sb.append(e3);
        }
        return sb.toString();
    }

    @VisibleForTesting
    /* renamed from: h */
    private final String m10777h() {
        String str;
        synchronized (this) {
            if (this.f18538d == null) {
                this.f18538d = this.zzy.zzr() != null ? this.zzy.zzr() : "FA";
            }
            str = this.f18538d;
        }
        return str;
    }

    protected static Object zza(String str) {
        if (str == null) {
            return null;
        }
        return new C2964d3(str);
    }

    private static String zzb(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return str;
        }
        return str.substring(0, lastIndexOf);
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    /* access modifiers changed from: protected */
    public final boolean zzd() {
        return false;
    }

    public final zzet zze() {
        return this.f18539e;
    }

    public final zzet zzf() {
        return this.f18540f;
    }

    public final zzet zzg() {
        return this.f18541g;
    }

    public final zzet zzh() {
        return this.f18542h;
    }

    public final zzet zzi() {
        return this.f18543i;
    }

    public final zzet zzj() {
        return this.f18544j;
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

    public final zzet zzu() {
        return this.f18545k;
    }

    public final zzet zzv() {
        return this.f18546l;
    }

    public final zzet zzw() {
        return this.f18547m;
    }

    public final String zzx() {
        Pair<String, Long> zza = zzr().f18227c.zza();
        if (zza == null || zza == C3049m3.f18223C) {
            return null;
        }
        String valueOf = String.valueOf(zza.second);
        String str = (String) zza.first;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(str).length());
        sb.append(valueOf);
        sb.append(":");
        sb.append(str);
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final void zza(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && zza(i)) {
            zza(i, m10775f(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            Preconditions.checkNotNull(str);
            zzfo m = this.zzy.mo20355m();
            if (m == null) {
                zza(6, "Scheduler not set. Not logging error/warn");
            } else if (!m.mo20065a()) {
                zza(6, "Scheduler not initialized. Not logging error/warn");
            } else {
                if (i < 0) {
                    i = 0;
                }
                m.zza((Runnable) new C2954c3(this, i >= 9 ? 8 : i, str, obj, obj2, obj3));
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public final boolean zza(int i) {
        return Log.isLoggable(m10777h(), i);
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public final void zza(int i, String str) {
        Log.println(i, m10777h(), str);
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
