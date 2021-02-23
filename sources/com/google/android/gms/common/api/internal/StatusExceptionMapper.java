package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public interface StatusExceptionMapper {
    @KeepForSdk
    Exception getException(Status status);
}
