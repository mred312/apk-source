package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.5.0 */
public final class zzagp {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener f12453a;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: b */
    public final NativeCustomTemplateAd.OnCustomClickListener f12454b;
    @GuardedBy("this")
    @Nullable

    /* renamed from: c */
    private NativeCustomTemplateAd f12455c;

    public zzagp(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, @Nullable NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.f12453a = onCustomTemplateAdLoadedListener;
        this.f12454b = onCustomClickListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final synchronized NativeCustomTemplateAd m7445d(zzaff zzaff) {
        NativeCustomTemplateAd nativeCustomTemplateAd = this.f12455c;
        if (nativeCustomTemplateAd != null) {
            return nativeCustomTemplateAd;
        }
        zzafg zzafg = new zzafg(zzaff);
        this.f12455c = zzafg;
        return zzafg;
    }

    public final zzafq zzti() {
        return new C2607y(this);
    }

    @Nullable
    public final zzafp zztj() {
        if (this.f12454b == null) {
            return null;
        }
        return new C2645z(this);
    }
}
