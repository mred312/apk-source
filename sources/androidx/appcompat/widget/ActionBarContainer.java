package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0131R;
import androidx.core.view.ViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a */
    private boolean f1033a;

    /* renamed from: b */
    private View f1034b;

    /* renamed from: c */
    private View f1035c;

    /* renamed from: d */
    private View f1036d;

    /* renamed from: e */
    Drawable f1037e;

    /* renamed from: f */
    Drawable f1038f;

    /* renamed from: g */
    Drawable f1039g;

    /* renamed from: h */
    boolean f1040h;

    /* renamed from: i */
    boolean f1041i;

    /* renamed from: j */
    private int f1042j;

    public ActionBarContainer(Context context) {
        this(context, (AttributeSet) null);
    }

    /* renamed from: a */
    private int m730a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    /* renamed from: b */
    private boolean m731b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f1037e;
        if (drawable != null && drawable.isStateful()) {
            this.f1037e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f1038f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f1038f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f1039g;
        if (drawable3 != null && drawable3.isStateful()) {
            this.f1039g.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.f1034b;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1037e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1038f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f1039g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1035c = findViewById(C0131R.C0133id.action_bar);
        this.f1036d = findViewById(C0131R.C0133id.action_context_bar);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1033a || super.onInterceptTouchEvent(motionEvent);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Drawable drawable;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f1034b;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            int i5 = ((FrameLayout.LayoutParams) view.getLayoutParams()).bottomMargin;
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - i5, i3, measuredHeight - i5);
        }
        if (this.f1040h) {
            Drawable drawable2 = this.f1039g;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.f1037e != null) {
                if (this.f1035c.getVisibility() == 0) {
                    this.f1037e.setBounds(this.f1035c.getLeft(), this.f1035c.getTop(), this.f1035c.getRight(), this.f1035c.getBottom());
                } else {
                    View view2 = this.f1036d;
                    if (view2 == null || view2.getVisibility() != 0) {
                        this.f1037e.setBounds(0, 0, 0, 0);
                    } else {
                        this.f1037e.setBounds(this.f1036d.getLeft(), this.f1036d.getTop(), this.f1036d.getRight(), this.f1036d.getBottom());
                    }
                }
                z3 = true;
            }
            this.f1041i = z4;
            if (!z4 || (drawable = this.f1038f) == null) {
                z2 = z3;
            } else {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z2) {
            invalidate();
        }
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        if (this.f1035c == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && (i4 = this.f1042j) >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i4, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.f1035c != null) {
            int mode = View.MeasureSpec.getMode(i2);
            View view = this.f1034b;
            if (view != null && view.getVisibility() != 8 && mode != 1073741824) {
                if (!m731b(this.f1035c)) {
                    i3 = m730a(this.f1035c);
                } else {
                    i3 = !m731b(this.f1036d) ? m730a(this.f1036d) : 0;
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(i3 + m730a(this.f1034b), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f1037e;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f1037e);
        }
        this.f1037e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f1035c;
            if (view != null) {
                this.f1037e.setBounds(view.getLeft(), this.f1035c.getTop(), this.f1035c.getRight(), this.f1035c.getBottom());
            }
        }
        boolean z = true;
        if (!this.f1040h ? !(this.f1037e == null && this.f1038f == null) : this.f1039g != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1039g;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f1039g);
        }
        this.f1039g = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1040h && (drawable2 = this.f1039g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f1040h ? this.f1037e == null && this.f1038f == null : this.f1039g == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1038f;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f1038f);
        }
        this.f1038f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1041i && (drawable2 = this.f1038f) != null) {
                drawable2.setBounds(this.f1034b.getLeft(), this.f1034b.getTop(), this.f1034b.getRight(), this.f1034b.getBottom());
            }
        }
        boolean z = true;
        if (!this.f1040h ? !(this.f1037e == null && this.f1038f == null) : this.f1039g != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f1034b;
        if (view != null) {
            removeView(view);
        }
        this.f1034b = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f1033a = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.f1037e;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f1038f;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f1039g;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f1037e && !this.f1040h) || (drawable == this.f1038f && this.f1041i) || ((drawable == this.f1039g && this.f1040h) || super.verifyDrawable(drawable));
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ViewCompat.setBackground(this, new C0316a(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0131R.styleable.ActionBar);
        this.f1037e = obtainStyledAttributes.getDrawable(C0131R.styleable.ActionBar_background);
        this.f1038f = obtainStyledAttributes.getDrawable(C0131R.styleable.ActionBar_backgroundStacked);
        this.f1042j = obtainStyledAttributes.getDimensionPixelSize(C0131R.styleable.ActionBar_height, -1);
        boolean z = true;
        if (getId() == C0131R.C0133id.split_action_bar) {
            this.f1040h = true;
            this.f1039g = obtainStyledAttributes.getDrawable(C0131R.styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        if (!this.f1040h ? !(this.f1037e == null && this.f1038f == null) : this.f1039g != null) {
            z = false;
        }
        setWillNotDraw(z);
    }
}
