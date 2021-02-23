package com.google.android.gms.internal.common;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
public final class zzn {
    public static <T> zzo<T> zza(zzo<T> zzo) {
        if ((zzo instanceof C2709c) || (zzo instanceof C2710d)) {
            return zzo;
        }
        if (zzo instanceof Serializable) {
            return new C2710d(zzo);
        }
        return new C2709c(zzo);
    }
}
