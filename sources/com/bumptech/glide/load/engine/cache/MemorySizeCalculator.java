package com.bumptech.glide.load.engine.cache;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.util.Preconditions;

public final class MemorySizeCalculator {

    /* renamed from: a */
    private final int f5783a;

    /* renamed from: b */
    private final int f5784b;

    /* renamed from: c */
    private final Context f5785c;

    /* renamed from: d */
    private final int f5786d;

    public static final class Builder {

        /* renamed from: i */
        static final int f5787i = (Build.VERSION.SDK_INT < 26 ? 4 : 1);

        /* renamed from: a */
        final Context f5788a;

        /* renamed from: b */
        ActivityManager f5789b;

        /* renamed from: c */
        C1222b f5790c;

        /* renamed from: d */
        float f5791d = 2.0f;

        /* renamed from: e */
        float f5792e = ((float) f5787i);

        /* renamed from: f */
        float f5793f = 0.4f;

        /* renamed from: g */
        float f5794g = 0.33f;

        /* renamed from: h */
        int f5795h = 4194304;

        public Builder(Context context) {
            this.f5788a = context;
            this.f5789b = (ActivityManager) context.getSystemService("activity");
            this.f5790c = new C1221a(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26 && MemorySizeCalculator.m4316b(this.f5789b)) {
                this.f5792e = 0.0f;
            }
        }

        public MemorySizeCalculator build() {
            return new MemorySizeCalculator(this);
        }

        public Builder setArrayPoolSize(int i) {
            this.f5795h = i;
            return this;
        }

        public Builder setBitmapPoolScreens(float f) {
            Preconditions.checkArgument(f >= 0.0f, "Bitmap pool screens must be greater than or equal to 0");
            this.f5792e = f;
            return this;
        }

        public Builder setLowMemoryMaxSizeMultiplier(float f) {
            Preconditions.checkArgument(f >= 0.0f && f <= 1.0f, "Low memory max size multiplier must be between 0 and 1");
            this.f5794g = f;
            return this;
        }

        public Builder setMaxSizeMultiplier(float f) {
            Preconditions.checkArgument(f >= 0.0f && f <= 1.0f, "Size multiplier must be between 0 and 1");
            this.f5793f = f;
            return this;
        }

        public Builder setMemoryCacheScreens(float f) {
            Preconditions.checkArgument(f >= 0.0f, "Memory cache screens must be greater than or equal to 0");
            this.f5791d = f;
            return this;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.cache.MemorySizeCalculator$a */
    private static final class C1221a implements C1222b {

        /* renamed from: a */
        private final DisplayMetrics f5796a;

        C1221a(DisplayMetrics displayMetrics) {
            this.f5796a = displayMetrics;
        }

        /* renamed from: a */
        public int mo9585a() {
            return this.f5796a.heightPixels;
        }

        /* renamed from: b */
        public int mo9586b() {
            return this.f5796a.widthPixels;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.cache.MemorySizeCalculator$b */
    interface C1222b {
        /* renamed from: a */
        int mo9585a();

        /* renamed from: b */
        int mo9586b();
    }

    MemorySizeCalculator(Builder builder) {
        int i;
        this.f5785c = builder.f5788a;
        if (m4316b(builder.f5789b)) {
            i = builder.f5795h / 2;
        } else {
            i = builder.f5795h;
        }
        this.f5786d = i;
        int a = m4315a(builder.f5789b, builder.f5793f, builder.f5794g);
        float b = (float) (builder.f5790c.mo9586b() * builder.f5790c.mo9585a() * 4);
        int round = Math.round(builder.f5792e * b);
        int round2 = Math.round(b * builder.f5791d);
        int i2 = a - i;
        int i3 = round2 + round;
        if (i3 <= i2) {
            this.f5784b = round2;
            this.f5783a = round;
        } else {
            float f = (float) i2;
            float f2 = builder.f5792e;
            float f3 = builder.f5791d;
            float f4 = f / (f2 + f3);
            this.f5784b = Math.round(f3 * f4);
            this.f5783a = Math.round(f4 * builder.f5792e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(m4317c(this.f5784b));
            sb.append(", pool size: ");
            sb.append(m4317c(this.f5783a));
            sb.append(", byte array size: ");
            sb.append(m4317c(i));
            sb.append(", memory class limited? ");
            sb.append(i3 > a);
            sb.append(", max size: ");
            sb.append(m4317c(a));
            sb.append(", memoryClass: ");
            sb.append(builder.f5789b.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(m4316b(builder.f5789b));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    /* renamed from: a */
    private static int m4315a(ActivityManager activityManager, float f, float f2) {
        boolean b = m4316b(activityManager);
        float memoryClass = (float) (activityManager.getMemoryClass() * 1024 * 1024);
        if (b) {
            f = f2;
        }
        return Math.round(memoryClass * f);
    }

    @TargetApi(19)
    /* renamed from: b */
    static boolean m4316b(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    /* renamed from: c */
    private String m4317c(int i) {
        return Formatter.formatFileSize(this.f5785c, (long) i);
    }

    public int getArrayPoolSizeInBytes() {
        return this.f5786d;
    }

    public int getBitmapPoolSize() {
        return this.f5783a;
    }

    public int getMemoryCacheSize() {
        return this.f5784b;
    }
}
