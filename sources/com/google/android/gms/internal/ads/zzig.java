package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import java.util.Arrays;

@TargetApi(21)
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzig {

    /* renamed from: a */
    private final int[] f16463a;

    /* renamed from: b */
    private final int f16464b = 2;

    static {
        new zzig(new int[]{2}, 2);
    }

    private zzig(int[] iArr, int i) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        this.f16463a = copyOf;
        Arrays.sort(copyOf);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzig)) {
            return false;
        }
        zzig zzig = (zzig) obj;
        return Arrays.equals(this.f16463a, zzig.f16463a) && this.f16464b == zzig.f16464b;
    }

    public final int hashCode() {
        return this.f16464b + (Arrays.hashCode(this.f16463a) * 31);
    }

    public final String toString() {
        int i = this.f16464b;
        String arrays = Arrays.toString(this.f16463a);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 67);
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(i);
        sb.append(", supportedEncodings=");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }
}
