package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* renamed from: com.google.android.gms.internal.ads.wn */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2556wn implements zzdyo<SQLiteDatabase> {

    /* renamed from: a */
    private final /* synthetic */ zzdqv f11723a;

    C2556wn(zzcqo zzcqo, zzdqv zzdqv) {
        this.f11723a = zzdqv;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        try {
            this.f11723a.apply((SQLiteDatabase) obj);
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzaza.zzey(valueOf.length() != 0 ? "Error executing function on offline buffered ping database: ".concat(valueOf) : new String("Error executing function on offline buffered ping database: "));
        }
    }

    public final void zzb(Throwable th) {
        String valueOf = String.valueOf(th.getMessage());
        zzaza.zzey(valueOf.length() != 0 ? "Failed to get offline buffered ping database: ".concat(valueOf) : new String("Failed to get offline buffered ping database: "));
    }
}
