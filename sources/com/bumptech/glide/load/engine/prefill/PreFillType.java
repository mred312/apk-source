package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import com.bumptech.glide.util.Preconditions;

public final class PreFillType {

    /* renamed from: a */
    private final int f5970a;

    /* renamed from: b */
    private final int f5971b;

    /* renamed from: c */
    private final Bitmap.Config f5972c;

    /* renamed from: d */
    private final int f5973d;

    public static class Builder {

        /* renamed from: a */
        private final int f5974a;

        /* renamed from: b */
        private final int f5975b;

        /* renamed from: c */
        private Bitmap.Config f5976c;

        /* renamed from: d */
        private int f5977d;

        public Builder(int i) {
            this(i, i);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public PreFillType mo9703a() {
            return new PreFillType(this.f5974a, this.f5975b, this.f5976c, this.f5977d);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public Bitmap.Config mo9704b() {
            return this.f5976c;
        }

        public Builder setConfig(@Nullable Bitmap.Config config) {
            this.f5976c = config;
            return this;
        }

        public Builder setWeight(int i) {
            if (i > 0) {
                this.f5977d = i;
                return this;
            }
            throw new IllegalArgumentException("Weight must be > 0");
        }

        public Builder(int i, int i2) {
            this.f5977d = 1;
            if (i <= 0) {
                throw new IllegalArgumentException("Width must be > 0");
            } else if (i2 > 0) {
                this.f5974a = i;
                this.f5975b = i2;
            } else {
                throw new IllegalArgumentException("Height must be > 0");
            }
        }
    }

    static {
        Bitmap.Config config = Bitmap.Config.RGB_565;
    }

    PreFillType(int i, int i2, Bitmap.Config config, int i3) {
        this.f5972c = (Bitmap.Config) Preconditions.checkNotNull(config, "Config must not be null");
        this.f5970a = i;
        this.f5971b = i2;
        this.f5973d = i3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Bitmap.Config mo9696a() {
        return this.f5972c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo9697b() {
        return this.f5971b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo9698c() {
        return this.f5973d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo9699d() {
        return this.f5970a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PreFillType)) {
            return false;
        }
        PreFillType preFillType = (PreFillType) obj;
        if (this.f5971b == preFillType.f5971b && this.f5970a == preFillType.f5970a && this.f5973d == preFillType.f5973d && this.f5972c == preFillType.f5972c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f5970a * 31) + this.f5971b) * 31) + this.f5972c.hashCode()) * 31) + this.f5973d;
    }

    public String toString() {
        return "PreFillSize{width=" + this.f5970a + ", height=" + this.f5971b + ", config=" + this.f5972c + ", weight=" + this.f5973d + '}';
    }
}
