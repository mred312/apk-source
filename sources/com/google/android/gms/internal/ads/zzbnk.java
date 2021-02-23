package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.WorkerThread;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbnk extends zzbme {

    /* renamed from: f */
    private final zzagd f13537f;

    /* renamed from: g */
    private final Runnable f13538g;

    /* renamed from: h */
    private final Executor f13539h;

    public zzbnk(zzbob zzbob, zzagd zzagd, Runnable runnable, Executor executor) {
        super(zzbob);
        this.f13537f = zzagd;
        this.f13538g = runnable;
        this.f13539h = executor;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo16376a(Runnable runnable) {
        try {
            if (!this.f13537f.zzm(ObjectWrapper.wrap(runnable))) {
                runnable.run();
            }
        } catch (RemoteException unused) {
            runnable.run();
        }
    }

    public final zzys getVideoController() {
        return null;
    }

    public final void zza(ViewGroup viewGroup, zzvn zzvn) {
    }

    public final zzdmx zzaiy() {
        return null;
    }

    public final View zzaiz() {
        return null;
    }

    public final zzdmx zzajh() {
        return null;
    }

    public final int zzaji() {
        return 0;
    }

    @WorkerThread
    public final void zzajj() {
        this.f13539h.execute(new C2133lc(this, new C2096kc(new AtomicReference(this.f13538g))));
    }

    public final void zzke() {
    }
}
