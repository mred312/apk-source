package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.C0131R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {

    /* renamed from: A */
    private ColorStateList f1531A;

    /* renamed from: B */
    private boolean f1532B;

    /* renamed from: C */
    private boolean f1533C;

    /* renamed from: D */
    private final ArrayList<View> f1534D;

    /* renamed from: E */
    private final ArrayList<View> f1535E;

    /* renamed from: F */
    private final int[] f1536F;

    /* renamed from: G */
    OnMenuItemClickListener f1537G;

    /* renamed from: H */
    private final ActionMenuView.OnMenuItemClickListener f1538H;

    /* renamed from: I */
    private ToolbarWidgetWrapper f1539I;

    /* renamed from: J */
    private ActionMenuPresenter f1540J;

    /* renamed from: K */
    private C0313d f1541K;

    /* renamed from: L */
    private MenuPresenter.Callback f1542L;

    /* renamed from: M */
    private MenuBuilder.Callback f1543M;

    /* renamed from: N */
    private boolean f1544N;

    /* renamed from: O */
    private final Runnable f1545O;

    /* renamed from: a */
    private ActionMenuView f1546a;

    /* renamed from: b */
    private TextView f1547b;

    /* renamed from: c */
    private TextView f1548c;

    /* renamed from: d */
    private ImageButton f1549d;

    /* renamed from: e */
    private ImageView f1550e;

    /* renamed from: f */
    private Drawable f1551f;

    /* renamed from: g */
    private CharSequence f1552g;

    /* renamed from: h */
    ImageButton f1553h;

    /* renamed from: i */
    View f1554i;

    /* renamed from: j */
    private Context f1555j;

    /* renamed from: k */
    private int f1556k;

    /* renamed from: l */
    private int f1557l;

    /* renamed from: m */
    private int f1558m;

    /* renamed from: n */
    int f1559n;

    /* renamed from: o */
    private int f1560o;

    /* renamed from: p */
    private int f1561p;

    /* renamed from: q */
    private int f1562q;

    /* renamed from: r */
    private int f1563r;

    /* renamed from: s */
    private int f1564s;

    /* renamed from: t */
    private C0334m f1565t;

    /* renamed from: u */
    private int f1566u;

    /* renamed from: v */
    private int f1567v;

    /* renamed from: w */
    private int f1568w;

    /* renamed from: x */
    private CharSequence f1569x;

    /* renamed from: y */
    private CharSequence f1570y;

    /* renamed from: z */
    private ColorStateList f1571z;

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0309a();

        /* renamed from: b */
        int f1573b;

        /* renamed from: c */
        boolean f1574c;

        /* renamed from: androidx.appcompat.widget.Toolbar$SavedState$a */
        class C0309a implements Parcelable.ClassLoaderCreator<SavedState> {
            C0309a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1573b);
            parcel.writeInt(this.f1574c ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1573b = parcel.readInt();
            this.f1574c = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$a */
    class C0310a implements ActionMenuView.OnMenuItemClickListener {
        C0310a() {
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            OnMenuItemClickListener onMenuItemClickListener = Toolbar.this.f1537G;
            if (onMenuItemClickListener != null) {
                return onMenuItemClickListener.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$b */
    class C0311b implements Runnable {
        C0311b() {
        }

        public void run() {
            Toolbar.this.showOverflowMenu();
        }
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$c */
    class C0312c implements View.OnClickListener {
        C0312c() {
        }

        public void onClick(View view) {
            Toolbar.this.collapseActionView();
        }
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$d */
    private class C0313d implements MenuPresenter {

        /* renamed from: a */
        MenuBuilder f1578a;

        /* renamed from: b */
        MenuItemImpl f1579b;

        C0313d() {
        }

        public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            View view = Toolbar.this.f1554i;
            if (view instanceof CollapsibleActionView) {
                ((CollapsibleActionView) view).onActionViewCollapsed();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f1554i);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f1553h);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f1554i = null;
            toolbar3.mo2819a();
            this.f1579b = null;
            Toolbar.this.requestLayout();
            menuItemImpl.setActionViewExpanded(false);
            return true;
        }

        public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            Toolbar.this.mo2823d();
            ViewParent parent = Toolbar.this.f1553h.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f1553h);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f1553h);
            }
            Toolbar.this.f1554i = menuItemImpl.getActionView();
            this.f1579b = menuItemImpl;
            ViewParent parent2 = Toolbar.this.f1554i.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f1554i);
                }
                LayoutParams generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                generateDefaultLayoutParams.gravity = 8388611 | (toolbar4.f1559n & 112);
                generateDefaultLayoutParams.f1572a = 2;
                toolbar4.f1554i.setLayoutParams(generateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f1554i);
            }
            Toolbar.this.mo2911v();
            Toolbar.this.requestLayout();
            menuItemImpl.setActionViewExpanded(true);
            View view = Toolbar.this.f1554i;
            if (view instanceof CollapsibleActionView) {
                ((CollapsibleActionView) view).onActionViewExpanded();
            }
            return true;
        }

        public boolean flagActionItems() {
            return false;
        }

        public int getId() {
            return 0;
        }

        public MenuView getMenuView(ViewGroup viewGroup) {
            return null;
        }

        public void initForMenu(Context context, MenuBuilder menuBuilder) {
            MenuItemImpl menuItemImpl;
            MenuBuilder menuBuilder2 = this.f1578a;
            if (!(menuBuilder2 == null || (menuItemImpl = this.f1579b) == null)) {
                menuBuilder2.collapseItemActionView(menuItemImpl);
            }
            this.f1578a = menuBuilder;
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            return false;
        }

        public void setCallback(MenuPresenter.Callback callback) {
        }

        public void updateMenuView(boolean z) {
            if (this.f1579b != null) {
                MenuBuilder menuBuilder = this.f1578a;
                boolean z2 = false;
                if (menuBuilder != null) {
                    int size = menuBuilder.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (this.f1578a.getItem(i) == this.f1579b) {
                            z2 = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                if (!z2) {
                    collapseItemActionView(this.f1578a, this.f1579b);
                }
            }
        }
    }

    public Toolbar(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* renamed from: b */
    private void m991b(List<View> list, int i) {
        boolean z = ViewCompat.getLayoutDirection(this) == 1;
        int childCount = getChildCount();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        list.clear();
        if (z) {
            for (int i2 = childCount - 1; i2 >= 0; i2--) {
                View childAt = getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f1572a == 0 && m1011x(childAt) && m998j(layoutParams.gravity) == absoluteGravity) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = getChildAt(i3);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.f1572a == 0 && m1011x(childAt2) && m998j(layoutParams2.gravity) == absoluteGravity) {
                list.add(childAt2);
            }
        }
    }

    /* renamed from: c */
    private void m992c(View view, boolean z) {
        LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams2)) {
            layoutParams = generateLayoutParams(layoutParams2);
        } else {
            layoutParams = (LayoutParams) layoutParams2;
        }
        layoutParams.f1572a = 1;
        if (!z || this.f1554i == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.f1535E.add(view);
    }

    /* renamed from: e */
    private void m993e() {
        if (this.f1565t == null) {
            this.f1565t = new C0334m();
        }
    }

    /* renamed from: f */
    private void m994f() {
        if (this.f1550e == null) {
            this.f1550e = new AppCompatImageView(getContext());
        }
    }

    /* renamed from: g */
    private void m995g() {
        m996h();
        if (this.f1546a.peekMenu() == null) {
            MenuBuilder menuBuilder = (MenuBuilder) this.f1546a.getMenu();
            if (this.f1541K == null) {
                this.f1541K = new C0313d();
            }
            this.f1546a.setExpandedActionViewsExclusive(true);
            menuBuilder.addMenuPresenter(this.f1541K, this.f1555j);
        }
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    /* renamed from: h */
    private void m996h() {
        if (this.f1546a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f1546a = actionMenuView;
            actionMenuView.setPopupTheme(this.f1556k);
            this.f1546a.setOnMenuItemClickListener(this.f1538H);
            this.f1546a.setMenuCallbacks(this.f1542L, this.f1543M);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = 8388613 | (this.f1559n & 112);
            this.f1546a.setLayoutParams(generateDefaultLayoutParams);
            m992c(this.f1546a, false);
        }
    }

    /* renamed from: i */
    private void m997i() {
        if (this.f1549d == null) {
            this.f1549d = new AppCompatImageButton(getContext(), (AttributeSet) null, C0131R.attr.toolbarNavigationButtonStyle);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = 8388611 | (this.f1559n & 112);
            this.f1549d.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    /* renamed from: j */
    private int m998j(int i) {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, layoutDirection) & 7;
        if (absoluteGravity == 1 || absoluteGravity == 3 || absoluteGravity == 5) {
            return absoluteGravity;
        }
        return layoutDirection == 1 ? 5 : 3;
    }

    /* renamed from: k */
    private int m999k(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int l = m1000l(layoutParams.gravity);
        if (l == 48) {
            return getPaddingTop() - i2;
        }
        if (l == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i3 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i4 = layoutParams.topMargin;
        if (i3 < i4) {
            i3 = i4;
        } else {
            int i5 = (((height - paddingBottom) - measuredHeight) - i3) - paddingTop;
            int i6 = layoutParams.bottomMargin;
            if (i5 < i6) {
                i3 = Math.max(0, i3 - (i6 - i5));
            }
        }
        return paddingTop + i3;
    }

    /* renamed from: l */
    private int m1000l(int i) {
        int i2 = i & 112;
        return (i2 == 16 || i2 == 48 || i2 == 80) ? i2 : this.f1568w & 112;
    }

    /* renamed from: m */
    private int m1001m(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return MarginLayoutParamsCompat.getMarginStart(marginLayoutParams) + MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams);
    }

    /* renamed from: n */
    private int m1002n(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    /* renamed from: o */
    private int m1003o(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            View view = list.get(i3);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i5 = layoutParams.leftMargin - i;
            int i6 = layoutParams.rightMargin - i2;
            int max = Math.max(0, i5);
            int max2 = Math.max(0, i6);
            int max3 = Math.max(0, -i5);
            int max4 = Math.max(0, -i6);
            i4 += max + view.getMeasuredWidth() + max2;
            i3++;
            i2 = max4;
            i = max3;
        }
        return i4;
    }

    /* renamed from: p */
    private boolean m1004p(View view) {
        return view.getParent() == this || this.f1535E.contains(view);
    }

    /* renamed from: q */
    private int m1005q(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.leftMargin - iArr[0];
        int max = i + Math.max(0, i3);
        iArr[0] = Math.max(0, -i3);
        int k = m999k(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, k, max + measuredWidth, view.getMeasuredHeight() + k);
        return max + measuredWidth + layoutParams.rightMargin;
    }

    /* renamed from: r */
    private int m1006r(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int k = m999k(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, k, max, view.getMeasuredHeight() + k);
        return max - (measuredWidth + layoutParams.leftMargin);
    }

    /* renamed from: s */
    private int m1007s(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + max + i2, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    /* renamed from: t */
    private void m1008t(View view, int i, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    /* renamed from: u */
    private void m1009u() {
        removeCallbacks(this.f1545O);
        post(this.f1545O);
    }

    /* renamed from: w */
    private boolean m1010w() {
        if (!this.f1544N) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m1011x(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: x */
    private boolean m1011x(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2819a() {
        for (int size = this.f1535E.size() - 1; size >= 0; size--) {
            addView(this.f1535E.get(size));
        }
        this.f1535E.clear();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.f1546a;
     */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean canShowOverflowMenu() {
        /*
            r1 = this;
            int r0 = r1.getVisibility()
            if (r0 != 0) goto L_0x0012
            androidx.appcompat.widget.ActionMenuView r0 = r1.f1546a
            if (r0 == 0) goto L_0x0012
            boolean r0 = r0.isOverflowReserved()
            if (r0 == 0) goto L_0x0012
            r0 = 1
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.canShowOverflowMenu():boolean");
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public void collapseActionView() {
        MenuItemImpl menuItemImpl;
        C0313d dVar = this.f1541K;
        if (dVar == null) {
            menuItemImpl = null;
        } else {
            menuItemImpl = dVar.f1579b;
        }
        if (menuItemImpl != null) {
            menuItemImpl.collapseActionView();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo2823d() {
        if (this.f1553h == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext(), (AttributeSet) null, C0131R.attr.toolbarNavigationButtonStyle);
            this.f1553h = appCompatImageButton;
            appCompatImageButton.setImageDrawable(this.f1551f);
            this.f1553h.setContentDescription(this.f1552g);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = 8388611 | (this.f1559n & 112);
            generateDefaultLayoutParams.f1572a = 2;
            this.f1553h.setLayoutParams(generateDefaultLayoutParams);
            this.f1553h.setOnClickListener(new C0312c());
        }
    }

    public void dismissPopupMenus() {
        ActionMenuView actionMenuView = this.f1546a;
        if (actionMenuView != null) {
            actionMenuView.dismissPopupMenus();
        }
    }

    @Nullable
    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f1553h;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    @Nullable
    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f1553h;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        C0334m mVar = this.f1565t;
        if (mVar != null) {
            return mVar.mo3063a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i = this.f1567v;
        return i != Integer.MIN_VALUE ? i : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        C0334m mVar = this.f1565t;
        if (mVar != null) {
            return mVar.mo3064b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        C0334m mVar = this.f1565t;
        if (mVar != null) {
            return mVar.mo3065c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        C0334m mVar = this.f1565t;
        if (mVar != null) {
            return mVar.mo3066d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.f1566u;
        return i != Integer.MIN_VALUE ? i : getContentInsetStart();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.peekMenu();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getCurrentContentInsetEnd() {
        /*
            r3 = this;
            androidx.appcompat.widget.ActionMenuView r0 = r3.f1546a
            r1 = 0
            if (r0 == 0) goto L_0x0013
            androidx.appcompat.view.menu.MenuBuilder r0 = r0.peekMenu()
            if (r0 == 0) goto L_0x0013
            boolean r0 = r0.hasVisibleItems()
            if (r0 == 0) goto L_0x0013
            r0 = 1
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            if (r0 == 0) goto L_0x0025
            int r0 = r3.getContentInsetEnd()
            int r2 = r3.f1567v
            int r1 = java.lang.Math.max(r2, r1)
            int r0 = java.lang.Math.max(r0, r1)
            goto L_0x0029
        L_0x0025:
            int r0 = r3.getContentInsetEnd()
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.getCurrentContentInsetEnd():int");
    }

    public int getCurrentContentInsetLeft() {
        if (ViewCompat.getLayoutDirection(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (ViewCompat.getLayoutDirection(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.f1566u, 0));
        }
        return getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f1550e;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f1550e;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        m995g();
        return this.f1546a.getMenu();
    }

    @Nullable
    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f1549d;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    @Nullable
    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f1549d;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.f1540J;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        m995g();
        return this.f1546a.getOverflowIcon();
    }

    /* access modifiers changed from: package-private */
    public Context getPopupContext() {
        return this.f1555j;
    }

    public int getPopupTheme() {
        return this.f1556k;
    }

    public CharSequence getSubtitle() {
        return this.f1570y;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    @RestrictTo({RestrictTo.Scope.TESTS})
    public final TextView getSubtitleTextView() {
        return this.f1548c;
    }

    public CharSequence getTitle() {
        return this.f1569x;
    }

    public int getTitleMarginBottom() {
        return this.f1564s;
    }

    public int getTitleMarginEnd() {
        return this.f1562q;
    }

    public int getTitleMarginStart() {
        return this.f1561p;
    }

    public int getTitleMarginTop() {
        return this.f1563r;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    @RestrictTo({RestrictTo.Scope.TESTS})
    public final TextView getTitleTextView() {
        return this.f1547b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DecorToolbar getWrapper() {
        if (this.f1539I == null) {
            this.f1539I = new ToolbarWidgetWrapper(this, true);
        }
        return this.f1539I;
    }

    public boolean hasExpandedActionView() {
        C0313d dVar = this.f1541K;
        return (dVar == null || dVar.f1579b == null) ? false : true;
    }

    public boolean hideOverflowMenu() {
        ActionMenuView actionMenuView = this.f1546a;
        return actionMenuView != null && actionMenuView.hideOverflowMenu();
    }

    public void inflateMenu(@MenuRes int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isOverflowMenuShowPending() {
        ActionMenuView actionMenuView = this.f1546a;
        return actionMenuView != null && actionMenuView.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuView actionMenuView = this.f1546a;
        return actionMenuView != null && actionMenuView.isOverflowMenuShowing();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isTitleTruncated() {
        Layout layout;
        TextView textView = this.f1547b;
        if (textView == null || (layout = textView.getLayout()) == null) {
            return false;
        }
        int lineCount = layout.getLineCount();
        for (int i = 0; i < lineCount; i++) {
            if (layout.getEllipsisCount(i) > 0) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f1545O);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1533C = false;
        }
        if (!this.f1533C) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f1533C = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1533C = false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x02a3 A[LOOP:0: B:101:0x02a1->B:102:0x02a3, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02c5 A[LOOP:1: B:104:0x02c3->B:105:0x02c5, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02ef  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02fe A[LOOP:2: B:112:0x02fc->B:113:0x02fe, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0229  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            r19 = this;
            r0 = r19
            int r1 = androidx.core.view.ViewCompat.getLayoutDirection(r19)
            r2 = 1
            r3 = 0
            if (r1 != r2) goto L_0x000c
            r1 = 1
            goto L_0x000d
        L_0x000c:
            r1 = 0
        L_0x000d:
            int r4 = r19.getWidth()
            int r5 = r19.getHeight()
            int r6 = r19.getPaddingLeft()
            int r7 = r19.getPaddingRight()
            int r8 = r19.getPaddingTop()
            int r9 = r19.getPaddingBottom()
            int r10 = r4 - r7
            int[] r11 = r0.f1536F
            r11[r2] = r3
            r11[r3] = r3
            int r12 = androidx.core.view.ViewCompat.getMinimumHeight(r19)
            if (r12 < 0) goto L_0x003a
            int r13 = r24 - r22
            int r12 = java.lang.Math.min(r12, r13)
            goto L_0x003b
        L_0x003a:
            r12 = 0
        L_0x003b:
            android.widget.ImageButton r13 = r0.f1549d
            boolean r13 = r0.m1011x(r13)
            if (r13 == 0) goto L_0x0055
            if (r1 == 0) goto L_0x004e
            android.widget.ImageButton r13 = r0.f1549d
            int r13 = r0.m1006r(r13, r10, r11, r12)
            r14 = r13
            r13 = r6
            goto L_0x0057
        L_0x004e:
            android.widget.ImageButton r13 = r0.f1549d
            int r13 = r0.m1005q(r13, r6, r11, r12)
            goto L_0x0056
        L_0x0055:
            r13 = r6
        L_0x0056:
            r14 = r10
        L_0x0057:
            android.widget.ImageButton r15 = r0.f1553h
            boolean r15 = r0.m1011x(r15)
            if (r15 == 0) goto L_0x006e
            if (r1 == 0) goto L_0x0068
            android.widget.ImageButton r15 = r0.f1553h
            int r14 = r0.m1006r(r15, r14, r11, r12)
            goto L_0x006e
        L_0x0068:
            android.widget.ImageButton r15 = r0.f1553h
            int r13 = r0.m1005q(r15, r13, r11, r12)
        L_0x006e:
            androidx.appcompat.widget.ActionMenuView r15 = r0.f1546a
            boolean r15 = r0.m1011x(r15)
            if (r15 == 0) goto L_0x0085
            if (r1 == 0) goto L_0x007f
            androidx.appcompat.widget.ActionMenuView r15 = r0.f1546a
            int r13 = r0.m1005q(r15, r13, r11, r12)
            goto L_0x0085
        L_0x007f:
            androidx.appcompat.widget.ActionMenuView r15 = r0.f1546a
            int r14 = r0.m1006r(r15, r14, r11, r12)
        L_0x0085:
            int r15 = r19.getCurrentContentInsetLeft()
            int r16 = r19.getCurrentContentInsetRight()
            int r2 = r15 - r13
            int r2 = java.lang.Math.max(r3, r2)
            r11[r3] = r2
            int r2 = r10 - r14
            int r2 = r16 - r2
            int r2 = java.lang.Math.max(r3, r2)
            r17 = 1
            r11[r17] = r2
            int r2 = java.lang.Math.max(r13, r15)
            int r10 = r10 - r16
            int r10 = java.lang.Math.min(r14, r10)
            android.view.View r13 = r0.f1554i
            boolean r13 = r0.m1011x(r13)
            if (r13 == 0) goto L_0x00c2
            if (r1 == 0) goto L_0x00bc
            android.view.View r13 = r0.f1554i
            int r10 = r0.m1006r(r13, r10, r11, r12)
            goto L_0x00c2
        L_0x00bc:
            android.view.View r13 = r0.f1554i
            int r2 = r0.m1005q(r13, r2, r11, r12)
        L_0x00c2:
            android.widget.ImageView r13 = r0.f1550e
            boolean r13 = r0.m1011x(r13)
            if (r13 == 0) goto L_0x00d9
            if (r1 == 0) goto L_0x00d3
            android.widget.ImageView r13 = r0.f1550e
            int r10 = r0.m1006r(r13, r10, r11, r12)
            goto L_0x00d9
        L_0x00d3:
            android.widget.ImageView r13 = r0.f1550e
            int r2 = r0.m1005q(r13, r2, r11, r12)
        L_0x00d9:
            android.widget.TextView r13 = r0.f1547b
            boolean r13 = r0.m1011x(r13)
            android.widget.TextView r14 = r0.f1548c
            boolean r14 = r0.m1011x(r14)
            if (r13 == 0) goto L_0x0100
            android.widget.TextView r15 = r0.f1547b
            android.view.ViewGroup$LayoutParams r15 = r15.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r15 = (androidx.appcompat.widget.Toolbar.LayoutParams) r15
            int r3 = r15.topMargin
            r23 = r7
            android.widget.TextView r7 = r0.f1547b
            int r7 = r7.getMeasuredHeight()
            int r3 = r3 + r7
            int r7 = r15.bottomMargin
            int r3 = r3 + r7
            r7 = 0
            int r3 = r3 + r7
            goto L_0x0103
        L_0x0100:
            r23 = r7
            r3 = 0
        L_0x0103:
            if (r14 == 0) goto L_0x011d
            android.widget.TextView r7 = r0.f1548c
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r7 = (androidx.appcompat.widget.Toolbar.LayoutParams) r7
            int r15 = r7.topMargin
            r16 = r4
            android.widget.TextView r4 = r0.f1548c
            int r4 = r4.getMeasuredHeight()
            int r15 = r15 + r4
            int r4 = r7.bottomMargin
            int r15 = r15 + r4
            int r3 = r3 + r15
            goto L_0x011f
        L_0x011d:
            r16 = r4
        L_0x011f:
            if (r13 != 0) goto L_0x012b
            if (r14 == 0) goto L_0x0124
            goto L_0x012b
        L_0x0124:
            r18 = r6
            r22 = r12
        L_0x0128:
            r1 = 0
            goto L_0x0294
        L_0x012b:
            if (r13 == 0) goto L_0x0130
            android.widget.TextView r4 = r0.f1547b
            goto L_0x0132
        L_0x0130:
            android.widget.TextView r4 = r0.f1548c
        L_0x0132:
            if (r14 == 0) goto L_0x0137
            android.widget.TextView r7 = r0.f1548c
            goto L_0x0139
        L_0x0137:
            android.widget.TextView r7 = r0.f1547b
        L_0x0139:
            android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r4 = (androidx.appcompat.widget.Toolbar.LayoutParams) r4
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r7 = (androidx.appcompat.widget.Toolbar.LayoutParams) r7
            if (r13 == 0) goto L_0x014f
            android.widget.TextView r15 = r0.f1547b
            int r15 = r15.getMeasuredWidth()
            if (r15 > 0) goto L_0x0159
        L_0x014f:
            if (r14 == 0) goto L_0x015c
            android.widget.TextView r15 = r0.f1548c
            int r15 = r15.getMeasuredWidth()
            if (r15 <= 0) goto L_0x015c
        L_0x0159:
            r17 = 1
            goto L_0x015e
        L_0x015c:
            r17 = 0
        L_0x015e:
            int r15 = r0.f1568w
            r15 = r15 & 112(0x70, float:1.57E-43)
            r18 = r6
            r6 = 48
            if (r15 == r6) goto L_0x01a6
            r6 = 80
            if (r15 == r6) goto L_0x0198
            int r6 = r5 - r8
            int r6 = r6 - r9
            int r6 = r6 - r3
            int r6 = r6 / 2
            int r15 = r4.topMargin
            r22 = r12
            int r12 = r0.f1563r
            r24 = r2
            int r2 = r15 + r12
            if (r6 >= r2) goto L_0x0181
            int r6 = r15 + r12
            goto L_0x0196
        L_0x0181:
            int r5 = r5 - r9
            int r5 = r5 - r3
            int r5 = r5 - r6
            int r5 = r5 - r8
            int r2 = r4.bottomMargin
            int r3 = r0.f1564s
            int r2 = r2 + r3
            if (r5 >= r2) goto L_0x0196
            int r2 = r7.bottomMargin
            int r2 = r2 + r3
            int r2 = r2 - r5
            int r6 = r6 - r2
            r2 = 0
            int r6 = java.lang.Math.max(r2, r6)
        L_0x0196:
            int r8 = r8 + r6
            goto L_0x01b5
        L_0x0198:
            r24 = r2
            r22 = r12
            int r5 = r5 - r9
            int r2 = r7.bottomMargin
            int r5 = r5 - r2
            int r2 = r0.f1564s
            int r5 = r5 - r2
            int r8 = r5 - r3
            goto L_0x01b5
        L_0x01a6:
            r24 = r2
            r22 = r12
            int r2 = r19.getPaddingTop()
            int r3 = r4.topMargin
            int r2 = r2 + r3
            int r3 = r0.f1563r
            int r8 = r2 + r3
        L_0x01b5:
            if (r1 == 0) goto L_0x0229
            if (r17 == 0) goto L_0x01bc
            int r1 = r0.f1561p
            goto L_0x01bd
        L_0x01bc:
            r1 = 0
        L_0x01bd:
            r2 = 1
            r3 = r11[r2]
            int r1 = r1 - r3
            r3 = 0
            int r4 = java.lang.Math.max(r3, r1)
            int r10 = r10 - r4
            int r1 = -r1
            int r1 = java.lang.Math.max(r3, r1)
            r11[r2] = r1
            if (r13 == 0) goto L_0x01f4
            android.widget.TextView r1 = r0.f1547b
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r1 = (androidx.appcompat.widget.Toolbar.LayoutParams) r1
            android.widget.TextView r2 = r0.f1547b
            int r2 = r2.getMeasuredWidth()
            int r2 = r10 - r2
            android.widget.TextView r3 = r0.f1547b
            int r3 = r3.getMeasuredHeight()
            int r3 = r3 + r8
            android.widget.TextView r4 = r0.f1547b
            r4.layout(r2, r8, r10, r3)
            int r4 = r0.f1562q
            int r2 = r2 - r4
            int r1 = r1.bottomMargin
            int r8 = r3 + r1
            goto L_0x01f5
        L_0x01f4:
            r2 = r10
        L_0x01f5:
            if (r14 == 0) goto L_0x021d
            android.widget.TextView r1 = r0.f1548c
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r1 = (androidx.appcompat.widget.Toolbar.LayoutParams) r1
            int r3 = r1.topMargin
            int r8 = r8 + r3
            android.widget.TextView r3 = r0.f1548c
            int r3 = r3.getMeasuredWidth()
            int r3 = r10 - r3
            android.widget.TextView r4 = r0.f1548c
            int r4 = r4.getMeasuredHeight()
            int r4 = r4 + r8
            android.widget.TextView r5 = r0.f1548c
            r5.layout(r3, r8, r10, r4)
            int r3 = r0.f1562q
            int r3 = r10 - r3
            int r1 = r1.bottomMargin
            goto L_0x021e
        L_0x021d:
            r3 = r10
        L_0x021e:
            if (r17 == 0) goto L_0x0225
            int r1 = java.lang.Math.min(r2, r3)
            r10 = r1
        L_0x0225:
            r2 = r24
            goto L_0x0128
        L_0x0229:
            if (r17 == 0) goto L_0x022f
            int r7 = r0.f1561p
            r1 = 0
            goto L_0x0231
        L_0x022f:
            r1 = 0
            r7 = 0
        L_0x0231:
            r2 = r11[r1]
            int r7 = r7 - r2
            int r2 = java.lang.Math.max(r1, r7)
            int r2 = r24 + r2
            int r3 = -r7
            int r3 = java.lang.Math.max(r1, r3)
            r11[r1] = r3
            if (r13 == 0) goto L_0x0266
            android.widget.TextView r3 = r0.f1547b
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r3 = (androidx.appcompat.widget.Toolbar.LayoutParams) r3
            android.widget.TextView r4 = r0.f1547b
            int r4 = r4.getMeasuredWidth()
            int r4 = r4 + r2
            android.widget.TextView r5 = r0.f1547b
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 + r8
            android.widget.TextView r6 = r0.f1547b
            r6.layout(r2, r8, r4, r5)
            int r6 = r0.f1562q
            int r4 = r4 + r6
            int r3 = r3.bottomMargin
            int r8 = r5 + r3
            goto L_0x0267
        L_0x0266:
            r4 = r2
        L_0x0267:
            if (r14 == 0) goto L_0x028d
            android.widget.TextView r3 = r0.f1548c
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r3 = (androidx.appcompat.widget.Toolbar.LayoutParams) r3
            int r5 = r3.topMargin
            int r8 = r8 + r5
            android.widget.TextView r5 = r0.f1548c
            int r5 = r5.getMeasuredWidth()
            int r5 = r5 + r2
            android.widget.TextView r6 = r0.f1548c
            int r6 = r6.getMeasuredHeight()
            int r6 = r6 + r8
            android.widget.TextView r7 = r0.f1548c
            r7.layout(r2, r8, r5, r6)
            int r6 = r0.f1562q
            int r5 = r5 + r6
            int r3 = r3.bottomMargin
            goto L_0x028e
        L_0x028d:
            r5 = r2
        L_0x028e:
            if (r17 == 0) goto L_0x0294
            int r2 = java.lang.Math.max(r4, r5)
        L_0x0294:
            java.util.ArrayList<android.view.View> r3 = r0.f1534D
            r4 = 3
            r0.m991b(r3, r4)
            java.util.ArrayList<android.view.View> r3 = r0.f1534D
            int r3 = r3.size()
            r7 = 0
        L_0x02a1:
            if (r7 >= r3) goto L_0x02b4
            java.util.ArrayList<android.view.View> r4 = r0.f1534D
            java.lang.Object r4 = r4.get(r7)
            android.view.View r4 = (android.view.View) r4
            r12 = r22
            int r2 = r0.m1005q(r4, r2, r11, r12)
            int r7 = r7 + 1
            goto L_0x02a1
        L_0x02b4:
            r12 = r22
            java.util.ArrayList<android.view.View> r3 = r0.f1534D
            r4 = 5
            r0.m991b(r3, r4)
            java.util.ArrayList<android.view.View> r3 = r0.f1534D
            int r3 = r3.size()
            r7 = 0
        L_0x02c3:
            if (r7 >= r3) goto L_0x02d4
            java.util.ArrayList<android.view.View> r4 = r0.f1534D
            java.lang.Object r4 = r4.get(r7)
            android.view.View r4 = (android.view.View) r4
            int r10 = r0.m1006r(r4, r10, r11, r12)
            int r7 = r7 + 1
            goto L_0x02c3
        L_0x02d4:
            java.util.ArrayList<android.view.View> r3 = r0.f1534D
            r4 = 1
            r0.m991b(r3, r4)
            java.util.ArrayList<android.view.View> r3 = r0.f1534D
            int r3 = r0.m1003o(r3, r11)
            int r4 = r16 - r18
            int r4 = r4 - r23
            int r4 = r4 / 2
            int r6 = r18 + r4
            int r4 = r3 / 2
            int r6 = r6 - r4
            int r3 = r3 + r6
            if (r6 >= r2) goto L_0x02ef
            goto L_0x02f6
        L_0x02ef:
            if (r3 <= r10) goto L_0x02f5
            int r3 = r3 - r10
            int r2 = r6 - r3
            goto L_0x02f6
        L_0x02f5:
            r2 = r6
        L_0x02f6:
            java.util.ArrayList<android.view.View> r3 = r0.f1534D
            int r3 = r3.size()
        L_0x02fc:
            if (r1 >= r3) goto L_0x030d
            java.util.ArrayList<android.view.View> r4 = r0.f1534D
            java.lang.Object r4 = r4.get(r1)
            android.view.View r4 = (android.view.View) r4
            int r2 = r0.m1005q(r4, r2, r11, r12)
            int r1 = r1 + 1
            goto L_0x02fc
        L_0x030d:
            java.util.ArrayList<android.view.View> r1 = r0.f1534D
            r1.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        char c;
        char c2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int[] iArr = this.f1536F;
        int i10 = 0;
        if (ViewUtils.isLayoutRtl(this)) {
            c2 = 1;
            c = 0;
        } else {
            c2 = 0;
            c = 1;
        }
        if (m1011x(this.f1549d)) {
            m1008t(this.f1549d, i, 0, i2, 0, this.f1560o);
            i5 = this.f1549d.getMeasuredWidth() + m1001m(this.f1549d);
            i4 = Math.max(0, this.f1549d.getMeasuredHeight() + m1002n(this.f1549d));
            i3 = View.combineMeasuredStates(0, this.f1549d.getMeasuredState());
        } else {
            i5 = 0;
            i4 = 0;
            i3 = 0;
        }
        if (m1011x(this.f1553h)) {
            m1008t(this.f1553h, i, 0, i2, 0, this.f1560o);
            i5 = this.f1553h.getMeasuredWidth() + m1001m(this.f1553h);
            i4 = Math.max(i4, this.f1553h.getMeasuredHeight() + m1002n(this.f1553h));
            i3 = View.combineMeasuredStates(i3, this.f1553h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = 0 + Math.max(currentContentInsetStart, i5);
        iArr[c2] = Math.max(0, currentContentInsetStart - i5);
        if (m1011x(this.f1546a)) {
            m1008t(this.f1546a, i, max, i2, 0, this.f1560o);
            i6 = this.f1546a.getMeasuredWidth() + m1001m(this.f1546a);
            i4 = Math.max(i4, this.f1546a.getMeasuredHeight() + m1002n(this.f1546a));
            i3 = View.combineMeasuredStates(i3, this.f1546a.getMeasuredState());
        } else {
            i6 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i6);
        iArr[c] = Math.max(0, currentContentInsetEnd - i6);
        if (m1011x(this.f1554i)) {
            max2 += m1007s(this.f1554i, i, max2, i2, 0, iArr);
            i4 = Math.max(i4, this.f1554i.getMeasuredHeight() + m1002n(this.f1554i));
            i3 = View.combineMeasuredStates(i3, this.f1554i.getMeasuredState());
        }
        if (m1011x(this.f1550e)) {
            max2 += m1007s(this.f1550e, i, max2, i2, 0, iArr);
            i4 = Math.max(i4, this.f1550e.getMeasuredHeight() + m1002n(this.f1550e));
            i3 = View.combineMeasuredStates(i3, this.f1550e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (((LayoutParams) childAt.getLayoutParams()).f1572a == 0 && m1011x(childAt)) {
                max2 += m1007s(childAt, i, max2, i2, 0, iArr);
                i4 = Math.max(i4, childAt.getMeasuredHeight() + m1002n(childAt));
                i3 = View.combineMeasuredStates(i3, childAt.getMeasuredState());
            }
        }
        int i12 = this.f1563r + this.f1564s;
        int i13 = this.f1561p + this.f1562q;
        if (m1011x(this.f1547b)) {
            m1007s(this.f1547b, i, max2 + i13, i2, i12, iArr);
            int measuredWidth = this.f1547b.getMeasuredWidth() + m1001m(this.f1547b);
            i7 = this.f1547b.getMeasuredHeight() + m1002n(this.f1547b);
            i9 = View.combineMeasuredStates(i3, this.f1547b.getMeasuredState());
            i8 = measuredWidth;
        } else {
            i9 = i3;
            i8 = 0;
            i7 = 0;
        }
        if (m1011x(this.f1548c)) {
            int i14 = i7 + i12;
            i8 = Math.max(i8, m1007s(this.f1548c, i, max2 + i13, i2, i14, iArr));
            i7 += this.f1548c.getMeasuredHeight() + m1002n(this.f1548c);
            i9 = View.combineMeasuredStates(i9, this.f1548c.getMeasuredState());
        } else {
            int i15 = i9;
        }
        int max3 = Math.max(i4, i7);
        int paddingLeft = max2 + i8 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max3 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, -16777216 & i9);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, i9 << 16);
        if (!m1010w()) {
            i10 = resolveSizeAndState2;
        }
        setMeasuredDimension(resolveSizeAndState, i10);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        ActionMenuView actionMenuView = this.f1546a;
        MenuBuilder peekMenu = actionMenuView != null ? actionMenuView.peekMenu() : null;
        int i = savedState.f1573b;
        if (!(i == 0 || this.f1541K == null || peekMenu == null || (findItem = peekMenu.findItem(i)) == null)) {
            findItem.expandActionView();
        }
        if (savedState.f1574c) {
            m1009u();
        }
    }

    public void onRtlPropertiesChanged(int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        m993e();
        C0334m mVar = this.f1565t;
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        mVar.mo3068f(z);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        MenuItemImpl menuItemImpl;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        C0313d dVar = this.f1541K;
        if (!(dVar == null || (menuItemImpl = dVar.f1579b) == null)) {
            savedState.f1573b = menuItemImpl.getItemId();
        }
        savedState.f1574c = isOverflowMenuShowing();
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1532B = false;
        }
        if (!this.f1532B) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f1532B = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1532B = false;
        }
        return true;
    }

    public void setCollapseContentDescription(@StringRes int i) {
        setCollapseContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setCollapseIcon(@DrawableRes int i) {
        setCollapseIcon(AppCompatResources.getDrawable(getContext(), i));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setCollapsible(boolean z) {
        this.f1544N = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f1567v) {
            this.f1567v = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f1566u) {
            this.f1566u = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetsAbsolute(int i, int i2) {
        m993e();
        this.f1565t.mo3067e(i, i2);
    }

    public void setContentInsetsRelative(int i, int i2) {
        m993e();
        this.f1565t.mo3069g(i, i2);
    }

    public void setLogo(@DrawableRes int i) {
        setLogo(AppCompatResources.getDrawable(getContext(), i));
    }

    public void setLogoDescription(@StringRes int i) {
        setLogoDescription(getContext().getText(i));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setMenu(MenuBuilder menuBuilder, ActionMenuPresenter actionMenuPresenter) {
        if (menuBuilder != null || this.f1546a != null) {
            m996h();
            MenuBuilder peekMenu = this.f1546a.peekMenu();
            if (peekMenu != menuBuilder) {
                if (peekMenu != null) {
                    peekMenu.removeMenuPresenter(this.f1540J);
                    peekMenu.removeMenuPresenter(this.f1541K);
                }
                if (this.f1541K == null) {
                    this.f1541K = new C0313d();
                }
                actionMenuPresenter.mo2046q(true);
                if (menuBuilder != null) {
                    menuBuilder.addMenuPresenter(actionMenuPresenter, this.f1555j);
                    menuBuilder.addMenuPresenter(this.f1541K, this.f1555j);
                } else {
                    actionMenuPresenter.initForMenu(this.f1555j, (MenuBuilder) null);
                    this.f1541K.initForMenu(this.f1555j, (MenuBuilder) null);
                    actionMenuPresenter.updateMenuView(true);
                    this.f1541K.updateMenuView(true);
                }
                this.f1546a.setPopupTheme(this.f1556k);
                this.f1546a.setPresenter(actionMenuPresenter);
                this.f1540J = actionMenuPresenter;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.f1542L = callback;
        this.f1543M = callback2;
        ActionMenuView actionMenuView = this.f1546a;
        if (actionMenuView != null) {
            actionMenuView.setMenuCallbacks(callback, callback2);
        }
    }

    public void setNavigationContentDescription(@StringRes int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationIcon(@DrawableRes int i) {
        setNavigationIcon(AppCompatResources.getDrawable(getContext(), i));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        m997i();
        this.f1549d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f1537G = onMenuItemClickListener;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        m995g();
        this.f1546a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(@StyleRes int i) {
        if (this.f1556k != i) {
            this.f1556k = i;
            if (i == 0) {
                this.f1555j = getContext();
            } else {
                this.f1555j = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(@StringRes int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitleTextAppearance(Context context, @StyleRes int i) {
        this.f1558m = i;
        TextView textView = this.f1548c;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    public void setSubtitleTextColor(@ColorInt int i) {
        setSubtitleTextColor(ColorStateList.valueOf(i));
    }

    public void setTitle(@StringRes int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitleMargin(int i, int i2, int i3, int i4) {
        this.f1561p = i;
        this.f1563r = i2;
        this.f1562q = i3;
        this.f1564s = i4;
        requestLayout();
    }

    public void setTitleMarginBottom(int i) {
        this.f1564s = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.f1562q = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.f1561p = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.f1563r = i;
        requestLayout();
    }

    public void setTitleTextAppearance(Context context, @StyleRes int i) {
        this.f1557l = i;
        TextView textView = this.f1547b;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(@ColorInt int i) {
        setTitleTextColor(ColorStateList.valueOf(i));
    }

    public boolean showOverflowMenu() {
        ActionMenuView actionMenuView = this.f1546a;
        return actionMenuView != null && actionMenuView.showOverflowMenu();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public void mo2911v() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((LayoutParams) childAt.getLayoutParams()).f1572a == 2 || childAt == this.f1546a)) {
                removeViewAt(childCount);
                this.f1535E.add(childAt);
            }
        }
    }

    public static class LayoutParams extends ActionBar.LayoutParams {

        /* renamed from: a */
        int f1572a;

        public LayoutParams(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1572a = 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo2912a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f1572a = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.f1572a = 0;
            this.gravity = i3;
        }

        public LayoutParams(int i) {
            this(-2, -1, i);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ActionBar.LayoutParams) layoutParams);
            this.f1572a = 0;
            this.f1572a = layoutParams.f1572a;
        }

        public LayoutParams(ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1572a = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super((ViewGroup.LayoutParams) marginLayoutParams);
            this.f1572a = 0;
            mo2912a(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1572a = 0;
        }
    }

    public Toolbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, C0131R.attr.toolbarStyle);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public void setCollapseContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            mo2823d();
        }
        ImageButton imageButton = this.f1553h;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            mo2823d();
            this.f1553h.setImageDrawable(drawable);
            return;
        }
        ImageButton imageButton = this.f1553h;
        if (imageButton != null) {
            imageButton.setImageDrawable(this.f1551f);
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m994f();
            if (!m1004p(this.f1550e)) {
                m992c(this.f1550e, true);
            }
        } else {
            ImageView imageView = this.f1550e;
            if (imageView != null && m1004p(imageView)) {
                removeView(this.f1550e);
                this.f1535E.remove(this.f1550e);
            }
        }
        ImageView imageView2 = this.f1550e;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m994f();
        }
        ImageView imageView = this.f1550e;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m997i();
        }
        ImageButton imageButton = this.f1549d;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            m997i();
            if (!m1004p(this.f1549d)) {
                m992c(this.f1549d, true);
            }
        } else {
            ImageButton imageButton = this.f1549d;
            if (imageButton != null && m1004p(imageButton)) {
                removeView(this.f1549d);
                this.f1535E.remove(this.f1549d);
            }
        }
        ImageButton imageButton2 = this.f1549d;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1548c == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f1548c = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f1548c.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.f1558m;
                if (i != 0) {
                    this.f1548c.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.f1531A;
                if (colorStateList != null) {
                    this.f1548c.setTextColor(colorStateList);
                }
            }
            if (!m1004p(this.f1548c)) {
                m992c(this.f1548c, true);
            }
        } else {
            TextView textView = this.f1548c;
            if (textView != null && m1004p(textView)) {
                removeView(this.f1548c);
                this.f1535E.remove(this.f1548c);
            }
        }
        TextView textView2 = this.f1548c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f1570y = charSequence;
    }

    public void setSubtitleTextColor(@NonNull ColorStateList colorStateList) {
        this.f1531A = colorStateList;
        TextView textView = this.f1548c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1547b == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f1547b = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f1547b.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.f1557l;
                if (i != 0) {
                    this.f1547b.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.f1571z;
                if (colorStateList != null) {
                    this.f1547b.setTextColor(colorStateList);
                }
            }
            if (!m1004p(this.f1547b)) {
                m992c(this.f1547b, true);
            }
        } else {
            TextView textView = this.f1547b;
            if (textView != null && m1004p(textView)) {
                removeView(this.f1547b);
                this.f1535E.remove(this.f1547b);
            }
        }
        TextView textView2 = this.f1547b;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f1569x = charSequence;
    }

    public void setTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.f1571z = colorStateList;
        TextView textView = this.f1547b;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public Toolbar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1568w = 8388627;
        this.f1534D = new ArrayList<>();
        this.f1535E = new ArrayList<>();
        this.f1536F = new int[2];
        this.f1538H = new C0310a();
        this.f1545O = new C0311b();
        Context context2 = getContext();
        int[] iArr = C0131R.styleable.Toolbar;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context2, attributeSet, iArr, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
        this.f1557l = obtainStyledAttributes.getResourceId(C0131R.styleable.Toolbar_titleTextAppearance, 0);
        this.f1558m = obtainStyledAttributes.getResourceId(C0131R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.f1568w = obtainStyledAttributes.getInteger(C0131R.styleable.Toolbar_android_gravity, this.f1568w);
        this.f1559n = obtainStyledAttributes.getInteger(C0131R.styleable.Toolbar_buttonGravity, 48);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(C0131R.styleable.Toolbar_titleMargin, 0);
        int i2 = C0131R.styleable.Toolbar_titleMargins;
        dimensionPixelOffset = obtainStyledAttributes.hasValue(i2) ? obtainStyledAttributes.getDimensionPixelOffset(i2, dimensionPixelOffset) : dimensionPixelOffset;
        this.f1564s = dimensionPixelOffset;
        this.f1563r = dimensionPixelOffset;
        this.f1562q = dimensionPixelOffset;
        this.f1561p = dimensionPixelOffset;
        int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(C0131R.styleable.Toolbar_titleMarginStart, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.f1561p = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = obtainStyledAttributes.getDimensionPixelOffset(C0131R.styleable.Toolbar_titleMarginEnd, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.f1562q = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = obtainStyledAttributes.getDimensionPixelOffset(C0131R.styleable.Toolbar_titleMarginTop, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.f1563r = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = obtainStyledAttributes.getDimensionPixelOffset(C0131R.styleable.Toolbar_titleMarginBottom, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.f1564s = dimensionPixelOffset5;
        }
        this.f1560o = obtainStyledAttributes.getDimensionPixelSize(C0131R.styleable.Toolbar_maxButtonHeight, -1);
        int dimensionPixelOffset6 = obtainStyledAttributes.getDimensionPixelOffset(C0131R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = obtainStyledAttributes.getDimensionPixelOffset(C0131R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0131R.styleable.Toolbar_contentInsetLeft, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(C0131R.styleable.Toolbar_contentInsetRight, 0);
        m993e();
        this.f1565t.mo3067e(dimensionPixelSize, dimensionPixelSize2);
        if (!(dimensionPixelOffset6 == Integer.MIN_VALUE && dimensionPixelOffset7 == Integer.MIN_VALUE)) {
            this.f1565t.mo3069g(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.f1566u = obtainStyledAttributes.getDimensionPixelOffset(C0131R.styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.f1567v = obtainStyledAttributes.getDimensionPixelOffset(C0131R.styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f1551f = obtainStyledAttributes.getDrawable(C0131R.styleable.Toolbar_collapseIcon);
        this.f1552g = obtainStyledAttributes.getText(C0131R.styleable.Toolbar_collapseContentDescription);
        CharSequence text = obtainStyledAttributes.getText(C0131R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = obtainStyledAttributes.getText(C0131R.styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.f1555j = getContext();
        setPopupTheme(obtainStyledAttributes.getResourceId(C0131R.styleable.Toolbar_popupTheme, 0));
        Drawable drawable = obtainStyledAttributes.getDrawable(C0131R.styleable.Toolbar_navigationIcon);
        if (drawable != null) {
            setNavigationIcon(drawable);
        }
        CharSequence text3 = obtainStyledAttributes.getText(C0131R.styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(C0131R.styleable.Toolbar_logo);
        if (drawable2 != null) {
            setLogo(drawable2);
        }
        CharSequence text4 = obtainStyledAttributes.getText(C0131R.styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        int i3 = C0131R.styleable.Toolbar_titleTextColor;
        if (obtainStyledAttributes.hasValue(i3)) {
            setTitleTextColor(obtainStyledAttributes.getColorStateList(i3));
        }
        int i4 = C0131R.styleable.Toolbar_subtitleTextColor;
        if (obtainStyledAttributes.hasValue(i4)) {
            setSubtitleTextColor(obtainStyledAttributes.getColorStateList(i4));
        }
        int i5 = C0131R.styleable.Toolbar_menu;
        if (obtainStyledAttributes.hasValue(i5)) {
            inflateMenu(obtainStyledAttributes.getResourceId(i5, 0));
        }
        obtainStyledAttributes.recycle();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ActionBar.LayoutParams) {
            return new LayoutParams((ActionBar.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }
}
