package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcft extends zzajm implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzads {

    /* renamed from: a */
    private View f14274a;

    /* renamed from: b */
    private zzys f14275b;

    /* renamed from: c */
    private zzcbt f14276c;

    /* renamed from: d */
    private boolean f14277d = false;

    /* renamed from: e */
    private boolean f14278e = false;

    public zzcft(zzcbt zzcbt, zzcce zzcce) {
        this.f14274a = zzcce.zzang();
        this.f14275b = zzcce.getVideoController();
        this.f14276c = zzcbt;
        if (zzcce.zzanh() != null) {
            zzcce.zzanh().zza((zzads) this);
        }
    }

    /* renamed from: a */
    private static void m8136a(zzajo zzajo, int i) {
        try {
            zzajo.zzdb(i);
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: b */
    private final void m8137b() {
        View view = this.f14274a;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f14274a);
            }
        }
    }

    /* renamed from: c */
    private final void m8138c() {
        View view;
        zzcbt zzcbt = this.f14276c;
        if (zzcbt != null && (view = this.f14274a) != null) {
            zzcbt.zzb(view, Collections.emptyMap(), Collections.emptyMap(), zzcbt.zzz(this.f14274a));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ void mo16837d() {
        try {
            destroy();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void destroy() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        m8137b();
        zzcbt zzcbt = this.f14276c;
        if (zzcbt != null) {
            zzcbt.destroy();
        }
        this.f14276c = null;
        this.f14274a = null;
        this.f14275b = null;
        this.f14277d = true;
    }

    public final zzys getVideoController() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (!this.f14277d) {
            return this.f14275b;
        }
        zzaza.zzey("getVideoController: Instream ad should not be used after destroyed");
        return null;
    }

    public final void onGlobalLayout() {
        m8138c();
    }

    public final void onScrollChanged() {
        m8138c();
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzajo zzajo) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.f14277d) {
            zzaza.zzey("Instream ad can not be shown after destroy().");
            m8136a(zzajo, 2);
            return;
        }
        View view = this.f14274a;
        if (view == null || this.f14275b == null) {
            String str = view == null ? "can not get video view." : "can not get video controller.";
            zzaza.zzey(str.length() != 0 ? "Instream internal error: ".concat(str) : new String("Instream internal error: "));
            m8136a(zzajo, 0);
        } else if (this.f14278e) {
            zzaza.zzey("Instream ad should not be used again.");
            m8136a(zzajo, 1);
        } else {
            this.f14278e = true;
            m8137b();
            ((ViewGroup) ObjectWrapper.unwrap(iObjectWrapper)).addView(this.f14274a, new ViewGroup.LayoutParams(-1, -1));
            zzp.zzln();
            zzazy.zza(this.f14274a, (ViewTreeObserver.OnGlobalLayoutListener) this);
            zzp.zzln();
            zzazy.zza(this.f14274a, (ViewTreeObserver.OnScrollChangedListener) this);
            m8138c();
            try {
                zzajo.zztn();
            } catch (RemoteException e) {
                zzaza.zze("#007 Could not call remote method.", e);
            }
        }
    }

    public final void zzr(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zza(iObjectWrapper, new C1770bj(this));
    }

    public final void zzsq() {
        zzm.zzedd.post(new C1807cj(this));
    }

    public final zzaee zzth() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.f14277d) {
            zzaza.zzey("getVideoController: Instream ad should not be used after destroyed");
            return null;
        }
        zzcbt zzcbt = this.f14276c;
        if (zzcbt == null || zzcbt.zzamz() == null) {
            return null;
        }
        return this.f14276c.zzamz().zzth();
    }
}
