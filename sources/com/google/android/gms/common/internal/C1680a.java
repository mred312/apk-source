package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.android.gms.common.internal.a */
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
final class C1680a implements Parcelable.Creator<BinderWrapper> {
    C1680a() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new BinderWrapper(parcel, (C1680a) null);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new BinderWrapper[i];
    }
}
