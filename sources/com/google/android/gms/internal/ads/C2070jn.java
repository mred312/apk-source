package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* renamed from: com.google.android.gms.internal.ads.jn */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2070jn implements zzdyo<SQLiteDatabase> {

    /* renamed from: a */
    private final /* synthetic */ zzdqv f9536a;

    C2070jn(zzcpr zzcpr, zzdqv zzdqv) {
        this.f9536a = zzdqv;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        try {
            this.f9536a.apply((SQLiteDatabase) obj);
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzaza.zzey(valueOf.length() != 0 ? "Error executing function on offline signal database: ".concat(valueOf) : new String("Error executing function on offline signal database: "));
        }
    }

    public final void zzb(Throwable th) {
        String valueOf = String.valueOf(th.getMessage());
        zzaza.zzey(valueOf.length() != 0 ? "Failed to get offline signal database: ".concat(valueOf) : new String("Failed to get offline signal database: "));
    }
}
