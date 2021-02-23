package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzd;

/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public interface IFragmentWrapper extends IInterface {
    IObjectWrapper zza();

    void zza(Intent intent);

    void zza(Intent intent, int i);

    void zza(IObjectWrapper iObjectWrapper);

    void zza(boolean z);

    Bundle zzb();

    void zzb(IObjectWrapper iObjectWrapper);

    void zzb(boolean z);

    int zzc();

    void zzc(boolean z);

    IFragmentWrapper zzd();

    void zzd(boolean z);

    IObjectWrapper zze();

    boolean zzf();

    String zzg();

    IFragmentWrapper zzh();

    int zzi();

    boolean zzj();

    IObjectWrapper zzk();

    boolean zzl();

    boolean zzm();

    boolean zzn();

    boolean zzo();

    boolean zzp();

    boolean zzq();

    boolean zzr();

    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    public static abstract class Stub extends com.google.android.gms.internal.common.zza implements IFragmentWrapper {
        public Stub() {
            super("com.google.android.gms.dynamic.IFragmentWrapper");
        }

        public static IFragmentWrapper asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            if (queryLocalInterface instanceof IFragmentWrapper) {
                return (IFragmentWrapper) queryLocalInterface;
            }
            return new zza(iBinder);
        }

        /* access modifiers changed from: protected */
        public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 2:
                    IObjectWrapper zza2 = zza();
                    parcel2.writeNoException();
                    zzd.zza(parcel2, (IInterface) zza2);
                    return true;
                case 3:
                    Bundle zzb = zzb();
                    parcel2.writeNoException();
                    zzd.zzb(parcel2, zzb);
                    return true;
                case 4:
                    int zzc = zzc();
                    parcel2.writeNoException();
                    parcel2.writeInt(zzc);
                    return true;
                case 5:
                    IFragmentWrapper zzd = zzd();
                    parcel2.writeNoException();
                    zzd.zza(parcel2, (IInterface) zzd);
                    return true;
                case 6:
                    IObjectWrapper zze = zze();
                    parcel2.writeNoException();
                    zzd.zza(parcel2, (IInterface) zze);
                    return true;
                case 7:
                    boolean zzf = zzf();
                    parcel2.writeNoException();
                    zzd.zza(parcel2, zzf);
                    return true;
                case 8:
                    String zzg = zzg();
                    parcel2.writeNoException();
                    parcel2.writeString(zzg);
                    return true;
                case 9:
                    IFragmentWrapper zzh = zzh();
                    parcel2.writeNoException();
                    zzd.zza(parcel2, (IInterface) zzh);
                    return true;
                case 10:
                    int zzi = zzi();
                    parcel2.writeNoException();
                    parcel2.writeInt(zzi);
                    return true;
                case 11:
                    boolean zzj = zzj();
                    parcel2.writeNoException();
                    zzd.zza(parcel2, zzj);
                    return true;
                case 12:
                    IObjectWrapper zzk = zzk();
                    parcel2.writeNoException();
                    zzd.zza(parcel2, (IInterface) zzk);
                    return true;
                case 13:
                    boolean zzl = zzl();
                    parcel2.writeNoException();
                    zzd.zza(parcel2, zzl);
                    return true;
                case 14:
                    boolean zzm = zzm();
                    parcel2.writeNoException();
                    zzd.zza(parcel2, zzm);
                    return true;
                case 15:
                    boolean zzn = zzn();
                    parcel2.writeNoException();
                    zzd.zza(parcel2, zzn);
                    return true;
                case 16:
                    boolean zzo = zzo();
                    parcel2.writeNoException();
                    zzd.zza(parcel2, zzo);
                    return true;
                case 17:
                    boolean zzp = zzp();
                    parcel2.writeNoException();
                    zzd.zza(parcel2, zzp);
                    return true;
                case 18:
                    boolean zzq = zzq();
                    parcel2.writeNoException();
                    zzd.zza(parcel2, zzq);
                    return true;
                case 19:
                    boolean zzr = zzr();
                    parcel2.writeNoException();
                    zzd.zza(parcel2, zzr);
                    return true;
                case 20:
                    zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 21:
                    zza(zzd.zza(parcel));
                    parcel2.writeNoException();
                    return true;
                case 22:
                    zzb(zzd.zza(parcel));
                    parcel2.writeNoException();
                    return true;
                case 23:
                    zzc(zzd.zza(parcel));
                    parcel2.writeNoException();
                    return true;
                case 24:
                    zzd(zzd.zza(parcel));
                    parcel2.writeNoException();
                    return true;
                case 25:
                    zza((Intent) zzd.zza(parcel, Intent.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 26:
                    zza((Intent) zzd.zza(parcel, Intent.CREATOR), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 27:
                    zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return false;
            }
        }

        /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
        public static class zza extends zzb implements IFragmentWrapper {
            zza(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IFragmentWrapper");
            }

            public final IObjectWrapper zza() {
                Parcel zza = zza(2, mo18531a_());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
                zza.recycle();
                return asInterface;
            }

            public final Bundle zzb() {
                Parcel zza = zza(3, mo18531a_());
                Bundle bundle = (Bundle) zzd.zza(zza, Bundle.CREATOR);
                zza.recycle();
                return bundle;
            }

            public final int zzc() {
                Parcel zza = zza(4, mo18531a_());
                int readInt = zza.readInt();
                zza.recycle();
                return readInt;
            }

            public final IFragmentWrapper zzd() {
                Parcel zza = zza(5, mo18531a_());
                IFragmentWrapper asInterface = Stub.asInterface(zza.readStrongBinder());
                zza.recycle();
                return asInterface;
            }

            public final IObjectWrapper zze() {
                Parcel zza = zza(6, mo18531a_());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
                zza.recycle();
                return asInterface;
            }

            public final boolean zzf() {
                Parcel zza = zza(7, mo18531a_());
                boolean zza2 = zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            public final String zzg() {
                Parcel zza = zza(8, mo18531a_());
                String readString = zza.readString();
                zza.recycle();
                return readString;
            }

            public final IFragmentWrapper zzh() {
                Parcel zza = zza(9, mo18531a_());
                IFragmentWrapper asInterface = Stub.asInterface(zza.readStrongBinder());
                zza.recycle();
                return asInterface;
            }

            public final int zzi() {
                Parcel zza = zza(10, mo18531a_());
                int readInt = zza.readInt();
                zza.recycle();
                return readInt;
            }

            public final boolean zzj() {
                Parcel zza = zza(11, mo18531a_());
                boolean zza2 = zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            public final IObjectWrapper zzk() {
                Parcel zza = zza(12, mo18531a_());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
                zza.recycle();
                return asInterface;
            }

            public final boolean zzl() {
                Parcel zza = zza(13, mo18531a_());
                boolean zza2 = zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            public final boolean zzm() {
                Parcel zza = zza(14, mo18531a_());
                boolean zza2 = zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            public final boolean zzn() {
                Parcel zza = zza(15, mo18531a_());
                boolean zza2 = zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            public final boolean zzo() {
                Parcel zza = zza(16, mo18531a_());
                boolean zza2 = zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            public final boolean zzp() {
                Parcel zza = zza(17, mo18531a_());
                boolean zza2 = zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            public final boolean zzq() {
                Parcel zza = zza(18, mo18531a_());
                boolean zza2 = zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            public final boolean zzr() {
                Parcel zza = zza(19, mo18531a_());
                boolean zza2 = zzd.zza(zza);
                zza.recycle();
                return zza2;
            }

            public final void zza(IObjectWrapper iObjectWrapper) {
                Parcel a_ = mo18531a_();
                zzd.zza(a_, (IInterface) iObjectWrapper);
                zzb(20, a_);
            }

            public final void zzb(boolean z) {
                Parcel a_ = mo18531a_();
                zzd.zza(a_, z);
                zzb(22, a_);
            }

            public final void zzc(boolean z) {
                Parcel a_ = mo18531a_();
                zzd.zza(a_, z);
                zzb(23, a_);
            }

            public final void zzd(boolean z) {
                Parcel a_ = mo18531a_();
                zzd.zza(a_, z);
                zzb(24, a_);
            }

            public final void zza(boolean z) {
                Parcel a_ = mo18531a_();
                zzd.zza(a_, z);
                zzb(21, a_);
            }

            public final void zzb(IObjectWrapper iObjectWrapper) {
                Parcel a_ = mo18531a_();
                zzd.zza(a_, (IInterface) iObjectWrapper);
                zzb(27, a_);
            }

            public final void zza(Intent intent) {
                Parcel a_ = mo18531a_();
                zzd.zza(a_, (Parcelable) intent);
                zzb(25, a_);
            }

            public final void zza(Intent intent, int i) {
                Parcel a_ = mo18531a_();
                zzd.zza(a_, (Parcelable) intent);
                a_.writeInt(i);
                zzb(26, a_);
            }
        }
    }
}
