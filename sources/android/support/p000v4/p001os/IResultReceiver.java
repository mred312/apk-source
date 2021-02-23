package android.support.p000v4.p001os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: android.support.v4.os.IResultReceiver */
public interface IResultReceiver extends IInterface {

    /* renamed from: android.support.v4.os.IResultReceiver$Default */
    public static class Default implements IResultReceiver {
        public IBinder asBinder() {
            return null;
        }

        public void send(int i, Bundle bundle) {
        }
    }

    /* renamed from: android.support.v4.os.IResultReceiver$Stub */
    public static abstract class Stub extends Binder implements IResultReceiver {

        /* renamed from: android.support.v4.os.IResultReceiver$Stub$a */
        private static class C0106a implements IResultReceiver {

            /* renamed from: b */
            public static IResultReceiver f258b;

            /* renamed from: a */
            private IBinder f259a;

            C0106a(IBinder iBinder) {
                this.f259a = iBinder;
            }

            public IBinder asBinder() {
                return this.f259a;
            }

            public void send(int i, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.os.IResultReceiver");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.f259a.transact(1, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().send(i, bundle);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "android.support.v4.os.IResultReceiver");
        }

        public static IResultReceiver asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IResultReceiver)) {
                return new C0106a(iBinder);
            }
            return (IResultReceiver) queryLocalInterface;
        }

        public static IResultReceiver getDefaultImpl() {
            return C0106a.f258b;
        }

        public static boolean setDefaultImpl(IResultReceiver iResultReceiver) {
            if (C0106a.f258b != null || iResultReceiver == null) {
                return false;
            }
            C0106a.f258b = iResultReceiver;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("android.support.v4.os.IResultReceiver");
                send(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("android.support.v4.os.IResultReceiver");
                return true;
            }
        }
    }

    void send(int i, Bundle bundle);
}
