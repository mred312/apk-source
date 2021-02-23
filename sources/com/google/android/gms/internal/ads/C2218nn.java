package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzue;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.ads.nn */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2218nn implements zzdqv {

    /* renamed from: a */
    private final C2181mn f10214a;

    /* renamed from: b */
    private final boolean f10215b;

    /* renamed from: c */
    private final ArrayList f10216c;

    /* renamed from: d */
    private final zzue.zzm f10217d;

    /* renamed from: e */
    private final zzue.zzo.zzc f10218e;

    C2218nn(C2181mn mnVar, boolean z, ArrayList arrayList, zzue.zzm zzm, zzue.zzo.zzc zzc) {
        this.f10214a = mnVar;
        this.f10215b = z;
        this.f10216c = arrayList;
        this.f10217d = zzm;
        this.f10218e = zzc;
    }

    public final Object apply(Object obj) {
        C2181mn mnVar = this.f10214a;
        boolean z = this.f10215b;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        byte[] c = mnVar.f9999b.m8234d(z, this.f10216c, this.f10217d, this.f10218e);
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(zzp.zzkx().currentTimeMillis()));
        contentValues.put("serialized_proto_data", c);
        sQLiteDatabase.insert("offline_signal_contents", (String) null, contentValues);
        sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", new Object[]{"total_requests"}));
        if (!z) {
            sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", new Object[]{"failed_requests"}));
        }
        return null;
    }
}
