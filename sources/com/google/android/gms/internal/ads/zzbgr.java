package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzbgr implements zzepf<WeakReference<Context>> {

    /* renamed from: a */
    private final zzbgl f13257a;

    public zzbgr(zzbgl zzbgl) {
        this.f13257a = zzbgl;
    }

    public final /* synthetic */ Object get() {
        return (WeakReference) zzepl.zza(this.f13257a.mo16254b(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
