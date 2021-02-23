package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzaai;
import com.google.android.gms.internal.ads.zzagc;
import com.google.android.gms.internal.ads.zzagd;
import com.google.android.gms.internal.ads.zzvt;
import com.google.android.gms.internal.ads.zzxn;
import com.google.android.gms.internal.ads.zzxo;

@SafeParcelable.Class(creator = "PublisherAdViewOptionsCreator")
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class PublisherAdViewOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublisherAdViewOptions> CREATOR = new zzc();
    @SafeParcelable.Field(getter = "getManualImpressionsEnabled", mo13011id = 1)
    private final boolean zzbnx;
    @SafeParcelable.Field(getter = "getAppEventListenerBinder", mo13011id = 2, type = "android.os.IBinder")
    @Nullable
    private final zzxo zzbny;
    @Nullable
    private AppEventListener zzbnz;
    @SafeParcelable.Field(getter = "getDelayedBannerAdListenerBinder", mo13011id = 3)
    @Nullable
    private final IBinder zzboa;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean zzbnx = false;
        /* access modifiers changed from: private */
        @Nullable
        public AppEventListener zzbnz;
        /* access modifiers changed from: private */
        @Nullable
        public ShouldDelayBannerRenderingListener zzbob;

        public final PublisherAdViewOptions build() {
            return new PublisherAdViewOptions(this);
        }

        public final Builder setAppEventListener(AppEventListener appEventListener) {
            this.zzbnz = appEventListener;
            return this;
        }

        public final Builder setManualImpressionsEnabled(boolean z) {
            this.zzbnx = z;
            return this;
        }

        @KeepForSdk
        public final Builder setShouldDelayBannerRenderingListener(ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
            this.zzbob = shouldDelayBannerRenderingListener;
            return this;
        }
    }

    private PublisherAdViewOptions(Builder builder) {
        this.zzbnx = builder.zzbnx;
        AppEventListener zzb = builder.zzbnz;
        this.zzbnz = zzb;
        zzaai zzaai = null;
        this.zzbny = zzb != null ? new zzvt(this.zzbnz) : null;
        this.zzboa = builder.zzbob != null ? new zzaai(builder.zzbob) : zzaai;
    }

    @Nullable
    public final AppEventListener getAppEventListener() {
        return this.zzbnz;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzbnx;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, getManualImpressionsEnabled());
        zzxo zzxo = this.zzbny;
        SafeParcelWriter.writeIBinder(parcel, 2, zzxo == null ? null : zzxo.asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzboa, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    public final zzxo zzju() {
        return this.zzbny;
    }

    @Nullable
    public final zzagd zzjv() {
        return zzagc.zzy(this.zzboa);
    }

    @SafeParcelable.Constructor
    PublisherAdViewOptions(@SafeParcelable.Param(mo13014id = 1) boolean z, @SafeParcelable.Param(mo13014id = 2) @Nullable IBinder iBinder, @SafeParcelable.Param(mo13014id = 3) @Nullable IBinder iBinder2) {
        this.zzbnx = z;
        this.zzbny = iBinder != null ? zzxn.zze(iBinder) : null;
        this.zzboa = iBinder2;
    }
}
