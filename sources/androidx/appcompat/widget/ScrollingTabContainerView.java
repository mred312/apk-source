package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0131R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.widget.LinearLayoutCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: j */
    private static final Interpolator f1366j = new DecelerateInterpolator();

    /* renamed from: a */
    Runnable f1367a;

    /* renamed from: b */
    private C0290c f1368b;

    /* renamed from: c */
    LinearLayoutCompat f1369c;

    /* renamed from: d */
    private Spinner f1370d;

    /* renamed from: e */
    private boolean f1371e;

    /* renamed from: f */
    int f1372f;

    /* renamed from: g */
    int f1373g;

    /* renamed from: h */
    private int f1374h;

    /* renamed from: i */
    private int f1375i;
    protected final VisibilityAnimListener mVisAnimListener = new VisibilityAnimListener();
    protected ViewPropertyAnimator mVisibilityAnim;

    protected class VisibilityAnimListener extends AnimatorListenerAdapter {

        /* renamed from: a */
        private boolean f1376a = false;

        /* renamed from: b */
        private int f1377b;

        protected VisibilityAnimListener() {
        }

        public void onAnimationCancel(Animator animator) {
            this.f1376a = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f1376a) {
                ScrollingTabContainerView scrollingTabContainerView = ScrollingTabContainerView.this;
                scrollingTabContainerView.mVisibilityAnim = null;
                scrollingTabContainerView.setVisibility(this.f1377b);
            }
        }

        public void onAnimationStart(Animator animator) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.f1376a = false;
        }

        public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimator viewPropertyAnimator, int i) {
            this.f1377b = i;
            ScrollingTabContainerView.this.mVisibilityAnim = viewPropertyAnimator;
            return this;
        }
    }

    /* renamed from: androidx.appcompat.widget.ScrollingTabContainerView$a */
    class C0288a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ View f1379a;

        C0288a(View view) {
            this.f1379a = view;
        }

        public void run() {
            ScrollingTabContainerView.this.smoothScrollTo(this.f1379a.getLeft() - ((ScrollingTabContainerView.this.getWidth() - this.f1379a.getWidth()) / 2), 0);
            ScrollingTabContainerView.this.f1367a = null;
        }
    }

    /* renamed from: androidx.appcompat.widget.ScrollingTabContainerView$b */
    private class C0289b extends BaseAdapter {
        C0289b() {
        }

        public int getCount() {
            return ScrollingTabContainerView.this.f1369c.getChildCount();
        }

        public Object getItem(int i) {
            return ((C0291d) ScrollingTabContainerView.this.f1369c.getChildAt(i)).mo2617b();
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.mo2593c((ActionBar.Tab) getItem(i), true);
            }
            ((C0291d) view).mo2616a((ActionBar.Tab) getItem(i));
            return view;
        }
    }

    /* renamed from: androidx.appcompat.widget.ScrollingTabContainerView$c */
    private class C0290c implements View.OnClickListener {
        C0290c() {
        }

        public void onClick(View view) {
            ((C0291d) view).mo2617b().select();
            int childCount = ScrollingTabContainerView.this.f1369c.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = ScrollingTabContainerView.this.f1369c.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ScrollingTabContainerView$d */
    private class C0291d extends LinearLayout {

        /* renamed from: a */
        private final int[] f1383a;

        /* renamed from: b */
        private ActionBar.Tab f1384b;

        /* renamed from: c */
        private TextView f1385c;

        /* renamed from: d */
        private ImageView f1386d;

        /* renamed from: e */
        private View f1387e;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public C0291d(android.content.Context r6, androidx.appcompat.app.ActionBar.Tab r7, boolean r8) {
            /*
                r4 = this;
                androidx.appcompat.widget.ScrollingTabContainerView.this = r5
                int r5 = androidx.appcompat.C0131R.attr.actionBarTabStyle
                r0 = 0
                r4.<init>(r6, r0, r5)
                r1 = 1
                int[] r1 = new int[r1]
                r2 = 16842964(0x10100d4, float:2.3694152E-38)
                r3 = 0
                r1[r3] = r2
                r4.f1383a = r1
                r4.f1384b = r7
                androidx.appcompat.widget.TintTypedArray r5 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(r6, r0, r1, r5, r3)
                boolean r6 = r5.hasValue(r3)
                if (r6 == 0) goto L_0x0026
                android.graphics.drawable.Drawable r6 = r5.getDrawable(r3)
                r4.setBackgroundDrawable(r6)
            L_0x0026:
                r5.recycle()
                if (r8 == 0) goto L_0x0031
                r5 = 8388627(0x800013, float:1.175497E-38)
                r4.setGravity(r5)
            L_0x0031:
                r4.mo2618c()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ScrollingTabContainerView.C0291d.<init>(androidx.appcompat.widget.ScrollingTabContainerView, android.content.Context, androidx.appcompat.app.ActionBar$Tab, boolean):void");
        }

        /* renamed from: a */
        public void mo2616a(ActionBar.Tab tab) {
            this.f1384b = tab;
            mo2618c();
        }

        /* renamed from: b */
        public ActionBar.Tab mo2617b() {
            return this.f1384b;
        }

        /* renamed from: c */
        public void mo2618c() {
            ActionBar.Tab tab = this.f1384b;
            View customView = tab.getCustomView();
            CharSequence charSequence = null;
            if (customView != null) {
                ViewParent parent = customView.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(customView);
                    }
                    addView(customView);
                }
                this.f1387e = customView;
                TextView textView = this.f1385c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f1386d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f1386d.setImageDrawable((Drawable) null);
                    return;
                }
                return;
            }
            View view = this.f1387e;
            if (view != null) {
                removeView(view);
                this.f1387e = null;
            }
            Drawable icon = tab.getIcon();
            CharSequence text = tab.getText();
            if (icon != null) {
                if (this.f1386d == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f1386d = appCompatImageView;
                }
                this.f1386d.setImageDrawable(icon);
                this.f1386d.setVisibility(0);
            } else {
                ImageView imageView2 = this.f1386d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f1386d.setImageDrawable((Drawable) null);
                }
            }
            boolean z = !TextUtils.isEmpty(text);
            if (z) {
                if (this.f1385c == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), (AttributeSet) null, C0131R.attr.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f1385c = appCompatTextView;
                }
                this.f1385c.setText(text);
                this.f1385c.setVisibility(0);
            } else {
                TextView textView2 = this.f1385c;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f1385c.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f1386d;
            if (imageView3 != null) {
                imageView3.setContentDescription(tab.getContentDescription());
            }
            if (!z) {
                charSequence = tab.getContentDescription();
            }
            TooltipCompat.setTooltipText(this, charSequence);
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public void onMeasure(int i, int i2) {
            int i3;
            super.onMeasure(i, i2);
            if (ScrollingTabContainerView.this.f1372f > 0 && getMeasuredWidth() > (i3 = ScrollingTabContainerView.this.f1372f)) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
            }
        }

        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }
    }

    public ScrollingTabContainerView(@NonNull Context context) {
        super(context);
        setHorizontalScrollBarEnabled(false);
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(context);
        setContentHeight(actionBarPolicy.getTabContainerHeight());
        this.f1373g = actionBarPolicy.getStackedTabMaxWidth();
        LinearLayoutCompat b = m919b();
        this.f1369c = b;
        addView(b, new ViewGroup.LayoutParams(-2, -1));
    }

    /* renamed from: a */
    private Spinner m918a() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), (AttributeSet) null, C0131R.attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    /* renamed from: b */
    private LinearLayoutCompat m919b() {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), (AttributeSet) null, C0131R.attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        return linearLayoutCompat;
    }

    /* renamed from: d */
    private boolean m920d() {
        Spinner spinner = this.f1370d;
        return spinner != null && spinner.getParent() == this;
    }

    /* renamed from: e */
    private void m921e() {
        if (!m920d()) {
            if (this.f1370d == null) {
                this.f1370d = m918a();
            }
            removeView(this.f1369c);
            addView(this.f1370d, new ViewGroup.LayoutParams(-2, -1));
            if (this.f1370d.getAdapter() == null) {
                this.f1370d.setAdapter(new C0289b());
            }
            Runnable runnable = this.f1367a;
            if (runnable != null) {
                removeCallbacks(runnable);
                this.f1367a = null;
            }
            this.f1370d.setSelection(this.f1375i);
        }
    }

    /* renamed from: f */
    private boolean m922f() {
        if (!m920d()) {
            return false;
        }
        removeView(this.f1370d);
        addView(this.f1369c, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f1370d.getSelectedItemPosition());
        return false;
    }

    public void addTab(ActionBar.Tab tab, boolean z) {
        C0291d c = mo2593c(tab, false);
        this.f1369c.addView(c, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner spinner = this.f1370d;
        if (spinner != null) {
            ((C0289b) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            c.setSelected(true);
        }
        if (this.f1371e) {
            requestLayout();
        }
    }

    public void animateToTab(int i) {
        View childAt = this.f1369c.getChildAt(i);
        Runnable runnable = this.f1367a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        C0288a aVar = new C0288a(childAt);
        this.f1367a = aVar;
        post(aVar);
    }

    public void animateToVisibility(int i) {
        ViewPropertyAnimator viewPropertyAnimator = this.mVisibilityAnim;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            ViewPropertyAnimator alpha = animate().alpha(1.0f);
            alpha.setDuration(200);
            alpha.setInterpolator(f1366j);
            alpha.setListener(this.mVisAnimListener.withFinalVisibility(alpha, i));
            alpha.start();
            return;
        }
        ViewPropertyAnimator alpha2 = animate().alpha(0.0f);
        alpha2.setDuration(200);
        alpha2.setInterpolator(f1366j);
        alpha2.setListener(this.mVisAnimListener.withFinalVisibility(alpha2, i));
        alpha2.start();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C0291d mo2593c(ActionBar.Tab tab, boolean z) {
        C0291d dVar = new C0291d(getContext(), tab, z);
        if (z) {
            dVar.setBackgroundDrawable((Drawable) null);
            dVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.f1374h));
        } else {
            dVar.setFocusable(true);
            if (this.f1368b == null) {
                this.f1368b = new C0290c();
            }
            dVar.setOnClickListener(this.f1368b);
        }
        return dVar;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f1367a;
        if (runnable != null) {
            post(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(getContext());
        setContentHeight(actionBarPolicy.getTabContainerHeight());
        this.f1373g = actionBarPolicy.getStackedTabMaxWidth();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f1367a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((C0291d) view).mo2617b().select();
    }

    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        boolean z = true;
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        int childCount = this.f1369c.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f1372f = -1;
        } else {
            if (childCount > 2) {
                this.f1372f = (int) (((float) View.MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.f1372f = View.MeasureSpec.getSize(i) / 2;
            }
            this.f1372f = Math.min(this.f1372f, this.f1373g);
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f1374h, 1073741824);
        if (z2 || !this.f1371e) {
            z = false;
        }
        if (z) {
            this.f1369c.measure(0, makeMeasureSpec);
            if (this.f1369c.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                m921e();
            } else {
                m922f();
            }
        } else {
            m922f();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (z2 && measuredWidth != measuredWidth2) {
            setTabSelected(this.f1375i);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void removeAllTabs() {
        this.f1369c.removeAllViews();
        Spinner spinner = this.f1370d;
        if (spinner != null) {
            ((C0289b) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.f1371e) {
            requestLayout();
        }
    }

    public void removeTabAt(int i) {
        this.f1369c.removeViewAt(i);
        Spinner spinner = this.f1370d;
        if (spinner != null) {
            ((C0289b) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.f1371e) {
            requestLayout();
        }
    }

    public void setAllowCollapse(boolean z) {
        this.f1371e = z;
    }

    public void setContentHeight(int i) {
        this.f1374h = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        this.f1375i = i;
        int childCount = this.f1369c.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.f1369c.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                animateToTab(i);
            }
            i2++;
        }
        Spinner spinner = this.f1370d;
        if (spinner != null && i >= 0) {
            spinner.setSelection(i);
        }
    }

    public void updateTab(int i) {
        ((C0291d) this.f1369c.getChildAt(i)).mo2618c();
        Spinner spinner = this.f1370d;
        if (spinner != null) {
            ((C0289b) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.f1371e) {
            requestLayout();
        }
    }

    public void addTab(ActionBar.Tab tab, int i, boolean z) {
        C0291d c = mo2593c(tab, false);
        this.f1369c.addView(c, i, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner spinner = this.f1370d;
        if (spinner != null) {
            ((C0289b) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            c.setSelected(true);
        }
        if (this.f1371e) {
            requestLayout();
        }
    }
}
