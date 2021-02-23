package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* renamed from: androidx.appcompat.view.menu.c */
/* compiled from: MenuPopup */
abstract class C0228c implements ShowableListMenu, MenuPresenter, AdapterView.OnItemClickListener {

    /* renamed from: a */
    private Rect f1002a;

    C0228c() {
    }

    /* renamed from: d */
    protected static int m705d(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        View view = null;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < count; i4++) {
            int itemViewType = listAdapter.getItemViewType(i4);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            if (viewGroup == null) {
                viewGroup = new FrameLayout(context);
            }
            view = listAdapter.getView(i4, view, viewGroup);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth > i2) {
                i2 = measuredWidth;
            }
        }
        return i2;
    }

    /* renamed from: m */
    protected static boolean m706m(MenuBuilder menuBuilder) {
        int size = menuBuilder.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menuBuilder.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: n */
    protected static MenuAdapter m707n(ListAdapter listAdapter) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            return (MenuAdapter) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return (MenuAdapter) listAdapter;
    }

    /* renamed from: a */
    public abstract void mo1577a(MenuBuilder menuBuilder);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo1578b() {
        return true;
    }

    /* renamed from: c */
    public Rect mo1899c() {
        return this.f1002a;
    }

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    /* renamed from: e */
    public abstract void mo1580e(View view);

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    /* renamed from: f */
    public void mo1900f(Rect rect) {
        this.f1002a = rect;
    }

    /* renamed from: g */
    public abstract void mo1581g(boolean z);

    public int getId() {
        return 0;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        throw new UnsupportedOperationException("MenuPopups manage their own views");
    }

    /* renamed from: h */
    public abstract void mo1583h(int i);

    /* renamed from: i */
    public abstract void mo1584i(int i);

    public void initForMenu(@NonNull Context context, @Nullable MenuBuilder menuBuilder) {
    }

    /* renamed from: j */
    public abstract void mo1586j(PopupWindow.OnDismissListener onDismissListener);

    /* renamed from: k */
    public abstract void mo1587k(boolean z);

    /* renamed from: l */
    public abstract void mo1588l(int i);

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        m707n(listAdapter).f904a.performItemAction((MenuItem) listAdapter.getItem(i), this, mo1578b() ? 0 : 4);
    }
}
