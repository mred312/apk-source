package com.google.android.gms.internal.ads;

import com.bumptech.glide.load.Key;
import com.google.android.gms.internal.ads.zzcf;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.internal.ads.rq */
/* compiled from: com.google.android.gms:play-services-ads@@19.5.0 */
final class C2370rq {

    /* renamed from: a */
    private static boolean f10817a = false;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static MessageDigest f10818b;

    /* renamed from: c */
    private static final Object f10819c = new Object();

    /* renamed from: d */
    private static final Object f10820d = new Object();

    /* renamed from: e */
    static CountDownLatch f10821e = new CountDownLatch(1);

    /* renamed from: a */
    private static zzcf.zza m6819a(zzcf.zza.zzd zzd) {
        zzcf.zza.C3977zza zzaq = zzcf.zza.zzaq();
        zzaq.zzn((long) zzd.zzv());
        return (zzcf.zza) ((zzekh) zzaq.zzbhv());
    }

    /* renamed from: c */
    private static Vector<byte[]> m6821c(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + 255) - 1) / 255;
        Vector<byte[]> vector = new Vector<>();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 * 255;
            try {
                vector.add(Arrays.copyOfRange(bArr, i3, bArr.length - i3 > 255 ? i3 + 255 : bArr.length));
                i2++;
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    /* renamed from: d */
    private static byte[] m6822d(byte[] bArr, String str, boolean z) {
        byte[] bArr2;
        int i = z ? 239 : 255;
        if (bArr.length > i) {
            bArr = m6819a(zzcf.zza.zzd.PSN_ENCODE_SIZE_FAIL).toByteArray();
        }
        if (bArr.length < i) {
            byte[] bArr3 = new byte[(i - bArr.length)];
            new SecureRandom().nextBytes(bArr3);
            bArr2 = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).put(bArr3).array();
        } else {
            bArr2 = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).array();
        }
        if (z) {
            bArr2 = ByteBuffer.allocate(256).put(m6823e(bArr2)).put(bArr2).array();
        }
        byte[] bArr4 = new byte[256];
        for (C2638yt a : new zzdc().f15260N2) {
            a.mo13788a(bArr2, bArr4);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzeil(str.getBytes(Key.STRING_CHARSET_NAME)).zzs(bArr4);
        }
        return bArr4;
    }

    /* renamed from: e */
    public static byte[] m6823e(byte[] bArr) {
        byte[] digest;
        synchronized (f10819c) {
            MessageDigest g = m6825g();
            if (g != null) {
                g.reset();
                g.update(bArr);
                digest = f10818b.digest();
            } else {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
        }
        return digest;
    }

    /* renamed from: f */
    static void m6824f() {
        synchronized (f10820d) {
            if (!f10817a) {
                f10817a = true;
                new Thread(new C2449tr()).start();
            }
        }
    }

    /* renamed from: g */
    private static MessageDigest m6825g() {
        boolean z;
        MessageDigest messageDigest;
        m6824f();
        try {
            z = f10821e.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            z = false;
        }
        if (z && (messageDigest = f10818b) != null) {
            return messageDigest;
        }
        return null;
    }

    /* renamed from: h */
    static String m6826h(zzcf.zza zza, String str) {
        byte[] bArr;
        byte[] byteArray = zza.toByteArray();
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcrg)).booleanValue()) {
            Vector<byte[]> c = m6821c(byteArray, 255);
            if (c == null || c.size() == 0) {
                bArr = m6822d(m6819a(zzcf.zza.zzd.PSN_ENCODE_SIZE_FAIL).toByteArray(), str, true);
            } else {
                zzcf.zzf.zza zzbl = zzcf.zzf.zzbl();
                Iterator<byte[]> it = c.iterator();
                while (it.hasNext()) {
                    zzbl.zzj(zzeiu.zzt(m6822d(it.next(), str, false)));
                }
                zzbl.zzk(zzeiu.zzt(m6823e(byteArray)));
                bArr = ((zzcf.zzf) ((zzekh) zzbl.zzbhv())).toByteArray();
            }
        } else if (bd0.f7910a != null) {
            bArr = ((zzcf.zzf) ((zzekh) zzcf.zzf.zzbl().zzj(zzeiu.zzt(bd0.f7910a.zzc(byteArray, str != null ? str.getBytes() : new byte[0]))).zzb(zzcm.TINK_HYBRID).zzbhv())).toByteArray();
        } else {
            throw new GeneralSecurityException();
        }
        return zzcv.zza(bArr, true);
    }
}
