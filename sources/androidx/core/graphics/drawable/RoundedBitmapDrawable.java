package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class RoundedBitmapDrawable extends Drawable {

    /* renamed from: a */
    final Bitmap f2345a;

    /* renamed from: b */
    private int f2346b = 160;

    /* renamed from: c */
    private int f2347c = 119;

    /* renamed from: d */
    private final Paint f2348d = new Paint(3);

    /* renamed from: e */
    private final BitmapShader f2349e;

    /* renamed from: f */
    private final Matrix f2350f = new Matrix();

    /* renamed from: g */
    private float f2351g;

    /* renamed from: h */
    final Rect f2352h = new Rect();

    /* renamed from: i */
    private final RectF f2353i = new RectF();

    /* renamed from: j */
    private boolean f2354j = true;

    /* renamed from: k */
    private boolean f2355k;

    /* renamed from: l */
    private int f2356l;

    /* renamed from: m */
    private int f2357m;

    RoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
        if (resources != null) {
            this.f2346b = resources.getDisplayMetrics().densityDpi;
        }
        this.f2345a = bitmap;
        if (bitmap != null) {
            m1581a();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f2349e = new BitmapShader(bitmap, tileMode, tileMode);
            return;
        }
        this.f2357m = -1;
        this.f2356l = -1;
        this.f2349e = null;
    }

    /* renamed from: a */
    private void m1581a() {
        this.f2356l = this.f2345a.getScaledWidth(this.f2346b);
        this.f2357m = this.f2345a.getScaledHeight(this.f2346b);
    }

    /* renamed from: c */
    private static boolean m1582c(float f) {
        return f > 0.05f;
    }

    /* renamed from: d */
    private void m1583d() {
        this.f2351g = (float) (Math.min(this.f2357m, this.f2356l) / 2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4207b(int i, int i2, int i3, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    public void draw(@NonNull Canvas canvas) {
        Bitmap bitmap = this.f2345a;
        if (bitmap != null) {
            mo4209e();
            if (this.f2348d.getShader() == null) {
                canvas.drawBitmap(bitmap, (Rect) null, this.f2352h, this.f2348d);
                return;
            }
            RectF rectF = this.f2353i;
            float f = this.f2351g;
            canvas.drawRoundRect(rectF, f, f, this.f2348d);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo4209e() {
        if (this.f2354j) {
            if (this.f2355k) {
                int min = Math.min(this.f2356l, this.f2357m);
                mo4207b(this.f2347c, min, min, getBounds(), this.f2352h);
                int min2 = Math.min(this.f2352h.width(), this.f2352h.height());
                this.f2352h.inset(Math.max(0, (this.f2352h.width() - min2) / 2), Math.max(0, (this.f2352h.height() - min2) / 2));
                this.f2351g = ((float) min2) * 0.5f;
            } else {
                mo4207b(this.f2347c, this.f2356l, this.f2357m, getBounds(), this.f2352h);
            }
            this.f2353i.set(this.f2352h);
            if (this.f2349e != null) {
                Matrix matrix = this.f2350f;
                RectF rectF = this.f2353i;
                matrix.setTranslate(rectF.left, rectF.top);
                this.f2350f.preScale(this.f2353i.width() / ((float) this.f2345a.getWidth()), this.f2353i.height() / ((float) this.f2345a.getHeight()));
                this.f2349e.setLocalMatrix(this.f2350f);
                this.f2348d.setShader(this.f2349e);
            }
            this.f2354j = false;
        }
    }

    public int getAlpha() {
        return this.f2348d.getAlpha();
    }

    @Nullable
    public final Bitmap getBitmap() {
        return this.f2345a;
    }

    public ColorFilter getColorFilter() {
        return this.f2348d.getColorFilter();
    }

    public float getCornerRadius() {
        return this.f2351g;
    }

    public int getGravity() {
        return this.f2347c;
    }

    public int getIntrinsicHeight() {
        return this.f2357m;
    }

    public int getIntrinsicWidth() {
        return this.f2356l;
    }

    public int getOpacity() {
        Bitmap bitmap;
        if (this.f2347c != 119 || this.f2355k || (bitmap = this.f2345a) == null || bitmap.hasAlpha() || this.f2348d.getAlpha() < 255 || m1582c(this.f2351g)) {
            return -3;
        }
        return -1;
    }

    @NonNull
    public final Paint getPaint() {
        return this.f2348d;
    }

    public boolean hasAntiAlias() {
        return this.f2348d.isAntiAlias();
    }

    public boolean hasMipMap() {
        throw new UnsupportedOperationException();
    }

    public boolean isCircular() {
        return this.f2355k;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.f2355k) {
            m1583d();
        }
        this.f2354j = true;
    }

    public void setAlpha(int i) {
        if (i != this.f2348d.getAlpha()) {
            this.f2348d.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setAntiAlias(boolean z) {
        this.f2348d.setAntiAlias(z);
        invalidateSelf();
    }

    public void setCircular(boolean z) {
        this.f2355k = z;
        this.f2354j = true;
        if (z) {
            m1583d();
            this.f2348d.setShader(this.f2349e);
            invalidateSelf();
            return;
        }
        setCornerRadius(0.0f);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2348d.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setCornerRadius(float f) {
        if (this.f2351g != f) {
            this.f2355k = false;
            if (m1582c(f)) {
                this.f2348d.setShader(this.f2349e);
            } else {
                this.f2348d.setShader((Shader) null);
            }
            this.f2351g = f;
            invalidateSelf();
        }
    }

    public void setDither(boolean z) {
        this.f2348d.setDither(z);
        invalidateSelf();
    }

    public void setFilterBitmap(boolean z) {
        this.f2348d.setFilterBitmap(z);
        invalidateSelf();
    }

    public void setGravity(int i) {
        if (this.f2347c != i) {
            this.f2347c = i;
            this.f2354j = true;
            invalidateSelf();
        }
    }

    public void setMipMap(boolean z) {
        throw new UnsupportedOperationException();
    }

    public void setTargetDensity(@NonNull Canvas canvas) {
        setTargetDensity(canvas.getDensity());
    }

    public void setTargetDensity(@NonNull DisplayMetrics displayMetrics) {
        setTargetDensity(displayMetrics.densityDpi);
    }

    public void setTargetDensity(int i) {
        if (this.f2346b != i) {
            if (i == 0) {
                i = 160;
            }
            this.f2346b = i;
            if (this.f2345a != null) {
                m1581a();
            }
            invalidateSelf();
        }
    }
}
