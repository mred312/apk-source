package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public abstract class zzhc implements zzhx, zzhy {

    /* renamed from: a */
    private final int f16440a;

    /* renamed from: b */
    private zzia f16441b;

    /* renamed from: c */
    private int f16442c;

    /* renamed from: d */
    private int f16443d;

    /* renamed from: e */
    private zznn f16444e;

    /* renamed from: f */
    private long f16445f;

    /* renamed from: g */
    private boolean f16446g = true;

    /* renamed from: h */
    private boolean f16447h;

    public zzhc(int i) {
        this.f16440a = i;
    }

    public final void disable() {
        boolean z = true;
        if (this.f16443d != 1) {
            z = false;
        }
        zzpc.checkState(z);
        this.f16443d = 0;
        this.f16444e = null;
        this.f16447h = false;
        zzeh();
    }

    /* access modifiers changed from: protected */
    public final int getIndex() {
        return this.f16442c;
    }

    public final int getState() {
        return this.f16443d;
    }

    public final int getTrackType() {
        return this.f16440a;
    }

    /* access modifiers changed from: protected */
    public void onStarted() {
    }

    /* access modifiers changed from: protected */
    public void onStopped() {
    }

    public final void setIndex(int i) {
        this.f16442c = i;
    }

    public final void start() {
        boolean z = true;
        if (this.f16443d != 1) {
            z = false;
        }
        zzpc.checkState(z);
        this.f16443d = 2;
        onStarted();
    }

    public final void stop() {
        zzpc.checkState(this.f16443d == 2);
        this.f16443d = 1;
        onStopped();
    }

    public void zza(int i, Object obj) {
    }

    /* access modifiers changed from: protected */
    public void zza(long j, boolean z) {
    }

    public final void zza(zzia zzia, zzhp[] zzhpArr, zznn zznn, long j, boolean z, long j2) {
        zzpc.checkState(this.f16443d == 0);
        this.f16441b = zzia;
        this.f16443d = 1;
        zze(z);
        zza(zzhpArr, zznn, j2);
        zza(j, z);
    }

    /* access modifiers changed from: protected */
    public void zza(zzhp[] zzhpArr, long j) {
    }

    public final void zzdo(long j) {
        this.f16447h = false;
        this.f16446g = false;
        zza(j, false);
    }

    /* access modifiers changed from: protected */
    public final void zzdp(long j) {
        this.f16444e.zzeh(j - this.f16445f);
    }

    public final zzhx zzdz() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void zze(boolean z) {
    }

    public zzpg zzea() {
        return null;
    }

    public final zznn zzeb() {
        return this.f16444e;
    }

    public final boolean zzec() {
        return this.f16446g;
    }

    public final void zzed() {
        this.f16447h = true;
    }

    public final boolean zzee() {
        return this.f16447h;
    }

    public final void zzef() {
        this.f16444e.zzhs();
    }

    public int zzeg() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void zzeh() {
    }

    /* access modifiers changed from: protected */
    public final zzia zzei() {
        return this.f16441b;
    }

    /* access modifiers changed from: protected */
    public final boolean zzej() {
        return this.f16446g ? this.f16447h : this.f16444e.isReady();
    }

    public final void zza(zzhp[] zzhpArr, zznn zznn, long j) {
        zzpc.checkState(!this.f16447h);
        this.f16444e = zznn;
        this.f16446g = false;
        this.f16445f = j;
        zza(zzhpArr, j);
    }

    /* access modifiers changed from: protected */
    public final int zza(zzhr zzhr, zzjl zzjl, boolean z) {
        int zzb = this.f16444e.zzb(zzhr, zzjl, z);
        if (zzb == -4) {
            if (zzjl.zzgl()) {
                this.f16446g = true;
                if (this.f16447h) {
                    return -4;
                }
                return -3;
            }
            zzjl.zzanz += this.f16445f;
        } else if (zzb == -5) {
            zzhp zzhp = zzhr.zzahv;
            long j = zzhp.zzahp;
            if (j != Long.MAX_VALUE) {
                zzhr.zzahv = zzhp.zzds(j + this.f16445f);
            }
        }
        return zzb;
    }
}
