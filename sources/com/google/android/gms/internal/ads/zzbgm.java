package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzbgl;
import com.google.android.gms.internal.ads.zzbim;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public abstract class zzbgm implements zzbjl {
    @GuardedBy("AppComponent.class")

    /* renamed from: a */
    private static zzbgm f13254a;

    @Deprecated
    /* renamed from: a */
    private static zzbgm m7760a(zzazh zzazh, Context context, zzbim.zza zza) {
        zzbgm zzbgm;
        synchronized (zzbgm.class) {
            if (f13254a == null) {
                f13254a = new zzbib().zzc(new zzbgl(new zzbgl.zza().zza(zzazh).zzby(context))).zza(new zzbim(zza)).zzahg();
                zzabf.initialize(context);
                zzp.zzku().zzd(context, zzazh);
                zzp.zzkw().initialize(context);
                zzp.zzkq().zzam(context);
                zzp.zzkq().zzan(context);
                zzp.zzkq();
                zzm.zzbd(context);
                zzb.zzal(context);
                zzp.zzkt().initialize(context);
                zzp.zzll().initialize(context);
                if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwu)).booleanValue()) {
                    new zzcqh(context, zzazh, new zzts(new zztx(context)), new zzcpr(new zzcpp(context), f13254a.zzaen())).zzari();
                }
            }
            zzbgm = f13254a;
        }
        return zzbgm;
    }

    public static zzbgm zza(Context context, zzani zzani, int i) {
        zzbgm zzf = zzf(context, i);
        zzf.zzaep().zzb(zzani);
        return zzf;
    }

    @Deprecated
    public static zzbgm zzf(Context context, int i) {
        synchronized (zzbgm.class) {
            zzbgm zzbgm = f13254a;
            if (zzbgm != null) {
                return zzbgm;
            }
            return m7760a(new zzazh(203404000, i, true, false), context, new zzbhh());
        }
    }

    /* access modifiers changed from: protected */
    public abstract zzdga zza(zzdhn zzdhn);

    public abstract Executor zzaek();

    public abstract ScheduledExecutorService zzael();

    public abstract Executor zzaem();

    public abstract zzdzc zzaen();

    public abstract zzbua zzaeo();

    public abstract zzciq zzaep();

    public abstract zzbiu zzaeq();

    public abstract zzbmz zzaer();

    public abstract zzblf zzaes();

    public abstract zzbls zzaet();

    public abstract zzdii zzaeu();

    public abstract zzcaa zzaev();

    public abstract zzdlc zzaew();

    public abstract zzcaw zzaex();

    public abstract zzchi zzaey();

    public abstract zzdmp zzaez();

    public abstract zzcyy zzafa();

    public abstract zzcyx zzafb();

    public abstract zzcqy zzafc();

    public abstract zzdod<zzcgh> zzafd();

    public final zzdga zza(zzatl zzatl, int i) {
        return zza(new zzdhn(zzatl, i));
    }
}
