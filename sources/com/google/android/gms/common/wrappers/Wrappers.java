package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public class Wrappers {

    /* renamed from: b */
    private static Wrappers f7652b = new Wrappers();

    /* renamed from: a */
    private PackageManagerWrapper f7653a = null;

    @VisibleForTesting
    /* renamed from: a */
    private final synchronized PackageManagerWrapper m5360a(Context context) {
        if (this.f7653a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f7653a = new PackageManagerWrapper(context);
        }
        return this.f7653a;
    }

    @KeepForSdk
    public static PackageManagerWrapper packageManager(Context context) {
        return f7652b.m5360a(context);
    }
}
