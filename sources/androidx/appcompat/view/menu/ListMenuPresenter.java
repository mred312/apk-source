package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0131R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ListMenuPresenter implements MenuPresenter, AdapterView.OnItemClickListener {
    public static final String VIEWS_TAG = "android:menu:list";

    /* renamed from: a */
    Context f892a;

    /* renamed from: b */
    LayoutInflater f893b;

    /* renamed from: c */
    MenuBuilder f894c;

    /* renamed from: d */
    ExpandedMenuView f895d;

    /* renamed from: e */
    int f896e;

    /* renamed from: f */
    int f897f;

    /* renamed from: g */
    int f898g;

    /* renamed from: h */
    private MenuPresenter.Callback f899h;

    /* renamed from: i */
    C0218a f900i;

    /* renamed from: j */
    private int f901j;

    /* renamed from: androidx.appcompat.view.menu.ListMenuPresenter$a */
    private class C0218a extends BaseAdapter {

        /* renamed from: a */
        private int f902a = -1;

        public C0218a() {
            mo1617a();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo1617a() {
            MenuItemImpl expandedItem = ListMenuPresenter.this.f894c.getExpandedItem();
            if (expandedItem != null) {
                ArrayList<MenuItemImpl> nonActionItems = ListMenuPresenter.this.f894c.getNonActionItems();
                int size = nonActionItems.size();
                for (int i = 0; i < size; i++) {
                    if (nonActionItems.get(i) == expandedItem) {
                        this.f902a = i;
                        return;
                    }
                }
            }
            this.f902a = -1;
        }

        /* renamed from: b */
        public MenuItemImpl getItem(int i) {
            ArrayList<MenuItemImpl> nonActionItems = ListMenuPresenter.this.f894c.getNonActionItems();
            int i2 = i + ListMenuPresenter.this.f896e;
            int i3 = this.f902a;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return nonActionItems.get(i2);
        }

        public int getCount() {
            int size = ListMenuPresenter.this.f894c.getNonActionItems().size() - ListMenuPresenter.this.f896e;
            return this.f902a < 0 ? size : size - 1;
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                ListMenuPresenter listMenuPresenter = ListMenuPresenter.this;
                view = listMenuPresenter.f893b.inflate(listMenuPresenter.f898g, viewGroup, false);
            }
            ((MenuView.ItemView) view).initialize(getItem(i), 0);
            return view;
        }

        public void notifyDataSetChanged() {
            mo1617a();
            super.notifyDataSetChanged();
        }
    }

    public ListMenuPresenter(Context context, int i) {
        this(i, 0);
        this.f892a = context;
        this.f893b = LayoutInflater.from(context);
    }

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public ListAdapter getAdapter() {
        if (this.f900i == null) {
            this.f900i = new C0218a();
        }
        return this.f900i;
    }

    public int getId() {
        return this.f901j;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.f895d == null) {
            this.f895d = (ExpandedMenuView) this.f893b.inflate(C0131R.layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f900i == null) {
                this.f900i = new C0218a();
            }
            this.f895d.setAdapter(this.f900i);
            this.f895d.setOnItemClickListener(this);
        }
        return this.f895d;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        if (this.f897f != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f897f);
            this.f892a = contextThemeWrapper;
            this.f893b = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f892a != null) {
            this.f892a = context;
            if (this.f893b == null) {
                this.f893b = LayoutInflater.from(context);
            }
        }
        this.f894c = menuBuilder;
        C0218a aVar = this.f900i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        MenuPresenter.Callback callback = this.f899h;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f894c.performItemAction(this.f900i.getItem(i), this, 0);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        restoreHierarchyState((Bundle) parcelable);
    }

    public Parcelable onSaveInstanceState() {
        if (this.f895d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        saveHierarchyState(bundle);
        return bundle;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        new C0227b(subMenuBuilder).mo1895b((IBinder) null);
        MenuPresenter.Callback callback = this.f899h;
        if (callback == null) {
            return true;
        }
        callback.onOpenSubMenu(subMenuBuilder);
        return true;
    }

    public void restoreHierarchyState(Bundle bundle) {
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(VIEWS_TAG);
        if (sparseParcelableArray != null) {
            this.f895d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public void saveHierarchyState(Bundle bundle) {
        SparseArray sparseArray = new SparseArray();
        ExpandedMenuView expandedMenuView = this.f895d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray(VIEWS_TAG, sparseArray);
    }

    public void setCallback(MenuPresenter.Callback callback) {
        this.f899h = callback;
    }

    public void setId(int i) {
        this.f901j = i;
    }

    public void setItemIndexOffset(int i) {
        this.f896e = i;
        if (this.f895d != null) {
            updateMenuView(false);
        }
    }

    public void updateMenuView(boolean z) {
        C0218a aVar = this.f900i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public ListMenuPresenter(int i, int i2) {
        this.f898g = i;
        this.f897f = i2;
    }
}
