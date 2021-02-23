package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.nonagon.transaction.omid.OmidMediaType;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzue;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcah implements zzp, zzbtj {

    /* renamed from: a */
    private final Context f13899a;
    @Nullable

    /* renamed from: b */
    private final zzbdv f13900b;

    /* renamed from: c */
    private final zzdmu f13901c;

    /* renamed from: d */
    private final zzazh f13902d;

    /* renamed from: e */
    private final zzue.zza.C3992zza f13903e;
    @Nullable
    @VisibleForTesting

    /* renamed from: f */
    private IObjectWrapper f13904f;

    public zzcah(Context context, @Nullable zzbdv zzbdv, zzdmu zzdmu, zzazh zzazh, zzue.zza.C3992zza zza) {
        this.f13899a = context;
        this.f13900b = zzbdv;
        this.f13901c = zzdmu;
        this.f13902d = zzazh;
        this.f13903e = zza;
    }

    public final void onAdLoaded() {
        zzare zzare;
        zzarg zzarg;
        zzarg zzarg2;
        zzue.zza.C3992zza zza = this.f13903e;
        if ((zza == zzue.zza.C3992zza.REWARD_BASED_VIDEO_AD || zza == zzue.zza.C3992zza.INTERSTITIAL || zza == zzue.zza.C3992zza.APP_OPEN) && this.f13901c.zzdvl && this.f13900b != null && com.google.android.gms.ads.internal.zzp.zzlf().zzm(this.f13899a)) {
            zzazh zzazh = this.f13902d;
            int i = zzazh.zzegl;
            int i2 = zzazh.zzegm;
            StringBuilder sb = new StringBuilder(23);
            sb.append(i);
            sb.append(".");
            sb.append(i2);
            String sb2 = sb.toString();
            String videoEventsOwner = this.f13901c.zzhhi.getVideoEventsOwner();
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcul)).booleanValue()) {
                if (this.f13901c.zzhhi.getMediaType() == OmidMediaType.VIDEO) {
                    zzare = zzare.VIDEO;
                    zzarg = zzarg.DEFINED_BY_JAVASCRIPT;
                } else {
                    if (this.f13901c.zzhhj == 2) {
                        zzarg2 = zzarg.UNSPECIFIED;
                    } else {
                        zzarg2 = zzarg.BEGIN_TO_RENDER;
                    }
                    zzarg = zzarg2;
                    zzare = zzare.HTML_DISPLAY;
                }
                this.f13904f = com.google.android.gms.ads.internal.zzp.zzlf().zza(sb2, this.f13900b.getWebView(), "", "javascript", videoEventsOwner, zzarg, zzare, this.f13901c.zzche);
            } else {
                this.f13904f = com.google.android.gms.ads.internal.zzp.zzlf().zza(sb2, this.f13900b.getWebView(), "", "javascript", videoEventsOwner);
            }
            if (this.f13904f != null && this.f13900b.getView() != null) {
                com.google.android.gms.ads.internal.zzp.zzlf().zza(this.f13904f, this.f13900b.getView());
                this.f13900b.zzaq(this.f13904f);
                com.google.android.gms.ads.internal.zzp.zzlf().zzab(this.f13904f);
                if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcuo)).booleanValue()) {
                    this.f13900b.zza("onSdkLoaded", new ArrayMap());
                }
            }
        }
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public final void onUserLeaveHint() {
    }

    public final void zza(zzl zzl) {
        this.f13904f = null;
    }

    public final void zzux() {
        zzbdv zzbdv;
        if (this.f13904f != null && (zzbdv = this.f13900b) != null) {
            zzbdv.zza("onSdkImpression", new ArrayMap());
        }
    }
}
