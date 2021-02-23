package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public class zzji {

    /* renamed from: a */
    private int f16548a;

    public void clear() {
        this.f16548a = 0;
    }

    public final void setFlags(int i) {
        this.f16548a = i;
    }

    public final void zzaa(int i) {
        this.f16548a |= Integer.MIN_VALUE;
    }

    /* access modifiers changed from: protected */
    public final boolean zzab(int i) {
        return (this.f16548a & i) == i;
    }

    public final boolean zzgk() {
        return zzab(Integer.MIN_VALUE);
    }

    public final boolean zzgl() {
        return zzab(4);
    }

    public final boolean zzgm() {
        return zzab(1);
    }
}
