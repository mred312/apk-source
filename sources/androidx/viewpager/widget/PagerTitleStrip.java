package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.util.Locale;

@ViewPager.DecorView
public class PagerTitleStrip extends ViewGroup {

    /* renamed from: o */
    private static final int[] f4915o = {16842804, 16842901, 16842904, 16842927};

    /* renamed from: p */
    private static final int[] f4916p = {16843660};

    /* renamed from: a */
    ViewPager f4917a;

    /* renamed from: b */
    TextView f4918b;

    /* renamed from: c */
    TextView f4919c;

    /* renamed from: d */
    TextView f4920d;

    /* renamed from: e */
    private int f4921e;

    /* renamed from: f */
    float f4922f;

    /* renamed from: g */
    private int f4923g;

    /* renamed from: h */
    private int f4924h;

    /* renamed from: i */
    private boolean f4925i;

    /* renamed from: j */
    private boolean f4926j;

    /* renamed from: k */
    private final C1062a f4927k;

    /* renamed from: l */
    private WeakReference<PagerAdapter> f4928l;

    /* renamed from: m */
    private int f4929m;

    /* renamed from: n */
    int f4930n;

    /* renamed from: androidx.viewpager.widget.PagerTitleStrip$a */
    private class C1062a extends DataSetObserver implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {

        /* renamed from: a */
        private int f4931a;

        C1062a() {
        }

        public void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            PagerTitleStrip.this.mo8522a(pagerAdapter, pagerAdapter2);
        }

        public void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.mo8523b(pagerTitleStrip.f4917a.getCurrentItem(), PagerTitleStrip.this.f4917a.getAdapter());
            PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
            float f = pagerTitleStrip2.f4922f;
            if (f < 0.0f) {
                f = 0.0f;
            }
            pagerTitleStrip2.mo8506c(pagerTitleStrip2.f4917a.getCurrentItem(), f, true);
        }

        public void onPageScrollStateChanged(int i) {
            this.f4931a = i;
        }

        public void onPageScrolled(int i, float f, int i2) {
            if (f > 0.5f) {
                i++;
            }
            PagerTitleStrip.this.mo8506c(i, f, false);
        }

        public void onPageSelected(int i) {
            if (this.f4931a == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.mo8523b(pagerTitleStrip.f4917a.getCurrentItem(), PagerTitleStrip.this.f4917a.getAdapter());
                PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
                float f = pagerTitleStrip2.f4922f;
                if (f < 0.0f) {
                    f = 0.0f;
                }
                pagerTitleStrip2.mo8506c(pagerTitleStrip2.f4917a.getCurrentItem(), f, true);
            }
        }
    }

    /* renamed from: androidx.viewpager.widget.PagerTitleStrip$b */
    private static class C1063b extends SingleLineTransformationMethod {

        /* renamed from: a */
        private Locale f4933a;

        C1063b(Context context) {
            this.f4933a = context.getResources().getConfiguration().locale;
        }

        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f4933a);
            }
            return null;
        }
    }

    public PagerTitleStrip(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new C1063b(textView.getContext()));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8522a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        if (pagerAdapter != null) {
            pagerAdapter.unregisterDataSetObserver(this.f4927k);
            this.f4928l = null;
        }
        if (pagerAdapter2 != null) {
            pagerAdapter2.registerDataSetObserver(this.f4927k);
            this.f4928l = new WeakReference<>(pagerAdapter2);
        }
        ViewPager viewPager = this.f4917a;
        if (viewPager != null) {
            this.f4921e = -1;
            this.f4922f = -1.0f;
            mo8523b(viewPager.getCurrentItem(), pagerAdapter2);
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo8523b(int i, PagerAdapter pagerAdapter) {
        int count = pagerAdapter != null ? pagerAdapter.getCount() : 0;
        this.f4925i = true;
        CharSequence charSequence = null;
        this.f4918b.setText((i < 1 || pagerAdapter == null) ? null : pagerAdapter.getPageTitle(i - 1));
        this.f4919c.setText((pagerAdapter == null || i >= count) ? null : pagerAdapter.getPageTitle(i));
        int i2 = i + 1;
        if (i2 < count && pagerAdapter != null) {
            charSequence = pagerAdapter.getPageTitle(i2);
        }
        this.f4920d.setText(charSequence);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.f4918b.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f4919c.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f4920d.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f4921e = i;
        if (!this.f4926j) {
            mo8506c(i, this.f4922f, false);
        }
        this.f4925i = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo8506c(int i, float f, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = i;
        float f2 = f;
        if (i6 != this.f4921e) {
            mo8523b(i6, this.f4917a.getAdapter());
        } else if (!z && f2 == this.f4922f) {
            return;
        }
        this.f4926j = true;
        int measuredWidth = this.f4918b.getMeasuredWidth();
        int measuredWidth2 = this.f4919c.getMeasuredWidth();
        int measuredWidth3 = this.f4920d.getMeasuredWidth();
        int i7 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i8 = paddingRight + i7;
        int i9 = (width - (paddingLeft + i7)) - i8;
        float f3 = 0.5f + f2;
        if (f3 > 1.0f) {
            f3 -= 1.0f;
        }
        int i10 = ((width - i8) - ((int) (((float) i9) * f3))) - i7;
        int i11 = measuredWidth2 + i10;
        int baseline = this.f4918b.getBaseline();
        int baseline2 = this.f4919c.getBaseline();
        int baseline3 = this.f4920d.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i12 = max - baseline;
        int i13 = max - baseline2;
        int i14 = max - baseline3;
        int i15 = measuredWidth3;
        int max2 = Math.max(Math.max(this.f4918b.getMeasuredHeight() + i12, this.f4919c.getMeasuredHeight() + i13), this.f4920d.getMeasuredHeight() + i14);
        int i16 = this.f4924h & 112;
        if (i16 == 16) {
            i5 = (((height - paddingTop) - paddingBottom) - max2) / 2;
        } else if (i16 != 80) {
            i4 = i12 + paddingTop;
            i2 = i13 + paddingTop;
            i3 = paddingTop + i14;
            TextView textView = this.f4919c;
            textView.layout(i10, i2, i11, textView.getMeasuredHeight() + i2);
            int min = Math.min(paddingLeft, (i10 - this.f4923g) - measuredWidth);
            TextView textView2 = this.f4918b;
            textView2.layout(min, i4, measuredWidth + min, textView2.getMeasuredHeight() + i4);
            int max3 = Math.max((width - paddingRight) - i15, i11 + this.f4923g);
            TextView textView3 = this.f4920d;
            textView3.layout(max3, i3, max3 + i15, textView3.getMeasuredHeight() + i3);
            this.f4922f = f;
            this.f4926j = false;
        } else {
            i5 = (height - paddingBottom) - max2;
        }
        i4 = i12 + i5;
        i2 = i13 + i5;
        i3 = i5 + i14;
        TextView textView4 = this.f4919c;
        textView4.layout(i10, i2, i11, textView4.getMeasuredHeight() + i2);
        int min2 = Math.min(paddingLeft, (i10 - this.f4923g) - measuredWidth);
        TextView textView22 = this.f4918b;
        textView22.layout(min2, i4, measuredWidth + min2, textView22.getMeasuredHeight() + i4);
        int max32 = Math.max((width - paddingRight) - i15, i11 + this.f4923g);
        TextView textView32 = this.f4920d;
        textView32.layout(max32, i3, max32 + i15, textView32.getMeasuredHeight() + i3);
        this.f4922f = f;
        this.f4926j = false;
    }

    /* access modifiers changed from: package-private */
    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.f4923g;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            PagerAdapter adapter = viewPager.getAdapter();
            viewPager.mo8542H(this.f4927k);
            viewPager.addOnAdapterChangeListener(this.f4927k);
            this.f4917a = viewPager;
            WeakReference<PagerAdapter> weakReference = this.f4928l;
            mo8522a(weakReference != null ? (PagerAdapter) weakReference.get() : null, adapter);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.f4917a;
        if (viewPager != null) {
            mo8522a(viewPager.getAdapter(), (PagerAdapter) null);
            this.f4917a.mo8542H((ViewPager.OnPageChangeListener) null);
            this.f4917a.removeOnAdapterChangeListener(this.f4927k);
            this.f4917a = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f4917a != null) {
            float f = this.f4922f;
            if (f < 0.0f) {
                f = 0.0f;
            }
            mo8506c(this.f4921e, f, true);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingTop, -2);
            int size = View.MeasureSpec.getSize(i);
            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i, (int) (((float) size) * 0.2f), -2);
            this.f4918b.measure(childMeasureSpec2, childMeasureSpec);
            this.f4919c.measure(childMeasureSpec2, childMeasureSpec);
            this.f4920d.measure(childMeasureSpec2, childMeasureSpec);
            if (View.MeasureSpec.getMode(i2) == 1073741824) {
                i3 = View.MeasureSpec.getSize(i2);
            } else {
                i3 = Math.max(getMinHeight(), this.f4919c.getMeasuredHeight() + paddingTop);
            }
            setMeasuredDimension(size, View.resolveSizeAndState(i3, i2, this.f4919c.getMeasuredState() << 16));
            return;
        }
        throw new IllegalStateException("Must measure with an exact width");
    }

    public void requestLayout() {
        if (!this.f4925i) {
            super.requestLayout();
        }
    }

    public void setGravity(int i) {
        this.f4924h = i;
        requestLayout();
    }

    public void setNonPrimaryAlpha(@FloatRange(from = 0.0d, mo761to = 1.0d) float f) {
        int i = ((int) (f * 255.0f)) & 255;
        this.f4929m = i;
        int i2 = (i << 24) | (this.f4930n & ViewCompat.MEASURED_SIZE_MASK);
        this.f4918b.setTextColor(i2);
        this.f4920d.setTextColor(i2);
    }

    public void setTextColor(@ColorInt int i) {
        this.f4930n = i;
        this.f4919c.setTextColor(i);
        int i2 = (this.f4929m << 24) | (this.f4930n & ViewCompat.MEASURED_SIZE_MASK);
        this.f4918b.setTextColor(i2);
        this.f4920d.setTextColor(i2);
    }

    public void setTextSize(int i, float f) {
        this.f4918b.setTextSize(i, f);
        this.f4919c.setTextSize(i, f);
        this.f4920d.setTextSize(i, f);
    }

    public void setTextSpacing(int i) {
        this.f4923g = i;
        requestLayout();
    }

    public PagerTitleStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4921e = -1;
        this.f4922f = -1.0f;
        this.f4927k = new C1062a();
        TextView textView = new TextView(context);
        this.f4918b = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.f4919c = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f4920d = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f4915o);
        boolean z = false;
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            TextViewCompat.setTextAppearance(this.f4918b, resourceId);
            TextViewCompat.setTextAppearance(this.f4919c, resourceId);
            TextViewCompat.setTextAppearance(this.f4920d, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            setTextSize(0, (float) dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            this.f4918b.setTextColor(color);
            this.f4919c.setTextColor(color);
            this.f4920d.setTextColor(color);
        }
        this.f4924h = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.f4930n = this.f4919c.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.f4918b.setEllipsize(TextUtils.TruncateAt.END);
        this.f4919c.setEllipsize(TextUtils.TruncateAt.END);
        this.f4920d.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, f4916p);
            z = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (z) {
            setSingleLineAllCaps(this.f4918b);
            setSingleLineAllCaps(this.f4919c);
            setSingleLineAllCaps(this.f4920d);
        } else {
            this.f4918b.setSingleLine();
            this.f4919c.setSingleLine();
            this.f4920d.setSingleLine();
        }
        this.f4923g = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }
}
