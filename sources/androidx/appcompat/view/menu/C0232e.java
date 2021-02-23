package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportSubMenu;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* renamed from: androidx.appcompat.view.menu.e */
/* compiled from: SubMenuWrapperICS */
class C0232e extends MenuWrapperICS implements SubMenu {

    /* renamed from: e */
    private final SupportSubMenu f1026e;

    C0232e(Context context, SupportSubMenu supportSubMenu) {
        super(context, supportSubMenu);
        this.f1026e = supportSubMenu;
    }

    public void clearHeader() {
        this.f1026e.clearHeader();
    }

    public MenuItem getItem() {
        return mo1889a(this.f1026e.getItem());
    }

    public SubMenu setHeaderIcon(int i) {
        this.f1026e.setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        this.f1026e.setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        this.f1026e.setHeaderView(view);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.f1026e.setIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f1026e.setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f1026e.setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f1026e.setIcon(drawable);
        return this;
    }
}
