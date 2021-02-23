package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

public class StandardGifDecoder implements GifDecoder {

    /* renamed from: v */
    private static final String f5567v = "StandardGifDecoder";
    @ColorInt

    /* renamed from: a */
    private int[] f5568a;
    @ColorInt

    /* renamed from: b */
    private final int[] f5569b;

    /* renamed from: c */
    private final GifDecoder.BitmapProvider f5570c;

    /* renamed from: d */
    private ByteBuffer f5571d;

    /* renamed from: e */
    private byte[] f5572e;

    /* renamed from: f */
    private GifHeaderParser f5573f;

    /* renamed from: g */
    private short[] f5574g;

    /* renamed from: h */
    private byte[] f5575h;

    /* renamed from: i */
    private byte[] f5576i;

    /* renamed from: j */
    private byte[] f5577j;
    @ColorInt

    /* renamed from: k */
    private int[] f5578k;

    /* renamed from: l */
    private int f5579l;

    /* renamed from: m */
    private GifHeader f5580m;

    /* renamed from: n */
    private Bitmap f5581n;

    /* renamed from: o */
    private boolean f5582o;

    /* renamed from: p */
    private int f5583p;

    /* renamed from: q */
    private int f5584q;

    /* renamed from: r */
    private int f5585r;

    /* renamed from: s */
    private int f5586s;
    @Nullable

    /* renamed from: t */
    private Boolean f5587t;
    @NonNull

    /* renamed from: u */
    private Bitmap.Config f5588u;

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer) {
        this(bitmapProvider, gifHeader, byteBuffer, 1);
    }

    @ColorInt
    /* renamed from: a */
    private int m4177a(int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = i; i9 < this.f5584q + i; i9++) {
            byte[] bArr = this.f5577j;
            if (i9 >= bArr.length || i9 >= i2) {
                break;
            }
            int i10 = this.f5568a[bArr[i9] & 255];
            if (i10 != 0) {
                i4 += (i10 >> 24) & 255;
                i5 += (i10 >> 16) & 255;
                i6 += (i10 >> 8) & 255;
                i7 += i10 & 255;
                i8++;
            }
        }
        int i11 = i + i3;
        for (int i12 = i11; i12 < this.f5584q + i11; i12++) {
            byte[] bArr2 = this.f5577j;
            if (i12 >= bArr2.length || i12 >= i2) {
                break;
            }
            int i13 = this.f5568a[bArr2[i12] & 255];
            if (i13 != 0) {
                i4 += (i13 >> 24) & 255;
                i5 += (i13 >> 16) & 255;
                i6 += (i13 >> 8) & 255;
                i7 += i13 & 255;
                i8++;
            }
        }
        if (i8 == 0) {
            return 0;
        }
        return ((i4 / i8) << 24) | ((i5 / i8) << 16) | ((i6 / i8) << 8) | (i7 / i8);
    }

    /* renamed from: b */
    private void m4178b(C1169a aVar) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        C1169a aVar2 = aVar;
        Boolean bool = Boolean.TRUE;
        int[] iArr = this.f5578k;
        int i5 = aVar2.f5592d;
        int i6 = this.f5584q;
        int i7 = i5 / i6;
        int i8 = aVar2.f5590b / i6;
        int i9 = aVar2.f5591c / i6;
        int i10 = aVar2.f5589a / i6;
        boolean z2 = this.f5579l == 0;
        int i11 = this.f5586s;
        int i12 = this.f5585r;
        byte[] bArr = this.f5577j;
        int[] iArr2 = this.f5568a;
        Boolean bool2 = this.f5587t;
        int i13 = 8;
        Boolean bool3 = bool;
        int i14 = 0;
        int i15 = 0;
        int i16 = 1;
        while (i15 < i7) {
            Boolean bool4 = bool2;
            if (aVar2.f5593e) {
                if (i14 >= i7) {
                    int i17 = i14;
                    int i18 = i16 + 1;
                    if (i18 == 2) {
                        i16 = i18;
                        i14 = 4;
                    } else if (i18 == 3) {
                        i16 = i18;
                        i14 = 2;
                        i13 = 4;
                    } else if (i18 != 4) {
                        i16 = i18;
                        i14 = i17;
                    } else {
                        i16 = i18;
                        i14 = 1;
                        i13 = 2;
                    }
                } else {
                    int i19 = i14;
                }
                i = i14 + i13;
            } else {
                i = i14;
                i14 = i15;
            }
            int i20 = i14 + i8;
            boolean z3 = i6 == 1;
            if (i20 < i12) {
                int i21 = i20 * i11;
                int i22 = i21 + i10;
                int i23 = i22 + i9;
                int i24 = i21 + i11;
                if (i24 < i23) {
                    i23 = i24;
                }
                i2 = i7;
                int i25 = i15 * i6 * aVar2.f5591c;
                if (z3) {
                    int i26 = i22;
                    while (i26 < i23) {
                        int i27 = i8;
                        int i28 = iArr2[bArr[i25] & 255];
                        if (i28 != 0) {
                            iArr[i26] = i28;
                        } else if (z2 && bool4 == null) {
                            bool4 = bool3;
                        }
                        i25 += i6;
                        i26++;
                        i8 = i27;
                    }
                } else {
                    i4 = i8;
                    int i29 = ((i23 - i22) * i6) + i25;
                    int i30 = i22;
                    while (true) {
                        i3 = i9;
                        if (i30 >= i23) {
                            break;
                        }
                        int a = m4177a(i25, i29, aVar2.f5591c);
                        if (a != 0) {
                            iArr[i30] = a;
                        } else if (z2 && bool4 == null) {
                            bool4 = bool3;
                        }
                        i25 += i6;
                        i30++;
                        i9 = i3;
                    }
                    bool2 = bool4;
                    i15++;
                    i8 = i4;
                    i9 = i3;
                    i14 = i;
                    i7 = i2;
                }
            } else {
                i2 = i7;
            }
            i4 = i8;
            i3 = i9;
            bool2 = bool4;
            i15++;
            i8 = i4;
            i9 = i3;
            i14 = i;
            i7 = i2;
        }
        Boolean bool5 = bool2;
        if (this.f5587t == null) {
            if (bool5 == null) {
                z = false;
            } else {
                z = bool5.booleanValue();
            }
            this.f5587t = Boolean.valueOf(z);
        }
    }

    /* renamed from: c */
    private void m4179c(C1169a aVar) {
        C1169a aVar2 = aVar;
        int[] iArr = this.f5578k;
        int i = aVar2.f5592d;
        int i2 = aVar2.f5590b;
        int i3 = aVar2.f5591c;
        int i4 = aVar2.f5589a;
        boolean z = this.f5579l == 0;
        int i5 = this.f5586s;
        byte[] bArr = this.f5577j;
        int[] iArr2 = this.f5568a;
        int i6 = 0;
        byte b = -1;
        while (i6 < i) {
            int i7 = (i6 + i2) * i5;
            int i8 = i7 + i4;
            int i9 = i8 + i3;
            int i10 = i7 + i5;
            if (i10 < i9) {
                i9 = i10;
            }
            int i11 = aVar2.f5591c * i6;
            int i12 = i8;
            while (i12 < i9) {
                byte b2 = bArr[i11];
                int i13 = i;
                byte b3 = b2 & 255;
                if (b3 != b) {
                    int i14 = iArr2[b3];
                    if (i14 != 0) {
                        iArr[i12] = i14;
                    } else {
                        b = b2;
                    }
                }
                i11++;
                i12++;
                C1169a aVar3 = aVar;
                i = i13;
            }
            int i15 = i;
            i6++;
            aVar2 = aVar;
        }
        Boolean bool = this.f5587t;
        this.f5587t = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.f5587t == null && z && b != -1));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: byte} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short, code=int, for r7v13, types: [short] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4180d(com.bumptech.glide.gifdecoder.C1169a r29) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            if (r1 == 0) goto L_0x000d
            java.nio.ByteBuffer r2 = r0.f5571d
            int r3 = r1.f5598j
            r2.position(r3)
        L_0x000d:
            if (r1 != 0) goto L_0x0016
            com.bumptech.glide.gifdecoder.GifHeader r1 = r0.f5580m
            int r2 = r1.f5555f
            int r1 = r1.f5556g
            goto L_0x001a
        L_0x0016:
            int r2 = r1.f5591c
            int r1 = r1.f5592d
        L_0x001a:
            int r2 = r2 * r1
            byte[] r1 = r0.f5577j
            if (r1 == 0) goto L_0x0023
            int r1 = r1.length
            if (r1 >= r2) goto L_0x002b
        L_0x0023:
            com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider r1 = r0.f5570c
            byte[] r1 = r1.obtainByteArray(r2)
            r0.f5577j = r1
        L_0x002b:
            byte[] r1 = r0.f5577j
            short[] r3 = r0.f5574g
            r4 = 4096(0x1000, float:5.74E-42)
            if (r3 != 0) goto L_0x0037
            short[] r3 = new short[r4]
            r0.f5574g = r3
        L_0x0037:
            short[] r3 = r0.f5574g
            byte[] r5 = r0.f5575h
            if (r5 != 0) goto L_0x0041
            byte[] r5 = new byte[r4]
            r0.f5575h = r5
        L_0x0041:
            byte[] r5 = r0.f5575h
            byte[] r6 = r0.f5576i
            if (r6 != 0) goto L_0x004d
            r6 = 4097(0x1001, float:5.741E-42)
            byte[] r6 = new byte[r6]
            r0.f5576i = r6
        L_0x004d:
            byte[] r6 = r0.f5576i
            int r7 = r28.m4184h()
            r8 = 1
            int r9 = r8 << r7
            int r10 = r9 + 1
            int r11 = r9 + 2
            int r7 = r7 + r8
            int r12 = r8 << r7
            int r12 = r12 - r8
            r13 = 0
            r14 = 0
        L_0x0060:
            if (r14 >= r9) goto L_0x006a
            r3[r14] = r13
            byte r15 = (byte) r14
            r5[r14] = r15
            int r14 = r14 + 1
            goto L_0x0060
        L_0x006a:
            byte[] r14 = r0.f5572e
            r15 = -1
            r23 = r7
            r21 = r11
            r22 = r12
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r24 = -1
            r25 = 0
            r26 = 0
        L_0x0083:
            if (r13 >= r2) goto L_0x014c
            if (r16 != 0) goto L_0x0094
            int r16 = r28.m4183g()
            if (r16 > 0) goto L_0x0092
            r3 = 3
            r0.f5583p = r3
            goto L_0x014c
        L_0x0092:
            r17 = 0
        L_0x0094:
            byte r4 = r14[r17]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r18
            int r19 = r19 + r4
            int r18 = r18 + 8
            int r17 = r17 + 1
            int r16 = r16 + -1
            r4 = r18
            r8 = r21
            r15 = r23
            r0 = r24
            r23 = r7
            r7 = r25
        L_0x00ae:
            if (r4 < r15) goto L_0x0136
            r24 = r11
            r11 = r19 & r22
            int r19 = r19 >> r15
            int r4 = r4 - r15
            if (r11 != r9) goto L_0x00c2
            r22 = r12
            r15 = r23
            r8 = r24
            r11 = r8
            r0 = -1
            goto L_0x00ae
        L_0x00c2:
            if (r11 != r10) goto L_0x00d9
            r18 = r4
            r25 = r7
            r21 = r8
            r7 = r23
            r11 = r24
            r4 = 4096(0x1000, float:5.74E-42)
            r8 = 1
            r24 = r0
            r23 = r15
            r15 = -1
            r0 = r28
            goto L_0x0083
        L_0x00d9:
            r25 = r4
            r4 = -1
            if (r0 != r4) goto L_0x00ed
            byte r0 = r5[r11]
            r1[r20] = r0
            int r20 = r20 + 1
            int r13 = r13 + 1
            r0 = r11
            r7 = r0
            r11 = r24
            r4 = r25
            goto L_0x00ae
        L_0x00ed:
            if (r11 < r8) goto L_0x00f6
            byte r7 = (byte) r7
            r6[r26] = r7
            int r26 = r26 + 1
            r7 = r0
            goto L_0x00f7
        L_0x00f6:
            r7 = r11
        L_0x00f7:
            if (r7 < r9) goto L_0x0102
            byte r21 = r5[r7]
            r6[r26] = r21
            int r26 = r26 + 1
            short r7 = r3[r7]
            goto L_0x00f7
        L_0x0102:
            byte r7 = r5[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r7
            r1[r20] = r4
        L_0x0109:
            int r20 = r20 + 1
            int r13 = r13 + 1
            if (r26 <= 0) goto L_0x0116
            int r26 = r26 + -1
            byte r27 = r6[r26]
            r1[r20] = r27
            goto L_0x0109
        L_0x0116:
            r27 = r6
            r6 = 4096(0x1000, float:5.74E-42)
            if (r8 >= r6) goto L_0x012d
            short r0 = (short) r0
            r3[r8] = r0
            r5[r8] = r4
            int r8 = r8 + 1
            r0 = r8 & r22
            if (r0 != 0) goto L_0x012d
            if (r8 >= r6) goto L_0x012d
            int r15 = r15 + 1
            int r22 = r22 + r8
        L_0x012d:
            r0 = r11
            r11 = r24
            r4 = r25
            r6 = r27
            goto L_0x00ae
        L_0x0136:
            r25 = r4
            r24 = r0
            r21 = r8
            r18 = r25
            r4 = 4096(0x1000, float:5.74E-42)
            r8 = 1
            r0 = r28
            r25 = r7
            r7 = r23
            r23 = r15
            r15 = -1
            goto L_0x0083
        L_0x014c:
            r13 = r20
            r0 = 0
            java.util.Arrays.fill(r1, r13, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.StandardGifDecoder.m4180d(com.bumptech.glide.gifdecoder.a):void");
    }

    @NonNull
    /* renamed from: e */
    private GifHeaderParser m4181e() {
        if (this.f5573f == null) {
            this.f5573f = new GifHeaderParser();
        }
        return this.f5573f;
    }

    /* renamed from: f */
    private Bitmap m4182f() {
        Boolean bool = this.f5587t;
        Bitmap obtain = this.f5570c.obtain(this.f5586s, this.f5585r, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.f5588u);
        obtain.setHasAlpha(true);
        return obtain;
    }

    /* renamed from: g */
    private int m4183g() {
        int h = m4184h();
        if (h <= 0) {
            return h;
        }
        ByteBuffer byteBuffer = this.f5571d;
        byteBuffer.get(this.f5572e, 0, Math.min(h, byteBuffer.remaining()));
        return h;
    }

    /* renamed from: h */
    private int m4184h() {
        return this.f5571d.get() & 255;
    }

    /* renamed from: i */
    private Bitmap m4185i(C1169a aVar, C1169a aVar2) {
        int i;
        int i2;
        Bitmap bitmap;
        int[] iArr = this.f5578k;
        int i3 = 0;
        if (aVar2 == null) {
            Bitmap bitmap2 = this.f5581n;
            if (bitmap2 != null) {
                this.f5570c.release(bitmap2);
            }
            this.f5581n = null;
            Arrays.fill(iArr, 0);
        }
        if (aVar2 != null && aVar2.f5595g == 3 && this.f5581n == null) {
            Arrays.fill(iArr, 0);
        }
        if (aVar2 != null && (i2 = aVar2.f5595g) > 0) {
            if (i2 == 2) {
                if (!aVar.f5594f) {
                    GifHeader gifHeader = this.f5580m;
                    int i4 = gifHeader.f5561l;
                    if (aVar.f5599k == null || gifHeader.f5559j != aVar.f5596h) {
                        i3 = i4;
                    }
                }
                int i5 = aVar2.f5592d;
                int i6 = this.f5584q;
                int i7 = i5 / i6;
                int i8 = aVar2.f5590b / i6;
                int i9 = aVar2.f5591c / i6;
                int i10 = aVar2.f5589a / i6;
                int i11 = this.f5586s;
                int i12 = (i8 * i11) + i10;
                int i13 = (i7 * i11) + i12;
                while (i12 < i13) {
                    int i14 = i12 + i9;
                    for (int i15 = i12; i15 < i14; i15++) {
                        iArr[i15] = i3;
                    }
                    i12 += this.f5586s;
                }
            } else if (i2 == 3 && (bitmap = this.f5581n) != null) {
                int i16 = this.f5586s;
                bitmap.getPixels(iArr, 0, i16, 0, 0, i16, this.f5585r);
            }
        }
        m4180d(aVar);
        if (aVar.f5593e || this.f5584q != 1) {
            m4178b(aVar);
        } else {
            m4179c(aVar);
        }
        if (this.f5582o && ((i = aVar.f5595g) == 0 || i == 1)) {
            if (this.f5581n == null) {
                this.f5581n = m4182f();
            }
            Bitmap bitmap3 = this.f5581n;
            int i17 = this.f5586s;
            bitmap3.setPixels(iArr, 0, i17, 0, 0, i17, this.f5585r);
        }
        Bitmap f = m4182f();
        int i18 = this.f5586s;
        f.setPixels(iArr, 0, i18, 0, 0, i18, this.f5585r);
        return f;
    }

    public void advance() {
        this.f5579l = (this.f5579l + 1) % this.f5580m.f5552c;
    }

    public void clear() {
        this.f5580m = null;
        byte[] bArr = this.f5577j;
        if (bArr != null) {
            this.f5570c.release(bArr);
        }
        int[] iArr = this.f5578k;
        if (iArr != null) {
            this.f5570c.release(iArr);
        }
        Bitmap bitmap = this.f5581n;
        if (bitmap != null) {
            this.f5570c.release(bitmap);
        }
        this.f5581n = null;
        this.f5571d = null;
        this.f5587t = null;
        byte[] bArr2 = this.f5572e;
        if (bArr2 != null) {
            this.f5570c.release(bArr2);
        }
    }

    public int getByteSize() {
        return this.f5571d.limit() + this.f5577j.length + (this.f5578k.length * 4);
    }

    public int getCurrentFrameIndex() {
        return this.f5579l;
    }

    @NonNull
    public ByteBuffer getData() {
        return this.f5571d;
    }

    public int getDelay(int i) {
        if (i >= 0) {
            GifHeader gifHeader = this.f5580m;
            if (i < gifHeader.f5552c) {
                return gifHeader.f5554e.get(i).f5597i;
            }
        }
        return -1;
    }

    public int getFrameCount() {
        return this.f5580m.f5552c;
    }

    public int getHeight() {
        return this.f5580m.f5556g;
    }

    @Deprecated
    public int getLoopCount() {
        int i = this.f5580m.f5562m;
        if (i == -1) {
            return 1;
        }
        return i;
    }

    public int getNetscapeLoopCount() {
        return this.f5580m.f5562m;
    }

    public int getNextDelay() {
        int i;
        if (this.f5580m.f5552c <= 0 || (i = this.f5579l) < 0) {
            return 0;
        }
        return getDelay(i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e3, code lost:
        return null;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.graphics.Bitmap getNextFrame() {
        /*
            r8 = this;
            monitor-enter(r8)
            com.bumptech.glide.gifdecoder.GifHeader r0 = r8.f5580m     // Catch:{ all -> 0x00e4 }
            int r0 = r0.f5552c     // Catch:{ all -> 0x00e4 }
            r1 = 3
            r2 = 1
            if (r0 <= 0) goto L_0x000d
            int r0 = r8.f5579l     // Catch:{ all -> 0x00e4 }
            if (r0 >= 0) goto L_0x0039
        L_0x000d:
            java.lang.String r0 = f5567v     // Catch:{ all -> 0x00e4 }
            boolean r3 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00e4 }
            if (r3 == 0) goto L_0x0037
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e4 }
            r3.<init>()     // Catch:{ all -> 0x00e4 }
            java.lang.String r4 = "Unable to decode frame, frameCount="
            r3.append(r4)     // Catch:{ all -> 0x00e4 }
            com.bumptech.glide.gifdecoder.GifHeader r4 = r8.f5580m     // Catch:{ all -> 0x00e4 }
            int r4 = r4.f5552c     // Catch:{ all -> 0x00e4 }
            r3.append(r4)     // Catch:{ all -> 0x00e4 }
            java.lang.String r4 = ", framePointer="
            r3.append(r4)     // Catch:{ all -> 0x00e4 }
            int r4 = r8.f5579l     // Catch:{ all -> 0x00e4 }
            r3.append(r4)     // Catch:{ all -> 0x00e4 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00e4 }
            android.util.Log.d(r0, r3)     // Catch:{ all -> 0x00e4 }
        L_0x0037:
            r8.f5583p = r2     // Catch:{ all -> 0x00e4 }
        L_0x0039:
            int r0 = r8.f5583p     // Catch:{ all -> 0x00e4 }
            r3 = 0
            if (r0 == r2) goto L_0x00c4
            r4 = 2
            if (r0 != r4) goto L_0x0043
            goto L_0x00c4
        L_0x0043:
            r0 = 0
            r8.f5583p = r0     // Catch:{ all -> 0x00e4 }
            byte[] r5 = r8.f5572e     // Catch:{ all -> 0x00e4 }
            if (r5 != 0) goto L_0x0054
            com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider r5 = r8.f5570c     // Catch:{ all -> 0x00e4 }
            r6 = 255(0xff, float:3.57E-43)
            byte[] r5 = r5.obtainByteArray(r6)     // Catch:{ all -> 0x00e4 }
            r8.f5572e = r5     // Catch:{ all -> 0x00e4 }
        L_0x0054:
            com.bumptech.glide.gifdecoder.GifHeader r5 = r8.f5580m     // Catch:{ all -> 0x00e4 }
            java.util.List<com.bumptech.glide.gifdecoder.a> r5 = r5.f5554e     // Catch:{ all -> 0x00e4 }
            int r6 = r8.f5579l     // Catch:{ all -> 0x00e4 }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ all -> 0x00e4 }
            com.bumptech.glide.gifdecoder.a r5 = (com.bumptech.glide.gifdecoder.C1169a) r5     // Catch:{ all -> 0x00e4 }
            int r6 = r8.f5579l     // Catch:{ all -> 0x00e4 }
            int r6 = r6 - r2
            if (r6 < 0) goto L_0x0070
            com.bumptech.glide.gifdecoder.GifHeader r7 = r8.f5580m     // Catch:{ all -> 0x00e4 }
            java.util.List<com.bumptech.glide.gifdecoder.a> r7 = r7.f5554e     // Catch:{ all -> 0x00e4 }
            java.lang.Object r6 = r7.get(r6)     // Catch:{ all -> 0x00e4 }
            com.bumptech.glide.gifdecoder.a r6 = (com.bumptech.glide.gifdecoder.C1169a) r6     // Catch:{ all -> 0x00e4 }
            goto L_0x0071
        L_0x0070:
            r6 = r3
        L_0x0071:
            int[] r7 = r5.f5599k     // Catch:{ all -> 0x00e4 }
            if (r7 == 0) goto L_0x0076
            goto L_0x007a
        L_0x0076:
            com.bumptech.glide.gifdecoder.GifHeader r7 = r8.f5580m     // Catch:{ all -> 0x00e4 }
            int[] r7 = r7.f5550a     // Catch:{ all -> 0x00e4 }
        L_0x007a:
            r8.f5568a = r7     // Catch:{ all -> 0x00e4 }
            if (r7 != 0) goto L_0x00a0
            java.lang.String r0 = f5567v     // Catch:{ all -> 0x00e4 }
            boolean r1 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00e4 }
            if (r1 == 0) goto L_0x009c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e4 }
            r1.<init>()     // Catch:{ all -> 0x00e4 }
            java.lang.String r4 = "No valid color table found for frame #"
            r1.append(r4)     // Catch:{ all -> 0x00e4 }
            int r4 = r8.f5579l     // Catch:{ all -> 0x00e4 }
            r1.append(r4)     // Catch:{ all -> 0x00e4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00e4 }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x00e4 }
        L_0x009c:
            r8.f5583p = r2     // Catch:{ all -> 0x00e4 }
            monitor-exit(r8)
            return r3
        L_0x00a0:
            boolean r1 = r5.f5594f     // Catch:{ all -> 0x00e4 }
            if (r1 == 0) goto L_0x00be
            int[] r1 = r8.f5569b     // Catch:{ all -> 0x00e4 }
            int r2 = r7.length     // Catch:{ all -> 0x00e4 }
            java.lang.System.arraycopy(r7, r0, r1, r0, r2)     // Catch:{ all -> 0x00e4 }
            int[] r1 = r8.f5569b     // Catch:{ all -> 0x00e4 }
            r8.f5568a = r1     // Catch:{ all -> 0x00e4 }
            int r2 = r5.f5596h     // Catch:{ all -> 0x00e4 }
            r1[r2] = r0     // Catch:{ all -> 0x00e4 }
            int r0 = r5.f5595g     // Catch:{ all -> 0x00e4 }
            if (r0 != r4) goto L_0x00be
            int r0 = r8.f5579l     // Catch:{ all -> 0x00e4 }
            if (r0 != 0) goto L_0x00be
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00e4 }
            r8.f5587t = r0     // Catch:{ all -> 0x00e4 }
        L_0x00be:
            android.graphics.Bitmap r0 = r8.m4185i(r5, r6)     // Catch:{ all -> 0x00e4 }
            monitor-exit(r8)
            return r0
        L_0x00c4:
            java.lang.String r0 = f5567v     // Catch:{ all -> 0x00e4 }
            boolean r1 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00e4 }
            if (r1 == 0) goto L_0x00e2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e4 }
            r1.<init>()     // Catch:{ all -> 0x00e4 }
            java.lang.String r2 = "Unable to decode frame, status="
            r1.append(r2)     // Catch:{ all -> 0x00e4 }
            int r2 = r8.f5583p     // Catch:{ all -> 0x00e4 }
            r1.append(r2)     // Catch:{ all -> 0x00e4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00e4 }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x00e4 }
        L_0x00e2:
            monitor-exit(r8)
            return r3
        L_0x00e4:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.StandardGifDecoder.getNextFrame():android.graphics.Bitmap");
    }

    public int getStatus() {
        return this.f5583p;
    }

    public int getTotalIterationCount() {
        int i = this.f5580m.f5562m;
        if (i == -1) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        return i + 1;
    }

    public int getWidth() {
        return this.f5580m.f5555f;
    }

    public int read(@Nullable InputStream inputStream, int i) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i > 0 ? i + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, 16384);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                Log.w(f5567v, "Error reading data from stream", e);
            }
        } else {
            this.f5583p = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                Log.w(f5567v, "Error closing stream", e2);
            }
        }
        return this.f5583p;
    }

    public void resetFrameIndex() {
        this.f5579l = -1;
    }

    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull byte[] bArr) {
        setData(gifHeader, ByteBuffer.wrap(bArr));
    }

    public void setDefaultBitmapConfig(@NonNull Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.f5588u = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
        this(bitmapProvider);
        setData(gifHeader, byteBuffer, i);
    }

    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer) {
        setData(gifHeader, byteBuffer, 1);
    }

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider) {
        this.f5569b = new int[256];
        this.f5588u = Bitmap.Config.ARGB_8888;
        this.f5570c = bitmapProvider;
        this.f5580m = new GifHeader();
    }

    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer, int i) {
        if (i > 0) {
            int highestOneBit = Integer.highestOneBit(i);
            this.f5583p = 0;
            this.f5580m = gifHeader;
            this.f5579l = -1;
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f5571d = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.f5571d.order(ByteOrder.LITTLE_ENDIAN);
            this.f5582o = false;
            Iterator<C1169a> it = gifHeader.f5554e.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().f5595g == 3) {
                        this.f5582o = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.f5584q = highestOneBit;
            int i2 = gifHeader.f5555f;
            this.f5586s = i2 / highestOneBit;
            int i3 = gifHeader.f5556g;
            this.f5585r = i3 / highestOneBit;
            this.f5577j = this.f5570c.obtainByteArray(i2 * i3);
            this.f5578k = this.f5570c.obtainIntArray(this.f5586s * this.f5585r);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
        }
    }

    public synchronized int read(@Nullable byte[] bArr) {
        GifHeader parseHeader = m4181e().setData(bArr).parseHeader();
        this.f5580m = parseHeader;
        if (bArr != null) {
            setData(parseHeader, bArr);
        }
        return this.f5583p;
    }
}
