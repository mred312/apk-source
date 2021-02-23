package com.bumptech.glide.request;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;

public class RequestOptions extends BaseRequestOptions<RequestOptions> {
    @Nullable

    /* renamed from: A */
    private static RequestOptions f6353A;
    @Nullable

    /* renamed from: B */
    private static RequestOptions f6354B;
    @Nullable

    /* renamed from: C */
    private static RequestOptions f6355C;
    @Nullable

    /* renamed from: D */
    private static RequestOptions f6356D;
    @Nullable

    /* renamed from: E */
    private static RequestOptions f6357E;
    @Nullable

    /* renamed from: F */
    private static RequestOptions f6358F;
    @Nullable

    /* renamed from: G */
    private static RequestOptions f6359G;
    @Nullable

    /* renamed from: H */
    private static RequestOptions f6360H;

    /* JADX WARNING: type inference failed for: r1v0, types: [com.bumptech.glide.load.Transformation, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.CheckResult
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.bumptech.glide.request.RequestOptions bitmapTransform(@androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r1) {
        /*
            com.bumptech.glide.request.RequestOptions r0 = new com.bumptech.glide.request.RequestOptions
            r0.<init>()
            com.bumptech.glide.request.BaseRequestOptions r1 = r0.transform((com.bumptech.glide.load.Transformation<android.graphics.Bitmap>) r1)
            com.bumptech.glide.request.RequestOptions r1 = (com.bumptech.glide.request.RequestOptions) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.RequestOptions.bitmapTransform(com.bumptech.glide.load.Transformation):com.bumptech.glide.request.RequestOptions");
    }

    @CheckResult
    @NonNull
    public static RequestOptions centerCropTransform() {
        if (f6357E == null) {
            f6357E = (RequestOptions) ((RequestOptions) new RequestOptions().centerCrop()).autoClone();
        }
        return f6357E;
    }

    @CheckResult
    @NonNull
    public static RequestOptions centerInsideTransform() {
        if (f6356D == null) {
            f6356D = (RequestOptions) ((RequestOptions) new RequestOptions().centerInside()).autoClone();
        }
        return f6356D;
    }

    @CheckResult
    @NonNull
    public static RequestOptions circleCropTransform() {
        if (f6358F == null) {
            f6358F = (RequestOptions) ((RequestOptions) new RequestOptions().circleCrop()).autoClone();
        }
        return f6358F;
    }

    @CheckResult
    @NonNull
    public static RequestOptions decodeTypeOf(@NonNull Class<?> cls) {
        return (RequestOptions) new RequestOptions().decode(cls);
    }

    @CheckResult
    @NonNull
    public static RequestOptions diskCacheStrategyOf(@NonNull DiskCacheStrategy diskCacheStrategy) {
        return (RequestOptions) new RequestOptions().diskCacheStrategy(diskCacheStrategy);
    }

    @CheckResult
    @NonNull
    public static RequestOptions downsampleOf(@NonNull DownsampleStrategy downsampleStrategy) {
        return (RequestOptions) new RequestOptions().downsample(downsampleStrategy);
    }

    @CheckResult
    @NonNull
    public static RequestOptions encodeFormatOf(@NonNull Bitmap.CompressFormat compressFormat) {
        return (RequestOptions) new RequestOptions().encodeFormat(compressFormat);
    }

    @CheckResult
    @NonNull
    public static RequestOptions encodeQualityOf(@IntRange(from = 0, mo779to = 100) int i) {
        return (RequestOptions) new RequestOptions().encodeQuality(i);
    }

    @CheckResult
    @NonNull
    public static RequestOptions errorOf(@Nullable Drawable drawable) {
        return (RequestOptions) new RequestOptions().error(drawable);
    }

    @CheckResult
    @NonNull
    public static RequestOptions fitCenterTransform() {
        if (f6355C == null) {
            f6355C = (RequestOptions) ((RequestOptions) new RequestOptions().fitCenter()).autoClone();
        }
        return f6355C;
    }

    @CheckResult
    @NonNull
    public static RequestOptions formatOf(@NonNull DecodeFormat decodeFormat) {
        return (RequestOptions) new RequestOptions().format(decodeFormat);
    }

    @CheckResult
    @NonNull
    public static RequestOptions frameOf(@IntRange(from = 0) long j) {
        return (RequestOptions) new RequestOptions().frame(j);
    }

    @CheckResult
    @NonNull
    public static RequestOptions noAnimation() {
        if (f6360H == null) {
            f6360H = (RequestOptions) ((RequestOptions) new RequestOptions().dontAnimate()).autoClone();
        }
        return f6360H;
    }

    @CheckResult
    @NonNull
    public static RequestOptions noTransformation() {
        if (f6359G == null) {
            f6359G = (RequestOptions) ((RequestOptions) new RequestOptions().dontTransform()).autoClone();
        }
        return f6359G;
    }

    @CheckResult
    @NonNull
    public static <T> RequestOptions option(@NonNull Option<T> option, @NonNull T t) {
        return (RequestOptions) new RequestOptions().set(option, t);
    }

    @CheckResult
    @NonNull
    public static RequestOptions overrideOf(int i, int i2) {
        return (RequestOptions) new RequestOptions().override(i, i2);
    }

    @CheckResult
    @NonNull
    public static RequestOptions placeholderOf(@Nullable Drawable drawable) {
        return (RequestOptions) new RequestOptions().placeholder(drawable);
    }

    @CheckResult
    @NonNull
    public static RequestOptions priorityOf(@NonNull Priority priority) {
        return (RequestOptions) new RequestOptions().priority(priority);
    }

    @CheckResult
    @NonNull
    public static RequestOptions signatureOf(@NonNull Key key) {
        return (RequestOptions) new RequestOptions().signature(key);
    }

    @CheckResult
    @NonNull
    public static RequestOptions sizeMultiplierOf(@FloatRange(from = 0.0d, mo761to = 1.0d) float f) {
        return (RequestOptions) new RequestOptions().sizeMultiplier(f);
    }

    @CheckResult
    @NonNull
    public static RequestOptions skipMemoryCacheOf(boolean z) {
        if (z) {
            if (f6353A == null) {
                f6353A = (RequestOptions) ((RequestOptions) new RequestOptions().skipMemoryCache(true)).autoClone();
            }
            return f6353A;
        }
        if (f6354B == null) {
            f6354B = (RequestOptions) ((RequestOptions) new RequestOptions().skipMemoryCache(false)).autoClone();
        }
        return f6354B;
    }

    @CheckResult
    @NonNull
    public static RequestOptions timeoutOf(@IntRange(from = 0) int i) {
        return (RequestOptions) new RequestOptions().timeout(i);
    }

    @CheckResult
    @NonNull
    public static RequestOptions errorOf(@DrawableRes int i) {
        return (RequestOptions) new RequestOptions().error(i);
    }

    @CheckResult
    @NonNull
    public static RequestOptions overrideOf(int i) {
        return overrideOf(i, i);
    }

    @CheckResult
    @NonNull
    public static RequestOptions placeholderOf(@DrawableRes int i) {
        return (RequestOptions) new RequestOptions().placeholder(i);
    }
}
