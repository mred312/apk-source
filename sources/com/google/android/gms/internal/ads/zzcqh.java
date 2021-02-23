package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zztu;
import com.google.android.gms.internal.ads.zzue;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcqh {

    /* renamed from: a */
    private zzts f14715a;

    /* renamed from: b */
    private Context f14716b;

    /* renamed from: c */
    private zzcpr f14717c;

    /* renamed from: d */
    private zzazh f14718d;

    public zzcqh(Context context, zzazh zzazh, zzts zzts, zzcpr zzcpr) {
        this.f14716b = context;
        this.f14718d = zzazh;
        this.f14715a = zzts;
        this.f14717c = zzcpr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ Void mo16963a(SQLiteDatabase sQLiteDatabase) {
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        ArrayList<zzue.zzo.zza> zzb = zzcqi.zzb(sQLiteDatabase);
        zzue.zzo zzo = (zzue.zzo) ((zzekh) zzue.zzo.zzon().zzca(this.f14716b.getPackageName()).zzcb(Build.MODEL).zzcj(zzcqi.zza(sQLiteDatabase2, 0)).zze(zzb).zzck(zzcqi.zza(sQLiteDatabase2, 1)).zzes(zzp.zzkx().currentTimeMillis()).zzet(zzcqi.zzb(sQLiteDatabase2, 2)).zzbhv());
        int size = zzb.size();
        long j = 0;
        int i = 0;
        while (i < size) {
            zzue.zzo.zza zza = zzb.get(i);
            i++;
            zzue.zzo.zza zza2 = zza;
            if (zza2.zzop() == zzuo.ENUM_TRUE && zza2.getTimestamp() > j) {
                j = zza2.getTimestamp();
            }
        }
        if (j != 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("value", Long.valueOf(j));
            sQLiteDatabase2.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", (String[]) null);
        }
        this.f14715a.zza((zztv) new C2256on(zzo));
        this.f14715a.zza((zztv) new C2330qn((zzue.zzu) ((zzekh) zzue.zzu.zzox().zzcq(this.f14718d.zzegl).zzcr(this.f14718d.zzegm).zzcs(this.f14718d.zzegn ? 0 : 2).zzbhv())));
        this.f14715a.zza(zztu.zza.C3991zza.OFFLINE_UPLOAD);
        sQLiteDatabase2.delete("offline_signal_contents", (String) null, (String[]) null);
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("value", 0);
        sQLiteDatabase2.update("offline_signal_statistics", contentValues2, "statistic_name = ?", new String[]{"failed_requests"});
        ContentValues contentValues3 = new ContentValues();
        contentValues3.put("value", 0);
        sQLiteDatabase2.update("offline_signal_statistics", contentValues3, "statistic_name = ?", new String[]{"total_requests"});
        return null;
    }

    public final void zzari() {
        try {
            this.f14717c.zza(new C2293pn(this));
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzaza.zzey(valueOf.length() != 0 ? "Error in offline signals database startup: ".concat(valueOf) : new String("Error in offline signals database startup: "));
        }
    }
}
