package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* renamed from: com.google.android.gms.dynamite.d */
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
final class C1704d implements DynamiteModule.VersionPolicy {
    C1704d() {
    }

    public final DynamiteModule.VersionPolicy.zza zza(Context context, String str, DynamiteModule.VersionPolicy.zzb zzb) {
        DynamiteModule.VersionPolicy.zza zza = new DynamiteModule.VersionPolicy.zza();
        int zza2 = zzb.zza(context, str);
        zza.zza = zza2;
        if (zza2 != 0) {
            zza.zzc = -1;
        } else {
            int zza3 = zzb.zza(context, str, true);
            zza.zzb = zza3;
            if (zza3 != 0) {
                zza.zzc = 1;
            }
        }
        return zza;
    }
}
