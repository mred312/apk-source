package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Iterator;

@SafeParcelable.Class(creator = "EventParamsCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.6.0 */
public final class zzam extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzam> CREATOR = new zzao();
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "z", mo13011id = 2)

    /* renamed from: a */
    public final Bundle f18510a;

    @SafeParcelable.Constructor
    zzam(@SafeParcelable.Param(mo13014id = 2) Bundle bundle) {
        this.f18510a = bundle;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final Object mo20239b(String str) {
        return this.f18510a.get(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final Long mo20240c(String str) {
        return Long.valueOf(this.f18510a.getLong(str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final Double mo20241d(String str) {
        return Double.valueOf(this.f18510a.getDouble(str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final String mo20242e(String str) {
        return this.f18510a.getString(str);
    }

    public final Iterator<String> iterator() {
        return new C3009i(this);
    }

    public final String toString() {
        return this.f18510a.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, zzb(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.f18510a.size();
    }

    public final Bundle zzb() {
        return new Bundle(this.f18510a);
    }
}
