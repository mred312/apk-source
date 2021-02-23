package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbdv;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzk {
    public final Context context;
    public final int index;
    public final ViewGroup parent;
    public final ViewGroup.LayoutParams zzdrc;

    public zzk(zzbdv zzbdv) {
        this.zzdrc = zzbdv.getLayoutParams();
        ViewParent parent2 = zzbdv.getParent();
        this.context = zzbdv.zzacn();
        if (parent2 == null || !(parent2 instanceof ViewGroup)) {
            throw new zzi("Could not get the parent of the WebView for an overlay.");
        }
        ViewGroup viewGroup = (ViewGroup) parent2;
        this.parent = viewGroup;
        this.index = viewGroup.indexOfChild(zzbdv.getView());
        viewGroup.removeView(zzbdv.getView());
        zzbdv.zzaz(true);
    }
}
