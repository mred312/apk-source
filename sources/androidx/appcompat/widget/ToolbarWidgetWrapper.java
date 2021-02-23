package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0131R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ToolbarWidgetWrapper implements DecorToolbar {

    /* renamed from: a */
    Toolbar f1581a;

    /* renamed from: b */
    private int f1582b;

    /* renamed from: c */
    private View f1583c;

    /* renamed from: d */
    private Spinner f1584d;

    /* renamed from: e */
    private View f1585e;

    /* renamed from: f */
    private Drawable f1586f;

    /* renamed from: g */
    private Drawable f1587g;

    /* renamed from: h */
    private Drawable f1588h;

    /* renamed from: i */
    private boolean f1589i;

    /* renamed from: j */
    CharSequence f1590j;

    /* renamed from: k */
    private CharSequence f1591k;

    /* renamed from: l */
    private CharSequence f1592l;

    /* renamed from: m */
    Window.Callback f1593m;

    /* renamed from: n */
    boolean f1594n;

    /* renamed from: o */
    private ActionMenuPresenter f1595o;

    /* renamed from: p */
    private int f1596p;

    /* renamed from: q */
    private int f1597q;

    /* renamed from: r */
    private Drawable f1598r;

    /* renamed from: androidx.appcompat.widget.ToolbarWidgetWrapper$a */
    class C0314a implements View.OnClickListener {

        /* renamed from: a */
        final ActionMenuItem f1599a;

        C0314a() {
            this.f1599a = new ActionMenuItem(ToolbarWidgetWrapper.this.f1581a.getContext(), 0, 16908332, 0, 0, ToolbarWidgetWrapper.this.f1590j);
        }

        public void onClick(View view) {
            ToolbarWidgetWrapper toolbarWidgetWrapper = ToolbarWidgetWrapper.this;
            Window.Callback callback = toolbarWidgetWrapper.f1593m;
            if (callback != null && toolbarWidgetWrapper.f1594n) {
                callback.onMenuItemSelected(0, this.f1599a);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ToolbarWidgetWrapper$b */
    class C0315b extends ViewPropertyAnimatorListenerAdapter {

        /* renamed from: a */
        private boolean f1601a = false;

        /* renamed from: b */
        final /* synthetic */ int f1602b;

        C0315b(int i) {
            this.f1602b = i;
        }

        public void onAnimationCancel(View view) {
            this.f1601a = true;
        }

        public void onAnimationEnd(View view) {
            if (!this.f1601a) {
                ToolbarWidgetWrapper.this.f1581a.setVisibility(this.f1602b);
            }
        }

        public void onAnimationStart(View view) {
            ToolbarWidgetWrapper.this.f1581a.setVisibility(0);
        }
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z) {
        this(toolbar, z, C0131R.string.abc_action_bar_up_description, C0131R.C0132drawable.abc_ic_ab_back_material);
    }

    /* renamed from: a */
    private int m1019a() {
        if (this.f1581a.getNavigationIcon() == null) {
            return 11;
        }
        this.f1598r = this.f1581a.getNavigationIcon();
        return 15;
    }

    /* renamed from: b */
    private void m1020b() {
        if (this.f1584d == null) {
            this.f1584d = new AppCompatSpinner(getContext(), (AttributeSet) null, C0131R.attr.actionDropDownStyle);
            this.f1584d.setLayoutParams(new Toolbar.LayoutParams(-2, -2, 8388627));
        }
    }

    /* renamed from: c */
    private void m1021c(CharSequence charSequence) {
        this.f1590j = charSequence;
        if ((this.f1582b & 8) != 0) {
            this.f1581a.setTitle(charSequence);
        }
    }

    /* renamed from: d */
    private void m1022d() {
        if ((this.f1582b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f1592l)) {
            this.f1581a.setNavigationContentDescription(this.f1597q);
        } else {
            this.f1581a.setNavigationContentDescription(this.f1592l);
        }
    }

    /* renamed from: e */
    private void m1023e() {
        if ((this.f1582b & 4) != 0) {
            Toolbar toolbar = this.f1581a;
            Drawable drawable = this.f1588h;
            if (drawable == null) {
                drawable = this.f1598r;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f1581a.setNavigationIcon((Drawable) null);
    }

    /* renamed from: f */
    private void m1024f() {
        Drawable drawable;
        int i = this.f1582b;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) != 0) {
            drawable = this.f1587g;
            if (drawable == null) {
                drawable = this.f1586f;
            }
        } else {
            drawable = this.f1586f;
        }
        this.f1581a.setLogo(drawable);
    }

    public void animateToVisibility(int i) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = setupAnimatorToVisibility(i, 200);
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.start();
        }
    }

    public boolean canShowOverflowMenu() {
        return this.f1581a.canShowOverflowMenu();
    }

    public void collapseActionView() {
        this.f1581a.collapseActionView();
    }

    public void dismissPopupMenus() {
        this.f1581a.dismissPopupMenus();
    }

    public Context getContext() {
        return this.f1581a.getContext();
    }

    public View getCustomView() {
        return this.f1585e;
    }

    public int getDisplayOptions() {
        return this.f1582b;
    }

    public int getDropdownItemCount() {
        Spinner spinner = this.f1584d;
        if (spinner != null) {
            return spinner.getCount();
        }
        return 0;
    }

    public int getDropdownSelectedPosition() {
        Spinner spinner = this.f1584d;
        if (spinner != null) {
            return spinner.getSelectedItemPosition();
        }
        return 0;
    }

    public int getHeight() {
        return this.f1581a.getHeight();
    }

    public Menu getMenu() {
        return this.f1581a.getMenu();
    }

    public int getNavigationMode() {
        return this.f1596p;
    }

    public CharSequence getSubtitle() {
        return this.f1581a.getSubtitle();
    }

    public CharSequence getTitle() {
        return this.f1581a.getTitle();
    }

    public ViewGroup getViewGroup() {
        return this.f1581a;
    }

    public int getVisibility() {
        return this.f1581a.getVisibility();
    }

    public boolean hasEmbeddedTabs() {
        return this.f1583c != null;
    }

    public boolean hasExpandedActionView() {
        return this.f1581a.hasExpandedActionView();
    }

    public boolean hasIcon() {
        return this.f1586f != null;
    }

    public boolean hasLogo() {
        return this.f1587g != null;
    }

    public boolean hideOverflowMenu() {
        return this.f1581a.hideOverflowMenu();
    }

    public void initIndeterminateProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void initProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public boolean isOverflowMenuShowPending() {
        return this.f1581a.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        return this.f1581a.isOverflowMenuShowing();
    }

    public boolean isTitleTruncated() {
        return this.f1581a.isTitleTruncated();
    }

    public void restoreHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.f1581a.restoreHierarchyState(sparseArray);
    }

    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.f1581a.saveHierarchyState(sparseArray);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        ViewCompat.setBackground(this.f1581a, drawable);
    }

    public void setCollapsible(boolean z) {
        this.f1581a.setCollapsible(z);
    }

    public void setCustomView(View view) {
        View view2 = this.f1585e;
        if (!(view2 == null || (this.f1582b & 16) == 0)) {
            this.f1581a.removeView(view2);
        }
        this.f1585e = view;
        if (view != null && (this.f1582b & 16) != 0) {
            this.f1581a.addView(view);
        }
    }

    public void setDefaultNavigationContentDescription(int i) {
        if (i != this.f1597q) {
            this.f1597q = i;
            if (TextUtils.isEmpty(this.f1581a.getNavigationContentDescription())) {
                setNavigationContentDescription(this.f1597q);
            }
        }
    }

    public void setDefaultNavigationIcon(Drawable drawable) {
        if (this.f1598r != drawable) {
            this.f1598r = drawable;
            m1023e();
        }
    }

    public void setDisplayOptions(int i) {
        View view;
        int i2 = this.f1582b ^ i;
        this.f1582b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m1022d();
                }
                m1023e();
            }
            if ((i2 & 3) != 0) {
                m1024f();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f1581a.setTitle(this.f1590j);
                    this.f1581a.setSubtitle(this.f1591k);
                } else {
                    this.f1581a.setTitle((CharSequence) null);
                    this.f1581a.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) != 0 && (view = this.f1585e) != null) {
                if ((i & 16) != 0) {
                    this.f1581a.addView(view);
                } else {
                    this.f1581a.removeView(view);
                }
            }
        }
    }

    public void setDropdownParams(SpinnerAdapter spinnerAdapter, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        m1020b();
        this.f1584d.setAdapter(spinnerAdapter);
        this.f1584d.setOnItemSelectedListener(onItemSelectedListener);
    }

    public void setDropdownSelectedPosition(int i) {
        Spinner spinner = this.f1584d;
        if (spinner != null) {
            spinner.setSelection(i);
            return;
        }
        throw new IllegalStateException("Can't set dropdown selected position without an adapter");
    }

    public void setEmbeddedTabView(ScrollingTabContainerView scrollingTabContainerView) {
        Toolbar toolbar;
        View view = this.f1583c;
        if (view != null && view.getParent() == (toolbar = this.f1581a)) {
            toolbar.removeView(this.f1583c);
        }
        this.f1583c = scrollingTabContainerView;
        if (scrollingTabContainerView != null && this.f1596p == 2) {
            this.f1581a.addView(scrollingTabContainerView, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f1583c.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.gravity = 8388691;
            scrollingTabContainerView.setAllowCollapse(true);
        }
    }

    public void setHomeButtonEnabled(boolean z) {
    }

    public void setIcon(int i) {
        setIcon(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setLogo(int i) {
        setLogo(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        if (this.f1595o == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.f1581a.getContext());
            this.f1595o = actionMenuPresenter;
            actionMenuPresenter.setId(C0131R.C0133id.action_menu_presenter);
        }
        this.f1595o.setCallback(callback);
        this.f1581a.setMenu((MenuBuilder) menu, this.f1595o);
    }

    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.f1581a.setMenuCallbacks(callback, callback2);
    }

    public void setMenuPrepared() {
        this.f1594n = true;
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        this.f1592l = charSequence;
        m1022d();
    }

    public void setNavigationIcon(Drawable drawable) {
        this.f1588h = drawable;
        m1023e();
    }

    public void setNavigationMode(int i) {
        Toolbar toolbar;
        View view;
        Toolbar toolbar2;
        int i2 = this.f1596p;
        if (i != i2) {
            if (i2 == 1) {
                Spinner spinner = this.f1584d;
                if (spinner != null && spinner.getParent() == (toolbar = this.f1581a)) {
                    toolbar.removeView(this.f1584d);
                }
            } else if (i2 == 2 && (view = this.f1583c) != null && view.getParent() == (toolbar2 = this.f1581a)) {
                toolbar2.removeView(this.f1583c);
            }
            this.f1596p = i;
            if (i == 0) {
                return;
            }
            if (i == 1) {
                m1020b();
                this.f1581a.addView(this.f1584d, 0);
            } else if (i == 2) {
                View view2 = this.f1583c;
                if (view2 != null) {
                    this.f1581a.addView(view2, 0);
                    Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f1583c.getLayoutParams();
                    layoutParams.width = -2;
                    layoutParams.height = -2;
                    layoutParams.gravity = 8388691;
                }
            } else {
                throw new IllegalArgumentException("Invalid navigation mode " + i);
            }
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1591k = charSequence;
        if ((this.f1582b & 8) != 0) {
            this.f1581a.setSubtitle(charSequence);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.f1589i = true;
        m1021c(charSequence);
    }

    public void setVisibility(int i) {
        this.f1581a.setVisibility(i);
    }

    public void setWindowCallback(Window.Callback callback) {
        this.f1593m = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        if (!this.f1589i) {
            m1021c(charSequence);
        }
    }

    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(int i, long j) {
        return ViewCompat.animate(this.f1581a).alpha(i == 0 ? 1.0f : 0.0f).setDuration(j).setListener(new C0315b(i));
    }

    public boolean showOverflowMenu() {
        return this.f1581a.showOverflowMenu();
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z, int i, int i2) {
        Drawable drawable;
        this.f1596p = 0;
        this.f1597q = 0;
        this.f1581a = toolbar;
        this.f1590j = toolbar.getTitle();
        this.f1591k = toolbar.getSubtitle();
        this.f1589i = this.f1590j != null;
        this.f1588h = toolbar.getNavigationIcon();
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(toolbar.getContext(), (AttributeSet) null, C0131R.styleable.ActionBar, C0131R.attr.actionBarStyle, 0);
        this.f1598r = obtainStyledAttributes.getDrawable(C0131R.styleable.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence text = obtainStyledAttributes.getText(C0131R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(text)) {
                setTitle(text);
            }
            CharSequence text2 = obtainStyledAttributes.getText(C0131R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(text2)) {
                setSubtitle(text2);
            }
            Drawable drawable2 = obtainStyledAttributes.getDrawable(C0131R.styleable.ActionBar_logo);
            if (drawable2 != null) {
                setLogo(drawable2);
            }
            Drawable drawable3 = obtainStyledAttributes.getDrawable(C0131R.styleable.ActionBar_icon);
            if (drawable3 != null) {
                setIcon(drawable3);
            }
            if (this.f1588h == null && (drawable = this.f1598r) != null) {
                setNavigationIcon(drawable);
            }
            setDisplayOptions(obtainStyledAttributes.getInt(C0131R.styleable.ActionBar_displayOptions, 0));
            int resourceId = obtainStyledAttributes.getResourceId(C0131R.styleable.ActionBar_customNavigationLayout, 0);
            if (resourceId != 0) {
                setCustomView(LayoutInflater.from(this.f1581a.getContext()).inflate(resourceId, this.f1581a, false));
                setDisplayOptions(this.f1582b | 16);
            }
            int layoutDimension = obtainStyledAttributes.getLayoutDimension(C0131R.styleable.ActionBar_height, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = this.f1581a.getLayoutParams();
                layoutParams.height = layoutDimension;
                this.f1581a.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(C0131R.styleable.ActionBar_contentInsetStart, -1);
            int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(C0131R.styleable.ActionBar_contentInsetEnd, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                this.f1581a.setContentInsetsRelative(Math.max(dimensionPixelOffset, 0), Math.max(dimensionPixelOffset2, 0));
            }
            int resourceId2 = obtainStyledAttributes.getResourceId(C0131R.styleable.ActionBar_titleTextStyle, 0);
            if (resourceId2 != 0) {
                Toolbar toolbar2 = this.f1581a;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), resourceId2);
            }
            int resourceId3 = obtainStyledAttributes.getResourceId(C0131R.styleable.ActionBar_subtitleTextStyle, 0);
            if (resourceId3 != 0) {
                Toolbar toolbar3 = this.f1581a;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), resourceId3);
            }
            int resourceId4 = obtainStyledAttributes.getResourceId(C0131R.styleable.ActionBar_popupTheme, 0);
            if (resourceId4 != 0) {
                this.f1581a.setPopupTheme(resourceId4);
            }
        } else {
            this.f1582b = m1019a();
        }
        obtainStyledAttributes.recycle();
        setDefaultNavigationContentDescription(i);
        this.f1592l = this.f1581a.getNavigationContentDescription();
        this.f1581a.setNavigationOnClickListener(new C0314a());
    }

    public void setIcon(Drawable drawable) {
        this.f1586f = drawable;
        m1024f();
    }

    public void setLogo(Drawable drawable) {
        this.f1587g = drawable;
        m1024f();
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription((CharSequence) i == 0 ? null : getContext().getString(i));
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }
}
