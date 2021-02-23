package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.C0131R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;

public class SwitchCompat extends CompoundButton {

    /* renamed from: N */
    private static final Property<SwitchCompat, Float> f1473N = new C0308a(Float.class, "thumbPos");

    /* renamed from: O */
    private static final int[] f1474O = {16842912};

    /* renamed from: A */
    private int f1475A;

    /* renamed from: B */
    private int f1476B;

    /* renamed from: C */
    private int f1477C;

    /* renamed from: D */
    private int f1478D;

    /* renamed from: E */
    private int f1479E;

    /* renamed from: F */
    private final TextPaint f1480F;

    /* renamed from: G */
    private ColorStateList f1481G;

    /* renamed from: H */
    private Layout f1482H;

    /* renamed from: I */
    private Layout f1483I;

    /* renamed from: J */
    private TransformationMethod f1484J;

    /* renamed from: K */
    ObjectAnimator f1485K;

    /* renamed from: L */
    private final C0324i f1486L;

    /* renamed from: M */
    private final Rect f1487M;

    /* renamed from: a */
    private Drawable f1488a;

    /* renamed from: b */
    private ColorStateList f1489b;

    /* renamed from: c */
    private PorterDuff.Mode f1490c;

    /* renamed from: d */
    private boolean f1491d;

    /* renamed from: e */
    private boolean f1492e;

    /* renamed from: f */
    private Drawable f1493f;

    /* renamed from: g */
    private ColorStateList f1494g;

    /* renamed from: h */
    private PorterDuff.Mode f1495h;

    /* renamed from: i */
    private boolean f1496i;

    /* renamed from: j */
    private boolean f1497j;

    /* renamed from: k */
    private int f1498k;

    /* renamed from: l */
    private int f1499l;

    /* renamed from: m */
    private int f1500m;

    /* renamed from: n */
    private boolean f1501n;

    /* renamed from: o */
    private CharSequence f1502o;

    /* renamed from: p */
    private CharSequence f1503p;

    /* renamed from: q */
    private boolean f1504q;

    /* renamed from: r */
    private int f1505r;

    /* renamed from: s */
    private int f1506s;

    /* renamed from: t */
    private float f1507t;

    /* renamed from: u */
    private float f1508u;

    /* renamed from: v */
    private VelocityTracker f1509v;

    /* renamed from: w */
    private int f1510w;

    /* renamed from: x */
    float f1511x;

    /* renamed from: y */
    private int f1512y;

    /* renamed from: z */
    private int f1513z;

    /* renamed from: androidx.appcompat.widget.SwitchCompat$a */
    class C0308a extends Property<SwitchCompat, Float> {
        C0308a(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.f1511x);
        }

        /* renamed from: b */
        public void set(SwitchCompat switchCompat, Float f) {
            switchCompat.setThumbPosition(f.floatValue());
        }
    }

    public SwitchCompat(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* renamed from: a */
    private void m975a(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f1473N, new float[]{z ? 1.0f : 0.0f});
        this.f1485K = ofFloat;
        ofFloat.setDuration(250);
        if (Build.VERSION.SDK_INT >= 18) {
            this.f1485K.setAutoCancel(true);
        }
        this.f1485K.start();
    }

    /* renamed from: b */
    private void m976b() {
        Drawable drawable = this.f1488a;
        if (drawable == null) {
            return;
        }
        if (this.f1491d || this.f1492e) {
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            this.f1488a = mutate;
            if (this.f1491d) {
                DrawableCompat.setTintList(mutate, this.f1489b);
            }
            if (this.f1492e) {
                DrawableCompat.setTintMode(this.f1488a, this.f1490c);
            }
            if (this.f1488a.isStateful()) {
                this.f1488a.setState(getDrawableState());
            }
        }
    }

    /* renamed from: c */
    private void m977c() {
        Drawable drawable = this.f1493f;
        if (drawable == null) {
            return;
        }
        if (this.f1496i || this.f1497j) {
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            this.f1493f = mutate;
            if (this.f1496i) {
                DrawableCompat.setTintList(mutate, this.f1494g);
            }
            if (this.f1497j) {
                DrawableCompat.setTintMode(this.f1493f, this.f1495h);
            }
            if (this.f1493f.isStateful()) {
                this.f1493f.setState(getDrawableState());
            }
        }
    }

    /* renamed from: d */
    private void m978d() {
        ObjectAnimator objectAnimator = this.f1485K;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    /* renamed from: e */
    private void m979e(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    /* renamed from: f */
    private static float m980f(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    /* renamed from: g */
    private boolean m981g(float f, float f2) {
        if (this.f1488a == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f1488a.getPadding(this.f1487M);
        int i = this.f1477C;
        int i2 = this.f1506s;
        int i3 = i - i2;
        int i4 = (this.f1476B + thumbOffset) - i2;
        Rect rect = this.f1487M;
        int i5 = this.f1475A + i4 + rect.left + rect.right + i2;
        int i6 = this.f1479E + i2;
        if (f <= ((float) i4) || f >= ((float) i5) || f2 <= ((float) i3) || f2 >= ((float) i6)) {
            return false;
        }
        return true;
    }

    private boolean getTargetCheckedState() {
        return this.f1511x > 0.5f;
    }

    private int getThumbOffset() {
        float f;
        if (ViewUtils.isLayoutRtl(this)) {
            f = 1.0f - this.f1511x;
        } else {
            f = this.f1511x;
        }
        return (int) ((f * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rect;
        Drawable drawable = this.f1493f;
        if (drawable == null) {
            return 0;
        }
        Rect rect2 = this.f1487M;
        drawable.getPadding(rect2);
        Drawable drawable2 = this.f1488a;
        if (drawable2 != null) {
            rect = DrawableUtils.getOpticalBounds(drawable2);
        } else {
            rect = DrawableUtils.INSETS_NONE;
        }
        return ((((this.f1512y - this.f1475A) - rect2.left) - rect2.right) - rect.left) - rect.right;
    }

    /* renamed from: h */
    private Layout m982h(CharSequence charSequence) {
        TransformationMethod transformationMethod = this.f1484J;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, this);
        }
        CharSequence charSequence2 = charSequence;
        TextPaint textPaint = this.f1480F;
        return new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil((double) Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    /* renamed from: i */
    private void m983i(int i, int i2) {
        Typeface typeface;
        if (i == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i != 2) {
            typeface = i != 3 ? null : Typeface.MONOSPACE;
        } else {
            typeface = Typeface.SERIF;
        }
        setSwitchTypeface(typeface, i2);
    }

    /* renamed from: j */
    private void m984j(MotionEvent motionEvent) {
        this.f1505r = 0;
        boolean z = true;
        boolean z2 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z2) {
            this.f1509v.computeCurrentVelocity(1000);
            float xVelocity = this.f1509v.getXVelocity();
            if (Math.abs(xVelocity) <= ((float) this.f1510w)) {
                z = getTargetCheckedState();
            } else if (!ViewUtils.isLayoutRtl(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                z = false;
            }
        } else {
            z = isChecked;
        }
        if (z != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z);
        m979e(motionEvent);
    }

    public void draw(Canvas canvas) {
        Rect rect;
        int i;
        int i2;
        Rect rect2 = this.f1487M;
        int i3 = this.f1476B;
        int i4 = this.f1477C;
        int i5 = this.f1478D;
        int i6 = this.f1479E;
        int thumbOffset = getThumbOffset() + i3;
        Drawable drawable = this.f1488a;
        if (drawable != null) {
            rect = DrawableUtils.getOpticalBounds(drawable);
        } else {
            rect = DrawableUtils.INSETS_NONE;
        }
        Drawable drawable2 = this.f1493f;
        if (drawable2 != null) {
            drawable2.getPadding(rect2);
            int i7 = rect2.left;
            thumbOffset += i7;
            if (rect != null) {
                int i8 = rect.left;
                if (i8 > i7) {
                    i3 += i8 - i7;
                }
                int i9 = rect.top;
                int i10 = rect2.top;
                i = i9 > i10 ? (i9 - i10) + i4 : i4;
                int i11 = rect.right;
                int i12 = rect2.right;
                if (i11 > i12) {
                    i5 -= i11 - i12;
                }
                int i13 = rect.bottom;
                int i14 = rect2.bottom;
                if (i13 > i14) {
                    i2 = i6 - (i13 - i14);
                    this.f1493f.setBounds(i3, i, i5, i2);
                }
            } else {
                i = i4;
            }
            i2 = i6;
            this.f1493f.setBounds(i3, i, i5, i2);
        }
        Drawable drawable3 = this.f1488a;
        if (drawable3 != null) {
            drawable3.getPadding(rect2);
            int i15 = thumbOffset - rect2.left;
            int i16 = thumbOffset + this.f1475A + rect2.right;
            this.f1488a.setBounds(i15, i4, i16, i6);
            Drawable background = getBackground();
            if (background != null) {
                DrawableCompat.setHotspotBounds(background, i15, i4, i16, i6);
            }
        }
        super.draw(canvas);
    }

    public void drawableHotspotChanged(float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f, f2);
        }
        Drawable drawable = this.f1488a;
        if (drawable != null) {
            DrawableCompat.setHotspot(drawable, f, f2);
        }
        Drawable drawable2 = this.f1493f;
        if (drawable2 != null) {
            DrawableCompat.setHotspot(drawable2, f, f2);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f1488a;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f1493f;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    public int getCompoundPaddingLeft() {
        if (!ViewUtils.isLayoutRtl(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f1512y;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f1500m : compoundPaddingLeft;
    }

    public int getCompoundPaddingRight() {
        if (ViewUtils.isLayoutRtl(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f1512y;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f1500m : compoundPaddingRight;
    }

    public boolean getShowText() {
        return this.f1504q;
    }

    public boolean getSplitTrack() {
        return this.f1501n;
    }

    public int getSwitchMinWidth() {
        return this.f1499l;
    }

    public int getSwitchPadding() {
        return this.f1500m;
    }

    public CharSequence getTextOff() {
        return this.f1503p;
    }

    public CharSequence getTextOn() {
        return this.f1502o;
    }

    public Drawable getThumbDrawable() {
        return this.f1488a;
    }

    public int getThumbTextPadding() {
        return this.f1498k;
    }

    @Nullable
    public ColorStateList getThumbTintList() {
        return this.f1489b;
    }

    @Nullable
    public PorterDuff.Mode getThumbTintMode() {
        return this.f1490c;
    }

    public Drawable getTrackDrawable() {
        return this.f1493f;
    }

    @Nullable
    public ColorStateList getTrackTintList() {
        return this.f1494g;
    }

    @Nullable
    public PorterDuff.Mode getTrackTintMode() {
        return this.f1495h;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1488a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1493f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.f1485K;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.f1485K.end();
            this.f1485K = null;
        }
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            CompoundButton.mergeDrawableStates(onCreateDrawableState, f1474O);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        Rect rect = this.f1487M;
        Drawable drawable = this.f1493f;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i2 = this.f1477C;
        int i3 = this.f1479E;
        int i4 = i2 + rect.top;
        int i5 = i3 - rect.bottom;
        Drawable drawable2 = this.f1488a;
        if (drawable != null) {
            if (!this.f1501n || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect opticalBounds = DrawableUtils.getOpticalBounds(drawable2);
                drawable2.copyBounds(rect);
                rect.left += opticalBounds.left;
                rect.right -= opticalBounds.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.f1482H : this.f1483I;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.f1481G;
            if (colorStateList != null) {
                this.f1480F.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.f1480F.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                i = bounds.left + bounds.right;
            } else {
                i = getWidth();
            }
            canvas.translate((float) ((i / 2) - (layout.getWidth() / 2)), (float) (((i4 + i5) / 2) - (layout.getHeight() / 2)));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        CharSequence charSequence = isChecked() ? this.f1502o : this.f1503p;
        if (!TextUtils.isEmpty(charSequence)) {
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(' ');
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        super.onLayout(z, i, i2, i3, i4);
        int i11 = 0;
        if (this.f1488a != null) {
            Rect rect = this.f1487M;
            Drawable drawable = this.f1493f;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect opticalBounds = DrawableUtils.getOpticalBounds(this.f1488a);
            i5 = Math.max(0, opticalBounds.left - rect.left);
            i11 = Math.max(0, opticalBounds.right - rect.right);
        } else {
            i5 = 0;
        }
        if (ViewUtils.isLayoutRtl(this)) {
            i7 = getPaddingLeft() + i5;
            i6 = ((this.f1512y + i7) - i5) - i11;
        } else {
            i6 = (getWidth() - getPaddingRight()) - i11;
            i7 = (i6 - this.f1512y) + i5 + i11;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            i10 = this.f1513z;
            i9 = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (i10 / 2);
        } else if (gravity != 80) {
            i9 = getPaddingTop();
            i10 = this.f1513z;
        } else {
            i8 = getHeight() - getPaddingBottom();
            i9 = i8 - this.f1513z;
            this.f1476B = i7;
            this.f1477C = i9;
            this.f1479E = i8;
            this.f1478D = i6;
        }
        i8 = i10 + i9;
        this.f1476B = i7;
        this.f1477C = i9;
        this.f1479E = i8;
        this.f1478D = i6;
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        if (this.f1504q) {
            if (this.f1482H == null) {
                this.f1482H = m982h(this.f1502o);
            }
            if (this.f1483I == null) {
                this.f1483I = m982h(this.f1503p);
            }
        }
        Rect rect = this.f1487M;
        Drawable drawable = this.f1488a;
        int i5 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i4 = (this.f1488a.getIntrinsicWidth() - rect.left) - rect.right;
            i3 = this.f1488a.getIntrinsicHeight();
        } else {
            i4 = 0;
            i3 = 0;
        }
        this.f1475A = Math.max(this.f1504q ? Math.max(this.f1482H.getWidth(), this.f1483I.getWidth()) + (this.f1498k * 2) : 0, i4);
        Drawable drawable2 = this.f1493f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i5 = this.f1493f.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i6 = rect.left;
        int i7 = rect.right;
        Drawable drawable3 = this.f1488a;
        if (drawable3 != null) {
            Rect opticalBounds = DrawableUtils.getOpticalBounds(drawable3);
            i6 = Math.max(i6, opticalBounds.left);
            i7 = Math.max(i7, opticalBounds.right);
        }
        int max = Math.max(this.f1499l, (this.f1475A * 2) + i6 + i7);
        int max2 = Math.max(i5, i3);
        this.f1512y = max;
        this.f1513z = max2;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f1502o : this.f1503p;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        if (r0 != 3) goto L_0x00b9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.f1509v
            r0.addMovement(r7)
            int r0 = r7.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L_0x009f
            r2 = 2
            if (r0 == r1) goto L_0x008b
            if (r0 == r2) goto L_0x0016
            r3 = 3
            if (r0 == r3) goto L_0x008b
            goto L_0x00b9
        L_0x0016:
            int r0 = r6.f1505r
            if (r0 == r1) goto L_0x0057
            if (r0 == r2) goto L_0x001e
            goto L_0x00b9
        L_0x001e:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.f1507t
            float r2 = r7 - r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == 0) goto L_0x0032
            float r0 = (float) r0
            float r2 = r2 / r0
            goto L_0x003d
        L_0x0032:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0039
            r2 = 1065353216(0x3f800000, float:1.0)
            goto L_0x003d
        L_0x0039:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x003d:
            boolean r0 = androidx.appcompat.widget.ViewUtils.isLayoutRtl(r6)
            if (r0 == 0) goto L_0x0044
            float r2 = -r2
        L_0x0044:
            float r0 = r6.f1511x
            float r0 = r0 + r2
            float r0 = m980f(r0, r4, r3)
            float r2 = r6.f1511x
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0056
            r6.f1507t = r7
            r6.setThumbPosition(r0)
        L_0x0056:
            return r1
        L_0x0057:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.f1507t
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f1506s
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L_0x007d
            float r4 = r6.f1508u
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f1506s
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x00b9
        L_0x007d:
            r6.f1505r = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.f1507t = r0
            r6.f1508u = r3
            return r1
        L_0x008b:
            int r0 = r6.f1505r
            if (r0 != r2) goto L_0x0096
            r6.m984j(r7)
            super.onTouchEvent(r7)
            return r1
        L_0x0096:
            r0 = 0
            r6.f1505r = r0
            android.view.VelocityTracker r0 = r6.f1509v
            r0.clear()
            goto L_0x00b9
        L_0x009f:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto L_0x00b9
            boolean r3 = r6.m981g(r0, r2)
            if (r3 == 0) goto L_0x00b9
            r6.f1505r = r1
            r6.f1507t = r0
            r6.f1508u = r2
        L_0x00b9:
            boolean r7 = super.onTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (getWindowToken() == null || !ViewCompat.isLaidOut(this)) {
            m978d();
            setThumbPosition(isChecked ? 1.0f : 0.0f);
            return;
        }
        m975a(isChecked);
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }

    public void setShowText(boolean z) {
        if (this.f1504q != z) {
            this.f1504q = z;
            requestLayout();
        }
    }

    public void setSplitTrack(boolean z) {
        this.f1501n = z;
        invalidate();
    }

    public void setSwitchMinWidth(int i) {
        this.f1499l = i;
        requestLayout();
    }

    public void setSwitchPadding(int i) {
        this.f1500m = i;
        requestLayout();
    }

    public void setSwitchTextAppearance(Context context, int i) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, i, C0131R.styleable.TextAppearance);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(C0131R.styleable.TextAppearance_android_textColor);
        if (colorStateList != null) {
            this.f1481G = colorStateList;
        } else {
            this.f1481G = getTextColors();
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0131R.styleable.TextAppearance_android_textSize, 0);
        if (dimensionPixelSize != 0) {
            float f = (float) dimensionPixelSize;
            if (f != this.f1480F.getTextSize()) {
                this.f1480F.setTextSize(f);
                requestLayout();
            }
        }
        m983i(obtainStyledAttributes.getInt(C0131R.styleable.TextAppearance_android_typeface, -1), obtainStyledAttributes.getInt(C0131R.styleable.TextAppearance_android_textStyle, -1));
        if (obtainStyledAttributes.getBoolean(C0131R.styleable.TextAppearance_textAllCaps, false)) {
            this.f1484J = new AllCapsTransformationMethod(getContext());
        } else {
            this.f1484J = null;
        }
        obtainStyledAttributes.recycle();
    }

    public void setSwitchTypeface(Typeface typeface, int i) {
        Typeface typeface2;
        float f = 0.0f;
        boolean z = false;
        if (i > 0) {
            if (typeface == null) {
                typeface2 = Typeface.defaultFromStyle(i);
            } else {
                typeface2 = Typeface.create(typeface, i);
            }
            setSwitchTypeface(typeface2);
            int style = ((typeface2 != null ? typeface2.getStyle() : 0) ^ -1) & i;
            TextPaint textPaint = this.f1480F;
            if ((style & 1) != 0) {
                z = true;
            }
            textPaint.setFakeBoldText(z);
            TextPaint textPaint2 = this.f1480F;
            if ((style & 2) != 0) {
                f = -0.25f;
            }
            textPaint2.setTextSkewX(f);
            return;
        }
        this.f1480F.setFakeBoldText(false);
        this.f1480F.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    public void setTextOff(CharSequence charSequence) {
        this.f1503p = charSequence;
        requestLayout();
    }

    public void setTextOn(CharSequence charSequence) {
        this.f1502o = charSequence;
        requestLayout();
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f1488a;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f1488a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void setThumbPosition(float f) {
        this.f1511x = f;
        invalidate();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(AppCompatResources.getDrawable(getContext(), i));
    }

    public void setThumbTextPadding(int i) {
        this.f1498k = i;
        requestLayout();
    }

    public void setThumbTintList(@Nullable ColorStateList colorStateList) {
        this.f1489b = colorStateList;
        this.f1491d = true;
        m976b();
    }

    public void setThumbTintMode(@Nullable PorterDuff.Mode mode) {
        this.f1490c = mode;
        this.f1492e = true;
        m976b();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f1493f;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f1493f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(AppCompatResources.getDrawable(getContext(), i));
    }

    public void setTrackTintList(@Nullable ColorStateList colorStateList) {
        this.f1494g = colorStateList;
        this.f1496i = true;
        m977c();
    }

    public void setTrackTintMode(@Nullable PorterDuff.Mode mode) {
        this.f1495h = mode;
        this.f1497j = true;
        m977c();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1488a || drawable == this.f1493f;
    }

    public SwitchCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, C0131R.attr.switchStyle);
    }

    public SwitchCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1489b = null;
        this.f1490c = null;
        this.f1491d = false;
        this.f1492e = false;
        this.f1494g = null;
        this.f1495h = null;
        this.f1496i = false;
        this.f1497j = false;
        this.f1509v = VelocityTracker.obtain();
        this.f1487M = new Rect();
        ThemeUtils.checkAppCompatTheme(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.f1480F = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = C0131R.styleable.SwitchCompat;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(C0131R.styleable.SwitchCompat_android_thumb);
        this.f1488a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(C0131R.styleable.SwitchCompat_track);
        this.f1493f = drawable2;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
        this.f1502o = obtainStyledAttributes.getText(C0131R.styleable.SwitchCompat_android_textOn);
        this.f1503p = obtainStyledAttributes.getText(C0131R.styleable.SwitchCompat_android_textOff);
        this.f1504q = obtainStyledAttributes.getBoolean(C0131R.styleable.SwitchCompat_showText, true);
        this.f1498k = obtainStyledAttributes.getDimensionPixelSize(C0131R.styleable.SwitchCompat_thumbTextPadding, 0);
        this.f1499l = obtainStyledAttributes.getDimensionPixelSize(C0131R.styleable.SwitchCompat_switchMinWidth, 0);
        this.f1500m = obtainStyledAttributes.getDimensionPixelSize(C0131R.styleable.SwitchCompat_switchPadding, 0);
        this.f1501n = obtainStyledAttributes.getBoolean(C0131R.styleable.SwitchCompat_splitTrack, false);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(C0131R.styleable.SwitchCompat_thumbTint);
        if (colorStateList != null) {
            this.f1489b = colorStateList;
            this.f1491d = true;
        }
        PorterDuff.Mode parseTintMode = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(C0131R.styleable.SwitchCompat_thumbTintMode, -1), (PorterDuff.Mode) null);
        if (this.f1490c != parseTintMode) {
            this.f1490c = parseTintMode;
            this.f1492e = true;
        }
        if (this.f1491d || this.f1492e) {
            m976b();
        }
        ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(C0131R.styleable.SwitchCompat_trackTint);
        if (colorStateList2 != null) {
            this.f1494g = colorStateList2;
            this.f1496i = true;
        }
        PorterDuff.Mode parseTintMode2 = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(C0131R.styleable.SwitchCompat_trackTintMode, -1), (PorterDuff.Mode) null);
        if (this.f1495h != parseTintMode2) {
            this.f1495h = parseTintMode2;
            this.f1497j = true;
        }
        if (this.f1496i || this.f1497j) {
            m977c();
        }
        int resourceId = obtainStyledAttributes.getResourceId(C0131R.styleable.SwitchCompat_switchTextAppearance, 0);
        if (resourceId != 0) {
            setSwitchTextAppearance(context, resourceId);
        }
        C0324i iVar = new C0324i(this);
        this.f1486L = iVar;
        iVar.mo2981m(attributeSet, i);
        obtainStyledAttributes.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1506s = viewConfiguration.getScaledTouchSlop();
        this.f1510w = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.f1480F.getTypeface() != null && !this.f1480F.getTypeface().equals(typeface)) || (this.f1480F.getTypeface() == null && typeface != null)) {
            this.f1480F.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }
}
