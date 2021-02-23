package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;

/* renamed from: com.google.android.gms.internal.ads.kb */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2095kb implements zzaz {

    /* renamed from: a */
    private File f9740a = null;

    /* renamed from: b */
    private final /* synthetic */ Context f9741b;

    C2095kb(Context context) {
        this.f9741b = context;
    }

    public final File zzo() {
        if (this.f9740a == null) {
            this.f9740a = new File(this.f9741b.getCacheDir(), "volley");
        }
        return this.f9740a;
    }
}
