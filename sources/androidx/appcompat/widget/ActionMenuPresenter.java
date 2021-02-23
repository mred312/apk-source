package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.C0131R;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ActionProvider;
import androidx.core.view.GravityCompat;
import java.util.ArrayList;

class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {

    /* renamed from: e */
    C0242d f1090e;

    /* renamed from: f */
    private Drawable f1091f;

    /* renamed from: g */
    private boolean f1092g;

    /* renamed from: h */
    private boolean f1093h;

    /* renamed from: i */
    private boolean f1094i;

    /* renamed from: j */
    private int f1095j;

    /* renamed from: k */
    private int f1096k;

    /* renamed from: l */
    private int f1097l;

    /* renamed from: m */
    private boolean f1098m;

    /* renamed from: n */
    private boolean f1099n;

    /* renamed from: o */
    private boolean f1100o;

    /* renamed from: p */
    private boolean f1101p;

    /* renamed from: q */
    private int f1102q;

    /* renamed from: r */
    private final SparseBooleanArray f1103r = new SparseBooleanArray();

    /* renamed from: s */
    C0244e f1104s;

    /* renamed from: t */
    C0239a f1105t;

    /* renamed from: u */
    C0241c f1106u;

    /* renamed from: v */
    private C0240b f1107v;

    /* renamed from: w */
    final C0245f f1108w = new C0245f();

    /* renamed from: x */
    int f1109x;

    @SuppressLint({"BanParcelableUsage"})
    private static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0238a();

        /* renamed from: a */
        public int f1110a;

        /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$SavedState$a */
        class C0238a implements Parcelable.Creator<SavedState> {
            C0238a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1110a);
        }

        SavedState(Parcel parcel) {
            this.f1110a = parcel.readInt();
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$a */
    private class C0239a extends MenuPopupHelper {
        public C0239a(Context context, SubMenuBuilder subMenuBuilder, View view) {
            super(context, subMenuBuilder, view, false, C0131R.attr.actionOverflowMenuStyle);
            if (!((MenuItemImpl) subMenuBuilder.getItem()).isActionButton()) {
                View view2 = ActionMenuPresenter.this.f1090e;
                setAnchorView(view2 == null ? (View) ActionMenuPresenter.this.mMenuView : view2);
            }
            setPresenterCallback(ActionMenuPresenter.this.f1108w);
        }

        /* access modifiers changed from: protected */
        public void onDismiss() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.f1105t = null;
            actionMenuPresenter.f1109x = 0;
            super.onDismiss();
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$b */
    private class C0240b extends ActionMenuItemView.PopupCallback {
        C0240b() {
        }

        public ShowableListMenu getPopup() {
            C0239a aVar = ActionMenuPresenter.this.f1105t;
            if (aVar != null) {
                return aVar.getPopup();
            }
            return null;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$c */
    private class C0241c implements Runnable {

        /* renamed from: a */
        private C0244e f1113a;

        public C0241c(C0244e eVar) {
            this.f1113a = eVar;
        }

        public void run() {
            if (ActionMenuPresenter.this.mMenu != null) {
                ActionMenuPresenter.this.mMenu.changeMenuMode();
            }
            View view = (View) ActionMenuPresenter.this.mMenuView;
            if (!(view == null || view.getWindowToken() == null || !this.f1113a.tryShow())) {
                ActionMenuPresenter.this.f1104s = this.f1113a;
            }
            ActionMenuPresenter.this.f1106u = null;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$d */
    private class C0242d extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {

        /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$d$a */
        class C0243a extends ForwardingListener {
            C0243a(View view, ActionMenuPresenter actionMenuPresenter) {
                super(view);
            }

            public ShowableListMenu getPopup() {
                C0244e eVar = ActionMenuPresenter.this.f1104s;
                if (eVar == null) {
                    return null;
                }
                return eVar.getPopup();
            }

            public boolean onForwardingStarted() {
                ActionMenuPresenter.this.mo2050u();
                return true;
            }

            public boolean onForwardingStopped() {
                ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                if (actionMenuPresenter.f1106u != null) {
                    return false;
                }
                actionMenuPresenter.mo2039k();
                return true;
            }
        }

        public C0242d(Context context) {
            super(context, (AttributeSet) null, C0131R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            TooltipCompat.setTooltipText(this, getContentDescription());
            setOnTouchListener(new C0243a(this, ActionMenuPresenter.this));
        }

        public boolean needsDividerAfter() {
            return false;
        }

        public boolean needsDividerBefore() {
            return false;
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.mo2050u();
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                DrawableCompat.setHotspotBounds(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$e */
    private class C0244e extends MenuPopupHelper {
        public C0244e(Context context, MenuBuilder menuBuilder, View view, boolean z) {
            super(context, menuBuilder, view, z, C0131R.attr.actionOverflowMenuStyle);
            setGravity(GravityCompat.END);
            setPresenterCallback(ActionMenuPresenter.this.f1108w);
        }

        /* access modifiers changed from: protected */
        public void onDismiss() {
            if (ActionMenuPresenter.this.mMenu != null) {
                ActionMenuPresenter.this.mMenu.close();
            }
            ActionMenuPresenter.this.f1104s = null;
            super.onDismiss();
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$f */
    private class C0245f implements MenuPresenter.Callback {
        C0245f() {
        }

        public void onCloseMenu(@NonNull MenuBuilder menuBuilder, boolean z) {
            if (menuBuilder instanceof SubMenuBuilder) {
                menuBuilder.getRootMenu().close(false);
            }
            MenuPresenter.Callback callback = ActionMenuPresenter.this.getCallback();
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, z);
            }
        }

        public boolean onOpenSubMenu(@NonNull MenuBuilder menuBuilder) {
            if (menuBuilder == ActionMenuPresenter.this.mMenu) {
                return false;
            }
            ActionMenuPresenter.this.f1109x = ((SubMenuBuilder) menuBuilder).getItem().getItemId();
            MenuPresenter.Callback callback = ActionMenuPresenter.this.getCallback();
            if (callback != null) {
                return callback.onOpenSubMenu(menuBuilder);
            }
            return false;
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, C0131R.layout.abc_action_menu_layout, C0131R.layout.abc_action_menu_item_layout);
    }

    /* renamed from: i */
    private View m750i(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof MenuView.ItemView) && ((MenuView.ItemView) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public void bindItemView(MenuItemImpl menuItemImpl, MenuView.ItemView itemView) {
        itemView.initialize(menuItemImpl, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) itemView;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.mMenuView);
        if (this.f1107v == null) {
            this.f1107v = new C0240b();
        }
        actionMenuItemView.setPopupCallback(this.f1107v);
    }

    public boolean filterLeftoverView(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.f1090e) {
            return false;
        }
        return super.filterLeftoverView(viewGroup, i);
    }

    public boolean flagActionItems() {
        int i;
        ArrayList<MenuItemImpl> arrayList;
        int i2;
        int i3;
        int i4;
        ActionMenuPresenter actionMenuPresenter = this;
        MenuBuilder menuBuilder = actionMenuPresenter.mMenu;
        View view = null;
        int i5 = 0;
        if (menuBuilder != null) {
            arrayList = menuBuilder.getVisibleItems();
            i = arrayList.size();
        } else {
            arrayList = null;
            i = 0;
        }
        int i6 = actionMenuPresenter.f1097l;
        int i7 = actionMenuPresenter.f1096k;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.mMenuView;
        boolean z = false;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            MenuItemImpl menuItemImpl = arrayList.get(i10);
            if (menuItemImpl.requiresActionButton()) {
                i8++;
            } else if (menuItemImpl.requestsActionButton()) {
                i9++;
            } else {
                z = true;
            }
            if (actionMenuPresenter.f1101p && menuItemImpl.isActionViewExpanded()) {
                i6 = 0;
            }
        }
        if (actionMenuPresenter.f1093h && (z || i9 + i8 > i6)) {
            i6--;
        }
        int i11 = i6 - i8;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.f1103r;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.f1099n) {
            int i12 = actionMenuPresenter.f1102q;
            i2 = i7 / i12;
            i3 = i12 + ((i7 % i12) / i2);
        } else {
            i3 = 0;
            i2 = 0;
        }
        int i13 = 0;
        int i14 = 0;
        while (i13 < i) {
            MenuItemImpl menuItemImpl2 = arrayList.get(i13);
            if (menuItemImpl2.requiresActionButton()) {
                View itemView = actionMenuPresenter.getItemView(menuItemImpl2, view, viewGroup);
                if (actionMenuPresenter.f1099n) {
                    i2 -= ActionMenuView.m766r(itemView, i3, i2, makeMeasureSpec, i5);
                } else {
                    itemView.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = itemView.getMeasuredWidth();
                i7 -= measuredWidth;
                if (i14 == 0) {
                    i14 = measuredWidth;
                }
                int groupId = menuItemImpl2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                menuItemImpl2.setIsActionButton(true);
                i4 = i;
            } else if (menuItemImpl2.requestsActionButton()) {
                int groupId2 = menuItemImpl2.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId2);
                boolean z3 = (i11 > 0 || z2) && i7 > 0 && (!actionMenuPresenter.f1099n || i2 > 0);
                boolean z4 = z3;
                i4 = i;
                if (z3) {
                    View itemView2 = actionMenuPresenter.getItemView(menuItemImpl2, (View) null, viewGroup);
                    if (actionMenuPresenter.f1099n) {
                        int r = ActionMenuView.m766r(itemView2, i3, i2, makeMeasureSpec, 0);
                        i2 -= r;
                        if (r == 0) {
                            z4 = false;
                        }
                    } else {
                        itemView2.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z5 = z4;
                    int measuredWidth2 = itemView2.getMeasuredWidth();
                    i7 -= measuredWidth2;
                    if (i14 == 0) {
                        i14 = measuredWidth2;
                    }
                    z3 = z5 & (!actionMenuPresenter.f1099n ? i7 + i14 > 0 : i7 >= 0);
                }
                if (z3 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z2) {
                    sparseBooleanArray.put(groupId2, false);
                    int i15 = 0;
                    while (i15 < i13) {
                        MenuItemImpl menuItemImpl3 = arrayList.get(i15);
                        if (menuItemImpl3.getGroupId() == groupId2) {
                            if (menuItemImpl3.isActionButton()) {
                                i11++;
                            }
                            menuItemImpl3.setIsActionButton(false);
                        }
                        i15++;
                    }
                }
                if (z3) {
                    i11--;
                }
                menuItemImpl2.setIsActionButton(z3);
            } else {
                i4 = i;
                menuItemImpl2.setIsActionButton(false);
                i13++;
                view = null;
                actionMenuPresenter = this;
                i = i4;
                i5 = 0;
            }
            i13++;
            view = null;
            actionMenuPresenter = this;
            i = i4;
            i5 = 0;
        }
        return true;
    }

    public View getItemView(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.hasCollapsibleActionView()) {
            actionView = super.getItemView(menuItemImpl, view, viewGroup);
        }
        actionView.setVisibility(menuItemImpl.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        MenuView menuView = this.mMenuView;
        MenuView menuView2 = super.getMenuView(viewGroup);
        if (menuView != menuView2) {
            ((ActionMenuView) menuView2).setPresenter(this);
        }
        return menuView2;
    }

    /* renamed from: h */
    public boolean mo2037h() {
        return mo2039k() | mo2040l();
    }

    public void initForMenu(@NonNull Context context, @Nullable MenuBuilder menuBuilder) {
        super.initForMenu(context, menuBuilder);
        Resources resources = context.getResources();
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(context);
        if (!this.f1094i) {
            this.f1093h = actionBarPolicy.showsOverflowMenuButton();
        }
        if (!this.f1100o) {
            this.f1095j = actionBarPolicy.getEmbeddedMenuWidthLimit();
        }
        if (!this.f1098m) {
            this.f1097l = actionBarPolicy.getMaxActionButtons();
        }
        int i = this.f1095j;
        if (this.f1093h) {
            if (this.f1090e == null) {
                C0242d dVar = new C0242d(this.mSystemContext);
                this.f1090e = dVar;
                if (this.f1092g) {
                    dVar.setImageDrawable(this.f1091f);
                    this.f1091f = null;
                    this.f1092g = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f1090e.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.f1090e.getMeasuredWidth();
        } else {
            this.f1090e = null;
        }
        this.f1096k = i;
        this.f1102q = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    /* renamed from: j */
    public Drawable mo2038j() {
        C0242d dVar = this.f1090e;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.f1092g) {
            return this.f1091f;
        }
        return null;
    }

    /* renamed from: k */
    public boolean mo2039k() {
        MenuView menuView;
        C0241c cVar = this.f1106u;
        if (cVar == null || (menuView = this.mMenuView) == null) {
            C0244e eVar = this.f1104s;
            if (eVar == null) {
                return false;
            }
            eVar.dismiss();
            return true;
        }
        ((View) menuView).removeCallbacks(cVar);
        this.f1106u = null;
        return true;
    }

    /* renamed from: l */
    public boolean mo2040l() {
        C0239a aVar = this.f1105t;
        if (aVar == null) {
            return false;
        }
        aVar.dismiss();
        return true;
    }

    /* renamed from: m */
    public boolean mo2041m() {
        return this.f1106u != null || mo2042n();
    }

    /* renamed from: n */
    public boolean mo2042n() {
        C0244e eVar = this.f1104s;
        return eVar != null && eVar.isShowing();
    }

    /* renamed from: o */
    public boolean mo2043o() {
        return this.f1093h;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        mo2037h();
        super.onCloseMenu(menuBuilder, z);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        MenuItem findItem;
        if ((parcelable instanceof SavedState) && (i = ((SavedState) parcelable).f1110a) > 0 && (findItem = this.mMenu.findItem(i)) != null) {
            onSubMenuSelected((SubMenuBuilder) findItem.getSubMenu());
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.f1110a = this.f1109x;
        return savedState;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        boolean z = false;
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        while (subMenuBuilder2.getParentMenu() != this.mMenu) {
            subMenuBuilder2 = (SubMenuBuilder) subMenuBuilder2.getParentMenu();
        }
        View i = m750i(subMenuBuilder2.getItem());
        if (i == null) {
            return false;
        }
        this.f1109x = subMenuBuilder.getItem().getItemId();
        int size = subMenuBuilder.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            MenuItem item = subMenuBuilder.getItem(i2);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i2++;
        }
        C0239a aVar = new C0239a(this.mContext, subMenuBuilder, i);
        this.f1105t = aVar;
        aVar.setForceShowIcon(z);
        this.f1105t.show();
        super.onSubMenuSelected(subMenuBuilder);
        return true;
    }

    public void onSubUiVisibilityChanged(boolean z) {
        if (z) {
            super.onSubMenuSelected((SubMenuBuilder) null);
            return;
        }
        MenuBuilder menuBuilder = this.mMenu;
        if (menuBuilder != null) {
            menuBuilder.close(false);
        }
    }

    /* renamed from: p */
    public void mo2045p(Configuration configuration) {
        if (!this.f1098m) {
            this.f1097l = ActionBarPolicy.get(this.mContext).getMaxActionButtons();
        }
        MenuBuilder menuBuilder = this.mMenu;
        if (menuBuilder != null) {
            menuBuilder.onItemsChanged(true);
        }
    }

    /* renamed from: q */
    public void mo2046q(boolean z) {
        this.f1101p = z;
    }

    /* renamed from: r */
    public void mo2047r(ActionMenuView actionMenuView) {
        this.mMenuView = actionMenuView;
        actionMenuView.initialize(this.mMenu);
    }

    /* renamed from: s */
    public void mo2048s(Drawable drawable) {
        C0242d dVar = this.f1090e;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
            return;
        }
        this.f1092g = true;
        this.f1091f = drawable;
    }

    public boolean shouldIncludeItem(int i, MenuItemImpl menuItemImpl) {
        return menuItemImpl.isActionButton();
    }

    /* renamed from: t */
    public void mo2049t(boolean z) {
        this.f1093h = z;
        this.f1094i = true;
    }

    /* renamed from: u */
    public boolean mo2050u() {
        MenuBuilder menuBuilder;
        if (!this.f1093h || mo2042n() || (menuBuilder = this.mMenu) == null || this.mMenuView == null || this.f1106u != null || menuBuilder.getNonActionItems().isEmpty()) {
            return false;
        }
        C0241c cVar = new C0241c(new C0244e(this.mContext, this.mMenu, this.f1090e, true));
        this.f1106u = cVar;
        ((View) this.mMenuView).post(cVar);
        return true;
    }

    public void updateMenuView(boolean z) {
        MenuView menuView;
        super.updateMenuView(z);
        ((View) this.mMenuView).requestLayout();
        MenuBuilder menuBuilder = this.mMenu;
        boolean z2 = false;
        if (menuBuilder != null) {
            ArrayList<MenuItemImpl> actionItems = menuBuilder.getActionItems();
            int size = actionItems.size();
            for (int i = 0; i < size; i++) {
                ActionProvider supportActionProvider = actionItems.get(i).getSupportActionProvider();
                if (supportActionProvider != null) {
                    supportActionProvider.setSubUiVisibilityListener(this);
                }
            }
        }
        MenuBuilder menuBuilder2 = this.mMenu;
        ArrayList<MenuItemImpl> nonActionItems = menuBuilder2 != null ? menuBuilder2.getNonActionItems() : null;
        if (this.f1093h && nonActionItems != null) {
            int size2 = nonActionItems.size();
            if (size2 == 1) {
                z2 = !nonActionItems.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.f1090e == null) {
                this.f1090e = new C0242d(this.mSystemContext);
            }
            ViewGroup viewGroup = (ViewGroup) this.f1090e.getParent();
            if (viewGroup != this.mMenuView) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f1090e);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.mMenuView;
                actionMenuView.addView(this.f1090e, actionMenuView.generateOverflowButtonLayoutParams());
            }
        } else {
            C0242d dVar = this.f1090e;
            if (dVar != null && dVar.getParent() == (menuView = this.mMenuView)) {
                ((ViewGroup) menuView).removeView(this.f1090e);
            }
        }
        ((ActionMenuView) this.mMenuView).setOverflowReserved(this.f1093h);
    }
}
