package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdal implements zzdfi<zzdai> {

    /* renamed from: a */
    private final zzdfi<zzdfp> f15135a;

    /* renamed from: b */
    private final zzdnn f15136b;

    /* renamed from: c */
    private final Context f15137c;

    /* renamed from: d */
    private final zzayg f15138d;

    public zzdal(zzdbw<zzdfp> zzdbw, zzdnn zzdnn, Context context, zzayg zzayg) {
        this.f15135a = zzdbw;
        this.f15136b = zzdnn;
        this.f15137c = context;
        this.f15138d = zzayg;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ zzdai mo17072a(zzdfp zzdfp) {
        boolean z;
        String str;
        int i;
        int i2;
        float f;
        String str2;
        int i3;
        DisplayMetrics displayMetrics;
        zzvn zzvn = this.f15136b.zzbpe;
        zzvn[] zzvnArr = zzvn.zzchq;
        if (zzvnArr != null) {
            str = null;
            boolean z2 = false;
            boolean z3 = false;
            z = false;
            for (zzvn zzvn2 : zzvnArr) {
                boolean z4 = zzvn2.zzchr;
                if (!z4 && !z2) {
                    str = zzvn2.zzacv;
                    z2 = true;
                }
                if (z4 && !z3) {
                    z3 = true;
                    z = true;
                }
                if (z2 && z3) {
                    break;
                }
            }
        } else {
            str = zzvn.zzacv;
            z = zzvn.zzchr;
        }
        Resources resources = this.f15137c.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            str2 = null;
            f = 0.0f;
            i2 = 0;
            i = 0;
        } else {
            float f2 = displayMetrics.density;
            int i4 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
            str2 = this.f15138d.zzwz().zzyb();
            i2 = i4;
            f = f2;
        }
        StringBuilder sb = new StringBuilder();
        zzvn[] zzvnArr2 = zzvn.zzchq;
        if (zzvnArr2 != null) {
            boolean z5 = false;
            for (zzvn zzvn3 : zzvnArr2) {
                if (zzvn3.zzchr) {
                    z5 = true;
                } else {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    int i5 = zzvn3.width;
                    if (i5 == -1 && f != 0.0f) {
                        i5 = (int) (((float) zzvn3.widthPixels) / f);
                    }
                    sb.append(i5);
                    sb.append("x");
                    int i6 = zzvn3.height;
                    if (i6 == -2) {
                        if (f != 0.0f) {
                            i6 = (int) (((float) zzvn3.heightPixels) / f);
                        }
                    }
                    sb.append(i6);
                }
            }
            if (z5) {
                if (sb.length() != 0) {
                    i3 = 0;
                    sb.insert(0, "|");
                } else {
                    i3 = 0;
                }
                sb.insert(i3, "320x50");
            }
        }
        return new zzdai(zzvn, str, z, sb.toString(), f, i2, i, str2, this.f15136b.zzgyj);
    }

    public final zzdyz<zzdai> zzasm() {
        return zzdyr.zzb(this.f15135a.zzasm(), new C2261os(this), (Executor) zzazj.zzegu);
    }
}
