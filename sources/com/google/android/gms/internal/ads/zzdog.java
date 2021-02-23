package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzdog {
    public static ParcelFileDescriptor zzf(InputStream inputStream) {
        ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
        ParcelFileDescriptor parcelFileDescriptor = createPipe[0];
        zzazj.zzegp.execute(new C2605xy(inputStream, createPipe[1]));
        return parcelFileDescriptor;
    }
}
