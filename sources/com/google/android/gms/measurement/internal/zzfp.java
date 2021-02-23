package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzca;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzih;
import com.google.android.gms.internal.measurement.zzlq;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@17.6.0 */
public final class zzfp extends C3071o7 implements C2930a {
    @VisibleForTesting

    /* renamed from: h */
    private static int f18593h = 65535;
    @VisibleForTesting

    /* renamed from: i */
    private static int f18594i = 2;

    /* renamed from: b */
    private final Map<String, Map<String, String>> f18595b = new ArrayMap();

    /* renamed from: c */
    private final Map<String, Map<String, Boolean>> f18596c = new ArrayMap();

    /* renamed from: d */
    private final Map<String, Map<String, Boolean>> f18597d = new ArrayMap();

    /* renamed from: e */
    private final Map<String, zzca.zzb> f18598e = new ArrayMap();

    /* renamed from: f */
    private final Map<String, Map<String, Integer>> f18599f = new ArrayMap();

    /* renamed from: g */
    private final Map<String, String> f18600g = new ArrayMap();

    zzfp(zzki zzki) {
        super(zzki);
    }

    @WorkerThread
    /* renamed from: b */
    private final zzca.zzb m10797b(String str, byte[] bArr) {
        if (bArr == null) {
            return zzca.zzb.zzj();
        }
        try {
            zzca.zzb zzb = (zzca.zzb) ((zzhz) ((zzca.zzb.zza) zzks.m10959g(zzca.zzb.zzi(), bArr)).zzz());
            zzet zzw = zzq().zzw();
            String str2 = null;
            Long valueOf = zzb.zza() ? Long.valueOf(zzb.zzb()) : null;
            if (zzb.zzc()) {
                str2 = zzb.zzd();
            }
            zzw.zza("Parsed config. version, gmp_app_id", valueOf, str2);
            return zzb;
        } catch (zzih e) {
            zzq().zzh().zza("Unable to merge remote config. appId", zzer.zza(str), e);
            return zzca.zzb.zzj();
        } catch (RuntimeException e2) {
            zzq().zzh().zza("Unable to merge remote config. appId", zzer.zza(str), e2);
            return zzca.zzb.zzj();
        }
    }

    /* renamed from: c */
    private static Map<String, String> m10798c(zzca.zzb zzb) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzb != null) {
            for (zzca.zzc next : zzb.zze()) {
                arrayMap.put(next.zza(), next.zzb());
            }
        }
        return arrayMap;
    }

    /* renamed from: d */
    private final void m10799d(String str, zzca.zzb.zza zza) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (zza != null) {
            for (int i = 0; i < zza.zza(); i++) {
                zzca.zza.C3997zza zza2 = (zzca.zza.C3997zza) zza.zza(i).zzbn();
                if (TextUtils.isEmpty(zza2.zza())) {
                    zzq().zzh().zza("EventConfig contained null event name");
                } else {
                    String zza3 = zza2.zza();
                    String zzb = zzgs.zzb(zza2.zza());
                    if (!TextUtils.isEmpty(zzb)) {
                        zza2 = zza2.zza(zzb);
                        zza.zza(i, zza2);
                    }
                    if (!zzlq.zzb() || !zzs().zza(zzat.zzcm)) {
                        arrayMap.put(zza2.zza(), Boolean.valueOf(zza2.zzb()));
                    } else {
                        arrayMap.put(zza3, Boolean.valueOf(zza2.zzb()));
                    }
                    arrayMap2.put(zza2.zza(), Boolean.valueOf(zza2.zzc()));
                    if (zza2.zzd()) {
                        if (zza2.zze() < f18594i || zza2.zze() > f18593h) {
                            zzq().zzh().zza("Invalid sampling rate. Event name, sample rate", zza2.zza(), Integer.valueOf(zza2.zze()));
                        } else {
                            arrayMap3.put(zza2.zza(), Integer.valueOf(zza2.zze()));
                        }
                    }
                }
            }
        }
        this.f18596c.put(str, arrayMap);
        this.f18597d.put(str, arrayMap2);
        this.f18599f.put(str, arrayMap3);
    }

    @WorkerThread
    /* renamed from: l */
    private final void m10800l(String str) {
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        if (this.f18598e.get(str) == null) {
            byte[] W = zzi().mo19840W(str);
            if (W == null) {
                this.f18595b.put(str, (Object) null);
                this.f18596c.put(str, (Object) null);
                this.f18597d.put(str, (Object) null);
                this.f18598e.put(str, (Object) null);
                this.f18600g.put(str, (Object) null);
                this.f18599f.put(str, (Object) null);
                return;
            }
            zzca.zzb.zza zza = (zzca.zzb.zza) m10797b(str, W).zzbn();
            m10799d(str, zza);
            this.f18595b.put(str, m10798c((zzca.zzb) ((zzhz) zza.zzz())));
            this.f18598e.put(str, (zzca.zzb) ((zzhz) zza.zzz()));
            this.f18600g.put(str, (Object) null);
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: e */
    public final boolean mo20337e(String str, String str2) {
        Boolean bool;
        zzc();
        m10800l(str);
        if (mo20343k(str) && zzkw.m10995S(str2)) {
            return true;
        }
        if (zzh(str) && zzkw.m11010w(str2)) {
            return true;
        }
        Map map = this.f18596c.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: f */
    public final boolean mo20338f(String str, String str2) {
        Boolean bool;
        zzc();
        m10800l(str);
        if (FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(str2) || FirebaseAnalytics.Event.PURCHASE.equals(str2) || FirebaseAnalytics.Event.REFUND.equals(str2)) {
            return true;
        }
        Map map = this.f18597d.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* renamed from: f_ */
    public final /* bridge */ /* synthetic */ zzks mo20059f_() {
        return super.mo20059f_();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: g */
    public final int mo20339g(String str, String str2) {
        Integer num;
        zzc();
        m10800l(str);
        Map map = this.f18599f.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: h */
    public final void mo20340h(String str) {
        zzc();
        this.f18598e.remove(str);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: i */
    public final boolean mo20341i(String str) {
        zzc();
        zzca.zzb zza = zza(str);
        if (zza == null) {
            return false;
        }
        return zza.zzh();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: j */
    public final long mo20342j(String str) {
        String zza = zza(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(zza)) {
            return 0;
        }
        try {
            return Long.parseLong(zza);
        } catch (NumberFormatException e) {
            zzq().zzh().zza("Unable to parse timezone offset. appId", zzer.zza(str), e);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public final boolean mo20343k(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final zzca.zzb zza(String str) {
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        m10800l(str);
        return this.f18598e.get(str);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final String zzb(String str) {
        zzc();
        return this.f18600g.get(str);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzc(String str) {
        zzc();
        this.f18600g.put(str, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final boolean zzd() {
        return false;
    }

    public final /* bridge */ /* synthetic */ zzjo zzf() {
        return super.zzf();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzh(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_public"));
    }

    public final /* bridge */ /* synthetic */ C2950c zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzfp zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzal zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ Clock zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Context zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ zzep zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzkw zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzfo zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzer zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ C3049m3 zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzy zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzx zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ C2939a8 zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @WorkerThread
    public final String zza(String str, String str2) {
        zzc();
        m10800l(str);
        Map map = this.f18595b.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final boolean zza(String str, byte[] bArr, String str2) {
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        zzca.zzb.zza zza = (zzca.zzb.zza) m10797b(str, bArr).zzbn();
        if (zza == null) {
            return false;
        }
        m10799d(str, zza);
        this.f18598e.put(str, (zzca.zzb) ((zzhz) zza.zzz()));
        this.f18600g.put(str, str2);
        this.f18595b.put(str, m10798c((zzca.zzb) ((zzhz) zza.zzz())));
        zzi().mo19873w(str, new ArrayList(zza.zzb()));
        try {
            zza.zzc();
            bArr = ((zzca.zzb) ((zzhz) zza.zzz())).zzbk();
        } catch (RuntimeException e) {
            zzq().zzh().zza("Unable to serialize reduced-size config. Storing full config instead. appId", zzer.zza(str), e);
        }
        C2950c zzi = zzi();
        Preconditions.checkNotEmpty(str);
        zzi.zzc();
        zzi.zzaj();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (((long) zzi.mo19847c().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                zzi.zzq().zze().zza("Failed to update remote config (got 0). appId", zzer.zza(str));
            }
        } catch (SQLiteException e2) {
            zzi.zzq().zze().zza("Error storing remote config. appId", zzer.zza(str), e2);
        }
        this.f18598e.put(str, (zzca.zzb) ((zzhz) zza.zzz()));
        return true;
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
