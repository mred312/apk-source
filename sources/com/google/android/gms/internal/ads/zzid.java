package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzid {

    /* renamed from: a */
    private static final int[] f16460a = {1, 2, 3, 6};

    /* renamed from: b */
    private static final int[] f16461b = {48000, 44100, 32000};

    /* renamed from: c */
    private static final int[] f16462c = {2, 1, 2, 3, 3, 4, 4, 5};

    public static zzhp zza(zzpn zzpn, String str, String str2, zzjo zzjo) {
        int i = f16461b[(zzpn.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = zzpn.readUnsignedByte();
        int i2 = f16462c[(readUnsignedByte & 56) >> 3];
        if ((readUnsignedByte & 4) != 0) {
            i2++;
        }
        return zzhp.zza(str, "audio/ac3", (String) null, -1, -1, i2, i, (List<byte[]>) null, zzjo, 0, str2);
    }

    public static zzhp zzb(zzpn zzpn, String str, String str2, zzjo zzjo) {
        zzpn zzpn2 = zzpn;
        zzpn.zzbm(2);
        int i = f16461b[(zzpn.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = zzpn.readUnsignedByte();
        int i2 = f16462c[(readUnsignedByte & 14) >> 1];
        if ((readUnsignedByte & 1) != 0) {
            i2++;
        }
        return zzhp.zza(str, "audio/eac3", (String) null, -1, -1, i2, i, (List<byte[]>) null, zzjo, 0, str2);
    }

    public static int zzfi() {
        return 1536;
    }

    public static int zzm(ByteBuffer byteBuffer) {
        int i = 6;
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i = f16460a[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4];
        }
        return i * 256;
    }
}
