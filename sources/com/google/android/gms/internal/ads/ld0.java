package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class ld0 implements zzhd {

    /* renamed from: a */
    private final zzhy[] f9836a;

    /* renamed from: b */
    private final zzoh f9837b;

    /* renamed from: c */
    private final zzoe f9838c;

    /* renamed from: d */
    private final Handler f9839d;

    /* renamed from: e */
    private final nd0 f9840e;

    /* renamed from: f */
    private final CopyOnWriteArraySet<zzhg> f9841f;

    /* renamed from: g */
    private final zzie f9842g;

    /* renamed from: h */
    private final zzib f9843h;

    /* renamed from: i */
    private boolean f9844i;

    /* renamed from: j */
    private boolean f9845j;

    /* renamed from: k */
    private int f9846k;

    /* renamed from: l */
    private int f9847l;

    /* renamed from: m */
    private int f9848m;

    /* renamed from: n */
    private boolean f9849n;

    /* renamed from: o */
    private zzhz f9850o;

    /* renamed from: p */
    private Object f9851p;

    /* renamed from: q */
    private zznq f9852q;

    /* renamed from: r */
    private zzoe f9853r;

    /* renamed from: s */
    private zzhv f9854s;

    /* renamed from: t */
    private zzho f9855t;

    /* renamed from: u */
    private int f9856u;

    /* renamed from: v */
    private long f9857v;

    @SuppressLint({"HandlerLeak"})
    public ld0(zzhy[] zzhyArr, zzoh zzoh, zzht zzht) {
        String str = zzpt.zzbkl;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 26);
        sb.append("Init ExoPlayerLib/2.4.2 [");
        sb.append(str);
        sb.append("]");
        Log.i("ExoPlayerImpl", sb.toString());
        zzpc.checkState(zzhyArr.length > 0);
        this.f9836a = (zzhy[]) zzpc.checkNotNull(zzhyArr);
        this.f9837b = (zzoh) zzpc.checkNotNull(zzoh);
        this.f9845j = false;
        this.f9846k = 1;
        this.f9841f = new CopyOnWriteArraySet<>();
        zzoe zzoe = new zzoe(new zzoc[zzhyArr.length]);
        this.f9838c = zzoe;
        this.f9850o = zzhz.zzaib;
        this.f9842g = new zzie();
        this.f9843h = new zzib();
        this.f9852q = zznq.zzbgs;
        this.f9853r = zzoe;
        this.f9854s = zzhv.zzahx;
        kd0 kd0 = new kd0(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        this.f9839d = kd0;
        zzho zzho = new zzho(0, 0);
        this.f9855t = zzho;
        this.f9840e = new nd0(zzhyArr, zzoh, zzht, this.f9845j, 0, kd0, zzho, this);
    }

    /* renamed from: b */
    private final int m6452b() {
        if (this.f9850o.isEmpty() || this.f9847l > 0) {
            return this.f9856u;
        }
        this.f9850o.zza(this.f9855t.zzafq, this.f9843h, false);
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo14387a(Message message) {
        boolean z = true;
        switch (message.what) {
            case 0:
                this.f9848m--;
                return;
            case 1:
                this.f9846k = message.arg1;
                Iterator<zzhg> it = this.f9841f.iterator();
                while (it.hasNext()) {
                    it.next().zza(this.f9845j, this.f9846k);
                }
                return;
            case 2:
                if (message.arg1 == 0) {
                    z = false;
                }
                this.f9849n = z;
                Iterator<zzhg> it2 = this.f9841f.iterator();
                while (it2.hasNext()) {
                    it2.next().zzg(this.f9849n);
                }
                return;
            case 3:
                if (this.f9848m == 0) {
                    zzoj zzoj = (zzoj) message.obj;
                    this.f9844i = true;
                    this.f9852q = zzoj.zzbhu;
                    this.f9853r = zzoj.zzbhv;
                    this.f9837b.zzd(zzoj.zzbhw);
                    Iterator<zzhg> it3 = this.f9841f.iterator();
                    while (it3.hasNext()) {
                        it3.next().zza(this.f9852q, this.f9853r);
                    }
                    return;
                }
                return;
            case 4:
                int i = this.f9847l - 1;
                this.f9847l = i;
                if (i == 0) {
                    this.f9855t = (zzho) message.obj;
                    if (message.arg1 != 0) {
                        Iterator<zzhg> it4 = this.f9841f.iterator();
                        while (it4.hasNext()) {
                            it4.next().zzen();
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.f9847l == 0) {
                    this.f9855t = (zzho) message.obj;
                    Iterator<zzhg> it5 = this.f9841f.iterator();
                    while (it5.hasNext()) {
                        it5.next().zzen();
                    }
                    return;
                }
                return;
            case 6:
                zzhq zzhq = (zzhq) message.obj;
                this.f9847l -= zzhq.zzahu;
                if (this.f9848m == 0) {
                    this.f9850o = zzhq.zzafc;
                    this.f9851p = zzhq.zzafd;
                    this.f9855t = zzhq.zzafh;
                    Iterator<zzhg> it6 = this.f9841f.iterator();
                    while (it6.hasNext()) {
                        it6.next().zza(this.f9850o, this.f9851p);
                    }
                    return;
                }
                return;
            case 7:
                zzhv zzhv = (zzhv) message.obj;
                if (!this.f9854s.equals(zzhv)) {
                    this.f9854s = zzhv;
                    Iterator<zzhg> it7 = this.f9841f.iterator();
                    while (it7.hasNext()) {
                        it7.next().zza(zzhv);
                    }
                    return;
                }
                return;
            case 8:
                zzhe zzhe = (zzhe) message.obj;
                Iterator<zzhg> it8 = this.f9841f.iterator();
                while (it8.hasNext()) {
                    it8.next().zza(zzhe);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }

    public final long getBufferedPosition() {
        if (this.f9850o.isEmpty() || this.f9847l > 0) {
            return this.f9857v;
        }
        this.f9850o.zza(this.f9855t.zzafq, this.f9843h, false);
        return this.f9843h.zzfh() + zzhb.zzdm(this.f9855t.zzagv);
    }

    public final long getDuration() {
        if (this.f9850o.isEmpty()) {
            return -9223372036854775807L;
        }
        return zzhb.zzdm(this.f9850o.zza(m6452b(), this.f9842g, false).zzaif);
    }

    public final int getPlaybackState() {
        return this.f9846k;
    }

    public final void release() {
        this.f9840e.mo14481a();
        this.f9839d.removeCallbacksAndMessages((Object) null);
    }

    public final void seekTo(long j) {
        long j2;
        int b = m6452b();
        if (b < 0 || (!this.f9850o.isEmpty() && b >= this.f9850o.zzff())) {
            throw new zzhu(this.f9850o, b, j);
        }
        this.f9847l++;
        this.f9856u = b;
        if (!this.f9850o.isEmpty()) {
            this.f9850o.zza(b, this.f9842g, false);
            if (j == -9223372036854775807L) {
                j2 = 0;
            } else {
                j2 = zzhb.zzdn(j);
            }
            long j3 = j2 + 0;
            long j4 = this.f9850o.zza(0, this.f9843h, false).zzaif;
            if (j4 != -9223372036854775807L) {
                int i = (j3 > j4 ? 1 : (j3 == j4 ? 0 : -1));
            }
        }
        if (j == -9223372036854775807L) {
            this.f9857v = 0;
            this.f9840e.mo14484j(this.f9850o, b, -9223372036854775807L);
            return;
        }
        this.f9857v = j;
        this.f9840e.mo14484j(this.f9850o, b, zzhb.zzdn(j));
        Iterator<zzhg> it = this.f9841f.iterator();
        while (it.hasNext()) {
            it.next().zzen();
        }
    }

    public final void stop() {
        this.f9840e.mo14482c();
    }

    public final void zza(zzhg zzhg) {
        this.f9841f.add(zzhg);
    }

    public final void zzb(zzhg zzhg) {
        this.f9841f.remove(zzhg);
    }

    public final boolean zzek() {
        return this.f9845j;
    }

    public final int zzel() {
        return this.f9836a.length;
    }

    public final long zzem() {
        if (this.f9850o.isEmpty() || this.f9847l > 0) {
            return this.f9857v;
        }
        this.f9850o.zza(this.f9855t.zzafq, this.f9843h, false);
        return this.f9843h.zzfh() + zzhb.zzdm(this.f9855t.zzagu);
    }

    public final void zzf(boolean z) {
        if (this.f9845j != z) {
            this.f9845j = z;
            this.f9840e.mo14480C(z);
            Iterator<zzhg> it = this.f9841f.iterator();
            while (it.hasNext()) {
                it.next().zza(z, this.f9846k);
            }
        }
    }

    public final void zza(zzna zzna) {
        if (!this.f9850o.isEmpty() || this.f9851p != null) {
            this.f9850o = zzhz.zzaib;
            this.f9851p = null;
            Iterator<zzhg> it = this.f9841f.iterator();
            while (it.hasNext()) {
                it.next().zza(this.f9850o, this.f9851p);
            }
        }
        if (this.f9844i) {
            this.f9844i = false;
            this.f9852q = zznq.zzbgs;
            this.f9853r = this.f9838c;
            this.f9837b.zzd((Object) null);
            Iterator<zzhg> it2 = this.f9841f.iterator();
            while (it2.hasNext()) {
                it2.next().zza(this.f9852q, this.f9853r);
            }
        }
        this.f9848m++;
        this.f9840e.mo14485k(zzna, true);
    }

    public final void zzb(zzhi... zzhiArr) {
        this.f9840e.mo14487s(zzhiArr);
    }

    public final void zza(zzhi... zzhiArr) {
        this.f9840e.mo14486m(zzhiArr);
    }
}
