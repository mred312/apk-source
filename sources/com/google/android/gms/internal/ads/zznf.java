package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zznf implements zzna {

    /* renamed from: a */
    private final zzna[] f16746a;

    /* renamed from: b */
    private final ArrayList<zzna> f16747b;

    /* renamed from: c */
    private final zzie f16748c = new zzie();

    /* renamed from: d */
    private zznd f16749d;

    /* renamed from: e */
    private zzhz f16750e;

    /* renamed from: f */
    private Object f16751f;

    /* renamed from: g */
    private int f16752g = -1;

    /* renamed from: h */
    private zznh f16753h;

    public zznf(zzna... zznaArr) {
        this.f16746a = zznaArr;
        this.f16747b = new ArrayList<>(Arrays.asList(zznaArr));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m9025a(int i, zzhz zzhz, Object obj) {
        zznh zznh;
        if (this.f16753h == null) {
            int zzff = zzhz.zzff();
            for (int i2 = 0; i2 < zzff; i2++) {
                zzhz.zza(i2, this.f16748c, false);
            }
            if (this.f16752g == -1) {
                this.f16752g = zzhz.zzfg();
            } else if (zzhz.zzfg() != this.f16752g) {
                zznh = new zznh(1);
                this.f16753h = zznh;
            }
            zznh = null;
            this.f16753h = zznh;
        }
        if (this.f16753h == null) {
            this.f16747b.remove(this.f16746a[i]);
            if (i == 0) {
                this.f16750e = zzhz;
                this.f16751f = obj;
            }
            if (this.f16747b.isEmpty()) {
                this.f16749d.zzb(this.f16750e, this.f16751f);
            }
        }
    }

    public final void zza(zzhd zzhd, boolean z, zznd zznd) {
        this.f16749d = zznd;
        int i = 0;
        while (true) {
            zzna[] zznaArr = this.f16746a;
            if (i < zznaArr.length) {
                zznaArr[i].zza(zzhd, false, new gg0(this, i));
                i++;
            } else {
                return;
            }
        }
    }

    public final void zzb(zzmy zzmy) {
        fg0 fg0 = (fg0) zzmy;
        int i = 0;
        while (true) {
            zzna[] zznaArr = this.f16746a;
            if (i < zznaArr.length) {
                zznaArr[i].zzb(fg0.f8459a[i]);
                i++;
            } else {
                return;
            }
        }
    }

    public final void zzhz() {
        zznh zznh = this.f16753h;
        if (zznh == null) {
            for (zzna zzhz : this.f16746a) {
                zzhz.zzhz();
            }
            return;
        }
        throw zznh;
    }

    public final void zzia() {
        for (zzna zzia : this.f16746a) {
            zzia.zzia();
        }
    }

    public final zzmy zza(int i, zzol zzol) {
        int length = this.f16746a.length;
        zzmy[] zzmyArr = new zzmy[length];
        for (int i2 = 0; i2 < length; i2++) {
            zzmyArr[i2] = this.f16746a[i2].zza(i, zzol);
        }
        return new fg0(zzmyArr);
    }
}
