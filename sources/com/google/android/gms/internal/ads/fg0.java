package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.IdentityHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class fg0 implements zzmy, zznb {

    /* renamed from: a */
    public final zzmy[] f8459a;

    /* renamed from: b */
    private final IdentityHashMap<zznn, Integer> f8460b = new IdentityHashMap<>();

    /* renamed from: c */
    private zznb f8461c;

    /* renamed from: d */
    private int f8462d;

    /* renamed from: e */
    private zznq f8463e;

    /* renamed from: f */
    private zzmy[] f8464f;

    /* renamed from: g */
    private zznm f8465g;

    public fg0(zzmy... zzmyArr) {
        this.f8459a = zzmyArr;
    }

    public final void zza(zznb zznb, long j) {
        this.f8461c = zznb;
        zzmy[] zzmyArr = this.f8459a;
        this.f8462d = zzmyArr.length;
        for (zzmy zza : zzmyArr) {
            zza.zza(this, j);
        }
    }

    public final void zzee(long j) {
        for (zzmy zzee : this.f8464f) {
            zzee.zzee(j);
        }
    }

    public final boolean zzef(long j) {
        return this.f8465g.zzef(j);
    }

    public final long zzeg(long j) {
        long zzeg = this.f8464f[0].zzeg(j);
        int i = 1;
        while (true) {
            zzmy[] zzmyArr = this.f8464f;
            if (i >= zzmyArr.length) {
                return zzeg;
            }
            if (zzmyArr[i].zzeg(zzeg) == zzeg) {
                i++;
            } else {
                throw new IllegalStateException("Children seeked to different positions");
            }
        }
    }

    public final void zzhn() {
        for (zzmy zzhn : this.f8459a) {
            zzhn.zzhn();
        }
    }

    public final zznq zzho() {
        return this.f8463e;
    }

    public final long zzhp() {
        return this.f8465g.zzhp();
    }

    public final long zzhq() {
        long zzhq = this.f8459a[0].zzhq();
        int i = 1;
        while (true) {
            zzmy[] zzmyArr = this.f8459a;
            if (i >= zzmyArr.length) {
                if (zzhq != -9223372036854775807L) {
                    zzmy[] zzmyArr2 = this.f8464f;
                    int length = zzmyArr2.length;
                    int i2 = 0;
                    while (i2 < length) {
                        zzmy zzmy = zzmyArr2[i2];
                        if (zzmy == this.f8459a[0] || zzmy.zzeg(zzhq) == zzhq) {
                            i2++;
                        } else {
                            throw new IllegalStateException("Children seeked to different positions");
                        }
                    }
                }
                return zzhq;
            } else if (zzmyArr[i].zzhq() == -9223372036854775807L) {
                i++;
            } else {
                throw new IllegalStateException("Child reported discontinuity");
            }
        }
    }

    public final long zzhr() {
        long j = Long.MAX_VALUE;
        for (zzmy zzhr : this.f8464f) {
            long zzhr2 = zzhr.zzhr();
            if (zzhr2 != Long.MIN_VALUE) {
                j = Math.min(j, zzhr2);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public final long zza(zzoc[] zzocArr, boolean[] zArr, zznn[] zznnArr, boolean[] zArr2, long j) {
        int i;
        zzoc[] zzocArr2 = zzocArr;
        zznn[] zznnArr2 = zznnArr;
        int[] iArr = new int[zzocArr2.length];
        int[] iArr2 = new int[zzocArr2.length];
        for (int i2 = 0; i2 < zzocArr2.length; i2++) {
            if (zznnArr2[i2] == null) {
                i = -1;
            } else {
                i = this.f8460b.get(zznnArr2[i2]).intValue();
            }
            iArr[i2] = i;
            iArr2[i2] = -1;
            if (zzocArr2[i2] != null) {
                zznr zzil = zzocArr2[i2].zzil();
                int i3 = 0;
                while (true) {
                    zzmy[] zzmyArr = this.f8459a;
                    if (i3 >= zzmyArr.length) {
                        break;
                    } else if (zzmyArr[i3].zzho().zza(zzil) != -1) {
                        iArr2[i2] = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        this.f8460b.clear();
        int length = zzocArr2.length;
        zznn[] zznnArr3 = new zznn[length];
        zznn[] zznnArr4 = new zznn[zzocArr2.length];
        zzoc[] zzocArr3 = new zzoc[zzocArr2.length];
        ArrayList arrayList = new ArrayList(this.f8459a.length);
        long j2 = j;
        int i4 = 0;
        while (i4 < this.f8459a.length) {
            for (int i5 = 0; i5 < zzocArr2.length; i5++) {
                zzoc zzoc = null;
                zznnArr4[i5] = iArr[i5] == i4 ? zznnArr2[i5] : null;
                if (iArr2[i5] == i4) {
                    zzoc = zzocArr2[i5];
                }
                zzocArr3[i5] = zzoc;
            }
            int i6 = i4;
            zzoc[] zzocArr4 = zzocArr3;
            ArrayList arrayList2 = arrayList;
            long zza = this.f8459a[i4].zza(zzocArr3, zArr, zznnArr4, zArr2, j2);
            if (i6 == 0) {
                j2 = zza;
            } else if (zza != j2) {
                throw new IllegalStateException("Children enabled at different positions");
            }
            boolean z = false;
            for (int i7 = 0; i7 < zzocArr2.length; i7++) {
                boolean z2 = true;
                if (iArr2[i7] == i6) {
                    zzpc.checkState(zznnArr4[i7] != null);
                    zznnArr3[i7] = zznnArr4[i7];
                    this.f8460b.put(zznnArr4[i7], Integer.valueOf(i6));
                    z = true;
                } else if (iArr[i7] == i6) {
                    if (zznnArr4[i7] != null) {
                        z2 = false;
                    }
                    zzpc.checkState(z2);
                }
            }
            if (z) {
                arrayList2.add(this.f8459a[i6]);
            }
            i4 = i6 + 1;
            arrayList = arrayList2;
            zzocArr3 = zzocArr4;
            zznnArr2 = zznnArr;
        }
        zznn[] zznnArr5 = zznnArr2;
        ArrayList arrayList3 = arrayList;
        System.arraycopy(zznnArr3, 0, zznnArr5, 0, length);
        zzmy[] zzmyArr2 = new zzmy[arrayList3.size()];
        this.f8464f = zzmyArr2;
        arrayList3.toArray(zzmyArr2);
        this.f8465g = new zzmp(this.f8464f);
        return j2;
    }

    public final void zza(zzmy zzmy) {
        int i = this.f8462d - 1;
        this.f8462d = i;
        if (i <= 0) {
            int i2 = 0;
            for (zzmy zzho : this.f8459a) {
                i2 += zzho.zzho().length;
            }
            zznr[] zznrArr = new zznr[i2];
            int i3 = 0;
            for (zzmy zzho2 : this.f8459a) {
                zznq zzho3 = zzho2.zzho();
                int i4 = zzho3.length;
                int i5 = 0;
                while (i5 < i4) {
                    zznrArr[i3] = zzho3.zzbb(i5);
                    i5++;
                    i3++;
                }
            }
            this.f8463e = new zznq(zznrArr);
            this.f8461c.zza(this);
        }
    }

    public final /* synthetic */ void zza(zznm zznm) {
        if (this.f8463e != null) {
            this.f8461c.zza(this);
        }
    }
}
