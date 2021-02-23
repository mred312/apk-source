package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;

/* renamed from: androidx.appcompat.view.menu.a */
/* compiled from: BaseMenuWrapper */
abstract class C0226a {

    /* renamed from: a */
    final Context f995a;

    /* renamed from: b */
    private SimpleArrayMap<SupportMenuItem, MenuItem> f996b;

    /* renamed from: c */
    private SimpleArrayMap<SupportSubMenu, SubMenu> f997c;

    C0226a(Context context) {
        this.f995a = context;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final MenuItem mo1889a(MenuItem menuItem) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return menuItem;
        }
        SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
        if (this.f996b == null) {
            this.f996b = new SimpleArrayMap<>();
        }
        MenuItem menuItem2 = this.f996b.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItemWrapperICS menuItemWrapperICS = new MenuItemWrapperICS(this.f995a, supportMenuItem);
        this.f996b.put(supportMenuItem, menuItemWrapperICS);
        return menuItemWrapperICS;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final SubMenu mo1890b(SubMenu subMenu) {
        if (!(subMenu instanceof SupportSubMenu)) {
            return subMenu;
        }
        SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
        if (this.f997c == null) {
            this.f997c = new SimpleArrayMap<>();
        }
        SubMenu subMenu2 = this.f997c.get(supportSubMenu);
        if (subMenu2 != null) {
            return subMenu2;
        }
        C0232e eVar = new C0232e(this.f995a, supportSubMenu);
        this.f997c.put(supportSubMenu, eVar);
        return eVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo1891c() {
        SimpleArrayMap<SupportMenuItem, MenuItem> simpleArrayMap = this.f996b;
        if (simpleArrayMap != null) {
            simpleArrayMap.clear();
        }
        SimpleArrayMap<SupportSubMenu, SubMenu> simpleArrayMap2 = this.f997c;
        if (simpleArrayMap2 != null) {
            simpleArrayMap2.clear();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo1892d(int i) {
        if (this.f996b != null) {
            int i2 = 0;
            while (i2 < this.f996b.size()) {
                if (this.f996b.keyAt(i2).getGroupId() == i) {
                    this.f996b.removeAt(i2);
                    i2--;
                }
                i2++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final void mo1893e(int i) {
        if (this.f996b != null) {
            for (int i2 = 0; i2 < this.f996b.size(); i2++) {
                if (this.f996b.keyAt(i2).getItemId() == i) {
                    this.f996b.removeAt(i2);
                    return;
                }
            }
        }
    }
}
