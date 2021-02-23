package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* renamed from: com.google.android.gms.dynamite.c */
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
final class C1703c implements DynamiteModule.VersionPolicy {
    C1703c() {
    }

    public final DynamiteModule.VersionPolicy.zza zza(Context context, String str, DynamiteModule.VersionPolicy.zzb zzb) {
        DynamiteModule.VersionPolicy.zza zza = new DynamiteModule.VersionPolicy.zza();
        int zza2 = zzb.zza(context, str, false);
        zza.zzb = zza2;
        if (zza2 == 0) {
            zza.zzc = 0;
        } else {
            zza.zzc = 1;
        }
        return zza;
    }
}
