package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* renamed from: com.google.android.gms.internal.ads.sn */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final /* synthetic */ class C2408sn implements Runnable {

    /* renamed from: a */
    private final SQLiteDatabase f11098a;

    /* renamed from: b */
    private final String f11099b;

    /* renamed from: c */
    private final zzaze f11100c;

    C2408sn(SQLiteDatabase sQLiteDatabase, String str, zzaze zzaze) {
        this.f11098a = sQLiteDatabase;
        this.f11099b = str;
        this.f11100c = zzaze;
    }

    public final void run() {
        zzcqo.m8246g(this.f11098a, this.f11099b, this.f11100c);
    }
}
