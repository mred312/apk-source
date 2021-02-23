package com.google.android.gms.internal.ads;

import android.support.p000v4.media.session.PlaybackStateCompat;
import androidx.core.view.InputDeviceCompat;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-gass@@19.5.0 */
public final class zzb {
    /* renamed from: a */
    private static int m7630a(int i) {
        if (i == 513) {
            return 1;
        }
        if (i == 514) {
            return 2;
        }
        if (i == 769) {
            return 1;
        }
        switch (i) {
            case InputDeviceCompat.SOURCE_KEYBOARD:
            case 259:
                return 1;
            case 258:
            case 260:
                return 2;
            default:
                String valueOf = String.valueOf(Long.toHexString((long) i));
                throw new IllegalArgumentException(valueOf.length() != 0 ? "Unknown signature algorithm: 0x".concat(valueOf) : new String("Unknown signature algorithm: 0x"));
        }
    }

    /* renamed from: b */
    private static ByteBuffer m7631b(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() >= 4) {
            int i = byteBuffer.getInt();
            if (i < 0) {
                throw new IllegalArgumentException("Negative length");
            } else if (i <= byteBuffer.remaining()) {
                return m7632c(byteBuffer, i);
            } else {
                int remaining = byteBuffer.remaining();
                StringBuilder sb = new StringBuilder(101);
                sb.append("Length-prefixed field longer than remaining buffer. Field length: ");
                sb.append(i);
                sb.append(", remaining: ");
                sb.append(remaining);
                throw new IOException(sb.toString());
            }
        } else {
            int remaining2 = byteBuffer.remaining();
            StringBuilder sb2 = new StringBuilder(93);
            sb2.append("Remaining buffer too short to contain length of length-prefixed field. Remaining: ");
            sb2.append(remaining2);
            throw new IOException(sb2.toString());
        }
    }

    /* renamed from: c */
    private static ByteBuffer m7632c(ByteBuffer byteBuffer, int i) {
        if (i >= 0) {
            int limit = byteBuffer.limit();
            int position = byteBuffer.position();
            int i2 = i + position;
            if (i2 < position || i2 > limit) {
                throw new BufferUnderflowException();
            }
            byteBuffer.limit(i2);
            try {
                ByteBuffer slice = byteBuffer.slice();
                slice.order(byteBuffer.order());
                byteBuffer.position(i2);
                return slice;
            } finally {
                byteBuffer.limit(limit);
            }
        } else {
            StringBuilder sb = new StringBuilder(17);
            sb.append("size: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: d */
    private static ByteBuffer m7633d(ByteBuffer byteBuffer, int i, int i2) {
        if (i2 >= 8) {
            int capacity = byteBuffer.capacity();
            if (i2 <= byteBuffer.capacity()) {
                int limit = byteBuffer.limit();
                int position = byteBuffer.position();
                try {
                    byteBuffer.position(0);
                    byteBuffer.limit(i2);
                    byteBuffer.position(8);
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    byteBuffer.position(0);
                    byteBuffer.limit(limit);
                    byteBuffer.position(position);
                    return slice;
                } catch (Throwable th) {
                    byteBuffer.position(0);
                    byteBuffer.limit(limit);
                    byteBuffer.position(position);
                    throw th;
                }
            } else {
                StringBuilder sb = new StringBuilder(41);
                sb.append("end > capacity: ");
                sb.append(i2);
                sb.append(" > ");
                sb.append(capacity);
                throw new IllegalArgumentException(sb.toString());
            }
        } else {
            StringBuilder sb2 = new StringBuilder(38);
            sb2.append("end < start: ");
            sb2.append(i2);
            sb2.append(" < 8");
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    /* renamed from: e */
    private static void m7634e(int i, byte[] bArr, int i2) {
        bArr[1] = (byte) i;
        bArr[2] = (byte) (i >>> 8);
        bArr[3] = (byte) (i >>> 16);
        bArr[4] = (byte) (i >>> 24);
    }

    /* JADX WARNING: Removed duplicated region for block: B:142:0x0015 A[SYNTHETIC] */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.security.cert.X509Certificate[] m7635f(java.nio.ByteBuffer r22, java.util.Map<java.lang.Integer, byte[]> r23, java.security.cert.CertificateFactory r24) {
        /*
            java.nio.ByteBuffer r0 = m7631b(r22)
            java.nio.ByteBuffer r1 = m7631b(r22)
            byte[] r2 = m7639j(r22)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r4 = -1
            r7 = -1
            r8 = 0
            r9 = 0
        L_0x0015:
            boolean r10 = r1.hasRemaining()
            r11 = 8
            r12 = 769(0x301, float:1.078E-42)
            r13 = 514(0x202, float:7.2E-43)
            r14 = 513(0x201, float:7.19E-43)
            r15 = 1
            if (r10 == 0) goto L_0x00d8
            int r8 = r8 + 1
            java.nio.ByteBuffer r10 = m7631b(r1)     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            int r6 = r10.remaining()     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            if (r6 < r11) goto L_0x00b4
            int r6 = r10.getInt()     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r6)     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            r3.add(r11)     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            if (r6 == r14) goto L_0x0046
            if (r6 == r13) goto L_0x0046
            if (r6 == r12) goto L_0x0046
            switch(r6) {
                case 257: goto L_0x0046;
                case 258: goto L_0x0046;
                case 259: goto L_0x0046;
                case 260: goto L_0x0046;
                default: goto L_0x0044;
            }     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
        L_0x0044:
            r11 = 0
            goto L_0x0047
        L_0x0046:
            r11 = 1
        L_0x0047:
            if (r11 != 0) goto L_0x004a
            goto L_0x0015
        L_0x004a:
            if (r7 == r4) goto L_0x00ac
            int r11 = m7630a(r6)     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            int r12 = m7630a(r7)     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            java.lang.String r13 = "Unknown digestAlgorithm2: "
            r14 = 37
            r5 = 2
            if (r11 == r15) goto L_0x008e
            if (r11 != r5) goto L_0x0077
            if (r12 == r15) goto L_0x00aa
            if (r12 != r5) goto L_0x0062
            goto L_0x00a9
        L_0x0062:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            r1.<init>(r14)     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            r1.append(r13)     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            r1.append(r12)     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            r0.<init>(r1)     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            throw r0     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
        L_0x0077:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            r1.<init>(r14)     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            java.lang.String r2 = "Unknown digestAlgorithm1: "
            r1.append(r2)     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            r1.append(r11)     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            r0.<init>(r1)     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            throw r0     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
        L_0x008e:
            if (r12 == r15) goto L_0x00a9
            if (r12 != r5) goto L_0x0094
            r15 = -1
            goto L_0x00aa
        L_0x0094:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            r1.<init>(r14)     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            r1.append(r13)     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            r1.append(r12)     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            r0.<init>(r1)     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            throw r0     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
        L_0x00a9:
            r15 = 0
        L_0x00aa:
            if (r15 <= 0) goto L_0x0015
        L_0x00ac:
            byte[] r5 = m7639j(r10)     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            r9 = r5
            r7 = r6
            goto L_0x0015
        L_0x00b4:
            java.lang.SecurityException r0 = new java.lang.SecurityException     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            java.lang.String r1 = "Signature record too short"
            r0.<init>(r1)     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
            throw r0     // Catch:{ IOException -> 0x00be, BufferUnderflowException -> 0x00bc }
        L_0x00bc:
            r0 = move-exception
            goto L_0x00bf
        L_0x00be:
            r0 = move-exception
        L_0x00bf:
            java.lang.SecurityException r1 = new java.lang.SecurityException
            r2 = 45
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Failed to parse signature record #"
            r3.append(r2)
            r3.append(r8)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x00d8:
            if (r7 != r4) goto L_0x00ec
            if (r8 != 0) goto L_0x00e4
            java.lang.SecurityException r0 = new java.lang.SecurityException
            java.lang.String r1 = "No signatures found"
            r0.<init>(r1)
            throw r0
        L_0x00e4:
            java.lang.SecurityException r0 = new java.lang.SecurityException
            java.lang.String r1 = "No supported signatures found"
            r0.<init>(r1)
            throw r0
        L_0x00ec:
            java.lang.String r1 = "Unknown signature algorithm: 0x"
            if (r7 == r14) goto L_0x011d
            if (r7 == r13) goto L_0x011d
            if (r7 == r12) goto L_0x011a
            switch(r7) {
                case 257: goto L_0x0117;
                case 258: goto L_0x0117;
                case 259: goto L_0x0117;
                case 260: goto L_0x0117;
                default: goto L_0x00f7;
            }
        L_0x00f7:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            long r2 = (long) r7
            java.lang.String r2 = java.lang.Long.toHexString(r2)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x010d
            java.lang.String r1 = r1.concat(r2)
            goto L_0x0113
        L_0x010d:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r1)
            r1 = r2
        L_0x0113:
            r0.<init>(r1)
            throw r0
        L_0x0117:
            java.lang.String r4 = "RSA"
            goto L_0x011f
        L_0x011a:
            java.lang.String r4 = "DSA"
            goto L_0x011f
        L_0x011d:
            java.lang.String r4 = "EC"
        L_0x011f:
            if (r7 == r14) goto L_0x0199
            if (r7 == r13) goto L_0x0191
            if (r7 == r12) goto L_0x0189
            switch(r7) {
                case 257: goto L_0x0170;
                case 258: goto L_0x0158;
                case 259: goto L_0x0150;
                case 260: goto L_0x0148;
                default: goto L_0x0128;
            }
        L_0x0128:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            long r2 = (long) r7
            java.lang.String r2 = java.lang.Long.toHexString(r2)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x013e
            java.lang.String r1 = r1.concat(r2)
            goto L_0x0144
        L_0x013e:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r1)
            r1 = r2
        L_0x0144:
            r0.<init>(r1)
            throw r0
        L_0x0148:
            java.lang.String r1 = "SHA512withRSA"
            r5 = 0
            android.util.Pair r1 = android.util.Pair.create(r1, r5)
            goto L_0x01a0
        L_0x0150:
            r5 = 0
            java.lang.String r1 = "SHA256withRSA"
            android.util.Pair r1 = android.util.Pair.create(r1, r5)
            goto L_0x01a0
        L_0x0158:
            java.security.spec.PSSParameterSpec r1 = new java.security.spec.PSSParameterSpec
            java.security.spec.MGF1ParameterSpec r19 = java.security.spec.MGF1ParameterSpec.SHA512
            r20 = 64
            r21 = 1
            java.lang.String r17 = "SHA-512"
            java.lang.String r18 = "MGF1"
            r16 = r1
            r16.<init>(r17, r18, r19, r20, r21)
            java.lang.String r5 = "SHA512withRSA/PSS"
            android.util.Pair r1 = android.util.Pair.create(r5, r1)
            goto L_0x0187
        L_0x0170:
            java.security.spec.PSSParameterSpec r1 = new java.security.spec.PSSParameterSpec
            java.security.spec.MGF1ParameterSpec r19 = java.security.spec.MGF1ParameterSpec.SHA256
            r20 = 32
            r21 = 1
            java.lang.String r17 = "SHA-256"
            java.lang.String r18 = "MGF1"
            r16 = r1
            r16.<init>(r17, r18, r19, r20, r21)
            java.lang.String r5 = "SHA256withRSA/PSS"
            android.util.Pair r1 = android.util.Pair.create(r5, r1)
        L_0x0187:
            r5 = 0
            goto L_0x01a0
        L_0x0189:
            java.lang.String r1 = "SHA256withDSA"
            r5 = 0
            android.util.Pair r1 = android.util.Pair.create(r1, r5)
            goto L_0x01a0
        L_0x0191:
            r5 = 0
            java.lang.String r1 = "SHA512withECDSA"
            android.util.Pair r1 = android.util.Pair.create(r1, r5)
            goto L_0x01a0
        L_0x0199:
            r5 = 0
            java.lang.String r1 = "SHA256withECDSA"
            android.util.Pair r1 = android.util.Pair.create(r1, r5)
        L_0x01a0:
            java.lang.Object r6 = r1.first
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r1 = r1.second
            java.security.spec.AlgorithmParameterSpec r1 = (java.security.spec.AlgorithmParameterSpec) r1
            java.security.KeyFactory r4 = java.security.KeyFactory.getInstance(r4)     // Catch:{ NoSuchAlgorithmException -> 0x02ee, InvalidKeySpecException -> 0x02ec, InvalidKeyException -> 0x02ea, InvalidAlgorithmParameterException -> 0x02e8, SignatureException -> 0x02e6 }
            java.security.spec.X509EncodedKeySpec r8 = new java.security.spec.X509EncodedKeySpec     // Catch:{ NoSuchAlgorithmException -> 0x02ee, InvalidKeySpecException -> 0x02ec, InvalidKeyException -> 0x02ea, InvalidAlgorithmParameterException -> 0x02e8, SignatureException -> 0x02e6 }
            r8.<init>(r2)     // Catch:{ NoSuchAlgorithmException -> 0x02ee, InvalidKeySpecException -> 0x02ec, InvalidKeyException -> 0x02ea, InvalidAlgorithmParameterException -> 0x02e8, SignatureException -> 0x02e6 }
            java.security.PublicKey r4 = r4.generatePublic(r8)     // Catch:{ NoSuchAlgorithmException -> 0x02ee, InvalidKeySpecException -> 0x02ec, InvalidKeyException -> 0x02ea, InvalidAlgorithmParameterException -> 0x02e8, SignatureException -> 0x02e6 }
            java.security.Signature r8 = java.security.Signature.getInstance(r6)     // Catch:{ NoSuchAlgorithmException -> 0x02ee, InvalidKeySpecException -> 0x02ec, InvalidKeyException -> 0x02ea, InvalidAlgorithmParameterException -> 0x02e8, SignatureException -> 0x02e6 }
            r8.initVerify(r4)     // Catch:{ NoSuchAlgorithmException -> 0x02ee, InvalidKeySpecException -> 0x02ec, InvalidKeyException -> 0x02ea, InvalidAlgorithmParameterException -> 0x02e8, SignatureException -> 0x02e6 }
            if (r1 == 0) goto L_0x01c1
            r8.setParameter(r1)     // Catch:{ NoSuchAlgorithmException -> 0x02ee, InvalidKeySpecException -> 0x02ec, InvalidKeyException -> 0x02ea, InvalidAlgorithmParameterException -> 0x02e8, SignatureException -> 0x02e6 }
        L_0x01c1:
            r8.update(r0)     // Catch:{ NoSuchAlgorithmException -> 0x02ee, InvalidKeySpecException -> 0x02ec, InvalidKeyException -> 0x02ea, InvalidAlgorithmParameterException -> 0x02e8, SignatureException -> 0x02e6 }
            boolean r1 = r8.verify(r9)     // Catch:{ NoSuchAlgorithmException -> 0x02ee, InvalidKeySpecException -> 0x02ec, InvalidKeyException -> 0x02ea, InvalidAlgorithmParameterException -> 0x02e8, SignatureException -> 0x02e6 }
            if (r1 == 0) goto L_0x02d6
            r0.clear()
            java.nio.ByteBuffer r1 = m7631b(r0)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r6 = 0
        L_0x01d7:
            boolean r8 = r1.hasRemaining()
            if (r8 == 0) goto L_0x021e
            int r6 = r6 + r15
            java.nio.ByteBuffer r8 = m7631b(r1)     // Catch:{ IOException -> 0x0204, BufferUnderflowException -> 0x0202 }
            int r9 = r8.remaining()     // Catch:{ IOException -> 0x0204, BufferUnderflowException -> 0x0202 }
            if (r9 < r11) goto L_0x01fa
            int r9 = r8.getInt()     // Catch:{ IOException -> 0x0204, BufferUnderflowException -> 0x0202 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r9)     // Catch:{ IOException -> 0x0204, BufferUnderflowException -> 0x0202 }
            r4.add(r10)     // Catch:{ IOException -> 0x0204, BufferUnderflowException -> 0x0202 }
            if (r9 != r7) goto L_0x01d7
            byte[] r5 = m7639j(r8)     // Catch:{ IOException -> 0x0204, BufferUnderflowException -> 0x0202 }
            goto L_0x01d7
        L_0x01fa:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0204, BufferUnderflowException -> 0x0202 }
            java.lang.String r1 = "Record too short"
            r0.<init>(r1)     // Catch:{ IOException -> 0x0204, BufferUnderflowException -> 0x0202 }
            throw r0     // Catch:{ IOException -> 0x0204, BufferUnderflowException -> 0x0202 }
        L_0x0202:
            r0 = move-exception
            goto L_0x0205
        L_0x0204:
            r0 = move-exception
        L_0x0205:
            java.io.IOException r1 = new java.io.IOException
            r2 = 42
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Failed to parse digest record #"
            r3.append(r2)
            r3.append(r6)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x021e:
            boolean r1 = r3.equals(r4)
            if (r1 == 0) goto L_0x02ce
            int r1 = m7630a(r7)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
            r4 = r23
            java.lang.Object r3 = r4.put(r3, r5)
            byte[] r3 = (byte[]) r3
            if (r3 == 0) goto L_0x0251
            boolean r3 = java.security.MessageDigest.isEqual(r3, r5)
            if (r3 == 0) goto L_0x023d
            goto L_0x0251
        L_0x023d:
            java.lang.SecurityException r0 = new java.lang.SecurityException
            java.lang.String r1 = m7638i(r1)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = " contents digest does not match the digest specified by a preceding signer"
            java.lang.String r1 = r1.concat(r2)
            r0.<init>(r1)
            throw r0
        L_0x0251:
            java.nio.ByteBuffer r0 = m7631b(r0)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r3 = 0
        L_0x025b:
            boolean r4 = r0.hasRemaining()
            if (r4 == 0) goto L_0x0296
            int r3 = r3 + r15
            byte[] r4 = m7639j(r0)
            java.io.ByteArrayInputStream r5 = new java.io.ByteArrayInputStream     // Catch:{ CertificateException -> 0x027c }
            r5.<init>(r4)     // Catch:{ CertificateException -> 0x027c }
            r6 = r24
            java.security.cert.Certificate r5 = r6.generateCertificate(r5)     // Catch:{ CertificateException -> 0x027c }
            java.security.cert.X509Certificate r5 = (java.security.cert.X509Certificate) r5     // Catch:{ CertificateException -> 0x027c }
            com.google.android.gms.internal.ads.gd0 r7 = new com.google.android.gms.internal.ads.gd0
            r7.<init>(r5, r4)
            r1.add(r7)
            goto L_0x025b
        L_0x027c:
            r0 = move-exception
            java.lang.SecurityException r1 = new java.lang.SecurityException
            r2 = 41
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r2)
            java.lang.String r2 = "Failed to decode certificate #"
            r4.append(r2)
            r4.append(r3)
            java.lang.String r2 = r4.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x0296:
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto L_0x02c6
            r0 = 0
            java.lang.Object r0 = r1.get(r0)
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0
            java.security.PublicKey r0 = r0.getPublicKey()
            byte[] r0 = r0.getEncoded()
            boolean r0 = java.util.Arrays.equals(r2, r0)
            if (r0 == 0) goto L_0x02be
            int r0 = r1.size()
            java.security.cert.X509Certificate[] r0 = new java.security.cert.X509Certificate[r0]
            java.lang.Object[] r0 = r1.toArray(r0)
            java.security.cert.X509Certificate[] r0 = (java.security.cert.X509Certificate[]) r0
            return r0
        L_0x02be:
            java.lang.SecurityException r0 = new java.lang.SecurityException
            java.lang.String r1 = "Public key mismatch between certificate and signature record"
            r0.<init>(r1)
            throw r0
        L_0x02c6:
            java.lang.SecurityException r0 = new java.lang.SecurityException
            java.lang.String r1 = "No certificates listed"
            r0.<init>(r1)
            throw r0
        L_0x02ce:
            java.lang.SecurityException r0 = new java.lang.SecurityException
            java.lang.String r1 = "Signature algorithms don't match between digests and signatures records"
            r0.<init>(r1)
            throw r0
        L_0x02d6:
            java.lang.SecurityException r0 = new java.lang.SecurityException
            java.lang.String r1 = java.lang.String.valueOf(r6)
            java.lang.String r2 = " signature did not verify"
            java.lang.String r1 = r1.concat(r2)
            r0.<init>(r1)
            throw r0
        L_0x02e6:
            r0 = move-exception
            goto L_0x02ef
        L_0x02e8:
            r0 = move-exception
            goto L_0x02ef
        L_0x02ea:
            r0 = move-exception
            goto L_0x02ef
        L_0x02ec:
            r0 = move-exception
            goto L_0x02ef
        L_0x02ee:
            r0 = move-exception
        L_0x02ef:
            java.lang.SecurityException r1 = new java.lang.SecurityException
            java.lang.String r2 = java.lang.String.valueOf(r6)
            int r2 = r2.length()
            int r2 = r2 + 27
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Failed to verify "
            r3.append(r2)
            r3.append(r6)
            java.lang.String r2 = " signature"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2, r0)
            goto L_0x0316
        L_0x0315:
            throw r1
        L_0x0316:
            goto L_0x0315
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzb.m7635f(java.nio.ByteBuffer, java.util.Map, java.security.cert.CertificateFactory):java.security.cert.X509Certificate[]");
    }

    /* renamed from: g */
    private static byte[][] m7636g(int[] iArr, C2475ug[] ugVarArr) {
        long j;
        int[] iArr2 = iArr;
        C2475ug[] ugVarArr2 = ugVarArr;
        int length = ugVarArr2.length;
        long j2 = 0;
        int i = 0;
        long j3 = 0;
        int i2 = 0;
        while (true) {
            j = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            if (i2 >= length) {
                break;
            }
            j3 += ((ugVarArr2[i2].size() + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) - 1) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            i2++;
        }
        if (j3 < 2097151) {
            int i3 = (int) j3;
            byte[][] bArr = new byte[iArr2.length][];
            for (int i4 = 0; i4 < iArr2.length; i4++) {
                byte[] bArr2 = new byte[((m7640k(iArr2[i4]) * i3) + 5)];
                bArr2[0] = 90;
                m7634e(i3, bArr2, 1);
                bArr[i4] = bArr2;
            }
            byte[] bArr3 = new byte[5];
            bArr3[0] = -91;
            int length2 = iArr2.length;
            MessageDigest[] messageDigestArr = new MessageDigest[length2];
            int i5 = 0;
            while (i5 < iArr2.length) {
                String i6 = m7638i(iArr2[i5]);
                try {
                    messageDigestArr[i5] = MessageDigest.getInstance(i6);
                    i5++;
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(String.valueOf(i6).concat(" digest not supported"), e);
                }
            }
            int length3 = ugVarArr2.length;
            int i7 = 0;
            int i8 = 0;
            while (i7 < length3) {
                C2475ug ugVar = ugVarArr2[i7];
                long j4 = j2;
                int i9 = i8;
                int i10 = length3;
                long size = ugVar.size();
                while (size > j2) {
                    int min = (int) Math.min(size, j);
                    m7634e(min, bArr3, 1);
                    for (int i11 = 0; i11 < length2; i11++) {
                        messageDigestArr[i11].update(bArr3);
                    }
                    long j5 = j4;
                    try {
                        ugVar.mo14316a(messageDigestArr, j5, min);
                        int i12 = 0;
                        while (i12 < iArr2.length) {
                            int i13 = iArr2[i12];
                            byte[] bArr4 = bArr3;
                            byte[] bArr5 = bArr[i12];
                            int k = m7640k(i13);
                            int i14 = length2;
                            MessageDigest messageDigest = messageDigestArr[i12];
                            MessageDigest[] messageDigestArr2 = messageDigestArr;
                            int i15 = i9;
                            C2475ug ugVar2 = ugVar;
                            int digest = messageDigest.digest(bArr5, (i15 * k) + 5, k);
                            if (digest == k) {
                                i12++;
                                i9 = i15;
                                bArr3 = bArr4;
                                length2 = i14;
                                messageDigestArr = messageDigestArr2;
                                ugVar = ugVar2;
                            } else {
                                String algorithm = messageDigest.getAlgorithm();
                                StringBuilder sb = new StringBuilder(String.valueOf(algorithm).length() + 46);
                                sb.append("Unexpected output size of ");
                                sb.append(algorithm);
                                sb.append(" digest: ");
                                sb.append(digest);
                                throw new RuntimeException(sb.toString());
                            }
                        }
                        int i16 = length2;
                        C2475ug ugVar3 = ugVar;
                        long j6 = (long) min;
                        long j7 = j5 + j6;
                        size -= j6;
                        i9++;
                        C2475ug[] ugVarArr3 = ugVarArr;
                        bArr3 = bArr3;
                        messageDigestArr = messageDigestArr;
                        j = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                        j4 = j7;
                        j2 = 0;
                    } catch (IOException e2) {
                        StringBuilder sb2 = new StringBuilder(59);
                        sb2.append("Failed to digest chunk #");
                        sb2.append(i9);
                        sb2.append(" of section #");
                        sb2.append(i);
                        throw new DigestException(sb2.toString(), e2);
                    }
                }
                byte[] bArr6 = bArr3;
                int i17 = length2;
                i++;
                i7++;
                ugVarArr2 = ugVarArr;
                i8 = i9;
                length3 = i10;
                messageDigestArr = messageDigestArr;
                j2 = 0;
                j = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            byte[][] bArr7 = new byte[iArr2.length][];
            int i18 = 0;
            while (i18 < iArr2.length) {
                int i19 = iArr2[i18];
                byte[] bArr8 = bArr[i18];
                String i20 = m7638i(i19);
                try {
                    bArr7[i18] = MessageDigest.getInstance(i20).digest(bArr8);
                    i18++;
                } catch (NoSuchAlgorithmException e3) {
                    throw new RuntimeException(String.valueOf(i20).concat(" digest not supported"), e3);
                }
            }
            return bArr7;
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("Too many chunks: ");
        sb3.append(j3);
        throw new DigestException(sb3.toString());
    }

    /* renamed from: h */
    private static X509Certificate[][] m7637h(FileChannel fileChannel, g40 g40) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer b = m7631b(g40.f8509a);
                int i = 0;
                int i2 = 0;
                while (b.hasRemaining()) {
                    i2++;
                    try {
                        arrayList.add(m7635f(m7631b(b), hashMap, instance));
                    } catch (IOException | SecurityException | BufferUnderflowException e) {
                        StringBuilder sb = new StringBuilder(48);
                        sb.append("Failed to parse/verify signer #");
                        sb.append(i2);
                        sb.append(" block");
                        throw new SecurityException(sb.toString(), e);
                    }
                }
                if (i2 <= 0) {
                    throw new SecurityException("No signers found");
                } else if (!hashMap.isEmpty()) {
                    long b2 = g40.f8510b;
                    long c = g40.f8511c;
                    long d = g40.f8512d;
                    ByteBuffer e2 = g40.f8513e;
                    if (!hashMap.isEmpty()) {
                        FileChannel fileChannel2 = fileChannel;
                        yc0 yc0 = new yc0(fileChannel2, 0, b2);
                        yc0 yc02 = new yc0(fileChannel2, c, d - c);
                        ByteBuffer duplicate = e2.duplicate();
                        duplicate.order(ByteOrder.LITTLE_ENDIAN);
                        zzi.zza(duplicate, b2);
                        C2075js jsVar = new C2075js(duplicate);
                        int size = hashMap.size();
                        int[] iArr = new int[size];
                        int i3 = 0;
                        for (Integer intValue : hashMap.keySet()) {
                            iArr[i3] = intValue.intValue();
                            i3++;
                        }
                        try {
                            byte[][] g = m7636g(iArr, new C2475ug[]{yc0, yc02, jsVar});
                            while (i < size) {
                                int i4 = iArr[i];
                                if (MessageDigest.isEqual((byte[]) hashMap.get(Integer.valueOf(i4)), g[i])) {
                                    i++;
                                } else {
                                    throw new SecurityException(String.valueOf(m7638i(i4)).concat(" digest of contents did not verify"));
                                }
                            }
                            return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]);
                        } catch (DigestException e3) {
                            throw new SecurityException("Failed to compute digest(s) of contents", e3);
                        }
                    } else {
                        throw new SecurityException("No digests provided");
                    }
                } else {
                    throw new SecurityException("No content digests found");
                }
            } catch (IOException e4) {
                throw new SecurityException("Failed to read list of signers", e4);
            }
        } catch (CertificateException e5) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e5);
        }
    }

    /* renamed from: i */
    private static String m7638i(int i) {
        if (i == 1) {
            return "SHA-256";
        }
        if (i == 2) {
            return "SHA-512";
        }
        StringBuilder sb = new StringBuilder(44);
        sb.append("Unknown content digest algorthm: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: j */
    private static byte[] m7639j(ByteBuffer byteBuffer) {
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IOException("Negative length");
        } else if (i <= byteBuffer.remaining()) {
            byte[] bArr = new byte[i];
            byteBuffer.get(bArr);
            return bArr;
        } else {
            int remaining = byteBuffer.remaining();
            StringBuilder sb = new StringBuilder(90);
            sb.append("Underflow while reading length-prefixed value. Length: ");
            sb.append(i);
            sb.append(", available: ");
            sb.append(remaining);
            throw new IOException(sb.toString());
        }
    }

    /* renamed from: k */
    private static int m7640k(int i) {
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 64;
        }
        StringBuilder sb = new StringBuilder(44);
        sb.append("Unknown content digest algorthm: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0039 A[Catch:{ all -> 0x028d }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0263 A[Catch:{ all -> 0x028d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.security.cert.X509Certificate[][] zza(java.lang.String r19) {
        /*
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile
            java.lang.String r0 = "r"
            r2 = r19
            r1.<init>(r2, r0)
            android.util.Pair r0 = com.google.android.gms.internal.ads.zzi.m8962a(r1)     // Catch:{ all -> 0x028d }
            if (r0 == 0) goto L_0x026b
            java.lang.Object r2 = r0.first     // Catch:{ all -> 0x028d }
            r11 = r2
            java.nio.ByteBuffer r11 = (java.nio.ByteBuffer) r11     // Catch:{ all -> 0x028d }
            java.lang.Object r0 = r0.second     // Catch:{ all -> 0x028d }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ all -> 0x028d }
            long r9 = r0.longValue()     // Catch:{ all -> 0x028d }
            r2 = 20
            long r2 = r9 - r2
            r0 = 1
            r4 = 0
            r6 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 < 0) goto L_0x0036
            r1.seek(r2)     // Catch:{ all -> 0x028d }
            int r2 = r1.readInt()     // Catch:{ all -> 0x028d }
            r3 = 1347094023(0x504b0607, float:1.36246794E10)
            if (r2 != r3) goto L_0x0036
            r2 = 1
            goto L_0x0037
        L_0x0036:
            r2 = 0
        L_0x0037:
            if (r2 != 0) goto L_0x0263
            long r7 = com.google.android.gms.internal.ads.zzi.zzc(r11)     // Catch:{ all -> 0x028d }
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 >= 0) goto L_0x0242
            long r2 = com.google.android.gms.internal.ads.zzi.zzd(r11)     // Catch:{ all -> 0x028d }
            long r2 = r2 + r7
            int r12 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r12 != 0) goto L_0x023a
            r2 = 32
            int r12 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r12 < 0) goto L_0x0221
            r2 = 24
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r2)     // Catch:{ all -> 0x028d }
            java.nio.ByteOrder r12 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ all -> 0x028d }
            r3.order(r12)     // Catch:{ all -> 0x028d }
            int r13 = r3.capacity()     // Catch:{ all -> 0x028d }
            long r13 = (long) r13     // Catch:{ all -> 0x028d }
            long r13 = r7 - r13
            r1.seek(r13)     // Catch:{ all -> 0x028d }
            byte[] r13 = r3.array()     // Catch:{ all -> 0x028d }
            int r14 = r3.arrayOffset()     // Catch:{ all -> 0x028d }
            int r15 = r3.capacity()     // Catch:{ all -> 0x028d }
            r1.readFully(r13, r14, r15)     // Catch:{ all -> 0x028d }
            r13 = 8
            long r14 = r3.getLong(r13)     // Catch:{ all -> 0x028d }
            r16 = 2334950737559900225(0x20676953204b5041, double:1.3968830566012645E-152)
            int r18 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r18 != 0) goto L_0x0219
            r14 = 16
            long r14 = r3.getLong(r14)     // Catch:{ all -> 0x028d }
            r16 = 3617552046287187010(0x3234206b636f6c42, double:7.465385175170059E-67)
            int r18 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r18 != 0) goto L_0x0219
            long r14 = r3.getLong(r6)     // Catch:{ all -> 0x028d }
            int r3 = r3.capacity()     // Catch:{ all -> 0x028d }
            long r2 = (long) r3     // Catch:{ all -> 0x028d }
            int r16 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r16 < 0) goto L_0x01ff
            r2 = 2147483639(0x7ffffff7, double:1.060997891E-314)
            int r16 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r16 > 0) goto L_0x01ff
            r2 = 8
            long r2 = r2 + r14
            int r3 = (int) r2     // Catch:{ all -> 0x028d }
            r16 = r14
            long r13 = (long) r3     // Catch:{ all -> 0x028d }
            long r13 = r7 - r13
            int r15 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r15 < 0) goto L_0x01e6
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r3)     // Catch:{ all -> 0x028d }
            r3.order(r12)     // Catch:{ all -> 0x028d }
            r1.seek(r13)     // Catch:{ all -> 0x028d }
            byte[] r4 = r3.array()     // Catch:{ all -> 0x028d }
            int r5 = r3.arrayOffset()     // Catch:{ all -> 0x028d }
            int r15 = r3.capacity()     // Catch:{ all -> 0x028d }
            r1.readFully(r4, r5, r15)     // Catch:{ all -> 0x028d }
            long r4 = r3.getLong(r6)     // Catch:{ all -> 0x028d }
            int r15 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r15 != 0) goto L_0x01c3
            java.lang.Long r4 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x028d }
            android.util.Pair r3 = android.util.Pair.create(r3, r4)     // Catch:{ all -> 0x028d }
            java.lang.Object r4 = r3.first     // Catch:{ all -> 0x028d }
            java.nio.ByteBuffer r4 = (java.nio.ByteBuffer) r4     // Catch:{ all -> 0x028d }
            java.lang.Object r3 = r3.second     // Catch:{ all -> 0x028d }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ all -> 0x028d }
            long r13 = r3.longValue()     // Catch:{ all -> 0x028d }
            java.nio.ByteOrder r3 = r4.order()     // Catch:{ all -> 0x028d }
            if (r3 != r12) goto L_0x01bb
            int r3 = r4.capacity()     // Catch:{ all -> 0x028d }
            r5 = 24
            int r3 = r3 - r5
            r2 = 8
            java.nio.ByteBuffer r3 = m7633d(r4, r2, r3)     // Catch:{ all -> 0x028d }
        L_0x00fb:
            boolean r4 = r3.hasRemaining()     // Catch:{ all -> 0x028d }
            if (r4 == 0) goto L_0x01b3
            int r6 = r6 + r0
            int r4 = r3.remaining()     // Catch:{ all -> 0x028d }
            if (r4 < r2) goto L_0x019a
            long r4 = r3.getLong()     // Catch:{ all -> 0x028d }
            r15 = 4
            java.lang.String r12 = " size out of range: "
            java.lang.String r0 = "APK Signing Block entry #"
            int r17 = (r4 > r15 ? 1 : (r4 == r15 ? 0 : -1))
            if (r17 < 0) goto L_0x017d
            r15 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r17 = (r4 > r15 ? 1 : (r4 == r15 ? 0 : -1))
            if (r17 > 0) goto L_0x017d
            int r5 = (int) r4
            int r4 = r3.position()     // Catch:{ all -> 0x028d }
            int r4 = r4 + r5
            int r15 = r3.remaining()     // Catch:{ all -> 0x028d }
            if (r5 > r15) goto L_0x0154
            int r0 = r3.getInt()     // Catch:{ all -> 0x028d }
            r12 = 1896449818(0x7109871a, float:6.810044E29)
            if (r0 != r12) goto L_0x014f
            int r5 = r5 + -4
            java.nio.ByteBuffer r4 = m7632c(r3, r5)     // Catch:{ all -> 0x028d }
            com.google.android.gms.internal.ads.g40 r0 = new com.google.android.gms.internal.ads.g40     // Catch:{ all -> 0x028d }
            r12 = 0
            r3 = r0
            r5 = r13
            r3.<init>(r4, r5, r7, r9, r11)     // Catch:{ all -> 0x028d }
            java.nio.channels.FileChannel r2 = r1.getChannel()     // Catch:{ all -> 0x028d }
            java.security.cert.X509Certificate[][] r0 = m7637h(r2, r0)     // Catch:{ all -> 0x028d }
            r1.close()     // Catch:{ all -> 0x028d }
            r1.close()     // Catch:{ IOException -> 0x014e }
        L_0x014e:
            return r0
        L_0x014f:
            r3.position(r4)     // Catch:{ all -> 0x028d }
            r0 = 1
            goto L_0x00fb
        L_0x0154:
            com.google.android.gms.internal.ads.zzh r2 = new com.google.android.gms.internal.ads.zzh     // Catch:{ all -> 0x028d }
            int r3 = r3.remaining()     // Catch:{ all -> 0x028d }
            r4 = 91
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x028d }
            r7.<init>(r4)     // Catch:{ all -> 0x028d }
            r7.append(r0)     // Catch:{ all -> 0x028d }
            r7.append(r6)     // Catch:{ all -> 0x028d }
            r7.append(r12)     // Catch:{ all -> 0x028d }
            r7.append(r5)     // Catch:{ all -> 0x028d }
            java.lang.String r0 = ", available: "
            r7.append(r0)     // Catch:{ all -> 0x028d }
            r7.append(r3)     // Catch:{ all -> 0x028d }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x028d }
            r2.<init>(r0)     // Catch:{ all -> 0x028d }
            throw r2     // Catch:{ all -> 0x028d }
        L_0x017d:
            com.google.android.gms.internal.ads.zzh r2 = new com.google.android.gms.internal.ads.zzh     // Catch:{ all -> 0x028d }
            r3 = 76
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x028d }
            r7.<init>(r3)     // Catch:{ all -> 0x028d }
            r7.append(r0)     // Catch:{ all -> 0x028d }
            r7.append(r6)     // Catch:{ all -> 0x028d }
            r7.append(r12)     // Catch:{ all -> 0x028d }
            r7.append(r4)     // Catch:{ all -> 0x028d }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x028d }
            r2.<init>(r0)     // Catch:{ all -> 0x028d }
            throw r2     // Catch:{ all -> 0x028d }
        L_0x019a:
            com.google.android.gms.internal.ads.zzh r0 = new com.google.android.gms.internal.ads.zzh     // Catch:{ all -> 0x028d }
            r2 = 70
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x028d }
            r3.<init>(r2)     // Catch:{ all -> 0x028d }
            java.lang.String r2 = "Insufficient data to read size of APK Signing Block entry #"
            r3.append(r2)     // Catch:{ all -> 0x028d }
            r3.append(r6)     // Catch:{ all -> 0x028d }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x028d }
            r0.<init>(r2)     // Catch:{ all -> 0x028d }
            throw r0     // Catch:{ all -> 0x028d }
        L_0x01b3:
            com.google.android.gms.internal.ads.zzh r0 = new com.google.android.gms.internal.ads.zzh     // Catch:{ all -> 0x028d }
            java.lang.String r2 = "No APK Signature Scheme v2 block in APK Signing Block"
            r0.<init>(r2)     // Catch:{ all -> 0x028d }
            throw r0     // Catch:{ all -> 0x028d }
        L_0x01bb:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x028d }
            java.lang.String r2 = "ByteBuffer byte order must be little endian"
            r0.<init>(r2)     // Catch:{ all -> 0x028d }
            throw r0     // Catch:{ all -> 0x028d }
        L_0x01c3:
            com.google.android.gms.internal.ads.zzh r0 = new com.google.android.gms.internal.ads.zzh     // Catch:{ all -> 0x028d }
            r2 = 103(0x67, float:1.44E-43)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x028d }
            r3.<init>(r2)     // Catch:{ all -> 0x028d }
            java.lang.String r2 = "APK Signing Block sizes in header and footer do not match: "
            r3.append(r2)     // Catch:{ all -> 0x028d }
            r3.append(r4)     // Catch:{ all -> 0x028d }
            java.lang.String r2 = " vs "
            r3.append(r2)     // Catch:{ all -> 0x028d }
            r4 = r16
            r3.append(r4)     // Catch:{ all -> 0x028d }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x028d }
            r0.<init>(r2)     // Catch:{ all -> 0x028d }
            throw r0     // Catch:{ all -> 0x028d }
        L_0x01e6:
            com.google.android.gms.internal.ads.zzh r0 = new com.google.android.gms.internal.ads.zzh     // Catch:{ all -> 0x028d }
            r2 = 59
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x028d }
            r3.<init>(r2)     // Catch:{ all -> 0x028d }
            java.lang.String r2 = "APK Signing Block offset out of range: "
            r3.append(r2)     // Catch:{ all -> 0x028d }
            r3.append(r13)     // Catch:{ all -> 0x028d }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x028d }
            r0.<init>(r2)     // Catch:{ all -> 0x028d }
            throw r0     // Catch:{ all -> 0x028d }
        L_0x01ff:
            r4 = r14
            com.google.android.gms.internal.ads.zzh r0 = new com.google.android.gms.internal.ads.zzh     // Catch:{ all -> 0x028d }
            r2 = 57
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x028d }
            r3.<init>(r2)     // Catch:{ all -> 0x028d }
            java.lang.String r2 = "APK Signing Block size out of range: "
            r3.append(r2)     // Catch:{ all -> 0x028d }
            r3.append(r4)     // Catch:{ all -> 0x028d }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x028d }
            r0.<init>(r2)     // Catch:{ all -> 0x028d }
            throw r0     // Catch:{ all -> 0x028d }
        L_0x0219:
            com.google.android.gms.internal.ads.zzh r0 = new com.google.android.gms.internal.ads.zzh     // Catch:{ all -> 0x028d }
            java.lang.String r2 = "No APK Signing Block before ZIP Central Directory"
            r0.<init>(r2)     // Catch:{ all -> 0x028d }
            throw r0     // Catch:{ all -> 0x028d }
        L_0x0221:
            com.google.android.gms.internal.ads.zzh r0 = new com.google.android.gms.internal.ads.zzh     // Catch:{ all -> 0x028d }
            r2 = 87
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x028d }
            r3.<init>(r2)     // Catch:{ all -> 0x028d }
            java.lang.String r2 = "APK too small for APK Signing Block. ZIP Central Directory offset: "
            r3.append(r2)     // Catch:{ all -> 0x028d }
            r3.append(r7)     // Catch:{ all -> 0x028d }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x028d }
            r0.<init>(r2)     // Catch:{ all -> 0x028d }
            throw r0     // Catch:{ all -> 0x028d }
        L_0x023a:
            com.google.android.gms.internal.ads.zzh r0 = new com.google.android.gms.internal.ads.zzh     // Catch:{ all -> 0x028d }
            java.lang.String r2 = "ZIP Central Directory is not immediately followed by End of Central Directory"
            r0.<init>(r2)     // Catch:{ all -> 0x028d }
            throw r0     // Catch:{ all -> 0x028d }
        L_0x0242:
            com.google.android.gms.internal.ads.zzh r0 = new com.google.android.gms.internal.ads.zzh     // Catch:{ all -> 0x028d }
            r2 = 122(0x7a, float:1.71E-43)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x028d }
            r3.<init>(r2)     // Catch:{ all -> 0x028d }
            java.lang.String r2 = "ZIP Central Directory offset out of range: "
            r3.append(r2)     // Catch:{ all -> 0x028d }
            r3.append(r7)     // Catch:{ all -> 0x028d }
            java.lang.String r2 = ". ZIP End of Central Directory offset: "
            r3.append(r2)     // Catch:{ all -> 0x028d }
            r3.append(r9)     // Catch:{ all -> 0x028d }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x028d }
            r0.<init>(r2)     // Catch:{ all -> 0x028d }
            throw r0     // Catch:{ all -> 0x028d }
        L_0x0263:
            com.google.android.gms.internal.ads.zzh r0 = new com.google.android.gms.internal.ads.zzh     // Catch:{ all -> 0x028d }
            java.lang.String r2 = "ZIP64 APK not supported"
            r0.<init>(r2)     // Catch:{ all -> 0x028d }
            throw r0     // Catch:{ all -> 0x028d }
        L_0x026b:
            com.google.android.gms.internal.ads.zzh r0 = new com.google.android.gms.internal.ads.zzh     // Catch:{ all -> 0x028d }
            long r2 = r1.length()     // Catch:{ all -> 0x028d }
            r4 = 102(0x66, float:1.43E-43)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x028d }
            r5.<init>(r4)     // Catch:{ all -> 0x028d }
            java.lang.String r4 = "Not an APK file: ZIP End of Central Directory record not found in file with "
            r5.append(r4)     // Catch:{ all -> 0x028d }
            r5.append(r2)     // Catch:{ all -> 0x028d }
            java.lang.String r2 = " bytes"
            r5.append(r2)     // Catch:{ all -> 0x028d }
            java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x028d }
            r0.<init>(r2)     // Catch:{ all -> 0x028d }
            throw r0     // Catch:{ all -> 0x028d }
        L_0x028d:
            r0 = move-exception
            r1.close()     // Catch:{ IOException -> 0x0291 }
        L_0x0291:
            goto L_0x0293
        L_0x0292:
            throw r0
        L_0x0293:
            goto L_0x0292
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzb.zza(java.lang.String):java.security.cert.X509Certificate[][]");
    }
}
