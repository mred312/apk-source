package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CircularProgressDrawable extends Drawable implements Animatable {
    public static final int DEFAULT = 1;
    public static final int LARGE = 0;

    /* renamed from: g */
    private static final Interpolator f4681g = new LinearInterpolator();

    /* renamed from: h */
    private static final Interpolator f4682h = new FastOutSlowInInterpolator();

    /* renamed from: i */
    private static final int[] f4683i = {-16777216};

    /* renamed from: a */
    private final C1016c f4684a;

    /* renamed from: b */
    private float f4685b;

    /* renamed from: c */
    private Resources f4686c;

    /* renamed from: d */
    private Animator f4687d;

    /* renamed from: e */
    float f4688e;

    /* renamed from: f */
    boolean f4689f;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ProgressDrawableSize {
    }

    /* renamed from: androidx.swiperefreshlayout.widget.CircularProgressDrawable$a */
    class C1014a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ C1016c f4690a;

        C1014a(C1016c cVar) {
            this.f4690a = cVar;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            CircularProgressDrawable.this.mo8082g(floatValue, this.f4690a);
            CircularProgressDrawable.this.mo8080b(floatValue, this.f4690a, false);
            CircularProgressDrawable.this.invalidateSelf();
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.CircularProgressDrawable$b */
    class C1015b implements Animator.AnimatorListener {

        /* renamed from: a */
        final /* synthetic */ C1016c f4692a;

        C1015b(C1016c cVar) {
            this.f4692a = cVar;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
            CircularProgressDrawable.this.mo8080b(1.0f, this.f4692a, true);
            this.f4692a.mo8130M();
            this.f4692a.mo8152v();
            CircularProgressDrawable circularProgressDrawable = CircularProgressDrawable.this;
            if (circularProgressDrawable.f4689f) {
                circularProgressDrawable.f4689f = false;
                animator.cancel();
                animator.setDuration(1332);
                animator.start();
                this.f4692a.mo8126I(false);
                return;
            }
            circularProgressDrawable.f4688e += 1.0f;
        }

        public void onAnimationStart(Animator animator) {
            CircularProgressDrawable.this.f4688e = 0.0f;
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.CircularProgressDrawable$c */
    private static class C1016c {

        /* renamed from: a */
        final RectF f4694a = new RectF();

        /* renamed from: b */
        final Paint f4695b;

        /* renamed from: c */
        final Paint f4696c;

        /* renamed from: d */
        final Paint f4697d;

        /* renamed from: e */
        float f4698e;

        /* renamed from: f */
        float f4699f;

        /* renamed from: g */
        float f4700g;

        /* renamed from: h */
        float f4701h;

        /* renamed from: i */
        int[] f4702i;

        /* renamed from: j */
        int f4703j;

        /* renamed from: k */
        float f4704k;

        /* renamed from: l */
        float f4705l;

        /* renamed from: m */
        float f4706m;

        /* renamed from: n */
        boolean f4707n;

        /* renamed from: o */
        Path f4708o;

        /* renamed from: p */
        float f4709p;

        /* renamed from: q */
        float f4710q;

        /* renamed from: r */
        int f4711r;

        /* renamed from: s */
        int f4712s;

        /* renamed from: t */
        int f4713t;

        /* renamed from: u */
        int f4714u;

        C1016c() {
            Paint paint = new Paint();
            this.f4695b = paint;
            Paint paint2 = new Paint();
            this.f4696c = paint2;
            Paint paint3 = new Paint();
            this.f4697d = paint3;
            this.f4698e = 0.0f;
            this.f4699f = 0.0f;
            this.f4700g = 0.0f;
            this.f4701h = 5.0f;
            this.f4709p = 1.0f;
            this.f4713t = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: A */
        public void mo8118A(int i) {
            this.f4697d.setColor(i);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: B */
        public void mo8119B(float f) {
            this.f4710q = f;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: C */
        public void mo8120C(int i) {
            this.f4714u = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: D */
        public void mo8121D(ColorFilter colorFilter) {
            this.f4695b.setColorFilter(colorFilter);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: E */
        public void mo8122E(int i) {
            this.f4703j = i;
            this.f4714u = this.f4702i[i];
        }

        /* access modifiers changed from: package-private */
        /* renamed from: F */
        public void mo8123F(@NonNull int[] iArr) {
            this.f4702i = iArr;
            mo8122E(0);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: G */
        public void mo8124G(float f) {
            this.f4699f = f;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: H */
        public void mo8125H(float f) {
            this.f4700g = f;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: I */
        public void mo8126I(boolean z) {
            if (this.f4707n != z) {
                this.f4707n = z;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: J */
        public void mo8127J(float f) {
            this.f4698e = f;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: K */
        public void mo8128K(Paint.Cap cap) {
            this.f4695b.setStrokeCap(cap);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: L */
        public void mo8129L(float f) {
            this.f4701h = f;
            this.f4695b.setStrokeWidth(f);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: M */
        public void mo8130M() {
            this.f4704k = this.f4698e;
            this.f4705l = this.f4699f;
            this.f4706m = this.f4700g;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo8131a(Canvas canvas, Rect rect) {
            RectF rectF = this.f4694a;
            float f = this.f4710q;
            float f2 = (this.f4701h / 2.0f) + f;
            if (f <= 0.0f) {
                f2 = (((float) Math.min(rect.width(), rect.height())) / 2.0f) - Math.max((((float) this.f4711r) * this.f4709p) / 2.0f, this.f4701h / 2.0f);
            }
            rectF.set(((float) rect.centerX()) - f2, ((float) rect.centerY()) - f2, ((float) rect.centerX()) + f2, ((float) rect.centerY()) + f2);
            float f3 = this.f4698e;
            float f4 = this.f4700g;
            float f5 = (f3 + f4) * 360.0f;
            float f6 = ((this.f4699f + f4) * 360.0f) - f5;
            this.f4695b.setColor(this.f4714u);
            this.f4695b.setAlpha(this.f4713t);
            float f7 = this.f4701h / 2.0f;
            rectF.inset(f7, f7);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f4697d);
            float f8 = -f7;
            rectF.inset(f8, f8);
            canvas.drawArc(rectF, f5, f6, false, this.f4695b);
            mo8132b(canvas, f5, f6, rectF);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo8132b(Canvas canvas, float f, float f2, RectF rectF) {
            if (this.f4707n) {
                Path path = this.f4708o;
                if (path == null) {
                    Path path2 = new Path();
                    this.f4708o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                this.f4708o.moveTo(0.0f, 0.0f);
                this.f4708o.lineTo(((float) this.f4711r) * this.f4709p, 0.0f);
                Path path3 = this.f4708o;
                float f3 = this.f4709p;
                path3.lineTo((((float) this.f4711r) * f3) / 2.0f, ((float) this.f4712s) * f3);
                this.f4708o.offset(((Math.min(rectF.width(), rectF.height()) / 2.0f) + rectF.centerX()) - ((((float) this.f4711r) * this.f4709p) / 2.0f), rectF.centerY() + (this.f4701h / 2.0f));
                this.f4708o.close();
                this.f4696c.setColor(this.f4714u);
                this.f4696c.setAlpha(this.f4713t);
                canvas.save();
                canvas.rotate(f + f2, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.f4708o, this.f4696c);
                canvas.restore();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public int mo8133c() {
            return this.f4713t;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public float mo8134d() {
            return (float) this.f4712s;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public float mo8135e() {
            return this.f4709p;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public float mo8136f() {
            return (float) this.f4711r;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public int mo8137g() {
            return this.f4697d.getColor();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public float mo8138h() {
            return this.f4710q;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public int[] mo8139i() {
            return this.f4702i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public float mo8140j() {
            return this.f4699f;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public int mo8141k() {
            return this.f4702i[mo8142l()];
        }

        /* access modifiers changed from: package-private */
        /* renamed from: l */
        public int mo8142l() {
            return (this.f4703j + 1) % this.f4702i.length;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: m */
        public float mo8143m() {
            return this.f4700g;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: n */
        public boolean mo8144n() {
            return this.f4707n;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o */
        public float mo8145o() {
            return this.f4698e;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: p */
        public int mo8146p() {
            return this.f4702i[this.f4703j];
        }

        /* access modifiers changed from: package-private */
        /* renamed from: q */
        public float mo8147q() {
            return this.f4705l;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: r */
        public float mo8148r() {
            return this.f4706m;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: s */
        public float mo8149s() {
            return this.f4704k;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: t */
        public Paint.Cap mo8150t() {
            return this.f4695b.getStrokeCap();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: u */
        public float mo8151u() {
            return this.f4701h;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: v */
        public void mo8152v() {
            mo8122E(mo8142l());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: w */
        public void mo8153w() {
            this.f4704k = 0.0f;
            this.f4705l = 0.0f;
            this.f4706m = 0.0f;
            mo8127J(0.0f);
            mo8124G(0.0f);
            mo8125H(0.0f);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: x */
        public void mo8154x(int i) {
            this.f4713t = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: y */
        public void mo8155y(float f, float f2) {
            this.f4711r = (int) f;
            this.f4712s = (int) f2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: z */
        public void mo8156z(float f) {
            if (f != this.f4709p) {
                this.f4709p = f;
            }
        }
    }

    public CircularProgressDrawable(@NonNull Context context) {
        this.f4686c = ((Context) Preconditions.checkNotNull(context)).getResources();
        C1016c cVar = new C1016c();
        this.f4684a = cVar;
        cVar.mo8123F(f4683i);
        setStrokeWidth(2.5f);
        m3669f();
    }

    /* renamed from: a */
    private void m3665a(float f, C1016c cVar) {
        mo8082g(f, cVar);
        cVar.mo8127J(cVar.mo8149s() + (((cVar.mo8147q() - 0.01f) - cVar.mo8149s()) * f));
        cVar.mo8124G(cVar.mo8147q());
        cVar.mo8125H(cVar.mo8148r() + ((((float) (Math.floor((double) (cVar.mo8148r() / 0.8f)) + 1.0d)) - cVar.mo8148r()) * f));
    }

    /* renamed from: c */
    private int m3666c(float f, int i, int i2) {
        int i3 = (i >> 24) & 255;
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = i & 255;
        return ((i3 + ((int) (((float) (((i2 >> 24) & 255) - i3)) * f))) << 24) | ((i4 + ((int) (((float) (((i2 >> 16) & 255) - i4)) * f))) << 16) | ((i5 + ((int) (((float) (((i2 >> 8) & 255) - i5)) * f))) << 8) | (i6 + ((int) (f * ((float) ((i2 & 255) - i6)))));
    }

    /* renamed from: d */
    private void m3667d(float f) {
        this.f4685b = f;
    }

    /* renamed from: e */
    private void m3668e(float f, float f2, float f3, float f4) {
        C1016c cVar = this.f4684a;
        float f5 = this.f4686c.getDisplayMetrics().density;
        cVar.mo8129L(f2 * f5);
        cVar.mo8119B(f * f5);
        cVar.mo8122E(0);
        cVar.mo8155y(f3 * f5, f4 * f5);
    }

    /* renamed from: f */
    private void m3669f() {
        C1016c cVar = this.f4684a;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new C1014a(cVar));
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f4681g);
        ofFloat.addListener(new C1015b(cVar));
        this.f4687d = ofFloat;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo8080b(float f, C1016c cVar, boolean z) {
        float f2;
        float f3;
        if (this.f4689f) {
            m3665a(f, cVar);
        } else if (f != 1.0f || z) {
            float r = cVar.mo8148r();
            if (f < 0.5f) {
                f2 = cVar.mo8149s();
                f3 = (f4682h.getInterpolation(f / 0.5f) * 0.79f) + 0.01f + f2;
            } else {
                float s = cVar.mo8149s() + 0.79f;
                float f4 = s;
                f2 = s - (((1.0f - f4682h.getInterpolation((f - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f3 = f4;
            }
            cVar.mo8127J(f2);
            cVar.mo8124G(f3);
            cVar.mo8125H(r + (0.20999998f * f));
            m3667d((f + this.f4688e) * 216.0f);
        }
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f4685b, bounds.exactCenterX(), bounds.exactCenterY());
        this.f4684a.mo8131a(canvas, bounds);
        canvas.restore();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo8082g(float f, C1016c cVar) {
        if (f > 0.75f) {
            cVar.mo8120C(m3666c((f - 0.75f) / 0.25f, cVar.mo8146p(), cVar.mo8141k()));
        } else {
            cVar.mo8120C(cVar.mo8146p());
        }
    }

    public int getAlpha() {
        return this.f4684a.mo8133c();
    }

    public boolean getArrowEnabled() {
        return this.f4684a.mo8144n();
    }

    public float getArrowHeight() {
        return this.f4684a.mo8134d();
    }

    public float getArrowScale() {
        return this.f4684a.mo8135e();
    }

    public float getArrowWidth() {
        return this.f4684a.mo8136f();
    }

    public int getBackgroundColor() {
        return this.f4684a.mo8137g();
    }

    public float getCenterRadius() {
        return this.f4684a.mo8138h();
    }

    @NonNull
    public int[] getColorSchemeColors() {
        return this.f4684a.mo8139i();
    }

    public float getEndTrim() {
        return this.f4684a.mo8140j();
    }

    public int getOpacity() {
        return -3;
    }

    public float getProgressRotation() {
        return this.f4684a.mo8143m();
    }

    public float getStartTrim() {
        return this.f4684a.mo8145o();
    }

    @NonNull
    public Paint.Cap getStrokeCap() {
        return this.f4684a.mo8150t();
    }

    public float getStrokeWidth() {
        return this.f4684a.mo8151u();
    }

    public boolean isRunning() {
        return this.f4687d.isRunning();
    }

    public void setAlpha(int i) {
        this.f4684a.mo8154x(i);
        invalidateSelf();
    }

    public void setArrowDimensions(float f, float f2) {
        this.f4684a.mo8155y(f, f2);
        invalidateSelf();
    }

    public void setArrowEnabled(boolean z) {
        this.f4684a.mo8126I(z);
        invalidateSelf();
    }

    public void setArrowScale(float f) {
        this.f4684a.mo8156z(f);
        invalidateSelf();
    }

    public void setBackgroundColor(int i) {
        this.f4684a.mo8118A(i);
        invalidateSelf();
    }

    public void setCenterRadius(float f) {
        this.f4684a.mo8119B(f);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f4684a.mo8121D(colorFilter);
        invalidateSelf();
    }

    public void setColorSchemeColors(@NonNull int... iArr) {
        this.f4684a.mo8123F(iArr);
        this.f4684a.mo8122E(0);
        invalidateSelf();
    }

    public void setProgressRotation(float f) {
        this.f4684a.mo8125H(f);
        invalidateSelf();
    }

    public void setStartEndTrim(float f, float f2) {
        this.f4684a.mo8127J(f);
        this.f4684a.mo8124G(f2);
        invalidateSelf();
    }

    public void setStrokeCap(@NonNull Paint.Cap cap) {
        this.f4684a.mo8128K(cap);
        invalidateSelf();
    }

    public void setStrokeWidth(float f) {
        this.f4684a.mo8129L(f);
        invalidateSelf();
    }

    public void setStyle(int i) {
        if (i == 0) {
            m3668e(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            m3668e(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    public void start() {
        this.f4687d.cancel();
        this.f4684a.mo8130M();
        if (this.f4684a.mo8140j() != this.f4684a.mo8145o()) {
            this.f4689f = true;
            this.f4687d.setDuration(666);
            this.f4687d.start();
            return;
        }
        this.f4684a.mo8122E(0);
        this.f4684a.mo8153w();
        this.f4687d.setDuration(1332);
        this.f4687d.start();
    }

    public void stop() {
        this.f4687d.cancel();
        m3667d(0.0f);
        this.f4684a.mo8126I(false);
        this.f4684a.mo8122E(0);
        this.f4684a.mo8153w();
        invalidateSelf();
    }
}
