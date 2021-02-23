package com.google.android.gms.ads.internal.offline.buffering;

import android.content.Context;
import android.os.RemoteException;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzanj;
import com.google.android.gms.internal.ads.zzaqw;
import com.google.android.gms.internal.ads.zzwq;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public class OfflineNotificationPoster extends Worker {
    private final zzaqw zzdpp;

    public OfflineNotificationPoster(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.zzdpp = zzwq.zzqb().zzb(context, new zzanj());
    }

    public ListenableWorker.Result doWork() {
        try {
            this.zzdpp.zzc(ObjectWrapper.wrap(getApplicationContext()), getInputData().getString("uri"), getInputData().getString("gws_query_id"));
            return ListenableWorker.Result.success();
        } catch (RemoteException unused) {
            return ListenableWorker.Result.failure();
        }
    }
}
