package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class Downsampler {
    public static final Option<Boolean> ALLOW_HARDWARE_CONFIG;
    public static final Option<DecodeFormat> DECODE_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
    @Deprecated
    public static final Option<DownsampleStrategy> DOWNSAMPLE_STRATEGY = DownsampleStrategy.OPTION;
    public static final Option<Boolean> FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS;
    public static final Option<PreferredColorSpace> PREFERRED_COLOR_SPACE = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", PreferredColorSpace.SRGB);

    /* renamed from: f */
    private static final Set<String> f6127f = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"image/vnd.wap.wbmp", "image/x-ico"})));

    /* renamed from: g */
    private static final DecodeCallbacks f6128g = new C1304a();

    /* renamed from: h */
    private static final Set<ImageHeaderParser.ImageType> f6129h = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));

    /* renamed from: i */
    private static final Queue<BitmapFactory.Options> f6130i = Util.createQueue(0);

    /* renamed from: a */
    private final BitmapPool f6131a;

    /* renamed from: b */
    private final DisplayMetrics f6132b;

    /* renamed from: c */
    private final ArrayPool f6133c;

    /* renamed from: d */
    private final List<ImageHeaderParser> f6134d;

    /* renamed from: e */
    private final HardwareConfigState f6135e = HardwareConfigState.getInstance();

    public interface DecodeCallbacks {
        void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap);

        void onObtainBounds();
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.Downsampler$a */
    class C1304a implements DecodeCallbacks {
        C1304a() {
        }

        public void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) {
        }

        public void onObtainBounds() {
        }
    }

    static {
        Boolean bool = Boolean.FALSE;
        FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        ALLOW_HARDWARE_CONFIG = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
    }

    public Downsampler(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.f6134d = list;
        this.f6132b = (DisplayMetrics) Preconditions.checkNotNull(displayMetrics);
        this.f6131a = (BitmapPool) Preconditions.checkNotNull(bitmapPool);
        this.f6133c = (ArrayPool) Preconditions.checkNotNull(arrayPool);
    }

    /* renamed from: a */
    private static int m4524a(double d) {
        int h = m4531h(d);
        double d2 = (double) h;
        Double.isNaN(d2);
        int q = m4540q(d2 * d);
        double d3 = (double) (((float) q) / ((float) h));
        Double.isNaN(d3);
        double d4 = (double) q;
        Double.isNaN(d4);
        return m4540q((d / d3) * d4);
    }

    /* renamed from: b */
    private void m4525b(InputStream inputStream, DecodeFormat decodeFormat, boolean z, boolean z2, BitmapFactory.Options options, int i, int i2) {
        if (!this.f6135e.mo9852c(i, i2, options, z, z2)) {
            if (decodeFormat == DecodeFormat.PREFER_ARGB_8888 || Build.VERSION.SDK_INT == 16) {
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                return;
            }
            boolean z3 = false;
            try {
                z3 = ImageHeaderParserUtils.getType(this.f6134d, inputStream, this.f6133c).hasAlpha();
            } catch (IOException e) {
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e);
                }
            }
            Bitmap.Config config = z3 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            options.inPreferredConfig = config;
            if (config == Bitmap.Config.RGB_565) {
                options.inDither = true;
            }
        }
    }

    /* renamed from: c */
    private static void m4526c(ImageHeaderParser.ImageType imageType, InputStream inputStream, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool, DownsampleStrategy downsampleStrategy, int i, int i2, int i3, int i4, int i5, BitmapFactory.Options options) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        double d;
        ImageHeaderParser.ImageType imageType2 = imageType;
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        int i12 = i2;
        int i13 = i3;
        int i14 = i4;
        int i15 = i5;
        BitmapFactory.Options options2 = options;
        if (i12 <= 0 || i13 <= 0) {
            String str = "Downsampler";
            String str2 = "x";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Unable to determine dimensions for: " + imageType2 + " with target [" + i14 + str2 + i15 + "]");
                return;
            }
            return;
        }
        if (m4534k(i)) {
            i6 = i12;
            i7 = i13;
        } else {
            i7 = i12;
            i6 = i13;
        }
        float scaleFactor = downsampleStrategy2.getScaleFactor(i7, i6, i14, i15);
        if (scaleFactor > 0.0f) {
            DownsampleStrategy.SampleSizeRounding sampleSizeRounding = downsampleStrategy2.getSampleSizeRounding(i7, i6, i14, i15);
            if (sampleSizeRounding != null) {
                float f = (float) i7;
                float f2 = (float) i6;
                int q = i7 / m4540q((double) (scaleFactor * f));
                int q2 = i6 / m4540q((double) (scaleFactor * f2));
                DownsampleStrategy.SampleSizeRounding sampleSizeRounding2 = DownsampleStrategy.SampleSizeRounding.MEMORY;
                if (sampleSizeRounding == sampleSizeRounding2) {
                    i8 = Math.max(q, q2);
                } else {
                    i8 = Math.min(q, q2);
                }
                int i16 = Build.VERSION.SDK_INT;
                String str3 = "x";
                String str4 = "Downsampler";
                if (i16 > 23 || !f6127f.contains(options2.outMimeType)) {
                    int max = Math.max(1, Integer.highestOneBit(i8));
                    if (sampleSizeRounding == sampleSizeRounding2 && ((float) max) < 1.0f / scaleFactor) {
                        max <<= 1;
                    }
                    i9 = max;
                } else {
                    i9 = 1;
                }
                options2.inSampleSize = i9;
                if (imageType2 == ImageHeaderParser.ImageType.JPEG) {
                    float min = (float) Math.min(i9, 8);
                    i10 = (int) Math.ceil((double) (f / min));
                    i11 = (int) Math.ceil((double) (f2 / min));
                    int i17 = i9 / 8;
                    if (i17 > 0) {
                        i10 /= i17;
                        i11 /= i17;
                    }
                } else {
                    if (imageType2 == ImageHeaderParser.ImageType.PNG || imageType2 == ImageHeaderParser.ImageType.PNG_A) {
                        float f3 = (float) i9;
                        i10 = (int) Math.floor((double) (f / f3));
                        d = Math.floor((double) (f2 / f3));
                    } else if (imageType2 == ImageHeaderParser.ImageType.WEBP || imageType2 == ImageHeaderParser.ImageType.WEBP_A) {
                        if (i16 >= 24) {
                            float f4 = (float) i9;
                            i10 = Math.round(f / f4);
                            i11 = Math.round(f2 / f4);
                        } else {
                            float f5 = (float) i9;
                            i10 = (int) Math.floor((double) (f / f5));
                            d = Math.floor((double) (f2 / f5));
                        }
                    } else if (i7 % i9 == 0 && i6 % i9 == 0) {
                        i10 = i7 / i9;
                        i11 = i6 / i9;
                    } else {
                        int[] i18 = m4532i(inputStream, options2, decodeCallbacks, bitmapPool);
                        i10 = i18[0];
                        i11 = i18[1];
                    }
                    i11 = (int) d;
                }
                double scaleFactor2 = (double) downsampleStrategy2.getScaleFactor(i10, i11, i14, i15);
                if (i16 >= 19) {
                    options2.inTargetDensity = m4524a(scaleFactor2);
                    options2.inDensity = m4531h(scaleFactor2);
                }
                if (m4535l(options)) {
                    options2.inScaled = true;
                } else {
                    options2.inTargetDensity = 0;
                    options2.inDensity = 0;
                }
                String str5 = str4;
                if (Log.isLoggable(str5, 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Calculate scaling, source: [");
                    sb.append(i2);
                    String str6 = str3;
                    sb.append(str6);
                    sb.append(i3);
                    sb.append("], degreesToRotate: ");
                    sb.append(i);
                    sb.append(", target: [");
                    sb.append(i14);
                    sb.append(str6);
                    sb.append(i15);
                    sb.append("], power of two scaled: [");
                    sb.append(i10);
                    sb.append(str6);
                    sb.append(i11);
                    sb.append("], exact scale factor: ");
                    sb.append(scaleFactor);
                    sb.append(", power of 2 sample size: ");
                    sb.append(i9);
                    sb.append(", adjusted scale factor: ");
                    sb.append(scaleFactor2);
                    sb.append(", target density: ");
                    sb.append(options2.inTargetDensity);
                    sb.append(", density: ");
                    sb.append(options2.inDensity);
                    Log.v(str5, sb.toString());
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        int i19 = i12;
        String str7 = "x";
        throw new IllegalArgumentException("Cannot scale with factor: " + scaleFactor + " from: " + downsampleStrategy2 + ", source: [" + i19 + str7 + i13 + "], target: [" + i14 + str7 + i15 + "]");
    }

    /* renamed from: d */
    private Bitmap m4527d(InputStream inputStream, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, PreferredColorSpace preferredColorSpace, boolean z, int i, int i2, boolean z2, DecodeCallbacks decodeCallbacks) {
        int i3;
        int i4;
        Downsampler downsampler;
        int i5;
        ColorSpace colorSpace;
        int i6;
        int i7;
        InputStream inputStream2 = inputStream;
        BitmapFactory.Options options2 = options;
        DecodeCallbacks decodeCallbacks2 = decodeCallbacks;
        long logTime = LogTime.getLogTime();
        int[] i8 = m4532i(inputStream2, options2, decodeCallbacks2, this.f6131a);
        boolean z3 = false;
        int i9 = i8[0];
        int i10 = i8[1];
        String str = options2.outMimeType;
        boolean z4 = (i9 == -1 || i10 == -1) ? false : z;
        int orientation = ImageHeaderParserUtils.getOrientation(this.f6134d, inputStream2, this.f6133c);
        int exifOrientationDegrees = TransformationUtils.getExifOrientationDegrees(orientation);
        boolean isExifOrientationRequired = TransformationUtils.isExifOrientationRequired(orientation);
        int i11 = i;
        if (i11 == Integer.MIN_VALUE) {
            i4 = i2;
            i3 = m4534k(exifOrientationDegrees) ? i10 : i9;
        } else {
            i4 = i2;
            i3 = i11;
        }
        int i12 = i4 == Integer.MIN_VALUE ? m4534k(exifOrientationDegrees) ? i9 : i10 : i4;
        ImageHeaderParser.ImageType type = ImageHeaderParserUtils.getType(this.f6134d, inputStream2, this.f6133c);
        BitmapPool bitmapPool = this.f6131a;
        ImageHeaderParser.ImageType imageType = type;
        m4526c(type, inputStream, decodeCallbacks, bitmapPool, downsampleStrategy, exifOrientationDegrees, i9, i10, i3, i12, options);
        int i13 = orientation;
        String str2 = str;
        int i14 = i10;
        int i15 = i9;
        DecodeCallbacks decodeCallbacks3 = decodeCallbacks2;
        BitmapFactory.Options options3 = options2;
        m4525b(inputStream, decodeFormat, z4, isExifOrientationRequired, options, i3, i12);
        int i16 = Build.VERSION.SDK_INT;
        boolean z5 = i16 >= 19;
        if (options3.inSampleSize == 1 || z5) {
            downsampler = this;
            if (downsampler.m4542s(imageType)) {
                if (i15 < 0 || i14 < 0 || !z2 || !z5) {
                    float f = m4535l(options) ? ((float) options3.inTargetDensity) / ((float) options3.inDensity) : 1.0f;
                    int i17 = options3.inSampleSize;
                    float f2 = (float) i17;
                    float f3 = f;
                    i7 = Math.round(((float) ((int) Math.ceil((double) (((float) i15) / f2)))) * f3);
                    i6 = Math.round(((float) ((int) Math.ceil((double) (((float) i14) / f2)))) * f3);
                    if (Log.isLoggable("Downsampler", 2)) {
                        Log.v("Downsampler", "Calculated target [" + i7 + "x" + i6 + "] for source [" + i15 + "x" + i14 + "], sampleSize: " + i17 + ", targetDensity: " + options3.inTargetDensity + ", density: " + options3.inDensity + ", density multiplier: " + f3);
                    }
                } else {
                    i7 = i3;
                    i6 = i12;
                }
                if (i7 > 0 && i6 > 0) {
                    m4541r(options3, downsampler.f6131a, i7, i6);
                }
            }
        } else {
            downsampler = this;
        }
        if (i16 >= 28) {
            if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && (colorSpace = options3.outColorSpace) != null && colorSpace.isWideGamut()) {
                z3 = true;
            }
            options3.inPreferredColorSpace = ColorSpace.get(z3 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
        } else if (i16 >= 26) {
            options3.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        Bitmap e = m4528e(inputStream, options3, decodeCallbacks3, downsampler.f6131a);
        decodeCallbacks3.onDecodeComplete(downsampler.f6131a, e);
        if (Log.isLoggable("Downsampler", 2)) {
            i5 = i13;
            m4536m(i15, i14, str2, options, e, i, i2, logTime);
        } else {
            i5 = i13;
        }
        Bitmap bitmap = null;
        if (e != null) {
            e.setDensity(downsampler.f6132b.densityDpi);
            bitmap = TransformationUtils.rotateImageExif(downsampler.f6131a, e, i5);
            if (!e.equals(bitmap)) {
                downsampler.f6131a.put(e);
            }
        }
        return bitmap;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:23|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005d */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap m4528e(java.io.InputStream r6, android.graphics.BitmapFactory.Options r7, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks r8, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r9) {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r7.inJustDecodeBounds
            if (r1 == 0) goto L_0x000c
            r1 = 10485760(0xa00000, float:1.469368E-38)
            r6.mark(r1)
            goto L_0x000f
        L_0x000c:
            r8.onObtainBounds()
        L_0x000f:
            int r1 = r7.outWidth
            int r2 = r7.outHeight
            java.lang.String r3 = r7.outMimeType
            java.util.concurrent.locks.Lock r4 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r4.lock()
            r4 = 0
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeStream(r6, r4, r7)     // Catch:{ IllegalArgumentException -> 0x0032 }
            java.util.concurrent.locks.Lock r9 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r9.unlock()
            boolean r7 = r7.inJustDecodeBounds
            if (r7 == 0) goto L_0x002f
            r6.reset()
        L_0x002f:
            return r8
        L_0x0030:
            r6 = move-exception
            goto L_0x005f
        L_0x0032:
            r5 = move-exception
            java.io.IOException r1 = m4537n(r5, r1, r2, r3, r7)     // Catch:{ all -> 0x0030 }
            r2 = 3
            boolean r2 = android.util.Log.isLoggable(r0, r2)     // Catch:{ all -> 0x0030 }
            if (r2 == 0) goto L_0x0043
            java.lang.String r2 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r2, r1)     // Catch:{ all -> 0x0030 }
        L_0x0043:
            android.graphics.Bitmap r0 = r7.inBitmap     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x005e
            r6.reset()     // Catch:{ IOException -> 0x005d }
            android.graphics.Bitmap r0 = r7.inBitmap     // Catch:{ IOException -> 0x005d }
            r9.put(r0)     // Catch:{ IOException -> 0x005d }
            r7.inBitmap = r4     // Catch:{ IOException -> 0x005d }
            android.graphics.Bitmap r6 = m4528e(r6, r7, r8, r9)     // Catch:{ IOException -> 0x005d }
            java.util.concurrent.locks.Lock r7 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r7.unlock()
            return r6
        L_0x005d:
            throw r1     // Catch:{ all -> 0x0030 }
        L_0x005e:
            throw r1     // Catch:{ all -> 0x0030 }
        L_0x005f:
            java.util.concurrent.locks.Lock r7 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r7.unlock()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.m4528e(java.io.InputStream, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool):android.graphics.Bitmap");
    }

    @TargetApi(19)
    @Nullable
    /* renamed from: f */
    private static String m4529f(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            str = " (" + bitmap.getAllocationByteCount() + ")";
        } else {
            str = "";
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
    }

    /* renamed from: g */
    private static synchronized BitmapFactory.Options m4530g() {
        BitmapFactory.Options poll;
        synchronized (Downsampler.class) {
            Queue<BitmapFactory.Options> queue = f6130i;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                m4539p(poll);
            }
        }
        return poll;
    }

    /* renamed from: h */
    private static int m4531h(double d) {
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        return (int) Math.round(d * 2.147483647E9d);
    }

    /* renamed from: i */
    private static int[] m4532i(InputStream inputStream, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool) {
        options.inJustDecodeBounds = true;
        m4528e(inputStream, options, decodeCallbacks, bitmapPool);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    /* renamed from: j */
    private static String m4533j(BitmapFactory.Options options) {
        return m4529f(options.inBitmap);
    }

    /* renamed from: k */
    private static boolean m4534k(int i) {
        return i == 90 || i == 270;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r1.inDensity;
     */
    /* renamed from: l */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m4535l(android.graphics.BitmapFactory.Options r1) {
        /*
            int r0 = r1.inTargetDensity
            if (r0 <= 0) goto L_0x000c
            int r1 = r1.inDensity
            if (r1 <= 0) goto L_0x000c
            if (r0 == r1) goto L_0x000c
            r1 = 1
            goto L_0x000d
        L_0x000c:
            r1 = 0
        L_0x000d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.m4535l(android.graphics.BitmapFactory$Options):boolean");
    }

    /* renamed from: m */
    private static void m4536m(int i, int i2, String str, BitmapFactory.Options options, Bitmap bitmap, int i3, int i4, long j) {
        Log.v("Downsampler", "Decoded " + m4529f(bitmap) + " from [" + i + "x" + i2 + "] " + str + " with inBitmap " + m4533j(options) + " for [" + i3 + "x" + i4 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + LogTime.getElapsedMillis(j));
    }

    /* renamed from: n */
    private static IOException m4537n(IllegalArgumentException illegalArgumentException, int i, int i2, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i + ", outHeight: " + i2 + ", outMimeType: " + str + ", inBitmap: " + m4533j(options), illegalArgumentException);
    }

    /* renamed from: o */
    private static void m4538o(BitmapFactory.Options options) {
        m4539p(options);
        Queue<BitmapFactory.Options> queue = f6130i;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    /* renamed from: p */
    private static void m4539p(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    /* renamed from: q */
    private static int m4540q(double d) {
        return (int) (d + 0.5d);
    }

    @TargetApi(26)
    /* renamed from: r */
    private static void m4541r(BitmapFactory.Options options, BitmapPool bitmapPool, int i, int i2) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig != Bitmap.Config.HARDWARE) {
            config = options.outConfig;
        } else {
            return;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = bitmapPool.getDirty(i, i2, config);
    }

    /* renamed from: s */
    private boolean m4542s(ImageHeaderParser.ImageType imageType) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return f6129h.contains(imageType);
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i, int i2, Options options) {
        return decode(inputStream, i, i2, options, f6128g);
    }

    public boolean handles(InputStream inputStream) {
        return true;
    }

    public boolean handles(ByteBuffer byteBuffer) {
        return true;
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i, int i2, Options options, DecodeCallbacks decodeCallbacks) {
        Options options2 = options;
        Preconditions.checkArgument(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.f6133c.get(65536, byte[].class);
        BitmapFactory.Options g = m4530g();
        g.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) options2.get(DECODE_FORMAT);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) options2.get(PREFERRED_COLOR_SPACE);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options2.get(DownsampleStrategy.OPTION);
        boolean booleanValue = ((Boolean) options2.get(FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS)).booleanValue();
        Option option = ALLOW_HARDWARE_CONFIG;
        try {
            return BitmapResource.obtain(m4527d(inputStream, g, downsampleStrategy, decodeFormat, preferredColorSpace, options2.get(option) != null && ((Boolean) options2.get(option)).booleanValue(), i, i2, booleanValue, decodeCallbacks), this.f6131a);
        } finally {
            m4538o(g);
            this.f6133c.put(bArr);
        }
    }
}
