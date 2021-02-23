package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdcy implements zzdfj<Bundle> {

    /* renamed from: a */
    private final Boolean f15436a;

    public zzdcy(Boolean bool) {
        this.f15436a = bool;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        Boolean bool = this.f15436a;
        if (bool != null) {
            bundle.putBoolean("hw_accel", bool.booleanValue());
        }
    }
}
