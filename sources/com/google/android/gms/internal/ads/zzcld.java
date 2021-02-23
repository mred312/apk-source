package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcld {
    /* renamed from: a */
    private static <T> Set<zzbxy<T>> m8185a(T t, Executor executor) {
        if (zzada.zzdcs.get().booleanValue()) {
            return Collections.singleton(new zzbxy(t, executor));
        }
        return Collections.emptySet();
    }

    public static Set<zzbxy<zzbsp>> zza(zzcln zzcln, Executor executor) {
        return m8185a(zzcln, executor);
    }

    public static Set<zzbxy<AppEventListener>> zzb(zzcln zzcln, Executor executor) {
        return m8185a(zzcln, executor);
    }

    public static Set<zzbxy<zzbtj>> zzc(zzcln zzcln, Executor executor) {
        return m8185a(zzcln, executor);
    }

    public static Set<zzbxy<zzbrz>> zzd(zzcln zzcln, Executor executor) {
        return m8185a(zzcln, executor);
    }

    public static Set<zzbxy<zzbru>> zze(zzcln zzcln, Executor executor) {
        return m8185a(zzcln, executor);
    }

    public static Set<zzbxy<zzbsm>> zzf(zzcln zzcln, Executor executor) {
        return m8185a(zzcln, executor);
    }

    public static Set<zzbxy<zzva>> zzg(zzcln zzcln, Executor executor) {
        return m8185a(zzcln, executor);
    }

    public static Set<zzbxy<zzdru>> zzh(zzcln zzcln, Executor executor) {
        return m8185a(zzcln, executor);
    }

    public static Set<zzbxy<zzbui>> zzi(zzcln zzcln, Executor executor) {
        return m8185a(zzcln, executor);
    }
}
