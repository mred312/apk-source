package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.InputStream;
import javax.annotation.concurrent.GuardedBy;

@SafeParcelable.Class(creator = "CacheEntryParcelCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzta extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzta> CREATOR = new zztd();
    @GuardedBy("this")
    @SafeParcelable.Field(getter = "getContentFileDescriptor", mo13011id = 2)
    @Nullable

    /* renamed from: a */
    private ParcelFileDescriptor f16992a;
    @GuardedBy("this")
    @SafeParcelable.Field(getter = "hasAdditionalMetadataFromReadV2", mo13011id = 3)

    /* renamed from: b */
    private final boolean f16993b;
    @GuardedBy("this")
    @SafeParcelable.Field(getter = "isDownloaded", mo13011id = 4)

    /* renamed from: c */
    private final boolean f16994c;
    @GuardedBy("this")
    @SafeParcelable.Field(getter = "getCachedBytes", mo13011id = 5)

    /* renamed from: d */
    private final long f16995d;
    @GuardedBy("this")
    @SafeParcelable.Field(getter = "isGcacheHit", mo13011id = 6)

    /* renamed from: e */
    private final boolean f16996e;

    public zzta() {
        this((ParcelFileDescriptor) null, false, false, 0, false);
    }

    /* renamed from: a */
    private final synchronized ParcelFileDescriptor m9106a() {
        return this.f16992a;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, m9106a(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 3, zzmy());
        SafeParcelWriter.writeBoolean(parcel, 4, zzmz());
        SafeParcelWriter.writeLong(parcel, 5, zzna());
        SafeParcelWriter.writeBoolean(parcel, 6, zznb());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final synchronized boolean zzmv() {
        return this.f16992a != null;
    }

    @Nullable
    public final synchronized InputStream zzmw() {
        if (this.f16992a == null) {
            return null;
        }
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(this.f16992a);
        this.f16992a = null;
        return autoCloseInputStream;
    }

    public final synchronized boolean zzmy() {
        return this.f16993b;
    }

    public final synchronized boolean zzmz() {
        return this.f16994c;
    }

    public final synchronized long zzna() {
        return this.f16995d;
    }

    public final synchronized boolean zznb() {
        return this.f16996e;
    }

    @SafeParcelable.Constructor
    public zzta(@SafeParcelable.Param(mo13014id = 2) @Nullable ParcelFileDescriptor parcelFileDescriptor, @SafeParcelable.Param(mo13014id = 3) boolean z, @SafeParcelable.Param(mo13014id = 4) boolean z2, @SafeParcelable.Param(mo13014id = 5) long j, @SafeParcelable.Param(mo13014id = 6) boolean z3) {
        this.f16992a = parcelFileDescriptor;
        this.f16993b = z;
        this.f16994c = z2;
        this.f16995d = j;
        this.f16996e = z3;
    }
}
