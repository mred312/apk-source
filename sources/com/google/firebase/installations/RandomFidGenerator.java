package com.google.firebase.installations;

import android.util.Base64;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.UUID;

public class RandomFidGenerator {

    /* renamed from: a */
    private static final byte f19592a = Byte.parseByte("01110000", 2);

    /* renamed from: b */
    private static final byte f19593b = Byte.parseByte("00001111", 2);

    /* renamed from: a */
    private static String m11790a(byte[] bArr) {
        return new String(Base64.encode(bArr, 11), Charset.defaultCharset()).substring(0, 22);
    }

    /* renamed from: b */
    private static byte[] m11791b(UUID uuid, byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.putLong(uuid.getMostSignificantBits());
        wrap.putLong(uuid.getLeastSignificantBits());
        return wrap.array();
    }

    @NonNull
    public String createRandomFid() {
        byte[] b = m11791b(UUID.randomUUID(), new byte[17]);
        b[16] = b[0];
        b[0] = (byte) ((f19593b & b[0]) | f19592a);
        return m11790a(b);
    }
}
