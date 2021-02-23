package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* renamed from: com.google.android.gms.dynamite.b */
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
final class C1702b implements DynamiteModule.VersionPolicy.zzb {
    C1702b() {
    }

    public final int zza(Context context, String str, boolean z) {
        return DynamiteModule.zza(context, str, z);
    }

    public final int zza(Context context, String str) {
        return DynamiteModule.getLocalVersion(context, str);
    }
}
