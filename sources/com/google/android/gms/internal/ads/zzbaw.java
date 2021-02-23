package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbaw extends zzbao {
    @Nullable
    public final zzbap zza(Context context, zzbbe zzbbe, int i, boolean z, zzabs zzabs, zzbbf zzbbf) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (!(applicationInfo == null || applicationInfo.targetSdkVersion >= 11)) {
            return null;
        }
        zzbbh zzbbh = new zzbbh(context, zzbbe.zzaao(), zzbbe.getRequestId(), zzabs, zzbbe.zzaai());
        if (i == 2) {
            return new zzbbl(context, zzbbh, zzbbe, z, zzbao.zza(zzbbe), zzbbf);
        }
        return new zzbac(context, zzbbe, z, zzbao.zza(zzbbe), zzbbf, new zzbbh(context, zzbbe.zzaao(), zzbbe.getRequestId(), zzabs, zzbbe.zzaai()));
    }
}
