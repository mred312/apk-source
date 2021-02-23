package com.google.android.gms.internal.ads;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.internal.ads.zzue;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzcqi {
    /* renamed from: a */
    private static Cursor m8242a(SQLiteDatabase sQLiteDatabase, int i) {
        String[] strArr = {"value"};
        String[] strArr2 = new String[1];
        if (i == 0) {
            strArr2[0] = "failed_requests";
        } else if (i == 1) {
            strArr2[0] = "total_requests";
        } else if (i == 2) {
            strArr2[0] = "last_successful_request_time";
        }
        return sQLiteDatabase.query("offline_signal_statistics", strArr, "statistic_name = ?", strArr2, (String) null, (String) null, (String) null);
    }

    public static int zza(SQLiteDatabase sQLiteDatabase, int i) {
        int i2 = 0;
        if (i == 2) {
            return 0;
        }
        Cursor a = m8242a(sQLiteDatabase, i);
        if (a.getCount() > 0) {
            a.moveToNext();
            i2 = 0 + a.getInt(a.getColumnIndexOrThrow("value"));
        }
        a.close();
        return i2;
    }

    public static ArrayList<zzue.zzo.zza> zzb(SQLiteDatabase sQLiteDatabase) {
        ArrayList<zzue.zzo.zza> arrayList = new ArrayList<>();
        Cursor query = sQLiteDatabase.query("offline_signal_contents", new String[]{"serialized_proto_data"}, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        while (query.moveToNext()) {
            try {
                arrayList.add(zzue.zzo.zza.zzg(query.getBlob(query.getColumnIndexOrThrow("serialized_proto_data"))));
            } catch (zzeks e) {
                zzaza.zzey("Unable to deserialize proto from offline signals database:");
                zzaza.zzey(e.getMessage());
            }
        }
        query.close();
        return arrayList;
    }

    public static long zzb(SQLiteDatabase sQLiteDatabase, int i) {
        Cursor a = m8242a(sQLiteDatabase, 2);
        long j = 0;
        if (a.getCount() > 0) {
            a.moveToNext();
            j = 0 + a.getLong(a.getColumnIndexOrThrow("value"));
        }
        a.close();
        return j;
    }
}
