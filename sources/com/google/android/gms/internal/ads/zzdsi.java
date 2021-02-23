package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.ads.zzbw;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public final class zzdsi {

    /* renamed from: d */
    private static volatile zzbw.zza.zzc f15929d = zzbw.zza.zzc.UNKNOWN;

    /* renamed from: a */
    private final Context f15930a;

    /* renamed from: b */
    private final Executor f15931b;

    /* renamed from: c */
    private final Task<zztx> f15932c;

    private zzdsi(@NonNull Context context, @NonNull Executor executor, @NonNull Task<zztx> task) {
        this.f15930a = context;
        this.f15931b = executor;
        this.f15932c = task;
    }

    /* renamed from: a */
    private final Task<Boolean> m8481a(int i, long j, Exception exc, String str, Map<String, String> map, String str2) {
        zzbw.zza.C3974zza zzc = zzbw.zza.zzs().zzj(this.f15930a.getPackageName()).zzc(j);
        zzc.zza(f15929d);
        if (exc != null) {
            zzc.zzk(zzdwe.zza(exc)).zzl(exc.getClass().getName());
        }
        if (str2 != null) {
            zzc.zzm(str2);
        }
        if (str != null) {
            zzc.zzn(str);
        }
        return this.f15932c.continueWith(this.f15931b, new l00(zzc, i));
    }

    /* renamed from: b */
    static final /* synthetic */ Boolean m8482b(zzbw.zza.C3974zza zza, int i, Task task) {
        if (!task.isSuccessful()) {
            return Boolean.FALSE;
        }
        zzub zzf = ((zztx) task.getResult()).zzf(((zzbw.zza) ((zzekh) zza.zzbhv())).toByteArray());
        zzf.zzbv(i);
        zzf.log();
        return Boolean.TRUE;
    }

    /* renamed from: c */
    static void m8483c(zzbw.zza.zzc zzc) {
        f15929d = zzc;
    }

    /* renamed from: d */
    static final /* synthetic */ zztx m8484d(Context context) {
        return new zztx(context, "GLAS", (String) null);
    }

    public static zzdsi zza(@NonNull Context context, @NonNull Executor executor) {
        return new zzdsi(context, executor, Tasks.call(executor, new k00(context)));
    }

    public final Task<Boolean> zzb(int i, long j, String str) {
        return m8481a(i, j, (Exception) null, (String) null, (Map<String, String>) null, str);
    }

    public final Task<Boolean> zzg(int i, String str) {
        return m8481a(i, 0, (Exception) null, (String) null, (Map<String, String>) null, str);
    }

    public final Task<Boolean> zzh(int i, long j) {
        return m8481a(i, j, (Exception) null, (String) null, (Map<String, String>) null, (String) null);
    }

    public final Task<Boolean> zza(int i, long j, Exception exc) {
        return m8481a(i, j, exc, (String) null, (Map<String, String>) null, (String) null);
    }

    public final Task<Boolean> zza(int i, long j, String str, Map<String, String> map) {
        return m8481a(i, j, (Exception) null, str, (Map<String, String>) null, (String) null);
    }
}
