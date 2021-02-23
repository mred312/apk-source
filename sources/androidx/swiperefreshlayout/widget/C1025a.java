package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;

/* renamed from: androidx.swiperefreshlayout.widget.a */
/* compiled from: CircleImageView */
class C1025a extends ImageView {

    /* renamed from: a */
    private Animation.AnimationListener f4765a;

    /* renamed from: b */
    int f4766b;

    /* renamed from: androidx.swiperefreshlayout.widget.a$a */
    /* compiled from: CircleImageView */
    private class C1026a extends OvalShape {

        /* renamed from: a */
        private RadialGradient f4767a;

        /* renamed from: b */
        private Paint f4768b = new Paint();

        C1026a(int i) {
            C1025a.this.f4766b = i;
            m3731a((int) rect().width());
        }

        /* renamed from: a */
        private void m3731a(int i) {
            float f = (float) (i / 2);
            RadialGradient radialGradient = new RadialGradient(f, f, (float) C1025a.this.f4766b, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.f4767a = radialGradient;
            this.f4768b.setShader(radialGradient);
        }

        public void draw(Canvas canvas, Paint paint) {
            int width = C1025a.this.getWidth() / 2;
            float f = (float) width;
            float height = (float) (C1025a.this.getHeight() / 2);
            canvas.drawCircle(f, height, f, this.f4768b);
            canvas.drawCircle(f, height, (float) (width - C1025a.this.f4766b), paint);
        }

        /* access modifiers changed from: protected */
        public void onResize(float f, float f2) {
            super.onResize(f, f2);
            m3731a((int) f);
        }
    }

    C1025a(Context context, int i) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) (1.75f * f);
        int i3 = (int) (0.0f * f);
        this.f4766b = (int) (3.5f * f);
        if (m3729a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ViewCompat.setElevation(this, f * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new C1026a(this.f4766b));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer((float) this.f4766b, (float) i3, (float) i2, 503316480);
            int i4 = this.f4766b;
            setPadding(i4, i4, i4, i4);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i);
        ViewCompat.setBackground(this, shapeDrawable);
    }

    /* renamed from: a */
    private boolean m3729a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    /* renamed from: b */
    public void mo8203b(Animation.AnimationListener animationListener) {
        this.f4765a = animationListener;
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f4765a;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f4765a;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!m3729a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f4766b * 2), getMeasuredHeight() + (this.f4766b * 2));
        }
    }

    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }
}
