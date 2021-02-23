package com.google.android.gms.internal.common;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public class zzb implements IInterface {

    /* renamed from: a */
    private final IBinder f17207a;

    /* renamed from: b */
    private final String f17208b;

    protected zzb(IBinder iBinder, String str) {
        this.f17207a = iBinder;
        this.f17208b = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a_ */
    public final Parcel mo18531a_() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f17208b);
        return obtain;
    }

    public IBinder asBinder() {
        return this.f17207a;
    }

    /* access modifiers changed from: protected */
    public final Parcel zza(int i, Parcel parcel) {
        parcel = Parcel.obtain();
        try {
            this.f17207a.transact(i, parcel, parcel, 0);
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
            this.f17207a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzc(int i, Parcel parcel) {
        try {
            this.f17207a.transact(2, parcel, (Parcel) null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
