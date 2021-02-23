package com.google.android.gms.common.internal;

import android.net.Uri;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public final class ResourceUtils {
    static {
        new Uri.Builder().scheme("android.resource").authority("com.google.android.gms").appendPath("drawable").build();
    }

    private ResourceUtils() {
    }
}
