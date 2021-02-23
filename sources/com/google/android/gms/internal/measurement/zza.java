package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.6.0 */
public class zza implements IInterface {

    /* renamed from: a */
    private final IBinder f17554a;

    /* renamed from: b */
    private final String f17555b;

    protected zza(IBinder iBinder, String str) {
        this.f17554a = iBinder;
        this.f17555b = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a_ */
    public final Parcel mo18994a_() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f17555b);
        return obtain;
    }

    public IBinder asBinder() {
        return this.f17554a;
    }

    /* access modifiers changed from: protected */
    public final Parcel zza(int i, Parcel parcel) {
        parcel = Parcel.obtain();
        try {
            this.f17554a.transact(i, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e) {
            throw e;
        } finally {
            parcel.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzb(int i, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.f17554a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
