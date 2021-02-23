package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
public final class zzeh {

    /* renamed from: a */
    private static Cipher f16155a;

    /* renamed from: b */
    private static final Object f16156b = new Object();

    /* renamed from: c */
    private static final Object f16157c = new Object();

    public zzeh(SecureRandom secureRandom) {
    }

    /* renamed from: a */
    private static Cipher m8773a() {
        Cipher cipher;
        synchronized (f16157c) {
            if (f16155a == null) {
                f16155a = Cipher.getInstance("AES/CBC/PKCS5Padding");
            }
            cipher = f16155a;
        }
        return cipher;
    }

    public final byte[] zza(byte[] bArr, String str) {
        byte[] doFinal;
        if (bArr.length == 16) {
            try {
                byte[] zzb = zzcv.zzb(str, false);
                if (zzb.length > 16) {
                    ByteBuffer allocate = ByteBuffer.allocate(zzb.length);
                    allocate.put(zzb);
                    allocate.flip();
                    byte[] bArr2 = new byte[16];
                    byte[] bArr3 = new byte[(zzb.length - 16)];
                    allocate.get(bArr2);
                    allocate.get(bArr3);
                    SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                    synchronized (f16156b) {
                        m8773a().init(2, secretKeySpec, new IvParameterSpec(bArr2));
                        doFinal = m8773a().doFinal(bArr3);
                    }
                    return doFinal;
                }
                throw new zzek(this);
            } catch (NoSuchAlgorithmException e) {
                throw new zzek(this, e);
            } catch (InvalidKeyException e2) {
                throw new zzek(this, e2);
            } catch (IllegalBlockSizeException e3) {
                throw new zzek(this, e3);
            } catch (NoSuchPaddingException e4) {
                throw new zzek(this, e4);
            } catch (BadPaddingException e5) {
                throw new zzek(this, e5);
            } catch (InvalidAlgorithmParameterException e6) {
                throw new zzek(this, e6);
            } catch (IllegalArgumentException e7) {
                throw new zzek(this, e7);
            }
        } else {
            throw new zzek(this);
        }
    }

    public final byte[] zzao(String str) {
        try {
            byte[] zzb = zzcv.zzb(str, false);
            if (zzb.length == 32) {
                byte[] bArr = new byte[16];
                ByteBuffer.wrap(zzb, 4, 16).get(bArr);
                for (int i = 0; i < 16; i++) {
                    bArr[i] = (byte) (bArr[i] ^ 68);
                }
                return bArr;
            }
            throw new zzek(this);
        } catch (IllegalArgumentException e) {
            throw new zzek(this, e);
        }
    }

    public final String zzb(byte[] bArr, byte[] bArr2) {
        byte[] doFinal;
        byte[] iv;
        if (bArr.length == 16) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                synchronized (f16156b) {
                    m8773a().init(1, secretKeySpec, (SecureRandom) null);
                    doFinal = m8773a().doFinal(bArr2);
                    iv = m8773a().getIV();
                }
                int length = doFinal.length + iv.length;
                ByteBuffer allocate = ByteBuffer.allocate(length);
                allocate.put(iv).put(doFinal);
                allocate.flip();
                byte[] bArr3 = new byte[length];
                allocate.get(bArr3);
                return zzcv.zza(bArr3, false);
            } catch (NoSuchAlgorithmException e) {
                throw new zzek(this, e);
            } catch (InvalidKeyException e2) {
                throw new zzek(this, e2);
            } catch (IllegalBlockSizeException e3) {
                throw new zzek(this, e3);
            } catch (NoSuchPaddingException e4) {
                throw new zzek(this, e4);
            } catch (BadPaddingException e5) {
                throw new zzek(this, e5);
            }
        } else {
            throw new zzek(this);
        }
    }
}
