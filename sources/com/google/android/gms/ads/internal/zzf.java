package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzayr;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzazh;
import com.google.android.gms.internal.ads.zzazj;
import com.google.android.gms.internal.ads.zzcw;
import com.google.android.gms.internal.ads.zzdp;
import com.google.android.gms.internal.ads.zzdv;
import com.google.android.gms.internal.ads.zzeg;
import com.google.android.gms.internal.ads.zzwq;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzf implements zzdv, Runnable {
    private Context context;
    private final List<Object[]> zzbop = new Vector();
    private final AtomicReference<zzdv> zzboq = new AtomicReference<>();
    private final AtomicReference<zzdv> zzbor = new AtomicReference<>();
    private zzazh zzbos;
    private CountDownLatch zzbot = new CountDownLatch(1);
    private final int zzws;

    public zzf(Context context2, zzazh zzazh) {
        this.context = context2;
        this.zzbos = zzazh;
        int intValue = ((Integer) zzwq.zzqe().zzd(zzabf.zzcqt)).intValue();
        if (intValue == 1) {
            this.zzws = zzcw.zznh;
        } else if (intValue != 2) {
            this.zzws = zzcw.zzng;
        } else {
            this.zzws = zzcw.zzni;
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcri)).booleanValue()) {
            zzazj.zzegp.execute(this);
            return;
        }
        zzwq.zzqa();
        if (zzayr.zzze()) {
            zzazj.zzegp.execute(this);
        } else {
            run();
        }
    }

    @Nullable
    private final zzdv zzca() {
        if (this.zzws == zzcw.zznh) {
            return this.zzbor.get();
        }
        return this.zzboq.get();
    }

    private static Context zze(Context context2) {
        Context applicationContext = context2.getApplicationContext();
        return applicationContext == null ? context2 : applicationContext;
    }

    private final boolean zzjz() {
        try {
            this.zzbot.await();
            return true;
        } catch (InterruptedException e) {
            zzaza.zzd("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    private final void zzka() {
        zzdv zzca = zzca();
        if (!this.zzbop.isEmpty() && zzca != null) {
            for (Object[] next : this.zzbop) {
                if (next.length == 1) {
                    zzca.zza((MotionEvent) next[0]);
                } else if (next.length == 3) {
                    zzca.zza(((Integer) next[0]).intValue(), ((Integer) next[1]).intValue(), ((Integer) next[2]).intValue());
                }
            }
            this.zzbop.clear();
        }
    }

    public final void run() {
        boolean z = false;
        try {
            boolean z2 = this.zzbos.zzegn;
            if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcos)).booleanValue() && z2) {
                z = true;
            }
            if (this.zzws != zzcw.zznh) {
                this.zzboq.set(zzeg.zzb(this.zzbos.zzbrf, zze(this.context), z, this.zzws));
            }
            if (this.zzws != zzcw.zzng) {
                this.zzbor.set(zzdp.zza(this.zzbos.zzbrf, zze(this.context), z));
            }
        } finally {
            this.zzbot.countDown();
            this.context = null;
            this.zzbos = null;
        }
    }

    public final String zza(Context context2, View view, Activity activity) {
        zzdv zzca = zzca();
        return zzca != null ? zzca.zza(context2, view, activity) : "";
    }

    public final String zzb(Context context2) {
        zzdv zzdv;
        if (!zzjz()) {
            return "";
        }
        int i = this.zzws;
        if (i == zzcw.zznh || i == zzcw.zzni) {
            zzdv = this.zzbor.get();
        } else {
            zzdv = this.zzboq.get();
        }
        if (zzdv == null) {
            return "";
        }
        zzka();
        return zzdv.zzb(zze(context2));
    }

    public final String zza(Context context2, String str, View view) {
        return zza(context2, str, view, (Activity) null);
    }

    public final String zza(Context context2, String str, View view, Activity activity) {
        zzdv zzca;
        if (!zzjz() || (zzca = zzca()) == null) {
            return "";
        }
        zzka();
        return zzca.zza(zze(context2), str, view, activity);
    }

    public final void zzb(View view) {
        zzdv zzca = zzca();
        if (zzca != null) {
            zzca.zzb(view);
        }
    }

    public final void zza(MotionEvent motionEvent) {
        zzdv zzca = zzca();
        if (zzca != null) {
            zzka();
            zzca.zza(motionEvent);
            return;
        }
        this.zzbop.add(new Object[]{motionEvent});
    }

    public final void zza(int i, int i2, int i3) {
        zzdv zzca = zzca();
        if (zzca != null) {
            zzka();
            zzca.zza(i, i2, i3);
            return;
        }
        this.zzbop.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }
}
