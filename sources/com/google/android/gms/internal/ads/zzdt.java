package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.ConditionVariable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbw;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzdt {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final ConditionVariable f15943b = new ConditionVariable();

    /* renamed from: c */
    private static volatile Random f15944c = null;
    @VisibleForTesting
    protected static volatile zztx zzwd = null;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public zzfa f15945a;
    @VisibleForTesting
    protected volatile Boolean zzwe;

    public zzdt(zzfa zzfa) {
        this.f15945a = zzfa;
        zzfa.zzcg().execute(new x10(this));
    }

    /* renamed from: b */
    private static Random m8491b() {
        if (f15944c == null) {
            synchronized (zzdt.class) {
                if (f15944c == null) {
                    f15944c = new Random();
                }
            }
        }
        return f15944c;
    }

    public static int zzbu() {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                return ThreadLocalRandom.current().nextInt();
            }
            return m8491b().nextInt();
        } catch (RuntimeException unused) {
            return m8491b().nextInt();
        }
    }

    public final void zza(int i, int i2, long j) {
        zza(i, i2, j, (String) null, (Exception) null);
    }

    public final void zza(int i, int i2, long j, String str) {
        zza(i, -1, j, str, (Exception) null);
    }

    public final void zza(int i, int i2, long j, String str, Exception exc) {
        try {
            f15943b.block();
            if (this.zzwe.booleanValue() && zzwd != null) {
                zzbw.zza.C3974zza zzc = zzbw.zza.zzs().zzj(this.f15945a.context.getPackageName()).zzc(j);
                if (str != null) {
                    zzc.zzm(str);
                }
                if (exc != null) {
                    StringWriter stringWriter = new StringWriter();
                    zzeid.zza((Throwable) exc, new PrintWriter(stringWriter));
                    zzc.zzk(stringWriter.toString()).zzl(exc.getClass().getName());
                }
                zzub zzf = zzwd.zzf(((zzbw.zza) ((zzekh) zzc.zzbhv())).toByteArray());
                zzf.zzbv(i);
                if (i2 != -1) {
                    zzf.zzbu(i2);
                }
                zzf.log();
            }
        } catch (Exception unused) {
        }
    }
}
