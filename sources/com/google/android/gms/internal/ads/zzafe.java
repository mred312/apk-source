package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public abstract class zzafe extends zzgw implements zzaff {
    public zzafe() {
        super("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    public static zzaff zzr(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
        if (queryLocalInterface instanceof zzaff) {
            return (zzaff) queryLocalInterface;
        }
        return new zzafh(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                String zzct = zzct(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(zzct);
                return true;
            case 2:
                zzaej zzcu = zzcu(parcel.readString());
                parcel2.writeNoException();
                zzgv.zza(parcel2, (IInterface) zzcu);
                return true;
            case 3:
                List<String> availableAssetNames = getAvailableAssetNames();
                parcel2.writeNoException();
                parcel2.writeStringList(availableAssetNames);
                return true;
            case 4:
                String customTemplateId = getCustomTemplateId();
                parcel2.writeNoException();
                parcel2.writeString(customTemplateId);
                return true;
            case 5:
                performClick(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                recordImpression();
                parcel2.writeNoException();
                return true;
            case 7:
                zzys videoController = getVideoController();
                parcel2.writeNoException();
                zzgv.zza(parcel2, (IInterface) videoController);
                return true;
            case 8:
                destroy();
                parcel2.writeNoException();
                return true;
            case 9:
                IObjectWrapper zzta = zzta();
                parcel2.writeNoException();
                zzgv.zza(parcel2, (IInterface) zzta);
                return true;
            case 10:
                boolean zzp = zzp(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgv.writeBoolean(parcel2, zzp);
                return true;
            case 11:
                IObjectWrapper zzsv = zzsv();
                parcel2.writeNoException();
                zzgv.zza(parcel2, (IInterface) zzsv);
                return true;
            case 12:
                boolean zztb = zztb();
                parcel2.writeNoException();
                zzgv.writeBoolean(parcel2, zztb);
                return true;
            case 13:
                boolean zztc = zztc();
                parcel2.writeNoException();
                zzgv.writeBoolean(parcel2, zztc);
                return true;
            case 14:
                zzq(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 15:
                zztd();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
