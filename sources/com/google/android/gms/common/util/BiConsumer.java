package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public interface BiConsumer<T, U> {
    @KeepForSdk
    void accept(T t, U u);
}
