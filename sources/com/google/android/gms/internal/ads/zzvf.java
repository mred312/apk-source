package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzvf extends RemoteCreator<zzxe> {
    public zzvf() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
        if (queryLocalInterface instanceof zzxe) {
            return (zzxe) queryLocalInterface;
        }
        return new zzxd(iBinder);
    }

    public final zzwz zza(Context context, String str, zzani zzani) {
        try {
            IBinder zzc = ((zzxe) getRemoteCreatorInstance(context)).zzc(ObjectWrapper.wrap(context), str, zzani, 203404000);
            if (zzc == null) {
                return null;
            }
            IInterface queryLocalInterface = zzc.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (queryLocalInterface instanceof zzwz) {
                return (zzwz) queryLocalInterface;
            }
            return new zzxb(zzc);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzaza.zzd("Could not create remote builder for AdLoader.", e);
            return null;
        }
    }
}
