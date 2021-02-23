package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbtc;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcvy<AdT, AdapterT, ListenerT extends zzbtc> implements zzcqz<AdT> {

    /* renamed from: a */
    private final zzcre<AdapterT, ListenerT> f14957a;

    /* renamed from: b */
    private final zzcrh<AdT, AdapterT, ListenerT> f14958b;

    /* renamed from: c */
    private final zzdro f14959c;

    /* renamed from: d */
    private final zzdzc f14960d;

    public zzcvy(zzdro zzdro, zzdzc zzdzc, zzcre<AdapterT, ListenerT> zzcre, zzcrh<AdT, AdapterT, ListenerT> zzcrh) {
        this.f14959c = zzdro;
        this.f14960d = zzdzc;
        this.f14958b = zzcrh;
        this.f14957a = zzcre;
    }

    @VisibleForTesting
    /* renamed from: b */
    static String m8285b(String str, int i) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 31);
        sb.append("Error from: ");
        sb.append(str);
        sb.append(", code: ");
        sb.append(i);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ Object mo17010a(zzdnj zzdnj, zzdmu zzdmu, zzcrb zzcrb, Void voidR) {
        return this.f14958b.zzb(zzdnj, zzdmu, zzcrb);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ void mo17011c(zzdnj zzdnj, zzdmu zzdmu, zzcrb zzcrb) {
        this.f14958b.zza(zzdnj, zzdmu, zzcrb);
    }

    public final boolean zza(zzdnj zzdnj, zzdmu zzdmu) {
        return !zzdmu.zzhgy.isEmpty();
    }

    public final zzdyz<AdT> zzb(zzdnj zzdnj, zzdmu zzdmu) {
        zzcrb<AdapterT, ListenerT> zzcrb;
        Class<AdMobAdapter> cls = AdMobAdapter.class;
        Iterator<String> it = zzdmu.zzhgy.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzcrb = null;
                break;
            }
            try {
                zzcrb = this.f14957a.zzf(it.next(), zzdmu.zzhha);
                break;
            } catch (zzdnr unused) {
            }
        }
        if (zzcrb == null) {
            return zzdyr.immediateFailedFuture(new zzcuc("unable to instantiate mediation adapter class"));
        }
        zzazq zzazq = new zzazq();
        zzcrb.zzgqp.zza(new C1999hq(this, zzcrb, zzazq));
        if (zzdmu.zzdxi) {
            Bundle bundle = zzdnj.zzhij.zzfvl.zzhio.zzchf;
            Bundle bundle2 = bundle.getBundle(cls.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(cls.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        return this.f14959c.zzu(zzdrl.ADAPTER_LOAD_AD_SYN).zza(new C1962gq(this, zzdnj, zzdmu, zzcrb), this.f14960d).zzw(zzdrl.ADAPTER_LOAD_AD_ACK).zze(zzazq).zzw(zzdrl.ADAPTER_WRAP_ADAPTER).zzb(new C2036iq(this, zzdnj, zzdmu, zzcrb)).zzaww();
    }
}
