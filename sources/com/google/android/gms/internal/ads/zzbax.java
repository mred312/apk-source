package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbax {

    /* renamed from: a */
    private final Context f13017a;

    /* renamed from: b */
    private final zzbbe f13018b;

    /* renamed from: c */
    private final ViewGroup f13019c;

    /* renamed from: d */
    private zzbar f13020d;

    public zzbax(Context context, ViewGroup viewGroup, zzbdv zzbdv) {
        this(context, viewGroup, zzbdv, (zzbar) null);
    }

    public final void onDestroy() {
        Preconditions.checkMainThread("onDestroy must be called from the UI thread.");
        zzbar zzbar = this.f13020d;
        if (zzbar != null) {
            zzbar.destroy();
            this.f13019c.removeView(this.f13020d);
            this.f13020d = null;
        }
    }

    public final void onPause() {
        Preconditions.checkMainThread("onPause must be called from the UI thread.");
        zzbar zzbar = this.f13020d;
        if (zzbar != null) {
            zzbar.pause();
        }
    }

    public final void zza(int i, int i2, int i3, int i4, int i5, boolean z, zzbbf zzbbf) {
        if (this.f13020d == null) {
            zzabn.zza(this.f13018b.zzaan().zzry(), this.f13018b.zzaai(), "vpr2");
            Context context = this.f13017a;
            zzbbe zzbbe = this.f13018b;
            zzbar zzbar = new zzbar(context, zzbbe, i5, z, zzbbe.zzaan().zzry(), zzbbf);
            this.f13020d = zzbar;
            this.f13019c.addView(zzbar, 0, new ViewGroup.LayoutParams(-1, -1));
            int i6 = i;
            int i7 = i2;
            this.f13020d.zzd(i, i2, i3, i4);
            this.f13018b.zzau(false);
        }
    }

    public final zzbar zzaac() {
        Preconditions.checkMainThread("getAdVideoUnderlay must be called from the UI thread.");
        return this.f13020d;
    }

    public final void zze(int i, int i2, int i3, int i4) {
        Preconditions.checkMainThread("The underlay may only be modified from the UI thread.");
        zzbar zzbar = this.f13020d;
        if (zzbar != null) {
            zzbar.zzd(i, i2, i3, i4);
        }
    }

    @VisibleForTesting
    private zzbax(Context context, ViewGroup viewGroup, zzbbe zzbbe, zzbar zzbar) {
        this.f13017a = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.f13019c = viewGroup;
        this.f13018b = zzbbe;
        this.f13020d = null;
    }
}
