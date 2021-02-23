package com.google.android.gms.internal.ads;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public abstract class zzxv extends zzgw implements zzxw {
    public zzxv() {
        super("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                initialize();
                parcel2.writeNoException();
                return true;
            case 2:
                setAppVolume(parcel.readFloat());
                parcel2.writeNoException();
                return true;
            case 3:
                zzcd(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 4:
                setAppMuted(zzgv.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 5:
                zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                zza(parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 7:
                float zzqk = zzqk();
                parcel2.writeNoException();
                parcel2.writeFloat(zzqk);
                return true;
            case 8:
                boolean zzql = zzql();
                parcel2.writeNoException();
                zzgv.writeBoolean(parcel2, zzql);
                return true;
            case 9:
                String versionString = getVersionString();
                parcel2.writeNoException();
                parcel2.writeString(versionString);
                return true;
            case 10:
                zzce(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                zza(zzanl.zzac(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 12:
                zza(zzajf.zzaa(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 13:
                List<zzaiz> zzqm = zzqm();
                parcel2.writeNoException();
                parcel2.writeTypedList(zzqm);
                return true;
            case 14:
                zza((zzaae) zzgv.zza(parcel, zzaae.CREATOR));
                parcel2.writeNoException();
                return true;
            case 15:
                zzqn();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
