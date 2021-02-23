package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;

public class PagerTabStrip extends PagerTitleStrip {

    /* renamed from: A */
    private boolean f4897A;

    /* renamed from: B */
    private int f4898B;

    /* renamed from: C */
    private boolean f4899C;

    /* renamed from: D */
    private float f4900D;

    /* renamed from: E */
    private float f4901E;

    /* renamed from: F */
    private int f4902F;

    /* renamed from: q */
    private int f4903q;

    /* renamed from: r */
    private int f4904r;

    /* renamed from: s */
    private int f4905s;

    /* renamed from: t */
    private int f4906t;

    /* renamed from: u */
    private int f4907u;

    /* renamed from: v */
    private int f4908v;

    /* renamed from: w */
    private final Paint f4909w;

    /* renamed from: x */
    private final Rect f4910x;

    /* renamed from: y */
    private int f4911y;

    /* renamed from: z */
    private boolean f4912z;

    /* renamed from: androidx.viewpager.widget.PagerTabStrip$a */
    class C1060a implements View.OnClickListener {
        C1060a() {
        }

        public void onClick(View view) {
            ViewPager viewPager = PagerTabStrip.this.f4917a;
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    /* renamed from: androidx.viewpager.widget.PagerTabStrip$b */
    class C1061b implements View.OnClickListener {
        C1061b() {
        }

        public void onClick(View view) {
            ViewPager viewPager = PagerTabStrip.this.f4917a;
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    }

    public PagerTabStrip(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo8506c(int i, float f, boolean z) {
        Rect rect = this.f4910x;
        int height = getHeight();
        int left = this.f4919c.getLeft() - this.f4908v;
        int right = this.f4919c.getRight() + this.f4908v;
        int i2 = height - this.f4904r;
        rect.set(left, i2, right, height);
        super.mo8506c(i, f, z);
        this.f4911y = (int) (Math.abs(f - 0.5f) * 2.0f * 255.0f);
        rect.union(this.f4919c.getLeft() - this.f4908v, i2, this.f4919c.getRight() + this.f4908v, height);
        invalidate(rect);
    }

    public boolean getDrawFullUnderline() {
        return this.f4912z;
    }

    /* access modifiers changed from: package-private */
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.f4907u);
    }

    @ColorInt
    public int getTabIndicatorColor() {
        return this.f4903q;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.f4919c.getLeft() - this.f4908v;
        int right = this.f4919c.getRight() + this.f4908v;
        this.f4909w.setColor((this.f4911y << 24) | (this.f4903q & ViewCompat.MEASURED_SIZE_MASK));
        float f = (float) height;
        canvas.drawRect((float) left, (float) (height - this.f4904r), (float) right, f, this.f4909w);
        if (this.f4912z) {
            this.f4909w.setColor(-16777216 | (this.f4903q & ViewCompat.MEASURED_SIZE_MASK));
            canvas.drawRect((float) getPaddingLeft(), (float) (height - this.f4898B), (float) (getWidth() - getPaddingRight()), f, this.f4909w);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.f4899C) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (action == 0) {
            this.f4900D = x;
            this.f4901E = y;
            this.f4899C = false;
        } else if (action != 1) {
            if (action == 2 && (Math.abs(x - this.f4900D) > ((float) this.f4902F) || Math.abs(y - this.f4901E) > ((float) this.f4902F))) {
                this.f4899C = true;
            }
        } else if (x < ((float) (this.f4919c.getLeft() - this.f4908v))) {
            ViewPager viewPager = this.f4917a;
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        } else if (x > ((float) (this.f4919c.getRight() + this.f4908v))) {
            ViewPager viewPager2 = this.f4917a;
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
        return true;
    }

    public void setBackgroundColor(@ColorInt int i) {
        super.setBackgroundColor(i);
        if (!this.f4897A) {
            this.f4912z = (i & ViewCompat.MEASURED_STATE_MASK) == 0;
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (!this.f4897A) {
            this.f4912z = drawable == null;
        }
    }

    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        if (!this.f4897A) {
            this.f4912z = i == 0;
        }
    }

    public void setDrawFullUnderline(boolean z) {
        this.f4912z = z;
        this.f4897A = true;
        invalidate();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        int i5 = this.f4905s;
        if (i4 < i5) {
            i4 = i5;
        }
        super.setPadding(i, i2, i3, i4);
    }

    public void setTabIndicatorColor(@ColorInt int i) {
        this.f4903q = i;
        this.f4909w.setColor(i);
        invalidate();
    }

    public void setTabIndicatorColorResource(@ColorRes int i) {
        setTabIndicatorColor(ContextCompat.getColor(getContext(), i));
    }

    public void setTextSpacing(int i) {
        int i2 = this.f4906t;
        if (i < i2) {
            i = i2;
        }
        super.setTextSpacing(i);
    }

    public PagerTabStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f4909w = paint;
        this.f4910x = new Rect();
        this.f4911y = 255;
        this.f4912z = false;
        this.f4897A = false;
        int i = this.f4930n;
        this.f4903q = i;
        paint.setColor(i);
        float f = context.getResources().getDisplayMetrics().density;
        this.f4904r = (int) ((3.0f * f) + 0.5f);
        this.f4905s = (int) ((6.0f * f) + 0.5f);
        this.f4906t = (int) (64.0f * f);
        this.f4908v = (int) ((16.0f * f) + 0.5f);
        this.f4898B = (int) ((1.0f * f) + 0.5f);
        this.f4907u = (int) ((f * 32.0f) + 0.5f);
        this.f4902F = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.f4918b.setFocusable(true);
        this.f4918b.setOnClickListener(new C1060a());
        this.f4920d.setFocusable(true);
        this.f4920d.setOnClickListener(new C1061b());
        if (getBackground() == null) {
            this.f4912z = true;
        }
    }
}
