package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbki implements zzp, zzbsm, zzbsp, zzqu {

    /* renamed from: a */
    private final zzbjz f13401a;

    /* renamed from: b */
    private final zzbkg f13402b;

    /* renamed from: c */
    private final Set<zzbdv> f13403c = new HashSet();

    /* renamed from: d */
    private final zzamx<JSONObject, JSONObject> f13404d;

    /* renamed from: e */
    private final Executor f13405e;

    /* renamed from: f */
    private final Clock f13406f;

    /* renamed from: g */
    private final AtomicBoolean f13407g = new AtomicBoolean(false);
    @GuardedBy("this")

    /* renamed from: h */
    private final zzbkk f13408h = new zzbkk();

    /* renamed from: i */
    private boolean f13409i = false;

    /* renamed from: j */
    private WeakReference<?> f13410j = new WeakReference<>(this);

    public zzbki(zzamq zzamq, zzbkg zzbkg, Executor executor, zzbjz zzbjz, Clock clock) {
        this.f13401a = zzbjz;
        zzamh<JSONObject> zzamh = zzamg.zzdjy;
        this.f13404d = zzamq.zzb("google.afma.activeView.handleUpdate", zzamh, zzamh);
        this.f13402b = zzbkg;
        this.f13405e = executor;
        this.f13406f = clock;
    }

    /* renamed from: a */
    private final void m7818a() {
        for (zzbdv zze : this.f13403c) {
            this.f13401a.zze(zze);
        }
        this.f13401a.zzaif();
    }

    public final synchronized void onAdImpression() {
        if (this.f13407g.compareAndSet(false, true)) {
            this.f13401a.zza(this);
            zzaig();
        }
    }

    public final synchronized void onPause() {
        this.f13408h.zzfrg = true;
        zzaig();
    }

    public final synchronized void onResume() {
        this.f13408h.zzfrg = false;
        zzaig();
    }

    public final void onUserLeaveHint() {
    }

    public final void zza(zzl zzl) {
    }

    public final synchronized void zza(zzqv zzqv) {
        zzbkk zzbkk = this.f13408h;
        zzbkk.zzbqz = zzqv.zzbqz;
        zzbkk.zzfrj = zzqv;
        zzaig();
    }

    public final synchronized void zzaig() {
        if (!(this.f13410j.get() != null)) {
            zzaii();
        } else if (!this.f13409i && this.f13407g.get()) {
            try {
                this.f13408h.timestamp = this.f13406f.elapsedRealtime();
                JSONObject zza = this.f13402b.zzj(this.f13408h);
                for (zzbdv wbVar : this.f13403c) {
                    this.f13405e.execute(new C2544wb(wbVar, zza));
                }
                zzazm.zzb(this.f13404d.zzf(zza), "ActiveViewListener.callActiveViewJs");
            } catch (Exception e) {
                zzd.zza("Failed to call ActiveViewJS", e);
            }
        }
    }

    public final synchronized void zzaii() {
        m7818a();
        this.f13409i = true;
    }

    public final synchronized void zzcc(@Nullable Context context) {
        this.f13408h.zzfrg = true;
        zzaig();
    }

    public final synchronized void zzcd(@Nullable Context context) {
        this.f13408h.zzfrg = false;
        zzaig();
    }

    public final synchronized void zzce(@Nullable Context context) {
        this.f13408h.zzfri = "u";
        zzaig();
        m7818a();
        this.f13409i = true;
    }

    public final synchronized void zzf(zzbdv zzbdv) {
        this.f13403c.add(zzbdv);
        this.f13401a.zzd(zzbdv);
    }

    public final void zzo(Object obj) {
        this.f13410j = new WeakReference<>(obj);
    }

    public final void zzux() {
    }
}
