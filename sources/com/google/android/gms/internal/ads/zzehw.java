package com.google.android.gms.internal.ads;

import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzehw implements zzedb {

    /* renamed from: a */
    private final ThreadLocal<Mac> f16180a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final String f16181b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Key f16182c;

    /* renamed from: d */
    private final int f16183d;

    public zzehw(String str, Key key) {
        y70 y70 = new y70(this);
        this.f16180a = y70;
        this.f16181b = str;
        this.f16182c = key;
        if (key.getEncoded().length >= 16) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1823053428:
                    if (str.equals("HMACSHA1")) {
                        c = 0;
                        break;
                    }
                    break;
                case 392315118:
                    if (str.equals("HMACSHA256")) {
                        c = 1;
                        break;
                    }
                    break;
                case 392316170:
                    if (str.equals("HMACSHA384")) {
                        c = 2;
                        break;
                    }
                    break;
                case 392317873:
                    if (str.equals("HMACSHA512")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.f16183d = 20;
                    break;
                case 1:
                    this.f16183d = 32;
                    break;
                case 2:
                    this.f16183d = 48;
                    break;
                case 3:
                    this.f16183d = 64;
                    break;
                default:
                    String valueOf = String.valueOf(str);
                    throw new NoSuchAlgorithmException(valueOf.length() != 0 ? "unknown Hmac algorithm: ".concat(valueOf) : new String("unknown Hmac algorithm: "));
            }
            y70.get();
            return;
        }
        throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
    }

    public final byte[] zzd(byte[] bArr, int i) {
        if (i <= this.f16183d) {
            this.f16180a.get().update(bArr);
            return Arrays.copyOf(this.f16180a.get().doFinal(), i);
        }
        throw new InvalidAlgorithmParameterException("tag size too big");
    }
}
