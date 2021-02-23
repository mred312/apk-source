package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import java.lang.reflect.Method;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuItemWrapperICS extends C0226a implements MenuItem {

    /* renamed from: d */
    private final SupportMenuItem f969d;

    /* renamed from: e */
    private Method f970e;

    /* renamed from: androidx.appcompat.view.menu.MenuItemWrapperICS$a */
    private class C0220a extends ActionProvider {

        /* renamed from: d */
        final android.view.ActionProvider f971d;

        C0220a(Context context, android.view.ActionProvider actionProvider) {
            super(context);
            this.f971d = actionProvider;
        }

        public boolean hasSubMenu() {
            return this.f971d.hasSubMenu();
        }

        public View onCreateActionView() {
            return this.f971d.onCreateActionView();
        }

        public boolean onPerformDefaultAction() {
            return this.f971d.onPerformDefaultAction();
        }

        public void onPrepareSubMenu(SubMenu subMenu) {
            this.f971d.onPrepareSubMenu(MenuItemWrapperICS.this.mo1890b(subMenu));
        }
    }

    @RequiresApi(16)
    /* renamed from: androidx.appcompat.view.menu.MenuItemWrapperICS$b */
    private class C0221b extends C0220a implements ActionProvider.VisibilityListener {

        /* renamed from: f */
        private ActionProvider.VisibilityListener f973f;

        C0221b(MenuItemWrapperICS menuItemWrapperICS, Context context, android.view.ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        public boolean isVisible() {
            return this.f971d.isVisible();
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            ActionProvider.VisibilityListener visibilityListener = this.f973f;
            if (visibilityListener != null) {
                visibilityListener.onActionProviderVisibilityChanged(z);
            }
        }

        public View onCreateActionView(MenuItem menuItem) {
            return this.f971d.onCreateActionView(menuItem);
        }

        public boolean overridesItemVisibility() {
            return this.f971d.overridesItemVisibility();
        }

        public void refreshVisibility() {
            this.f971d.refreshVisibility();
        }

        public void setVisibilityListener(ActionProvider.VisibilityListener visibilityListener) {
            this.f973f = visibilityListener;
            this.f971d.setVisibilityListener(visibilityListener != null ? this : null);
        }
    }

    /* renamed from: androidx.appcompat.view.menu.MenuItemWrapperICS$c */
    static class C0222c extends FrameLayout implements CollapsibleActionView {

        /* renamed from: a */
        final android.view.CollapsibleActionView f974a;

        C0222c(View view) {
            super(view.getContext());
            this.f974a = (android.view.CollapsibleActionView) view;
            addView(view);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public View mo1835a() {
            return (View) this.f974a;
        }

        public void onActionViewCollapsed() {
            this.f974a.onActionViewCollapsed();
        }

        public void onActionViewExpanded() {
            this.f974a.onActionViewExpanded();
        }
    }

    /* renamed from: androidx.appcompat.view.menu.MenuItemWrapperICS$d */
    private class C0223d implements MenuItem.OnActionExpandListener {

        /* renamed from: a */
        private final MenuItem.OnActionExpandListener f975a;

        C0223d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f975a = onActionExpandListener;
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f975a.onMenuItemActionCollapse(MenuItemWrapperICS.this.mo1889a(menuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f975a.onMenuItemActionExpand(MenuItemWrapperICS.this.mo1889a(menuItem));
        }
    }

    /* renamed from: androidx.appcompat.view.menu.MenuItemWrapperICS$e */
    private class C0224e implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a */
        private final MenuItem.OnMenuItemClickListener f977a;

        C0224e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f977a = onMenuItemClickListener;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f977a.onMenuItemClick(MenuItemWrapperICS.this.mo1889a(menuItem));
        }
    }

    public MenuItemWrapperICS(Context context, SupportMenuItem supportMenuItem) {
        super(context);
        if (supportMenuItem != null) {
            this.f969d = supportMenuItem;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public boolean collapseActionView() {
        return this.f969d.collapseActionView();
    }

    public boolean expandActionView() {
        return this.f969d.expandActionView();
    }

    public android.view.ActionProvider getActionProvider() {
        androidx.core.view.ActionProvider supportActionProvider = this.f969d.getSupportActionProvider();
        if (supportActionProvider instanceof C0220a) {
            return ((C0220a) supportActionProvider).f971d;
        }
        return null;
    }

    public View getActionView() {
        View actionView = this.f969d.getActionView();
        return actionView instanceof C0222c ? ((C0222c) actionView).mo1835a() : actionView;
    }

    public int getAlphabeticModifiers() {
        return this.f969d.getAlphabeticModifiers();
    }

    public char getAlphabeticShortcut() {
        return this.f969d.getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return this.f969d.getContentDescription();
    }

    public int getGroupId() {
        return this.f969d.getGroupId();
    }

    public Drawable getIcon() {
        return this.f969d.getIcon();
    }

    public ColorStateList getIconTintList() {
        return this.f969d.getIconTintList();
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f969d.getIconTintMode();
    }

    public Intent getIntent() {
        return this.f969d.getIntent();
    }

    public int getItemId() {
        return this.f969d.getItemId();
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f969d.getMenuInfo();
    }

    public int getNumericModifiers() {
        return this.f969d.getNumericModifiers();
    }

    public char getNumericShortcut() {
        return this.f969d.getNumericShortcut();
    }

    public int getOrder() {
        return this.f969d.getOrder();
    }

    public SubMenu getSubMenu() {
        return mo1890b(this.f969d.getSubMenu());
    }

    public CharSequence getTitle() {
        return this.f969d.getTitle();
    }

    public CharSequence getTitleCondensed() {
        return this.f969d.getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return this.f969d.getTooltipText();
    }

    public boolean hasSubMenu() {
        return this.f969d.hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return this.f969d.isActionViewExpanded();
    }

    public boolean isCheckable() {
        return this.f969d.isCheckable();
    }

    public boolean isChecked() {
        return this.f969d.isChecked();
    }

    public boolean isEnabled() {
        return this.f969d.isEnabled();
    }

    public boolean isVisible() {
        return this.f969d.isVisible();
    }

    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        androidx.core.view.ActionProvider actionProvider2;
        if (Build.VERSION.SDK_INT >= 16) {
            actionProvider2 = new C0221b(this, this.f995a, actionProvider);
        } else {
            actionProvider2 = new C0220a(this.f995a, actionProvider);
        }
        SupportMenuItem supportMenuItem = this.f969d;
        if (actionProvider == null) {
            actionProvider2 = null;
        }
        supportMenuItem.setSupportActionProvider(actionProvider2);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof android.view.CollapsibleActionView) {
            view = new C0222c(view);
        }
        this.f969d.setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f969d.setAlphabeticShortcut(c);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f969d.setCheckable(z);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f969d.setChecked(z);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f969d.setContentDescription(charSequence);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f969d.setEnabled(z);
        return this;
    }

    public void setExclusiveCheckable(boolean z) {
        try {
            if (this.f970e == null) {
                this.f970e = this.f969d.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f970e.invoke(this.f969d, new Object[]{Boolean.valueOf(z)});
        } catch (Exception e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f969d.setIcon(drawable);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f969d.setIconTintList(colorStateList);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f969d.setIconTintMode(mode);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f969d.setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f969d.setNumericShortcut(c);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f969d.setOnActionExpandListener(onActionExpandListener != null ? new C0223d(onActionExpandListener) : null);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f969d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new C0224e(onMenuItemClickListener) : null);
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f969d.setShortcut(c, c2);
        return this;
    }

    public void setShowAsAction(int i) {
        this.f969d.setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        this.f969d.setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f969d.setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f969d.setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f969d.setTooltipText(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        return this.f969d.setVisible(z);
    }

    public MenuItem setAlphabeticShortcut(char c, int i) {
        this.f969d.setAlphabeticShortcut(c, i);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f969d.setIcon(i);
        return this;
    }

    public MenuItem setNumericShortcut(char c, int i) {
        this.f969d.setNumericShortcut(c, i);
        return this;
    }

    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f969d.setShortcut(c, c2, i, i2);
        return this;
    }

    public MenuItem setTitle(int i) {
        this.f969d.setTitle(i);
        return this;
    }

    public MenuItem setActionView(int i) {
        this.f969d.setActionView(i);
        View actionView = this.f969d.getActionView();
        if (actionView instanceof android.view.CollapsibleActionView) {
            this.f969d.setActionView((View) new C0222c(actionView));
        }
        return this;
    }
}
