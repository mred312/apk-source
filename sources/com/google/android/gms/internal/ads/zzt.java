package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzt implements zzak {

    /* renamed from: a */
    private final Executor f16991a;

    public zzt(Handler handler) {
        this.f16991a = new vh0(this, handler);
    }

    public final void zza(zzaa<?> zzaa, zzaj<?> zzaj, Runnable runnable) {
        zzaa.zzk();
        zzaa.zzc("post-response");
        this.f16991a.execute(new vi0(zzaa, zzaj, runnable));
    }

    public final void zzb(zzaa<?> zzaa, zzaj<?> zzaj) {
        zza(zzaa, zzaj, (Runnable) null);
    }

    public final void zza(zzaa<?> zzaa, zzao zzao) {
        zzaa.zzc("post-error");
        this.f16991a.execute(new vi0(zzaa, zzaj.zzd(zzao), (Runnable) null));
    }
}
