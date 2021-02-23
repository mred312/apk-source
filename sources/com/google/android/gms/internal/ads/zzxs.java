package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public abstract class zzxs extends zzgw implements zzxp {
    public zzxs() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                zzxg zza = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzvn) zzgv.zza(parcel, zzvn.CREATOR), parcel.readString(), zzanl.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgv.zza(parcel2, (IInterface) zza);
                return true;
            case 2:
                zzxg zzb = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzvn) zzgv.zza(parcel, zzvn.CREATOR), parcel.readString(), zzanl.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgv.zza(parcel2, (IInterface) zzb);
                return true;
            case 3:
                zzwz zza2 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), zzanl.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgv.zza(parcel2, (IInterface) zza2);
                return true;
            case 4:
                zzxw zzc = zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgv.zza(parcel2, (IInterface) zzc);
                return true;
            case 5:
                zzaen zza3 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgv.zza(parcel2, (IInterface) zza3);
                return true;
            case 6:
                zzaui zza4 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzanl.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgv.zza(parcel2, (IInterface) zza4);
                return true;
            case 7:
                zzaru zzd = zzd(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgv.zza(parcel2, (IInterface) zzd);
                return true;
            case 8:
                zzarj zzb2 = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgv.zza(parcel2, (IInterface) zzb2);
                return true;
            case 9:
                zzxw zza5 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgv.zza(parcel2, (IInterface) zza5);
                return true;
            case 10:
                zzxg zza6 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzvn) zzgv.zza(parcel, zzvn.CREATOR), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                zzgv.zza(parcel2, (IInterface) zza6);
                return true;
            case 11:
                zzaeq zza7 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgv.zza(parcel2, (IInterface) zza7);
                return true;
            case 12:
                zzavh zzb3 = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), zzanl.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgv.zza(parcel2, (IInterface) zzb3);
                return true;
            case 13:
                zzxg zzc2 = zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzvn) zzgv.zza(parcel, zzvn.CREATOR), parcel.readString(), zzanl.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgv.zza(parcel2, (IInterface) zzc2);
                return true;
            case 14:
                zzaxq zzb4 = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzanl.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgv.zza(parcel2, (IInterface) zzb4);
                return true;
            case 15:
                zzaqw zzc3 = zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzanl.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgv.zza(parcel2, (IInterface) zzc3);
                return true;
            default:
                return false;
        }
    }
}
