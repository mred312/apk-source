package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzabn {
    public static boolean zza(@Nullable zzabs zzabs, @Nullable zzabq zzabq, String... strArr) {
        if (zzabs == null || zzabq == null || !zzabs.f12365a || zzabq == null) {
            return false;
        }
        return zzabs.zza(zzabq, zzp.zzkx().elapsedRealtime(), strArr);
    }

    @Nullable
    public static zzabq zzb(@Nullable zzabs zzabs) {
        if (zzabs == null) {
            return null;
        }
        return zzabs.zzex(zzp.zzkx().elapsedRealtime());
    }
}
