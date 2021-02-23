package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzn;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator = "GoogleCertificatesQueryCreator")
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new zzm();
    @SafeParcelable.Field(getter = "getCallingPackage", mo13011id = 1)

    /* renamed from: a */
    private final String f7654a;
    @SafeParcelable.Field(getter = "getCallingCertificateBinder", mo13011id = 2, type = "android.os.IBinder")
    @Nullable

    /* renamed from: b */
    private final C1663b f7655b;
    @SafeParcelable.Field(getter = "getAllowTestKeys", mo13011id = 3)

    /* renamed from: c */
    private final boolean f7656c;
    @SafeParcelable.Field(defaultValue = "false", getter = "getIgnoreTestKeysOverride", mo13011id = 4)

    /* renamed from: d */
    private final boolean f7657d;

    @SafeParcelable.Constructor
    zzj(@SafeParcelable.Param(mo13014id = 1) String str, @SafeParcelable.Param(mo13014id = 2) @Nullable IBinder iBinder, @SafeParcelable.Param(mo13014id = 3) boolean z, @SafeParcelable.Param(mo13014id = 4) boolean z2) {
        this.f7654a = str;
        this.f7655b = m5361a(iBinder);
        this.f7656c = z;
        this.f7657d = z2;
    }

    @Nullable
    /* renamed from: a */
    private static C1663b m5361a(@Nullable IBinder iBinder) {
        byte[] bArr;
        if (iBinder == null) {
            return null;
        }
        try {
            IObjectWrapper zzb = zzn.zza(iBinder).zzb();
            if (zzb == null) {
                bArr = null;
            } else {
                bArr = (byte[]) ObjectWrapper.unwrap(zzb);
            }
            if (bArr != null) {
                return new C1672e(bArr);
            }
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
            return null;
        } catch (RemoteException e) {
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e);
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        IBinder iBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f7654a, false);
        C1663b bVar = this.f7655b;
        if (bVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            iBinder = null;
        } else {
            iBinder = bVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 2, iBinder, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.f7656c);
        SafeParcelWriter.writeBoolean(parcel, 4, this.f7657d);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    zzj(String str, @Nullable C1663b bVar, boolean z, boolean z2) {
        this.f7654a = str;
        this.f7655b = bVar;
        this.f7656c = z;
        this.f7657d = z2;
    }
}
