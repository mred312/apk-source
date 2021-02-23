package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* renamed from: com.google.android.gms.dynamite.e */
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
final class C1705e implements DynamiteModule.VersionPolicy {
    C1705e() {
    }

    public final DynamiteModule.VersionPolicy.zza zza(Context context, String str, DynamiteModule.VersionPolicy.zzb zzb) {
        DynamiteModule.VersionPolicy.zza zza = new DynamiteModule.VersionPolicy.zza();
        int zza2 = zzb.zza(context, str);
        zza.zza = zza2;
        if (zza2 != 0) {
            zza.zzb = zzb.zza(context, str, false);
        } else {
            zza.zzb = zzb.zza(context, str, true);
        }
        int i = zza.zza;
        if (i == 0 && zza.zzb == 0) {
            zza.zzc = 0;
        } else if (i >= zza.zzb) {
            zza.zzc = -1;
        } else {
            zza.zzc = 1;
        }
        return zza;
    }
}
