package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzaqv extends zzaqu implements zzahv<zzbdv> {

    /* renamed from: c */
    private final zzbdv f12649c;

    /* renamed from: d */
    private final Context f12650d;

    /* renamed from: e */
    private final WindowManager f12651e;

    /* renamed from: f */
    private final zzaam f12652f;

    /* renamed from: g */
    private DisplayMetrics f12653g;

    /* renamed from: h */
    private float f12654h;

    /* renamed from: i */
    private int f12655i = -1;

    /* renamed from: j */
    private int f12656j = -1;

    /* renamed from: k */
    private int f12657k;

    /* renamed from: l */
    private int f12658l = -1;

    /* renamed from: m */
    private int f12659m = -1;

    /* renamed from: n */
    private int f12660n = -1;

    /* renamed from: o */
    private int f12661o = -1;

    public zzaqv(zzbdv zzbdv, Context context, zzaam zzaam) {
        super(zzbdv);
        this.f12649c = zzbdv;
        this.f12650d = context;
        this.f12652f = zzaam;
        this.f12651e = (WindowManager) context.getSystemService("window");
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbdv zzbdv = (zzbdv) obj;
        this.f12653g = new DisplayMetrics();
        Display defaultDisplay = this.f12651e.getDefaultDisplay();
        defaultDisplay.getMetrics(this.f12653g);
        this.f12654h = this.f12653g.density;
        this.f12657k = defaultDisplay.getRotation();
        zzwq.zzqa();
        DisplayMetrics displayMetrics = this.f12653g;
        this.f12655i = zzayr.zzb(displayMetrics, displayMetrics.widthPixels);
        zzwq.zzqa();
        DisplayMetrics displayMetrics2 = this.f12653g;
        this.f12656j = zzayr.zzb(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzaaj = this.f12649c.zzaaj();
        if (zzaaj == null || zzaaj.getWindow() == null) {
            this.f12658l = this.f12655i;
            this.f12659m = this.f12656j;
        } else {
            zzp.zzkq();
            int[] zzf = zzm.zzf(zzaaj);
            zzwq.zzqa();
            this.f12658l = zzayr.zzb(this.f12653g, zzf[0]);
            zzwq.zzqa();
            this.f12659m = zzayr.zzb(this.f12653g, zzf[1]);
        }
        if (this.f12649c.zzacq().zzady()) {
            this.f12660n = this.f12655i;
            this.f12661o = this.f12656j;
        } else {
            this.f12649c.measure(0, 0);
        }
        zza(this.f12655i, this.f12656j, this.f12658l, this.f12659m, this.f12654h, this.f12657k);
        this.f12649c.zzb("onDeviceFeaturesReceived", new zzaqq(new zzaqs().zzae(this.f12652f.zzrg()).zzad(this.f12652f.zzrh()).zzaf(this.f12652f.zzrj()).zzag(this.f12652f.zzri()).zzah(true)).zzdr());
        int[] iArr = new int[2];
        this.f12649c.getLocationOnScreen(iArr);
        zzj(zzwq.zzqa().zzb(this.f12650d, iArr[0]), zzwq.zzqa().zzb(this.f12650d, iArr[1]));
        if (zzaza.isLoggable(2)) {
            zzaza.zzez("Dispatching Ready Event.");
        }
        zzdu(this.f12649c.zzaao().zzbrf);
    }

    public final void zzj(int i, int i2) {
        int i3 = 0;
        if (this.f12650d instanceof Activity) {
            zzp.zzkq();
            i3 = zzm.zzh((Activity) this.f12650d)[0];
        }
        if (this.f12649c.zzacq() == null || !this.f12649c.zzacq().zzady()) {
            int width = this.f12649c.getWidth();
            int height = this.f12649c.getHeight();
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcnc)).booleanValue()) {
                if (width == 0 && this.f12649c.zzacq() != null) {
                    width = this.f12649c.zzacq().widthPixels;
                }
                if (height == 0 && this.f12649c.zzacq() != null) {
                    height = this.f12649c.zzacq().heightPixels;
                }
            }
            this.f12660n = zzwq.zzqa().zzb(this.f12650d, width);
            this.f12661o = zzwq.zzqa().zzb(this.f12650d, height);
        }
        zzb(i, i2 - i3, this.f12660n, this.f12661o);
        this.f12649c.zzacs().zzi(i, i2);
    }
}
