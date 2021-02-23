package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SubMenuBuilder extends MenuBuilder implements SubMenu {

    /* renamed from: B */
    private MenuBuilder f993B;

    /* renamed from: C */
    private MenuItemImpl f994C;

    public SubMenuBuilder(Context context, MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        super(context);
        this.f993B = menuBuilder;
        this.f994C = menuItemImpl;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo1645b(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        return super.mo1645b(menuBuilder, menuItem) || this.f993B.mo1645b(menuBuilder, menuItem);
    }

    public boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
        return this.f993B.collapseItemActionView(menuItemImpl);
    }

    public boolean expandItemActionView(MenuItemImpl menuItemImpl) {
        return this.f993B.expandItemActionView(menuItemImpl);
    }

    public String getActionViewStatesKey() {
        MenuItemImpl menuItemImpl = this.f994C;
        int itemId = menuItemImpl != null ? menuItemImpl.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.getActionViewStatesKey() + ":" + itemId;
    }

    public MenuItem getItem() {
        return this.f994C;
    }

    public Menu getParentMenu() {
        return this.f993B;
    }

    public MenuBuilder getRootMenu() {
        return this.f993B.getRootMenu();
    }

    public boolean isGroupDividerEnabled() {
        return this.f993B.isGroupDividerEnabled();
    }

    public boolean isQwertyMode() {
        return this.f993B.isQwertyMode();
    }

    public boolean isShortcutsVisible() {
        return this.f993B.isShortcutsVisible();
    }

    public void setCallback(MenuBuilder.Callback callback) {
        this.f993B.setCallback(callback);
    }

    public void setGroupDividerEnabled(boolean z) {
        this.f993B.setGroupDividerEnabled(z);
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.setHeaderIconInt(drawable);
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.setHeaderTitleInt(charSequence);
    }

    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.setHeaderViewInt(view);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f994C.setIcon(drawable);
        return this;
    }

    public void setQwertyMode(boolean z) {
        this.f993B.setQwertyMode(z);
    }

    public void setShortcutsVisible(boolean z) {
        this.f993B.setShortcutsVisible(z);
    }

    public SubMenu setHeaderIcon(int i) {
        return (SubMenu) super.setHeaderIconInt(i);
    }

    public SubMenu setHeaderTitle(int i) {
        return (SubMenu) super.setHeaderTitleInt(i);
    }

    public SubMenu setIcon(int i) {
        this.f994C.setIcon(i);
        return this;
    }
}
