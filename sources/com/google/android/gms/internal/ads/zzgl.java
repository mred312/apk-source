package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public abstract class zzgl implements Callable {

    /* renamed from: a */
    private final String f16432a;

    /* renamed from: b */
    private final String f16433b;

    /* renamed from: c */
    private final int f16434c;

    /* renamed from: d */
    private final int f16435d;
    protected final zzcf.zza.C3977zza zzaay;
    protected Method zzabi;
    protected final zzfa zzwb;

    public zzgl(zzfa zzfa, String str, String str2, zzcf.zza.C3977zza zza, int i, int i2) {
        getClass().getSimpleName();
        this.zzwb = zzfa;
        this.f16432a = str;
        this.f16433b = str2;
        this.zzaay = zza;
        this.f16434c = i;
        this.f16435d = i2;
    }

    /* access modifiers changed from: protected */
    public abstract void zzcw();

    /* renamed from: zzcy */
    public Void call() {
        int i;
        try {
            long nanoTime = System.nanoTime();
            Method zza = this.zzwb.zza(this.f16432a, this.f16433b);
            this.zzabi = zza;
            if (zza == null) {
                return null;
            }
            zzcw();
            zzdt zzcl = this.zzwb.zzcl();
            if (!(zzcl == null || (i = this.f16434c) == Integer.MIN_VALUE)) {
                zzcl.zza(this.f16435d, i, (System.nanoTime() - nanoTime) / 1000);
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }
}
