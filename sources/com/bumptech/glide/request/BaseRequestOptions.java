package com.bumptech.glide.request;

import android.content.res.Resources;
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
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.gif.GifOptions;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Map;

public abstract class BaseRequestOptions<T extends BaseRequestOptions<T>> implements Cloneable {

    /* renamed from: a */
    private int f6308a;

    /* renamed from: b */
    private float f6309b = 1.0f;
    @NonNull

    /* renamed from: c */
    private DiskCacheStrategy f6310c = DiskCacheStrategy.AUTOMATIC;
    @NonNull

    /* renamed from: d */
    private Priority f6311d = Priority.NORMAL;
    @Nullable

    /* renamed from: e */
    private Drawable f6312e;

    /* renamed from: f */
    private int f6313f;
    @Nullable

    /* renamed from: g */
    private Drawable f6314g;

    /* renamed from: h */
    private int f6315h;

    /* renamed from: i */
    private boolean f6316i = true;

    /* renamed from: j */
    private int f6317j = -1;

    /* renamed from: k */
    private int f6318k = -1;
    @NonNull

    /* renamed from: l */
    private Key f6319l = EmptySignature.obtain();

    /* renamed from: m */
    private boolean f6320m;

    /* renamed from: n */
    private boolean f6321n = true;
    @Nullable

    /* renamed from: o */
    private Drawable f6322o;

    /* renamed from: p */
    private int f6323p;
    @NonNull

    /* renamed from: q */
    private Options f6324q = new Options();
    @NonNull

    /* renamed from: r */
    private Map<Class<?>, Transformation<?>> f6325r = new CachedHashCodeArrayMap();
    @NonNull

    /* renamed from: s */
    private Class<?> f6326s = Object.class;

    /* renamed from: t */
    private boolean f6327t;
    @Nullable

    /* renamed from: u */
    private Resources.Theme f6328u;

    /* renamed from: v */
    private boolean f6329v;

    /* renamed from: w */
    private boolean f6330w;

    /* renamed from: x */
    private boolean f6331x;

    /* renamed from: y */
    private boolean f6332y = true;

    /* renamed from: z */
    private boolean f6333z;

    /* renamed from: b */
    private boolean m4666b(int i) {
        return m4667c(this.f6308a, i);
    }

    /* renamed from: c */
    private static boolean m4667c(int i, int i2) {
        return (i & i2) != 0;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.load.Transformation, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.NonNull
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private T m4668d(@androidx.annotation.NonNull com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r2, @androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r3) {
        /*
            r1 = this;
            r0 = 0
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.m4670g(r2, r3, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.m4668d(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, com.bumptech.glide.load.Transformation):com.bumptech.glide.request.BaseRequestOptions");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.load.Transformation, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.NonNull
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private T m4669f(@androidx.annotation.NonNull com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r2, @androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r3) {
        /*
            r1 = this;
            r0 = 1
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.m4670g(r2, r3, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.m4669f(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, com.bumptech.glide.load.Transformation):com.bumptech.glide.request.BaseRequestOptions");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.bumptech.glide.load.Transformation, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.NonNull
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private T m4670g(@androidx.annotation.NonNull com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r1, @androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r2, boolean r3) {
        /*
            r0 = this;
            if (r3 == 0) goto L_0x0007
            com.bumptech.glide.request.BaseRequestOptions r1 = r0.mo10091k(r1, r2)
            goto L_0x000b
        L_0x0007:
            com.bumptech.glide.request.BaseRequestOptions r1 = r0.mo10049e(r1, r2)
        L_0x000b:
            r2 = 1
            r1.f6332y = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.m4670g(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, com.bumptech.glide.load.Transformation, boolean):com.bumptech.glide.request.BaseRequestOptions");
    }

    /* renamed from: h */
    private T m4671h() {
        return this;
    }

    @NonNull
    /* renamed from: i */
    private T m4672i() {
        if (!this.f6327t) {
            m4671h();
            return this;
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo10038a() {
        return this.f6332y;
    }

    @CheckResult
    @NonNull
    public T apply(@NonNull BaseRequestOptions<?> baseRequestOptions) {
        if (this.f6329v) {
            return clone().apply(baseRequestOptions);
        }
        if (m4667c(baseRequestOptions.f6308a, 2)) {
            this.f6309b = baseRequestOptions.f6309b;
        }
        if (m4667c(baseRequestOptions.f6308a, 262144)) {
            this.f6330w = baseRequestOptions.f6330w;
        }
        if (m4667c(baseRequestOptions.f6308a, 1048576)) {
            this.f6333z = baseRequestOptions.f6333z;
        }
        if (m4667c(baseRequestOptions.f6308a, 4)) {
            this.f6310c = baseRequestOptions.f6310c;
        }
        if (m4667c(baseRequestOptions.f6308a, 8)) {
            this.f6311d = baseRequestOptions.f6311d;
        }
        if (m4667c(baseRequestOptions.f6308a, 16)) {
            this.f6312e = baseRequestOptions.f6312e;
            this.f6313f = 0;
            this.f6308a &= -33;
        }
        if (m4667c(baseRequestOptions.f6308a, 32)) {
            this.f6313f = baseRequestOptions.f6313f;
            this.f6312e = null;
            this.f6308a &= -17;
        }
        if (m4667c(baseRequestOptions.f6308a, 64)) {
            this.f6314g = baseRequestOptions.f6314g;
            this.f6315h = 0;
            this.f6308a &= -129;
        }
        if (m4667c(baseRequestOptions.f6308a, 128)) {
            this.f6315h = baseRequestOptions.f6315h;
            this.f6314g = null;
            this.f6308a &= -65;
        }
        if (m4667c(baseRequestOptions.f6308a, 256)) {
            this.f6316i = baseRequestOptions.f6316i;
        }
        if (m4667c(baseRequestOptions.f6308a, 512)) {
            this.f6318k = baseRequestOptions.f6318k;
            this.f6317j = baseRequestOptions.f6317j;
        }
        if (m4667c(baseRequestOptions.f6308a, 1024)) {
            this.f6319l = baseRequestOptions.f6319l;
        }
        if (m4667c(baseRequestOptions.f6308a, 4096)) {
            this.f6326s = baseRequestOptions.f6326s;
        }
        if (m4667c(baseRequestOptions.f6308a, 8192)) {
            this.f6322o = baseRequestOptions.f6322o;
            this.f6323p = 0;
            this.f6308a &= -16385;
        }
        if (m4667c(baseRequestOptions.f6308a, 16384)) {
            this.f6323p = baseRequestOptions.f6323p;
            this.f6322o = null;
            this.f6308a &= -8193;
        }
        if (m4667c(baseRequestOptions.f6308a, 32768)) {
            this.f6328u = baseRequestOptions.f6328u;
        }
        if (m4667c(baseRequestOptions.f6308a, 65536)) {
            this.f6321n = baseRequestOptions.f6321n;
        }
        if (m4667c(baseRequestOptions.f6308a, 131072)) {
            this.f6320m = baseRequestOptions.f6320m;
        }
        if (m4667c(baseRequestOptions.f6308a, 2048)) {
            this.f6325r.putAll(baseRequestOptions.f6325r);
            this.f6332y = baseRequestOptions.f6332y;
        }
        if (m4667c(baseRequestOptions.f6308a, 524288)) {
            this.f6331x = baseRequestOptions.f6331x;
        }
        if (!this.f6321n) {
            this.f6325r.clear();
            int i = this.f6308a & -2049;
            this.f6308a = i;
            this.f6320m = false;
            this.f6308a = i & -131073;
            this.f6332y = true;
        }
        this.f6308a |= baseRequestOptions.f6308a;
        this.f6324q.putAll(baseRequestOptions.f6324q);
        m4672i();
        return this;
    }

    @NonNull
    public T autoClone() {
        if (!this.f6327t || this.f6329v) {
            this.f6329v = true;
            return lock();
        }
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    @CheckResult
    @NonNull
    public T centerCrop() {
        return mo10091k(DownsampleStrategy.CENTER_OUTSIDE, new CenterCrop());
    }

    @CheckResult
    @NonNull
    public T centerInside() {
        return m4669f(DownsampleStrategy.CENTER_INSIDE, new CenterInside());
    }

    @CheckResult
    @NonNull
    public T circleCrop() {
        return mo10091k(DownsampleStrategy.CENTER_INSIDE, new CircleCrop());
    }

    @CheckResult
    @NonNull
    public T decode(@NonNull Class<?> cls) {
        if (this.f6329v) {
            return clone().decode(cls);
        }
        this.f6326s = (Class) Preconditions.checkNotNull(cls);
        this.f6308a |= 4096;
        m4672i();
        return this;
    }

    @CheckResult
    @NonNull
    public T disallowHardwareConfig() {
        return set(Downsampler.ALLOW_HARDWARE_CONFIG, Boolean.FALSE);
    }

    @CheckResult
    @NonNull
    public T diskCacheStrategy(@NonNull DiskCacheStrategy diskCacheStrategy) {
        if (this.f6329v) {
            return clone().diskCacheStrategy(diskCacheStrategy);
        }
        this.f6310c = (DiskCacheStrategy) Preconditions.checkNotNull(diskCacheStrategy);
        this.f6308a |= 4;
        m4672i();
        return this;
    }

    @CheckResult
    @NonNull
    public T dontAnimate() {
        return set(GifOptions.DISABLE_ANIMATION, Boolean.TRUE);
    }

    @CheckResult
    @NonNull
    public T dontTransform() {
        if (this.f6329v) {
            return clone().dontTransform();
        }
        this.f6325r.clear();
        int i = this.f6308a & -2049;
        this.f6308a = i;
        this.f6320m = false;
        int i2 = i & -131073;
        this.f6308a = i2;
        this.f6321n = false;
        this.f6308a = i2 | 65536;
        this.f6332y = true;
        m4672i();
        return this;
    }

    @CheckResult
    @NonNull
    public T downsample(@NonNull DownsampleStrategy downsampleStrategy) {
        return set(DownsampleStrategy.OPTION, Preconditions.checkNotNull(downsampleStrategy));
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.load.Transformation, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.NonNull
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T mo10049e(@androidx.annotation.NonNull com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r2, @androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r3) {
        /*
            r1 = this;
            boolean r0 = r1.f6329v
            if (r0 == 0) goto L_0x000d
            com.bumptech.glide.request.BaseRequestOptions r0 = r1.clone()
            com.bumptech.glide.request.BaseRequestOptions r2 = r0.mo10049e(r2, r3)
            return r2
        L_0x000d:
            r1.downsample(r2)
            r2 = 0
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.mo10090j(r3, r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.mo10049e(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, com.bumptech.glide.load.Transformation):com.bumptech.glide.request.BaseRequestOptions");
    }

    @CheckResult
    @NonNull
    public T encodeFormat(@NonNull Bitmap.CompressFormat compressFormat) {
        return set(BitmapEncoder.COMPRESSION_FORMAT, Preconditions.checkNotNull(compressFormat));
    }

    @CheckResult
    @NonNull
    public T encodeQuality(@IntRange(from = 0, mo779to = 100) int i) {
        return set(BitmapEncoder.COMPRESSION_QUALITY, Integer.valueOf(i));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BaseRequestOptions)) {
            return false;
        }
        BaseRequestOptions baseRequestOptions = (BaseRequestOptions) obj;
        if (Float.compare(baseRequestOptions.f6309b, this.f6309b) == 0 && this.f6313f == baseRequestOptions.f6313f && Util.bothNullOrEqual(this.f6312e, baseRequestOptions.f6312e) && this.f6315h == baseRequestOptions.f6315h && Util.bothNullOrEqual(this.f6314g, baseRequestOptions.f6314g) && this.f6323p == baseRequestOptions.f6323p && Util.bothNullOrEqual(this.f6322o, baseRequestOptions.f6322o) && this.f6316i == baseRequestOptions.f6316i && this.f6317j == baseRequestOptions.f6317j && this.f6318k == baseRequestOptions.f6318k && this.f6320m == baseRequestOptions.f6320m && this.f6321n == baseRequestOptions.f6321n && this.f6330w == baseRequestOptions.f6330w && this.f6331x == baseRequestOptions.f6331x && this.f6310c.equals(baseRequestOptions.f6310c) && this.f6311d == baseRequestOptions.f6311d && this.f6324q.equals(baseRequestOptions.f6324q) && this.f6325r.equals(baseRequestOptions.f6325r) && this.f6326s.equals(baseRequestOptions.f6326s) && Util.bothNullOrEqual(this.f6319l, baseRequestOptions.f6319l) && Util.bothNullOrEqual(this.f6328u, baseRequestOptions.f6328u)) {
            return true;
        }
        return false;
    }

    @CheckResult
    @NonNull
    public T error(@Nullable Drawable drawable) {
        if (this.f6329v) {
            return clone().error(drawable);
        }
        this.f6312e = drawable;
        int i = this.f6308a | 16;
        this.f6308a = i;
        this.f6313f = 0;
        this.f6308a = i & -33;
        m4672i();
        return this;
    }

    @CheckResult
    @NonNull
    public T fallback(@Nullable Drawable drawable) {
        if (this.f6329v) {
            return clone().fallback(drawable);
        }
        this.f6322o = drawable;
        int i = this.f6308a | 8192;
        this.f6308a = i;
        this.f6323p = 0;
        this.f6308a = i & -16385;
        m4672i();
        return this;
    }

    @CheckResult
    @NonNull
    public T fitCenter() {
        return m4669f(DownsampleStrategy.FIT_CENTER, new FitCenter());
    }

    @CheckResult
    @NonNull
    public T format(@NonNull DecodeFormat decodeFormat) {
        Preconditions.checkNotNull(decodeFormat);
        return set(Downsampler.DECODE_FORMAT, decodeFormat).set(GifOptions.DECODE_FORMAT, decodeFormat);
    }

    @CheckResult
    @NonNull
    public T frame(@IntRange(from = 0) long j) {
        return set(VideoDecoder.TARGET_FRAME, Long.valueOf(j));
    }

    @NonNull
    public final DiskCacheStrategy getDiskCacheStrategy() {
        return this.f6310c;
    }

    public final int getErrorId() {
        return this.f6313f;
    }

    @Nullable
    public final Drawable getErrorPlaceholder() {
        return this.f6312e;
    }

    @Nullable
    public final Drawable getFallbackDrawable() {
        return this.f6322o;
    }

    public final int getFallbackId() {
        return this.f6323p;
    }

    public final boolean getOnlyRetrieveFromCache() {
        return this.f6331x;
    }

    @NonNull
    public final Options getOptions() {
        return this.f6324q;
    }

    public final int getOverrideHeight() {
        return this.f6317j;
    }

    public final int getOverrideWidth() {
        return this.f6318k;
    }

    @Nullable
    public final Drawable getPlaceholderDrawable() {
        return this.f6314g;
    }

    public final int getPlaceholderId() {
        return this.f6315h;
    }

    @NonNull
    public final Priority getPriority() {
        return this.f6311d;
    }

    @NonNull
    public final Class<?> getResourceClass() {
        return this.f6326s;
    }

    @NonNull
    public final Key getSignature() {
        return this.f6319l;
    }

    public final float getSizeMultiplier() {
        return this.f6309b;
    }

    @Nullable
    public final Resources.Theme getTheme() {
        return this.f6328u;
    }

    @NonNull
    public final Map<Class<?>, Transformation<?>> getTransformations() {
        return this.f6325r;
    }

    public final boolean getUseAnimationPool() {
        return this.f6333z;
    }

    public final boolean getUseUnlimitedSourceGeneratorsPool() {
        return this.f6330w;
    }

    public int hashCode() {
        return Util.hashCode((Object) this.f6328u, Util.hashCode((Object) this.f6319l, Util.hashCode((Object) this.f6326s, Util.hashCode((Object) this.f6325r, Util.hashCode((Object) this.f6324q, Util.hashCode((Object) this.f6311d, Util.hashCode((Object) this.f6310c, Util.hashCode(this.f6331x, Util.hashCode(this.f6330w, Util.hashCode(this.f6321n, Util.hashCode(this.f6320m, Util.hashCode(this.f6318k, Util.hashCode(this.f6317j, Util.hashCode(this.f6316i, Util.hashCode((Object) this.f6322o, Util.hashCode(this.f6323p, Util.hashCode((Object) this.f6314g, Util.hashCode(this.f6315h, Util.hashCode((Object) this.f6312e, Util.hashCode(this.f6313f, Util.hashCode(this.f6309b)))))))))))))))))))));
    }

    /* access modifiers changed from: protected */
    public boolean isAutoCloneEnabled() {
        return this.f6329v;
    }

    public final boolean isDiskCacheStrategySet() {
        return m4666b(4);
    }

    public final boolean isLocked() {
        return this.f6327t;
    }

    public final boolean isMemoryCacheable() {
        return this.f6316i;
    }

    public final boolean isPrioritySet() {
        return m4666b(8);
    }

    public final boolean isSkipMemoryCacheSet() {
        return m4666b(256);
    }

    public final boolean isTransformationAllowed() {
        return this.f6321n;
    }

    public final boolean isTransformationRequired() {
        return this.f6320m;
    }

    public final boolean isTransformationSet() {
        return m4666b(2048);
    }

    public final boolean isValidOverride() {
        return Util.isValidDimensions(this.f6318k, this.f6317j);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.load.Transformation, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.NonNull
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T mo10090j(@androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r3, boolean r4) {
        /*
            r2 = this;
            boolean r0 = r2.f6329v
            if (r0 == 0) goto L_0x000d
            com.bumptech.glide.request.BaseRequestOptions r0 = r2.clone()
            com.bumptech.glide.request.BaseRequestOptions r3 = r0.mo10090j(r3, r4)
            return r3
        L_0x000d:
            com.bumptech.glide.load.resource.bitmap.DrawableTransformation r0 = new com.bumptech.glide.load.resource.bitmap.DrawableTransformation
            r0.<init>(r3, r4)
            java.lang.Class<android.graphics.Bitmap> r1 = android.graphics.Bitmap.class
            r2.mo10092l(r1, r3, r4)
            java.lang.Class<android.graphics.drawable.Drawable> r1 = android.graphics.drawable.Drawable.class
            r2.mo10092l(r1, r0, r4)
            java.lang.Class<android.graphics.drawable.BitmapDrawable> r1 = android.graphics.drawable.BitmapDrawable.class
            com.bumptech.glide.load.Transformation r0 = r0.asBitmapDrawable()
            r2.mo10092l(r1, r0, r4)
            java.lang.Class<com.bumptech.glide.load.resource.gif.GifDrawable> r0 = com.bumptech.glide.load.resource.gif.GifDrawable.class
            com.bumptech.glide.load.resource.gif.GifDrawableTransformation r1 = new com.bumptech.glide.load.resource.gif.GifDrawableTransformation
            r1.<init>(r3)
            r2.mo10092l(r0, r1, r4)
            r2.m4672i()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.mo10090j(com.bumptech.glide.load.Transformation, boolean):com.bumptech.glide.request.BaseRequestOptions");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.load.Transformation, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.CheckResult
    @androidx.annotation.NonNull
    /* renamed from: k */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T mo10091k(@androidx.annotation.NonNull com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r2, @androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r3) {
        /*
            r1 = this;
            boolean r0 = r1.f6329v
            if (r0 == 0) goto L_0x000d
            com.bumptech.glide.request.BaseRequestOptions r0 = r1.clone()
            com.bumptech.glide.request.BaseRequestOptions r2 = r0.mo10091k(r2, r3)
            return r2
        L_0x000d:
            r1.downsample(r2)
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.transform((com.bumptech.glide.load.Transformation<android.graphics.Bitmap>) r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.mo10091k(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, com.bumptech.glide.load.Transformation):com.bumptech.glide.request.BaseRequestOptions");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Class<Y>, java.lang.Object, java.lang.Class] */
    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.load.Transformation<Y>, com.bumptech.glide.load.Transformation, java.lang.Object] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 2 */
    @androidx.annotation.NonNull
    /* renamed from: l */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <Y> T mo10092l(@androidx.annotation.NonNull java.lang.Class<Y> r2, @androidx.annotation.NonNull com.bumptech.glide.load.Transformation<Y> r3, boolean r4) {
        /*
            r1 = this;
            boolean r0 = r1.f6329v
            if (r0 == 0) goto L_0x000d
            com.bumptech.glide.request.BaseRequestOptions r0 = r1.clone()
            com.bumptech.glide.request.BaseRequestOptions r2 = r0.mo10092l(r2, r3, r4)
            return r2
        L_0x000d:
            com.bumptech.glide.util.Preconditions.checkNotNull(r2)
            com.bumptech.glide.util.Preconditions.checkNotNull(r3)
            java.util.Map<java.lang.Class<?>, com.bumptech.glide.load.Transformation<?>> r0 = r1.f6325r
            r0.put(r2, r3)
            int r2 = r1.f6308a
            r2 = r2 | 2048(0x800, float:2.87E-42)
            r1.f6308a = r2
            r3 = 1
            r1.f6321n = r3
            r0 = 65536(0x10000, float:9.18355E-41)
            r2 = r2 | r0
            r1.f6308a = r2
            r0 = 0
            r1.f6332y = r0
            if (r4 == 0) goto L_0x0032
            r4 = 131072(0x20000, float:1.83671E-40)
            r2 = r2 | r4
            r1.f6308a = r2
            r1.f6320m = r3
        L_0x0032:
            r1.m4672i()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.mo10092l(java.lang.Class, com.bumptech.glide.load.Transformation, boolean):com.bumptech.glide.request.BaseRequestOptions");
    }

    @NonNull
    public T lock() {
        this.f6327t = true;
        m4671h();
        return this;
    }

    @CheckResult
    @NonNull
    public T onlyRetrieveFromCache(boolean z) {
        if (this.f6329v) {
            return clone().onlyRetrieveFromCache(z);
        }
        this.f6331x = z;
        this.f6308a |= 524288;
        m4672i();
        return this;
    }

    @CheckResult
    @NonNull
    public T optionalCenterCrop() {
        return mo10049e(DownsampleStrategy.CENTER_OUTSIDE, new CenterCrop());
    }

    @CheckResult
    @NonNull
    public T optionalCenterInside() {
        return m4668d(DownsampleStrategy.CENTER_INSIDE, new CenterInside());
    }

    @CheckResult
    @NonNull
    public T optionalCircleCrop() {
        return mo10049e(DownsampleStrategy.CENTER_OUTSIDE, new CircleCrop());
    }

    @CheckResult
    @NonNull
    public T optionalFitCenter() {
        return m4668d(DownsampleStrategy.FIT_CENTER, new FitCenter());
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.bumptech.glide.load.Transformation, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.CheckResult
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T optionalTransform(@androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r2) {
        /*
            r1 = this;
            r0 = 0
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.mo10090j(r2, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.optionalTransform(com.bumptech.glide.load.Transformation):com.bumptech.glide.request.BaseRequestOptions");
    }

    @CheckResult
    @NonNull
    public T override(int i, int i2) {
        if (this.f6329v) {
            return clone().override(i, i2);
        }
        this.f6318k = i;
        this.f6317j = i2;
        this.f6308a |= 512;
        m4672i();
        return this;
    }

    @CheckResult
    @NonNull
    public T placeholder(@Nullable Drawable drawable) {
        if (this.f6329v) {
            return clone().placeholder(drawable);
        }
        this.f6314g = drawable;
        int i = this.f6308a | 64;
        this.f6308a = i;
        this.f6315h = 0;
        this.f6308a = i & -129;
        m4672i();
        return this;
    }

    @CheckResult
    @NonNull
    public T priority(@NonNull Priority priority) {
        if (this.f6329v) {
            return clone().priority(priority);
        }
        this.f6311d = (Priority) Preconditions.checkNotNull(priority);
        this.f6308a |= 8;
        m4672i();
        return this;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.bumptech.glide.load.Option, java.lang.Object, com.bumptech.glide.load.Option<Y>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.CheckResult
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <Y> T set(@androidx.annotation.NonNull com.bumptech.glide.load.Option<Y> r2, @androidx.annotation.NonNull Y r3) {
        /*
            r1 = this;
            boolean r0 = r1.f6329v
            if (r0 == 0) goto L_0x000d
            com.bumptech.glide.request.BaseRequestOptions r0 = r1.clone()
            com.bumptech.glide.request.BaseRequestOptions r2 = r0.set(r2, r3)
            return r2
        L_0x000d:
            com.bumptech.glide.util.Preconditions.checkNotNull(r2)
            com.bumptech.glide.util.Preconditions.checkNotNull(r3)
            com.bumptech.glide.load.Options r0 = r1.f6324q
            r0.set(r2, r3)
            r1.m4672i()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.set(com.bumptech.glide.load.Option, java.lang.Object):com.bumptech.glide.request.BaseRequestOptions");
    }

    @CheckResult
    @NonNull
    public T signature(@NonNull Key key) {
        if (this.f6329v) {
            return clone().signature(key);
        }
        this.f6319l = (Key) Preconditions.checkNotNull(key);
        this.f6308a |= 1024;
        m4672i();
        return this;
    }

    @CheckResult
    @NonNull
    public T sizeMultiplier(@FloatRange(from = 0.0d, mo761to = 1.0d) float f) {
        if (this.f6329v) {
            return clone().sizeMultiplier(f);
        }
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f6309b = f;
        this.f6308a |= 2;
        m4672i();
        return this;
    }

    @CheckResult
    @NonNull
    public T skipMemoryCache(boolean z) {
        if (this.f6329v) {
            return clone().skipMemoryCache(true);
        }
        this.f6316i = !z;
        this.f6308a |= 256;
        m4672i();
        return this;
    }

    @CheckResult
    @NonNull
    public T theme(@Nullable Resources.Theme theme) {
        if (this.f6329v) {
            return clone().theme(theme);
        }
        this.f6328u = theme;
        this.f6308a |= 32768;
        m4672i();
        return this;
    }

    @CheckResult
    @NonNull
    public T timeout(@IntRange(from = 0) int i) {
        return set(HttpGlideUrlLoader.TIMEOUT, Integer.valueOf(i));
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.bumptech.glide.load.Transformation, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.CheckResult
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T transform(@androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r2) {
        /*
            r1 = this;
            r0 = 1
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.mo10090j(r2, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.transform(com.bumptech.glide.load.Transformation):com.bumptech.glide.request.BaseRequestOptions");
    }

    @CheckResult
    @NonNull
    @Deprecated
    public T transforms(@NonNull Transformation<Bitmap>... transformationArr) {
        return mo10090j(new MultiTransformation((Transformation<T>[]) transformationArr), true);
    }

    @CheckResult
    @NonNull
    public T useAnimationPool(boolean z) {
        if (this.f6329v) {
            return clone().useAnimationPool(z);
        }
        this.f6333z = z;
        this.f6308a |= 1048576;
        m4672i();
        return this;
    }

    @CheckResult
    @NonNull
    public T useUnlimitedSourceGeneratorsPool(boolean z) {
        if (this.f6329v) {
            return clone().useUnlimitedSourceGeneratorsPool(z);
        }
        this.f6330w = z;
        this.f6308a |= 262144;
        m4672i();
        return this;
    }

    @CheckResult
    public T clone() {
        try {
            T t = (BaseRequestOptions) super.clone();
            Options options = new Options();
            t.f6324q = options;
            options.putAll(this.f6324q);
            CachedHashCodeArrayMap cachedHashCodeArrayMap = new CachedHashCodeArrayMap();
            t.f6325r = cachedHashCodeArrayMap;
            cachedHashCodeArrayMap.putAll(this.f6325r);
            t.f6327t = false;
            t.f6329v = false;
            return t;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Class<Y>, java.lang.Class] */
    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.load.Transformation<Y>, com.bumptech.glide.load.Transformation] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @androidx.annotation.CheckResult
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <Y> T optionalTransform(@androidx.annotation.NonNull java.lang.Class<Y> r2, @androidx.annotation.NonNull com.bumptech.glide.load.Transformation<Y> r3) {
        /*
            r1 = this;
            r0 = 0
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.mo10092l(r2, r3, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.optionalTransform(java.lang.Class, com.bumptech.glide.load.Transformation):com.bumptech.glide.request.BaseRequestOptions");
    }

    @CheckResult
    @NonNull
    public T transform(@NonNull Transformation<Bitmap>... transformationArr) {
        if (transformationArr.length > 1) {
            return mo10090j(new MultiTransformation((Transformation<T>[]) transformationArr), true);
        }
        if (transformationArr.length == 1) {
            return transform((Transformation<Bitmap>) transformationArr[0]);
        }
        m4672i();
        return this;
    }

    @CheckResult
    @NonNull
    public T override(int i) {
        return override(i, i);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Class<Y>, java.lang.Class] */
    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.load.Transformation<Y>, com.bumptech.glide.load.Transformation] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @androidx.annotation.CheckResult
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <Y> T transform(@androidx.annotation.NonNull java.lang.Class<Y> r2, @androidx.annotation.NonNull com.bumptech.glide.load.Transformation<Y> r3) {
        /*
            r1 = this;
            r0 = 1
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.mo10092l(r2, r3, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.transform(java.lang.Class, com.bumptech.glide.load.Transformation):com.bumptech.glide.request.BaseRequestOptions");
    }

    @CheckResult
    @NonNull
    public T error(@DrawableRes int i) {
        if (this.f6329v) {
            return clone().error(i);
        }
        this.f6313f = i;
        int i2 = this.f6308a | 32;
        this.f6308a = i2;
        this.f6312e = null;
        this.f6308a = i2 & -17;
        m4672i();
        return this;
    }

    @CheckResult
    @NonNull
    public T fallback(@DrawableRes int i) {
        if (this.f6329v) {
            return clone().fallback(i);
        }
        this.f6323p = i;
        int i2 = this.f6308a | 16384;
        this.f6308a = i2;
        this.f6322o = null;
        this.f6308a = i2 & -8193;
        m4672i();
        return this;
    }

    @CheckResult
    @NonNull
    public T placeholder(@DrawableRes int i) {
        if (this.f6329v) {
            return clone().placeholder(i);
        }
        this.f6315h = i;
        int i2 = this.f6308a | 128;
        this.f6308a = i2;
        this.f6314g = null;
        this.f6308a = i2 & -65;
        m4672i();
        return this;
    }
}
