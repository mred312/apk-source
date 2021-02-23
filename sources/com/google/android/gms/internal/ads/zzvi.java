package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzvi extends RemoteCreator<zzxh> {
    @VisibleForTesting
    public zzvi() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        if (queryLocalInterface instanceof zzxh) {
            return (zzxh) queryLocalInterface;
        }
        return new zzxk(iBinder);
    }

    public final zzxg zza(Context context, zzvn zzvn, String str, zzani zzani, int i) {
        try {
            IBinder zza = ((zzxh) getRemoteCreatorInstance(context)).zza(ObjectWrapper.wrap(context), zzvn, str, zzani, 203404000, i);
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzxg) {
                return (zzxg) queryLocalInterface;
            }
            return new zzxi(zza);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzaza.zzb("Could not create remote AdManager.", e);
            return null;
        }
    }
}
