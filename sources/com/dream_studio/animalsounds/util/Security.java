package com.dream_studio.animalsounds.util;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.Key;
import com.medio.myutilities.Base64;
import com.medio.myutilities.Base64DecoderException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class Security {

    /* renamed from: a */
    private static final byte[] f6894a = {19, 73, 7, 31, 20, 3, 9, 11, 19, 73, 12, 14, 19, 44, 1, 17};

    public static String AESDecrypt(String str) {
        try {
            return new String(m4953a(m4955c("PremiumSoftware2014"), Base64.decode(str)), Key.STRING_CHARSET_NAME);
        } catch (Exception unused) {
            Log.e("IABUtil/Security", "Exception.");
            return null;
        }
    }

    public static String AESEncrypt(String str) {
        try {
            return Base64.encode(m4954b(m4955c("PremiumSoftware2014"), str.getBytes(Key.STRING_CHARSET_NAME)));
        } catch (Exception unused) {
            Log.e("IABUtil/Security", "Exception.");
            return null;
        }
    }

    /* renamed from: a */
    private static byte[] m4953a(byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES");
            instance.init(2, secretKeySpec);
            return instance.doFinal(bArr2);
        } catch (NoSuchAlgorithmException unused) {
            Log.e("IABUtil/Security", "NoSuchAlgorithmException.");
            return null;
        } catch (NoSuchPaddingException unused2) {
            Log.e("IABUtil/Security", "NoSuchPaddingException.");
            return null;
        } catch (IllegalBlockSizeException unused3) {
            Log.e("IABUtil/Security", "IllegalBlockSizeException.");
            return null;
        } catch (BadPaddingException unused4) {
            Log.e("IABUtil/Security", "BadPaddingException.");
            return null;
        } catch (InvalidKeyException unused5) {
            Log.e("IABUtil/Security", "InvalidKeyException.");
            return null;
        }
    }

    /* renamed from: b */
    private static byte[] m4954b(byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES");
            instance.init(1, secretKeySpec);
            return instance.doFinal(bArr2);
        } catch (NoSuchAlgorithmException unused) {
            Log.e("IABUtil/Security", "NoSuchAlgorithmException.");
            return null;
        } catch (NoSuchPaddingException unused2) {
            Log.e("IABUtil/Security", "NoSuchPaddingException.");
            return null;
        } catch (InvalidKeyException unused3) {
            Log.e("IABUtil/Security", "InvalidKeyException.");
            return null;
        } catch (IllegalBlockSizeException unused4) {
            Log.e("IABUtil/Security", "IllegalBlockSizeException.");
            return null;
        } catch (BadPaddingException unused5) {
            Log.e("IABUtil/Security", "BadPaddingException.");
            return null;
        } catch (Exception unused6) {
            Log.e("IABUtil/Security", "Exception.");
            return null;
        }
    }

    /* renamed from: c */
    private static byte[] m4955c(String str) {
        try {
            return SecretKeyFactory.getInstance("PBEWITHSHA256AND128BITAES-CBC-BC").generateSecret(new PBEKeySpec(str.toCharArray(), f6894a, str.length())).getEncoded();
        } catch (NullPointerException unused) {
            Log.e("IABUtil/Security", "NullPointerException.");
            return null;
        } catch (NoSuchAlgorithmException unused2) {
            Log.e("IABUtil/Security", "NoSuchAlgorithmException.");
            return null;
        } catch (InvalidKeySpecException unused3) {
            Log.e("IABUtil/Security", "InvalidKeySpecException.");
            return null;
        } catch (IllegalArgumentException unused4) {
            Log.e("IABUtil/Security", "IllegalArgumentException.");
            return null;
        }
    }

    public static PublicKey generatePublicKey(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str)));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e2) {
            Log.e("IABUtil/Security", "Invalid key specification.");
            throw new IllegalArgumentException(e2);
        } catch (Base64DecoderException e3) {
            Log.e("IABUtil/Security", "Base64 decoding failed.");
            throw new IllegalArgumentException(e3);
        } catch (Exception e4) {
            Log.e("IABUtil/Security", "Exception.");
            throw new RuntimeException(e4);
        }
    }

    public static String getPublicKey() {
        return AESDecrypt("4tfhUOTjxYRQtTNhab5S4Siipccjgz8HwV/e1p4JTM1qP3F/LrZ07M231A1gKE8DgwldfP+6CWdj9PUNZnoiX5JTcxT+v4HSrUex2gjhR6rHskXZJqf2aB8Xt27LvxjminpAr10NFH+uAjISbfESbhSF6Jz9xPWhT4eMTJMR/XAXMCzcutXFa5ouWGTaftRWegRAx8btV896kaaJWa3mprdpTDK9OO8+J8fDnJ5cQKj7XNZgPPDJVuKg3dA7HH8bJv+jc3d/+GsQQfUr4c78ckV2FSweZyGGhjhsu288l3ZBoYS+aFmo6xG40byLhprgnQy3GuCwiXxaQ+2Ofcbl+viClPbuCqj7JRO8H+mVDG/WqVajikg2j6YSQWQKRwGeS9egPRbCxE3v7dyVEHjLq4+dyFvz4fzo7+//8kdaSB/ytqLd6VKUe3TshY0SyVgn+a8iSkF7+tlewiQ5gOmzIb/sl/QGkCTNw+/UiNXv34/Jm90OIZTh+L2jWtxkDGi9TrNf3APpr00XKsCsrvDWTw==");
    }

    public static boolean verify(PublicKey publicKey, String str, String str2) {
        try {
            Signature instance = Signature.getInstance("SHA1withRSA");
            instance.initVerify(publicKey);
            instance.update(str.getBytes());
            if (instance.verify(Base64.decode(str2))) {
                return true;
            }
            Log.e("IABUtil/Security", "Signature verification failed.");
            return false;
        } catch (NoSuchAlgorithmException unused) {
            Log.e("IABUtil/Security", "NoSuchAlgorithmException.");
            return false;
        } catch (InvalidKeyException unused2) {
            Log.e("IABUtil/Security", "Invalid key specification.");
            return false;
        } catch (SignatureException unused3) {
            Log.e("IABUtil/Security", "Signature exception.");
            return false;
        } catch (Base64DecoderException unused4) {
            Log.e("IABUtil/Security", "Base64 decoding failed.");
            return false;
        } catch (Exception unused5) {
            Log.e("IABUtil/Security", "Exception.");
            return false;
        }
    }

    public static boolean verifyPurchase(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            return verify(generatePublicKey(str), str2, str3);
        }
        Log.e("IABUtil/Security", "Purchase verification failed: missing data.");
        return false;
    }
}
