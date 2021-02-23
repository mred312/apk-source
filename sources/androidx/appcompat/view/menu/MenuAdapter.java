package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuAdapter extends BaseAdapter {

    /* renamed from: a */
    MenuBuilder f904a;

    /* renamed from: b */
    private int f905b = -1;

    /* renamed from: c */
    private boolean f906c;

    /* renamed from: d */
    private final boolean f907d;

    /* renamed from: e */
    private final LayoutInflater f908e;

    /* renamed from: f */
    private final int f909f;

    public MenuAdapter(MenuBuilder menuBuilder, LayoutInflater layoutInflater, boolean z, int i) {
        this.f907d = z;
        this.f908e = layoutInflater;
        this.f904a = menuBuilder;
        this.f909f = i;
        mo1624a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1624a() {
        MenuItemImpl expandedItem = this.f904a.getExpandedItem();
        if (expandedItem != null) {
            ArrayList<MenuItemImpl> nonActionItems = this.f904a.getNonActionItems();
            int size = nonActionItems.size();
            for (int i = 0; i < size; i++) {
                if (nonActionItems.get(i) == expandedItem) {
                    this.f905b = i;
                    return;
                }
            }
        }
        this.f905b = -1;
    }

    public MenuBuilder getAdapterMenu() {
        return this.f904a;
    }

    public int getCount() {
        ArrayList<MenuItemImpl> nonActionItems = this.f907d ? this.f904a.getNonActionItems() : this.f904a.getVisibleItems();
        if (this.f905b < 0) {
            return nonActionItems.size();
        }
        return nonActionItems.size() - 1;
    }

    public boolean getForceShowIcon() {
        return this.f906c;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f908e.inflate(this.f909f, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f904a.isGroupDividerEnabled() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        MenuView.ItemView itemView = (MenuView.ItemView) view;
        if (this.f906c) {
            listMenuItemView.setForceShowIcon(true);
        }
        itemView.initialize(getItem(i), 0);
        return view;
    }

    public void notifyDataSetChanged() {
        mo1624a();
        super.notifyDataSetChanged();
    }

    public void setForceShowIcon(boolean z) {
        this.f906c = z;
    }

    public MenuItemImpl getItem(int i) {
        ArrayList<MenuItemImpl> nonActionItems = this.f907d ? this.f904a.getNonActionItems() : this.f904a.getVisibleItems();
        int i2 = this.f905b;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return nonActionItems.get(i);
    }
}
