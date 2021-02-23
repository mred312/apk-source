package com.bumptech.glide.load.resource.bitmap;

import android.os.Build;
import com.bumptech.glide.load.Option;

public abstract class DownsampleStrategy {
    public static final DownsampleStrategy AT_LEAST = new C1298a();
    public static final DownsampleStrategy AT_MOST = new C1299b();
    public static final DownsampleStrategy CENTER_INSIDE = new C1300c();
    public static final DownsampleStrategy CENTER_OUTSIDE;
    public static final DownsampleStrategy DEFAULT;
    public static final DownsampleStrategy FIT_CENTER = new C1302e();
    public static final DownsampleStrategy NONE = new C1303f();
    public static final Option<DownsampleStrategy> OPTION;

    /* renamed from: a */
    static final boolean f6125a = (Build.VERSION.SDK_INT >= 19);

    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$a */
    private static class C1298a extends DownsampleStrategy {
        C1298a() {
        }

        public SampleSizeRounding getSampleSizeRounding(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }

        public float getScaleFactor(int i, int i2, int i3, int i4) {
            int min = Math.min(i2 / i4, i / i3);
            if (min == 0) {
                return 1.0f;
            }
            return 1.0f / ((float) Integer.highestOneBit(min));
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$b */
    private static class C1299b extends DownsampleStrategy {
        C1299b() {
        }

        public SampleSizeRounding getSampleSizeRounding(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.MEMORY;
        }

        public float getScaleFactor(int i, int i2, int i3, int i4) {
            int ceil = (int) Math.ceil((double) Math.max(((float) i2) / ((float) i4), ((float) i) / ((float) i3)));
            int i5 = 1;
            int max = Math.max(1, Integer.highestOneBit(ceil));
            if (max >= ceil) {
                i5 = 0;
            }
            return 1.0f / ((float) (max << i5));
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$c */
    private static class C1300c extends DownsampleStrategy {
        C1300c() {
        }

        public SampleSizeRounding getSampleSizeRounding(int i, int i2, int i3, int i4) {
            if (getScaleFactor(i, i2, i3, i4) == 1.0f) {
                return SampleSizeRounding.QUALITY;
            }
            return DownsampleStrategy.FIT_CENTER.getSampleSizeRounding(i, i2, i3, i4);
        }

        public float getScaleFactor(int i, int i2, int i3, int i4) {
            return Math.min(1.0f, DownsampleStrategy.FIT_CENTER.getScaleFactor(i, i2, i3, i4));
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$d */
    private static class C1301d extends DownsampleStrategy {
        C1301d() {
        }

        public SampleSizeRounding getSampleSizeRounding(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }

        public float getScaleFactor(int i, int i2, int i3, int i4) {
            return Math.max(((float) i3) / ((float) i), ((float) i4) / ((float) i2));
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$e */
    private static class C1302e extends DownsampleStrategy {
        C1302e() {
        }

        public SampleSizeRounding getSampleSizeRounding(int i, int i2, int i3, int i4) {
            if (DownsampleStrategy.f6125a) {
                return SampleSizeRounding.QUALITY;
            }
            return SampleSizeRounding.MEMORY;
        }

        public float getScaleFactor(int i, int i2, int i3, int i4) {
            if (DownsampleStrategy.f6125a) {
                return Math.min(((float) i3) / ((float) i), ((float) i4) / ((float) i2));
            }
            int max = Math.max(i2 / i4, i / i3);
            if (max == 0) {
                return 1.0f;
            }
            return 1.0f / ((float) Integer.highestOneBit(max));
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$f */
    private static class C1303f extends DownsampleStrategy {
        C1303f() {
        }

        public SampleSizeRounding getSampleSizeRounding(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }

        public float getScaleFactor(int i, int i2, int i3, int i4) {
            return 1.0f;
        }
    }

    static {
        C1301d dVar = new C1301d();
        CENTER_OUTSIDE = dVar;
        DEFAULT = dVar;
        OPTION = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", dVar);
    }

    public abstract SampleSizeRounding getSampleSizeRounding(int i, int i2, int i3, int i4);

    public abstract float getScaleFactor(int i, int i2, int i3, int i4);
}
