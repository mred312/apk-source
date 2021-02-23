package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0131R;
import androidx.core.graphics.drawable.DrawableCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class DrawerArrowDrawable extends Drawable {
    public static final int ARROW_DIRECTION_END = 3;
    public static final int ARROW_DIRECTION_LEFT = 0;
    public static final int ARROW_DIRECTION_RIGHT = 1;
    public static final int ARROW_DIRECTION_START = 2;

    /* renamed from: m */
    private static final float f661m = ((float) Math.toRadians(45.0d));

    /* renamed from: a */
    private final Paint f662a;

    /* renamed from: b */
    private float f663b;

    /* renamed from: c */
    private float f664c;

    /* renamed from: d */
    private float f665d;

    /* renamed from: e */
    private float f666e;

    /* renamed from: f */
    private boolean f667f;

    /* renamed from: g */
    private final Path f668g = new Path();

    /* renamed from: h */
    private final int f669h;

    /* renamed from: i */
    private boolean f670i = false;

    /* renamed from: j */
    private float f671j;

    /* renamed from: k */
    private float f672k;

    /* renamed from: l */
    private int f673l = 2;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ArrowDirection {
    }

    public DrawerArrowDrawable(Context context) {
        Paint paint = new Paint();
        this.f662a = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet) null, C0131R.styleable.DrawerArrowToggle, C0131R.attr.drawerArrowStyle, C0131R.style.Base_Widget_AppCompat_DrawerArrowToggle);
        setColor(obtainStyledAttributes.getColor(C0131R.styleable.DrawerArrowToggle_color, 0));
        setBarThickness(obtainStyledAttributes.getDimension(C0131R.styleable.DrawerArrowToggle_thickness, 0.0f));
        setSpinEnabled(obtainStyledAttributes.getBoolean(C0131R.styleable.DrawerArrowToggle_spinBars, true));
        setGapSize((float) Math.round(obtainStyledAttributes.getDimension(C0131R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0f)));
        this.f669h = obtainStyledAttributes.getDimensionPixelSize(C0131R.styleable.DrawerArrowToggle_drawableSize, 0);
        this.f664c = (float) Math.round(obtainStyledAttributes.getDimension(C0131R.styleable.DrawerArrowToggle_barLength, 0.0f));
        this.f663b = (float) Math.round(obtainStyledAttributes.getDimension(C0131R.styleable.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.f665d = obtainStyledAttributes.getDimension(C0131R.styleable.DrawerArrowToggle_arrowShaftLength, 0.0f);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private static float m575a(float f, float f2, float f3) {
        return f + ((f2 - f) * f3);
    }

    public void draw(Canvas canvas) {
        Canvas canvas2 = canvas;
        Rect bounds = getBounds();
        int i = this.f673l;
        boolean z = false;
        if (i != 0 && (i == 1 || (i == 3 ? DrawableCompat.getLayoutDirection(this) == 0 : DrawableCompat.getLayoutDirection(this) == 1))) {
            z = true;
        }
        float f = this.f663b;
        float a = m575a(this.f664c, (float) Math.sqrt((double) (f * f * 2.0f)), this.f671j);
        float a2 = m575a(this.f664c, this.f665d, this.f671j);
        float round = (float) Math.round(m575a(0.0f, this.f672k, this.f671j));
        float a3 = m575a(0.0f, f661m, this.f671j);
        double d = (double) a;
        float a4 = m575a(z ? 0.0f : -180.0f, z ? 180.0f : 0.0f, this.f671j);
        double d2 = (double) a3;
        double cos = Math.cos(d2);
        Double.isNaN(d);
        boolean z2 = z;
        float round2 = (float) Math.round(cos * d);
        double sin = Math.sin(d2);
        Double.isNaN(d);
        float round3 = (float) Math.round(d * sin);
        this.f668g.rewind();
        float a5 = m575a(this.f666e + this.f662a.getStrokeWidth(), -this.f672k, this.f671j);
        float f2 = (-a2) / 2.0f;
        this.f668g.moveTo(f2 + round, 0.0f);
        this.f668g.rLineTo(a2 - (round * 2.0f), 0.0f);
        this.f668g.moveTo(f2, a5);
        this.f668g.rLineTo(round2, round3);
        this.f668g.moveTo(f2, -a5);
        this.f668g.rLineTo(round2, -round3);
        this.f668g.close();
        canvas.save();
        float strokeWidth = this.f662a.getStrokeWidth();
        float height = ((float) bounds.height()) - (3.0f * strokeWidth);
        float f3 = this.f666e;
        canvas2.translate((float) bounds.centerX(), ((float) ((((int) (height - (2.0f * f3))) / 4) * 2)) + (strokeWidth * 1.5f) + f3);
        if (this.f667f) {
            canvas2.rotate(a4 * ((float) (this.f670i ^ z2 ? -1 : 1)));
        } else if (z2) {
            canvas2.rotate(180.0f);
        }
        canvas2.drawPath(this.f668g, this.f662a);
        canvas.restore();
    }

    public float getArrowHeadLength() {
        return this.f663b;
    }

    public float getArrowShaftLength() {
        return this.f665d;
    }

    public float getBarLength() {
        return this.f664c;
    }

    public float getBarThickness() {
        return this.f662a.getStrokeWidth();
    }

    @ColorInt
    public int getColor() {
        return this.f662a.getColor();
    }

    public int getDirection() {
        return this.f673l;
    }

    public float getGapSize() {
        return this.f666e;
    }

    public int getIntrinsicHeight() {
        return this.f669h;
    }

    public int getIntrinsicWidth() {
        return this.f669h;
    }

    public int getOpacity() {
        return -3;
    }

    public final Paint getPaint() {
        return this.f662a;
    }

    @FloatRange(from = 0.0d, mo761to = 1.0d)
    public float getProgress() {
        return this.f671j;
    }

    public boolean isSpinEnabled() {
        return this.f667f;
    }

    public void setAlpha(int i) {
        if (i != this.f662a.getAlpha()) {
            this.f662a.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setArrowHeadLength(float f) {
        if (this.f663b != f) {
            this.f663b = f;
            invalidateSelf();
        }
    }

    public void setArrowShaftLength(float f) {
        if (this.f665d != f) {
            this.f665d = f;
            invalidateSelf();
        }
    }

    public void setBarLength(float f) {
        if (this.f664c != f) {
            this.f664c = f;
            invalidateSelf();
        }
    }

    public void setBarThickness(float f) {
        if (this.f662a.getStrokeWidth() != f) {
            this.f662a.setStrokeWidth(f);
            double d = (double) (f / 2.0f);
            double cos = Math.cos((double) f661m);
            Double.isNaN(d);
            this.f672k = (float) (d * cos);
            invalidateSelf();
        }
    }

    public void setColor(@ColorInt int i) {
        if (i != this.f662a.getColor()) {
            this.f662a.setColor(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f662a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setDirection(int i) {
        if (i != this.f673l) {
            this.f673l = i;
            invalidateSelf();
        }
    }

    public void setGapSize(float f) {
        if (f != this.f666e) {
            this.f666e = f;
            invalidateSelf();
        }
    }

    public void setProgress(@FloatRange(from = 0.0d, mo761to = 1.0d) float f) {
        if (this.f671j != f) {
            this.f671j = f;
            invalidateSelf();
        }
    }

    public void setSpinEnabled(boolean z) {
        if (this.f667f != z) {
            this.f667f = z;
            invalidateSelf();
        }
    }

    public void setVerticalMirror(boolean z) {
        if (this.f670i != z) {
            this.f670i = z;
            invalidateSelf();
        }
    }
}
