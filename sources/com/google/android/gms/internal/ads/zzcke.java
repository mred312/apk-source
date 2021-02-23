package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcke implements zzbry, zzbsm, zzbvz, zzva {

    /* renamed from: a */
    private final Context f14483a;

    /* renamed from: b */
    private final zzdoa f14484b;

    /* renamed from: c */
    private final zzckq f14485c;

    /* renamed from: d */
    private final zzdnj f14486d;

    /* renamed from: e */
    private final zzdmu f14487e;

    /* renamed from: f */
    private final zzcqo f14488f;
    @Nullable

    /* renamed from: g */
    private Boolean f14489g;

    /* renamed from: h */
    private final boolean f14490h = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcxw)).booleanValue();

    public zzcke(Context context, zzdoa zzdoa, zzckq zzckq, zzdnj zzdnj, zzdmu zzdmu, zzcqo zzcqo) {
        this.f14483a = context;
        this.f14484b = zzdoa;
        this.f14485c = zzckq;
        this.f14486d = zzdnj;
        this.f14487e = zzdmu;
        this.f14488f = zzcqo;
    }

    /* renamed from: a */
    private final void m8173a(zzckp zzckp) {
        if (this.f14487e.zzhhq) {
            this.f14488f.zza(new zzcqv(zzp.zzkx().currentTimeMillis(), this.f14486d.zzhik.zzerj.zzbvf, zzckp.zzaqe(), zzcql.zzgqc));
            return;
        }
        zzckp.zzaqd();
    }

    /* renamed from: b */
    private final boolean m8174b() {
        if (this.f14489g == null) {
            synchronized (this) {
                if (this.f14489g == null) {
                    zzaaq zzaaq = zzabf.zzcqf;
                    zzp.zzkq();
                    this.f14489g = Boolean.valueOf(m8175c((String) zzwq.zzqe().zzd(zzaaq), zzm.zzba(this.f14483a)));
                }
            }
        }
        return this.f14489g.booleanValue();
    }

    /* renamed from: c */
    private static boolean m8175c(String str, String str2) {
        if (!(str == null || str2 == null)) {
            try {
                return Pattern.matches(str, str2);
            } catch (RuntimeException e) {
                zzp.zzku().zza(e, "CsiActionsListener.isPatternMatched");
            }
        }
        return false;
    }

    /* renamed from: d */
    private final zzckp m8176d(String str) {
        zzckp zzc = this.f14485c.zzaqg().zza(this.f14486d.zzhik.zzerj).zzc(this.f14487e);
        zzc.zzr("action", str);
        if (!this.f14487e.zzhgy.isEmpty()) {
            zzc.zzr("ancn", this.f14487e.zzhgy.get(0));
        }
        if (this.f14487e.zzhhq) {
            zzp.zzkq();
            zzc.zzr("device_connectivity", zzm.zzbc(this.f14483a) ? "online" : "offline");
            zzc.zzr("event_timestamp", String.valueOf(zzp.zzkx().currentTimeMillis()));
            zzc.zzr("offline_ad", "1");
        }
        return zzc;
    }

    public final void onAdClicked() {
        if (this.f14487e.zzhhq) {
            m8173a(m8176d("click"));
        }
    }

    public final void onAdImpression() {
        if (m8174b() || this.f14487e.zzhhq) {
            m8173a(m8176d("impression"));
        }
    }

    public final void zza(zzcai zzcai) {
        if (this.f14490h) {
            zzckp d = m8176d("ifts");
            d.zzr("reason", "exception");
            if (!TextUtils.isEmpty(zzcai.getMessage())) {
                d.zzr(NotificationCompat.CATEGORY_MESSAGE, zzcai.getMessage());
            }
            d.zzaqd();
        }
    }

    public final void zzakm() {
        if (m8174b()) {
            m8176d("adapter_impression").zzaqd();
        }
    }

    public final void zzako() {
        if (m8174b()) {
            m8176d("adapter_shown").zzaqd();
        }
    }

    public final void zzaky() {
        if (this.f14490h) {
            zzckp d = m8176d("ifts");
            d.zzr("reason", "blocked");
            d.zzaqd();
        }
    }

    public final void zzl(zzve zzve) {
        zzve zzve2;
        if (this.f14490h) {
            zzckp d = m8176d("ifts");
            d.zzr("reason", "adapter");
            int i = zzve.errorCode;
            String str = zzve.zzcgs;
            if (zzve.zzcgt.equals(MobileAds.ERROR_DOMAIN) && (zzve2 = zzve.zzcgu) != null && !zzve2.zzcgt.equals(MobileAds.ERROR_DOMAIN)) {
                zzve zzve3 = zzve.zzcgu;
                i = zzve3.errorCode;
                str = zzve3.zzcgs;
            }
            if (i >= 0) {
                d.zzr("arec", String.valueOf(i));
            }
            String zzgr = this.f14484b.zzgr(str);
            if (zzgr != null) {
                d.zzr("areec", zzgr);
            }
            d.zzaqd();
        }
    }
}
