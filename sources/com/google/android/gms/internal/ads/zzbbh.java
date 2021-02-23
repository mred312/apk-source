package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzat;
import com.google.android.gms.ads.internal.util.zzav;
import com.google.android.gms.ads.internal.util.zzay;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbbh {

    /* renamed from: a */
    private final Context f13056a;

    /* renamed from: b */
    private final String f13057b;

    /* renamed from: c */
    private final zzazh f13058c;
    @Nullable

    /* renamed from: d */
    private final zzabq f13059d;
    @Nullable

    /* renamed from: e */
    private final zzabs f13060e;

    /* renamed from: f */
    private final zzat f13061f = new zzay().zza("min_1", Double.MIN_VALUE, 1.0d).zza("1_5", 1.0d, 5.0d).zza("5_10", 5.0d, 10.0d).zza("10_20", 10.0d, 20.0d).zza("20_30", 20.0d, 30.0d).zza("30_max", 30.0d, Double.MAX_VALUE).zzyv();

    /* renamed from: g */
    private final long[] f13062g;

    /* renamed from: h */
    private final String[] f13063h;

    /* renamed from: i */
    private boolean f13064i = false;

    /* renamed from: j */
    private boolean f13065j = false;

    /* renamed from: k */
    private boolean f13066k = false;

    /* renamed from: l */
    private boolean f13067l = false;

    /* renamed from: m */
    private boolean f13068m;

    /* renamed from: n */
    private zzbap f13069n;

    /* renamed from: o */
    private boolean f13070o;

    /* renamed from: p */
    private boolean f13071p;

    /* renamed from: q */
    private long f13072q = -1;

    public zzbbh(Context context, zzazh zzazh, String str, @Nullable zzabs zzabs, @Nullable zzabq zzabq) {
        this.f13056a = context;
        this.f13058c = zzazh;
        this.f13057b = str;
        this.f13060e = zzabs;
        this.f13059d = zzabq;
        String str2 = (String) zzwq.zzqe().zzd(zzabf.zzcml);
        if (str2 == null) {
            this.f13063h = new String[0];
            this.f13062g = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        this.f13063h = new String[split.length];
        this.f13062g = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.f13062g[i] = Long.parseLong(split[i]);
            } catch (NumberFormatException e) {
                zzaza.zzd("Unable to parse frame hash target time number.", e);
                this.f13062g[i] = -1;
            }
        }
    }

    public final void onStop() {
        if (zzadn.zzddx.get().booleanValue() && !this.f13070o) {
            Bundle bundle = new Bundle();
            bundle.putString("type", "native-player-metrics");
            bundle.putString("request", this.f13057b);
            bundle.putString("player", this.f13069n.zzzk());
            for (zzav next : this.f13061f.zzyu()) {
                String valueOf = String.valueOf(next.name);
                bundle.putString(valueOf.length() != 0 ? "fps_c_".concat(valueOf) : new String("fps_c_"), Integer.toString(next.count));
                String valueOf2 = String.valueOf(next.name);
                bundle.putString(valueOf2.length() != 0 ? "fps_p_".concat(valueOf2) : new String("fps_p_"), Double.toString(next.zzeel));
            }
            int i = 0;
            while (true) {
                long[] jArr = this.f13062g;
                if (i < jArr.length) {
                    String str = this.f13063h[i];
                    if (str != null) {
                        String valueOf3 = String.valueOf(Long.valueOf(jArr[i]));
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf3).length() + 3);
                        sb.append("fh_");
                        sb.append(valueOf3);
                        bundle.putString(sb.toString(), str);
                    }
                    i++;
                } else {
                    zzp.zzkq().zza(this.f13056a, this.f13058c.zzbrf, "gmob-apps", bundle, true);
                    this.f13070o = true;
                    return;
                }
            }
        }
    }

    public final void zzaat() {
        this.f13068m = true;
        if (this.f13065j && !this.f13066k) {
            zzabn.zza(this.f13060e, this.f13059d, "vfp2");
            this.f13066k = true;
        }
    }

    public final void zzaau() {
        this.f13068m = false;
    }

    public final void zzb(zzbap zzbap) {
        zzabn.zza(this.f13060e, this.f13059d, "vpc2");
        this.f13064i = true;
        zzabs zzabs = this.f13060e;
        if (zzabs != null) {
            zzabs.zzh("vpn", zzbap.zzzk());
        }
        this.f13069n = zzbap;
    }

    public final void zzc(zzbap zzbap) {
        if (this.f13066k && !this.f13067l) {
            if (zzd.zzxn() && !this.f13067l) {
                zzd.zzee("VideoMetricsMixin first frame");
            }
            zzabn.zza(this.f13060e, this.f13059d, "vff2");
            this.f13067l = true;
        }
        long nanoTime = zzp.zzkx().nanoTime();
        if (this.f13068m && this.f13071p && this.f13072q != -1) {
            double nanos = (double) TimeUnit.SECONDS.toNanos(1);
            double d = (double) (nanoTime - this.f13072q);
            Double.isNaN(nanos);
            Double.isNaN(d);
            this.f13061f.zza(nanos / d);
        }
        this.f13071p = this.f13068m;
        this.f13072q = nanoTime;
        long longValue = ((Long) zzwq.zzqe().zzd(zzabf.zzcmm)).longValue();
        long currentPosition = (long) zzbap.getCurrentPosition();
        int i = 0;
        while (true) {
            String[] strArr = this.f13063h;
            if (i >= strArr.length) {
                return;
            }
            if (strArr[i] != null || longValue <= Math.abs(currentPosition - this.f13062g[i])) {
                zzbap zzbap2 = zzbap;
                i++;
            } else {
                String[] strArr2 = this.f13063h;
                int i2 = 8;
                Bitmap bitmap = zzbap.getBitmap(8, 8);
                long j = 63;
                int i3 = 0;
                long j2 = 0;
                while (i3 < i2) {
                    int i4 = 0;
                    while (i4 < i2) {
                        int pixel = bitmap.getPixel(i4, i3);
                        j2 |= ((Color.blue(pixel) + Color.red(pixel)) + Color.green(pixel) > 128 ? 1 : 0) << ((int) j);
                        i4++;
                        j--;
                        i2 = 8;
                    }
                    i3++;
                    i2 = 8;
                }
                strArr2[i] = String.format("%016X", new Object[]{Long.valueOf(j2)});
                return;
            }
        }
    }

    public final void zzfb() {
        if (this.f13064i && !this.f13065j) {
            zzabn.zza(this.f13060e, this.f13059d, "vfr2");
            this.f13065j = true;
        }
    }
}
