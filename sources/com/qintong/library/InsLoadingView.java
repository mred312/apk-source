package com.qintong.library;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.facebook.ads.AdError;

public class InsLoadingView extends ImageView {

    /* renamed from: r */
    private static String f20949r = "InsLoadingView";

    /* renamed from: s */
    private static boolean f20950s = false;

    /* renamed from: t */
    private static SparseArray<Status> f20951t;

    /* renamed from: a */
    private Status f20952a = Status.LOADING;

    /* renamed from: b */
    private int f20953b = 10000;

    /* renamed from: c */
    private int f20954c = AdError.SERVER_ERROR_CODE;

    /* renamed from: d */
    private float f20955d = 0.875f;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public float f20956e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public float f20957f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f20958g = true;

    /* renamed from: h */
    private ValueAnimator f20959h;

    /* renamed from: i */
    private ValueAnimator f20960i;

    /* renamed from: j */
    private ValueAnimator f20961j;

    /* renamed from: k */
    private int f20962k = Color.parseColor("#FFF700C2");

    /* renamed from: l */
    private int f20963l = Color.parseColor("#FFFFD900");
    /* access modifiers changed from: private */

    /* renamed from: m */
    public float f20964m = 1.0f;

    /* renamed from: n */
    private Paint f20965n;

    /* renamed from: o */
    private Paint f20966o;

    /* renamed from: p */
    private RectF f20967p;

    /* renamed from: q */
    private RectF f20968q;

    public enum Status {
        LOADING,
        CLICKED,
        UNCLICKED
    }

    /* renamed from: com.qintong.library.InsLoadingView$a */
    class C3792a implements ValueAnimator.AnimatorUpdateListener {
        C3792a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float unused = InsLoadingView.this.f20956e = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            InsLoadingView.this.postInvalidate();
        }
    }

    /* renamed from: com.qintong.library.InsLoadingView$b */
    class C3793b implements ValueAnimator.AnimatorUpdateListener {
        C3793b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (InsLoadingView.this.f20958g) {
                float unused = InsLoadingView.this.f20957f = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else {
                float unused2 = InsLoadingView.this.f20957f = ((Float) valueAnimator.getAnimatedValue()).floatValue() - 360.0f;
            }
            InsLoadingView.this.postInvalidate();
        }
    }

    /* renamed from: com.qintong.library.InsLoadingView$c */
    class C3794c implements Animator.AnimatorListener {
        C3794c() {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
            InsLoadingView insLoadingView = InsLoadingView.this;
            boolean unused = insLoadingView.f20958g = !insLoadingView.f20958g;
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    /* renamed from: com.qintong.library.InsLoadingView$d */
    class C3795d implements ValueAnimator.AnimatorUpdateListener {
        C3795d() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float unused = InsLoadingView.this.f20964m = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            InsLoadingView.this.postInvalidate();
        }
    }

    /* renamed from: com.qintong.library.InsLoadingView$e */
    static /* synthetic */ class C3796e {

        /* renamed from: a */
        static final /* synthetic */ int[] f20974a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.qintong.library.InsLoadingView$Status[] r0 = com.qintong.library.InsLoadingView.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20974a = r0
                com.qintong.library.InsLoadingView$Status r1 = com.qintong.library.InsLoadingView.Status.LOADING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20974a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.qintong.library.InsLoadingView$Status r1 = com.qintong.library.InsLoadingView.Status.UNCLICKED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20974a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.qintong.library.InsLoadingView$Status r1 = com.qintong.library.InsLoadingView.Status.CLICKED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qintong.library.InsLoadingView.C3796e.<clinit>():void");
        }
    }

    static {
        SparseArray<Status> sparseArray = new SparseArray<>(3);
        f20951t = sparseArray;
        sparseArray.put(0, Status.LOADING);
        f20951t.put(1, Status.CLICKED);
        f20951t.put(2, Status.UNCLICKED);
    }

    public InsLoadingView(Context context) {
        super(context);
        m14073n(context, (AttributeSet) null);
    }

    /* renamed from: f */
    private float m14065f() {
        return (float) (getWidth() / 2);
    }

    /* renamed from: g */
    private float m14066g() {
        return (float) (getHeight() / 2);
    }

    private Paint getTrackPaint() {
        Paint paint = new Paint();
        paint.setShader(new LinearGradient(0.0f, 0.0f, ((((float) getWidth()) * 0.9f) * 312.0f) / 360.0f, ((float) getHeight()) * 0.025f, this.f20962k, this.f20963l, Shader.TileMode.CLAMP));
        setPaintStroke(paint);
        return paint;
    }

    private Paint getmBitmapPaint() {
        Paint paint = new Paint();
        Drawable drawable = getDrawable();
        Matrix matrix = new Matrix();
        if (drawable == null) {
            return paint;
        }
        Bitmap l = m14071l(drawable);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(l, tileMode, tileMode);
        float width = (((float) getWidth()) * 1.0f) / ((float) Math.min(l.getWidth(), l.getHeight()));
        matrix.setScale(width, width);
        if (l.getWidth() > l.getHeight()) {
            matrix.postTranslate((-((((float) l.getWidth()) * width) - ((float) getWidth()))) / 2.0f, 0.0f);
        } else {
            matrix.postTranslate(0.0f, (-((((float) l.getHeight()) * width) - ((float) getHeight()))) / 2.0f);
        }
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        return paint;
    }

    /* renamed from: h */
    private void m14067h(Canvas canvas) {
        canvas.drawOval(this.f20967p, this.f20965n);
    }

    /* renamed from: i */
    private void m14068i(Canvas canvas, Paint paint) {
        canvas.drawOval(new RectF(((float) getWidth()) * 0.100000024f, ((float) getWidth()) * 0.100000024f, ((float) getWidth()) * 0.9f, ((float) getHeight()) * 0.9f), paint);
    }

    /* renamed from: j */
    private void m14069j(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(-3355444);
        setPaintStroke(paint);
        m14068i(canvas, paint);
    }

    /* renamed from: k */
    private void m14070k(Canvas canvas, Paint paint) {
        Canvas canvas2 = canvas;
        canvas.rotate(this.f20956e, m14065f(), m14066g());
        canvas.rotate(12.0f, m14065f(), m14066g());
        if (f20950s) {
            String str = f20949r;
            Log.d(str, "cricleWidth:" + this.f20957f);
        }
        float f = this.f20957f;
        float f2 = 8.0f;
        float f3 = 360.0f;
        if (f < 0.0f) {
            float f4 = f + 360.0f;
            canvas.drawArc(this.f20968q, f4, 360.0f - f4, false, paint);
            float f5 = this.f20957f + 360.0f;
            while (f5 > 12.0f) {
                f2 -= 0.2f;
                float f6 = f5 - 12.0f;
                canvas.drawArc(this.f20968q, f6, f2, false, paint);
                f5 = f6;
            }
            return;
        }
        for (int i = 0; i <= 4; i++) {
            float f7 = ((float) i) * 12.0f;
            float f8 = this.f20957f;
            if (f7 > f8) {
                break;
            }
            canvas.drawArc(this.f20968q, f8 - f7, (float) (i + 8), false, paint);
        }
        float f9 = this.f20957f;
        if (f9 > 48.0f) {
            canvas.drawArc(this.f20968q, 0.0f, f9 - 48.0f, false, paint);
        }
        float f10 = ((360.0f - this.f20957f) * 8.0f) / 360.0f;
        if (f20950s) {
            String str2 = f20949r;
            Log.d(str2, "width:" + f10);
        }
        while (f10 > 0.0f && f3 > 12.0f) {
            float f11 = f10 - 0.2f;
            f3 -= 12.0f;
            canvas.drawArc(this.f20968q, f3, f11, false, paint);
            f10 = f11;
        }
    }

    /* renamed from: l */
    private Bitmap m14071l(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    /* renamed from: m */
    private void m14072m() {
        this.f20959h.end();
        this.f20960i.end();
    }

    /* renamed from: n */
    private void m14073n(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            m14077r(context, attributeSet);
        }
        m14076q();
    }

    /* renamed from: o */
    private void m14074o() {
        if (this.f20965n == null) {
            this.f20965n = getmBitmapPaint();
        }
        if (this.f20966o == null) {
            this.f20966o = getTrackPaint();
        }
    }

    /* renamed from: p */
    private void m14075p() {
        if (this.f20967p == null) {
            this.f20967p = new RectF(((float) getWidth()) * (1.0f - this.f20955d), ((float) getWidth()) * (1.0f - this.f20955d), ((float) getWidth()) * this.f20955d, ((float) getHeight()) * this.f20955d);
        }
        if (this.f20968q == null) {
            this.f20968q = new RectF(((float) getWidth()) * 0.100000024f, ((float) getWidth()) * 0.100000024f, ((float) getWidth()) * 0.9f, ((float) getHeight()) * 0.9f);
        }
    }

    /* renamed from: q */
    private void m14076q() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 180.0f, 360.0f});
        this.f20959h = ofFloat;
        ofFloat.addUpdateListener(new C3792a());
        this.f20959h.setInterpolator(new LinearInterpolator());
        this.f20959h.setDuration((long) this.f20953b);
        this.f20959h.setRepeatCount(-1);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 360.0f});
        this.f20960i = ofFloat2;
        ofFloat2.setInterpolator(new DecelerateInterpolator());
        this.f20960i.setDuration((long) this.f20954c);
        this.f20960i.setRepeatCount(-1);
        this.f20960i.addUpdateListener(new C3793b());
        this.f20960i.addListener(new C3794c());
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f20961j = valueAnimator;
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        this.f20961j.setDuration(200);
        this.f20961j.addUpdateListener(new C3795d());
        m14078s();
    }

    /* renamed from: r */
    private void m14077r(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3797R.styleable.InsLoadingViewAttr);
        int i = C3797R.styleable.InsLoadingViewAttr_start_color;
        int color = obtainStyledAttributes.getColor(i, this.f20962k);
        int color2 = obtainStyledAttributes.getColor(i, this.f20963l);
        int i2 = obtainStyledAttributes.getInt(C3797R.styleable.InsLoadingViewAttr_circle_duration, this.f20954c);
        int i3 = obtainStyledAttributes.getInt(C3797R.styleable.InsLoadingViewAttr_rotate_duration, this.f20953b);
        int i4 = obtainStyledAttributes.getInt(C3797R.styleable.InsLoadingViewAttr_status, 0);
        if (f20950s) {
            String str = f20949r;
            Log.d(str, "praseAttrs start_color: " + color);
            String str2 = f20949r;
            Log.d(str2, "praseAttrs end_color: " + color2);
            String str3 = f20949r;
            Log.d(str3, "praseAttrs rotate_duration: " + i3);
            String str4 = f20949r;
            Log.d(str4, "praseAttrs circle_duration: " + i2);
            String str5 = f20949r;
            Log.d(str5, "praseAttrs status: " + i4);
        }
        if (i2 != this.f20954c) {
            setCircleDuration(i2);
        }
        if (i3 != this.f20953b) {
            setRotateDuration(i3);
        }
        setStartColor(color);
        setEndColor(color2);
        setStatus(f20951t.get(i4));
    }

    /* renamed from: s */
    private void m14078s() {
        this.f20959h.start();
        this.f20960i.start();
    }

    private void setPaintStroke(Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(((float) getHeight()) * 0.025f);
    }

    /* renamed from: t */
    private void m14079t() {
        this.f20961j.setFloatValues(new float[]{this.f20964m, 0.9f});
        this.f20961j.start();
    }

    /* renamed from: u */
    private void m14080u() {
        this.f20961j.setFloatValues(new float[]{this.f20964m, 1.0f});
        this.f20961j.start();
    }

    public Status getStatus() {
        return this.f20952a;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        m14074o();
        m14075p();
        float f = this.f20964m;
        canvas.scale(f, f, m14065f(), m14066g());
        m14067h(canvas);
        int i = C3796e.f20974a[this.f20952a.ordinal()];
        if (i == 1) {
            m14070k(canvas, this.f20966o);
        } else if (i == 2) {
            m14068i(canvas, this.f20966o);
        } else if (i == 3) {
            m14069j(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (f20950s) {
            Log.d(f20949r, String.format("onMeasure widthMeasureSpec: %s -- %s", new Object[]{Integer.valueOf(mode), Integer.valueOf(size)}));
            Log.d(f20949r, String.format("onMeasure heightMeasureSpec: %s -- %s", new Object[]{Integer.valueOf(mode2), Integer.valueOf(size2)}));
        }
        if (mode == 1073741824 && mode2 == 1073741824) {
            i3 = Math.min(size, size2);
        } else {
            i3 = Math.min(Math.min(size, size2), 300);
        }
        setMeasuredDimension(i3, i3);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (f20950s) {
            Log.d(f20949r, "onSizeChanged");
        }
        this.f20967p = null;
        this.f20968q = null;
        this.f20965n = null;
        this.f20966o = null;
        super.onSizeChanged(i, i2, i3, i4);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (f20950s) {
            String str = f20949r;
            Log.d(str, "onTouchEvent: " + motionEvent.getAction());
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                m14080u();
            } else if (action == 3) {
                m14080u();
            }
            z = false;
        } else {
            m14079t();
            z = true;
        }
        if (super.onTouchEvent(motionEvent) || z) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        if (f20950s) {
            Log.d(f20949r, "onVisibilityChanged");
        }
        if (i == 0) {
            m14078s();
        } else {
            m14072m();
        }
        super.onVisibilityChanged(view, i);
    }

    public InsLoadingView setCircleDuration(int i) {
        this.f20954c = i;
        this.f20960i.setDuration((long) i);
        return this;
    }

    public void setEndColor(int i) {
        this.f20963l = i;
        this.f20966o = null;
    }

    public void setImageDrawable(Drawable drawable) {
        if (f20950s) {
            Log.d(f20949r, "setImageDrawable");
        }
        this.f20965n = null;
        super.setImageDrawable(drawable);
    }

    public InsLoadingView setRotateDuration(int i) {
        this.f20953b = i;
        this.f20959h.setDuration((long) i);
        return this;
    }

    public void setStartColor(int i) {
        this.f20962k = i;
        this.f20966o = null;
    }

    public void setStatus(Status status) {
        this.f20952a = status;
    }

    public InsLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14073n(context, attributeSet);
    }

    public InsLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14073n(context, attributeSet);
    }
}
