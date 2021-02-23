package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.gif.GifFrameLoader;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class GifDrawable extends Drawable implements GifFrameLoader.FrameCallback, Animatable, Animatable2Compat {
    public static final int LOOP_FOREVER = -1;
    public static final int LOOP_INTRINSIC = 0;

    /* renamed from: a */
    private final C1323a f6202a;

    /* renamed from: b */
    private boolean f6203b;

    /* renamed from: c */
    private boolean f6204c;

    /* renamed from: d */
    private boolean f6205d;

    /* renamed from: e */
    private boolean f6206e;

    /* renamed from: f */
    private int f6207f;

    /* renamed from: g */
    private int f6208g;

    /* renamed from: h */
    private boolean f6209h;

    /* renamed from: i */
    private Paint f6210i;

    /* renamed from: j */
    private Rect f6211j;

    /* renamed from: k */
    private List<Animatable2Compat.AnimationCallback> f6212k;

    /* renamed from: com.bumptech.glide.load.resource.gif.GifDrawable$a */
    static final class C1323a extends Drawable.ConstantState {
        @VisibleForTesting

        /* renamed from: a */
        final GifFrameLoader f6213a;

        C1323a(GifFrameLoader gifFrameLoader) {
            this.f6213a = gifFrameLoader;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        @NonNull
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @NonNull
        public Drawable newDrawable() {
            return new GifDrawable(this);
        }
    }

    @Deprecated
    public GifDrawable(Context context, GifDecoder gifDecoder, BitmapPool bitmapPool, Transformation<Bitmap> transformation, int i, int i2, Bitmap bitmap) {
        this(context, gifDecoder, transformation, i, i2, bitmap);
    }

    /* renamed from: a */
    private Drawable.Callback m4586a() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    /* renamed from: b */
    private Rect m4587b() {
        if (this.f6211j == null) {
            this.f6211j = new Rect();
        }
        return this.f6211j;
    }

    /* renamed from: c */
    private Paint m4588c() {
        if (this.f6210i == null) {
            this.f6210i = new Paint(2);
        }
        return this.f6210i;
    }

    /* renamed from: d */
    private void m4589d() {
        List<Animatable2Compat.AnimationCallback> list = this.f6212k;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                this.f6212k.get(i).onAnimationEnd(this);
            }
        }
    }

    /* renamed from: e */
    private void m4590e() {
        this.f6207f = 0;
    }

    /* renamed from: f */
    private void m4591f() {
        Preconditions.checkArgument(!this.f6205d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f6202a.f6213a.mo9934f() == 1) {
            invalidateSelf();
        } else if (!this.f6203b) {
            this.f6203b = true;
            this.f6202a.f6213a.mo9943u(this);
            invalidateSelf();
        }
    }

    /* renamed from: g */
    private void m4592g() {
        this.f6203b = false;
        this.f6202a.f6213a.mo9944v(this);
    }

    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> list = this.f6212k;
        if (list != null) {
            list.clear();
        }
    }

    public void draw(@NonNull Canvas canvas) {
        if (!this.f6205d) {
            if (this.f6209h) {
                Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), m4587b());
                this.f6209h = false;
            }
            canvas.drawBitmap(this.f6202a.f6213a.mo9931c(), (Rect) null, m4587b(), m4588c());
        }
    }

    public ByteBuffer getBuffer() {
        return this.f6202a.f6213a.mo9930b();
    }

    public Drawable.ConstantState getConstantState() {
        return this.f6202a;
    }

    public Bitmap getFirstFrame() {
        return this.f6202a.f6213a.mo9933e();
    }

    public int getFrameCount() {
        return this.f6202a.f6213a.mo9934f();
    }

    public int getFrameIndex() {
        return this.f6202a.f6213a.mo9932d();
    }

    public Transformation<Bitmap> getFrameTransformation() {
        return this.f6202a.f6213a.mo9935h();
    }

    public int getIntrinsicHeight() {
        return this.f6202a.f6213a.mo9936i();
    }

    public int getIntrinsicWidth() {
        return this.f6202a.f6213a.mo9939m();
    }

    public int getOpacity() {
        return -2;
    }

    public int getSize() {
        return this.f6202a.f6213a.mo9938l();
    }

    public boolean isRunning() {
        return this.f6203b;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f6209h = true;
    }

    public void onFrameReady() {
        if (m4586a() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (getFrameIndex() == getFrameCount() - 1) {
            this.f6207f++;
        }
        int i = this.f6208g;
        if (i != -1 && this.f6207f >= i) {
            m4589d();
            stop();
        }
    }

    public void recycle() {
        this.f6205d = true;
        this.f6202a.f6213a.mo9929a();
    }

    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback != null) {
            if (this.f6212k == null) {
                this.f6212k = new ArrayList();
            }
            this.f6212k.add(animationCallback);
        }
    }

    public void setAlpha(int i) {
        m4588c().setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        m4588c().setColorFilter(colorFilter);
    }

    public void setFrameTransformation(Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.f6202a.f6213a.mo9941q(transformation, bitmap);
    }

    public void setLoopCount(int i) {
        int i2 = -1;
        if (i <= 0 && i != -1 && i != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        } else if (i == 0) {
            int j = this.f6202a.f6213a.mo9937j();
            if (j != 0) {
                i2 = j;
            }
            this.f6208g = i2;
        } else {
            this.f6208g = i;
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Preconditions.checkArgument(!this.f6205d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f6206e = z;
        if (!z) {
            m4592g();
        } else if (this.f6204c) {
            m4591f();
        }
        return super.setVisible(z, z2);
    }

    public void start() {
        this.f6204c = true;
        m4590e();
        if (this.f6206e) {
            m4591f();
        }
    }

    public void startFromFirstFrame() {
        Preconditions.checkArgument(!this.f6203b, "You cannot restart a currently running animation.");
        this.f6202a.f6213a.mo9942r();
        start();
    }

    public void stop() {
        this.f6204c = false;
        m4592g();
    }

    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.f6212k;
        if (list == null || animationCallback == null) {
            return false;
        }
        return list.remove(animationCallback);
    }

    public GifDrawable(Context context, GifDecoder gifDecoder, Transformation<Bitmap> transformation, int i, int i2, Bitmap bitmap) {
        this(new C1323a(new GifFrameLoader(Glide.get(context), gifDecoder, i, i2, transformation, bitmap)));
    }

    GifDrawable(C1323a aVar) {
        this.f6206e = true;
        this.f6208g = -1;
        this.f6202a = (C1323a) Preconditions.checkNotNull(aVar);
    }
}
