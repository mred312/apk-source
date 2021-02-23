package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzg;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzabu extends zzabz {

    /* renamed from: a */
    private final zzg f12372a;
    @Nullable

    /* renamed from: b */
    private final String f12373b;

    /* renamed from: c */
    private final String f12374c;

    public zzabu(zzg zzg, @Nullable String str, String str2) {
        this.f12372a = zzg;
        this.f12373b = str;
        this.f12374c = str2;
    }

    public final String getContent() {
        return this.f12374c;
    }

    public final void recordClick() {
        this.f12372a.zzkb();
    }

    public final void recordImpression() {
        this.f12372a.zzkc();
    }

    public final void zzn(@Nullable IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper != null) {
            this.f12372a.zzh((View) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public final String zzrz() {
        return this.f12373b;
    }
}
