package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "NativeAdLayoutInfoParcelCreator")
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzasl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzasl> CREATOR = new zzask();
    @SafeParcelable.Field(getter = "getAdViewAsBinder", mo13011id = 1, type = "android.os.IBinder")
    public final View zzaaq;
    @SafeParcelable.Field(getter = "getAssetViewMapAsBinder", mo13011id = 2, type = "android.os.IBinder")
    public final Map<String, WeakReference<View>> zzdse;

    @SafeParcelable.Constructor
    public zzasl(@SafeParcelable.Param(mo13014id = 1) IBinder iBinder, @SafeParcelable.Param(mo13014id = 2) IBinder iBinder2) {
        this.zzaaq = (View) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.zzdse = (Map) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder2));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 1, ObjectWrapper.wrap(this.zzaaq).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 2, ObjectWrapper.wrap(this.zzdse).asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
