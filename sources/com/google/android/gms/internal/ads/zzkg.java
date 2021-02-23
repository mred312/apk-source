package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzkg {
    public final int zzaox = 1;
    public final byte[] zzaoy;

    public zzkg(int i, byte[] bArr) {
        this.zzaoy = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzkg.class == obj.getClass()) {
            zzkg zzkg = (zzkg) obj;
            return this.zzaox == zzkg.zzaox && Arrays.equals(this.zzaoy, zzkg.zzaoy);
        }
    }

    public final int hashCode() {
        return (this.zzaox * 31) + Arrays.hashCode(this.zzaoy);
    }
}
