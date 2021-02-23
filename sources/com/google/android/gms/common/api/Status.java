package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepForSdk
@SafeParcelable.Class(creator = "StatusCreator")
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new zzb();
    @ShowFirstParty
    @KeepForSdk
    public static final Status RESULT_CANCELED = new Status(16);
    @KeepForSdk
    public static final Status RESULT_DEAD_CLIENT = new Status(18);
    @ShowFirstParty
    @KeepForSdk
    public static final Status RESULT_INTERNAL_ERROR = new Status(8);
    @ShowFirstParty
    @KeepForSdk
    public static final Status RESULT_INTERRUPTED = new Status(14);
    @ShowFirstParty
    @KeepForSdk
    @VisibleForTesting
    public static final Status RESULT_SUCCESS = new Status(0);
    @ShowFirstParty
    @KeepForSdk
    public static final Status RESULT_TIMEOUT = new Status(15);
    @SafeParcelable.VersionField(mo13017id = 1000)

    /* renamed from: a */
    private final int f7465a;
    @SafeParcelable.Field(getter = "getStatusCode", mo13011id = 1)

    /* renamed from: b */
    private final int f7466b;
    @SafeParcelable.Field(getter = "getStatusMessage", mo13011id = 2)
    @Nullable

    /* renamed from: c */
    private final String f7467c;
    @SafeParcelable.Field(getter = "getPendingIntent", mo13011id = 3)
    @Nullable

    /* renamed from: d */
    private final PendingIntent f7468d;

    static {
        new Status(17);
    }

    @SafeParcelable.Constructor
    @KeepForSdk
    Status(@SafeParcelable.Param(mo13014id = 1000) int i, @SafeParcelable.Param(mo13014id = 1) int i2, @SafeParcelable.Param(mo13014id = 2) @Nullable String str, @SafeParcelable.Param(mo13014id = 3) @Nullable PendingIntent pendingIntent) {
        this.f7465a = i;
        this.f7466b = i2;
        this.f7467c = str;
        this.f7468d = pendingIntent;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        if (this.f7465a != status.f7465a || this.f7466b != status.f7466b || !Objects.equal(this.f7467c, status.f7467c) || !Objects.equal(this.f7468d, status.f7468d)) {
            return false;
        }
        return true;
    }

    @Nullable
    public final PendingIntent getResolution() {
        return this.f7468d;
    }

    @KeepForSdk
    public final Status getStatus() {
        return this;
    }

    public final int getStatusCode() {
        return this.f7466b;
    }

    @Nullable
    public final String getStatusMessage() {
        return this.f7467c;
    }

    @VisibleForTesting
    public final boolean hasResolution() {
        return this.f7468d != null;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f7465a), Integer.valueOf(this.f7466b), this.f7467c, this.f7468d);
    }

    public final boolean isCanceled() {
        return this.f7466b == 16;
    }

    public final boolean isInterrupted() {
        return this.f7466b == 14;
    }

    public final boolean isSuccess() {
        return this.f7466b <= 0;
    }

    public final void startResolutionForResult(Activity activity, int i) {
        if (hasResolution()) {
            activity.startIntentSenderForResult(((PendingIntent) Preconditions.checkNotNull(this.f7468d)).getIntentSender(), i, (Intent) null, 0, 0, 0);
        }
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("statusCode", zza()).add("resolution", this.f7468d).toString();
    }

    @KeepForSdk
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getStatusCode());
        SafeParcelWriter.writeString(parcel, 2, getStatusMessage(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f7468d, i, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.f7465a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zza() {
        String str = this.f7467c;
        if (str != null) {
            return str;
        }
        return CommonStatusCodes.getStatusCodeString(this.f7466b);
    }

    @KeepForSdk
    public Status(int i) {
        this(i, (String) null);
    }

    @KeepForSdk
    public Status(int i, @Nullable String str) {
        this(1, i, str, (PendingIntent) null);
    }

    @KeepForSdk
    public Status(int i, @Nullable String str, @Nullable PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }
}
