package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.AdChoicesView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.ads.internal.util.zzbq;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcda {

    /* renamed from: a */
    private final zzf f14114a;

    /* renamed from: b */
    private final zzdnn f14115b;

    /* renamed from: c */
    private final zzcci f14116c;

    /* renamed from: d */
    private final zzcce f14117d;
    @Nullable

    /* renamed from: e */
    private final zzcdi f14118e;
    @Nullable

    /* renamed from: f */
    private final zzcdq f14119f;

    /* renamed from: g */
    private final Executor f14120g;

    /* renamed from: h */
    private final Executor f14121h;

    /* renamed from: i */
    private final zzadz f14122i;

    /* renamed from: j */
    private final zzcbz f14123j;

    public zzcda(zzf zzf, zzdnn zzdnn, zzcci zzcci, zzcce zzcce, @Nullable zzcdi zzcdi, @Nullable zzcdq zzcdq, Executor executor, Executor executor2, zzcbz zzcbz) {
        this.f14114a = zzf;
        this.f14115b = zzdnn;
        this.f14122i = zzdnn.zzdnh;
        this.f14116c = zzcci;
        this.f14117d = zzcce;
        this.f14118e = zzcdi;
        this.f14119f = zzcdq;
        this.f14120g = executor;
        this.f14121h = executor2;
        this.f14123j = zzcbz;
    }

    /* renamed from: a */
    private static void m7922a(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static boolean m7924c(zzcdy zzcdy, String[] strArr) {
        Map<String, WeakReference<View>> zzaof = zzcdy.zzaof();
        if (zzaof == null) {
            return false;
        }
        for (String str : strArr) {
            if (zzaof.get(str) != null) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ void mo16694d(ViewGroup viewGroup) {
        boolean z = viewGroup != null;
        if (this.f14117d.zzang() == null) {
            return;
        }
        if (2 == this.f14117d.zzanc() || 1 == this.f14117d.zzanc()) {
            this.f14114a.zza(this.f14115b.zzhip, String.valueOf(this.f14117d.zzanc()), z);
        } else if (6 == this.f14117d.zzanc()) {
            this.f14114a.zza(this.f14115b.zzhip, "2", z);
            this.f14114a.zza(this.f14115b.zzhip, "1", z);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final /* synthetic */ void mo16695e(zzcdy zzcdy) {
        ViewGroup viewGroup;
        View view;
        ViewGroup viewGroup2;
        IObjectWrapper iObjectWrapper;
        Drawable drawable;
        int i = 0;
        IObjectWrapper iObjectWrapper2 = null;
        if (this.f14116c.zzanq() || this.f14116c.zzanp()) {
            String[] strArr = {NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW};
            int i2 = 0;
            while (true) {
                if (i2 < 2) {
                    View zzgc = zzcdy.zzgc(strArr[i2]);
                    if (zzgc != null && (zzgc instanceof ViewGroup)) {
                        viewGroup = (ViewGroup) zzgc;
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
        }
        viewGroup = null;
        boolean z = viewGroup != null;
        Context context = zzcdy.zzaiz().getContext();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.f14117d.zzand() != null) {
            view = this.f14117d.zzand();
            zzadz zzadz = this.f14122i;
            if (zzadz != null && !z) {
                m7922a(layoutParams, zzadz.zzbnp);
                view.setLayoutParams(layoutParams);
            }
        } else if (!(this.f14117d.zzsx() instanceof zzadq)) {
            view = null;
        } else {
            zzadq zzadq = (zzadq) this.f14117d.zzsx();
            if (!z) {
                m7922a(layoutParams, zzadq.zzsp());
            }
            zzadt zzadt = new zzadt(context, zzadq, layoutParams);
            zzadt.setContentDescription((CharSequence) zzwq.zzqe().zzd(zzabf.zzcse));
            view = zzadt;
        }
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (z) {
                viewGroup.removeAllViews();
                viewGroup.addView(view);
            } else {
                AdChoicesView adChoicesView = new AdChoicesView(zzcdy.zzaiz().getContext());
                adChoicesView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                adChoicesView.addView(view);
                FrameLayout zzaoc = zzcdy.zzaoc();
                if (zzaoc != null) {
                    zzaoc.addView(adChoicesView);
                }
            }
            zzcdy.zza(zzcdy.zzaoh(), view, true);
        }
        String[] strArr2 = zzccy.zzgeb;
        int length = strArr2.length;
        while (true) {
            if (i >= length) {
                viewGroup2 = null;
                break;
            }
            View zzgc2 = zzcdy.zzgc(strArr2[i]);
            if (zzgc2 instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) zzgc2;
                break;
            }
            i++;
        }
        this.f14121h.execute(new C2287ph(this, viewGroup2));
        if (viewGroup2 == null) {
            return;
        }
        if (!zza(viewGroup2)) {
            viewGroup2.removeAllViews();
            View zzaiz = zzcdy.zzaiz();
            Context context2 = zzaiz != null ? zzaiz.getContext() : null;
            if (context2 != null) {
                if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcsd)).booleanValue()) {
                    zzaee zzth = this.f14123j.zzth();
                    if (zzth != null) {
                        try {
                            iObjectWrapper = zzth.zzsu();
                        } catch (RemoteException unused) {
                            zzaza.zzfa("Could not get main image drawable");
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    zzaej zzane = this.f14117d.zzane();
                    if (zzane != null) {
                        try {
                            iObjectWrapper = zzane.zzsr();
                        } catch (RemoteException unused2) {
                            zzaza.zzfa("Could not get drawable from image");
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (iObjectWrapper != null && (drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapper)) != null) {
                    ImageView imageView = new ImageView(context2);
                    imageView.setImageDrawable(drawable);
                    if (zzcdy != null) {
                        iObjectWrapper2 = zzcdy.zzaoi();
                    }
                    if (iObjectWrapper2 != null) {
                        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwt)).booleanValue()) {
                            imageView.setScaleType((ImageView.ScaleType) ObjectWrapper.unwrap(iObjectWrapper2));
                            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                            viewGroup2.addView(imageView);
                        }
                    }
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    viewGroup2.addView(imageView);
                }
            }
        } else if (this.f14117d.zzanh() != null) {
            this.f14117d.zzanh().zza((zzadx) new C2250oh(this, zzcdy, viewGroup2));
        }
    }

    public final void zza(zzcdy zzcdy) {
        this.f14120g.execute(new C2212nh(this, zzcdy));
    }

    public final void zzc(@Nullable zzcdy zzcdy) {
        if (zzcdy != null && this.f14118e != null && zzcdy.zzaoc() != null && this.f14116c.zzano()) {
            try {
                zzcdy.zzaoc().addView(this.f14118e.zzaon());
            } catch (zzbeh e) {
                zzd.zza("web view can not be obtained", e);
            }
        }
    }

    public final void zzd(@Nullable zzcdy zzcdy) {
        if (zzcdy != null) {
            Context context = zzcdy.zzaiz().getContext();
            if (zzbq.zza(context, this.f14116c.zzgdi)) {
                if (!(context instanceof Activity)) {
                    zzaza.zzeb("Activity context is needed for policy validator.");
                } else if (this.f14119f != null && zzcdy.zzaoc() != null) {
                    try {
                        WindowManager windowManager = (WindowManager) context.getSystemService("window");
                        windowManager.addView(this.f14119f.zza(zzcdy.zzaoc(), windowManager), zzbq.zzyx());
                    } catch (zzbeh e) {
                        zzd.zza("web view can not be obtained", e);
                    }
                }
            }
        }
    }

    public final boolean zza(@NonNull ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        View zzang = this.f14117d.zzang();
        if (zzang == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (zzang.getParent() instanceof ViewGroup) {
            ((ViewGroup) zzang.getParent()).removeView(zzang);
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcsh)).booleanValue()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        }
        viewGroup.addView(zzang, layoutParams);
        return true;
    }
}
