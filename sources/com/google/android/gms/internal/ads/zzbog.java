package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbog<AdT> implements zzbod<AdT> {

    /* renamed from: a */
    private final Map<String, zzcqz<AdT>> f13585a;

    zzbog(Map<String, zzcqz<AdT>> map) {
        this.f13585a = map;
    }

    @Nullable
    public final zzcqz<AdT> zze(int i, String str) {
        return this.f13585a.get(str);
    }
}
