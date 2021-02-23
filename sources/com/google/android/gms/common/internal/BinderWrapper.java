package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new C1680a();

    /* renamed from: a */
    private IBinder f7525a;

    public BinderWrapper() {
        this.f7525a = null;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.f7525a);
    }

    @KeepForSdk
    public BinderWrapper(IBinder iBinder) {
        this.f7525a = null;
        this.f7525a = iBinder;
    }

    private BinderWrapper(Parcel parcel) {
        this.f7525a = null;
        this.f7525a = parcel.readStrongBinder();
    }

    /* synthetic */ BinderWrapper(Parcel parcel, C1680a aVar) {
        this(parcel);
    }
}
