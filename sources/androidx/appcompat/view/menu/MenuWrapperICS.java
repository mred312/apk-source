package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportMenu;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuWrapperICS extends C0226a implements Menu {

    /* renamed from: d */
    private final SupportMenu f992d;

    public MenuWrapperICS(Context context, SupportMenu supportMenu) {
        super(context);
        if (supportMenu != null) {
            this.f992d = supportMenu;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public MenuItem add(CharSequence charSequence) {
        return mo1889a(this.f992d.add(charSequence));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr;
        MenuItem[] menuItemArr3 = menuItemArr2 != null ? new MenuItem[menuItemArr2.length] : null;
        int addIntentOptions = this.f992d.addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr3);
        if (menuItemArr3 != null) {
            int length = menuItemArr3.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr2[i5] = mo1889a(menuItemArr3[i5]);
            }
        }
        return addIntentOptions;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return mo1890b(this.f992d.addSubMenu(charSequence));
    }

    public void clear() {
        mo1891c();
        this.f992d.clear();
    }

    public void close() {
        this.f992d.close();
    }

    public MenuItem findItem(int i) {
        return mo1889a(this.f992d.findItem(i));
    }

    public MenuItem getItem(int i) {
        return mo1889a(this.f992d.getItem(i));
    }

    public boolean hasVisibleItems() {
        return this.f992d.hasVisibleItems();
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return this.f992d.isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return this.f992d.performIdentifierAction(i, i2);
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return this.f992d.performShortcut(i, keyEvent, i2);
    }

    public void removeGroup(int i) {
        mo1892d(i);
        this.f992d.removeGroup(i);
    }

    public void removeItem(int i) {
        mo1893e(i);
        this.f992d.removeItem(i);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        this.f992d.setGroupCheckable(i, z, z2);
    }

    public void setGroupEnabled(int i, boolean z) {
        this.f992d.setGroupEnabled(i, z);
    }

    public void setGroupVisible(int i, boolean z) {
        this.f992d.setGroupVisible(i, z);
    }

    public void setQwertyMode(boolean z) {
        this.f992d.setQwertyMode(z);
    }

    public int size() {
        return this.f992d.size();
    }

    public MenuItem add(int i) {
        return mo1889a(this.f992d.add(i));
    }

    public SubMenu addSubMenu(int i) {
        return mo1890b(this.f992d.addSubMenu(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return mo1889a(this.f992d.add(i, i2, i3, charSequence));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return mo1890b(this.f992d.addSubMenu(i, i2, i3, charSequence));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return mo1889a(this.f992d.add(i, i2, i3, i4));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return mo1890b(this.f992d.addSubMenu(i, i2, i3, i4));
    }
}
