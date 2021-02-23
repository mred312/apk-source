package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzchc extends zzboc {

    /* renamed from: f */
    private final Context f14364f;

    /* renamed from: g */
    private final WeakReference<zzbdv> f14365g;

    /* renamed from: h */
    private final zzcaf f14366h;

    /* renamed from: i */
    private final zzbxm f14367i;

    /* renamed from: j */
    private final zzbsb f14368j;

    /* renamed from: k */
    private final zzbti f14369k;

    /* renamed from: l */
    private final zzbov f14370l;

    /* renamed from: m */
    private final zzavc f14371m;

    /* renamed from: n */
    private final zzdst f14372n;

    /* renamed from: o */
    private boolean f14373o = false;

    zzchc(zzbob zzbob, Context context, @Nullable zzbdv zzbdv, zzcaf zzcaf, zzbxm zzbxm, zzbsb zzbsb, zzbti zzbti, zzbov zzbov, zzdmu zzdmu, zzdst zzdst) {
        super(zzbob);
        this.f14364f = context;
        this.f14366h = zzcaf;
        this.f14365g = new WeakReference<>(zzbdv);
        this.f14367i = zzbxm;
        this.f14368j = zzbsb;
        this.f14369k = zzbti;
        this.f14370l = zzbov;
        this.f14372n = zzdst;
        this.f14371m = new zzawd(zzdmu.zzdvb);
    }

    public final void finalize() {
        try {
            zzbdv zzbdv = (zzbdv) this.f14365g.get();
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcxt)).booleanValue()) {
                if (!this.f14373o && zzbdv != null) {
                    zzdzc zzdzc = zzazj.zzegt;
                    zzbdv.getClass();
                    zzdzc.execute(C2289pj.m6687a(zzbdv));
                }
            } else if (zzbdv != null) {
                zzbdv.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final Bundle getAdMetadata() {
        return this.f14369k.getAdMetadata();
    }

    public final boolean isClosed() {
        return this.f14370l.isClosed();
    }

    public final boolean isUsed() {
        return this.f14373o;
    }

    public final boolean zzb(boolean z, @Nullable Activity activity) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcnz)).booleanValue()) {
            zzp.zzkq();
            if (zzm.zzas(this.f14364f)) {
                zzaza.zzfa("Rewarded ads that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.f14368j.zzaky();
                if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcoa)).booleanValue()) {
                    this.f14372n.zzgz(this.zzfpr.zzhik.zzerj.zzbvf);
                }
                return false;
            }
        }
        if (this.f14373o) {
            zzaza.zzfa("The rewarded ad have been showed.");
            this.f14368j.zzl(zzdoi.zza(zzdok.AD_REUSED, (String) null, (zzve) null));
            return false;
        }
        this.f14373o = true;
        this.f14367i.zzakn();
        Context context = activity;
        if (activity == null) {
            context = this.f14364f;
        }
        try {
            this.f14366h.zza(z, context);
            this.f14367i.zzakl();
            return true;
        } catch (zzcai e) {
            this.f14368j.zza(e);
            return false;
        }
    }

    public final zzavc zzre() {
        return this.f14371m;
    }

    public final boolean zzrf() {
        zzbdv zzbdv = (zzbdv) this.f14365g.get();
        return zzbdv != null && !zzbdv.zzadh();
    }
}
