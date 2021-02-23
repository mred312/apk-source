package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzaut extends RemoteCreator<zzaun> {
    public zzaut() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
        if (queryLocalInterface instanceof zzaun) {
            return (zzaun) queryLocalInterface;
        }
        return new zzaum(iBinder);
    }

    public final zzaui zzc(Context context, zzani zzani) {
        try {
            IBinder zzd = ((zzaun) getRemoteCreatorInstance(context)).zzd(ObjectWrapper.wrap(context), zzani, 203404000);
            if (zzd == null) {
                return null;
            }
            IInterface queryLocalInterface = zzd.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
            if (queryLocalInterface instanceof zzaui) {
                return (zzaui) queryLocalInterface;
            }
            return new zzauk(zzd);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzaza.zzd("Could not get remote RewardedVideoAd.", e);
            return null;
        }
    }
}
