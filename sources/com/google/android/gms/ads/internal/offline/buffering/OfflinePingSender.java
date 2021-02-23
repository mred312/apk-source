package com.google.android.gms.ads.internal.offline.buffering;

import android.content.Context;
import android.os.RemoteException;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzanj;
import com.google.android.gms.internal.ads.zzaqw;
import com.google.android.gms.internal.ads.zzwq;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public class OfflinePingSender extends Worker {
    private final zzaqw zzdpp;

    public OfflinePingSender(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.zzdpp = zzwq.zzqb().zzb(context, new zzanj());
    }

    public ListenableWorker.Result doWork() {
        try {
            this.zzdpp.zzuz();
            return ListenableWorker.Result.success();
        } catch (RemoteException unused) {
            return ListenableWorker.Result.failure();
        }
    }
}
