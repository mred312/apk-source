package com.google.android.gms.internal.ads;

import com.dream_studio.animalsounds.VolumeControl;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzq implements zzan {

    /* renamed from: a */
    private int f16846a;

    /* renamed from: b */
    private int f16847b;

    /* renamed from: c */
    private final int f16848c;

    /* renamed from: d */
    private final float f16849d;

    public zzq() {
        this(VolumeControl.VOLUME_CONTROL_VISIBILITY_TIME, 1, 1.0f);
    }

    public final void zza(zzao zzao) {
        boolean z = true;
        int i = this.f16847b + 1;
        this.f16847b = i;
        int i2 = this.f16846a;
        this.f16846a = i2 + ((int) (((float) i2) * this.f16849d));
        if (i > this.f16848c) {
            z = false;
        }
        if (!z) {
            throw zzao;
        }
    }

    public final int zzb() {
        return this.f16846a;
    }

    public final int zzc() {
        return this.f16847b;
    }

    private zzq(int i, int i2, float f) {
        this.f16846a = VolumeControl.VOLUME_CONTROL_VISIBILITY_TIME;
        this.f16848c = 1;
        this.f16849d = 1.0f;
    }
}
