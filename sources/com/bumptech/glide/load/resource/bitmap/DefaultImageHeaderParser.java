package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.Preconditions;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public final class DefaultImageHeaderParser implements ImageHeaderParser {

    /* renamed from: a */
    static final byte[] f6120a = "Exif\u0000\u0000".getBytes(Charset.forName(Key.STRING_CHARSET_NAME));

    /* renamed from: b */
    private static final int[] f6121b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* renamed from: com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$a */
    private static final class C1294a implements C1296c {

        /* renamed from: a */
        private final ByteBuffer f6122a;

        C1294a(ByteBuffer byteBuffer) {
            this.f6122a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        /* renamed from: a */
        public int mo9834a() {
            return ((mo9837d() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (mo9837d() & 255);
        }

        /* renamed from: b */
        public int mo9835b(byte[] bArr, int i) {
            int min = Math.min(i, this.f6122a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f6122a.get(bArr, 0, min);
            return min;
        }

        /* renamed from: c */
        public short mo9836c() {
            return (short) (mo9837d() & 255);
        }

        /* renamed from: d */
        public int mo9837d() {
            if (this.f6122a.remaining() < 1) {
                return -1;
            }
            return this.f6122a.get();
        }

        public long skip(long j) {
            int min = (int) Math.min((long) this.f6122a.remaining(), j);
            ByteBuffer byteBuffer = this.f6122a;
            byteBuffer.position(byteBuffer.position() + min);
            return (long) min;
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$b */
    private static final class C1295b {

        /* renamed from: a */
        private final ByteBuffer f6123a;

        C1295b(byte[] bArr, int i) {
            this.f6123a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        /* renamed from: c */
        private boolean m4511c(int i, int i2) {
            return this.f6123a.remaining() - i >= i2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public short mo9839a(int i) {
            if (m4511c(i, 2)) {
                return this.f6123a.getShort(i);
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo9840b(int i) {
            if (m4511c(i, 4)) {
                return this.f6123a.getInt(i);
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public int mo9841d() {
            return this.f6123a.remaining();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo9842e(ByteOrder byteOrder) {
            this.f6123a.order(byteOrder);
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$c */
    private interface C1296c {
        /* renamed from: a */
        int mo9834a();

        /* renamed from: b */
        int mo9835b(byte[] bArr, int i);

        /* renamed from: c */
        short mo9836c();

        /* renamed from: d */
        int mo9837d();

        long skip(long j);
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$d */
    private static final class C1297d implements C1296c {

        /* renamed from: a */
        private final InputStream f6124a;

        C1297d(InputStream inputStream) {
            this.f6124a = inputStream;
        }

        /* renamed from: a */
        public int mo9834a() {
            return ((this.f6124a.read() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (this.f6124a.read() & 255);
        }

        /* renamed from: b */
        public int mo9835b(byte[] bArr, int i) {
            int i2 = i;
            while (i2 > 0) {
                int read = this.f6124a.read(bArr, i - i2, i2);
                if (read == -1) {
                    break;
                }
                i2 -= read;
            }
            return i - i2;
        }

        /* renamed from: c */
        public short mo9836c() {
            return (short) (this.f6124a.read() & 255);
        }

        /* renamed from: d */
        public int mo9837d() {
            return this.f6124a.read();
        }

        public long skip(long j) {
            if (j < 0) {
                return 0;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.f6124a.skip(j2);
                if (skip <= 0) {
                    if (this.f6124a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }
    }

    /* renamed from: a */
    private static int m4499a(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    /* renamed from: b */
    private int m4500b(C1296c cVar, ArrayPool arrayPool) {
        int a = cVar.mo9834a();
        if (!m4502d(a)) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + a);
            }
            return -1;
        }
        int f = m4504f(cVar);
        if (f == -1) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
            }
            return -1;
        }
        byte[] bArr = (byte[]) arrayPool.get(f, byte[].class);
        try {
            return m4506h(cVar, bArr, f);
        } finally {
            arrayPool.put(bArr);
        }
    }

    @NonNull
    /* renamed from: c */
    private ImageHeaderParser.ImageType m4501c(C1296c cVar) {
        int a = cVar.mo9834a();
        if (a == 65496) {
            return ImageHeaderParser.ImageType.JPEG;
        }
        int a2 = ((a << 16) & SupportMenu.CATEGORY_MASK) | (cVar.mo9834a() & SupportMenu.USER_MASK);
        if (a2 == -1991225785) {
            cVar.skip(21);
            return cVar.mo9837d() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
        } else if ((a2 >> 8) == 4671814) {
            return ImageHeaderParser.ImageType.GIF;
        } else {
            if (a2 != 1380533830) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            cVar.skip(4);
            if ((((cVar.mo9834a() << 16) & SupportMenu.CATEGORY_MASK) | (cVar.mo9834a() & SupportMenu.USER_MASK)) != 1464156752) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int a3 = ((cVar.mo9834a() << 16) & SupportMenu.CATEGORY_MASK) | (cVar.mo9834a() & SupportMenu.USER_MASK);
            if ((a3 & InputDeviceCompat.SOURCE_ANY) != 1448097792) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i = a3 & 255;
            if (i == 88) {
                cVar.skip(4);
                return (cVar.mo9837d() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            } else if (i != 76) {
                return ImageHeaderParser.ImageType.WEBP;
            } else {
                cVar.skip(4);
                return (cVar.mo9837d() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            }
        }
    }

    /* renamed from: d */
    private static boolean m4502d(int i) {
        return (i & 65496) == 65496 || i == 19789 || i == 18761;
    }

    /* renamed from: e */
    private boolean m4503e(byte[] bArr, int i) {
        boolean z = bArr != null && i > f6120a.length;
        if (z) {
            int i2 = 0;
            while (true) {
                byte[] bArr2 = f6120a;
                if (i2 >= bArr2.length) {
                    break;
                } else if (bArr[i2] != bArr2[i2]) {
                    return false;
                } else {
                    i2++;
                }
            }
        }
        return z;
    }

    /* renamed from: f */
    private int m4504f(C1296c cVar) {
        short c;
        int a;
        long j;
        long skip;
        do {
            short c2 = cVar.mo9836c();
            if (c2 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + c2);
                }
                return -1;
            }
            c = cVar.mo9836c();
            if (c == 218) {
                return -1;
            }
            if (c == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            a = cVar.mo9834a() - 2;
            if (c == 225) {
                return a;
            }
            j = (long) a;
            skip = cVar.skip(j);
        } while (skip == j);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + c + ", wanted to skip: " + a + ", but actually skipped: " + skip);
        }
        return -1;
    }

    /* renamed from: g */
    private static int m4505g(C1295b bVar) {
        ByteOrder byteOrder;
        short a = bVar.mo9839a(6);
        if (a == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else if (a != 19789) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unknown endianness = " + a);
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        bVar.mo9842e(byteOrder);
        int b = bVar.mo9840b(10) + 6;
        short a2 = bVar.mo9839a(b);
        for (int i = 0; i < a2; i++) {
            int a3 = m4499a(b, i);
            short a4 = bVar.mo9839a(a3);
            if (a4 == 274) {
                short a5 = bVar.mo9839a(a3 + 2);
                if (a5 >= 1 && a5 <= 12) {
                    int b2 = bVar.mo9840b(a3 + 4);
                    if (b2 >= 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got tagIndex=" + i + " tagType=" + a4 + " formatCode=" + a5 + " componentCount=" + b2);
                        }
                        int i2 = b2 + f6121b[a5];
                        if (i2 <= 4) {
                            int i3 = a3 + 8;
                            if (i3 < 0 || i3 > bVar.mo9841d()) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i3 + " tagType=" + a4);
                                }
                            } else if (i2 >= 0 && i2 + i3 <= bVar.mo9841d()) {
                                return bVar.mo9839a(i3);
                            } else {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + a4);
                                }
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + a5);
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Negative tiff component count");
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Got invalid format code = " + a5);
                }
            }
        }
        return -1;
    }

    /* renamed from: h */
    private int m4506h(C1296c cVar, byte[] bArr, int i) {
        int b = cVar.mo9835b(bArr, i);
        if (b != i) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i + ", actually read: " + b);
            }
            return -1;
        } else if (m4503e(bArr, i)) {
            return m4505g(new C1295b(bArr, i));
        } else {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
            }
            return -1;
        }
    }

    public int getOrientation(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) {
        return m4500b(new C1297d((InputStream) Preconditions.checkNotNull(inputStream)), (ArrayPool) Preconditions.checkNotNull(arrayPool));
    }

    @NonNull
    public ImageHeaderParser.ImageType getType(@NonNull InputStream inputStream) {
        return m4501c(new C1297d((InputStream) Preconditions.checkNotNull(inputStream)));
    }

    @NonNull
    public ImageHeaderParser.ImageType getType(@NonNull ByteBuffer byteBuffer) {
        return m4501c(new C1294a((ByteBuffer) Preconditions.checkNotNull(byteBuffer)));
    }

    public int getOrientation(@NonNull ByteBuffer byteBuffer, @NonNull ArrayPool arrayPool) {
        return m4500b(new C1294a((ByteBuffer) Preconditions.checkNotNull(byteBuffer)), (ArrayPool) Preconditions.checkNotNull(arrayPool));
    }
}
