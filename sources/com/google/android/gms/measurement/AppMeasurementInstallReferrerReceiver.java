package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.measurement.zzag;

@KeepForSdk
@Deprecated
/* compiled from: com.google.android.gms:play-services-measurement-api@@17.6.0 */
public final class AppMeasurementInstallReferrerReceiver extends BroadcastReceiver {
    @Nullable
    public final BroadcastReceiver.PendingResult doGoAsync() {
        return goAsync();
    }

    public final void doStartService(@Nullable Context context, @Nullable Intent intent) {
    }

    @MainThread
    public final void onReceive(@NonNull Context context, @Nullable Intent intent) {
        zzag.zza(context).zza(5, "Install Referrer Broadcast deprecated", (Object) null, (Object) null, (Object) null);
    }
}
