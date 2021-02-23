package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzbf;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcqo extends SQLiteOpenHelper {

    /* renamed from: a */
    private final Context f14719a;

    /* renamed from: b */
    private final zzdzc f14720b;

    public zzcqo(Context context, zzdzc zzdzc) {
        super(context, "AdMobOfflineBufferedPings.db", (SQLiteDatabase.CursorFactory) null, ((Integer) zzwq.zzqe().zzd(zzabf.zzczd)).intValue());
        this.f14719a = context;
        this.f14720b = zzdzc;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static void m8244d(SQLiteDatabase sQLiteDatabase, zzaze zzaze) {
        sQLiteDatabase.beginTransaction();
        try {
            String[] strArr = {ImagesContract.URL};
            StringBuilder sb = new StringBuilder(25);
            sb.append("event_state = 1");
            Cursor query = sQLiteDatabase.query("offline_buffered_pings", strArr, sb.toString(), (String[]) null, (String) null, (String) null, "timestamp ASC", (String) null);
            int count = query.getCount();
            String[] strArr2 = new String[count];
            int i = 0;
            while (query.moveToNext()) {
                int columnIndex = query.getColumnIndex(ImagesContract.URL);
                if (columnIndex != -1) {
                    strArr2[i] = query.getString(columnIndex);
                }
                i++;
            }
            query.close();
            sQLiteDatabase.delete("offline_buffered_pings", "event_state = ?", new String[]{Integer.toString(1)});
            sQLiteDatabase.setTransactionSuccessful();
            for (int i2 = 0; i2 < count; i2++) {
                zzaze.zzeo(strArr2[i2]);
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* renamed from: f */
    static void m8245f(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.delete("offline_buffered_pings", "gws_query_id = ? AND event_state = ?", new String[]{str, Integer.toString(0)});
    }

    /* renamed from: g */
    static final /* synthetic */ void m8246g(SQLiteDatabase sQLiteDatabase, String str, zzaze zzaze) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_state", 1);
        sQLiteDatabase.update("offline_buffered_pings", contentValues, "gws_query_id = ?", new String[]{str});
        m8244d(sQLiteDatabase, zzaze);
    }

    /* renamed from: h */
    private final void m8247h(zzdqv<SQLiteDatabase, Void> zzdqv) {
        zzdyr.zza(this.f14720b.zze(new C2367rn(this)), new C2556wn(this, zzdqv), this.f14720b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ Void mo16965b(zzaze zzaze, String str, SQLiteDatabase sQLiteDatabase) {
        mo16967e(sQLiteDatabase, zzaze, str);
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ Void mo16966c(zzcqv zzcqv, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(zzcqv.timestamp));
        contentValues.put("gws_query_id", zzcqv.zzbvf);
        contentValues.put(ImagesContract.URL, zzcqv.url);
        contentValues.put("event_state", Integer.valueOf(zzcqv.zzgqk - 1));
        sQLiteDatabase.insert("offline_buffered_pings", (String) null, contentValues);
        zzp.zzkq();
        zzbf zzbf = zzm.zzbf(this.f14719a);
        if (zzbf != null) {
            try {
                zzbf.zzap(ObjectWrapper.wrap(this.f14719a));
            } catch (RemoteException e) {
                zzd.zza("Failed to schedule offline ping sender.", e);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final void mo16967e(SQLiteDatabase sQLiteDatabase, zzaze zzaze, String str) {
        this.f14720b.execute(new C2408sn(sQLiteDatabase, str, zzaze));
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE offline_buffered_pings (timestamp INTEGER PRIMARY_KEY, gws_query_id TEXT, url TEXT, event_state INTEGER)");
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i, i2);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_buffered_pings");
    }

    public final void zza(zzaze zzaze) {
        m8247h(new C2445tn(zzaze));
    }

    public final void zzb(zzaze zzaze, String str) {
        m8247h(new C2519vn(this, zzaze, str));
    }

    public final void zzgk(String str) {
        m8247h(new C2482un(this, str));
    }

    public final void zza(zzcqv zzcqv) {
        m8247h(new C2594xn(this, zzcqv));
    }
}
