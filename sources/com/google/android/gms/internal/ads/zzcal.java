package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzue;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcal implements zzbru, zzbxn {

    /* renamed from: a */
    private final zzawu f13911a;

    /* renamed from: b */
    private final Context f13912b;

    /* renamed from: c */
    private final zzawx f13913c;
    @Nullable

    /* renamed from: d */
    private final View f13914d;

    /* renamed from: e */
    private String f13915e;

    /* renamed from: f */
    private final zzue.zza.C3992zza f13916f;

    public zzcal(zzawu zzawu, Context context, zzawx zzawx, @Nullable View view, zzue.zza.C3992zza zza) {
        this.f13911a = zzawu;
        this.f13912b = context;
        this.f13913c = zzawx;
        this.f13914d = view;
        this.f13916f = zza;
    }

    public final void onAdClosed() {
        this.f13911a.zzam(false);
    }

    public final void onAdLeftApplication() {
    }

    public final void onAdOpened() {
        View view = this.f13914d;
        if (!(view == null || this.f13915e == null)) {
            this.f13913c.zzf(view.getContext(), this.f13915e);
        }
        this.f13911a.zzam(true);
    }

    public final void onRewardedVideoCompleted() {
    }

    public final void onRewardedVideoStarted() {
    }

    public final void zzakl() {
    }

    public final void zzakn() {
        String zzab = this.f13913c.zzab(this.f13912b);
        this.f13915e = zzab;
        String valueOf = String.valueOf(zzab);
        String str = this.f13916f == zzue.zza.C3992zza.REWARD_BASED_VIDEO_AD ? "/Rewarded" : "/Interstitial";
        this.f13915e = str.length() != 0 ? valueOf.concat(str) : new String(valueOf);
    }

    @ParametersAreNonnullByDefault
    public final void zzb(zzauf zzauf, String str, String str2) {
        if (this.f13913c.zzz(this.f13912b)) {
            try {
                zzawx zzawx = this.f13913c;
                Context context = this.f13912b;
                zzawx.zza(context, zzawx.zzae(context), this.f13911a.getAdUnitId(), zzauf.getType(), zzauf.getAmount());
            } catch (RemoteException e) {
                zzaza.zzd("Remote Exception to get reward item.", e);
            }
        }
    }
}
