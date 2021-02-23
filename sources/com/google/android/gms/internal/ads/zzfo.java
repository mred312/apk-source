package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcf;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzfo extends zzgl {

    /* renamed from: f */
    private static zzgo<String> f16407f = new zzgo<>();

    /* renamed from: e */
    private final Context f16408e;

    public zzfo(zzfa zzfa, String str, String str2, zzcf.zza.C3977zza zza, int i, int i2, Context context) {
        super(zzfa, str, str2, zza, i, 29);
        this.f16408e = context;
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        this.zzaay.zzw("E");
        AtomicReference<String> zzas = f16407f.zzas(this.f16408e.getPackageName());
        if (zzas.get() == null) {
            synchronized (zzas) {
                if (zzas.get() == null) {
                    zzas.set((String) this.zzabi.invoke((Object) null, new Object[]{this.f16408e}));
                }
            }
        }
        String str = zzas.get();
        synchronized (this.zzaay) {
            this.zzaay.zzw(zzcv.zza(str.getBytes(), true));
        }
    }
}
