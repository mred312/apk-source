package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzajz {

    /* renamed from: a */
    private final Context f12496a;

    /* renamed from: b */
    private final zzwy f12497b;

    zzajz(Context context, zzwy zzwy) {
        this(context, zzwy, zzvl.zzcho);
    }

    /* renamed from: a */
    private final void m7472a(zzza zzza) {
        try {
            this.f12497b.zzb(zzvl.zza(this.f12496a, zzza));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(AdRequest adRequest) {
        m7472a(adRequest.zzds());
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        m7472a(publisherAdRequest.zzds());
    }

    private zzajz(Context context, zzwy zzwy, zzvl zzvl) {
        this.f12496a = context;
        this.f12497b = zzwy;
    }
}
