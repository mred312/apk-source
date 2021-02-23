package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzmw implements zzna, zznd {

    /* renamed from: a */
    private final Uri f16735a;

    /* renamed from: b */
    private final zzom f16736b;

    /* renamed from: c */
    private final zzkb f16737c;

    /* renamed from: d */
    private final int f16738d;

    /* renamed from: e */
    private final Handler f16739e;

    /* renamed from: f */
    private final zzmz f16740f;

    /* renamed from: g */
    private final zzib f16741g = new zzib();

    /* renamed from: h */
    private final int f16742h;

    /* renamed from: i */
    private zznd f16743i;

    /* renamed from: j */
    private zzhz f16744j;

    /* renamed from: k */
    private boolean f16745k;

    public zzmw(Uri uri, zzom zzom, zzkb zzkb, int i, Handler handler, zzmz zzmz, String str, int i2) {
        this.f16735a = uri;
        this.f16736b = zzom;
        this.f16737c = zzkb;
        this.f16738d = i;
        this.f16739e = handler;
        this.f16740f = zzmz;
        this.f16742h = i2;
    }

    public final void zza(zzhd zzhd, boolean z, zznd zznd) {
        this.f16743i = zznd;
        zzno zzno = new zzno(-9223372036854775807L, false);
        this.f16744j = zzno;
        zznd.zzb(zzno, (Object) null);
    }

    public final void zzb(zzmy zzmy) {
        ((xf0) zzmy).mo15030a();
    }

    public final void zzhz() {
    }

    public final void zzia() {
        this.f16743i = null;
    }

    public final void zzb(zzhz zzhz, Object obj) {
        boolean z = false;
        if (zzhz.zza(0, this.f16741g, false).zzaif != -9223372036854775807L) {
            z = true;
        }
        if (!this.f16745k || z) {
            this.f16744j = zzhz;
            this.f16745k = z;
            this.f16743i.zzb(zzhz, (Object) null);
        }
    }

    public final zzmy zza(int i, zzol zzol) {
        zzpc.checkArgument(i == 0);
        return new xf0(this.f16735a, this.f16736b.zzip(), this.f16737c.zzgt(), this.f16738d, this.f16739e, this.f16740f, this, zzol, (String) null, this.f16742h);
    }
}
